package com.tencent.qqmail.attachment.util;

import android.os.Handler;
import com.tencent.qqmail.ftn.Ftn.ItemOutputStoreFile;
import com.tencent.qqmail.ftn.Ftn.StoreFileOutput;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Observable;

class AttachOperateMore$1
  extends IObserver
{
  AttachOperateMore$1(AttachOperateMore paramAttachOperateMore, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    QMLog.log(4, "AttachOperateMore", "Ftn save file success called");
    int i;
    int i2;
    int i1;
    int n;
    int m;
    int k;
    if (paramObject != null)
    {
      paramObservable = (StoreFileOutput)((HashMap)paramObject).get("paramsavefileinfo");
      i = 0;
      int i3 = 0;
      int i4 = 0;
      int i5 = 0;
      int i6 = 0;
      int i7 = 0;
      i2 = i;
      i1 = i7;
      n = i6;
      m = i5;
      k = i4;
      int j = i3;
      if (paramObservable != null)
      {
        i2 = i;
        i1 = i7;
        n = i6;
        m = i5;
        k = i4;
        j = i3;
        if (paramObservable.itemlist != null)
        {
          i2 = paramObservable.itemlist.size();
          i = 0;
          j = 0;
          k = 0;
          m = 0;
          n = 0;
          i1 = 0;
          if (i1 < paramObservable.itemlist.size())
          {
            i3 = ((ItemOutputStoreFile)paramObservable.itemlist.get(i1)).ret;
            if (i3 == 0) {
              i += 1;
            }
            for (;;)
            {
              i1 += 1;
              break;
              if ((i3 == -106) || (i3 == -109))
              {
                k += 1;
              }
              else if ((i3 == -99) || (i3 == -107))
              {
                n += 1;
              }
              else if (i3 == -103)
              {
                m += 1;
              }
              else
              {
                QMLog.log(4, "AttachOperateMore", "save ftn other fail:" + i3);
                j += 1;
              }
            }
          }
          i1 = n;
          n = m;
          m = k;
          k = j;
          j = i;
        }
      }
      if (j == i2)
      {
        i = 0;
        QMLog.log(4, "AttachOperateMore", "save ftn total:" + i2 + ", success:" + j + ", fail:" + k + ", overCapacity:" + i1 + ", exist:" + m + ", delete:" + n + ", retCode:" + i);
      }
    }
    for (;;)
    {
      AttachOperateMore.access$000(this.this$0).sendEmptyMessage(i);
      return;
      if (k == i2)
      {
        i = 1;
        break;
      }
      if (i1 > 0)
      {
        i = 6;
        break;
      }
      if (i2 == m)
      {
        i = 2;
        break;
      }
      if (i2 == n)
      {
        i = 4;
        break;
      }
      if ((k > 0) || (n > 0))
      {
        i = 3;
        break;
      }
      i = 0;
      break;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.util.AttachOperateMore.1
 * JD-Core Version:    0.7.0.1
 */