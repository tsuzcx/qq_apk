package com.tencent.qqmail.activity.contacts.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;

class ContactAddItemView$1
  implements View.OnClickListener
{
  ContactAddItemView$1(ContactAddItemView paramContactAddItemView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.this$0.getParent();
    int i;
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof ContactTableView)))
    {
      localObject1 = (ContactTableView)localObject1;
      i = ((ContactTableView)localObject1).indexOfChild(this.this$0);
      if (i != -1)
      {
        if (this.this$0.itemType != ContactBaseItemView.ContactItemType.TYPE_EMAIL) {
          break label127;
        }
        localObject2 = new ContactEditItemView(this.this$0.context);
        ((ContactEditItemView)localObject2).setItemType(ContactBaseItemView.ContactItemType.TYPE_EMAIL);
        ((ContactEditItemView)localObject2).setNodeLabel(2131692036);
        ((ContactEditItemView)localObject2).setNodeValueOperateCallback(this.this$0.contactItemViewOperateCallback);
        ((ContactEditItemView)localObject2).setNodeInputText("");
        ((ContactTableView)localObject1).addView((View)localObject2, i);
        ContactUIHelper.startAddItemAnimation((View)localObject2, null);
      }
    }
    for (;;)
    {
      KeyBoardHelper.showKeyBoard(0, 1);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label127:
      if (this.this$0.itemType == ContactBaseItemView.ContactItemType.TYPE_TEL)
      {
        localObject2 = new ContactEditItemView(this.this$0.context);
        ((ContactEditItemView)localObject2).setItemType(ContactBaseItemView.ContactItemType.TYPE_TEL);
        ((ContactEditItemView)localObject2).setNodeLabel(2131692086);
        ((ContactEditItemView)localObject2).setNodeValueOperateCallback(this.this$0.contactItemViewOperateCallback);
        ((ContactEditItemView)localObject2).setNodeInputText("");
        ((ContactTableView)localObject1).addView((View)localObject2, i);
        ContactUIHelper.startAddItemAnimation((View)localObject2, null);
      }
      else if (this.this$0.itemType == ContactBaseItemView.ContactItemType.TYPE_ADDRESS)
      {
        localObject2 = new ContactEditItemView(this.this$0.context);
        ((ContactEditItemView)localObject2).setItemType(ContactBaseItemView.ContactItemType.TYPE_ADDRESS);
        ((ContactEditItemView)localObject2).setNodeLabel(2131692009);
        ((ContactEditItemView)localObject2).setNodeInputText("");
        ((ContactEditItemView)localObject2).setNodeValueOperateCallback(this.this$0.contactItemViewOperateCallback);
        ((ContactTableView)localObject1).addView((View)localObject2, i);
        ContactUIHelper.startAddItemAnimation((View)localObject2, null);
      }
      else if (this.this$0.itemType == ContactBaseItemView.ContactItemType.TYPE_CUSTOM)
      {
        localObject2 = new ContactCustomItemView(this.this$0.context);
        ((ContactCustomItemView)localObject2).setItemType(ContactBaseItemView.ContactItemType.TYPE_CUSTOM);
        ((ContactCustomItemView)localObject2).setCustomKeyInputText("");
        ((ContactCustomItemView)localObject2).setCustomValueInputText("");
        ((ContactCustomItemView)localObject2).setNodeValueOperateCallback(this.this$0.contactItemViewOperateCallback);
        ((ContactTableView)localObject1).addView((View)localObject2, i);
        ContactUIHelper.startAddItemAnimation((View)localObject2, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactAddItemView.1
 * JD-Core Version:    0.7.0.1
 */