package com.tencent.mobileqq.filemanager.settings;

import ahae.a;
import ahaf;
import ahag;
import java.io.File;

public class FMSettings$4
  implements Runnable
{
  public FMSettings$4(ahaf paramahaf, String paramString, File paramFile, int paramInt, ahae.a parama) {}
  
  public void run()
  {
    File localFile = new File(this.bJC);
    ahaf.a(this.this$0, localFile, this.aw, new ahag(this));
    localFile.delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FMSettings.4
 * JD-Core Version:    0.7.0.1
 */