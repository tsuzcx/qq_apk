import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.widget.QQToast;

public class cly
  extends Handler
{
  public cly(ForwardOperations paramForwardOperations) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      QQToast.a(this.a.a, BaseApplicationImpl.getContext().getString(2131559072), 0).a();
    }
    while (1 != paramMessage.what) {
      return;
    }
    this.a.a.setResult(-1);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cly
 * JD-Core Version:    0.7.0.1
 */