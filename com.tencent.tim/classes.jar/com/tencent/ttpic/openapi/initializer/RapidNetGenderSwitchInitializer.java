package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.RapidnetGPUGenderSwitch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RapidNetGenderSwitchInitializer
  extends Feature
{
  private static final String TAG = "RapidNetGenderSwitchInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_java3"), new SharedLibraryInfo("Rapidnet"), new SharedLibraryInfo("rapidnet_gpu_genderswitch") };
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  private final RapidnetGPUGenderSwitch rapidnetGPUGenderSwitch = new RapidnetGPUGenderSwitch();
  
  private boolean isHairSkyGenderModelLoaded()
  {
    boolean bool = false;
    if ((this.modelManager.isModelLoaded(0)) || (this.modelManager.isModelLoaded(1)) || (this.modelManager.isModelLoaded(2))) {
      bool = true;
    }
    return bool;
  }
  
  private boolean unloadRapidNetModelImpl(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    LogUtils.i("RapidNetGenderSwitchInitializer", "unloadRapidNetModelImpl");
    if (paramInt1 == 1) {
      synchronized (this.rapidnetGPUGenderSwitch)
      {
        paramInt1 = this.rapidnetGPUGenderSwitch.deinit();
      }
    }
    while (paramInt1 != 0)
    {
      return false;
      paramInt1 = 0;
    }
    return true;
  }
  
  public void deInitAll()
  {
    if (FeatureManager.Features.RAPID_NET_GENDER_SWITCH.isFunctionReady()) {
      destroyImpl();
    }
  }
  
  protected boolean destroyImpl()
  {
    synchronized (this.rapidnetGPUGenderSwitch)
    {
      this.rapidnetGPUGenderSwitch.deinit();
      return true;
    }
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return forward(paramBitmap, paramInt1, false, false, paramInt2);
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if ((isHairSkyGenderModelLoaded()) && (paramInt1 == 0)) {
      synchronized (this.rapidnetGPUGenderSwitch)
      {
        if (this.modelManager.isModelLoaded(0))
        {
          paramBitmap = this.rapidnetGPUGenderSwitch.forwardWithAngle(paramBitmap, paramInt2);
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
    return "RapidNetGenderSwitchInitializer";
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
    //   13: invokevirtual 74	com/tencent/ttpic/openapi/initializer/RapidNetGenderSwitchInitializer:isFunctionReady	()Z
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
    //   42: invokespecial 115	com/tencent/ttpic/openapi/initializer/RapidNetGenderSwitchInitializer:unloadRapidNetModelImpl	(ZII)Z
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
    //   68: getstatic 71	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_GENDER_SWITCH	Lcom/tencent/ttpic/openapi/initializer/RapidNetGenderSwitchInitializer;
    //   71: invokevirtual 130	com/tencent/ttpic/openapi/initializer/RapidNetGenderSwitchInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   74: invokestatic 134	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   77: astore 10
    //   79: aload_1
    //   80: new 117	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   87: aload_2
    //   88: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc 136
    //   93: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: getstatic 71	com/tencent/ttpic/openapi/manager/FeatureManager$Features:RAPID_NET_GENDER_SWITCH	Lcom/tencent/ttpic/openapi/initializer/RapidNetGenderSwitchInitializer;
    //   102: invokevirtual 130	com/tencent/ttpic/openapi/initializer/RapidNetGenderSwitchInitializer:getFinalResourcesDir	()Ljava/lang/String;
    //   105: invokestatic 134	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:copyIfInAssets	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   108: astore_2
    //   109: new 138	java/io/File
    //   112: dup
    //   113: aload 10
    //   115: invokespecial 139	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: astore 11
    //   120: new 138	java/io/File
    //   123: dup
    //   124: aload_2
    //   125: invokespecial 139	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: astore 12
    //   130: aload 10
    //   132: astore_1
    //   133: iload_3
    //   134: ifeq +25 -> 159
    //   137: aload 11
    //   139: invokevirtual 142	java/io/File:getParent	()Ljava/lang/String;
    //   142: aload 11
    //   144: invokevirtual 144	java/io/File:getName	()Ljava/lang/String;
    //   147: invokestatic 148	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:decryptRapidNetFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   150: astore_1
    //   151: iload 9
    //   153: istore 8
    //   155: aload_1
    //   156: ifnull -129 -> 27
    //   159: iload 4
    //   161: ifeq +25 -> 186
    //   164: aload 11
    //   166: invokevirtual 142	java/io/File:getParent	()Ljava/lang/String;
    //   169: aload 12
    //   171: invokevirtual 144	java/io/File:getName	()Ljava/lang/String;
    //   174: invokestatic 148	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:decryptRapidNetFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   177: astore_2
    //   178: iload 9
    //   180: istore 8
    //   182: aload_2
    //   183: ifnull -156 -> 27
    //   186: iload 9
    //   188: istore 8
    //   190: aload_1
    //   191: invokestatic 154	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   194: ifeq -167 -> 27
    //   197: iload 9
    //   199: istore 8
    //   201: aload_2
    //   202: invokestatic 154	com/tencent/ttpic/baseutils/io/FileUtils:isFileExist	(Ljava/lang/String;)Z
    //   205: ifeq -178 -> 27
    //   208: aload_0
    //   209: getfield 40	com/tencent/ttpic/openapi/initializer/RapidNetGenderSwitchInitializer:rapidnetGPUGenderSwitch	Lcom/tencent/youtu/rapidnet/library/RapidnetGPUGenderSwitch;
    //   212: astore 10
    //   214: aload 10
    //   216: monitorenter
    //   217: aload_0
    //   218: getfield 40	com/tencent/ttpic/openapi/initializer/RapidNetGenderSwitchInitializer:rapidnetGPUGenderSwitch	Lcom/tencent/youtu/rapidnet/library/RapidnetGPUGenderSwitch;
    //   221: aload_2
    //   222: aload_1
    //   223: getstatic 160	com/tencent/youtu/rapidnet/library/RapidnetGPUSegmentation:HAIR_GENDER_SWITCH	I
    //   226: invokevirtual 164	com/tencent/youtu/rapidnet/library/RapidnetGPUGenderSwitch:init	(Ljava/lang/String;Ljava/lang/String;I)I
    //   229: istore 5
    //   231: aload 10
    //   233: monitorexit
    //   234: aload_2
    //   235: invokestatic 167	com/tencent/ttpic/baseutils/io/FileUtils:delete	(Ljava/lang/String;)V
    //   238: iload 5
    //   240: ifeq +46 -> 286
    //   243: ldc 8
    //   245: new 117	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   252: ldc 169
    //   254: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: iload 5
    //   259: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   262: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 175	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: iload 9
    //   270: istore 8
    //   272: goto -245 -> 27
    //   275: astore_1
    //   276: aload_0
    //   277: monitorexit
    //   278: aload_1
    //   279: athrow
    //   280: astore_1
    //   281: aload 10
    //   283: monitorexit
    //   284: aload_1
    //   285: athrow
    //   286: ldc 8
    //   288: new 117	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   295: ldc 177
    //   297: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: iload 5
    //   302: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   305: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 175	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: aload_0
    //   312: getfield 45	com/tencent/ttpic/openapi/initializer/RapidNetGenderSwitchInitializer:modelManager	Lcom/tencent/ttpic/openapi/initializer/RapidnetModelManager;
    //   315: iload 7
    //   317: iconst_1
    //   318: invokevirtual 181	com/tencent/ttpic/openapi/initializer/RapidnetModelManager:toggleRapidModel	(IZ)V
    //   321: iconst_1
    //   322: istore 8
    //   324: goto -297 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	RapidNetGenderSwitchInitializer
    //   0	327	1	paramString1	String
    //   0	327	2	paramString2	String
    //   0	327	3	paramBoolean1	boolean
    //   0	327	4	paramBoolean2	boolean
    //   0	327	5	paramInt1	int
    //   0	327	6	paramInt2	int
    //   0	327	7	paramInt3	int
    //   16	307	8	bool1	boolean
    //   1	268	9	bool2	boolean
    //   118	47	11	localFile1	java.io.File
    //   128	42	12	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   5	18	275	finally
    //   36	130	275	finally
    //   137	151	275	finally
    //   164	178	275	finally
    //   190	197	275	finally
    //   201	217	275	finally
    //   234	238	275	finally
    //   243	268	275	finally
    //   284	286	275	finally
    //   286	321	275	finally
    //   217	234	280	finally
    //   281	284	280	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.RapidNetGenderSwitchInitializer
 * JD-Core Version:    0.7.0.1
 */