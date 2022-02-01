import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;

class the
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  the(thd paramthd, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Thd.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Thd.a, ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Thd.a) + thd.a(this.jdField_a_of_type_Thd));
    ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Thd.a, ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Thd.a) + thd.b(this.jdField_a_of_type_Thd));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Thd.a, this.jdField_a_of_type_Thd.a.a(ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Thd.a)));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Thd.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Thd.a).setVisibility(4);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Thd.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     the
 * JD-Core Version:    0.7.0.1
 */