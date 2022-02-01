package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.trd.guava.Lists;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class ContactsSelectAdapter
  extends BaseAdapter
{
  protected static ArrayList<MailContact> selectContacts = ;
  protected boolean isEditable = false;
  protected boolean isFromBlackWhiteList = false;
  
  public ContactsSelectAdapter(boolean paramBoolean)
  {
    this.isEditable = paramBoolean;
  }
  
  public ContactsSelectAdapter(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.isEditable = paramBoolean1;
    this.isFromBlackWhiteList = paramBoolean2;
  }
  
  public static void clearSelectContacts()
  {
    if (selectContacts != null) {
      selectContacts.clear();
    }
  }
  
  public static ArrayList<MailContact> getSelectContacts()
  {
    return selectContacts;
  }
  
  protected void addSelectContact(MailContact paramMailContact)
  {
    selectContacts.add(paramMailContact);
  }
  
  public abstract int getCount();
  
  public abstract Object getItem(int paramInt);
  
  public abstract long getItemId(int paramInt);
  
  public abstract View getView(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  protected boolean isContactSelected(MailContact paramMailContact)
  {
    if (selectContacts != null)
    {
      Iterator localIterator = selectContacts.iterator();
      while (localIterator.hasNext()) {
        if (((MailContact)localIterator.next()).getId() == paramMailContact.getId()) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean isEditable()
  {
    return this.isEditable;
  }
  
  public boolean isFromBlackWhiteList()
  {
    return this.isFromBlackWhiteList;
  }
  
  protected void removeSelectContact(MailContact paramMailContact)
  {
    int i;
    if (selectContacts != null)
    {
      i = 0;
      if (i >= selectContacts.size()) {
        break label60;
      }
      if (paramMailContact.getId() != ((MailContact)selectContacts.get(i)).getId()) {
        break label53;
      }
    }
    for (;;)
    {
      if (i != -1) {
        selectContacts.remove(i);
      }
      return;
      label53:
      i += 1;
      break;
      label60:
      i = -1;
    }
  }
  
  public abstract void toggleSelected(View paramView, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsSelectAdapter
 * JD-Core Version:    0.7.0.1
 */