import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;

class tqm
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  tqm(tql paramtql, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Tql.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tql.a, ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tql.a) + tql.a(this.jdField_a_of_type_Tql));
    ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Tql.a, ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Tql.a) + tql.b(this.jdField_a_of_type_Tql));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tql.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tql.a).setVisibility(0);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tql.a, this.jdField_a_of_type_Tql.a.a(ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tql.a)));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tql.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tql.a).setVisibility(4);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tql.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tqm
 * JD-Core Version:    0.7.0.1
 */