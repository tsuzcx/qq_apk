package com.tencent.mobileqq.apollo.view;

import abin;
import abqt;
import abrj;
import acbh;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ChatApolloViewListener$2
  implements Runnable
{
  public ChatApolloViewListener$2(acbh paramacbh, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.fj == null) {
        return;
      }
      Object localObject2 = (BaseChatPie)this.this$0.fj.get();
      if ((localObject2 != null) && (((BaseChatPie)localObject2).sessionInfo != null) && (((BaseChatPie)localObject2).app != null) && (((BaseChatPie)localObject2).a != null) && (((BaseChatPie)localObject2).a.Yo()) && (this.vf) && (this.val$data != null))
      {
        Object localObject1 = (ArrayList)this.val$data;
        if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
        {
          localObject2 = abrj.a(((BaseChatPie)localObject2).app);
          if (localObject2 != null)
          {
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((abqt)localObject2).bv((String)((Iterator)localObject1).next(), true);
            }
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ChatApolloViewListener", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ChatApolloViewListener.2
 * JD-Core Version:    0.7.0.1
 */