import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.RecentOptionBar;

public class etl
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  
  public etl(RecentOptionBar paramRecentOptionBar) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_a_of_type_Long) < 500L) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    boolean bool = false;
    switch (paramView.getId())
    {
    default: 
      bool = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar.a(bool);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar.c();
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar.e();
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar.b();
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     etl
 * JD-Core Version:    0.7.0.1
 */