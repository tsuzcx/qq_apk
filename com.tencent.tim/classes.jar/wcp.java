import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.widget.QQToast;

public class wcp
  extends Handler
{
  public wcp(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.this$0.ath();
      QQToast.a(this.this$0, this.this$0.getString(2131719496), 0).show(this.this$0.getTitleBarHeight());
      this.this$0.finish();
      return;
    case 1: 
      this.this$0.setButtonEnabled(true);
      this.this$0.ath();
      QQToast.a(this.this$0, this.this$0.getString(2131719483), 0).show(this.this$0.getTitleBarHeight());
      return;
    }
    paramMessage = (String)paramMessage.obj;
    this.this$0.GK.setText(paramMessage + "");
    this.this$0.GK.setContentDescription(paramMessage + "");
    this.this$0.GK.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wcp
 * JD-Core Version:    0.7.0.1
 */