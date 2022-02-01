import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleCheckableSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleCheckableSlidingIndicator.a;

public class yzy
  implements Handler.Callback
{
  public yzy(SimpleCheckableSlidingIndicator paramSimpleCheckableSlidingIndicator) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == SimpleCheckableSlidingIndicator.cce)
    {
      if (this.b.getScrollX() == SimpleCheckableSlidingIndicator.a(this.b))
      {
        SimpleCheckableSlidingIndicator.a(this.b, SimpleCheckableSlidingIndicator.cca);
        if (SimpleCheckableSlidingIndicator.a(this.b) != null) {
          SimpleCheckableSlidingIndicator.a(this.b).yL(SimpleCheckableSlidingIndicator.b(this.b));
        }
        SimpleCheckableSlidingIndicator.a(this.b).removeMessages(SimpleCheckableSlidingIndicator.cce);
      }
    }
    else {
      return false;
    }
    SimpleCheckableSlidingIndicator.a(this.b, SimpleCheckableSlidingIndicator.ccc);
    if (SimpleCheckableSlidingIndicator.a(this.b) != null) {
      SimpleCheckableSlidingIndicator.a(this.b).yL(SimpleCheckableSlidingIndicator.b(this.b));
    }
    SimpleCheckableSlidingIndicator.b(this.b, this.b.getScrollX());
    SimpleCheckableSlidingIndicator.a(this.b).sendEmptyMessageDelayed(SimpleCheckableSlidingIndicator.cce, 50L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yzy
 * JD-Core Version:    0.7.0.1
 */