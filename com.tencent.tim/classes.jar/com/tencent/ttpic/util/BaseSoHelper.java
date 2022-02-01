package com.tencent.ttpic.util;

import java.io.File;

public class BaseSoHelper
{
  public static boolean checkSoRecursively(String paramString)
  {
    boolean bool2 = false;
    paramString = new File(paramString).listFiles();
    boolean bool1 = bool2;
    int i;
    if (paramString != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      Object localObject;
      if (i < paramString.length)
      {
        localObject = paramString[i];
        if (localObject.isDirectory())
        {
          if (!checkSoRecursively(localObject.getAbsolutePath())) {
            break label73;
          }
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      if (localObject.getName().endsWith(".so")) {
        return true;
      }
      label73:
      i += 1;
    }
  }
  
  public static void loadSoRecursively(String paramString)
  {
    paramString = new File(paramString).listFiles();
    if (paramString != null)
    {
      int i = 0;
      if (i < paramString.length)
      {
        Object localObject = paramString[i];
        if (localObject.isDirectory()) {
          loadSoRecursively(localObject.getAbsolutePath());
        }
        for (;;)
        {
          i += 1;
          break;
          if (localObject.getName().endsWith(".so")) {
            System.load(localObject.getAbsolutePath());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.util.BaseSoHelper
 * JD-Core Version:    0.7.0.1
 */