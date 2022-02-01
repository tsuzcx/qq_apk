package com.tencent.ttpic.offlineset.beans;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StyleFilterSettingJsonBean
{
  public String id;
  public float isDenoise = 0.0F;
  public Map<String, String> lutPaths;
  public Map<String, String> materialPaths;
  public float styleParams = 0.18F;
  public int type;
  
  public StyleFilterSettingJsonBean() {}
  
  public StyleFilterSettingJsonBean(int paramInt)
  {
    this.type = paramInt;
  }
  
  private void updateMap(String paramString, Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {}
    for (;;)
    {
      return;
      paramMap = paramMap.entrySet().iterator();
      if ((paramMap != null) && (paramMap.hasNext())) {
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          localEntry.setValue(paramString + File.separator + (String)localEntry.getValue());
        }
      }
    }
  }
  
  public boolean isCurrentStyle(String paramString)
  {
    return (this.id != null) && (paramString != null) && (this.id.equals(paramString));
  }
  
  public void updatePath(String paramString)
  {
    updateMap(paramString, this.lutPaths);
    updateMap(paramString, this.materialPaths);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.offlineset.beans.StyleFilterSettingJsonBean
 * JD-Core Version:    0.7.0.1
 */