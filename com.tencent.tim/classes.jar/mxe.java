import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class mxe
  implements DialogInterface.OnShowListener
{
  mxe(mwq.b paramb) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    mwq.a(this.a.b, "mDisLikeActionSheet onShow() on VideoFeedsPlayActivity");
    mwq.a(this.a.b).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mxe
 * JD-Core Version:    0.7.0.1
 */