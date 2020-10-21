package fr.isep.ii3510.apiillustration.ui.glide;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import fr.isep.ii3510.apiillustration.R;

public class GlideFragment extends Fragment {
    private ImageView imageView;
    private GlideViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_glide, container, false);
        imageView = viewGroup.findViewById(R.id.glide_imageView);
        return viewGroup;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GlideViewModel.class);
        Glide.with(this)
                .load("https://i.imgflip.com/35rt5v.jpg")
                .into(imageView);
    }

}