import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.util.SwipeBackLayout;
import com.tencent.qphone.base.util.QLog;

public class oek
  extends Handler
{
  public oek(SwipeBackLayout paramSwipeBackLayout) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
    }
    do
    {
      do
      {
        return;
      } while (SwipeBackLayout.a(this.this$0));
      SwipeBackLayout.a(this.this$0, true);
    } while (!(this.this$0.mContext instanceof Activity));
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_SwipeBackLayout", 2, "SwipeBackLayout finish()");
    }
    this.this$0.acn = true;
    ((Activity)this.this$0.mContext).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oek
 * JD-Core Version:    0.7.0.1
 */