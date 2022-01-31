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

public class wsd
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
  
  private static String a(wsf paramwsf, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramwsf.a);
    localStringBuilder.append("_").append(paramwsf.b);
    localStringBuilder.append("_").append(paramwsf.h);
    localStringBuilder.append("_").append(a(paramString));
    paramString = bflg.a(localStringBuilder.toString());
    localStringBuilder = new StringBuilder().append(paramwsf.d);
    localStringBuilder.append("_").append(paramwsf.k);
    localStringBuilder.append("_").append(paramwsf.l);
    localStringBuilder.append("_").append(paramwsf.m);
    localStringBuilder.append("_").append(paramwsf.n);
    localStringBuilder.append("_").append(paramwsf.o);
    localStringBuilder.append("_").append(paramwsf.p);
    localStringBuilder.append("_").append(paramwsf.q);
    localStringBuilder.append("_").append(paramString);
    return bflg.a(localStringBuilder.toString());
  }
  
  public static void a(Context paramContext, wsf paramwsf)
  {
    if ((paramContext == null) || (paramwsf == null)) {
      return;
    }
    Request localRequest = new Request.Builder().url("https://jubao.qq.com/uniform_impeach/impeach_cryptokey").build();
    new OkHttpClient().newCall(localRequest).enqueue(new wse(paramContext, paramwsf));
  }
  
  private static void b(Context paramContext, wsf paramwsf, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://jubao.qq.com/uniform_impeach/impeach_entry");
    localStringBuilder.append("?system=").append(paramwsf.a);
    localStringBuilder.append("&version=").append(paramwsf.b);
    localStringBuilder.append("&uintype=").append(paramwsf.c);
    localStringBuilder.append("&eviluin=").append(paramwsf.d);
    localStringBuilder.append("&appname=").append(paramwsf.e);
    localStringBuilder.append("&appid=").append(paramwsf.f);
    localStringBuilder.append("&subapp=").append(paramwsf.g);
    localStringBuilder.append("&scene=").append(paramwsf.h);
    localStringBuilder.append("&buddyflag=").append(paramwsf.i);
    localStringBuilder.append("&contentid=").append(paramwsf.j);
    localStringBuilder.append("&srv_para=").append(paramwsf.k);
    localStringBuilder.append("&text_evidence=").append(paramwsf.l);
    localStringBuilder.append("&img_evidence=").append(paramwsf.m);
    localStringBuilder.append("&url_evidence=").append(paramwsf.n);
    localStringBuilder.append("&video_evidence=").append(paramwsf.o);
    localStringBuilder.append("&file_evidence=").append(paramwsf.p);
    localStringBuilder.append("&audio_evidence=").append(paramwsf.q);
    localStringBuilder.append("&user_input_param=").append(paramwsf.r);
    localStringBuilder.append("&cryptograph=").append(a(paramwsf, paramString));
    paramwsf = new Intent(paramContext, QQBrowserDelegationActivity.class);
    paramwsf.putExtra("url", localStringBuilder.toString());
    paramContext.startActivity(paramwsf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wsd
 * JD-Core Version:    0.7.0.1
 */