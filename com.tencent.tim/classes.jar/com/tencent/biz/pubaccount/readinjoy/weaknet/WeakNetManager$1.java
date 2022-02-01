package com.tencent.biz.pubaccount.readinjoy.weaknet;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import kxm;
import kxm.b;
import nxs;
import nxt;
import org.json.JSONException;

public class WeakNetManager$1
  implements Runnable
{
  public WeakNetManager$1(nxt paramnxt, long paramLong) {}
  
  public void run()
  {
    nxt.a(this.this$0, null);
    if (nxs.Go())
    {
      QQToast.a(BaseApplicationImpl.sApplication, 1, 2131718571, 1).show();
      try
      {
        nxs.C("0X8009D08", kxm.a().a("loading_time", String.valueOf(this.uG)).build());
        QLog.d("WeakNetManager", 1, "show weak net toast.");
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("WeakNetManager", 1, "show weak net data report exception, e = ", localJSONException);
        }
      }
    }
    QLog.d("WeakNetManager", 1, "no need to show toast.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.weaknet.WeakNetManager.1
 * JD-Core Version:    0.7.0.1
 */