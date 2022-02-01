import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

class zwr
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private int b;
  
  zwr(zwk paramzwk) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    aadd localaadd = null;
    if (paramEditable == null) {
      return;
    }
    this.jdField_a_of_type_Zwk.a.removeTextChangedListener(this);
    String str = paramEditable.toString().substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
    int i = str.indexOf('/');
    Object localObject = localaadd;
    if (i >= 0)
    {
      localObject = localaadd;
      if (i < str.length() - 1)
      {
        localObject = new aadc(paramEditable.toString());
        localaadd = new aadd();
        localaadd.jdField_a_of_type_Float = ((int)(22.0D * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5D));
        localaadd.jdField_a_of_type_Int = 0;
        localaadd.jdField_a_of_type_JavaLangCharSequence = paramEditable.toString();
        aadb.a(localaadd, str, null, (aadc)localObject, null, false);
      }
    }
    if (localObject != null) {
      i = this.jdField_a_of_type_Zwk.a.getSelectionEnd();
    }
    try
    {
      this.jdField_a_of_type_Zwk.a.setText((CharSequence)localObject);
      this.jdField_a_of_type_Zwk.a.setSelection(i);
      this.b = 0;
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Zwk.a.addTextChangedListener(this);
      return;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      for (;;)
      {
        this.jdField_a_of_type_Zwk.a.setText(paramEditable.toString());
        i = paramEditable.toString().length();
      }
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
 * Qualified Name:     zwr
 * JD-Core Version:    0.7.0.1
 */