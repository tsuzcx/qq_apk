import android.content.Intent;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class yxb
  implements auuw.b
{
  public yxb(TroopActivity paramTroopActivity) {}
  
  public void a(auuw.a parama)
  {
    switch (parama.id)
    {
    default: 
    case 0: 
      do
      {
        return;
        anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_create", 0, 0, "", "", "", "");
        anot.a(this.this$0.app, "CliOper", "", "", "0X8006622", "0X8006622", 0, 0, "", "", "", "");
        parama = (apbc)this.this$0.app.getManager(32);
      } while (parama == null);
      parama.d(this.this$0, 0);
      return;
    case 1: 
      anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_join", 0, 0, "", "", "", "");
      anot.a(this.this$0.app, "CliOper", "", "", "Grp", "grplist_plus_join", 47, 0, "", "", "", "");
      AddContactsActivity.m(this.this$0, 1);
      return;
    case 2: 
      anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_msgset", 0, 0, "", "", "", "");
      anot.a(this.this$0.app, "CliOper", "", "", "Grp", "grplist_plus_setting", 0, 0, "", "", "", "");
      parama = new Intent(this.this$0, TroopAssisSettingActivity.class);
      this.this$0.startActivity(parama);
      return;
    }
    TroopActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yxb
 * JD-Core Version:    0.7.0.1
 */