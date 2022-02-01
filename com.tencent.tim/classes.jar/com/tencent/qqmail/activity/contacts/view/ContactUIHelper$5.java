package com.tencent.qqmail.activity.contacts.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

final class ContactUIHelper$5
  extends Animation
{
  ContactUIHelper$5(int paramInt, View paramView) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int i = (int)(this.val$height * (1.0F - paramFloat));
    if (i > 0)
    {
      paramTransformation = this.val$editItemView.getLayoutParams();
      paramTransformation.height = i;
      this.val$editItemView.setLayoutParams(paramTransformation);
      return;
    }
    paramTransformation = this.val$editItemView.getLayoutParams();
    paramTransformation.height = 1;
    this.val$editItemView.setLayoutParams(paramTransformation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactUIHelper.5
 * JD-Core Version:    0.7.0.1
 */