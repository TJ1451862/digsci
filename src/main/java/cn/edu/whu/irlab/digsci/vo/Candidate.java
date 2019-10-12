package cn.edu.whu.irlab.digsci.vo;

/**
 * @author gcr19
 * @date 2019-10-09 15:21
 * @desc
 **/
public class Candidate {

    private String paper_id;
    private String title;
    private String abstractp;
    private String journal;
    private String keywords;

    public Candidate(String paper_id, String title, String abstractp, String journal, String keywords) {
        this.paper_id = paper_id;
        this.title = title;
        this.abstractp = abstractp;
        this.journal = journal;
        this.keywords = keywords;
    }

    public String getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(String paper_id) {
        this.paper_id = paper_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstractp() {
        return abstractp;
    }

    public void setAbstractp(String abstractp) {
        this.abstractp = abstractp;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
