import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.widget.QFavDownloadProgressDialog;
import java.io.PrintStream;

public class fba
  extends Handler
{
  private fba(QFavDownloadProgressDialog paramQFavDownloadProgressDialog) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = String.format(QFavDownloadProgressDialog.a(this.a).getResources().getString(2131364524), new Object[] { Integer.valueOf(QFavDownloadProgressDialog.a(this.a)), Integer.valueOf(QFavDownloadProgressDialog.b(this.a)) });
    QFavDownloadProgressDialog.a(this.a).setText(paramMessage);
    System.out.println("s progress = " + paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fba
 * JD-Core Version:    0.7.0.1
 */