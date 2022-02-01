import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.widget.QfavJumpActivity;
import java.io.InputStream;

public class avkm
  implements DialogInterface.OnClickListener
{
  public avkm(QfavJumpActivity paramQfavJumpActivity, String paramString, InputStream paramInputStream, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      QfavJumpActivity.a(this.this$0, this.val$path, this.b, this.val$fileSize);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.w("qqfav|QfavJumpActivity", 2, "copy file error", paramDialogInterface);
      }
      QfavJumpActivity.a(this.this$0, this.this$0.B());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     avkm
 * JD-Core Version:    0.7.0.1
 */