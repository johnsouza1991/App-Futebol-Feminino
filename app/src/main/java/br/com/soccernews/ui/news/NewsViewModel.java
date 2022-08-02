package br.com.soccernews.ui.news;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import br.com.soccernews.domain.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        this.news = new MutableLiveData<>();

        List<News> news = new ArrayList<>();
        news.add(new News("Noticia 1","Descricao 1"));
        news.add(new News("Noticia 2","Descricao 2"));
        news.add(new News("Noticia 3","Descricao 3"));

        this.news.setValue(news);
    }

    public MutableLiveData<List<News>> getNews() {
        return this.news;
    }
}