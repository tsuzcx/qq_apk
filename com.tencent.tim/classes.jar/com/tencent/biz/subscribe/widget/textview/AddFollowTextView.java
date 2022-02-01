package com.tencent.biz.subscribe.widget.textview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class AddFollowTextView
  extends FollowTextView
{
  public AddFollowTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AddFollowTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AddFollowTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void bkv()
  {
    setBackgroundResource(2130839140);
    setVisibility(0);
  }
  
  protected void bkw()
  {
    setBackgroundResource(2130839142);
    postDelayed(new AddFollowTextView.1(this), 2000L);
  }
  
  protected void initView()
  {
    setBackgroundResource(2130839140);
    setGravity(17);
    setOnClickListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.textview.AddFollowTextView
 * JD-Core Version:    0.7.0.1
 */