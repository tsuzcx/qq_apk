import android.view.View;
import android.view.View.OnClickListener;

public class xcn
  implements View.OnClickListener
{
  protected long a;
  protected View a;
  public xco a;
  
  public xcn(xco paramxco, View paramView)
  {
    this.jdField_a_of_type_Xco = paramxco;
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
      wxj.a("home_page", "clk_shoot", 0, 0, new String[0]);
      this.jdField_a_of_type_Xco.a();
    }
    baxx.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xcn
 * JD-Core Version:    0.7.0.1
 */