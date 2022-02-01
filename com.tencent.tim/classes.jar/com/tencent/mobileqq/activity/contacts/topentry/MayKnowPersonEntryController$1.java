package com.tencent.mobileqq.activity.contacts.topentry;

import android.os.Message;
import auru;
import java.util.List;
import zbq;
import zca;

public class MayKnowPersonEntryController$1
  implements Runnable
{
  public MayKnowPersonEntryController$1(zca paramzca) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Auru.removeMessages(2);
    if (this.this$0.jdField_a_of_type_Zbq != null)
    {
      List localList = this.this$0.jdField_a_of_type_Zbq.dj();
      this.this$0.jdField_a_of_type_Auru.removeMessages(1);
      Message.obtain(this.this$0.jdField_a_of_type_Auru, 1, 0, 0, localList).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.MayKnowPersonEntryController.1
 * JD-Core Version:    0.7.0.1
 */