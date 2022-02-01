package dov.com.qq.im.aeeditor.module.filter;

import axiy;
import axmr;
import axmr.a;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import java.util.Map;

public class AEEditorFiltersManager$5
  implements Runnable
{
  public AEEditorFiltersManager$5(axmr paramaxmr, String paramString, axmr.a parama) {}
  
  public void run()
  {
    axiy.i("AEEditorFiltersManager", "downLoadResource--by user--BEGIN id: " + this.cVx);
    axmr.a(this.this$0);
    AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)axmr.a(this.this$0).get(this.cVx);
    if (localAEEditorDownloadResBean != null) {
      axmr.a(this.this$0, localAEEditorDownloadResBean, this.a);
    }
    do
    {
      return;
      axiy.e("AEEditorFiltersManager", "downLoadResource--by user--FAIL, no download config for id: " + this.cVx);
    } while (this.a == null);
    this.a.Ys(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AEEditorFiltersManager.5
 * JD-Core Version:    0.7.0.1
 */