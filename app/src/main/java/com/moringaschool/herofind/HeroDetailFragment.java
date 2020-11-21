package com.moringaschool.herofind;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.moringaschool.herofind.model.Result;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HeroDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HeroDetailFragment extends Fragment implements  View.OnClickListener {

    @BindView(R.id.batmanNameTextView)
    TextView batmanName;
    @BindView(R.id.placeOfBirthTextView)
    TextView placeOfBirth;
    @BindView(R.id.occupationTextView)
    TextView mOccupation;
    @BindView(R.id.batman2ImageView)
    ImageView imageView;
    @BindView(R.id.power)
    TextView mPower;
    @BindView(R.id.aliasesTextView)
    TextView mAliases;
    @BindView(R.id.relatives)
    TextView mRelatives;

    private Result heroItems;


    public HeroDetailFragment() {
        // Required empty public constructor
    }


    public static HeroDetailFragment newInstance(Result results) {
        HeroDetailFragment fragment = new HeroDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("results", Parcels.wrap(results));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            heroItems = Parcels.unwrap(getArguments().getParcelable("results"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View heroDetails = inflater.inflate(R.layout.fragment_hero_detail, container, false);

        ButterKnife.bind(this, heroDetails);

        Picasso.get().load(heroItems.getImage().getUrl()).into(imageView);


        mPower.setText(("Speed: ") + heroItems.getPowerstats().getSpeed());
        mRelatives.setText(("Relatives: ") + heroItems.getConnections().getRelatives());
        mAliases.setText(("Aliases : ") + heroItems.getBiography().getAliases());
        mOccupation.setText(("Occupation: ") + heroItems.getWork().getOccupation());
        batmanName.setText(("Movie Name: ") + heroItems.getName());
        placeOfBirth.setText(("Place of Birth: ") + heroItems.getBiography().getPlaceOfBirth());


        return heroDetails;
    }

    @Override
    public void onClick(View v) {

    }
}