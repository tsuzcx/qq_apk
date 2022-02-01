import android.view.View;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import cooperation.troop.TroopPluginManager.a;

public class arhj
  implements TroopPluginManager.a
{
  public arhj(ProfileCardMoreInfoView paramProfileCardMoreInfoView) {}
  
  public void onInstallFinish(int paramInt)
  {
    if (paramInt == 0)
    {
      this.this$0.isPluginInstalled = true;
      View localView = this.this$0.k("map_key_troop_mem_recent_said");
      if (localView != null) {
        ProfileCardMoreInfoView.b(localView, this.this$0.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arhj
 * JD-Core Version:    0.7.0.1
 */