import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.PrivacyDeclareViewActivity;
import com.tencent.mobileqq.app.PrivacyDeclareHelper;

public class czv
  extends Handler
{
  public czv(PrivacyDeclareViewActivity paramPrivacyDeclareViewActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 101: 
      paramMessage = new czw(this);
      PrivacyDeclareViewActivity.a(this.a, null, PrivacyDeclareViewActivity.a(this.a, 2131563349), PrivacyDeclareViewActivity.a(this.a, 2131563363), PrivacyDeclareViewActivity.a(this.a, 2131561842), paramMessage);
      return;
    }
    String str = PrivacyDeclareHelper.a(this.a, 2131563358, (String)paramMessage.obj);
    paramMessage = PrivacyDeclareHelper.a(this.a, 2131562539, (String)paramMessage.obj);
    PrivacyDeclareViewActivity.a(this.a, null, str, paramMessage, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     czv
 * JD-Core Version:    0.7.0.1
 */