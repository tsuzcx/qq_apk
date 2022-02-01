package com.tencent.qqmail.activity.vipcontacts;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qqmail.activity.contacts.fragment.ContactViewHolder;
import com.tencent.qqmail.view.keeppressed.KeepPressedRelativeLayout;

class VIPContactsIndexAdapter$1
  implements View.OnLayoutChangeListener
{
  VIPContactsIndexAdapter$1(VIPContactsIndexAdapter paramVIPContactsIndexAdapter, int paramInt, KeepPressedRelativeLayout paramKeepPressedRelativeLayout, ContactViewHolder paramContactViewHolder) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.val$itemViewType == 3) {
      this.val$layout.updateDividerInsetLeft(0, 0);
    }
    do
    {
      return;
      if (this.val$itemViewType == 0)
      {
        this.val$layout.updateDividerInsetLeft(0, VIPContactsIndexAdapter.access$000(this.this$0, this.val$fHolder));
        return;
      }
      if (this.val$itemViewType == 2)
      {
        this.val$layout.updateDividerInsetLeft(0, 0);
        return;
      }
    } while (this.val$itemViewType != 1);
    this.val$layout.updateDividerInsetLeft(0, VIPContactsIndexAdapter.access$000(this.this$0, this.val$fHolder));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsIndexAdapter.1
 * JD-Core Version:    0.7.0.1
 */