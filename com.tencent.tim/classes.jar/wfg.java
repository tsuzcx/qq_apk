import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.activity.VerifyCodeActivity;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.ServerNotifyObserver;

public class wfg
  extends ServerNotifyObserver
{
  public wfg(VerifyCodeActivity paramVerifyCodeActivity) {}
  
  public void onReceiveVerifyCode(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
  {
    QLog.d("VerifyCodeActivity", 1, "onReceiveVerifyCode");
    this.a.isRefresh = false;
    if (this.a.isSend)
    {
      this.a.a.setText("");
      QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131721676), 0).show();
    }
    this.a.serverNotifyObserver.setKey(paramString1);
    this.a.serverNotifyObserver.setSeq(paramInt);
    this.a.dU.setEnabled(true);
    if ((this.a.a.getText().toString() != null) && (this.a.a.getText().toString().length() > 4)) {
      VerifyCodeActivity.a(this.a, true);
    }
    if (paramArrayOfByte != null)
    {
      this.a.bE.setImageBitmap(aqcu.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length));
      this.a.by(false);
      return;
    }
    Toast.makeText(this.a.getApplicationContext(), this.a.getString(2131721667), 1).show();
  }
  
  public void onVerifyClose()
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     wfg
 * JD-Core Version:    0.7.0.1
 */