package com.tencent.mobileqq.bubble;

import acfp;
import acny;
import adxk;
import adxk.a;
import adxm;
import adxn;
import adxp;
import adxp.a;
import adxw;
import adyc;
import adyc.a;
import adyc.b;
import adyc.c;
import adyd;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.util.SparseArray;
import android.widget.TextView;
import anot;
import aqhq;
import aqiw;
import aqnl;
import aqrh;
import aqri;
import aquy;
import aqva;
import aqvd;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import common.config.service.QzoneConfig;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wja;

public class BubbleManager
  implements Manager
{
  public static long VM = 1000L;
  public static volatile boolean bRK;
  public static volatile int cKU;
  protected Vector<Integer> B;
  aqvd a;
  public LruLinkedHashMap<Integer, adxm> a;
  protected a a;
  private Rect bN;
  private String bwe;
  private int cKT = 2000000;
  private int cKV;
  float density = 1.0F;
  public ConcurrentHashMap<String, adxk> eR = new ConcurrentHashMap();
  public ConcurrentHashMap<String, adyc> eS = new ConcurrentHashMap();
  QQLruCache<Integer, JSONObject> i = new QQLruCache(2015, 100);
  protected AppInterface mApp;
  protected Context mContext;
  aquy o = new adxw(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  private LruCache<String, Bitmap> q = new LruCache(10);
  Map<Integer, Float> y;
  private final List<String> yz = new ArrayList();
  
  public BubbleManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Aqvd = null;
    this.mApp = paramAppInterface;
    this.mContext = this.mApp.getApp().getApplicationContext();
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$a = new a(2010, 50, 10);
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap = new LruLinkedHashMap(9);
    paramAppInterface = this.mContext.getResources().getDisplayMetrics();
    if (paramAppInterface.density == 160.0F) {}
    for (;;)
    {
      this.density = f;
      this.B = new Vector(16);
      this.y = new ConcurrentHashMap();
      return;
      f = paramAppInterface.density;
    }
  }
  
  private void LE(int paramInt)
  {
    if (iV(paramInt)) {
      a(paramInt, new String[] { "bubble.android." + paramInt + "." + "static.zip", "bubble.android." + paramInt + "." + "other.zip" }, "0");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "createBubbleInfo, download bubble resource, bubbleId=" + paramInt);
      }
      return;
      K(paramInt, "static.zip", "0");
    }
  }
  
  private adxk.a a(String paramString, JSONObject paramJSONObject)
    throws JSONException
  {
    adxk.a locala = new adxk.a();
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "parseEachStepAttrInPathAnim jsonObject = null");
      paramString = null;
    }
    do
    {
      return paramString;
      if (paramJSONObject.has("count")) {
        locala.cKJ = paramJSONObject.getInt("count");
      }
      if (paramJSONObject.has("cycle_count")) {
        locala.cKK = paramJSONObject.getInt("cycle_count");
      }
      paramString = locala;
    } while (!paramJSONObject.has("prefix_name"));
    locala.bvV = paramJSONObject.getString("prefix_name");
    return locala;
  }
  
  private adxk a(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    adxk localadxk = new adxk();
    localadxk.cKA = paramInt;
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "parseCommonAnimationConfig animation = null");
      return null;
    }
    if (paramJSONObject.has("rect"))
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("rect");
      localadxk.kG = new int[4];
      paramInt = 0;
      while (paramInt < localJSONArray.length())
      {
        localadxk.kG[paramInt] = localJSONArray.getInt(paramInt);
        paramInt += 1;
      }
    }
    if (paramJSONObject.has("cycle_count")) {
      localadxk.cKB = paramJSONObject.getInt("cycle_count");
    }
    if (paramJSONObject.has("count")) {
      localadxk.count = paramJSONObject.getInt("count");
    }
    if (paramJSONObject.has("zip_name")) {
      localadxk.zipName = paramJSONObject.getString("zip_name");
    }
    if (paramJSONObject.has("second_zip_name")) {
      localadxk.bvT = paramJSONObject.getString("second_zip_name");
    }
    if (paramJSONObject.has("align")) {
      localadxk.bvU = paramJSONObject.getString("align");
    }
    if ((!paramJSONObject.has("count_stiil")) || (paramJSONObject.has("alpha"))) {
      localadxk.bRC = paramJSONObject.getBoolean("alpha");
    }
    if (paramJSONObject.has("displayChartlet")) {
      localadxk.bRD = paramJSONObject.getBoolean("displayChartlet");
    }
    if (paramJSONObject.has("mirror")) {
      localadxk.mirror = paramJSONObject.getBoolean("mirror");
    }
    a(localadxk, paramJSONObject);
    localadxk.time = paramJSONObject.getInt("time");
    return localadxk;
  }
  
  private adxk a(JSONObject paramJSONObject)
    throws JSONException
  {
    Object localObject;
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "parseBubbleFrameAnimationConfig object = null");
      localObject = null;
    }
    adxk localadxk;
    do
    {
      return localObject;
      localadxk = new adxk();
      localadxk.cKA = 4;
      localadxk.cKC = 1;
      if (paramJSONObject.has("repeat")) {
        localadxk.cKB = paramJSONObject.getInt("repeat");
      }
      if (paramJSONObject.has("count")) {
        localadxk.count = paramJSONObject.getInt("count");
      }
      if (paramJSONObject.has("zip_name")) {
        localadxk.zipName = paramJSONObject.getString("zip_name");
      }
      localObject = localadxk;
    } while (!paramJSONObject.has("time"));
    localadxk.time = paramJSONObject.getInt("time");
    return localadxk;
  }
  
  private adxp.a a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "getAttrsByConfig, bubbleId = " + paramInt + " animName = " + paramString + " autoDown = " + paramBoolean1 + " reversion = " + paramBoolean2);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    adxk localadxk = a(paramInt, paramString);
    if (localadxk == null) {
      return null;
    }
    adxp.a locala = new adxp.a();
    locala.size = localadxk.count;
    locala.duration = localadxk.time;
    locala.repeatCount = localadxk.cKB;
    locala.bRH = localadxk.bRC;
    locala.cKC = localadxk.cKC;
    locala.g = localadxk;
    File localFile;
    String[] arrayOfString;
    int m;
    int j;
    Object localObject;
    label225:
    label228:
    int k;
    boolean bool;
    if (locala.repeatCount <= 1)
    {
      locala.bRG = true;
      localFile = new File(d(paramInt), localadxk.zipName);
      arrayOfString = new String[localadxk.count];
      m = 0;
      j = 0;
      if (localadxk.cr != null) {
        break label420;
      }
      if (localadxk.cKA != 4) {
        break label403;
      }
      localObject = "%04d.9.png";
      j = 0;
      k = m;
      if (j >= arrayOfString.length) {
        break label776;
      }
      arrayOfString[j] = (localFile.getAbsolutePath() + File.separatorChar + String.format((String)localObject, new Object[] { Integer.valueOf(j + 1) }));
      bool = new File(arrayOfString[j]).exists();
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "checkBubbleSource|pngs[" + j + "]=" + arrayOfString[j] + ",isFileExists=" + bool);
      }
      if (bool) {
        break label411;
      }
      j = 1;
    }
    for (;;)
    {
      label403:
      label411:
      label420:
      int n;
      if ((paramBoolean1) && (j != 0))
      {
        K(paramInt, "other.zip", "0");
        return null;
        locala.bRG = false;
        break;
        localObject = "%04d.png";
        break label225;
        j += 1;
        break label228;
        int i1 = localadxk.cr.size();
        n = 0;
        m = 0;
        label436:
        k = j;
        if (n >= i1) {
          break label776;
        }
        localObject = (adxk.a)localadxk.cr.valueAt(n);
        k = 0;
        label465:
        if (k >= ((adxk.a)localObject).cKJ) {
          break label773;
        }
        arrayOfString[(k + m)] = (localFile.getAbsolutePath() + File.separatorChar + ((adxk.a)localObject).bvV + String.format("%04d.png", new Object[] { Integer.valueOf(k + 1) }));
        bool = new File(arrayOfString[(k + m)]).exists();
        if (QLog.isColorLevel()) {
          QLog.d("BubbleManager", 2, "checkBubbleSource|pngs[" + k + "]=" + arrayOfString[k] + ",isFileExists=" + bool);
        }
        if (!bool) {
          j = 1;
        }
      }
      label773:
      for (;;)
      {
        if (j != 0)
        {
          break;
          k += 1;
          break label465;
        }
        k = ((adxk.a)localObject).cKJ;
        n += 1;
        m += k;
        break label436;
        if (j != 0) {
          return null;
        }
        if (arrayOfString.length > 0) {}
        for (localObject = arrayOfString;; localObject = null)
        {
          locala.ez = ((String[])localObject);
          locala.key = paramString;
          locala.bkg = j(localadxk.bvU, paramBoolean2);
          if ((localadxk.kG != null) && (localadxk.kG.length > 0)) {
            locala.mRect = d(localadxk.kG[0], localadxk.kG[1], localadxk.kG[2], localadxk.kG[3]);
          }
          return locala;
        }
      }
      label776:
      j = k;
    }
  }
  
  private adyc a(JSONObject paramJSONObject)
    throws JSONException
  {
    Object localObject;
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "getPendantAnimConf object == null");
      localObject = null;
    }
    adyc.c localc;
    do
    {
      return localObject;
      localc = new adyc.c();
      if (paramJSONObject.has("key")) {
        localc.key = paramJSONObject.getString("key");
      }
      if (paramJSONObject.has("duration")) {
        localc.duration = paramJSONObject.getInt("duration");
      }
      if (paramJSONObject.has("repeat")) {
        localc.repeatCount = paramJSONObject.getInt("repeat");
      }
      if (paramJSONObject.has("pendent_prefix")) {
        localc.bwg = paramJSONObject.getString("pendent_prefix");
      }
      if (paramJSONObject.has("img_count")) {
        localc.cLb = paramJSONObject.getInt("img_count");
      }
      localObject = localc;
    } while (!paramJSONObject.has("play_with"));
    localc.bwj = paramJSONObject.getString("play_with");
    return localc;
  }
  
  /* Error */
  private Boolean a(int paramInt, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 6
    //   9: new 389	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokevirtual 498	com/tencent/mobileqq/bubble/BubbleManager:C	()Ljava/io/File;
    //   17: new 175	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   24: iload_1
    //   25: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: ldc_w 500
    //   31: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokespecial 395	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   40: astore 4
    //   42: aload 4
    //   44: invokevirtual 427	java/io/File:exists	()Z
    //   47: ifeq +9 -> 56
    //   50: aload 4
    //   52: invokevirtual 503	java/io/File:delete	()Z
    //   55: pop
    //   56: aload 7
    //   58: astore_3
    //   59: new 505	java/io/RandomAccessFile
    //   62: dup
    //   63: aload 4
    //   65: ldc_w 507
    //   68: invokespecial 508	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   71: astore 4
    //   73: aload 4
    //   75: aload_2
    //   76: invokevirtual 509	org/json/JSONObject:toString	()Ljava/lang/String;
    //   79: invokevirtual 513	java/lang/String:getBytes	()[B
    //   82: invokevirtual 517	java/io/RandomAccessFile:write	([B)V
    //   85: aload 4
    //   87: invokevirtual 520	java/io/RandomAccessFile:close	()V
    //   90: aload 7
    //   92: astore_3
    //   93: iconst_1
    //   94: invokestatic 525	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   97: astore_2
    //   98: iconst_0
    //   99: ifeq +11 -> 110
    //   102: new 527	java/lang/NullPointerException
    //   105: dup
    //   106: invokespecial 528	java/lang/NullPointerException:<init>	()V
    //   109: athrow
    //   110: aload_2
    //   111: areturn
    //   112: astore_3
    //   113: aload_3
    //   114: invokevirtual 531	java/io/IOException:printStackTrace	()V
    //   117: aload_2
    //   118: areturn
    //   119: astore 4
    //   121: aload 6
    //   123: astore_2
    //   124: aload_2
    //   125: astore_3
    //   126: aload 4
    //   128: invokevirtual 532	java/io/FileNotFoundException:printStackTrace	()V
    //   131: aload_2
    //   132: ifnull +7 -> 139
    //   135: aload_2
    //   136: invokevirtual 520	java/io/RandomAccessFile:close	()V
    //   139: iconst_0
    //   140: invokestatic 525	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   143: areturn
    //   144: astore_2
    //   145: aload_2
    //   146: invokevirtual 531	java/io/IOException:printStackTrace	()V
    //   149: goto -10 -> 139
    //   152: astore 4
    //   154: aload 5
    //   156: astore_2
    //   157: aload_2
    //   158: astore_3
    //   159: aload 4
    //   161: invokevirtual 531	java/io/IOException:printStackTrace	()V
    //   164: aload_2
    //   165: ifnull -26 -> 139
    //   168: aload_2
    //   169: invokevirtual 520	java/io/RandomAccessFile:close	()V
    //   172: goto -33 -> 139
    //   175: astore_2
    //   176: aload_2
    //   177: invokevirtual 531	java/io/IOException:printStackTrace	()V
    //   180: goto -41 -> 139
    //   183: astore_2
    //   184: aload_3
    //   185: ifnull +7 -> 192
    //   188: aload_3
    //   189: invokevirtual 520	java/io/RandomAccessFile:close	()V
    //   192: aload_2
    //   193: athrow
    //   194: astore_3
    //   195: aload_3
    //   196: invokevirtual 531	java/io/IOException:printStackTrace	()V
    //   199: goto -7 -> 192
    //   202: astore_2
    //   203: aload 4
    //   205: astore_3
    //   206: goto -22 -> 184
    //   209: astore_3
    //   210: aload 4
    //   212: astore_2
    //   213: aload_3
    //   214: astore 4
    //   216: goto -59 -> 157
    //   219: astore_3
    //   220: aload 4
    //   222: astore_2
    //   223: aload_3
    //   224: astore 4
    //   226: goto -102 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	BubbleManager
    //   0	229	1	paramInt	int
    //   0	229	2	paramJSONObject	JSONObject
    //   58	35	3	localObject1	Object
    //   112	2	3	localIOException1	IOException
    //   125	64	3	localJSONObject	JSONObject
    //   194	2	3	localIOException2	IOException
    //   205	1	3	localIOException3	IOException
    //   209	5	3	localIOException4	IOException
    //   219	5	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   40	46	4	localObject2	Object
    //   119	8	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   152	59	4	localIOException5	IOException
    //   214	11	4	localObject3	Object
    //   1	154	5	localObject4	Object
    //   7	115	6	localObject5	Object
    //   4	87	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   102	110	112	java/io/IOException
    //   59	73	119	java/io/FileNotFoundException
    //   93	98	119	java/io/FileNotFoundException
    //   135	139	144	java/io/IOException
    //   59	73	152	java/io/IOException
    //   93	98	152	java/io/IOException
    //   168	172	175	java/io/IOException
    //   59	73	183	finally
    //   93	98	183	finally
    //   126	131	183	finally
    //   159	164	183	finally
    //   188	192	194	java/io/IOException
    //   73	90	202	finally
    //   73	90	209	java/io/IOException
    //   73	90	219	java/io/FileNotFoundException
  }
  
  private void a(adxk paramadxk, JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject == null) {
      QLog.e("BubbleManager", 1, "parseAttrInPathAnimation animation = null");
    }
    do
    {
      Object localObject;
      do
      {
        return;
        if (paramJSONObject.has("type"))
        {
          localObject = paramJSONObject.getString("type");
          if ("line".equalsIgnoreCase((String)localObject)) {
            paramadxk.cKC = 10;
          }
          if ("circle".equalsIgnoreCase((String)localObject)) {
            paramadxk.cKC = 11;
          }
          if ("static".equalsIgnoreCase((String)localObject)) {
            paramadxk.cKC = 1;
          }
        }
        if (paramJSONObject.has("padding"))
        {
          localObject = paramJSONObject.getJSONArray("padding");
          paramadxk.cKD = ((JSONArray)localObject).getInt(0);
          paramadxk.cKF = ((JSONArray)localObject).getInt(1);
          paramadxk.cKE = ((JSONArray)localObject).getInt(2);
          paramadxk.cKG = ((JSONArray)localObject).getInt(3);
        }
      } while (!paramJSONObject.has("step"));
      if (paramadxk.cr == null) {
        paramadxk.cr = new SparseArray(3);
      }
      paramJSONObject = paramJSONObject.getJSONObject("step");
      if (paramJSONObject.has("static"))
      {
        localObject = paramJSONObject.getJSONObject("static");
        paramadxk.cr.put(0, a("static", (JSONObject)localObject));
      }
      if (paramJSONObject.has("moving"))
      {
        localObject = paramJSONObject.getJSONObject("moving");
        paramadxk.cr.put(1, a("moving", (JSONObject)localObject));
      }
    } while (!paramJSONObject.has("turnback"));
    paramJSONObject = paramJSONObject.getJSONObject("turnback");
    paramadxk.cr.put(2, a("turnback", paramJSONObject));
  }
  
  private void a(adxm paramadxm, JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString)
    throws Exception
  {
    paramJSONObject2 = paramJSONObject2.optString(paramString);
    paramJSONObject1 = d(paramJSONObject2, paramJSONObject1);
    adyc.a locala = new adyc.a();
    locala.b(paramadxm.bubbleId, paramJSONObject2, paramJSONObject1);
    paramadxm.jO.put(paramString, locala);
  }
  
  private boolean a(adxp paramadxp)
  {
    if (paramadxp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "checkBubbleStaticSource|bubbleInfo is null");
      }
      return false;
    }
    Object localObject1 = d(paramadxp.bubbleId).getAbsolutePath() + File.separatorChar + "chartlet" + File.separatorChar;
    localObject1 = (String)localObject1 + "chartlet.png";
    boolean bool = new File((String)localObject1).exists();
    if (((!bool) || (!TextUtils.isEmpty(paramadxp.bwa))) && (!TextUtils.isEmpty(paramadxp.bvZ)) && (!TextUtils.isEmpty(paramadxp.bvW)) && (!TextUtils.isEmpty(paramadxp.bvX)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "checkBubbleStaticSource|bubbleId=" + paramadxp.bubbleId + ",chkStaticSrcAndUpdate is ok | not empty");
      }
      return true;
    }
    String str3 = d(paramadxp.bubbleId).getAbsolutePath() + File.separatorChar + "static" + File.separatorChar;
    String str1 = str3 + "aio_user_bg_nor.9.png";
    String str2 = str3 + "aio_user_pic_nor.9.png";
    str3 = str3 + "chat_bubble_thumbnail.png";
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(str1);
    ((List)localObject2).add(str2);
    ((List)localObject2).add(str3);
    if (bool) {
      ((List)localObject2).add(localObject1);
    }
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str4 = (String)((Iterator)localObject2).next();
      if (!new File(str4).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("BubbleManager", 2, "checkBubbleStaticSource|file is not exists,bubbleId=" + paramadxp.bubbleId + ",strFilePath=" + str4);
        }
        return false;
      }
    }
    paramadxp.bvZ = str3;
    paramadxp.bvW = str1;
    paramadxp.bvX = str2;
    paramadxp.bwa = ((String)localObject1);
    paramadxp.ew = h(paramadxp.bubbleId);
    try
    {
      localObject1 = decodeFile(str3, null);
      if (localObject1 != null)
      {
        int j = ((Bitmap)localObject1).getPixel(((Bitmap)localObject1).getWidth() / 2, ((Bitmap)localObject1).getHeight() / 2);
        if (paramadxp.mTextColor == j)
        {
          paramadxp.mTextColor = Color.rgb(255 - Color.red(j), 255 - Color.green(j), 255 - Color.blue(j));
          if (QLog.isColorLevel()) {
            QLog.i("BubbleManager", 2, "text color:" + Integer.toHexString(j) + ",  now chage to " + Integer.toHexString(paramadxp.mTextColor));
          }
        }
        if (paramadxp.mLinkColor == j)
        {
          paramadxp.mLinkColor = Color.rgb(255 - Color.red(j), 255 - Color.green(j), 255 - Color.blue(j));
          if (QLog.isColorLevel()) {
            QLog.i("BubbleManager", 2, "mLinkColor :" + Integer.toHexString(j) + ",  now chage to " + Integer.toHexString(paramadxp.mLinkColor));
          }
        }
      }
    }
    catch (OutOfMemoryError paramadxp)
    {
      for (;;)
      {
        QLog.e("BubbleManager", 2, "bubble change color out of memory error!", paramadxp);
      }
    }
    catch (Exception paramadxp)
    {
      for (;;)
      {
        QLog.e("BubbleManager", 2, "bubble change color throws exception!", paramadxp);
      }
    }
    return true;
  }
  
  private adxk b(JSONObject paramJSONObject)
    throws JSONException
  {
    int j = 0;
    adxk localadxk = new adxk();
    localadxk.cKA = 5;
    localadxk.cKC = 1;
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "parseVoicePrintAnimationConfig object = null");
      return null;
    }
    if (paramJSONObject.has("align")) {
      localadxk.bvU = paramJSONObject.getString("align");
    }
    if (paramJSONObject.has("repeat")) {
      localadxk.cKB = paramJSONObject.getInt("repeat");
    }
    if (paramJSONObject.has("count")) {
      localadxk.count = paramJSONObject.getInt("count");
    }
    if (paramJSONObject.has("zip_name")) {
      localadxk.zipName = paramJSONObject.getString("zip_name");
    }
    if (paramJSONObject.has("time")) {
      localadxk.time = paramJSONObject.getInt("time");
    }
    if (paramJSONObject.has("padding"))
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("padding");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        localadxk.cKD = wja.dp2px(localJSONArray.getInt(0) / 2, this.mContext.getResources());
        localadxk.cKF = wja.dp2px(localJSONArray.getInt(1) / 2, this.mContext.getResources());
        localadxk.cKE = wja.dp2px(localJSONArray.getInt(2) / 2, this.mContext.getResources());
        localadxk.cKG = wja.dp2px(localJSONArray.getInt(3) / 2, this.mContext.getResources());
      }
    }
    if (paramJSONObject.has("cut_array"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("cut_array");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        localadxk.kI = new int[paramJSONObject.length()];
        while (j < paramJSONObject.length())
        {
          localadxk.kI[j] = paramJSONObject.getInt(j);
          j += 1;
        }
        Arrays.sort(localadxk.kI);
      }
    }
    return localadxk;
  }
  
  private adyc b(JSONObject paramJSONObject)
    throws JSONException
  {
    Object localObject;
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "getPathAnimConf object == null");
      localObject = null;
    }
    adyc.b localb;
    do
    {
      return localObject;
      localb = new adyc.b();
      if (paramJSONObject.has("key")) {
        localb.key = paramJSONObject.getString("key");
      }
      if (paramJSONObject.has("start_end"))
      {
        localObject = paramJSONObject.getJSONArray("start_end");
        localb.startX = ((float)((JSONArray)localObject).getDouble(0));
        localb.startY = ((float)((JSONArray)localObject).getDouble(1));
        localb.aH = ((float)((JSONArray)localObject).getDouble(2));
        localb.aI = ((float)((JSONArray)localObject).getDouble(3));
      }
      if (paramJSONObject.has("bezier"))
      {
        localObject = paramJSONObject.getJSONArray("bezier");
        localb.vv = ((float)((JSONArray)localObject).getDouble(0));
        localb.vw = ((float)((JSONArray)localObject).getDouble(1));
        localb.vx = ((float)((JSONArray)localObject).getDouble(2));
        localb.vy = ((float)((JSONArray)localObject).getDouble(3));
      }
      if (paramJSONObject.has("duration")) {
        localb.duration = paramJSONObject.getInt("duration");
      }
      if (paramJSONObject.has("speed")) {
        localb.cLd = paramJSONObject.getInt("speed");
      }
      if (paramJSONObject.has("img_prefix")) {
        localb.bwg = paramJSONObject.getString("img_prefix");
      }
      if (paramJSONObject.has("img_reverse")) {
        localb.bRL = paramJSONObject.getBoolean("img_reverse");
      }
      if (paramJSONObject.has("img_alpha"))
      {
        localObject = paramJSONObject.getJSONArray("img_alpha");
        localb.cLe = ((JSONArray)localObject).getInt(0);
        localb.cLf = ((JSONArray)localObject).getInt(1);
      }
      if (paramJSONObject.has("repeat")) {
        localb.repeatCount = paramJSONObject.getInt("repeat");
      }
      if (paramJSONObject.has("img_rotate"))
      {
        localObject = paramJSONObject.getJSONArray("img_rotate");
        localb.cLg = ((JSONArray)localObject).getInt(0);
        localb.cLh = ((JSONArray)localObject).getInt(1);
      }
      if (paramJSONObject.has("img_count")) {
        localb.cLb = paramJSONObject.getInt("img_count");
      }
      if (paramJSONObject.has("periodical")) {
        localb.bRN = paramJSONObject.getBoolean("periodical");
      }
      localObject = localb;
    } while (!paramJSONObject.has("period_length"));
    localb.cLi = paramJSONObject.getInt("period_length");
    return localb;
  }
  
  private ArrayList<adyc> c(JSONArray paramJSONArray)
    throws JSONException
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramJSONArray.length());
    int j = 0;
    if (j < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.getJSONObject(j);
      if (((JSONObject)localObject).has("pendent_prefix")) {}
      for (localObject = a((JSONObject)localObject);; localObject = b((JSONObject)localObject))
      {
        localArrayList.add(localObject);
        j += 1;
        break;
      }
    }
    return localArrayList;
  }
  
  private JSONObject c(String paramString, JSONObject paramJSONObject)
    throws JSONException
  {
    if (!paramJSONObject.has("animations")) {}
    do
    {
      return null;
      paramJSONObject = paramJSONObject.getJSONObject("animations");
    } while (paramJSONObject == null);
    return paramJSONObject.getJSONObject(paramString);
  }
  
  private Rect d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = new Rect();
    localRect.set((int)(paramInt1 / 2.0F * this.density), (int)(paramInt2 / 2.0F * this.density), (int)(paramInt3 / 2.0F * this.density), (int)(paramInt4 / 2.0F * this.density));
    return localRect;
  }
  
  private JSONObject d(String paramString, JSONObject paramJSONObject)
    throws JSONException
  {
    if (!paramJSONObject.has("animation_sets")) {}
    do
    {
      return null;
      paramJSONObject = paramJSONObject.getJSONObject("animation_sets");
    } while (paramJSONObject == null);
    return paramJSONObject.getJSONObject(paramString);
  }
  
  /* Error */
  public static Bitmap decodeFile(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 853	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 854	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: new 856	java/io/BufferedInputStream
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 859	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: astore 5
    //   22: aload_1
    //   23: ifnull +43 -> 66
    //   26: aload_2
    //   27: astore 4
    //   29: aload 5
    //   31: astore_3
    //   32: aload 5
    //   34: aconst_null
    //   35: aload_1
    //   36: invokestatic 865	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   39: astore_1
    //   40: aload_1
    //   41: astore_0
    //   42: aload_2
    //   43: ifnull +7 -> 50
    //   46: aload_2
    //   47: invokevirtual 868	java/io/InputStream:close	()V
    //   50: aload_0
    //   51: astore_2
    //   52: aload 5
    //   54: ifnull +10 -> 64
    //   57: aload 5
    //   59: invokevirtual 868	java/io/InputStream:close	()V
    //   62: aload_0
    //   63: astore_2
    //   64: aload_2
    //   65: areturn
    //   66: aload_2
    //   67: astore 4
    //   69: aload 5
    //   71: astore_3
    //   72: aload 5
    //   74: invokestatic 871	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   77: astore_1
    //   78: aload_1
    //   79: astore_0
    //   80: goto -38 -> 42
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_2
    //   86: aconst_null
    //   87: astore_0
    //   88: aload_2
    //   89: astore 4
    //   91: aload_0
    //   92: astore_3
    //   93: ldc 208
    //   95: iconst_1
    //   96: new 175	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   103: ldc_w 873
    //   106: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_1
    //   110: invokevirtual 876	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 229	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_2
    //   120: ifnull +7 -> 127
    //   123: aload_2
    //   124: invokevirtual 868	java/io/InputStream:close	()V
    //   127: aload 7
    //   129: astore_2
    //   130: aload_0
    //   131: ifnull -67 -> 64
    //   134: aload_0
    //   135: invokevirtual 868	java/io/InputStream:close	()V
    //   138: aconst_null
    //   139: areturn
    //   140: astore_0
    //   141: aconst_null
    //   142: areturn
    //   143: astore 6
    //   145: aconst_null
    //   146: astore_2
    //   147: aconst_null
    //   148: astore_1
    //   149: aload_2
    //   150: astore 4
    //   152: aload_1
    //   153: astore_3
    //   154: ldc 208
    //   156: iconst_1
    //   157: new 175	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   164: ldc_w 878
    //   167: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_0
    //   171: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: aload 6
    //   179: invokestatic 728	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   182: aload_2
    //   183: ifnull +7 -> 190
    //   186: aload_2
    //   187: invokevirtual 868	java/io/InputStream:close	()V
    //   190: aload 7
    //   192: astore_2
    //   193: aload_1
    //   194: ifnull -130 -> 64
    //   197: aload_1
    //   198: invokevirtual 868	java/io/InputStream:close	()V
    //   201: aconst_null
    //   202: areturn
    //   203: astore_0
    //   204: aconst_null
    //   205: areturn
    //   206: astore_0
    //   207: aconst_null
    //   208: astore_2
    //   209: aconst_null
    //   210: astore_3
    //   211: aload_2
    //   212: ifnull +7 -> 219
    //   215: aload_2
    //   216: invokevirtual 868	java/io/InputStream:close	()V
    //   219: aload_3
    //   220: ifnull +7 -> 227
    //   223: aload_3
    //   224: invokevirtual 868	java/io/InputStream:close	()V
    //   227: aload_0
    //   228: athrow
    //   229: astore_1
    //   230: goto -180 -> 50
    //   233: astore_1
    //   234: aload_0
    //   235: areturn
    //   236: astore_1
    //   237: goto -110 -> 127
    //   240: astore_0
    //   241: goto -51 -> 190
    //   244: astore_1
    //   245: goto -26 -> 219
    //   248: astore_1
    //   249: goto -22 -> 227
    //   252: astore_0
    //   253: aconst_null
    //   254: astore_3
    //   255: goto -44 -> 211
    //   258: astore_0
    //   259: aload 4
    //   261: astore_2
    //   262: goto -51 -> 211
    //   265: astore 6
    //   267: aconst_null
    //   268: astore_1
    //   269: goto -120 -> 149
    //   272: astore 6
    //   274: aload 5
    //   276: astore_1
    //   277: goto -128 -> 149
    //   280: astore_1
    //   281: aconst_null
    //   282: astore_0
    //   283: goto -195 -> 88
    //   286: astore_1
    //   287: aload 5
    //   289: astore_0
    //   290: goto -202 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramString	String
    //   0	293	1	paramOptions	BitmapFactory.Options
    //   11	251	2	localObject1	Object
    //   31	224	3	localObject2	Object
    //   27	233	4	localObject3	Object
    //   20	268	5	localBufferedInputStream	java.io.BufferedInputStream
    //   143	35	6	localOutOfMemoryError1	OutOfMemoryError
    //   265	1	6	localOutOfMemoryError2	OutOfMemoryError
    //   272	1	6	localOutOfMemoryError3	OutOfMemoryError
    //   1	190	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   3	12	83	java/lang/Exception
    //   134	138	140	java/io/IOException
    //   3	12	143	java/lang/OutOfMemoryError
    //   197	201	203	java/io/IOException
    //   3	12	206	finally
    //   46	50	229	java/io/IOException
    //   57	62	233	java/io/IOException
    //   123	127	236	java/io/IOException
    //   186	190	240	java/io/IOException
    //   215	219	244	java/io/IOException
    //   223	227	248	java/io/IOException
    //   12	22	252	finally
    //   32	40	258	finally
    //   72	78	258	finally
    //   93	119	258	finally
    //   154	182	258	finally
    //   12	22	265	java/lang/OutOfMemoryError
    //   32	40	272	java/lang/OutOfMemoryError
    //   72	78	272	java/lang/OutOfMemoryError
    //   12	22	280	java/lang/Exception
    //   32	40	286	java/lang/Exception
    //   72	78	286	java/lang/Exception
  }
  
  private boolean iU(int paramInt)
  {
    boolean bool = true;
    ??? = new File(C(), paramInt + ".cfg");
    if (!((File)???).exists()) {
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "readLocalVersionInfo local info not exist id = " + paramInt);
      }
    }
    do
    {
      return false;
      ??? = aqhq.b((File)???, -1);
      if (!TextUtils.isEmpty((CharSequence)???)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BubbleManager", 2, "readLocalVersionInfo read local info fail id = " + paramInt);
    return false;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject((String)???);
        synchronized (this.i)
        {
          this.i.put(Integer.valueOf(paramInt), localJSONObject);
          int j = localJSONObject.optInt("full_download");
          if (j == 1) {
            return bool;
          }
        }
        bool = false;
      }
      catch (Exception localException)
      {
        QLog.e("BubbleManager", 1, "readLocalVersionInfo id = " + paramInt + " error: ", localException);
        return false;
      }
    }
  }
  
  private int j(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals("T")) {
        if (paramBoolean) {}
      }
      do
      {
        return 3;
        return 4;
        if (paramString.equals("L"))
        {
          if (!paramBoolean) {
            return 2;
          }
          return 7;
        }
        if (paramString.equals("TL"))
        {
          if (!paramBoolean) {
            return 0;
          }
          return 5;
        }
        if (!paramString.equals("B")) {
          break;
        }
      } while (paramBoolean);
      return 4;
      if (paramString.equals("BL"))
      {
        if (!paramBoolean) {
          return 1;
        }
        return 6;
      }
      if (paramString.equals("R"))
      {
        if (!paramBoolean) {
          return 7;
        }
        return 2;
      }
      if (paramString.equals("TR"))
      {
        if (!paramBoolean) {
          return 5;
        }
        return 0;
      }
      if (paramString.equals("BR"))
      {
        if (!paramBoolean) {
          return 6;
        }
        return 1;
      }
    }
    return -1;
  }
  
  public File A()
  {
    File localFile = new File(this.mContext.getFilesDir(), "bubble_info");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public File B()
  {
    File localFile = new File(A(), "bubble_paster");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public File C()
  {
    File localFile = new File(A(), "bubble_local/");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void GM(boolean paramBoolean)
  {
    boolean bool = true;
    if (!afO()) {
      paramBoolean = true;
    }
    int j;
    Object localObject;
    if (paramBoolean != afN())
    {
      if (!paramBoolean) {
        break label139;
      }
      j = 1;
      this.cKV = j;
      localObject = this.mApp.getApp().getSharedPreferences(this.mApp.getCurrentAccountUin(), 0).edit();
      if (j != 1) {
        break label144;
      }
    }
    for (;;)
    {
      ((SharedPreferences.Editor)localObject).putBoolean("svip_bubble_unread_switch", bool).apply();
      localObject = (acny)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(27);
      if (localObject != null) {
        ((acny)localObject).FL(paramBoolean);
      }
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "setBubbleUnreadShow " + paramBoolean);
      }
      return;
      label139:
      j = -1;
      break;
      label144:
      bool = false;
    }
  }
  
  public void K(int paramInt, String arg2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "downloadBubble, bubbleId = " + paramInt + " pkgName = " + ??? + " from = " + paramString2);
    }
    if (paramInt == 0) {}
    String str;
    VasQuickUpdateManager localVasQuickUpdateManager;
    do
    {
      return;
      str = "bubble.android." + paramInt + "." + ???;
      localVasQuickUpdateManager = (VasQuickUpdateManager)this.mApp.getManager(184);
    } while (localVasQuickUpdateManager == null);
    synchronized (this.yz)
    {
      if (this.yz.contains(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BubbleManager", 2, str + " is downloading, remove duplicate download.");
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 2, str + " is downloading, remove duplicate download.");
    }
    this.yz.add(str);
    localVasQuickUpdateManager.downloadItem(2L, str, paramString2);
  }
  
  public void LF(int paramInt)
  {
    try
    {
      synchronized (this.i)
      {
        JSONObject localJSONObject2 = (JSONObject)this.i.get(Integer.valueOf(paramInt));
        JSONObject localJSONObject1 = localJSONObject2;
        if (localJSONObject2 == null) {
          localJSONObject1 = new JSONObject();
        }
        localJSONObject1.put("full_download", 1);
        localJSONObject1.put("id", paramInt);
        this.i.put(Integer.valueOf(paramInt), localJSONObject1);
        a(paramInt, localJSONObject1);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public adxk a(int paramInt1, int paramInt2)
  {
    Object localObject = a(paramInt1, false);
    if (localObject == null) {
      return null;
    }
    switch (paramInt2)
    {
    case 4: 
    default: 
      localObject = null;
    }
    int j;
    for (;;)
    {
      if (localObject != null) {
        if (this.eR.contains(((adxk)localObject).bvS))
        {
          return localObject;
          localObject = ((adxm)localObject).c;
          adxk.a((adxk)localObject);
          continue;
          localObject = ((adxm)localObject).b;
          continue;
          localObject = ((adxm)localObject).f;
        }
        else if ((localObject != null) && (((adxk)localObject).uX != null) && (((adxk)localObject).uX.size() > 0))
        {
          Iterator localIterator = ((adxk)localObject).uX.iterator();
          paramInt2 = 1;
          if (!localIterator.hasNext()) {
            break label315;
          }
          adyc localadyc = (adyc)localIterator.next();
          File localFile = new File(d(paramInt1), ((adxk)localObject).zipName);
          j = 0;
          label188:
          if (j >= localadyc.cLb) {
            break label348;
          }
          String str = localFile.getAbsolutePath() + File.separatorChar + localadyc.bwg + String.format("%04d.png", new Object[] { Integer.valueOf(j + 1) });
          if (!new File(str).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d("BubbleManager", 2, "pendent anim conf, file is not exit, " + str);
            }
            paramInt2 = 0;
          }
        }
      }
    }
    label315:
    label348:
    for (;;)
    {
      break;
      j += 1;
      break label188;
      return null;
      if (paramInt2 == 0)
      {
        K(paramInt1, "other.zip", "0");
        return null;
      }
      this.eR.put(((adxk)localObject).bvS, localObject);
      return localObject;
    }
  }
  
  adxk a(int paramInt, String paramString)
  {
    Object localObject = a(paramInt, true);
    if (localObject == null)
    {
      QLog.e("BubbleManager", 1, "findAnimConfig bubbleId = " + paramInt + " bubbleConfig = null");
      return null;
    }
    if ((((adxm)localObject).jdField_a_of_type_Adxk != null) && (((adxm)localObject).jdField_a_of_type_Adxk.bvS.equals(paramString))) {
      return ((adxm)localObject).jdField_a_of_type_Adxk;
    }
    if ((((adxm)localObject).b != null) && (((adxm)localObject).b.bvS.equals(paramString))) {
      return ((adxm)localObject).b;
    }
    if ((((adxm)localObject).c != null) && (((adxm)localObject).c.bvS.equals(paramString))) {
      return ((adxm)localObject).c;
    }
    if ((((adxm)localObject).d != null) && (((adxm)localObject).d.bvS.equals(paramString))) {
      return ((adxm)localObject).d;
    }
    if ((((adxm)localObject).e != null) && (((adxm)localObject).e.bvS.equals(paramString))) {
      return ((adxm)localObject).e;
    }
    if (((adxm)localObject).uY != null)
    {
      localObject = ((adxm)localObject).uY.iterator();
      while (((Iterator)localObject).hasNext())
      {
        adxk localadxk = (adxk)((Iterator)localObject).next();
        if (localadxk.bvS.equals(paramString)) {
          return localadxk;
        }
      }
    }
    return null;
  }
  
  /* Error */
  adxm a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc 208
    //   8: iconst_2
    //   9: new 175	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 1073
    //   19: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: ldc_w 1075
    //   29: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 355	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_2
    //   43: invokestatic 361	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifeq +5 -> 51
    //   49: aconst_null
    //   50: areturn
    //   51: aload_0
    //   52: aload_2
    //   53: invokevirtual 1078	com/tencent/mobileqq/bubble/BubbleManager:kb	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore 8
    //   58: aload 8
    //   60: invokestatic 361	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifeq +5 -> 68
    //   66: aconst_null
    //   67: areturn
    //   68: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +30 -> 101
    //   74: ldc 208
    //   76: iconst_2
    //   77: new 175	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 1080
    //   87: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 8
    //   92: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: aload 8
    //   103: astore_2
    //   104: getstatic 1085	android/os/Build$VERSION:SDK_INT	I
    //   107: bipush 10
    //   109: if_icmpgt +37 -> 146
    //   112: aload 8
    //   114: astore_2
    //   115: aload 8
    //   117: invokevirtual 1086	java/lang/String:length	()I
    //   120: iconst_1
    //   121: if_icmple +25 -> 146
    //   124: aload 8
    //   126: astore_2
    //   127: aload 8
    //   129: iconst_0
    //   130: invokevirtual 1090	java/lang/String:charAt	(I)C
    //   133: ldc_w 1091
    //   136: if_icmpne +10 -> 146
    //   139: aload 8
    //   141: iconst_1
    //   142: invokevirtual 1094	java/lang/String:substring	(I)Ljava/lang/String;
    //   145: astore_2
    //   146: new 590	adxm
    //   149: dup
    //   150: iload_1
    //   151: invokespecial 1095	adxm:<init>	(I)V
    //   154: astore 9
    //   156: new 233	org/json/JSONObject
    //   159: dup
    //   160: aload_2
    //   161: invokespecial 889	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   164: astore 10
    //   166: aload 9
    //   168: aload 10
    //   170: ldc_w 1097
    //   173: invokevirtual 255	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: putfield 1099	adxm:name	Ljava/lang/String;
    //   179: aload 10
    //   181: ldc_w 1101
    //   184: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   187: istore 7
    //   189: iload 7
    //   191: ifeq +122 -> 313
    //   194: aload 10
    //   196: ldc_w 1101
    //   199: invokevirtual 274	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   202: astore_2
    //   203: aload_2
    //   204: ifnull +109 -> 313
    //   207: aload_2
    //   208: invokevirtual 284	org/json/JSONArray:length	()I
    //   211: ifle +102 -> 313
    //   214: aload 9
    //   216: new 75	java/util/ArrayList
    //   219: dup
    //   220: invokespecial 76	java/util/ArrayList:<init>	()V
    //   223: putfield 1104	adxm:uZ	Ljava/util/ArrayList;
    //   226: aload 9
    //   228: iconst_0
    //   229: putfield 1107	adxm:cKL	I
    //   232: iconst_0
    //   233: istore 5
    //   235: iload 5
    //   237: aload_2
    //   238: invokevirtual 284	org/json/JSONArray:length	()I
    //   241: if_icmpge +30 -> 271
    //   244: aload 9
    //   246: getfield 1104	adxm:uZ	Ljava/util/ArrayList;
    //   249: aload_2
    //   250: iload 5
    //   252: invokevirtual 287	org/json/JSONArray:getInt	(I)I
    //   255: invokestatic 417	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: invokevirtual 836	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   261: pop
    //   262: iload 5
    //   264: iconst_1
    //   265: iadd
    //   266: istore 5
    //   268: goto -33 -> 235
    //   271: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +39 -> 313
    //   277: ldc 208
    //   279: iconst_2
    //   280: new 175	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   287: ldc_w 1109
    //   290: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc_w 1111
    //   296: aload 9
    //   298: getfield 1104	adxm:uZ	Ljava/util/ArrayList;
    //   301: invokestatic 1115	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   304: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 355	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload 10
    //   315: ldc_w 1117
    //   318: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   321: ifeq +62 -> 383
    //   324: aload 10
    //   326: ldc_w 1117
    //   329: invokevirtual 255	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   332: astore 8
    //   334: aload 8
    //   336: astore_2
    //   337: aload 8
    //   339: ldc_w 1119
    //   342: invokevirtual 1122	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   345: ifeq +10 -> 355
    //   348: aload 8
    //   350: iconst_2
    //   351: invokevirtual 1094	java/lang/String:substring	(I)Ljava/lang/String;
    //   354: astore_2
    //   355: aload 9
    //   357: new 175	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   364: ldc_w 1124
    //   367: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload_2
    //   371: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 1127	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   380: putfield 1130	adxm:fontColor	I
    //   383: aload 10
    //   385: ldc_w 1132
    //   388: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   391: ifeq +62 -> 453
    //   394: aload 10
    //   396: ldc_w 1132
    //   399: invokevirtual 255	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   402: astore 8
    //   404: aload 8
    //   406: astore_2
    //   407: aload 8
    //   409: ldc_w 1119
    //   412: invokevirtual 1122	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   415: ifeq +10 -> 425
    //   418: aload 8
    //   420: iconst_2
    //   421: invokevirtual 1094	java/lang/String:substring	(I)Ljava/lang/String;
    //   424: astore_2
    //   425: aload 9
    //   427: new 175	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   434: ldc_w 1124
    //   437: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload_2
    //   441: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 1127	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   450: putfield 1135	adxm:linkColor	I
    //   453: aload 10
    //   455: ldc_w 1137
    //   458: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   461: ifeq +943 -> 1404
    //   464: aload 9
    //   466: iconst_1
    //   467: putfield 1140	adxm:hasStroke	Z
    //   470: aload 10
    //   472: ldc_w 1137
    //   475: invokevirtual 255	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   478: astore 8
    //   480: aload 8
    //   482: astore_2
    //   483: aload 8
    //   485: ldc_w 1119
    //   488: invokevirtual 1122	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   491: ifeq +10 -> 501
    //   494: aload 8
    //   496: iconst_2
    //   497: invokevirtual 1094	java/lang/String:substring	(I)Ljava/lang/String;
    //   500: astore_2
    //   501: aload 9
    //   503: new 175	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   510: ldc_w 1124
    //   513: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_2
    //   517: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 1127	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   526: putfield 1143	adxm:strokeColor	I
    //   529: aload 9
    //   531: aload 10
    //   533: ldc_w 1145
    //   536: dconst_1
    //   537: invokevirtual 1149	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   540: putfield 1153	adxm:cs	D
    //   543: aload 10
    //   545: ldc_w 1155
    //   548: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   551: ifeq +36 -> 587
    //   554: aload 10
    //   556: ldc_w 1155
    //   559: invokevirtual 274	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   562: astore_2
    //   563: aload 9
    //   565: iconst_2
    //   566: newarray int
    //   568: dup
    //   569: iconst_0
    //   570: aload_2
    //   571: iconst_0
    //   572: invokevirtual 287	org/json/JSONArray:getInt	(I)I
    //   575: iastore
    //   576: dup
    //   577: iconst_1
    //   578: aload_2
    //   579: iconst_1
    //   580: invokevirtual 287	org/json/JSONArray:getInt	(I)I
    //   583: iastore
    //   584: putfield 1158	adxm:kJ	[I
    //   587: aload 10
    //   589: ldc_w 1160
    //   592: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   595: ifeq +95 -> 690
    //   598: aload 10
    //   600: ldc_w 1160
    //   603: invokevirtual 566	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   606: astore_2
    //   607: aload_2
    //   608: ldc_w 1162
    //   611: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   614: ifeq +76 -> 690
    //   617: aload_0
    //   618: aload_2
    //   619: ldc_w 1162
    //   622: invokevirtual 255	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   625: aload 10
    //   627: invokespecial 1164	com/tencent/mobileqq/bubble/BubbleManager:c	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   630: astore 8
    //   632: aload 8
    //   634: ifnull +56 -> 690
    //   637: aload_0
    //   638: iconst_0
    //   639: aload 8
    //   641: invokespecial 1166	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Ladxk;
    //   644: astore 8
    //   646: aload 8
    //   648: aload_2
    //   649: ldc_w 1162
    //   652: invokevirtual 255	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   655: putfield 1033	adxk:bvS	Ljava/lang/String;
    //   658: aload 9
    //   660: aload 8
    //   662: putfield 1063	adxm:jdField_a_of_type_Adxk	Ladxk;
    //   665: aload 8
    //   667: getfield 297	adxk:zipName	Ljava/lang/String;
    //   670: invokestatic 361	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   673: ifne +17 -> 690
    //   676: aload 9
    //   678: getfield 1170	adxm:ba	Ljava/util/HashSet;
    //   681: aload 8
    //   683: getfield 297	adxk:zipName	Ljava/lang/String;
    //   686: invokevirtual 1173	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   689: pop
    //   690: aload 10
    //   692: ldc_w 1175
    //   695: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   698: ifeq +131 -> 829
    //   701: aload 10
    //   703: ldc_w 1175
    //   706: invokevirtual 566	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   709: astore_2
    //   710: aload_2
    //   711: ldc_w 1162
    //   714: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   717: ifeq +112 -> 829
    //   720: aload_0
    //   721: aload_2
    //   722: ldc_w 1162
    //   725: invokevirtual 255	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   728: aload 10
    //   730: invokespecial 1164	com/tencent/mobileqq/bubble/BubbleManager:c	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   733: astore 11
    //   735: aload 11
    //   737: ifnull +92 -> 829
    //   740: aload_0
    //   741: iconst_2
    //   742: aload 11
    //   744: invokespecial 1166	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Ladxk;
    //   747: astore 8
    //   749: aload 11
    //   751: ldc_w 1177
    //   754: invokevirtual 274	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   757: astore 11
    //   759: aload 8
    //   761: iconst_2
    //   762: newarray int
    //   764: dup
    //   765: iconst_0
    //   766: aload 11
    //   768: iconst_0
    //   769: invokevirtual 287	org/json/JSONArray:getInt	(I)I
    //   772: iastore
    //   773: dup
    //   774: iconst_1
    //   775: aload 11
    //   777: iconst_1
    //   778: invokevirtual 287	org/json/JSONArray:getInt	(I)I
    //   781: iastore
    //   782: putfield 1180	adxk:kH	[I
    //   785: aload 8
    //   787: aload_2
    //   788: ldc_w 1162
    //   791: invokevirtual 255	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   794: putfield 1033	adxk:bvS	Ljava/lang/String;
    //   797: aload 9
    //   799: aload 8
    //   801: putfield 1041	adxm:b	Ladxk;
    //   804: aload 8
    //   806: getfield 297	adxk:zipName	Ljava/lang/String;
    //   809: invokestatic 361	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   812: ifne +17 -> 829
    //   815: aload 9
    //   817: getfield 1170	adxm:ba	Ljava/util/HashSet;
    //   820: aload 8
    //   822: getfield 297	adxk:zipName	Ljava/lang/String;
    //   825: invokevirtual 1173	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   828: pop
    //   829: aload 10
    //   831: ldc_w 1182
    //   834: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   837: ifeq +152 -> 989
    //   840: aload 10
    //   842: ldc_w 1182
    //   845: invokevirtual 566	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   848: astore_2
    //   849: aload_2
    //   850: ldc_w 1162
    //   853: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   856: ifeq +133 -> 989
    //   859: aload_0
    //   860: aload_2
    //   861: ldc_w 1162
    //   864: invokevirtual 255	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   867: aload 10
    //   869: invokespecial 1164	com/tencent/mobileqq/bubble/BubbleManager:c	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   872: astore 8
    //   874: aload 8
    //   876: ifnull +113 -> 989
    //   879: aload_0
    //   880: iconst_3
    //   881: aload 8
    //   883: invokespecial 1166	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Ladxk;
    //   886: astore 8
    //   888: aload 8
    //   890: aload_2
    //   891: ldc_w 1162
    //   894: invokevirtual 255	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   897: putfield 1033	adxk:bvS	Ljava/lang/String;
    //   900: aload_2
    //   901: ldc_w 1184
    //   904: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   907: ifeq +50 -> 957
    //   910: aload_2
    //   911: ldc_w 1184
    //   914: invokevirtual 241	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   917: istore 5
    //   919: aload_0
    //   920: getfield 133	com/tencent/mobileqq/bubble/BubbleManager:mContext	Landroid/content/Context;
    //   923: ldc_w 1186
    //   926: invokevirtual 1190	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   929: checkcast 1192	android/view/WindowManager
    //   932: invokeinterface 1196 1 0
    //   937: invokevirtual 1199	android/view/Display:getWidth	()I
    //   940: i2d
    //   941: dstore_3
    //   942: aload 8
    //   944: iload 5
    //   946: i2d
    //   947: ldc2_w 1200
    //   950: ddiv
    //   951: dload_3
    //   952: dmul
    //   953: d2i
    //   954: putfield 1204	adxk:cKH	I
    //   957: aload 9
    //   959: aload 8
    //   961: putfield 1036	adxm:c	Ladxk;
    //   964: aload 8
    //   966: getfield 297	adxk:zipName	Ljava/lang/String;
    //   969: invokestatic 361	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   972: ifne +17 -> 989
    //   975: aload 9
    //   977: getfield 1170	adxm:ba	Ljava/util/HashSet;
    //   980: aload 8
    //   982: getfield 297	adxk:zipName	Ljava/lang/String;
    //   985: invokevirtual 1173	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   988: pop
    //   989: aload 10
    //   991: ldc_w 1206
    //   994: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   997: ifeq +94 -> 1091
    //   1000: aload 10
    //   1002: ldc_w 1206
    //   1005: invokevirtual 566	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1008: astore_2
    //   1009: aload_2
    //   1010: ldc_w 1208
    //   1013: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1016: ifeq +75 -> 1091
    //   1019: aload_0
    //   1020: aload_2
    //   1021: ldc_w 1208
    //   1024: invokevirtual 255	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1027: aload 10
    //   1029: invokespecial 585	com/tencent/mobileqq/bubble/BubbleManager:d	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1032: astore 8
    //   1034: aload 8
    //   1036: ifnull +55 -> 1091
    //   1039: aload_0
    //   1040: aload 8
    //   1042: invokespecial 1210	com/tencent/mobileqq/bubble/BubbleManager:a	(Lorg/json/JSONObject;)Ladxk;
    //   1045: astore 8
    //   1047: aload 8
    //   1049: aload_2
    //   1050: ldc_w 1208
    //   1053: invokevirtual 255	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1056: putfield 1033	adxk:bvS	Ljava/lang/String;
    //   1059: aload 9
    //   1061: aload 8
    //   1063: putfield 1065	adxm:d	Ladxk;
    //   1066: aload 8
    //   1068: getfield 297	adxk:zipName	Ljava/lang/String;
    //   1071: invokestatic 361	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1074: ifne +17 -> 1091
    //   1077: aload 9
    //   1079: getfield 1170	adxm:ba	Ljava/util/HashSet;
    //   1082: aload 8
    //   1084: getfield 297	adxk:zipName	Ljava/lang/String;
    //   1087: invokevirtual 1173	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1090: pop
    //   1091: aload 10
    //   1093: ldc_w 1212
    //   1096: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1099: ifeq +94 -> 1193
    //   1102: aload 10
    //   1104: ldc_w 1212
    //   1107: invokevirtual 566	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1110: astore_2
    //   1111: aload_2
    //   1112: ldc_w 1208
    //   1115: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1118: ifeq +75 -> 1193
    //   1121: aload_0
    //   1122: aload_2
    //   1123: ldc_w 1208
    //   1126: invokevirtual 255	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1129: aload 10
    //   1131: invokespecial 585	com/tencent/mobileqq/bubble/BubbleManager:d	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1134: astore 8
    //   1136: aload 8
    //   1138: ifnull +55 -> 1193
    //   1141: aload_0
    //   1142: aload 8
    //   1144: invokespecial 1214	com/tencent/mobileqq/bubble/BubbleManager:b	(Lorg/json/JSONObject;)Ladxk;
    //   1147: astore 8
    //   1149: aload 8
    //   1151: aload_2
    //   1152: ldc_w 1208
    //   1155: invokevirtual 255	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1158: putfield 1033	adxk:bvS	Ljava/lang/String;
    //   1161: aload 9
    //   1163: aload 8
    //   1165: putfield 1067	adxm:e	Ladxk;
    //   1168: aload 8
    //   1170: getfield 297	adxk:zipName	Ljava/lang/String;
    //   1173: invokestatic 361	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1176: ifne +17 -> 1193
    //   1179: aload 9
    //   1181: getfield 1170	adxm:ba	Ljava/util/HashSet;
    //   1184: aload 8
    //   1186: getfield 297	adxk:zipName	Ljava/lang/String;
    //   1189: invokevirtual 1173	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1192: pop
    //   1193: aload 10
    //   1195: ldc_w 1216
    //   1198: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1201: ifeq +426 -> 1627
    //   1204: aload 10
    //   1206: ldc_w 1216
    //   1209: invokevirtual 274	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1212: astore_2
    //   1213: new 75	java/util/ArrayList
    //   1216: dup
    //   1217: invokespecial 76	java/util/ArrayList:<init>	()V
    //   1220: astore 8
    //   1222: iconst_0
    //   1223: istore 5
    //   1225: iload 5
    //   1227: aload_2
    //   1228: invokevirtual 284	org/json/JSONArray:length	()I
    //   1231: if_icmpge +389 -> 1620
    //   1234: aload_2
    //   1235: iload 5
    //   1237: invokevirtual 833	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1240: astore 11
    //   1242: aload 11
    //   1244: ldc_w 1162
    //   1247: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1250: ifeq +818 -> 2068
    //   1253: aload_0
    //   1254: aload 11
    //   1256: ldc_w 1162
    //   1259: invokevirtual 255	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1262: aload 10
    //   1264: invokespecial 1164	com/tencent/mobileqq/bubble/BubbleManager:c	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1267: astore 12
    //   1269: aload 12
    //   1271: ifnonnull +231 -> 1502
    //   1274: goto +794 -> 2068
    //   1277: astore_2
    //   1278: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1281: ifeq -968 -> 313
    //   1284: ldc 208
    //   1286: iconst_2
    //   1287: ldc_w 1218
    //   1290: aload_2
    //   1291: invokestatic 728	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1294: goto -981 -> 313
    //   1297: astore_2
    //   1298: ldc 208
    //   1300: iconst_1
    //   1301: new 175	java/lang/StringBuilder
    //   1304: dup
    //   1305: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   1308: ldc_w 1220
    //   1311: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: iload_1
    //   1315: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1318: ldc_w 1222
    //   1321: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1327: aload_2
    //   1328: invokestatic 728	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1331: aconst_null
    //   1332: areturn
    //   1333: astore_2
    //   1334: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1337: ifeq -954 -> 383
    //   1340: ldc 208
    //   1342: iconst_2
    //   1343: ldc_w 1224
    //   1346: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1349: goto -966 -> 383
    //   1352: astore_2
    //   1353: ldc 208
    //   1355: iconst_1
    //   1356: ldc_w 1226
    //   1359: aload_2
    //   1360: invokestatic 728	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1363: goto -32 -> 1331
    //   1366: astore_2
    //   1367: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1370: ifeq -917 -> 453
    //   1373: ldc 208
    //   1375: iconst_2
    //   1376: ldc_w 1228
    //   1379: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1382: goto -929 -> 453
    //   1385: astore_2
    //   1386: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1389: ifeq -860 -> 529
    //   1392: ldc 208
    //   1394: iconst_2
    //   1395: ldc_w 1230
    //   1398: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1401: goto -872 -> 529
    //   1404: aload 10
    //   1406: ldc_w 1232
    //   1409: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1412: ifeq -883 -> 529
    //   1415: aload 9
    //   1417: iconst_1
    //   1418: putfield 1235	adxm:bRF	Z
    //   1421: aload 10
    //   1423: ldc_w 1232
    //   1426: invokevirtual 255	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1429: astore 8
    //   1431: aload 8
    //   1433: astore_2
    //   1434: aload 8
    //   1436: ldc_w 1119
    //   1439: invokevirtual 1122	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1442: ifeq +10 -> 1452
    //   1445: aload 8
    //   1447: iconst_2
    //   1448: invokevirtual 1094	java/lang/String:substring	(I)Ljava/lang/String;
    //   1451: astore_2
    //   1452: aload 9
    //   1454: new 175	java/lang/StringBuilder
    //   1457: dup
    //   1458: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   1461: ldc_w 1124
    //   1464: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1467: aload_2
    //   1468: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1471: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1474: invokestatic 1127	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1477: putfield 1143	adxm:strokeColor	I
    //   1480: goto -951 -> 529
    //   1483: astore_2
    //   1484: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1487: ifeq -958 -> 529
    //   1490: ldc 208
    //   1492: iconst_2
    //   1493: ldc_w 1230
    //   1496: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1499: goto -970 -> 529
    //   1502: aload_0
    //   1503: iconst_1
    //   1504: aload 12
    //   1506: invokespecial 1166	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Ladxk;
    //   1509: astore 12
    //   1511: aload 11
    //   1513: ldc_w 1237
    //   1516: invokevirtual 274	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1519: astore 13
    //   1521: aload 12
    //   1523: aload 13
    //   1525: invokevirtual 284	org/json/JSONArray:length	()I
    //   1528: anewarray 173	java/lang/String
    //   1531: putfield 1240	adxk:ev	[Ljava/lang/String;
    //   1534: iconst_0
    //   1535: istore 6
    //   1537: iload 6
    //   1539: aload 13
    //   1541: invokevirtual 284	org/json/JSONArray:length	()I
    //   1544: if_icmpge +27 -> 1571
    //   1547: aload 12
    //   1549: getfield 1240	adxk:ev	[Ljava/lang/String;
    //   1552: iload 6
    //   1554: aload 13
    //   1556: iload 6
    //   1558: invokevirtual 1242	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1561: aastore
    //   1562: iload 6
    //   1564: iconst_1
    //   1565: iadd
    //   1566: istore 6
    //   1568: goto -31 -> 1537
    //   1571: aload 12
    //   1573: aload 11
    //   1575: ldc_w 1162
    //   1578: invokevirtual 255	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1581: putfield 1033	adxk:bvS	Ljava/lang/String;
    //   1584: aload 8
    //   1586: aload 12
    //   1588: invokevirtual 836	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1591: pop
    //   1592: aload 12
    //   1594: getfield 297	adxk:zipName	Ljava/lang/String;
    //   1597: invokestatic 361	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1600: ifne +468 -> 2068
    //   1603: aload 9
    //   1605: getfield 1170	adxm:ba	Ljava/util/HashSet;
    //   1608: aload 12
    //   1610: getfield 297	adxk:zipName	Ljava/lang/String;
    //   1613: invokevirtual 1173	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1616: pop
    //   1617: goto +451 -> 2068
    //   1620: aload 9
    //   1622: aload 8
    //   1624: putfield 1070	adxm:uY	Ljava/util/ArrayList;
    //   1627: aload 9
    //   1629: iload_1
    //   1630: aload 10
    //   1632: invokestatic 1247	adye:a	(ILorg/json/JSONObject;)Ljava/util/HashMap;
    //   1635: putfield 1250	adxm:jN	Ljava/util/HashMap;
    //   1638: aload 10
    //   1640: ldc_w 1252
    //   1643: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1646: ifeq +211 -> 1857
    //   1649: aload 10
    //   1651: ldc_w 1252
    //   1654: invokevirtual 566	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1657: astore 8
    //   1659: new 262	adxk
    //   1662: dup
    //   1663: invokespecial 263	adxk:<init>	()V
    //   1666: astore_2
    //   1667: aload 8
    //   1669: ldc_w 1254
    //   1672: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1675: ifeq +15 -> 1690
    //   1678: aload_2
    //   1679: aload 8
    //   1681: ldc_w 1254
    //   1684: invokevirtual 241	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1687: putfield 1257	adxk:cKI	I
    //   1690: aload 8
    //   1692: ldc_w 1208
    //   1695: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1698: ifeq +159 -> 1857
    //   1701: aload 8
    //   1703: ldc_w 1208
    //   1706: invokevirtual 255	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1709: astore 8
    //   1711: aload_2
    //   1712: aload 8
    //   1714: putfield 1033	adxk:bvS	Ljava/lang/String;
    //   1717: aload_0
    //   1718: aload 8
    //   1720: aload 10
    //   1722: invokespecial 585	com/tencent/mobileqq/bubble/BubbleManager:d	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1725: astore 11
    //   1727: aload 11
    //   1729: ifnull +128 -> 1857
    //   1732: aload_2
    //   1733: aload 11
    //   1735: ldc_w 294
    //   1738: invokevirtual 255	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1741: putfield 297	adxk:zipName	Ljava/lang/String;
    //   1744: aload 11
    //   1746: ldc_w 1259
    //   1749: invokevirtual 274	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1752: astore 8
    //   1754: aload 11
    //   1756: ldc_w 547
    //   1759: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1762: ifeq +66 -> 1828
    //   1765: aload 11
    //   1767: ldc_w 547
    //   1770: invokevirtual 274	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1773: astore 11
    //   1775: aload 11
    //   1777: ifnull +51 -> 1828
    //   1780: aload 11
    //   1782: invokevirtual 284	org/json/JSONArray:length	()I
    //   1785: ifle +43 -> 1828
    //   1788: aload_2
    //   1789: aload 11
    //   1791: iconst_0
    //   1792: invokevirtual 287	org/json/JSONArray:getInt	(I)I
    //   1795: putfield 550	adxk:cKD	I
    //   1798: aload_2
    //   1799: aload 11
    //   1801: iconst_1
    //   1802: invokevirtual 287	org/json/JSONArray:getInt	(I)I
    //   1805: putfield 553	adxk:cKF	I
    //   1808: aload_2
    //   1809: aload 11
    //   1811: iconst_2
    //   1812: invokevirtual 287	org/json/JSONArray:getInt	(I)I
    //   1815: putfield 556	adxk:cKE	I
    //   1818: aload_2
    //   1819: aload 11
    //   1821: iconst_3
    //   1822: invokevirtual 287	org/json/JSONArray:getInt	(I)I
    //   1825: putfield 559	adxk:cKG	I
    //   1828: aload 8
    //   1830: ifnull +21 -> 1851
    //   1833: aload 8
    //   1835: invokevirtual 284	org/json/JSONArray:length	()I
    //   1838: ifle +13 -> 1851
    //   1841: aload_2
    //   1842: aload_0
    //   1843: aload 8
    //   1845: invokespecial 1261	com/tencent/mobileqq/bubble/BubbleManager:c	(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    //   1848: putfield 1048	adxk:uX	Ljava/util/ArrayList;
    //   1851: aload 9
    //   1853: aload_2
    //   1854: putfield 1044	adxm:f	Ladxk;
    //   1857: aload 10
    //   1859: ldc_w 1263
    //   1862: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1865: ifeq +200 -> 2065
    //   1868: aload 10
    //   1870: ldc_w 1263
    //   1873: invokevirtual 566	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1876: astore_2
    //   1877: aload_2
    //   1878: ldc_w 1237
    //   1881: invokevirtual 1266	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1884: astore 8
    //   1886: aload 9
    //   1888: new 602	java/util/HashMap
    //   1891: dup
    //   1892: invokespecial 1267	java/util/HashMap:<init>	()V
    //   1895: putfield 600	adxm:jO	Ljava/util/HashMap;
    //   1898: aload 8
    //   1900: ifnull +66 -> 1966
    //   1903: aload 8
    //   1905: invokevirtual 284	org/json/JSONArray:length	()I
    //   1908: ifle +58 -> 1966
    //   1911: aload 9
    //   1913: new 75	java/util/ArrayList
    //   1916: dup
    //   1917: aload 8
    //   1919: invokevirtual 284	org/json/JSONArray:length	()I
    //   1922: invokespecial 830	java/util/ArrayList:<init>	(I)V
    //   1925: putfield 1270	adxm:va	Ljava/util/ArrayList;
    //   1928: iconst_0
    //   1929: istore 5
    //   1931: iload 5
    //   1933: aload 8
    //   1935: invokevirtual 284	org/json/JSONArray:length	()I
    //   1938: if_icmpge +28 -> 1966
    //   1941: aload 9
    //   1943: getfield 1270	adxm:va	Ljava/util/ArrayList;
    //   1946: aload 8
    //   1948: iload 5
    //   1950: invokevirtual 1242	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1953: invokevirtual 836	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1956: pop
    //   1957: iload 5
    //   1959: iconst_1
    //   1960: iadd
    //   1961: istore 5
    //   1963: goto -32 -> 1931
    //   1966: aload 9
    //   1968: aload 10
    //   1970: ldc_w 1272
    //   1973: iconst_m1
    //   1974: invokevirtual 1275	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1977: putfield 1278	adxm:cKM	I
    //   1980: aload 9
    //   1982: getfield 1278	adxm:cKM	I
    //   1985: iconst_m1
    //   1986: if_icmpne +17 -> 2003
    //   1989: aload 9
    //   1991: aload 10
    //   1993: ldc_w 1280
    //   1996: iconst_m1
    //   1997: invokevirtual 1275	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2000: putfield 1278	adxm:cKM	I
    //   2003: aload 9
    //   2005: aload 10
    //   2007: ldc_w 1282
    //   2010: iconst_2
    //   2011: invokevirtual 1275	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2014: putfield 1285	adxm:cKN	I
    //   2017: aload_0
    //   2018: aload 9
    //   2020: aload 10
    //   2022: aload_2
    //   2023: ldc_w 1287
    //   2026: invokespecial 1289	com/tencent/mobileqq/bubble/BubbleManager:a	(Ladxm;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   2029: aload_0
    //   2030: aload 9
    //   2032: aload 10
    //   2034: aload_2
    //   2035: ldc_w 1291
    //   2038: invokespecial 1289	com/tencent/mobileqq/bubble/BubbleManager:a	(Ladxm;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   2041: aload_0
    //   2042: aload 9
    //   2044: aload 10
    //   2046: aload_2
    //   2047: ldc_w 1293
    //   2050: invokespecial 1289	com/tencent/mobileqq/bubble/BubbleManager:a	(Ladxm;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   2053: aload_0
    //   2054: aload 9
    //   2056: aload 10
    //   2058: aload_2
    //   2059: ldc_w 1295
    //   2062: invokespecial 1289	com/tencent/mobileqq/bubble/BubbleManager:a	(Ladxm;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   2065: aload 9
    //   2067: areturn
    //   2068: iload 5
    //   2070: iconst_1
    //   2071: iadd
    //   2072: istore 5
    //   2074: goto -849 -> 1225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2077	0	this	BubbleManager
    //   0	2077	1	paramInt	int
    //   0	2077	2	paramString	String
    //   941	11	3	d	double
    //   233	1840	5	j	int
    //   1535	32	6	k	int
    //   187	3	7	bool	boolean
    //   56	1891	8	localObject1	Object
    //   154	1912	9	localadxm	adxm
    //   164	1893	10	localJSONObject	JSONObject
    //   733	1087	11	localObject2	Object
    //   1267	342	12	localObject3	Object
    //   1519	36	13	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   194	203	1277	java/lang/Exception
    //   207	232	1277	java/lang/Exception
    //   235	262	1277	java/lang/Exception
    //   271	313	1277	java/lang/Exception
    //   51	66	1297	org/json/JSONException
    //   68	101	1297	org/json/JSONException
    //   104	112	1297	org/json/JSONException
    //   115	124	1297	org/json/JSONException
    //   127	146	1297	org/json/JSONException
    //   146	189	1297	org/json/JSONException
    //   194	203	1297	org/json/JSONException
    //   207	232	1297	org/json/JSONException
    //   235	262	1297	org/json/JSONException
    //   271	313	1297	org/json/JSONException
    //   313	334	1297	org/json/JSONException
    //   337	355	1297	org/json/JSONException
    //   355	383	1297	org/json/JSONException
    //   383	404	1297	org/json/JSONException
    //   407	425	1297	org/json/JSONException
    //   425	453	1297	org/json/JSONException
    //   453	480	1297	org/json/JSONException
    //   483	501	1297	org/json/JSONException
    //   501	529	1297	org/json/JSONException
    //   529	587	1297	org/json/JSONException
    //   587	632	1297	org/json/JSONException
    //   637	690	1297	org/json/JSONException
    //   690	735	1297	org/json/JSONException
    //   740	829	1297	org/json/JSONException
    //   829	874	1297	org/json/JSONException
    //   879	957	1297	org/json/JSONException
    //   957	989	1297	org/json/JSONException
    //   989	1034	1297	org/json/JSONException
    //   1039	1091	1297	org/json/JSONException
    //   1091	1136	1297	org/json/JSONException
    //   1141	1193	1297	org/json/JSONException
    //   1193	1222	1297	org/json/JSONException
    //   1225	1269	1297	org/json/JSONException
    //   1278	1294	1297	org/json/JSONException
    //   1334	1349	1297	org/json/JSONException
    //   1367	1382	1297	org/json/JSONException
    //   1386	1401	1297	org/json/JSONException
    //   1404	1431	1297	org/json/JSONException
    //   1434	1452	1297	org/json/JSONException
    //   1452	1480	1297	org/json/JSONException
    //   1484	1499	1297	org/json/JSONException
    //   1502	1534	1297	org/json/JSONException
    //   1537	1562	1297	org/json/JSONException
    //   1571	1617	1297	org/json/JSONException
    //   1620	1627	1297	org/json/JSONException
    //   1627	1690	1297	org/json/JSONException
    //   1690	1727	1297	org/json/JSONException
    //   1732	1775	1297	org/json/JSONException
    //   1780	1828	1297	org/json/JSONException
    //   1833	1851	1297	org/json/JSONException
    //   1851	1857	1297	org/json/JSONException
    //   1857	1898	1297	org/json/JSONException
    //   1903	1928	1297	org/json/JSONException
    //   1931	1957	1297	org/json/JSONException
    //   1966	2003	1297	org/json/JSONException
    //   2003	2065	1297	org/json/JSONException
    //   355	383	1333	java/lang/Exception
    //   51	66	1352	java/lang/Exception
    //   68	101	1352	java/lang/Exception
    //   104	112	1352	java/lang/Exception
    //   115	124	1352	java/lang/Exception
    //   127	146	1352	java/lang/Exception
    //   146	189	1352	java/lang/Exception
    //   313	334	1352	java/lang/Exception
    //   337	355	1352	java/lang/Exception
    //   383	404	1352	java/lang/Exception
    //   407	425	1352	java/lang/Exception
    //   453	480	1352	java/lang/Exception
    //   483	501	1352	java/lang/Exception
    //   529	587	1352	java/lang/Exception
    //   587	632	1352	java/lang/Exception
    //   637	690	1352	java/lang/Exception
    //   690	735	1352	java/lang/Exception
    //   740	829	1352	java/lang/Exception
    //   829	874	1352	java/lang/Exception
    //   879	957	1352	java/lang/Exception
    //   957	989	1352	java/lang/Exception
    //   989	1034	1352	java/lang/Exception
    //   1039	1091	1352	java/lang/Exception
    //   1091	1136	1352	java/lang/Exception
    //   1141	1193	1352	java/lang/Exception
    //   1193	1222	1352	java/lang/Exception
    //   1225	1269	1352	java/lang/Exception
    //   1278	1294	1352	java/lang/Exception
    //   1334	1349	1352	java/lang/Exception
    //   1367	1382	1352	java/lang/Exception
    //   1386	1401	1352	java/lang/Exception
    //   1404	1431	1352	java/lang/Exception
    //   1434	1452	1352	java/lang/Exception
    //   1484	1499	1352	java/lang/Exception
    //   1502	1534	1352	java/lang/Exception
    //   1537	1562	1352	java/lang/Exception
    //   1571	1617	1352	java/lang/Exception
    //   1620	1627	1352	java/lang/Exception
    //   1627	1690	1352	java/lang/Exception
    //   1690	1727	1352	java/lang/Exception
    //   1732	1775	1352	java/lang/Exception
    //   1780	1828	1352	java/lang/Exception
    //   1833	1851	1352	java/lang/Exception
    //   1851	1857	1352	java/lang/Exception
    //   1857	1898	1352	java/lang/Exception
    //   1903	1928	1352	java/lang/Exception
    //   1931	1957	1352	java/lang/Exception
    //   1966	2003	1352	java/lang/Exception
    //   2003	2065	1352	java/lang/Exception
    //   425	453	1366	java/lang/Exception
    //   501	529	1385	java/lang/Exception
    //   1452	1480	1483	java/lang/Exception
  }
  
  public adxm a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localObject = null;
      return localObject;
    }
    adxm localadxm = (adxm)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.get(Integer.valueOf(paramInt));
    if (localadxm == null)
    {
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break label116;
      }
      ThreadManager.post(new HandleBubbleConfigRunnable(paramInt, paramBoolean), 5, null, true);
    }
    for (;;)
    {
      localObject = localadxm;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("BubbleManager", 2, "getBubbleConfig bubbleId=" + paramInt + ",autoDownload=" + paramBoolean + ",bubbleConfig=" + localadxm);
      return localadxm;
      label116:
      new HandleBubbleConfigRunnable(paramInt, paramBoolean).run();
    }
  }
  
  public adxp a(int paramInt, boolean paramBoolean)
  {
    if (paramInt < 1) {
      ??? = null;
    }
    Object localObject2;
    do
    {
      return ???;
      localObject2 = (adxp)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$a.get(Integer.valueOf(paramInt));
      if (localObject2 == null) {
        break;
      }
      ??? = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("BubbleManager", 2, "getBubbleInfo, from cache, bubbleId=" + paramInt);
    return localObject2;
    if ((paramBoolean) && (!this.B.contains(Integer.valueOf(paramInt)))) {
      synchronized (this.B)
      {
        localObject2 = new BubbleManager.2(this, paramInt);
        this.B.add(Integer.valueOf(paramInt));
        ThreadManager.post((Runnable)localObject2, 8, null, true);
      }
    }
    return null;
  }
  
  public b a(QQAppInterface paramQQAppInterface, TextView paramTextView, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject2 = (BubbleManager)paramQQAppInterface.getManager(44);
    Object localObject1 = null;
    adxp localadxp = adyd.a(paramInt1, paramQQAppInterface, null, null);
    if (localadxp.ew != null)
    {
      paramQQAppInterface = localadxp.ew;
      if ((paramQQAppInterface == null) || (localObject2 == null) || (!((BubbleManager)localObject2).afN())) {
        break label621;
      }
      if (paramInt2 >= 10) {
        break label88;
      }
      paramQQAppInterface = paramQQAppInterface[0];
    }
    for (;;)
    {
      if (paramQQAppInterface != null) {
        break label109;
      }
      return null;
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (paramInt1 <= 0) {
        break;
      }
      paramQQAppInterface = ((BubbleManager)localObject2).h(paramInt1);
      break;
      label88:
      if (paramInt2 < 100) {
        paramQQAppInterface = paramQQAppInterface[1];
      } else {
        paramQQAppInterface = paramQQAppInterface[2];
      }
    }
    label109:
    localObject2 = (Bitmap)this.q.get(paramQQAppInterface);
    if ((localObject2 != null) || (new File(paramQQAppInterface).exists()))
    {
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = BitmapFactory.decodeFile(paramQQAppInterface);
        if (localObject1 != null) {
          this.q.put(paramQQAppInterface, localObject1);
        }
      }
      else if ((this.bN != null) && (TextUtils.equals(paramString, this.bwe))) {}
      for (;;)
      {
        try
        {
          if (this.bN == null)
          {
            this.bwe = paramString;
            this.bN = new Rect();
            paramQQAppInterface = paramTextView.getText();
            paramString = new Rect(paramTextView.getPaddingLeft(), paramTextView.getPaddingTop(), paramTextView.getPaddingRight(), paramTextView.getPaddingBottom());
            localObject2 = paramTextView.getBackground();
            paramTextView.setText("1");
            paramTextView.measure(0, 0);
            int i1 = paramTextView.getMeasuredWidth();
            if (Build.VERSION.SDK_INT >= 16)
            {
              paramTextView.setBackground(new BitmapDrawable((Bitmap)localObject1));
              paramTextView.setPadding(0, 0, 0, 0);
              paramTextView.measure(0, 0);
              paramInt2 = paramTextView.getMeasuredWidth();
              paramInt1 = paramTextView.getMeasuredHeight();
              int j = Math.max((i1 - paramInt2) / 2, 0);
              int m = Math.max((i1 - paramInt1) / 2, 0);
              int k = Math.max(i1 - paramInt2 - j, 0);
              int n = Math.max(i1 - paramInt1 - m, 0);
              paramTextView.setPadding(k, n, j, m);
              paramTextView.measure(0, 0);
              int i2 = i1 - paramTextView.getMeasuredWidth();
              paramInt2 = k;
              paramInt1 = j;
              if (i2 != 0)
              {
                paramInt2 = k + i2 / 2;
                paramInt1 = j + (i2 - i2 / 2);
              }
              i1 -= paramTextView.getMeasuredHeight();
              k = n;
              j = m;
              if (i1 != 0)
              {
                k = n + i1 / 2;
                j = m + (i1 - i1 / 2);
              }
              this.bN.set(paramInt2, k, paramInt1, j);
              paramTextView.setText(paramQQAppInterface);
              if (Build.VERSION.SDK_INT < 16) {
                break label607;
              }
              paramTextView.setBackground((Drawable)localObject2);
              paramTextView.setPadding(paramString.left, paramString.top, paramString.right, paramString.bottom);
            }
          }
          else
          {
            paramQQAppInterface = new BitmapDrawable((Bitmap)localObject1);
            if (localadxp.bubbleId <= 0) {
              break label616;
            }
            paramInt1 = localadxp.mTextColor;
            return new b(paramQQAppInterface, paramInt1, this.bN);
            if (QLog.isColorLevel()) {
              QLog.d("BubbleManager", 1, "find no bubble unread : decode error");
            }
            return null;
          }
          paramTextView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject1));
          continue;
          paramTextView.setBackgroundDrawable((Drawable)localObject2);
        }
        finally {}
        label607:
        continue;
        label616:
        paramInt1 = -1;
      }
    }
    label621:
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 1, "find no bubble unread");
    }
    return null;
  }
  
  public Pair<adxp.a, adxp.a> a(int paramInt, adxk paramadxk, boolean paramBoolean)
  {
    boolean bool = false;
    if ((paramadxk == null) || (TextUtils.isEmpty(paramadxk.zipName)) || (TextUtils.isEmpty(paramadxk.bvS))) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "parseAnimToCommonAttrs, bubbleId = " + paramInt + " autoDown = " + paramBoolean);
    }
    adxp.a locala = a(paramInt, paramadxk.bvS, paramBoolean, false);
    if (locala == null) {
      return null;
    }
    if (paramadxk.zipName.equals(paramadxk.bvT)) {
      bool = true;
    }
    return new Pair(locala, a(paramInt, paramadxk.bvT, paramBoolean, bool));
  }
  
  public Pair<adxp.a, adxp.a> a(int paramInt, String paramString, Pair<adxp.a, adxp.a> paramPair)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("chkAnimCommAttrs, bubbleId = ").append(paramInt).append(" animName = ").append(paramString).append(" commonAttrs is null ? ");
      if (paramPair != null) {
        break label133;
      }
    }
    label133:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("BubbleManager", 2, String.valueOf(bool));
      localObject = paramPair;
      if (paramPair == null)
      {
        paramString = a(paramInt, a(paramInt, paramString), true);
        localObject = paramString;
        if (paramString != null)
        {
          paramPair = (adxp)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$a.get(Integer.valueOf(paramInt));
          localObject = paramString;
          if (paramPair != null)
          {
            paramPair.yu.add(paramString);
            localObject = paramString;
          }
        }
      }
      return localObject;
    }
  }
  
  public File a(int paramInt, boolean paramBoolean)
  {
    String str = A().getAbsolutePath();
    Object localObject = str;
    if (paramBoolean) {
      localObject = str + "/temp";
    }
    localObject = new File((String)localObject + File.separatorChar + paramInt);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return localObject;
  }
  
  public void a(int paramInt, String[] paramArrayOfString, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "downloadBubbleGather, bubbleId = " + paramInt + " pkgName[]= " + paramArrayOfString + " from = " + paramString);
    }
    if (paramInt == 0) {}
    VasQuickUpdateManager localVasQuickUpdateManager;
    do
    {
      return;
      localVasQuickUpdateManager = (VasQuickUpdateManager)this.mApp.getManager(184);
    } while (localVasQuickUpdateManager == null);
    String str = "bubble.android." + paramInt + "." + "all.zip";
    if ("0".equals(paramString))
    {
      synchronized (this.yz)
      {
        if (this.yz.contains(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("BubbleManager", 2, str + " is downloading, remove duplicate download.");
          }
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, str + " add download queue.");
      }
      this.yz.add(str);
    }
    if (paramArrayOfString == null)
    {
      paramArrayOfString = new String[3];
      paramArrayOfString[0] = ("bubble.android." + paramInt + "." + "config.json");
      paramArrayOfString[1] = ("bubble.android." + paramInt + "." + "static.zip");
      paramArrayOfString[2] = ("bubble.android." + paramInt + "." + "other.zip");
    }
    for (;;)
    {
      localVasQuickUpdateManager.downloadGatherItem(2L, str, paramArrayOfString, paramString);
      this.y.put(Integer.valueOf(paramInt), Float.valueOf(0.0F));
      return;
    }
  }
  
  public void a(aqvd paramaqvd)
  {
    this.jdField_a_of_type_Aqvd = paramaqvd;
  }
  
  public void a(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    int j = aqiw.getSystemNetwork(this.mContext);
    String str = "0";
    if (this.mApp != null) {
      str = VipUtils.d(this.mApp, this.mApp.getCurrentAccountUin());
    }
    anot.a(null, "CliOper", "", "", "Bubble", paramString1, 0, (int)paramLong, String.valueOf(paramInt), str, Integer.toString(j), paramString2);
  }
  
  public boolean aN(int paramInt1, int paramInt2)
  {
    Object localObject2 = a(paramInt1, false);
    if (localObject2 == null) {}
    label44:
    while (((List)localObject1).size() <= 0)
    {
      return false;
      localObject1 = new ArrayList();
      switch (paramInt2)
      {
      }
    }
    Object localObject1 = ((List)localObject1).iterator();
    paramInt2 = 1;
    label65:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (adyc)((Iterator)localObject1).next();
      if (!this.eS.containsKey(((adyc)localObject2).key))
      {
        File localFile = new File(d(paramInt1), ((adyc)localObject2).zipName);
        int j = 0;
        for (;;)
        {
          int k = paramInt2;
          if (j < ((adyc)localObject2).cLb)
          {
            String str = localFile.getAbsolutePath() + File.separatorChar + ((adyc)localObject2).bwg + String.format("%04d.png", new Object[] { Integer.valueOf(j + 1) });
            if (!new File(str).exists())
            {
              QLog.e("BubbleManager", 2, "anim conf, file is not exit, " + str);
              k = 0;
            }
          }
          else
          {
            paramInt2 = k;
            if (k == 0) {
              break label65;
            }
            this.eS.put(((adyc)localObject2).key, localObject2);
            paramInt2 = k;
            break label65;
            if ((((adxm)localObject2).jO == null) || (((adxm)localObject2).jO.size() <= 0)) {
              break;
            }
            localObject2 = ((adxm)localObject2).jO.values().iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((List)localObject1).add(((Iterator)localObject2).next());
            }
            break label44;
          }
          j += 1;
        }
      }
    }
    if (paramInt2 == 0)
    {
      K(paramInt1, "other.zip", "0");
      return false;
    }
    return true;
  }
  
  public boolean afN()
  {
    if (this.cKV == 0) {
      if (!this.mApp.getApp().getSharedPreferences(this.mApp.getCurrentAccountUin(), 0).getBoolean("svip_bubble_unread_switch", true)) {
        break label89;
      }
    }
    label89:
    for (int j = 1;; j = -1)
    {
      this.cKV = j;
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "showBubbleUnread " + this.cKV);
      }
      if (this.cKV != 1) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public boolean afO()
  {
    return QzoneConfig.getInstance().getConfig("K_QQ_VAS", "SK_QQ_VAS_ShowSwitchPersonalUnread", 0) == 1;
  }
  
  public Boolean b(int paramInt)
  {
    if (!new File(A(), Integer.toString(paramInt)).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "bubble dir does not exist id:" + paramInt);
      }
      return Boolean.valueOf(false);
    }
    for (;;)
    {
      synchronized (this.i)
      {
        JSONObject localJSONObject = (JSONObject)this.i.get(Integer.valueOf(paramInt));
        if (localJSONObject == null) {
          break;
        }
        if (localJSONObject.optInt("full_download") == 1)
        {
          bool = true;
          return Boolean.valueOf(bool);
        }
      }
      bool = false;
    }
    boolean bool = iU(paramInt);
    return Boolean.valueOf(bool);
  }
  
  public void b(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (!paramString1.startsWith("bubble.android."))) {}
    while (!paramString1.endsWith("all.zip")) {
      return;
    }
    int j = cI(paramString1);
    float f = (float)paramLong1 / (float)paramLong2;
    this.y.put(Integer.valueOf(j), Float.valueOf(f));
  }
  
  public boolean bV(long paramLong)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$a != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$a.containsKey((int)paramLong));
  }
  
  public int cI(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("\\.");
      if (paramString.length == 5)
      {
        paramString = paramString[2];
        try
        {
          int j = Integer.parseInt(paramString);
          return j;
        }
        catch (NumberFormatException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("BubbleManager", 2, "getBubbleIdFromScid: parse bubbleId error", paramString);
          }
        }
      }
    }
    return 0;
  }
  
  public void ci(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 2, "startDownload id=" + paramInt + " callbackId = " + paramString);
    }
    Bundle localBundle = new Bundle();
    if (paramString != null)
    {
      localBundle.putInt("srcType", 3);
      localBundle.putString("callbackId", paramString);
    }
    if (b(paramInt).booleanValue()) {
      if ((this.jdField_a_of_type_Aqvd != null) && (paramString != null)) {
        this.jdField_a_of_type_Aqvd.a(paramInt, 3, localBundle);
      }
    }
    do
    {
      return;
      if (aqiw.isNetSupport(this.mContext)) {
        break;
      }
    } while ((this.jdField_a_of_type_Aqvd == null) || (paramString == null));
    this.jdField_a_of_type_Aqvd.a(paramInt, -1, localBundle);
    return;
    a(paramInt, null, paramString);
  }
  
  public File d(int paramInt)
  {
    File localFile = new File(A(), String.valueOf(paramInt));
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, String.format("onPasterDownloadComplete, scid %s, errorcode %d", new Object[] { paramString1, Integer.valueOf(paramInt1) }));
    }
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.startsWith("bubble.paster.")))
    {
      paramString1 = paramString1.replace("bubble.paster.", "").replace(".png", "");
      adxn.a().Bw(paramString1);
    }
  }
  
  public JSONObject e(int paramInt)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      if (b(paramInt).booleanValue())
      {
        localJSONObject2.put("status", 3);
        localJSONObject2.put("progress", 100);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", acfp.m(2131703267));
      }
      for (;;)
      {
        localJSONObject2.put("id", paramInt);
        localJSONObject1.put("data", localJSONObject2);
        if (QLog.isColorLevel()) {
          QLog.d("BubbleManager", 2, "queryInfo bubbleId=" + paramInt + ",json=" + localJSONObject1.toString());
        }
        return localJSONObject1;
        if (!this.y.containsKey(Integer.valueOf(paramInt))) {
          break label345;
        }
        f = ((Float)this.y.get(Integer.valueOf(paramInt))).floatValue();
        if (f != 1.0F) {
          break;
        }
        localJSONObject2.put("status", 3);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", acfp.m(2131703270));
        break label393;
        localJSONObject2.put("canceling", j);
        localJSONObject2.put("progress", 100.0F * f);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        float f;
        int j;
        localJSONException.printStackTrace();
        continue;
        if (f == 2.0F)
        {
          localJSONException.put("status", 1);
          localJSONObject1.put("result", -1);
          localJSONObject1.put("message", acfp.m(2131703268));
        }
        else
        {
          localJSONException.put("status", 2);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", acfp.m(2131703266));
          break label393;
          label345:
          localJSONException.put("status", 1);
          localJSONException.put("progress", 0);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", acfp.m(2131703265));
          continue;
        }
        label393:
        if (f == 3.0F) {
          j = 1;
        } else {
          j = 0;
        }
      }
    }
  }
  
  public void e(String paramString1, String arg2, String paramString3, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, String.format("onDownloadComplete, scid %s, errorcode %d, from %s, httpCode %d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString3, Integer.valueOf(paramInt2) }));
    }
    if ((TextUtils.isEmpty(paramString1)) || (!paramString1.startsWith("bubble.android."))) {}
    label343:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                for (;;)
                {
                  return;
                  paramInt2 = cI(paramString1);
                  if (paramInt1 == 0) {
                    this.y.put(Integer.valueOf(paramInt2), Float.valueOf(1.0F));
                  }
                  synchronized (this.yz)
                  {
                    if (this.yz.contains(paramString1))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("BubbleManager", 2, paramString1 + " download completed, remove from download queue.");
                      }
                      this.yz.remove(paramString1);
                    }
                    if (!paramString1.endsWith("config.json")) {
                      break label343;
                    }
                    if (paramInt1 == 0)
                    {
                      paramString1 = new File(d(paramInt2), "config.json");
                      if (paramString1.exists())
                      {
                        paramString1 = a(paramInt2, paramString1.getAbsolutePath());
                        if (QLog.isColorLevel()) {
                          QLog.d("BubbleManager", 2, "onDownloadComplete|bubbleId=" + paramInt2 + ",createBubbleConfig bubbleConfig=" + paramString1);
                        }
                        if (paramString1 == null) {
                          continue;
                        }
                        this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.put(Integer.valueOf(paramInt2), paramString1);
                        return;
                        this.y.put(Integer.valueOf(paramInt2), Float.valueOf(2.0F));
                      }
                    }
                  }
                }
              } while (!QLog.isColorLevel());
              QLog.d("BubbleManager", 2, "onDownloadComplete|" + paramString1.getAbsolutePath() + " not exist");
              return;
              if (!paramString1.endsWith("all.zip")) {
                break;
              }
              if (paramInt1 == 0) {
                LF(paramInt2);
              }
            } while ((paramString3.equals("0")) || (this.jdField_a_of_type_Aqvd == null));
            paramString1 = new Bundle();
            paramString1.putInt("srcType", 3);
            paramString1.putString("callbackId", paramString3);
            ??? = this.jdField_a_of_type_Aqvd;
            long l = paramInt2;
            if (paramInt1 == 0) {}
            for (paramInt1 = j;; paramInt1 = -1)
            {
              ???.a(l, paramInt1, paramString1);
              return;
            }
            if (!paramString1.endsWith("static.zip")) {
              break;
            }
          } while (paramInt1 != 0);
          l(paramInt2, false);
          paramString1 = a(paramInt2, a(paramInt2, "static"), false);
        } while (paramString1 == null);
        ??? = (adxp)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$a.get(Integer.valueOf(paramInt2));
      } while (??? == null);
      ???.yu.add(paramString1);
      return;
    } while ((!paramString1.endsWith("other.zip")) || (paramInt1 != 0));
    l(paramInt2, false);
  }
  
  public JSONObject f(int paramInt)
  {
    Object localObject = (VasQuickUpdateManager)this.mApp.getManager(184);
    if (localObject != null) {
      ((VasQuickUpdateManager)localObject).cancelDwonloadItem(2L, "bubble.android." + paramInt + "." + "all.zip");
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("status", 0);
      ((JSONObject)localObject).put("message", acfp.m(2131703269));
      ((JSONObject)localObject).put("id", paramInt);
      ((JSONObject)localObject).put("result", 0);
      label104:
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "stopDownload id=" + paramInt + ",status=" + 0);
      }
      this.y.put(Integer.valueOf(paramInt), Float.valueOf(3.0F));
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      break label104;
    }
  }
  
  public String[] h(int paramInt)
  {
    String str1 = d(paramInt).getAbsolutePath() + File.separatorChar + "unread" + File.separatorChar + "unread1.png";
    String str2 = d(paramInt).getAbsolutePath() + File.separatorChar + "unread" + File.separatorChar + "unread2.png";
    String str3 = d(paramInt).getAbsolutePath() + File.separatorChar + "unread" + File.separatorChar + "unread3.png";
    if ((new File(str1).exists()) && (new File(str2).exists()) && (new File(str3).exists())) {
      return new String[] { str1, str2, str3 };
    }
    return null;
  }
  
  public boolean iV(int paramInt)
  {
    boolean bool2 = false;
    boolean bool3 = aqva.ci(this.mApp.getApp().getApplicationContext());
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (!b(paramInt).booleanValue()) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 2, "bubbleId=" + paramInt + ",isQualityNetwork=" + bool3 + ",canFullDown=" + bool1);
    }
    return bool1;
  }
  
  public boolean isFileExists(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "scid isFileExists: " + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("bubble.android."))) {}
    int j;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return false;
                j = cI(paramString);
              } while (j <= 0);
              if (paramString.endsWith("config.json")) {
                return new File(d(j), "config.json").exists();
              }
              if (!paramString.endsWith("static.zip")) {
                break;
              }
              paramString = new File(d(j), "static");
            } while ((!paramString.exists()) || (!paramString.isDirectory()));
            paramString = paramString.list();
          } while ((paramString == null) || (paramString.length < 3));
          paramString = Arrays.asList(paramString);
        } while ((!paramString.contains("aio_user_bg_nor.9.png")) || (!paramString.contains("aio_user_pic_nor.9.png")) || (!paramString.contains("chat_bubble_thumbnail.png")));
        return true;
      } while ((!paramString.endsWith("other.zip")) || (!new File(d(j), "config.json").exists()));
      paramString = a(j, false);
    } while (paramString == null);
    return paramString.x(d(j));
  }
  
  public String kb(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      QLog.e("BubbleManager", 1, "getConfigContent file not exist : " + paramString);
      return null;
    }
    try
    {
      paramString = aqhq.readFileToString(localFile);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      QLog.e("BubbleManager", 2, paramString, new Object[0]);
      return null;
    }
    catch (IOException paramString)
    {
      QLog.e("BubbleManager", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  boolean l(int paramInt, boolean paramBoolean)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 2, "createBubbleInfo, bubbleId=" + paramInt + ", autoAsyncDownload=" + paramBoolean);
    }
    Object localObject1 = a(paramInt, paramBoolean);
    if (localObject1 == null)
    {
      QLog.e("BubbleManager", 1, "createBubbleInfo, no config, bubbleId=" + paramInt);
      this.B.remove(Integer.valueOf(paramInt));
      return false;
    }
    Object localObject4;
    int k;
    try
    {
      localObject3 = new ArrayList();
      localObject4 = new HashMap();
      if (((adxm)localObject1).uY != null)
      {
        j = 0;
        if (j < ((adxm)localObject1).uY.size())
        {
          localObject5 = (adxk)((adxm)localObject1).uY.get(j);
          k = 0;
          while (k < ((adxk)localObject5).ev.length)
          {
            localObject6 = localObject5.ev[k];
            ((ArrayList)localObject3).add(localObject6);
            ((HashMap)localObject4).put(localObject6, ((adxk)localObject5).bvS);
            k += 1;
          }
        }
      }
      localObject4 = new adxp(paramInt, "", "", "", "", ((adxm)localObject1).jdField_a_of_type_Adye$a, ((adxm)localObject1).fontColor, ((adxm)localObject1).linkColor, ((adxm)localObject1).strokeColor, ((adxm)localObject1).hasStroke, ((adxm)localObject1).bRF, ((adxm)localObject1).cs, (String[])((ArrayList)localObject3).toArray(new String[0]), null, 0, 0, null, null, (HashMap)localObject4);
      boolean bool = a((adxp)localObject4);
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "createBubbleInfo, isCheckOk=" + bool + ", bubbleId=" + paramInt);
      }
      if (!bool)
      {
        if (paramBoolean) {
          LE(paramInt);
        }
        this.B.remove(Integer.valueOf(paramInt));
        return false;
      }
      if (TextUtils.isEmpty(((adxp)localObject4).bvW)) {
        break label1014;
      }
      j = 1;
      if (TextUtils.isEmpty(((adxp)localObject4).bvX)) {
        break label1019;
      }
      k = 1;
    }
    catch (Exception localException)
    {
      Object localObject5;
      Object localObject6;
      label393:
      QLog.e("BubbleManager", 1, "createBubbleInfo failed", localException);
      return false;
    }
    Object localObject3 = null;
    localObject5 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject5).inDensity = 320;
    ((BitmapFactory.Options)localObject5).inTargetDensity = this.mContext.getResources().getDisplayMetrics().densityDpi;
    localObject1 = localObject3;
    int j = k;
    if (k != 0)
    {
      localObject1 = decodeFile(((adxp)localObject4).bvW, (BitmapFactory.Options)localObject5);
      if (localObject1 == null) {
        break label738;
      }
      localObject6 = ((Bitmap)localObject1).getNinePatchChunk();
      if ((localObject6 != null) && (NinePatch.isNinePatchChunk((byte[])localObject6)))
      {
        ((adxp)localObject4).g = new NinePatch((Bitmap)localObject1, (byte[])localObject6, null);
        j = k;
        localObject1 = localObject3;
      }
    }
    else
    {
      label504:
      localObject3 = localObject1;
      k = j;
      if (j == 0) {
        break label1031;
      }
      localObject5 = decodeFile(((adxp)localObject4).bvX, (BitmapFactory.Options)localObject5);
      if (localObject5 == null) {
        break label821;
      }
      localObject3 = ((Bitmap)localObject5).getNinePatchChunk();
      if ((localObject3 == null) || (!NinePatch.isNinePatchChunk((byte[])localObject3))) {
        break label774;
      }
      ((adxp)localObject4).h = new NinePatch((Bitmap)localObject5, (byte[])localObject3, null);
      break label1011;
    }
    for (;;)
    {
      label572:
      if (j == 0)
      {
        QLog.e("BubbleManager", 1, "createBubbleInfo, load nine patch failed, abort, bubbleId=" + paramInt);
        aqri.a(this.mApp, "individual_v2_bubble_9png_err", (String)localObject1, "norPath:" + ((adxp)localObject4).bvW + ", animatePath:" + ((adxp)localObject4).bvX, null, 0.0F);
        aqrh.is("individual_v2_bubble_9png_err", (String)localObject1);
        this.B.remove(Integer.valueOf(paramInt));
        return false;
        j = 0;
        localObject1 = "nor9pngErr";
        QLog.e("BubbleManager", 1, "createBubbleInfo, normal bg chunk null or not nine patch, chunk=" + localObject6 + ", bubbleId=" + paramInt);
        break label504;
        label738:
        j = 0;
        localObject2 = "norDecodeErr";
        QLog.e("BubbleManager", 1, "createBubbleInfo, decode normal bg null, bubbleId=" + paramInt);
        break label504;
        j = 0;
        localObject2 = "9pngErr";
        QLog.e("BubbleManager", 1, "createBubbleInfo, animation bg chunk null or not nine patch, chunk=" + localObject3 + ", bubbleId=" + paramInt);
        break label1011;
        k = 0;
        localObject3 = "decodeErr";
        QLog.e("BubbleManager", 1, "createBubbleInfo, decode animation bg null, bubbleId=" + paramInt);
        break label1031;
      }
      label774:
      label821:
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$a.put(Integer.valueOf(paramInt), localObject4);
      if (this.mApp != null)
      {
        aqnl.H(this.mApp);
        localObject2 = this.mApp.getHandler(FontSettingActivity.class);
        if (localObject2 != null)
        {
          ((MqqHandler)localObject2).removeMessages(16711697);
          ((MqqHandler)localObject2).sendMessageDelayed(((MqqHandler)localObject2).obtainMessage(16711697), VM);
        }
      }
      this.B.remove(Integer.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "createBubbleInfo, duration=" + (SystemClock.uptimeMillis() - l) + ", bubbleId=" + paramInt);
      }
      return true;
      j += 1;
      break;
      for (;;)
      {
        if ((j == 0) || (k == 0)) {
          break label1025;
        }
        k = 1;
        break label393;
        label1011:
        break label572;
        label1014:
        j = 0;
        break;
        label1019:
        k = 0;
      }
      label1025:
      k = 0;
      break label393;
      label1031:
      j = k;
      Object localObject2 = localObject3;
    }
  }
  
  public boolean ln(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "isBubblePasterExists scid: " + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("bubble.paster.")))
    {
      paramString = paramString.replace("bubble.paster.", "");
      paramString = new File(A(), paramString);
      if (QLog.isColorLevel()) {
        QLog.i("BubbleManager", 2, "isBubblePasterExists file is Exits: " + paramString.exists() + ", path:" + paramString.getAbsolutePath());
      }
      return paramString.exists();
    }
    return false;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 2, "onDestroy...");
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$a.clear();
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.clear();
    cKU = 0;
  }
  
  class HandleBubbleConfigRunnable
    implements Runnable
  {
    adxm a;
    boolean autoDownload;
    int bubbleId;
    
    public HandleBubbleConfigRunnable(int paramInt, boolean paramBoolean)
    {
      this.bubbleId = paramInt;
      this.autoDownload = paramBoolean;
    }
    
    public void run()
    {
      Object localObject = BubbleManager.this.d(this.bubbleId).getAbsolutePath() + File.separatorChar + "config.json";
      this.a = BubbleManager.this.a(this.bubbleId, (String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "getBubbleConfig bubbleId=" + this.bubbleId + ",filePath=" + (String)localObject + ",bubbleConfig=" + this.a);
      }
      if (this.a != null) {
        BubbleManager.this.a.put(Integer.valueOf(this.bubbleId), this.a);
      }
      for (;;)
      {
        localObject = new BubbleManager.HandleBubbleConfigRunnable.1(this);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break;
        }
        ((Runnable)localObject).run();
        return;
        if (this.autoDownload)
        {
          BubbleManager.this.K(this.bubbleId, "config.json", "0");
          BubbleManager.a(BubbleManager.this, this.bubbleId);
        }
      }
      new Handler(Looper.getMainLooper()).post((Runnable)localObject);
    }
  }
  
  public class LruLinkedHashMap<K, V>
    extends LinkedHashMap<K, V>
  {
    private static final long serialVersionUID = 1L;
    private final Lock lock = new ReentrantLock();
    protected final int maxCapacity;
    
    public LruLinkedHashMap(int paramInt)
    {
      super(0.75F, true);
      this.maxCapacity = paramInt;
    }
    
    public void clear()
    {
      try
      {
        this.lock.lock();
        super.clear();
        return;
      }
      finally
      {
        this.lock.unlock();
      }
    }
    
    public V get(Object paramObject)
    {
      try
      {
        this.lock.lock();
        paramObject = super.get(paramObject);
        return paramObject;
      }
      finally
      {
        this.lock.unlock();
      }
    }
    
    public V put(K paramK, V paramV)
    {
      try
      {
        this.lock.lock();
        paramK = super.put(paramK, paramV);
        return paramK;
      }
      finally
      {
        this.lock.unlock();
      }
    }
    
    protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
    {
      return size() > this.maxCapacity;
    }
  }
  
  class a
    extends QQLruCache<Integer, adxp>
  {
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt2, paramInt3);
    }
    
    protected void a(boolean paramBoolean, Integer paramInteger, adxp paramadxp1, adxp paramadxp2)
    {
      super.entryRemoved(paramBoolean, paramInteger, paramadxp1, paramadxp2);
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "entryRemoved key=" + paramInteger);
      }
      paramadxp1.cUW();
    }
    
    public void clear()
    {
      Map localMap = snapshot();
      if (localMap != null)
      {
        Iterator localIterator = localMap.values().iterator();
        while (localIterator.hasNext()) {
          ((adxp)localIterator.next()).cUW();
        }
        if (QLog.isColorLevel()) {
          QLog.i("BubbleManager", 2, "BubbleInfoLruCache cleared, size = " + localMap.size());
        }
      }
    }
    
    public boolean containsKey(int paramInt)
    {
      return get(Integer.valueOf(paramInt)) != null;
    }
  }
  
  public static class b
  {
    public final Rect bO = new Rect();
    public final BitmapDrawable drawable;
    public final int textColor;
    
    public b(BitmapDrawable paramBitmapDrawable, int paramInt, Rect paramRect)
    {
      this.drawable = paramBitmapDrawable;
      this.textColor = paramInt;
      this.bO.set(paramRect);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleManager
 * JD-Core Version:    0.7.0.1
 */