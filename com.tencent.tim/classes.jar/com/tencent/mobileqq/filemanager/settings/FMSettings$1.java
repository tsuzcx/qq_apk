package com.tencent.mobileqq.filemanager.settings;

import ahaf;
import java.io.File;

public class FMSettings$1
  implements Runnable
{
  public FMSettings$1(ahaf paramahaf, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject = new File(this.val$tmpPath);
      if (!((File)localObject).exists()) {
        return;
      }
      if (((File)localObject).isDirectory())
      {
        localObject = ((File)localObject).listFiles();
        if ((localObject != null) && (localObject.length != 0))
        {
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            localObject[i].delete();
            i += 1;
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FMSettings.1
 * JD-Core Version:    0.7.0.1
 */