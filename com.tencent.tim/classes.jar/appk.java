import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class appk
  implements ausj.a
{
  public appk(VisitorTroopCardFragment paramVisitorTroopCardFragment, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (VisitorTroopCardFragment.a(this.this$0) == null) {
      VisitorTroopCardFragment.a(this.this$0, new arib(this.this$0.getActivity()));
    }
    if (aqiw.isNetSupport(this.this$0.getActivity()))
    {
      paramView = (acms)this.this$0.app.getBusinessHandler(20);
      if (paramView != null)
      {
        if ((VisitorTroopCardFragment.b(this.this$0) & 0x1) == 0)
        {
          VisitorTroopCardFragment.a(this.this$0, VisitorTroopCardFragment.b(this.this$0) | 0x1);
          paramView.Fc(this.this$0.a.troopUin);
        }
        VisitorTroopCardFragment.a(this.this$0).aq(0, 2131693298, 1000);
      }
    }
    for (;;)
    {
      apqe.I(21, new Object());
      this.val$actionSheet.cancel();
      return;
      VisitorTroopCardFragment.a(this.this$0).aq(2, 2131693293, 1500);
      continue;
      VisitorTroopCardFragment.a(this.this$0).aq(2, 2131696348, 1500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     appk
 * JD-Core Version:    0.7.0.1
 */