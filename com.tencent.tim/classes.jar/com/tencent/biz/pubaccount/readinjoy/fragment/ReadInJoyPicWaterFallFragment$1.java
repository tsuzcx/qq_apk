package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView;

class ReadInJoyPicWaterFallFragment$1
  extends ReadInjoyXRecyclerView
{
  ReadInJoyPicWaterFallFragment$1(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    if ((paramInt == 0) && (this.this$0.a != null)) {
      this.this$0.a.setData(this.this$0.nh(), this.this$0.kz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.1
 * JD-Core Version:    0.7.0.1
 */