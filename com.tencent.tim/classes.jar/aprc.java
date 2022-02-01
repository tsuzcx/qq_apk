import android.content.Context;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class aprc
  extends aprb
{
  public aprc(String paramString1, String paramString2, aprb.a parama, int paramInt, Bundle paramBundle)
  {
    super(paramString1, paramString2, parama, paramInt, paramBundle);
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
        String str3 = ((Bundle)localObject).getString("Origin");
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
          localBundle.putString("Origin", str3);
          ((Bundle)localObject).remove("Origin");
        }
        paramVarArgs = new JSONObject(jqc.a(paramVarArgs, this.mUri, this.mMethodName, (Bundle)localObject, localBundle));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aprc
 * JD-Core Version:    0.7.0.1
 */