import android.text.format.DateFormat;
import android.widget.TextView;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.List;

class cxk
  implements Runnable
{
  cxk(cxi paramcxi) {}
  
  public void run()
  {
    String str1 = StringUtil.a(this.a.a.c, 0, 32);
    String str2 = StringUtil.a(this.a.a.e, 0, 32);
    if (this.a.a.jdField_a_of_type_JavaUtilList != null) {
      this.a.a.jdField_a_of_type_AndroidWidgetTextView.setText(str1 + String.format(this.a.a.getString(2131559084), new Object[] { Integer.valueOf(this.a.a.jdField_a_of_type_JavaUtilList.size()) }));
    }
    for (;;)
    {
      this.a.a.jdField_b_of_type_AndroidWidgetTextView.setText(this.a.a.getString(2131559085, new Object[] { str2, DateFormat.format("yy-M-d", this.a.a.jdField_b_of_type_Long) }));
      return;
      this.a.a.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cxk
 * JD-Core Version:    0.7.0.1
 */