import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.qphone.base.util.QLog;

public class arru
  extends Handler
{
  public arru(OpenCardContainer paramOpenCardContainer, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SDK_LOGIN.OpenCardContainer", 2, "-->handleMessage MSG_UPDATE");
      }
      OpenCardContainer.a(this.this$0);
      this.this$0.f.setImageDrawable(this.this$0.mDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arru
 * JD-Core Version:    0.7.0.1
 */