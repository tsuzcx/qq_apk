import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.json.JSONObject;

public class aqpr
  implements Manager
{
  private aqva b;
  public aqvd c;
  QQAppInterface mApp;
  aquy v = new aqps(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
  
  public aqpr(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.b = ((aqva)paramQQAppInterface.getManager(47));
  }
  
  public static String a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2)
  {
    Object localObject = "";
    if (paramInt2 == 3)
    {
      localObject = aqwu.a(paramAppRuntime, 0, null).getString("_3_" + paramInt1, null);
      paramAppRuntime = (AppRuntime)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramAppRuntime = aqqj.getUrl("colorringAudio");
      }
    }
    for (;;)
    {
      localObject = paramAppRuntime;
      if (paramAppRuntime != null) {
        localObject = paramAppRuntime.replace("[id]", String.valueOf(paramInt1));
      }
      return localObject;
      if (paramInt2 == 2)
      {
        paramAppRuntime = aqqj.getUrl("colorringConfig");
      }
      else
      {
        paramAppRuntime = (AppRuntime)localObject;
        if (paramInt2 == 1) {
          paramAppRuntime = aqqj.getUrl("colorringCover");
        }
      }
    }
  }
  
  public static JSONObject a(long paramLong)
  {
    Object localObject = new File(aqpq.cuS + File.separator + paramLong + File.separator + "config.txt");
    try
    {
      localObject = aqhq.readFileContent((File)localObject);
      if (localObject != null)
      {
        localObject = new JSONObject((String)localObject);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static void af(String paramString1, int paramInt, String paramString2) {}
  
  public static Bitmap e(long paramLong)
  {
    if (paramLong == 0L) {}
    for (;;)
    {
      return null;
      Object localObject = p(paramLong, 1);
      if (new File((String)localObject).exists())
      {
        try
        {
          localObject = BitmapFactory.decodeFile((String)localObject);
          return localObject;
        }
        catch (OutOfMemoryError localOutOfMemoryError) {}
        if (QLog.isColorLevel()) {
          QLog.d("ColorRingManager", 2, "getCoverBitmap OOM.");
        }
      }
    }
  }
  
  public static String p(long paramLong, int paramInt)
  {
    if (paramLong == 0L) {}
    do
    {
      return "";
      if (paramInt == 2) {
        return aqpq.cuS + File.separator + paramLong + File.separator + "config.txt";
      }
      if (paramInt == 1) {
        return aqpq.cuS + File.separator + paramLong + File.separator + "cover.jpg";
      }
    } while (paramInt != 3);
    return aqpq.cuS + File.separator + paramLong + File.separator + "ring.mp3";
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, ">>startDownload, id=" + paramInt1);
    }
    if (paramInt1 == 0) {}
    label284:
    do
    {
      return;
      String str = p(paramInt1, paramInt2);
      File localFile = new File(str);
      if ((localFile.exists()) && (localFile.isFile())) {}
      Bundle localBundle;
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorRingManager", 2, "startDownload exists(), id=" + paramInt1 + ", resType=ring3,, isIPC=" + paramBoolean + ", srcType=" + paramInt3 + ", fileExist=" + bool);
        }
        if ((bool) && (!paramBoolean)) {
          break;
        }
        localBundle = new Bundle();
        localBundle.putInt("callId", paramInt1);
        localBundle.putString("path", str);
        localBundle.putBoolean("isIPC", paramBoolean);
        localBundle.putInt("resourceType", paramInt2);
        localBundle.putInt("srcType", paramInt3);
        localBundle.putString("path", str);
        localBundle.putString("colorType", paramString);
        paramString = a(this.mApp, paramInt1, paramInt2);
        if (!bool) {
          break label284;
        }
        localBundle.putBoolean("isExists", true);
        paramString = new aquz(paramString, localFile);
        paramString.setStatus(3);
        paramString.errCode = 0;
        paramString.dy(localBundle);
        this.v.onDone(paramString);
        return;
      }
      paramString = new aquz(paramString, new File(str + ".tmp"));
      paramString.atX = 3145728L;
      paramString.cWl = true;
      this.b.a(1).a(paramString, this.v, localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("ColorRingManager", 2, "<<startDownload, id=" + paramInt1);
  }
  
  public void kn(int paramInt1, int paramInt2)
  {
    this.b.a(1).a(true, a(this.mApp, paramInt1, paramInt2));
  }
  
  public void onDestroy()
  {
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqpr
 * JD-Core Version:    0.7.0.1
 */