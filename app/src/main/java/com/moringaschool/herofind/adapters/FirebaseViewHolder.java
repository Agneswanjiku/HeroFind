package com.moringaschool.herofind.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.herofind.Constants;
import com.moringaschool.herofind.R;
import com.moringaschool.herofind.model.Result;
import com.moringaschool.herofind.HeroDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View firebaseView;
    Context mContext;

    public FirebaseViewHolder(View itemView) {
        super(itemView);
        firebaseView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }
    public void bindHero(Result results) {
        ImageView movieImage = (ImageView) firebaseView.findViewById(R.id.heroSavedImageView);
        TextView movieName = (TextView) firebaseView.findViewById(R.id.heroSavedNameTextView);
        TextView realName = (TextView) firebaseView.findViewById(R.id.realNameSavedTextView);

        Picasso.get().load(results.getImage().getUrl()).into(movieImage);
        movieName.setText(("Name: ")+results.getName());
        realName.setText(("RealName: ")+results.getBiography().getFullName());

    }

    @Override
    public void onClick(View view) {
        final ArrayList<Result> heroes = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_FLASH);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    heroes.add(snapshot.getValue(Result.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, HeroDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("heroes", Parcels.wrap(heroes));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }
}
