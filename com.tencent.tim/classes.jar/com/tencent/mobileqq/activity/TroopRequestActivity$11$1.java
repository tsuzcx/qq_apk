package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Message;
import apyg;
import apyh;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;
import wcq;

public class TroopRequestActivity$11$1
  implements Runnable
{
  public TroopRequestActivity$11$1(wcq paramwcq, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    apyg localapyg = apyh.a(BaseApplication.getContext()).a(this.a.this$0, Long.toString(this.e.dwGroupClassExt));
    if (localapyg != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = localapyg.BD();
      this.a.this$0.bP.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.11.1
 * JD-Core Version:    0.7.0.1
 */