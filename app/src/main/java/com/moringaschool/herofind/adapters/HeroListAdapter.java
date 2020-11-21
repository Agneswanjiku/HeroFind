package com.moringaschool.herofind.adapters;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.herofind.HeroDetailActivity;
import com.moringaschool.herofind.R;
import com.moringaschool.herofind.model.Result;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HeroListAdapter extends RecyclerView.Adapter<HeroListAdapter.HeroViewHolder> {

    private List<Result> batman;
    private Context mContext;

    public HeroListAdapter(Context context, List<Result> mBatman){
        mContext = context;
        batman = mBatman;
    }

    @NonNull
    @Override
    public HeroListAdapter.HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hero_list_item, parent, false);
        HeroViewHolder viewHolder = new HeroViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        holder.bindHero(batman.get(position));
    }

    @Override
    public int getItemCount() {
        return batman.size();
    }


    public class HeroViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        @BindView(R.id.heroImageView) ImageView mImageView;
        @BindView(R.id.heroNameTextView) TextView mHeroName;
        @BindView(R.id.fullNameTextView) TextView mFullName;

        private Context mContext;

        public HeroViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);

            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            final Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.bounce);
            flipIt(view);
            view.startAnimation(animation);
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, HeroDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("heroes", Parcels.wrap(batman));
            mContext.startActivity(intent);
        }

        public void bindHero(Result batman){

            Picasso.get().load(batman.getImage().getUrl()).into(mImageView);
            mHeroName.setText(("Movie Name: ")+batman.getName());
            mFullName.setText(("Real Name: ")+batman.getBiography().getFullName());

        }

        private void flipIt(final View viewToFlip) {
            ObjectAnimator flip = ObjectAnimator.ofFloat(viewToFlip, "rotationX", 2.0f, 360f);
            flip.setDuration(2000);
            flip.start();
        }


    }

}
