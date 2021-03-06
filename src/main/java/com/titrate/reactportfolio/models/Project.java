package com.titrate.reactportfolio.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project")
@JsonPropertyOrder({"id", "name", "technologies","description","liveLink","sourceCode"})
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private long projectid;

    @JsonProperty("name")
    @Column(name = "name", nullable = false)
    private String projectname;

    //An Array of Strings;
    @ElementCollection
    private List<String> technologies = new ArrayList<>();

    @Column(name = "description", nullable = false)
    private String description;

    @JsonProperty("liveLink")
    @Column(name = "livelink")
    private String livelink;

    @JsonProperty("sourceCode")
    @Column(name = "sourcecode")
    private String sourcecode;

    @JsonProperty("shown")
    @Column(name = "shown", nullable = false)
    private boolean shown = true;

    public Project() {
    }

    public Project(String projectname, List<String> technologies, String description, String livelink, String sourcecode) {
        this.projectname = projectname;
        this.technologies = technologies;
        this.description = description;
        this.livelink = livelink;
        this.sourcecode = sourcecode;
    }

    public long getProjectid() {
        return projectid;
    }

    public void setProjectid(long projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSourcecode() {
        return sourcecode;
    }

    public void setSourcecode(String sourcecode) {
        this.sourcecode = sourcecode;
    }

    public String getLivelink() {
        return livelink;
    }

    public void setLivelink(String livelink) {
        this.livelink = livelink;
    }

    public boolean isShown() {
        return shown;
    }

    public void setShown(boolean shown) {
        this.shown = shown;
    }
}
