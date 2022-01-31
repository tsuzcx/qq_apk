import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.widget.GridListView;

public class bsi
  extends Handler
{
  public bsi(VisitorsActivity paramVisitorsActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.B();
      return;
    case 4: 
      this.a.jdField_b_of_type_ComTencentMobileqqWidgetGridListView.B();
      return;
    case 2: 
      VisitorsActivity.a(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.B();
      this.a.jdField_b_of_type_ComTencentMobileqqWidgetGridListView.B();
      this.a.a(1, this.a.getString(2131363527));
      return;
    }
    if (this.a.h == 0) {
      this.a.jdField_a_of_type_Bso.notifyDataSetChanged();
    }
    for (;;)
    {
      this.a.d = SystemClock.uptimeMillis();
      return;
      this.a.jdField_b_of_type_Bso.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bsi
 * JD-Core Version:    0.7.0.1
 */