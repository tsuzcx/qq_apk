import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

class zve
  implements DialogInterface.OnClickListener
{
  zve(zvb paramzvb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (((NewPhotoListActivity)this.this$0.mActivity).sendBtn != null) {
      ((NewPhotoListActivity)this.this$0.mActivity).sendBtn.setClickable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zve
 * JD-Core Version:    0.7.0.1
 */