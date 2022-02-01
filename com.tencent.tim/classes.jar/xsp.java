import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.qphone.base.util.QLog;

class xsp
  implements DialogInterface.OnClickListener
{
  xsp(xsk paramxsk, int paramInt, Object paramObject, xuf paramxuf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (this.val$type)
    {
    case 2: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "showSaveFileTips type = " + this.val$type);
      }
      break;
    }
    do
    {
      do
      {
        return;
      } while (!(this.val$data instanceof AIOImageData));
      xsk.a(this.this$0, (AIOImageData)this.val$data, this.c);
      this.this$0.updateUI();
      return;
    } while (!(this.val$data instanceof AIOShortVideoData));
    xsk.a(this.this$0, (AIOShortVideoData)this.val$data, this.c);
    this.c.a.biW = true;
    this.this$0.updateUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xsp
 * JD-Core Version:    0.7.0.1
 */