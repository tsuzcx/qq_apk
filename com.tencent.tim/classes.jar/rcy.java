import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqstory.takevideo.EditVideoMusic;

public class rcy
  implements DialogInterface.OnDismissListener
{
  public rcy(EditVideoMusic paramEditVideoMusic) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.this$0.b.changeState(0);
    ras.so("0X80076DD");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rcy
 * JD-Core Version:    0.7.0.1
 */