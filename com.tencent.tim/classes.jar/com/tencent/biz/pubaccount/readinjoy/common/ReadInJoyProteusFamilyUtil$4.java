package com.tencent.biz.pubaccount.readinjoy.common;

import android.text.TextUtils;
import awit;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import jqi;
import kxb;
import kxb.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyProteusFamilyUtil$4
  implements Runnable
{
  public ReadInJoyProteusFamilyUtil$4(kxb paramkxb) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = (String)awit.f(kxb.access$200(), "");
      QLog.d(kxb.access$000(), 2, "local card data str " + (String)localObject2);
      Object localObject1 = localObject2;
      Object localObject3;
      int j;
      int i;
      if (jqi.isNetworkAvailable(BaseApplicationImpl.context))
      {
        localObject3 = kxb.access$300(null);
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject1 = new JSONObject();
          localObject2 = new JSONArray((String)localObject3);
          j = ((JSONArray)localObject2).length();
          i = 0;
        }
      }
      for (;;)
      {
        if (i < j)
        {
          localObject3 = ((JSONArray)localObject2).optJSONObject(i);
          if (localObject3 != null) {
            ((JSONObject)localObject1).put(((JSONObject)localObject3).optString(kxb.access$400()), ((JSONObject)localObject3).optString(kxb.access$500()));
          }
        }
        else
        {
          if (((JSONObject)localObject1).length() > 0)
          {
            localObject1 = ((JSONObject)localObject1).toString();
            QLog.d(kxb.access$000(), 2, "loadProteusFamilyData | update local cardDataStr " + (String)localObject1);
            awit.H(kxb.access$200(), localObject1);
            kxb.a(this.this$0, kxb.B((String)localObject1));
            if (kxb.a(this.this$0) != null) {
              kxb.a(this.this$0).h(true, kxb.a(this.this$0));
            }
            localObject1 = kxb.access$000();
            localObject2 = new StringBuilder().append("loadProteusFamilyData | proteus family members updated ");
            if (kxb.ax() == null) {
              break label316;
            }
          }
          label316:
          for (i = kxb.ax().size();; i = 0)
          {
            QLog.d((String)localObject1, 2, i);
            return;
            localObject1 = (String)awit.f(kxb.access$200(), "");
            QLog.d(kxb.access$000(), 2, "loadProteusFamilyData | no need to update just use local cardDataStr " + (String)localObject1);
            break;
          }
        }
        i += 1;
      }
      return;
    }
    catch (JSONException localJSONException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyProteusFamilyUtil.4
 * JD-Core Version:    0.7.0.1
 */