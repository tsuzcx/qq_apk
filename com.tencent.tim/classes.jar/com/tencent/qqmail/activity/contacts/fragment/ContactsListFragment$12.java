package com.tencent.qqmail.activity.contacts.fragment;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import com.tencent.qqmail.utilities.ui.QMListPopupWindow;
import org.apache.commons.lang3.StringUtils;

class ContactsListFragment$12
  extends QMListPopupWindow
{
  ContactsListFragment$12(ContactsListFragment paramContactsListFragment, Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
  }
  
  public void onListItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((TextView)paramView.findViewById(2131373495)).getText().toString();
    if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131692000))) {
      this.this$0.startFragmentForResult(new ContactEditFragment(), 200);
    }
    while (!StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131692052))) {
      return;
    }
    this.this$0.startFragment(new ContactsMergeFragment());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment.12
 * JD-Core Version:    0.7.0.1
 */