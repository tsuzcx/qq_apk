package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.TNNStyleChild;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TNNStyleChildInitializer
  extends Feature
{
  private static final String TAG = "TNNStyleChildInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_java3"), new SharedLibraryInfo("TNN"), new SharedLibraryInfo("tnn_common"), new SharedLibraryInfo("tnn_stylechild") };
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  private final TNNStyleChild tnnGenderSwitch = new TNNStyleChild();
  
  private boolean isHairSkyGenderModelLoaded()
  {
    return this.modelManager.isModelLoaded(6);
  }
  
  private boolean unloadRapidNetModelImpl(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    paramBoolean = false;
    LogUtils.i("TNNStyleChildInitializer", "unloadRapidNetModelImpl");
    if (paramInt1 == 6) {
      synchronized (this.tnnGenderSwitch)
      {
        this.modelManager.clear();
        paramInt1 = this.tnnGenderSwitch.deinit();
      }
    }
    paramInt1 = 0;
    if (paramInt1 == 0) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public int addInitMat(int paramInt, Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramInt = this.tnnGenderSwitch.addInitMat(paramBitmap, paramBoolean);
          return paramInt;
        }
      }
    }
    return -1;
  }
  
  public int addPostMat(int paramInt, Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramInt = this.tnnGenderSwitch.addPostMat(paramBitmap, paramBoolean);
          return paramInt;
        }
      }
    }
    return -1;
  }
  
  public int addPreMat(int paramInt, Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramInt = this.tnnGenderSwitch.addPreMat(paramBitmap, paramBoolean);
          return paramInt;
        }
      }
    }
    return -1;
  }
  
  public float[] computeFaceCropTransform(List<PointF> paramList, int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    float[] arrayOfFloat1 = new float[paramList.size()];
    float[] arrayOfFloat2 = new float[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfFloat1[i] = ((PointF)paramList.get(i)).x;
      arrayOfFloat2[i] = ((PointF)paramList.get(i)).y;
      i += 1;
    }
    return this.tnnGenderSwitch.computeFaceCropTransform(arrayOfFloat1, arrayOfFloat2, paramInt1, paramFloat, paramInt2, paramInt3);
  }
  
  public int convertBitmapToFloat(int paramInt, Bitmap paramBitmap, float[] paramArrayOfFloat)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramInt = this.tnnGenderSwitch.convertBitmapToFloat(paramBitmap, paramArrayOfFloat);
          return paramInt;
        }
      }
    }
    return -1;
  }
  
  public Bitmap convertFloatToBitmap(int paramInt, float[] paramArrayOfFloat)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramArrayOfFloat = this.tnnGenderSwitch.convertFloatToBitmap(paramArrayOfFloat);
          return paramArrayOfFloat;
        }
      }
    }
    return null;
  }
  
  public void deInitAll()
  {
    if (FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER.isFunctionReady()) {
      destroyImpl();
    }
  }
  
  protected boolean destroyImpl()
  {
    synchronized (this.tnnGenderSwitch)
    {
      this.modelManager.clear();
      this.tnnGenderSwitch.deinit();
      return true;
    }
  }
  
  public int forward(int paramInt1, int paramInt2)
  {
    return forward(paramInt1, false, false, paramInt2);
  }
  
  public int forward(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt1 == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramInt1 = this.tnnGenderSwitch.forwardTwoOutput();
          return paramInt1;
        }
      }
    }
    return -1;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    return new ArrayList();
  }
  
  public String getName()
  {
    return "TNNStyleChildInitializer";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sharedLibraries);
  }
  
  protected boolean initImpl()
  {
    return loadAllSoFiles();
  }
  
  public int initProcess(int paramInt)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramInt = this.tnnGenderSwitch.initProcess();
          return paramInt;
        }
      }
    }
    return -1;
  }
  
  public boolean isModelLoaded(int paramInt)
  {
    return this.modelManager.isModelLoaded(paramInt);
  }
  
  /* Error */
  public boolean loadRapidModelFrom(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc 8
    //   7: ldc 166
    //   9: invokestatic 62	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 127	com/tencent/ttpic/openapi/initializer/TNNStyleChildInitializer:isFunctionReady	()Z
    //   16: istore 8
    //   18: iload 8
    //   20: ifne +12 -> 32
    //   23: iload 9
    //   25: istore 8
    //   27: aload_0
    //   28: monitorexit
    //   29: iload 8
    //   31: ireturn
    //   32: iload 9
    //   34: istore 8
    //   36: aload_0
    //   37: iconst_0
    //   38: iload 5
    //   40: iload 7
    //   42: invokespecial 168	com/tencent/ttpic/openapi/initializer/TNNStyleChildInitializer:unloadRapidNetModelImpl	(ZII)Z
    //   45: ifeq -18 -> 27
    //   48: aload_1
    //   49: new 170	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   56: aload_2
    //   57: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 177
    //   62: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: getstatic 124	com/tencent/ttpic/openapi/manager/FeatureManager$Features:TNN_STYLE_CHILD_INITIALIZER	Lcom/tencent/ttpic/openapi/initializer/TNNStyleChildInitializer;
    //   71: invokevirtual 183	com/tencent/ttpic/openapi/initializer/TNNStyleChildInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   74: invokestatic 187	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   77: astore 10
    //   79: aload_1
    //   80: new 170	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   87: aload_2
    //   88: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc 189
    //   93: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: getstatic 124	com/tencent/ttpic/openapi/manager/FeatureManager$Features:TNN_STYLE_CHILD_INITIALIZER	Lcom/tencent/ttpic/openapi/initializer/TNNStyleChildInitializer;
    //   102: invokevirtual 183	com/tencent/ttpic/openapi/initializer/TNNStyleChildInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   105: invokestatic 187	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   108: astore_2
    //   109: new 191	java/io/File
    //   112: dup
    //   113: aload 10
    //   115: invokespecial 192	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: astore 11
    //   120: new 191	java/io/File
    //   123: dup
    //   124: aload_2
    //   125: invokespecial 192	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: astore 12
    //   130: aload 10
    //   132: astore_1
    //   133: iload_3
    //   134: ifeq +25 -> 159
    //   137: aload 11
    //   139: invokevirtual 195	java/io/File:getParent	()Ljava/lang/String;
    //   142: aload 11
    //   144: invokevirtual 197	java/io/File:getName	()Ljava/lang/String;
    //   147: invokestatic 201	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:decryptRapidNetFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   150: astore_1
    //   151: iload 9
    //   153: istore 8
    //   155: aload_1
    //   156: ifnull -129 -> 27
    //   159: iload 4
    //   161: ifeq +25 -> 186
    //   164: aload 11
    //   166: invokevirtual 195	java/io/File:getParent	()Ljava/lang/String;
    //   169: aload 12
    //   171: invokevirtual 197	java/io/File:getName	()Ljava/lang/String;
    //   174: invokestatic 201	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:decryptRapidNetFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   177: astore_2
    //   178: iload 9
    //   180: istore 8
    //   182: aload_2
    //   183: ifnull -156 -> 27
    //   186: iload 9
    //   188: istore 8
    //   190: aload_1
    //   191: invokestatic 207	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   194: ifeq -167 -> 27
    //   197: iload 9
    //   199: istore 8
    //   201: aload_2
    //   202: invokestatic 207	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   205: ifeq -178 -> 27
    //   208: aload_0
    //   209: getfield 42	com/tencent/ttpic/openapi/initializer/TNNStyleChildInitializer:tnnGenderSwitch	Lcom/tencent/youtu/rapidnet/library/TNNStyleChild;
    //   212: astore 10
    //   214: aload 10
    //   216: monitorenter
    //   217: aload_0
    //   218: getfield 42	com/tencent/ttpic/openapi/initializer/TNNStyleChildInitializer:tnnGenderSwitch	Lcom/tencent/youtu/rapidnet/library/TNNStyleChild;
    //   221: aload_2
    //   222: aload_1
    //   223: ldc 209
    //   225: invokevirtual 213	com/tencent/youtu/rapidnet/library/TNNStyleChild:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   228: istore 5
    //   230: aload 10
    //   232: monitorexit
    //   233: aload_2
    //   234: invokestatic 216	com/tencent/ttpic/baseutils/io/FileUtils:delete	(Ljava/lang/String;)V
    //   237: iload 5
    //   239: ifeq +46 -> 285
    //   242: ldc 8
    //   244: new 170	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   251: ldc 218
    //   253: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: iload 5
    //   258: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 224	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: iload 9
    //   269: istore 8
    //   271: goto -244 -> 27
    //   274: astore_1
    //   275: aload_0
    //   276: monitorexit
    //   277: aload_1
    //   278: athrow
    //   279: astore_1
    //   280: aload 10
    //   282: monitorexit
    //   283: aload_1
    //   284: athrow
    //   285: ldc 8
    //   287: new 170	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   294: ldc 226
    //   296: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: iload 5
    //   301: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   304: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokestatic 224	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   310: aload_0
    //   311: getfield 47	com/tencent/ttpic/openapi/initializer/TNNStyleChildInitializer:modelManager	Lcom/tencent/ttpic/openapi/initializer/RapidnetModelManager;
    //   314: iload 7
    //   316: iconst_1
    //   317: invokevirtual 230	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:toggleRapidModel	(IZ)V
    //   320: iconst_1
    //   321: istore 8
    //   323: goto -296 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	this	TNNStyleChildInitializer
    //   0	326	1	paramString1	String
    //   0	326	2	paramString2	String
    //   0	326	3	paramBoolean1	boolean
    //   0	326	4	paramBoolean2	boolean
    //   0	326	5	paramInt1	int
    //   0	326	6	paramInt2	int
    //   0	326	7	paramInt3	int
    //   16	306	8	bool1	boolean
    //   1	267	9	bool2	boolean
    //   118	47	11	localFile1	java.io.File
    //   128	42	12	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   5	18	274	finally
    //   36	130	274	finally
    //   137	151	274	finally
    //   164	178	274	finally
    //   190	197	274	finally
    //   201	217	274	finally
    //   233	237	274	finally
    //   242	267	274	finally
    //   283	285	274	finally
    //   285	320	274	finally
    //   217	233	279	finally
    //   280	283	279	finally
  }
  
  public int setParams(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, float[] paramArrayOfFloat6)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt1 == 6)) {
      synchronized (this.tnnGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(6))
        {
          paramInt1 = this.tnnGenderSwitch.setParams(paramString1, paramInt2, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat3, paramArrayOfFloat4, paramArrayOfFloat5, paramArrayOfFloat6);
          return paramInt1;
        }
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.TNNStyleChildInitializer
 * JD-Core Version:    0.7.0.1
 */