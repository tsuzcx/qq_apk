import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;

class zwg
  implements DialogInterface.OnClickListener
{
  zwg(zwc paramzwc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoPreviewActivity", 2, "cancel shortvideo_mobile_send_confirm dialog");
    }
    if (((NewPhotoPreviewActivity)this.this$0.mActivity).sendBtn != null) {
      ((NewPhotoPreviewActivity)this.this$0.mActivity).sendBtn.setClickable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zwg
 * JD-Core Version:    0.7.0.1
 */