import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class zho
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TextView b;
  TextView c;
  TextView d;
  
  public zho(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131378256));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378279));
    this.b = ((TextView)paramView.findViewById(2131378247));
    this.c = ((TextView)paramView.findViewById(2131378246));
    this.d = ((TextView)paramView.findViewById(2131378284));
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
  
  public void a(zhp paramzhp1, zhp paramzhp2)
  {
    a(this.jdField_a_of_type_AndroidWidgetTextView, paramzhp1.jdField_a_of_type_Zhq.jdField_a_of_type_JavaLangString);
    a(this.b, paramzhp1.jdField_a_of_type_Zhq.b);
    if (paramzhp1.jdField_a_of_type_Int <= 0) {
      this.c.setVisibility(8);
    }
    for (;;)
    {
      a(this.d, paramzhp1.jdField_a_of_type_JavaLangString);
      if (!paramzhp1.equals(paramzhp2)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846831);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFA34B"));
      return;
      a(this.c, paramzhp1.jdField_a_of_type_Int + anni.a(2131709824));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846835);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zho
 * JD-Core Version:    0.7.0.1
 */