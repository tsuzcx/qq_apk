package com.tencent.ttpic.openapi.initializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParticleSystemInitializer
  extends Feature
{
  private static final String TAG = ParticleSystemInitializer.class.getSimpleName();
  private static final SharedLibraryInfo sharedLibrary = new SharedLibraryInfo("ParticleSystem");
  
  protected boolean destroyImpl()
  {
    return false;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    return new ArrayList();
  }
  
  public String getName()
  {
    return "ParticleSystem";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(new SharedLibraryInfo[] { sharedLibrary });
  }
  
  protected boolean initImpl()
  {
    return loadAllSoFiles();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.ParticleSystemInitializer
 * JD-Core Version:    0.7.0.1
 */