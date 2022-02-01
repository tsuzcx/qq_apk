import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;

class thg
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  thg(thf paramthf, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Thf.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Thf.a, ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Thf.a) + thf.a(this.jdField_a_of_type_Thf));
    ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Thf.a, ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Thf.a) + thf.b(this.jdField_a_of_type_Thf));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Thf.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Thf.a).setVisibility(0);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Thf.a, this.jdField_a_of_type_Thf.a.a(ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Thf.a)));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Thf.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Thf.a).setVisibility(4);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Thf.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     thg
 * JD-Core Version:    0.7.0.1
 */