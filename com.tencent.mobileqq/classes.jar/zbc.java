import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class zbc
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TextView b;
  TextView c;
  TextView d;
  
  public zbc(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131378468));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378491));
    this.b = ((TextView)paramView.findViewById(2131378459));
    this.c = ((TextView)paramView.findViewById(2131378458));
    this.d = ((TextView)paramView.findViewById(2131378496));
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
  
  public void a(zbd paramzbd1, zbd paramzbd2)
  {
    a(this.jdField_a_of_type_AndroidWidgetTextView, paramzbd1.jdField_a_of_type_Zbe.jdField_a_of_type_JavaLangString);
    a(this.b, paramzbd1.jdField_a_of_type_Zbe.b);
    if (paramzbd1.jdField_a_of_type_Int <= 0) {
      this.c.setVisibility(8);
    }
    for (;;)
    {
      a(this.d, paramzbd1.jdField_a_of_type_JavaLangString);
      if (!paramzbd1.equals(paramzbd2)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846852);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFA34B"));
      return;
      a(this.c, paramzbd1.jdField_a_of_type_Int + anvx.a(2131710512));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846856);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zbc
 * JD-Core Version:    0.7.0.1
 */