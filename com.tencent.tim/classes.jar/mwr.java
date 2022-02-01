import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class mwr
  implements DialogInterface.OnDismissListener
{
  mwr(mwq parammwq) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.b;
    StringBuilder localStringBuilder = new StringBuilder().append("DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    if (!mwq.a(this.b)) {}
    for (boolean bool = true;; bool = false)
    {
      mwq.a(paramDialogInterface, bool);
      if ((mwq.a(this.b) != null) && (mwq.a(this.b).isPause()) && (mwq.b(this.b)) && (mwq.a(this.b))) {
        mwq.a(this.b).restart();
      }
      if (mwq.a(this.b) != null) {
        mwq.a(this.b).aRD();
      }
      mwq.a(this.b, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mwr
 * JD-Core Version:    0.7.0.1
 */