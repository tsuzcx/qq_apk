import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ynr
  implements View.OnClickListener
{
  ynr(yno paramyno) {}
  
  public void onClick(View paramView)
  {
    String str;
    if (!TextUtils.isEmpty(this.a.jdField_a_of_type_Ywf.jdField_a_of_type_JavaLangString))
    {
      this.a.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_Ywf.jdField_a_of_type_JavaLangString;
      str = this.a.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      if ((str.equals("##")) || (TextUtils.isEmpty(str)) || (!str.equals("# " + this.a.jdField_a_of_type_JavaLangString)))
      {
        ynw localynw = this.a.jdField_a_of_type_Ynw;
        if (this.a.jdField_a_of_type_Ynw.a())
        {
          str = "2";
          localynw.a("use_custom_tag", 0, 0, new String[] { str });
        }
      }
      else
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText("# " + this.a.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Ynw.a(0);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str = "1";
      break;
      this.a.jdField_a_of_type_JavaLangString = "";
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ynr
 * JD-Core Version:    0.7.0.1
 */