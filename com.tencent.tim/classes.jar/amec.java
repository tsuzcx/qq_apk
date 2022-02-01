import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class amec
  implements DialogInterface.OnClickListener
{
  amec(amea paramamea, int paramInt, Object paramObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (this.val$type)
    {
    default: 
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "showSaveFileTips type = " + this.val$type);
    }
    do
    {
      return;
    } while (!(this.val$data instanceof AIOPictureData));
    amea.a(this.this$0).a((AIOPictureData)this.val$data);
    this.this$0.updateUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amec
 * JD-Core Version:    0.7.0.1
 */