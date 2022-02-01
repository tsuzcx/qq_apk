package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import jqc;
import kxm;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import msg;
import ndi;
import nrl.a;
import org.json.JSONObject;

public final class FastWebRequestUtil$7
  implements Runnable
{
  public FastWebRequestUtil$7(ArticleInfo paramArticleInfo, nrl.a parama) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        str2 = kxm.getAccount();
        str3 = ((TicketManager)((QQAppInterface)kxm.getAppRuntime()).getManager(2)).getSkey(str2);
        localBundle = new Bundle();
        localBundle.putString("type", "1");
        localBundle.putString("uin", String.valueOf(this.d.publishUin));
        if (ndi.P(this.d)) {
          break label348;
        }
        if (!ndi.ak(this.d)) {
          break label355;
        }
      }
      catch (Exception localException)
      {
        String str2;
        String str3;
        Bundle localBundle;
        Object localObject;
        int i;
        if (this.a == null) {
          continue;
        }
        ThreadManager.getUIHandler().post(new FastWebRequestUtil.7.2(this, localException));
        QLog.d("FastWebRequestUtil", 2, "shieldFeedSource exception. ", localException);
        return;
      }
      localBundle.putString("accountType", (String)localObject);
      if (str3 == null)
      {
        localObject = "";
        localBundle.putString("g_tk", (String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("FastWebRequestUtil", 2, new Object[] { "shieldFeedSource, params type = ", localBundle.getString("type"), ", uin = ", localBundle.getString("uin"), ", accountType = ", localBundle.getString("accountType") });
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("cookie", "uin=o" + str2 + ";skey=" + str3);
        localObject = new String(jqc.a(BaseApplicationImpl.getContext(), "https://kandian.qq.com/cgi-bin/social/setNotCare", "GET", localBundle, (Bundle)localObject));
        QLog.d("FastWebRequestUtil", 1, new Object[] { "shieldFeeds result = ", localObject });
        localObject = new JSONObject((String)localObject).getJSONObject("result");
        i = ((JSONObject)localObject).getInt("retCode");
        localObject = ((JSONObject)localObject).getString("retMsg");
        if (this.a != null) {
          ThreadManager.getUIHandler().post(new FastWebRequestUtil.7.1(this, i, (String)localObject));
        }
      }
      else
      {
        localObject = msg.ej(str3);
        continue;
        label348:
        str1 = "1";
        continue;
      }
      return;
      label355:
      String str1 = "2";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.7
 * JD-Core Version:    0.7.0.1
 */