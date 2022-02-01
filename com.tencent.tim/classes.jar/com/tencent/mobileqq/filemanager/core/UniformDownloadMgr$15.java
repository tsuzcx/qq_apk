package com.tencent.mobileqq.filemanager.core;

import aglz;
import aglz.a;
import aglz.b;
import ahcj;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UniformDownloadMgr$15
  implements Runnable
{
  public UniformDownloadMgr$15(aglz paramaglz) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject4;
    Object localObject5;
    synchronized (aglz.a(this.this$0))
    {
      if (aglz.a(this.this$0).size() > 0)
      {
        localObject4 = aglz.a(this.this$0).entrySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (aglz.a)((Map.Entry)((Iterator)localObject4).next()).getValue();
          if ((((aglz.a)localObject5).a != null) && (8 == ((aglz.a)localObject5).a.getStatus()) && (2 == ((aglz.a)localObject5).a.getType())) {
            localArrayList.add(localObject5);
          }
        }
      }
    }
    ??? = localObject2.iterator();
    Object localObject3;
    while (((Iterator)???).hasNext())
    {
      localObject3 = (aglz.a)((Iterator)???).next();
      QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>> resumeRuningGenDownloadOfOldApp, url:[" + ((aglz.a)localObject3).mUrl + "]");
      ((aglz.a)localObject3).a.start();
    }
    if (aglz.a(this.this$0))
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot. start resume");
      localObject3 = this.this$0.an();
      this.this$0.dil();
      ??? = new HashMap();
      if ((localObject3 != null) && (((Map)localObject3).size() > 0))
      {
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject5 = (Map.Entry)((Iterator)localObject3).next();
          localObject4 = (String)((Map.Entry)localObject5).getKey();
          localObject5 = (aglz.b)((Map.Entry)localObject5).getValue();
          if (localObject5 != null)
          {
            if (((aglz.b)localObject5).ng)
            {
              ((Map)???).put(localObject4, localObject5);
            }
            else
            {
              QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot, url:[" + (String)localObject4 + "] nId:[" + ((aglz.b)localObject5).cXM + "] - 1");
              aglz.a(this.this$0, (String)localObject4, ((aglz.b)localObject5).fileName, ((aglz.b)localObject5).fileSize, ((aglz.b)localObject5).notifyTitle, ((aglz.b)localObject5).aV, ((aglz.b)localObject5).cXM, true);
            }
          }
          else {
            QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] resumeRuningDownloadPreMobileQQReboot, value error. url:[" + (String)localObject4 + "] -1");
          }
        }
      }
      if (((Map)???).size() > 0)
      {
        ??? = ((Map)???).entrySet().iterator();
        while (((Iterator)???).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)???).next();
          localObject3 = (String)((Map.Entry)localObject4).getKey();
          localObject4 = (aglz.b)((Map.Entry)localObject4).getValue();
          if (localObject4 != null)
          {
            QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot, url:[" + (String)localObject3 + "] nId:[" + ((aglz.b)localObject4).cXM + "] - 2");
            aglz.a(this.this$0, (String)localObject3, ((aglz.b)localObject4).fileName, ((aglz.b)localObject4).fileSize, ((aglz.b)localObject4).notifyTitle, ((aglz.b)localObject4).aV, ((aglz.b)localObject4).cXM, true);
          }
          else
          {
            QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] resumeRuningDownloadPreMobileQQReboot, value error. url:[" + (String)localObject3 + "] -2");
          }
        }
      }
    }
    else
    {
      QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot. not resume");
      this.this$0.dil();
    }
    aglz.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.15
 * JD-Core Version:    0.7.0.1
 */