package com.tencent.qqmail.activity.contacts.fragment;

import android.widget.ListView;
import com.tencent.qqmail.utilities.ui.QMSideIndexer;
import com.tencent.qqmail.utilities.ui.QMSideIndexer.QMSideIndexerCallback;

class ContactsListFragment$13
  implements QMSideIndexer.QMSideIndexerCallback
{
  ContactsListFragment$13(ContactsListFragment paramContactsListFragment) {}
  
  public void touchedSideIndexer(QMSideIndexer paramQMSideIndexer, int paramInt, String paramString)
  {
    if (ContactsListFragment.access$200(this.this$0) == 0) {}
    for (paramInt = ContactsListFragment.access$1200(this.this$0).getPositionForSection(paramInt - ContactsListFragment.access$400(this.this$0).getHeaderViewsCount()); (paramInt < 0) || (paramInt >= ContactsListFragment.access$1200(this.this$0).getCount()); paramInt = ContactsListFragment.access$1200(this.this$0).getPositionForSection(paramInt))
    {
      ContactsListFragment.access$400(this.this$0).setSelection(0);
      return;
    }
    ContactsListFragment.access$400(this.this$0).setSelection(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment.13
 * JD-Core Version:    0.7.0.1
 */