import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class awht
  extends awfr
{
  private String TAG = awht.class.getSimpleName();
  
  private void abA(String paramString)
  {
    Object localObject = this.f.mRuntime.getActivity();
    if ((localObject == null) || (((Activity)localObject).isFinishing()) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        return;
        localObject = ((Activity)localObject).getIntent();
      } while (localObject == null);
      localObject = ((Intent)localObject).getExtras();
    } while (localObject == null);
    localObject = awhu.k((Bundle)localObject);
    this.f.callJs(paramString, new String[] { localObject });
  }
  
  private void abB(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      String str1 = paramString.getString("type");
      String str2 = paramString.getString("value");
      long l = paramString.getLong("uin");
      paramString.getString("callback");
      avzf.a().a().A(str1, str2, l);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e(this.TAG, 1, "error process friend setting json string.", paramString);
    }
  }
  
  private void b(WebViewPlugin.a parama, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        if (new JSONObject(paramString).getInt("result") == 1)
        {
          ands.ap(0, parama.a().getLongAccountUin());
          return;
        }
      }
      catch (Throwable parama)
      {
        QLog.e(this.TAG, 1, "handleCancellationStatus... e:", parama);
      }
    }
  }
  
  private void jA(String paramString1, String paramString2)
  {
    Object localObject = this.f.mRuntime.getActivity();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent();
      localIntent.putExtras(awhu.d(localIntent.getExtras(), paramString1));
      ((Activity)localObject).setResult(-1, localIntent);
    } while (TextUtils.isEmpty(paramString2));
    localObject = localIntent.getStringExtra("key_parse_json_status");
    paramString1 = "{\"ret\":0, \"msg\":\"sucess\"}";
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString1 = "{\"ret\":-1, \"msg\":\"" + (String)localObject + "\"}";
    }
    this.f.callJs(paramString2, new String[] { paramString1 });
  }
  
  private void jB(String paramString1, String paramString2)
  {
    paramString1 = this.f.mRuntime.getActivity();
    if ((paramString1 == null) || (paramString1.isFinishing()) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      do
      {
        return;
        paramString1 = paramString1.getIntent();
      } while (paramString1 == null);
      paramString1 = paramString1.getExtras();
    } while (paramString1 == null);
    paramString1 = awhu.l(paramString1);
    this.f.callJs(paramString2, new String[] { paramString1 });
  }
  
  private void jC(String paramString1, String paramString2)
  {
    Object localObject = this.f.mRuntime.getActivity();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent();
      localIntent.putExtras(awhu.c(localIntent.getExtras(), paramString1));
      ((Activity)localObject).setResult(-1, localIntent);
    } while (TextUtils.isEmpty(paramString2));
    localObject = localIntent.getStringExtra("key_parse_json_status");
    paramString1 = "{\"ret\":0, \"msg\":\"sucess\"}";
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString1 = "{\"ret\":-1, \"msg\":\"" + (String)localObject + "\"}";
    }
    this.f.callJs(paramString2, new String[] { paramString1 });
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.f == null) || (this.f.mRuntime == null)) {
      return false;
    }
    if ((paramString3.equals("getUgcSetting")) && (paramVarArgs != null) && (paramVarArgs.length >= 1)) {
      try
      {
        abA(new JSONObject(paramVarArgs[0]).optString("callback"));
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return true;
      }
    }
    if ((paramString3.equals("setUgcSetting")) && (paramVarArgs != null) && (paramVarArgs.length >= 1)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        jC(paramVarArgs[0], paramJsBridgeListener.optString("callback"));
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return true;
      }
    }
    if ((paramString3.equals("getLiveUgcSetting")) && (paramVarArgs != null) && (paramVarArgs.length >= 1)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        jB(paramVarArgs[0], paramJsBridgeListener.optString("callback"));
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return true;
      }
    }
    if ((paramString3.equals("setLiveUgcSetting")) && (paramVarArgs != null) && (paramVarArgs.length >= 1)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        jA(paramVarArgs[0], paramJsBridgeListener.optString("callback"));
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return true;
      }
    }
    if ((paramString3.equals("UpdateFriendSetting")) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      abB(paramVarArgs[0]);
      return true;
    }
    if ((paramString3.equals("reopenQzone")) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      b(this.f.mRuntime, paramVarArgs[0]);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awht
 * JD-Core Version:    0.7.0.1
 */