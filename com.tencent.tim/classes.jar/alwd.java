import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.1;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.2;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.4;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.6;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.7;
import com.tencent.mobileqq.richmedia.capture.data.CaptureRedDotConfig;
import com.tencent.mobileqq.richmedia.capture.data.CaptureRedDotConfig.CategoryRedConfig;
import com.tencent.mobileqq.richmedia.capture.data.CaptureRedDotConfig.RedDotItemConfig;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.b;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class alwd
{
  public static File aH;
  public static File aI;
  public static final Long ab = Long.valueOf(2000L);
  public static String bYM = "ptv_template_usable";
  public static String bYN = "ptv_debug";
  public static String bYO = aI.getPath() + File.separator + bYO + File.separator;
  public static int dyy;
  static Object ez = new Object();
  public List<alwl> Fu = new CopyOnWriteArrayList();
  public alwd.c a;
  CaptureRedDotConfig a;
  private alwl jdField_b_of_type_Alwl;
  private anhn jdField_b_of_type_Anhn;
  String bYP;
  String bYQ;
  public Handler dl = new Handler(ThreadManager.getSubThreadLooper());
  public PtvTemplateManager.PtvTemplateInfo f;
  HashMap<Integer, alwd.a> mBusinessParams = new HashMap();
  
  static
  {
    File localFile = BaseApplicationImpl.getApplication().getCacheDir();
    aH = new File(localFile, "capture_ptv_template");
    bYM = aH.getPath() + File.separator + bYM + File.separator;
    bYN = aH.getPath() + File.separator + bYN;
    aI = new File(localFile, "new_ptv_template");
  }
  
  private alwd.e a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.b paramb)
  {
    alwd.e locale = new alwd.e();
    locale.g = paramPtvTemplateInfo;
    locale.c = paramb;
    paramb = new alwd.d();
    paramb.mName = paramPtvTemplateInfo.dgStageName;
    paramb.bYT = paramPtvTemplateInfo.dgStageResmd5;
    paramb.bYU = paramPtvTemplateInfo.dgStageResurl;
    paramb.usable = paramPtvTemplateInfo.dgStageUsable;
    paramb.czU = false;
    locale.items.add(paramb);
    paramb = new alwd.d();
    paramb.mName = paramPtvTemplateInfo.dgModelName;
    paramb.bYT = paramPtvTemplateInfo.dgModelResmd5;
    paramb.bYU = paramPtvTemplateInfo.dgModelResurl;
    paramb.usable = paramPtvTemplateInfo.dgModelUsable;
    paramb.czU = false;
    locale.items.add(paramb);
    paramb = new alwd.d();
    paramb.mName = paramPtvTemplateInfo.name;
    paramb.bYT = paramPtvTemplateInfo.md5;
    paramb.bYU = paramPtvTemplateInfo.resurl;
    paramb.usable = paramPtvTemplateInfo.usable;
    paramb.czU = true;
    locale.items.add(paramb);
    locale.dyz = 3;
    return locale;
  }
  
  public static final alwd a()
  {
    return alwd.b.b();
  }
  
  public static List<alwl> a(alwd paramalwd, String paramString, CaptureRedDotConfig paramCaptureRedDotConfig)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, "parseConfigRaw " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (paramalwd != null)
        {
          if (localJSONObject.has("guide_video_url")) {
            paramalwd.bYP = localJSONObject.getString("guide_video_url");
          }
          if (localJSONObject.has("guide_video_md5")) {
            paramalwd.bYQ = localJSONObject.getString("guide_video_md5");
          }
          if (localJSONObject.has("gestureGapFrame")) {
            atao.f.cdv = localJSONObject.getString("gestureGapFrame");
          }
          if (localJSONObject.has("gestureGapTime")) {
            atao.f.cdw = localJSONObject.getString("gestureGapTime");
          }
          if (localJSONObject.has("gesturethreadcoldtime")) {
            atao.f.cdx = localJSONObject.getString("gesturethreadcoldtime");
          }
          if (localJSONObject.has("gestureShouldUpload")) {
            atao.f.cFf = localJSONObject.getBoolean("gestureShouldUpload");
          }
        }
        Object localObject1 = "";
        Object localObject2 = "";
        String str2 = "";
        String str1 = str2;
        paramString = (String)localObject2;
        paramalwd = (alwd)localObject1;
        Object localObject3;
        if (localJSONObject.has("bigheadCommonRes"))
        {
          localObject3 = localJSONObject.getJSONObject("bigheadCommonRes");
          str1 = str2;
          paramString = (String)localObject2;
          paramalwd = (alwd)localObject1;
          if (localObject3 != null)
          {
            paramalwd = ((JSONObject)localObject3).optString("bighead_model_name", "");
            str1 = ((JSONObject)localObject3).optString("bighead_model_resurl", "");
            paramString = ((JSONObject)localObject3).optString("bighead_model_resmd5", "");
          }
        }
        if (paramCaptureRedDotConfig != null)
        {
          int j = localJSONObject.optInt("iconRedDotVersion");
          boolean bool = localJSONObject.optBoolean("needRedDot");
          int k = localJSONObject.optInt("redDotShowTime", CaptureRedDotConfig.SHOW_TIME_DEFAULT);
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_PTV", 2, "parseConfig|oldVer= " + paramCaptureRedDotConfig.iconVersion + ",ver=" + j + ",showRed=" + bool + ",showTime=" + k);
          }
          paramCaptureRedDotConfig.showTime = k;
          if (paramCaptureRedDotConfig.iconVersion != j)
          {
            paramCaptureRedDotConfig.iconVersion = j;
            paramCaptureRedDotConfig.showRedDot = bool;
            paramCaptureRedDotConfig.hasShow = false;
            paramCaptureRedDotConfig.firstShowTime = 0L;
          }
          j = localJSONObject.optInt("defaultCategoryVersion");
          k = localJSONObject.optInt("defaultCategoryId", -1);
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_PTV", 2, "parseConfig|oldVer= " + paramCaptureRedDotConfig.defaultCategoryVer + ",ver=" + j + ",defaultCategoryId=" + k);
          }
          if (paramCaptureRedDotConfig.defaultCategoryVer != j)
          {
            paramCaptureRedDotConfig.defaultCategoryVer = j;
            paramCaptureRedDotConfig.defaultCategoryId = k;
            paramCaptureRedDotConfig.hasChoose = false;
          }
          j = localJSONObject.optInt("defaultUseVersion");
          localObject1 = localJSONObject.optString("defaultUseId");
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_PTV", 2, "parseConfig|oldVer= " + paramCaptureRedDotConfig.defaultUseVer + ",ver=" + j + ",defaultUseId=" + (String)localObject1);
          }
          if (paramCaptureRedDotConfig.defaultUseVer != j)
          {
            paramCaptureRedDotConfig.defaultUseVer = j;
            paramCaptureRedDotConfig.defaultUseId = ((String)localObject1);
            paramCaptureRedDotConfig.hasUse = false;
          }
          j = localJSONObject.optInt("itemRedDotVersion");
          if (paramCaptureRedDotConfig.redDotVersion != j)
          {
            paramCaptureRedDotConfig.redDotVersion = j;
            paramCaptureRedDotConfig.redDotItems.clear();
            if (localJSONObject.has("itemNeedRedDot"))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("parseConfig|redDotList:");
              localObject2 = localJSONObject.getJSONArray("itemNeedRedDot");
              if (i < ((JSONArray)localObject2).length())
              {
                str2 = ((JSONArray)localObject2).optString(i);
                if (TextUtils.isEmpty(str2)) {
                  break label863;
                }
                localObject3 = new CaptureRedDotConfig.RedDotItemConfig();
                ((CaptureRedDotConfig.RedDotItemConfig)localObject3).filterId = str2;
                ((StringBuilder)localObject1).append(str2).append(",");
                paramCaptureRedDotConfig.redDotItems.put(str2, localObject3);
                break label863;
              }
              if (QLog.isColorLevel()) {
                QLog.d("QIMRedDotConfig_PTV", 2, "parseConfig|redDotItem= " + ((StringBuilder)localObject1).toString());
              }
            }
          }
        }
        if (!localJSONObject.has("category")) {
          break;
        }
        paramCaptureRedDotConfig = a(localJSONObject.getJSONArray("category"), paramCaptureRedDotConfig);
        a(paramCaptureRedDotConfig, paramalwd, str1, paramString);
        return paramCaptureRedDotConfig;
      }
      catch (JSONException paramalwd) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      paramalwd.printStackTrace();
      return null;
      label863:
      i += 1;
    }
  }
  
  static List<alwl> a(JSONArray paramJSONArray, CaptureRedDotConfig paramCaptureRedDotConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, "parse config: " + paramJSONArray);
    }
    if (paramJSONArray == null) {
      return null;
    }
    int j = paramJSONArray.length();
    if (j <= 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < j) {}
    for (;;)
    {
      alwl localalwl;
      Object localObject3;
      int k;
      Object localObject4;
      Object localObject5;
      try
      {
        localalwl = new alwl();
        localObject3 = paramJSONArray.getJSONObject(i);
        if (((JSONObject)localObject3).has("content")) {
          localalwl.Fv = PtvTemplateManager.PtvTemplateInfo.convertFrom(((JSONObject)localObject3).getJSONArray("content"));
        }
        if (((JSONObject)localObject3).has("categoryName")) {
          localalwl.categoryName = ((JSONObject)localObject3).getString("categoryName");
        }
        if (((JSONObject)localObject3).has("GetRedBag"))
        {
          if (((JSONObject)localObject3).getInt("GetRedBag") == 1)
          {
            bool = true;
            localalwl.czY = bool;
            anjo.bB((JSONObject)localObject3);
          }
        }
        else
        {
          if ((((JSONObject)localObject3).has("TipsVer")) && (((JSONObject)localObject3).has("Tips")))
          {
            localalwl.dyC = ((JSONObject)localObject3).getInt("TipsVer");
            localalwl.bZc = ((JSONObject)localObject3).getString("Tips");
          }
          if (!((JSONObject)localObject3).has("categoryId")) {
            break label488;
          }
          localalwl.categoryId = ((JSONObject)localObject3).getInt("categoryId");
          if (paramCaptureRedDotConfig == null) {
            break label711;
          }
          k = ((JSONObject)localObject3).optInt("redDotVersion");
          bool = ((JSONObject)localObject3).optBoolean("needRedDot");
          localObject1 = (CaptureRedDotConfig.CategoryRedConfig)paramCaptureRedDotConfig.categories.get(Integer.valueOf(localalwl.categoryId));
          if (localObject1 == null) {
            break label425;
          }
          if (((CaptureRedDotConfig.CategoryRedConfig)localObject1).version == k) {
            break label708;
          }
          ((CaptureRedDotConfig.CategoryRedConfig)localObject1).version = k;
          ((CaptureRedDotConfig.CategoryRedConfig)localObject1).showRedDot = bool;
          ((CaptureRedDotConfig.CategoryRedConfig)localObject1).hasShow = false;
          ((CaptureRedDotConfig.CategoryRedConfig)localObject1).firstShowTime = 0L;
          if ((localalwl.Fv == null) || (localalwl.Fv.isEmpty())) {
            break label461;
          }
          localObject4 = localalwl.Fv.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label461;
          }
          localObject5 = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject4).next();
          ((PtvTemplateManager.PtvTemplateInfo)localObject5).categoryId = localalwl.categoryId;
          ((PtvTemplateManager.PtvTemplateInfo)localObject5).categoryName = localalwl.categoryName;
          continue;
          return localArrayList;
        }
      }
      catch (JSONException paramJSONArray)
      {
        if (QLog.isColorLevel()) {
          paramJSONArray.printStackTrace();
        }
      }
      boolean bool = false;
      continue;
      label425:
      Object localObject1 = new CaptureRedDotConfig.CategoryRedConfig();
      ((CaptureRedDotConfig.CategoryRedConfig)localObject1).categoryId = localalwl.categoryId;
      ((CaptureRedDotConfig.CategoryRedConfig)localObject1).version = k;
      ((CaptureRedDotConfig.CategoryRedConfig)localObject1).showRedDot = bool;
      continue;
      label461:
      if ((paramCaptureRedDotConfig != null) && (localObject1 != null)) {
        paramCaptureRedDotConfig.categories.put(Integer.valueOf(((CaptureRedDotConfig.CategoryRedConfig)localObject1).categoryId), localObject1);
      }
      label488:
      bool = ((JSONObject)localObject3).has("commonRes");
      if (bool) {
        try
        {
          Object localObject6 = ((JSONObject)localObject3).getJSONObject("commonRes");
          localObject1 = ((JSONObject)localObject6).getString("dg_stage_name");
          RecentDanceConfigMgr.po((String)localObject1);
          localObject3 = ((JSONObject)localObject6).getString("dg_stage_resurl");
          localObject4 = ((JSONObject)localObject6).getString("dg_stage_resmd5");
          localObject5 = ((JSONObject)localObject6).getString("dg_model_name");
          String str = ((JSONObject)localObject6).getString("dg_model_resurl");
          localObject6 = ((JSONObject)localObject6).getString("dg_model_resmd5");
          if (localalwl.Fv != null)
          {
            Iterator localIterator = localalwl.Fv.iterator();
            while (localIterator.hasNext())
            {
              PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localIterator.next();
              if ((localPtvTemplateInfo.kind == 3) || (localPtvTemplateInfo.kind == 4))
              {
                localPtvTemplateInfo.dgStageName = ((String)localObject1);
                localPtvTemplateInfo.dgStageResurl = ((String)localObject3);
                localPtvTemplateInfo.dgStageResmd5 = ((String)localObject4);
                localPtvTemplateInfo.dgModelName = ((String)localObject5);
                localPtvTemplateInfo.dgModelResurl = str;
                localPtvTemplateInfo.dgModelResmd5 = ((String)localObject6);
              }
            }
          }
          localArrayList.add(localalwl);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      i += 1;
      break;
      label708:
      continue;
      label711:
      Object localObject2 = null;
    }
  }
  
  private void a(alwd.e parame)
  {
    alwd.a locala2 = (alwd.a)this.mBusinessParams.get(Integer.valueOf(parame.dyz));
    alwd.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new alwd.a();
      this.mBusinessParams.put(Integer.valueOf(parame.dyz), locala1);
    }
    locala1.yZ.add(parame);
  }
  
  private void a(alwd.e parame, alwd.d paramd, long paramLong1, long paramLong2)
  {
    if ((parame == null) || (paramd == null)) {}
    do
    {
      alwd.a locala;
      do
      {
        return;
        locala = (alwd.a)this.mBusinessParams.get(Integer.valueOf(parame.dyz));
        if (locala != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("CapturePtvTemplateManager", 2, "multiSessionDownloadProcessUpdate: BusinessParam=null  kind=" + parame.dyz + " mItem.mName=" + paramd.mName);
      return;
      paramd.ahM = paramLong1;
      paramd.totalLen = paramLong2;
      paramd.czV = true;
      paramLong2 = 0L;
      paramLong1 = 1L;
      paramd = parame.items.iterator();
      while (paramd.hasNext())
      {
        alwd.d locald = (alwd.d)paramd.next();
        if (!locald.usable)
        {
          locald = (alwd.d)locala.mG.get(locald.mName);
          if (locald != null) {
            if (locald.czV)
            {
              paramLong2 += locald.ahM;
              paramLong1 += locald.totalLen;
            }
            else
            {
              paramLong1 += 1000L;
            }
          }
        }
      }
    } while (parame.c == null);
    parame.c.a(parame.g, (int)(paramLong2 * 100L / paramLong1));
  }
  
  private static void a(List<alwl> paramList, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    while ((paramList == null) || (paramList.size() <= 0)) {}
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (alwl)paramList.next();
      if ((((alwl)localObject).Fv == null) || (((alwl)localObject).Fv.size() <= 0)) {
        break;
      }
      localObject = ((alwl)localObject).Fv.iterator();
      while (((Iterator)localObject).hasNext())
      {
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
        if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.kind == 20))
        {
          localPtvTemplateInfo.bigHeadName = paramString1;
          localPtvTemplateInfo.bigHeadUrl = paramString2;
          localPtvTemplateInfo.bigHeadMd5 = paramString3;
        }
      }
    }
  }
  
  private boolean a(alwd.e parame)
  {
    alwd.a locala = (alwd.a)this.mBusinessParams.get(Integer.valueOf(parame.dyz));
    if (locala != null)
    {
      if (locala.yY.size() == 0) {
        return true;
      }
      parame = parame.items.iterator();
      while (parame.hasNext())
      {
        alwd.d locald = (alwd.d)parame.next();
        if (!locala.yY.contains(locald.mName)) {}
        for (int i = 1; i == 0; i = 0) {
          return false;
        }
      }
    }
    return true;
  }
  
  private boolean a(alwd.e parame, alwd.d paramd)
  {
    if ((parame == null) || (paramd == null)) {
      return false;
    }
    alwd.a locala = (alwd.a)this.mBusinessParams.get(Integer.valueOf(parame.dyz));
    if (locala != null)
    {
      locala.yY.remove(paramd.mName);
      if (a(parame))
      {
        parame.g.usable = a(parame.g);
        paramd = this.Fu.iterator();
        while (paramd.hasNext())
        {
          Object localObject = (alwl)paramd.next();
          if (((alwl)localObject).Fv != null)
          {
            localObject = ((alwl)localObject).Fv.iterator();
            while (((Iterator)localObject).hasNext())
            {
              PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
              if (localPtvTemplateInfo.id.equals(parame.g.id)) {
                localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
              } else if (parame.dyz == localPtvTemplateInfo.kind) {
                localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
              }
            }
          }
        }
        if (parame.c != null) {
          parame.c.a(parame.g, parame.g.usable);
        }
        if (locala.yY.size() == 0) {
          locala.mG.clear();
        }
        return true;
      }
    }
    return false;
  }
  
  private void aG(QQAppInterface paramQQAppInterface, String paramString)
  {
    synchronized (ez)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig = new CaptureRedDotConfig(2);
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_PTV", 2, "parseFilterConfigZip RedDot is null");
        }
      }
      if (TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip TextUtils.isEmpty(config) return");
        }
        aarz.Gp(-1);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip config=" + paramString);
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          localObject2 = new JSONObject(paramString);
          paramString = "";
          str = "";
          if (((JSONObject)localObject2).has("pendantMD5")) {
            paramString = ((JSONObject)localObject2).getString("pendantMD5");
          }
          if (!((JSONObject)localObject2).has("pendantUrl")) {
            break label549;
          }
          ??? = ((JSONObject)localObject2).getString("pendantUrl");
          if (((JSONObject)localObject2).has("pendantName")) {
            str = ((JSONObject)localObject2).getString("pendantName");
          }
          if (QLog.isColorLevel()) {
            QLog.d("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip pendantMD5=" + paramString + " pendantUrl=" + (String)???);
          }
          if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)???))) {
            break label279;
          }
          if (QLog.isColorLevel()) {
            QLog.w("CapturePtvTemplateManager_PTV", 2, "zipMd5 or zipUrl empty return!");
          }
          aarz.Gp(-1);
          return;
        }
        catch (JSONException paramQQAppInterface) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        paramQQAppInterface.printStackTrace();
        return;
        label279:
        Object localObject2 = aH + File.separator;
        String str = aH + File.separator + str;
        File localFile = new File(aH, "temp_ptv_template_zip");
        if (localFile.exists())
        {
          localFile.delete();
          if (QLog.isColorLevel()) {
            QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip file.delete()");
          }
        }
        Object localObject3 = new File(str);
        if (((File)localObject3).exists())
        {
          ((File)localObject3).delete();
          if (QLog.isColorLevel()) {
            QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip filejson.delete()");
          }
        }
        localObject3 = new aoll();
        ((aoll)localObject3).f = new alwe(this, paramString, (String)localObject2, paramQQAppInterface, str);
        ((aoll)localObject3).bZ = ((String)???);
        ((aoll)localObject3).mHttpMethod = 0;
        ((aoll)localObject3).atY = localFile.getPath();
        ((aoll)localObject3).mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
        try
        {
          paramQQAppInterface = BaseApplicationImpl.getApplication().getRuntime();
          if (!QQAppInterface.class.isInstance(paramQQAppInterface)) {
            break;
          }
          ((QQAppInterface)paramQQAppInterface).getNetEngine(0).a((aomg)localObject3);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("CapturePtvTemplateManager", 2, "startDownloadFilterConfigZip, url: " + (String)???);
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          return;
        }
      }
      label549:
      ??? = "";
    }
  }
  
  public static boolean auE()
  {
    File localFile1 = new File(aH, "ptv_template_new.cfg");
    File localFile2 = new File(aH, "temp_ptv_template_zip");
    return (localFile1.exists()) && (localFile2.exists());
  }
  
  private boolean auF()
  {
    return (this.jdField_b_of_type_Alwl != null) && (this.jdField_b_of_type_Alwl.Fv.size() >= 30);
  }
  
  private alwd.e b(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.b paramb)
  {
    alwd.e locale = new alwd.e();
    locale.g = paramPtvTemplateInfo;
    locale.c = paramb;
    paramb = new alwd.d();
    paramb.mName = paramPtvTemplateInfo.bigHeadName;
    paramb.bYT = paramPtvTemplateInfo.bigHeadMd5;
    paramb.bYU = paramPtvTemplateInfo.bigHeadUrl;
    paramb.usable = paramPtvTemplateInfo.bigHeadModelUsable;
    paramb.czU = false;
    locale.items.add(paramb);
    paramb = new alwd.d();
    paramb.mName = paramPtvTemplateInfo.name;
    paramb.bYT = paramPtvTemplateInfo.md5;
    paramb.bYU = paramPtvTemplateInfo.resurl;
    paramb.usable = paramPtvTemplateInfo.usable;
    paramb.czU = true;
    locale.items.add(paramb);
    locale.dyz = 20;
    return locale;
  }
  
  private void b(alwd.e parame)
  {
    alwd.a locala = (alwd.a)this.mBusinessParams.get(Integer.valueOf(parame.dyz));
    if (locala != null) {
      locala.yZ.remove(parame);
    }
  }
  
  public static String bt(String paramString1, String paramString2)
  {
    String str = bYM + paramString1;
    paramString1 = bYO + paramString2 + File.separator + paramString1;
    if (new File(paramString1).exists()) {
      return paramString1;
    }
    return str;
  }
  
  private void c(File paramFile, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, String.format("rebuildTemplateInfos, cur_runnable[%s]", new Object[] { Integer.valueOf(hashCode()) }));
    }
    if (this.Fu.size() > 0) {}
    do
    {
      do
      {
        return;
        paramFile = p(paramFile);
      } while (TextUtils.isEmpty(paramFile));
      paramFile = a(a(), paramFile, null);
      if (paramFile != null)
      {
        this.Fu.clear();
        this.Fu.addAll(paramFile);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMRedDotConfig_PTV", 2, "rebuildTemplateInfos");
      }
      aA(paramFile, paramBoolean);
      dKh();
    } while (this.jdField_a_of_type_Alwd$c == null);
    this.jdField_a_of_type_Alwd$c.dKk();
  }
  
  private void dKi()
  {
    Object localObject1 = new ArrayList();
    ((List)localObject1).addAll(this.Fu);
    localObject1 = ((List)localObject1).iterator();
    int i = 0;
    int j = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (alwl)((Iterator)localObject1).next();
      int k = i;
      int m = j;
      if (((alwl)localObject2).Fv != null)
      {
        Object localObject3 = new ArrayList();
        ((List)localObject3).addAll(((alwl)localObject2).Fv);
        localObject2 = ((List)localObject3).iterator();
        for (;;)
        {
          k = i;
          m = j;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            k = i + 1;
            ((PtvTemplateManager.PtvTemplateInfo)localObject3).usable = a((PtvTemplateManager.PtvTemplateInfo)localObject3);
            i = k;
            if (((PtvTemplateManager.PtvTemplateInfo)localObject3).usable)
            {
              j += 1;
              i = k;
            }
          }
        }
      }
      j = m;
      i = k;
    }
    aqmj.kk(j, i);
  }
  
  private ArrayList<alwl> dv()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.Fu);
    boolean bool1 = anhq.axc();
    boolean bool2 = ankb.axD();
    boolean bool3 = QmcfManager.getInstance().hasQmcfEntrance(3);
    if ((!bool1) || (!bool2) || (!bool3))
    {
      Iterator localIterator1 = localArrayList.iterator();
      while (localIterator1.hasNext())
      {
        alwl localalwl = (alwl)localIterator1.next();
        List localList = localalwl.Fv;
        Iterator localIterator2 = localList.iterator();
        while (localIterator2.hasNext())
        {
          PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localIterator2.next();
          if (((!bool1) && (localPtvTemplateInfo.kind == 3)) || ((!bool2) && (localPtvTemplateInfo.kind == 4)) || ((!bool3) && (localPtvTemplateInfo.kind == 20)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("CapturePtvTemplateManager", 2, "should hide dg item! isQmcfEnableEntry=" + bool1 + " isFaceDanceEnableEntry=" + bool2 + " itemID=" + localPtvTemplateInfo.id);
            }
            localIterator2.remove();
          }
        }
        if (localList.size() == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("CapturePtvTemplateManager", 2, "should hide dg tab! isQmcfEnableEntry=" + bool1 + " isFaceDanceEnableEntry=" + bool2 + " categoryID=" + localalwl.categoryId);
          }
          localIterator1.remove();
        }
      }
      alwz.a().cs(bool1, bool2);
    }
    return localArrayList;
  }
  
  private static boolean f(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      for (;;)
      {
        return false;
        Object localObject = new File(aH, paramString1);
        if (((File)localObject).exists()) {
          try
          {
            localObject = aqhq.px(((File)localObject).getPath());
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase(paramString2)))
            {
              localObject = bYM + paramString1 + File.separator;
              paramString2 = new File((String)localObject, "params.json");
              localObject = new File((String)localObject, "params.dat");
              long l = paramString2.length();
              if (((!paramString2.exists()) || (l >= 1L)) && ((paramString2.exists()) || ((paramBoolean) && (((File)localObject).exists())))) {
                break label194;
              }
              if (!QLog.isColorLevel()) {}
            }
          }
          catch (UnsatisfiedLinkError paramString1)
          {
            try
            {
              jqp.b(new File(aH, paramString1), bYM);
              return true;
            }
            catch (Exception paramString1) {}
            paramString1 = paramString1;
          }
        }
      }
      paramString1.printStackTrace();
      return false;
    } while (!QLog.isColorLevel());
    paramString1.printStackTrace();
    return false;
    label194:
    return true;
  }
  
  public static boolean g(String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if (TextUtils.isEmpty(paramString1))
    {
      bool1 = false;
      return bool1;
    }
    File localFile = new File(aI, paramString2);
    if (localFile.exists()) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localFile = new File(aH, paramString1);
        if (!localFile.exists()) {}
      }
      for (;;)
      {
        try
        {
          Object localObject = aqhq.px(localFile.getPath());
          int j = i;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            bool1 = ((String)localObject).equalsIgnoreCase(paramString2);
            j = i;
            if (bool1) {
              j = 1;
            }
          }
          i = j;
          if (i != 0)
          {
            localObject = bt(paramString1, paramString2) + File.separator;
            paramString1 = new File((String)localObject, "params.json");
            localObject = new File((String)localObject, "params.dat");
            long l = paramString1.length();
            if ((!paramString1.exists()) || (l >= 1L))
            {
              bool1 = bool2;
              if (paramString1.exists()) {
                break;
              }
              if (paramBoolean)
              {
                bool1 = bool2;
                if (((File)localObject).exists()) {
                  break;
                }
              }
            }
            try
            {
              jqp.b(localFile, mZ(paramString2));
              return true;
            }
            catch (Exception paramString1)
            {
              if (QLog.isColorLevel()) {
                paramString1.printStackTrace();
              }
              return false;
            }
            continue;
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          if (QLog.isColorLevel()) {
            localUnsatisfiedLinkError.printStackTrace();
          }
        }
        return false;
      }
    }
  }
  
  static void he(String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new CapturePtvTemplateManager.2(paramString2, paramString1));
  }
  
  public static String mZ(String paramString)
  {
    return bYO + paramString + File.separator;
  }
  
  public static String p(File paramFile)
  {
    paramFile = aqhq.fileToBytes(paramFile);
    if ((paramFile == null) || (paramFile.length <= 0)) {
      return null;
    }
    if (Build.VERSION.SDK_INT <= 8) {
      return new String(paramFile);
    }
    try
    {
      paramFile = new String(paramFile, "UTF-8");
      return paramFile;
    }
    catch (UnsupportedEncodingException paramFile)
    {
      if (QLog.isDevelopLevel()) {
        paramFile.printStackTrace();
      }
    }
    return null;
  }
  
  public void E(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    aG(paramQQAppInterface, paramString);
  }
  
  public void F(int paramInt, Object paramObject)
  {
    if (this.jdField_b_of_type_Anhn != null)
    {
      this.jdField_b_of_type_Anhn.notify(paramInt, new Object[] { paramObject });
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager", 2, "notifyEventId eventId" + paramInt);
      }
    }
  }
  
  public void I(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (ez)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig == null) {
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.updateRedDotInfo(paramInt1, paramInt2, paramString))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateRedDotInfo==> type=");
            if (paramInt1 == 2)
            {
              localStringBuilder.append(",categoryId=").append(paramInt2);
              QLog.d("QIMRedDotConfig_PTV", 2, localStringBuilder.toString());
            }
          }
          else
          {
            this.dl.removeCallbacks(null);
            this.dl.post(new CapturePtvTemplateManager.7(this));
          }
        }
        else {
          return;
        }
      }
      if (paramInt1 == 3) {
        localStringBuilder.append(",id=").append(paramString);
      } else if (paramInt1 == 4) {
        localStringBuilder.append(",defaultId=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId);
      }
    }
  }
  
  public int Io()
  {
    synchronized (ez)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig != null) && (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.hasChoose))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_PTV", 2, "getDefaultCategoryId=" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId);
        }
        int i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId;
        return i;
      }
      return -1;
    }
  }
  
  public void Ok(boolean paramBoolean)
  {
    ThreadManager.postImmediately(new CapturePtvTemplateManager.1(this, paramBoolean), null, false);
  }
  
  @TargetApi(9)
  public void Ol(boolean paramBoolean)
  {
    dKj();
    File localFile = new File(aH, "ptv_template_new.cfg");
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager", 2, "initLocalTemplateConfigInfo config file not exist.");
      }
      Ok(false);
      return;
    }
    c(localFile, paramBoolean);
  }
  
  public void Om(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.update))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.update = false;
        CaptureRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig, aH.getAbsolutePath(), "_PTV");
      }
      return;
    }
    CaptureRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig, aH.getAbsolutePath(), "_PTV");
  }
  
  public PtvTemplateManager.PtvTemplateInfo a(String paramString, int paramInt)
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      Iterator localIterator = dt().iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (alwl)localIterator.next();
        } while ((((alwl)localObject).categoryId != paramInt) || (((alwl)localObject).Fv == null));
        localObject = ((alwl)localObject).Fv.iterator();
      }
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
    } while (!localPtvTemplateInfo.id.equals(paramString));
    if (QLog.isColorLevel()) {
      QLog.d("CapturePtvTemplateManager", 2, "QIMPtvTemplateManager existTemplateInfo id=" + paramString + " tagId=" + paramInt);
    }
    return localPtvTemplateInfo;
    return null;
  }
  
  public void a(alwd.c paramc)
  {
    this.jdField_a_of_type_Alwd$c = paramc;
  }
  
  public void a(anho paramanho, int paramInt)
  {
    try
    {
      if (this.jdField_b_of_type_Anhn == null) {
        this.jdField_b_of_type_Anhn = new anhn();
      }
      this.jdField_b_of_type_Anhn.a(paramanho, new int[] { paramInt });
      return;
    }
    finally {}
  }
  
  public void a(AppInterface paramAppInterface, alwd.e parame)
  {
    if ((parame.g == null) || (paramAppInterface == null)) {}
    label98:
    label99:
    for (;;)
    {
      return;
      if ((parame.items != null) && (parame.items.size() > 0))
      {
        a(parame);
        Iterator localIterator = parame.items.iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          alwd.d locald = (alwd.d)localIterator.next();
          if (locald.usable) {
            break label98;
          }
          a(paramAppInterface, parame, locald);
          i = 1;
        }
        for (;;)
        {
          break;
          if (i != 0) {
            break label99;
          }
          b(parame);
          return;
        }
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, alwd.e parame, alwd.d paramd)
  {
    Object localObject = (alwd.a)this.mBusinessParams.get(Integer.valueOf(parame.dyz));
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.e("CapturePtvTemplateManager", 2, "[BG]downloadSessionTemplateItem url: businessParam = null kind=" + parame.dyz);
      }
    }
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(paramd.mName)) {
        continue;
      }
      if (((alwd.a)localObject).mG.get(paramd.mName) != null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("CapturePtvTemplateManager", 2, "[BG]downloadSessionTemplateItem[no need download] url: " + paramd.bYU + " item.mName=" + paramd.mName);
        return;
      }
      ((alwd.a)localObject).mG.put(paramd.mName, paramd);
      ((alwd.a)localObject).yY.add(paramd.mName);
      localObject = new aoll();
      ((aoll)localObject).f = new alwd.f(parame, paramd);
      ((aoll)localObject).bZ = paramd.bYU;
      ((aoll)localObject).mHttpMethod = 0;
      ((aoll)localObject).atY = new File(aH, paramd.mName).getPath();
      ((aoll)localObject).bw(paramd);
      ((aoll)localObject).mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
      try
      {
        paramAppInterface.getNetEngine(0).a((aomg)localObject);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("CapturePtvTemplateManager", 2, "downloadSessionTemplateItem url: " + paramd.bYU);
        return;
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            paramAppInterface.printStackTrace();
          }
        }
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.b paramb)
  {
    if (paramPtvTemplateInfo == null) {
      return;
    }
    if ((paramPtvTemplateInfo.kind == 3) || (paramPtvTemplateInfo.kind == 4))
    {
      a(paramAppInterface, a(paramPtvTemplateInfo, paramb));
      return;
    }
    if (paramPtvTemplateInfo.kind == 20)
    {
      a(paramAppInterface, b(paramPtvTemplateInfo, paramb));
      return;
    }
    b(paramAppInterface, paramPtvTemplateInfo, paramb);
  }
  
  public boolean a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    if (paramPtvTemplateInfo == null) {}
    do
    {
      boolean bool;
      do
      {
        do
        {
          return false;
          if (paramPtvTemplateInfo.kind != 3) {
            break;
          }
          paramPtvTemplateInfo.dgStageUsable = f(paramPtvTemplateInfo.dgStageName, paramPtvTemplateInfo.dgStageResmd5, false);
          paramPtvTemplateInfo.dgModelUsable = f(paramPtvTemplateInfo.dgModelName, paramPtvTemplateInfo.dgModelResmd5, false);
          bool = f(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, false);
          if (QLog.isColorLevel()) {
            QLog.d("CapturePtvTemplateManager", 2, String.format("isDGTemplateUsage stage[%s], model[%s], total[%s], id[%s]", new Object[] { Boolean.valueOf(paramPtvTemplateInfo.dgStageUsable), Boolean.valueOf(paramPtvTemplateInfo.dgModelUsable), Boolean.valueOf(bool), paramPtvTemplateInfo.id }));
          }
        } while ((!paramPtvTemplateInfo.dgStageUsable) || (!paramPtvTemplateInfo.dgModelUsable));
        return bool;
        if (paramPtvTemplateInfo.kind != 20) {
          break;
        }
        if (!paramPtvTemplateInfo.bigHeadModelUsable) {
          paramPtvTemplateInfo.bigHeadModelUsable = f(paramPtvTemplateInfo.bigHeadName, paramPtvTemplateInfo.bigHeadMd5, false);
        }
        bool = f(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, false);
        if (QLog.isColorLevel()) {
          QLog.d("CapturePtvTemplateManager", 2, String.format("isDGTemplateUsage stage[%s], model[%s], total[%s], id[%s]", new Object[] { Boolean.valueOf(paramPtvTemplateInfo.dgStageUsable), Boolean.valueOf(paramPtvTemplateInfo.dgModelUsable), Boolean.valueOf(bool), paramPtvTemplateInfo.id }));
        }
      } while (!paramPtvTemplateInfo.bigHeadModelUsable);
      return bool;
      if (paramPtvTemplateInfo.kind != 4) {
        break;
      }
      paramPtvTemplateInfo.dgStageUsable = f(paramPtvTemplateInfo.dgStageName, paramPtvTemplateInfo.dgStageResmd5, false);
    } while (!paramPtvTemplateInfo.dgStageUsable);
    return f(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, false);
    return g(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, true);
  }
  
  public void aA(List<alwl> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        dKi();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("CapturePtvTemplateManager", 2, "updateFaceuTemplateConfigInfo size=" + this.Fu.size());
        return;
        ThreadManager.getSubThreadHandler().post(new CapturePtvTemplateManager.6(this));
      }
    }
  }
  
  public alwl b(alwl paramalwl)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("recent_template_setting", 0);
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localObject1 = ((SharedPreferences)localObject1).getString("recent_template_list" + (String)localObject2, null);
    if (QLog.isColorLevel()) {
      QLog.d("CapturePtvTemplateManager", 2, "getRecentTemplate list=" + (String)localObject1);
    }
    if (localObject1 == null) {}
    for (;;)
    {
      return paramalwl;
      localObject1 = ((String)localObject1).split("\\$");
      int i = 0;
      while (i < localObject1.length)
      {
        localObject2 = localObject1[i].split("\\|");
        if ((localObject2 != null) && (localObject2.length == 2))
        {
          int j = Integer.valueOf(localObject2[1]).intValue();
          localObject2 = a(localObject2[0], j);
          if (localObject2 != null) {
            paramalwl.Fv.add(localObject2);
          }
        }
        i += 1;
      }
    }
  }
  
  public PtvTemplateManager.PtvTemplateInfo b()
  {
    return this.f;
  }
  
  public void b(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.b paramb)
  {
    if ((paramPtvTemplateInfo == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      aoll localaoll = new aoll();
      localaoll.f = new alwg(this, paramPtvTemplateInfo, paramb);
      localaoll.bZ = paramPtvTemplateInfo.resurl;
      localaoll.mHttpMethod = 0;
      localaoll.atY = new File(aI, paramPtvTemplateInfo.md5).getPath();
      localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
      try
      {
        paramAppInterface.getNetEngine(0).a(localaoll);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("CapturePtvTemplateManager", 2, "startDownloadTemplate url: " + paramPtvTemplateInfo.resurl);
        return;
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            paramAppInterface.printStackTrace();
          }
        }
      }
    }
  }
  
  public void b(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    if (this.jdField_b_of_type_Alwl == null)
    {
      this.jdField_b_of_type_Alwl = new alwl(acfp.m(2131703416));
      this.jdField_b_of_type_Alwl.Fv = new ArrayList(30);
      b(this.jdField_b_of_type_Alwl);
    }
    for (;;)
    {
      return;
      int i = 0;
      int j = -1;
      while (i < this.jdField_b_of_type_Alwl.Fv.size())
      {
        if (((PtvTemplateManager.PtvTemplateInfo)this.jdField_b_of_type_Alwl.Fv.get(i)).id.equals(paramPtvTemplateInfo.id)) {
          j = i;
        }
        i += 1;
      }
      if (j == -1) {
        if (!auF())
        {
          this.jdField_b_of_type_Alwl.Fv.add(0, paramPtvTemplateInfo);
          F(paramInt, this.jdField_b_of_type_Alwl);
          if (QLog.isColorLevel()) {
            QLog.d("CapturePtvTemplateManager", 2, "setCurrentTemplateInfoToRecent not isRecentTemplateFull ");
          }
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("CapturePtvTemplateManager", 2, "setCurrentTemplateInfoToRecent index=" + j);
        return;
        this.jdField_b_of_type_Alwl.Fv.remove(29);
        this.jdField_b_of_type_Alwl.Fv.add(0, paramPtvTemplateInfo);
        F(paramInt, this.jdField_b_of_type_Alwl);
        continue;
        if (j != 0)
        {
          this.jdField_b_of_type_Alwl.Fv.remove(j);
          this.jdField_b_of_type_Alwl.Fv.add(0, paramPtvTemplateInfo);
          F(paramInt, this.jdField_b_of_type_Alwl);
        }
      }
    }
  }
  
  public void c(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    this.f = paramPtvTemplateInfo;
  }
  
  public void dKh()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new CapturePtvTemplateManager.4(this), ab.longValue());
  }
  
  public void dKj()
  {
    CaptureRedDotConfig localCaptureRedDotConfig = CaptureRedDotConfig.getRedDotConfigFromFile(aH.getAbsolutePath(), "_PTV");
    if (localCaptureRedDotConfig != null) {
      synchronized (ez)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig == null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig = localCaptureRedDotConfig;
        }
        return;
      }
    }
  }
  
  public ArrayList<alwl> dt()
  {
    ArrayList localArrayList = dv();
    if (!anjo.lC(dyy))
    {
      List localList = fW();
      if ((localList != null) && (!localList.isEmpty())) {
        localArrayList.removeAll(localList);
      }
    }
    return localArrayList;
  }
  
  public ArrayList<alwl> du()
  {
    ArrayList localArrayList = dt();
    if (this.jdField_b_of_type_Alwl == null)
    {
      this.jdField_b_of_type_Alwl = new alwl(acfp.m(2131703415));
      this.jdField_b_of_type_Alwl.Fv = new ArrayList(30);
      b(this.jdField_b_of_type_Alwl);
    }
    localArrayList.add(0, this.jdField_b_of_type_Alwl);
    if (QLog.isColorLevel()) {
      QLog.d("CapturePtvTemplateManager", 2, "getRecentTemplateAndConfigTemplate al size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public List<alwl> fW()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Fu.iterator();
    while (localIterator.hasNext())
    {
      alwl localalwl = (alwl)localIterator.next();
      if (localalwl.czY) {
        localArrayList.add(localalwl);
      }
    }
    return localArrayList;
  }
  
  public void lW(List<alwl> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    label21:
    List localList;
    do
    {
      return;
      while (!paramList.hasNext()) {
        paramList = paramList.iterator();
      }
      localList = ((alwl)paramList.next()).Fv;
    } while (localList == null);
    int i = 0;
    label51:
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (i < localList.size())
    {
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localList.get(i);
      if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.predownload) && (!TextUtils.isEmpty(localPtvTemplateInfo.resurl))) {
        break label106;
      }
    }
    for (;;)
    {
      i += 1;
      break label51;
      break label21;
      label106:
      if (a(localPtvTemplateInfo))
      {
        localPtvTemplateInfo.usable = true;
      }
      else
      {
        localPtvTemplateInfo.usable = false;
        int j = (int)(aqhq.getAvailableInnernalMemorySize() / 1024.0F / 1024.0F);
        int k = (int)(localPtvTemplateInfo.sizeFree * 1024.0D);
        if (QLog.isColorLevel()) {
          QLog.d("CapturePtvTemplateManager", 2, "preDownloadTemplates getAvailableInnernalMemorySize: " + j + " mSizeFree: " + k);
        }
        if (j < k)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("CapturePtvTemplateManager", 2, "preDownloadTemplates return getAvailableInnernalMemorySize: " + j + " mSizeFree: " + k);
          return;
        }
        aoll localaoll = new aoll();
        localaoll.f = new alwf(this, localPtvTemplateInfo);
        localaoll.bZ = localPtvTemplateInfo.resurl;
        localaoll.mHttpMethod = 0;
        localaoll.atY = new File(aI, localPtvTemplateInfo.md5).getPath();
        localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
        try
        {
          AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
          if ((localAppRuntime != null) && ((localAppRuntime instanceof ToolRuntimePeak)))
          {
            localAppRuntime = ((ToolRuntimePeak)localAppRuntime).onGetSubRuntime("peak");
            if (localAppRuntime != null)
            {
              ((PeakAppInterface)localAppRuntime).getNetEngine(0).a(localaoll);
              if (QLog.isColorLevel()) {
                QLog.i("CapturePtvTemplateManager", 2, "startDownloadFilterConfigZip, url: " + localPtvTemplateInfo.resurl);
              }
            }
          }
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public boolean needShowRedDot(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (ez)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig == null) {
          return false;
        }
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.needShowRedDot(paramInt1, paramInt2, paramString);
        if ((bool) && (QLog.isColorLevel()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ShowRedDot ==> type=");
          localStringBuilder.append(paramInt1);
          if (paramInt1 == 2)
          {
            localStringBuilder.append(",categoryId=").append(paramInt2);
            QLog.d("QIMRedDotConfig_PTV", 2, localStringBuilder.toString());
          }
        }
        else
        {
          return bool;
        }
      }
      if (paramInt1 == 3) {
        localStringBuilder.append(",id=").append(paramString);
      } else if (paramInt1 == 4) {
        localStringBuilder.append(",defaultId=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId);
      }
    }
  }
  
  public static class a
  {
    HashMap<String, alwd.d> mG = new HashMap();
    ArrayList<String> yY = new ArrayList();
    ArrayList<alwd.e> yZ = new ArrayList();
  }
  
  static class b
  {
    private static final alwd b = new alwd(null);
  }
  
  public static abstract interface c
  {
    public abstract void dKk();
  }
  
  public static class d
  {
    long ahM;
    public String bYT;
    public String bYU;
    public boolean czU;
    boolean czV;
    public String mName;
    long totalLen;
    public boolean usable;
  }
  
  public static class e
  {
    public PtvTemplateManager.b c;
    public int dyz;
    public PtvTemplateManager.PtvTemplateInfo g;
    public ArrayList<alwd.d> items = new ArrayList();
  }
  
  class f
    implements aolm.b
  {
    alwd.d jdField_a_of_type_Alwd$d;
    alwd.e jdField_a_of_type_Alwd$e;
    
    f(alwd.e parame, alwd.d paramd)
    {
      this.jdField_a_of_type_Alwd$e = parame;
      this.jdField_a_of_type_Alwd$d = paramd;
    }
    
    public void onResp(aomh paramaomh)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CapturePtvTemplateManager", 2, String.format("SessionResHttpListener respCode[%s], resName[%s], resUrl[%s]", new Object[] { Integer.valueOf(paramaomh.dPy), this.jdField_a_of_type_Alwd$d.mName, this.jdField_a_of_type_Alwd$d.bYU }));
      }
      paramaomh = (alwd.d)paramaomh.b.U();
      if (paramaomh == null) {}
      label269:
      label286:
      do
      {
        do
        {
          for (;;)
          {
            return;
            if (!paramaomh.mName.equals(this.jdField_a_of_type_Alwd$d.mName)) {
              break label286;
            }
            if (alwd.h(paramaomh.mName, paramaomh.bYT, false)) {}
            try
            {
              jqp.b(new File(alwd.aH, this.jdField_a_of_type_Alwd$d.mName), alwd.bYM);
              if (paramaomh.czU) {
                break label269;
              }
              paramaomh = (alwd.a)alwd.this.mBusinessParams.get(Integer.valueOf(this.jdField_a_of_type_Alwd$e.dyz));
              if (paramaomh != null)
              {
                paramaomh = paramaomh.yZ.iterator();
                while (paramaomh.hasNext())
                {
                  alwd.e locale = (alwd.e)paramaomh.next();
                  if (alwd.a(alwd.this, locale, this.jdField_a_of_type_Alwd$d)) {
                    paramaomh.remove();
                  }
                }
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
        } while (!QLog.isColorLevel());
        QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: BusinessParam=null  kind=" + this.jdField_a_of_type_Alwd$e.dyz + " mItem.mName=" + this.jdField_a_of_type_Alwd$d.mName);
        return;
        alwd.a(alwd.this, this.jdField_a_of_type_Alwd$e, this.jdField_a_of_type_Alwd$d);
        return;
      } while (!QLog.isColorLevel());
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: download information no match current=" + this.jdField_a_of_type_Alwd$d.mName + " callback=" + paramaomh.mName);
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
    {
      paramaomg = (alwd.d)paramaomg.U();
      if (paramaomg == null) {}
      label134:
      label187:
      do
      {
        do
        {
          for (;;)
          {
            return;
            if (!paramaomg.mName.equalsIgnoreCase(this.jdField_a_of_type_Alwd$d.mName)) {
              break label187;
            }
            Object localObject = (alwd.a)alwd.this.mBusinessParams.get(Integer.valueOf(this.jdField_a_of_type_Alwd$e.dyz));
            if (localObject == null) {
              break label134;
            }
            if (paramaomg.czU) {
              break;
            }
            paramaomg = ((alwd.a)localObject).yZ.iterator();
            while (paramaomg.hasNext())
            {
              localObject = (alwd.e)paramaomg.next();
              alwd.a(alwd.this, (alwd.e)localObject, this.jdField_a_of_type_Alwd$d, paramLong1, paramLong2);
            }
          }
          alwd.a(alwd.this, this.jdField_a_of_type_Alwd$e, this.jdField_a_of_type_Alwd$d, paramLong1, paramLong2);
          return;
        } while (!QLog.isColorLevel());
        QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: BusinessParam=null  kind=" + this.jdField_a_of_type_Alwd$e.dyz + " mItem.mName=" + this.jdField_a_of_type_Alwd$d.mName);
        return;
      } while (!QLog.isColorLevel());
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: download information no match current=" + this.jdField_a_of_type_Alwd$d.mName + " callback=" + paramaomg.mName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alwd
 * JD-Core Version:    0.7.0.1
 */