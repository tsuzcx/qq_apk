import android.text.TextUtils;
import com.tencent.aekit.api.standard.GLCapabilities;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import javax.annotation.Nullable;

public class axip
{
  private static Long ao = Long.valueOf(-1L);
  public static final Long ap = Long.valueOf(-1L);
  public static final Long aq = Long.valueOf(1L);
  public static final Long ar = Long.valueOf(2L);
  public static final Long as = Long.valueOf(3L);
  public static final Long at = Long.valueOf(4L);
  public static final Long au = Long.valueOf(5L);
  private axir a = new axir();
  private long aBU = -1L;
  private long aBV;
  private long aBW;
  private long aBX;
  private long aBY;
  private long aBZ = -1L;
  private long aCa = -1L;
  private long aCb;
  private long aCc = 1L;
  private long aCd = 1L;
  private String auH = "#ffffff";
  private String cUJ;
  private String cUK = "none";
  private String cUL = "none";
  private String cUM = "-1";
  private String cUN = "none";
  private String cUO = "none";
  private String cUP;
  private String cUQ;
  private String cUR = "none";
  private String cUS = "none";
  private String cUT = "";
  private int cnW = -1;
  private boolean duU;
  private boolean duV;
  private boolean duW;
  private boolean duX = true;
  private int eFi = -1;
  private int eFj;
  private int mBeautyValue;
  private String mTextContent = "none";
  private String mUin;
  private long mVideoDuration;
  private HashMap<String, String> rc = new HashMap();
  
  public static axip a()
  {
    return axip.a.b();
  }
  
  private HashMap<String, String> a(String paramString1, int paramInt, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    if ((this.cnW == 4) || (this.cnW == 5) || (this.cnW == 6) || (this.cnW == 7) || (this.cnW == 2))
    {
      localHashMap.put("face_id", this.cUL);
      localHashMap.put("content_type", ao.toString());
      localHashMap.put("MD5", paramString1);
      paramString1 = new DecimalFormat("0.00").format(this.mBeautyValue / 100.0F);
      String str = new DecimalFormat("0.00").format(this.eFj / 100.0F);
      localHashMap.put("beauty_value", paramString1);
      localHashMap.put("facial_value", str);
      if (TextUtils.isEmpty(this.cUJ)) {
        break label416;
      }
      localHashMap.put("filter_id", this.cUJ);
      label172:
      localHashMap.put("duration", "" + this.mVideoDuration);
      localHashMap.put("cameraId", axio.fi(aaqh.cix));
      if (ao.longValue() != 1L) {
        break label429;
      }
      localHashMap.put("resolution", awyu.a.Hu());
    }
    for (;;)
    {
      localHashMap.put("post_type", String.valueOf(paramInt));
      localHashMap.put("receive_type", paramString2);
      localHashMap.put("face_index", String.valueOf(this.eFi));
      localHashMap.put("face_from", this.cUM);
      localHashMap.put("face_tab", this.cUN);
      localHashMap.put("face_type", this.cnW + "");
      if ((this.cnW != 4) && (this.cnW != 5) && (this.cnW != 6) && (this.cnW != 7)) {
        break label472;
      }
      localHashMap.put("face_uin", this.cUL + UserAction.getQIMEI());
      return localHashMap;
      localHashMap.put("face_id", this.cUK);
      break;
      label416:
      localHashMap.put("filter_id", "none");
      break label172;
      label429:
      if (ao.longValue() == 2L) {
        localHashMap.put("resolution", awyu.a.Hz());
      } else {
        localHashMap.put("resolution", "none");
      }
    }
    label472:
    localHashMap.put("face_uin", this.cUK + UserAction.getQIMEI());
    return localHashMap;
  }
  
  private HashMap<String, String> b(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap(6);
    localHashMap.put("face_id", paramString1);
    localHashMap.put("face_tab", this.cUN);
    localHashMap.put("face_type", this.cnW + "");
    localHashMap.put("face_index", String.valueOf(this.eFi));
    localHashMap.put("face_from", paramString2);
    localHashMap.put("face_uin", paramString1 + UserAction.getQIMEI());
    return localHashMap;
  }
  
  private long iW()
  {
    return System.currentTimeMillis() - this.aBU;
  }
  
  public HashMap<String, String> A(String paramString)
  {
    return b(paramString, this.cUM);
  }
  
