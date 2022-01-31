import android.widget.CompoundButton;
import com.tencent.mobileqq.activity.ShowReactiveActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

public class tpo
  extends CardObserver
{
  public tpo(ShowReactiveActivity paramShowReactiveActivity) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    Switch localSwitch;
    if ((paramBoolean1) && (!this.a.isFinishing()))
    {
      localObject = this.a;
      localSwitch = this.a.a.a();
      if (paramBoolean2) {
        break label117;
      }
    }
    label117:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      ShowReactiveActivity.a((ShowReactiveActivity)localObject, localSwitch, paramBoolean1);
      if (QLog.isColorLevel())
      {
        localObject = ((FriendsManager)this.a.app.getManager(50)).b(this.a.app.getCurrentAccountUin());
        QLog.d("interactive", 2, " ShowReactiveActivity onGetCalReactiveDays isAllow= " + paramBoolean2 + "card.allowCalInteractive=" + ((Card)localObject).allowCalInteractive);
      }
      return;
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    boolean bool2 = true;
    Object localObject1;
    Object localObject2;
    boolean bool1;
    if (!paramBoolean)
    {
      QQToast.a(this.a.app.getApp(), 1, this.a.getString(2131436049), 3000).b(this.a.getTitleBarHeight());
      localObject1 = this.a;
      localObject2 = this.a.a.a();
      if (this.a.a.a().isChecked()) {
        break label217;
      }
      bool1 = true;
      ShowReactiveActivity.a((ShowReactiveActivity)localObject1, (CompoundButton)localObject2, bool1);
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, "ShowReactiveActivity onSetCalReactiveDays isSuccess false= ");
      }
    }
    Switch localSwitch;
    if ((paramBoolean) && (!this.a.isFinishing()))
    {
      localObject1 = ((FriendsManager)this.a.app.getManager(50)).b(this.a.app.getCurrentAccountUin());
      localObject2 = this.a;
      localSwitch = this.a.a.a();
      if (((Card)localObject1).allowCalInteractive) {
        break label222;
      }
    }
    label217:
    label222:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ShowReactiveActivity.a((ShowReactiveActivity)localObject2, localSwitch, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, "ShowReactiveActivity onSetCalReactiveDays allowCalInteractive= " + ((Card)localObject1).allowCalInteractive);
      }
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tpo
 * JD-Core Version:    0.7.0.1
 */