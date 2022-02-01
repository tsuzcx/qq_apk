import android.content.Context;
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
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.data.CaptureRedDotConfig;
import dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager.1;
import dov.com.tencent.mobileqq.richmedia.capture.data.FilterCategory;
import dov.com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
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

public class aywt
{
  private static final String PC;
  private static int ResExist;
  private static int ResFailed = -1;
  private static int ResGenerating;
  public static final String bei = aasa.SDCARD_PATH + "pddata/prd/dov_capture_qsvf" + File.separator;
  public static final String bej = bei + "capture_res" + File.separator;
  private static final String bel = aasa.SDCARD_PATH + "qav" + File.separator + "beauty" + File.separator;
  public static Object ez;
  public static String lowLightDir;
  public static String lowLightPath;
  public static int mLowLightResStatus;
  private aywt.b jdField_a_of_type_Aywt$b;
  private aywt.e jdField_a_of_type_Aywt$e;
  public FilterCategoryItem a;
  private AtomicInteger aJ = new AtomicInteger(0);
  private final CopyOnWriteArrayList<FilterCategory> am = new CopyOnWriteArrayList();
  private final CopyOnWriteArrayList<FilterCategoryItem> an = new CopyOnWriteArrayList();
  public CaptureRedDotConfig b;
  public boolean czW;
  private Handler dl;
  HashMap<String, FilterDesc> mMap = new HashMap();
  
  static
  {
    PC = bel + "SKINCOLOR" + File.separator;
    ez = new Object();
    lowLightDir = bei + "lowlight";
    lowLightPath = lowLightDir + File.separator + "LowLight.png";
    ResExist = 2;
    ResGenerating = 1;
  }
  
  private aywt()
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
  
  public static final aywt a()
  {
    return aywt.a.b();
  }
  
  public static void ae(Context paramContext, int paramInt)
  {
    igd.aJ("CaptureVideoFilterManager", "setQQShortVideoFilterConfigVersion:" + paramInt);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("capture_qq_video_filter_config_version", paramInt);
    paramContext.commit();
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
  
  private boolean bw(Context paramContext)
  {
    paramContext = aw(paramContext);
    boolean bool = oA(paramContext);
    if (QLog.isColorLevel()) {
      QLog.i("CaptureVideoFilterManager", 2, "initFromCache" + paramContext + " result:" + bool);
    }
    return bool;
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
      if (this.jdField_a_of_type_Aywt$b != null) {
        this.jdField_a_of_type_Aywt$b.dKm();
      }
      return true;
      label335:
      i += 1;
    }
  }
  
  public void I(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (ez)
      {
        if (this.b == null) {
          return;
        }
        if (this.b.updateRedDotInfo(paramInt1, paramInt2, paramString))
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
        localStringBuilder.append(",defaultId=").append(this.b.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(this.b.defaultCategoryId);
      }
    }
  }
  
  public void Om(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.b != null) && (this.b.update))
      {
        this.b.update = false;
        CaptureRedDotConfig.saveRedDotConfig(this.b, bei, "_Filter");
      }
      return;
    }
    CaptureRedDotConfig.saveRedDotConfig(this.b, bei, "_Filter");
  }
  
  public FilterDesc a(String paramString)
  {
    return (FilterDesc)this.mMap.get(paramString);
  }
  
  public FilterCategoryItem a()
  {
    return this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem;
  }
  
  public void a(aywt.b paramb)
  {
    this.jdField_a_of_type_Aywt$b = paramb;
  }
  
  public void a(aywt.e parame)
  {
    if ((this.am == null) || (this.am.size() == 0)) {
      igd.aJ("CaptureVideoFilterManager", "preDownloadResource list is empty!");
    }
    do
    {
      return;
      this.jdField_a_of_type_Aywt$e = parame;
      igd.aJ("CaptureVideoFilterManager", "preDownloadResource list size: " + this.am.size());
      this.aJ.set(0);
      parame = this.am.iterator();
      while (parame.hasNext())
      {
        Object localObject1 = (FilterCategory)parame.next();
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
                    ((aoll)localObject3).f = new aywt.d();
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
                    ((aoll)localObject2).f = new aywt.c();
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
    } while ((this.aJ.get() != 0) || (this.jdField_a_of_type_Aywt$e == null));
    this.jdField_a_of_type_Aywt$e.CT(false);
  }
  
  public void a(FilterCategoryItem paramFilterCategoryItem)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem = paramFilterCategoryItem;
    if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem != null) && (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem.auG())) {
      I(3, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem.categoryId, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem.id);
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem != null)
    {
      paramFilterCategoryItem = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataFilterCategoryItem.a();
      if (paramFilterCategoryItem != null)
      {
        QQFilterRenderManager localQQFilterRenderManager = EffectsCameraCaptureView.b();
        if (localQQFilterRenderManager != null) {
          localQQFilterRenderManager.getBusinessOperation().setFilterEffect(paramFilterCategoryItem);
        }
      }
    }
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
          this.b = localCaptureRedDotConfig;
        }
        return;
      }
    }
  }
  
  public void dKl()
  {
    this.jdField_a_of_type_Aywt$b = null;
  }
  
  public void eTU()
  {
    this.jdField_a_of_type_Aywt$e = null;
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
  
  static class a
  {
    private static final aywt a = new aywt(null);
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
          localObject = aywt.bej;
          aqhq.W(paramaomh.b.atY, (String)localObject, false);
          aqhq.deleteFile(paramaomh.b.atY);
          if ((aywt.a(aywt.this).decrementAndGet() == 0) && (aywt.a(aywt.this) != null))
          {
            aywt.a(aywt.this).CT(true);
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
  
  class d
    implements aolm.b
  {
    d() {}
    
    public void onResp(aomh paramaomh)
    {
      FilterDesc localFilterDesc = (FilterDesc)paramaomh.b.U();
      if (paramaomh.mResult != 0)
      {
        igd.aJ("CaptureVideoFilterManager", "download IconFile failed. errorCode: " + paramaomh.mErrCode + ", errorMsg: " + paramaomh.clO + ", file: " + localFilterDesc.iconurl);
        return;
      }
      if ((aywt.a(aywt.this).decrementAndGet() == 0) && (aywt.a(aywt.this) != null)) {
        aywt.a(aywt.this).CT(true);
      }
      igd.aJ("CaptureVideoFilterManager", "download iconFile success. file: " + localFilterDesc.iconurl);
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  }
  
  public static abstract interface e
  {
    public abstract void CT(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aywt
 * JD-Core Version:    0.7.0.1
 */