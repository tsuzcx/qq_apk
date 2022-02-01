import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class zlj
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TextView b;
  TextView c;
  TextView d;
  
  public zlj(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131378413));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378436));
    this.b = ((TextView)paramView.findViewById(2131378404));
    this.c = ((TextView)paramView.findViewById(2131378403));
    this.d = ((TextView)paramView.findViewById(2131378441));
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
  
  public void a(zlk paramzlk1, zlk paramzlk2)
  {
    a(this.jdField_a_of_type_AndroidWidgetTextView, paramzlk1.jdField_a_of_type_Zll.jdField_a_of_type_JavaLangString);
    a(this.b, paramzlk1.jdField_a_of_type_Zll.b);
    if (paramzlk1.jdField_a_of_type_Int <= 0) {
      this.c.setVisibility(8);
    }
    for (;;)
    {
      a(this.d, paramzlk1.jdField_a_of_type_JavaLangString);
      if (!paramzlk1.equals(paramzlk2)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846848);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFA34B"));
      return;
      a(this.c, paramzlk1.jdField_a_of_type_Int + anzj.a(2131709933));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846852);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zlj
 * JD-Core Version:    0.7.0.1
 */