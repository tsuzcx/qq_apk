import com.tencent.widget.AbsListView;
import com.tencent.widget.FastScroller;

public class hvz
  implements Runnable
{
  public hvz(FastScroller paramFastScroller) {}
  
  public void run()
  {
    int k;
    int j;
    int i;
    if (this.a.jdField_a_of_type_ComTencentWidgetAbsListView.l)
    {
      this.a.f();
      k = this.a.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight();
      j = (int)this.a.jdField_a_of_type_Float - this.a.jdField_a_of_type_Int + 10;
      if (j >= 0) {
        break label100;
      }
      i = 0;
    }
    for (;;)
    {
      this.a.c = i;
      this.a.a(this.a.c / (k - this.a.jdField_a_of_type_Int));
      this.a.b = false;
      return;
      label100:
      i = j;
      if (this.a.jdField_a_of_type_Int + j > k) {
        i = k - this.a.jdField_a_of_type_Int;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hvz
 * JD-Core Version:    0.7.0.1
 */