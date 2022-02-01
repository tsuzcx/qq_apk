package com.tencent.qqmail.activity.contacts.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.qqmail.utilities.timer.TextChangeTimer;
import java.util.Locale;

class ContactsListFragment$21
  implements TextWatcher
{
  ContactsListFragment$21(ContactsListFragment paramContactsListFragment) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!ContactsListFragment.access$2600(this.this$0)) {
      return;
    }
    ContactsListFragment.access$2102(this.this$0, paramCharSequence.toString().toLowerCase(Locale.getDefault()));
    ContactsListFragment.access$3500(this.this$0).startTextChangedTimer(new ContactsListFragment.21.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment.21
 * JD-Core Version:    0.7.0.1
 */