import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.opengl.GLES20;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.video.effect.filter.FilterRender;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aasr
{
  private static final String PC = bel + "SKINCOLOR" + File.separator;
  private static boolean RN;
  private static aasr b;
  public static final String bei = aasa.SDCARD_ROOT + "/qsvf" + File.separator;
  public static final String bej = bei + "res" + File.separator;
  public static final String bek = bei + "artfilter" + File.separator;
  private static final String bel = aasa.SDCARD_ROOT + "/qav" + File.separator + "beauty" + File.separator;
  private aasr.d a;
  private AtomicInteger aJ = new AtomicInteger(0);
  private FilterDesc c;
  private volatile boolean mDestroy;
  private int mFilterHeight;
  private FilterRender mFilterRender;
  private int mFilterTextureFbo = -1;
  private int[] mFilterTextureId = { -1 };
  private int mFilterWidth;
  private ArrayList<FilterDesc> sc;
  
  private aasr()
  {
    GraphicRenderMgr.loadSo();
    String str = aqgz.BY() + " " + aqgz.getDeviceModel();
    QLog.i("VideoFilterTools", 2, "DeviceInfo " + str);
  }
  
  public static void AP(String paramString)
  {
    if (paramString == null) {
      igd.aJ("VideoFilterTools", "handleQQSvCommonConfig empty content!");
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramString = new JSONObject(paramString).getJSONObject("CommonConfig");
          if (paramString.getJSONObject("SvArtFilter") != null)
          {
            QmcfManager.getInstance().updateQmcfMainSwitch(paramString.getJSONObject("SvArtFilter"));
            return;
          }
        }
        catch (Exception paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("VideoFilterTools", 2, "handleQQSvCommonConfig error!", paramString);
  }
  
  private static aasr.e a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      igd.aJ("VideoFilterTools", "parseConfig|content is empty.");
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
        locale = null;
        continue;
      }
      try
      {
        i = Integer.valueOf(localJSONObject.getString("filterid")).intValue();
        str1 = localJSONObject.getString("resurl");
        str2 = localJSONObject.getString("md5");
        locale = new aasr.e(i, str1, str2);
        try
        {
          igd.aJ("VideoFilterTools", "parseConfig:" + i + "|" + str1 + "|" + str2);
          return locale;
        }
        catch (JSONException localJSONException1) {}
      }
      catch (JSONException localJSONException4)
      {
        locale = null;
        continue;
      }
      try
      {
        localJSONException1.printStackTrace();
        igd.aJ("VideoFilterTools", "parseConfig failed. info = " + localJSONObject);
        return locale;
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
        igd.aJ("VideoFilterTools", "parseConfig|parse failed.context = " + paramString);
        return locale;
      }
    }
  }
  
  public static aasr a()
  {
    if (b == null) {
      b = new aasr();
    }
    return b;
  }
  
  public static boolean a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    int i = aqgz.getOsVersion();
    if (i < paramInt2)
    {
      igd.aJ("VideoFilterTools", "isSupportOfDevice error OSversion: " + i);
      return false;
    }
    paramInt2 = imm.getNumCores();
    if (paramInt2 < paramInt1)
    {
      igd.aJ("VideoFilterTools", "isSupportOfDevice error cpucount: " + paramInt2);
      return false;
    }
    long l = imm.getMaxCpuFreq();
    if (l < paramLong1)
    {
      igd.aJ("VideoFilterTools", "isSupportOfDevice error cpuFrequency: " + l);
      return false;
    }
    paramLong1 = aqgz.getSystemTotalMemory();
    if (paramLong1 < paramLong2)
    {
      igd.aJ("VideoFilterTools", "isSupportOfDevice error memory: " + paramLong1);
      return false;
    }
    return true;
  }
  
  public static boolean aS(Context paramContext)
  {
    boolean bool = false;
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qq_video_filter_config_first_launch", 0);
    igd.aJ("VideoFilterTools", "getIsFirstLauncher:" + i);
    if (i == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static void ae(Context paramContext, int paramInt)
  {
    igd.aJ("VideoFilterTools", "setQQShortVideoFilterConfigVersion:" + paramInt);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qq_video_filter_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void af(Context paramContext, int paramInt)
  {
    igd.aJ("VideoFilterTools", "setVideoEffectBeautyConfigVersion:" + paramInt);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qav_effect_beauty_config_version", paramInt);
    paramContext.commit();
  }
  
  public static int ak(Context paramContext)
  {
    int i = 0;
    int j = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qq_video_filter_config_version", 0);
    if ((j > 0) && (!new File(bei + "filter_config.xml").exists())) {
      igd.aJ("VideoFilterTools", "getQQShortVideoFilterConfigVersion config file don't exist!");
    }
    for (;;)
    {
      igd.aJ("VideoFilterTools", "getQQShortVideoFilterConfigVersion:" + i);
      return i;
      i = j;
    }
  }
  
  public static String aw(Context paramContext)
  {
    try
    {
      File localFile = new File(bei + "filter_config.xml");
      igd.aJ("VideoFilterTools", "getQQShortVideoFilterConfig:" + bei + "filter_config.xml" + "|" + localFile.exists());
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
      igd.aJ("VideoFilterTools", "getVideoEffectBeautyConfig:" + bel + "beauty_config.json" + "|" + localFile.exists());
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
  
  public static void dy(Context paramContext)
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
        igd.aJ("VideoFilterTools", "preDownloadResource :" + ((File)localObject).exists());
        if (!((File)localObject).exists())
        {
          localObject = new aoll();
          ((aoll)localObject).f = new aasr.b();
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
  
  public static boolean isSupport(Context paramContext)
  {
    if (RN) {
      return true;
    }
    if (!a(4, 1350000L, 1073741824L, 17)) {
      return false;
    }
    if ((paramContext != null) && (TextUtils.isEmpty(aw(paramContext)))) {
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
        if (paramContext != null) {
          break label136;
        }
        aqhq.cn(bej);
      }
      for (;;)
      {
        long l2 = System.currentTimeMillis();
        igd.aJ("VideoFilterTools", "compareContent :" + (l2 - l1));
        return;
        paramString1 = localIterator;
        if (!new File(bej).exists()) {
          break;
        }
        aqhq.cn(bej);
        paramString1 = localIterator;
        break;
        label136:
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
                igd.aJ("VideoFilterTools", "compareContent res:" + localFilterDesc.name + "|" + localFilterDesc.resMD5 + "|" + paramString2.resMD5);
                if ((localFilterDesc.resMD5 != null) && (!localFilterDesc.resMD5.equals(paramString2.resMD5))) {
                  aqhq.cn(paramString2.getResFold(bej));
                }
                igd.aJ("VideoFilterTools", "compareContent iconMD5:" + localFilterDesc.name + "|" + localFilterDesc.iconMD5 + "|" + paramString2.iconMD5);
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
  
  public static void n(Context paramContext, String paramString, int paramInt)
  {
    if (paramString == null)
    {
      igd.aJ("VideoFilterTools", "updateQQShortVideoFilterConfig error ");
      return;
    }
    l(paramContext, paramString, aw(paramContext));
    aqhq.z(bei, "filter_config.xml", paramString);
    ae(paramContext, paramInt);
  }
  
  public static boolean uV()
  {
    return (new File(PC + "params.json").exists()) && (new File(bel + "beauty_config.json").exists());
  }
  
  static void y(String paramString, List<FilterDesc> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null)) {
      igd.aJ("VideoFilterTools", "parseConfig|content is empty.");
    }
    for (;;)
    {
      return;
      paramList.clear();
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("content");
        int i = 0;
        while (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          try
          {
            int j = Integer.valueOf(localJSONObject.getString("type")).intValue();
            int k = Integer.valueOf(localJSONObject.getString("filterid")).intValue();
            int m = Integer.valueOf(localJSONObject.getString("subid")).intValue();
            int n = Integer.valueOf(localJSONObject.getString("predownload")).intValue();
            String str5 = localJSONObject.getString("resurl");
            String str1 = localJSONObject.getString("md5");
            String str4 = localJSONObject.getString("iconurl");
            String str2 = localJSONObject.getString("iconmd5");
            String str3 = localJSONObject.getString("name");
            str5 = aden.replaceBlank(str5);
            str4 = aden.replaceBlank(str4);
            paramList.add(new FilterDesc(k, m, n, str5, str1, str4, str2, str3, j));
            igd.aJ("VideoFilterTools", "parseConfig:" + k + "|" + m + "|" + n + "|" + str5 + "|" + str1 + "|" + str4 + "|" + str2 + "|" + str3);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
              igd.aJ("VideoFilterTools", "parseConfig failed. info = " + localJSONObject);
            }
          }
        }
        return;
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
        igd.aJ("VideoFilterTools", "parseConfig|parse failed.context = " + paramString);
      }
    }
  }
  
  public boolean WY()
  {
    int i = this.sc.size();
    return (i > 1) || ((i == 1) && (!((FilterDesc)this.sc.get(0)).isEmptyFilter()));
  }
  
  public boolean WZ()
  {
    if (this.c != null) {
      return this.c.type == 1;
    }
    return false;
  }
  
  public FilterRender a(int paramInt1, int paramInt2)
  {
    if ((this.mDestroy) || (this.mFilterWidth != paramInt1) || (this.mFilterHeight != paramInt2))
    {
      igd.aJ("VideoFilterTools", "getFilter|init texture.");
      this.mFilterWidth = paramInt1;
      this.mFilterHeight = paramInt2;
      if (this.mFilterTextureFbo != -1) {
        this.mFilterTextureFbo = -1;
      }
      if (this.mFilterTextureId[0] != -1) {
        this.mFilterTextureId[0] = -1;
      }
      GLES20.glGenTextures(this.mFilterTextureId.length, this.mFilterTextureId, 0);
      this.mFilterTextureFbo = AVGLUtils.initFrameBuffer(paramInt1, paramInt2, this.mFilterTextureId[0]);
    }
    if (this.mDestroy)
    {
      igd.aJ("VideoFilterTools", "getFilterRender|destroy current filterRender.");
      this.mFilterRender = null;
      this.mDestroy = false;
    }
    if (this.mFilterRender == null) {
      this.mFilterRender = new FilterRender(BaseApplicationImpl.getContext());
    }
    if (this.c != null) {
      this.mFilterRender.setFilterPath(this.c.getResFold(bej));
    }
    return this.mFilterRender;
  }
  
  public void a(Context paramContext, aasr.d arg2)
  {
    if (QLog.isColorLevel()) {
      com.tencent.av.video.effect.QavVideoEffect.DEBUG_MODE = true;
    }
    igd.aJ("VideoFilterTools", "init");
    if (this.sc == null) {
      this.sc = new ArrayList();
    }
    this.a = ???;
    synchronized (this.sc)
    {
      y(aw(paramContext), this.sc);
      hK(this.sc);
      igd.aJ("VideoFilterTools", "filter list size:" + this.sc.size());
      if (this.sc.size() > 0) {
        this.c = ((FilterDesc)this.sc.get(0));
      }
      return;
    }
  }
  
  public void cxS()
  {
    igd.aJ("VideoFilterTools", "destroy");
    if (this.mFilterRender != null)
    {
      this.mFilterRender.destroy();
      this.mFilterRender = null;
    }
    this.mDestroy = false;
  }
  
  public void dA(Context paramContext)
  {
    if (new File(bel + "beauty_config.json").exists())
    {
      if (!new File(PC + "params.json").exists())
      {
        igd.aJ("VideoFilterTools", "!JasonFile.exists()");
        dz(paramContext);
      }
      return;
    }
    igd.aJ("VideoFilterTools", "BEAUTY_CONFIG  is not exsit");
  }
  
  public void destroy()
  {
    igd.aJ("VideoFilterTools", "destroy");
    this.mDestroy = true;
  }
  
  public void jdMethod_do(ArrayList<FilterDesc> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((FilterDesc)paramArrayList.next()).id == 9) {
        paramArrayList.remove();
      }
    }
  }
  
  public List<FilterDesc> dw()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    Object localObject3;
    String str1;
    boolean bool;
    synchronized (this.sc)
    {
      jdMethod_do(this.sc);
      localObject2 = this.sc.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FilterDesc)((Iterator)localObject2).next();
        str1 = ((FilterDesc)localObject3).getIconFile(bej);
        bool = new File(str1).exists();
        igd.aJ("VideoFilterTools", "getFilterDescs " + str1 + " exist: " + bool);
        if (bool)
        {
          str1 = ((FilterDesc)localObject3).getResFold(bej);
          String str2 = str1 + "params.json";
          bool = new File(str2).exists();
          igd.aJ("VideoFilterTools", "getFilterDescs " + str2 + " exist: " + bool);
          if ((TextUtils.isEmpty(str1)) || ((str1 != null) && (bool))) {
            localArrayList.add(localObject3);
          }
        }
      }
    }
    ??? = this.sc.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (FilterDesc)((Iterator)???).next();
      localObject3 = ((FilterDesc)localObject2).getIconFile(bej);
      bool = new File((String)localObject3).exists();
      igd.aJ("VideoFilterTools", "getFilterDescs " + (String)localObject3 + " exist: " + bool);
      if (bool)
      {
        localObject3 = ((FilterDesc)localObject2).getResFold(bej);
        str1 = (String)localObject3 + "params.json";
        bool = new File(str1).exists();
        igd.aJ("VideoFilterTools", "getFilterDescs " + str1 + " exist: " + bool);
        if ((TextUtils.isEmpty((CharSequence)localObject3)) || ((localObject3 != null) && (bool))) {
          localList.add(localObject2);
        }
      }
    }
    return localList;
  }
  
  void hK(List<FilterDesc> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      igd.aJ("VideoFilterTools", "preDownloadResource list is empty!");
    }
    do
    {
      return;
      igd.aJ("VideoFilterTools", "preDownloadResource list size: " + paramList.size());
      this.aJ.set(0);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FilterDesc localFilterDesc = (FilterDesc)paramList.next();
        igd.aJ("VideoFilterTools", "preDownloadResource predownload: " + localFilterDesc.predownload + ", iconurl: " + localFilterDesc.iconurl + ", resurl:" + localFilterDesc.resurl);
        if (localFilterDesc.predownload == 1)
        {
          Object localObject2;
          if (!TextUtils.isEmpty(localFilterDesc.iconurl))
          {
            localObject1 = localFilterDesc.getIconFile(bej);
            localObject2 = new File((String)localObject1);
            igd.aJ("VideoFilterTools", "preDownloadResource " + (String)localObject1 + " exist: " + ((File)localObject2).exists());
            if (!((File)localObject2).exists())
            {
              localObject2 = new aoll();
              ((aoll)localObject2).f = new aasr.c();
              ((aoll)localObject2).bZ = localFilterDesc.iconurl;
              ((aoll)localObject2).mHttpMethod = 0;
              ((aoll)localObject2).atY = ((String)localObject1);
              ((aoll)localObject2).bw(localFilterDesc);
              ige.a().a((aomg)localObject2);
              this.aJ.incrementAndGet();
            }
          }
          Object localObject1 = localFilterDesc.getResFold(bej);
          if ((!TextUtils.isEmpty(localFilterDesc.resurl)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            localObject2 = new File((String)localObject1 + "params.json");
            igd.aJ("VideoFilterTools", "preDownloadResource " + (String)localObject1 + "params.json" + " exist: " + ((File)localObject2).exists());
            if (!((File)localObject2).exists())
            {
              localObject1 = new aoll();
              ((aoll)localObject1).f = new aasr.a();
              ((aoll)localObject1).bZ = localFilterDesc.resurl;
              ((aoll)localObject1).mHttpMethod = 0;
              ((aoll)localObject1).atY = (bej + localFilterDesc.name + ".zip");
              ((aoll)localObject1).bw(localFilterDesc);
              ige.a().a((aomg)localObject1);
              this.aJ.incrementAndGet();
            }
          }
        }
      }
    } while ((this.aJ.get() != 0) || (this.a == null));
    this.a.CT(false);
  }
  
  public void release()
  {
    this.a = null;
    if (this.mFilterTextureFbo != -1) {
      this.mFilterTextureFbo = -1;
    }
    if (this.mFilterTextureId[0] != -1) {
      this.mFilterTextureId[0] = -1;
    }
  }
  
  public void setCurrentId(FilterDesc paramFilterDesc)
  {
    Object localObject2 = null;
    if (paramFilterDesc != null) {
      new StringBuilder().append(paramFilterDesc.id).append("").toString();
    }
    StringBuilder localStringBuilder;
    if (AudioHelper.aCz())
    {
      localStringBuilder = new StringBuilder().append("setCurrentId, id[");
      if (paramFilterDesc != null) {
        break label107;
      }
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append("->");
      if (this.c != null) {
        break label118;
      }
    }
    label107:
    label118:
    for (Object localObject1 = localObject2;; localObject1 = Integer.valueOf(this.c.id))
    {
      QLog.w("VideoFilterTools", 1, localObject1 + "]");
      this.c = paramFilterDesc;
      return;
      localObject1 = Integer.valueOf(paramFilterDesc.id);
      break;
    }
  }
  
  class a
    implements aolm.b
  {
    a() {}
    
    public void onResp(aomh paramaomh)
    {
      Object localObject = (FilterDesc)paramaomh.b.U();
      if (paramaomh.mResult != 0) {
        igd.aJ("VideoFilterTools", "download file failed. errorCode: " + paramaomh.mErrCode + ", errorMsg: " + paramaomh.clO + ", file: " + ((FilterDesc)localObject).resurl);
      }
      for (;;)
      {
        return;
        if (!((FilterDesc)localObject).resMD5.equalsIgnoreCase(SecUtil.getFileMd5(paramaomh.b.atY)))
        {
          igd.aJ("VideoFilterTools", "download file failed: md5 is not match.");
          aqhq.deleteFile(paramaomh.b.atY);
          return;
        }
        igd.aJ("VideoFilterTools", "download resFile success. file: " + ((FilterDesc)localObject).resurl);
        try
        {
          localObject = aasr.bej;
          aqhq.W(paramaomh.b.atY, (String)localObject, false);
          aqhq.deleteFile(paramaomh.b.atY);
          if ((aasr.a(aasr.this).decrementAndGet() == 0) && (aasr.a(aasr.this) != null))
          {
            aasr.a(aasr.this).CT(true);
            return;
          }
        }
        catch (IOException paramaomh)
        {
          paramaomh.printStackTrace();
          igd.aJ("VideoFilterTools", "unzip file failed.");
        }
      }
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  }
  
  static class b
    implements aolm.b
  {
    public void onResp(aomh paramaomh)
    {
      Object localObject = (aasr.e)paramaomh.b.U();
      igd.aJ("VideoFilterTools", "download file call back. file = " + ((aasr.e)localObject).resUrl);
      if (paramaomh.mResult != 0)
      {
        igd.aJ("VideoFilterTools", "download file faild. errcode = " + paramaomh.mErrCode);
        return;
      }
      if (!((aasr.e)localObject).resMD5.equalsIgnoreCase(SecUtil.getFileMd5(paramaomh.b.atY)))
      {
        igd.aJ("VideoFilterTools", "download file faild : md5 is not match.");
        aqhq.deleteFile(paramaomh.b.atY);
        return;
      }
      igd.aJ("VideoFilterTools", "download file successed.");
      try
      {
        localObject = aasr.bel;
        aqhq.W(paramaomh.b.atY, (String)localObject, false);
        aqhq.deleteFile(paramaomh.b.atY);
        return;
      }
      catch (IOException paramaomh)
      {
        paramaomh.printStackTrace();
        igd.aJ("VideoFilterTools", "BEAUTY_ZIP unzip file faild.");
      }
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  }
  
  class c
    implements aolm.b
  {
    c() {}
    
    public void onResp(aomh paramaomh)
    {
      FilterDesc localFilterDesc = (FilterDesc)paramaomh.b.U();
      if (paramaomh.mResult != 0)
      {
        igd.aJ("VideoFilterTools", "download IconFile failed. errorCode: " + paramaomh.mErrCode + ", errorMsg: " + paramaomh.clO + ", file: " + localFilterDesc.iconurl);
        return;
      }
      if ((aasr.a(aasr.this).decrementAndGet() == 0) && (aasr.a(aasr.this) != null)) {
        aasr.a(aasr.this).CT(true);
      }
      igd.aJ("VideoFilterTools", "download iconFile success. file: " + localFilterDesc.iconurl);
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  }
  
  public static abstract interface d
  {
    public abstract void CT(boolean paramBoolean);
  }
  
  public static class e
  {
    public int id;
    public String resMD5;
    public String resUrl;
    
    public e(int paramInt, String paramString1, String paramString2)
    {
      this.id = paramInt;
      this.resUrl = paramString1;
      this.resMD5 = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aasr
 * JD-Core Version:    0.7.0.1
 */