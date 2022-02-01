import com.tencent.mobileqq.activity.contact.troop.BaseTroopView;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.a;

public class ywz
  implements TabBarView.a
{
  public ywz(TroopActivity paramTroopActivity) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (this.this$0.a != null) {
      this.this$0.a.cmm();
    }
    if (this.this$0.cbH != 2)
    {
      switch (paramInt2)
      {
      default: 
        anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_mygrp", 0, 0, "", "", "", "");
        anot.a(this.this$0.app, "CliOper", "", "", "0X8006620", "0X8006620", 0, 0, "", "", "", "");
        this.this$0.iMode = 0;
      }
      for (;;)
      {
        this.this$0.hG(this.this$0.iMode);
        this.this$0.b.sendEmptyMessage(1234);
        TroopActivity.a(this.this$0, paramInt2);
        return;
        anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_mygrp", 0, 0, "", "", "", "");
        anot.a(this.this$0.app, "CliOper", "", "", "0X8006620", "0X8006620", 0, 0, "", "", "", "");
        this.this$0.iMode = 0;
        continue;
        anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "discuss", "contact_discuss_tab", 0, 0, "", "", "", "");
        anot.a(this.this$0.app, "CliOper", "", "", "0X8006621", "0X8006621", 0, 0, "", "", "", "");
        this.this$0.iMode = 1;
      }
    }
    switch (paramInt2)
    {
    default: 
      if (!this.this$0.c.b(1).aGD()) {
        break;
      }
    }
    for (String str = "0";; str = "1")
    {
      anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_grpnotice", 0, 0, "", str, "", "");
      anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
      this.this$0.iMode = 1;
      break;
      if (this.this$0.c.b(1).aGD()) {}
      for (str = "0";; str = "1")
      {
        anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_grpnotice", 0, 0, "", str, "", "");
        anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
        this.this$0.iMode = 1;
        break;
      }
      if (this.this$0.c.b(0).aGD()) {}
      for (str = "0";; str = "1")
      {
        anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_grprecom", 0, 0, "", str, "", "");
        anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_recom", 0, 0, "", "", "", "");
        this.this$0.iMode = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ywz
 * JD-Core Version:    0.7.0.1
 */