package com.tencent.biz.pubaccount.readinjoy.view.headers;

import android.text.format.DateUtils;
import aqmj;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import nom;

public class ReadInJoyTabTopSearchHeaderController$3
  implements Runnable
{
  public ReadInJoyTabTopSearchHeaderController$3(nom paramnom, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int i = 0;
    if (!DateUtils.isToday(aqmj.bd("search_word_prefix_last_change_hotword_time")))
    {
      aqmj.bn("search_word_prefix_last_change_hotword_time", System.currentTimeMillis());
      aqmj.go(this.this$0.ana, 0);
      aqmj.go(this.this$0.anb, 0);
    }
    AladdinConfig localAladdinConfig = Aladdin.getConfig(204);
    int m;
    int k;
    int j;
    if (localAladdinConfig != null)
    {
      m = localAladdinConfig.getIntegerFromString("search_max_num", 0);
      k = localAladdinConfig.getIntegerFromString("refresh_num_n", 0);
      j = localAladdinConfig.getIntegerFromString("wording_times_m", 0);
      i = localAladdinConfig.getIntegerFromString("later_wording_times_y", 0);
    }
    for (;;)
    {
      if (aqmj.fl(this.this$0.ana) < m)
      {
        if (aqmj.fl(this.this$0.anb) >= k) {
          break label200;
        }
        if ((aqmj.fl(this.this$0.anb) + 1) % j == 0)
        {
          aqmj.go(this.this$0.ana, aqmj.fl(this.this$0.ana) + 1);
          this.this$0.j(true, this.aYr, this.baG);
        }
      }
      for (;;)
      {
        aqmj.go(this.this$0.anb, aqmj.fl(this.this$0.anb) + 1);
        return;
        label200:
        if ((aqmj.fl(this.this$0.anb) + 1 - k) % i == 0)
        {
          aqmj.go(this.this$0.ana, aqmj.fl(this.this$0.ana) + 1);
          this.this$0.j(true, this.aYr, this.baG);
        }
      }
      j = 0;
      k = 0;
      m = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyTabTopSearchHeaderController.3
 * JD-Core Version:    0.7.0.1
 */