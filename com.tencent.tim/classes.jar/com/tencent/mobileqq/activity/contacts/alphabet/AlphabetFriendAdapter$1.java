package com.tencent.mobileqq.activity.contacts.alphabet;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import yyy;

public class AlphabetFriendAdapter$1
  implements Runnable
{
  public AlphabetFriendAdapter$1(yyy paramyyy) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(yyy.a(this.this$0));
      Object[] arrayOfObject = yyy.a(this.this$0, localArrayList, yyy.a(this.this$0));
      ThreadManager.getUIHandler().post(new AlphabetFriendAdapter.1.1(this, localArrayList));
      if ((arrayOfObject == null) || (arrayOfObject.length < 3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AlphabetFriendAdapter", 2, "constructHashStruct result == null!");
        }
        ThreadManager.getUIHandler().post(new AlphabetFriendAdapter.1.2(this));
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AlphabetFriendAdapter", 2, "loadData Exception = " + localException.toString());
          }
        }
      } while (localException.length < 3);
      ThreadManager.getUIHandler().post(new AlphabetFriendAdapter.1.3(this, localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendAdapter.1
 * JD-Core Version:    0.7.0.1
 */