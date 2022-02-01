package com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import nps;

public class RealTimeStyleLoaderHelper$1
  implements Runnable
{
  public RealTimeStyleLoaderHelper$1(nps paramnps, List paramList) {}
  
  public void run()
  {
    try
    {
      Iterator localIterator = this.kz.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        File localFile = new File(nps.a(this.this$0) + "/" + str);
        if ((localFile.exists()) && (localFile.isFile()))
        {
          boolean bool = localFile.delete();
          QLog.d("RealTimeTemplateFactory", 1, "fileName: " + str + "  succ :" + bool);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("RealTimeTemplateFactory", 1, "deleteFile: ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime.RealTimeStyleLoaderHelper.1
 * JD-Core Version:    0.7.0.1
 */