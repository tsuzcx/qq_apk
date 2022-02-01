package com.tencent.av.business.manager.pendant;

import igd;
import ikh;
import java.util.ArrayList;
import java.util.Iterator;

public final class AVEffectPendantReport$1
  implements Runnable
{
  public void run()
  {
    if ((ikh.access$000() == null) || (ikh.access$000().isEmpty()))
    {
      ikh.anq();
      return;
    }
    ikh.access$102(0);
    ikh.access$202(0);
    Iterator localIterator = ikh.access$000().iterator();
    while (localIterator.hasNext())
    {
      PendantItem localPendantItem = (PendantItem)localIterator.next();
      ikh.access$108();
      if (ikh.c(localPendantItem)) {
        ikh.access$208();
      }
    }
    igd.aJ("AVEffectPendantReport", "refleshAndSetDownloadInfo()  mTotalCount = " + ikh.access$100() + "  mDownloadCount = " + ikh.access$200());
    ikh.ann();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.AVEffectPendantReport.1
 * JD-Core Version:    0.7.0.1
 */