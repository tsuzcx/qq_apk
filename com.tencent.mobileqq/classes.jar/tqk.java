import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;

class tqk
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  tqk(tqj paramtqj, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Tqj.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tqj.a, ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tqj.a) + tqj.a(this.jdField_a_of_type_Tqj));
    ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Tqj.a, ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Tqj.a) + tqj.b(this.jdField_a_of_type_Tqj));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tqj.a, this.jdField_a_of_type_Tqj.a.a(ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tqj.a)));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tqj.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tqj.a).setVisibility(4);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tqj.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tqk
 * JD-Core Version:    0.7.0.1
 */