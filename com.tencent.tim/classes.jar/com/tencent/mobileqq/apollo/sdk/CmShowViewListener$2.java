package com.tencent.mobileqq.apollo.sdk;

import absa;
import absb;
import abse;
import absp;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class CmShowViewListener$2
  implements Runnable
{
  public CmShowViewListener$2(absp paramabsp, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    try
    {
      if ((this.vf) && (this.val$data != null))
      {
        if (absp.a(this.this$0).get() == null) {
          return;
        }
        Object localObject2 = (ArrayList)this.val$data;
        if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
        {
          Object localObject1 = (absa)absp.a(this.this$0).get();
          absb localabsb = ((absa)localObject1).a();
          localObject1 = ((absa)localObject1).a();
          if ((localabsb != null) && (localObject1 != null))
          {
            localObject2 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              String str = (String)((Iterator)localObject2).next();
              if (str.equals(((abse)localObject1).mSelfUin)) {
                localabsb.bv(str, true);
              }
            }
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CmShow_ApolloDrawerInfoViewListener", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowViewListener.2
 * JD-Core Version:    0.7.0.1
 */