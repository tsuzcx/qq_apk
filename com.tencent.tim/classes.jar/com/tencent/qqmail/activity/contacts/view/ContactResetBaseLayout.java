package com.tencent.qqmail.activity.contacts.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ScrollView;

public class ContactResetBaseLayout
  extends ScrollView
{
  private Button holderDeleteButton;
  private ContactsScrollItemView holderScrollView;
  
  public ContactResetBaseLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ContactResetBaseLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public Button getHolderDeleteButton()
  {
    return this.holderDeleteButton;
  }
  
  public ContactsScrollItemView getHolderScrollView()
  {
    return this.holderScrollView;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.holderScrollView != null) && (this.holderDeleteButton != null))
    {
      int[] arrayOfInt = new int[2];
      this.holderDeleteButton.getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[0];
      int j = arrayOfInt[1];
      if ((paramMotionEvent.getRawX() < i) || (paramMotionEvent.getRawX() > i + this.holderDeleteButton.getWidth()) || (paramMotionEvent.getRawY() < j) || (paramMotionEvent.getRawY() > j + this.holderDeleteButton.getHeight()))
      {
        this.holderScrollView.scrollToStart();
        this.holderScrollView = null;
        this.holderDeleteButton = null;
        return true;
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setHolderDeleteButton(Button paramButton)
  {
    this.holderDeleteButton = paramButton;
  }
  
  public void setHolderScrollView(ContactsScrollItemView paramContactsScrollItemView)
  {
    this.holderScrollView = paramContactsScrollItemView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactResetBaseLayout
 * JD-Core Version:    0.7.0.1
 */