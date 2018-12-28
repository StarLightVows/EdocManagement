package org.star.model;

import java.util.Date;

public class EdocEntry {
    private Integer id;

    private Integer categoryid;

    private String title;

    private String summary;

    private String uoloaduser;

    private Date createdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getUoloaduser() {
        return uoloaduser;
    }

    public void setUoloaduser(String uoloaduser) {
        this.uoloaduser = uoloaduser == null ? null : uoloaduser.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}