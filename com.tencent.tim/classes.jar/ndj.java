import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;

class ndj
  extends Handler
{
  ndj(ndi paramndi, Looper paramLooper)
  {
    super(paramLooper);
  }
  
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
        this.this$0.a.getGlobalVisibleRect(ndi.a(this.this$0));
      } while (!knd.d(ndi.a(this.this$0)));
      if (!this.this$0.art) {
        break;
      }
      if (this.this$0.ars)
      {
        ndi.a(this.this$0, this.this$0.a);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.w("ReadInJoyBaseAdapter", 2, "MSG_FOR_CHECK_PLAYAREA, 平移转场动画未做完，不触发自动播放");
    return;
    ndi.a(this.this$0, this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ndj
 * JD-Core Version:    0.7.0.1
 */