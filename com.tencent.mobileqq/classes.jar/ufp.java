import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.mobileqq.widget.QQToast;

class ufp
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private int b;
  
  ufp(ufj paramufj) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    ufj.a(this.jdField_a_of_type_Ufj).a();
    if (paramEditable == null) {
      return;
    }
    ufj.a(this.jdField_a_of_type_Ufj).removeTextChangedListener(this);
    if (paramEditable.length() > ufj.b(this.jdField_a_of_type_Ufj))
    {
      QQToast.a(this.jdField_a_of_type_Ufj.getContext(), anzj.a(2131701094) + ufj.b(this.jdField_a_of_type_Ufj) + anzj.a(2131701095), 0).a();
      paramEditable.delete(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
      ufj.a(this.jdField_a_of_type_Ufj).addTextChangedListener(this);
      return;
    }
    Object localObject1 = paramEditable.toString().substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
    int i = ((String)localObject1).indexOf('/');
    if ((i >= 0) && (i < ((String)localObject1).length() - 1))
    {
      localObject1 = new SpannableStringBuilder(paramEditable.toString());
      aajt.a(ufj.a(this.jdField_a_of_type_Ufj).getContext(), (SpannableStringBuilder)localObject1);
    }
    for (;;)
    {
      for (;;)
      {
        if (localObject1 != null) {
          i = ufj.a(this.jdField_a_of_type_Ufj).getSelectionEnd();
        }
        try
        {
          ufj.a(this.jdField_a_of_type_Ufj).setText((CharSequence)localObject1);
          ufj.a(this.jdField_a_of_type_Ufj).setSelection(i);
          this.b = 0;
          this.jdField_a_of_type_Int = 0;
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          for (;;)
          {
            ufj.a(this.jdField_a_of_type_Ufj).setText(paramEditable.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufp
 * JD-Core Version:    0.7.0.1
 */