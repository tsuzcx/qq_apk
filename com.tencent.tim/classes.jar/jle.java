import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.utils.SignalStrengthReport.1;
import com.tencent.av.utils.SignalStrengthReport.2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URI;
import org.json.JSONObject;

public class jle
{
  static volatile jle jdField_a_of_type_Jle;
  public String SK = "";
  WifiManager jdField_a_of_type_AndroidNetWifiWifiManager;
  TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager;
  jle.b jdField_a_of_type_Jle$b;
  public int aAW = -1;
  public int aAX = 0;
  int aAY = 0;
  int aAZ = -1;
  Runnable cn = new SignalStrengthReport.1(this);
  Runnable co = new SignalStrengthReport.2(this);
  WeakReference<Context> mContextReference;
  public Handler mHandler;
  HandlerThread mThread;
  
  private jle(Context paramContext)
  {
    this.mContextReference = new WeakReference(paramContext);
    if (Looper.myLooper() != null) {
      this.jdField_a_of_type_Jle$b = new jle.b();
    }
    if (paramContext != null)
    {
      this.jdField_a_of_type_AndroidNetWifiWifiManager = ((WifiManager)paramContext.getSystemService("wifi"));
      this.jdField_a_of_type_AndroidTelephonyTelephonyManager = ((TelephonyManager)paramContext.getSystemService("phone"));
    }
  }
  
  public static jle a(Context paramContext)
  {
    if (jdField_a_of_type_Jle == null) {}
    try
    {
      if (jdField_a_of_type_Jle == null) {
        jdField_a_of_type_Jle = new jle(paramContext);
      }
      return jdField_a_of_type_Jle;
    }
    finally {}
  }
  
