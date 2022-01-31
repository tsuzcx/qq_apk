import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

class tzx
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private int b;
  
  tzx(tzr paramtzr) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    ylp localylp = null;
    if (paramEditable == null) {
      return;
    }
    this.jdField_a_of_type_Tzr.a.removeTextChangedListener(this);
    String str = paramEditable.toString().substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
    int i = str.indexOf('/');
    Object localObject = localylp;
    if (i >= 0)
    {
      localObject = localylp;
      if (i < str.length() - 1)
      {
        localObject = new ylo(paramEditable.toString());
        localylp = new ylp();
        localylp.jdField_a_of_type_Float = ((int)(22.0D * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5D));
        localylp.jdField_a_of_type_Int = 0;
        localylp.jdField_a_of_type_JavaLangCharSequence = paramEditable.toString();
        yln.a(localylp, str, null, (ylo)localObject);
      }
    }
    if (localObject != null) {
      i = this.jdField_a_of_type_Tzr.a.getSelectionEnd();
    }
    try
    {
      this.jdField_a_of_type_Tzr.a.setText((CharSequence)localObject);
      this.jdField_a_of_type_Tzr.a.setSelection(i);
      this.b = 0;
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Tzr.a.addTextChangedListener(this);
      return;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      for (;;)
      {
        this.jdField_a_of_type_Tzr.a.setText(paramEditable.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tzx
 * JD-Core Version:    0.7.0.1
 */