import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class yvu
  extends yvs<yvt>
{
  TextView jdField_a_of_type_AndroidWidgetTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370508);
  
  yvu(yvt paramyvt, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561765, paramViewGroup, false);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  public void a(yvt paramyvt, int paramInt)
  {
    super.a(paramyvt, paramInt);
    if (paramyvt != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramyvt.a());
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yvu
 * JD-Core Version:    0.7.0.1
 */