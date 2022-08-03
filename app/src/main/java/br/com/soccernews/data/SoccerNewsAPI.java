package br.com.soccernews.data;

import java.util.List;

import br.com.soccernews.domain.News;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SoccerNewsAPI {

    @GET("news.json")
    Call<List<News>> getNews();
}
