import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;

class tpl
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  tpl(tpk paramtpk, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Tpk.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Tpk.a, ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Tpk.a) + tpk.a(this.jdField_a_of_type_Tpk));
    ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Tpk.a, ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Tpk.a) + tpk.b(this.jdField_a_of_type_Tpk));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Tpk.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Tpk.a).setVisibility(0);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Tpk.a, this.jdField_a_of_type_Tpk.a.a(ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Tpk.a)));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Tpk.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Tpk.a).setVisibility(4);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Tpk.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tpl
 * JD-Core Version:    0.7.0.1
 */