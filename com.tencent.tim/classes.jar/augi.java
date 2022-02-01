import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tim.mail.MailPluginAttachDownloader.4;

public class augi
  implements DialogInterface.OnClickListener
{
  public augi(MailPluginAttachDownloader.4 param4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(auge.a(this.a.this$0), 1, 2131696270, 0).show(auge.a(this.a.this$0).getResources().getDimensionPixelSize(2131299627));
      return;
    }
    paramDialogInterface.dismiss();
    auge.a(this.a.this$0, null);
    auge.a(this.a.this$0, 0);
    auge.b(this.a.this$0, -1);
    auge.c(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     augi
 * JD-Core Version:    0.7.0.1
 */