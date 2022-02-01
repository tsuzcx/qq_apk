import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class mww
  implements DialogInterface.OnCancelListener
{
  mww(mwq parammwq) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    mwq.a(this.b, "mShareActionSheet cancle button OnClick");
    if (mwq.a(this.b) != null) {
      mwq.a(this.b).restart();
    }
    paramDialogInterface = mwq.a(this.b);
    mwq.a(this.b, paramDialogInterface, String.valueOf(kxm.getLongAccountUin()), paramDialogInterface.Wz, paramDialogInterface.vid, paramDialogInterface.algorithmID, -1, -1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mww
 * JD-Core Version:    0.7.0.1
 */