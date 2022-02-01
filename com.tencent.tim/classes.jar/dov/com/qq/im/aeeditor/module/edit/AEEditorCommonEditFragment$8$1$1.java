package dov.com.qq.im.aeeditor.module.edit;

import aomh;
import aqhq;
import axim;
import axiy;
import axjj.a.a;
import axlr;
import java.io.File;
import java.io.IOException;

public class AEEditorCommonEditFragment$8$1$1
  implements Runnable
{
  public AEEditorCommonEditFragment$8$1$1(axlr paramaxlr, aomh paramaomh) {}
  
  public void run()
  {
    boolean bool = false;
    if (this.b != null)
    {
      localObject = axim.a();
      if (this.b.mResult == 0) {
        bool = true;
      }
      ((axim)localObject).a(bool, 2, "AEEditorFilterAIAnimation", "", this.b.mErrCode, this.b.reqCost);
    }
    Object localObject = axjj.a.a.cVb;
    File localFile = new File((String)localObject);
    if (localFile.exists()) {
      try
      {
        if (!"b9f8fc550f1535b445b564bfbe0d82c5".equalsIgnoreCase(aqhq.px((String)localObject)))
        {
          localFile.delete();
          axiy.e(AEEditorCommonEditFragment.access$000(), "ae editor lottie download md5 check failed.");
          return;
        }
        aqhq.W((String)localObject, axjj.a.a.cVa, false);
        aqhq.createFile(axjj.a.a.cVa + File.separator + ".nomedia");
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment.8.1.1
 * JD-Core Version:    0.7.0.1
 */