import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule.1;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ObserverMethod.3;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ObserverMethod.6;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Locale;

public class admn
  extends adnq.b
{
  private admn.a jdField_a_of_type_Admn$a = new admn.a(null);
  private admn.c jdField_a_of_type_Admn$c = new admn.c(null);
  private admn.d jdField_a_of_type_Admn$d = new admn.d(null);
  private admn.e jdField_a_of_type_Admn$e = new admn.e(null);
  public adno a;
  private HashMap<String, admn.b> jy = new ArkAppDeviceModule.1(this);
  private BroadcastReceiver scanResultReceiver;
  
  public admn(ark.Application paramApplication, long paramLong)
  {
    super(paramApplication, paramLong);
    this.jdField_a_of_type_Adno = new adno(this.mAppName);
  }
  
  private void a(long paramLong, boolean paramBoolean, double paramDouble1, double paramDouble2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppDeviceModule", 2, "doPositionCallback cbId=" + paramLong + ", success=" + paramBoolean + ", lat=" + paramDouble1 + ", lng=" + paramDouble2);
    }
    ark.VariantWrapper localVariantWrapper1 = b(paramLong);
    if (localVariantWrapper1 == null) {
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    if (paramBoolean) {
      localVariantWrapper2.SetTableAsJsonString(String.format(Locale.CHINA, "{\"latitude\":%.6f,\"longitude\":%.6f}", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) }));
    }
    for (;;)
    {
      ark.VariantWrapper localVariantWrapper3 = localVariantWrapper1.Create();
      localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, localVariantWrapper3);
      localVariantWrapper3.Reset();
      localVariantWrapper2.Reset();
      return;
      localVariantWrapper2.SetNull();
    }
  }
  
  private void a(long paramLong, boolean paramBoolean, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppDeviceModule", 2, "doSensorCallback cbId=" + paramLong + ", success=" + paramBoolean + ", sensorEventType=" + paramString + ", argA=" + paramFloat1 + ", argB=" + paramFloat2 + ", argC=" + paramFloat3);
    }
    ark.VariantWrapper localVariantWrapper1 = b(paramLong);
    if (localVariantWrapper1 == null) {
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    String str = null;
    if ("Motion".equals(paramString))
    {
      str = "{\"x\":%.6f,\"y\":%.6f,\"z\":%.6f}";
      if ((!paramBoolean) || (TextUtils.isEmpty(str))) {
        break label220;
      }
      localVariantWrapper2.SetTableAsJsonString(String.format(Locale.CHINA, str, new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) }));
    }
    for (;;)
    {
      paramString = localVariantWrapper1.Create();
      localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, paramString);
      paramString.Reset();
      localVariantWrapper2.Reset();
      return;
      if (!"Orientation".equals(paramString)) {
        break;
      }
      str = "{\"alpha\":%.6f,\"beta\":%.6f,\"gamma\":%.6f}";
      break;
      label220:
      localVariantWrapper2.SetNull();
    }
  }
  
  private void c(long paramLong, boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppDeviceModule", 2, "doConnectionCallback cbId=" + paramLong + ", success=" + paramBoolean + ", netType=" + paramString);
    }
    ark.VariantWrapper localVariantWrapper1 = b(paramLong);
    if (localVariantWrapper1 == null) {
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    if (paramBoolean) {
      localVariantWrapper2.SetString(paramString);
    }
    for (;;)
    {
      paramString = localVariantWrapper1.Create();
      localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, paramString);
      paramString.Reset();
      localVariantWrapper2.Reset();
      return;
      localVariantWrapper2.SetNull();
    }
  }
  
  private void p(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppDeviceModule", 2, "doScanCodeCallback cbId=" + paramLong + ", scanResult=" + paramString1 + ", scanType=" + paramString2);
    }
    ark.VariantWrapper localVariantWrapper1 = a(paramLong);
    if (localVariantWrapper1 == null) {
      return;
    }
    int i;
    ark.VariantWrapper localVariantWrapper2;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      i = 1;
      localVariantWrapper2 = localVariantWrapper1.Create();
      if (i == 0) {
        break label186;
      }
      if (!"QR_CODE".equalsIgnoreCase(paramString2)) {
        break label179;
      }
      paramString2 = "QRCode";
      label104:
      localVariantWrapper2.SetTableAsJsonString(String.format(Locale.CHINA, "{\"result\":\"%s\",\"type\":\"%s\",\"charset\":\"%s\"}", new Object[] { paramString1, paramString2, "utf-8" }));
    }
    for (;;)
    {
      paramString1 = localVariantWrapper1.Create();
      localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, paramString1);
      paramString1.Reset();
      localVariantWrapper2.Reset();
      localVariantWrapper1.Reset();
      return;
      i = 0;
      break;
      label179:
      paramString2 = "BarCode";
      break label104;
      label186:
      localVariantWrapper2.SetNull();
    }
  }
  
  public void Destruct()
  {
    if (this.jdField_a_of_type_Adno != null) {
      this.jdField_a_of_type_Adno.Destruct();
    }
    if (this.scanResultReceiver != null) {}
    try
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.scanResultReceiver);
      label31:
      this.scanResultReceiver = null;
      super.Destruct();
      return;
    }
    catch (Exception localException)
    {
      break label31;
    }
  }
  
  public String GetTypeName()
  {
    return "Device";
  }
  
  public boolean HasMenthod(String paramString)
  {
    return (this.jy != null) && (this.jy.containsKey(paramString)) && (this.jy.get(paramString) != null);
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppDeviceModule", 2, "invokeFunc=" + paramString);
    }
    if (!la(paramString)) {
      return false;
    }
    if (this.jy != null)
    {
      admn.b localb = (admn.b)this.jy.get(paramString);
      if (localb != null) {
        return localb.a(paramString, paramArrayOfVariantWrapper, paramVariantWrapper);
      }
    }
    return false;
  }
  
  public class a
    implements admn.b
  {
    private a() {}
    
    public boolean a(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
    {
      if (!adnq.a(admn.this.mAppName, admn.this.Vj, admn.this.mApplication, "permission.CONNECTION_TYPE")) {
        return false;
      }
      if (!AppNetConnInfo.isNetSupport()) {
        paramVariantWrapper.SetString("none");
      }
      for (;;)
      {
        return true;
        if (AppNetConnInfo.isWifiConn())
        {
          paramVariantWrapper.SetString("wifi");
        }
        else if (AppNetConnInfo.isMobileConn())
        {
          int i = AppNetConnInfo.getMobileInfo();
          if (i == 0) {
            paramVariantWrapper.SetString("none");
          } else if (-1 == i) {
            paramVariantWrapper.SetString("other");
          } else {
            paramVariantWrapper.SetString("cellular");
          }
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean a(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper);
  }
  
  public class c
    implements admn.b
  {
    private c() {}
    
    public boolean a(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
    {
      long l;
      String str;
      if ("AttachEvent".equals(paramString))
      {
        if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 2) || (!paramArrayOfVariantWrapper[0].IsString()) || (!paramArrayOfVariantWrapper[1].IsFunction())) {
          return false;
        }
        paramVariantWrapper = paramArrayOfVariantWrapper[0].GetString();
        l = admn.this.a(paramArrayOfVariantWrapper[1].Copy());
        paramString = null;
        if ("Motion".equals(paramVariantWrapper))
        {
          if (!adnq.a(admn.this.mAppName, admn.this.Vj, admn.this.mApplication, "permission.SENSORS")) {
            return false;
          }
          paramString = new admo(this, l);
        }
        while ((paramString != null) && (!"Position".equals(paramVariantWrapper)))
        {
          admn.this.a.a(paramString, l);
          return true;
          if ("Orientation".equals(paramVariantWrapper))
          {
            if (!adnq.a(admn.this.mAppName, admn.this.Vj, admn.this.mApplication, "permission.SENSORS")) {
              return false;
            }
            paramString = new admp(this, l);
          }
          else
          {
            if ("Position".equals(paramVariantWrapper))
            {
              if (!adnq.a(admn.this.mAppName, admn.this.Vj, admn.this.mApplication, "permission.POSITION")) {
                return false;
              }
              if (QLog.isColorLevel()) {
                QLog.i("ArkAppDeviceModule", 2, String.format("Position.app.%s", new Object[] { admn.this.mAppName }));
              }
              paramString = null;
              paramArrayOfVariantWrapper = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
              if (paramArrayOfVariantWrapper != null) {
                paramString = paramArrayOfVariantWrapper.getCurrentAccountUin();
              }
              if ((paramArrayOfVariantWrapper == null) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(admn.this.mAppName))) {
                return false;
              }
              paramVariantWrapper = ArkAppCacheMgr.getApplicationDesc(admn.this.mAppName);
              paramArrayOfVariantWrapper = paramVariantWrapper;
              if (TextUtils.isEmpty(paramVariantWrapper)) {
                paramArrayOfVariantWrapper = admn.this.mAppName;
              }
              paramVariantWrapper = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0);
              str = "key_ark_authority_show_dialog" + "_" + paramArrayOfVariantWrapper + "_" + "ark_authority_api_location" + "_" + paramString;
              if ((!paramVariantWrapper.getBoolean(str, false)) && (adnq.b.bPX))
              {
                ArkAppCenter.a().postToMainThread(new ArkAppDeviceModule.ObserverMethod.3(this, paramArrayOfVariantWrapper, l, paramString));
                paramVariantWrapper.edit().putBoolean(str, true).commit();
                adnq.c.fq(paramArrayOfVariantWrapper, paramString);
              }
              for (;;)
              {
                return true;
                if (1 == adnq.c.i(paramArrayOfVariantWrapper, "ark_authority_api_location", paramString))
                {
                  paramString = new admu(this, l);
                  admn.this.a.a(paramString, l);
                }
                else
                {
                  admn.a(admn.this, l, false, 0.0D, 0.0D);
                  paramString = admn.this.a(l);
                  if (paramString != null) {
                    paramString.Reset();
                  }
                }
              }
            }
            if ("ConnectionTypeChange".equals(paramVariantWrapper))
            {
              if (!adnq.a(admn.this.mAppName, admn.this.Vj, admn.this.mApplication, "permission.CONNECTION_TYPE")) {
                return false;
              }
              paramString = new admv(this, l);
            }
          }
        }
        return false;
      }
      if ("DetachEvent".equals(paramString))
      {
        if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (!paramArrayOfVariantWrapper[0].IsString()) || (TextUtils.isEmpty(paramArrayOfVariantWrapper[0].GetString()))) {
          return false;
        }
        admn.this.a.GC(paramArrayOfVariantWrapper[0].GetString());
        return true;
      }
      if ("GetCurrentPosition".equals(paramString))
      {
        if (!adnq.a(admn.this.mAppName, admn.this.Vj, admn.this.mApplication, "permission.POSITION")) {
          return false;
        }
        if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (!paramArrayOfVariantWrapper[0].IsFunction())) {
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ArkAppDeviceModule", 2, String.format("GetCurrentPosition.app.%s", new Object[] { admn.this.mAppName }));
        }
        l = admn.this.a(paramArrayOfVariantWrapper[0].Copy());
        paramString = null;
        paramArrayOfVariantWrapper = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if (paramArrayOfVariantWrapper != null) {
          paramString = paramArrayOfVariantWrapper.getCurrentAccountUin();
        }
        if ((paramArrayOfVariantWrapper == null) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(admn.this.mAppName))) {
          return false;
        }
        paramVariantWrapper = ArkAppCacheMgr.getApplicationDesc(admn.this.mAppName);
        paramArrayOfVariantWrapper = paramVariantWrapper;
        if (TextUtils.isEmpty(paramVariantWrapper)) {
          paramArrayOfVariantWrapper = admn.this.mAppName;
        }
        paramVariantWrapper = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0);
        str = "key_ark_authority_show_dialog" + "_" + paramArrayOfVariantWrapper + "_" + "ark_authority_api_location" + "_" + paramString;
        if ((!paramVariantWrapper.getBoolean(str, false)) && (adnq.b.bPX))
        {
          ArkAppCenter.a().postToMainThread(new ArkAppDeviceModule.ObserverMethod.6(this, paramArrayOfVariantWrapper, l, paramString));
          paramVariantWrapper.edit().putBoolean(str, true).commit();
          adnq.c.fq(paramArrayOfVariantWrapper, paramString);
        }
        for (;;)
        {
          return true;
          if (1 == adnq.c.i(paramArrayOfVariantWrapper, "ark_authority_api_location", paramString))
          {
            paramString = new adna(this, l);
            admn.this.a.a(paramString, l);
          }
          else
          {
            admn.a(admn.this, l, false, 0.0D, 0.0D);
            paramString = admn.this.a(l);
            if (paramString != null) {
              paramString.Reset();
            }
          }
        }
      }
      return false;
    }
  }
  
  public class d
    implements admn.b
  {
    private d() {}
    
    public boolean a(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
    {
      if ((!"ScanCode".equals(paramString)) || (paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (!paramArrayOfVariantWrapper[0].IsFunction())) {}
      for (;;)
      {
        return false;
        long l = admn.this.a(paramArrayOfVariantWrapper[0].Copy());
        paramString = new Intent();
        paramString.setClassName("com.tencent.tim", "com.tencent.biz.qrcode.activity.ScannerActivity");
        paramString.putExtra("from", admn.class.getName());
        paramString.putExtra("finishAfterSucc", true);
        if (admn.a(admn.this) != null) {}
        try
        {
          BaseApplicationImpl.getApplication().unregisterReceiver(admn.a(admn.this));
          label105:
          admn.a(admn.this, null);
          admn.a(admn.this, new adnb(this, l));
          paramArrayOfVariantWrapper = new IntentFilter("com.tencent.mobileqq.ark.API.scanResultAction");
          BaseApplicationImpl.getApplication().registerReceiver(admn.a(admn.this), paramArrayOfVariantWrapper, "com.tencent.tim.msg.permission.pushnotify", null);
          paramArrayOfVariantWrapper = BaseActivity.sTopActivity;
          if (paramArrayOfVariantWrapper == null) {
            continue;
          }
          paramArrayOfVariantWrapper.startActivity(paramString);
          return false;
        }
        catch (Exception paramArrayOfVariantWrapper)
        {
          break label105;
        }
      }
    }
  }
  
  public class e
    implements admn.b
  {
    private e() {}
    
    public boolean a(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
    {
      if (!adnq.a(admn.this.mAppName, admn.this.Vj, admn.this.mApplication, "permission.DEVICE_INFORMATION")) {}
      do
      {
        return false;
        if ("GetModelName".equals(paramString))
        {
          paramVariantWrapper.SetString(Build.MODEL);
          return true;
        }
        if ("GetScreenWidth".equals(paramString))
        {
          paramString = adqr.m;
          paramVariantWrapper.SetInt((int)(paramString.widthPixels / paramString.density));
          return true;
        }
        if ("GetScreenHeight".equals(paramString))
        {
          paramString = adqr.m;
          paramVariantWrapper.SetInt((int)(paramString.heightPixels / paramString.density));
          return true;
        }
        if ("GetPixelRatio".equals(paramString))
        {
          paramVariantWrapper.SetDouble(adqr.getDensity());
          return true;
        }
      } while (!"GetIdentifier".equals(paramString));
      paramArrayOfVariantWrapper = aqgz.getIMEI();
      paramString = paramArrayOfVariantWrapper;
      if (TextUtils.isEmpty(paramArrayOfVariantWrapper)) {}
      try
      {
        paramString = auri.getIMEI("6973c4");
        paramArrayOfVariantWrapper = paramString;
        if (paramString == null)
        {
          paramArrayOfVariantWrapper = "";
          QLog.e("ArkAppDeviceModule", 1, "get identifer: null, fix it with empty string");
        }
        paramString = paramArrayOfVariantWrapper;
        if (admn.this.Vj != 0L) {
          paramString = MD5Coding.encodeHexStr(paramArrayOfVariantWrapper);
        }
        paramVariantWrapper.SetString(paramString);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          QLog.e("ArkAppDeviceModule", 1, "get identifer: exception, catch it");
          paramString = paramArrayOfVariantWrapper;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     admn
 * JD-Core Version:    0.7.0.1
 */