package com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget;

import acfp;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import rac;

public class NewMessageYellowBar
  extends FrameLayout
{
  protected int bpk;
  protected AnimationSet d = new AnimationSet(false);
  protected AlphaAnimation k = new AlphaAnimation(1.0F, 0.0F);
  public TextView mTextView;
  protected TranslateAnimation s = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
  
  public NewMessageYellowBar(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null);
  }
  
  public NewMessageYellowBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public void dX(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0) {
      if (paramInt2 > this.bpk) {}
    }
    do
    {
      return;
      this.bpk = paramInt2;
      if (paramInt1 > 0)
      {
        setVisibility(0);
        post(new NewMessageYellowBar.2(this, paramInt1));
        return;
      }
      setVisibility(8);
      this.mTextView.setText(acfp.m(2131709055));
      this.mTextView.setAlpha(0.0F);
    } while (this.d.hasEnded());
    this.mTextView.clearAnimation();
  }
  
  public void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(getContext()).inflate(2131562050, this, true);
    this.mTextView = ((TextView)findViewById(2131382404));
    this.s.setDuration(1000L);
    this.k.setStartOffset(1000L);
    this.k.setDuration(3000L);
    this.d.addAnimation(this.s);
    this.d.addAnimation(this.k);
    this.d.setFillAfter(true);
    this.d.setAnimationListener(new rac(this));
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.NewMessageYellowBar
 * JD-Core Version:    0.7.0.1
 */