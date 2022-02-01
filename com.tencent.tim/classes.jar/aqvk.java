import android.text.TextUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

public class aqvk
{
  public static Map<String, Long> oy = new HashMap(10);
  private final String KEY = "a4d7ea5belhtimecard";
  private final String TAG = "LhHelper";
  private final String cyb = "cmd=rsp&key=a4d7ea5belhtimecard";
  private final String cyc = "https://proxy.vip.qq.com/cgi-bin/srfentry.fcgi";
  private int ede = -1;
  private int edf = -1;
  private String uin;
  
  public aqvk(String paramString)
  {
    this.uin = paramString;
  }
  
  private String Cz()
  {
    return MD5.toMD5("cmd=rsp&key=a4d7ea5belhtimecard&uin=" + this.uin);
  }
  
  private OkHttpClient a()
  {
    return new OkHttpClient().newBuilder().connectTimeout(5L, TimeUnit.SECONDS).readTimeout(5L, TimeUnit.SECONDS).build();
  }
  
  private String gp(int paramInt)
  {
    return MD5.toMD5("cmd=" + paramInt + "&key=" + "a4d7ea5belhtimecard" + "&uin=" + this.uin);
  }
  
  private String gq(int paramInt)
  {
    try
    {
      String str = gp(paramInt);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cmd", paramInt);
      localJSONObject.put("sign", str);
      localJSONObject.put("uin", this.uin);
      str = "https://proxy.vip.qq.com/cgi-bin/srfentry.fcgi?data=" + t(localJSONObject);
      return str;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("LhHelper", 1, "buildReqUrl cmd = " + paramInt + "exception e = ", localThrowable);
    }
    return null;
  }
  
  private JSONObject m(int paramInt)
  {
    int i;
    try
    {
      Object localObject = gq(paramInt);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return null;
      }
      QLog.d("LhHelper", 1, "reqCgi cmd = " + paramInt);
      localObject = new Request.Builder().url((String)localObject).build();
      localObject = a().newCall((Request)localObject).execute();
      i = ((Response)localObject).code();
      if (i == 200)
      {
        localObject = new JSONObject(((Response)localObject).body().string()).optJSONObject("12042");
        if (localObject == null) {
          break label280;
        }
        localObject = ((JSONObject)localObject).optJSONObject("data");
        if (localObject == null) {
          break label280;
        }
        localObject = ((JSONObject)localObject).optJSONObject("rsp");
        if (localObject == null) {
          break label280;
        }
        i = ((JSONObject)localObject).optInt("ret");
        String str = ((JSONObject)localObject).optString("sign");
        QLog.d("LhHelper", 1, "reqCgi retCode = " + i);
        if ((i == 0) && (Cz().equalsIgnoreCase(str))) {
          return localObject;
        }
        QLog.e("LhHelper", 1, "reqCgi rsp sign error, cmd = " + paramInt);
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("LhHelper", 1, "reqCgi exception cmd =" + paramInt + ", e = ", localThrowable);
      return null;
    }
    QLog.e("LhHelper", 1, "reqCgi http errorCode = " + i + " ,cmd = " + paramInt);
    label280:
    return null;
  }
  
  private JSONObject t(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("req", paramJSONObject);
      localJSONObject1.put("12042", localJSONObject2);
      return localJSONObject1;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("LhHelper", 1, "buildReqData exception e = ", paramJSONObject);
    }
    return null;
  }
  
  public int Mw()
  {
    return this.ede;
  }
  
  public int Mx()
  {
    return this.edf;
  }
  
  public int My()
  {
    try
    {
      JSONObject localJSONObject = m(1);
      if (localJSONObject != null)
      {
        this.ede = localJSONObject.optInt("buyoutMonth", -1);
        this.edf = localJSONObject.optInt("buyoutType", -1);
        int i = localJSONObject.optInt("cardState", -1);
        if ((this.ede != -1) && (this.edf != -1))
        {
          if (i == 0) {
            return 1;
          }
        }
        else
        {
          QLog.e("LhHelper", 1, "checkUserStatus buyoutData is error");
          break label105;
        }
      }
      else
      {
        QLog.e("LhHelper", 1, "checkUserStatus rsp data is empty");
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("LhHelper", 1, "checkUserStatus exception e = ", localThrowable);
    }
    return 2;
    label105:
    return 3;
  }
  
  public boolean aFI()
  {
    try
    {
      if (m(2) != null) {
        return true;
      }
      QLog.e("LhHelper", 1, "receiveReq rsp data is error");
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("LhHelper", 1, "receiveReq exception e = ", localThrowable);
      }
    }
    return false;
  }
  
  public boolean aFJ()
  {
    try
    {
      JSONObject localJSONObject = m(3);
      if (localJSONObject != null)
      {
        int i = localJSONObject.optInt("lhState", -1);
        QLog.d("LhHelper", 1, "reqLhStatus lhState = " + i);
        if (i == 2) {
          return true;
        }
      }
      else
      {
        QLog.e("LhHelper", 1, "reqLhStatus rsp data is error");
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("LhHelper", 1, "reqLhStatus exception e = ", localThrowable);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqvk
 * JD-Core Version:    0.7.0.1
 */