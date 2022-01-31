import android.text.Editable;
import android.text.TextWatcher;

public class xez
  implements TextWatcher
{
  public xez(xex paramxex) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    String str = xmt.a(paramEditable.toString(), 30);
    if (str.length() < paramEditable.length()) {
      paramEditable.replace(0, paramEditable.length(), str);
    }
    this.a.jdField_a_of_type_JavaLangString = paramEditable.toString();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = paramCharSequence.toString();
    this.a.jdField_a_of_type_JavaLangString = paramCharSequence;
    wsv.b("Q.qqstory.record.label.QQStoryAddVideoLabelView", "keyword = " + this.a.jdField_a_of_type_JavaLangString);
    if (this.a.jdField_a_of_type_Xfa != null) {
      this.a.jdField_a_of_type_Xfa.a(this.a.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xez
 * JD-Core Version:    0.7.0.1
 */