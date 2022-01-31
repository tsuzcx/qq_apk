import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class vhg
  implements View.OnClickListener
{
  vhg(vhd paramvhd) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.a.jdField_a_of_type_Vqf.jdField_a_of_type_JavaLangString))
    {
      this.a.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_Vqf.jdField_a_of_type_JavaLangString;
      paramView = this.a.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      if ((paramView.equals("##")) || (TextUtils.isEmpty(paramView)) || (!paramView.equals("# " + this.a.jdField_a_of_type_JavaLangString)))
      {
        vhm localvhm = this.a.jdField_a_of_type_Vhm;
        if (this.a.jdField_a_of_type_Vhm.a())
        {
          paramView = "2";
          localvhm.a("use_custom_tag", 0, 0, new String[] { paramView });
        }
      }
      else
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText("# " + this.a.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Vhm.a(0);
      return;
      paramView = "1";
      break;
      this.a.jdField_a_of_type_JavaLangString = "";
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vhg
 * JD-Core Version:    0.7.0.1
 */