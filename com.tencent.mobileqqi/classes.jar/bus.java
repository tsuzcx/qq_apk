import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class bus
  implements View.OnClickListener
{
  public bus(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.a.jdField_a_of_type_AndroidWidgetButton)
    {
      if (this.a.d != -1011) {
        break label104;
      }
      this.a.a(AddRequestActivity.a(this.a), this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ArrayOfByte, this.a.q, AddRequestActivity.b(this.a), AddRequestActivity.c(this.a));
    }
    for (;;)
    {
      ReportController.b(this.a.b, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
      return;
      label104:
      this.a.a(AddRequestActivity.a(this.a), AddRequestActivity.b(this.a), 0, null, AddRequestActivity.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bus
 * JD-Core Version:    0.7.0.1
 */