package com.tencent.ttpic.openapi.factory;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;
import com.tencent.filter.ttpic.GPUImageLookupFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.encrypt.FileEncryptUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.filter.ChannelSplitFilter;
import com.tencent.ttpic.openapi.filter.PtuFilterFactory;
import com.tencent.view.FilterEngineFactory;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;

public class TTPicFilterFactoryLocal
{
  private static final String TAG = TTPicFilterFactoryLocal.class.getSimpleName();
  
  public static void clearLutFiles()
  {
    if (AEModule.getLutDirPath() == null) {
      return;
    }
    FileUtils.delete(new File(AEModule.getLutDirPath()));
  }
  
  public static BaseFilter creatFilterById(int paramInt)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    if (AEModule.getLutDirPath() == null) {}
    Object localObject1;
    label818:
    do
    {
      return localObject3;
      switch (paramInt)
      {
      default: 
        localObject1 = null;
      }
      for (;;)
      {
        localObject3 = localObject2;
        if (localObject2 != null) {
          break;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label818;
        }
        return PtuFilterFactory.createFilter(paramInt);
        localObject2 = new GPUImageLookupFilter();
        ((BaseFilter)localObject2).addParam(new TextureResParam("inputImageTexture2", "sh/wuxia_lf.png", 33986));
        localObject1 = null;
        continue;
        localObject2 = new GPUImageLookupFilter();
        ((BaseFilter)localObject2).addParam(new TextureResParam("inputImageTexture2", "sh/ziran_lf.png", 33986));
        localObject1 = null;
        continue;
        localObject2 = new GPUImageLookupFilter();
        ((BaseFilter)localObject2).addParam(new TextureResParam("inputImageTexture2", "sh/qiangwei_lf.png", 33986));
        localObject1 = null;
        continue;
        localObject2 = new GPUImageLookupFilter();
        ((BaseFilter)localObject2).addParam(new TextureResParam("inputImageTexture2", "sh/xinye_lf.png", 33986));
        localObject1 = null;
        continue;
        localObject2 = new GPUImageLookupFilter();
        ((BaseFilter)localObject2).addParam(new TextureResParam("inputImageTexture2", "sh/tangguomeigui_lf.png", 33986));
        localObject1 = null;
        continue;
        localObject2 = new GPUImageLookupFilter();
        ((BaseFilter)localObject2).addParam(new TextureResParam("inputImageTexture2", "sh/shuilian_lf.png", 33986));
        localObject1 = null;
        continue;
        localObject2 = new GPUImageLookupFilter();
        ((BaseFilter)localObject2).addParam(new TextureResParam("inputImageTexture2", "sh/youjiali_lf.png", 33986));
        localObject1 = null;
        continue;
        localObject2 = new ChannelSplitFilter();
        localObject1 = null;
        continue;
        localObject1 = "MIC_PTU_ZIPAI_LIGHTWHITE";
        continue;
        localObject1 = "MIC_PTU_ZIPAI_LIGHTRED";
        continue;
        localObject1 = "MIC_PTU_ZIPAI_LIGHT";
        continue;
        localObject1 = "MIC_PTU_ZIPAI_TEAMILK";
        continue;
        localObject2 = new GPUImageLookupFilter();
        ((BaseFilter)localObject2).addParam(new TextureResParam("inputImageTexture2", "sh/fenbi_lf.png", 33986));
        localObject1 = null;
        continue;
        localObject2 = new GPUImageLookupFilter();
        ((BaseFilter)localObject2).addParam(new TextureResParam("inputImageTexture2", "sh/fennen_lf.png", 33986));
        localObject1 = null;
        continue;
        localObject2 = new GPUImageLookupFilter();
        ((BaseFilter)localObject2).addParam(new TextureResParam("inputImageTexture2", "sh/tianbohe_lf.png", 33986));
        localObject1 = null;
        continue;
        localObject1 = "MIC_PTU_ZIPAI_GRADIENT_LIPNEW";
        continue;
        localObject1 = "MIC_PTU_ZIPAI_FAIRYTALE";
        continue;
        localObject1 = "MIC_PTU_ZIPAI_RICHRED";
        continue;
        localObject1 = "MIC_PTU_ZIPAI_YOUNG";
        continue;
        localObject2 = new GPUImageLookupFilter();
        ((BaseFilter)localObject2).addParam(new TextureResParam("inputImageTexture2", "sh/zhahuang_lf.png", 33986));
        localObject1 = null;
        continue;
        localObject2 = new GPUImageLookupFilter();
        ((BaseFilter)localObject2).addParam(new TextureResParam("inputImageTexture2", "sh/dongjing_lf.png", 33986));
        localObject1 = null;
        continue;
        localObject2 = new GPUImageLookupFilter();
        ((BaseFilter)localObject2).addParam(new TextureResParam("inputImageTexture2", "sh/chongsheng_lf.png", 33986));
        localObject1 = null;
        continue;
        localObject1 = "MIC_PTU_ZIPAI_MAPLERED";
        continue;
        localObject1 = "MIC_PTU_ZIPAI_RICHBLUE";
        continue;
        localObject1 = "MIC_PTU_ZIPAI_RICHYELLOW";
        continue;
        localObject2 = new GPUImageLookupFilter();
        ((BaseFilter)localObject2).addParam(new TextureResParam("inputImageTexture2", "sh/blackwhite_lf.png", 33986));
        localObject1 = null;
        continue;
        localObject2 = new GPUImageLookupFilter();
        ((BaseFilter)localObject2).addParam(new TextureResParam("inputImageTexture2", "sh/nuanyang_lf.png", 33986));
        localObject1 = null;
        continue;
        localObject1 = "MIC_PTU_FBBS_LANGMAN";
      }
      localObject2 = lutFilterWithID((String)localObject1);
      localObject3 = localObject2;
    } while (localObject2 != null);
    filter2Image(paramInt, (String)localObject1);
    return PtuFilterFactory.createFilter(paramInt);
  }
  
  public static void filter2Image(int paramInt, String paramString)
  {
    if (AEModule.getLutDirPath() == null) {
      return;
    }
    FilterEngineFactory.getInstance().queue(new TTPicFilterFactoryLocal.1(paramInt, paramString));
  }
  
  public static Bitmap getBitmapFromEncryptedFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        if (paramString.startsWith("assets://"))
        {
          paramString = AEModule.getContext().getAssets().open(FileUtils.getRealPath(paramString));
          label32:
          arrayOfByte = FileEncryptUtils.decryptFile(paramString);
        }
      }
      catch (Exception paramString)
      {
        try
        {
          byte[] arrayOfByte;
          IOUtils.closeQuietly(paramString);
          label41:
          while (arrayOfByte != null)
          {
            paramString = new BitmapFactory.Options();
            paramString.inPreferredConfig = Bitmap.Config.ARGB_8888;
            try
            {
              paramString = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, paramString);
              return paramString;
            }
            catch (OutOfMemoryError paramString)
            {
              LogUtils.e("BitmapUtils", "decodeByteArray", paramString, new Object[0]);
              return null;
            }
            paramString = new FileInputStream(paramString);
            break label32;
            paramString = paramString;
            arrayOfByte = null;
          }
        }
        catch (Exception paramString)
        {
          break label41;
        }
      }
    }
  }
  
  public static BaseFilter lutFilterWithBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    GPUImageLookupFilter localGPUImageLookupFilter = new GPUImageLookupFilter();
    localGPUImageLookupFilter.addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", paramBitmap, 33986, true));
    return localGPUImageLookupFilter;
  }
  
  public static BaseFilter lutFilterWithID(String paramString)
  {
    if (AEModule.getLutDirPath() == null) {}
    do
    {
      return null;
      paramString = getBitmapFromEncryptedFile(AEModule.getLutDirPath() + File.separator + paramString + ".png2");
    } while (paramString == null);
    GPUImageLookupFilter localGPUImageLookupFilter = new GPUImageLookupFilter();
    localGPUImageLookupFilter.addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", paramString, 33986, true));
    return localGPUImageLookupFilter;
  }
  
  public static Bitmap preloadBaseLUTImage()
  {
    for (;;)
    {
      Object localObject;
      int n;
      int j;
      try
      {
        byte[] arrayOfByte = new byte[1048576];
        localObject = new byte[64];
        i = 0;
        if (i < 64)
        {
          localObject[i] = ((byte)Math.round(i * 4.047619F));
          i += 1;
          continue;
          if (i < 64)
          {
            n = i / 8;
            j = 0;
            break label98;
          }
          localObject = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
          ((Bitmap)localObject).copyPixelsFromBuffer(ByteBuffer.wrap(arrayOfByte));
          return localObject;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        return null;
      }
      int i = 0;
      continue;
      label98:
      while (j < 64)
      {
        int m = (n * 64 + j) * 512 * 4 + i % 8 * 64 * 4;
        int k = 0;
        while (k < 64)
        {
          int i1 = m + 1;
          localOutOfMemoryError[m] = localObject[k];
          m = i1 + 1;
          localOutOfMemoryError[i1] = localObject[j];
          i1 = m + 1;
          localOutOfMemoryError[m] = localObject[i];
          m = i1 + 1;
          localOutOfMemoryError[i1] = -1;
          k += 1;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  public static void saveLutOrg()
  {
    if (AEModule.getLutDirPath() == null) {}
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = preloadBaseLUTImage();
    } while (localBitmap == null);
    BitmapUtils.saveBitmap2PNG(localBitmap, AEModule.getLutDirPath() + File.separator + "LUT_ORG.png");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.factory.TTPicFilterFactoryLocal
 * JD-Core Version:    0.7.0.1
 */