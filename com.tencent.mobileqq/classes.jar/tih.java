import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;

class tih
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  tih(tig paramtig, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Tig.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tig.a, ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tig.a) + tig.a(this.jdField_a_of_type_Tig));
    ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Tig.a, ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Tig.a) + tig.b(this.jdField_a_of_type_Tig));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tig.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tig.a).setVisibility(0);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tig.a, this.jdField_a_of_type_Tig.a.a(ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tig.a)));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tig.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tig.a).setVisibility(4);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tig.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tih
 * JD-Core Version:    0.7.0.1
 */