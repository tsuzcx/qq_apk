package com.tencent.biz.pubaccount.readinjoy.video.multivideo;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import muj;
import nam;
import naq.d;

public class MultiVideoDataManager$1
  implements Runnable
{
  public MultiVideoDataManager$1(nam paramnam, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    int i = this.aXd;
    if ((i < this.aXd + this.val$size) && (i < nam.a(this.this$0).bg().size()))
    {
      localObject = (VideoInfo)nam.a(this.this$0).bg().get(i);
      if ((TextUtils.isEmpty(((VideoInfo)localObject).hH)) || (((VideoInfo)localObject).adB)) {}
      for (;;)
      {
        i += 1;
        break;
        localHashMap.put(((VideoInfo)localObject).hH, localObject);
      }
    }
    Object localObject = localHashMap.keySet().iterator();
    label172:
    label243:
    label244:
    for (;;)
    {
      String str;
      if (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        boolean bool = muj.b(nam.a(this.this$0), Long.valueOf(str).longValue());
        Iterator localIterator = localHashMap.values().iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
          if (localVideoInfo.isFollowed == bool) {
            break label243;
          }
          localVideoInfo.isFollowed = bool;
          i = 1;
        }
      }
      for (;;)
      {
        break label172;
        if (i == 0) {
          break label244;
        }
        nam.a(this.this$0).post(new MultiVideoDataManager.1.1(this, str));
        break;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoDataManager.1
 * JD-Core Version:    0.7.0.1
 */