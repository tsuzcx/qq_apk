import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class ymj
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TextView b;
  TextView c;
  TextView d;
  
  public ymj(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131378180));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378203));
    this.b = ((TextView)paramView.findViewById(2131378171));
    this.c = ((TextView)paramView.findViewById(2131378170));
    this.d = ((TextView)paramView.findViewById(2131378208));
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
  
  public void a(ymk paramymk1, ymk paramymk2)
  {
    a(this.jdField_a_of_type_AndroidWidgetTextView, paramymk1.jdField_a_of_type_Yml.jdField_a_of_type_JavaLangString);
    a(this.b, paramymk1.jdField_a_of_type_Yml.b);
    if (paramymk1.jdField_a_of_type_Int <= 0) {
      this.c.setVisibility(8);
    }
    for (;;)
    {
      a(this.d, paramymk1.jdField_a_of_type_JavaLangString);
      if (!paramymk1.equals(paramymk2)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846756);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFA34B"));
      return;
      a(this.c, paramymk1.jdField_a_of_type_Int + amtj.a(2131710165));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846760);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymj
 * JD-Core Version:    0.7.0.1
 */