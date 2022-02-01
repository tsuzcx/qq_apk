package com.google.android.filament.gltfio;

public class MaterialInfo
{
  public static String getGlbInfo(String paramString)
  {
    return nGetGlbInfo(paramString);
  }
  
  private static native String nGetGlbInfo(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.filament.gltfio.MaterialInfo
 * JD-Core Version:    0.7.0.1
 */