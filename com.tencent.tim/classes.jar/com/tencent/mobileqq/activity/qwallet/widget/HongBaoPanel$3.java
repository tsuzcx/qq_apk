package com.tencent.mobileqq.activity.qwallet.widget;

import aadn;
import aagc;
import android.view.View;
import android.view.View.OnClickListener;
import aqmr;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class HongBaoPanel$3
  implements View.OnClickListener
{
  HongBaoPanel$3(HongBaoPanel paramHongBaoPanel) {}
  
  public void onClick(View paramView)
  {
    try
    {
      aadn localaadn = (aadn)paramView.getTag();
      if (localaadn == null)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        String str = null;
        continue;
        switch (str.type)
        {
        default: 
          break;
        case 100: 
          if (str.params != null)
          {
            str = str.params.optString("url");
            if (!aqmr.isEmpty(str)) {
              aagc.N(this.this$0.mContext, str);
            }
          }
          break;
        case 101: 
          HongBaoPanel.access$200(this.this$0);
          break;
        case 102: 
          str = str.params.optString("url");
          if (!aqmr.isEmpty(str)) {
            aagc.N(this.this$0.mContext, str);
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel.3
 * JD-Core Version:    0.7.0.1
 */