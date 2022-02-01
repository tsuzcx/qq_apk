import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.FormSimpleItem;
import cooperation.troop.TroopPluginManager.a;

public class uqr
  implements TroopPluginManager.a
{
  public uqr(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onInstallFinish(int paramInt)
  {
    int i = 0;
    boolean bool;
    Object localObject;
    if (paramInt == 0)
    {
      this.this$0.aUn = true;
      bool = this.this$0.a.isOwnerOrAdim();
      localObject = this.this$0.p[5];
      if (localObject != null) {
        if (!bool) {
          break label88;
        }
      }
    }
    label88:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      localObject = (FormSimpleItem)this.this$0.p[6];
      if (localObject != null)
      {
        paramInt = i;
        if (bool) {
          paramInt = 3;
        }
        ((FormSimpleItem)localObject).setBgType(paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uqr
 * JD-Core Version:    0.7.0.1
 */