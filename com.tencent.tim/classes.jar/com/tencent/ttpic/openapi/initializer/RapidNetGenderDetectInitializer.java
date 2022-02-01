package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.RapidnetCPUGenderDetect;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RapidNetGenderDetectInitializer
  extends Feature
{
  private static final String TAG = "RapidNetGenderDetectInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_java3"), new SharedLibraryInfo("rapidnet_cpu_common"), new SharedLibraryInfo("rapidnet_cpu_gender_detect") };
  private RapidnetModelManager modelManager = new RapidnetModelManager();
  private final RapidnetCPUGenderDetect rapidnetCPUGenderDetect = new RapidnetCPUGenderDetect();
  
  private boolean unloadRapidNetModelImpl(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    LogUtils.i("RapidNetGenderDetectInitializer", "unloadRapidNetModelImpl");
    synchronized (this.rapidnetCPUGenderDetect)
    {
      paramInt1 = this.rapidnetCPUGenderDetect.deinit();
      if (paramInt1 == 0) {
        return true;
      }
    }
    return false;
  }
  
  public void deInitAll()
  {
    if (FeatureManager.Features.RAPID_NET_GENDER_DETECT.isFunctionReady()) {
      destroyImpl();
    }
  }
  
  protected boolean destroyImpl()
  {
    synchronized (this.rapidnetCPUGenderDetect)
    {
      this.rapidnetCPUGenderDetect.deinit();
      return true;
    }
  }
  
  public List<ModelInfo> getModelInfos()
  {
    return new ArrayList();
  }
  
  public String getName()
  {
    return "RapidNetGenderDetectInitializer";
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
  
  public boolean loadRapidModelFrom(String paramString, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      try
      {
        LogUtils.i("RapidNetGenderDetectInitializer", "loadRapidNetModelImpl");
        boolean bool = isFunctionReady();
        if (!bool)
        {
          paramBoolean1 = false;
          return paramBoolean1;
        }
        if (!unloadRapidNetModelImpl(true, paramInt1, paramInt3))
        {
          paramBoolean1 = false;
          continue;
        }
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          paramList = RapidnetModelManager.copyIfInAssets(paramString, str1 + ".rapidmodel", FeatureManager.Features.RAPID_NET_GESTURE.getFinalResourcesDir());
          str1 = RapidnetModelManager.copyIfInAssets(paramString, str1 + ".rapidproto", FeatureManager.Features.RAPID_NET_GESTURE.getFinalResourcesDir());
          File localFile1 = new File(paramList);
          File localFile2 = new File(str1);
          if (paramBoolean1)
          {
            String str2 = RapidnetModelManager.decryptRapidNetFile(localFile1.getParent(), localFile1.getName());
            paramList = str2;
            if (str2 == null)
            {
              paramBoolean1 = false;
              continue;
            }
          }
          localArrayList1.add(paramList);
          paramList = str1;
          if (paramBoolean2)
          {
            str1 = RapidnetModelManager.decryptRapidNetFile(localFile1.getParent(), localFile2.getName());
            paramList = str1;
            if (str1 == null)
            {
              paramBoolean1 = false;
              continue;
            }
          }
          localArrayList2.add(paramList);
          continue;
        }
        paramInt2 = -1;
      }
      finally {}
      paramString = this.rapidnetCPUGenderDetect;
      if (paramInt1 == 5) {}
      try
      {
        paramInt2 = this.rapidnetCPUGenderDetect.init((String)localArrayList2.get(0), (String)localArrayList1.get(0));
        FileUtils.delete((String)localArrayList2.get(0));
        if (paramInt2 != 0)
        {
          LogUtils.d("RapidNetGenderDetectInitializer", "RapidnetLib init failed ret =" + paramInt2);
          paramBoolean1 = false;
          continue;
        }
      }
      finally {}
      LogUtils.d("RapidNetGenderDetectInitializer", "RapidnetLib init success. ret =" + paramInt2);
      this.modelManager.toggleRapidModel(paramInt3, true);
      paramBoolean1 = true;
    }
  }
  
  public float[] retrieveGenderInfo(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.modelManager.isModelLoaded(5)) {
      synchronized (this.rapidnetCPUGenderDetect)
      {
        if (this.modelManager.isModelLoaded(5))
        {
          paramBitmap = this.rapidnetCPUGenderDetect.forwardWithBox(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
          return paramBitmap;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.RapidNetGenderDetectInitializer
 * JD-Core Version:    0.7.0.1
 */