import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.voip.VoipGoogleWalletPayActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class ewm
  implements Runnable
{
  public ewm(VoipGoogleWalletPayActivity paramVoipGoogleWalletPayActivity) {}
  
  public void run()
  {
    this.a.a.hide();
    QRUtils.a(1, 2131562452);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ewm
 * JD-Core Version:    0.7.0.1
 */