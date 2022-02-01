package com.tencent.open.downloadnew;

import android.text.TextUtils;
import aroi;
import arxn;
import aryy;
import asab;
import asab.a;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManager$3
  implements Runnable
{
  public DownloadManager$3(aryy paramaryy) {}
  
  public void run()
  {
    Object localObject1 = arxn.getCurProcessName(aroi.a().getContext());
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).contains(":")))
    {
      localObject1 = asab.a().F();
      if (localObject1 != null)
      {
        Iterator localIterator = ((ConcurrentHashMap)localObject1).keySet().iterator();
        while (localIterator.hasNext())
        {
          asab.a locala = (asab.a)((ConcurrentHashMap)localObject1).get((String)localIterator.next());
          if (locala != null)
          {
            Object localObject2 = this.this$0.c(locala.appid);
            if ((localObject2 != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject2).urlStr)))
            {
              localObject2 = this.this$0.b(((DownloadInfo)localObject2).urlStr);
              if ((localObject2 != null) && (4 != aryy.kO(((TMAssistantDownloadTaskInfo)localObject2).mState))) {
                asab.a().Xt(locala.key);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.3
 * JD-Core Version:    0.7.0.1
 */