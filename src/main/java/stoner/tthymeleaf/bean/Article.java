package stoner.tthymeleaf.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Article {

    private String id;

    private String title;

    private String summary;

    private Date createTime;
}
