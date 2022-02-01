package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.RapidnetGPUSegmentationHuman;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RapidNetHumanSegGpuInitializer
  extends Feature
{
  private static final String TAG = "RapidNetHumanSegGpuInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_java3"), new SharedLibraryInfo("Rapidnet"), new SharedLibraryInfo("rapidnet_gpu_segmentation_human") };
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  private final RapidnetGPUSegmentationHuman rapidnetGPUSegmentationHuman = new RapidnetGPUSegmentationHuman();
  
  private boolean isHumanSegModelLoaded()
  {
    return this.modelManager.isModelLoaded(4);
  }
  
  private boolean unloadRapidNetModelImpl(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    paramBoolean = false;
    LogUtils.i("RapidNetHumanSegGpuInitializer", "unloadRapidNetModelImpl");
    if (paramInt2 == 4) {
      synchronized (this.rapidnetGPUSegmentationHuman)
      {
        paramInt1 = this.rapidnetGPUSegmentationHuman.deinit();
      }
    }
    paramInt1 = 0;
    if (paramInt1 == 0) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public void deInitAll()
  {
    if (FeatureManager.Features.RAPID_NET_HUMAN_SEG_GPU.isFunctionReady()) {
      destroyImpl();
    }
  }
  
  protected boolean destroyImpl()
  {
    synchronized (this.rapidnetGPUSegmentationHuman)
    {
      this.rapidnetGPUSegmentationHuman.deinit();
      return true;
    }
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return forward(paramBitmap, paramInt1, false, false, paramInt2);
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if ((isHumanSegModelLoaded()) && (paramInt1 == 4)) {
      synchronized (this.rapidnetGPUSegmentationHuman)
      {
        if (isHumanSegModelLoaded())
        {
          paramBitmap = this.rapidnetGPUSegmentationHuman.forwardWithAngle(paramBitmap, 0);
          return paramBitmap;
        }
        return paramBitmap;
      }
    }
    return paramBitmap;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    return new ArrayList();
  }
  
  public String getName()
  {
    return "RapidNetHumanSegGpuInitializer";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sharedLibraries);
  }
  
  protected boolean initImpl()
  {
    return loadAllSoFiles();
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
    //   7: ldc 113
    //   9: invokestatic 60	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 74	com/tencent/ttpic/openapi/initializer/RapidNetHumanSegGpuInitializer:isFunctionReady	()Z
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
    //   42: invokespecial 115	com/tencent/ttpic/openapi/initializer/RapidNetHumanSegGpuInitializer:unloadRapidNetModelImpl	(ZII)Z
    //   45: ifeq -18 -> 27
    //   48: aload_1
    //   49: new 117	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   56: aload_2
    //   57: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 124
    //   62: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: getstatic 131	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_SEG_GPU	Lcom/tencent/ttpic/openapi/initializer/RapidNetSegGpuInitializer;
    //   71: invokevirtual 136	com/tencent/ttpic/openapi/initializer/RapidNetSegGpuInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   74: invokestatic 140	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   77: astore 10
    //   79: aload_1
    //   80: new 117	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   87: aload_2
    //   88: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc 142
    //   93: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: getstatic 131	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_SEG_GPU	Lcom/tencent/ttpic/openapi/initializer/RapidNetSegGpuInitializer;
    //   102: invokevirtual 136	com/tencent/ttpic/openapi/initializer/RapidNetSegGpuInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   105: invokestatic 140	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   108: astore_2
    //   109: new 144	java/io/File
    //   112: dup
    //   113: aload 10
    //   115: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: astore 11
    //   120: new 144	java/io/File
    //   123: dup
    //   124: aload_2
    //   125: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: astore 12
    //   130: aload 10
    //   132: astore_1
    //   133: iload_3
    //   134: ifeq +25 -> 159
    //   137: aload 11
    //   139: invokevirtual 148	java/io/File:getParent	()Ljava/lang/String;
    //   142: aload 11
    //   144: invokevirtual 150	java/io/File:getName	()Ljava/lang/String;
    //   147: invokestatic 154	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:decryptRapidNetFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   150: astore_1
    //   151: iload 9
    //   153: istore 8
    //   155: aload_1
    //   156: ifnull -129 -> 27
    //   159: iload 4
    //   161: ifeq +25 -> 186
    //   164: aload 11
    //   166: invokevirtual 148	java/io/File:getParent	()Ljava/lang/String;
    //   169: aload 12
    //   171: invokevirtual 150	java/io/File:getName	()Ljava/lang/String;
    //   174: invokestatic 154	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:decryptRapidNetFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   177: astore_2
    //   178: iload 9
    //   180: istore 8
    //   182: aload_2
    //   183: ifnull -156 -> 27
    //   186: iload 9
    //   188: istore 8
    //   190: aload_1
    //   191: invokestatic 160	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   194: ifeq -167 -> 27
    //   197: iload 9
    //   199: istore 8
    //   201: aload_2
    //   202: invokestatic 160	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   205: ifeq -178 -> 27
    //   208: iload 7
    //   210: iconst_4
    //   211: if_icmpne +122 -> 333
    //   214: aload_0
    //   215: getfield 40	com/tencent/ttpic/openapi/initializer/RapidNetHumanSegGpuInitializer:rapidnetGPUSegmentationHuman	Lcom/tencent/youtu/rapidnet/library/RapidnetGPUSegmentationHuman;
    //   218: astore 10
    //   220: aload 10
    //   222: monitorenter
    //   223: aload_0
    //   224: getfield 40	com/tencent/ttpic/openapi/initializer/RapidNetHumanSegGpuInitializer:rapidnetGPUSegmentationHuman	Lcom/tencent/youtu/rapidnet/library/RapidnetGPUSegmentationHuman;
    //   227: aload_2
    //   228: aload_1
    //   229: getstatic 164	com/tencent/youtu/rapidnet/library/RapidnetGPUSegmentationHuman:HAIR_SEG_MODEL	I
    //   232: invokevirtual 168	com/tencent/youtu/rapidnet/library/RapidnetGPUSegmentationHuman:init	(Ljava/lang/String;Ljava/lang/String;I)I
    //   235: istore 5
    //   237: aload 10
    //   239: monitorexit
    //   240: aload_2
    //   241: invokestatic 171	com/tencent/ttpic/baseutils/io/FileUtils:delete	(Ljava/lang/String;)V
    //   244: iload 5
    //   246: ifeq +46 -> 292
    //   249: ldc 8
    //   251: new 117	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   258: ldc 173
    //   260: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: iload 5
    //   265: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 179	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: iload 9
    //   276: istore 8
    //   278: goto -251 -> 27
    //   281: astore_1
    //   282: aload_0
    //   283: monitorexit
    //   284: aload_1
    //   285: athrow
    //   286: astore_1
    //   287: aload 10
    //   289: monitorexit
    //   290: aload_1
    //   291: athrow
    //   292: ldc 8
    //   294: new 117	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   301: ldc 181
    //   303: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: iload 5
    //   308: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   311: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 179	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: aload_0
    //   318: getfield 45	com/tencent/ttpic/openapi/initializer/RapidNetHumanSegGpuInitializer:modelManager	Lcom/tencent/ttpic/openapi/initializer/RapidnetModelManager;
    //   321: iload 7
    //   323: iconst_1
    //   324: invokevirtual 185	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:toggleRapidModel	(IZ)V
    //   327: iconst_1
    //   328: istore 8
    //   330: goto -303 -> 27
    //   333: iconst_m1
    //   334: istore 5
    //   336: goto -96 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	this	RapidNetHumanSegGpuInitializer
    //   0	339	1	paramString1	String
    //   0	339	2	paramString2	String
    //   0	339	3	paramBoolean1	boolean
    //   0	339	4	paramBoolean2	boolean
    //   0	339	5	paramInt1	int
    //   0	339	6	paramInt2	int
    //   0	339	7	paramInt3	int
    //   16	313	8	bool1	boolean
    //   1	274	9	bool2	boolean
    //   118	47	11	localFile1	java.io.File
    //   128	42	12	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   5	18	281	finally
    //   36	130	281	finally
    //   137	151	281	finally
    //   164	178	281	finally
    //   190	197	281	finally
    //   201	208	281	finally
    //   214	223	281	finally
    //   240	244	281	finally
    //   249	274	281	finally
    //   290	292	281	finally
    //   292	327	281	finally
    //   223	240	286	finally
    //   287	290	286	finally
  }
  
  public void setMode(int paramInt)
  {
    if (isHumanSegModelLoaded()) {
      synchronized (this.rapidnetGPUSegmentationHuman)
      {
        if (isHumanSegModelLoaded()) {
          this.rapidnetGPUSegmentationHuman.setMode(paramInt);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.RapidNetHumanSegGpuInitializer
 * JD-Core Version:    0.7.0.1
 */