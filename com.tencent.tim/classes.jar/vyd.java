import android.content.Intent;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;

public class vyd
  implements auuw.b
{
  public vyd(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void a(auuw.a parama)
  {
    boolean bool = false;
    switch (parama.id)
    {
    default: 
      return;
    case 0: 
      parama = this.this$0;
      if (!this.this$0.baV) {
        bool = true;
      }
      parama.baV = bool;
      aizp.a().f(this.this$0.app, this.this$0.baV);
      return;
    }
    parama = new Intent(this.this$0, TroopAssisSettingActivity.class);
    parama.setFlags(67108864);
    this.this$0.startActivity(parama);
    anot.a(this.this$0.app, "P_CliOper", "Grp_msg", "", "help_list", "Clk_set", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vyd
 * JD-Core Version:    0.7.0.1
 */