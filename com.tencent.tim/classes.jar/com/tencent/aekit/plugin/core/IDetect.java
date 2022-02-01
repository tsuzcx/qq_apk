package com.tencent.aekit.plugin.core;

public abstract class IDetect
  implements IModule
{
  public static final String TAG = "IDetect";
  
  public abstract void clear();
  
  public abstract Object detect(AIInput paramAIInput, AIParam paramAIParam);
  
  public abstract boolean init();
  
  public boolean isSupportCurrentDevice()
  {
    return true;
  }
  
  public abstract boolean reInit();
  
  public boolean reloadModel()
  {
    return true;
  }
  
  public void resetState() {}
  
  public abstract void updateAIAttr(AIAttr paramAIAttr);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.IDetect
 * JD-Core Version:    0.7.0.1
 */