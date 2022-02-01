package com.tencent.qqmail.utilities.qmnetwork.ssl;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.launcher.third.LaunchWebPush;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.stringextention.Hex;
import com.tencent.qqmail.utilities.thread.QMSchedulers;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMNotificationConstructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import moai.oss.KvHelper;
import moai.oss.OssHelper;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class SafeSSLStrategy
  extends SSLStraetgy
{
  private static final Map<Integer, Object> PROCESSING_CERTIFICATE_ID_WAITER_MAP = new ConcurrentHashMap();
  private static final String TAG = "SafeSSLStrategy";
  
  private boolean appVerify(String paramString, SSLSession paramSSLSession)
  {
    try
    {
      paramSSLSession = paramSSLSession.getPeerCertificates();
      QMLog.log(3, "SafeSSLStrategy", "appVerify certificates len:" + paramSSLSession.length);
      boolean bool = verify(paramString, (X509Certificate)paramSSLSession[0]);
      return bool;
    }
    catch (SSLException paramString) {}
    return false;
  }
  
  private static void cancel(int paramInt, Subscriber<? super Void> paramSubscriber)
  {
    KvHelper.cancelTrustSslCertificate(new double[0]);
    QMLog.log(4, "SafeSSLStrategy", "cancle id:" + paramInt);
    if (paramSubscriber != null) {
      paramSubscriber.onCompleted();
    }
  }
  
  private String extractCNFromSubjectName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    int k = paramString.indexOf("CN=") + 3;
    int j = paramString.indexOf(",", k);
    int i = j;
    if (j == -1) {
      i = paramString.length();
    }
    return paramString.substring(k, i);
  }
  
  @NonNull
  private String generateSSLCertificateDetail(X509Certificate paramX509Certificate)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    localStringBuilder.append("颁发给：").append(extractCNFromSubjectName(paramX509Certificate.getSubjectX500Principal().getName())).append("\n").append("颁发者：").append(extractCNFromSubjectName(paramX509Certificate.getIssuerX500Principal().getName())).append("\n").append("有效期：").append(localSimpleDateFormat.format(paramX509Certificate.getNotBefore())).append("至").append(localSimpleDateFormat.format(paramX509Certificate.getNotAfter())).append("\n").append("证书指纹：\n").append(getThumbPrint(paramX509Certificate)).append("\n");
    return localStringBuilder.toString();
  }
  
  private X509Certificate getFirstCertificate(Certificate[] paramArrayOfCertificate)
  {
    if ((paramArrayOfCertificate != null) && (paramArrayOfCertificate.length > 0) && (paramArrayOfCertificate[0] != null)) {
      return (X509Certificate)paramArrayOfCertificate[0];
    }
    return null;
  }
  
  private X509Certificate getFirstCertificate(X509Certificate[] paramArrayOfX509Certificate)
  {
    if ((paramArrayOfX509Certificate != null) && (paramArrayOfX509Certificate.length > 0)) {
      return paramArrayOfX509Certificate[0];
    }
    return null;
  }
  
  private SSLSocketFactory getSocketFactory()
  {
    try
    {
      Object localObject = getX509TrustManager();
      if (localObject == null) {
        return (SSLSocketFactory)SSLSocketFactory.getDefault();
      }
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      SecureRandom localSecureRandom = new SecureRandom();
      localSSLContext.init(null, new TrustManager[] { localObject }, localSecureRandom);
      localObject = localSSLContext.getSocketFactory();
      return localObject;
    }
    catch (Exception localException)
    {
      QMLog.log(5, "SafeSSLStrategy", "SSLTrustManager getSocketFactory exception" + localException.toString());
    }
    return (SSLSocketFactory)SSLSocketFactory.getDefault();
  }
  
  private static List<String> getSubjectAltNames(X509Certificate paramX509Certificate, int paramInt)
  {
    localArrayList = new ArrayList();
    try
    {
      paramX509Certificate = paramX509Certificate.getSubjectAlternativeNames();
      if (paramX509Certificate == null) {
        return Collections.emptyList();
      }
      paramX509Certificate = paramX509Certificate.iterator();
      while (paramX509Certificate.hasNext())
      {
        Object localObject = (List)paramX509Certificate.next();
        if ((localObject != null) && (((List)localObject).size() >= 2))
        {
          Integer localInteger = (Integer)((List)localObject).get(0);
          if ((localInteger != null) && (localInteger.intValue() == paramInt))
          {
            localObject = (String)((List)localObject).get(1);
            if (localObject != null) {
              localArrayList.add(localObject);
            }
          }
        }
      }
      return localArrayList;
    }
    catch (CertificateParsingException paramX509Certificate)
    {
      return Collections.emptyList();
    }
  }
  
  public static String getThumbPrint(X509Certificate paramX509Certificate)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramX509Certificate.getEncoded());
      paramX509Certificate = toReadableString(Hex.encodeHex(localMessageDigest.digest()));
      return paramX509Certificate;
    }
    catch (Throwable paramX509Certificate) {}
    return "";
  }
  
  private boolean handleCertificateException(X509Certificate paramX509Certificate, CertificateException paramCertificateException)
    throws CertificateException
  {
    boolean bool = true;
    OssHelper.sslErrorHost(new Object[] { this.mHost });
    if (paramX509Certificate != null) {
      if (!isCertificateTrusted(paramX509Certificate)) {
        bool = waitToAskIfTrust(getCertificateId(paramX509Certificate), paramX509Certificate, paramCertificateException);
      }
    }
    while (isHostTrusted(this.mHost)) {
      return bool;
    }
    return waitToAskIfTrust(getUrlId(this.mHost), null, paramCertificateException);
  }
  
  private static boolean isTrust(int paramInt)
  {
    return SPManager.getSp("trusted_certificate").getBoolean(paramInt + "", false);
  }
  
  private void logResult(String paramString1, String paramString2, List<String> paramList, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key:").append(paramString1);
    localStringBuilder.append(",address:").append(paramString2);
    localStringBuilder.append(",names:");
    paramString1 = paramList.iterator();
    while (paramString1.hasNext()) {
      localStringBuilder.append((String)paramString1.next()).append(",");
    }
    localStringBuilder.append(",result:").append(paramBoolean);
    QMLog.log(4, "SafeSSLStrategy", localStringBuilder.toString());
  }
  
  private void printCertDetail(TrustManager[] paramArrayOfTrustManager)
  {
    int k = paramArrayOfTrustManager.length;
    int i = 0;
    for (;;)
    {
      X509Certificate[] arrayOfX509Certificate;
      if (i < k)
      {
        arrayOfX509Certificate = ((X509TrustManager)paramArrayOfTrustManager[i]).getAcceptedIssuers();
        if (arrayOfX509Certificate != null) {}
      }
      else
      {
        return;
      }
      Log.d("SafeSSLStrategy", "X509TrustManager issuers length=" + arrayOfX509Certificate.length);
      int m = arrayOfX509Certificate.length;
      int j = 0;
      while (j < m)
      {
        X509Certificate localX509Certificate = arrayOfX509Certificate[j];
        Log.d("SafeSSLStrategy", "S:" + localX509Certificate.getSubjectDN().getName() + "\nI:" + localX509Certificate.getIssuerDN().getName());
        j += 1;
      }
      i += 1;
    }
  }
  
  private void printCertificate(X509Certificate[] paramArrayOfX509Certificate)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfX509Certificate.length)
    {
      localStringBuilder.append(i).append(" X509Certificate:\n");
      localStringBuilder.append("S:").append(paramArrayOfX509Certificate[i].getSubjectDN().getName()).append("\nI:").append(paramArrayOfX509Certificate[i].getIssuerX500Principal()).append("\n").append("Not Before:").append(paramArrayOfX509Certificate[i].getNotBefore()).append("\nNot After:").append(paramArrayOfX509Certificate[i].getNotAfter()).append("\n").append("Serial Number:").append(paramArrayOfX509Certificate[i].getSerialNumber());
      i += 1;
    }
    QMLog.log(4, "SafeSSLStrategy", "host:" + this.mHost + "\n" + localStringBuilder.toString());
  }
  
  private void printCertificates(String paramString, SSLSession paramSSLSession)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("time:").append(new Date()).append(",host:").append(paramString).append(",verify cers:");
    try
    {
      paramString = paramSSLSession.getPeerCertificates();
      if (paramString != null)
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          localStringBuilder.append(paramString[i]).append("\n\n");
          i += 1;
        }
      }
    }
    catch (SSLPeerUnverifiedException paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      paramString = QMApplicationContext.sharedInstance();
      localStringBuilder.append("\n").append("network wifi:").append(QMNetworkUtils.isWifiConnected(paramString)).append(",mobile:").append(QMNetworkUtils.isMobileConnected(paramString)).append(",airplane:").append(QMNetworkUtils.isAirplaneModeOn(paramString));
      QMLog.log(3, "SafeSSLStrategy", localStringBuilder.toString());
    }
  }
  
  /* Error */
  private static boolean putNewWaiterIfCertIdNotExist(int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 20	com/tencent/qqmail/utilities/qmnetwork/ssl/SafeSSLStrategy:PROCESSING_CERTIFICATE_ID_WAITER_MAP	Ljava/util/Map;
    //   6: iload_0
    //   7: invokestatic 468	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokeinterface 473 2 0
    //   15: ifne +34 -> 49
    //   18: iconst_1
    //   19: istore_1
    //   20: iload_1
    //   21: ifeq +23 -> 44
    //   24: getstatic 20	com/tencent/qqmail/utilities/qmnetwork/ssl/SafeSSLStrategy:PROCESSING_CERTIFICATE_ID_WAITER_MAP	Ljava/util/Map;
    //   27: iload_0
    //   28: invokestatic 468	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   31: new 320	java/lang/Object
    //   34: dup
    //   35: invokespecial 474	java/lang/Object:<init>	()V
    //   38: invokeinterface 478 3 0
    //   43: pop
    //   44: ldc 2
    //   46: monitorexit
    //   47: iload_1
    //   48: ireturn
    //   49: iconst_0
    //   50: istore_1
    //   51: goto -31 -> 20
    //   54: astore_2
    //   55: ldc 2
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	paramInt	int
    //   19	32	1	bool	boolean
    //   54	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	18	54	finally
    //   24	44	54	finally
  }
  
  private static void showSSLDialog(int paramInt, String paramString1, String paramString2, Subscriber<? super Void> paramSubscriber)
  {
    Activity localActivity = QMActivityManager.shareInstance().getVisibleActivity();
    if (localActivity == null)
    {
      if (paramSubscriber != null) {
        paramSubscriber.onCompleted();
      }
      return;
    }
    paramString1 = new QMUIDialogAction(localActivity, "查看证书详情", new SafeSSLStrategy.6(localActivity, paramString1));
    QMUIDialogAction localQMUIDialogAction = new QMUIDialogAction(localActivity, 0, "继续", 0, 2, new SafeSSLStrategy.7(paramInt, paramString2, paramSubscriber));
    paramString1 = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(localActivity).setMessage(paramString2 + "服务器证书来自不可信任的授权中心，是否信任并继续").addAction(2131691246, new SafeSSLStrategy.8())).addAction(paramString1)).addAction(localQMUIDialogAction)).create();
    paramString1.setCanceledOnTouchOutside(false);
    paramString1.setOnDismissListener(new SafeSSLStrategy.9(paramInt, paramSubscriber));
    paramString1.show();
    KvHelper.showSslDialog(new double[0]);
  }
  
  public static void showUnconfirmedSSLDialog()
  {
    try
    {
      HashMap localHashMap1 = new HashMap(SPManager.getSp("unconfirmed_certificate").getAll());
      HashMap localHashMap2 = new HashMap(SPManager.getSp("unconfirmed_host").getAll());
      SPManager.getEditor("unconfirmed_certificate").clear().apply();
      SPManager.getEditor("unconfirmed_host").clear().apply();
      Set localSet = localHashMap1.keySet();
      Log.d("SafeSSLStrategy", "unconfirmedCertificate ids size:" + localSet.size());
      Observable.timer(500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).flatMap(new SafeSSLStrategy.5(localSet)).doOnNext(new SafeSSLStrategy.4(localHashMap1, localHashMap2)).subscribe();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @NonNull
  private static String toReadableString(char[] paramArrayOfChar)
  {
    int j = 0;
    if ((paramArrayOfChar == null) || (paramArrayOfChar.length == 0)) {
      return "";
    }
    char[] arrayOfChar = new char[paramArrayOfChar.length + paramArrayOfChar.length / 2 - 1];
    int i = 0;
    while (j < paramArrayOfChar.length)
    {
      arrayOfChar[i] = paramArrayOfChar[j];
      int k = i;
      if (j % 2 == 1)
      {
        i += 1;
        k = i;
        if (i < arrayOfChar.length)
        {
          arrayOfChar[i] = ' ';
          k = i;
        }
      }
      i = k + 1;
      j += 1;
    }
    return new String(arrayOfChar).toUpperCase();
  }
  
  private boolean verifyHostName(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty())) {}
    int i;
    int j;
    int k;
    do
    {
      do
      {
        return false;
        paramString2 = paramString2.toLowerCase(Locale.US);
        if (!paramString2.contains("*")) {
          return paramString1.equals(paramString2);
        }
        if ((paramString2.startsWith("*.")) && (paramString1.equals(paramString2.substring(2)))) {
          return true;
        }
        i = paramString2.indexOf('*');
      } while ((i > paramString2.indexOf('.')) || (!paramString1.regionMatches(0, paramString2, 0, i)));
      j = paramString2.length() - (i + 1);
      k = paramString1.length() - j;
    } while ((paramString1.indexOf('.', i) < k) && (!paramString1.endsWith(".clients.google.com")));
    return paramString1.regionMatches(k, paramString2, i + 1, j);
  }
  
  private boolean verifyHostName(String paramString, X509Certificate paramX509Certificate)
  {
    paramString = paramString.toLowerCase(Locale.US);
    paramX509Certificate = getSubjectAltNames(paramX509Certificate, 2);
    Iterator localIterator = paramX509Certificate.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      if (!verifyHostName(paramString, (String)localIterator.next())) {
        break label69;
      }
      bool = true;
    }
    label69:
    for (;;)
    {
      break;
      logResult("verifyHostName", paramString, paramX509Certificate, bool);
      return bool;
    }
  }
  
  private boolean verifyIpAddress(String paramString, X509Certificate paramX509Certificate)
  {
    paramX509Certificate = getSubjectAltNames(paramX509Certificate, 7);
    Iterator localIterator = paramX509Certificate.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      if (!paramString.equalsIgnoreCase((String)localIterator.next())) {
        break label61;
      }
      bool = true;
    }
    label61:
    for (;;)
    {
      break;
      logResult("verifyIpAddress", paramString, paramX509Certificate, bool);
      return bool;
    }
  }
  
  private boolean waitToAskIfTrust(int paramInt, X509Certificate arg2, CertificateException paramCertificateException)
    throws CertificateException
  {
    boolean bool = false;
    Object localObject;
    if (AppStatusUtil.isAppOnBackGround())
    {
      long l = QMSettingManager.sharedInstance().getLastLastSSLErrorNotificationTime();
      if (new Date().getTime() - l > 600000L)
      {
        QMSettingManager.sharedInstance().setLastSSLErrorNotificationTime();
        localObject = LaunchWebPush.createSSLErrorIntent();
        localObject = PendingIntent.getActivity(QMApplicationContext.sharedInstance(), 0, (Intent)localObject, 268435456);
        QMNotificationConstructor.getInstance().notifySSLError("安全提示", "服务器证书来自不可信任的授权中心", "", (PendingIntent)localObject);
        KvHelper.showSslNotification(new double[0]);
      }
      SPManager.getEditor("unconfirmed_certificate").putString(paramInt + "", generateSSLCertificateDetail(???)).apply();
      SPManager.getEditor("unconfirmed_host").putString(paramInt + "", this.mHost).apply();
      if (paramCertificateException != null) {
        throw new CertificateException("QMCertificateException", paramCertificateException);
      }
    }
    else
    {
      localObject = new AtomicBoolean(false);
      if (putNewWaiterIfCertIdNotExist(paramInt))
      {
        QMLog.log(4, "SafeSSLStrategy", "waitToAskIfTrust id:" + paramInt + ", err:" + paramCertificateException);
        Observable.just(Observable.empty()).observeOn(AndroidSchedulers.mainThread()).flatMap(new SafeSSLStrategy.3(this, ???, paramInt)).observeOn(QMSchedulers.io()).doOnCompleted(new SafeSSLStrategy.2(this, paramInt, (AtomicBoolean)localObject)).subscribe();
      }
      synchronized (PROCESSING_CERTIFICATE_ID_WAITER_MAP.get(Integer.valueOf(paramInt)))
      {
        if (!((AtomicBoolean)localObject).get()) {
          Threads.waitNoException(???);
        }
        if (!isTrust(paramInt))
        {
          QMLog.log(4, "SafeSSLStrategy", "id:" + paramInt + ", throw err");
          if (paramCertificateException == null) {
            break label376;
          }
          throw new CertificateException("QMCertificateException", paramCertificateException);
        }
      }
      bool = true;
    }
    label376:
    return bool;
  }
  
  SSLSocketFactory getWrappedFactory()
  {
    try
    {
      SSLSocketFactory localSSLSocketFactory = getSocketFactory();
      if (localSSLSocketFactory != null) {
        return localSSLSocketFactory;
      }
    }
    catch (Exception localException)
    {
      QMLog.log(5, "SafeSSLStrategy", "getWrappedFactory exception" + localException.toString());
    }
    return (SSLSocketFactory)SSLSocketFactory.getDefault();
  }
  
  public X509TrustManager getX509TrustManager()
  {
    try
    {
      Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject).init((KeyStore)null);
      localObject = ((TrustManagerFactory)localObject).getTrustManagers();
      Log.d("SafeSSLStrategy", "trustManagers.length=" + localObject.length + ", className=" + localObject[0].getClass().getName());
      localObject = new SafeSSLStrategy.1(this, (X509TrustManager)localObject[0]);
      return localObject;
    }
    catch (Exception localException)
    {
      QMLog.log(5, "SafeSSLStrategy", "SSLTrustManager construction exception" + localException.toString());
    }
    return null;
  }
  
  public boolean verify(String paramString, X509Certificate paramX509Certificate)
  {
    try
    {
      Method localMethod = InetAddress.class.getDeclaredMethod("isNumeric", new Class[] { String.class });
      localMethod.setAccessible(true);
      boolean bool = ((Boolean)localMethod.invoke(null, new Object[] { paramString })).booleanValue();
      QMLog.log(3, "SafeSSLStrategy", "verify host:" + paramString + "," + bool);
      if (bool) {
        return verifyIpAddress(paramString, paramX509Certificate);
      }
      bool = verifyHostName(paramString, paramX509Certificate);
      return bool;
    }
    catch (NoSuchMethodException paramString)
    {
      QMLog.log(5, "SafeSSLStrategy", "verify host fail NoSuchMethodException:" + paramString.toString());
      return false;
    }
    catch (InvocationTargetException paramString)
    {
      for (;;)
      {
        QMLog.log(5, "SafeSSLStrategy", "verify host fail InvocationTargetException:" + paramString.toString());
      }
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        QMLog.log(5, "SafeSSLStrategy", "verify host fail IllegalAccessException:" + paramString.toString());
      }
    }
  }
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    boolean bool2 = HttpsURLConnection.getDefaultHostnameVerifier().verify(paramString, paramSSLSession);
    Log.d("SafeSSLStrategy", "verify by DefaultHostnameVerifier: " + bool2);
    boolean bool1 = bool2;
    if (!bool2) {
      printCertificates(paramString, paramSSLSession);
    }
    try
    {
      bool1 = handleCertificateException(getFirstCertificate(paramSSLSession.getPeerCertificates()), null);
      return bool1;
    }
    catch (Exception localException)
    {
      bool1 = appVerify(paramString, paramSSLSession);
      QMLog.log(4, "SafeSSLStrategy", "appVerify:" + bool1);
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.ssl.SafeSSLStrategy
 * JD-Core Version:    0.7.0.1
 */