package me.ele.uetool.util;

import java.util.Map;
import me.ele.uetool.base.Application;

public class JarResource
{
  private static Map nameIdMap = null;
  
  public static int getIdByName(String paramString1, String paramString2)
  {
    int j = 0;
    int i = 0;
    Application.getApplicationContext();
    if (nameIdMap != null) {
      if (nameIdMap.get(paramString2) != null) {
        break label34;
      }
    }
    for (;;)
    {
      j = i;
      if (i != 0) {}
      return j;
      label34:
      i = ((Integer)nameIdMap.get(paramString2)).intValue();
    }
  }
  
  public static void setNameIdMap(Map paramMap)
  {
    nameIdMap = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.util.JarResource
 * JD-Core Version:    0.7.0.1
 */