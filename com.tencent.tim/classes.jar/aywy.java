import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.opencl.OpenclInfoManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.e;
import com.tencent.mobileqq.shortvideo.filter.QQBaseFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import dov.com.qq.im.ptv.LightVideoConfigMgr;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class aywy
{
  private static aywy a;
  public float GS = 0.5F;
  private String cYf = "";
  public String cen = "";
  public boolean dBA = true;
  public boolean dBB;
  public boolean dBy;
  public boolean dBz;
  private int eMV = 1;
  private int mFaceDetectType = 1;
  private Map<Integer, aasq> mP = new HashMap();
  public Map<Integer, Float> qY = new HashMap();
  private Map<Integer, aasq> qZ = new HashMap();
  
  private aywy()
  {
    anq();
  }
  
  private void QA(String paramString)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString = paramString.split(";");
    for (;;)
    {
      int j;
      int i;
      boolean bool1;
      Object localObject;
      int k;
      int m;
      int n;
      try
      {
        if (this.cen.contains("Mali"))
        {
          j = arrayOfString.length;
          i = 0;
          bool1 = bool3;
          if (i < j)
          {
            paramString = arrayOfString[i].split("#");
            bool1 = bool3;
            if (paramString.length == 4)
            {
              localObject = paramString[0] + paramString[1];
              if (!this.cen.contains((CharSequence)localObject)) {
                break label383;
              }
              localObject = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(this.cen);
              bool1 = ((Matcher)localObject).find();
              if (!bool1) {
                break label383;
              }
            }
          }
        }
        bool1 = bool3;
      }
      catch (Exception paramString)
      {
        try
        {
          k = Integer.parseInt(((Matcher)localObject).group(4));
          m = Integer.parseInt(paramString[2]);
          n = Integer.parseInt(paramString[3]);
          if ((k > n) || (k < m)) {
            break label377;
          }
          bool1 = bool2;
          Qc(bool1);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
        paramString = paramString;
        paramString.printStackTrace();
        return;
      }
      if (this.cen.contains("Adreno"))
      {
        j = arrayOfString.length;
        i = 0;
        for (;;)
        {
          for (;;)
          {
            bool1 = bool3;
            if (i >= j) {
              break;
            }
            localObject = arrayOfString[i].split("#");
            paramString = "0";
            Matcher localMatcher = Pattern.compile("Adreno.*(\\d{3,4})").matcher(this.cen);
            if (localMatcher.find()) {
              paramString = localMatcher.group(1);
            }
            if ((localObject.length != 3) || (!paramString.substring(0, 1).equals(localObject[0])))
            {
              k = localObject.length;
              if (k != 2) {}
            }
            else
            {
              try
              {
                k = Integer.parseInt(paramString);
                m = Integer.parseInt(localObject[(localObject.length - 2)]);
                n = Integer.parseInt(localObject[(localObject.length - 1)]);
                bool1 = bool3;
                if (k > n) {
                  break;
                }
                bool1 = bool3;
                if (k < m) {
                  break;
                }
                bool1 = true;
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
              }
            }
          }
          i += 1;
        }
        label377:
        bool1 = false;
        continue;
        label383:
        i += 1;
      }
    }
  }
  
  private void QB(String paramString)
  {
    boolean bool2 = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = paramString.split(";");
    for (;;)
    {
      int i;
      try
      {
        int j = paramString.length;
        i = 0;
        boolean bool1 = bool2;
        if (i < j)
        {
          CharSequence localCharSequence = paramString[i];
          if (this.cen.contains(localCharSequence)) {
            bool1 = true;
          }
        }
        else
        {
          Qc(bool1);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  private void Qc(boolean paramBoolean)
  {
    if ("white".equals(this.cYf)) {
      if (paramBoolean)
      {
        this.dBz = true;
        this.dBy = false;
      }
    }
    while (!"black".equals(this.cYf))
    {
      return;
      this.dBz = false;
      return;
    }
    if (!paramBoolean)
    {
      this.dBy = false;
      return;
    }
    this.dBy = true;
    this.dBz = false;
  }
  
  public static aywy a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aywy();
      }
      return a;
    }
    finally {}
  }
  
  private void bA(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("rule").split(";");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        hr(str, paramJSONObject.getString(str));
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void by(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("verdor").split(";");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (this.cen.contains(str)) {
          bz(paramJSONObject.getJSONObject(str));
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void bz(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("strategy").split(";");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        JSONObject localJSONObject = paramJSONObject.getJSONObject(str);
        this.cYf = str;
        bA(localJSONObject);
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void cR(String paramString, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString1 = paramString.split(";");
    label409:
    label415:
    for (;;)
    {
      int j;
      int i;
      boolean bool1;
      String[] arrayOfString2;
      int k;
      int m;
      try
      {
        if (!this.cen.contains("Mali")) {
          break label232;
        }
        j = arrayOfString1.length;
        i = 0;
        bool1 = bool3;
        if (i < j)
        {
          arrayOfString2 = arrayOfString1[i].split("#");
          if (arrayOfString2.length != 2) {
            break label185;
          }
          paramString = arrayOfString2[0];
          if (!this.cen.contains(paramString)) {
            break label415;
          }
          paramString = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(this.cen);
          k = arrayOfString2.length;
          bool1 = paramString.find();
          if (!bool1) {
            break label415;
          }
        }
        bool1 = bool3;
      }
      catch (Exception paramString)
      {
        try
        {
          k = Integer.parseInt(paramString.group((k - 1) * 2));
          m = Integer.parseInt(arrayOfString2[(arrayOfString2.length - 1)]);
          if (paramBoolean)
          {
            bool1 = bool2;
            if (k >= m) {}
          }
          else
          {
            if ((paramBoolean) || (k > m)) {
              break label409;
            }
            bool1 = bool2;
          }
          Qc(bool1);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
        paramString = paramString;
        paramString.printStackTrace();
        return;
      }
      label185:
      if (arrayOfString2.length == 3)
      {
        paramString = arrayOfString2[0] + arrayOfString2[1];
        continue;
        label232:
        bool1 = bool3;
        if (this.cen.contains("Adreno"))
        {
          j = arrayOfString1.length;
          i = 0;
          for (;;)
          {
            for (;;)
            {
              bool1 = bool3;
              if (i >= j) {
                break;
              }
              arrayOfString2 = arrayOfString1[i].split("#");
              paramString = "0";
              Matcher localMatcher = Pattern.compile("Adreno.*(\\d{3,4})").matcher(this.cen);
              if (localMatcher.find()) {
                paramString = localMatcher.group(1);
              }
              if ((arrayOfString2.length != 2) || (!paramString.substring(0, 1).equals(arrayOfString2[0])))
              {
                k = arrayOfString2.length;
                if (k != 1) {}
              }
              else
              {
                try
                {
                  k = Integer.parseInt(paramString);
                  m = Integer.parseInt(arrayOfString2[(arrayOfString2.length - 1)]);
                  if ((!paramBoolean) || (k < m))
                  {
                    bool1 = bool3;
                    if (paramBoolean) {
                      break;
                    }
                    bool1 = bool3;
                    if (k > m) {
                      break;
                    }
                  }
                  bool1 = true;
                }
                catch (Exception paramString)
                {
                  paramString.printStackTrace();
                }
              }
            }
            i += 1;
          }
          bool1 = false;
          continue;
          i += 1;
        }
      }
    }
  }
  
  private void co(JSONObject paramJSONObject)
  {
    try
    {
      this.GS = Float.valueOf(paramJSONObject.getString("maxWeight")).floatValue();
      paramJSONObject = paramJSONObject.getJSONObject("renderListWeight");
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = paramJSONObject.getString(str1);
        this.qY.put(Integer.valueOf(str1), Float.valueOf(str2));
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void cp(JSONObject paramJSONObject)
  {
    int i = 0;
    try
    {
      String[] arrayOfString1 = paramJSONObject.getString("resolutionList").split(";");
      paramJSONObject = paramJSONObject.getString("cpResolutionList").split(";");
      if (arrayOfString1.length == paramJSONObject.length) {
        while (i < arrayOfString1.length)
        {
          String[] arrayOfString2 = arrayOfString1[i].split("\\*");
          String[] arrayOfString3 = paramJSONObject[i].split("\\*");
          if ((arrayOfString2.length == 2) && (arrayOfString3.length == 2))
          {
            this.mP.put(Integer.valueOf(i), new aasq(Integer.valueOf(arrayOfString2[0]).intValue(), Integer.valueOf(arrayOfString2[1]).intValue()));
            this.qZ.put(Integer.valueOf(i), new aasq(Integer.valueOf(arrayOfString3[0]).intValue(), Integer.valueOf(arrayOfString3[1]).intValue()));
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void cq(JSONObject paramJSONObject)
  {
    try
    {
      String str1 = Build.MANUFACTURER + ";" + Build.MODEL;
      paramJSONObject = paramJSONObject.getJSONArray("blackList");
      int i = 0;
      for (;;)
      {
        if (i < paramJSONObject.length())
        {
          String str2 = paramJSONObject.getString(i);
          if (!str2.trim().equals(str1.trim())) {
            break label107;
          }
          this.dBB = true;
          if (QLog.isColorLevel()) {
            QLog.d("DovSVParamManager", 2, "parseJSONBlackList true =" + str2);
          }
        }
        return;
        label107:
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void cr(JSONObject paramJSONObject)
  {
    try
    {
      String str1 = DeviceInstance.getInstance().getDeviceName();
      paramJSONObject = paramJSONObject.getJSONArray("qijianList");
      int i = 0;
      for (;;)
      {
        if (i < paramJSONObject.length())
        {
          String str2 = paramJSONObject.getString(i);
          if (!str2.trim().equals(str1.trim())) {
            break label87;
          }
          this.dBA = true;
          if (QLog.isColorLevel()) {
            QLog.d("DovSVParamManager", 2, "parseJSONQijianList true =" + str2);
          }
        }
        return;
        label87:
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void cs(JSONObject paramJSONObject)
  {
    try
    {
      this.mFaceDetectType = paramJSONObject.optInt("faceDetectSwitch", 1);
      if (QLog.isColorLevel()) {
        QLog.d("DovSVParamManager", 2, "parseJSONFaceDetectSwitch mFaceDetectType:" + this.mFaceDetectType);
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void hr(String paramString1, String paramString2)
  {
    if ("large".equals(paramString1)) {
      cR(paramString2, true);
    }
    do
    {
      return;
      if ("less".equals(paramString1))
      {
        cR(paramString2, false);
        return;
      }
      if ("between".equals(paramString1))
      {
        QA(paramString2);
        return;
      }
    } while (!"enum".equals(paramString1));
    QB(paramString2);
  }
  
  private String zD()
  {
    String str2 = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_gpu_config", 0).getString("cfg_content", "");
    String str1;
    if (TextUtils.isEmpty(str2))
    {
      str2 = aqhq.py("short_video_device_rule_config.xml");
      str1 = str2;
      if (QLog.isColorLevel())
      {
        QLog.d("DovSVParamManager", 2, "take local config");
        str1 = str2;
      }
    }
    do
    {
      return str1;
      str1 = str2;
    } while (!QLog.isColorLevel());
    QLog.d("DovSVParamManager", 2, "take server config");
    return str2;
  }
  
  public aasq a(int paramInt)
  {
    if (this.dBB) {}
    for (aasq localaasq = (aasq)this.mP.get(Integer.valueOf(1));; localaasq = (aasq)this.mP.get(Integer.valueOf(0)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DovSVParamManager", 2, "getCameraResolution inBlackPhone = " + this.dBB + " dpcSize=" + localaasq);
      }
      return localaasq;
    }
  }
  
  public awvv a(Context paramContext, int paramInt)
  {
    paramContext = new awvv();
    aasq localaasq1 = a(paramInt);
    aasq localaasq2 = c(paramInt);
    if (localaasq1 != null)
    {
      paramContext.TN(localaasq1.getWidth());
      paramContext.TO(localaasq1.getHeight());
    }
    if (localaasq2 != null)
    {
      paramContext.TP(localaasq2.getWidth());
      paramContext.TQ(localaasq2.getHeight());
    }
    paramContext.bb(w(paramInt));
    int i = iS(paramInt) * 1000;
    paramContext.TT(i);
    aniq.dFI = i;
    paramContext.TU(1);
    paramContext.TS(paramInt);
    if ((anki.axH()) && (Build.VERSION.SDK_INT < 27)) {
      paramContext.TV(0);
    }
    return paramContext;
  }
  
  public CameraCaptureView.e a(Context paramContext)
  {
    CameraCaptureView.e locale = new CameraCaptureView.e();
    int i = alwt.Ip();
    aasq localaasq1 = a(i);
    aasq localaasq2 = c(i);
    paramContext = b(paramContext);
    if (localaasq1 != null)
    {
      locale.TN(localaasq1.getWidth());
      locale.TO(localaasq1.getHeight());
    }
    if (localaasq2 != null)
    {
      locale.TP(localaasq2.getWidth());
      locale.TQ(localaasq2.getHeight());
    }
    if (paramContext != null)
    {
      locale.TR(paramContext.getWidth());
      locale.setScreenHeight(paramContext.getHeight());
    }
    locale.bb(w(i));
    int j = iS(i) * 1000;
    locale.TT(j);
    aniq.dFI = j;
    locale.TU(1);
    locale.TS(i);
    if ((anki.axH()) && (Build.VERSION.SDK_INT < 27)) {
      locale.TV(0);
    }
    return locale;
  }
  
  public boolean a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    int i = aqgz.getOsVersion();
    if (i < paramInt2)
    {
      igd.aJ("DovSVParamManager", "isSupportOfDevice error OSversion: " + i);
      return false;
    }
    paramInt2 = imm.getNumCores();
    if (paramInt2 < paramInt1)
    {
      igd.aJ("DovSVParamManager", "isSupportOfDevice error cpucount: " + paramInt2);
      return false;
    }
    long l = imm.getMaxCpuFreq();
    if (l < paramLong1)
    {
      igd.aJ("DovSVParamManager", "isSupportOfDevice error cpuFrequency: " + l);
      return false;
    }
    paramLong1 = aqgz.getSystemTotalMemory();
    if (paramLong1 < paramLong2)
    {
      igd.aJ("DovSVParamManager", "isSupportOfDevice error memory: " + paramLong1);
      return false;
    }
    return true;
  }
  
  public boolean aRl()
  {
    return this.dBy;
  }
  
  public boolean aRm()
  {
    return this.dBA;
  }
  
  public boolean aRn()
  {
    return this.mFaceDetectType == 1;
  }
  
  public boolean aRo()
  {
    return this.eMV == 1;
  }
  
  public boolean aRp()
  {
    return this.dBB;
  }
  
  public void anq()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(zD());
      cp(localJSONObject);
      co(localJSONObject);
      cn(localJSONObject);
      cq(localJSONObject);
      cr(localJSONObject);
      cs(localJSONObject);
      ct(localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("DovSVParamManager", 2, "parse sv config error, stacktrace :  " + QLog.getStackTraceString(localException));
    }
  }
  
  public float b(List<QQBaseFilter> paramList)
  {
    paramList = paramList.iterator();
    float f = 0.0F;
    if (paramList.hasNext())
    {
      QQBaseFilter localQQBaseFilter = (QQBaseFilter)paramList.next();
      if (!this.qY.containsKey(Integer.valueOf(localQQBaseFilter.getFilterType()))) {
        break label77;
      }
      f = ((Float)this.qY.get(Integer.valueOf(localQQBaseFilter.getFilterType()))).floatValue() + f;
    }
    label77:
    for (;;)
    {
      break;
      return f;
    }
  }
  
  public aasq b(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return new aasq(localDisplayMetrics.heightPixels, localDisplayMetrics.widthPixels);
  }
  
  public awvv b(Context paramContext, int paramInt)
  {
    paramContext = new awvv();
    aasq localaasq = alxh.a().a(paramInt);
    paramContext.TN(localaasq.getWidth());
    paramContext.TO(localaasq.getHeight());
    paramContext.bb(alxh.a().w(paramInt));
    int i = alxh.a().iS(paramInt) * 1000;
    paramContext.TT(i);
    aniq.dFI = i;
    paramContext.TU(1);
    paramContext.TS(paramInt);
    return paramContext;
  }
  
  public CameraCaptureView.e b(Context paramContext)
  {
    paramContext = new CameraCaptureView.e();
    int i = alwt.Ip();
    aasq localaasq = alxh.a().a(i);
    paramContext.TN(localaasq.getWidth());
    paramContext.TO(localaasq.getHeight());
    paramContext.bb(alxh.a().w(i));
    int j = alxh.a().iS(i) * 1000;
    paramContext.TT(j);
    aniq.dFI = j;
    paramContext.TU(1);
    paramContext.TS(i);
    return paramContext;
  }
  
  public boolean b(String paramString, int paramInt, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DovSVParamManager", 2, "saveGPUConfig :  " + paramString);
    }
    paramContext = paramContext.getSharedPreferences("short_video_gpu_config", 0).edit();
    paramContext.putString("cfg_content", paramString);
    paramContext.putInt("cfg_version", paramInt);
    return paramContext.commit();
  }
  
  public int bJ(Context paramContext)
  {
    return paramContext.getSharedPreferences("short_video_gpu_config", 0).getInt("cfg_version", 0);
  }
  
  public aasq c(int paramInt)
  {
    if (this.dBB) {}
    for (aasq localaasq = (aasq)this.qZ.get(Integer.valueOf(1));; localaasq = (aasq)this.qZ.get(Integer.valueOf(0)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DovSVParamManager", 2, "getDpcCompressResolution inBlackPhone = " + this.dBB + " dpcCompressSize=" + localaasq);
      }
      return localaasq;
    }
  }
  
  public CameraCaptureView.e c(Context paramContext)
  {
    paramContext = new CameraCaptureView.e();
    if (anih.agb()) {}
    for (int i = 1;; i = 2)
    {
      aasq localaasq = alxh.a().b(i);
      paramContext.TN(localaasq.getWidth());
      paramContext.TO(localaasq.getHeight());
      paramContext.bb(1.0F);
      int j = LightVideoConfigMgr.a().RD() * 1000;
      if (QLog.isColorLevel()) {
        QLog.e("DovSVParamManager", 2, "getLightVideoCaptureParam bitrate:  " + j);
      }
      paramContext.TT(j);
      aniq.dFI = j;
      paramContext.TU(1);
      paramContext.TS(i);
      return paramContext;
    }
  }
  
  public void cn(JSONObject paramJSONObject)
  {
    boolean bool = true;
    if ((Build.MODEL.contains("Pixel")) || (Build.MODEL.contains("Nexus")) || (Build.VERSION.SDK_INT >= 24) || (Build.VERSION.SDK_INT < 21)) {
      if (!a(4, 1200000L, 2573741824L, 17))
      {
        bool = true;
        this.dBy = bool;
      }
    }
    do
    {
      by(paramJSONObject);
      return;
      bool = false;
      break;
      if (TextUtils.isEmpty(this.cen))
      {
        this.cen = new OpenclInfoManager().xK();
        QLog.d("DovSVParamManager", 1, "GPUInfo:" + this.cen);
      }
    } while (!TextUtils.isEmpty(this.cen));
    if (!a(4, 1200000L, 2573741824L, 17)) {}
    for (;;)
    {
      this.dBy = bool;
      break;
      bool = false;
    }
  }
  
  public float co()
  {
    return this.GS;
  }
  
  public void ct(JSONObject paramJSONObject)
  {
    try
    {
      this.eMV = paramJSONObject.optInt("samSungCameraSwitch", 1);
      if (QLog.isColorLevel()) {
        QLog.d("DovSVParamManager", 2, "parseJsonSamSungSwitch parseJsonSamSungSwitch:" + this.eMV);
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public int iS(int paramInt)
  {
    return 4000;
  }
  
  public float w(int paramInt)
  {
    return 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aywy
 * JD-Core Version:    0.7.0.1
 */