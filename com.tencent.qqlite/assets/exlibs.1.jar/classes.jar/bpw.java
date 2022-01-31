import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class bpw
  extends Handler
{
  public bpw(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      if (TroopRequestActivity.a(this.a) != null) {
        TroopRequestActivity.a(this.a).dismiss();
      }
      QQToast.a(this.a, this.a.getString(2131363387), 0).b(this.a.getTitleBarHeight());
      this.a.finish();
      return;
    case 1: 
      this.a.a(true);
      if (TroopRequestActivity.a(this.a) != null) {
        TroopRequestActivity.a(this.a).dismiss();
      }
      QQToast.a(this.a, this.a.getString(2131363388), 0).b(this.a.getTitleBarHeight());
      return;
    }
    paramMessage = (String)paramMessage.obj;
    this.a.a.setText(paramMessage + "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bpw
 * JD-Core Version:    0.7.0.1
 */