import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.qphone.base.util.QLog;

class vkp
  implements aakg
{
  vkp(vkl paramvkl) {}
  
  public void a()
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardClosed");
    if (vkl.a(this.a))
    {
      vkl.a(this.a, false);
      if (vkl.a(this.a) != null) {
        vkl.a(this.a).setVisibility(0);
      }
      if (vkl.a(this.a) != null) {
        vkl.a(this.a).setVisibility(0);
      }
    }
    for (;;)
    {
      this.a.b = false;
      return;
      if (!this.a.c) {
        this.a.dismiss();
      }
    }
  }
  
  public void a(int paramInt)
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardOpened");
    if (this.a.jdField_a_of_type_Int != paramInt)
    {
      this.a.jdField_a_of_type_Int = paramInt;
      vkl.c(this.a);
      this.a.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("GroupSoftKeyboardHeight", paramInt);
      this.a.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
    }
    this.a.e();
    this.a.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vkp
 * JD-Core Version:    0.7.0.1
 */