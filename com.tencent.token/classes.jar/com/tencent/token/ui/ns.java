package com.tencent.token.ui;

import android.os.Handler;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.token.cg;
import com.tencent.token.ui.base.bw;

class ns
  implements bw
{
  private ns(LoginMsgReportLocationActivity paramLoginMsgReportLocationActivity) {}
  
  public void a(int paramInt)
  {
    String[] arrayOfString = cg.a().f;
    int[] arrayOfInt = cg.a().g;
    if (paramInt < arrayOfString.length)
    {
      LoginMsgReportLocationActivity.access$700(this.a).setSelection(arrayOfInt[paramInt]);
      LoginMsgReportLocationActivity.access$800(this.a).setText(arrayOfString[paramInt]);
      LoginMsgReportLocationActivity.access$800(this.a).setVisibility(0);
      this.a.mHandler.removeCallbacks(LoginMsgReportLocationActivity.access$900(this.a));
      this.a.mHandler.postDelayed(LoginMsgReportLocationActivity.access$900(this.a), 1500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ns
 * JD-Core Version:    0.7.0.1
 */