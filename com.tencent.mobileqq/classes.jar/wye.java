import android.view.View;
import android.view.View.OnClickListener;

public class wye
  implements View.OnClickListener
{
  protected long a;
  protected View a;
  public wyf a;
  
  public wye(wyf paramwyf, View paramView)
  {
    this.jdField_a_of_type_Wyf = paramwyf;
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
      wta.a("home_page", "clk_shoot", 0, 0, new String[0]);
      this.jdField_a_of_type_Wyf.a();
    }
    bato.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wye
 * JD-Core Version:    0.7.0.1
 */