package dov.com.qq.im.aeeditor.module.filter;

import aqhq;
import axmr;
import java.io.File;
import java.io.IOException;

public class AEEditorFiltersManager$1
  implements Runnable
{
  public AEEditorFiltersManager$1(axmr paramaxmr) {}
  
  public void run()
  {
    axmr.a(this.this$0);
    axmr.b(this.this$0);
    String str = axmr.access$200() + File.separator + ".nomedia";
    if (!new File(str).exists()) {}
    try
    {
      aqhq.createFile(str);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AEEditorFiltersManager.1
 * JD-Core Version:    0.7.0.1
 */