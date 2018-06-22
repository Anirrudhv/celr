package com.example.anirudhv.celr_demo;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

public class customswipe extends PagerAdapter {
    private Context ctx;
    private LayoutInflater layoutInflater;
    public  String app[] = new String[6];
    public  String bcc[] = new String[6];

    public void getvalues(String[] V, String[] I){

        for (int i =0; i < V.length; i++){
            app[i] = V[i];
            bcc[i] = I[i];
        }}

    public int getCount() {

        return app.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return false;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe,container,false);
        container.addView(item_view);
        final VideoView videoView = (VideoView) item_view.findViewById(R.id.videoView);
        try {
            Log.d("tes",app[3]);

            Uri uri = Uri.parse(app[position]);
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
        return item_view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }
}
