import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class xah
  implements View.OnClickListener
{
  xah(xae paramxae) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.a.jdField_a_of_type_Xjg.jdField_a_of_type_JavaLangString))
    {
      this.a.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_Xjg.jdField_a_of_type_JavaLangString;
      paramView = this.a.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      if ((paramView.equals("##")) || (TextUtils.isEmpty(paramView)) || (!paramView.equals("# " + this.a.jdField_a_of_type_JavaLangString)))
      {
        xan localxan = this.a.jdField_a_of_type_Xan;
        if (this.a.jdField_a_of_type_Xan.a())
        {
          paramView = "2";
          localxan.a("use_custom_tag", 0, 0, new String[] { paramView });
        }
      }
      else
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText("# " + this.a.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Xan.a(0);
      return;
      paramView = "1";
      break;
      this.a.jdField_a_of_type_JavaLangString = "";
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xah
 * JD-Core Version:    0.7.0.1
 */