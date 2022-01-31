package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.tencent.smtt.secure.SecureWebView;
import java.io.PrintWriter;
import java.io.StringWriter;

public class SecuritySwitch
{
  private static final String LOGTAG = "SecuritySwitch";
  public static final int STATUS_DEFAULT = 0;
  public static final int STATUS_DISABLE = 2;
  public static final int STATUS_SKIP_LOAD_SO = 1;
  private static Context mContext = null;
  private static Object securityLock;
  private static boolean shouldApplySecurity = false;
  
  static
  {
    securityLock = new Object();
  }
  
  public static int getSecurityJsVersion()
  {
    try
    {
      int i = SecureWebView.getJSVersionCode(mContext);
      return i;
    }
    catch (Throwable localThrowable)
    {
      StringWriter localStringWriter = new StringWriter();
      localThrowable.printStackTrace(new PrintWriter(localStringWriter));
      QbSdkLog.e("SecuritySwitch", "exceptions occurred4:" + localStringWriter.toString());
    }
    return 0;
  }
  
  public static int getSecuritySdkVersion()
  {
    try
    {
      int i = SecureWebView.getSDKVersionCode(mContext);
      return i;
    }
    catch (Throwable localThrowable)
    {
      StringWriter localStringWriter = new StringWriter();
      localThrowable.printStackTrace(new PrintWriter(localStringWriter));
      QbSdkLog.e("SecuritySwitch", "exceptions occurred3:" + localStringWriter.toString());
    }
    return 0;
  }
  
  public static boolean isSecurityApplyed()
  {
    synchronized (securityLock)
    {
      boolean bool = shouldApplySecurity;
      return bool;
    }
  }
  
  public static void setContext(Context paramContext)
  {
    if (paramContext != null) {
      mContext = paramContext.getApplicationContext();
    }
  }
  
  public static void setSecureLibraryStatus(int paramInt)
  {
    SecureWebView.setSecureLibraryStatus(paramInt);
  }
  
  /* Error */
  public static void setSecurityStatusIfNecessary(Context paramContext, View paramView)
  {
    // Byte code:
    //   0: getstatic 104	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 14
    //   5: if_icmpge +11 -> 16
    //   8: ldc 10
    //   10: ldc 106
    //   12: invokestatic 109	com/tencent/smtt/sdk/QbSdkLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: return
    //   16: aload_0
    //   17: invokevirtual 93	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   20: putstatic 34	com/tencent/smtt/sdk/SecuritySwitch:mContext	Landroid/content/Context;
    //   23: getstatic 32	com/tencent/smtt/sdk/SecuritySwitch:securityLock	Ljava/lang/Object;
    //   26: astore_2
    //   27: aload_2
    //   28: monitorenter
    //   29: getstatic 34	com/tencent/smtt/sdk/SecuritySwitch:mContext	Landroid/content/Context;
    //   32: aload_1
    //   33: invokestatic 112	com/tencent/smtt/sdk/SecuritySwitch:shouldApplySecurity	(Landroid/content/Context;Landroid/view/View;)Z
    //   36: putstatic 27	com/tencent/smtt/sdk/SecuritySwitch:shouldApplySecurity	Z
    //   39: aload_2
    //   40: monitorexit
    //   41: ldc 10
    //   43: new 59	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   50: ldc 114
    //   52: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: getstatic 27	com/tencent/smtt/sdk/SecuritySwitch:shouldApplySecurity	Z
    //   58: invokevirtual 117	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   61: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 77	com/tencent/smtt/sdk/QbSdkLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_0
    //   68: invokestatic 119	com/tencent/smtt/secure/SecureWebView:setContext	(Landroid/content/Context;)V
    //   71: getstatic 27	com/tencent/smtt/sdk/SecuritySwitch:shouldApplySecurity	Z
    //   74: invokestatic 123	com/tencent/smtt/secure/SecureWebView:setSafeUxssStatus	(Z)V
    //   77: return
    //   78: astore_0
    //   79: new 47	java/io/StringWriter
    //   82: dup
    //   83: invokespecial 48	java/io/StringWriter:<init>	()V
    //   86: astore_1
    //   87: aload_0
    //   88: new 50	java/io/PrintWriter
    //   91: dup
    //   92: aload_1
    //   93: invokespecial 53	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   96: invokevirtual 57	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   99: ldc 10
    //   101: new 59	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   108: ldc 125
    //   110: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_1
    //   114: invokevirtual 70	java/io/StringWriter:toString	()Ljava/lang/String;
    //   117: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 77	com/tencent/smtt/sdk/QbSdkLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: return
    //   127: astore_0
    //   128: aload_2
    //   129: monitorexit
    //   130: aload_0
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramContext	Context
    //   0	132	1	paramView	View
    // Exception table:
    //   from	to	target	type
    //   16	29	78	java/lang/Throwable
    //   41	77	78	java/lang/Throwable
    //   130	132	78	java/lang/Throwable
    //   29	41	127	finally
    //   128	130	127	finally
  }
  
  private static boolean shouldApplySecurity(Context paramContext, View paramView)
  {
    paramView.post(new Runnable()
    {
      public void run()
      {
        try
        {
          Log.e("SecuritySwitch", "TesDownloader --> pull switch if necessary!");
          TesDownloader.needDownload(this.val$cx);
          return;
        }
        catch (Throwable localThrowable)
        {
          StringWriter localStringWriter = new StringWriter();
          localThrowable.printStackTrace(new PrintWriter(localStringWriter));
          QbSdkLog.e("SecuritySwitch", "exceptions occurred2:" + localStringWriter.toString());
        }
      }
    });
    paramContext = TesDownloadConfig.getInstance(paramContext);
    if (paramContext != null) {
      return paramContext.mLastSecuritySwitch;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.SecuritySwitch
 * JD-Core Version:    0.7.0.1
 */