import android.os.Environment;
import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class awhr
  extends awfr
{
  private awhq a = new awhq();
  private awhq b = new awhq();
  private String cQx = "";
  private String cQy = "";
  
  private String GX()
  {
    if (TextUtils.isEmpty(this.cQx))
    {
      if (!Environment.getExternalStorageState().equals("mounted"))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QzoneSoundPlugin", 2, "no sdcard");
        }
        return "";
      }
      Object localObject = avtc.ROOT_PATH;
      this.cQx = ((String)localObject + "tencent/Qzone/tinyprogram/");
      localObject = new File(this.cQx);
      if (!((File)localObject).exists())
      {
        if (!((File)localObject).mkdirs())
        {
          if (QLog.isColorLevel()) {
            QLog.i("QzoneSoundPlugin", 2, "make dir fail");
          }
          return "";
        }
        if (QLog.isColorLevel()) {
          QLog.i("QzoneSoundPlugin", 2, "make dir suc");
        }
      }
    }
    for (;;)
    {
      return this.cQx;
      if (QLog.isColorLevel())
      {
        QLog.i("QzoneSoundPlugin", 2, "dir is exists");
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("QzoneSoundPlugin", 2, "cache root found use : " + this.cQx);
        }
      }
    }
  }
  
  private void aI(String... paramVarArgs)
  {
    if (this.a != null) {
      this.a.stop();
    }
  }
  
  private void aJ(String... paramVarArgs)
  {
    if (this.b != null) {
      this.b.stop();
    }
  }
  
  private void aK(String... paramVarArgs)
  {
    try
    {
      paramVarArgs = arwv.toMD5(new JSONObject(paramVarArgs[0]).optString("url"));
      paramVarArgs = GX() + paramVarArgs + ".mp3";
      QLog.d("QzoneSoundPlugin", 2, "playLocalSound : " + paramVarArgs);
      if (new File(paramVarArgs).exists())
      {
        this.b.gd(paramVarArgs);
        this.b.start();
      }
      return;
    }
    catch (Exception paramVarArgs) {}
  }
  
  private void aL(String... paramVarArgs)
  {
    try
    {
      paramVarArgs = arwv.toMD5(new JSONObject(paramVarArgs[0]).optString("url"));
      paramVarArgs = GX() + paramVarArgs + ".mp3";
      QLog.d("QzoneSoundPlugin", 2, "playLocalBackSound : " + paramVarArgs);
      if (new File(paramVarArgs).exists())
      {
        this.a.gd(paramVarArgs);
        this.a.start();
      }
      return;
    }
    catch (Exception paramVarArgs) {}
  }
  
  private void aM(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        Object localObject2 = new JSONObject(paramVarArgs[0]);
        paramVarArgs = ((JSONObject)localObject2).optString("callback");
        Object localObject1 = ((JSONObject)localObject2).optString("url");
        localObject2 = arwv.toMD5(((JSONObject)localObject2).optString("url"));
        QLog.d("QzoneSoundPlugin", 2, "downloadMusicUrl : " + (String)localObject1);
        QLog.d("QzoneSoundPlugin", 2, "downloadMusicMD5 : " + (String)localObject2);
        this.cQy = (GX() + (String)localObject2 + ".mp3");
        QLog.d("QzoneSoundPlugin", 2, "mDownloadMusicFinalCachePath : " + this.cQy);
        if (!new File(this.cQy).exists())
        {
          DownloaderFactory.getInstance(this.f.mRuntime.getActivity()).getCommonDownloader().download((String)localObject1, this.cQy, new awhs(this, paramVarArgs));
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QzoneSoundPlugin", 2, "The Music File is Exist");
        }
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("code", 0);
          ((JSONObject)localObject1).put("message", "success");
          this.f.callJs(paramVarArgs, new String[] { ((JSONObject)localObject1).toString() });
          return;
        }
        catch (Exception paramVarArgs)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        QLog.i("QzoneSoundPlugin", 2, "DownloaderFactory onDownloadSucceed : " + paramVarArgs.getMessage());
        return;
      }
      catch (JSONException paramVarArgs)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QzoneSoundPlugin", 2, "METHOD_DOWNLOAD_SUPER_LIKE_MUSIC: ", paramVarArgs);
        }
      }
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.f == null) || (this.f.mRuntime == null)) {
      return false;
    }
    if (paramString3.equalsIgnoreCase("playLocalSound"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneSoundPlugin", 2, "playLocalSound");
      }
      aK(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("playLocalBackSound"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneSoundPlugin", 2, "playLocalBackSound");
      }
      aL(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("preloadSound"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneSoundPlugin", 2, "preloadSound");
      }
      aM(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("stopLocalSound"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneSoundPlugin", 2, "stopLocalSound");
      }
      aJ(new String[0]);
      return true;
    }
    if (paramString3.equalsIgnoreCase("stopLocalBackSound"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneSoundPlugin", 2, "stopLocalBackSound");
      }
      aI(new String[0]);
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("QzoneSoundPlugin", 2, "onDestroy");
    }
    if (this.a != null)
    {
      this.a.release();
      this.a = null;
    }
    if (this.b != null)
    {
      this.b.release();
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awhr
 * JD-Core Version:    0.7.0.1
 */