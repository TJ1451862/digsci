package cn.edu.whu.irlab.digsci.vo;

/**
 * @author gcr19
 * @date 2019-10-09 15:11
 * @desc
 **/
public class Validation {
    private String discription_id;
    private String description_text;

    public Validation(String description_id, String description_text) {
        this.discription_id = description_id;
        this.description_text = description_text;
    }

    public String getDiscription_id() {
        return discription_id;
    }

    public void setDiscription_id(String discription_id) {
        this.discription_id = discription_id;
    }

    public String getDescription_text() {
        return description_text;
    }

    public void setDescription_text(String description_text) {
        this.description_text = description_text;
    }
}
