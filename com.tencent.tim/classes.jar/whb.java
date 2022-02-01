import android.content.res.Resources;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivatePageAdapter;
import com.tencent.mobileqq.widget.QQToast;

public class whb
  extends accn
{
  public whb(ActivateFriendActivity paramActivateFriendActivity) {}
  
  protected void onGetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((ActivateFriendActivity.a(this.this$0) != paramBoolean2) && (paramBoolean2 == true))
    {
      acoe.a(this.this$0.app, false, true, false, true);
      this.this$0.bYa();
    }
    ActivateFriendActivity.a(this.this$0, paramBoolean2);
  }
  
  protected void onSetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((ActivateFriendActivity.a(this.this$0) != paramBoolean2) && (paramBoolean2 == true))
    {
      acoe.a(this.this$0.app, false, true, false, true);
      this.this$0.bYa();
    }
    if (!this.this$0.isFinishing())
    {
      if (!paramBoolean1) {
        break label161;
      }
      ActivateFriendActivity.a(this.this$0, paramBoolean2);
      if (!ActivateFriendActivity.a(this.this$0)) {
        break label148;
      }
    }
    label148:
    for (String str = this.this$0.getString(2131689676);; str = this.this$0.getString(2131689677))
    {
      str = this.this$0.getString(2131689679, new Object[] { str });
      QQToast.a(this.this$0, 2, str, 0).show(this.this$0.getTitleBarHeight());
      if (ActivateFriendActivity.a(this.this$0) != null)
      {
        ActivateFriendActivity.a(this.this$0).bYe();
        ActivateFriendActivity.b(this.this$0);
      }
      return;
    }
    label161:
    QQToast.a(this.this$0, 1, this.this$0.getResources().getString(2131719890), 0).show(this.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     whb
 * JD-Core Version:    0.7.0.1
 */