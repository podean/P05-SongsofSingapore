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
        private ImageView ivMusic;
        private  TextView tvYear;
        private TextView tvName;
        private TextView tvArtist;

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View rowView = inflater.inflate(R.layout.row, parent, false);


            tvYear = (TextView)rowView.findViewById(R.id.tvID);
            tvName = (TextView)rowView.findViewById(R.id.tvName);
            tvArtist = (TextView)rowView.findViewById(R.id.tvArtist);
            ivMusic = (ImageView)rowView.findViewById(R.id.ivMusic);



            Song currentsong = songs.get(position);

            tvID.setText(currentTask.getId());
            tvDesc.setText(currentTask.getDescription());
            tvDate.setText(currentTask.getDate());
            return rowView;
        }
        public taskAdapter(Context context, int resource, ArrayList<task> objects){
            super(context, resource, objects);

            Task = objects;
            this.context = context;
        }
    }

}