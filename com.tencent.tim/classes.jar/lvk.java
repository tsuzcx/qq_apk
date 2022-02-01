import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class lvk
{
  public static boolean H(String paramString1, String paramString2)
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = jqj.D(paramString1, paramString2);
      bool1 = bool2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("PTSOfflineUtil", 1, "[checkOfflineDirIsValid], t = " + localThrowable);
      }
    }
    QLog.i("PTSOfflineUtil", 1, "[checkOfflineDirIsValid], res = " + bool1 + ", bid = " + paramString2 + ", dir = " + paramString1);
    return bool1;
  }
  
  public static boolean dO(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = eM(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("PTSOfflineUtil", 1, "[checkOfflineVersionIsValid], configStr = " + (String)localObject);
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      bool1 = npv.b(((JSONObject)localObject).optString("min_version", null), ((JSONObject)localObject).optString("max_version", null), ((JSONObject)localObject).optString("min_android_build", null), ((JSONObject)localObject).optString("max_android_build", null));
      QLog.i("PTSOfflineUtil", 1, "[checkOfflineVersionIsValid], res = " + bool1 + ", configPath = " + paramString);
      return bool1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.i("PTSOfflineUtil", 1, "[checkOfflineVersionIsValid], e = " + localJSONException);
        bool1 = bool2;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("PTSOfflineUtil", 1, "[checkOfflineVersionIsValid], t = " + localThrowable);
        bool1 = bool2;
      }
    }
  }
  
  public static String eM(String paramString)
  {
    QLog.i("PTSOfflineUtil", 1, "[loadFilePathAsString], path = " + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = new File(paramString);
    try
    {
      if (!paramString.exists())
      {
        QLog.i("PTSOfflineUtil", 1, "[loadFilePathAsString], file not exist.");
        return "";
      }
      paramString = new FileInputStream(paramString);
      byte[] arrayOfByte = new byte[paramString.available()];
      paramString.read(arrayOfByte);
      paramString.close();
      paramString = new String(arrayOfByte);
      return paramString;
    }
    catch (IOException paramString)
    {
      QLog.e("PTSOfflineUtil", 1, "[loadFilePathAsString], e = " + paramString);
      return "";
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.e("PTSOfflineUtil", 1, "[loadFilePathAsString], t = " + paramString);
      }
    }
  }
  
  public static String eN(String paramString)
  {
    String str4 = "no version";
    String str1 = str4;
    if (!TextUtils.isEmpty(paramString))
    {
      str1 = eM(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("PTSOfflineUtil", 1, "[getOfflineCurrentVersion], configStr = " + str1);
      }
    }
    try
    {
      str1 = new JSONObject(str1).optString("pts_version", "no version");
      QLog.i("PTSOfflineUtil", 1, "[getOfflineCurrentVersion], res = " + str1 + ", configPath = " + paramString);
      return str1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.i("PTSOfflineUtil", 1, "[getOfflineCurrentVersion], e = " + localJSONException);
        String str2 = str4;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("PTSOfflineUtil", 1, "[getOfflineCurrentVersion], t = " + localThrowable);
        String str3 = str4;
      }
    }
  }
  
  public static class a
    implements jox
  {
    public void loaded(String paramString, int paramInt) {}
    
    public void progress(int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lvk
 * JD-Core Version:    0.7.0.1
 */