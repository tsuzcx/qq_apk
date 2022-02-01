package com.tencent.biz.pubaccount.readinjoy.redpacket.mvp;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import meg.a;
import meg.b;
import mer;

public class RIJRedPacketProgressPresenter$1
  implements Runnable
{
  public RIJRedPacketProgressPresenter$1(mer parammer, String paramString, int paramInt) {}
  
  public void run()
  {
    if (mer.a(this.this$0) != null) {
      if (!this.Vw.equals(mer.a(this.this$0).jF())) {
        break label552;
      }
    }
    label552:
    for (int i = mer.a(this.this$0).pd();; i = 0)
    {
      int j;
      int k;
      if (((!mer.a(this.this$0).dR(this.Vw)) && (i < mer.a(this.this$0).pf())) || ((!TextUtils.isEmpty(mer.a(this.this$0).jD())) && (mer.a(this.this$0).jD().equals(this.Vw)) && (mer.a(this.this$0).oY() + mer.a(this.this$0).pd() < mer.a(this.this$0).pf())))
      {
        i = mer.a(this.this$0).oU();
        j = mer.a(this.this$0).oT();
        k = mer.a(this.this$0).pe();
        int m = mer.a(this.this$0).pb();
        int n = (j + k - 1) / k;
        if (!this.Vw.equals(mer.a(this.this$0).jF()))
        {
          mer.a(this.this$0).nA(this.Vw);
          mer.a(this.this$0).rF(0);
          mer.a(this.this$0).rE(this.val$type);
        }
        mer.a(this.this$0).rF(mer.a(this.this$0).pd() + 33);
        if (j > i)
        {
          this.this$0.aOM();
          mer.a(this.this$0).setFinishRound(m);
          mer.a(this.this$0).rH(0);
          return;
        }
        if ((j + 33 > n * k) && (n != 0))
        {
          mer.a(this.this$0).rH(j + 33);
          mer.a(this.this$0).setRound(n, m);
          mer.a(this.this$0).setProgress(0.0F);
          long l = NetConnInfoCenter.getServerTimeMillis();
          if (!mer.a(this.this$0, l, l - 33L))
          {
            mer.a(this.this$0).setProgress(0.0F);
            mer.a(this.this$0).rF(0);
            mer.a(this.this$0).rH(0);
          }
        }
      }
      for (;;)
      {
        mer.a(this.this$0).postDelayed(mer.a(this.this$0), 33L);
        return;
        mer.a(this.this$0).rH(j + 33);
        mer.a(this.this$0).setProgress(j % k / k * 100.0F);
        break;
        this.this$0.refresh();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.redpacket.mvp.RIJRedPacketProgressPresenter.1
 * JD-Core Version:    0.7.0.1
 */