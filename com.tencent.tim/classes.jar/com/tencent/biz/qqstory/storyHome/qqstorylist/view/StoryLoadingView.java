package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class StoryLoadingView
  extends ImageView
{
  protected AnimationDrawable l;
  
  public StoryLoadingView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public StoryLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public StoryLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.l = new AnimationDrawable();
    this.l.addFrame(getResources().getDrawable(2130847441), 50);
    this.l.addFrame(getResources().getDrawable(2130847442), 50);
    this.l.addFrame(getResources().getDrawable(2130847443), 50);
    this.l.addFrame(getResources().getDrawable(2130847444), 50);
    this.l.addFrame(getResources().getDrawable(2130847445), 50);
    this.l.addFrame(getResources().getDrawable(2130847446), 50);
    this.l.addFrame(getResources().getDrawable(2130847447), 50);
    this.l.addFrame(getResources().getDrawable(2130847448), 50);
    this.l.addFrame(getResources().getDrawable(2130847449), 50);
    this.l.addFrame(getResources().getDrawable(2130847450), 50);
    this.l.addFrame(getResources().getDrawable(2130847451), 50);
    this.l.addFrame(getResources().getDrawable(2130847452), 50);
    this.l.addFrame(getResources().getDrawable(2130847453), 50);
    this.l.addFrame(getResources().getDrawable(2130847454), 50);
    this.l.addFrame(getResources().getDrawable(2130847455), 50);
    this.l.addFrame(getResources().getDrawable(2130847456), 50);
    this.l.addFrame(getResources().getDrawable(2130847457), 50);
    this.l.addFrame(getResources().getDrawable(2130847458), 50);
    this.l.addFrame(getResources().getDrawable(2130847459), 50);
    this.l.addFrame(getResources().getDrawable(2130847460), 50);
    this.l.addFrame(getResources().getDrawable(2130847461), 50);
    this.l.addFrame(getResources().getDrawable(2130847462), 50);
    this.l.addFrame(getResources().getDrawable(2130847463), 50);
    this.l.addFrame(getResources().getDrawable(2130847464), 50);
    this.l.addFrame(getResources().getDrawable(2130847465), 50);
    this.l.addFrame(getResources().getDrawable(2130847466), 50);
    this.l.addFrame(getResources().getDrawable(2130847467), 50);
    this.l.addFrame(getResources().getDrawable(2130847468), 50);
    this.l.addFrame(getResources().getDrawable(2130847469), 50);
    this.l.setOneShot(false);
    super.setImageDrawable(this.l);
    if ((this.l != null) && (!this.l.isRunning())) {
      this.l.start();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if ((paramInt == 0) && (!this.l.isRunning())) {
      this.l.start();
    }
    while (!this.l.isRunning()) {
      return;
    }
    this.l.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryLoadingView
 * JD-Core Version:    0.7.0.1
 */