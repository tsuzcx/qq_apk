package com.tencent.qqmail.activity.contacts.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.qmdomain.ContactEmail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import moai.fragment.app.FragmentActivity;
import moai.fragment.base.BaseFragment;

class ContactsListFragment$15
  implements AdapterView.OnItemClickListener
{
  ContactsListFragment$15(ContactsListFragment paramContactsListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 0;
    Intent localIntent = null;
    Object localObject3 = null;
    int j;
    if (!ContactsListFragment.access$2600(this.this$0))
    {
      if (ContactsListFragment.access$1200(this.this$0) == null) {
        break label533;
      }
      j = paramInt - ContactsListFragment.access$400(this.this$0).getHeaderViewsCount();
      localObject1 = localObject3;
      if (j >= 0)
      {
        localObject1 = localObject3;
        if (j < ContactsListFragment.access$1200(this.this$0).getCount()) {
          localObject1 = ContactsListFragment.access$1200(this.this$0).getItem(j);
        }
      }
      localObject3 = localObject1;
      if (ContactsListFragment.access$2700(this.this$0))
      {
        if (localObject1 != null) {
          ContactsListFragment.access$1200(this.this$0).toggleSelected(paramView, j);
        }
        ContactsListFragment.access$2800(this.this$0);
      }
    }
    else
    {
      for (;;)
      {
        EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
        if (ContactsListFragment.access$2900(this.this$0) == null) {
          break label533;
        }
        j = paramInt - ContactsListFragment.access$2500(this.this$0).getHeaderViewsCount();
        localObject1 = localIntent;
        if (j >= 0)
        {
          localObject1 = localIntent;
          if (j < ContactsListFragment.access$2900(this.this$0).getCount()) {
            localObject1 = ContactsListFragment.access$2900(this.this$0).getItem(j);
          }
        }
        localObject3 = localObject1;
        if (!ContactsListFragment.access$2700(this.this$0)) {
          break;
        }
        if (localObject1 != null) {
          ContactsListFragment.access$2900(this.this$0).toggleSelected(paramView, j);
        }
        ContactsListFragment.access$2800(this.this$0);
      }
    }
    Object localObject1 = localObject3;
    label248:
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        if (ContactsListFragment.access$200(this.this$0) != 5) {
          break label409;
        }
        localIntent = new Intent();
        if (((MailContact)localObject1).getEmails() == null) {
          break label387;
        }
        localObject3 = new String[((MailContact)localObject1).getEmails().size()];
        if (i >= ((MailContact)localObject1).getEmails().size()) {
          break label539;
        }
        localObject3[i] = ((ContactEmail)((MailContact)localObject1).getEmails().get(i)).getEmail();
        i += 1;
        continue;
        localIntent.putExtra("result_select_contact_emails", (String[])localObject1);
        this.this$0.getActivity().setResult(-1, localIntent);
        this.this$0.popBackStack();
      }
      catch (Exception localException)
      {
        QMLog.log(6, "ContactsListFragment", Log.getStackTraceString(localException));
      }
      break;
      label387:
      localObject3 = new String[1];
      localObject3[0] = localException.getAddress();
      Object localObject2 = localObject3;
      continue;
      label409:
      if ((ContactsListFragment.access$200(this.this$0) == 4) && (ContactsListFragment.access$3000(this.this$0) != null))
      {
        localObject2 = QMContactManager.sharedInstance().getContactById(((MailContact)localObject2).getId());
        localObject2 = new ContactEditFragment((MailContact)localObject2, (MailContact)QMContactManager.sharedInstance().mergeContactsInfo((MailContact)localObject2, ContactsListFragment.access$3000(this.this$0)).get(0), false, 1);
        this.this$0.startFragmentForResult((BaseFragment)localObject2, 100);
        break;
      }
      localObject2 = new ContactDetailFragment(((MailContact)localObject2).getId(), ((MailContact)localObject2).getAccountId(), ((MailContact)localObject2).getAddress(), ((MailContact)localObject2).getName());
      this.this$0.startFragment((BaseFragment)localObject2);
      break;
      label533:
      localObject2 = null;
      break label248;
      break;
      label539:
      localObject2 = localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment.15
 * JD-Core Version:    0.7.0.1
 */