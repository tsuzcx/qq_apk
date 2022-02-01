package com.tencent.biz.qqstory.storyHome.memory.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.BaseAdapter;
import aqcx;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.b;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import que;
import quf;

@TargetApi(9)
public class MemoriesInnerListView
  extends HorizontalListView
{
  private quf a;
  public a b;
  protected int bnG;
  protected int mScreenWidth;
  
  public MemoriesInnerListView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public MemoriesInnerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mScreenWidth = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.bnG = aqcx.dip2px(paramContext, 82.0F);
    this.a = new quf(getContext());
    super.setAdapter(this.a);
    super.setOnItemClickListener(this.a);
    super.setOnScrollStateChangedListener(new que(this));
    setOverScrollMode(1);
  }
  
  public BaseAdapter getAdapter()
  {
    return this.a;
  }
  
  public void setDate(List<VideoCollectionItem.b> paramList, String paramString)
  {
    this.a.setData(paramList, paramString);
    int i = this.mScreenWidth / this.bnG;
    if (paramList.size() >= i)
    {
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public static abstract interface a
  {
    public abstract void rO(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.MemoriesInnerListView
 * JD-Core Version:    0.7.0.1
 */