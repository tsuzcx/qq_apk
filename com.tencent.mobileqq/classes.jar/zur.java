import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.qphone.base.util.QLog;

public class zur
  implements TextWatcher
{
  int jdField_a_of_type_Int = -1;
  String jdField_a_of_type_JavaLangString = null;
  
  public zur(CommentEditText paramCommentEditText) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.jdField_a_of_type_JavaLangString != null) {}
    try
    {
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setText(this.jdField_a_of_type_JavaLangString);
      if (i > this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.length()) {
        this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setSelection(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.length());
      }
      return;
    }
    catch (Exception paramEditable)
    {
      QLog.e("CommentInputPopupWindow", 1, "setTextError");
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = paramCharSequence.toString().indexOf("[/", paramInt1);
    int i = paramCharSequence.toString().indexOf(']', paramInt1);
    if ((paramInt2 >= paramInt1) && (paramInt2 < paramInt1 + paramInt3) && ((i > paramInt1 + paramInt3) || (i == -1)))
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getSelectionEnd();
      this.jdField_a_of_type_JavaLangString = (paramCharSequence.subSequence(0, paramInt2).toString() + paramCharSequence.subSequence(paramInt1 + paramInt3, paramCharSequence.length()));
      return;
    }
    this.jdField_a_of_type_JavaLangString = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zur
 * JD-Core Version:    0.7.0.1
 */