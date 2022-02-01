package com.tencent.mobileqq.activity.contact.addcontact;

import acfp;
import com.tencent.mobileqq.widget.FormMutiWithAvatarItem;
import java.util.ArrayList;

class AddContactsView$12$1
  implements Runnable
{
  AddContactsView$12$1(AddContactsView.12 param12, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((AddContactsView.a(this.a.this$0) == null) || (this.cac == 0) || (this.ef == null) || (this.ef.isEmpty())) {}
    FormMutiWithAvatarItem localFormMutiWithAvatarItem;
    do
    {
      do
      {
        return;
      } while (!(this.a.this$0.i instanceof FormMutiWithAvatarItem));
      localFormMutiWithAvatarItem = (FormMutiWithAvatarItem)this.a.this$0.i;
      if (!localFormMutiWithAvatarItem.aGw()) {
        localFormMutiWithAvatarItem.setOverloading();
      }
      if (this.cac != 0) {
        localFormMutiWithAvatarItem.setPeopleText(this.cac + acfp.m(2131702039));
      }
    } while ((this.ef == null) || (this.ef.size() <= 0));
    String[] arrayOfString = new String[this.ef.size()];
    int i = 0;
    while (i < this.ef.size())
    {
      arrayOfString[i] = ((String)this.ef.get(i));
      i += 1;
    }
    localFormMutiWithAvatarItem.setOverimgLayout(24, 24, arrayOfString, AddContactsView.a(this.a.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.12.1
 * JD-Core Version:    0.7.0.1
 */