package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.RapidnetCPUSegmentationHuman;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RapidNetHumanSegCpuInitializer
  extends Feature
{
  private static final String TAG = "RapidNetHumanSegCpuInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_java3"), new SharedLibraryInfo("rapidnet_cpu_common"), new SharedLibraryInfo("rapidnet_cpu_segmentation_human") };
  private boolean isUseCpuLib = false;
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  private final RapidnetCPUSegmentationHuman rapidnetCPUSegmentationHuman = new RapidnetCPUSegmentationHuman();
  
  private boolean isHumanSegModelLoaded()
  {
    return this.modelManager.isModelLoaded(4);
  }
  
  private boolean unloadRapidNetModelImpl(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    paramBoolean = false;
    LogUtils.i("RapidNetHumanSegCpuInitializer", "unloadRapidNetModelImpl");
    if (paramInt2 == 4) {
      synchronized (this.rapidnetCPUSegmentationHuman)
      {
        paramInt1 = this.rapidnetCPUSegmentationHuman.deinit();
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
    if (FeatureManager.Features.RAPID_NET_HUMAN_SEG_CPU.isFunctionReady()) {
      destroyImpl();
    }
  }
  
  protected boolean destroyImpl()
  {
    synchronized (this.rapidnetCPUSegmentationHuman)
    {
      this.rapidnetCPUSegmentationHuman.deinit();
      return true;
    }
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return forward(paramBitmap, paramInt1, this.isUseCpuLib, this.isUseCpuLib, paramInt2);
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if ((isHumanSegModelLoaded()) && (paramInt1 == 4)) {
      synchronized (this.rapidnetCPUSegmentationHuman)
      {
        if (isHumanSegModelLoaded())
        {
          paramBitmap = this.rapidnetCPUSegmentationHuman.forwardWithAngle(paramBitmap, 0);
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
    return "RapidNetHumanSegCpuInitializer";
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
    //   7: ldc 117
    //   9: invokestatic 64	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 78	com/tencent/ttpic/openapi/initializer/RapidNetHumanSegCpuInitializer:isFunctionReady	()Z
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
    //   37: iconst_1
    //   38: iload 5
    //   40: iload 7
    //   42: invokespecial 119	com/tencent/ttpic/openapi/initializer/RapidNetHumanSegCpuInitializer:unloadRapidNetModelImpl	(ZII)Z
    //   45: ifeq -18 -> 27
    //   48: aload_1
    //   49: new 121	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   56: aload_2
    //   57: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 128
    //   62: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: getstatic 135	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_SEG_CPU	Lcom/tencent/ttpic/openapi/initializer/RapidNetSegCpuInitializer;
    //   71: invokevirtual 140	com/tencent/ttpic/openapi/initializer/RapidNetSegCpuInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   74: invokestatic 144	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   77: astore 10
    //   79: aload_1
    //   80: new 121	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   87: aload_2
    //   88: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc 146
    //   93: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: getstatic 135	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_SEG_CPU	Lcom/tencent/ttpic/openapi/initializer/RapidNetSegCpuInitializer;
    //   102: invokevirtual 140	com/tencent/ttpic/openapi/initializer/RapidNetSegCpuInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   105: invokestatic 144	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   108: astore_2
    //   109: new 148	java/io/File
    //   112: dup
    //   113: aload 10
    //   115: invokespecial 149	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: astore 11
    //   120: new 148	java/io/File
    //   123: dup
    //   124: aload_2
    //   125: invokespecial 149	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: astore 12
    //   130: aload 10
    //   132: astore_1
    //   133: iload_3
    //   134: ifeq +25 -> 159
    //   137: aload 11
    //   139: invokevirtual 152	java/io/File:getParent	()Ljava/lang/String;
    //   142: aload 11
    //   144: invokevirtual 154	java/io/File:getName	()Ljava/lang/String;
    //   147: invokestatic 158	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:decryptRapidNetFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   150: astore_1
    //   151: iload 9
    //   153: istore 8
    //   155: aload_1
    //   156: ifnull -129 -> 27
    //   159: iload 4
    //   161: ifeq +25 -> 186
    //   164: aload 11
    //   166: invokevirtual 152	java/io/File:getParent	()Ljava/lang/String;
    //   169: aload 12
    //   171: invokevirtual 154	java/io/File:getName	()Ljava/lang/String;
    //   174: invokestatic 158	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:decryptRapidNetFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   177: astore_2
    //   178: iload 9
    //   180: istore 8
    //   182: aload_2
    //   183: ifnull -156 -> 27
    //   186: iload 9
    //   188: istore 8
    //   190: aload_1
    //   191: invokestatic 164	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   194: ifeq -167 -> 27
    //   197: iload 9
    //   199: istore 8
    //   201: aload_2
    //   202: invokestatic 164	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   205: ifeq -178 -> 27
    //   208: aload_0
    //   209: iconst_1
    //   210: putfield 44	com/tencent/ttpic/openapi/initializer/RapidNetHumanSegCpuInitializer:isUseCpuLib	Z
    //   213: iload 7
    //   215: iconst_4
    //   216: if_icmpne +119 -> 335
    //   219: aload_0
    //   220: getfield 42	com/tencent/ttpic/openapi/initializer/RapidNetHumanSegCpuInitializer:rapidnetCPUSegmentationHuman	Lcom/tencent/youtu/rapidnet/library/RapidnetCPUSegmentationHuman;
    //   223: astore 10
    //   225: aload 10
    //   227: monitorenter
    //   228: aload_0
    //   229: getfield 42	com/tencent/ttpic/openapi/initializer/RapidNetHumanSegCpuInitializer:rapidnetCPUSegmentationHuman	Lcom/tencent/youtu/rapidnet/library/RapidnetCPUSegmentationHuman;
    //   232: aload_2
    //   233: aload_1
    //   234: invokevirtual 168	com/tencent/youtu/rapidnet/library/RapidnetCPUSegmentationHuman:init	(Ljava/lang/String;Ljava/lang/String;)I
    //   237: istore 5
    //   239: aload 10
    //   241: monitorexit
    //   242: aload_2
    //   243: invokestatic 171	com/tencent/ttpic/baseutils/io/FileUtils:delete	(Ljava/lang/String;)V
    //   246: iload 5
    //   248: ifeq +46 -> 294
    //   251: ldc 8
    //   253: new 121	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   260: ldc 173
    //   262: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: iload 5
    //   267: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   270: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 179	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: iload 9
    //   278: istore 8
    //   280: goto -253 -> 27
    //   283: astore_1
    //   284: aload_0
    //   285: monitorexit
    //   286: aload_1
    //   287: athrow
    //   288: astore_1
    //   289: aload 10
    //   291: monitorexit
    //   292: aload_1
    //   293: athrow
    //   294: ldc 8
    //   296: new 121	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   303: ldc 181
    //   305: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: iload 5
    //   310: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 179	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: aload_0
    //   320: getfield 49	com/tencent/ttpic/openapi/initializer/RapidNetHumanSegCpuInitializer:modelManager	Lcom/tencent/ttpic/openapi/initializer/RapidnetModelManager;
    //   323: iload 7
    //   325: iconst_1
    //   326: invokevirtual 185	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:toggleRapidModel	(IZ)V
    //   329: iconst_1
    //   330: istore 8
    //   332: goto -305 -> 27
    //   335: iconst_m1
    //   336: istore 5
    //   338: goto -96 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	this	RapidNetHumanSegCpuInitializer
    //   0	341	1	paramString1	String
    //   0	341	2	paramString2	String
    //   0	341	3	paramBoolean1	boolean
    //   0	341	4	paramBoolean2	boolean
    //   0	341	5	paramInt1	int
    //   0	341	6	paramInt2	int
    //   0	341	7	paramInt3	int
    //   16	315	8	bool1	boolean
    //   1	276	9	bool2	boolean
    //   118	47	11	localFile1	java.io.File
    //   128	42	12	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   5	18	283	finally
    //   36	130	283	finally
    //   137	151	283	finally
    //   164	178	283	finally
    //   190	197	283	finally
    //   201	213	283	finally
    //   219	228	283	finally
    //   242	246	283	finally
    //   251	276	283	finally
    //   292	294	283	finally
    //   294	329	283	finally
    //   228	242	288	finally
    //   289	292	288	finally
  }
  
  public void setMode(int paramInt)
  {
    if (isHumanSegModelLoaded()) {
      synchronized (this.rapidnetCPUSegmentationHuman)
      {
        if (isHumanSegModelLoaded()) {
          this.rapidnetCPUSegmentationHuman.hairSegSetMode(paramInt);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.RapidNetHumanSegCpuInitializer
 * JD-Core Version:    0.7.0.1
 */