import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.widget.XEditTextEx;
import com.tribe.async.dispatch.IEventReceiver;

public class zgm
  implements IEventReceiver
{
  public View.OnClickListener a;
  public final View a;
  public ImageButton a;
  public TextView a;
  public XEditTextEx a;
  public String a;
  public zgp a;
  
  public zgm(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    a(paramView);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131363250));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364926));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)paramView.findViewById(2131365878));
    paramView = new SpannableString(anzj.a(2131709677));
    paramView.setSpan(new AbsoluteSizeSpan(14, true), 0, paramView.length(), 33);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(paramView);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(new zgo(this));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnEditorActionListener(new zgn(this));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidViewView.getVisibility();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(paramOnClickListener);
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zgm
 * JD-Core Version:    0.7.0.1
 */