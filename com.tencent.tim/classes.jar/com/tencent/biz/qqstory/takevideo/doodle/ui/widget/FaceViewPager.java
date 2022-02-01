package com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import riv;

public class FaceViewPager
  extends ViewPager
{
  private List<a> jC;
  
  public FaceViewPager(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public FaceViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    this.jC = new ArrayList();
    setOnPageChangeListener(new riv(this));
  }
  
  public void a(a parama)
  {
    if (!this.jC.contains(parama)) {
      this.jC.add(parama);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onPageSelected(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager
 * JD-Core Version:    0.7.0.1
 */