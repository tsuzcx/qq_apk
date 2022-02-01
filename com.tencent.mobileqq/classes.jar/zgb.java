import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class zgb
  extends zfz<zga>
{
  TextView jdField_a_of_type_AndroidWidgetTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370359);
  
  zgb(zga paramzga, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561819, paramViewGroup, false);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  public void a(zga paramzga, int paramInt)
  {
    super.a(paramzga, paramInt);
    if (paramzga != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramzga.a());
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zgb
 * JD-Core Version:    0.7.0.1
 */