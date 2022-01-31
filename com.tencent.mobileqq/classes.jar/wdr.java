import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import cooperation.qzone.util.QZLog;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class wdr
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
  
  private static String a(wdt paramwdt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramwdt.a);
    localStringBuilder.append("_").append(paramwdt.b);
    localStringBuilder.append("_").append(paramwdt.h);
    localStringBuilder.append("_").append(a(paramString));
    paramString = becz.a(localStringBuilder.toString());
    localStringBuilder = new StringBuilder().append(paramwdt.d);
    localStringBuilder.append("_").append(paramwdt.k);
    localStringBuilder.append("_").append(paramwdt.l);
    localStringBuilder.append("_").append(paramwdt.m);
    localStringBuilder.append("_").append(paramwdt.n);
    localStringBuilder.append("_").append(paramwdt.o);
    localStringBuilder.append("_").append(paramwdt.p);
    localStringBuilder.append("_").append(paramwdt.q);
    localStringBuilder.append("_").append(paramString);
    return becz.a(localStringBuilder.toString());
  }
  
  public static void a(Context paramContext, wdt paramwdt)
  {
    if ((paramContext == null) || (paramwdt == null)) {
      return;
    }
    Request localRequest = new Request.Builder().url("https://jubao.qq.com/uniform_impeach/impeach_cryptokey").build();
    new OkHttpClient().newCall(localRequest).enqueue(new wds(paramContext, paramwdt));
  }
  
  private static void b(Context paramContext, wdt paramwdt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://juabotest.qq.com/uniform_impeach/impeach_entry");
    localStringBuilder.append("?system=").append(paramwdt.a);
    localStringBuilder.append("&version=").append(paramwdt.b);
    localStringBuilder.append("&uintype=").append(paramwdt.c);
    localStringBuilder.append("&eviluin=").append(paramwdt.d);
    localStringBuilder.append("&appname=").append(paramwdt.e);
    localStringBuilder.append("&appid=").append(paramwdt.f);
    localStringBuilder.append("&subapp=").append(paramwdt.g);
    localStringBuilder.append("&scene=").append(paramwdt.h);
    localStringBuilder.append("&buddyflag=").append(paramwdt.i);
    localStringBuilder.append("&contentid=").append(paramwdt.j);
    localStringBuilder.append("&srv_para=").append(paramwdt.k);
    localStringBuilder.append("&text_evidence=").append(paramwdt.l);
    localStringBuilder.append("&img_evidence=").append(paramwdt.m);
    localStringBuilder.append("&url_evidence=").append(paramwdt.n);
    localStringBuilder.append("&video_evidence=").append(paramwdt.o);
    localStringBuilder.append("&file_evidence=").append(paramwdt.p);
    localStringBuilder.append("&audio_evidence=").append(paramwdt.q);
    localStringBuilder.append("&user_input_param=").append(paramwdt.r);
    localStringBuilder.append("&cryptograph=").append(a(paramwdt, paramString));
    paramwdt = new Intent(paramContext, QQBrowserDelegationActivity.class);
    paramwdt.putExtra("url", localStringBuilder.toString());
    paramContext.startActivity(paramwdt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wdr
 * JD-Core Version:    0.7.0.1
 */