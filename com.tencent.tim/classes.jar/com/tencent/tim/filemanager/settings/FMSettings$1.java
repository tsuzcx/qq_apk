package com.tencent.tim.filemanager.settings;

import audn;
import java.io.File;

public class FMSettings$1
  implements Runnable
{
  public FMSettings$1(audn paramaudn, String paramString) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.settings.FMSettings.1
 * JD-Core Version:    0.7.0.1
 */