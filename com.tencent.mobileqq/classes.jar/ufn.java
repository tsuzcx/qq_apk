import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.mobileqq.widget.QQToast;

class ufn
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private int b;
  
  ufn(ufh paramufh) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    ufh.a(this.jdField_a_of_type_Ufh).a();
    if (paramEditable == null) {
      return;
    }
    ufh.a(this.jdField_a_of_type_Ufh).removeTextChangedListener(this);
    if (paramEditable.length() > ufh.b(this.jdField_a_of_type_Ufh))
    {
      QQToast.a(this.jdField_a_of_type_Ufh.getContext(), anni.a(2131700987) + ufh.b(this.jdField_a_of_type_Ufh) + anni.a(2131700988), 0).a();
      paramEditable.delete(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
      ufh.a(this.jdField_a_of_type_Ufh).addTextChangedListener(this);
      return;
    }
    Object localObject1 = paramEditable.toString().substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
    int i = ((String)localObject1).indexOf('/');
    if ((i >= 0) && (i < ((String)localObject1).length() - 1))
    {
      localObject1 = new SpannableStringBuilder(paramEditable.toString());
      aafs.a(ufh.a(this.jdField_a_of_type_Ufh).getContext(), (SpannableStringBuilder)localObject1);
    }
    for (;;)
    {
      for (;;)
      {
        if (localObject1 != null) {
          i = ufh.a(this.jdField_a_of_type_Ufh).getSelectionEnd();
        }
        try
        {
          ufh.a(this.jdField_a_of_type_Ufh).setText((CharSequence)localObject1);
          ufh.a(this.jdField_a_of_type_Ufh).setSelection(i);
          this.b = 0;
          this.jdField_a_of_type_Int = 0;
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          for (;;)
          {
            ufh.a(this.jdField_a_of_type_Ufh).setText(paramEditable.toString());
            i = paramEditable.toString().length();
          }
        }
      }
      Object localObject2 = null;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ufn
 * JD-Core Version:    0.7.0.1
 */