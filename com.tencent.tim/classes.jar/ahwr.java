import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

class ahwr
  implements DialogInterface.OnClickListener
{
  ahwr(ahwp paramahwp, Uri paramUri, String paramString, InputStream paramInputStream, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      ahwp.a(this.this$0, this.d, this.val$path, this.b, this.val$fileSize);
      this.this$0.waiting = false;
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("UriParserPathHelper", 1, "system share.copy file error", paramDialogInterface);
      if (ahwp.msg != null) {}
    }
    for (paramDialogInterface = this.this$0.mAppContext.getString(2131720159);; paramDialogInterface = ahwp.msg)
    {
      ahwp.a(this.this$0, paramDialogInterface);
      if (ahwp.a(this.this$0) == null) {
        break;
      }
      ahwp.a(this.this$0).f(this.d);
      ahwp.a(this.this$0, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahwr
 * JD-Core Version:    0.7.0.1
 */