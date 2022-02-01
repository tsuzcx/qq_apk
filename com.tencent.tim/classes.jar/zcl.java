import android.view.View;
import com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;

public class zcl
  implements ausj.a
{
  public zcl(ContactsTroopAdapter paramContactsTroopAdapter, boolean paramBoolean, TroopInfo paramTroopInfo, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!aqiw.isNetworkAvailable(this.this$0.mContext)) {
      QQToast.a(this.this$0.mContext, 1, 2131693404, 0).show();
    }
    for (;;)
    {
      this.val$sheet.superDismiss();
      return;
      paramView = (accc)this.this$0.mApp.getBusinessHandler(22);
      if (this.bqH)
      {
        paramView.N(this.c.troopcode, 1);
        anot.a(this.this$0.mApp, "dc00898", "", "", "0X800808D", "0X800808D", 0, 0, "", "", "", "");
      }
      else
      {
        paramView.N(this.c.troopcode, 0);
        anot.a(this.this$0.mApp, "dc00898", "", "", "0X800808C", "0X800808C", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zcl
 * JD-Core Version:    0.7.0.1
 */