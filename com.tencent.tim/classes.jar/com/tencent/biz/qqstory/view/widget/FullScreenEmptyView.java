package com.tencent.biz.qqstory.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import rpq;
import wja;

@TargetApi(14)
public class FullScreenEmptyView
  extends AbsEmptyView
{
  public FullScreenEmptyView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FullScreenEmptyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getViewHeight()
  {
    return rpq.getWindowScreenHeight(super.getContext()) - wja.dp2px(55.0F, super.getResources()) - rpq.getStatusBarHeight(super.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.FullScreenEmptyView
 * JD-Core Version:    0.7.0.1
 */