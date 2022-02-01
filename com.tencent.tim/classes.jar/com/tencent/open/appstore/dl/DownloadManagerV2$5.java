package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import arvv;
import asab;
import asab.a;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManagerV2$5
  implements Runnable
{
  public DownloadManagerV2$5(arvv paramarvv) {}
  
  public void run()
  {
    ConcurrentHashMap localConcurrentHashMap = asab.a().F();
    if (localConcurrentHashMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = localConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        asab.a locala = (asab.a)localConcurrentHashMap.get((String)localIterator.next());
        if (locala != null)
        {
          Object localObject = arvv.a(this.this$0, locala.appid);
          if ((localObject != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject).urlStr)))
          {
            localObject = this.this$0.b(((DownloadInfo)localObject).urlStr);
            if ((localObject != null) && (4 != arvv.access$700(((TMAssistantDownloadTaskInfo)localObject).mState))) {
              asab.a().Xt(locala.key);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.5
 * JD-Core Version:    0.7.0.1
 */