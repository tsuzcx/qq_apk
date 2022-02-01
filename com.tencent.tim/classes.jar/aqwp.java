import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vip.lianghao.net.CheckRegisterLiangHao.1;
import com.tencent.mobileqq.vip.lianghao.net.CheckRegisterLiangHao.2;
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
import org.json.JSONObject;

public class aqwp
{
  private long Tb;
  private final String aea = "https://proxy.vip.qq.com/cgi-bin/srfentry.fcgi";
  private final String appid = "a4d7xwsbelhregistercard";
  private WeakReference<aqwp.a> iz = new WeakReference(null);
  private String uin;
  
  public aqwp(String paramString, aqwp.a parama)
  {
    this.uin = paramString;
    this.iz = new WeakReference(parama);
  }
  
  private String CA()
  {
    return "https://proxy.vip.qq.com/cgi-bin/srfentry.fcgi?ts=" + System.currentTimeMillis() + "&data=" + ai();
  }
  
  private String CB()
  {
    return MD5.toMD5("uin=" + this.uin + "&key=" + "a4d7xwsbelhregistercard").toUpperCase();
  }
  
  private aqwk a()
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
        if (QLog.isColorLevel()) {
          QLog.i("CheckRegisterLiangHao", 2, "json " + (String)localObject);
        }
        localObject = new JSONObject((String)localObject).optJSONObject("12196");
        if (localObject != null)
        {
          localObject = ((JSONObject)localObject).optJSONObject("data");
          if (localObject != null)
          {
            localObject = ((JSONObject)localObject).optJSONObject("mOut");
            if (localObject != null) {
              return new aqwk((JSONObject)localObject);
            }
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.e("CheckRegisterLiangHao", 2, "sendRequest errorCode" + i);
        }
        localObject = new aqwk();
        ((aqwk)localObject).ret = i;
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CheckRegisterLiangHao", 2, localThrowable.toString());
      }
    }
    return null;
  }
  
  private OkHttpClient a()
  {
    return new OkHttpClient().newBuilder().connectTimeout(5L, TimeUnit.SECONDS).readTimeout(5L, TimeUnit.SECONDS).build();
  }
  
  private void a(aqwk paramaqwk)
  {
    Object localObject2;
    Object localObject1;
    long l1;
    long l2;
    int i;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("onResponse ");
      if (paramaqwk == null)
      {
        localObject1 = "";
        QLog.i("CheckRegisterLiangHao", 2, (String)localObject1);
      }
    }
    else
    {
      l1 = SystemClock.elapsedRealtime();
      l2 = this.Tb;
      if (paramaqwk == null) {
        break label146;
      }
      i = paramaqwk.ret;
      label63:
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("param_FailCode", String.valueOf(i));
      localObject2 = anpc.a(BaseApplicationImpl.getApplication());
      if (i != 0) {
        break label153;
      }
    }
    label146:
    label153:
    for (boolean bool = true;; bool = false)
    {
      ((anpc)localObject2).collectPerformance(null, "reg_lh_check_uin", bool, l1 - l2, 0L, (HashMap)localObject1, "", true);
      localObject1 = (aqwp.a)this.iz.get();
      if (localObject1 != null) {
        break label159;
      }
      return;
      localObject1 = paramaqwk.toString();
      break;
      i = -30009;
      break label63;
    }
    label159:
    ThreadManagerV2.getUIHandlerV2().post(new CheckRegisterLiangHao.2(this, (aqwp.a)localObject1, paramaqwk));
  }
  
  private JSONObject ai()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("uin", this.uin);
      localJSONObject3.put("sign", CB());
      localJSONObject2.put("mIn", localJSONObject3);
      localJSONObject1.put("12196", localJSONObject2);
      return localJSONObject1;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public void dpp()
  {
    ThreadManagerV2.excute(new CheckRegisterLiangHao.1(this), 16, null, true);
  }
  
  public static abstract interface a
  {
    public abstract void aP(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqwp
 * JD-Core Version:    0.7.0.1
 */