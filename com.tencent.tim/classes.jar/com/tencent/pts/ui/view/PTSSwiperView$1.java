package com.tencent.pts.ui.view;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.pts.support.PagerSnapHelper.PagerEventListener;

class PTSSwiperView$1
  implements PagerSnapHelper.PagerEventListener
{
  PTSSwiperView$1(PTSSwiperView paramPTSSwiperView) {}
  
  public void onFooterRebound() {}
  
  public void onPagerChanged(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = PTSSwiperView.access$100(this.this$0).getCurrentPosition();
    PTSSwiperView.access$300(this.this$0, PTSSwiperView.access$200(this.this$0).getRealPosition(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSSwiperView.1
 * JD-Core Version:    0.7.0.1
 */