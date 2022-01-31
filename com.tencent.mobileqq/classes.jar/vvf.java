import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class vvf
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TextView b;
  TextView c;
  TextView d;
  
  public vvf(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376857));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376879));
    this.b = ((TextView)paramView.findViewById(2131376848));
    this.c = ((TextView)paramView.findViewById(2131376847));
    this.d = ((TextView)paramView.findViewById(2131376881));
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
  
  public void a(vvg paramvvg1, vvg paramvvg2)
  {
    a(this.jdField_a_of_type_AndroidWidgetTextView, paramvvg1.jdField_a_of_type_Vvh.jdField_a_of_type_JavaLangString);
    a(this.b, paramvvg1.jdField_a_of_type_Vvh.b);
    if (paramvvg1.jdField_a_of_type_Int <= 0) {
      this.c.setVisibility(8);
    }
    for (;;)
    {
      a(this.d, paramvvg1.jdField_a_of_type_JavaLangString);
      if (!paramvvg1.equals(paramvvg2)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845935);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFA34B"));
      return;
      a(this.c, paramvvg1.jdField_a_of_type_Int + ajyc.a(2131711053));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845939);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vvf
 * JD-Core Version:    0.7.0.1
 */