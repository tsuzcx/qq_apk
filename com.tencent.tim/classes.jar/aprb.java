import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Ljava.lang.Object;>;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public class aprb
  extends arxd<HashMap<String, Object>, Void, JSONObject>
{
  protected Bundle bq;
  protected boolean cSa;
  protected int dVr;
  protected aprb.a e;
  
  public aprb(String paramString1, String paramString2, aprb.a parama, int paramInt, Bundle paramBundle)
  {
    super(paramString1, paramString2);
    this.e = parama;
    this.dVr = paramInt;
    this.bq = paramBundle;
  }
  
  public aprb(String paramString1, String paramString2, aprb.a parama, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    super(paramString1, paramString2);
    this.e = parama;
    this.dVr = paramInt;
    this.bq = paramBundle;
    this.cSa = paramBoolean;
  }
  
  @SuppressLint({"InlinedApi", "NewApi"})
  public void J(HashMap<String, Object> paramHashMap)
  {
    Executor localExecutor = obtainMultiExecutor();
    if (localExecutor != null)
    {
      executeOnExecutor(localExecutor, new HashMap[] { paramHashMap });
      return;
    }
    execute(new HashMap[] { paramHashMap });
  }
  
  protected JSONObject a(HashMap<String, Object>... paramVarArgs)
  {
    if (isCancelled()) {
      return null;
    }
    Object localObject = paramVarArgs[0];
    if (((((HashMap)localObject).get("CONTEXT") instanceof Context)) && ((((HashMap)localObject).get("BUNDLE") instanceof Bundle)))
    {
      paramVarArgs = (Context)((HashMap)localObject).get("CONTEXT");
      localObject = (Bundle)((HashMap)localObject).get("BUNDLE");
    }
    for (;;)
    {
      try
      {
        Bundle localBundle = new Bundle();
        String str1 = ((Bundle)localObject).getString("Cookie");
        String str2 = ((Bundle)localObject).getString("Referer");
        String str3 = ((Bundle)localObject).getString("Host");
        if (str1 != null)
        {
          localBundle.putString("Cookie", str1);
          ((Bundle)localObject).remove("Cookie");
        }
        if (str2 != null)
        {
          localBundle.putString("Referer", str2);
          ((Bundle)localObject).remove("Referer");
        }
        if (str3 != null)
        {
          localBundle.putString("Host", str3);
          ((Bundle)localObject).remove(str3);
        }
        localObject = new JSONObject(jqc.a(paramVarArgs, this.mUri, this.mMethodName, (Bundle)localObject, localBundle));
        paramVarArgs = (HashMap<String, Object>[])localObject;
        if (!this.cSa)
        {
          paramVarArgs = (HashMap<String, Object>[])localObject;
          if (((JSONObject)localObject).getInt("retcode") == 0) {
            paramVarArgs = ((JSONObject)localObject).getJSONObject("result");
          }
        }
      }
      catch (IOException paramVarArgs)
      {
        QLog.w("HttpWebCgiAsyncTask", 1, paramVarArgs.getMessage(), paramVarArgs);
        paramVarArgs = null;
        continue;
      }
      catch (JSONException paramVarArgs)
      {
        QLog.w("HttpWebCgiAsyncTask", 1, paramVarArgs.getMessage(), paramVarArgs);
        paramVarArgs = null;
        continue;
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        QLog.w("HttpWebCgiAsyncTask", 1, paramVarArgs.getMessage(), paramVarArgs);
      }
      return paramVarArgs;
      paramVarArgs = null;
    }
  }
  
  protected void onPostExecute(JSONObject paramJSONObject)
  {
    if (isCancelled()) {}
    while (this.e == null) {
      return;
    }
    this.e.a(paramJSONObject, this.dVr, this.bq);
  }
  
  public static abstract interface a
  {
    public abstract void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aprb
 * JD-Core Version:    0.7.0.1
 */