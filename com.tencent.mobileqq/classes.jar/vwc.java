import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class vwc
  implements DialogInterface.OnDismissListener
{
  vwc(vwb paramvwb) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.a != null) {
      this.a.a.c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vwc
 * JD-Core Version:    0.7.0.1
 */