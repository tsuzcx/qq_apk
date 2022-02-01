import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class iou
{
  private static final String PC = igg.gB() + "SKINCOLOR" + File.separator;
  private static int aro;
  private static float gL = -1.0F;
  
  public static float Q()
  {
    if (gL != -1.0F) {
      return gL;
    }
    for (;;)
    {
      try
      {
        ioi localioi = ioi.a();
        if (localioi == null) {
          continue;
        }
        gL = localioi.Q();
        igd.aJ("EffectBeautyTools", "mBeautyRatio:" + gL);
      }
      catch (Exception localException)
      {
        igd.aJ("EffectBeautyTools", "getNewBeautyRatio Exception:" + localException);
        gL = 1.0F;
        continue;
      }
      return gL;
      gL = 1.0F;
    }
  }
  
  private static iou.b a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      igd.aJ("EffectBeautyTools", "parseConfig|content is empty.");
      return null;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString).getJSONObject("skinColorFilter");
      }
      catch (JSONException localJSONException3)
      {
        JSONObject localJSONObject;
        int i;
        String str1;
        String str2;
        localb = null;
        continue;
      }
      try
      {
        i = Integer.valueOf(localJSONObject.getString("filterid")).intValue();
        str1 = localJSONObject.getString("resurl");
        str2 = localJSONObject.getString("md5");
        localb = new iou.b(i, str1, str2);
        try
        {
          igd.aJ("EffectBeautyTools", "parseConfig:" + i + "|" + str1 + "|" + str2);
          return localb;
        }
        catch (JSONException localJSONException1) {}
      }
      catch (JSONException localJSONException4)
      {
        localb = null;
        continue;
      }
      try
      {
        localJSONException1.printStackTrace();
        igd.aJ("EffectBeautyTools", "parseConfig failed. info = " + localJSONObject);
        return localb;
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
        igd.aJ("EffectBeautyTools", "parseConfig|parse failed.context = " + paramString);
        return localb;
      }
    }
  }
  
  private static void aoV()
  {
    SharedPreferences.Editor localEditor = EffectConfigBase.a(180, EffectConfigBase.Nk).edit();
    localEditor.putInt("qav_effect_beauty_config_first_launch", 1);
    localEditor.commit();
  }
  
  public static void b(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    l(paramContext, paramString, EffectConfigBase.i(180, EffectConfigBase.Nk));
    EffectConfigBase.j(180, EffectConfigBase.Nk, paramInt, paramString);
    if (paramBoolean) {
      br(paramContext);
    }
  }
  
  public static void br(Context paramContext)
  {
    try
    {
      if (uU())
      {
        aoV();
        if (new File(PC).exists()) {
          aqhq.cn(PC);
        }
      }
      paramContext = a(EffectConfigBase.i(180, EffectConfigBase.Nk));
      if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.resUrl)))
      {
        Object localObject = new File(PC + "params.json");
        igd.aJ("EffectBeautyTools", "preDownloadResource :" + ((File)localObject).exists());
        if (!((File)localObject).exists())
        {
          localObject = new aoll();
          ((aoll)localObject).f = new iou.a();
          ((aoll)localObject).bZ = paramContext.resUrl;
          ((aoll)localObject).mHttpMethod = 0;
          ((aoll)localObject).atY = (igg.gB() + "skin_color.zip");
          ((aoll)localObject).bw(paramContext);
          ige.a().a((aomg)localObject);
        }
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private static void l(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = null;
    if (!TextUtils.isEmpty(paramString1)) {}
    for (paramContext = a(paramString1);; paramContext = null)
    {
      paramString1 = localObject;
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1 = a(paramString2);
      }
      if (paramContext == null) {
        aqhq.cn(PC);
      }
      while ((paramString1 == null) || (paramContext.resMD5.equals(paramString1.resMD5))) {
        return;
      }
      aqhq.cn(PC);
      return;
    }
  }
  
  public static boolean uB()
  {
    if (aro != 0) {
      return aro == 2;
    }
    for (;;)
    {
      try
      {
        ioi localioi = ioi.a();
        if ((localioi == null) || (!localioi.uB()) || (!uV())) {
          continue;
        }
        aro = 2;
        igd.aJ("EffectBeautyTools", "mIsSupportFlag:" + aro);
      }
      catch (Exception localException)
      {
        igd.aJ("EffectBeautyTools", "isSupportNewBeauty Exception:" + localException);
        aro = 1;
        continue;
      }
      if (aro == 2) {
        break;
      }
      return false;
      aro = 1;
    }
  }
  
  private static boolean uU()
  {
    boolean bool = false;
    int i = EffectConfigBase.a(180, EffectConfigBase.Nk).getInt("qav_effect_beauty_config_first_launch", 0);
    igd.aJ("EffectBeautyTools", "getIsFirstLauncher:" + i);
    if (i == 0) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean uV()
  {
    int i = EffectConfigBase.j(180, EffectConfigBase.Nk);
    return (new File(PC + "params.json").exists()) && (i != 0);
  }
  
  static class a
    implements aolm.b
  {
    public void onResp(aomh paramaomh)
    {
      Object localObject = (iou.b)paramaomh.b.U();
      igd.aJ("EffectBeautyTools", "download file call back. file = " + ((iou.b)localObject).resUrl);
      if (paramaomh.mResult != 0)
      {
        igd.aJ("EffectBeautyTools", "download file faild. errcode = " + paramaomh.mErrCode);
        return;
      }
      if (!((iou.b)localObject).resMD5.equalsIgnoreCase(SecUtil.getFileMd5(paramaomh.b.atY)))
      {
        igd.aJ("EffectBeautyTools", "download file faild : md5 is not match.");
        aqhq.deleteFile(paramaomh.b.atY);
        return;
      }
      igd.aJ("EffectBeautyTools", "download file successed.");
      try
      {
        localObject = igg.gB();
        aqhq.W(paramaomh.b.atY, (String)localObject, false);
        aqhq.deleteFile(paramaomh.b.atY);
        return;
      }
      catch (IOException paramaomh)
      {
        paramaomh.printStackTrace();
        igd.aJ("EffectBeautyTools", "unzip file faild.");
      }
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  }
  
  public static class b
  {
    public int id;
    public String resMD5;
    public String resUrl;
    
    public b(int paramInt, String paramString1, String paramString2)
    {
      this.id = paramInt;
      this.resUrl = paramString1;
      this.resMD5 = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iou
 * JD-Core Version:    0.7.0.1
 */