import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.video.effect.lowlight.LowLightTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.CaptureRedDotConfig;
import com.tencent.mobileqq.richmedia.capture.data.CaptureRedDotConfig.RedDotItemConfig;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager.1;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategory;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class alwh
{
  private static final String PC;
  private static boolean RN;
  private static int ResExist;
  private static int ResFailed = -1;
  private static int ResGenerating;
  public static final String bYW;
  public static final String bei = aasa.SDCARD_ROOT + "/capture_qsvf" + File.separator;
  public static final String bej = bei + "capture_res" + File.separator;
  private static final String bel = aasa.SDCARD_ROOT + "/qav" + File.separator + "beauty" + File.separator;
  public static Object ez;
  public static String lowLightDir;
  public static String lowLightPath;
  public static int mLowLightResStatus;
  private alwh.b jdField_a_of_type_Alwh$b;
  private alwh.f jdField_a_of_type_Alwh$f;
  public FilterCategoryItem a;
  private AtomicInteger aJ = new AtomicInteger(0);
  private final CopyOnWriteArrayList<FilterCategory> am = new CopyOnWriteArrayList();
  private final CopyOnWriteArrayList<FilterCategoryItem> an = new CopyOnWriteArrayList();
  public CaptureRedDotConfig c;
  public boolean czW;
  private Handler dl;
  HashMap<String, FilterDesc> mMap = new HashMap();
  
  static
  {
    PC = bel + "SKINCOLOR" + File.separator;
    bYW = bel;
    ez = new Object();
    lowLightDir = bei + "lowlight";
    lowLightPath = lowLightDir + File.separator + "LowLight.png";
    ResExist = 2;
    ResGenerating = 1;
  }
  
  private alwh()
  {
    GraphicRenderMgr.loadSo();
    String str = aqgz.BY() + " " + aqgz.getDeviceModel();
    QLog.i("CaptureVideoFilterManager", 2, "DeviceInfo " + str);
    this.dl = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  private boolean Xp()
  {
    String str = aqhq.py("filter_template.cfg");
    boolean bool = oA(str);
    if (QLog.isColorLevel()) {
      QLog.i("CaptureVideoFilterManager", 2, "initFromAsset" + str + " result:" + bool);
    }
    return bool;
  }
  
  private static alwh.g a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      igd.aJ("CaptureVideoFilterManager", "parseConfig|content is empty.");
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
        localg = null;
        continue;
      }
      try
      {
        i = Integer.valueOf(localJSONObject.getString("filterid")).intValue();
        str1 = localJSONObject.getString("resurl");
        str2 = localJSONObject.getString("md5");
        localg = new alwh.g(i, str1, str2);
        try
        {
          igd.aJ("CaptureVideoFilterManager", "parseConfig:" + i + "|" + str1 + "|" + str2);
          return localg;
        }
        catch (JSONException localJSONException1) {}
      }
      catch (JSONException localJSONException4)
      {
        localg = null;
        continue;
      }
      try
      {
        localJSONException1.printStackTrace();
        igd.aJ("CaptureVideoFilterManager", "parseConfig failed. info = " + localJSONObject);
        return localg;
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
        igd.aJ("CaptureVideoFilterManager", "parseConfig|parse failed.context = " + paramString);
        return localg;
      }
    }
  }
  
  public static final alwh a()
  {
    return alwh.a.b();
  }
  
  public static boolean a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    int i = aqgz.getOsVersion();
    if (i < paramInt2)
    {
      igd.aJ("CaptureVideoFilterManager", "isSupportOfDevice error OSversion: " + i);
      return false;
    }
    paramInt2 = imm.getNumCores();
    if (paramInt2 < paramInt1)
    {
      igd.aJ("CaptureVideoFilterManager", "isSupportOfDevice error cpucount: " + paramInt2);
      return false;
    }
    long l = imm.getMaxCpuFreq();
    if (l < paramLong1)
    {
      igd.aJ("CaptureVideoFilterManager", "isSupportOfDevice error cpuFrequency: " + l);
      return false;
    }
    paramLong1 = aqgz.getSystemTotalMemory();
    if (paramLong1 < paramLong2)
    {
      igd.aJ("CaptureVideoFilterManager", "isSupportOfDevice error memory: " + paramLong1);
      return false;
    }
    return true;
  }
  
  private static boolean aS(Context paramContext)
  {
    boolean bool = false;
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qq_video_filter_config_first_launch", 0);
    igd.aJ("CaptureVideoFilterManager", "getIsFirstLauncher:" + i);
    if (i == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static void ae(Context paramContext, int paramInt)
  {
    igd.aJ("CaptureVideoFilterManager", "setQQShortVideoFilterConfigVersion:" + paramInt);
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("capture_qq_video_filter_config", 4).edit();
    paramContext.putInt("capture_qq_video_filter_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void af(Context paramContext, int paramInt)
  {
    igd.aJ("CaptureVideoFilterManager", "setVideoEffectBeautyConfigVersion:" + paramInt);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qav_effect_beauty_config_version", paramInt);
    paramContext.commit();
  }
  
  public static int ak(Context paramContext)
  {
    int i = 0;
    int j = BaseApplicationImpl.getApplication().getSharedPreferences("capture_qq_video_filter_config", 4).getInt("capture_qq_video_filter_config_version", 0);
    if ((j > 0) && (!new File(bei + "filter_config.xml").exists())) {
      igd.aJ("CaptureVideoFilterManager", "getQQShortVideoFilterConfigVersion config file don't exist!");
    }
    for (;;)
    {
      igd.aJ("CaptureVideoFilterManager", "getQQShortVideoFilterConfigVersion:" + i);
      return i;
      i = j;
    }
  }
  
  public static String aw(Context paramContext)
  {
    try
    {
      File localFile = new File(bei + "filter_config.xml");
      igd.aJ("CaptureVideoFilterManager", "getQQShortVideoFilterConfig:" + bei + "filter_config.xml" + "|" + localFile.exists());
      if (localFile.exists()) {
        return aqhq.readFileToString(localFile);
      }
      ae(paramContext, 0);
      return null;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String ax(Context paramContext)
  {
    try
    {
      File localFile = new File(bel + "beauty_config.json");
      igd.aJ("CaptureVideoFilterManager", "getVideoEffectBeautyConfig:" + bel + "beauty_config.json" + "|" + localFile.exists());
      if (localFile.exists()) {
        return aqhq.readFileToString(localFile);
      }
      af(paramContext, 0);
      return null;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private boolean bw(Context paramContext)
  {
    paramContext = aw(paramContext);
    boolean bool = oA(paramContext);
    if (QLog.isColorLevel()) {
      QLog.i("CaptureVideoFilterManager", 2, "initFromCache" + paramContext + " result:" + bool);
    }
    return bool;
  }
  
  private static void dy(Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qq_video_filter_config_first_launch", 1);
    paramContext.commit();
  }
  
  public static void dz(Context paramContext)
  {
    try
    {
      if (aS(paramContext))
      {
        dy(paramContext);
        if (new File(PC).exists()) {
          aqhq.cn(PC);
        }
      }
      paramContext = a(ax(paramContext));
      if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.resUrl)))
      {
        Object localObject = new File(PC + "params.json");
        igd.aJ("CaptureVideoFilterManager", "preDownloadResource :" + ((File)localObject).exists());
        if (!((File)localObject).exists())
        {
          localObject = new aoll();
          ((aoll)localObject).f = new alwh.d();
          ((aoll)localObject).bZ = paramContext.resUrl;
          ((aoll)localObject).mHttpMethod = 0;
          ((aoll)localObject).atY = (bel + "skin_color.zip");
          ((aoll)localObject).bw(paramContext);
          ige.a().a((aomg)localObject);
        }
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private void generateLowlightRes()
  {
    File localFile = new File(lowLightPath);
    if (localFile.exists()) {
      localFile.delete();
    }
    for (;;)
    {
      Object localObject = LowLightTools.getLowLightImage(3.0F, 0.88F, 0.96F, 1.22F, false);
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        ((Bitmap)localObject).compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
        localFileOutputStream.flush();
        localFileOutputStream.close();
        if (!localFile.exists())
        {
          mLowLightResStatus = ResFailed;
          return;
          localObject = localFile.getParentFile();
          if (((File)localObject).exists()) {
            continue;
          }
          ((File)localObject).mkdirs();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.w("CaptureVideoFilterManager", 2, "LowLightTools saveBitmap:" + localException);
        }
        mLowLightResStatus = ResExist;
      }
    }
  }
  
  public static boolean isSupport(Context paramContext)
  {
    if (RN) {
      return true;
    }
    if (!a(4, 1350000L, 1073741824L, 17))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureVideoFilterManager", 2, "filter device note support");
      }
      return false;
    }
    RN = true;
    return RN;
  }
  
  static void l(Context paramContext, String paramString1, String paramString2)
  {
    Iterator localIterator = null;
    long l1 = System.currentTimeMillis();
    if ((paramString1 != null) && (!paramString1.equals("")))
    {
      paramContext = new ArrayList();
      y(paramString1, paramContext);
    }
    for (;;)
    {
      if ((paramString2 != null) && (!paramString2.equals("")))
      {
        paramString1 = new ArrayList();
        y(paramString2, paramString1);
        if ((paramContext != null) && (paramContext.size() != 0)) {
          break label151;
        }
        igd.aJ("CaptureVideoFilterManager", "compareContent newList.size=0");
        aqhq.cn(bej);
      }
      for (;;)
      {
        long l2 = System.currentTimeMillis();
        igd.aJ("CaptureVideoFilterManager", "compareContent :" + (l2 - l1));
        return;
        paramString1 = localIterator;
        if (!new File(bej).exists()) {
          break;
        }
        aqhq.cn(bej);
        paramString1 = localIterator;
        break;
        label151:
        if (paramString1 != null)
        {
          paramString1 = paramString1.iterator();
          while (paramString1.hasNext())
          {
            paramString2 = (FilterDesc)paramString1.next();
            localIterator = paramContext.iterator();
            while (localIterator.hasNext())
            {
              FilterDesc localFilterDesc = (FilterDesc)localIterator.next();
              if ((localFilterDesc.name != null) && (localFilterDesc.name.equals(paramString2.name)))
              {
                igd.aJ("CaptureVideoFilterManager", "compareContent res:" + localFilterDesc.name + "|" + localFilterDesc.resMD5 + "|" + paramString2.resMD5);
                if ((localFilterDesc.resMD5 != null) && (!localFilterDesc.resMD5.equals(paramString2.resMD5))) {
                  aqhq.cn(paramString2.getResFold(bej));
                }
                igd.aJ("CaptureVideoFilterManager", "compareContent iconMD5:" + localFilterDesc.name + "|" + localFilterDesc.iconMD5 + "|" + paramString2.iconMD5);
                if ((localFilterDesc.iconMD5 != null) && (!localFilterDesc.iconMD5.equals(paramString2.iconMD5))) {
                  aqhq.deleteFile(paramString2.getIconFile(bej));
                }
              }
            }
          }
        }
      }
      paramContext = null;
    }
  }
  
  private boolean oA(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    for (;;)
    {
      int i;
      synchronized (ez)
      {
        Object localObject3;
        try
        {
          paramString = new JSONObject(paramString);
          localObject2 = FilterDesc.parse(paramString.getJSONArray("filters")).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FilterDesc)((Iterator)localObject2).next();
            this.mMap.put(((FilterDesc)localObject3).name, localObject3);
            continue;
          }
          paramString = paramString.getJSONArray("categorys");
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          return false;
        }
        Object localObject2 = new ArrayList(paramString.length());
        i = 0;
        if (i < paramString.length())
        {
          localObject3 = new FilterCategory(paramString.getJSONObject(i), null);
          if ((((FilterCategory)localObject3).Fv.size() <= 0) || ((((FilterCategory)localObject3).Fv.size() == 1) && (((FilterCategoryItem)((FilterCategory)localObject3).Fv.get(0)).auG()))) {
            break label335;
          }
          ((ArrayList)localObject2).add(new FilterCategory(paramString.getJSONObject(i), null));
          break label335;
        }
        this.am.clear();
        this.am.addAll((Collection)localObject2);
        this.an.clear();
        paramString = this.am.iterator();
        if (paramString.hasNext())
        {
          localObject2 = ((FilterCategory)paramString.next()).Fv.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            continue;
          }
          localObject3 = (FilterCategoryItem)((Iterator)localObject2).next();
          if (((FilterCategoryItem)localObject3).advertisement) {
            continue;
          }
          localObject3 = ((FilterCategoryItem)localObject3).b();
          this.an.add(localObject3);
        }
      }
      if (this.jdField_a_of_type_Alwh$b != null) {
        this.jdField_a_of_type_Alwh$b.dKm();
      }
      return true;
      label335:
      i += 1;
    }
  }
  
  static void y(String paramString, List<FilterDesc> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null))
    {
      igd.aJ("CaptureVideoFilterManager", "parseConfig|content is empty.");
      return;
    }
    paramList.clear();
    try
    {
      paramList.addAll(FilterDesc.parse(new JSONObject(paramString).getJSONArray("filters")));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void I(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (ez)
      {
        if (this.c == null) {
          return;
        }
        if (this.c.updateRedDotInfo(paramInt1, paramInt2, paramString))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateRedDotInfo==> type=");
            localStringBuilder.append(paramInt1);
            if (paramInt1 == 2)
            {
              localStringBuilder.append(",categoryId=").append(paramInt2);
              QLog.d("QIMRedDotConfig_Filter", 2, localStringBuilder.toString());
            }
          }
          else
          {
            this.dl.removeCallbacks(null);
            this.dl.post(new CaptureVideoFilterManager.1(this));
          }
        }
        else {
          return;
        }
      }
      if (paramInt1 == 3) {
        localStringBuilder.append(",id=").append(paramString);
      } else if (paramInt1 == 4) {
        localStringBuilder.append(",defaultId=").append(this.c.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(this.c.defaultCategoryId);
      }
    }
  }
  
  public int Io()
  {
    synchronized (ez)
    {
      if ((this.c != null) && (!this.c.hasChoose))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_PTV", 2, "getDefaultCategoryId=" + this.c.defaultCategoryId);
        }
        int i = this.c.defaultCategoryId;
        return i;
      }
      return -1;
    }
  }
  
  public void Om(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.c != null) && (this.c.update))
      {
        this.c.update = false;
        CaptureRedDotConfig.saveRedDotConfig(this.c, bei, "_Filter");
      }
      return;
    }
    CaptureRedDotConfig.saveRedDotConfig(this.c, bei, "_Filter");
  }
  
  public FilterCategoryItem a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterCategoryItem;
  }
  
  public FilterDesc a(String paramString)
  {
    return (FilterDesc)this.mMap.get(paramString);
  }
  
  public void a(alwh.b paramb)
  {
    this.jdField_a_of_type_Alwh$b = paramb;
  }
  
  public void a(alwh.f paramf)
  {
    if ((this.am == null) || (this.am.size() == 0)) {
      igd.aJ("CaptureVideoFilterManager", "preDownloadResource list is empty!");
    }
    do
    {
      return;
      this.jdField_a_of_type_Alwh$f = paramf;
      igd.aJ("CaptureVideoFilterManager", "preDownloadResource list size: " + this.am.size());
      this.aJ.set(0);
      paramf = this.am.iterator();
      while (paramf.hasNext())
      {
        Object localObject1 = (FilterCategory)paramf.next();
        if (((FilterCategory)localObject1).Fv != null)
        {
          localObject1 = ((FilterCategory)localObject1).Fv.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            FilterDesc localFilterDesc = ((FilterCategoryItem)((Iterator)localObject1).next()).a();
            if (localFilterDesc != null)
            {
              igd.aJ("CaptureVideoFilterManager", "preDownloadResource predownload: " + localFilterDesc.predownload + ", iconurl: " + localFilterDesc.iconurl + ", resurl:" + localFilterDesc.resurl);
              if (localFilterDesc.predownload == 1)
              {
                Object localObject3;
                if (!TextUtils.isEmpty(localFilterDesc.iconurl))
                {
                  localObject2 = localFilterDesc.getIconFile(bej);
                  localObject3 = new File((String)localObject2);
                  igd.aJ("CaptureVideoFilterManager", "preDownloadResource icon " + (String)localObject2 + " exist: " + ((File)localObject3).exists());
                  if (!((File)localObject3).exists())
                  {
                    localObject3 = new aoll();
                    ((aoll)localObject3).f = new alwh.e();
                    ((aoll)localObject3).bZ = localFilterDesc.iconurl;
                    ((aoll)localObject3).mHttpMethod = 0;
                    ((aoll)localObject3).atY = ((String)localObject2);
                    ((aoll)localObject3).bw(localFilterDesc);
                    ige.a().a((aomg)localObject3);
                    this.aJ.incrementAndGet();
                  }
                }
                Object localObject2 = localFilterDesc.getResFold(bej);
                if ((!TextUtils.isEmpty(localFilterDesc.resurl)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
                {
                  localObject3 = new File((String)localObject2 + "params.json");
                  igd.aJ("CaptureVideoFilterManager", "preDownloadResource file " + (String)localObject2 + "params.json" + " exist: " + ((File)localObject3).exists());
                  if (!((File)localObject3).exists())
                  {
                    localObject2 = new aoll();
                    ((aoll)localObject2).f = new alwh.c();
                    ((aoll)localObject2).bZ = localFilterDesc.resurl;
                    ((aoll)localObject2).mHttpMethod = 0;
                    ((aoll)localObject2).atY = (bej + localFilterDesc.name + ".zip");
                    ((aoll)localObject2).bw(localFilterDesc);
                    ige.a().a((aomg)localObject2);
                    this.aJ.incrementAndGet();
                  }
                }
              }
            }
          }
        }
      }
    } while ((this.aJ.get() != 0) || (this.jdField_a_of_type_Alwh$f == null));
    this.jdField_a_of_type_Alwh$f.CT(false);
  }
  
  public void a(FilterCategoryItem paramFilterCategoryItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterCategoryItem = paramFilterCategoryItem;
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterCategoryItem != null) && (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterCategoryItem.auG())) {
      I(3, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterCategoryItem.categoryId, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterCategoryItem.id);
    }
  }
  
  public void dA(Context paramContext)
  {
    if (new File(bel + "beauty_config.json").exists())
    {
      if (!new File(PC + "params.json").exists())
      {
        igd.aJ("CaptureVideoFilterManager", "!JasonFile.exists()");
        dz(paramContext);
      }
      return;
    }
    igd.aJ("CaptureVideoFilterManager", "BEAUTY_CONFIG  is not exsit");
  }
  
  public void dKj()
  {
    CaptureRedDotConfig localCaptureRedDotConfig = CaptureRedDotConfig.getRedDotConfigFromFile(bei, "_Filter");
    if (localCaptureRedDotConfig != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMRedDotConfig_Filter", 2, "CaptureVideoFilterManger init UpdateByServer= " + this.czW);
      }
      synchronized (ez)
      {
        if (!this.czW) {
          this.c = localCaptureRedDotConfig;
        }
        return;
      }
    }
  }
  
  public void dKl()
  {
    this.jdField_a_of_type_Alwh$b = null;
  }
  
  public List<FilterCategory> fX()
  {
    return this.am;
  }
  
  public List<FilterCategoryItem> fY()
  {
    return this.an;
  }
  
  public void init()
  {
    if (QLog.isColorLevel()) {
      com.tencent.av.video.effect.QavVideoEffect.DEBUG_MODE = true;
    }
    dKj();
    if (!bw(BaseApplicationImpl.sApplication)) {
      Xp();
    }
    igd.aJ("CaptureVideoFilterManager", "init mFilterCategoryRaw size:" + this.am.size());
  }
  
  public void n(Context paramContext, String paramString, int paramInt)
  {
    if (paramString == null)
    {
      igd.aJ("CaptureVideoFilterManager", "updateQQShortVideoFilterConfig error ");
      return;
    }
    int i = ak(paramContext);
    String str = "";
    if (i != 0) {
      str = aw(paramContext);
    }
    l(paramContext, paramString, str);
    aqhq.z(bei, "filter_config.xml", paramString);
    ae(paramContext, paramInt);
    dKj();
    oz(paramString);
    igd.aJ("CaptureVideoFilterManager", "updateQQShortVideoFilterConfig sendBroadcast");
    paramContext.sendBroadcast(new Intent("action_brocassreceiver_for_filter"));
  }
  
  public boolean needShowRedDot(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (ez)
      {
        if (this.c == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "needShowRedDot|mCaptureRedDotConfig is null");
          }
          return false;
        }
        boolean bool = this.c.needShowRedDot(paramInt1, paramInt2, paramString);
        if ((bool) && (QLog.isColorLevel()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ShowRedDot==> type=");
          localStringBuilder.append(paramInt1);
          if (paramInt1 == 2)
          {
            localStringBuilder.append(",categoryId=").append(paramInt2);
            QLog.d("QIMRedDotConfig_Filter", 2, localStringBuilder.toString());
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
        localStringBuilder.append(",defaultId=").append(this.c.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(this.c.defaultCategoryId);
      }
    }
  }
  
  public boolean oz(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    for (;;)
    {
      int i;
      synchronized (ez)
      {
        if (this.c == null)
        {
          this.c = new CaptureRedDotConfig(1);
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer config is null");
          }
        }
        try
        {
          Object localObject2 = new JSONObject(paramString);
          paramString = ((JSONObject)localObject2).getJSONArray("categorys");
          i = ((JSONObject)localObject2).optInt("iconRedDotVersion");
          boolean bool = ((JSONObject)localObject2).optBoolean("needRedDot");
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + this.c.iconVersion + ",ver=" + i + ",showRed " + bool);
          }
          int j = ((JSONObject)localObject2).optInt("redDotShowTime", CaptureRedDotConfig.SHOW_TIME_DEFAULT);
          this.c.showTime = j;
          if (this.c.iconVersion != i)
          {
            this.c.iconVersion = i;
            this.c.showRedDot = bool;
            this.c.hasShow = false;
            this.c.firstShowTime = 0L;
          }
          i = ((JSONObject)localObject2).optInt("defaultCategoryVersion");
          j = ((JSONObject)localObject2).optInt("defaultCategoryId", -1);
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + this.c.defaultCategoryVer + ",ver=" + i + ",defaultCategoryId " + j);
          }
          if (this.c.defaultCategoryVer != i)
          {
            this.c.defaultCategoryVer = i;
            this.c.defaultCategoryId = j;
            this.c.hasChoose = false;
          }
          i = ((JSONObject)localObject2).optInt("defaultUseVersion");
          Object localObject3 = ((JSONObject)localObject2).optString("defaultUseId");
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer oldVer=" + this.c.defaultUseVer + ",ver=" + i + ",defaultUseId " + (String)localObject3);
          }
          if (this.c.defaultUseVer != i)
          {
            this.c.defaultUseVer = i;
            this.c.defaultUseId = ((String)localObject3);
            this.c.hasUse = false;
          }
          i = ((JSONObject)localObject2).optInt("itemRedDotVersion");
          if (this.c.redDotVersion != i)
          {
            this.c.redDotVersion = i;
            this.c.redDotItems.clear();
            if (((JSONObject)localObject2).has("itemNeedRedDot"))
            {
              localObject2 = ((JSONObject)localObject2).getJSONArray("itemNeedRedDot");
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("updateFromServer redDotList: ");
              i = 0;
              if (i < ((JSONArray)localObject2).length())
              {
                String str = ((JSONArray)localObject2).optString(i);
                if (TextUtils.isEmpty(str)) {
                  break label708;
                }
                CaptureRedDotConfig.RedDotItemConfig localRedDotItemConfig = new CaptureRedDotConfig.RedDotItemConfig();
                localRedDotItemConfig.filterId = str;
                ((StringBuilder)localObject3).append(str).append(",");
                this.c.redDotItems.put(str, localRedDotItemConfig);
                break label708;
              }
              if (QLog.isColorLevel()) {
                QLog.d("QIMRedDotConfig_Filter", 2, ((StringBuilder)localObject3).toString());
              }
            }
          }
          localObject2 = new ArrayList(paramString.length());
          i = 0;
          if (i < paramString.length())
          {
            ((ArrayList)localObject2).add(new FilterCategory(paramString.getJSONObject(i), this.c));
            i += 1;
            continue;
          }
          this.czW = true;
          Om(false);
          return true;
        }
        catch (JSONException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QIMRedDotConfig", 2, QLog.getStackTraceString(paramString));
          }
          return false;
        }
      }
      label708:
      i += 1;
    }
  }
  
  static class a
  {
    private static final alwh a = new alwh(null);
  }
  
  public static abstract interface b
  {
    public abstract void dKm();
  }
  
  class c
    implements aolm.b
  {
    c() {}
    
    public void onResp(aomh paramaomh)
    {
      Object localObject = (FilterDesc)paramaomh.b.U();
      if (paramaomh.mResult != 0) {
        igd.aJ("CaptureVideoFilterManager", "download file failed. errorCode: " + paramaomh.mErrCode + ", errorMsg: " + paramaomh.clO + ", file: " + ((FilterDesc)localObject).resurl);
      }
      for (;;)
      {
        return;
        if (!((FilterDesc)localObject).resMD5.equalsIgnoreCase(SecUtil.getFileMd5(paramaomh.b.atY)))
        {
          igd.aJ("CaptureVideoFilterManager", "download file failed: md5 is not match.");
          aqhq.deleteFile(paramaomh.b.atY);
          return;
        }
        igd.aJ("CaptureVideoFilterManager", "download resFile success. file: " + ((FilterDesc)localObject).resurl);
        try
        {
          localObject = alwh.bej;
          aqhq.W(paramaomh.b.atY, (String)localObject, false);
          aqhq.deleteFile(paramaomh.b.atY);
          if ((alwh.a(alwh.this).decrementAndGet() == 0) && (alwh.a(alwh.this) != null))
          {
            alwh.a(alwh.this).CT(true);
            return;
          }
        }
        catch (IOException paramaomh)
        {
          paramaomh.printStackTrace();
          igd.aJ("CaptureVideoFilterManager", "unzip file failed.");
        }
      }
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  }
  
  static class d
    implements aolm.b
  {
    public void onResp(aomh paramaomh)
    {
      Object localObject = (alwh.g)paramaomh.b.U();
      igd.aJ("CaptureVideoFilterManager", "download file call back. file = " + ((alwh.g)localObject).resUrl);
      if (paramaomh.mResult != 0)
      {
        igd.aJ("CaptureVideoFilterManager", "download file faild. errcode = " + paramaomh.mErrCode);
        return;
      }
      if (!((alwh.g)localObject).resMD5.equalsIgnoreCase(SecUtil.getFileMd5(paramaomh.b.atY)))
      {
        igd.aJ("CaptureVideoFilterManager", "download file faild : md5 is not match.");
        aqhq.deleteFile(paramaomh.b.atY);
        return;
      }
      igd.aJ("CaptureVideoFilterManager", "download file successed.");
      try
      {
        localObject = alwh.bel;
        aqhq.W(paramaomh.b.atY, (String)localObject, false);
        aqhq.deleteFile(paramaomh.b.atY);
        return;
      }
      catch (IOException paramaomh)
      {
        paramaomh.printStackTrace();
        igd.aJ("CaptureVideoFilterManager", "BEAUTY_ZIP unzip file faild.");
      }
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  }
  
  class e
    implements aolm.b
  {
    e() {}
    
    public void onResp(aomh paramaomh)
    {
      FilterDesc localFilterDesc = (FilterDesc)paramaomh.b.U();
      if (paramaomh.mResult != 0)
      {
        igd.aJ("CaptureVideoFilterManager", "download IconFile failed. errorCode: " + paramaomh.mErrCode + ", errorMsg: " + paramaomh.clO + ", file: " + localFilterDesc.iconurl);
        return;
      }
      if ((alwh.a(alwh.this).decrementAndGet() == 0) && (alwh.a(alwh.this) != null)) {
        alwh.a(alwh.this).CT(true);
      }
      igd.aJ("CaptureVideoFilterManager", "download iconFile success. file: " + localFilterDesc.iconurl);
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  }
  
  public static abstract interface f
  {
    public abstract void CT(boolean paramBoolean);
  }
  
  public static class g
  {
    public int id;
    public String resMD5;
    public String resUrl;
    
    public g(int paramInt, String paramString1, String paramString2)
    {
      this.id = paramInt;
      this.resUrl = paramString1;
      this.resMD5 = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alwh
 * JD-Core Version:    0.7.0.1
 */