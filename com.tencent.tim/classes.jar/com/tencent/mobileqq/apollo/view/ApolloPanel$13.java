package com.tencent.mobileqq.apollo.view;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ApolloPanel$13
  implements Runnable
{
  public void run()
  {
    if ((this.this$0.wW != null) && (this.this$0.a != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "clear bindList");
      }
      this.this$0.wW.clear();
      this.this$0.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.13
 * JD-Core Version:    0.7.0.1
 */