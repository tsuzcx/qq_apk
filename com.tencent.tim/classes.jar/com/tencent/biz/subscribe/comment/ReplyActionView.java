package com.tencent.biz.subscribe.comment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import wja;

public class ReplyActionView
  extends RelativeLayout
{
  private TextView wc;
  private TextView wd;
  
  public ReplyActionView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ReplyActionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReplyActionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void initView()
  {
    Object localObject = LayoutInflater.from(getContext()).inflate(2131558833, this, true);
    this.wc = ((TextView)((View)localObject).findViewById(2131371968));
    this.wd = ((TextView)((View)localObject).findViewById(2131370397));
    int i = wja.dp2px(12.0F, getContext().getResources());
    localObject = getResources().getDrawable(2130851967);
    ((Drawable)localObject).setBounds(0, 0, i, i);
    this.wc.setCompoundDrawables(null, null, (Drawable)localObject, null);
    localObject = getResources().getDrawable(2130851968);
    ((Drawable)localObject).setBounds(0, 0, i, i);
    this.wd.setCompoundDrawables(null, null, (Drawable)localObject, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.ReplyActionView
 * JD-Core Version:    0.7.0.1
 */