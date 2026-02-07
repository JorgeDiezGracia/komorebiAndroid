package com.svalero.komorebiandroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.komorebiandroid.R;
import com.svalero.komorebiandroid.domain.School;
import com.svalero.komorebiandroid.domain.SchoolDTO;

import java.util.List;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.SchoolHolder> {

    private List<School> schoolList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(SchoolDTO schoolDTO);
    }

    public SchoolAdapter(List<School> schoolList, OnItemClickListener listener) {
        this.schoolList = schoolList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SchoolHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.school_item, parent, false);
        return new SchoolHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolHolder holder, int position) {
        School school =schoolList.get(position);
        holder.schoolName.setText(school.getName());
        holder.schoolCity.setText(school.getCity());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(new SchoolDTO(school)); // Convertimos a DTO
            }
        });
    }

    @Override
    public int getItemCount() {
        return schoolList.size();
    }

    public static class SchoolHolder extends RecyclerView.ViewHolder {
        TextView schoolName, schoolCity;

        public SchoolHolder(@NonNull View itemView) {
            super(itemView);
            schoolName = itemView.findViewById(R.id.item_school_name);
            schoolCity = itemView.findViewById(R.id.item_school_city);
        }
    }
}
