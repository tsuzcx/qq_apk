package com.tencent.qqmail.bottle.fragment;

import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.bottle.controller.BottleBeachController.BottlePickupError;
import com.tencent.qqmail.bottle.controller.BottleBeachController.BottlePickupWatcher;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.bottle.fragment.adapter.BottleBeachAdapter;
import com.tencent.qqmail.bottle.fragment.adapter.BottleBeachWithAdvertiseAdapter;
import com.tencent.qqmail.bottle.model.BottleBeach;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.ui.PtrListView;

class BottleBeachFragment$24
  implements BottleBeachController.BottlePickupWatcher
{
  BottleBeachFragment$24(BottleBeachFragment paramBottleBeachFragment) {}
  
  private void logGainBottle(int paramInt1, int paramInt2, BottleBeach[] paramArrayOfBottleBeach)
  {
    long l1 = System.currentTimeMillis();
    long l2 = BottleBeachFragment.access$1100(this.this$0)[1];
    long l3 = BottleBeachFragment.access$1100(this.this$0)[0];
    long l4 = BottleBeachFragment.access$1100(this.this$0)[1];
    int n;
    int m;
    if (paramArrayOfBottleBeach != null)
    {
      int i1 = paramArrayOfBottleBeach.length;
      int k = 0;
      int j = 0;
      int i = 0;
      n = j;
      m = i;
      if (k < i1)
      {
        if (paramArrayOfBottleBeach[k].getType() == 30) {
          i += 1;
        }
        for (;;)
        {
          k += 1;
          break;
          j += 1;
        }
      }
    }
    else
    {
      n = 0;
      m = 0;
    }
    QMLog.log(4, "BottleBeachFragment", "mPickUpBottleWatcher logGainBottle requestInterval:" + (l2 - l3) + ", responseUsedTime:" + (l1 - l4) + ", errorCode:" + paramInt1 + ", expectedCount:" + paramInt2 + ", appType:" + m + ", webType:" + n);
    BottleBeachFragment.access$1600(this.this$0).logDetailEvent("DetailEvent_Bottle_Gain_Bottle", paramInt1, String.format("app;%s;web;%s", new Object[] { m + "", n + "" }));
    BottleBeachFragment.access$1100(this.this$0)[0] = BottleBeachFragment.access$1100(this.this$0)[1];
  }
  
  public void onErrorInMainThread(QMNetworkError paramQMNetworkError)
  {
    BottleBeachFragment.access$300(this.this$0).onRefreshComplete();
    BottleBeachFragment.access$1500(this.this$0, BottleBeachFragment.access$800(this.this$0).getWrappedAdapter().getBeachBottles());
    StringBuilder localStringBuilder = new StringBuilder().append("requestBeachBottle:error");
    String str;
    int i;
    if (paramQMNetworkError != null)
    {
      str = paramQMNetworkError.toString();
      QMLog.log(6, "BottleBeachFragment", str);
      if (!(paramQMNetworkError instanceof BottleBeachController.BottlePickupError)) {
        break label147;
      }
      i = ((BottleBeachController.BottlePickupError)paramQMNetworkError).expectedCount;
      if (paramQMNetworkError.code != -20001) {
        break label124;
      }
      Toast.makeText(QMApplicationContext.sharedInstance(), 2131690985, 1).show();
    }
    for (;;)
    {
      logGainBottle(paramQMNetworkError.code, i, null);
      return;
      str = "null";
      break;
      label124:
      if ((paramQMNetworkError.code == -20002) || (paramQMNetworkError.code != -20004)) {}
    }
    label147:
    if ((paramQMNetworkError instanceof QMCGIError))
    {
      logGainBottle(((QMCGIError)paramQMNetworkError).appCode, 1, null);
      return;
    }
    logGainBottle(paramQMNetworkError.code, 1, null);
  }
  
  public void onSuccessInMainThread(int paramInt, BottleBeach[] paramArrayOfBottleBeach1, BottleBeach[] paramArrayOfBottleBeach2)
  {
    QMLog.log(4, "BottleBeachFragment", "mPickUpBottleWatcher onSuccessInMainThread");
    BottleBeachFragment.access$1302(this.this$0, paramArrayOfBottleBeach2);
    if ((BottleBeachFragment.access$1300(this.this$0) != null) && (BottleBeachFragment.access$1300(this.this$0).length > 0))
    {
      paramArrayOfBottleBeach2 = BottleBeachFragment.access$1300(this.this$0);
      int j = paramArrayOfBottleBeach2.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfBottleBeach2[i].getType() == 32) {
          DataCollector.logEvent("Event_Bottle_Ad_Show");
        }
        i += 1;
      }
    }
    BottleBeachFragment.access$1402(this.this$0, true);
    BottleBeachFragment.access$1500(this.this$0, BottleBeachFragment.access$1300(this.this$0));
    logGainBottle(0, paramInt, paramArrayOfBottleBeach1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleBeachFragment.24
 * JD-Core Version:    0.7.0.1
 */