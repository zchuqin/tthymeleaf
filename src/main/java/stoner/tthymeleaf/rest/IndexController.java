package stoner.tthymeleaf.rest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import stoner.tthymeleaf.bean.Article;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class IndexController {

    @PostMapping("/index.html")
    public String indexArticlePage(Model model, @RequestBody List<Article> articles) {
        for (Article article : articles) {
            article.setCreateTime(new Date());
        }
        model.addAttribute("list", articles);
        return "index.html";
    }

    @GetMapping("/index.html")
    public String indexArticlePage(Model model, String titles) {
        if (StringUtils.isNotBlank(titles)) {
            ArrayList<Article> articles = new ArrayList<>();
            for (String s : titles.split(",")) {
                Article article = new Article();
                article.setTitle(s);
                articles.add(article);
            }
            model.addAttribute("list", articles);
        }
        return "index.html";
    }
}
