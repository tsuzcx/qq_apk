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

public class yli
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
  
  private static String a(ylk paramylk, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramylk.a);
    localStringBuilder.append("_").append(paramylk.b);
    localStringBuilder.append("_").append(paramylk.h);
    localStringBuilder.append("_").append(a(paramString));
    paramString = bhqh.a(localStringBuilder.toString());
    localStringBuilder = new StringBuilder().append(paramylk.d);
    localStringBuilder.append("_").append(paramylk.k);
    localStringBuilder.append("_").append(paramylk.l);
    localStringBuilder.append("_").append(paramylk.m);
    localStringBuilder.append("_").append(paramylk.n);
    localStringBuilder.append("_").append(paramylk.o);
    localStringBuilder.append("_").append(paramylk.p);
    localStringBuilder.append("_").append(paramylk.q);
    localStringBuilder.append("_").append(paramString);
    return bhqh.a(localStringBuilder.toString());
  }
  
  public static void a(Context paramContext, ylk paramylk)
  {
    if ((paramContext == null) || (paramylk == null)) {
      return;
    }
    Request localRequest = new Request.Builder().url("https://jubao.qq.com/uniform_impeach/impeach_cryptokey").build();
    new OkHttpClient().newCall(localRequest).enqueue(new ylj(paramContext, paramylk));
  }
  
  private static void b(Context paramContext, ylk paramylk, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://jubao.qq.com/uniform_impeach/impeach_entry");
    localStringBuilder.append("?system=").append(paramylk.a);
    localStringBuilder.append("&version=").append(paramylk.b);
    localStringBuilder.append("&uintype=").append(paramylk.c);
    localStringBuilder.append("&eviluin=").append(paramylk.d);
    localStringBuilder.append("&appname=").append(paramylk.e);
    localStringBuilder.append("&appid=").append(paramylk.f);
    localStringBuilder.append("&subapp=").append(paramylk.g);
    localStringBuilder.append("&scene=").append(paramylk.h);
    localStringBuilder.append("&buddyflag=").append(paramylk.i);
    localStringBuilder.append("&contentid=").append(paramylk.j);
    localStringBuilder.append("&srv_para=").append(paramylk.k);
    localStringBuilder.append("&text_evidence=").append(paramylk.l);
    localStringBuilder.append("&img_evidence=").append(URLEncoder.encode(paramylk.m));
    localStringBuilder.append("&url_evidence=").append(paramylk.n);
    localStringBuilder.append("&video_evidence=").append(URLEncoder.encode(paramylk.o));
    localStringBuilder.append("&file_evidence=").append(paramylk.p);
    localStringBuilder.append("&audio_evidence=").append(paramylk.q);
    localStringBuilder.append("&user_input_param=").append(paramylk.r);
    localStringBuilder.append("&cryptograph=").append(a(paramylk, paramString));
    paramylk = new Intent(paramContext, QQBrowserDelegationActivity.class);
    paramylk.putExtra("url", localStringBuilder.toString());
    paramContext.startActivity(paramylk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yli
 * JD-Core Version:    0.7.0.1
 */