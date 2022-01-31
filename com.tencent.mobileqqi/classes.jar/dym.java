import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class dym
  extends Handler
{
  public dym(TroopRequestActivity paramTroopRequestActivity) {}
  
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
      QQToast.a(this.a, this.a.getString(2131562880), 0).b(this.a.d());
      this.a.finish();
      return;
    case 1: 
      this.a.a(true);
      if (TroopRequestActivity.a(this.a) != null) {
        TroopRequestActivity.a(this.a).dismiss();
      }
      QQToast.a(this.a, this.a.getString(2131561435), 0).b(this.a.d());
      return;
    }
    paramMessage = (String)paramMessage.obj;
    this.a.a.setText(paramMessage + "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dym
 * JD-Core Version:    0.7.0.1
 */