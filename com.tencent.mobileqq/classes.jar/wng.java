import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import com.tencent.biz.subscribe.comment.CommentEditText;

class wng
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private int b;
  
  wng(wnb paramwnb) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    wnb.a(this.jdField_a_of_type_Wnb).removeTextChangedListener(this);
    if (paramEditable.length() > wnb.b(this.jdField_a_of_type_Wnb))
    {
      bcql.a(this.jdField_a_of_type_Wnb.getContext(), ajya.a(2131702183) + wnb.b(this.jdField_a_of_type_Wnb) + ajya.a(2131702184), 0).a();
      paramEditable.delete(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
      wnb.a(this.jdField_a_of_type_Wnb).addTextChangedListener(this);
      return;
    }
    Object localObject1 = paramEditable.toString().substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
    int i = ((String)localObject1).indexOf('/');
    if ((i >= 0) && (i < ((String)localObject1).length() - 1))
    {
      localObject1 = new SpannableStringBuilder(paramEditable.toString());
      woh.a(wnb.a(this.jdField_a_of_type_Wnb).getContext(), (SpannableStringBuilder)localObject1);
    }
    for (;;)
    {
      for (;;)
      {
        if (localObject1 != null) {
          i = wnb.a(this.jdField_a_of_type_Wnb).getSelectionEnd();
        }
        try
        {
          wnb.a(this.jdField_a_of_type_Wnb).setText((CharSequence)localObject1);
          wnb.a(this.jdField_a_of_type_Wnb).setSelection(i);
          this.b = 0;
          this.jdField_a_of_type_Int = 0;
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          for (;;)
          {
            wnb.a(this.jdField_a_of_type_Wnb).setText(paramEditable.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wng
 * JD-Core Version:    0.7.0.1
 */