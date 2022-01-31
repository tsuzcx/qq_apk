import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class wtk
{
  public static String a(long paramLong, int paramInt)
  {
    Object localObject = bbtm.a().f();
    long l = bbtm.a().a();
    localObject = "https://tu.qq.com/wspeed.qq.com/w.cgi?appid=1000322&commandid=pitu.qqsdk.AutoAIScene&releaseversion=" + (String)localObject + "&touin=" + l + "&frequency=1&resultcode=" + paramInt + "&timecost=" + paramLong;
    try
    {
      localObject = (HttpURLConnection)new URL((String)localObject).openConnection();
      ((HttpURLConnection)localObject).setConnectTimeout(5000);
      ((HttpURLConnection)localObject).setRequestMethod("GET");
      if (((HttpURLConnection)localObject).getResponseCode() == 200)
      {
        localObject = ((HttpURLConnection)localObject).getInputStream().toString();
        return localObject;
      }
      return null;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static JSONObject a(String paramString1, String paramString2)
  {
    System.setProperty("sun.net.client.defaultConnectTimeout", "30000");
    System.setProperty("sun.net.client.defaultReadTimeout", "30000");
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString1).openConnection();
    localHttpURLConnection.setRequestMethod("POST");
    localHttpURLConnection.setRequestProperty("accept", "*/*");
    localHttpURLConnection.setRequestProperty("content-type", "application/json");
    localHttpURLConnection.setConnectTimeout(5000);
    localHttpURLConnection.setReadTimeout(5000);
    localHttpURLConnection.setDoOutput(true);
    localHttpURLConnection.setDoInput(true);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setInstanceFollowRedirects(true);
    localHttpURLConnection.connect();
    paramString1 = new DataOutputStream(localHttpURLConnection.getOutputStream());
    paramString1.write(paramString2.getBytes("utf-8"));
    paramString1.flush();
    paramString1.close();
    if (200 == localHttpURLConnection.getResponseCode())
    {
      paramString1 = new BufferedReader(new InputStreamReader(localHttpURLConnection.getInputStream()));
      paramString2 = new StringBuilder();
      for (;;)
      {
        String str = paramString1.readLine();
        if (str == null) {
          break;
        }
        paramString2.append(new String(str.getBytes(), "utf-8"));
      }
      paramString1.close();
    }
    for (paramString1 = paramString2.toString();; paramString1 = null)
    {
      localHttpURLConnection.disconnect();
      if (paramString1 != null) {
        break;
      }
      return null;
    }
    return new JSONObject(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wtk
 * JD-Core Version:    0.7.0.1
 */