import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import cooperation.qzone.util.QZLog;
import java.net.URLEncoder;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;

public class ygv
{
  private static String a(String paramString)
  {
    try
    {
      paramString = Base64.decode(paramString, 0);
      SecretKeySpec localSecretKeySpec = new SecretKeySpec("d41d8cd98f00b204e9800998ecf8427e".getBytes(), "AES");
      Cipher localCipher = Cipher.getInstance("AES/ECB/NoPadding");
      localCipher.init(2, localSecretKeySpec);
      paramString = new String(localCipher.doFinal(paramString), "utf-8");
      return paramString;
    }
    catch (Throwable paramString)
    {
      QZLog.e("EvilReportUtil", "decrypt key error! " + paramString);
    }
    return "";
  }
  
  private static String a(ygx paramygx, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramygx.a);
    localStringBuilder.append("_").append(paramygx.b);
    localStringBuilder.append("_").append(paramygx.h);
    localStringBuilder.append("_").append(a(paramString));
    paramString = bhma.a(localStringBuilder.toString());
    localStringBuilder = new StringBuilder().append(paramygx.d);
    localStringBuilder.append("_").append(paramygx.k);
    localStringBuilder.append("_").append(paramygx.l);
    localStringBuilder.append("_").append(paramygx.m);
    localStringBuilder.append("_").append(paramygx.n);
    localStringBuilder.append("_").append(paramygx.o);
    localStringBuilder.append("_").append(paramygx.p);
    localStringBuilder.append("_").append(paramygx.q);
    localStringBuilder.append("_").append(paramString);
    return bhma.a(localStringBuilder.toString());
  }
  
  public static void a(Context paramContext, ygx paramygx)
  {
    if ((paramContext == null) || (paramygx == null)) {
      return;
    }
    Request localRequest = new Request.Builder().url("https://jubao.qq.com/uniform_impeach/impeach_cryptokey").build();
    new OkHttpClient().newCall(localRequest).enqueue(new ygw(paramContext, paramygx));
  }
  
  private static void b(Context paramContext, ygx paramygx, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://jubao.qq.com/uniform_impeach/impeach_entry");
    localStringBuilder.append("?system=").append(paramygx.a);
    localStringBuilder.append("&version=").append(paramygx.b);
    localStringBuilder.append("&uintype=").append(paramygx.c);
    localStringBuilder.append("&eviluin=").append(paramygx.d);
    localStringBuilder.append("&appname=").append(paramygx.e);
    localStringBuilder.append("&appid=").append(paramygx.f);
    localStringBuilder.append("&subapp=").append(paramygx.g);
    localStringBuilder.append("&scene=").append(paramygx.h);
    localStringBuilder.append("&buddyflag=").append(paramygx.i);
    localStringBuilder.append("&contentid=").append(paramygx.j);
    localStringBuilder.append("&srv_para=").append(paramygx.k);
    localStringBuilder.append("&text_evidence=").append(paramygx.l);
    localStringBuilder.append("&img_evidence=").append(URLEncoder.encode(paramygx.m));
    localStringBuilder.append("&url_evidence=").append(paramygx.n);
    localStringBuilder.append("&video_evidence=").append(URLEncoder.encode(paramygx.o));
    localStringBuilder.append("&file_evidence=").append(paramygx.p);
    localStringBuilder.append("&audio_evidence=").append(paramygx.q);
    localStringBuilder.append("&user_input_param=").append(paramygx.r);
    localStringBuilder.append("&cryptograph=").append(a(paramygx, paramString));
    paramygx = new Intent(paramContext, QQBrowserDelegationActivity.class);
    paramygx.putExtra("url", localStringBuilder.toString());
    paramContext.startActivity(paramygx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ygv
 * JD-Core Version:    0.7.0.1
 */