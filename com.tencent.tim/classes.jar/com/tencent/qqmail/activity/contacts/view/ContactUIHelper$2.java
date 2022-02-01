package com.tencent.qqmail.activity.contacts.view;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class ContactUIHelper$2
  implements ViewTreeObserver.OnPreDrawListener
{
  ContactUIHelper$2(View paramView) {}
  
  public boolean onPreDraw()
  {
    ContactUIHelper.access$002(this.val$editItemView.getMeasuredHeight());
    this.val$editItemView.getViewTreeObserver().removeOnPreDrawListener(this);
    this.val$editItemView.setVisibility(8);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactUIHelper.2
 * JD-Core Version:    0.7.0.1
 */