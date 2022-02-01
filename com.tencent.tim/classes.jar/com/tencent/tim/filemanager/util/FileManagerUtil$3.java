package com.tencent.tim.filemanager.util;

import aqhq;
import audn;
import java.io.File;

public final class FileManagerUtil$3
  implements Runnable
{
  public void run()
  {
    Object localObject2 = audn.a().vZ();
    Object localObject1 = audn.a().wa();
    File localFile = new File((String)localObject2);
    if (!aqhq.fileExists((String)localObject2)) {
      localFile.mkdirs();
    }
    localObject2 = new File((String)localObject1);
    if (!aqhq.fileExists((String)localObject1)) {
      ((File)localObject2).mkdirs();
    }
    localObject1 = new File(audn.a().vZ() + ".nomedia");
    if (((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.util.FileManagerUtil.3
 * JD-Core Version:    0.7.0.1
 */