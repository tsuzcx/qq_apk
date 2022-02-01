package com.tencent.mobileqq.activity.contact.addcontact;

import achg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class AddContactsView$12
  implements Runnable
{
  AddContactsView$12(AddContactsView paramAddContactsView) {}
  
  public void run()
  {
    Object localObject = (achg)this.this$0.app.getManager(159);
    int i = ((achg)localObject).Ay();
    localObject = ((achg)localObject).cv();
    ThreadManager.getUIHandler().post(new AddContactsView.12.1(this, i, (ArrayList)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.12
 * JD-Core Version:    0.7.0.1
 */