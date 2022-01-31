import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import com.tencent.biz.subscribe.comment.CommentEditText;

class wnj
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private int b;
  
  wnj(wne paramwne) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    wne.a(this.jdField_a_of_type_Wne).removeTextChangedListener(this);
    if (paramEditable.length() > wne.b(this.jdField_a_of_type_Wne))
    {
      bcpw.a(this.jdField_a_of_type_Wne.getContext(), ajyc.a(2131702172) + wne.b(this.jdField_a_of_type_Wne) + ajyc.a(2131702173), 0).a();
      paramEditable.delete(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
      wne.a(this.jdField_a_of_type_Wne).addTextChangedListener(this);
      return;
    }
    Object localObject1 = paramEditable.toString().substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
    int i = ((String)localObject1).indexOf('/');
    if ((i >= 0) && (i < ((String)localObject1).length() - 1))
    {
      localObject1 = new SpannableStringBuilder(paramEditable.toString());
      wok.a(wne.a(this.jdField_a_of_type_Wne).getContext(), (SpannableStringBuilder)localObject1);
    }
    for (;;)
    {
      for (;;)
      {
        if (localObject1 != null) {
          i = wne.a(this.jdField_a_of_type_Wne).getSelectionEnd();
        }
        try
        {
          wne.a(this.jdField_a_of_type_Wne).setText((CharSequence)localObject1);
          wne.a(this.jdField_a_of_type_Wne).setSelection(i);
          this.b = 0;
          this.jdField_a_of_type_Int = 0;
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          for (;;)
          {
            wne.a(this.jdField_a_of_type_Wne).setText(paramEditable.toString());
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
 * Qualified Name:     wnj
 * JD-Core Version:    0.7.0.1
 */