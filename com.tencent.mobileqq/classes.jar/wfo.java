import android.text.Layout;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import java.util.ArrayList;

public class wfo
  implements Runnable
{
  public wfo(BlessSelectMemberActivity paramBlessSelectMemberActivity, TextView paramTextView, StringBuilder paramStringBuilder) {}
  
  public void run()
  {
    int i = 0;
    int j = this.jdField_a_of_type_AndroidWidgetTextView.getLineCount();
    String str1;
    if (j == 4)
    {
      j = this.jdField_a_of_type_AndroidWidgetTextView.getLayout().getLineEnd(j - 1);
      if (j < this.jdField_a_of_type_JavaLangStringBuilder.length())
      {
        str1 = String.format(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity.getString(2131438264), new Object[] { "...", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity.a.size()) });
        float f = this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(str1);
        if (i < this.jdField_a_of_type_JavaLangStringBuilder.length())
        {
          String str2 = this.jdField_a_of_type_JavaLangStringBuilder.substring(j - i, j);
          if (this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(str2) < f) {
            break label237;
          }
          this.jdField_a_of_type_JavaLangStringBuilder.setLength(j - i);
        }
        BlessSelectMemberActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity, this.jdField_a_of_type_JavaLangStringBuilder.toString());
        if (!BlessSelectMemberActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity).endsWith("、 ")) {
          break label244;
        }
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(this.jdField_a_of_type_JavaLangStringBuilder.length() - 2);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append(str1);
      BlessSelectMemberActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity, this.jdField_a_of_type_JavaLangStringBuilder.toString());
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(null);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(BlessSelectMemberActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity));
      return;
      label237:
      i += 1;
      break;
      label244:
      if (BlessSelectMemberActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity).endsWith("、")) {
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(this.jdField_a_of_type_JavaLangStringBuilder.length() - 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wfo
 * JD-Core Version:    0.7.0.1
 */