package com.tencent.ttpic.openapi.initializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VoiceChangerInitializer
  extends Feature
{
  private static final String TAG = VoiceChangerInitializer.class.getSimpleName();
  private static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("voicechanger_shared"), new SharedLibraryInfo("pitu_voice") };
  
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
    return "VoiceChanger";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sharedLibraries);
  }
  
  protected boolean initImpl()
  {
    return loadAllSoFiles();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.VoiceChangerInitializer
 * JD-Core Version:    0.7.0.1
 */