import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class mwt
  implements DialogInterface.OnShowListener
{
  mwt(mwq parammwq) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    mwq.a(this.b, "mDisLikeActionSheet onShow() on VideoFeedsPlayActivity");
    mwq.a(this.b).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mwt
 * JD-Core Version:    0.7.0.1
 */