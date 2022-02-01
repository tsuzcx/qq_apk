package com.tencent.ttpic.openapi.ttpicmodule;

import java.util.HashMap;

public class AEMaterialExtender
{
  private static HashMap<String, Object> renderExtension = new HashMap();
  
  public static void extendRenderAttr(Class paramClass)
  {
    renderExtension.put(paramClass.getName(), paramClass);
  }
  
  public static HashMap<String, Object> getRenderExtension()
  {
    return renderExtension;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.AEMaterialExtender
 * JD-Core Version:    0.7.0.1
 */