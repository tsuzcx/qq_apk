package com.tencent.mobileqq.activity;

import alhr;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.CardHandler;
import java.util.ArrayList;

class VisitorsActivity$9
  implements Runnable
{
  VisitorsActivity$9(VisitorsActivity paramVisitorsActivity) {}
  
  public void run()
  {
    ArrayList localArrayList1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppCardHandler.f(2, 7);
    ArrayList localArrayList2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppCardHandler.f(3, 7);
    if (!this.this$0.isFinishing())
    {
      this.this$0.jdField_a_of_type_Alhr.initData();
      this.this$0.mHandler.obtainMessage(5, 0, 0, new Object[] { localArrayList1, localArrayList2 }).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.9
 * JD-Core Version:    0.7.0.1
 */