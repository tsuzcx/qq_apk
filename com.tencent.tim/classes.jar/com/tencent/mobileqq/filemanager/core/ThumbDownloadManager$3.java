package com.tencent.mobileqq.filemanager.core;

import aglw;
import aglw.a;
import java.util.LinkedHashMap;
import java.util.List;

public class ThumbDownloadManager$3
  implements Runnable
{
  public ThumbDownloadManager$3(aglw paramaglw) {}
  
  public void run()
  {
    if (aglw.a(this.this$0).size() >= 8) {}
    while (aglw.a(this.this$0).size() == 0) {
      return;
    }
    aglw.a locala = (aglw.a)aglw.a(this.this$0).get(0);
    if (locala == null)
    {
      aglw.a(this.this$0).remove(0);
      aglw.a(this.this$0);
      return;
    }
    aglw.a(this.this$0).remove(locala);
    aglw.a(this.this$0, locala);
    aglw.b(this.this$0, locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */