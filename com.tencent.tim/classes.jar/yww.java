import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class yww
  implements View.OnClickListener
{
  public yww(TroopActivity paramTroopActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    switch (paramView.getId())
    {
    default: 
      this.this$0.cmC();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.this$0.hi != null)
      {
        Intent localIntent = new Intent();
        if (!this.this$0.hi.isEmpty()) {
          bool = true;
        }
        localIntent.putExtra("isDataChanged", bool);
        this.this$0.setResult(-1, localIntent);
      }
      this.this$0.onBackPressed();
      continue;
      anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right", 0, 0, "", "", "", "");
      if (this.this$0.isPopupShowing())
      {
        this.this$0.cmC();
      }
      else
      {
        anot.a(this.this$0.app, "CliOper", "", "", "Grp", "Clk_grplist_plus", 0, 0, "", "", "", "");
        this.this$0.showPopup();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yww
 * JD-Core Version:    0.7.0.1
 */