  private String am(long paramLong)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(String.valueOf((int)(paramLong & 0xFF)));
    localStringBuffer.append('.');
    localStringBuffer.append(String.valueOf((int)(paramLong >> 8 & 0xFF)));
    localStringBuffer.append('.');
    localStringBuffer.append(String.valueOf((int)(paramLong >> 16 & 0xFF)));
    localStringBuffer.append('.');
    localStringBuffer.append(String.valueOf((int)(paramLong >> 24 & 0xFF)));
    return localStringBuffer.toString();
  }
  
  private static int getNetworkType()
  {
    int i = 0;
    if (AppNetConnInfo.isWifiConn()) {
      i = 1;
    }
    while (!AppNetConnInfo.isMobileConn()) {
      return i;
    }
    switch (AppNetConnInfo.getMobileInfo())
    {
    default: 
      return 0;
    case 1: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 4;
    }
    return 5;
  }
  
  private String hy()
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      if (this.jdField_a_of_type_AndroidNetWifiWifiManager != null)
      {
        DhcpInfo localDhcpInfo = this.jdField_a_of_type_AndroidNetWifiWifiManager.getDhcpInfo();
        str1 = str2;
        if (localDhcpInfo != null) {
          str1 = am(localDhcpInfo.gateway);
        }
      }
      return str1;
    }
    catch (Exception localException)
    {
      igd.aJ("SignalStrengthReport", "getGateway e:" + localException);
    }
    return "";
  }
  
  private int mK()
  {
    int j = -1;
    int i = j;
    try
    {
      if (this.mContextReference != null)
      {
        i = j;
        if (this.mContextReference.get() != null)
        {
          Object localObject = EffectConfigBase.i(218, EffectConfigBase.Nk);
          i = j;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            igd.aJ("SignalStrengthReport", "getPingInterval config:" + (String)localObject);
            localObject = new JSONObject((String)localObject);
            i = j;
            if (((JSONObject)localObject).has("pingInterval"))
            {
              i = ((JSONObject)localObject).getInt("pingInterval");
              j = i;
              i = j;
              if (j >= 0)
              {
                i = j;
                if (j < 2000) {
                  return 2000;
                }
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      igd.aJ("SignalStrengthReport", "getPingInterval e:" + localException);
      i = j;
    }
    return i;
  }
  
  int a(SignalStrength paramSignalStrength)
  {
    int j = 100;
    int k = 0;
    int i = 0;
    if (paramSignalStrength != null) {
      i = k;
    }
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          i = Integer.parseInt(Class.forName(SignalStrength.class.getName()).getDeclaredMethod("getLevel", new Class[0]).invoke(paramSignalStrength, new Object[0]).toString());
          k = i * 25;
          i = k;
          if (k > 100)
          {
            i = j;
            return i;
          }
        }
      }
      catch (Exception paramSignalStrength)
      {
        igd.aJ("SignalStrengthReport", "getLevelPercentBySignalStrength reflect getLevel e:" + paramSignalStrength);
        return 0;
      }
    }
  }
  
  /* Error */
  int b(SignalStrength paramSignalStrength)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 4
    //   3: iload 4
    //   5: istore_2
    //   6: aload_1
    //   7: ifnull +78 -> 85
    //   10: ldc 225
    //   12: invokevirtual 230	java/lang/Class:getName	()Ljava/lang/String;
    //   15: invokestatic 234	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   18: ldc_w 256
    //   21: iconst_0
    //   22: anewarray 227	java/lang/Class
    //   25: invokevirtual 240	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   28: aload_1
    //   29: iconst_0
    //   30: anewarray 4	java/lang/Object
    //   33: invokevirtual 246	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   36: invokevirtual 247	java/lang/Object:toString	()Ljava/lang/String;
    //   39: invokestatic 252	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   42: istore_2
    //   43: iload_2
    //   44: iconst_m1
    //   45: if_icmpne +143 -> 188
    //   48: aload_1
    //   49: invokevirtual 259	android/telephony/SignalStrength:isGsm	()Z
    //   52: ifeq +68 -> 120
    //   55: aload_1
    //   56: invokevirtual 262	android/telephony/SignalStrength:getGsmSignalStrength	()I
    //   59: istore_2
    //   60: iload_2
    //   61: istore_3
    //   62: iload_2
    //   63: bipush 99
    //   65: if_icmpne +5 -> 70
    //   68: iconst_m1
    //   69: istore_3
    //   70: iload 4
    //   72: istore_2
    //   73: iload_3
    //   74: iconst_m1
    //   75: if_icmpeq +10 -> 85
    //   78: iload_3
    //   79: iconst_2
    //   80: imul
    //   81: bipush 113
    //   83: isub
    //   84: istore_2
    //   85: iload_2
    //   86: ireturn
    //   87: astore 5
    //   89: ldc 160
    //   91: new 162	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 264
    //   101: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload 5
    //   106: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 178	igd:aJ	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: iconst_m1
    //   116: istore_2
    //   117: goto -74 -> 43
    //   120: aload_1
    //   121: invokevirtual 267	android/telephony/SignalStrength:getCdmaDbm	()I
    //   124: istore 4
    //   126: aload_1
    //   127: invokevirtual 270	android/telephony/SignalStrength:getEvdoDbm	()I
    //   130: istore_3
    //   131: iload_3
    //   132: bipush 136
    //   134: if_icmpne +6 -> 140
    //   137: iload 4
    //   139: ireturn
    //   140: iload_3
    //   141: istore_2
    //   142: iload 4
    //   144: bipush 136
    //   146: if_icmpeq -61 -> 85
    //   149: iload_3
    //   150: istore_2
    //   151: iload 4
    //   153: iload_3
    //   154: if_icmpge -69 -> 85
    //   157: iload 4
    //   159: ireturn
    //   160: astore_1
    //   161: ldc 160
    //   163: new 162	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 272
    //   173: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_1
    //   177: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 178	igd:aJ	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: iconst_m1
    //   187: ireturn
    //   188: iload_2
    //   189: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	jle
    //   0	190	1	paramSignalStrength	SignalStrength
    //   5	184	2	i	int
    //   61	94	3	j	int
    //   1	157	4	k	int
    //   87	18	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   10	43	87	java/lang/Exception
    //   48	60	160	java/lang/Exception
    //   120	131	160	java/lang/Exception
  }
  
  public String hx()
  {
    return this.SK;
  }
  
  public int mG()
  {
    return this.aAZ;
  }
  
  public int mH()
  {
    return this.aAY;
  }
  
  public int mI()
  {
    int j = 0;
    int i = j;
    try
    {
      if (this.jdField_a_of_type_AndroidNetWifiWifiManager != null)
      {
        WifiInfo localWifiInfo = alkz.a(this.jdField_a_of_type_AndroidNetWifiWifiManager);
        i = j;
        if (localWifiInfo.getBSSID() != null)
        {
          i = WifiManager.calculateSignalLevel(localWifiInfo.getRssi(), 5);
          j = i * 25;
          i = j;
          if (j > 100) {
            return 100;
          }
        }
      }
    }
    catch (Exception localException)
    {
      igd.aJ("SignalStrengthReport", "getWifiLevelPercent e:" + localException);
      i = j;
    }
    return i;
  }
  
  public int mJ()
  {
    int j = -1;
    int i = j;
    try
    {
      if (this.jdField_a_of_type_AndroidNetWifiWifiManager != null)
      {
        WifiInfo localWifiInfo = alkz.a(this.jdField_a_of_type_AndroidNetWifiWifiManager);
        i = j;
        if (localWifiInfo != null)
        {
          i = j;
          if (localWifiInfo.getBSSID() != null) {
            i = localWifiInfo.getRssi();
          }
        }
      }
      return i;
    }
    catch (Exception localException)
    {
      igd.aJ("SignalStrengthReport", "getWifiDbm e:" + localException);
    }
    return -1;
  }
  
  public void start()
  {
    if ((this.mThread != null) && (this.mThread.isAlive())) {}
    do
    {
      return;
      igd.aJ("SignalStrengthReport", "report start");
      this.mThread = new HandlerThread("SignalStrengthReportThread" + (int)(Math.random() * 100.0D));
      this.mThread.start();
      this.mHandler = new Handler(this.mThread.getLooper());
      this.aAW = mK();
      this.SK = "";
      if (this.cn != null) {
        this.mHandler.post(this.cn);
      }
      if (this.co != null) {
        this.mHandler.post(this.co);
      }
    } while ((this.jdField_a_of_type_Jle$b == null) || (this.jdField_a_of_type_AndroidTelephonyTelephonyManager == null));
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager.listen(this.jdField_a_of_type_Jle$b, 256);
  }
  
  public void stop()
  {
    if (this.mHandler != null)
    {
      if (this.cn != null) {
        this.mHandler.removeCallbacks(this.cn);
      }
      if (this.co != null) {
        this.mHandler.removeCallbacks(this.co);
      }
      this.mHandler = null;
    }
    this.aAW = -1;
    if ((this.jdField_a_of_type_Jle$b != null) && (this.jdField_a_of_type_AndroidTelephonyTelephonyManager != null)) {
      this.jdField_a_of_type_AndroidTelephonyTelephonyManager.listen(this.jdField_a_of_type_Jle$b, 0);
    }
    if (this.mThread != null)
    {
      this.mThread.quit();
      this.mThread = null;
    }
    this.SK = "";
    igd.aJ("SignalStrengthReport", "report stop");
  }
  
  public static class a
  {
    private static String a(int paramInt1, int paramInt2, String paramString)
    {
      return "/system/bin/ping -c " + paramInt1 + " -w " + paramInt2 + " " + paramString;
    }
    
    public static int ay(String paramString)
    {
      return b(paramString, 1, 1000);
    }
    
    public static int b(String paramString, int paramInt1, int paramInt2)
    {
      paramString = getDomain(paramString);
      if (paramString == null) {}
      do
      {
        return -1;
        paramString = dC(a(paramInt1, paramInt2, paramString));
      } while (paramString == null);
      try
      {
        paramInt1 = Math.round(Float.valueOf(paramString.substring(paramString.indexOf("min/avg/max/mdev") + 19).split("/")[1]).floatValue());
        return paramInt1;
      }
      catch (Exception paramString)
      {
        igd.aJ("SignalStrengthReport", "getAvgRTT e:" + paramString);
      }
      return -1;
    }
    
    /* Error */
    private static String dC(String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: invokestatic 103	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
      //   5: aload_0
      //   6: invokevirtual 107	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
      //   9: astore_1
      //   10: aload_1
      //   11: astore_0
      //   12: aload_1
      //   13: invokevirtual 113	java/lang/Process:getInputStream	()Ljava/io/InputStream;
      //   16: astore_2
      //   17: aload_1
      //   18: astore_0
      //   19: new 115	java/io/BufferedReader
      //   22: dup
      //   23: new 117	java/io/InputStreamReader
      //   26: dup
      //   27: aload_2
      //   28: invokespecial 120	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   31: invokespecial 123	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   34: astore 4
      //   36: aload_1
      //   37: astore_0
      //   38: new 10	java/lang/StringBuilder
      //   41: dup
      //   42: invokespecial 14	java/lang/StringBuilder:<init>	()V
      //   45: astore 5
      //   47: aload_1
      //   48: astore_0
      //   49: aload 4
      //   51: invokevirtual 126	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   54: astore 6
      //   56: aload 6
      //   58: ifnull +67 -> 125
      //   61: aload_1
      //   62: astore_0
      //   63: aload 5
      //   65: aload 6
      //   67: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   70: pop
      //   71: aload_1
      //   72: astore_0
      //   73: aload 5
      //   75: ldc 128
      //   77: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   80: pop
      //   81: goto -34 -> 47
      //   84: astore_2
      //   85: aload_1
      //   86: astore_0
      //   87: ldc 84
      //   89: new 10	java/lang/StringBuilder
      //   92: dup
      //   93: invokespecial 14	java/lang/StringBuilder:<init>	()V
      //   96: ldc 130
      //   98: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   101: aload_2
      //   102: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   105: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   108: invokestatic 95	igd:aJ	(Ljava/lang/String;Ljava/lang/String;)V
      //   111: aload_3
      //   112: astore_0
      //   113: aload_1
      //   114: ifnull +9 -> 123
      //   117: aload_1
      //   118: invokevirtual 133	java/lang/Process:destroy	()V
      //   121: aload_3
      //   122: astore_0
      //   123: aload_0
      //   124: areturn
      //   125: aload_1
      //   126: astore_0
      //   127: aload 4
      //   129: invokevirtual 136	java/io/BufferedReader:close	()V
      //   132: aload_1
      //   133: astore_0
      //   134: aload_2
      //   135: invokevirtual 139	java/io/InputStream:close	()V
      //   138: aload_1
      //   139: astore_0
      //   140: aload 5
      //   142: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   145: astore_2
      //   146: aload_2
      //   147: astore_0
      //   148: aload_1
      //   149: ifnull -26 -> 123
      //   152: aload_1
      //   153: invokevirtual 133	java/lang/Process:destroy	()V
      //   156: aload_2
      //   157: areturn
      //   158: astore_0
      //   159: aconst_null
      //   160: astore_2
      //   161: aload_0
      //   162: astore_1
      //   163: aload_2
      //   164: ifnull +7 -> 171
      //   167: aload_2
      //   168: invokevirtual 133	java/lang/Process:destroy	()V
      //   171: aload_1
      //   172: athrow
      //   173: astore_1
      //   174: aload_0
      //   175: astore_2
      //   176: goto -13 -> 163
      //   179: astore_2
      //   180: aconst_null
      //   181: astore_1
      //   182: goto -97 -> 85
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	185	0	paramString	String
      //   9	163	1	localObject1	Object
      //   173	1	1	localObject2	Object
      //   181	1	1	localObject3	Object
      //   16	12	2	localInputStream	java.io.InputStream
      //   84	51	2	localThrowable1	java.lang.Throwable
      //   145	31	2	str1	String
      //   179	1	2	localThrowable2	java.lang.Throwable
      //   1	121	3	localObject4	Object
      //   34	94	4	localBufferedReader	java.io.BufferedReader
      //   45	96	5	localStringBuilder	java.lang.StringBuilder
      //   54	12	6	str2	String
      // Exception table:
      //   from	to	target	type
      //   12	17	84	java/lang/Throwable
      //   19	36	84	java/lang/Throwable
      //   38	47	84	java/lang/Throwable
      //   49	56	84	java/lang/Throwable
      //   63	71	84	java/lang/Throwable
      //   73	81	84	java/lang/Throwable
      //   127	132	84	java/lang/Throwable
      //   134	138	84	java/lang/Throwable
      //   140	146	84	java/lang/Throwable
      //   2	10	158	finally
      //   12	17	173	finally
      //   19	36	173	finally
      //   38	47	173	finally
      //   49	56	173	finally
      //   63	71	173	finally
      //   73	81	173	finally
      //   87	111	173	finally
      //   127	132	173	finally
      //   134	138	173	finally
      //   140	146	173	finally
      //   2	10	179	java/lang/Throwable
    }
    
    private static String getDomain(String paramString)
    {
      try
      {
        paramString = URI.create(paramString).getHost();
        return paramString;
      }
      catch (Exception paramString)
      {
        igd.aJ("SignalStrengthReport", "getDomain e:" + paramString);
      }
      return null;
    }
  }
  
  class b
    extends PhoneStateListener
  {
    b() {}
    
    public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
    {
      super.onSignalStrengthsChanged(paramSignalStrength);
      jle.this.aAY = jle.this.a(paramSignalStrength);
      jle.this.aAZ = jle.this.b(paramSignalStrength);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jle
 * JD-Core Version:    0.7.0.1
 */