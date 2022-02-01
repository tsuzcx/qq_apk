package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.ftn.Ftn.ItemOutputStoreFile;
import com.tencent.qqmail.ftn.Ftn.StoreFileOutput;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Observable;

class ReadMailFragment$3
  extends IObserver
{
  ReadMailFragment$3(ReadMailFragment paramReadMailFragment, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    QMLog.log(4, "ReadMailFragment", "Ftn save file success called");
    int i2;
    int i1;
    int n;
    int k;
    int i;
    int m;
    int i4;
    if (paramObject != null)
    {
      paramObservable = (StoreFileOutput)((HashMap)paramObject).get("paramsavefileinfo");
      i2 = 0;
      i1 = 0;
      n = 0;
      k = 0;
      if ((paramObservable == null) || (paramObservable.itemlist == null)) {
        break label610;
      }
      int i6 = paramObservable.itemlist.size();
      i = 0;
      j = 0;
      k = 0;
      m = 0;
      n = 0;
      i1 = 0;
      if (i1 < paramObservable.itemlist.size())
      {
        i2 = ((ItemOutputStoreFile)paramObservable.itemlist.get(i1)).ret;
        int i5;
        if (i2 == 0)
        {
          i5 = i + 1;
          i4 = j;
          i3 = k;
          i2 = n;
        }
        for (;;)
        {
          i1 += 1;
          n = i2;
          k = i3;
          j = i4;
          i = i5;
          break;
          if ((i2 == -106) || (i2 == -109))
          {
            i3 = k + 1;
            i2 = n;
            i4 = j;
            i5 = i;
          }
          else if ((i2 == -99) || (i2 == -107))
          {
            i2 = n + 1;
            i3 = k;
            i4 = j;
            i5 = i;
          }
          else if (i2 == -103)
          {
            int i7 = m + 1;
            i2 = n;
            m = i7;
            i3 = k;
            i4 = j;
            i5 = i;
            if (i1 < ReadMailFragment.access$1300(this.this$0).size())
            {
              ((MailBigAttach)ReadMailFragment.access$1300(this.this$0).get(i1)).setExpire(-2L);
              QMAttachManager.sharedInstance().updateBigAttachExpire(((MailBigAttach)ReadMailFragment.access$1300(this.this$0).get(i1)).getHashId(), -2L);
              i2 = n;
              m = i7;
              i3 = k;
              i4 = j;
              i5 = i;
            }
          }
          else
          {
            QMLog.log(4, "ReadMailFragment", "save ftn other fail:" + i2);
            i4 = j + 1;
            i2 = n;
            i3 = k;
            i5 = i;
          }
        }
      }
      int i3 = n;
      i4 = m;
      m = i6;
      i2 = i;
      i1 = j;
      n = k;
      k = i3;
    }
    for (int j = i4;; j = 0)
    {
      if (i2 == m)
      {
        i = 0;
        QMLog.log(4, "ReadMailFragment", "save ftn total:" + m + ", success:" + i2 + ", fail:" + i1 + ", overCapacity:" + k + ", exist:" + n + ", delete:" + j + ", retCode:" + i);
      }
      for (;;)
      {
        Threads.runOnMainThread(new ReadMailFragment.3.1(this, j));
        ReadMailFragment.access$1700(this.this$0, new ReadMailFragment.3.2(this, i));
        return;
        if (i1 == m)
        {
          i = 1;
          break;
        }
        if (k > 0)
        {
          i = 6;
          break;
        }
        if (m == n)
        {
          i = 2;
          break;
        }
        if (m == j)
        {
          i = 4;
          break;
        }
        if ((i1 > 0) || (j > 0))
        {
          i = 3;
          break;
        }
        i = 0;
        break;
        i = 1;
        j = 0;
      }
      label610:
      m = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.3
 * JD-Core Version:    0.7.0.1
 */