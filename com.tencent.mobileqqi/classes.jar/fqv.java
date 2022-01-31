import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.widget.VerticalGallery.LayoutParams;

public class fqv
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 25;
  private int b;
  
  public fqv(IphonePickerView paramIphonePickerView, int paramInt)
  {
    this.b = paramInt;
  }
  
  public fqv(IphonePickerView paramIphonePickerView, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_Int = ((int)TypedValue.applyDimension(1, paramInt2, paramIphonePickerView.getResources().getDisplayMetrics()));
  }
  
  public int getCount()
  {
    return IphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView).a(this.b);
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new WheelTextView(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.getContext());
      paramView.setLayoutParams(new VerticalGallery.LayoutParams(-1, this.jdField_a_of_type_Int));
    }
    for (;;)
    {
      paramViewGroup = (WheelTextView)paramView;
      paramViewGroup.setTextSize(20.0F);
      paramViewGroup.setTextColor(-7829368);
      paramViewGroup.setGravity(17);
      paramViewGroup.setText(IphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView).a(this.b, paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fqv
 * JD-Core Version:    0.7.0.1
 */