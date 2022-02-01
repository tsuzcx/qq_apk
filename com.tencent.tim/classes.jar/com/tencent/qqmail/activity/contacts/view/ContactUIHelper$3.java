package com.tencent.qqmail.activity.contacts.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

final class ContactUIHelper$3
  extends Animation
{
  ContactUIHelper$3(View paramView) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int i = (int)(ContactUIHelper.access$000() * paramFloat);
    if (i >= 0)
    {
      paramTransformation = this.val$editItemView.getLayoutParams();
      paramTransformation.height = i;
      this.val$editItemView.setLayoutParams(paramTransformation);
    }
    if (this.val$editItemView.getVisibility() == 8)
    {
      this.val$editItemView.setVisibility(0);
      this.val$editItemView.requestFocus();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactUIHelper.3
 * JD-Core Version:    0.7.0.1
 */