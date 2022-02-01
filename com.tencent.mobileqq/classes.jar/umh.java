import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.mobileqq.widget.QQToast;

class umh
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private int b;
  
  umh(umb paramumb) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    umb.a(this.jdField_a_of_type_Umb).a();
    if (paramEditable == null) {
      return;
    }
    umb.a(this.jdField_a_of_type_Umb).removeTextChangedListener(this);
    if (paramEditable.length() > umb.b(this.jdField_a_of_type_Umb))
    {
      QQToast.a(this.jdField_a_of_type_Umb.getContext(), amtj.a(2131701329) + umb.b(this.jdField_a_of_type_Umb) + amtj.a(2131701330), 0).a();
      paramEditable.delete(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
      umb.a(this.jdField_a_of_type_Umb).addTextChangedListener(this);
      return;
    }
    Object localObject1 = paramEditable.toString().substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
    int i = ((String)localObject1).indexOf('/');
    if ((i >= 0) && (i < ((String)localObject1).length() - 1))
    {
      localObject1 = new SpannableStringBuilder(paramEditable.toString());
      zgr.a(umb.a(this.jdField_a_of_type_Umb).getContext(), (SpannableStringBuilder)localObject1);
    }
    for (;;)
    {
      for (;;)
      {
        if (localObject1 != null) {
          i = umb.a(this.jdField_a_of_type_Umb).getSelectionEnd();
        }
        try
        {
          umb.a(this.jdField_a_of_type_Umb).setText((CharSequence)localObject1);
          umb.a(this.jdField_a_of_type_Umb).setSelection(i);
          this.b = 0;
          this.jdField_a_of_type_Int = 0;
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          for (;;)
          {
            umb.a(this.jdField_a_of_type_Umb).setText(paramEditable.toString());
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
 * Qualified Name:     umh
 * JD-Core Version:    0.7.0.1
 */