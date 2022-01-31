import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qqfav.QfavBuilder;

public class fnb
  implements DialogInterface.OnDismissListener
{
  public fnb(QfavBuilder paramQfavBuilder) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QfavBuilder.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fnb
 * JD-Core Version:    0.7.0.1
 */