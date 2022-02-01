package com.tencent.qqmail.activity.contacts.fragment;

import android.content.Context;
import android.widget.ListView;
import com.tencent.qqmail.maillist.view.MailListMoreItemView;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.mail.cursor.QMSearchCursor;
import com.tencent.qqmail.search.fragment.SearchListAdapter;

public class ContactsHistoryMailListAdapter
  extends SearchListAdapter
{
  public ContactsHistoryMailListAdapter(Context paramContext, int paramInt, IMailListCursor paramIMailListCursor, ListView paramListView)
  {
    super(paramContext, paramInt, paramIMailListCursor, paramListView);
  }
  
  public int getCount()
  {
    int j = 0;
    if (this.mSearchCursor == null) {
      return 0;
    }
    int i;
    if (!this.mSearchCursor.canLoadMore())
    {
      i = j;
      if (this.mSearchCursor.canSearchRemote())
      {
        i = j;
        if (this.mSearchCursor.getRemoteCount() == 0)
        {
          i = j;
          if (this.mSearchCursor.getLocalCount() != 0) {}
        }
      }
    }
    else
    {
      i = 1;
    }
    return i + this.mSearchCursor.getCount();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt >= this.mSearchCursor.getCount()) {
      return 1;
    }
    return 0;
  }
  
  public void showMoreItemView(boolean paramBoolean, MailListMoreItemView paramMailListMoreItemView)
  {
    if (paramBoolean)
    {
      paramMailListMoreItemView.showTips(2131719320);
      paramMailListMoreItemView.setEnabled(true);
      return;
    }
    if (hasMoreMail())
    {
      paramMailListMoreItemView.showTips(2131719318);
      paramMailListMoreItemView.setEnabled(true);
      return;
    }
    if ((this.mSearchCursor.getRemoteCount() == 0) && (this.mSearchCursor.getLocalCount() == 0)) {
      paramMailListMoreItemView.showTips(2131719319);
    }
    for (;;)
    {
      paramMailListMoreItemView.setEnabled(false);
      return;
      paramMailListMoreItemView.setVisibility(8);
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsHistoryMailListAdapter
 * JD-Core Version:    0.7.0.1
 */