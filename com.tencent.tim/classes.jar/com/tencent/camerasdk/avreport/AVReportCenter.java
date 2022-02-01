package com.tencent.camerasdk.avreport;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.Object;>;
import java.util.Set;

public class AVReportCenter
{
  private static final String TAG = "AVReportCenter-" + Integer.toHexString(AVReportCenter.class.hashCode());
  private static final AVReportCenter ourInstance = new AVReportCenter();
  private String app;
  private Boolean auto = Boolean.valueOf(true);
  private Context context;
  private String dir;
  private boolean enable = true;
  private String imei;
  private volatile Handler ioHandler;
  private volatile HandlerThread ioThread;
  private String os;
  private Reporter reporter;
  private String tmpDir;
  
  public static AVReportCenter getInstance()
  {
    return ourInstance;
  }
  
  private void hibernate(String paramString)
  {
    hibernate(paramString, "bean");
  }
  
  private void hibernate(String paramString1, String paramString2)
  {
    if ((this.dir == null) || (this.dir.length() == 0))
    {
      LogUtils.e(TAG, "hibernate: dir is empty");
      return;
    }
    try
    {
      File localFile = new File(this.tmpDir + File.separator + paramString2 + "." + System.nanoTime());
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      localFileOutputStream.write(paramString1.getBytes());
      localFileOutputStream.close();
      localFile.renameTo(new File(this.dir + File.separator + paramString2 + "." + System.nanoTime()));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private static String toUrlParams(Map<String, Object> paramMap)
  {
    Object localObject1 = "attaid=06400000136&token=3598698434";
    Iterator localIterator = paramMap.entrySet().iterator();
    paramMap = (Map<String, Object>)localObject1;
    if (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      localObject1 = ((Map.Entry)localObject2).getValue();
      localObject2 = (String)((Map.Entry)localObject2).getKey();
      if ((localObject1 instanceof Number)) {
        paramMap = paramMap + "&" + (String)localObject2 + "=" + localObject1.toString();
      }
      for (;;)
      {
        break;
        if ((localObject1 instanceof String)) {
          try
          {
            localObject1 = paramMap + "&" + (String)localObject2 + "=" + URLEncoder.encode(localObject1.toString(), "UTF-8");
            paramMap = (Map<String, Object>)localObject1;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
        }
      }
    }
    return paramMap;
  }
  
  public void commit(BaseBean paramBaseBean)
  {
    commit(paramBaseBean, Boolean.valueOf(false));
  }
  
  public void commit(BaseBean paramBaseBean, Boolean paramBoolean)
  {
    if (!this.enable) {}
    while (this.ioHandler == null) {
      return;
    }
    this.ioHandler.post(new AVReportCenter.2(this, paramBaseBean, paramBoolean));
  }
  
  public void flush()
  {
    if (this.ioHandler != null) {
      this.ioHandler.post(new AVReportCenter.3(this));
    }
  }
  
  /* Error */
  public void init(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 246	com/tencent/camerasdk/avreport/AVReportCenter:context	Landroid/content/Context;
    //   5: aload_0
    //   6: getfield 225	com/tencent/camerasdk/avreport/AVReportCenter:ioHandler	Landroid/os/Handler;
    //   9: ifnonnull +16 -> 25
    //   12: ldc 2
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 225	com/tencent/camerasdk/avreport/AVReportCenter:ioHandler	Landroid/os/Handler;
    //   19: ifnull +7 -> 26
    //   22: ldc 2
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: new 29	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   34: aload_0
    //   35: getfield 246	com/tencent/camerasdk/avreport/AVReportCenter:context	Landroid/content/Context;
    //   38: invokestatic 252	com/tencent/camerasdk/avreport/DeviceInfo:getRomFingerprint	(Landroid/content/Context;)Ljava/lang/String;
    //   41: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokestatic 255	com/tencent/camerasdk/avreport/DeviceInfo:getApiLevelInt	()I
    //   47: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: putfield 90	com/tencent/camerasdk/avreport/AVReportCenter:os	Ljava/lang/String;
    //   56: aload_0
    //   57: aload_0
    //   58: getfield 246	com/tencent/camerasdk/avreport/AVReportCenter:context	Landroid/content/Context;
    //   61: invokestatic 263	com/tencent/camerasdk/avreport/AppInfo:getPackageName	(Landroid/content/Context;)Ljava/lang/String;
    //   64: putfield 93	com/tencent/camerasdk/avreport/AVReportCenter:app	Ljava/lang/String;
    //   67: aload_0
    //   68: new 29	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   75: aload_0
    //   76: getfield 246	com/tencent/camerasdk/avreport/AVReportCenter:context	Landroid/content/Context;
    //   79: invokevirtual 269	android/content/Context:getExternalCacheDir	()Ljava/io/File;
    //   82: invokevirtual 272	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   85: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: getstatic 130	java/io/File:separator	Ljava/lang/String;
    //   91: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc_w 274
    //   97: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: getstatic 130	java/io/File:separator	Ljava/lang/String;
    //   103: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc_w 276
    //   109: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: putfield 73	com/tencent/camerasdk/avreport/AVReportCenter:dir	Ljava/lang/String;
    //   118: new 127	java/io/File
    //   121: dup
    //   122: aload_0
    //   123: getfield 73	com/tencent/camerasdk/avreport/AVReportCenter:dir	Ljava/lang/String;
    //   126: invokespecial 143	java/io/File:<init>	(Ljava/lang/String;)V
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 279	java/io/File:exists	()Z
    //   134: ifne +8 -> 142
    //   137: aload_1
    //   138: invokevirtual 282	java/io/File:mkdirs	()Z
    //   141: pop
    //   142: aload_0
    //   143: new 29	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   150: aload_0
    //   151: getfield 246	com/tencent/camerasdk/avreport/AVReportCenter:context	Landroid/content/Context;
    //   154: invokevirtual 269	android/content/Context:getExternalCacheDir	()Ljava/io/File;
    //   157: invokevirtual 272	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   160: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: getstatic 130	java/io/File:separator	Ljava/lang/String;
    //   166: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc_w 274
    //   172: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: getstatic 130	java/io/File:separator	Ljava/lang/String;
    //   178: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: ldc_w 284
    //   184: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: putfield 76	com/tencent/camerasdk/avreport/AVReportCenter:tmpDir	Ljava/lang/String;
    //   193: new 127	java/io/File
    //   196: dup
    //   197: aload_0
    //   198: getfield 76	com/tencent/camerasdk/avreport/AVReportCenter:tmpDir	Ljava/lang/String;
    //   201: invokespecial 143	java/io/File:<init>	(Ljava/lang/String;)V
    //   204: astore_1
    //   205: aload_1
    //   206: invokevirtual 279	java/io/File:exists	()Z
    //   209: ifne +8 -> 217
    //   212: aload_1
    //   213: invokevirtual 282	java/io/File:mkdirs	()Z
    //   216: pop
    //   217: aload_0
    //   218: aload_0
    //   219: getfield 246	com/tencent/camerasdk/avreport/AVReportCenter:context	Landroid/content/Context;
    //   222: invokevirtual 288	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   225: ldc_w 290
    //   228: invokestatic 296	alla:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   231: putfield 87	com/tencent/camerasdk/avreport/AVReportCenter:imei	Ljava/lang/String;
    //   234: aload_0
    //   235: new 298	android/os/HandlerThread
    //   238: dup
    //   239: getstatic 54	com/tencent/camerasdk/avreport/AVReportCenter:TAG	Ljava/lang/String;
    //   242: invokespecial 299	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   245: putfield 301	com/tencent/camerasdk/avreport/AVReportCenter:ioThread	Landroid/os/HandlerThread;
    //   248: aload_0
    //   249: getfield 301	com/tencent/camerasdk/avreport/AVReportCenter:ioThread	Landroid/os/HandlerThread;
    //   252: iconst_1
    //   253: invokevirtual 305	android/os/HandlerThread:setDaemon	(Z)V
    //   256: aload_0
    //   257: getfield 301	com/tencent/camerasdk/avreport/AVReportCenter:ioThread	Landroid/os/HandlerThread;
    //   260: invokevirtual 308	android/os/HandlerThread:start	()V
    //   263: aload_0
    //   264: getfield 301	com/tencent/camerasdk/avreport/AVReportCenter:ioThread	Landroid/os/HandlerThread;
    //   267: invokevirtual 311	android/os/HandlerThread:isAlive	()Z
    //   270: ifeq -7 -> 263
    //   273: aload_0
    //   274: new 232	android/os/Handler
    //   277: dup
    //   278: aload_0
    //   279: getfield 301	com/tencent/camerasdk/avreport/AVReportCenter:ioThread	Landroid/os/HandlerThread;
    //   282: invokevirtual 315	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   285: invokespecial 318	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   288: putfield 225	com/tencent/camerasdk/avreport/AVReportCenter:ioHandler	Landroid/os/Handler;
    //   291: aload_0
    //   292: getfield 225	com/tencent/camerasdk/avreport/AVReportCenter:ioHandler	Landroid/os/Handler;
    //   295: new 320	com/tencent/camerasdk/avreport/AVReportCenter$1
    //   298: dup
    //   299: aload_0
    //   300: invokespecial 321	com/tencent/camerasdk/avreport/AVReportCenter$1:<init>	(Lcom/tencent/camerasdk/avreport/AVReportCenter;)V
    //   303: invokevirtual 236	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   306: pop
    //   307: ldc 2
    //   309: monitorexit
    //   310: return
    //   311: astore_1
    //   312: ldc 2
    //   314: monitorexit
    //   315: aload_1
    //   316: athrow
    //   317: astore_1
    //   318: aload_1
    //   319: invokevirtual 166	java/lang/Exception:printStackTrace	()V
    //   322: aload_0
    //   323: ldc_w 323
    //   326: putfield 87	com/tencent/camerasdk/avreport/AVReportCenter:imei	Ljava/lang/String;
    //   329: goto -95 -> 234
    //   332: astore_1
    //   333: aload_1
    //   334: invokevirtual 166	java/lang/Exception:printStackTrace	()V
    //   337: ldc 2
    //   339: monitorexit
    //   340: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	this	AVReportCenter
    //   0	341	1	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   15	25	311	finally
    //   26	142	311	finally
    //   142	217	311	finally
    //   217	234	311	finally
    //   234	263	311	finally
    //   263	310	311	finally
    //   312	315	311	finally
    //   318	329	311	finally
    //   333	340	311	finally
    //   217	234	317	java/lang/Exception
    //   26	142	332	java/lang/Exception
    //   142	217	332	java/lang/Exception
    //   318	329	332	java/lang/Exception
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.camerasdk.avreport.AVReportCenter
 * JD-Core Version:    0.7.0.1
 */