package com.tencent.biz.subscribe.utils;

import android.text.TextUtils;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import oba;
import shg;
import shg.a;

public class SubscribeDraftManager$2
  implements Runnable
{
  public SubscribeDraftManager$2(shg paramshg, String paramString, shg.a parama) {}
  
  public void run()
  {
    Object localObject1 = new File(shg.a(this.this$0) + Md5Utils.getMD5(this.val$uin));
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      QLog.d(shg.TAG, 4, "qureyAllSimpleDraft count:" + localObject1.length);
      localArrayList = new ArrayList();
      j = localObject1.length;
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label181;
        }
        localObject2 = localObject1[i];
        try
        {
          localObject2 = shg.a(this.this$0, ((File)localObject2).getAbsolutePath());
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = (SubscribeDraftBean)oba.a().fromJson((String)localObject2, SubscribeDraftBean.class);
            if (localObject2 != null) {
              localArrayList.add(localObject2);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.d(shg.TAG, 4, "readString failed:");
          }
        }
        i += 1;
      }
      label181:
      Collections.sort(localArrayList);
      if (!localArrayList.isEmpty()) {
        if (this.a != null) {
          this.a.b(4, true, "", new Object[] { localArrayList });
        }
      }
    }
    while (this.a == null)
    {
      ArrayList localArrayList;
      int j;
      int i;
      Object localObject2;
      do
      {
        return;
      } while (this.a == null);
      this.a.b(4, false, "", null);
      return;
    }
    this.a.b(4, false, "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.2
 * JD-Core Version:    0.7.0.1
 */