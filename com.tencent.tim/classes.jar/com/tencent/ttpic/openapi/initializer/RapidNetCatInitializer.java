package com.tencent.ttpic.openapi.initializer;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.youtu.rapidnet.library.RapidnetCPUCat;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RapidNetCatInitializer
  extends Feature
{
  private static final String TAG = "RapidNetCatInitializer";
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("c++_shared"), new SharedLibraryInfo("opencv_java3"), new SharedLibraryInfo("rapidnet_cpu_common"), new SharedLibraryInfo("rapidnet_cpu_cat") };
  private final RapidnetCPUCat rapidnetCPUCat = new RapidnetCPUCat();
  
  private boolean unloadRapidNetModelImpl(boolean paramBoolean)
  {
    LogUtils.i("RapidNetCatInitializer", "unloadRapidNetModelImpl");
    synchronized (this.rapidnetCPUCat)
    {
      int i = this.rapidnetCPUCat.catKeypointsDeinit();
      if (i == 0) {
        return true;
      }
    }
    return false;
  }
  
  protected boolean destroyImpl()
  {
    synchronized (this.rapidnetCPUCat)
    {
      this.rapidnetCPUCat.catKeypointsDeinit();
      return true;
    }
  }
  
  public List<ModelInfo> getModelInfos()
  {
    return new ArrayList();
  }
  
  public String getName()
  {
    return "RapidNetCatInitializer";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sharedLibraries);
  }
  
  protected boolean initImpl()
  {
    return loadAllSoFiles();
  }
  
  public boolean loadRapidModelFrom(String arg1, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    for (;;)
    {
      try
      {
        LogUtils.i("RapidNetCatInitializer", "loadRapidNetModelImpl");
        boolean bool = isFunctionReady();
        if (!bool)
        {
          paramBoolean1 = false;
          return paramBoolean1;
        }
        if (!unloadRapidNetModelImpl(true))
        {
          paramBoolean1 = false;
          continue;
        }
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          paramList = RapidnetModelManager.copyIfInAssets(???, str1 + ".rapidmodel", FeatureManager.Features.RAPID_NET_GESTURE.getFinalResourcesDir());
          str1 = RapidnetModelManager.copyIfInAssets(???, str1 + ".rapidproto", FeatureManager.Features.RAPID_NET_GESTURE.getFinalResourcesDir());
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
        synchronized (this.rapidnetCPUCat)
        {
          paramInt = this.rapidnetCPUCat.catKeypointsInit((String)localArrayList2.get(0), (String)localArrayList1.get(0), (String)localArrayList2.get(1), (String)localArrayList1.get(1), (String)localArrayList2.get(2), (String)localArrayList1.get(2));
          FileUtils.delete((String)localArrayList2.get(0));
          FileUtils.delete((String)localArrayList2.get(1));
          FileUtils.delete((String)localArrayList2.get(2));
          if (paramInt != 0)
          {
            LogUtils.d("RapidNetCatInitializer", "RapidnetLib init failed ret =" + paramInt);
            paramBoolean1 = false;
          }
        }
      }
      finally {}
      LogUtils.d("RapidNetCatInitializer", "RapidnetLib init success. ret =" + paramInt);
      paramBoolean1 = true;
    }
  }
  
  public float[] retrieveCatKeyPoints(Bitmap paramBitmap)
  {
    synchronized (this.rapidnetCPUCat)
    {
      paramBitmap = this.rapidnetCPUCat.catKeypointResult(paramBitmap, 0);
      return paramBitmap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.RapidNetCatInitializer
 * JD-Core Version:    0.7.0.1
 */