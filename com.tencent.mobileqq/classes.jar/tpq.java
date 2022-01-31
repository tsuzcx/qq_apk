import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.util.Utils;

class tpq
  implements Runnable
{
  tpq(tpp paramtpp, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Tpp.a.a.getTop() > QQSettingMe.a(this.jdField_a_of_type_Tpp.a).getBottom()) {
      this.jdField_a_of_type_Tpp.a.a.setMaxWidth(QQSettingMe.a(this.jdField_a_of_type_Tpp.a) - QQSettingMe.a(this.jdField_a_of_type_Tpp.a).getWidth());
    }
    for (;;)
    {
      if (!Utils.a(this.jdField_a_of_type_JavaLangString, QQSettingMe.a(this.jdField_a_of_type_Tpp.a)))
      {
        QQSettingMe.a(this.jdField_a_of_type_Tpp.a, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Tpp.a.a.setText(QQSettingMe.a(this.jdField_a_of_type_Tpp.a));
      }
      return;
      this.jdField_a_of_type_Tpp.a.a.setMaxWidth(QQSettingMe.a(this.jdField_a_of_type_Tpp.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tpq
 * JD-Core Version:    0.7.0.1
 */