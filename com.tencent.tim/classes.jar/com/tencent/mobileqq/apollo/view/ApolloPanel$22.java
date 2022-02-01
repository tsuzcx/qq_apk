package com.tencent.mobileqq.apollo.view;

import com.tencent.qphone.base.util.QLog;

class ApolloPanel$22
  implements Runnable
{
  ApolloPanel$22(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.wW != null) && (this.this$0.r != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "refreshPanel. Thread id = " + Thread.currentThread().getId());
      }
      this.this$0.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.22
 * JD-Core Version:    0.7.0.1
 */