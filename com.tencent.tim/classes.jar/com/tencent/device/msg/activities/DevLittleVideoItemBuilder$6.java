package com.tencent.device.msg.activities;

import android.text.TextUtils;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import syw;
import szh;
import szy;

public class DevLittleVideoItemBuilder$6
  implements Runnable
{
  public DevLittleVideoItemBuilder$6(szh paramszh, MessageForDevLittleVideo paramMessageForDevLittleVideo) {}
  
  public void run()
  {
    syw localsyw = (syw)this.this$0.app.getBusinessHandler(51);
    szy localszy = (szy)this.this$0.app.getBusinessHandler(49);
    for (;;)
    {
      synchronized (localszy.cF)
      {
        Iterator localIterator = localszy.cF.entrySet().iterator();
        if (localIterator.hasNext())
        {
          if (((MessageRecord)((Map.Entry)localIterator.next()).getValue()).uniseq != this.a.uniseq) {
            continue;
          }
          i = 1;
          if ((i == 0) && (!TextUtils.isEmpty(this.a.videoFileKey)))
          {
            long l = localsyw.a(this.a.videoFileKey, this.a.fileKey2, 2201);
            localszy.cF.put(Long.valueOf(l), this.a);
          }
          return;
        }
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevLittleVideoItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */