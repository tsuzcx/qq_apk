import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.mobileqq.widget.QQToast;

class vah
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private int b;
  
  vah(vab paramvab) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    vab.a(this.jdField_a_of_type_Vab).a();
    if (paramEditable == null) {
      return;
    }
    vab.a(this.jdField_a_of_type_Vab).removeTextChangedListener(this);
    if (paramEditable.length() > vab.b(this.jdField_a_of_type_Vab))
    {
      QQToast.a(this.jdField_a_of_type_Vab.getContext(), anvx.a(2131701680) + vab.b(this.jdField_a_of_type_Vab) + anvx.a(2131701681), 0).a();
      paramEditable.delete(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
      vab.a(this.jdField_a_of_type_Vab).addTextChangedListener(this);
      return;
    }
    Object localObject1 = paramEditable.toString().substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
    int i = ((String)localObject1).indexOf('/');
    if ((i >= 0) && (i < ((String)localObject1).length() - 1))
    {
      localObject1 = new SpannableStringBuilder(paramEditable.toString());
      zvw.a(vab.a(this.jdField_a_of_type_Vab).getContext(), (SpannableStringBuilder)localObject1);
    }
    for (;;)
    {
      for (;;)
      {
        if (localObject1 != null) {
          i = vab.a(this.jdField_a_of_type_Vab).getSelectionEnd();
        }
        try
        {
          vab.a(this.jdField_a_of_type_Vab).setText((CharSequence)localObject1);
          vab.a(this.jdField_a_of_type_Vab).setSelection(i);
          this.b = 0;
          this.jdField_a_of_type_Int = 0;
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          for (;;)
          {
            vab.a(this.jdField_a_of_type_Vab).setText(paramEditable.toString());
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
 * Qualified Name:     vah
 * JD-Core Version:    0.7.0.1
 */