package dov.com.tencent.mobileqq.shortvideo;

import aasa;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import anii;
import anpc;
import aopm;
import aopo;
import aopp;
import aqhq;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQTemplateParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jqp;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PtvTemplateManager
{
  static PtvTemplateManager a;
  public static File aH;
  public static File aL;
  public static final Long ab = Long.valueOf(60000L);
  public static String bYM = "ptv_template_usable";
  public static String bYN = "ptv_debug";
  public static boolean cFf;
  private static boolean cFi = anii.isFoundProductFeatureRom(anii.KEY_BLACK_NOT_SUPPORT_3D_TK);
  public static String cdu = "dov_ptv_template_usable_doodle";
  public static String cdv;
  public static String cdw;
  public static String cdx;
  static Object sLock = new Object();
  ArrayList<PtvTemplateInfo> As = new ArrayList();
  ArrayList<PtvTemplateInfo> At = new ArrayList();
  ArrayList<PtvTemplateInfo> Au = new ArrayList();
  public ArrayList<VideoMaterial> Av = new ArrayList();
  ArrayList<PtvTemplateInfo> Aw = new ArrayList();
  public c a;
  String bYP;
  String bYQ;
  public boolean cFg;
  public boolean cFh;
  public boolean cFj;
  public boolean cFk;
  public boolean czW;
  Object eI = new Object();
  Object eJ = new Object();
  Object eK = new Object();
  public PtvTemplateInfo h;
  String mVersion;
  
  static
  {
    cdv = "5";
    cdw = "200";
    cdx = "20";
    File localFile = new File(aasa.SDCARD_PATH);
    aH = new File(localFile, "dov_ptv_template");
    bYM = aH.getPath() + File.separator + bYM + File.separator;
    bYN = aH.getPath() + File.separator + bYN;
    aL = new File(localFile, "dov_doodle_template");
    cdu = aL.getPath() + File.separator + cdu + File.separator;
  }
  
  private PtvTemplateManager(AppInterface paramAppInterface) {}
  
  /* Error */
  static PtvTemplateInfo a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 181	org/json/JSONObject
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 182	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: aload_0
    //   19: ldc 9
    //   21: invokestatic 188	aqec:convertFrom	(Lorg/json/JSONObject;Ljava/lang/Class;)Ljava/lang/Object;
    //   24: checkcast 9	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo
    //   27: astore_3
    //   28: aload_0
    //   29: ldc 190
    //   31: invokevirtual 193	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   34: ifeq +165 -> 199
    //   37: aload_0
    //   38: ldc 190
    //   40: invokevirtual 197	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   43: astore_0
    //   44: aload_3
    //   45: astore 4
    //   47: aload_0
    //   48: astore_3
    //   49: aload 4
    //   51: astore_0
    //   52: aload_3
    //   53: ifnull -46 -> 7
    //   56: aload_0
    //   57: ifnull -50 -> 7
    //   60: aload_3
    //   61: invokevirtual 203	org/json/JSONArray:length	()I
    //   64: istore_2
    //   65: iload_2
    //   66: ifle -59 -> 7
    //   69: aload_0
    //   70: new 153	java/util/ArrayList
    //   73: dup
    //   74: iload_2
    //   75: invokespecial 206	java/util/ArrayList:<init>	(I)V
    //   78: putfield 209	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:doodleInfos	Ljava/util/ArrayList;
    //   81: iconst_0
    //   82: istore_1
    //   83: iload_1
    //   84: iload_2
    //   85: if_icmpge +71 -> 156
    //   88: aload_3
    //   89: iload_1
    //   90: invokevirtual 213	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   93: ldc 6
    //   95: invokestatic 188	aqec:convertFrom	(Lorg/json/JSONObject;Ljava/lang/Class;)Ljava/lang/Object;
    //   98: checkcast 6	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$DoodleInfo
    //   101: astore 4
    //   103: aload 4
    //   105: ifnull +13 -> 118
    //   108: aload_0
    //   109: getfield 209	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:doodleInfos	Ljava/util/ArrayList;
    //   112: aload 4
    //   114: invokevirtual 217	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   117: pop
    //   118: iload_1
    //   119: iconst_1
    //   120: iadd
    //   121: istore_1
    //   122: goto -39 -> 83
    //   125: astore_3
    //   126: aconst_null
    //   127: astore_0
    //   128: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +7 -> 138
    //   134: aload_3
    //   135: invokevirtual 226	org/json/JSONException:printStackTrace	()V
    //   138: aconst_null
    //   139: astore_3
    //   140: goto -88 -> 52
    //   143: astore_0
    //   144: invokestatic 229	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   147: ifeq -140 -> 7
    //   150: aload_0
    //   151: invokevirtual 226	org/json/JSONException:printStackTrace	()V
    //   154: aconst_null
    //   155: areturn
    //   156: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +28 -> 187
    //   162: ldc 231
    //   164: iconst_2
    //   165: new 119	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   172: ldc 233
    //   174: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload_0
    //   188: areturn
    //   189: astore 4
    //   191: aload_3
    //   192: astore_0
    //   193: aload 4
    //   195: astore_3
    //   196: goto -68 -> 128
    //   199: aconst_null
    //   200: astore_0
    //   201: goto -157 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	paramString	String
    //   82	40	1	i	int
    //   64	22	2	j	int
    //   27	62	3	localObject1	Object
    //   125	10	3	localJSONException1	JSONException
    //   139	57	3	localObject2	Object
    //   45	68	4	localObject3	Object
    //   189	5	4	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   9	28	125	org/json/JSONException
    //   60	65	143	org/json/JSONException
    //   69	81	143	org/json/JSONException
    //   88	103	143	org/json/JSONException
    //   108	118	143	org/json/JSONException
    //   28	44	189	org/json/JSONException
  }
  
  public static PtvTemplateManager a(AppInterface paramAppInterface)
  {
    if (jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager != null) {
      return jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager;
    }
    synchronized (sLock)
    {
      if (jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager != null)
      {
        paramAppInterface = jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager;
        return paramAppInterface;
      }
    }
    jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager = new PtvTemplateManager(paramAppInterface);
    paramAppInterface = jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager;
    return paramAppInterface;
  }
  
  static List<PtvTemplateInfo> a(PtvTemplateManager paramPtvTemplateManager, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateManager", 2, "parse config: " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("content"))
        {
          paramString = localJSONObject.getJSONArray("content");
          if (paramPtvTemplateManager == null) {}
        }
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          try
          {
            JSONObject localJSONObject;
            if (localJSONObject.has("guide_video_url")) {
              paramPtvTemplateManager.bYP = localJSONObject.getString("guide_video_url");
            }
            if (localJSONObject.has("guide_video_md5")) {
              paramPtvTemplateManager.bYQ = localJSONObject.getString("guide_video_md5");
            }
            if (localJSONObject.has("version")) {
              paramPtvTemplateManager.mVersion = localJSONObject.getString("version");
            }
            if (localJSONObject.has("gestureGapFrame")) {
              cdv = localJSONObject.getString("gestureGapFrame");
            }
            if (localJSONObject.has("gestureGapTime")) {
              cdw = localJSONObject.getString("gestureGapTime");
            }
            if (localJSONObject.has("gesturethreadcoldtime")) {
              cdx = localJSONObject.getString("gesturethreadcoldtime");
            }
            paramPtvTemplateManager = paramString;
            if (localJSONObject.has("gestureShouldUpload"))
            {
              cFf = localJSONObject.getBoolean("gestureShouldUpload");
              paramPtvTemplateManager = paramString;
            }
            if (paramPtvTemplateManager == null) {
              break;
            }
            paramPtvTemplateManager = PtvTemplateInfo.convertFrom(paramPtvTemplateManager);
            if ((paramPtvTemplateManager == null) || (paramPtvTemplateManager.isEmpty())) {
              break;
            }
            return paramPtvTemplateManager;
          }
          catch (JSONException localJSONException2)
          {
            continue;
          }
          localJSONException1 = localJSONException1;
          paramString = null;
          paramPtvTemplateManager = paramString;
          if (QLog.isColorLevel())
          {
            localJSONException1.printStackTrace();
            paramPtvTemplateManager = paramString;
            continue;
            paramString = null;
          }
        }
      }
    }
  }
  
  public static boolean awA()
  {
    return new File(aL, "dov_doodle_template_new.cfg").exists();
  }
  
  private void dPg()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$c != null) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$c.cwS();
    }
  }
  
  public static String p(File paramFile)
  {
    paramFile = aqhq.fileToBytes(paramFile);
    if ((paramFile == null) || (paramFile.length <= 0)) {
      return null;
    }
    if (Build.VERSION.SDK_INT <= 8) {
      return new String(paramFile);
    }
    try
    {
      paramFile = new String(paramFile, "UTF-8");
      return paramFile;
    }
    catch (UnsupportedEncodingException paramFile)
    {
      if (QLog.isDevelopLevel()) {
        paramFile.printStackTrace();
      }
    }
    return null;
  }
  
  List<PtvTemplateInfo> a(AppInterface paramAppInterface, File paramFile, HashMap<String, PtvTemplateInfo> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      if (paramAppInterface == null) {
        break label66;
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("PtvTemplateManager", 2, String.format("rebuildTemplateInfos, app[%s], isUpdateedByServer[%s], cur_runnable[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.czW), Integer.valueOf(hashCode()) }));
      if (!this.czW) {
        break;
      }
      return null;
    }
    paramAppInterface = p(paramFile);
    if (TextUtils.isEmpty(paramAppInterface)) {
      return null;
    }
    paramAppInterface = a(this, paramAppInterface);
    if ((paramAppInterface == null) || (paramAppInterface.isEmpty())) {
      return null;
    }
    paramFile = paramAppInterface.iterator();
    while (paramFile.hasNext())
    {
      PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateInfo)paramFile.next();
      if (localPtvTemplateInfo != null)
      {
        localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
        if (paramHashMap != null) {
          paramHashMap.put(localPtvTemplateInfo.id, localPtvTemplateInfo);
        }
      }
    }
    return paramAppInterface;
  }
  
  public void a(AppInterface paramAppInterface, a parama, boolean paramBoolean)
  {
    if ((this.h != null) && (!this.h.doodleInfos.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "initDoodleInfo has inited.");
      }
      if (paramBoolean) {
        ThreadManager.postImmediately(new PtvTemplateManager.9(this), null, false);
      }
    }
    File localFile;
    do
    {
      return;
      localFile = new File(aL, "dov_doodle_template_new.cfg");
      if (localFile.exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "initLocalDoodleInfo config file not exist.");
    return;
    parama = new PtvTemplateManager.10(this, localFile, paramBoolean, parama, paramAppInterface);
    if (QLog.isDevelopLevel()) {
      QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 4, String.format("initLocalDoodleInfo async, runnable[%s]", new Object[] { Integer.valueOf(parama.hashCode()) }));
    }
    if ((paramAppInterface instanceof QQAppInterface))
    {
      ThreadManager.getFileThreadHandler().postDelayed(parama, 0L);
      return;
    }
    ThreadManager.postImmediately(parama, null, false);
  }
  
  public boolean a(DoodleInfo paramDoodleInfo, boolean paramBoolean)
  {
    if ((paramDoodleInfo == null) || (TextUtils.isEmpty(paramDoodleInfo.doodleName))) {}
    do
    {
      for (;;)
      {
        return false;
        Object localObject = new File(aL, paramDoodleInfo.doodleName);
        if (!((File)localObject).exists())
        {
          if (QLog.isColorLevel())
          {
            QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "isDoodleTemplateUsable|file is not exist -> " + paramDoodleInfo.doodleName);
            return false;
          }
        }
        else {
          try
          {
            localObject = aqhq.px(((File)localObject).getPath());
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase(paramDoodleInfo.doodleMd5)))
            {
              if ((!paramBoolean) || (new File(cdu + paramDoodleInfo.doodleName + File.separator, "params.json").exists())) {
                break label268;
              }
              if (QLog.isColorLevel()) {
                QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "isDoodleTemplateUsable|paramFile is not exist->>" + paramDoodleInfo.doodleName);
              }
              if (!QLog.isColorLevel()) {}
            }
          }
          catch (UnsatisfiedLinkError paramDoodleInfo)
          {
            try
            {
              jqp.b(new File(aL, paramDoodleInfo.doodleName), cdu);
              if (QLog.isColorLevel()) {
                QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "isDoodleTemplateUsable|unZipFile->>" + paramDoodleInfo.doodleName);
              }
              return true;
            }
            catch (IOException paramDoodleInfo) {}
            paramDoodleInfo = paramDoodleInfo;
          }
        }
      }
      paramDoodleInfo.printStackTrace();
      return false;
    } while (!QLog.isColorLevel());
    paramDoodleInfo.printStackTrace();
    return false;
    label268:
    return true;
  }
  
  /* Error */
  public boolean a(PtvTemplateInfo paramPtvTemplateInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: getfield 467	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:name	Ljava/lang/String;
    //   8: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: new 102	java/io/File
    //   19: dup
    //   20: getstatic 117	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager:aH	Ljava/io/File;
    //   23: aload_1
    //   24: getfield 467	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:name	Ljava/lang/String;
    //   27: invokespecial 115	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: astore_2
    //   31: aload_2
    //   32: invokevirtual 304	java/io/File:exists	()Z
    //   35: ifeq -21 -> 14
    //   38: aload_2
    //   39: invokevirtual 124	java/io/File:getPath	()Ljava/lang/String;
    //   42: invokestatic 441	aqhq:px	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore_2
    //   46: aload_2
    //   47: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne -36 -> 14
    //   53: aload_2
    //   54: aload_1
    //   55: getfield 470	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:md5	Ljava/lang/String;
    //   58: invokevirtual 447	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   61: ifeq -47 -> 14
    //   64: new 119	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   71: getstatic 75	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager:bYM	Ljava/lang/String;
    //   74: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_1
    //   78: getfield 467	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:name	Ljava/lang/String;
    //   81: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: getstatic 131	java/io/File:separator	Ljava/lang/String;
    //   87: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore_3
    //   94: new 102	java/io/File
    //   97: dup
    //   98: aload_3
    //   99: ldc_w 449
    //   102: invokespecial 452	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: astore_2
    //   106: new 102	java/io/File
    //   109: dup
    //   110: aload_3
    //   111: ldc_w 472
    //   114: invokespecial 452	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: astore_3
    //   118: aload_2
    //   119: invokevirtual 304	java/io/File:exists	()Z
    //   122: ifne +58 -> 180
    //   125: aload_3
    //   126: invokevirtual 304	java/io/File:exists	()Z
    //   129: ifne +51 -> 180
    //   132: new 102	java/io/File
    //   135: dup
    //   136: getstatic 117	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager:aH	Ljava/io/File;
    //   139: aload_1
    //   140: getfield 467	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:name	Ljava/lang/String;
    //   143: invokespecial 115	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   146: getstatic 75	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager:bYM	Ljava/lang/String;
    //   149: invokestatic 458	jqp:b	(Ljava/io/File;Ljava/lang/String;)V
    //   152: iconst_1
    //   153: ireturn
    //   154: astore_1
    //   155: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq -144 -> 14
    //   161: aload_1
    //   162: invokevirtual 461	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   165: iconst_0
    //   166: ireturn
    //   167: astore_1
    //   168: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq -157 -> 14
    //   174: aload_1
    //   175: invokevirtual 473	java/lang/Exception:printStackTrace	()V
    //   178: iconst_0
    //   179: ireturn
    //   180: iconst_1
    //   181: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	PtvTemplateManager
    //   0	182	1	paramPtvTemplateInfo	PtvTemplateInfo
    //   30	89	2	localObject1	Object
    //   93	33	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   38	46	154	java/lang/UnsatisfiedLinkError
    //   132	152	167	java/lang/Exception
  }
  
  void c(AppInterface paramAppInterface, ArrayList<PtvTemplateInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    int i = 0;
    label14:
    PtvTemplateInfo localPtvTemplateInfo;
    if (i < paramArrayList.size())
    {
      localPtvTemplateInfo = (PtvTemplateInfo)paramArrayList.get(i);
      if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.predownload) && (!TextUtils.isEmpty(localPtvTemplateInfo.resurl))) {
        break label63;
      }
    }
    for (;;)
    {
      i += 1;
      break label14;
      break;
      label63:
      ThreadManager.getFileThreadHandler().post(new PtvTemplateManager.5(this, localPtvTemplateInfo, paramAppInterface));
    }
  }
  
  public ArrayList<DoodleInfo> dH()
  {
    ArrayList localArrayList = new ArrayList();
    DoodleInfo localDoodleInfo;
    File localFile;
    Object localObject2;
    int j;
    int i;
    for (;;)
    {
      synchronized (this.eK)
      {
        if ((this.h == null) || (this.h.doodleInfos.isEmpty())) {
          return null;
        }
        Iterator localIterator = this.h.doodleInfos.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localDoodleInfo = (DoodleInfo)localIterator.next();
        if ((localDoodleInfo == null) || (TextUtils.isEmpty(localDoodleInfo.doodleName)))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "info is null or info name is null " + localDoodleInfo);
        }
      }
      if (!new File(aL, localDoodleInfo.doodleName).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "getDoodleInfos|file is not exist ");
        }
        localDoodleInfo.doodleUsable = false;
      }
      else
      {
        localFile = new File(cdu + localDoodleInfo.doodleName + File.separator, "params.json");
        if (!localFile.exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "getDoodleInfos|paramFile is not exist ");
          }
          localDoodleInfo.doodleUsable = false;
        }
        else
        {
          localObject2 = localFile.getParentFile();
          if (!((File)localObject2).isDirectory()) {
            break label358;
          }
          localObject2 = ((File)localObject2).listFiles();
          if ((localObject2 == null) || (localObject2.length <= 0)) {
            break label358;
          }
          j = localObject2.length;
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (i < j)
      {
        if (!localObject2[i].getName().endsWith("png")) {}
      }
      else {
        label358:
        for (i = 1;; i = 0)
        {
          if (i == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "getDoodleInfos|image is not exist ");
            }
            localFile.delete();
            break;
          }
          localArrayList1.add(localDoodleInfo);
          break;
          return localArrayList1;
        }
      }
      i += 1;
    }
  }
  
  void fb(QQAppInterface paramQQAppInterface)
  {
    if ((this.h == null) || (this.h.doodleInfos.isEmpty()) || (paramQQAppInterface == null)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "preDownloadDoodleTemplate|app= " + paramQQAppInterface);
      }
      Iterator localIterator = this.h.doodleInfos.iterator();
      while (localIterator.hasNext())
      {
        DoodleInfo localDoodleInfo = (DoodleInfo)localIterator.next();
        if ((localDoodleInfo != null) && (!TextUtils.isEmpty(localDoodleInfo.doodleUrl)) && (!localDoodleInfo.doodleUsable))
        {
          Object localObject = new PtvTemplateManager.13(this, localDoodleInfo, paramQQAppInterface);
          aopo localaopo = (aopo)paramQQAppInterface.getManager(193);
          if (localaopo.isEnable())
          {
            localObject = new aopp(paramQQAppInterface, "qq_doodle_res", (Runnable)localObject, 4000L);
            localaopo.a(10020, null, localDoodleInfo.doodleName, 0, localDoodleInfo.doodleUrl, new File(aL, localDoodleInfo.doodleName).getPath(), 2, 0, true, (aopm)localObject);
          }
          else
          {
            ThreadManager.post((Runnable)localObject, 8, null, true);
          }
        }
      }
    }
  }
  
  public String fd(int paramInt)
  {
    if ((this.h != null) && (this.h.doodleInfos != null) && (!this.h.doodleInfos.isEmpty()))
    {
      Iterator localIterator = this.h.doodleInfos.iterator();
      while (localIterator.hasNext())
      {
        DoodleInfo localDoodleInfo = (DoodleInfo)localIterator.next();
        if (Integer.valueOf(localDoodleInfo.doodleId).intValue() == paramInt) {
          return cdu + localDoodleInfo.doodleName;
        }
      }
    }
    return "";
  }
  
  public List<VideoMaterial> gi()
  {
    if ((this.Av.isEmpty()) && (this.h != null)) {
      synchronized (this.eK)
      {
        Iterator localIterator = this.h.doodleInfos.iterator();
        while (localIterator.hasNext())
        {
          Object localObject3 = (DoodleInfo)localIterator.next();
          if (((DoodleInfo)localObject3).doodleUsable)
          {
            localObject3 = cdu + ((DoodleInfo)localObject3).doodleName;
            VideoMaterial localVideoMaterial = QQTemplateParser.parseVideoMaterial((String)localObject3, "params");
            if (localVideoMaterial != null)
            {
              localVideoMaterial.setDataPath((String)localObject3);
              this.Av.add(localVideoMaterial);
              if (QLog.isDevelopLevel()) {
                QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 4, new Object[] { "getDoodleMaterials add DoodleMaterial:", localVideoMaterial.getId() });
              }
            }
          }
        }
      }
    }
    return this.Av;
  }
  
  void mq(List<PtvTemplateInfo> paramList) {}
  
  public void p(String arg1, QQAppInterface paramQQAppInterface)
  {
    PtvTemplateInfo localPtvTemplateInfo = a(???);
    if (localPtvTemplateInfo == null) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new PtvTemplateManager.11(this, ???));
    synchronized (this.eK)
    {
      this.h = localPtvTemplateInfo;
      ThreadManager.getFileThreadHandler().post(new PtvTemplateManager.12(this));
      fb(paramQQAppInterface);
      return;
    }
  }
  
  public static class DoodleInfo
  {
    public String doodleId;
    public String doodleMd5;
    public String doodleName;
    public String doodleUrl;
    public boolean doodleUsable;
    
    public String toString()
    {
      return "PtvTemplateInfo{id='" + this.doodleId + '\'' + ", doodleName='" + this.doodleName + '\'' + ", doodleUsable='" + this.doodleUsable + '\'' + '}';
    }
  }
  
  public static class PtvTemplateInfo
  {
    public static final int AR_PARTICLE = 11;
    public static final int Category_Face = 0;
    public static final int Category_FaceAndGesture = 2;
    public static final int Category_Gesture = 1;
    public static final int D3D_TK = 1;
    public static final int DG_FILTER = 5;
    public static final int DISPLAY_TYPE_AR = 2;
    public static final int DISPLAY_TYPE_AUDIO = 1;
    public static final int DISPLAY_TYPE_CHANGE_VOICE = 4;
    public static final int DISPLAY_TYPE_DEFAULT = 0;
    public static final int DISPLAY_TYPE_WM = 3;
    public static final int DOODLE = 1;
    public static final int DOV_FILTER = 13;
    public static final int FDG_FILTER = 6;
    public static final int FILTER = 0;
    public static final int FOOLS_DAY = 10;
    public static int FUNC_REDBAG_GET = 1;
    public static final int LBS_MACDONALD = 1;
    public static final int LBS_NORMAL_FILTER = 0;
    public static final int MOVIE_FILTER = 3;
    public static final int NORMAL = 0;
    public static final int PORTRAIT_FILTER = 7;
    public static final int QQ_BIG_HEAD = 20;
    public static final int RANDOM_FORTUNE = 9;
    public static final int SHOOK_HEAD = 8;
    static final String SV_FILTER_DOWNLOAD_TIME = "sv_filter_download_time";
    public static final int WS_FILTER = 12;
    public static final int YSLD_FILTER = 2;
    public int activityType = 0;
    public boolean advertisement;
    public String androidopenurlheader;
    public String badgeurl;
    public String bigHeadMd5 = "";
    public boolean bigHeadModelUsable;
    public String bigHeadName = "";
    public String bigHeadUrl = "";
    public int businessID;
    public String buttonbgcolor;
    public String cameraScheme;
    public String cameraTitle;
    public int category = 0;
    public int categoryId;
    public String dgModelName;
    public String dgModelResmd5;
    public String dgModelResurl;
    public boolean dgModelUsable;
    public String dgStageName;
    public String dgStageResmd5;
    public String dgStageResurl;
    public boolean dgStageUsable;
    public int displayType = 0;
    public ArrayList<PtvTemplateManager.DoodleInfo> doodleInfos;
    public boolean downloading;
    public boolean editablewatermark;
    public int funcType;
    public String gestureType = "";
    public String gestureWording = "";
    public String iconurl;
    public String id;
    public String jump_app;
    public int kind = 0;
    public String md5;
    public boolean multivideosupport = true;
    public String name;
    public boolean needRedDot;
    public String openurl;
    public int platform;
    public String playShowCoverImg;
    public String playShowDisplayText;
    public boolean popup = true;
    public String popupbtn;
    public String popupbtn2;
    public String popupcontent;
    public String popupcontent2;
    public String popupimgurl;
    public boolean predownload;
    public String resurl;
    public double sizeFree;
    public long startDownloadTime;
    public String storeurl;
    public int templateStyle;
    public long totalLen;
    public boolean usable;
    
    public static List<PtvTemplateInfo> convertFrom(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {}
      do
      {
        return null;
        try
        {
          paramString = convertFrom(new JSONArray(paramString));
          return paramString;
        }
        catch (JSONException paramString) {}
      } while (!QLog.isDevelopLevel());
      paramString.printStackTrace();
      return null;
    }
    
    public static List<PtvTemplateInfo> convertFrom(JSONArray paramJSONArray)
    {
      if (paramJSONArray == null) {
        return null;
      }
      for (;;)
      {
        ArrayList localArrayList;
        int i;
        try
        {
          int j = paramJSONArray.length();
          if (j <= 0) {
            break;
          }
          localArrayList = new ArrayList(j);
          i = 0;
          if (i >= j) {
            break label156;
          }
          PtvTemplateInfo localPtvTemplateInfo = parseContent(paramJSONArray.getJSONObject(i));
          if (localPtvTemplateInfo == null) {
            break label161;
          }
          try
          {
            Long.parseLong(localPtvTemplateInfo.id);
            switch (localPtvTemplateInfo.kind)
            {
            case 1: 
              localArrayList.add(localPtvTemplateInfo);
            }
          }
          catch (Exception localException)
          {
            if (!QLog.isColorLevel()) {
              break label161;
            }
          }
          if (PtvTemplateManager.cFi) {
            break label161;
          }
          localArrayList.add(localPtvTemplateInfo);
        }
        catch (JSONException paramJSONArray) {}
        QLog.e("PtvTemplateManager", 1, "templateId must be a numeric string!");
        break label161;
        if (!QLog.isDevelopLevel()) {
          break;
        }
        paramJSONArray.printStackTrace();
        return null;
        localArrayList.add(localException);
        break label161;
        label156:
        return localArrayList;
        continue;
        label161:
        i += 1;
      }
    }
    
    public static boolean isFace(int paramInt)
    {
      return (paramInt == 2) || (paramInt == 0);
    }
    
    public static boolean isGesture(int paramInt)
    {
      return (paramInt == 2) || (paramInt == 1);
    }
    
    private static PtvTemplateInfo parseContent(JSONObject paramJSONObject)
    {
      PtvTemplateInfo localPtvTemplateInfo = new PtvTemplateInfo();
      try
      {
        if (paramJSONObject.has("id")) {
          localPtvTemplateInfo.id = paramJSONObject.getString("id");
        }
        if (paramJSONObject.has("iconurl")) {
          localPtvTemplateInfo.iconurl = paramJSONObject.getString("iconurl");
        }
        if (paramJSONObject.has("resurl")) {
          localPtvTemplateInfo.resurl = paramJSONObject.getString("resurl");
        }
        if (paramJSONObject.has("md5")) {
          localPtvTemplateInfo.md5 = paramJSONObject.getString("md5");
        }
        if (paramJSONObject.has("name")) {
          localPtvTemplateInfo.name = paramJSONObject.getString("name");
        }
        if (paramJSONObject.has("predownload")) {
          localPtvTemplateInfo.predownload = paramJSONObject.getBoolean("predownload");
        }
        if (paramJSONObject.has("platform")) {
          localPtvTemplateInfo.platform = paramJSONObject.getInt("platform");
        }
        if (paramJSONObject.has("businessID")) {
          localPtvTemplateInfo.businessID = paramJSONObject.getInt("businessID");
        }
        if (paramJSONObject.has("categoryId")) {
          localPtvTemplateInfo.categoryId = paramJSONObject.getInt("categoryId");
        }
        if (paramJSONObject.has("templateStyle")) {
          localPtvTemplateInfo.templateStyle = paramJSONObject.getInt("templateStyle");
        }
        if (paramJSONObject.has("needRedDot")) {
          localPtvTemplateInfo.needRedDot = paramJSONObject.getBoolean("needRedDot");
        }
        if (paramJSONObject.has("kind")) {
          localPtvTemplateInfo.kind = paramJSONObject.getInt("kind");
        }
        if (paramJSONObject.has("displayType")) {
          localPtvTemplateInfo.displayType = paramJSONObject.getInt("displayType");
        }
        if (paramJSONObject.has("qq_camera_top_title")) {
          localPtvTemplateInfo.cameraTitle = paramJSONObject.getString("qq_camera_top_title");
        }
        if (paramJSONObject.has("qq_camera_scheme")) {
          localPtvTemplateInfo.cameraScheme = paramJSONObject.getString("qq_camera_scheme");
        }
        if (paramJSONObject.has("activityType")) {
          localPtvTemplateInfo.activityType = paramJSONObject.getInt("activityType");
        }
        if (paramJSONObject.has("category")) {
          localPtvTemplateInfo.category = paramJSONObject.getInt("category");
        }
        if (paramJSONObject.has("gestureType")) {
          localPtvTemplateInfo.gestureType = paramJSONObject.getString("gestureType");
        }
        if (paramJSONObject.has("gestureWording")) {
          localPtvTemplateInfo.gestureWording = paramJSONObject.getString("gestureWording");
        }
        if (paramJSONObject.has("advertisement")) {
          localPtvTemplateInfo.advertisement = paramJSONObject.getBoolean("advertisement");
        }
        if (paramJSONObject.has("androidopenurlheader")) {
          localPtvTemplateInfo.androidopenurlheader = paramJSONObject.getString("androidopenurlheader");
        }
        if (paramJSONObject.has("openurl")) {
          localPtvTemplateInfo.openurl = paramJSONObject.getString("openurl");
        }
        if (paramJSONObject.has("storeurl")) {
          localPtvTemplateInfo.storeurl = paramJSONObject.getString("storeurl");
        }
        if (paramJSONObject.has("popup")) {
          localPtvTemplateInfo.popup = paramJSONObject.getBoolean("popup");
        }
        if (paramJSONObject.has("badgeurl")) {
          localPtvTemplateInfo.badgeurl = paramJSONObject.getString("badgeurl");
        }
        if (paramJSONObject.has("popupimgurl")) {
          localPtvTemplateInfo.popupimgurl = paramJSONObject.getString("popupimgurl");
        }
        if (paramJSONObject.has("popupcontent")) {
          localPtvTemplateInfo.popupcontent = paramJSONObject.getString("popupcontent");
        }
        if (paramJSONObject.has("popupbtn")) {
          localPtvTemplateInfo.popupbtn = paramJSONObject.getString("popupbtn");
        }
        if (paramJSONObject.has("popupcontent2")) {
          localPtvTemplateInfo.popupcontent2 = paramJSONObject.getString("popupcontent2");
        }
        if (paramJSONObject.has("popupbtn2")) {
          localPtvTemplateInfo.popupbtn2 = paramJSONObject.getString("popupbtn2");
        }
        if (paramJSONObject.has("buttonbgcolor")) {
          localPtvTemplateInfo.buttonbgcolor = paramJSONObject.getString("buttonbgcolor");
        }
        if (paramJSONObject.has("multivideosupport")) {
          localPtvTemplateInfo.multivideosupport = paramJSONObject.getBoolean("multivideosupport");
        }
        if (paramJSONObject.has("sizeFree")) {
          localPtvTemplateInfo.sizeFree = paramJSONObject.getDouble("sizeFree");
        }
        if (paramJSONObject.has("jump_app")) {
          localPtvTemplateInfo.jump_app = paramJSONObject.getString("jump_app");
        }
        if (paramJSONObject.has("funcType")) {
          localPtvTemplateInfo.funcType = paramJSONObject.getInt("funcType");
        }
      }
      catch (Exception paramJSONObject)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("PtvTemplateManager", 1, "parseContent error=" + paramJSONObject.getMessage());
      }
      return localPtvTemplateInfo;
      return localPtvTemplateInfo;
    }
    
    public void doDownloadDataReport()
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.startDownloadTime;
      HashMap localHashMap = new HashMap();
      localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
      localHashMap.put("MODEL", Build.MODEL);
      localHashMap.put("SDK_INT", "" + Build.VERSION.SDK_INT);
      localHashMap.put("timems", "" + (l1 - l2));
      localHashMap.put("totalsize", "" + this.totalLen);
      localHashMap.put("success", "" + this.usable);
      anpc.a(VideoEnvironment.getContext()).collectPerformance(null, "sv_filter_download_time", true, 0L, 0L, localHashMap, "");
    }
    
    public int getDisplayIconByType()
    {
      switch (this.displayType)
      {
      default: 
        return -1;
      case 1: 
        return 2130845447;
      case 2: 
        return 2130845448;
      case 3: 
        return 2130845450;
      }
      return 2130845449;
    }
    
    public String getLbsActivityType(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "LBS_NORMAL_FILTER_" + paramInt;
      }
      return "LBS_MACDONALD_" + paramInt;
    }
    
    public boolean hasFace()
    {
      return isFace(this.category);
    }
    
    public boolean hasGesture()
    {
      return isGesture(this.category);
    }
    
    public boolean isDovItem()
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (!TextUtils.isEmpty(this.jump_app))
      {
        bool1 = bool2;
        if (this.jump_app.startsWith("qim")) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public boolean isWsBanner()
    {
      return this.kind == 12;
    }
    
    public boolean needDisplayType()
    {
      return this.displayType != 0;
    }
    
    public String toString()
    {
      return "PtvTemplateInfo{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", dooleInfos=" + this.doodleInfos + '\'' + ",usable=" + this.usable + '}';
    }
  }
  
  public static class a
  {
    public void bsj() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean);
    
    public abstract void b(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void cwS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager
 * JD-Core Version:    0.7.0.1
 */