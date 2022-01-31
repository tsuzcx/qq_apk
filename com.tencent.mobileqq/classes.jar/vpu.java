import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class vpu
  extends vps<vpt>
{
  TextView jdField_a_of_type_AndroidWidgetTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369540);
  
  vpu(vpt paramvpt, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561335, paramViewGroup, false);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  public void a(vpt paramvpt, int paramInt)
  {
    super.a(paramvpt, paramInt);
    if (paramvpt != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramvpt.a());
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vpu
 * JD-Core Version:    0.7.0.1
 */