package cn.edu.whu.irlab.digsci.service;

import cn.edu.whu.irlab.digsci.vo.Validation;
import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author gcr19
 * @date 2019-10-11 10:45
 * @desc
 **/
public class Searcher implements Runnable {

    private List<Validation> queries;
    private File file;
    private IndexSearcher indexSearcher;
    private MultiFieldQueryParser multiFieldQueryParser;

    public Searcher(List<Validation> queries, File file, IndexSearcher indexSearcher, MultiFieldQueryParser multiFieldQueryParser) {
        this.queries = queries;
        this.file = file;
        this.indexSearcher = indexSearcher;
        this.multiFieldQueryParser=multiFieldQueryParser;
    }

    @Override
    public void run() {

        for (Validation v :
                queries) {
            String description_text = v.getDescription_text();
            String description_id = v.getDiscription_id();

            TopDocs topDocs = null;
            try {
                Query query = multiFieldQueryParser.parse(QueryParser.escape(description_text));
                topDocs = indexSearcher.search(query, 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //遍历查询结果
            for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
                Document doc = null;
                try {
                    doc = indexSearcher.doc(scoreDoc.doc);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String paper_id = doc.get("paper_id");
                String abstractp = doc.get("abstract");
                String title = doc.get("title");
                String similarity = String.valueOf(scoreDoc.score);
                String data = description_id + "\t" + description_text + "\t" + paper_id + "\t" + title + abstractp + "\t" + similarity + "\n";
                try {
                    FileUtils.write(file, data, "UTF-8", true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
