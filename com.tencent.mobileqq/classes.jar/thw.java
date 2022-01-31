import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.util.Utils;

class thw
  implements Runnable
{
  thw(thv paramthv, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Thv.a.a.getTop() > QQSettingMe.a(this.jdField_a_of_type_Thv.a).getBottom()) {
      this.jdField_a_of_type_Thv.a.a.setMaxWidth(QQSettingMe.a(this.jdField_a_of_type_Thv.a) - QQSettingMe.a(this.jdField_a_of_type_Thv.a).getWidth());
    }
    for (;;)
    {
      if (!Utils.a(this.jdField_a_of_type_JavaLangString, QQSettingMe.a(this.jdField_a_of_type_Thv.a)))
      {
        QQSettingMe.a(this.jdField_a_of_type_Thv.a, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Thv.a.a.setText(QQSettingMe.a(this.jdField_a_of_type_Thv.a));
      }
      return;
      this.jdField_a_of_type_Thv.a.a.setMaxWidth(QQSettingMe.a(this.jdField_a_of_type_Thv.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     thw
 * JD-Core Version:    0.7.0.1
 */