package com.tencent.mobileqq.troop.utils;

import acbn;
import apsl;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TroopFileTransferManager$1
  implements Runnable
{
  public void run()
  {
    File[] arrayOfFile;
    do
    {
      try
      {
        Thread.sleep(3000L);
        File localFile = new File(acbn.bmj);
        if (!localFile.isDirectory()) {
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        return;
      }
      arrayOfFile = localInterruptedException.listFiles(new apsl(this));
    } while ((arrayOfFile == null) || (arrayOfFile.length < 100));
    Object localObject = new ArrayList(arrayOfFile.length);
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      ((List)localObject).add(Long.valueOf(arrayOfFile[i].lastModified()));
      i += 1;
    }
    Collections.sort((List)localObject);
    long l = ((Long)((List)localObject).get(((List)localObject).size() - 100)).longValue();
    j = arrayOfFile.length;
    i = 0;
    while (i < j)
    {
      localObject = arrayOfFile[i];
      if (((File)localObject).lastModified() < l) {
        ((File)localObject).deleteOnExit();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.1
 * JD-Core Version:    0.7.0.1
 */