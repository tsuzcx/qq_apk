package com.tencent.mobileqq.vashealth;

import ahbj;
import ailu;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import anpc;
import aqge;
import aqtl;
import aqtq;
import aqtr;
import aqts;
import aqtu;
import aqtv;
import aquz;
import aqva;
import aqvc;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginInterface;
import com.tencent.mobileqq.pluginsdk.PluginInterfaceHelper;
import com.tencent.mobileqq.pluginsdk.PluginInterfaceHelper.OnPluginInterfaceLoadedListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.pb.qqsport.QQSportsOrbit.OrbitHeader;
import tencent.im.pb.qqsport.QQSportsOrbit.OrbitPacePoint;
import tencent.im.pb.qqsport.QQSportsOrbit.OrbitPoint;
import tencent.im.pb.qqsport.QQSportsOrbit.OrbitReq;

public class PathTraceManager
  implements Manager
{
  public static MediaPlayer d;
  public static int ecE = -1;
  public static int ecF = -2;
  private static int ecI;
  private static int ecK = 50;
  private static int ecL = 100;
  private static int ecM = 30;
  public ArrayList<TracePointsData> Dd = new ArrayList();
  public long Fo;
  private List<TracePointsData> Jf = new ArrayList(4);
  BrowserAppInterface jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface;
  private PluginInterfaceHelper.OnPluginInterfaceLoadedListener jdField_a_of_type_ComTencentMobileqqPluginsdkPluginInterfaceHelper$OnPluginInterfaceLoadedListener;
  private a jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager$a;
  private TracePathData jdField_a_of_type_ComTencentMobileqqVashealthTracePathData;
  private TracePointsData jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData;
  aqva jdField_b_of_type_Aqva;
  aqvc jdField_b_of_type_Aqvc;
  private PluginInterface c;
  public boolean cVZ;
  public boolean cWa;
  boolean cWb = true;
  private boolean cWc = true;
  private String cwZ;
  SensorEventListener jdField_d_of_type_AndroidHardwareSensorEventListener;
  SensorManager jdField_d_of_type_AndroidHardwareSensorManager;
  public boolean debug = false;
  private int ecD;
  private int ecG;
  private int ecH;
  private int ecJ;
  public WeakReference<aqtl> iy;
  EntityManager mEntityManager;
  public boolean mIsMute;
  private int mType;
  public Handler mUIHandler = new aqtu(this, Looper.getMainLooper());
  public long mUploadTime;
  Sensor n;
  
  public PathTraceManager(BrowserAppInterface paramBrowserAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = paramBrowserAppInterface;
    this.mEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getEntityManagerFactory().createEntityManager();
    this.ecD = -1;
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginInterfaceHelper$OnPluginInterfaceLoadedListener = new aqtq(this);
    PluginInterfaceHelper.getPluginInterface(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginInterfaceHelper$OnPluginInterfaceLoadedListener);
    this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData = b();
    paramBrowserAppInterface = new StringBuilder(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApp().getFilesDir().getPath());
    paramBrowserAppInterface.append("/QQSportVoice/");
    this.cwZ = paramBrowserAppInterface.toString();
    VG(null);
    this.jdField_d_of_type_AndroidHardwareSensorManager = ((SensorManager)this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApp().getApplicationContext().getSystemService("sensor"));
    this.n = this.jdField_d_of_type_AndroidHardwareSensorManager.getDefaultSensor(19);
    this.jdField_d_of_type_AndroidHardwareSensorEventListener = new aqtr(this);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("path:");
      if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData == null) {
        break label249;
      }
    }
    label249:
    for (paramBrowserAppInterface = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData;; paramBrowserAppInterface = "null")
    {
      QLog.i("PathTraceManager", 2, paramBrowserAppInterface);
      return;
    }
  }
  
  private JSONObject a(TracePointsData paramTracePointsData)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retCode", 1);
      localJSONObject.put("data", paramTracePointsData.toJson().toString());
      localJSONObject.put("isBeforeRunning", "true");
      if (this.iy != null)
      {
        paramTracePointsData = (aqtl)this.iy.get();
        if (paramTracePointsData != null) {
          paramTracePointsData.dispatchJsEvent("PathTraceSend", localJSONObject, new JSONObject());
        }
      }
      return localJSONObject;
    }
    catch (Exception paramTracePointsData) {}
    return localJSONObject;
  }
  
  private void a(ArrayList<String> paramArrayList, double paramDouble)
  {
    paramDouble /= Float.valueOf(1000.0F).floatValue();
    if (k(paramDouble) != null)
    {
      paramArrayList.add(k(paramDouble));
      paramArrayList.add("100");
    }
    if (l(paramDouble) != null)
    {
      paramArrayList.add(l(paramDouble));
      paramArrayList.add("10");
    }
    if (m(paramDouble) != null) {
      paramArrayList.add(m(paramDouble));
    }
    paramArrayList.add("d");
    if (n(paramDouble) != null) {
      paramArrayList.add(n(paramDouble));
    }
    if (o(paramDouble) != null) {
      paramArrayList.add(o(paramDouble));
    }
    paramArrayList.add("km");
  }
  
  /* Error */
  public static void fh(ArrayList<Uri> paramArrayList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aload 6
    //   10: astore 4
    //   12: aload 5
    //   14: astore_2
    //   15: getstatic 342	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_d_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   18: ifnull +66 -> 84
    //   21: aload 6
    //   23: astore 4
    //   25: aload 5
    //   27: astore_2
    //   28: getstatic 342	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_d_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   31: invokevirtual 347	android/media/MediaPlayer:isPlaying	()Z
    //   34: istore_1
    //   35: iload_1
    //   36: ifeq +22 -> 58
    //   39: iconst_0
    //   40: ifeq +11 -> 51
    //   43: new 349	java/lang/NullPointerException
    //   46: dup
    //   47: invokespecial 350	java/lang/NullPointerException:<init>	()V
    //   50: athrow
    //   51: return
    //   52: astore_0
    //   53: aload_0
    //   54: invokevirtual 353	java/io/IOException:printStackTrace	()V
    //   57: return
    //   58: aload 6
    //   60: astore 4
    //   62: aload 5
    //   64: astore_2
    //   65: getstatic 342	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_d_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   68: ifnull +16 -> 84
    //   71: aload 6
    //   73: astore 4
    //   75: aload 5
    //   77: astore_2
    //   78: getstatic 342	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_d_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   81: invokevirtual 356	android/media/MediaPlayer:release	()V
    //   84: aload 6
    //   86: astore 4
    //   88: aload 5
    //   90: astore_2
    //   91: iconst_0
    //   92: putstatic 332	com/tencent/mobileqq/vashealth/PathTraceManager:ecI	I
    //   95: aload 6
    //   97: astore 4
    //   99: aload 5
    //   101: astore_2
    //   102: aload_0
    //   103: getstatic 332	com/tencent/mobileqq/vashealth/PathTraceManager:ecI	I
    //   106: invokevirtual 359	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   109: checkcast 361	android/net/Uri
    //   112: astore 7
    //   114: aload 6
    //   116: astore 4
    //   118: aload 5
    //   120: astore_2
    //   121: aload 7
    //   123: invokevirtual 364	android/net/Uri:getScheme	()Ljava/lang/String;
    //   126: ldc_w 366
    //   129: invokevirtual 371	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   132: ifeq +63 -> 195
    //   135: aload 6
    //   137: astore 4
    //   139: aload 5
    //   141: astore_2
    //   142: new 344	android/media/MediaPlayer
    //   145: dup
    //   146: invokespecial 372	android/media/MediaPlayer:<init>	()V
    //   149: putstatic 342	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_d_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   152: aload 6
    //   154: astore 4
    //   156: aload 5
    //   158: astore_2
    //   159: new 374	java/io/FileInputStream
    //   162: dup
    //   163: new 161	java/io/File
    //   166: dup
    //   167: aload 7
    //   169: invokevirtual 375	android/net/Uri:getPath	()Ljava/lang/String;
    //   172: invokespecial 376	java/io/File:<init>	(Ljava/lang/String;)V
    //   175: invokespecial 379	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   178: astore_3
    //   179: getstatic 342	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_d_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   182: aload_3
    //   183: invokevirtual 383	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   186: invokevirtual 387	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   189: getstatic 342	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_d_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   192: invokevirtual 390	android/media/MediaPlayer:prepare	()V
    //   195: aload_3
    //   196: astore 4
    //   198: aload_3
    //   199: astore_2
    //   200: getstatic 342	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_d_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   203: astore 5
    //   205: aload 5
    //   207: ifnonnull +18 -> 225
    //   210: aload_3
    //   211: ifnull -160 -> 51
    //   214: aload_3
    //   215: invokevirtual 393	java/io/FileInputStream:close	()V
    //   218: return
    //   219: astore_0
    //   220: aload_0
    //   221: invokevirtual 353	java/io/IOException:printStackTrace	()V
    //   224: return
    //   225: aload_3
    //   226: astore 4
    //   228: aload_3
    //   229: astore_2
    //   230: getstatic 342	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_d_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   233: new 395	aqtt
    //   236: dup
    //   237: aload_0
    //   238: invokespecial 397	aqtt:<init>	(Ljava/util/ArrayList;)V
    //   241: invokevirtual 401	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   244: aload_3
    //   245: astore 4
    //   247: aload_3
    //   248: astore_2
    //   249: getstatic 342	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_d_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   252: invokevirtual 404	android/media/MediaPlayer:start	()V
    //   255: aload_3
    //   256: astore 4
    //   258: aload_3
    //   259: astore_2
    //   260: getstatic 342	com/tencent/mobileqq/vashealth/PathTraceManager:jdField_d_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   263: iconst_0
    //   264: invokevirtual 408	android/media/MediaPlayer:setLooping	(Z)V
    //   267: aload_3
    //   268: ifnull -217 -> 51
    //   271: aload_3
    //   272: invokevirtual 393	java/io/FileInputStream:close	()V
    //   275: return
    //   276: astore_0
    //   277: aload_0
    //   278: invokevirtual 353	java/io/IOException:printStackTrace	()V
    //   281: return
    //   282: astore_0
    //   283: aload 4
    //   285: astore_2
    //   286: aload_0
    //   287: invokevirtual 409	java/lang/Exception:printStackTrace	()V
    //   290: aload 4
    //   292: ifnull -241 -> 51
    //   295: aload 4
    //   297: invokevirtual 393	java/io/FileInputStream:close	()V
    //   300: return
    //   301: astore_0
    //   302: aload_0
    //   303: invokevirtual 353	java/io/IOException:printStackTrace	()V
    //   306: return
    //   307: astore_0
    //   308: aload_2
    //   309: ifnull +7 -> 316
    //   312: aload_2
    //   313: invokevirtual 393	java/io/FileInputStream:close	()V
    //   316: aload_0
    //   317: athrow
    //   318: astore_2
    //   319: aload_2
    //   320: invokevirtual 353	java/io/IOException:printStackTrace	()V
    //   323: goto -7 -> 316
    //   326: astore_0
    //   327: aload_3
    //   328: astore_2
    //   329: goto -21 -> 308
    //   332: astore_0
    //   333: aload_3
    //   334: astore 4
    //   336: goto -53 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	paramArrayList	ArrayList<Uri>
    //   34	2	1	bool	boolean
    //   14	299	2	localObject1	Object
    //   318	2	2	localIOException	java.io.IOException
    //   328	1	2	localFileInputStream1	java.io.FileInputStream
    //   7	327	3	localFileInputStream2	java.io.FileInputStream
    //   10	325	4	localObject2	Object
    //   4	202	5	localMediaPlayer	MediaPlayer
    //   1	152	6	localObject3	Object
    //   112	56	7	localUri	Uri
    // Exception table:
    //   from	to	target	type
    //   43	51	52	java/io/IOException
    //   214	218	219	java/io/IOException
    //   271	275	276	java/io/IOException
    //   15	21	282	java/lang/Exception
    //   28	35	282	java/lang/Exception
    //   65	71	282	java/lang/Exception
    //   78	84	282	java/lang/Exception
    //   91	95	282	java/lang/Exception
    //   102	114	282	java/lang/Exception
    //   121	135	282	java/lang/Exception
    //   142	152	282	java/lang/Exception
    //   159	179	282	java/lang/Exception
    //   200	205	282	java/lang/Exception
    //   230	244	282	java/lang/Exception
    //   249	255	282	java/lang/Exception
    //   260	267	282	java/lang/Exception
    //   295	300	301	java/io/IOException
    //   15	21	307	finally
    //   28	35	307	finally
    //   65	71	307	finally
    //   78	84	307	finally
    //   91	95	307	finally
    //   102	114	307	finally
    //   121	135	307	finally
    //   142	152	307	finally
    //   159	179	307	finally
    //   200	205	307	finally
    //   230	244	307	finally
    //   249	255	307	finally
    //   260	267	307	finally
    //   286	290	307	finally
    //   312	316	318	java/io/IOException
    //   179	195	326	finally
    //   179	195	332	java/lang/Exception
  }
  
  /* Error */
  public static byte[] gzip(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 416	java/io/ByteArrayOutputStream
    //   6: dup
    //   7: aload_0
    //   8: arraylength
    //   9: invokespecial 417	java/io/ByteArrayOutputStream:<init>	(I)V
    //   12: astore_2
    //   13: aload_2
    //   14: astore_1
    //   15: new 419	java/util/zip/GZIPOutputStream
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 422	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   23: astore_3
    //   24: aload_2
    //   25: astore_1
    //   26: aload_3
    //   27: aload_0
    //   28: invokevirtual 426	java/util/zip/GZIPOutputStream:write	([B)V
    //   31: aload_2
    //   32: astore_1
    //   33: aload_3
    //   34: invokevirtual 429	java/util/zip/GZIPOutputStream:finish	()V
    //   37: aload_2
    //   38: astore_1
    //   39: aload_3
    //   40: invokevirtual 432	java/util/zip/GZIPOutputStream:flush	()V
    //   43: aload_2
    //   44: astore_1
    //   45: aload_3
    //   46: invokevirtual 433	java/util/zip/GZIPOutputStream:close	()V
    //   49: aload 4
    //   51: astore_1
    //   52: aload_2
    //   53: ifnull +8 -> 61
    //   56: aload_2
    //   57: invokevirtual 437	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   60: astore_1
    //   61: aload_1
    //   62: areturn
    //   63: astore_3
    //   64: aconst_null
    //   65: astore_0
    //   66: aload_0
    //   67: astore_1
    //   68: ldc 220
    //   70: iconst_1
    //   71: aload_3
    //   72: iconst_0
    //   73: anewarray 4	java/lang/Object
    //   76: invokestatic 441	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   79: aload 4
    //   81: astore_1
    //   82: aload_0
    //   83: ifnull -22 -> 61
    //   86: aload_0
    //   87: invokevirtual 437	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   90: areturn
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_0
    //   94: aload 4
    //   96: astore_1
    //   97: aload_0
    //   98: ifnull -37 -> 61
    //   101: aload_0
    //   102: invokevirtual 437	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   105: areturn
    //   106: astore_0
    //   107: aload_1
    //   108: astore_0
    //   109: goto -15 -> 94
    //   112: astore_3
    //   113: aload_2
    //   114: astore_0
    //   115: goto -49 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramArrayOfByte	byte[]
    //   14	94	1	localObject1	Object
    //   12	102	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   23	23	3	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   63	9	3	localThrowable1	Throwable
    //   112	1	3	localThrowable2	Throwable
    //   1	94	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	63	java/lang/Throwable
    //   3	13	91	finally
    //   15	24	106	finally
    //   26	31	106	finally
    //   33	37	106	finally
    //   39	43	106	finally
    //   45	49	106	finally
    //   68	79	106	finally
    //   15	24	112	java/lang/Throwable
    //   26	31	112	java/lang/Throwable
    //   33	37	112	java/lang/Throwable
    //   39	43	112	java/lang/Throwable
    //   45	49	112	java/lang/Throwable
  }
  
  private void ne(List<TracePointsData> paramList)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("retCode", 0);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("distance", this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance);
      localJSONObject2.put("totalTime", this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime);
      localJSONObject2.put("totalSteps", this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalSteps);
      JSONArray localJSONArray = new JSONArray();
      if (paramList != null)
      {
        int i = 0;
        while (i < paramList.size())
        {
          localJSONArray.put(((TracePointsData)paramList.get(i)).toJson());
          i += 1;
        }
      }
      localJSONObject2.put("tracePath", localJSONArray);
      localJSONObject1.put("data", localJSONObject2.toString());
      if (this.iy != null)
      {
        paramList = (aqtl)this.iy.get();
        if (paramList != null) {
          paramList.dispatchJsEvent("PathTraceSend", localJSONObject1, new JSONObject());
        }
      }
      return;
    }
    catch (Exception paramList)
    {
      QLog.d("PathTraceManager", 1, "draw Err");
    }
  }
  
  public JSONObject B(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        paramString = a(Long.parseLong(new JSONObject(paramString).getString("startTime")));
        if (paramString != null)
        {
          long l = paramString.startTime;
          localJSONObject1.put("startTime", paramString.startTime);
          localJSONObject1.put("endTime", paramString.endTime);
          localJSONObject1.put("totalTime", paramString.totalTime);
          localJSONObject1.put("distance", paramString.distance);
          localJSONObject1.put("type", paramString.type);
          localJSONObject1.put("totalSteps", paramString.totalSteps);
          localJSONObject1.put("stepsGoal", paramString.stepsGoal);
          paramString = k(Long.parseLong(String.valueOf(l)));
          if ((paramString == null) || (paramString.size() <= 0)) {
            break;
          }
          paramString = paramString.iterator();
          if (!paramString.hasNext()) {
            break;
          }
          TracePointsData localTracePointsData = (TracePointsData)paramString.next();
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("time", localTracePointsData.time);
          localJSONObject2.put("longitude", localTracePointsData.longitude);
          localJSONObject2.put("latitude", localTracePointsData.latitude);
          localJSONObject2.put("altitude", localTracePointsData.altitude);
          localJSONObject2.put("speed", localTracePointsData.speed);
          localJSONObject2.put("accuracy", localTracePointsData.accuracy);
          localJSONObject2.put("steps", localTracePointsData.steps);
          localJSONArray.put(localJSONObject2);
          continue;
        }
        return localJSONObject1;
      }
      catch (Exception paramString)
      {
        QLog.d("PathTraceManager", 1, "queryPathData Err");
      }
      paramString = b();
    }
    localJSONObject1.put("data", localJSONArray);
    return localJSONObject1;
  }
  
  public int Mt()
  {
    int i = 0;
    if (this.ecD <= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData = b();
      if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData != null) {
        i = 2;
      }
      return i;
    }
    return this.ecD;
  }
  
  public int Mu()
  {
    return this.ecD;
  }
  
  public void VG(String paramString)
  {
    String str = this.cwZ + "audio715.zip";
    Object localObject;
    if (!ahbj.isFileExists(str))
    {
      localObject = new File(this.cwZ, "audio715.zip");
      this.cWb = false;
    }
    for (;;)
    {
      if (this.cWb) {}
      do
      {
        return;
        localObject = new aquz("https://imgcache.qq.com/ac/vasapp/webviewlib/2513/run_sd/audio715.zip", (File)localObject);
        ((aquz)localObject).cWA = false;
        ((aquz)localObject).cWz = true;
        if (this.jdField_b_of_type_Aqva == null)
        {
          this.jdField_b_of_type_Aqva = ((aqva)this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getManager(47));
          this.jdField_b_of_type_Aqvc = this.jdField_b_of_type_Aqva.a(1);
        }
        if (this.jdField_b_of_type_Aqvc != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PathTraceManager", 2, "loaderInterface Null");
      return;
      this.jdField_b_of_type_Aqvc.a((aquz)localObject, new aqts(this, str, paramString), null);
      return;
      localObject = null;
    }
  }
  
  public void XV(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager$a == null) {
      this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager$a = new a(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface);
    }
    this.ecD = paramInt;
    SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager$a);
    if ((this.ecD == 1) && (this.iy != null) && (this.iy.get() != null))
    {
      localObject = (aqtl)this.iy.get();
      if ((localObject != null) && (((aqtl)localObject).mRuntime != null)) {
        if (((aqtl)localObject).mRuntime.b() == null) {
          break label149;
        }
      }
    }
    label149:
    for (Object localObject = ((aqtl)localObject).mRuntime.b().mUrl;; localObject = null)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        dY(this.ecD, (String)localObject);
      }
      QLog.i("PathTraceManager", 1, "startMode: " + this.ecD);
      return;
    }
  }
  
  public void XW(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager$a != null)
    {
      SosoInterface.c(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager$a);
      this.ecD = paramInt;
      if ((this.ecD == 2) && (this.iy != null) && (this.iy.get() != null))
      {
        localObject = (aqtl)this.iy.get();
        if ((localObject != null) && (((aqtl)localObject).mRuntime != null)) {
          if (((aqtl)localObject).mRuntime.b() == null) {
            break label133;
          }
        }
      }
    }
    label133:
    for (Object localObject = ((aqtl)localObject).mRuntime.b().mUrl;; localObject = null)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        dY(this.ecD, (String)localObject);
      }
      QLog.i("PathTraceManager", 1, "stopMode:" + this.ecD);
      return;
    }
  }
  
  public void XX(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("CommondType", 2);
    localBundle.putLong("runningState", paramInt);
    if (this.c != null) {
      this.c.transfer("running_plugin_cmd", localBundle);
    }
    dx(localBundle);
    QLog.i("PathTraceManager", 1, "removeSportBar");
  }
  
  public TracePathData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData;
  }
  
  public TracePathData a(long paramLong)
  {
    TracePathData localTracePathData = null;
    Object localObject = "SELECT * FROM TracePathData WHERE startTime = " + paramLong;
    localObject = this.mEntityManager.rawQuery(TracePathData.class, (String)localObject, null);
    if (localObject != null) {
      localTracePathData = (TracePathData)((List)localObject).get(0);
    }
    return localTracePathData;
  }
  
  public void a(aqtl paramaqtl)
  {
    this.iy = new WeakReference(paramaqtl);
  }
  
  protected void a(TracePathData paramTracePathData, boolean paramBoolean, TracePointsData paramTracePointsData)
  {
    ArrayList localArrayList = new ArrayList();
    double d1 = paramTracePathData.distance;
    if (paramBoolean) {
      localArrayList.add("end");
    }
    long l1;
    SharedPreferences localSharedPreferences;
    Object localObject;
    SharedPreferences.Editor localEditor;
    if (!paramBoolean)
    {
      d1 = Math.floor(d1 / 1000.0D);
      localArrayList.add("yyd");
      if (k(d1) != null)
      {
        localArrayList.add(k(d1));
        localArrayList.add("100");
      }
      if ((l(d1) != null) && (Integer.parseInt(l(d1)) != 0))
      {
        localArrayList.add(l(d1));
        localArrayList.add("10");
      }
      if (m(d1) != null) {
        localArrayList.add(m(d1));
      }
      localArrayList.add("km");
      l1 = paramTracePathData.totalTime;
      localArrayList.add("ys");
      h(localArrayList, l1);
      if (!paramBoolean)
      {
        localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getCurrentAccountUin(), 0);
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences(String.valueOf(paramTracePathData.startTime), 0);
        localEditor = localSharedPreferences.edit();
        localObject = ((SharedPreferences)localObject).edit();
        if ((int)(paramTracePathData.distance / 1000.0D) != 1) {
          break label597;
        }
        localArrayList.add("zjps");
        h(localArrayList, l1);
        localEditor.putLong(String.valueOf(paramTracePathData.startTime), paramTracePathData.totalTime);
        if (paramTracePointsData == null) {
          break label559;
        }
        ((SharedPreferences.Editor)localObject).putString("1", String.valueOf(l1) + "," + String.valueOf(paramTracePointsData.latitude) + "," + String.valueOf(paramTracePointsData.longitude));
        label347:
        ((SharedPreferences.Editor)localObject).putLong(String.valueOf(ecE), paramTracePathData.totalTime).putFloat(String.valueOf(ecF), (float)paramTracePathData.distance);
        label381:
        localEditor.commit();
        ((SharedPreferences.Editor)localObject).commit();
      }
      localArrayList.add("pjps");
      if ((paramBoolean) || ((int)(paramTracePathData.distance / Float.valueOf(1000.0F).floatValue()) != 1)) {
        break label792;
      }
    }
    label792:
    for (d1 = l1;; d1 = l1 / (paramTracePathData.distance / Float.valueOf(1000.0F).floatValue()))
    {
      h(localArrayList, d1);
      if (!paramBoolean)
      {
        localArrayList.add("jxjy");
        fi(localArrayList);
      }
      if (paramBoolean)
      {
        localArrayList.add("jsy");
        fi(localArrayList);
      }
      int i = 0;
      while (i < localArrayList.size())
      {
        QLog.d("PathTraceManager", 1, "psvoice:" + (String)localArrayList.get(i));
        i += 1;
      }
      localArrayList.add("yyd");
      a(localArrayList, d1);
      break;
      label559:
      ((SharedPreferences.Editor)localObject).putString("1", String.valueOf(l1) + ",0,0");
      break label347;
      label597:
      long l2 = localSharedPreferences.getLong(String.valueOf(paramTracePathData.startTime), 0L);
      if (l2 == 0L) {
        break label381;
      }
      long l3 = paramTracePathData.totalTime;
      localArrayList.add("zjps");
      h(localArrayList, paramTracePathData.totalTime - l2);
      if (paramTracePointsData != null) {
        ((SharedPreferences.Editor)localObject).putString(String.valueOf((int)(paramTracePathData.distance / 1000.0D)), String.valueOf(paramTracePathData.totalTime - l2) + "," + String.valueOf(paramTracePointsData.latitude) + "," + String.valueOf(paramTracePointsData.longitude));
      }
      ((SharedPreferences.Editor)localObject).putLong(String.valueOf(ecE), paramTracePathData.totalTime).putFloat(String.valueOf(ecF), Float.valueOf(String.valueOf(paramTracePathData.distance)).floatValue());
      localEditor.putLong(String.valueOf(paramTracePathData.startTime), paramTracePathData.totalTime);
      break label381;
    }
  }
  
  public void a(TracePathData paramTracePathData, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramTracePathData.totalSteps;
    if (paramBoolean1) {
      localArrayList.add("end");
    }
    if (!paramBoolean1)
    {
      localArrayList.add("yyd");
      if (paramBoolean2)
      {
        i(localArrayList, paramTracePathData.stepsGoal);
        localArrayList.add("ys");
        h(localArrayList, paramTracePathData.totalTime);
        if (paramTracePathData.stepsGoal == 0)
        {
          localArrayList.add("jxjy");
          fi(localArrayList);
        }
      }
      else
      {
        if ((i(i) != null) && (Integer.parseInt(i(i)) != 0))
        {
          if (i % 100000 / 10000 == 2)
          {
            localArrayList.add("2_liang");
            label144:
            localArrayList.add("10000");
          }
        }
        else if ((j(i) != null) && (Integer.parseInt(j(i)) != 0))
        {
          if ((i >= 10000) || (i % 10000 / 1000 != 2)) {
            break label244;
          }
          localArrayList.add("2_liang");
        }
        for (;;)
        {
          localArrayList.add("1000");
          localArrayList.add("step");
          break;
          localArrayList.add(i(i));
          break label144;
          label244:
          localArrayList.add(j(i));
        }
      }
      if (paramTracePathData.totalSteps < paramTracePathData.stepsGoal)
      {
        localArrayList.add("hy");
        i(localArrayList, paramTracePathData.stepsGoal - paramTracePathData.totalSteps / 1000 * 1000);
        localArrayList.add("goal_0");
        localArrayList.add("jxjy");
        fi(localArrayList);
        return;
      }
      if (paramBoolean2)
      {
        localArrayList.add("goal_1");
        fi(localArrayList);
        return;
      }
      localArrayList.add("jxjy");
      fi(localArrayList);
      return;
    }
    localArrayList.add("bcyd");
    i(localArrayList, paramTracePathData.totalSteps);
    localArrayList.add("empty_0_5s");
    a(localArrayList, paramTracePathData.distance);
    localArrayList.add("ys");
    h(localArrayList, paramTracePathData.totalTime);
    if (paramTracePathData.totalSteps < 10000) {
      localArrayList.add("jsy");
    }
    for (;;)
    {
      fi(localArrayList);
      return;
      localArrayList.add("guli_1");
    }
  }
  
  public void a(TracePointsData paramTracePointsData)
  {
    if (this.ecD <= 0)
    {
      a(paramTracePointsData);
      QLog.i("PathTraceManager", 1, "drawPoint: " + paramTracePointsData.toString());
      return;
    }
    if (this.ecD == 1)
    {
      if (this.debug)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData != null)
        {
          paramTracePointsData.latitude = (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.latitude + (float)(0.0003D * Math.random()));
          paramTracePointsData.longitude = (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.longitude + (float)(0.0003D * Math.random()));
        }
        paramTracePointsData.speed = 3.0F;
        paramTracePointsData.altitude = 8.800000000000001D;
        paramTracePointsData.accuracy = 41;
      }
      Object localObject1;
      int i;
      label179:
      Object localObject2;
      TracePathData localTracePathData;
      if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData == null)
      {
        QLog.e("PathTraceManager", 1, "dowhile Err");
        localObject1 = new StringBuilder("drawPathTrace: ").append(paramTracePointsData.toString());
        if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData != null) {
          break label807;
        }
        QLog.e("PathTraceManager", 1, "DoWhile Err");
        i = 0;
        localObject2 = new ArrayList(2);
        if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData != null)
        {
          localTracePathData = new TracePathData();
          localTracePathData.startTime = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.startTime;
          localTracePathData.type = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.type;
          localTracePathData.distance = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance;
          localTracePathData.endTime = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.endTime;
          localTracePathData.totalTime = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime;
          localTracePathData.isStop = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.isStop;
          localTracePathData.totalSteps = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalSteps;
          localTracePathData.stepsGoal = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.stepsGoal;
          ((List)localObject2).add(localTracePathData);
          ((StringBuilder)localObject1).append(",totalTime: ").append(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime).append(",total distance: ").append(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance);
        }
        if (i == 0) {
          break label1712;
        }
        ((List)localObject2).add(paramTracePointsData);
      }
      for (;;)
      {
        ThreadManager.getSubThreadHandler().post(new PathTraceManager.6(this, (List)localObject2));
        if ((this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData != null) && (Build.VERSION.SDK_INT >= 25))
        {
          paramTracePointsData = new Intent();
          paramTracePointsData.setAction(PathTraceService.cxc);
          paramTracePointsData.putExtra(PathTraceService.PARAM_STATUS, this.ecD);
          paramTracePointsData.putExtra(PathTraceService.cxd, this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime);
          paramTracePointsData.putExtra(PathTraceService.cxe, this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance);
          this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApp().getApplicationContext().sendBroadcast(paramTracePointsData);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData != null) && (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime > 21600L)) {
          paramTracePointsData = new JSONObject();
        }
        try
        {
          paramTracePointsData.put("retCode", -6);
          if (this.iy != null)
          {
            localObject2 = (aqtl)this.iy.get();
            if (localObject2 != null)
            {
              ((aqtl)localObject2).dispatchJsEvent("PathTraceEnd", paramTracePointsData, new JSONObject());
              QLog.i("PathTraceManager", 1, "LONG END");
            }
          }
        }
        catch (Exception paramTracePointsData)
        {
          for (;;)
          {
            int j;
            float f1;
            float f2;
            QLog.i("PathTraceManager", 1, "TooLong Err");
          }
        }
        cX(21600L);
        QLog.i("PathTraceManager", 1, ((StringBuilder)localObject1).toString());
        return;
        if ((Build.VERSION.SDK_INT < 19) || (this.n == null))
        {
          i = (int)(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance / 0.65D);
          localObject1 = new float[1];
          if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData != null) {
            Location.distanceBetween(paramTracePointsData.latitude, paramTracePointsData.longitude, this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.latitude, this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.longitude, (float[])localObject1);
          }
          j = (int)((this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance + localObject1[0]) / 0.65D);
          if (this.debug) {}
          for (paramTracePointsData.steps += (int)(20.0D * Math.random());; paramTracePointsData.steps = j)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.type != 1) {
              break label747;
            }
            if ((i >= this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.stepsGoal) || (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalSteps < this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.stepsGoal)) {
              break label749;
            }
            a(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData, false, true);
            break;
          }
          label747:
          break;
          label749:
          if (Math.floor(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalSteps / 1000) - Math.floor(i / 1000) <= 0.0D) {
            break;
          }
          a(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData, false, false);
          break;
        }
        paramTracePointsData.steps = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalSteps;
        break;
        label807:
        paramTracePointsData.startTime = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.startTime;
        this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.endTime = NetConnInfoCenter.getServerTime();
        if ((this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData == null) && (this.Fo != 0L))
        {
          this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime = (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime + NetConnInfoCenter.getServerTime() - this.Fo);
          this.Fo = NetConnInfoCenter.getServerTime();
          this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.isStop = 2;
          localObject2 = new float[1];
          if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData != null)
          {
            Location.distanceBetween(paramTracePointsData.latitude, paramTracePointsData.longitude, this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.latitude, this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.longitude, (float[])localObject2);
            ((StringBuilder)localObject1).append(",interval: ").append(localObject2[0]);
            if ((localObject2[0] <= ecM) || (localObject2[0] >= ecL)) {
              break label1324;
            }
            if (paramTracePointsData.accuracy < ecL) {
              break label1279;
            }
            f1 = 0.2F;
            label980:
            paramTracePointsData.latitude = (paramTracePointsData.latitude * f1 + this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.latitude * (1.0F - f1));
            paramTracePointsData.longitude = (paramTracePointsData.longitude * f1 + this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.longitude * (1.0F - f1));
            Location.distanceBetween(paramTracePointsData.latitude, paramTracePointsData.longitude, this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.latitude, this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.longitude, (float[])localObject2);
            ((StringBuilder)localObject1).append(",Mis distance:" + localObject2[0] + ",coefficient:" + f1);
          }
        }
        label1324:
        for (this.cVZ = false;; this.cVZ = true)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData != null) {
            this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.time = paramTracePointsData.time;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance >= 10.0D) || (this.Dd == null) || (this.Dd.size() < 5)) {
            break label1545;
          }
          f2 = 0.0F;
          f1 = 0.0F;
          i = 0;
          while (i < this.Dd.size())
          {
            f2 += ((TracePointsData)this.Dd.get(i)).latitude;
            f1 += ((TracePointsData)this.Dd.get(i)).longitude;
            i += 1;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData;
          long l2 = ((TracePathData)localObject2).totalTime;
          if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData == null) {}
          for (long l1 = 2L;; l1 = paramTracePointsData.time - this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.time)
          {
            ((TracePathData)localObject2).totalTime = (l1 + l2);
            break;
          }
          label1279:
          if (paramTracePointsData.accuracy <= ecM)
          {
            f1 = 1.0F;
            break label980;
          }
          f1 = Float.valueOf(ecL - paramTracePointsData.accuracy).floatValue() / (ecL - ecM);
          break label980;
        }
        paramTracePointsData.latitude = (f2 / this.Dd.size());
        paramTracePointsData.longitude = (f1 / this.Dd.size());
        QLog.d("PathTraceManager", 1, "mOriginnalPoints HAPPEND:" + this.Dd.toString());
        this.Dd.clear();
        label1545:
        do
        {
          double d1 = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance;
          localTracePathData = this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData;
          localTracePathData.distance += localObject2[0];
          if ((this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.type == 0) && (Math.floor(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance / 1000.0D) - Math.floor(Double.valueOf(d1).doubleValue() / 1000.0D) > 0.0D)) {
            a(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData, false, paramTracePointsData);
          }
          i = 1;
          this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData = paramTracePointsData;
          this.cWc = true;
          this.cVZ = true;
          this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalSteps = paramTracePointsData.steps;
          this.Jf.clear();
          this.Jf.add(paramTracePointsData);
          ne(this.Jf);
          break;
          if (paramTracePointsData.accuracy > ecK)
          {
            ((StringBuilder)localObject1).append(",accuracy too low: ").append(paramTracePointsData.accuracy);
            i = 0;
            break;
          }
          if ((this.cWa) || ((paramTracePointsData.speed < 0.005D) && (this.cVZ)))
          {
            ((StringBuilder)localObject1).append(",speed too low: ").append(paramTracePointsData.speed);
            i = 0;
            break;
          }
          if ((localObject2[0] > ecL) && (this.cWc))
          {
            ((StringBuilder)localObject1).append(",distance too long: ").append(localObject2[0]);
            this.cWc = false;
            i = 0;
            break;
          }
        } while ((localObject2[0] >= 0.5D) || (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData == null));
        ((StringBuilder)localObject1).append(",distance too low: ").append(localObject2[0]);
        i = 0;
        break label179;
        label1712:
        if ((this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData != null) && (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance < 10.0D) && (this.Dd != null)) {
          this.Dd.add(paramTracePointsData);
        }
        paramTracePointsData = new JSONObject();
        try
        {
          paramTracePointsData.put("retCode", 1);
          if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData != null) {
            ne(null);
          }
        }
        catch (Exception paramTracePointsData)
        {
          QLog.i("PathTraceManager", 1, "no singnal step");
        }
      }
    }
    XW(-1);
    PathTraceService.efB();
    QLog.e("PathTraceManager", 1, "WorkMode Err :" + this.ecD);
  }
  
  public boolean a(Entity paramEntity)
  {
    if ((this.mEntityManager != null) && (this.mEntityManager.isOpen()))
    {
      if (paramEntity.getStatus() == 1000)
      {
        this.mEntityManager.persistOrReplace(paramEntity);
        return paramEntity.getStatus() == 1001;
      }
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.mEntityManager.update(paramEntity);
      }
    }
    QLog.e("PathTraceManager", 1, "updateEntity Err");
    return false;
  }
  
  public void aM(long paramLong, String paramString)
  {
    ThreadManager.executeOnNetWorkThread(new DataUploadTask(paramLong, paramString));
  }
  
  public JSONObject ah()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Object localObject = this.mEntityManager.query(TracePathData.class);
    try
    {
      localJSONObject1.put("retCode", 1);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label200;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TracePathData localTracePathData = (TracePathData)((Iterator)localObject).next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("startTime", localTracePathData.startTime);
        localJSONObject2.put("endTime", localTracePathData.endTime);
        localJSONObject2.put("totalTime", localTracePathData.totalTime);
        localJSONObject2.put("totalSteps", localTracePathData.totalSteps);
        localJSONObject2.put("distance", localTracePathData.distance);
        localJSONObject2.put("type", localTracePathData.type);
        localJSONArray.put(localJSONObject2);
      }
      localJSONObject1.put("data", localJSONException);
    }
    catch (JSONException localJSONException)
    {
      QLog.d("PathTraceManager", 1, "PathTraceQuery Err");
      return localJSONObject1;
    }
    return localJSONObject1;
    label200:
    localJSONObject1.put("retCode", 1);
    localJSONObject1.put("data", localJSONException);
    return localJSONObject1;
  }
  
  public TracePathData b()
  {
    TracePathData localTracePathData = null;
    List localList = this.mEntityManager.rawQuery(TracePathData.class, "SELECT * FROM TracePathData WHERE isStop <> 1 order by startTime desc limit 1 ", null);
    if (localList != null) {
      localTracePathData = (TracePathData)localList.get(0);
    }
    return localTracePathData;
  }
  
  public void bS(JSONObject paramJSONObject)
  {
    QLog.i("PathTraceManager", 1, "startPathTrace");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("start");
    fi(localArrayList);
    this.mType = paramJSONObject.optInt("type");
    ecK = paramJSONObject.optInt("accuracy");
    this.ecJ = paramJSONObject.optInt("stepGoal");
    if (ecK == 0) {
      ecK = 50;
    }
    try
    {
      paramJSONObject = new TracePathData();
      paramJSONObject.startTime = NetConnInfoCenter.getServerTime();
      paramJSONObject.endTime = NetConnInfoCenter.getServerTime();
      paramJSONObject.type = this.mType;
      paramJSONObject.stepsGoal = this.ecJ;
      this.Fo = paramJSONObject.startTime;
      this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData = paramJSONObject;
      boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData);
      QLog.i("PathTraceManager", 1, "createTime: " + this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.startTime + ", ret: " + bool);
      XV(1);
      PathTraceService.efA();
      this.ecG = 0;
      efw();
      return;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        QLog.e("PathTraceManager", 1, paramJSONObject.getMessage());
      }
    }
  }
  
  String bU(long paramLong)
  {
    if (paramLong >= 3600L) {
      return String.valueOf((int)(paramLong / 3600L));
    }
    return null;
  }
  
  String bV(long paramLong)
  {
    if (paramLong >= 60L) {
      return String.valueOf((int)(paramLong % 3600L / 60L));
    }
    return null;
  }
  
  String bW(long paramLong)
  {
    if (paramLong >= 0L) {
      return String.valueOf((int)(paramLong % 60L));
    }
    return null;
  }
  
  public boolean cX(long paramLong)
  {
    XW(-1);
    PathTraceService.efB();
    XX(this.ecD);
    if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData == null) {
      this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData = b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData != null) {
      BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getCurrentAccountUin(), 0).edit().remove(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.startTime)).commit();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData == null)
    {
      QLog.e("PathTraceManager", 1, "pathTraceEnd Err");
      return false;
    }
    JSONObject localJSONObject = new JSONObject();
    if (this.iy != null) {}
    Object localObject;
    for (aqtl localaqtl = (aqtl)this.iy.get();; localObject = null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime < 60L) || (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.distance < 100.0D))
      {
        try
        {
          localJSONObject.put("retCode", -5);
          if (localaqtl != null) {
            localaqtl.dispatchJsEvent("PathTraceEnd", localJSONObject, new JSONObject());
          }
          g(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.startTime));
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            localJSONException1.printStackTrace();
          }
        }
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime = paramLong;
      this.mUploadTime = paramLong;
      if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.type == 0) {
        a(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData, true, null);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.isStop = 1;
        this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.endTime = NetConnInfoCenter.getServerTime();
        a(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData);
        try
        {
          localJSONObject.put("retCode", 1);
          if (localJSONException1 != null) {
            localJSONException1.dispatchJsEvent("PathTraceEnd", localJSONObject, new JSONObject());
          }
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            localJSONException2.printStackTrace();
          }
        }
        efx();
        return true;
        if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.type == 1) {
          a(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData, true, false);
        }
      }
    }
  }
  
  public void dY(int paramInt, String paramString)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      if (Uri.parse(paramString).getQuery() == null) {
        break label169;
      }
      localObject = paramString;
      if (Uri.parse(paramString).getQueryParameter("ADTAG") == null) {
        localObject = paramString + "&ADTAG=aio.run.click&from=bar";
      }
      if (((String)localObject).contains("runningState")) {
        break label236;
      }
      if (Uri.parse((String)localObject).getQuery() == null) {
        break label208;
      }
      paramString = (String)localObject + "&runningState=" + paramInt;
    }
    for (;;)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("CommondType", 1);
      ((Bundle)localObject).putLong("runningState", paramInt);
      ((Bundle)localObject).putString("cookieUrl", paramString);
      dx((Bundle)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("PathTraceManager", 2, "showSportBar url：" + paramString);
      }
      return;
      label169:
      localObject = paramString;
      if (Uri.parse(paramString).getQueryParameter("ADTAG") != null) {
        break;
      }
      localObject = paramString + "?ADTAG=aio.run.click&from=bar";
      break;
      label208:
      paramString = (String)localObject + "?runningState=" + paramInt;
      continue;
      label236:
      paramString = Uri.parse((String)localObject).getQueryParameter("runningState");
      paramString = ((String)localObject).replace("runningState=" + paramString, "runningState=" + paramInt);
    }
  }
  
  public void dx(Bundle paramBundle)
  {
    if (this.c != null)
    {
      long l = System.currentTimeMillis();
      paramBundle.setClassLoader(getClass().getClassLoader());
      this.c.transfer("running_plugin_cmd", paramBundle);
      QLog.i("PathTraceManager", 1, "postInvokeRemoteCmd cost: " + (System.currentTimeMillis() - l));
      return;
    }
    QLog.e("PathTraceManager", 1, "postInvokeRemoteCmd Err");
  }
  
  @TargetApi(19)
  public void efw()
  {
    if ((Build.VERSION.SDK_INT >= 19) && (this.n != null)) {
      try
      {
        this.jdField_d_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_d_of_type_AndroidHardwareSensorEventListener, this.n, 3, 0);
        this.jdField_d_of_type_AndroidHardwareSensorManager.flush(this.jdField_d_of_type_AndroidHardwareSensorEventListener);
        return;
      }
      catch (Exception localException)
      {
        QLog.d("PathTraceManager", 1, "detector API err");
        return;
      }
    }
    QLog.d("PathTraceManager", 1, "Step Unsupported");
  }
  
  public void efx()
  {
    if ((this.jdField_d_of_type_AndroidHardwareSensorManager != null) && (this.jdField_d_of_type_AndroidHardwareSensorEventListener != null)) {
      this.jdField_d_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_d_of_type_AndroidHardwareSensorEventListener);
    }
  }
  
  public void efy()
  {
    boolean bool = false;
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add("pause");
    fi((ArrayList)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData != null) {
      BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getCurrentAccountUin(), 0).edit().putFloat("search_lbs_logitude", this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.longitude).putFloat("search_lbs_latitude", this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData.latitude).putLong("search_lbs_timestamp", System.currentTimeMillis()).commit();
    }
    this.jdField_a_of_type_ComTencentMobileqqVashealthTracePointsData = null;
    XW(2);
    PathTraceService.efB();
    if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData != null)
    {
      if (this.Fo != 0L) {
        this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime = (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.totalTime + NetConnInfoCenter.getServerTime() - this.Fo);
      }
      this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.isStop = 3;
      a(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData);
    }
    localObject = new StringBuilder().append("pathTracePause:");
    if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData == null) {
      bool = true;
    }
    QLog.i("PathTraceManager", 1, bool);
  }
  
  public void efz()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData == null) {
      this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData = b();
    }
    this.Fo = NetConnInfoCenter.getServerTime();
    efw();
    if (this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData != null)
    {
      XV(1);
      PathTraceService.efA();
    }
    for (;;)
    {
      this.ecG = 0;
      return;
      QLog.e("PathTraceManager", 1, "pathTraceResume Err");
    }
  }
  
  public void fi(ArrayList<String> paramArrayList)
  {
    QLog.d("PathTraceManager", 1, "internalSavePath:" + this.cwZ);
    if (!this.mIsMute)
    {
      int i = 0;
      int j = 1;
      if (i < paramArrayList.size())
      {
        if (!ahbj.isFileExists(this.cwZ + (String)paramArrayList.get(i) + ".mp3"))
        {
          if (paramArrayList.size() != 1) {
            break label117;
          }
          VG((String)paramArrayList.get(0));
        }
        for (;;)
        {
          j = 0;
          i += 1;
          break;
          label117:
          VG(null);
        }
      }
      if (j != 0)
      {
        if (paramArrayList.size() == 1) {
          aqge.a(Uri.fromFile(new File(this.cwZ + (String)paramArrayList.get(0) + ".mp3")), false, true);
        }
      }
      else {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      i = 0;
      while (i < paramArrayList.size())
      {
        localArrayList.add(Uri.fromFile(new File(this.cwZ + (String)paramArrayList.get(i) + ".mp3")));
        i += 1;
      }
      ThreadManager.post(new PathTraceManager.5(this, localArrayList), 5, null, false);
      return;
    }
    QLog.d("PathTraceManager", 1, "play mute");
  }
  
  public boolean g(Long paramLong)
  {
    Object localObject = "DELETE FROM TracePathData WHERE startTime = " + paramLong;
    this.mEntityManager.execSQL((String)localObject);
    paramLong = "DELETE FROM TracePointsData WHERE time IN (SELECT time FROM TracePointsData WHERE startTime =" + paramLong + ")";
    bool = this.mEntityManager.execSQL(paramLong);
    try
    {
      localObject = new JSONObject();
      if (bool) {
        ((JSONObject)localObject).put("retCode", 1);
      }
      for (;;)
      {
        paramLong = null;
        if (this.iy != null) {
          paramLong = (aqtl)this.iy.get();
        }
        if (paramLong == null) {
          break;
        }
        paramLong.dispatchJsEvent("PathTraceDelete", (JSONObject)localObject, new JSONObject());
        return bool;
        ((JSONObject)localObject).put("retCode", -8);
      }
      return bool;
    }
    catch (JSONException paramLong)
    {
      QLog.d("PathTraceManager", 1, "PathTraceDelete Err");
    }
  }
  
  void h(ArrayList<String> paramArrayList, long paramLong)
  {
    long l;
    if (bU(paramLong) != null)
    {
      l = paramLong / 3600L;
      if (k(l) != null)
      {
        paramArrayList.add(k(l));
        paramArrayList.add("100");
      }
      if (l(l) != null)
      {
        paramArrayList.add(l(l));
        paramArrayList.add("10");
      }
      if (m(l) != null) {
        paramArrayList.add(m(l));
      }
      paramArrayList.add("hour");
    }
    if (bV(paramLong) != null)
    {
      l = paramLong % 3600L / 60L;
      if (k(l) != null)
      {
        paramArrayList.add(k(l));
        paramArrayList.add("100");
      }
      if (l(l) != null)
      {
        paramArrayList.add(l(l));
        paramArrayList.add("10");
      }
      if (m(l) != null) {
        paramArrayList.add(m(l));
      }
      paramArrayList.add("min");
    }
    if (bW(paramLong) != null)
    {
      paramLong %= 60L;
      if (k(paramLong) != null)
      {
        paramArrayList.add(k(paramLong));
        paramArrayList.add("100");
      }
      if (paramLong < 10L) {
        break label321;
      }
      if (l(paramLong) != null)
      {
        paramArrayList.add(l(paramLong));
        paramArrayList.add("10");
      }
      if (m(paramLong) != null) {
        paramArrayList.add(m(paramLong));
      }
      paramArrayList.add("sec");
    }
    label321:
    do
    {
      return;
      if (paramLong > 0L)
      {
        paramArrayList.add("0");
        if (m(paramLong) != null) {
          paramArrayList.add(m(paramLong));
        }
        paramArrayList.add("sec");
        return;
      }
    } while (paramLong != 0L);
    paramArrayList.add("0");
    paramArrayList.add("sec");
  }
  
  String i(double paramDouble)
  {
    if (paramDouble >= 10000.0D) {
      return String.valueOf((int)(paramDouble % 100000.0D / 10000.0D));
    }
    return null;
  }
  
  void i(ArrayList<String> paramArrayList, long paramLong)
  {
    label90:
    int i;
    if (i(paramLong) != null)
    {
      if ((int)(paramLong % 100000L / 10000L) == 2)
      {
        paramArrayList.add("2_liang");
        paramArrayList.add("10000");
      }
    }
    else
    {
      if ((j(paramLong) == null) || (Integer.parseInt(j(paramLong)) == 0)) {
        break label253;
      }
      if ((paramLong >= 10000L) || ((int)(paramLong % 10000L / 1000L) != 2)) {
        break label239;
      }
      paramArrayList.add("2_liang");
      paramArrayList.add("1000");
      i = 0;
    }
    for (;;)
    {
      label101:
      int j;
      if ((k(paramLong) != null) && (Integer.parseInt(k(paramLong)) != 0))
      {
        paramArrayList.add(k(paramLong));
        paramArrayList.add("100");
        j = 0;
        label144:
        if ((l(paramLong) == null) || (Integer.parseInt(l(paramLong)) == 0)) {
          break label453;
        }
        paramArrayList.add(l(paramLong));
        paramArrayList.add("10");
      }
      for (;;)
      {
        if ((m(paramLong) != null) && (Integer.parseInt(m(paramLong)) != 0)) {
          paramArrayList.add(m(paramLong));
        }
        paramArrayList.add("step");
        return;
        paramArrayList.add(i(paramLong));
        break;
        label239:
        paramArrayList.add(j(paramLong));
        break label90;
        label253:
        if ((j(paramLong) == null) || (Integer.parseInt(j(paramLong)) != 0) || (((k(paramLong) == null) || (Integer.parseInt(k(paramLong)) == 0)) && ((l(paramLong) == null) || (Integer.parseInt(l(paramLong)) == 0)) && ((m(paramLong) == null) || (Integer.parseInt(m(paramLong)) == 0)))) {
          break label511;
        }
        paramArrayList.add("0");
        i = 1;
        break label101;
        j = i;
        if (k(paramLong) == null) {
          break label144;
        }
        j = i;
        if (Integer.parseInt(k(paramLong)) != 0) {
          break label144;
        }
        j = i;
        if (i != 0) {
          break label144;
        }
        if ((l(paramLong) == null) || (Integer.parseInt(l(paramLong)) == 0))
        {
          j = i;
          if (m(paramLong) == null) {
            break label144;
          }
          j = i;
          if (Integer.parseInt(m(paramLong)) == 0) {
            break label144;
          }
        }
        paramArrayList.add("0");
        j = 1;
        break label144;
        label453:
        if ((l(paramLong) != null) && (Integer.parseInt(l(paramLong)) == 0) && (j == 0) && (m(paramLong) != null) && (Integer.parseInt(m(paramLong)) != 0)) {
          paramArrayList.add("0");
        }
      }
      label511:
      i = 0;
    }
  }
  
  public boolean isRunning()
  {
    return this.ecD == 1;
  }
  
  String j(double paramDouble)
  {
    if (paramDouble >= 1000.0D) {
      return String.valueOf((int)(paramDouble % 10000.0D / 1000.0D));
    }
    return null;
  }
  
  String k(double paramDouble)
  {
    if (paramDouble >= 100.0D) {
      return String.valueOf((int)(paramDouble % 1000.0D / 100.0D));
    }
    return null;
  }
  
  public List<TracePointsData> k(long paramLong)
  {
    long l = System.currentTimeMillis();
    Object localObject = "SELECT * FROM TracePointsData WHERE startTime = " + paramLong;
    localObject = this.mEntityManager.rawQuery(TracePointsData.class, (String)localObject, null);
    StringBuilder localStringBuilder = new StringBuilder().append("getAllTracePointByStartTime  size: ");
    if (localObject != null) {}
    for (int i = ((List)localObject).size();; i = 0)
    {
      QLog.i("PathTraceManager", 1, i + ", cost: " + (System.currentTimeMillis() - l));
      return localObject;
    }
  }
  
  String l(double paramDouble)
  {
    if (paramDouble >= 10.0D) {
      return String.valueOf((int)(paramDouble % 100.0D / 10.0D));
    }
    return null;
  }
  
  String m(double paramDouble)
  {
    if ((l(paramDouble) != null) && ((int)(paramDouble % 10.0D) == 0)) {
      return null;
    }
    return String.valueOf((int)(paramDouble % 10.0D));
  }
  
  String n(double paramDouble)
  {
    return String.valueOf((int)(paramDouble * 10.0D % 10.0D));
  }
  
  /* Error */
  public void nf(List<Entity> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 470 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokeinterface 470 1 0
    //   20: iconst_1
    //   21: if_icmpne +19 -> 40
    //   24: aload_0
    //   25: aload_1
    //   26: iconst_0
    //   27: invokeinterface 471 2 0
    //   32: checkcast 1017	com/tencent/mobileqq/persistence/Entity
    //   35: invokevirtual 1065	com/tencent/mobileqq/vashealth/PathTraceManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   38: pop
    //   39: return
    //   40: aload_0
    //   41: getfield 127	com/tencent/mobileqq/vashealth/PathTraceManager:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   44: invokevirtual 1283	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   47: astore_2
    //   48: aload_2
    //   49: invokevirtual 1288	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   52: aload_1
    //   53: invokeinterface 523 1 0
    //   58: astore_1
    //   59: aload_1
    //   60: invokeinterface 528 1 0
    //   65: ifeq +61 -> 126
    //   68: aload_0
    //   69: aload_1
    //   70: invokeinterface 531 1 0
    //   75: checkcast 1017	com/tencent/mobileqq/persistence/Entity
    //   78: invokevirtual 1065	com/tencent/mobileqq/vashealth/PathTraceManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   81: pop
    //   82: goto -23 -> 59
    //   85: astore_1
    //   86: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +32 -> 121
    //   92: ldc 220
    //   94: iconst_2
    //   95: new 153	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   102: ldc_w 1290
    //   105: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_1
    //   109: invokevirtual 1083	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   112: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 480	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_2
    //   122: invokevirtual 1292	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   125: return
    //   126: aload_2
    //   127: invokevirtual 1294	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   130: aload_2
    //   131: invokevirtual 1292	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   134: return
    //   135: astore_1
    //   136: aload_2
    //   137: invokevirtual 1292	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   140: aload_1
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	PathTraceManager
    //   0	142	1	paramList	List<Entity>
    //   47	90	2	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    // Exception table:
    //   from	to	target	type
    //   52	59	85	java/lang/Exception
    //   59	82	85	java/lang/Exception
    //   126	130	85	java/lang/Exception
    //   52	59	135	finally
    //   59	82	135	finally
    //   86	121	135	finally
    //   126	130	135	finally
  }
  
  String o(double paramDouble)
  {
    if ((int)(paramDouble * 100.0D % 10.0D) != 0) {
      return String.valueOf((int)(paramDouble * 100.0D % 10.0D));
    }
    return null;
  }
  
  public void onDestroy()
  {
    XW(-1);
    PathTraceService.efB();
    XX(Mt());
    aqge.bVz();
    QLog.i("PathTraceManager", 1, "onDestroy");
  }
  
  public class DataUploadTask
    implements Runnable
  {
    private String callback;
    private final int ecN = 3000;
    private String mCmd = "yundong_orbit.datauploadV3";
    private long startTime;
    
    public DataUploadTask(long paramLong, String paramString)
    {
      this.startTime = paramLong;
      this.callback = paramString;
    }
    
    private void bJ(boolean paramBoolean, int paramInt)
    {
      if (PathTraceManager.this.a != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("type", paramInt + "");
        String str = PathTraceManager.this.a.getCurrentAccountUin();
        anpc.a(PathTraceManager.this.a.getApp()).collectPerformance(str, "QQSportUpload", paramBoolean, System.currentTimeMillis(), 0L, localHashMap, "", false);
      }
    }
    
    public void run()
    {
      QQSportsOrbit.OrbitReq localOrbitReq = new QQSportsOrbit.OrbitReq();
      JSONObject localJSONObject;
      List localList;
      Object localObject1;
      SharedPreferences localSharedPreferences;
      int i;
      Object localObject2;
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("callback", this.callback);
        TracePathData localTracePathData;
        if (PathTraceManager.a(PathTraceManager.this) != null)
        {
          localTracePathData = PathTraceManager.a(PathTraceManager.this);
          PathTraceManager.this.a(PathTraceManager.a(PathTraceManager.this));
          if ((PathTraceManager.this.mUploadTime != 0L) && (localTracePathData != null)) {
            localTracePathData.totalTime = PathTraceManager.this.mUploadTime;
          }
          localList = PathTraceManager.this.k(this.startTime);
          if ((localTracePathData == null) || (localList == null)) {
            break label965;
          }
          QLog.d("PathTraceManager", 1, "upload startTime: " + localTracePathData.toString() + ",point size: " + localList.size());
          localObject1 = new QQSportsOrbit.OrbitHeader();
          ((QQSportsOrbit.OrbitHeader)localObject1).startTime.set((int)localTracePathData.startTime);
          ((QQSportsOrbit.OrbitHeader)localObject1).endTime.set((int)localTracePathData.endTime);
          ((QQSportsOrbit.OrbitHeader)localObject1).totalTime.set((int)localTracePathData.totalTime);
          ((QQSportsOrbit.OrbitHeader)localObject1).totalSteps.set(localTracePathData.totalSteps);
          ((QQSportsOrbit.OrbitHeader)localObject1).type.set(localTracePathData.type);
          ((QQSportsOrbit.OrbitHeader)localObject1).distance.set((float)localTracePathData.distance);
          ((QQSportsOrbit.OrbitHeader)localObject1).platform.set(2);
          if ((Build.VERSION.SDK_INT < 19) || (PathTraceManager.this.n == null)) {
            break label447;
          }
          ((QQSportsOrbit.OrbitHeader)localObject1).stepType.set(1);
        }
        for (;;)
        {
          localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(String.valueOf(localTracePathData.startTime), 0);
          i = 1;
          if (localSharedPreferences.getString(String.valueOf(i), null) == null) {
            break label492;
          }
          localObject2 = localSharedPreferences.getString(String.valueOf(i), null);
          if (localObject2 == null) {
            break label989;
          }
          localObject2 = ((String)localObject2).split(",");
          QQSportsOrbit.OrbitPacePoint localOrbitPacePoint = new QQSportsOrbit.OrbitPacePoint();
          localOrbitPacePoint.km.set(i);
          localOrbitPacePoint.time.set(Integer.parseInt(localObject2[0]));
          localOrbitPacePoint.latitude.set(Double.valueOf(localObject2[1]).doubleValue());
          localOrbitPacePoint.longitude.set(Double.valueOf(localObject2[2]).doubleValue());
          ((QQSportsOrbit.OrbitHeader)localObject1).kmRecords.add(localOrbitPacePoint);
          break label989;
          localTracePathData = PathTraceManager.this.a(this.startTime);
          break;
          label447:
          ((QQSportsOrbit.OrbitHeader)localObject1).stepType.set(0);
        }
        localOrbitReq.reqHeader.set((MessageMicro)localObject1);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("PathTraceManager", 1, "[run] json fail" + localThrowable.getMessage());
        return;
      }
      label492:
      localOrbitReq.isOver.set(0);
      if (localList.size() > 0) {
        i = 0;
      }
      for (;;)
      {
        if (i < 3000)
        {
          localObject1 = new QQSportsOrbit.OrbitPoint();
          ((QQSportsOrbit.OrbitPoint)localObject1).latitude.set(((TracePointsData)localList.get(i)).latitude);
          ((QQSportsOrbit.OrbitPoint)localObject1).longitude.set(((TracePointsData)localList.get(i)).longitude);
          ((QQSportsOrbit.OrbitPoint)localObject1).timef.set((int)((TracePointsData)localList.get(i)).time);
          ((QQSportsOrbit.OrbitPoint)localObject1).speedf.set(((TracePointsData)localList.get(i)).speed);
          ((QQSportsOrbit.OrbitPoint)localObject1).accuracy.set(((TracePointsData)localList.get(i)).accuracy + 1);
          ((QQSportsOrbit.OrbitPoint)localObject1).step.set(((TracePointsData)localList.get(i)).steps);
          ((QQSportsOrbit.OrbitPoint)localObject1).altitude.set((float)((TracePointsData)localList.get(i)).altitude);
          localOrbitReq.tracePath.add((MessageMicro)localObject1);
          if (i == localList.size() - 1) {
            localOrbitReq.isOver.set(1);
          }
        }
        else
        {
          localObject2 = localOrbitReq.toByteArray();
          long l = System.currentTimeMillis();
          localObject1 = PathTraceManager.gzip((byte[])localObject2);
          if ((QLog.isColorLevel()) && (localObject1 != null)) {
            QLog.d("PathTraceManager", 2, String.format("first:%s second:%s rate:%.3f time:%s", new Object[] { Integer.valueOf(localObject2.length), Integer.valueOf(localObject1.length), Double.valueOf((localObject1.length + 0.0D) / (localObject2.length + 0.0D)), Long.valueOf(System.currentTimeMillis() - l) }));
          }
          if ((localObject1 == null) || (localObject1.length == 0))
          {
            localJSONObject.put("retCode", -11);
            localJSONObject.put("message", "gzip failed");
            return;
          }
          localObject2 = new NewIntent(BaseApplicationImpl.sApplication.getApplicationContext(), ailu.class);
          ((NewIntent)localObject2).putExtra("extra_cmd", this.mCmd);
          localOrbitReq.num.set(0);
          ((NewIntent)localObject2).putExtra("extra_data", (byte[])localObject1);
          localOrbitReq.tracePath.clear();
          ((NewIntent)localObject2).putExtra("extra_timeout", 15000);
          ((NewIntent)localObject2).setObserver(new aqtv(this, localJSONObject, localList, localThrowable, localSharedPreferences, localOrbitReq));
          BaseApplicationImpl.sApplication.getRuntime().startServlet((NewIntent)localObject2);
          return;
          label965:
          localJSONObject.put("retCode", -9);
          localJSONObject.put("message", "no path trace recode");
          return;
          label989:
          i += 1;
          break;
        }
        i += 1;
      }
    }
  }
  
  public class a
    extends SosoInterface.a
  {
    private AppInterface mApp;
    
    public a(AppInterface paramAppInterface)
    {
      super(true, true, 0L, true, true, "pathtrace");
      this.mApp = paramAppInterface;
    }
    
    public void onConsecutiveFailure(int paramInt1, int paramInt2)
    {
      if (paramInt2 > 3) {
        QLog.d("PathTraceManager", 1, "Consecutive Err");
      }
      super.onConsecutiveFailure(paramInt1, paramInt2);
    }
    
    public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
    {
      if (paramInt == 0)
      {
        Object localObject = paramSosoLbsInfo.a;
        paramSosoLbsInfo = new TracePointsData();
        paramSosoLbsInfo.time = NetConnInfoCenter.getServerTime();
        paramSosoLbsInfo.latitude = ((float)((SosoInterface.SosoLocation)localObject).cd);
        paramSosoLbsInfo.longitude = ((float)((SosoInterface.SosoLocation)localObject).ce);
        paramSosoLbsInfo.altitude = ((SosoInterface.SosoLocation)localObject).altitude;
        paramSosoLbsInfo.accuracy = ((int)((SosoInterface.SosoLocation)localObject).accuracy);
        paramSosoLbsInfo.speed = ((SosoInterface.SosoLocation)localObject).speed;
        if (this.mApp != null)
        {
          localObject = (PathTraceManager)this.mApp.getManager(210);
          if (localObject != null) {
            ((PathTraceManager)localObject).a(paramSosoLbsInfo);
          }
        }
        return;
      }
      PathTraceManager.b(PathTraceManager.this, PathTraceManager.b(PathTraceManager.this));
      if (PathTraceManager.a(PathTraceManager.this) != null) {
        PathTraceManager.this.a(PathTraceManager.a(PathTraceManager.this));
      }
      QLog.e("PathTraceManager", 1, "Location Err: " + paramInt);
    }
    
    public void onStatusUpdate(String paramString1, int paramInt, String paramString2)
    {
      if ((paramString1.equals("gps")) && (paramInt == 0)) {
        QLog.d("PathTraceManager", 1, "GPS shutdown");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.PathTraceManager
 * JD-Core Version:    0.7.0.1
 */