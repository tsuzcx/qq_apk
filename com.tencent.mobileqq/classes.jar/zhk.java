import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.qphone.base.util.QLog;

class zhk
  implements zhe
{
  zhk(zhf paramzhf) {}
  
  public void a()
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardClosed");
    if (zhf.a(this.a))
    {
      zhf.b(this.a, false);
      if (zhf.a(this.a) != null) {
        zhf.a(this.a).setVisibility(0);
      }
      if (zhf.a(this.a) != null) {
        zhf.a(this.a).setVisibility(0);
      }
    }
    for (;;)
    {
      zhf.a(this.a, false);
      return;
      this.a.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardOpened");
    if (zhf.a(this.a) != paramInt)
    {
      zhf.a(this.a, paramInt);
      zhf.a(this.a);
      zhf.a(this.a).putInt("GroupSoftKeyboardHeight", paramInt);
      zhf.a(this.a).commit();
    }
    this.a.c();
    zhf.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zhk
 * JD-Core Version:    0.7.0.1
 */