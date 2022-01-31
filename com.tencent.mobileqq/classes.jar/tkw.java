import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.util.Utils;

class tkw
  implements Runnable
{
  tkw(tkv paramtkv, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Tkv.a.a.getTop() > QQSettingMe.a(this.jdField_a_of_type_Tkv.a).getBottom()) {
      this.jdField_a_of_type_Tkv.a.a.setMaxWidth(QQSettingMe.a(this.jdField_a_of_type_Tkv.a) - QQSettingMe.a(this.jdField_a_of_type_Tkv.a).getWidth());
    }
    for (;;)
    {
      if (!Utils.a(this.jdField_a_of_type_JavaLangString, QQSettingMe.a(this.jdField_a_of_type_Tkv.a)))
      {
        QQSettingMe.a(this.jdField_a_of_type_Tkv.a, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Tkv.a.a.setText(QQSettingMe.a(this.jdField_a_of_type_Tkv.a));
      }
      return;
      this.jdField_a_of_type_Tkv.a.a.setMaxWidth(QQSettingMe.a(this.jdField_a_of_type_Tkv.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tkw
 * JD-Core Version:    0.7.0.1
 */