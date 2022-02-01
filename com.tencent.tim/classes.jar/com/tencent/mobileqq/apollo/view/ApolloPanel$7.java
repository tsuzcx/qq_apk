package com.tencent.mobileqq.apollo.view;

import acbb;
import acbg;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ApolloPanel$7
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "func updateLastApolloPanel begins. Thread id = " + Thread.currentThread().getId());
    }
    if (this.this$0.wW == null) {}
    acbg localacbg;
    do
    {
      return;
      localacbg = (acbg)this.this$0.wW.get(0);
    } while ((this.this$0.mBaseChatPie == null) || (!(localacbg instanceof acbb)));
    if (localacbg.awS == 2) {
      localacbg.awS = 0;
    }
    ((acbb)localacbg).h(this.this$0.mBaseChatPie.app, this.this$0.g);
    this.this$0.notifyDataChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.7
 * JD-Core Version:    0.7.0.1
 */