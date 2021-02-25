package com.example.musicapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class AlbumFragment extends Fragment {

    ListView listView;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = (ListView) getView().findViewById(R.id.album_list);

        // Create Data
        ArrayList<AlbumObject> albumList = new ArrayList<AlbumObject>();
        albumList.add(new AlbumObject(R.drawable.bohemian, "Bohemian Rhapsody", "Produced by Queen", 5));
        albumList.add(new AlbumObject(R.drawable.hybrid, "Hybrid Theory", "Produced by Linkin Park", 8));
        albumList.add(new AlbumObject(R.drawable.kohinoor, "Kohinoor", "Produced by Divine", 7));
        albumList.add(new AlbumObject(R.drawable.maroon5, "Live from Le Cabaret", "Produced by Maroon 5", 3));
        albumList.add(new AlbumObject(R.drawable.mtbmb, "Music To Be Murdered By", "Produced by Eminem", 5));
        albumList.add(new AlbumObject(R.drawable.rated_r, "Rated R", "Produced by Rihanna", 7));
        albumList.add(new AlbumObject(R.drawable.reckless, "Reckless", "Produced by Bryan Adams", 1));
        albumList.add(new AlbumObject(R.drawable.recovery, "Recovery", "Produced by Eminem", 9));
        albumList.add(new AlbumObject(R.drawable.reputation, "Reputation", "Produced by Taylor Swift", 8));
        albumList.add(new AlbumObject(R.drawable.rockstar, "Rockstar", "Produced by AR Rehman", 2));
        albumList.add(new AlbumObject(R.drawable.tamasha, "Tamasha", "Produced by AR Rehman", 4));

        // Make Custom Adapter
        AlbumAdapter albumAdapter = new AlbumAdapter(view.getContext(), R.layout.album_row, albumList);
        listView.setAdapter(albumAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_album, container, false);
    }

    public class AlbumAdapter extends ArrayAdapter<AlbumObject> {
        private Context mContext;
        private int mResource;

        public AlbumAdapter(@NonNull Context context, int resource, @NonNull ArrayList<AlbumObject> objects) {
            super(context, resource, objects);
            this.mContext = context;
            this.mResource = resource;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);

            convertView = layoutInflater.inflate(mResource, parent, false);

            ImageView imageView = convertView.findViewById(R.id.image);

            TextView albumName = convertView.findViewById(R.id.album_name);

            TextView albumDescription = convertView.findViewById(R.id.album_description);

            TextView numberOfSongs = convertView.findViewById(R.id.songs_number);

            AlbumObject albumObject = getItem(position);
            imageView.setImageResource(albumObject.getImage());

            albumName.setText(albumObject.getName());

            albumDescription.setText(albumObject.getDescription());

            numberOfSongs.setText(String.valueOf(albumObject.getNumberOfSongs()) + " Songs");

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO: Show the detail page of album, sorry due to lack of time I was not able to show details and songs of album
                    String title = "Show album details: " + albumObject.getName();
                    new AlertDialog.Builder(v.getContext()).setTitle(title).show();
                }
            });

            return convertView;
        }
    }
}
