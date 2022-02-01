import android.widget.TextView;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.Switch;

public class vlc
  extends acnd
{
  public vlc(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void aP(boolean paramBoolean1, boolean paramBoolean2)
  {
    TextView localTextView;
    if (paramBoolean1)
    {
      this.this$0.aq.a().setChecked(paramBoolean2);
      localTextView = this.this$0.Ey;
      if (!paramBoolean2) {
        break label59;
      }
    }
    label59:
    for (int i = 2131694507;; i = 2131694508)
    {
      localTextView.setText(i);
      aqmj.l(this.this$0, this.this$0.app.getCurrentAccountUin(), paramBoolean2);
      return;
    }
  }
  
  protected void aQ(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (!paramBoolean1)
    {
      QQToast.a(this.this$0, 1, acfp.m(2131709427), 0).show();
      Switch localSwitch = this.this$0.aq.a();
      if (!paramBoolean2) {}
      for (paramBoolean1 = bool;; paramBoolean1 = false)
      {
        localSwitch.setChecked(paramBoolean1);
        return;
      }
    }
    aqmj.l(this.this$0, this.this$0.app.getCurrentAccountUin(), paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vlc
 * JD-Core Version:    0.7.0.1
 */