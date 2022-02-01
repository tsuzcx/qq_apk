import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Calendar;
import mqq.app.MobileQQ;
import mqq.app.WtloginPrivacyListenerImpl;
import mqq.manager.Manager;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONArray;

public class aizk
  implements Handler.Callback, Manager
{
  public static String TAG = "TimJumpLoginManager";
  public JSONArray M;
  public JSONArray N;
  private QQAppInterface app;
  public boolean cmW;
  public int dhg = 60;
  public int dhh = 72;
  public int dhi = 5;
  public int dhj = 24;
  private long lastShowTime = -1L;
  private Handler mHandler;
  private int showCount;
  
  public aizk(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.mHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private boolean aqb()
  {
    if (!this.cmW) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "switchKey false");
      }
    }
    label182:
    label482:
    for (;;)
    {
      return false;
      if (this.showCount > this.dhi)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(TAG, 2, "showCount = " + this.showCount + ", showTipTotalCount = " + this.dhi);
          return false;
        }
      }
      else if (System.currentTimeMillis() - this.lastShowTime < this.dhj * 60 * 60 * 1000)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(TAG, 2, "lastShowTime = " + this.lastShowTime + ", showTipHourInterval = " + this.dhj);
          return false;
        }
      }
      else
      {
        Object localObject = Calendar.getInstance();
        int j = ((Calendar)localObject).get(7);
        if (this.M != null)
        {
          i = 0;
          if (i < this.M.length()) {
            if (j - 1 != this.M.optInt(i)) {}
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label482;
          }
          i = ((Calendar)localObject).get(11);
          if ((this.N == null) || (this.N.length() != 2)) {
            break;
          }
          j = this.N.optInt(0);
          int k = this.N.optInt(1);
          if ((i < j) || (i >= k)) {
            break;
          }
          if (!ausc.bb(this.app.getApp(), "com.tencent.tim"))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(TAG, 2, "tim not installed");
            return false;
            i += 1;
            break label182;
          }
          localObject = new File(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/com/tencent/tim");
          if ((((File)localObject).exists()) && (System.currentTimeMillis() - ((File)localObject).lastModified() < this.dhh * 60 * 60 * 1000))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(TAG, 2, "timLogFile.lastModified() = " + ((File)localObject).lastModified() + ", androidLimit = " + this.dhh);
            return false;
          }
          if ((BaseActivity.sTopActivity instanceof SplashActivity))
          {
            localObject = (SplashActivity)BaseActivity.sTopActivity;
            if (SplashActivity.bKT != 1) {}
          }
          for (i = 1;; i = 0)
          {
            if (i == 0)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d(TAG, 2, "is not in main tab");
              return false;
            }
            return true;
          }
        }
      }
    }
  }
  
  private void dvH()
  {
    if (!this.app.isLogin()) {}
    Object localObject1;
    label123:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "showTimLoginDialog");
      }
      localObject1 = this.app.getApp().getSharedPreferences("tim_login_shared_pre_" + this.app.getCurrentUin(), 0);
      try
      {
        localObject2 = ((SharedPreferences)localObject1).getString("tim_login_sd", "");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.M = new JSONArray((String)localObject2);
        }
        localObject2 = ((SharedPreferences)localObject1).getString("tim_login_st", "");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.N = new JSONArray((String)localObject2);
        }
      }
      catch (Exception localException2)
      {
        Object localObject2;
        int i;
        String str4;
        String str2;
        String str5;
        String str6;
        Object localObject3;
        String str3;
        JSONArray localJSONArray;
        String str1;
        break label123;
      }
      this.dhh = ((SharedPreferences)localObject1).getInt("tim_login_l", 72);
      this.dhi = ((SharedPreferences)localObject1).getInt("tim_login_tc", 5);
      this.dhj = ((SharedPreferences)localObject1).getInt("tim_login_sti", 24);
      this.lastShowTime = ((SharedPreferences)localObject1).getLong("tim_login_lct", 0L);
      this.showCount = ((SharedPreferences)localObject1).getInt("tim_login_sc", 0);
    } while (!aqb());
    localObject2 = ((SharedPreferences)localObject1).edit();
    i = this.showCount + 1;
    this.showCount = i;
    ((SharedPreferences.Editor)localObject2).putInt("tim_login_sc", i);
    ((SharedPreferences.Editor)localObject2).putLong("tim_login_lct", System.currentTimeMillis());
    ((SharedPreferences.Editor)localObject2).commit();
    localObject2 = acfp.m(2131715356);
    str4 = "登录TIM";
    str2 = acfp.m(2131715355);
    str5 = ((SharedPreferences)localObject1).getString("tim_login_t", "QQ办公简洁版");
    str6 = ((SharedPreferences)localObject1).getString("tim_login_c", (String)localObject2);
    localObject2 = str2;
    try
    {
      localObject1 = ((SharedPreferences)localObject1).getString("tim_login_btns", "");
      localObject3 = str2;
      str3 = str4;
      localObject2 = str2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = str2;
        localJSONArray = new JSONArray((String)localObject1);
        localObject3 = str2;
        str3 = str4;
        if (localJSONArray != null)
        {
          localObject3 = str2;
          str3 = str4;
          localObject2 = str2;
          if (localJSONArray.length() == 2)
          {
            localObject1 = str2;
            localObject2 = str2;
            if (!TextUtils.isEmpty(localJSONArray.optString(0)))
            {
              localObject2 = str2;
              localObject1 = localJSONArray.optString(0);
            }
            localObject3 = localObject1;
            str3 = str4;
            localObject2 = localObject1;
            if (!TextUtils.isEmpty(localJSONArray.optString(1)))
            {
              localObject2 = localObject1;
              str3 = localJSONArray.optString(1);
              localObject3 = localObject1;
            }
          }
        }
      }
      localObject1 = str3;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        str1 = "登录TIM";
        localObject3 = localObject2;
      }
    }
    aqha.a(BaseActivity.sTopActivity, 230, str5, str6, (String)localObject3, (String)localObject1, new aizl(this), new aizm(this)).show();
    anot.a(this.app, "dc00898", "", "", "0X80085D9", "0X80085D9", 0, 0, "", "", "", "");
  }
  
  public void cY(Bundle paramBundle)
  {
    if (!aqiz.s(this.app.getApp(), "com.tencent.tim", "775E696D09856872FDD8AB4F3F06B1E0"))
    {
      QQToast.a(this.app.getApp(), 1, 2131721072, 0).show();
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "jumpTimLogin tim not install ");
      }
      return;
    }
    String str = aqiz.O(this.app.getApp(), "com.tencent.tim");
    int i = aetq.a().Cu();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "jumpTimLogin tim timVersion=" + str + "tim limit version = " + i);
    }
    int j;
    do
    {
      arhz localarhz;
      try
      {
        j = Integer.parseInt(str.replace(".", ""));
        if (j != 0) {
          continue;
        }
        QQToast.a(this.app.getApp(), 1, 2131721072, 0).show();
        return;
      }
      catch (Exception localException)
      {
        localarhz = new arhz(BaseActivity.sTopActivity, this.app.getApplication().getResources().getDimensionPixelOffset(2131299627));
        localarhz.setMessage(acfp.m(2131715354));
        localarhz.show();
        WtloginHelper localWtloginHelper = new WtloginHelper(this.app.getApplication().getApplicationContext(), WtloginPrivacyListenerImpl.getSingleton());
        localWtloginHelper.SetTimeOut(20);
        localWtloginHelper.SetMsfTransportFlag(1);
        localWtloginHelper.SetListener(new aizn(this, localarhz, localWtloginHelper, paramBundle));
        paramBundle = util.getPkgSigFromApkName(this.app.getApp(), "com.tencent.tim");
        i = localWtloginHelper.GetA1WithA1(this.app.getAccount(), 16L, 16L, "com.tencent.tim".getBytes(), 1L, 16L, 16L, "3.4.4".getBytes(), paramBundle, new WUserSigInfo(), new WFastLoginInfo());
      }
      if (i == -1001) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "jumpTimLogin GetA1WithA1, retCode = " + i);
      }
      if ((localarhz != null) && (localarhz.isShowing())) {
        localarhz.dismiss();
      }
      QQToast.a(this.app.getApp(), 1, 2131721071, 0).show();
      return;
    } while (j >= i);
    QQToast.a(this.app.getApp(), 1, 2131721073, 0).show();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      dvH();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aizk
 * JD-Core Version:    0.7.0.1
 */