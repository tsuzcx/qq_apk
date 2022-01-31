import android.text.format.DateFormat;
import android.widget.TextView;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.List;

class art
  implements Runnable
{
  art(arr paramarr) {}
  
  public void run()
  {
    String str1 = StringUtil.a(this.a.a.c, 0, 32);
    String str2 = StringUtil.a(this.a.a.e, 0, 32);
    if (this.a.a.jdField_a_of_type_JavaUtilList != null) {
      this.a.a.jdField_a_of_type_AndroidWidgetTextView.setText(str1 + String.format("(%d人)", new Object[] { Integer.valueOf(this.a.a.jdField_a_of_type_JavaUtilList.size()) }));
    }
    for (;;)
    {
      this.a.a.jdField_b_of_type_AndroidWidgetTextView.setText(str2 + " 创建于 " + DateFormat.format("yy-M-d", this.a.a.jdField_b_of_type_Long));
      return;
      this.a.a.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     art
 * JD-Core Version:    0.7.0.1
 */