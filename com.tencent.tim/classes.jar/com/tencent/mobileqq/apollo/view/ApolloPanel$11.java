package com.tencent.mobileqq.apollo.view;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ApolloPanel$11
  implements Runnable
{
  ApolloPanel$11(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.wW != null) && (this.this$0.il != null) && (this.this$0.b != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "func showGameViewOnly begins. Thread id = " + Thread.currentThread().getId());
      }
      this.this$0.a.notifyDataSetChanged();
      this.this$0.wW.clear();
      this.this$0.wW.add(this.this$0.c);
      ApolloPanel.a(this.this$0);
      this.this$0.a.iA(this.this$0.wW);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.11
 * JD-Core Version:    0.7.0.1
 */