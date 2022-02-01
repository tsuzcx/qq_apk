import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.ims.signature.SignatureReport;
import com.tencent.ims.signature.SignatureResult;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler.3;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;

public class acly
  extends accg
  implements BusinessObserver
{
  Queue<acly.b> E = new LinkedList();
  Activity F = null;
  public acly.a a;
  public acly.c a;
  public AppInterface appInterface = null;
  private Handler cx = new aclz(this, Looper.getMainLooper());
  private Handler cy = new acma(this, Looper.getMainLooper());
  final int cyd = 1;
  final int cye = 2;
  final int cyf = 3;
  Runnable fN = new StartAppCheckHandler.3(this);
  BrowserAppInterface mBrowserApp = null;
  public boolean mIsRunning = false;
  
  public acly(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.appInterface = paramQQAppInterface;
  }
  
  private void aO(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:server result code ok");
    }
    Object localObject2 = new signature.SignatureResult();
    Object localObject1;
    try
    {
      ((signature.SignatureResult)localObject2).mergeFrom(paramArrayOfByte);
      if (((signature.SignatureResult)localObject2).str_packname.get().equalsIgnoreCase("MobileQQ"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:MobileQQ fail");
        }
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:sigResult parse fail");
          }
          paramArrayOfByte.printStackTrace();
        }
        if ((((signature.SignatureResult)localObject2).has()) && (((signature.SignatureResult)localObject2).str_packname.has()) && (((signature.SignatureResult)localObject2).str_packname.get() != null) && (((signature.SignatureResult)localObject2).u32_check_result.has())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:packname fail");
      return;
      paramArrayOfByte = ((signature.SignatureResult)localObject2).str_packname.get();
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_Acly$a.lastReportTime = Long.valueOf(l).longValue();
      if (((signature.SignatureResult)localObject2).u32_timeout.has()) {
        this.jdField_a_of_type_Acly$a.timeToWait = ((signature.SignatureResult)localObject2).u32_timeout.get();
      }
      if (((signature.SignatureResult)localObject2).u32_check_result.has()) {
        this.jdField_a_of_type_Acly$a.cyg = ((signature.SignatureResult)localObject2).u32_check_result.get();
      }
      if (((signature.SignatureResult)localObject2).str_title.has()) {
        this.jdField_a_of_type_Acly$a.bpu = ((signature.SignatureResult)localObject2).str_title.get();
      }
      if (((signature.SignatureResult)localObject2).str_content.has()) {
        this.jdField_a_of_type_Acly$a.bpv = ((signature.SignatureResult)localObject2).str_content.get();
      }
      if (((signature.SignatureResult)localObject2).str_left_button.has()) {
        this.jdField_a_of_type_Acly$a.bpw = ((signature.SignatureResult)localObject2).str_left_button.get();
      }
      if (((signature.SignatureResult)localObject2).str_right_button.has()) {
        this.jdField_a_of_type_Acly$a.bpx = ((signature.SignatureResult)localObject2).str_right_button.get();
      }
      if (((signature.SignatureResult)localObject2).str_url.has()) {
        this.jdField_a_of_type_Acly$a.bpy = ((signature.SignatureResult)localObject2).str_url.get();
      }
      this.jdField_a_of_type_Acly$a.cMz();
      this.jdField_a_of_type_Acly$a = null;
      localObject1 = new LinkedList();
      switch (((signature.SignatureResult)localObject2).u32_check_result.get())
      {
      }
    }
    for (;;)
    {
      paramArrayOfByte = ((List)localObject1).iterator();
      while (paramArrayOfByte.hasNext())
      {
        localObject1 = (acly.b)paramArrayOfByte.next();
        this.E.remove(localObject1);
      }
      break;
      localObject2 = this.E.iterator();
      Object localObject4;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (acly.b)((Iterator)localObject2).next();
        if (((acly.b)localObject3).packageName.equals(paramArrayOfByte))
        {
          ((List)localObject1).add(localObject3);
          localObject4 = this.cy.obtainMessage(2, localObject3);
          this.cy.removeMessages(2, localObject3);
          this.cy.sendMessage((Message)localObject4);
        }
      }
      continue;
      Object localObject3 = this.E.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (acly.b)((Iterator)localObject3).next();
        if (((acly.b)localObject4).packageName.equals(paramArrayOfByte))
        {
          ((List)localObject1).add(localObject4);
          this.cy.removeMessages(2, localObject4);
          localObject4 = new Intent(this.appInterface.getApplication(), NotificationActivity.class);
          ((Intent)localObject4).putExtra("type", 9);
          Bundle localBundle = new Bundle();
          localBundle.putString("dlg_title", ((signature.SignatureResult)localObject2).str_title.get());
          localBundle.putString("dlg_content", ((signature.SignatureResult)localObject2).str_content.get());
          localBundle.putString("dlg_lbutton", ((signature.SignatureResult)localObject2).str_left_button.get());
          localBundle.putString("dlg_rbutton", ((signature.SignatureResult)localObject2).str_right_button.get());
          localBundle.putString("dlg_url", ((signature.SignatureResult)localObject2).str_url.get());
          ((Intent)localObject4).putExtras(localBundle);
          ((Intent)localObject4).setFlags(872415232);
          this.appInterface.getApplication().startActivity((Intent)localObject4);
        }
      }
    }
  }
  
  private PackageInfo b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString, 64);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void j(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("openType", paramString1);
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramString2.length() > 300) {
        paramString1 = paramString2.substring(0, 300);
      }
    }
    localHashMap.put("url", paramString1);
    localHashMap.put("appName", paramString3);
    localHashMap.put("from", paramString4);
    localHashMap.put("clickOrigin", paramString5);
    localHashMap.put("className", paramString6);
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "AppOpenUrl", true, 0L, 0L, localHashMap, null);
  }
  
  public void a(String paramString, Context paramContext, Intent paramIntent)
  {
    QQBrowserActivity localQQBrowserActivity = (QQBrowserActivity)paramContext;
    this.F = localQQBrowserActivity;
    this.mBrowserApp = ((BrowserAppInterface)localQQBrowserActivity.getAppRuntime());
    this.appInterface = this.mBrowserApp;
    b(paramString, paramContext, paramIntent);
  }
  
  public void b(String paramString, Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppStartedHandler", 2, "<-- AppStartedObserver pkgName=" + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramContext != null) && (paramIntent != null)) {
      j(paramIntent.getStringExtra("report_open_type"), paramIntent.getStringExtra("report_url"), paramString, paramIntent.getStringExtra("report_from"), paramIntent.getStringExtra("report_click_origin"), paramIntent.getStringExtra("report_class_name"));
    }
    if ((true == this.mIsRunning) || (paramString == null))
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    this.jdField_a_of_type_Acly$c = new acly.c(paramString);
    this.jdField_a_of_type_Acly$a = new acly.a(paramString);
    long l;
    if (Long.valueOf(System.currentTimeMillis()).longValue() < this.jdField_a_of_type_Acly$a.lastReportTime + 86400000L)
    {
      PackageInfo localPackageInfo = b(this.appInterface.getApplication(), this.jdField_a_of_type_Acly$c.mPkgName);
      if (localPackageInfo != null)
      {
        String str = SecUtil.getSignatureHash(localPackageInfo.signatures[0].toByteArray());
        l = new File(localPackageInfo.applicationInfo.sourceDir).lastModified();
        if ((this.jdField_a_of_type_Acly$a.QQ == l) && (this.jdField_a_of_type_Acly$a.bpt.equalsIgnoreCase(str)))
        {
          if (this.jdField_a_of_type_Acly$a.cyg != 2)
          {
            paramContext.startActivity(paramIntent);
            return;
          }
          paramString = new Intent(this.appInterface.getApplication(), NotificationActivity.class);
          paramString.putExtra("type", 9);
          paramContext = new Bundle();
          paramContext.putString("dlg_title", this.jdField_a_of_type_Acly$a.bpu);
          paramContext.putString("dlg_content", this.jdField_a_of_type_Acly$a.bpv);
          paramContext.putString("dlg_lbutton", this.jdField_a_of_type_Acly$a.bpw);
          paramContext.putString("dlg_rbutton", this.jdField_a_of_type_Acly$a.bpx);
          paramContext.putString("dlg_url", this.jdField_a_of_type_Acly$a.bpy);
          paramString.putExtras(paramContext);
          paramString.setFlags(872415232);
          this.appInterface.getApplication().startActivity(paramString);
          try
          {
            anot.a(null, "P_CliOper", "Safe_StartAppCheck", this.appInterface.getAccount(), "startAppByCheckValid", this.jdField_a_of_type_Acly$a.md5, 0, 0, "", "", "", "");
            return;
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            return;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Acly$c.mUin = Long.valueOf(this.appInterface.getAccount()).longValue();
        this.jdField_a_of_type_Acly$c.mClientType = 1;
        this.jdField_a_of_type_Acly$c.mPkgName = paramString;
        paramString = new acly.b(paramString, paramContext, paramIntent);
        this.E.offer(paramString);
        paramContext = new Message();
        paramContext.what = 2;
        paramContext.obj = paramString;
        this.cy.sendMessage(paramContext);
        paramString = this.cx;
        if (this.jdField_a_of_type_Acly$a.timeToWait <= 0L) {
          break label581;
        }
        l = this.jdField_a_of_type_Acly$a.timeToWait;
        paramString.sendEmptyMessageDelayed(3, l);
        this.mIsRunning = true;
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AppStartedHandler", 2, "GetAccount Failed!");
      return;
      label581:
      l = 300L;
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {
      if (QLog.isColorLevel()) {
        QLog.d("AppStartedHandler", 2, "onReceive: onReceive Observer package:MobileQQ fail");
      }
    }
    while ((!paramBoolean) || (paramBundle == null)) {
      return;
    }
    aO(paramBundle.getByteArray("data"));
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    if ((paramToServiceMsg == null) || (paramToServiceMsg.length() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package: server cmd is null");
      }
    }
    do
    {
      do
      {
        return;
      } while (!"SecCheckSigSvc.UploadReq".equalsIgnoreCase(paramToServiceMsg));
      if (QLog.isColorLevel()) {
        QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:check result");
      }
    } while (!paramFromServiceMsg.isSuccess());
    aO((byte[])paramObject);
  }
  
  public class a
  {
    public long QQ;
    public String bpt;
    String bpu;
    String bpv;
    String bpw;
    String bpx;
    String bpy;
    int cyg;
    long lastReportTime;
    public String md5;
    String pkgName;
    long timeToWait;
    
    a(String paramString)
    {
      this.pkgName = paramString;
      cMy();
    }
    
    public void cMy()
    {
      if (this.pkgName == null) {
        return;
      }
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("AppStartedObserver", 0);
      this.timeToWait = localSharedPreferences.getLong(this.pkgName + "_timeToWait", 0L);
      this.lastReportTime = localSharedPreferences.getLong(this.pkgName + "_lastReportTime", 0L);
      this.QQ = localSharedPreferences.getLong(this.pkgName + "_lastUpdateTime", 0L);
      this.bpt = localSharedPreferences.getString(this.pkgName + "_sigHash", "");
      this.md5 = localSharedPreferences.getString(this.pkgName + "_md5", "");
      this.cyg = localSharedPreferences.getInt(this.pkgName + "_serverResult", 0);
      this.bpu = localSharedPreferences.getString(this.pkgName + "_dlgTitle", "");
      this.bpv = localSharedPreferences.getString(this.pkgName + "_dlgContent", "");
      this.bpw = localSharedPreferences.getString(this.pkgName + "_dlgLButton", "");
      this.bpx = localSharedPreferences.getString(this.pkgName + "_dlgRButoon", "");
      this.bpy = localSharedPreferences.getString(this.pkgName + "_dlgUrl", "");
    }
    
    public void cMz()
    {
      if (this.pkgName == null) {
        return;
      }
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("AppStartedObserver", 0).edit();
      localEditor.putLong(this.pkgName + "_timeToWait", this.timeToWait);
      localEditor.putLong(this.pkgName + "_lastReportTime", this.lastReportTime);
      localEditor.putLong(this.pkgName + "_lastUpdateTime", this.QQ);
      localEditor.putString(this.pkgName + "_sigHash", this.bpt);
      localEditor.putString(this.pkgName + "_md5", this.md5);
      localEditor.putInt(this.pkgName + "_serverResult", this.cyg);
      localEditor.putString(this.pkgName + "_dlgTitle", this.bpu);
      localEditor.putString(this.pkgName + "_dlgContent", this.bpv);
      localEditor.putString(this.pkgName + "_dlgLButton", this.bpw);
      localEditor.putString(this.pkgName + "_dlgRButoon", this.bpx);
      localEditor.putString(this.pkgName + "_dlgUrl", this.bpy);
      localEditor.commit();
    }
  }
  
  class b
  {
    Context S;
    Intent intent;
    String packageName;
    
    b(String paramString, Context paramContext, Intent paramIntent)
    {
      this.packageName = paramString;
      this.S = paramContext;
      this.intent = paramIntent;
    }
  }
  
  public class c
  {
    public signature.SignatureReport a;
    public String bpA;
    public String bpB;
    public String bpz;
    public int mClientType;
    public String mPkgName;
    public long mUin;
    
    c(String paramString)
    {
      this.mPkgName = paramString;
      this.a = new signature.SignatureReport();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acly
 * JD-Core Version:    0.7.0.1
 */