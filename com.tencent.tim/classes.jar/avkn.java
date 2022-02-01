import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qqfav.widget.QfavJumpActivity;

public class avkn
  implements DialogInterface.OnClickListener
{
  public avkn(QfavJumpActivity paramQfavJumpActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QfavJumpActivity.a(this.this$0, false);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     avkn
 * JD-Core Version:    0.7.0.1
 */