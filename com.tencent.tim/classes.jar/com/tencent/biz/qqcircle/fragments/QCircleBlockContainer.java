package com.tencent.biz.qqcircle.fragments;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.widget.StatusView;

public class QCircleBlockContainer
  extends BlockContainer
{
  public QCircleBlockContainer(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleBlockContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCircleBlockContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public StatusView a(View paramView)
  {
    return new QCircleStatusView(getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBlockContainer
 * JD-Core Version:    0.7.0.1
 */