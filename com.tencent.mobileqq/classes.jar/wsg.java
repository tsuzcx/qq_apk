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

public class wsg
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
  
  private static String a(wsi paramwsi, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramwsi.a);
    localStringBuilder.append("_").append(paramwsi.b);
    localStringBuilder.append("_").append(paramwsi.h);
    localStringBuilder.append("_").append(a(paramString));
    paramString = bfkp.a(localStringBuilder.toString());
    localStringBuilder = new StringBuilder().append(paramwsi.d);
    localStringBuilder.append("_").append(paramwsi.k);
    localStringBuilder.append("_").append(paramwsi.l);
    localStringBuilder.append("_").append(paramwsi.m);
    localStringBuilder.append("_").append(paramwsi.n);
    localStringBuilder.append("_").append(paramwsi.o);
    localStringBuilder.append("_").append(paramwsi.p);
    localStringBuilder.append("_").append(paramwsi.q);
    localStringBuilder.append("_").append(paramString);
    return bfkp.a(localStringBuilder.toString());
  }
  
  public static void a(Context paramContext, wsi paramwsi)
  {
    if ((paramContext == null) || (paramwsi == null)) {
      return;
    }
    Request localRequest = new Request.Builder().url("https://jubao.qq.com/uniform_impeach/impeach_cryptokey").build();
    new OkHttpClient().newCall(localRequest).enqueue(new wsh(paramContext, paramwsi));
  }
  
  private static void b(Context paramContext, wsi paramwsi, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://jubao.qq.com/uniform_impeach/impeach_entry");
    localStringBuilder.append("?system=").append(paramwsi.a);
    localStringBuilder.append("&version=").append(paramwsi.b);
    localStringBuilder.append("&uintype=").append(paramwsi.c);
    localStringBuilder.append("&eviluin=").append(paramwsi.d);
    localStringBuilder.append("&appname=").append(paramwsi.e);
    localStringBuilder.append("&appid=").append(paramwsi.f);
    localStringBuilder.append("&subapp=").append(paramwsi.g);
    localStringBuilder.append("&scene=").append(paramwsi.h);
    localStringBuilder.append("&buddyflag=").append(paramwsi.i);
    localStringBuilder.append("&contentid=").append(paramwsi.j);
    localStringBuilder.append("&srv_para=").append(paramwsi.k);
    localStringBuilder.append("&text_evidence=").append(paramwsi.l);
    localStringBuilder.append("&img_evidence=").append(paramwsi.m);
    localStringBuilder.append("&url_evidence=").append(paramwsi.n);
    localStringBuilder.append("&video_evidence=").append(paramwsi.o);
    localStringBuilder.append("&file_evidence=").append(paramwsi.p);
    localStringBuilder.append("&audio_evidence=").append(paramwsi.q);
    localStringBuilder.append("&user_input_param=").append(paramwsi.r);
    localStringBuilder.append("&cryptograph=").append(a(paramwsi, paramString));
    paramwsi = new Intent(paramContext, QQBrowserDelegationActivity.class);
    paramwsi.putExtra("url", localStringBuilder.toString());
    paramContext.startActivity(paramwsi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wsg
 * JD-Core Version:    0.7.0.1
 */