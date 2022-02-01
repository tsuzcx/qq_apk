package com.google.android.filament.gltfio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.filament.Engine;
import com.google.android.filament.IndirectLight;
import com.google.android.filament.Skybox;
import com.google.android.filament.Texture;
import java.lang.reflect.Constructor;
import java.nio.Buffer;

public class KtxLoader
{
  private static Constructor<IndirectLight> sIndirectLightConstructor;
  private static Constructor<Skybox> sSkyboxConstructor;
  private static Constructor<Texture> sTextureConstructor;
  
  static
  {
    try
    {
      sTextureConstructor = Texture.class.getDeclaredConstructor(new Class[] { Long.TYPE });
      sTextureConstructor.setAccessible(true);
      sIndirectLightConstructor = IndirectLight.class.getDeclaredConstructor(new Class[] { Long.TYPE });
      sIndirectLightConstructor.setAccessible(true);
      sSkyboxConstructor = Skybox.class.getDeclaredConstructor(new Class[] { Long.TYPE });
      sSkyboxConstructor.setAccessible(true);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  @Nullable
  public static IndirectLight createIndirectLight(@NonNull Engine paramEngine, @NonNull Buffer paramBuffer, @NonNull Options paramOptions)
  {
    try
    {
      long l = nCreateIndirectLight(paramEngine.getNativeObject(), paramBuffer, paramBuffer.remaining(), paramOptions.srgb);
      paramEngine = (IndirectLight)sIndirectLightConstructor.newInstance(new Object[] { Long.valueOf(l) });
      return paramEngine;
    }
    catch (Exception paramEngine) {}
    return null;
  }
  
  @Nullable
  public static Skybox createSkybox(@NonNull Engine paramEngine, @NonNull Buffer paramBuffer, @NonNull Options paramOptions)
  {
    try
    {
      long l = nCreateSkybox(paramEngine.getNativeObject(), paramBuffer, paramBuffer.remaining(), paramOptions.srgb);
      paramEngine = (Skybox)sSkyboxConstructor.newInstance(new Object[] { Long.valueOf(l) });
      return paramEngine;
    }
    catch (Exception paramEngine) {}
    return null;
  }
  
  @Nullable
  public static Texture createTexture(@NonNull Engine paramEngine, @NonNull Buffer paramBuffer, @NonNull Options paramOptions)
  {
    try
    {
      long l = nCreateTexture(paramEngine.getNativeObject(), paramBuffer, paramBuffer.remaining(), paramOptions.srgb);
      paramEngine = (Texture)sTextureConstructor.newInstance(new Object[] { Long.valueOf(l) });
      return paramEngine;
    }
    catch (Exception paramEngine) {}
    return null;
  }
  
  private static native long nCreateIndirectLight(long paramLong, Buffer paramBuffer, int paramInt, boolean paramBoolean);
  
  private static native long nCreateSkybox(long paramLong, Buffer paramBuffer, int paramInt, boolean paramBoolean);
  
  private static native long nCreateTexture(long paramLong, Buffer paramBuffer, int paramInt, boolean paramBoolean);
  
  public static class Options
  {
    public boolean srgb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.filament.gltfio.KtxLoader
 * JD-Core Version:    0.7.0.1
 */