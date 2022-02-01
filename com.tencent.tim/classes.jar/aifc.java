import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.now.NowDataReporter.1;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;

public class aifc
{
  public static long abu;
  protected boolean ckk;
  protected boolean ckl;
  protected String d1 = "";
  protected String d2 = "";
  protected String d3 = "";
  protected String d4 = "";
  protected int ddi;
  protected int ddj;
  HashMap<Long, JSONObject> lk = new HashMap();
  protected int mFrameVersion;
  protected String mLastOpName;
  protected String mMacVersion = Build.MODEL;
  protected int mOpIn;
  protected String mOpName = "";
  protected int mOpResult;
  protected String mOpType = "";
  protected int mPlatform = 2;
  String mRoomType;
  String mRoomid;
  String mSdkversion;
  String mSource;
  protected String mSysVersion = Build.VERSION.RELEASE;
  protected String mTimeLong;
  protected String mToUin = "";
  protected String networktype = "";
  
  public aifc(QQAppInterface paramQQAppInterface)
  {
    a("now_plugin");
  }
  
  private void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean2)
  {
    if (paramLong == 0L) {
      return;
    }
    JSONObject localJSONObject;
    if (!this.lk.containsKey(Long.valueOf(paramLong)))
    {
      localJSONObject = new JSONObject();
      this.lk.put(Long.valueOf(paramLong), localJSONObject);
    }
    for (;;)
    {
      try
      {
        if (localJSONObject.optBoolean("noneedadd")) {
          break label223;
        }
        localJSONObject.put("opname", paramString4);
        localJSONObject.put("roomid", paramString2);
        localJSONObject.put("roomtype", paramString3);
        localJSONObject.put("source", paramString1);
        localJSONObject.put("d1", paramString5);
        localJSONObject.put("d2", paramString6);
        localJSONObject.put("d3", paramString7);
        localJSONObject.put("d4", paramString8);
        localJSONObject.put("op_in", paramInt1);
        localJSONObject.put("op_result", paramInt2);
        localJSONObject.put("noneedadd", paramBoolean1);
        localJSONObject.put("timelong", paramString9);
        this.lk.put(Long.valueOf(paramLong), localJSONObject);
        if (!paramBoolean2) {
          break;
        }
        kb(paramLong);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      localJSONObject = (JSONObject)this.lk.get(Long.valueOf(paramLong));
      continue;
      label223:
      QLog.i("NowDataReporter", 1, "本次opname不影响上报");
    }
  }
  
  private void reset()
  {
    abu = 0L;
    this.mOpName = "";
    this.mToUin = "";
    this.d1 = "";
    this.d2 = "";
    this.d3 = "";
    this.d4 = "";
    this.mFrameVersion = 11;
    this.mOpResult = 0;
    this.mTimeLong = "";
    this.mOpIn = 0;
  }
  
  public void J(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      h(paramString1).f(paramString2).b("jump_h5").c(paramString3).d(paramString4).report();
      a(abu, paramString1, paramString2, this.mRoomType, "jump_h5", true, this.mOpIn, this.mOpResult, this.d1, this.d2, this.d3, this.d4, "", true);
      return;
    }
    catch (Exception paramString3)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NowDataReporter", 2, "reportJumpH5 Exception");
        }
      }
    }
  }
  
  public aifc a(String paramString)
  {
    this.mOpType = paramString;
    return this;
  }
  
  public void a(boolean paramBoolean1, String paramString1, String paramString2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    reset();
    long l = System.currentTimeMillis();
    abu = l;
    this.ckl = paramBoolean4;
    if (this.ckl) {
      this.mFrameVersion = 11;
    }
    this.ckk = paramBoolean1;
    try
    {
      localaifc = h(paramString1).f(paramString2).g(paramString3).b("nowentry");
      if (!paramBoolean1) {
        break label173;
      }
      str1 = "1";
      localaifc = localaifc.c(str1);
      if (!paramBoolean2) {
        break label206;
      }
      str1 = "1";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        aifc localaifc;
        String str1;
        if (QLog.isColorLevel())
        {
          QLog.d("NowDataReporter", 2, "reportNowEntry Exception");
          continue;
          String str2 = "0";
        }
      }
    }
    localaifc = localaifc.d(str1);
    if (paramBoolean3) {}
    for (str1 = "1";; str1 = "0")
    {
      localaifc.e(str1).report();
      a(abu, paramString1, paramString2, paramString3, "now_entry", false, 0, 0, this.d1, this.d2, this.d3, this.d4, "", false);
      new Handler().postDelayed(new NowDataReporter.1(this, l), 90000L);
      return;
      label173:
      str1 = "0";
      break;
    }
  }
  
  public aifc b(String paramString)
  {
    this.mOpName = paramString;
    return this;
  }
  
  public aifc c(String paramString)
  {
    this.d1 = paramString;
    return this;
  }
  
  public void cK(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    for (;;)
    {
      try
      {
        this.mOpName = paramBundle.getString("op_name");
        if (TextUtils.isEmpty(this.mOpName)) {
          break;
        }
        bool2 = false;
        int j = 1;
        bool4 = false;
        this.mOpIn = paramBundle.getInt("op_in");
        this.mOpResult = paramBundle.getInt("op_result");
        this.mTimeLong = paramBundle.getString("timeconsume");
        String str = paramBundle.getString("sdkversion");
        if ((!TextUtils.isEmpty(str)) && (!str.equals("0"))) {
          this.mSdkversion = paramBundle.getString("sdkversion");
        }
        this.d1 = paramBundle.getString("d1");
        this.d2 = paramBundle.getString("d2");
        this.d3 = paramBundle.getString("d3");
        this.d4 = paramBundle.getString("d4");
        if (this.mOpName.equals("enter_shadow"))
        {
          this.ddi = Integer.parseInt(paramBundle.getString("status1", "0"));
          this.mFrameVersion = paramBundle.getInt("frameVersion");
        }
        report();
        if ((this.mOpName.equals("check_version_complete")) && (this.d3.equals("1")))
        {
          this.ckk = false;
          this.ddi = 0;
        }
        if (!this.lk.containsKey(Long.valueOf(abu))) {
          break;
        }
        if ((this.mOpName.equals("cancel_run")) || (this.mOpName.equals("cancel_in_plugin")) || (this.mOpName.equals("download_fail")) || (this.mOpName.equals("boot_fail")) || (this.mOpName.equals("login_fail")) || (this.mOpName.equals("enter_fail")) || (this.mOpName.equals("user_cancel_in_plugin")) || (this.mOpName.equals("enter_room")) || (this.mOpName.equals("jump_h5")) || (this.mOpName.equals("jump_app"))) {
          break label719;
        }
        boolean bool3 = bool2;
        boolean bool1 = bool4;
        if (this.mOpName.equals("download_biz_plugin"))
        {
          bool3 = bool2;
          bool1 = bool4;
          if (this.d1.equals("fail"))
          {
            bool3 = true;
            bool1 = true;
          }
        }
        bool4 = bool3;
        bool2 = bool1;
        if (this.mOpName.equals("unzip_biz_plugin"))
        {
          bool4 = bool3;
          bool2 = bool1;
          if (this.d1.equals("fail"))
          {
            bool4 = true;
            bool2 = true;
          }
        }
        int i = j;
        if (this.mOpName.equals("download_start"))
        {
          i = j;
          if (this.d1.equals("2")) {
            i = 0;
          }
        }
        j = i;
        if (this.mOpName.equals("download_complete"))
        {
          j = i;
          if (this.d1.equals("2")) {
            j = 0;
          }
        }
        i = j;
        if (this.mOpName.equals("download_fail"))
        {
          i = j;
          if (this.d1.equals("2")) {
            i = 0;
          }
        }
        j = i;
        if (this.mOpName.equals("install_start"))
        {
          j = i;
          if (this.mOpIn != 1) {
            j = 0;
          }
        }
        i = j;
        if (this.mOpName.equals("install_complete"))
        {
          i = j;
          if (this.mOpIn != 1) {
            i = 0;
          }
        }
        j = i;
        if (this.mOpName.equals("install_fail"))
        {
          j = i;
          if (this.mOpIn != 1) {
            j = 0;
          }
        }
        if (j == 0) {
          break;
        }
        a(abu, this.mSource, this.mRoomid, this.mRoomType, this.mOpName, bool4, this.mOpIn, this.mOpResult, this.d1, this.d2, this.d3, this.d4, this.mTimeLong, bool2);
        return;
      }
      catch (Exception paramBundle) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NowDataReporter", 2, "onReportFromXProxy Exception");
      return;
      label719:
      boolean bool2 = true;
      boolean bool4 = true;
    }
  }
  
  public aifc d(String paramString)
  {
    this.d2 = paramString;
    return this;
  }
  
  public void d(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    try
    {
      b("get_record_res").c(String.valueOf(paramInt1)).d(paramString).e(String.valueOf(paramInt2)).i(String.valueOf(paramLong)).report();
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("NowDataReporter", 2, "reportRecordCgi Exception");
    }
  }
  
  public void dsk()
  {
    for (;;)
    {
      try
      {
        aifc localaifc = b("show_loading");
        if (!this.ckk) {
          continue;
        }
        str = "1";
        localaifc.c(str).report();
      }
      catch (Exception localException)
      {
        String str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NowDataReporter", 2, "reportJumpPlugin Exception");
        continue;
      }
      a(abu, this.mSource, this.mRoomid, this.mRoomType, "show_loading", false, this.mOpIn, this.mOpResult, this.d1, this.d2, this.d3, this.d4, "", false);
      return;
      str = "0";
    }
  }
  
  public aifc e(String paramString)
  {
    this.d3 = paramString;
    return this;
  }
  
  public aifc f(String paramString)
  {
    this.mRoomid = paramString;
    return this;
  }
  
  public aifc g(String paramString)
  {
    this.mRoomType = paramString;
    return this;
  }
  
  public aifc h(String paramString)
  {
    this.mSource = paramString;
    return this;
  }
  
  public aifc i(String paramString)
  {
    this.mTimeLong = paramString;
    return this;
  }
  
  public void kb(long paramLong)
  {
    JSONObject localJSONObject = (JSONObject)this.lk.get(Long.valueOf(paramLong));
    if ((localJSONObject != null) && (localJSONObject.has("opname")))
    {
      m("last_op_name", localJSONObject);
      this.lk.remove(Long.valueOf(paramLong));
    }
  }
  
  public void m(String paramString, JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("opname");
    int i = paramJSONObject.optInt("op_in");
    int j = paramJSONObject.optInt("op_result");
    String str2 = paramJSONObject.optString("d1");
    String str3 = paramJSONObject.optString("d2");
    String str4 = paramJSONObject.optString("d3");
    String str5 = paramJSONObject.optString("d4");
    String str6 = paramJSONObject.optString("source");
    String str7 = paramJSONObject.optString("roomid");
    paramJSONObject = paramJSONObject.optString("roomtype");
    String str8 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
    String str9 = String.valueOf(aewh.getVersionCode(BaseApplicationImpl.getContext()));
    this.networktype = (jqc.getNetWorkType() + "");
    QLog.i("NowDataReporter", 2, "nowDatareportlastop: source = " + str6 + " roomid = " + str7 + " roomType = " + paramJSONObject + " op_name = " + paramString + " op_in = " + i + " d1= " + str2 + " d2=" + str3 + " d3=" + str4 + " d4=" + str5 + " timelong=" + this.mTimeLong + " op_result = " + j + " qq_version = " + str9 + "  optime = " + str8 + " lastOpName = " + str1 + " pluginstatus =" + this.ddi + " preloadStatus =" + this.ddj + " sdkversion = " + this.mSdkversion + " useShadow =" + this.ckl);
    anot.b(null, "dc02882", "grp_lbs", this.mToUin, this.mOpType, paramString, i, 1, j, str2, str3, str4, str5 + "|" + this.mTimeLong + "|" + str7 + "|" + paramJSONObject + "|" + str6 + "|" + this.networktype + "|" + this.mPlatform + "|" + this.mMacVersion + "|" + this.mSysVersion + "|" + this.mFrameVersion + "|" + this.mSdkversion + "|" + str9 + "|" + str8 + "|" + str1 + "|" + this.ddi + "|" + this.ddj + "|" + this.ckl);
  }
  
  public void report()
  {
    String str1 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
    String str2 = String.valueOf(aewh.getVersionCode(BaseApplicationImpl.getContext()));
    this.networktype = (jqc.getNetWorkType() + "");
    QLog.i("NowDataReporter", 1, "nowDatareport: source = " + this.mSource + " roomid = " + this.mRoomid + " roomType = " + this.mRoomType + " op_name = " + this.mOpName + " op_in = " + this.mOpIn + " d1= " + this.d1 + " d2=" + this.d2 + " d3=" + this.d3 + " d4=" + this.d4 + " timelong=" + this.mTimeLong + " op_result = " + this.mOpResult + " qq_version = " + str2 + "  optime = " + str1 + " lastOpName = " + this.mLastOpName + " pluginstatus =" + this.ddi + " preloadStatus =" + this.ddj + " sdkversion = " + this.mSdkversion + "useShadow =" + this.ckl);
    anot.b(null, "dc02882", "grp_lbs", this.mToUin, this.mOpType, this.mOpName, this.mOpIn, 1, this.mOpResult, this.d1, this.d2, this.d3, this.d4 + "|" + this.mTimeLong + "|" + this.mRoomid + "|" + this.mRoomType + "|" + this.mSource + "|" + this.networktype + "|" + this.mPlatform + "|" + this.mMacVersion + "|" + this.mSysVersion + "|" + this.mFrameVersion + "|" + this.mSdkversion + "|" + str2 + "|" + str1 + "|" + this.mLastOpName + "|" + this.ddi + "|" + this.ddj + "|" + this.ckl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aifc
 * JD-Core Version:    0.7.0.1
 */