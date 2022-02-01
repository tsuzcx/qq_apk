import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFiltersManager.4;
import java.util.concurrent.CountDownLatch;

public class axmu
  implements axmr.a
{
  public axmu(AEEditorFiltersManager.4 param4, int paramInt, AEEditorDownloadResBean paramAEEditorDownloadResBean, CountDownLatch paramCountDownLatch) {}
  
  public void Ys(boolean paramBoolean)
  {
    axiy.i("AEEditorFiltersManager", "preDownloadAllRes---[finish] " + this.eFY + ", id=" + this.jdField_a_of_type_DovComQqImAeeditorDataAEEditorDownloadResBean.getId());
    this.val$latch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axmu
 * JD-Core Version:    0.7.0.1
 */