import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yzt
  implements View.OnClickListener
{
  protected long a;
  protected View a;
  public yzu a;
  
  public yzt(yzu paramyzu, View paramView)
  {
    this.jdField_a_of_type_Yzu = paramyzu;
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramView.setOnClickListener(this);
  }
  
  private boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_a_of_type_Long;
    if ((l2 > 0L) && (l2 < 2000L)) {
      return true;
    }
    this.jdField_a_of_type_Long = l1;
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (!a())
    {
      yup.a("home_page", "clk_shoot", 0, 0, new String[0]);
      this.jdField_a_of_type_Yzu.a();
    }
    bext.g();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yzt
 * JD-Core Version:    0.7.0.1
 */