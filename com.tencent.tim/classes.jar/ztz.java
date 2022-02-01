import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.qphone.base.util.QLog;

class ztz
  implements DialogInterface.OnClickListener
{
  ztz(ztv paramztv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoListActivity", 2, "cancel shortvideo_mobile_send_confirm dialog");
    }
    if (((NewPhotoListActivity)this.this$0.mActivity).sendBtn != null) {
      ((NewPhotoListActivity)this.this$0.mActivity).sendBtn.setClickable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ztz
 * JD-Core Version:    0.7.0.1
 */