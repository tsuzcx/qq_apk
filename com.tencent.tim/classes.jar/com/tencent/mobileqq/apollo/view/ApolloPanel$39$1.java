package com.tencent.mobileqq.apollo.view;

import acav;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;

public class ApolloPanel$39$1
  implements Runnable
{
  public ApolloPanel$39$1(acav paramacav) {}
  
  public void run()
  {
    if ((this.a.this$0.mBaseChatPie != null) && (this.a.this$0.mBaseChatPie.app != null))
    {
      ApolloPanel.b(this.a.this$0, true);
      this.a.this$0.Dk(this.a.this$0.mBaseChatPie.app.getCurrentUin());
      ApolloPanel.b(this.a.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.39.1
 * JD-Core Version:    0.7.0.1
 */