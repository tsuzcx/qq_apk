import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class kux
  implements BusinessObserver
{
  kux(kuu paramkuu, boolean paramBoolean, long paramLong1, int paramInt1, String paramString1, int paramInt2, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    i = -1;
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      paramInt = i;
      if (paramBundle != null)
      {
        localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
      }
      try
      {
        paramBundle = ((WebSsoBody.WebSsoResponseBody)localObject).data.get();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentSSOModule", 2, "createComment ret=" + paramBundle);
        }
        paramBundle = new JSONObject(paramBundle);
        if (paramInt == 0) {
          break label381;
        }
        localObject = paramBundle.optString("msg");
        if (kuu.a(this.b) != null)
        {
          if (!this.ahX) {
            break label289;
          }
          kuu.a(this.b).a(this.sP, false, this.aLS, (String)localObject, this.aco, this.aLT);
        }
        for (;;)
        {
          String str1 = paramBundle.optJSONObject("data").optString("comment_id");
          kuu localkuu = this.b;
          String str2 = this.acx;
          if (!TextUtils.isEmpty(this.acy)) {
            break;
          }
          paramBundle = this.Vu;
          label195:
          String str3 = this.acu;
          String str4 = this.acz;
          localObject = str1;
          if (str1 == null) {
            localObject = "";
          }
          kuu.a(localkuu, str2, paramBundle, str3, str4, (String)localObject);
          QLog.d("ReadInJoyCommentSSOModule", 2, "commentSink   commentRowKey :" + this.acy + "  rowKey :" + this.Vu);
          label274:
          odv.a(paramInt, 4, System.currentTimeMillis() - this.sQ, null);
          return;
          label289:
          kuu.a(this.b).a(this.sP, false, this.aLS, (String)localObject, this.aLT);
        }
        localObject = paramBundle.getLocalizedMessage();
      }
      catch (Exception paramBundle) {}
    }
    catch (Exception paramBundle)
    {
      label521:
      label551:
      label733:
      for (;;)
      {
        Object localObject;
        label381:
        paramInt = i;
      }
    }
    if (kuu.a(this.b) != null)
    {
      if (!this.ahX) {
        break label733;
      }
      kuu.a(this.b).a(this.sP, false, this.aLS, (String)localObject, this.aco, this.aLT);
    }
    for (;;)
    {
      paramBundle.printStackTrace();
      break label274;
      localObject = paramBundle.optString("msg");
      i = paramBundle.getInt("ret");
      if (kuu.a(this.b) != null)
      {
        if (i == 0) {
          break label551;
        }
        if (!this.ahX) {
          break label521;
        }
        kuu.a(this.b).a(this.sP, false, this.aLS, (String)localObject, this.aco, this.aLT);
      }
      for (;;)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("retCode", i);
        ((JSONObject)localObject).put("os", 1);
        ((JSONObject)localObject).put("consume_time", System.currentTimeMillis() - this.sQ);
        kbp.a(null, "", "0X8009A35", "0X8009A35", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
        break;
        kuu.a(this.b).a(this.sP, false, this.aLS, (String)localObject, this.aLT);
        continue;
        localObject = paramBundle.getJSONObject("data").getString("comment_id");
        if (this.ahX) {
          kuu.a(this.b).a(this.sP, true, this.aLS, (String)localObject, this.aco, this.aLT);
        } else {
          kuu.a(this.b).a(this.sP, true, this.aLS, (String)localObject, this.aLT);
        }
      }
      paramBundle = this.acy;
      break label195;
      paramInt = i;
      if (kuu.a(this.b) == null) {
        break label274;
      }
      if (this.ahX)
      {
        kuu.a(this.b).a(this.sP, false, this.aLS, "", this.aco, this.aLT);
        paramInt = i;
        break label274;
      }
      kuu.a(this.b).a(this.sP, false, this.aLS, "", this.aLT);
      paramInt = i;
      break label274;
      kuu.a(this.b).a(this.sP, false, this.aLS, (String)localObject, this.aLT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kux
 * JD-Core Version:    0.7.0.1
 */