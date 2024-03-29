package com.deskshop.front.controllers;

import com.deskshop.common.metier.Article;
import com.deskshop.front.util.ControllerUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.ResourceBundle;

public class DisplayArticleController implements Initializable {


    @FXML
    private VBox vbox;

    @FXML
    private ImageView imgProduit;

    @FXML
    private Label lbNomProduit;

    @FXML
    private Label lbPrix;

    @FXML
    private Hyperlink linkAjouterPanier;

    private Article article;
    private HashMap<Article, Integer> panier;
    private boolean modifyArticle;
    public DisplayArticleController(Article article, HashMap<Article, Integer> panier, boolean modifyArticle) {
        this.article = article;
        this.panier = panier;
        this.modifyArticle = modifyArticle;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            //this.imgProduit.setImage(new Image(this.image));
            //this.imgProduit.setImage(new Image("images/deskshop-logo.png"));
            try {
                this.imgProduit.setImage(new Image(Paths.get(this.article.getPicture()).toUri().toURL().toExternalForm()));
            }catch (Exception ignore){
                this.imgProduit.setImage(new Image("images/deskshop-logo.png"));
            }
            this.lbNomProduit.setText(this.article.getName());
            this.lbPrix.setText(this.article.getPrice() + "Ø");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    void linkAjouterPanierClick(ActionEvent event) {
        ControllerUtils.loadPopupArticle(article, panier, this.modifyArticle);
    }
}
