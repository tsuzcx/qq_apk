package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import aqhq;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import lcr;
import ooz;
import opn;

public class WeishiManager$3
  implements Runnable
{
  public WeishiManager$3(lcr paramlcr, String paramString1, long paramLong, QQMessageFacade paramQQMessageFacade, String paramString2, Map paramMap) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.val$title, this.val$time);
    if (localObject != null) {
      this.a.b((MessageRecord)localObject, lcr.a(this.this$0).getCurrentUin());
    }
    opn.ara = this.dL;
    ooz.i("WSAioLog", "saveLastFeedInfo feedId:" + this.dL + ", title:" + this.val$title);
    try
    {
      long l = Long.parseLong(lcr.a(this.this$0).getCurrentAccountUin());
      localObject = PreferenceManager.getDefaultPreference(lcr.a(this.this$0).getApplication(), l).edit();
      ((SharedPreferences.Editor)localObject).putString("key_weishi_newest_feed_id", this.dL).apply();
      ((SharedPreferences.Editor)localObject).putString("key_weishi_newest_feed_desc", this.val$title).apply();
      ((SharedPreferences.Editor)localObject).putLong("key_weishi_newest_feed_time", this.val$time).apply();
      if (this.ei.containsKey(Integer.valueOf(1)))
      {
        if (this.ei.get(Integer.valueOf(1)) != null)
        {
          aqhq.writeFile((byte[])this.ei.get(Integer.valueOf(1)), this.this$0.jm(), false);
          Log.i("weishi-report", "save map passback length:" + ((byte[])this.ei.get(Integer.valueOf(1))).length);
          Log.d("weishi-report", "save map passback:" + opn.bytesToHexString((byte[])this.ei.get(Integer.valueOf(1))));
        }
      }
      else
      {
        Log.i("weishi-report", "save map passback error, no key 1!");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.d("WeishiManager", 2, localException.getMessage(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager.3
 * JD-Core Version:    0.7.0.1
 */