import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

class aboh
  implements tzd
{
  aboh(aboc paramaboc, String paramString, long paramLong) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    aboc.a(this.this$0, this.val$cmd, this.Od, paramInt);
  }
  
  public void onPermission(int paramInt)
  {
    aboc.a(this.this$0, this.val$cmd, this.Od, paramInt);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    for (;;)
    {
      JSONObject localJSONObject1;
      Object localObject1;
      Object localObject2;
      try
      {
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("ret", 0);
        if ("cs.get_user_info.local".equals(this.val$cmd))
        {
          localObject1 = abmt.a(aboc.a(this.this$0));
          if (localObject1 == null)
          {
            QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[getUserInfo], launcher is null, mGameId:" + aboc.a(this.this$0));
            return;
          }
          localObject1 = ((abos)localObject1).c();
          localObject2 = new ably(paramJSONObject.optString("avatarUrl"), paramJSONObject.optString("nickName"), ((CmGameInitParams)localObject1).openId);
          aboc.a(this.this$0).put(((CmGameInitParams)localObject1).openId, localObject2);
          localJSONObject1.put("gender", paramJSONObject.optString("gender", ""));
          localJSONObject1.put("city", paramJSONObject.optString("city", ""));
          localJSONObject1.put("province", paramJSONObject.optString("province", ""));
          localJSONObject1.put("country", paramJSONObject.optString("country", ""));
          localJSONObject1.put("openid", ((CmGameInitParams)localObject1).openId);
          if (QLog.isColorLevel()) {}
          paramJSONObject = abmt.a();
          if (paramJSONObject == null) {
            break;
          }
          paramJSONObject.callbackFromRequest(this.Od, 0, this.val$cmd, localJSONObject1.toString());
          return;
        }
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramJSONObject, new Object[0]);
        return;
      }
      if ("cs.get_app_friends.local".equals(this.val$cmd))
      {
        paramJSONObject = paramJSONObject.optJSONArray("appfriends");
        if ((paramJSONObject != null) && (paramJSONObject.length() != 0))
        {
          localObject1 = new JSONArray();
          int j = paramJSONObject.length();
          int i = 0;
          while (i < j)
          {
            localObject2 = paramJSONObject.getJSONObject(i);
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("openid", ((JSONObject)localObject2).optString("openid"));
            Object localObject3 = ((JSONObject)localObject2).optString("openid");
            localObject3 = new ably(((JSONObject)localObject2).optString("avatarUrl"), ((JSONObject)localObject2).optString("nickName"), (String)localObject3);
            aboc.a(this.this$0).put(((JSONObject)localObject2).optString("openid"), localObject3);
            ((JSONArray)localObject1).put(localJSONObject2);
            i += 1;
          }
          localJSONObject1.put("friendsInfo", localObject1);
        }
      }
      else if ("cs.get_city.local".equals(this.val$cmd))
      {
        localJSONObject1.put("nation", paramJSONObject.optString("nation", ""));
        localJSONObject1.put("province", paramJSONObject.optString("province", ""));
        localJSONObject1.put("city", paramJSONObject.optString("city", ""));
        localJSONObject1.put("district", paramJSONObject.optString("district", ""));
      }
      else if ("cs.get_location.local".equals(this.val$cmd))
      {
        localJSONObject1.put("latitude", paramJSONObject.optString("latitude", ""));
        localJSONObject1.put("longitude", paramJSONObject.optString("longitude", ""));
        localJSONObject1.put("speed", paramJSONObject.optString("speed", ""));
        localJSONObject1.put("accuracy", paramJSONObject.optString("accuracy", ""));
        localJSONObject1.put("altitude", paramJSONObject.optString("altitude", ""));
        localJSONObject1.put("verticalAccuracy", paramJSONObject.optString("verticalAccuracy", ""));
        localJSONObject1.put("horizontalAccuracy", paramJSONObject.optString("horizontalAccuracy", ""));
      }
    }
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aboh
 * JD-Core Version:    0.7.0.1
 */