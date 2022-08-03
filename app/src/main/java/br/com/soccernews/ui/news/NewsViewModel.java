package br.com.soccernews.ui.news;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import br.com.soccernews.data.SoccerNewsAPI;
import br.com.soccernews.domain.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news = new MutableLiveData<>();
    private final SoccerNewsAPI api;

    public NewsViewModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://johnsouza1991.github.io/Soccer-news-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(SoccerNewsAPI.class);
        this.findNews();

    }

    private void findNews() {
        api.getNews().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if(response.isSuccessful()){
                    news.setValue(response.body());
                }else {}
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {

            }
        });
    }

    public MutableLiveData<List<News>> getNews() {
        return this.news;
    }
}