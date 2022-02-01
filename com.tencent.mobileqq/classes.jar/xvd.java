import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class xvd
  implements DialogInterface.OnDismissListener
{
  xvd(xvb paramxvb) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (xvb.a(this.a) != null) {
      xvb.a(this.a).c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvd
 * JD-Core Version:    0.7.0.1
 */