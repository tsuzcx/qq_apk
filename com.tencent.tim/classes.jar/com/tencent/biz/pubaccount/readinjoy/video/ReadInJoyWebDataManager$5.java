package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import aprb.a;
import aprc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kxm;
import mqq.manager.TicketManager;
import msg;
import msg.b;
import msh;
import org.json.JSONObject;

public class ReadInJoyWebDataManager$5
  implements Runnable
{
  public ReadInJoyWebDataManager$5(msg parammsg, String paramString1, String paramString2, msg.b paramb, JSONObject paramJSONObject) {}
  
  public void run()
  {
    try
    {
      Object localObject3 = (QQAppInterface)kxm.getAppRuntime();
      if (localObject3 == null) {
        return;
      }
      Object localObject1 = new Bundle();
      TicketManager localTicketManager = (TicketManager)((QQAppInterface)localObject3).getManager(2);
      Object localObject2 = ((QQAppInterface)localObject3).getAccount();
      localObject3 = localTicketManager.getSkey(((QQAppInterface)localObject3).getCurrentAccountUin());
      ((Bundle)localObject1).putString("Cookie", "uin=o" + (String)localObject2 + "; skey=" + (String)localObject3);
      ((Bundle)localObject1).putString("User-Agent", msg.access$500());
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("BUNDLE", localObject1);
      ((HashMap)localObject2).put("CONTEXT", BaseApplicationImpl.getApplication());
      if (QLog.isColorLevel()) {
        QLog.w("ReadInJoyWebDataManager", 2, "doSendRequestWithExtraHeader:url :" + this.val$url);
      }
      localObject1 = new msh(this);
      new aprc(this.val$url, "GET", (aprb.a)localObject1, 0, null).executeOnExecutor(ThreadManagerV2.getNetExcutor(), new HashMap[] { localObject2 });
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ReadInJoyWebDataManager", 2, "doSendRequestWithExtraHeader:request err " + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager.5
 * JD-Core Version:    0.7.0.1
 */