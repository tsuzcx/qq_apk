package com.tencent.mobileqq.qmcf;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.FileUtils;
import com.tencent.mobileqq.shortvideo.resource.ArtFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.util.SoLoader;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public class QmcfManager
{
  public static final int FRAME_TYPE_CL_MALI = 2;
  public static final int FRAME_TYPE_CL_OCL = 3;
  public static final int FRAME_TYPE_GL = 4;
  public static final int FRAME_TYPE_NONE = -1;
  public static final int FRAME_TYPE_NO_SUPPORT = 0;
  public static final int FRAME_TYPE_SNPE = 1;
  public static boolean FrameExtraction = false;
  public static String QMCF_FRAME_TYPE = "qmcf_frame_type";
  public static final int QMCF_MODE_ART = 1;
  public static final int QMCF_MODE_BIGHEAD = 3;
  public static final int QMCF_MODE_NONE = 0;
  public static final int QMCF_MODE_POSE = 2;
  private static final String TAG = "QMCF_MGR";
  private static int artFilterLimitVersion = 1;
  private static QmcfManager g_sInstance;
  public static boolean hasSNPESo = false;
  public static boolean isDebugMode = false;
  public static boolean isQQRun = true;
  private static QmcfReporter mReporter;
  private static QmcfSwitchStrategy mSwitchStrategy;
  public String CommonPrefixPath = null;
  private int currFrameType = -1;
  private String currModelResFolder;
  private int currQmcfMode = 0;
  public int mCameraMode = 1;
  private Object mReadResLock = new Object();
  public float[] mSTMatrix = new float[16];
  public boolean modeChanged = false;
  private HashMap modelItemsMap = new HashMap(16);
  private ArrayList<String> modelSwichList = new ArrayList();
  public boolean modelSwitched = false;
  ExecutorService singleThreadExecutor = null;
  
  static
  {
    FrameExtraction = false;
    mSwitchStrategy = new QmcfSwitchStrategy();
    mReporter = new QmcfReporter();
  }
  
  public static QmcfManager getInstance()
  {
    if (g_sInstance == null) {
      g_sInstance = new QmcfManager();
    }
    return g_sInstance;
  }
  
  private String getQmcfModelPath(String paramString)
  {
    int j = 0;
    boolean bool2 = false;
    Object localObject3 = null;
    localObject1 = null;
    localObject2 = localObject1;
    Object localObject4;
    if (!TextUtils.isEmpty(paramString))
    {
      localFile = new File(paramString + "params.json");
      localObject2 = localObject1;
      if (localFile.exists())
      {
        localObject4 = FileUtils.readFileContent(localFile);
        localObject2 = localObject1;
        if (localObject4 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject4).length() > 0)
          {
            localObject1 = localObject3;
            bool1 = bool2;
            i = j;
          }
        }
      }
    }
    try
    {
      localObject4 = new JSONObject((String)localObject4);
      localObject1 = localObject3;
      bool1 = bool2;
      i = j;
      localObject2 = ((JSONObject)localObject4).getString("model_name");
      localObject1 = localObject3;
      bool1 = bool2;
      i = j;
      localObject4 = ((JSONObject)localObject4).getString("model_struct");
      localObject1 = localObject3;
      bool1 = bool2;
      i = j;
      String str = paramString + (String)localObject2;
      localObject1 = localObject3;
      bool1 = bool2;
      i = j;
      paramString = paramString + (String)localObject4;
      localObject1 = paramString;
      bool1 = bool2;
      i = j;
      boolean bool3 = new File(str).exists();
      localObject1 = paramString;
      bool1 = bool2;
      i = j;
      bool2 = new File(paramString).exists();
      localObject1 = paramString;
      bool1 = bool2;
      i = bool2;
      if (SLog.isEnable())
      {
        localObject1 = paramString;
        bool1 = bool2;
        i = bool2;
        SLog.d("QMCF_MGR", String.format("getQmcfModelPath paramExit[%s], modelExist[%s], paramName[%s], modelName[%s]", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), localObject2, localObject4 }));
      }
      localObject2 = paramString;
      if (!bool2)
      {
        localFile.delete();
        localObject2 = paramString;
      }
    }
    catch (Exception paramString)
    {
      i = bool1;
      paramString.printStackTrace();
      localObject2 = localObject1;
      return localObject1;
    }
    finally
    {
      if (i != 0) {
        break label375;
      }
      localFile.delete();
    }
    return localObject2;
  }
  
  public boolean checkPathValid()
  {
    try
    {
      this.CommonPrefixPath = (SdkContext.getInstance().getResources().getArtFilterResource().getCommonPrefix() + "binarys/");
      File localFile = new File(this.CommonPrefixPath);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return true;
    }
    catch (Exception localException)
    {
      if (SLog.isEnable()) {
        SLog.d("QMCF_MGR", "createDir excep");
      }
      localException.printStackTrace();
    }
    return false;
  }
  
  public void destroy()
  {
    if (SLog.isEnable()) {
      SLog.d("QMCF_MGR", "destroy");
    }
    mReporter.clearReporter();
    this.modelSwitched = false;
  }
  
  public byte[] drink(byte[] paramArrayOfByte)
  {
    return QMCF.nDrink(paramArrayOfByte, paramArrayOfByte.length, QMCF.getDefaultSign());
  }
  
  public int getCurrFrameType()
  {
    if (this.currFrameType == -1)
    {
      this.currFrameType = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).getInt(QMCF_FRAME_TYPE, 4);
      if (SLog.isEnable()) {
        SLog.d("QMCF_MGR", "getCurrFrameType:" + this.currFrameType);
      }
    }
    return this.currFrameType;
  }
  
  public int getCurrQmcfMode()
  {
    return this.currQmcfMode;
  }
  
  public String getCurrResFolder()
  {
    return this.currModelResFolder;
  }
  
  public QmcfSwitchStrategy getCurrSwitchStrategy()
  {
    return mSwitchStrategy;
  }
  
  public int getMatchQmcfMode(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 3) {
      return 2;
    }
    return 0;
  }
  
  public QmcfModelItem getQmcfModelItem()
  {
    if (TextUtils.isEmpty(this.currModelResFolder))
    {
      if (SLog.isEnable()) {
        SLog.d("QMCF_MGR", "getQmcfModelItem currModelResFolder is null");
      }
      return null;
    }
    String str2 = null;
    Object localObject8 = null;
    File localFile;
    synchronized (this.mReadResLock)
    {
      localFile = new File(this.currModelResFolder + "params.json");
      if (!localFile.exists())
      {
        if (SLog.isEnable()) {
          SLog.d("QMCF_MGR", "getQmcfModelItem file not exist " + localFile.getAbsolutePath());
        }
        return null;
      }
    }
    Object localObject10 = FileUtils.readFileContent(localFile);
    if (TextUtils.isEmpty((CharSequence)localObject10)) {
      return null;
    }
    Object localObject5 = null;
    Object localObject7 = null;
    String str1 = null;
    Object localObject4 = str1;
    Object localObject3 = localObject7;
    Object localObject2 = localObject5;
    try
    {
      localObject10 = new JSONObject((String)localObject10);
      localObject4 = str1;
      localObject3 = localObject7;
      localObject2 = localObject5;
      localObject5 = ((JSONObject)localObject10).getString("model_name");
      localObject4 = str1;
      localObject3 = localObject7;
      localObject2 = localObject5;
      localObject7 = ((JSONObject)localObject10).getString("model_struct");
      localObject4 = str1;
      localObject3 = localObject7;
      localObject2 = localObject5;
      str1 = ((JSONObject)localObject10).optString("model_dlc");
      localObject4 = str1;
      localObject3 = localObject7;
      localObject2 = localObject5;
      i = ((JSONObject)localObject10).optInt("model_encrypt");
      localObject4 = localObject5;
      localObject5 = str1;
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          long l;
          boolean bool2;
          boolean bool3;
          localException.printStackTrace();
          int i = 0;
          Object localObject6 = localObject4;
          localObject7 = localObject3;
          localObject4 = localObject2;
        }
        localObject2 = localObject8;
      } while (!SLog.isEnable());
      if (TextUtils.isEmpty(str2)) {
        break label659;
      }
    }
    localObject3 = str2;
    if (this.modelItemsMap.get(localObject4) == null)
    {
      l = System.currentTimeMillis();
      localObject3 = this.currModelResFolder + (String)localObject4;
      localObject2 = this.currModelResFolder + (String)localObject7;
      str1 = this.currModelResFolder + (String)localObject5;
      bool2 = new File((String)localObject3).exists();
      bool3 = new File((String)localObject2).exists();
      if ((!bool2) || (!bool3)) {
        break label646;
      }
      str2 = readQmcfModelFile((String)localObject2);
      if (TextUtils.isEmpty(str2)) {
        break label595;
      }
      localObject2 = new QmcfModelItem();
      ((QmcfModelItem)localObject2).modelDeployString = str2;
      ((QmcfModelItem)localObject2).modelParamPath = ((String)localObject3);
      ((QmcfModelItem)localObject2).modelDlcPath = str1;
      ((QmcfModelItem)localObject2).modelEncrypt = i;
      this.modelItemsMap.put(localObject4, localObject2);
      localObject3 = localObject2;
      if (SLog.isEnable())
      {
        SLog.d("QMCF_MGR", String.format("getQmcfModelItem cost[%s], paramExit[%s], modelExist[%s], paramName[%s], modelName[%s], dlcName[%s]", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(bool2), Boolean.valueOf(bool3), localObject4, localObject7, localObject5 }));
        localObject3 = localObject2;
      }
    }
    if (this.modelItemsMap.get(localObject4) != null) {
      localObject3 = (QmcfModelItem)this.modelItemsMap.get(localObject4);
    }
    return localObject3;
    label595:
    for (boolean bool1 = true;; bool1 = false)
    {
      SLog.d("QMCF_MGR", String.format("getQmcfModelItem modelValid[%s]", new Object[] { Boolean.valueOf(bool1) }));
      localObject2 = localObject8;
      break;
      localFile.delete();
      localObject2 = localObject8;
      break;
    }
  }
  
  public int getRunType()
  {
    if (getCurrFrameType() == 4) {
      return 1;
    }
    return 0;
  }
  
  public boolean hasQmcfEntrance(int paramInt)
  {
    return hasQmcfEntrance(paramInt, false);
  }
  
  public boolean hasQmcfEntrance(int paramInt, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (;;)
    {
      return false;
      boolean bool3 = isQmcfSupported(paramInt);
      boolean bool2 = SoLoader.isLoadArtFilterSuccess();
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (!bool2)
        {
          if (!paramBoolean) {
            break label98;
          }
          paramBoolean = SoLoader.loadSvArtFilterSO(SdkContext.getInstance().getApplication());
          bool1 = paramBoolean;
          if (SLog.isEnable()) {
            SLog.d("QMCF_MGR", "reloadso :" + paramBoolean);
          }
        }
      }
      label98:
      for (bool1 = paramBoolean; (bool3) && (bool1); bool1 = SoLoader.isQmcfSoUnLoaded()) {
        return true;
      }
    }
  }
  
  public boolean isArtFilterVersionOK(int paramInt)
  {
    return paramInt >= artFilterLimitVersion;
  }
  
  public boolean isQmcfNoNeedBeauty()
  {
    return (this.currQmcfMode == 1) || (this.currQmcfMode == 2);
  }
  
  public boolean isQmcfSupported()
  {
    return (mSwitchStrategy.isModeSupported(1)) || (mSwitchStrategy.isModeSupported(2)) || (mSwitchStrategy.isModeSupported(3));
  }
  
  public boolean isQmcfSupported(int paramInt)
  {
    return mSwitchStrategy.isModeSupported(paramInt);
  }
  
  public boolean isQmcfWork()
  {
    return this.currQmcfMode != 0;
  }
  
  public boolean needConvertCoor()
  {
    return this.mCameraMode == 1;
  }
  
  /* Error */
  public String readQmcfModelFile(String paramString)
  {
    // Byte code:
    //   0: invokestatic 316	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: new 143	java/io/File
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 159	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore_1
    //   13: aload_1
    //   14: invokevirtual 163	java/io/File:exists	()Z
    //   17: ifeq +200 -> 217
    //   20: new 389	java/io/FileInputStream
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 392	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore 5
    //   30: aload 5
    //   32: astore_1
    //   33: new 171	java/lang/String
    //   36: dup
    //   37: aload_0
    //   38: aload 5
    //   40: invokestatic 398	com/tencent/ttpic/baseutils/io/IOUtils:toByteArray	(Ljava/io/InputStream;)[B
    //   43: invokevirtual 400	com/tencent/mobileqq/qmcf/QmcfManager:drink	([B)[B
    //   46: invokespecial 403	java/lang/String:<init>	([B)V
    //   49: astore 6
    //   51: aload 6
    //   53: astore_1
    //   54: aload 5
    //   56: ifnull +11 -> 67
    //   59: aload 5
    //   61: invokevirtual 406	java/io/FileInputStream:close	()V
    //   64: aload 6
    //   66: astore_1
    //   67: invokestatic 190	com/tencent/sveffects/SLog:isEnable	()Z
    //   70: ifeq +57 -> 127
    //   73: new 145	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   80: ldc_w 408
    //   83: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokestatic 316	java/lang/System:currentTimeMillis	()J
    //   89: lload_2
    //   90: lsub
    //   91: invokevirtual 411	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   94: ldc_w 413
    //   97: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: astore 5
    //   102: aload_1
    //   103: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   106: ifne +95 -> 201
    //   109: iconst_1
    //   110: istore 4
    //   112: ldc 28
    //   114: aload 5
    //   116: iload 4
    //   118: invokevirtual 377	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   121: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 206	com/tencent/sveffects/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_1
    //   128: areturn
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 212	java/lang/Exception:printStackTrace	()V
    //   134: aload 6
    //   136: astore_1
    //   137: goto -70 -> 67
    //   140: astore 6
    //   142: aconst_null
    //   143: astore 5
    //   145: aload 5
    //   147: astore_1
    //   148: aload 6
    //   150: invokevirtual 212	java/lang/Exception:printStackTrace	()V
    //   153: aload 5
    //   155: ifnull +8 -> 163
    //   158: aload 5
    //   160: invokevirtual 406	java/io/FileInputStream:close	()V
    //   163: aconst_null
    //   164: astore_1
    //   165: goto -98 -> 67
    //   168: astore_1
    //   169: aload_1
    //   170: invokevirtual 212	java/lang/Exception:printStackTrace	()V
    //   173: aconst_null
    //   174: astore_1
    //   175: goto -108 -> 67
    //   178: astore 5
    //   180: aconst_null
    //   181: astore_1
    //   182: aload_1
    //   183: ifnull +7 -> 190
    //   186: aload_1
    //   187: invokevirtual 406	java/io/FileInputStream:close	()V
    //   190: aload 5
    //   192: athrow
    //   193: astore_1
    //   194: aload_1
    //   195: invokevirtual 212	java/lang/Exception:printStackTrace	()V
    //   198: goto -8 -> 190
    //   201: iconst_0
    //   202: istore 4
    //   204: goto -92 -> 112
    //   207: astore 5
    //   209: goto -27 -> 182
    //   212: astore 6
    //   214: goto -69 -> 145
    //   217: aconst_null
    //   218: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	QmcfManager
    //   0	219	1	paramString	String
    //   3	87	2	l	long
    //   110	93	4	bool	boolean
    //   28	131	5	localObject1	Object
    //   178	13	5	localObject2	Object
    //   207	1	5	localObject3	Object
    //   49	86	6	str	String
    //   140	9	6	localException1	Exception
    //   212	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   59	64	129	java/lang/Exception
    //   20	30	140	java/lang/Exception
    //   158	163	168	java/lang/Exception
    //   20	30	178	finally
    //   186	190	193	java/lang/Exception
    //   33	51	207	finally
    //   148	153	207	finally
    //   33	51	212	java/lang/Exception
  }
  
  public void reportQmcfFrameConsume(int paramInt1, int paramInt2, String paramString)
  {
    mReporter.reportMtaFrameCost(paramInt1, paramInt2, paramString, this.currQmcfMode, this.currFrameType);
  }
  
  public void setCameraMode(int paramInt)
  {
    this.mCameraMode = paramInt;
  }
  
  public void setCurrFrameType(int paramInt)
  {
    if (this.currFrameType != paramInt)
    {
      SharedPreferences.Editor localEditor = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).edit();
      localEditor.putInt(QMCF_FRAME_TYPE, paramInt);
      localEditor.commit();
      if (SLog.isEnable()) {
        SLog.d("QMCF_MGR", "setCurrFrameType:" + paramInt);
      }
    }
    this.currFrameType = paramInt;
  }
  
  public void setCurrQmcfMode(int paramInt)
  {
    this.currQmcfMode = paramInt;
  }
  
  public void setCurrResFolder(String paramString)
  {
    this.currModelResFolder = paramString;
  }
  
  public void setIsQQRun(boolean paramBoolean)
  {
    isQQRun = paramBoolean;
  }
  
  public void setQmcfInitSuccess(boolean paramBoolean)
  {
    mSwitchStrategy.setInitSuccess(paramBoolean);
  }
  
  public void setQmcfMobileNotSupport(String paramString)
  {
    if (mSwitchStrategy.isMobileSupported())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("svaf_gpuinfo", paramString);
      paramString = mReporter;
      QmcfReporter.report("svaf_nosupport_ocl", localHashMap, true);
    }
    mSwitchStrategy.setMobileSupport(false);
  }
  
  public void setQmcfMobileSupport()
  {
    mSwitchStrategy.setMobileSupport(true);
  }
  
  public void setQmcfProcessConsume(long paramLong)
  {
    mReporter.updateProcessConsume(paramLong);
  }
  
  public void setQmcfRunSupported(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    mSwitchStrategy.setQmcfRunSupported(paramBoolean1, paramBoolean2, paramInt);
  }
  
  public void setSTMatrix(float[] paramArrayOfFloat)
  {
    this.mSTMatrix = paramArrayOfFloat;
  }
  
  public void switchQmcfModel(int paramInt, String paramString)
  {
    if (SLog.isEnable()) {
      SLog.d("QMCF_MGR", "switchQmcfModel begin resFold" + paramString);
    }
    synchronized (this.modelSwichList)
    {
      if (paramInt == this.currQmcfMode)
      {
        this.modelSwichList.add(paramString);
        if (this.currQmcfMode == 1) {
          this.modelSwitched = true;
        }
        this.currQmcfMode = paramInt;
        this.currModelResFolder = paramString;
        if (this.singleThreadExecutor == null)
        {
          if (SLog.isEnable()) {
            SLog.d("QMCF_MGR", "switchQmcfModel create singleThreadExecutor");
          }
          this.singleThreadExecutor = Executors.newSingleThreadExecutor();
        }
        this.singleThreadExecutor.execute(new QmcfManager.1(this));
        return;
      }
      this.modeChanged = true;
      this.modelSwichList.clear();
      this.modelSwichList.add(paramString);
    }
  }
  
  public void updateQmcfFrameConsume(long paramLong)
  {
    mReporter.updateFrameConsume(paramLong);
  }
  
  public void updateQmcfMainSwitch(JSONObject paramJSONObject)
  {
    mSwitchStrategy.updateMainSwitch(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.QmcfManager
 * JD-Core Version:    0.7.0.1
 */