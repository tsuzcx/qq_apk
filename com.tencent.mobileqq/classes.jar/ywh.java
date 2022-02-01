import android.text.Editable;
import android.text.TextWatcher;

public class ywh
  implements TextWatcher
{
  public ywh(ywf paramywf) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    String str = zdx.a(paramEditable.toString(), 30);
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
    ykq.b("Q.qqstory.record.label.QQStoryAddVideoLabelView", "keyword = " + this.a.jdField_a_of_type_JavaLangString);
    if (this.a.jdField_a_of_type_Ywi != null) {
      this.a.jdField_a_of_type_Ywi.a(this.a.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywh
 * JD-Core Version:    0.7.0.1
 */