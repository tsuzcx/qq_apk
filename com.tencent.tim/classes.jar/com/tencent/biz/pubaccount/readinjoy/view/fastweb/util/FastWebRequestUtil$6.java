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
import nrl.a;
import org.json.JSONObject;

public final class FastWebRequestUtil$6
  implements Runnable
{
  public FastWebRequestUtil$6(ArticleInfo paramArticleInfo, nrl.a parama) {}
  
  public void run()
  {
    try
    {
      Bundle localBundle = new Bundle();
      Object localObject = (QQAppInterface)kxm.getAppRuntime();
      String str1 = kxm.getAccount();
      String str2 = ((TicketManager)((QQAppInterface)localObject).getManager(2)).getSkey(str1);
      localBundle.putString("feeds_id", String.valueOf(this.d.mFeedId));
      localBundle.putString("uin", String.valueOf(this.d.publishUin));
      localBundle.putString("feedsType", String.valueOf(this.d.mFeedType));
      if (str2 == null) {}
      for (localObject = "";; localObject = msg.ej(str2))
      {
        localBundle.putString("g_tk", (String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("FastWebRequestUtil", 2, new Object[] { "params feeds_id = ", Long.valueOf(this.d.mFeedId), ", uin = ", Long.valueOf(this.d.publishUin), ", feedsType = ", Integer.valueOf(this.d.mFeedType) });
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("cookie", "uin=o" + str1 + ";skey=" + str2);
        localObject = new String(jqc.a(BaseApplicationImpl.getContext(), "https://kandian.qq.com/qz_kandian_social/kandian_ext/deleteFeeds", "GET", localBundle, (Bundle)localObject));
        QLog.d("FastWebRequestUtil", 1, new Object[] { "deleteFeeds result = ", localObject });
        localObject = new JSONObject((String)localObject).getJSONObject("result");
        int i = ((JSONObject)localObject).getInt("retCode");
        localObject = ((JSONObject)localObject).getString("retMsg");
        if (this.a == null) {
          break;
        }
        ThreadManager.getUIHandler().post(new FastWebRequestUtil.6.1(this, i, (String)localObject));
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      if (this.a != null) {
        ThreadManager.getUIHandler().post(new FastWebRequestUtil.6.2(this, localException));
      }
      QLog.d("FastWebRequestUtil", 2, "deleteFeeds exception. ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.6
 * JD-Core Version:    0.7.0.1
 */