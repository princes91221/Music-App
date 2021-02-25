package com.example.musicapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
        albumList.add(new AlbumObject(R.drawable.bohemian, "Bohemian Rhapsody", "Produced by Queen"));
        albumList.add(new AlbumObject(R.drawable.hybrid, "Hybrid Theory", "Produced by Linkin Park"));
        albumList.add(new AlbumObject(R.drawable.kohinoor, "Kohinoor", "Produced by Divine"));
        albumList.add(new AlbumObject(R.drawable.maroon5, "Live from Le Cabaret", "Produced by Maroon 5"));
        albumList.add(new AlbumObject(R.drawable.mtbmb, "Music To Be Murdered By", "Produced by Eminem"));
        albumList.add(new AlbumObject(R.drawable.rated_r, "Rated R", "Produced by Rihanna"));
        albumList.add(new AlbumObject(R.drawable.reckless, "Reckless", "Produced by Bryan Adams"));
        albumList.add(new AlbumObject(R.drawable.recovery, "Recovery", "Produced by Eminem"));
        albumList.add(new AlbumObject(R.drawable.reputation, "Reputation", "Produced by Taylor Swift"));
        albumList.add(new AlbumObject(R.drawable.rockstar, "Rockstar", "Produced by AR Rehman"));
        albumList.add(new AlbumObject(R.drawable.tamasha, "Tamasha", "Produced by AR Rehman"));

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

            imageView.setImageResource(getItem(position).getImage());

            albumName.setText(getItem(position).getName());

            albumDescription.setText(getItem(position).getDescription());

            return convertView;
        }
    }
}
