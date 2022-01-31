import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class wbs
  implements DialogInterface.OnDismissListener
{
  wbs(wbq paramwbq) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (wbq.a(this.a) != null) {
      wbq.a(this.a).c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wbs
 * JD-Core Version:    0.7.0.1
 */