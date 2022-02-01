package com.tencent.ttpic.util;

import com.tencent.ttpic.model.FaceLusterData;

public class SDKResourceLoader
{
  public static void enableAsync(boolean paramBoolean)
  {
    FaceLusterFilterResourceLoader.async = paramBoolean;
  }
  
  public static FaceLusterData getFaceLusterData()
  {
    return FaceLusterFilterResourceLoader.getFaceLusterData();
  }
  
  public static void loadFaceLusterData() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.util.SDKResourceLoader
 * JD-Core Version:    0.7.0.1
 */