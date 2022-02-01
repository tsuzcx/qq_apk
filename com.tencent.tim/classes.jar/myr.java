import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class myr
  implements DialogInterface.OnDismissListener
{
  myr(myq parammyq) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    }
    if (myq.a(this.a) != null) {
      myq.a(this.a).c(myq.a(this.a), myq.b(this.a), false, false);
    }
    myq.a(this.a, true);
    myq.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     myr
 * JD-Core Version:    0.7.0.1
 */