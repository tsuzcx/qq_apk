import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class mgh
{
  private static int aRc = 0;
  private static int aRg = -1;
  private static int aRh = -1;
  private static String agC = "";
  private static String agw;
  private static String agx;
  private static List<String> iG;
  private static long vc = -1L;
  
  static void D(String paramString, long paramLong)
  {
    if ((!agC.equals(paramString)) || (vc != paramLong))
    {
      agC = paramString;
      aPa();
    }
  }
  
  public static boolean DA()
  {
    if (aRh < 0) {
      aOV();
    }
    return aRh > 0;
  }
  
  public static void aOV()
  {
    JSONObject localJSONObject = null;
    String str2 = null;
    String str1 = str2;
    Object localObject = localJSONObject;
    try
    {
      File localFile = new File(jI() + "refreshConfig.json");
      str1 = str2;
      localObject = localJSONObject;
      if (localFile.exists())
      {
        str1 = str2;
        localObject = localJSONObject;
        str2 = aqhq.readFileToString(localFile);
        str1 = str2;
        localObject = str2;
        localJSONObject = new JSONObject(str2);
        if (localJSONObject != null)
        {
          str1 = str2;
          localObject = str2;
          aRc = localJSONObject.optInt("refresh_type");
          str1 = str2;
          localObject = str2;
          agw = localJSONObject.optString("voice_path");
          str1 = str2;
          localObject = str2;
          agx = localJSONObject.optString("rain_animate_path");
          str1 = str2;
          localObject = str2;
          aRg = localJSONObject.optInt("refresh_sub_type");
          str1 = str2;
          localObject = str2;
          aRh = localJSONObject.optInt("refresh_length_type", 0);
        }
      }
      else
      {
        str1 = str2;
        localObject = localJSONObject;
        QLog.e("RefreshRes", 1, "parseRefreshParaJson error refreshConfig not exist ");
        return;
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("RefreshRes", 1, "parseRefreshParaJson JSONException json = " + localIOException);
      localJSONException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("RefreshRes", 1, localException, new Object[] { "parseRefreshParaJson error json = " + localJSONException });
      localException.printStackTrace();
    }
  }
  
  private static void aPa()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RefreshRes", 2, "clearDataAfterSetRefreshInfo()");
    }
    aRc = 0;
    agw = null;
    agx = null;
    iG = null;
    aRg = -1;
    vc = -1L;
  }
  
  public static List<String> aY()
  {
    Object localObject3 = null;
    Object localObject2;
    if (iG != null)
    {
      localObject2 = iG;
      return localObject2;
    }
    if (aRc == 0) {
      aOV();
    }
    Object localObject1;
    if ((aRc == 1) || (aRc == 3)) {
      localObject1 = new File(jI() + "refreshAnimatePictures" + "/");
    }
    for (;;)
    {
      localObject2 = localObject3;
      if (localObject1 == null) {
        break;
      }
      localObject2 = localObject3;
      if (!((File)localObject1).exists()) {
        break;
      }
      localObject2 = localObject3;
      if (!((File)localObject1).isDirectory()) {
        break;
      }
      localObject1 = ((File)localObject1).listFiles();
      localObject2 = localObject3;
      if (localObject1 == null) {
        break;
      }
      localObject2 = new ArrayList();
      int i = 0;
      for (;;)
      {
        if (i < localObject1.length)
        {
          if (localObject1[i].getName().endsWith(".png")) {
            ((List)localObject2).add(localObject1[i].getName());
          }
          i += 1;
          continue;
          if (aRc != 2) {
            break label206;
          }
          localObject1 = new File(jI() + "refreshRandomPictures" + "/");
          break;
        }
      }
      iG = (List)localObject2;
      return localObject2;
      label206:
      localObject1 = null;
    }
  }
  
  public static boolean dU(String paramString)
  {
    return anyk.E(new File(eP(paramString)));
  }
  
  public static String eP(String paramString)
  {
    return aqul.getSDKPrivatePath(acbn.SDCARD_PATH + ".readInjoy/refresh_res/" + paramString);
  }
  
  public static String getResPath()
  {
    return aqul.getSDKPrivatePath(acbn.SDCARD_PATH + ".readInjoy/refresh_res/");
  }
  
  public static String jG()
  {
    return aqul.getSDKPrivatePath(acbn.SDCARD_PATH + ".readInjoy/refresh_res/" + agC);
  }
  
  public static String jI()
  {
    return jG() + "/" + "refresh" + "/";
  }
  
  public static String jJ()
  {
    if ((TextUtils.isEmpty(agw)) && (aRc == 0)) {
      aOV();
    }
    if (!TextUtils.isEmpty(agw)) {
      return jI() + agw;
    }
    return null;
  }
  
  public static String jK()
  {
    if ((TextUtils.isEmpty(agx)) && (aRc == 0)) {
      aOV();
    }
    if (!TextUtils.isEmpty(agx)) {
      return jI() + agx;
    }
    return null;
  }
  
  public static String jN()
  {
    return jI() + "refreshGuideConfig";
  }
  
  public static int oH()
  {
    if (aRc == 0) {
      aOV();
    }
    return aRc;
  }
  
  public static int ph()
  {
    return aRg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mgh
 * JD-Core Version:    0.7.0.1
 */