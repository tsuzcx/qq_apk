import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.QQToast;

class ahkp
  extends Handler
{
  ahkp(ahki paramahki) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      QQToast.a(this.this$0.mActivity, acfp.m(2131706514), 0).show();
    }
    while (1 != paramMessage.what) {
      return;
    }
    this.this$0.mActivity.setResult(-1);
    this.this$0.mActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahkp
 * JD-Core Version:    0.7.0.1
 */