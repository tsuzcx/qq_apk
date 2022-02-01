package com.tencent.biz.qqcircle.comment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class QCircleReplyActionView
  extends RelativeLayout
{
  private TextView wc;
  private TextView wd;
  
  public QCircleReplyActionView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public QCircleReplyActionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleReplyActionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void initView()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131560882, this, true);
    this.wc = ((TextView)localView.findViewById(2131380809));
    this.wd = ((TextView)localView.findViewById(2131380779));
  }
  
  public TextView t()
  {
    return this.wc;
  }
  
  public TextView u()
  {
    return this.wd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleReplyActionView
 * JD-Core Version:    0.7.0.1
 */