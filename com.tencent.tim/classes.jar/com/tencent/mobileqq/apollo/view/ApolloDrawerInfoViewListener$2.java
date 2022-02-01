package com.tencent.mobileqq.apollo.view;

import abqt;
import abrc;
import abrs;
import abzf;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ApolloDrawerInfoViewListener$2
  implements Runnable
{
  public ApolloDrawerInfoViewListener$2(abzf paramabzf, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    try
    {
      if ((this.vf) && (this.val$data != null))
      {
        if (abzf.a(this.this$0).get() == null) {
          return;
        }
        Object localObject2 = (ArrayList)this.val$data;
        if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
        {
          Object localObject1 = (abrs)abzf.a(this.this$0).get();
          abqt localabqt = ((abrs)localObject1).a();
          localObject1 = ((abrs)localObject1).a();
          if ((localabqt != null) && (localObject1 != null))
          {
            localObject2 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              String str = (String)((Iterator)localObject2).next();
              if (str.equals(((abrc)localObject1).mSelfUin)) {
                localabqt.bv(str, true);
              }
            }
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloDrawerInfoViewListener", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloDrawerInfoViewListener.2
 * JD-Core Version:    0.7.0.1
 */