import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;

public class zi
  implements View.OnFocusChangeListener
{
  public zi(BaseChatPie paramBaseChatPie) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && (BaseChatPie.a(this.a) != null) && (BaseChatPie.a(this.a).getVisibility() == 0)) {
      BaseChatPie.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     zi
 * JD-Core Version:    0.7.0.1
 */