import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.page.Gallery;

class amds
  implements ahal.a
{
  amds(amdr paramamdr, AIOFilePictureData paramAIOFilePictureData) {}
  
  public void aD()
  {
    try
    {
      this.this$0.updateUI();
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(this.a.msgId, this.a.subId, 20);
      if (this.this$0.b.getGallery() != null)
      {
        this.this$0.b.getGallery().enableDoubleTap(true);
        this.this$0.b.getGallery().enableScaleGesture(true);
      }
      return;
    }
    catch (Exception localException)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "showFlowDialog exception = " + localException.getMessage());
    }
  }
  
  public void aE()
  {
    this.this$0.updateUI();
    this.this$0.OS(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amds
 * JD-Core Version:    0.7.0.1
 */