import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class xju
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TextView b;
  TextView c;
  TextView d;
  
  public xju(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377373));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377395));
    this.b = ((TextView)paramView.findViewById(2131377364));
    this.c = ((TextView)paramView.findViewById(2131377363));
    this.d = ((TextView)paramView.findViewById(2131377397));
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
  
  public void a(xjv paramxjv1, xjv paramxjv2)
  {
    a(this.jdField_a_of_type_AndroidWidgetTextView, paramxjv1.jdField_a_of_type_Xjw.jdField_a_of_type_JavaLangString);
    a(this.b, paramxjv1.jdField_a_of_type_Xjw.b);
    if (paramxjv1.jdField_a_of_type_Int <= 0) {
      this.c.setVisibility(8);
    }
    for (;;)
    {
      a(this.d, paramxjv1.jdField_a_of_type_JavaLangString);
      if (!paramxjv1.equals(paramxjv2)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846320);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFA34B"));
      return;
      a(this.c, paramxjv1.jdField_a_of_type_Int + alpo.a(2131711436));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846324);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xju
 * JD-Core Version:    0.7.0.1
 */