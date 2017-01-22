package com.elorri.android.recyclerviewripple;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Elorri on 21/01/2017.
 */
public class MainFragment extends Fragment {

    private Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container);

        final TextView selectableItem = (TextView) view.findViewById(R.id.selectable_item);
        selectableItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //View.inflate(new ContextThemeWrapper(mContext, R.style.AppTheme_Bleu), R.layout
        //      .fragment_main, container);

        view.findViewById(R.id.default_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindView(selectableItem, R.style.AppTheme);
            }
        });

        view.findViewById(R.id.blue_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindView(selectableItem, R.style.AppTheme_Bleu);
            }
        });
        view.findViewById(R.id.pink_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindView(selectableItem, R.style.AppTheme_Pink);
            }
        });


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new NumberedAdapter(mContext, 30));

        return view;
    }

    private void bindView(TextView selectableItem, int themeRes) {

        Resources.Theme currentTheme = mContext.getTheme();
        currentTheme.applyStyle(themeRes, true);
        selectableItem.setBackground(mContext.getResources()
                .getDrawable(RessoucesUtils
                        .getResDrawable(mContext, R.attr.selectableItemBackground), currentTheme));
    }


}
