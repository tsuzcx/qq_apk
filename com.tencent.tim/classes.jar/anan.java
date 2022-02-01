import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeRequest;
import com.tencent.qphone.base.util.QLog;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.WtloginPrivacyListenerImpl;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.tools.util;

public class anan
{
  protected static String SKEY = "";
  protected static boolean cEB;
  protected String ccI;
  protected Handler dp;
  protected NewIntent i;
  protected Handler mHandler;
  protected boolean mIsCanceled;
  protected HashMap<String, String> nb = new HashMap();
  
  private void a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    localanar = new anar(this, System.currentTimeMillis(), paramString3, paramContext, paramInt);
    if (this.i == null) {
      this.i = new NewIntent(paramContext, jnl.class);
    }
    localAuthorizeRequest = new FastAuthorize.AuthorizeRequest();
    long l1 = 0L;
    try
    {
      l2 = Long.parseLong(paramAppInterface.getCurrentAccountUin());
      l1 = l2;
    }
    catch (Exception localException)
    {
      long l2;
      label64:
      break label64;
    }
    localAuthorizeRequest.uin.set(l1);
    l1 = 0L;
    try
    {
      l2 = Long.parseLong(paramString1);
      l1 = l2;
    }
    catch (Exception paramString1)
    {
      label87:
      int j;
      break label87;
    }
    localAuthorizeRequest.client_id.set(l1);
    localAuthorizeRequest.pf.set("");
    paramString1 = arxn.bI(paramContext);
    localAuthorizeRequest.qqv.set(paramString1);
    localAuthorizeRequest.sdkp.set("a");
    paramString1 = Build.DISPLAY;
    localAuthorizeRequest.os.set(paramString1);
    localAuthorizeRequest.skey.set(paramString4);
    j = ea(paramString2);
    if (j == 0)
    {
      arxn.a(paramContext, paramString3, f(this.ccI), paramInt);
      cEB = false;
      return;
    }
    localAuthorizeRequest.flags.set(j);
    paramString2 = "";
    paramString1 = paramString2;
    for (;;)
    {
      try
      {
        arrayOfSignature = paramContext.getPackageManager().getPackageInfo(paramString3, 64).signatures;
        paramString1 = paramString2;
        if (arrayOfSignature != null)
        {
          paramString4 = paramString2;
          paramString1 = paramString2;
        }
      }
      catch (Exception paramString2)
      {
        Signature[] arrayOfSignature;
        MessageDigest localMessageDigest;
        label302:
        continue;
        localAuthorizeRequest.apk_sign.set(paramString1);
        this.i.putExtra("cmd", "ConnAuthSvr.fast_qq_login");
        try
        {
          this.i.putExtra("data", localAuthorizeRequest.toByteArray());
          this.i.setObserver(localanar);
          paramAppInterface.startServlet(this.i);
          this.mHandler.sendEmptyMessageDelayed(0, 2000L);
          return;
        }
        catch (Exception paramAppInterface)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(getClass().getSimpleName(), 2, paramAppInterface.getMessage());
          cEB = false;
          return;
        }
      }
      try
      {
        localMessageDigest = MessageDigest.getInstance("MD5");
        paramString4 = paramString2;
        paramString1 = paramString2;
        localMessageDigest.update(arrayOfSignature[0].toByteArray());
        paramString4 = paramString2;
        paramString1 = paramString2;
        paramString2 = aqhs.bytes2HexStr(localMessageDigest.digest());
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException1)
      {
        paramString2 = paramString4;
        paramString1 = paramString2;
        localNoSuchAlgorithmException1.printStackTrace();
        paramString1 = paramString2;
      }
    }
    try
    {
      paramString1 = paramString2.toLowerCase();
      paramString2 = paramString1;
      paramString4 = paramString2;
      paramString1 = paramString2;
      localMessageDigest.reset();
      paramString1 = paramString2;
    }
    catch (Exception paramString1)
    {
      paramString1 = paramString2;
      break label302;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
    {
      break label355;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(getClass().getSimpleName(), 2, "no sign");
      }
      cEB = false;
      arxn.a(paramContext, paramString3, f(this.ccI), paramInt);
      return;
    }
  }
  
  public static void dOL()
  {
    SKEY = "";
  }
  
  public static int ea(String paramString)
  {
    int k = 0;
    if (paramString.contains("$OPID$")) {
      k = 1;
    }
    int j = k;
    if (paramString.contains("$AT$")) {
      j = k | 0x2;
    }
    k = j;
    if (paramString.contains("$PT$")) {
      k = j | 0x4;
    }
    j = k;
    if (paramString.contains("$PF$")) {
      j = k | 0x40;
    }
    k = j;
    if (paramString.contains("$ESK$")) {
      k = j | 0x80;
    }
    return k;
  }
  
  public static Bundle f(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return localBundle;
      paramString = paramString.split("&");
    } while (paramString == null);
    int k = paramString.length;
    int j = 0;
    while (j < k)
    {
      Object localObject = paramString[j];
      int m = localObject.indexOf('=');
      if (m != -1) {}
      try
      {
        localBundle.putString(localObject.substring(0, m), localObject.substring(m + 1));
        j += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("AppLaucherHelper", 2, localException.getMessage(), localException);
        }
      }
    }
  }
  
  public boolean a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (cEB) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(getClass().getSimpleName(), 2, "lauchApp");
    }
    cEB = true;
    if (this.mHandler == null) {
      this.mHandler = new anaq(this, Looper.getMainLooper(), paramContext, paramString3, paramInt, paramAppInterface, paramString1, paramString2);
    }
    if (paramString2.startsWith("?")) {}
    for (this.ccI = paramString2.substring(1);; this.ccI = paramString2)
    {
      a(paramAppInterface, paramContext, paramString1, paramString2, paramString3, ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount()), paramInt);
      return true;
    }
  }
  
  public boolean a(String paramString1, Context paramContext, String paramString2, AppInterface paramAppInterface, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    if (cEB) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(getClass().getSimpleName(), 2, "launchAppWithWlogin");
    }
    if ((TextUtils.isEmpty(paramString2)) || (!jml.a().cX(paramString2))) {
      return false;
    }
    cEB = true;
    if (this.dp == null) {
      this.dp = new anao(this);
    }
    Long localLong = Long.valueOf(0L);
    try
    {
      paramString2 = Long.valueOf(paramString3);
      long l1 = 1L;
      try
      {
        long l2 = Long.valueOf(paramString5).longValue();
        l1 = l2;
      }
      catch (Exception paramString3)
      {
        label99:
        break label99;
      }
      paramString3 = new WtloginHelper(paramAppInterface.getApplication().getApplicationContext(), WtloginPrivacyListenerImpl.getSingleton());
      paramString5 = util.getPkgSigFromApkName(paramContext, paramString4);
      paramString3.GetA1WithA1(paramAppInterface.getAccount(), 16L, 16L, paramString4.getBytes(), 1L, paramString2.longValue(), l1, "5.2".getBytes(), paramString5, new WUserSigInfo(), new WFastLoginInfo());
      paramString3.SetListener(new anap(this, paramString1, paramString3, paramInt, paramContext));
      this.dp.sendEmptyMessageDelayed(0, 10000L);
      return true;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString2 = localLong;
        if (QLog.isColorLevel())
        {
          QLog.d("appcenter", 2, "parse appid error = " + paramString3);
          paramString2 = localLong;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anan
 * JD-Core Version:    0.7.0.1
 */