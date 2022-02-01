import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.viola.core.ViolaInstance;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class lci
{
  private static volatile lci jdField_a_of_type_Lci;
  public static int aNg;
  public static int aNh = 1;
  public static int aNi = 2;
  public static int aNj = 3;
  public static int aNk = 4;
  public static int aNl = 5;
  private static volatile boolean aiY;
  private static final LRULinkedHashMap<String, lci.b> d;
  private static final LRULinkedHashMap<String, lci.b> e;
  private static final Object lock = new Object();
  private ViolaInstance jdField_a_of_type_ComTencentViolaCoreViolaInstance;
  protected final lck a;
  protected int aNf = 1;
  private String aep;
  private String aeq;
  private String aer;
  private String aes;
  private boolean aiZ;
  private boolean aja;
  private boolean fV = true;
  private String mBusinessId;
  private String mUrl;
  private long tv;
  
  static
  {
    d = new LRULinkedHashMap(4);
    e = new LRULinkedHashMap(4);
  }
  
  public lci()
  {
    this.jdField_a_of_type_Lck = new lck(new lcj(this));
  }
  
  public static boolean BJ()
  {
    boolean bool = true;
    File localFile = new File(lcl.jg(), "libviola.so");
    if ((!aiY) || (!localFile.exists()))
    {
      kxm.a(kxm.getAppRuntime(), true, 2);
      loadLibrary("other ");
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "native_render [isEngineReady], ret:", Boolean.valueOf(false) });
      }
      bool = false;
    }
    while (!QLog.isColorLevel()) {
      return bool;
    }
    QLog.d("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "native_render [isEngineReady], ret:", Boolean.valueOf(true) });
    return true;
  }
  
  public static lci.b a(String paramString)
  {
    if ((AppSetting.aNT) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("viola.ReadInJoyWebRenderEngine", 2, "native_render  getRenderHtmlData url : " + paramString);
    }
    synchronized (lock)
    {
      localb = (lci.b)d.get(paramString);
      if (localb != null)
      {
        paramString = localb;
        if (localb.isExpired()) {
          paramString = null;
        }
        return paramString;
      }
    }
    lci.b localb = (lci.b)e.get(paramString);
    if (localb != null)
    {
      paramString = localb;
      if (localb.isExpired()) {}
    }
    for (;;)
    {
      return paramString;
      paramString = null;
    }
  }
  
  public static lci a()
  {
    if (jdField_a_of_type_Lci == null) {
      jdField_a_of_type_Lci = new lci();
    }
    return jdField_a_of_type_Lci;
  }
  
  /* Error */
  public static void a(String paramString, lci.a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 101	lci:aiY	Z
    //   6: ifeq +20 -> 26
    //   9: aload_1
    //   10: ifnull +12 -> 22
    //   13: aload_1
    //   14: getstatic 67	lci:aNl	I
    //   17: invokeinterface 185 2 0
    //   22: ldc 2
    //   24: monitorexit
    //   25: return
    //   26: invokestatic 191	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   29: new 193	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyWebRenderEngine$3
    //   32: dup
    //   33: aload_1
    //   34: aload_0
    //   35: invokespecial 196	com/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyWebRenderEngine$3:<init>	(Llci$a;Ljava/lang/String;)V
    //   38: invokevirtual 202	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   41: pop
    //   42: goto -20 -> 22
    //   45: astore_0
    //   46: ldc 2
    //   48: monitorexit
    //   49: aload_0
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	paramString	String
    //   0	51	1	parama	lci.a
    // Exception table:
    //   from	to	target	type
    //   3	9	45	finally
    //   13	22	45	finally
    //   26	42	45	finally
  }
  
  public static void aJN()
  {
    if (!awit.D(kxm.getAppRuntime())) {
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "preWebRenderLoadSo [getWebRenderConfig], is:", Boolean.valueOf(false) });
      }
    }
    for (;;)
    {
      if (ntp.Gg()) {
        ntp.preInit();
      }
      return;
      if (!aiY) {
        loadLibrary("preload");
      } else if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "preWebRenderLoadSo [sLoadEngineLibDone], is:", Boolean.valueOf(true) });
      }
    }
  }
  
  public static void aJO() {}
  
  private void aJP()
  {
    this.mUrl = "";
    this.aer = "";
    this.aes = "";
    this.aeq = "";
    this.aep = "";
  }
  
  public static void loadLibrary(String paramString)
  {
    try
    {
      a(paramString, null);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void qD(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("viola.ReadInJoyWebRenderEngine", 2, new Object[] { "[notifyLibLoad], ret:", Integer.valueOf(paramInt) });
    }
  }
  
  public int a(Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(this.aer))
    {
      if (!this.aiZ) {
        break label131;
      }
      e.put(this.mUrl, new lci.b(this.aer, "utf-8", 1800000L));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("viola.ReadInJoyWebRenderEngine", 1, "native_render one result total cost[" + (System.currentTimeMillis() - this.tv) + " ms]");
      }
      kxm.a(kxm.getAppRuntime(), true, 8);
      kxm.a(kxm.getAppRuntime(), true, 12, System.currentTimeMillis() - this.tv);
      aJP();
      aJM();
      this.aNf = 1;
      return -1;
      label131:
      d.put(this.mUrl, new lci.b(this.aer, "utf-8"));
    }
  }
  
  public void aJM()
  {
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null)
    {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.destroy();
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance = null;
    }
    this.fV = true;
  }
  
  public int c(Bundle paramBundle)
  {
    kxm.a(kxm.getAppRuntime(), true, 9);
    this.aNf = 11;
    return -1;
  }
  
  public int d(Bundle paramBundle)
  {
    Uri.parse(this.mUrl).getQueryParameter("_prenr");
    if ((!this.aja) && (a(this.mUrl) != null))
    {
      this.aNf = 10;
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 1, "native_render doCreateLoopStep_Check has url cache");
      }
    }
    for (;;)
    {
      return 0;
      this.aNf = 4;
    }
  }
  
  @Deprecated
  public int e(Bundle paramBundle)
  {
    return 0;
  }
  
  @Deprecated
  public int f(Bundle paramBundle)
  {
    return 0;
  }
  
  @Deprecated
  public int g(Bundle paramBundle)
  {
    return 0;
  }
  
  @Deprecated
  public int h(Bundle paramBundle)
  {
    return 0;
  }
  
  public int i(Bundle paramBundle)
  {
    Object localObject = this.mUrl.replace("_pbid", "_bid");
    if (arcm.rT((String)localObject))
    {
      localObject = arcm.a((String)localObject);
      if ((localObject != null) && (!TextUtils.isEmpty(((arcm.a)localObject).data))) {
        this.aer = ((arcm.a)localObject).data;
      }
    }
    while (TextUtils.isEmpty(this.aer))
    {
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 2, "native_render doCreateLoopStep_GetHtml mHtmlOffline is empty");
      }
      kxm.a(kxm.getAppRuntime(), true, 7);
      return c(paramBundle);
      localObject = jpa.a(this.mBusinessId, this.mUrl);
      if (localObject != null) {
        try
        {
          int i = ((jpa.a)localObject).g.available();
          if (i != 0)
          {
            byte[] arrayOfByte = new byte[i];
            if (i == ((jpa.a)localObject).g.read(arrayOfByte)) {
              this.aer = new String(arrayOfByte, "utf-8");
            }
          }
        }
        catch (IOException localIOException)
        {
          return c(paramBundle);
        }
      }
    }
    this.aNf = 8;
    return 0;
  }
  
  public boolean isFinish()
  {
    return this.fV;
  }
  
  public int j(Bundle paramBundle)
  {
    String str1 = "<!--native-render-->";
    String str3 = "<!--native-data-render-->";
    String str2 = "renderData";
    this.aes = "true;";
    String str4 = str1;
    String str5 = str2;
    String str6 = str3;
    if (paramBundle != null)
    {
      if (!TextUtils.isEmpty(paramBundle.getString(nuf.anI))) {
        str1 = paramBundle.getString(nuf.anI);
      }
      if (!TextUtils.isEmpty(paramBundle.getString(nuf.anM))) {
        str2 = paramBundle.getString(nuf.anM);
      }
      if (!TextUtils.isEmpty(paramBundle.getString(nuf.anK))) {
        str3 = paramBundle.getString(nuf.anK);
      }
      str4 = str1;
      str5 = str2;
      str6 = str3;
      if (!TextUtils.isEmpty(paramBundle.getString(nuf.anL)))
      {
        this.aes = paramBundle.getString(nuf.anL);
        str6 = str3;
        str5 = str2;
        str4 = str1;
      }
    }
    this.aer = this.aer.replaceFirst(str4, this.aeq);
    this.aer = this.aer.replaceFirst(str6, "var " + str5 + " = " + this.aes + ";");
    this.aNf = 9;
    return 0;
  }
  
  public int k(Bundle paramBundle)
  {
    kxm.a(kxm.getAppRuntime(), true, 3);
    aJP();
    aJM();
    this.aNf = 1;
    return -1;
  }
  
  public int l(Bundle paramBundle)
  {
    aJP();
    aJM();
    this.aNf = 1;
    return -1;
  }
  
  public static abstract interface a
  {
    public abstract void onError(int paramInt);
    
    public abstract void onFinish(int paramInt);
  }
  
  public static class b
  {
    final long cacheTime;
    public final String data;
    public final String encoding;
    long expireTime;
    
    b(String paramString1, String paramString2)
    {
      this.data = paramString1;
      this.encoding = paramString2;
      this.cacheTime = SystemClock.elapsedRealtime();
    }
    
    b(String paramString1, String paramString2, long paramLong)
    {
      this.data = paramString1;
      this.encoding = paramString2;
      this.cacheTime = SystemClock.elapsedRealtime();
      this.expireTime = paramLong;
    }
    
    boolean isExpired()
    {
      if (this.expireTime > 0L) {
        if (SystemClock.elapsedRealtime() - this.cacheTime <= this.expireTime) {}
      }
      while (SystemClock.elapsedRealtime() - this.cacheTime > 300000L)
      {
        return true;
        return false;
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lci
 * JD-Core Version:    0.7.0.1
 */