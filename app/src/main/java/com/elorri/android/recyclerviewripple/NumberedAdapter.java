package com.elorri.android.recyclerviewripple;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elorri on 22/01/2017.
 */
public class NumberedAdapter extends RecyclerView.Adapter<NumberedAdapter.TextViewHolder> {
    private final Context mContext;
    private List<String> labels;

    public static final int GREEN = 0;
    public static final int BLEU = 1;
    public static final int PINK = 2;

    public NumberedAdapter(Context context, int count) {
        mContext = context;
        labels = new ArrayList<>(count);
        for (int i = 0; i < count; ++i) {
            labels.add(String.valueOf(i));
        }
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext.getTheme().applyStyle(getThemeRes(viewType), true);

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new TextViewHolder(view);
    }

    private int getThemeRes(int viewType) {
        switch (viewType) {
            case GREEN:
                return R.style.AppTheme;
            case BLEU:
                return R.style.AppTheme_Bleu;
            case PINK:
                return R.style.AppTheme_Pink;
            default:
                return R.style.AppTheme;
        }
    }

    @Override
    public void onBindViewHolder(final TextViewHolder holder, final int position) {
        if (isLastItem(position)) {
            mContext.getTheme().applyStyle(R.style.AppTheme, true);
        }
        final String label = getLabel(position);
        holder.textView.setText(label);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        holder.textView.getContext(), label, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isLastItem(int position) {
        return position == labels.size() - 1;
    }

    private String getLabel(int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case GREEN:
                return "Default";
            case BLEU:
                return "Blue";
            case PINK:
                return "Pink";
            default:
                return "Default";
        }
    }

    @Override
    public int getItemCount() {
        return labels.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 3;
    }

    public class TextViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public TextViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
