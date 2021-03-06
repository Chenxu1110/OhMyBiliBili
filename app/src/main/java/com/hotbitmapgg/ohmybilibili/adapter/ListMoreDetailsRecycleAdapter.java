package com.hotbitmapgg.ohmybilibili.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.model.VideoItemInfo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListMoreDetailsRecycleAdapter extends AbsRecyclerViewAdapter
{

    private List<VideoItemInfo> videoItemInfos = new ArrayList<>();

    public ListMoreDetailsRecycleAdapter(RecyclerView recyclerView, List<VideoItemInfo> videoItemInfos)
    {

        super(recyclerView);
        this.videoItemInfos = videoItemInfos;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_main_list_recycle, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            VideoItemInfo videoItemInfo = videoItemInfos.get(position);
            itemViewHolder.mVideoTitle.setText(videoItemInfo.title);
            itemViewHolder.mVideoPlayNum.setText(videoItemInfo.play);
            itemViewHolder.mVideoReviewCount.setText((videoItemInfo.video_review) + "");

            Picasso.with(getContext()).load(Uri.parse(videoItemInfo.pic)).placeholder(R.drawable.bili_default_image_tv).into(itemViewHolder.mVideoImg);
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return videoItemInfos.size();
    }

    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        public ImageView mVideoImg;

        public TextView mVideoTitle;

        public TextView mVideoPlayNum;

        public TextView mVideoReviewCount;

        public ItemViewHolder(View itemView)
        {

            super(itemView);
            mVideoImg = $(R.id.video_preview);
            mVideoTitle = $(R.id.video_title);
            mVideoPlayNum = $(R.id.video_play_num);
            mVideoReviewCount = $(R.id.video_review_count);
        }
    }
}
