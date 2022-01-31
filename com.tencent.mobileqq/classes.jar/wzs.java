import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;
import com.tencent.mobileqq.activity.qwallet.widget.ViewTransformer.ViewTransformerListener;

public class wzs
  implements ViewTransformer.ViewTransformerListener
{
  public wzs(CommonHbFragment paramCommonHbFragment, EditText paramEditText, RelativeLayout paramRelativeLayout) {}
  
  public void OnTransferFinished()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {}
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wzs
 * JD-Core Version:    0.7.0.1
 */