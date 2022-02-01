import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

class aikh
  implements skj.a
{
  aikh(aikg paramaikg, long paramLong1, long paramLong2, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    boolean bool = true;
    paramBundle = paramBundle.getString("videoPath");
    Object localObject;
    if (!TextUtils.isEmpty(paramBundle))
    {
      localObject = new File(paramBundle);
      if ((!((File)localObject).exists()) || (!((File)localObject).isFile())) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopApiPlugin", 2, "previewRewardVideo: videoPath=" + paramBundle + ", " + bool);
      }
      try
      {
        localObject = new JSONObject();
        if (bool)
        {
          MediaApiPlugin.a(this.a.mRuntime.getActivity(), paramBundle, this.abE, this.wU);
          ((JSONObject)localObject).put("ret", 0);
          ((JSONObject)localObject).put("errMsg", "");
        }
        for (;;)
        {
          this.a.callJs(this.val$callback, new String[] { ((JSONObject)localObject).toString() });
          return;
          ((JSONObject)localObject).put("ret", -2);
          ((JSONObject)localObject).put("errMsg", acfp.m(2131715542));
        }
        QLog.w("TroopApiPlugin", 2, "previewRewardVideo exp", paramBundle);
      }
      catch (Exception paramBundle)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aikh
 * JD-Core Version:    0.7.0.1
 */