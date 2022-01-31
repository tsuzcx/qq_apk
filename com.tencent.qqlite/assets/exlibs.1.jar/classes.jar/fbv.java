import android.os.Handler;
import android.os.Message;
import android.widget.Scroller;
import com.tencent.mobileqq.widget.TCTransitDrawable;

public class fbv
  extends Handler
{
  public fbv(TCTransitDrawable paramTCTransitDrawable) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      if ((this.a.jdField_a_of_type_Boolean) && (!this.a.b) && (this.a.c)) {}
    }
    while (paramMessage.what != 2)
    {
      return;
      if (this.a.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
      {
        int i = this.a.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
        int j = this.a.jdField_a_of_type_AndroidWidgetScroller.getCurrY();
        int k = this.a.f;
        int m = this.a.g;
        this.a.f = i;
        this.a.g = j;
        paramMessage = this.a;
        paramMessage.d += i - k;
        paramMessage = this.a;
        paramMessage.e += j - m;
        this.a.invalidateSelf();
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 50L);
        return;
      }
      this.a.d();
      return;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fbv
 * JD-Core Version:    0.7.0.1
 */