package com.tencent.qqmail.activity.contacts.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactCustomItemView$1
  implements View.OnClickListener
{
  ContactCustomItemView$1(ContactCustomItemView paramContactCustomItemView) {}
  
  public void onClick(View paramView)
  {
    ContactCustomItemView.access$000(this.this$0).scrollToEnd();
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
    ((ContactResetBaseLayout)localObject).setHolderScrollView(ContactCustomItemView.access$000(this.this$0));
    ((ContactResetBaseLayout)localObject).setHolderDeleteButton(ContactCustomItemView.access$100(this.this$0));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactCustomItemView.1
 * JD-Core Version:    0.7.0.1
 */