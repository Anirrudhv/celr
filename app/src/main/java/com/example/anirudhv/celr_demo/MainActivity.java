package com.example.anirudhv.celr_demo;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView videoView;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Celr>> call = api.getCelr();

        call.enqueue(new Callback<List<Celr>>() {
            @Override
            public void onResponse(Call<List<Celr>> call, Response<List<Celr>> response) {
                List<Celr> ani = response.body();
                String videos [] = new String[ani.size()];
                String images [] = new  String[ani.size()];
                for (int i =0 ; i< ani.size(); i++){
                    videos[i] = ani.get(i).getVideoUrl();
                    images[i] = ani.get(i).getImageUrl();

                    Log.d("o",videos[i]);
                    Log.d("d",images[i]);





                    final VideoView videoView = (VideoView)findViewById(R.id.videoView);
                    try {
                        Uri uri = Uri.parse(videos[5]);
                        videoView.setVideoURI(uri);

                    }
                    catch (Exception ex){

                    }

                    videoView.requestFocus();
                    videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mediaPlayer.setLooping(true);
                            videoView.start();
                        }
                    });

                }}



            @Override
            public void onFailure(Call<List<Celr>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}