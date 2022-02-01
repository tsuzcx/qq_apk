package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.trd.guava.Lists;
import java.util.ArrayList;

class ContactDetailFragment$10
  implements View.OnClickListener
{
  ContactDetailFragment$10(ContactDetailFragment paramContactDetailFragment) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    QMContactManager localQMContactManager = QMContactManager.sharedInstance();
    ArrayList localArrayList = Lists.newArrayList(new MailContact[] { ContactDetailFragment.access$100(this.this$0) });
    if (!ContactDetailFragment.access$100(this.this$0).isVip()) {}
    for (;;)
    {
      localQMContactManager.setVip(localArrayList, bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactDetailFragment.10
 * JD-Core Version:    0.7.0.1
 */