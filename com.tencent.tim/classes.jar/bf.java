import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

public class bf
  implements DialogInterface.OnClickListener
{
  public bf(LiteActivity paramLiteActivity, String paramString, InputStream paramInputStream, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      LiteActivity.a(this.this$0, this.val$path, this.b, this.val$fileSize);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.w(LiteActivity.TAG, 2, "copy file error", paramDialogInterface);
      }
      LiteActivity.a(this.this$0, this.this$0.B());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     bf
 * JD-Core Version:    0.7.0.1
 */