import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;

public class whw
  implements TextView.OnEditorActionListener
{
  public whw(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 3) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      paramTextView = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (!TextUtils.isEmpty(paramTextView)) {
        if ((this.a.f == ClassificationSearchActivity.jdField_a_of_type_Int) && (!TextUtils.isEmpty(paramTextView.trim())))
        {
          this.a.a(paramTextView);
          PublicAccountReportUtils.a(null, "dc00899", "Pb_account_lifeservice", "", "0X80067C4", "0X80067C4", 0, 0, "", "", paramTextView, "", true);
          ClassificationSearchActivity.a(this.a, paramTextView);
        }
      }
      for (;;)
      {
        return true;
        if (this.a.f == ClassificationSearchActivity.d)
        {
          PublicAccountReportUtils.a(null, "", "0X800742D", "0X800742D", 0, 0, paramTextView, "", "", "");
          ClassificationSearchActivity.a(this.a, paramTextView);
        }
        else
        {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(paramTextView, false);
          continue;
          if (this.a.f == ClassificationSearchActivity.jdField_a_of_type_Int)
          {
            paramTextView = this.a.jdField_a_of_type_AndroidWidgetEditText.getHint().toString();
            if ((!TextUtils.isEmpty(paramTextView.trim())) && (!TextUtils.equals(paramTextView, "搜索相关文章")) && (!TextUtils.equals(paramTextView, "搜索")))
            {
              this.a.a(paramTextView);
              PublicAccountReportUtils.a(null, "dc00899", "Pb_account_lifeservice", "", "0X80067C4", "0X80067C4", 0, 0, "", "", paramTextView, "", true);
              ClassificationSearchActivity.a(this.a, paramTextView);
            }
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     whw
 * JD-Core Version:    0.7.0.1
 */