import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.troop.file.MoveFileActivity;

public class xai
  implements TextWatcher
{
  public xai(MoveFileActivity paramMoveFileActivity, EditText paramEditText, xnj paramxnj) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    TextView localTextView = this.jdField_a_of_type_Xnj.getBtnight();
    if (bakx.b(paramEditable))
    {
      localTextView.setEnabled(false);
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getResources().getColor(2131165540));
      return;
    }
    localTextView.setEnabled(true);
    localTextView.setTextColor(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getResources().getColor(2131165535));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > 0)
    {
      paramCharSequence = paramCharSequence.toString();
      String str = bakx.b(paramCharSequence);
      if ((paramCharSequence == null) || (paramCharSequence.equals(str))) {
        break label57;
      }
      this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.jdField_a_of_type_Int = paramInt1;
      this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
    }
    label57:
    while (!this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xai
 * JD-Core Version:    0.7.0.1
 */