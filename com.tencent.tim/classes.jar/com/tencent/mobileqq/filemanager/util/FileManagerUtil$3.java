package com.tencent.mobileqq.filemanager.util;

import ahaf;
import aqhq;
import java.io.File;

public final class FileManagerUtil$3
  implements Runnable
{
  public void run()
  {
    Object localObject2 = ahaf.a().vZ();
    Object localObject1 = ahaf.a().wa();
    File localFile = new File((String)localObject2);
    if (!aqhq.fileExists((String)localObject2)) {
      localFile.mkdirs();
    }
    localObject2 = new File((String)localObject1);
    if (!aqhq.fileExists((String)localObject1)) {
      ((File)localObject2).mkdirs();
    }
    localObject1 = new File(ahaf.a().vZ() + ".nomedia");
    if (((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.3
 * JD-Core Version:    0.7.0.1
 */