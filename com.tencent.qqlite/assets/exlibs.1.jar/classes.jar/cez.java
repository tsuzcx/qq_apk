import com.tencent.mobileqq.activity.contact.troop.BaseTroopView;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.util.WeakReferenceHandler;

public class cez
  implements TabBarView.OnTabChangeListener
{
  public cez(TroopActivity paramTroopActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (TroopActivity.a(this.a) != null) {
      TroopActivity.a(this.a).c();
    }
    if (this.a.j != 2)
    {
      switch (paramInt2)
      {
      default: 
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_mygrp", 0, 0, "", "", "", "");
        this.a.i = 0;
      }
      for (;;)
      {
        this.a.a(this.a.i);
        TroopActivity.a(this.a).sendEmptyMessage(1234);
        return;
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_mygrp", 0, 0, "", "", "", "");
        this.a.i = 0;
        continue;
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "discuss", "contact_discuss_tab", 0, 0, "", "", "", "");
        this.a.i = 1;
      }
    }
    switch (paramInt2)
    {
    default: 
      if (!TroopActivity.a(this.a).a(0).a()) {
        break;
      }
    }
    for (String str = "0";; str = "1")
    {
      ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_grpnotice", 0, 0, "", str, "", "");
      ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
      this.a.i = 0;
      break;
      if (TroopActivity.a(this.a).a(0).a()) {}
      for (str = "0";; str = "1")
      {
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_grpnotice", 0, 0, "", str, "", "");
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
        this.a.i = 0;
        break;
      }
      if (TroopActivity.a(this.a).a(1).a()) {}
      for (str = "0";; str = "1")
      {
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_grprecom", 0, 0, "", str, "", "");
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_recom", 0, 0, "", "", "", "");
        this.a.i = 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cez
 * JD-Core Version:    0.7.0.1
 */