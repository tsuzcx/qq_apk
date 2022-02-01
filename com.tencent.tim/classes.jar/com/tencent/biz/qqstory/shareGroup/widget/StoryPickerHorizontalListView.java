package com.tencent.biz.qqstory.shareGroup.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.BaseAdapter;
import aqcx;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.b;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import qql;
import qqn;

@TargetApi(9)
public class StoryPickerHorizontalListView
  extends HorizontalListView
{
  public c a;
  public qql b;
  int bnG;
  int mScreenWidth;
  
  public StoryPickerHorizontalListView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public StoryPickerHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mScreenWidth = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.bnG = aqcx.dip2px(paramContext, 105.0F);
    this.b = new qql(getContext());
    super.setAdapter(this.b);
    super.setOnItemClickListener(this.b);
    super.setOnScrollStateChangedListener(new qqn(this));
    setOverScrollMode(1);
  }
  
  public BaseAdapter getAdapter()
  {
    return this.b;
  }
  
  public void setData(List<VideoCollectionItem.b> paramList, String paramString)
  {
    this.b.setData(paramList, paramString);
    int i = this.mScreenWidth / this.bnG;
    if (paramList.size() >= i)
    {
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public void setOnHorizontalScrollListener(c paramc)
  {
    this.a = paramc;
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, VideoCollectionItem.b paramb);
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString, int paramInt, View paramView, VideoCollectionItem.b paramb);
  }
  
  public static abstract interface c
  {
    public abstract void rP(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView
 * JD-Core Version:    0.7.0.1
 */