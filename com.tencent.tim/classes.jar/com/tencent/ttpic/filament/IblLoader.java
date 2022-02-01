package com.tencent.ttpic.filament;

import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Pair;
import com.google.android.filament.Engine;
import com.google.android.filament.IndirectLight;
import com.google.android.filament.Skybox;
import com.google.android.filament.Texture;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.IOException;
import java.io.InputStream;

public class IblLoader
{
  public static void destroyIbl(Engine paramEngine, Ibl paramIbl)
  {
    paramEngine.destroySkybox(paramIbl.skybox);
    paramEngine.destroyTexture(paramIbl.skyboxTexture);
    paramEngine.destroyIndirectLight(paramIbl.indirectLight);
    paramEngine.destroyTexture(paramIbl.indirectLightTexture);
  }
  
  private static Pair<Integer, Integer> peekSize(AssetManager paramAssetManager, String paramString)
  {
    localObject = null;
    AssetManager localAssetManager = null;
    try
    {
      paramAssetManager = paramAssetManager.open(paramString);
      localAssetManager = paramAssetManager;
      localObject = paramAssetManager;
      paramString = new BitmapFactory.Options();
      localAssetManager = paramAssetManager;
      localObject = paramAssetManager;
      paramString.inJustDecodeBounds = true;
      localAssetManager = paramAssetManager;
      localObject = paramAssetManager;
      BitmapFactory.decodeStream(paramAssetManager, null, paramString);
      localAssetManager = paramAssetManager;
      localObject = paramAssetManager;
      paramString = new Pair(Integer.valueOf(paramString.outWidth), Integer.valueOf(paramString.outHeight));
      if (paramAssetManager != null) {}
      try
      {
        paramAssetManager.close();
        return paramString;
      }
      catch (IOException paramAssetManager)
      {
        LogUtils.e(paramAssetManager);
        return paramString;
      }
      try
      {
        ((InputStream)localObject).close();
        throw paramAssetManager;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          LogUtils.e(paramString);
        }
      }
    }
    catch (IOException paramAssetManager)
    {
      localObject = localAssetManager;
      LogUtils.e(paramAssetManager);
      if (localAssetManager != null) {}
      try
      {
        localAssetManager.close();
        return new Pair(Integer.valueOf(0), Integer.valueOf(0));
      }
      catch (IOException paramAssetManager)
      {
        for (;;)
        {
          LogUtils.e(paramAssetManager);
        }
      }
    }
    finally
    {
      if (localObject == null) {}
    }
  }
  
  public static class Ibl
  {
    public IndirectLight indirectLight;
    public Texture indirectLightTexture;
    public Skybox skybox;
    public Texture skyboxTexture;
    
    public Ibl(IndirectLight paramIndirectLight, Texture paramTexture1, Skybox paramSkybox, Texture paramTexture2)
    {
      this.indirectLight = paramIndirectLight;
      this.indirectLightTexture = paramTexture1;
      this.skybox = paramSkybox;
      this.skyboxTexture = paramTexture2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filament.IblLoader
 * JD-Core Version:    0.7.0.1
 */