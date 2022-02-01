import android.os.Message;
import com.tencent.mobileqq.activity.AssociatedAccountManageActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;
import mqq.os.MqqHandler;

public class ugq
  extends accn
{
  public ugq(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  protected void onSetSubaccountDisplayThirdQQ(boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = AssociatedAccountManageActivity.a(this.this$0).isChecked();
    AssociatedAccountManageActivity.a(this.this$0).removeMessages(8193);
    AssociatedAccountManageActivity.a(this.this$0).sendEmptyMessage(8194);
    Object localObject = AssociatedAccountManageActivity.a(this.this$0).obtainMessage(8195);
    int i;
    if (paramBoolean)
    {
      i = 2;
      ((Message)localObject).arg1 = i;
      if (!paramBoolean) {
        break label134;
      }
      if (!bool2) {
        break label128;
      }
      i = 2131701722;
    }
    for (;;)
    {
      ((Message)localObject).arg2 = i;
      AssociatedAccountManageActivity.a(this.this$0).sendMessage((Message)localObject);
      if (!paramBoolean) {
        break label151;
      }
      AssociatedAccountManageActivity.a(this.this$0);
      anxk.T(this.this$0.app, bool2);
      return;
      i = 1;
      break;
      label128:
      i = 2131701721;
      continue;
      label134:
      if (bool2) {
        i = 2131720553;
      } else {
        i = 2131720552;
      }
    }
    label151:
    localObject = this.this$0;
    if (!bool2) {}
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      AssociatedAccountManageActivity.a((AssociatedAccountManageActivity)localObject, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ugq
 * JD-Core Version:    0.7.0.1
 */