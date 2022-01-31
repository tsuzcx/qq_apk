import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.widget.VerticalGallery;
import com.tencent.widget.VerticalGallery.OnEndMovementListener;

public class dbv
  implements VerticalGallery.OnEndMovementListener
{
  private int jdField_a_of_type_Int;
  
  public dbv(IphonePickerView paramIphonePickerView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(VerticalGallery paramVerticalGallery)
  {
    paramVerticalGallery = IphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView)[this.jdField_a_of_type_Int];
    int i = paramVerticalGallery.p();
    if (IphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView) != null)
    {
      String str = IphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView).a(this.jdField_a_of_type_Int, i);
      paramVerticalGallery.setContentDescription(str + "已选中");
    }
    if (IphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView) != null) {
      IphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView).a(this.jdField_a_of_type_Int, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dbv
 * JD-Core Version:    0.7.0.1
 */