import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.qphone.base.util.QLog;

class vil
  implements aagf
{
  vil(vih paramvih) {}
  
  public void a()
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardClosed");
    if (vih.a(this.a))
    {
      vih.a(this.a, false);
      if (vih.a(this.a) != null) {
        vih.a(this.a).setVisibility(0);
      }
      if (vih.a(this.a) != null) {
        vih.a(this.a).setVisibility(0);
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
      vih.c(this.a);
      this.a.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("GroupSoftKeyboardHeight", paramInt);
      this.a.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
    }
    this.a.e();
    this.a.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vil
 * JD-Core Version:    0.7.0.1
 */