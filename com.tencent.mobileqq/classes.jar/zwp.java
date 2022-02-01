import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.qphone.base.util.QLog;

class zwp
  implements zwj
{
  zwp(zwk paramzwk) {}
  
  public void a()
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardClosed");
    if (zwk.a(this.a))
    {
      zwk.b(this.a, false);
      if (zwk.a(this.a) != null) {
        zwk.a(this.a).setVisibility(0);
      }
      if (zwk.a(this.a) != null) {
        zwk.a(this.a).setVisibility(0);
      }
    }
    for (;;)
    {
      zwk.a(this.a, false);
      return;
      this.a.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardOpened");
    if (zwk.a(this.a) != paramInt)
    {
      zwk.a(this.a, paramInt);
      zwk.a(this.a);
      zwk.a(this.a).putInt("GroupSoftKeyboardHeight", paramInt);
      zwk.a(this.a).commit();
    }
    this.a.c();
    zwk.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwp
 * JD-Core Version:    0.7.0.1
 */