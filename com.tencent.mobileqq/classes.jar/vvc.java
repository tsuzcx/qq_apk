import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class vvc
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TextView b;
  TextView c;
  TextView d;
  
  public vvc(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376859));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376881));
    this.b = ((TextView)paramView.findViewById(2131376850));
    this.c = ((TextView)paramView.findViewById(2131376849));
    this.d = ((TextView)paramView.findViewById(2131376883));
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
    paramTextView.setText(paramString);
  }
  
  public void a(vvd paramvvd1, vvd paramvvd2)
  {
    a(this.jdField_a_of_type_AndroidWidgetTextView, paramvvd1.jdField_a_of_type_Vve.jdField_a_of_type_JavaLangString);
    a(this.b, paramvvd1.jdField_a_of_type_Vve.b);
    if (paramvvd1.jdField_a_of_type_Int <= 0) {
      this.c.setVisibility(8);
    }
    for (;;)
    {
      a(this.d, paramvvd1.jdField_a_of_type_JavaLangString);
      if (!paramvvd1.equals(paramvvd2)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845941);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFA34B"));
      return;
      a(this.c, paramvvd1.jdField_a_of_type_Int + ajya.a(2131711064));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845945);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vvc
 * JD-Core Version:    0.7.0.1
 */