import android.view.View;
import com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;

public class zcm
  implements ausj.a
{
  public zcm(ContactsTroopAdapter paramContactsTroopAdapter, acdt paramacdt, DiscussionInfo paramDiscussionInfo, boolean paramBoolean, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.c;
    Object localObject = this.b;
    boolean bool;
    if (!this.bqI)
    {
      bool = true;
      paramView.a((DiscussionInfo)localObject, bool);
      this.val$sheet.superDismiss();
      if (!this.bqI) {
        break label154;
      }
      paramInt = 1;
      label43:
      paramView = this.b.uin;
      ((accc)this.this$0.mApp.getBusinessHandler(22)).notifyUI(18, true, new Object[] { paramView, Integer.valueOf(paramInt), Integer.valueOf(0), null });
      localObject = new anov(this.this$0.mApp).a("dc00899").b("Grp_Dis_set").c("Grp_contactlist");
      if (!this.bqI) {
        break label159;
      }
    }
    label154:
    label159:
    for (paramView = "Clk_unstick";; paramView = "Clk_stick")
    {
      ((anov)localObject).d(paramView).report();
      return;
      bool = false;
      break;
      paramInt = 0;
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zcm
 * JD-Core Version:    0.7.0.1
 */