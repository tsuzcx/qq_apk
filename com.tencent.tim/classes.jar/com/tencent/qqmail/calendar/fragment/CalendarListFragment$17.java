package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class CalendarListFragment$17
  extends Animation
{
  CalendarListFragment$17(CalendarListFragment paramCalendarListFragment, int paramInt, View paramView) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int i = (int)(this.val$height * paramFloat);
    if (i > 0)
    {
      paramTransformation = this.val$view.getLayoutParams();
      paramTransformation.height = i;
      this.val$view.setLayoutParams(paramTransformation);
      return;
    }
    paramTransformation = this.val$view.getLayoutParams();
    paramTransformation.height = 1;
    this.val$view.setLayoutParams(paramTransformation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarListFragment.17
 * JD-Core Version:    0.7.0.1
 */