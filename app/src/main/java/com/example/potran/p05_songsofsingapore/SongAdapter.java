package com.example.potran.p05_songsofsingapore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter{
        private ArrayList<Song> songs;
        private Context context;
        private  TextView tvYear;
        private TextView tvName;
        private TextView tvArtist;
    private ImageView ivMusic;
    private ImageView ivStar1;
    private ImageView ivStar2;
    private ImageView ivStar3;
    private ImageView ivStar4;
    private ImageView ivStar5;

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View rowView = inflater.inflate(R.layout.row, parent, false);


            tvYear = (TextView)rowView.findViewById(R.id.tvID);
            tvName = (TextView)rowView.findViewById(R.id.tvName);
            tvArtist = (TextView)rowView.findViewById(R.id.tvArtist);
            ivStar1 = (ImageView)rowView.findViewById(R.id.ivStar1);
            ivStar2 = (ImageView)rowView.findViewById(R.id.ivStar2);
            ivStar3 = (ImageView)rowView.findViewById(R.id.ivStar3);
            ivStar4 = (ImageView)rowView.findViewById(R.id.ivStar4);
            ivStar5 = (ImageView)rowView.findViewById(R.id.ivStar5);
            ivMusic = (ImageView)rowView.findViewById(R.id.ivMusic);



            Song currentsong = songs.get(position);

            tvYear.setText(currentsong.getYear());
            tvName.setText(currentsong.getTitle());
            tvArtist.setText(currentsong.getSingers());
            ivMusic.setImageResource(R.drawable.ic_library_music);
            return rowView;
        }

        public SongAdapter(Context context, int resource, ArrayList<Song> objects){
            super(context, resource, objects);

            songs = objects;
            this.context = context;
        }
    }

