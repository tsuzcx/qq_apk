import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.widget.GridListView;

public class dve
  extends Handler
{
  public dve(VisitorsActivity paramVisitorsActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        return;
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.B();
        return;
        VisitorsActivity.a(this.a);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.B();
        this.a.a(1, this.a.getString(2131562097));
      } while (!dvk.a(this.a.jdField_a_of_type_Dvk));
      dvk.a(this.a.jdField_a_of_type_Dvk, false);
      this.a.jdField_a_of_type_Dvk.notifyDataSetChanged();
      return;
    }
    this.a.jdField_a_of_type_Dvk.notifyDataSetChanged();
    this.a.d = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dve
 * JD-Core Version:    0.7.0.1
 */