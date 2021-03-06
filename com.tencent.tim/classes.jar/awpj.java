import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class awpj
  extends WebViewPlugin
{
  public awpj()
  {
    this.mPluginNameSpace = "Weiyun";
  }
  
  public static boolean ud(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return bool1;
      }
      paramString = Uri.parse(paramString);
      String str = paramString.getScheme();
      if (("http".equalsIgnoreCase(str)) || ("https".equalsIgnoreCase(str)))
      {
        paramString = paramString.getHost();
        bool1 = bool2;
        if (TextUtils.isEmpty(paramString)) {
          return bool1;
        }
        if (!paramString.contains("share.weiyun.com"))
        {
          bool1 = bool2;
          if (!paramString.contains("h5.weiyun.com")) {
            return bool1;
          }
        }
      }
      else
      {
        Log.e("WeiyunJsPlugin", "Weiyun urlString is not url!");
        return false;
      }
    }
    catch (Exception paramString)
    {
      Log.e("WeiyunJsPlugin", "Weiyun exception: " + paramString);
      return false;
    }
    bool1 = true;
    return bool1;
  }
  
  public WeiYunFileInfo a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    WeiYunFileInfo localWeiYunFileInfo = new WeiYunFileInfo();
    localWeiYunFileInfo.bIk = paramString4;
    localWeiYunFileInfo.strFileName = paramString3;
    localWeiYunFileInfo.nFileSize = paramLong;
    localWeiYunFileInfo.cookieName = "FTN5K";
    localWeiYunFileInfo.cookieValue = paramString2;
    localWeiYunFileInfo.cYi = 2;
    localWeiYunFileInfo.encodeUrl = aurr.decodeUrl(paramString1);
    localWeiYunFileInfo.bIz = (awri.zo() + "/" + paramString3);
    localWeiYunFileInfo.dirKey = ("FTN5K=" + paramString2);
    localWeiYunFileInfo.mtime = System.currentTimeMillis();
    return localWeiYunFileInfo;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    int i = 0;
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("Weiyun")) || (paramString3 == null)) {}
    while ((this.mRuntime == null) || (this.mRuntime.getActivity() == null) || (!paramString3.equals("createDownload"))) {
      return false;
    }
    paramString1 = paramVarArgs[0];
    try
    {
      paramJsBridgeListener = new ArrayList();
      paramString1 = new JSONObject(paramString1);
      if (paramString1.has("file_list"))
      {
        paramString1 = paramString1.getJSONArray("file_list");
        while (i < paramString1.length())
        {
          paramString2 = paramString1.getJSONObject(i);
          paramString3 = paramString2.getString("url");
          paramVarArgs = paramString2.getString("pack_name");
          String str = paramString2.getString("file_id");
          paramJsBridgeListener.add(a(paramString3, paramString2.getString("FTN5K"), paramVarArgs, str, paramString2.getLong("file_size")));
          i += 1;
        }
      }
      paramString1 = new Intent("com.weiyun.BROADCAST");
      paramString1.setPackage(MobileQQ.getContext().getPackageName());
      paramString1.putExtra("fileinfos", paramJsBridgeListener);
      this.mRuntime.getActivity().sendBroadcast(paramString1);
    }
    catch (Exception paramJsBridgeListener)
    {
      label204:
      break label204;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awpj
 * JD-Core Version:    0.7.0.1
 */