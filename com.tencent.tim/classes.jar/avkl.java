import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qqfav.widget.QfavJumpActivity;
import java.io.IOException;
import java.io.InputStream;

public class avkl
  implements DialogInterface.OnClickListener
{
  public avkl(QfavJumpActivity paramQfavJumpActivity, InputStream paramInputStream) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this.b.close();
      this.this$0.finish();
      return;
    }
    catch (IOException paramDialogInterface)
    {
      for (;;)
      {
        paramDialogInterface.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     avkl
 * JD-Core Version:    0.7.0.1
 */