package com.tencent.mobileqq.apollo.sdk;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

final class CmShowRenderView$3
  implements Runnable
{
  CmShowRenderView$3(List paramList) {}
  
  public void run()
  {
    if (!CmShowRenderView.access$100().isEmpty())
    {
      Iterator localIterator = CmShowRenderView.access$100().values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        if (localObject != null)
        {
          localObject = (CmShowRenderView)((WeakReference)localObject).get();
          if (localObject != null) {
            CmShowRenderView.a((CmShowRenderView)localObject, this.hL);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowRenderView.3
 * JD-Core Version:    0.7.0.1
 */