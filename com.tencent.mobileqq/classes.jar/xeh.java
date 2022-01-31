import android.view.View;
import com.tencent.biz.ui.RefreshView;
import com.tencent.widget.ListView;

public class xeh
  implements bfub
{
  public xeh(RefreshView paramRefreshView) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.jdField_a_of_type_Int == 2)
    {
      this.a.jdField_a_of_type_Xea.ao_();
      return;
    }
    this.a.jdField_a_of_type_Xea.c(0L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.jdField_a_of_type_Int != 2)
    {
      RefreshView.a(this.a, false);
      this.a.a(RefreshView.a(this.a));
      this.a.jdField_a_of_type_Xea.a(0L);
      this.a.jdField_a_of_type_Int = 2;
      RefreshView.a(this.a);
    }
    return false;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.jdField_a_of_type_Int != 2) {
      this.a.jdField_a_of_type_Xea.b(0L);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     xeh
 * JD-Core Version:    0.7.0.1
 */