import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberInnerFrame;
import java.util.ArrayList;

public class eve
  implements View.OnKeyListener
{
  public eve(SelectMemberActivity paramSelectMemberActivity) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0))
    {
      SelectMemberActivity.a(this.a).requestFocus();
      if ((SelectMemberActivity.a(this.a).getText().toString().equals("")) && (this.a.c.size() != 0))
      {
        paramView = ((SelectMemberActivity.ResultRecord)this.a.c.get(this.a.c.size() - 1)).a;
        if (this.a.a(paramView))
        {
          this.a.a(paramView);
          this.a.d();
          paramInt = this.a.a.a();
          if ((paramInt == 8) || (paramInt == 9) || (paramInt == 6) || (paramInt == 5)) {
            ((SelectMemberInnerFrame)this.a.a.getCurrentView()).f();
          }
          this.a.a(false);
        }
      }
    }
    while ((paramInt != 4) || (!SelectMemberActivity.a(this.a).getText().toString().trim().equals(""))) {
      return false;
    }
    this.a.i();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eve
 * JD-Core Version:    0.7.0.1
 */