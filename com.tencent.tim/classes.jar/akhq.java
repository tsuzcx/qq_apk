import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

class akhq
  extends AsyncTask<Integer, Void, Bundle>
{
  akhq(akhp paramakhp) {}
  
  protected Bundle a(Integer... paramVarArgs)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("downloadcode", paramVarArgs[0].intValue());
    try
    {
      paramVarArgs = (HttpURLConnection)new URL("https://tiantian.qq.com/qiqimanage/qunpack/android/58.json").openConnection();
      paramVarArgs.setConnectTimeout(5000);
      paramVarArgs.setReadTimeout(30000);
      paramVarArgs.setRequestMethod("GET");
      paramVarArgs.setRequestProperty("Connection", "Keep-Alive");
      paramVarArgs.connect();
      paramVarArgs = new BufferedReader(new InputStreamReader(paramVarArgs.getInputStream()));
      Object localObject = new StringBuffer();
      for (;;)
      {
        String str = paramVarArgs.readLine();
        if (str == null) {
          break;
        }
        ((StringBuffer)localObject).append(str).append("\n");
      }
      localObject = ((StringBuffer)localObject).toString();
      paramVarArgs.close();
      paramVarArgs = new JSONObject((String)localObject);
      if (paramVarArgs.optInt("errCode", -1) == 0)
      {
        paramVarArgs = paramVarArgs.optJSONObject("data");
        if (paramVarArgs != null)
        {
          paramVarArgs = paramVarArgs.optJSONObject("package");
          if (paramVarArgs != null)
          {
            localBundle.putString("DownPackage", paramVarArgs.optString("package"));
            localBundle.putString("DownUrl", paramVarArgs.optString("url"));
            localBundle.putString("DownAppId", paramVarArgs.optString("appid"));
          }
        }
      }
      return localBundle;
    }
    catch (Exception paramVarArgs) {}
    return null;
  }
  
  protected void dg(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.b.bTr = paramBundle.getString("DownPackage");
      this.b.bTt = paramBundle.getString("DownUrl");
      this.b.bTs = paramBundle.getString("DownAppId");
      if ((!TextUtils.isEmpty(this.b.bTr)) && (!TextUtils.isEmpty(this.b.bTs)) && (!TextUtils.isEmpty(this.b.bTt))) {
        this.b.RP(paramBundle.getInt("downloadcode"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akhq
 * JD-Core Version:    0.7.0.1
 */