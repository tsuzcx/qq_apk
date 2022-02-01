import android.os.Handler;
import com.tencent.mobileqq.activity.EditTagActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;

public class cjq
  extends CardObserver
{
  public cjq(EditTagActivity paramEditTagActivity) {}
  
  protected void b(boolean paramBoolean, Card paramCard)
  {
    if (paramBoolean) {
      this.a.d(2131562804);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1000L);
      return;
      this.a.d(2131562043);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cjq
 * JD-Core Version:    0.7.0.1
 */