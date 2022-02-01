import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class xcn
  implements DialogInterface.OnClickListener
{
  xcn(xcl paramxcl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!aqiw.isNetworkAvailable(this.a.this$0.mContext)) {
      arxa.a().showToast(2131692561);
    }
    do
    {
      return;
      paramDialogInterface = (syw)this.a.this$0.app.getBusinessHandler(51);
      paramDialogInterface.c(Long.parseLong(this.a.this$0.sessionInfo.aTl), 0, 1, 0);
      paramDialogInterface = paramDialogInterface.a(Long.parseLong(this.a.this$0.sessionInfo.aTl));
    } while (paramDialogInterface == null);
    tar.a(this.a.this$0.app, Long.parseLong(this.a.this$0.sessionInfo.aTl), "Usr_AIO_Menu", 5, 0, paramDialogInterface.productId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xcn
 * JD-Core Version:    0.7.0.1
 */