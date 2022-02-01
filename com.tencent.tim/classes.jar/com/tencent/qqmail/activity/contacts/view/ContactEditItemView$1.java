package com.tencent.qqmail.activity.contacts.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactEditItemView$1
  implements View.OnClickListener
{
  ContactEditItemView$1(ContactEditItemView paramContactEditItemView) {}
  
  public void onClick(View paramView)
  {
    this.this$0.mScrollerView.scrollToEnd();
    Object localObject = this.this$0;
    View localView;
    do
    {
      localView = (View)((View)localObject).getParent();
      if (localView == null) {
        break;
      }
      localObject = localView;
    } while (!(localView instanceof ContactResetBaseLayout));
    localObject = (ContactResetBaseLayout)localView;
    if (((ContactResetBaseLayout)localObject).getHolderScrollView() != null) {
      ((ContactResetBaseLayout)localObject).getHolderScrollView().scrollToStart();
    }
    ((ContactResetBaseLayout)localObject).setHolderScrollView(this.this$0.mScrollerView);
    ((ContactResetBaseLayout)localObject).setHolderDeleteButton(this.this$0.deleteButton);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactEditItemView.1
 * JD-Core Version:    0.7.0.1
 */