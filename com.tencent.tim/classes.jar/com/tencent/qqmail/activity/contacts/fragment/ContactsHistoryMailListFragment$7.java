package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.readmail.ReadMailFragment;
import com.tencent.qqmail.maillist.fragment.ConvMailListFragment;
import com.tencent.qqmail.maillist.view.MailListItemView;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.mail.cursor.QMSearchCursor;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import moai.fragment.base.BaseFragment;

class ContactsHistoryMailListFragment$7
  implements AdapterView.OnItemClickListener
{
  ContactsHistoryMailListFragment$7(ContactsHistoryMailListFragment paramContactsHistoryMailListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Mail localMail;
    Object localObject;
    if ((paramView instanceof MailListItemView))
    {
      localMail = ContactsHistoryMailListFragment.access$200(this.this$0).getItem(paramInt);
      if ((localMail != null) || (localMail.getStatus().isConversation())) {
        if (ContactsHistoryMailListFragment.access$200(this.this$0).isLocalItem(paramInt))
        {
          localObject = new ConvMailListFragment(localMail.getInformation().getAccountId(), localMail.getInformation().getFolderId(), localMail.getInformation().getId(), ContactsHistoryMailListFragment.access$1600(this.this$0).getItemIds());
          this.this$0.startFragment((BaseFragment)localObject);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      localObject = new ConvMailListFragment(localMail.getInformation().getAccountId(), 110, localMail.getInformation().getId(), ContactsHistoryMailListFragment.access$1600(this.this$0).getItemIds());
      break;
      localObject = new ReadMailFragment(localMail.getInformation().getAccountId(), localMail.getInformation().getFolderId(), localMail.getInformation().getId(), ContactsHistoryMailListFragment.access$1700(this.this$0), ContactsHistoryMailListFragment.access$1600(this.this$0).getItemIdsInFuture());
      ((ReadMailFragment)localObject).reuseMailData(localMail);
      break;
      if (!ContactsHistoryMailListFragment.access$100(this.this$0))
      {
        ContactsHistoryMailListFragment.access$102(this.this$0, true);
        ContactsHistoryMailListFragment.access$200(this.this$0).setMoreLoading(true);
        ContactsHistoryMailListFragment.access$200(this.this$0).getCursor().loadMore();
        ContactsHistoryMailListFragment.access$200(this.this$0).notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsHistoryMailListFragment.7
 * JD-Core Version:    0.7.0.1
 */