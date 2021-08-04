package com.example.sharingyuk.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.sharingyuk.R;
import com.example.sharingyuk.activity.DetailActivity;
import com.example.sharingyuk.activity.MainActivity;
import com.example.sharingyuk.model.Mentor;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private ArrayList<Mentor> mentorArrayList = new ArrayList<>();
    Context context;

    public CardAdapter(ArrayList<Mentor> mentorArrayList, Context context) {
        this.mentorArrayList = mentorArrayList;
        this.context = context;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card, parent, false);
        return new CardAdapter.CardViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CardAdapter.CardViewHolder holder, int position) {

        Mentor mentor = mentorArrayList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(mentor.getPhoto())
                .apply(new RequestOptions().override(120, 150))
                .into(holder.imageView);

//        holder.imageView.setImageResource(mentor.getPhoto());
        holder.tvnama.setText(mentor.getNama());
        holder.tvbidang.setText(mentor.getBidang());
        holder.tvalamat.setText(mentor.getAlamat());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),DetailActivity.class);
                intent.putExtra("gambar", mentorArrayList.get(position).getPhoto());

                intent.putExtra("nama", mentorArrayList.get(position).getNama());
                intent.putExtra("alamat", mentorArrayList.get(position).getAlamat());
                intent.putExtra("bidang", mentorArrayList.get(position).getBidang());

                context.startActivity(intent);

            }
        });

        holder.btnlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(),"Anda Menyukai : "+mentorArrayList.get(holder.getAdapterPosition()).getNama(),Toast.LENGTH_LONG).show();
            }
        });

        holder.btncomment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(),"Anda Comment  : "+mentorArrayList.get(holder.getAdapterPosition()).getNama(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mentorArrayList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvnama,tvbidang,tvalamat,tvemail,tvnomorhp;
        Button btnlike,btncomment;
        CardView cardView;

        public CardViewHolder(View itemView) {
            super(itemView);


            imageView = itemView.findViewById(R.id.img_card);
            tvnama = itemView.findViewById(R.id.tv_nama);
            tvbidang = itemView.findViewById(R.id.tv_bdang);
            tvalamat = itemView.findViewById(R.id.tv_alamat4);
            btnlike = itemView.findViewById(R.id.btn_like);
            btncomment = itemView.findViewById(R.id.btn_comment);
            cardView = itemView.findViewById(R.id.cardview);

        }
    }
}
