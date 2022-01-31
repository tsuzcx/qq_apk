import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import com.tencent.biz.subscribe.comment.CommentEditText;

class vzx
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private int b;
  
  vzx(vzs paramvzs) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    vzs.a(this.jdField_a_of_type_Vzs).removeTextChangedListener(this);
    if (paramEditable.length() > vzs.b(this.jdField_a_of_type_Vzs))
    {
      bbmy.a(this.jdField_a_of_type_Vzs.getContext(), ajjy.a(2131636388) + vzs.b(this.jdField_a_of_type_Vzs) + ajjy.a(2131636389), 0).a();
      paramEditable.delete(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
      vzs.a(this.jdField_a_of_type_Vzs).addTextChangedListener(this);
      return;
    }
    Object localObject1 = paramEditable.toString().substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
    int i = ((String)localObject1).indexOf('/');
    if ((i >= 0) && (i < ((String)localObject1).length() - 1))
    {
      localObject1 = new SpannableStringBuilder(paramEditable.toString());
      wax.a(vzs.a(this.jdField_a_of_type_Vzs).getContext(), (SpannableStringBuilder)localObject1);
    }
    for (;;)
    {
      for (;;)
      {
        if (localObject1 != null) {
          i = vzs.a(this.jdField_a_of_type_Vzs).getSelectionEnd();
        }
        try
        {
          vzs.a(this.jdField_a_of_type_Vzs).setText((CharSequence)localObject1);
          vzs.a(this.jdField_a_of_type_Vzs).setSelection(i);
          this.b = 0;
          this.jdField_a_of_type_Int = 0;
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          for (;;)
          {
            vzs.a(this.jdField_a_of_type_Vzs).setText(paramEditable.toString());
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
 * Qualified Name:     vzx
 * JD-Core Version:    0.7.0.1
 */