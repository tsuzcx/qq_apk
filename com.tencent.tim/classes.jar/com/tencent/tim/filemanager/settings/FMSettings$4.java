package com.tencent.tim.filemanager.settings;

import audm.a;
import audn;
import audo;
import java.io.File;

public class FMSettings$4
  implements Runnable
{
  public FMSettings$4(audn paramaudn, String paramString, File paramFile, int paramInt, audm.a parama) {}
  
  public void run()
  {
    File localFile = new File(this.bJC);
    audn.a(this.this$0, localFile, this.aw, new audo(this));
    localFile.delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.settings.FMSettings.4
 * JD-Core Version:    0.7.0.1
 */