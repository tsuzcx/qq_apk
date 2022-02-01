import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.vip.manager.MonitorManager;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class awhj
{
  public static String GW()
  {
    Object localObject1 = "";
    Object localObject2 = bQ(null);
    if (localObject2 != null)
    {
      ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("/"));
      Object localObject3 = new File((String)localObject2);
      localObject2 = localObject1;
      if (((File)localObject3).isDirectory())
      {
        localObject3 = ((File)localObject3).listFiles();
        int j = localObject3.length;
        int i = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (i >= j) {
            break;
          }
          Object localObject4 = localObject3[i];
          localObject2 = localObject1;
          if (localObject4.isDirectory()) {
            localObject2 = (String)localObject1 + localObject4.getName() + ",";
          }
          i += 1;
          localObject1 = localObject2;
        }
      }
      if (((String)localObject2).length() > 0) {
        return ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
      }
      return "";
    }
    return "";
  }
  
  public static String bQ(Context paramContext)
  {
    return sf("avatar");
  }
  
  public static String sf(String paramString)
  {
    Object localObject = awhj.a.getExternalCacheDir();
    if (localObject == null) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = ((File)localObject).getAbsolutePath();
      localObject = str;
    } while (TextUtils.isEmpty(paramString));
    paramString = new File(str + File.separator + paramString);
    try
    {
      if (paramString.isFile()) {
        FileUtils.delete(paramString);
      }
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return paramString.getAbsolutePath();
    }
    finally {}
  }
  
  public static void x(WebViewPlugin.a parama, String... paramVarArgs)
  {
    j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("QZoneFacadeJsHandleLogic", 2, "handleSetFacadeFinish");
    }
    if ((parama.a() == null) || (parama.getActivity() == null)) {
      return;
    }
    LocalMultiProcConfig.putInt4Uin("key_personalize_prefix_19", 0, Long.valueOf(parama.a().getCurrentAccountUin()).longValue());
    Intent localIntent = new Intent("action_facade_js2qzone");
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", "setAvatar");
    localIntent.putExtras(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneFacadeJsHandleLogic", 2, "actionString: " + localIntent.getAction());
    }
    avpw.a(parama.getActivity(), avpw.d.a(), localIntent);
    i = j;
    if (paramVarArgs != null)
    {
      i = j;
      if (paramVarArgs.length >= 1)
      {
        i = j;
        if (TextUtils.isEmpty(paramVarArgs[0])) {}
      }
    }
    for (;;)
    {
      try
      {
        i = new JSONObject(paramVarArgs[0]).optInt("need_jump");
        if (i != 1) {
          continue;
        }
        i = j;
      }
      catch (Exception paramVarArgs)
      {
        QLog.e("QZoneFacadeJsHandleLogic", 1, paramVarArgs.getMessage());
        MonitorManager.a().d(15, 4, " parse json error " + paramVarArgs.getStackTrace(), false);
        i = j;
        continue;
      }
      if (i == 0) {
        break;
      }
      parama.getActivity().finish();
      return;
      i = 0;
    }
  }
  
  public static void y(WebViewPlugin.a parama, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneFacadeJsHandleLogic", 2, "handleDownloadFacadeFinish");
    }
    String str1 = "";
    Object localObject3 = "";
    str2 = "";
    localObject4 = str2;
    Object localObject2 = localObject3;
    Object localObject1 = str1;
    if (paramVarArgs != null)
    {
      localObject4 = str2;
      localObject2 = localObject3;
      localObject1 = str1;
      if (paramVarArgs.length > 0)
      {
        localObject2 = localObject3;
        localObject1 = str1;
      }
    }
    try
    {
      localObject4 = new JSONObject(paramVarArgs[0]);
      localObject2 = localObject3;
      localObject1 = str1;
      paramVarArgs = ((JSONObject)localObject4).getString("avatarID");
      localObject2 = localObject3;
      localObject1 = paramVarArgs;
      localObject3 = ((JSONObject)localObject4).getString("avatarUrl");
      localObject2 = localObject3;
      localObject1 = paramVarArgs;
      localObject4 = ((JSONObject)localObject4).getString("type");
      localObject1 = paramVarArgs;
      localObject2 = localObject3;
    }
    catch (JSONException paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
        localObject4 = str2;
      }
    }
    if ((!TextUtils.isEmpty(localObject2)) && (parama.getActivity() != null))
    {
      paramVarArgs = new Intent("action_facade_js2qzone");
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("avatarId", (String)localObject1);
      ((Bundle)localObject3).putString("avatarUrl", localObject2);
      ((Bundle)localObject3).putString("type", (String)localObject4);
      ((Bundle)localObject3).putString("cmd", "downloadAvatar");
      paramVarArgs.putExtras((Bundle)localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneFacadeJsHandleLogic", 2, "actionString: " + paramVarArgs.getAction());
      }
      avpw.a(parama.getActivity(), avpw.d.a(), paramVarArgs);
    }
  }
  
  public static void z(WebViewPlugin.a parama, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneFacadeJsHandleLogic", 2, "handleCheckDownloadedIdList");
    }
    paramVarArgs = GW();
    parama = parama.getWebView();
    if (parama != null) {
      parama.callJs("window.QzAvatarDressJSInterface.onReceive({type:\"idlist\",data:\"" + paramVarArgs + "\"});");
    }
  }
  
  static class a
  {
    public static File getExternalCacheDir()
    {
      try
      {
        String str = avtc.cNo;
        File localFile1 = new File(str);
        boolean bool = localFile1.exists();
        if (!bool) {
          try
          {
            new File(str, ".nomedia").createNewFile();
            if (!localFile1.mkdirs())
            {
              if (QLog.isColorLevel()) {
                QLog.w("InnerEnvironment", 2, "Unable to create external cache directory");
              }
              return null;
            }
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              localIOException.printStackTrace();
            }
          }
        }
      }
      finally {}
      return localFile2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awhj
 * JD-Core Version:    0.7.0.1
 */