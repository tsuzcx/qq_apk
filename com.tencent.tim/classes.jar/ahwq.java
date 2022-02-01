import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

class ahwq
  implements DialogInterface.OnClickListener
{
  ahwq(ahwp paramahwp, InputStream paramInputStream) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this.b.close();
      ahwp.a(this.this$0).finish();
      return;
    }
    catch (IOException paramDialogInterface)
    {
      for (;;)
      {
        QLog.e("UriParserPathHelper", 1, "system share.exception.e=", paramDialogInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahwq
 * JD-Core Version:    0.7.0.1
 */