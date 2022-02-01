import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.OpenWithQQBrowser.1;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.smtt.sdk.stat.MttLoader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class obf
  implements Handler.Callback
{
  private obf.a a;
  private boolean awc;
  private Handler bd;
  private Activity s;
  
  public obf(Activity paramActivity, obf.a parama)
  {
    this.s = paramActivity;
    this.a = parama;
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (this.awc) {
      return;
    }
    this.awc = true;
    if (this.s.isFinishing()) {
      if (this.a != null) {
        this.a.bda();
      }
    }
    for (;;)
    {
      try
      {
        new Thread(new OpenWithQQBrowser.1(this, paramString3)).start();
        return;
      }
      catch (Throwable paramContext)
      {
        return;
      }
      if (this.a != null) {
        this.a.bdb();
      }
    }
  }
  
  private void aT(String paramString, int paramInt)
  {
    if (paramInt < 12)
    {
      try
      {
        localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
        localHttpURLConnection.setDoInput(true);
        localHttpURLConnection.setConnectTimeout(20000);
        localHttpURLConnection.setRequestMethod("GET");
        localHttpURLConnection.connect();
        i = localHttpURLConnection.getResponseCode();
        if ((i != 301) && (i != 302)) {
          break label197;
        }
        paramString = localHttpURLConnection.getHeaderFields().keySet().iterator();
        do
        {
          if (!paramString.hasNext()) {
            break;
          }
          str = (String)paramString.next();
        } while (!"location".equalsIgnoreCase(str));
        paramString = localHttpURLConnection.getHeaderField(str);
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          HttpURLConnection localHttpURLConnection;
          int i;
          String str;
          paramString = null;
          continue;
          paramString = null;
          continue;
          paramString = null;
        }
      }
      if (paramString != null)
      {
        aT(MsfSdkUtils.insertMtype("Web", paramString), paramInt + 1);
        return;
      }
      paramString = null;
      str = paramString;
    }
    for (;;)
    {
      try
      {
        localHttpURLConnection.disconnect();
        if (this.bd == null) {}
        label197:
        try
        {
          if (this.bd == null) {
            this.bd = new auru(Looper.getMainLooper(), this);
          }
          Message.obtain(this.bd, 101, paramString).sendToTarget();
          return;
        }
        finally {}
        if (i == 200)
        {
          paramString = new Bundle();
          str = paramString;
          paramString.putLong("_filesize", localHttpURLConnection.getContentLength());
          str = paramString;
          paramString.putString("qb_param_url", localHttpURLConnection.getURL().toString());
          str = paramString;
          paramString.putString("param_content_des", "");
          str = paramString;
          paramString.putString("param_mime_type", localHttpURLConnection.getContentType());
        }
      }
      catch (Throwable paramString)
      {
        paramString = str;
        continue;
      }
      paramString = null;
    }
  }
  
  protected boolean a(String paramString1, boolean paramBoolean, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("KEY_PID", String.valueOf(50079));
    ((HashMap)localObject).put("KEY_EUSESTAT", String.valueOf(5));
    ((HashMap)localObject).put("ChannelID", this.s.getApplicationInfo().processName);
    ((HashMap)localObject).put("PosID", Integer.toString(paramInt));
    String str = MttLoader.getValidQBUrl(this.s, paramString1);
    paramInt = MttLoader.loadUrl(this.s, str, (HashMap)localObject, null);
    if (paramBoolean)
    {
      if (4 == paramInt)
      {
        localObject = this.s.getResources().getString(2131689526);
        a(this.s, paramString1, (String)localObject, 2131689532, paramString2);
      }
    }
    else {
      if (paramInt != 0) {
        break label222;
      }
    }
    label222:
    for (paramBoolean = true;; paramBoolean = false)
    {
      return paramBoolean;
      if (5 == paramInt)
      {
        localObject = this.s.getResources().getString(2131689525);
        a(this.s, paramString1, (String)localObject, 2131689538, paramString2);
        break;
      }
      if (paramInt == 0) {
        break;
      }
      localObject = this.s.getResources().getString(2131689526);
      a(this.s, paramString1, (String)localObject, 2131689532, paramString2);
      break;
    }
  }
  
  public boolean eq(String paramString)
  {
    return a(paramString, true, "https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10367", 0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if (!this.s.isFinishing())
    {
      paramMessage = (Bundle)paramMessage.obj;
      if (paramMessage != null)
      {
        Object localObject = this.s.getSharedPreferences("qb_info", 0);
        if (localObject != null)
        {
          paramMessage.putString("param_content_memo", ((SharedPreferences)localObject).getString("content_memo", null));
          paramMessage.putString("param_icon_path", ((SharedPreferences)localObject).getString("icon_url", null));
        }
        localObject = paramMessage.getString("qb_param_url");
        if ((localObject != null) && (((String)localObject).length() != 0))
        {
          paramMessage.remove("qb_param_url");
          agjj.a(this.s, (String)localObject, paramMessage);
        }
      }
    }
    if (this.a != null) {
      this.a.bda();
    }
    this.awc = false;
    return false;
  }
  
  static abstract interface a
  {
    public abstract void bda();
    
    public abstract void bdb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     obf
 * JD-Core Version:    0.7.0.1
 */