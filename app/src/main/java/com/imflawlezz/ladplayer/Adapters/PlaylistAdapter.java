package com.imflawlezz.ladplayer.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.imflawlezz.ladplayer.R;

import java.util.List;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder> {

    private final List<String> playlistItems;

    public PlaylistAdapter(List<String> playlistItems) {
        this.playlistItems = playlistItems;
    }

    @NonNull
    @Override
    public PlaylistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_song, parent, false);
        return new PlaylistViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistViewHolder holder, int position) {
        String[] songInfo = playlistItems.get(position).split(" - ");
        String songTitle = songInfo[0];
        String artistName = songInfo.length > 1 ? songInfo[1] : "Unknown Artist";

        holder.songNameText.setText(songTitle);
        holder.artistNameText.setText(artistName);
    }

    @Override
    public int getItemCount() {
        return playlistItems.size();
    }

    static class PlaylistViewHolder extends RecyclerView.ViewHolder {
        TextView songNameText;
        TextView artistNameText;

        public PlaylistViewHolder(@NonNull View itemView) {
            super(itemView);
            songNameText = itemView.findViewById(R.id.songNameText);
            artistNameText = itemView.findViewById(R.id.artistNameText);
        }
    }
}
