import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.common.app.BaseApplicationImpl;

class vco
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private int b;
  
  vco(vcn paramvcn) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    vcn.a(this.jdField_a_of_type_Vcn).removeTextChangedListener(this);
    if ((paramEditable.toString().length() > 80) && (this.jdField_a_of_type_Int + this.b <= paramEditable.toString().length()))
    {
      int i = this.jdField_a_of_type_Int + this.b - (paramEditable.toString().length() - 80);
      paramEditable = paramEditable.toString().substring(0, i) + paramEditable.toString().substring(this.jdField_a_of_type_Int + this.b);
      vcn.a(this.jdField_a_of_type_Vcn).setText(paramEditable);
      vcn.a(this.jdField_a_of_type_Vcn).setSelection(i);
      vws.a(-1L, BaseApplicationImpl.getContext(), 1, anzj.a(2131697194), 1);
    }
    vcn.a(this.jdField_a_of_type_Vcn).addTextChangedListener(this);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vco
 * JD-Core Version:    0.7.0.1
 */