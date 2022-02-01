package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import apyg;
import apyh;
import java.util.ArrayList;

class TroopClassChoiceActivity$GetClassChoiceCallBack$1
  implements Runnable
{
  TroopClassChoiceActivity$GetClassChoiceCallBack$1(TroopClassChoiceActivity.a parama) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a.a.mId)) {
      this.a.a.pF = apyh.a(this.a.a).dX();
    }
    for (;;)
    {
      TroopClassChoiceActivity.a(this.a.a).notifyDataSetChanged();
      return;
      this.a.a.pF = apyh.a(this.a.a).af(this.a.a.mId);
      if ((this.a.a.pF != null) && (this.a.a.pF.size() > 0))
      {
        apyg localapyg = (apyg)this.a.a.pF.get(0);
        if (localapyg.c != null) {
          this.a.a.setTitle(localapyg.c.name);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopClassChoiceActivity.GetClassChoiceCallBack.1
 * JD-Core Version:    0.7.0.1
 */