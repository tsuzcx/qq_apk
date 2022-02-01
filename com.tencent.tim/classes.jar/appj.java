import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.BaseApplication;

public class appj
  implements ausj.a
{
  public appj(VisitorTroopCardFragment paramVisitorTroopCardFragment, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (VisitorTroopCardFragment.a(this.this$0) == null) {
      VisitorTroopCardFragment.a(this.this$0, new arib(this.this$0.getActivity()));
    }
    paramView = (acms)this.this$0.app.getBusinessHandler(20);
    if ((aqiw.isNetSupport(this.this$0.app.getApp().getApplicationContext())) && (paramView != null))
    {
      VisitorTroopCardFragment.a(this.this$0).aq(0, 2131693294, 0);
      paramView.Fb(this.this$0.a.troopUin);
    }
    for (;;)
    {
      anot.a(this.this$0.app, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
      this.val$actionSheet.cancel();
      return;
      if (paramView != null) {
        VisitorTroopCardFragment.a(this.this$0).aq(2, 2131696348, 1500);
      } else {
        VisitorTroopCardFragment.a(this.this$0).aq(2, 2131693293, 1500);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     appj
 * JD-Core Version:    0.7.0.1
 */