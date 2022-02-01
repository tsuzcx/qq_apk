package com.tencent.biz.pubaccount;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kbq;
import kbq.c;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class PublicAccountSearchRecommendManager$1
  implements Runnable
{
  public PublicAccountSearchRecommendManager$1(kbq paramkbq, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.val$app.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + this.val$app.getCurrentAccountUin(), 0);
    if (localSharedPreferences != null) {
      try
      {
        localObject1 = new JSONArray();
        localObject2 = kbq.a(this.this$0).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          kbq.c localc = (kbq.c)((Iterator)localObject2).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("uin", localc.mUin);
          localJSONObject.put("name", localc.mName);
          localJSONObject.put("isPA", localc.ady);
          ((JSONArray)localObject1).put(localJSONObject);
          continue;
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(kbq.b(this.this$0), 2, "saveRecommendListToLocal->error:" + localException);
        }
        localException.printStackTrace();
      }
    }
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("recommend_title", kbq.a(this.this$0));
    ((JSONObject)localObject2).put("recommend_cache_time", kbq.a(this.this$0));
    ((JSONObject)localObject2).put("recommend_fetch_time", kbq.b(this.this$0));
    ((JSONObject)localObject2).put("recommend_is_forbidden", kbq.a(this.this$0));
    ((JSONObject)localObject2).put("recommend_content_list", localObject1);
    Object localObject1 = ((JSONObject)localObject2).toString();
    if (QLog.isColorLevel()) {
      QLog.d(kbq.b(this.this$0), 2, "saveRecommendListToLocal->json:" + (String)localObject1);
    }
    SharedPreferences.Editor localEditor = localException.edit();
    localEditor.putString("public_account_search_recommend", (String)localObject1);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountSearchRecommendManager.1
 * JD-Core Version:    0.7.0.1
 */