import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ClipboardEditText;

class xbj
  implements TextWatcher
{
  xbj(xbi paramxbi) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.a.jdField_a_of_type_Xbm != null)
    {
      this.a.jdField_a_of_type_Xah.a = paramEditable.toString();
      this.a.jdField_a_of_type_Xbm.a(this.a.jdField_a_of_type_Xah);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_Xbm == null) {}
    do
    {
      do
      {
        return;
      } while (this.a.a(paramCharSequence.toString()) <= 420);
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setText(paramCharSequence.subSequence(0, paramInt1));
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setSelection(paramInt1);
    } while (this.a.jdField_a_of_type_Xbm == null);
    this.a.jdField_a_of_type_Xbm.b(420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xbj
 * JD-Core Version:    0.7.0.1
 */