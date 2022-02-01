package com.tencent.mobileqq.apollo.view;

import abxk;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionPackage;
import java.util.Iterator;
import java.util.List;

class ApolloPanel$4
  implements Runnable
{
  ApolloPanel$4(ApolloPanel paramApolloPanel, List paramList) {}
  
  public void run()
  {
    if ((this.this$0.mBaseChatPie != null) && (this.this$0.mBaseChatPie.app != null))
    {
      abxk localabxk = (abxk)this.this$0.mBaseChatPie.app.getManager(155);
      if (localabxk != null)
      {
        Iterator localIterator = this.xa.iterator();
        while (localIterator.hasNext()) {
          localabxk.a((ApolloActionPackage)localIterator.next());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.4
 * JD-Core Version:    0.7.0.1
 */