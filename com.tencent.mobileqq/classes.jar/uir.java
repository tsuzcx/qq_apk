import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class uir
  implements DialogInterface.OnDismissListener
{
  uir(uip paramuip) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (uip.a(this.a) != null) {
      uip.a(this.a).c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uir
 * JD-Core Version:    0.7.0.1
 */