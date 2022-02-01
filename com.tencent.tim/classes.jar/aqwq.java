import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vip.lianghao.net.GetRegisterLiangHaoList.1;
import com.tencent.mobileqq.vip.lianghao.net.GetRegisterLiangHaoList.2;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

public class aqwq
{
  private String SB;
  private long Tb;
  private final String aea = "https://proxy.vip.qq.com/cgi-bin/srfentry.fcgi";
  private final String appid = "d4e1f57bb381ec80e480aa10c65d05d1";
  private String cyq = "android";
  private String imei;
  private WeakReference<aqwq.a> iz = new WeakReference(null);
  private int page;
  private String version = "3.4.4";
  
  public aqwq(String paramString, int paramInt, aqwq.a parama)
  {
    this.SB = paramString;
    this.page = paramInt;
    this.iz = new WeakReference(parama);
  }
  
  private String CA()
  {
    return "https://proxy.vip.qq.com/cgi-bin/srfentry.fcgi?ts=" + System.currentTimeMillis() + "&data=" + ai();
  }
  
  private String CB()
  {
    return MD5.toMD5(this.imei + this.page + this.SB + this.cyq + this.version + "d4e1f57bb381ec80e480aa10c65d05d1").toUpperCase();
  }
  
  private aqwj a()
  {
    try
    {
      Object localObject = CA();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return null;
      }
      localObject = new Request.Builder().url((String)localObject).build();
      localObject = a().newCall((Request)localObject).execute();
      int i = ((Response)localObject).code();
      if (i == 200)
      {
        localObject = ((Response)localObject).body().string();
        if (QLog.isDevelopLevel()) {
          QLog.d("GetRegisterLiangHaoList", 4, "json " + (String)localObject);
        }
        localObject = new JSONObject((String)localObject).optJSONObject("12162");
        if (localObject != null)
        {
          localObject = ((JSONObject)localObject).optJSONObject("data");
          if (localObject != null)
          {
            localObject = ((JSONObject)localObject).optJSONObject("rsp");
            if (localObject != null) {
              return new aqwj((JSONObject)localObject);
            }
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.e("GetRegisterLiangHaoList", 2, "sendRequest errorCode" + i);
        }
        localObject = new aqwj();
        ((aqwj)localObject).ret = i;
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GetRegisterLiangHaoList", 2, localThrowable.toString());
      }
    }
    return null;
  }
  
  private OkHttpClient a()
  {
    return new OkHttpClient().newBuilder().connectTimeout(5L, TimeUnit.SECONDS).readTimeout(5L, TimeUnit.SECONDS).build();
  }
  
  private JSONObject ai()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("imei", getImei());
      localJSONObject3.put("page", String.valueOf(this.page));
      localJSONObject3.put("phone", this.SB);
      localJSONObject3.put("plat", this.cyq);
      localJSONObject3.put("version", this.version);
      localJSONObject3.put("sign", CB());
      localJSONObject2.put("req", localJSONObject3);
      localJSONObject1.put("12162", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GetRegisterLiangHaoList", 2, "buildRequestJson " + localJSONException);
      }
    }
    return null;
  }
  
  private void b(aqwj paramaqwj)
  {
    if ((paramaqwj != null) && (QLog.isColorLevel())) {
      QLog.i("GetRegisterLiangHaoList", 2, "onResponse " + paramaqwj);
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.Tb;
    int i;
    Object localObject;
    anpc localanpc;
    if (paramaqwj != null)
    {
      i = paramaqwj.ret;
      localObject = new HashMap();
      ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
      localanpc = anpc.a(BaseApplicationImpl.getApplication());
      if (i != 0) {
        break label139;
      }
    }
    label139:
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance(null, "reg_lh_get_list", bool, l1 - l2, 0L, (HashMap)localObject, "", true);
      localObject = (aqwq.a)this.iz.get();
      if (localObject != null) {
        break label145;
      }
      return;
      i = -30009;
      break;
    }
    label145:
    ThreadManagerV2.getUIHandlerV2().post(new GetRegisterLiangHaoList.2(this, paramaqwj, (aqwq.a)localObject));
  }
  
  private String getImei()
  {
    if (this.imei == null) {}
    try
    {
      this.imei = auri.getIMEI("ecd027");
      return this.imei;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("GetRegisterLiangHaoList", 2, "get imei error" + localThrowable.toString());
        }
        this.imei = "000000000000001";
      }
    }
  }
  
  public void dpp()
  {
    ThreadManagerV2.excute(new GetRegisterLiangHaoList.1(this), 16, null, true);
  }
  
  public static abstract interface a
  {
    public abstract void a(aqwj paramaqwj);
    
    public abstract void ea(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqwq
 * JD-Core Version:    0.7.0.1
 */