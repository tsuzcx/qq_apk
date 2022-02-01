import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class mfk
  extends mfj
{
  private static int aRc = 0;
  private static String agw;
  private static String agx;
  private static JSONObject au;
  private static List<String> iG;
  private static String sSkinId = "";
  
  public static JSONObject G()
  {
    if (au == null) {}
    try
    {
      au = new JSONObject(aqhq.readFileToString(new File(jG() + "/colors.json")));
      return au;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public static void aOV()
  {
    Object localObject = null;
    try
    {
      String str = aqhq.readFileToString(new File(jI() + "refreshConfig.json"));
      localObject = str;
      JSONObject localJSONObject = new JSONObject(str);
      if (localJSONObject != null)
      {
        localObject = str;
        aRc = localJSONObject.optInt("refresh_type");
        localObject = str;
        agw = localJSONObject.optString("voice_path");
        localObject = str;
        agx = localJSONObject.optString("rain_animate_path");
      }
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("CommonSkinRes", 1, "parseRefreshParaJson error json = " + localIOException);
      localJSONException.printStackTrace();
    }
  }
  
  private static void aOW()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonSkinRes", 2, "clearDataAfterSetSkin()");
    }
    aRc = 0;
    agw = null;
    agx = null;
    iG = null;
    au = null;
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
    if (aRc == 1) {
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
            break label199;
          }
          localObject1 = new File(jI() + "refreshRandomPictures" + "/");
          break;
        }
      }
      iG = (List)localObject2;
      return localObject2;
      label199:
      localObject1 = null;
    }
  }
  
  public static boolean dS(String paramString)
  {
    return anyk.E(new File(eP(paramString)));
  }
  
  public static String eP(String paramString)
  {
    return getResPath() + paramString;
  }
  
  public static String eQ(String paramString)
  {
    return jH() + paramString;
  }
  
  public static String getResPath()
  {
    return aqul.getSDKPrivatePath(acbn.SDCARD_PATH + ".readInjoy/skin_res/");
  }
  
  public static String jG()
  {
    return eP(sSkinId);
  }
  
  public static String jH()
  {
    return aqul.getSDKPrivatePath(acbn.SDCARD_PATH + ".readInjoy/skin_guide/");
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
  
  static void nC(String paramString)
  {
    if (!sSkinId.equals(paramString))
    {
      sSkinId = paramString;
      aOW();
    }
  }
  
  public static int oH()
  {
    if (aRc == 0) {
      aOV();
    }
    return aRc;
  }
  
  public Drawable a(Resources paramResources, String paramString1, String paramString2)
  {
    paramResources = new mfk.a();
    paramResources.normalDrawable = getDrawable(paramString1);
    paramResources.cE = getDrawable(paramString2);
    paramString1 = paramResources.cE;
    paramResources.addState(new int[] { 16842913 }, paramString1);
    paramString1 = paramResources.cE;
    paramResources.addState(new int[] { 16842912 }, paramString1);
    paramString1 = paramResources.normalDrawable;
    paramResources.addState(new int[] { -16842919 }, paramString1);
    return paramResources;
  }
  
  public int getColor(String paramString)
  {
    JSONObject localJSONObject = G();
    if (localJSONObject == null) {
      return 0;
    }
    return Color.parseColor(localJSONObject.optString(paramString));
  }
  
  public Drawable getDrawable(String paramString)
  {
    Object localObject2 = jG() + "/" + paramString;
    Object localObject1 = new File((String)localObject2 + ".gif");
    paramString = (String)localObject1;
    if (!((File)localObject1).exists())
    {
      localObject1 = new File((String)localObject2 + ".png");
      paramString = (String)localObject1;
      if (!((File)localObject1).exists())
      {
        paramString = new File((String)localObject2 + ".jpg");
        if (!paramString.exists()) {
          break label220;
        }
      }
    }
    localObject1 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = akyr.lP(paramString.getAbsolutePath());
    localObject2 = new ColorDrawable(0);
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
    ((URLDrawable.URLDrawableOptions)localObject1).mUseAutoScaleParams = true;
    ((URLDrawable.URLDrawableOptions)localObject1).mUseMemoryCache = false;
    label220:
    label229:
    for (;;)
    {
      try
      {
        paramString = paramString.toURL();
        if (!((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage) {
          break label229;
        }
        paramString = new URL("readinjoy_skin_gif", paramString.getAuthority(), paramString.getFile());
        paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        paramString.printStackTrace();
      }
      return new ColorDrawable(0);
    }
  }
  
  public static class a
    extends StateListDrawable
  {
    public Drawable cE;
    public Drawable normalDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mfk
 * JD-Core Version:    0.7.0.1
 */