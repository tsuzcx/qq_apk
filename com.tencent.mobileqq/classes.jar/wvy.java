import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class wvy
  implements View.OnClickListener
{
  wvy(wvv paramwvv) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.a.jdField_a_of_type_Xex.jdField_a_of_type_JavaLangString))
    {
      this.a.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_Xex.jdField_a_of_type_JavaLangString;
      paramView = this.a.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      if ((paramView.equals("##")) || (TextUtils.isEmpty(paramView)) || (!paramView.equals("# " + this.a.jdField_a_of_type_JavaLangString)))
      {
        wwe localwwe = this.a.jdField_a_of_type_Wwe;
        if (this.a.jdField_a_of_type_Wwe.a())
        {
          paramView = "2";
          localwwe.a("use_custom_tag", 0, 0, new String[] { paramView });
        }
      }
      else
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText("# " + this.a.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Wwe.a(0);
      return;
      paramView = "1";
      break;
      this.a.jdField_a_of_type_JavaLangString = "";
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wvy
 * JD-Core Version:    0.7.0.1
 */