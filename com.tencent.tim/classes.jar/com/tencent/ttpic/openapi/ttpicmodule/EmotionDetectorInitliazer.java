package com.tencent.ttpic.openapi.ttpicmodule;

import com.tencent.ttpic.openapi.initializer.Feature;
import com.tencent.ttpic.openapi.initializer.ModelInfo;
import com.tencent.ttpic.openapi.initializer.SharedLibraryInfo;
import com.tencent.ttpic.util.youtu.EmotionDetector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmotionDetectorInitliazer
  extends Feature
{
  private static final SharedLibraryInfo[] sos = { new SharedLibraryInfo("expression_ttpic") };
  private EmotionDetector emotionDetector = new EmotionDetector();
  
  public boolean destroyImpl()
  {
    this.emotionDetector.destroy();
    return true;
  }
  
  public EmotionDetector getEmotionDetector()
  {
    return this.emotionDetector;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    return new ArrayList();
  }
  
  public String getName()
  {
    return "EmotionDetector";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sos);
  }
  
  public boolean initImpl()
  {
    if (!loadAllSoFiles()) {}
    boolean bool;
    do
    {
      return false;
      EmotionDetector.nativeInit();
      bool = this.emotionDetector.init();
    } while (!bool);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.EmotionDetectorInitliazer
 * JD-Core Version:    0.7.0.1
 */