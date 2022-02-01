package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qqmail.view.keeppressed.KeepPressedRelativeLayout;

class ContactsListAdapter$2
  implements View.OnLayoutChangeListener
{
  ContactsListAdapter$2(ContactsListAdapter paramContactsListAdapter, KeepPressedRelativeLayout paramKeepPressedRelativeLayout, ContactViewHolder paramContactViewHolder) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (paramInt3 - paramInt1 != paramInt7 - paramInt5)
    {
      this.val$layout.updateDividerInsetLeft(ContactsListAdapter.access$200(this.this$0, this.val$fHolder, ContactsListAdapter.access$100(this.this$0)), 0);
      this.val$layout.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListAdapter.2
 * JD-Core Version:    0.7.0.1
 */