import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class ameu
  implements DialogInterface.OnClickListener
{
  ameu(amem paramamem, int paramInt, Object paramObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (this.val$type)
    {
    default: 
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "showSaveFileTips type = " + this.val$type);
    }
    do
    {
      return;
    } while (!(this.val$data instanceof AIOVideoData));
    paramDialogInterface = (AIOVideoData)this.val$data;
    this.this$0.b.a(paramDialogInterface);
    this.this$0.b.P(paramDialogInterface.msgId, paramDialogInterface.subId, 2);
    this.this$0.updateUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ameu
 * JD-Core Version:    0.7.0.1
 */