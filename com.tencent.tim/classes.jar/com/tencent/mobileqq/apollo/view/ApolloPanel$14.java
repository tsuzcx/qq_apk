package com.tencent.mobileqq.apollo.view;

import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.widget.QQToast;

class ApolloPanel$14
  implements Runnable
{
  public void run()
  {
    if ((this.this$0.mBaseChatPie != null) && (this.this$0.mBaseChatPie.mContext != null)) {
      QQToast.a(this.this$0.mBaseChatPie.mContext, 2, this.val$tips, 1).show(this.cuo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.14
 * JD-Core Version:    0.7.0.1
 */