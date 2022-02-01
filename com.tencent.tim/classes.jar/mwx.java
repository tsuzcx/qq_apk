import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class mwx
  implements DialogInterface.OnDismissListener
{
  mwx(mwq parammwq) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    mwq.a(this.b, "DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    if ((mwq.a(this.b) != null) && (mwq.a(this.b).isPause()) && (mwq.b(this.b)) && (!mwq.c(this.b)) && (mwq.a(this.b)) && (!mwq.d(this.b))) {
      mwq.a(this.b).restart();
    }
    if (mwq.a(this.b) != null) {
      mwq.a(this.b).aRD();
    }
    mwq.a(this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mwx
 * JD-Core Version:    0.7.0.1
 */