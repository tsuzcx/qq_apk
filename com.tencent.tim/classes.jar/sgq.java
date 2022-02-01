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

public class sgq
{
  private static String a(sgq.a parama, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(parama.system);
    localStringBuilder.append("_").append(parama.version);
    localStringBuilder.append("_").append(parama.scene);
    localStringBuilder.append("_").append(gA(paramString));
    paramString = atad.toMD5(localStringBuilder.toString());
    localStringBuilder = new StringBuilder().append(parama.aDS);
    localStringBuilder.append("_").append(parama.aDV);
    localStringBuilder.append("_").append(parama.aDW);
    localStringBuilder.append("_").append(parama.aDX);
    localStringBuilder.append("_").append(parama.aDY);
    localStringBuilder.append("_").append(parama.aDZ);
    localStringBuilder.append("_").append(parama.aEa);
    localStringBuilder.append("_").append(parama.aEb);
    localStringBuilder.append("_").append(paramString);
    return atad.toMD5(localStringBuilder.toString());
  }
  
  public static void a(Context paramContext, sgq.a parama)
  {
    if ((paramContext == null) || (parama == null)) {
      return;
    }
    Request localRequest = new Request.Builder().url("https://jubao.qq.com/uniform_impeach/impeach_cryptokey").build();
    new OkHttpClient().newCall(localRequest).enqueue(new sgr(paramContext, parama));
  }
  
  private static void a(Context paramContext, sgq.a parama, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://jubao.qq.com/uniform_impeach/impeach_entry");
    localStringBuilder.append("?system=").append(parama.system);
    localStringBuilder.append("&version=").append(parama.version);
    localStringBuilder.append("&uintype=").append(parama.aDR);
    localStringBuilder.append("&eviluin=").append(parama.aDS);
    localStringBuilder.append("&appname=").append(parama.appname);
    localStringBuilder.append("&appid=").append(parama.appid);
    localStringBuilder.append("&subapp=").append(parama.aDT);
    localStringBuilder.append("&scene=").append(parama.scene);
    localStringBuilder.append("&buddyflag=").append(parama.aDU);
    localStringBuilder.append("&contentid=").append(parama.contentid);
    localStringBuilder.append("&srv_para=").append(parama.aDV);
    localStringBuilder.append("&text_evidence=").append(parama.aDW);
    localStringBuilder.append("&img_evidence=").append(URLEncoder.encode(parama.aDX));
    localStringBuilder.append("&url_evidence=").append(parama.aDY);
    localStringBuilder.append("&video_evidence=").append(URLEncoder.encode(parama.aDZ));
    localStringBuilder.append("&file_evidence=").append(parama.aEa);
    localStringBuilder.append("&audio_evidence=").append(parama.aEb);
    localStringBuilder.append("&user_input_param=").append(parama.aEc);
    localStringBuilder.append("&cryptograph=").append(a(parama, paramString));
    parama = new Intent(paramContext, QQBrowserDelegationActivity.class);
    parama.putExtra("url", localStringBuilder.toString());
    paramContext.startActivity(parama);
  }
  
  private static String gA(String paramString)
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
  
  public static class a
  {
    public String aDR = "";
    public String aDS = "";
    public String aDT = "";
    public String aDU = "";
    public String aDV = "";
    public String aDW = "";
    public String aDX = "";
    public String aDY = "";
    public String aDZ = "";
    public String aEa = "";
    public String aEb = "";
    public String aEc = "";
    public String appid = "";
    public String appname = "";
    public String contentid = "";
    public String scene = "";
    public String system = "";
    public String version = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sgq
 * JD-Core Version:    0.7.0.1
 */