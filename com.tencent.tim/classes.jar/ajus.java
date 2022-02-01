import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV;

public class ajus
  implements View.OnKeyListener
{
  public ajus(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0)) {
      if (ChooseInterestTagActivity.a(this.this$0).getText() == null)
      {
        paramView = "";
        if (TextUtils.isEmpty(paramView))
        {
          ChooseInterestTagActivity.a(this.this$0).fullScroll(66);
          ChooseInterestTagActivity.a(this.this$0, ChooseInterestTagActivity.d(this.this$0) + 1);
        }
      }
    }
    for (;;)
    {
      return false;
      paramView = ChooseInterestTagActivity.a(this.this$0).getText().toString();
      break;
      if ((paramInt == 66) && (paramKeyEvent.getAction() == 0)) {
        aurd.hide(ChooseInterestTagActivity.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajus
 * JD-Core Version:    0.7.0.1
 */