import android.os.Bundle;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.widget.QQToast;

class yjy
  extends aeaz.b
{
  yjy(yju paramyju) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    if (paramBoolean)
    {
      QQToast.a(yju.a(this.this$0).a(), 2, 2131721575, 0).show();
      return;
    }
    QQToast.a(yju.a(this.this$0).a(), 0, 2131721574, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yjy
 * JD-Core Version:    0.7.0.1
 */