  public HashMap<String, String> B(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString))
    {
      localHashMap.put("filter_id", "none");
      return localHashMap;
    }
    localHashMap.put("filter_id", paramString);
    return localHashMap;
  }
  
  public HashMap<String, String> C(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("filter_id", paramString);
    return localHashMap;
  }
  
  public HashMap<String, String> D(String paramString)
  {
    return b(paramString, "3");
  }
  
  public HashMap<String, String> E(String paramString)
  {
    return axio.a(ap(), b(paramString, "3"));
  }
  
  public HashMap<String, String> F(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", String.valueOf(this.a.aCe));
    localHashMap.put("filter_id", paramString);
    return localHashMap;
  }
  
  public HashMap<String, String> G(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoticon_id", paramString);
    return localHashMap;
  }
  
  public HashMap<String, String> H(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("filter_id", paramString);
    return localHashMap;
  }
  
  public String HP()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.mUin);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date());
    localStringBuilder.append(" ");
    localStringBuilder.append(str);
    return arwu.toMD5(localStringBuilder.toString());
  }
  
  public String HQ()
  {
    return this.cUR;
  }
  
  public HashMap<String, String> I(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("text_content", paramString);
    acX(paramString);
    return localHashMap;
  }
  
  public void LB(int paramInt)
  {
    this.cnW = paramInt;
  }
  
  public void Yl(boolean paramBoolean)
  {
    this.duU = paramBoolean;
  }
  
  public void Ym(boolean paramBoolean)
  {
    this.duV = paramBoolean;
  }
  
  public void Yn(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.aCc = 2L;
      return;
    }
    this.aCc = 1L;
  }
  
  public void Yo(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.aCd = 2L;
      return;
    }
    this.aCd = 1L;
  }
  
  public axir a()
  {
    return this.a;
  }
  
  public HashMap<String, String> a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ret_code", "" + paramInt1);
    localHashMap.put("req_cost", paramString1);
    localHashMap.put("cmd_id", paramString2);
    localHashMap.put("res_code", String.valueOf(paramInt2));
    return localHashMap;
  }
  
  public HashMap<String, String> a(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    if ((this.cnW == 4) || (this.cnW == 5) || (this.cnW == 6) || (this.cnW == 7) || (this.cnW == 2))
    {
      localHashMap.put("face_id", this.cUL);
      localHashMap.put("content_type", ao.toString());
      String str1 = new DecimalFormat("0.00").format(this.mBeautyValue / 100.0F);
      String str2 = new DecimalFormat("0.00").format(this.eFj / 100.0F);
      localHashMap.put("beauty_value", str1);
      localHashMap.put("facial_value", str2);
      if (TextUtils.isEmpty(this.cUJ)) {
        break label230;
      }
      localHashMap.put("filter_id", this.cUJ);
    }
    for (;;)
    {
      localHashMap.put("duration", axio.d(Long.valueOf(System.currentTimeMillis() - paramLong)));
      localHashMap.put("cameraId", axio.fi(aaqh.cix));
      if (ao.longValue() != 1L) {
        break label242;
      }
      localHashMap.put("resolution", awyu.a.Hu());
      return localHashMap;
      localHashMap.put("face_id", this.cUK);
      break;
      label230:
      localHashMap.put("filter_id", "none");
    }
    label242:
    if (ao.longValue() == 2L)
    {
      localHashMap.put("resolution", awyu.a.Hz());
      return localHashMap;
    }
    localHashMap.put("resolution", "none");
    return localHashMap;
  }
  
  public HashMap<String, String> a(long paramLong1, long paramLong2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("part_one_cost", String.valueOf(paramLong1));
    localHashMap.put("part_two_cost", String.valueOf(paramLong2));
    return localHashMap;
  }
  
  public HashMap<String, String> a(Long paramLong)
  {
    HashMap localHashMap = new HashMap();
    if ((paramLong.longValue() == -1L) || (paramLong.longValue() == 3L)) {
      localHashMap.put("receive_type", paramLong.toString());
    }
    for (;;)
    {
      localHashMap.put("content_type", ao.toString());
      return localHashMap;
      if ((paramLong.longValue() == 3000L) || (paramLong.longValue() == 1L)) {
        localHashMap.put("receive_type", "2");
      } else {
        localHashMap.put("receive_type", "1");
      }
    }
  }
  
  public HashMap<String, String> a(String paramString, int paramInt)
  {
    String str;
    if (paramInt == 1) {
      str = "2";
    }
    for (;;)
    {
      if ((this.cUP == null) || (!this.cUP.equals(paramString)))
      {
        this.cUP = paramString;
        this.cUQ = arwv.toMD5(QQStoryContext.c().getAccount() + axio.HO());
      }
      return a(paramString, 2, str);
      if (paramInt == 0) {
        str = "1";
      } else {
        str = "3";
      }
    }
  }
  
  public HashMap<String, String> a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("material_id", paramString1);
    localHashMap.put("ret", String.valueOf(paramInt));
    localHashMap.put("duration", String.valueOf(paramLong1));
    localHashMap.put("zip_size", String.valueOf(paramLong2));
    localHashMap.put("MD5", paramString2);
    return localHashMap;
  }
  
  public HashMap<String, String> a(String paramString1, boolean paramBoolean, float paramFloat, double paramDouble1, double paramDouble2, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (paramString2 = "1";; paramString2 = "2")
    {
      localHashMap.put("cameraId", paramString2);
      localHashMap.put("frame_rate", String.format("%.2f", new Object[] { Float.valueOf(paramFloat) }));
      localHashMap.put("face_id", paramString1);
      return localHashMap;
    }
  }
  
  public HashMap<String, String> a(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("base_res_ready", str);
      return localHashMap;
    }
  }
  
  public HashMap<String, String> a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("packageId", String.valueOf(paramInt));
    String str;
    if (paramBoolean)
    {
      str = "1";
      localHashMap.put("ret_code", str);
      localHashMap.put("packageName", paramString1);
      localHashMap.put("packageSubName", paramString2);
      localHashMap.put("cost_time", String.valueOf(paramLong2));
      if (!paramBoolean) {
        break label106;
      }
    }
    label106:
    for (paramString1 = "0";; paramString1 = String.valueOf(paramLong1))
    {
      localHashMap.put("error_code", paramString1);
      return localHashMap;
      str = "0";
      break;
    }
  }
  
  public HashMap<String, String> aA()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", axio.d(Long.valueOf(this.aCb)));
    localHashMap.put("cutout_type", Long.toString(this.aCc));
    localHashMap.put("countdown_type", Long.toString(this.aCd));
    Object localObject = new DecimalFormat("0.00").format(this.mBeautyValue / 100.0F);
    String str = new DecimalFormat("0.00").format(this.eFj / 100.0F);
    localHashMap.put("beauty_value", localObject);
    localHashMap.put("facial_value", str);
    localHashMap.put("cameraId", axio.fi(aaqh.cix));
    localHashMap.put("emoticon_id", this.cUR);
    localHashMap.put("text_content", this.mTextContent);
    if (this.mTextContent.equals("none"))
    {
      localHashMap.put("text_color", "none");
      localObject = ayva.a().d(0);
      if (localObject == null) {
        break label249;
      }
    }
    label249:
    for (this.cUS = ((QIMFilterCategoryItem)localObject).id;; this.cUS = "none")
    {
      localHashMap.put("filter_id", this.cUS);
      if (this.cUT.equals("")) {
        eLA();
      }
      localHashMap.put("MD5", this.cUT);
      return localHashMap;
      localHashMap.put("text_color", this.auH);
      break;
    }
  }
  
  public HashMap<String, String> aB()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", axio.d(Long.valueOf(this.aCb)));
    localHashMap.put("cutout_type", Long.toString(this.aCc));
    localHashMap.put("countdown_type", Long.toString(this.aCd));
    Object localObject = new DecimalFormat("0.00").format(this.mBeautyValue / 100.0F);
    String str = new DecimalFormat("0.00").format(this.eFj / 100.0F);
    localHashMap.put("beauty_value", localObject);
    localHashMap.put("facial_value", str);
    localHashMap.put("cameraId", axio.fi(aaqh.cix));
    localHashMap.put("text_content", this.mTextContent);
    if (!localHashMap.containsKey("emoticon_id")) {
      localHashMap.put("emoticon_id", this.cUR);
    }
    localObject = ayva.a().d(0);
    if (localObject != null)
    {
      this.cUS = ((QIMFilterCategoryItem)localObject).id;
      localHashMap.put("filter_id", this.cUS);
      if (!localHashMap.containsKey("text_color"))
      {
        if (!this.mTextContent.equals("none")) {
          break label263;
        }
        localHashMap.put("text_color", "none");
      }
    }
    for (;;)
    {
      if (this.cUT.equals("")) {
        eLA();
      }
      localHashMap.put("MD5", this.cUT);
      return localHashMap;
      this.cUS = "none";
      break;
      label263:
      localHashMap.put("text_color", this.auH);
    }
  }
  
  public boolean aOH()
  {
    return this.duU;
  }
  
  public boolean aOI()
  {
    return this.duV;
  }
  
  public boolean aOJ()
  {
    if ((this.aBV <= 0L) || (this.aBW <= 0L) || (this.aBX <= 0L) || (this.aBY <= 0L)) {}
    while ((this.aBW - this.aBV > 120000L) || (this.aBX - this.aBV > 120000L) || (this.aBY - this.aBV > 120000L)) {
      return false;
    }
    return true;
  }
  
  public void acR(String paramString)
  {
    QLog.d("AEBaseReportParam", 4, "[setExperimentID] experimentID = " + paramString);
    if ((paramString == null) || (TextUtils.isEmpty(paramString)))
    {
      this.rc.put("expirement_id", "none");
      return;
    }
    this.rc.put("expirement_id", paramString);
  }
  
  public void acS(String paramString)
  {
    this.cUK = paramString;
  }
  
  public void acT(String paramString)
  {
    this.cUL = paramString;
  }
  
  public void acU(String paramString)
  {
    this.cUM = paramString;
  }
  
  public void acV(String paramString)
  {
    this.cUN = paramString;
  }
  
  public void acW(String paramString)
  {
    this.cUS = paramString;
  }
  
  public void acX(String paramString)
  {
    this.mTextContent = paramString;
  }
  
  public void acY(String paramString)
  {
    this.cUR = paramString;
  }
  
  public void adX(int paramInt)
  {
    this.eFi = paramInt;
  }
  
  public void adY(int paramInt)
  {
    this.mBeautyValue = paramInt;
  }
  
  public void adZ(int paramInt)
  {
    this.eFj = paramInt;
  }
  
  public HashMap<String, String> aj()
  {
    return this.rc;
  }
  
  public HashMap<String, String> ak()
  {
    return b(this.cUL, "3");
  }
  
  public HashMap<String, String> al()
  {
    return b(this.cUL, this.cUM);
  }
  
  public HashMap<String, String> am()
  {
    return b(this.cUL, this.cUM);
  }
  
  public HashMap<String, String> an()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("face_id", axis.a().t("camera_ad_op_id", "", 4));
    return localHashMap;
  }
  
  public HashMap<String, String> ao()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", axio.d(Long.valueOf(iW())));
    return localHashMap;
  }
  
  public HashMap<String, String> ap()
  {
    if (TextUtils.isEmpty(this.cUQ)) {}
    for (String str = arwv.toMD5(QQStoryContext.c().getAccount() + axio.HO());; str = this.cUQ) {
      return a(str, 1, "-1");
    }
  }
  
  public HashMap<String, String> aq()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", String.valueOf(this.a.mDuration));
    localHashMap.put("content_type", String.valueOf(this.a.aCe));
    localHashMap.put("MD5", this.a.cUU);
    localHashMap.put("filter_id", this.a.cUV);
    localHashMap.put("filter_value", String.valueOf(this.a.Ek));
    localHashMap.put("music_id", this.a.cUW);
    localHashMap.put("sound_type", String.valueOf(this.a.eFk));
    localHashMap.put("text_count", String.valueOf(this.a.eFl));
    localHashMap.put("music_list", this.a.cUY);
    localHashMap.put("video_id", this.a.cUU);
    localHashMap.put("music_common_info", this.a.cUX);
    localHashMap.put("face_id", this.cUK);
    return localHashMap;
  }
  
  public HashMap<String, String> ar()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", String.valueOf(this.a.aCe));
    return localHashMap;
  }
  
  public HashMap<String, String> as()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("video_id", this.a.cUU);
    return localHashMap;
  }
  
  public HashMap<String, String> at()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("music_id", this.a.cUW);
    localHashMap.put("music_list", this.a.cUY);
    localHashMap.put("video_id", this.a.cUU);
    return localHashMap;
  }
  
  public HashMap<String, String> au()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", ao.toString());
    return localHashMap;
  }
  
  public HashMap<String, String> av()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration_first_frame", axio.d(Long.valueOf(this.aBW - this.aBV)));
    localHashMap.put("duration_bottom_bar", axio.d(Long.valueOf(this.aBX - this.aBV)));
    localHashMap.put("duration_photo_btn", axio.d(Long.valueOf(this.aBY - this.aBV)));
    String str;
    if (axio.aOG()) {
      str = "first_launch";
    }
    for (;;)
    {
      localHashMap.put("launch_type", str);
      return localHashMap;
      if (this.duW) {
        str = "cold_launch";
      } else {
        str = "warm_launch";
      }
    }
  }
  
  public HashMap<String, String> aw()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("OpenGL", GLCapabilities.getGlesVersion());
    localHashMap.put("shader", String.valueOf(GLCapabilities.isFilamentShaderCompileSucceed()));
    return localHashMap;
  }
  
  public HashMap<String, String> ax()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.aCa;
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", axio.d(Long.valueOf(l1 - l2)));
    return localHashMap;
  }
  
  public HashMap<String, String> ay()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", axio.d(Long.valueOf(this.aCb)));
    localHashMap.put("cutout_type", Long.toString(this.aCc));
    localHashMap.put("countdown_type", Long.toString(this.aCd));
    Object localObject = new DecimalFormat("0.00").format(this.mBeautyValue / 100.0F);
    String str = new DecimalFormat("0.00").format(this.eFj / 100.0F);
    localHashMap.put("beauty_value", localObject);
    localHashMap.put("facial_value", str);
    localObject = ayva.a().d(0);
    if (localObject != null) {}
    for (this.cUS = ((QIMFilterCategoryItem)localObject).id;; this.cUS = "none")
    {
      localHashMap.put("filter_id", this.cUS);
      localHashMap.put("cameraId", axio.fi(aaqh.cix));
      localHashMap.put("emoticon_id", this.cUR);
      return localHashMap;
    }
  }
  
  public HashMap<String, String> az()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoticon_id", this.cUR);
    return localHashMap;
  }
  
  public HashMap<String, String> b(long paramLong)
  {
    long l = -1L;
    HashMap localHashMap = new HashMap();
    if ((this.cnW == 4) || (this.cnW == 5) || (this.cnW == 6) || (this.cnW == 7) || (this.cnW == 2))
    {
      localHashMap.put("face_id", this.cUL);
      localHashMap.put("content_type", ao.toString());
      localObject = new DecimalFormat("0.00").format(this.mBeautyValue / 100.0F);
      String str = new DecimalFormat("0.00").format(this.eFj / 100.0F);
      localHashMap.put("beauty_value", localObject);
      localHashMap.put("facial_value", str);
      if (TextUtils.isEmpty(this.cUJ)) {
        break label474;
      }
      localHashMap.put("filter_id", this.cUJ);
      label169:
      localObject = new StringBuilder().append("");
      if (paramLong != -1L) {
        break label487;
      }
      paramLong = l;
      label193:
      localHashMap.put("duration", paramLong);
      localHashMap.put("cameraId", axio.fi(aaqh.cix));
      localHashMap.put("face_index", String.valueOf(this.eFi));
      localHashMap.put("face_from", this.cUM);
      localHashMap.put("face_tab", this.cUN);
      localHashMap.put("face_type", this.cnW + "");
      if (this.cnW != 7) {
        break label496;
      }
      localHashMap.put("face_uin", this.cUL + UserAction.getQIMEI());
      label335:
      localHashMap.put("preview_view_size", awyu.a.Hr());
      localHashMap.put("configed_preview_resolution", awyu.a.Hs());
      localHashMap.put("configed_capture_resolution", awyu.a.Ht());
      localHashMap.put("render_resolution", awyu.a.Hw());
      if (ao.longValue() != 1L) {
        break label531;
      }
      localHashMap.put("resolution", awyu.a.Hu());
      label420:
      if (ao.longValue() != 1L) {
        break label582;
      }
      if (!awyu.a.dtF) {
        break label574;
      }
    }
    label531:
    label574:
    for (Object localObject = "screenshot";; localObject = "camera")
    {
      localHashMap.put("photo_capture_mode", localObject);
      return localHashMap;
      localHashMap.put("face_id", this.cUK);
      break;
      label474:
      localHashMap.put("filter_id", "none");
      break label169;
      label487:
      paramLong /= 1000L;
      break label193;
      label496:
      localHashMap.put("face_uin", this.cUK + UserAction.getQIMEI());
      break label335;
      if (ao.longValue() == 2L)
      {
        localHashMap.put("resolution", awyu.a.Hz());
        break label420;
      }
      localHashMap.put("resolution", "none");
      break label420;
    }
    label582:
    localHashMap.put("photo_capture_mode", "none");
    return localHashMap;
  }
  
  public HashMap<String, String> d(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", String.valueOf(0));
    localHashMap.put("content_type", String.valueOf(this.a.aCe));
    localHashMap.put("MD5", this.a.cUU);
    localHashMap.put("filter_id", this.a.rd.get(Integer.valueOf(paramInt)));
    localHashMap.put("filter_value", String.valueOf(this.a.re.get(Integer.valueOf(paramInt))));
    localHashMap.put("music_id", "");
    localHashMap.put("sound_type", "");
    localHashMap.put("video_id", this.a.cUU);
    localHashMap.put("text_count", String.valueOf(this.a.rf.get(Integer.valueOf(paramInt))));
    localHashMap.put("face_id", this.cUK);
    return localHashMap;
  }
  
  public HashMap<String, String> e(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", this.a.aCe + "");
    localHashMap.put("MD5", this.a.cUU);
    localHashMap.put("pic_count", paramInt + "");
    return localHashMap;
  }
  
  public void eI(int paramInt, String paramString)
  {
    this.rc.put("op_in", String.valueOf(paramInt));
    if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.rc.put("activity_id", paramString);
      return;
    }
    this.rc.put("activity_id", "none");
  }
  
  public void eLA()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.mUin);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date());
    localStringBuilder.append(" ");
    localStringBuilder.append(str);
    this.cUT = arwu.toMD5(localStringBuilder.toString());
  }
  
  public void eLB()
  {
    this.aCc = 1L;
    this.aCd = 1L;
  }
  
  public void eLr()
  {
    String str = axio.HO();
    this.rc.put("operation_time", str);
    axiy.i("AEBaseReportParam", "【operation_time】:" + str);
  }
  
  public void eLs()
  {
    int j = -1;
    int i;
    if (AppNetConnInfo.isWifiConn()) {
      i = 1;
    }
    for (;;)
    {
      this.rc.put("network_type", String.valueOf(i));
      UserAction.setLogAble(false, false);
      return;
      i = j;
      switch (AppNetConnInfo.getMobileInfo())
      {
      case 0: 
      default: 
        i = j;
        break;
      case 1: 
        i = 2;
        break;
      case 2: 
        i = 3;
        break;
      case 3: 
        i = 4;
        break;
      case 4: 
        i = 5;
      }
    }
  }
  
  public void eLt()
  {
    this.aBU = System.currentTimeMillis();
  }
  
  public void eLu()
  {
    this.cUP = null;
    this.cUQ = null;
  }
  
  public void eLv()
  {
    this.aBV = 0L;
    this.aBW = 0L;
    this.aBX = 0L;
    this.aBY = 0L;
    this.duW = false;
  }
  
  public void eLw()
  {
    if (this.aBW == 0L) {
      this.aBW = System.currentTimeMillis();
    }
  }
  
  public void eLx()
  {
    if (this.aBX == 0L) {
      this.aBX = System.currentTimeMillis();
    }
  }
  
  public void eLy()
  {
    if (this.aBY == 0L) {
      this.aBY = System.currentTimeMillis();
    }
  }
  
  public void eLz()
  {
    this.aCa = System.currentTimeMillis();
  }
  
  public HashMap<String, String> i(String paramString, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("face_id", paramString);
    localHashMap.put("cost_time", String.valueOf(paramLong));
    return localHashMap;
  }
  
  public void ob(long paramLong)
  {
    ao = Long.valueOf(paramLong);
  }
  
  public void oc(long paramLong)
  {
    eLv();
    this.aBV = paramLong;
    this.duW = this.duX;
    this.duX = false;
  }
  
  public void od(long paramLong)
  {
    this.aCb = paramLong;
  }
  
  public void setFilterId(String paramString)
  {
    this.cUJ = paramString;
  }
  
  public void setSex(int paramInt)
  {
    int i;
    if (paramInt <= 3)
    {
      i = paramInt;
      if (paramInt >= -1) {}
    }
    else
    {
      i = -1;
    }
    this.rc.put("sex", "" + i);
  }
  
  public void setTextColor(String paramString)
  {
    this.auH = paramString;
  }
  
  public void setUin(@Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (this.mUin = paramString;; this.mUin = "none")
    {
      this.rc.put("fromuin", this.mUin);
      return;
    }
  }
  
  public void setVideoDuration(long paramLong)
  {
    this.mVideoDuration = paramLong;
  }
  
  static class a
  {
    private static axip a = new axip(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axip
 * JD-Core Version:    0.7.0.1
 */