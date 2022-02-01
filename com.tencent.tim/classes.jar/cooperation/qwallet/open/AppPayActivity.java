package cooperation.qwallet.open;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import aqgo;
import aqgz;
import avov;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class AppPayActivity
  extends BaseActivity
{
  private boolean dnJ;
  
  private void WH(boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject3 = super.getIntent();
    if (localObject3 == null) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " AppPayActivity.doPay intent == null");
      }
    }
    String str;
    do
    {
      Object localObject1;
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " AppPayActivity.doPay");
        }
        if ((!paramBoolean) || (this.app.isLogin())) {
          break;
        }
        localObject1 = new Intent(this, LoginActivity.class);
        ((Intent)localObject1).putExtra("isActionSend", true);
        ((Intent)localObject1).putExtras((Intent)localObject3);
        super.startActivityForResult((Intent)localObject1, 21);
      } while (!QLog.isColorLevel());
      QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " AppPayActivity.doPay login");
      return;
      try
      {
        localObject1 = ((Intent)localObject3).getDataString();
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).length() <= 9))
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.qwallet.pay", 2, "AppPayActivity.doPay url error:" + (String)localObject1);
          }
          super.finish();
          return;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
          str = null;
        }
        if ("mqqwallet://open_pay/".compareTo(str) == 0)
        {
          em((Intent)localObject3);
          return;
        }
        if ("mqqwallet://pubacc_pay/".compareTo(str) == 0)
        {
          super.finish();
          return;
        }
        int i = str.indexOf("mqqwallet://");
        if (i != -1)
        {
          localObject3 = str.substring(i + "mqqwallet://".length());
          try
          {
            localObject3 = new String(aqgo.decode((String)localObject3, 0));
            localObject2 = localObject3;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localException2.printStackTrace();
            }
          }
          if (localObject2 != null)
          {
            aaa(localObject2);
            return;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.qwallet.pay", 2, "AppPayActivity.doPay url not THIRD_APP:" + str);
  }
  
  private void aaa(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    long l = VACDReportUtil.a(null, "qqwallet", "pay-app", "payinvoke", null, 0, null);
    Object localObject = new avov();
    ((avov)localObject).fromJson(paramString);
    boolean bool = ((avov)localObject).checkParams();
    paramString = ((avov)localObject).toString();
    paramString = paramString + "&check=" + bool;
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " AppPayActivity.doBrowserPay data:" + paramString);
    }
    if (bool)
    {
      if (!tx(((avov)localObject).packageName))
      {
        VACDReportUtil.endReport(l, "parseurl", paramString, 668801, "app died.");
        super.finish();
        return;
      }
      VACDReportUtil.b(l, ((avov)localObject).cMu, "parseurl", paramString, 0, null);
      paramString = new Bundle();
      paramString.putInt("extra.key.pay.type", 1);
      paramString.putInt("extra.key.pay.from", 2);
      paramString.putInt("extra.key.pay.platform", 1);
      paramString.putInt("extra.key.app.type", 2);
      paramString.putLong("vacreport_key_seq", l);
      paramString.putString("appId", ((avov)localObject).appId);
      paramString.putString("callbackSn", ((avov)localObject).cMq);
      paramString.putString("nonce", ((avov)localObject).nonce);
      paramString.putLong("timeStamp", ((avov)localObject).timeStamp);
      paramString.putString("sig", ((avov)localObject).sig);
      paramString.putString("sigType", ((avov)localObject).cvX);
      paramString.putString("tokenId", ((avov)localObject).cMu);
      paramString.putString("bargainorId", ((avov)localObject).bargainorId);
      paramString.putString("qVersion", aqgz.bd(this));
      paramString.putString("packageName", ((avov)localObject).packageName);
      paramString.putString("callbackScheme", ((avov)localObject).cMr);
      localObject = new Intent(this, OpenPayActivity.class);
      ((Intent)localObject).putExtras(paramString);
      ((Intent)localObject).addFlags(67108864);
      super.startActivity((Intent)localObject);
    }
    for (;;)
    {
      super.finish();
      return;
      VACDReportUtil.endReport(l, "parseurl", paramString, 668801, "params error");
    }
  }
  
  private void eBw()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " AppPayActivity.prePay");
    }
    Object localObject = super.getIntent();
    if ((localObject != null) && (!TextUtils.isEmpty(((Intent)localObject).getAction())) && (((Intent)localObject).getAction().equals("android.intent.action.VIEW")) && (!TextUtils.isEmpty(((Intent)localObject).getScheme())) && (((Intent)localObject).getScheme().equals("mqqwallet")))
    {
      WH(true);
      return;
    }
    if (localObject == null) {}
    String str;
    for (localObject = "intent is null";; localObject = str + " Action:" + ((Intent)localObject).getAction())
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.pay", 2, "AppPayActivity.prePay error, params:" + (String)localObject);
      }
      super.finish();
      return;
      str = "Scheme:" + ((Intent)localObject).getScheme();
    }
  }
  
  private void em(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    long l = VACDReportUtil.a(null, "qqwallet", "pay-open-app", "payinvoke", null, 0, null);
    Object localObject = new avov();
    try
    {
      ((avov)localObject).fromBundle(paramIntent.getExtras());
      boolean bool = ((avov)localObject).checkParams();
      paramIntent = ((avov)localObject).toString();
      paramIntent = paramIntent + "&check=" + bool;
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " AppPayActivity.doOpenPay data:" + paramIntent);
      }
      if (bool)
      {
        VACDReportUtil.b(l, ((avov)localObject).cMu, "parseurl", paramIntent, 0, null);
        paramIntent = new Bundle();
        paramIntent.putInt("extra.key.pay.type", 1);
        paramIntent.putInt("extra.key.pay.from", 2);
        paramIntent.putInt("extra.key.pay.platform", 1);
        paramIntent.putInt("extra.key.app.type", 1);
        paramIntent.putLong("vacreport_key_seq", l);
        paramIntent.putString("appId", ((avov)localObject).appId);
        paramIntent.putString("callbackSn", ((avov)localObject).cMq);
        paramIntent.putString("nonce", ((avov)localObject).nonce);
        paramIntent.putLong("timeStamp", ((avov)localObject).timeStamp);
        paramIntent.putString("sig", ((avov)localObject).sig);
        paramIntent.putString("sigType", ((avov)localObject).cvX);
        paramIntent.putString("tokenId", ((avov)localObject).cMu);
        paramIntent.putString("bargainorId", ((avov)localObject).bargainorId);
        paramIntent.putString("qVersion", aqgz.bd(this));
        paramIntent.putString("packageName", ((avov)localObject).packageName);
        paramIntent.putString("callbackScheme", ((avov)localObject).cMr);
        localObject = new Intent(this, OpenPayActivity.class);
        ((Intent)localObject).putExtras(paramIntent);
        ((Intent)localObject).addFlags(67108864);
        super.startActivity((Intent)localObject);
        super.finish();
        return;
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
        continue;
        VACDReportUtil.endReport(l, "parseurl", paramIntent, 668801, "params error");
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " AppPayActivity.doOnActivityResult PAY_LOGIN_REQUEST");
    }
    WH(false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    try
    {
      super.doOnCreate(paramBundle);
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " AppPayActivity.doOnCreate");
      }
    }
    catch (Exception paramBundle)
    {
      label143:
      while (!QLog.isColorLevel()) {}
      QLog.e("qqBaseActivity", 2, "doOnCreate|exp:" + paramBundle.getMessage());
      return false;
    }
    try
    {
      if ((mAppForground) || (!this.mCanLock) || (this.app == null) || (this.app.getCurrentAccountUin() == null) || (!GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin()))) {
        break label184;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " AppPayActivity.doOnCreate getJumpLock");
      }
      this.dnJ = true;
    }
    catch (Throwable paramBundle)
    {
      label184:
      if (!QLog.isColorLevel()) {
        break label143;
      }
      QLog.e("qqBaseActivity", 2, "doOnCreate|exp:" + paramBundle.getMessage());
    }
    return false;
    eBw();
    return false;
    return false;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.dnJ) && (Math.abs(mShowGesture - SystemClock.uptimeMillis()) >= 1000L))
    {
      this.dnJ = false;
      eBw();
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
  
  protected boolean tx(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int j;
    do
    {
      Object localObject2;
      do
      {
        return false;
        localObject1 = null;
        if (getCallingActivity() != null) {
          localObject1 = getCallingActivity().getPackageName();
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject1;
          if (getCallingPackage() != null) {
            localObject2 = getCallingPackage();
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          return ((String)localObject2).equals(paramString);
        }
        localObject1 = (ActivityManager)getSystemService("activity");
      } while (localObject1 == null);
      Object localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses().iterator();
      j = 1;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
        int i = j;
        if (j != 0)
        {
          i = j;
          if (((ActivityManager.RunningAppProcessInfo)localObject2).processName != null)
          {
            i = j;
            if (((ActivityManager.RunningAppProcessInfo)localObject2).processName.indexOf("com.tencent.mobileqq") != 0) {
              i = 0;
            }
          }
        }
        j = i;
        if (((ActivityManager.RunningAppProcessInfo)localObject2).pkgList != null)
        {
          int k = 0;
          for (;;)
          {
            j = i;
            if (k >= ((ActivityManager.RunningAppProcessInfo)localObject2).pkgList.length) {
              break;
            }
            if (paramString.equals(localObject2.pkgList[k])) {
              return true;
            }
            k += 1;
          }
        }
      }
    } while (j == 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     cooperation.qwallet.open.AppPayActivity
 * JD-Core Version:    0.7.0.1
 */