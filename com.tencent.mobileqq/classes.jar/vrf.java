import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel;
import com.tencent.mobileqq.werewolves.WerewolvesPluginInterface;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.HashMap;

public class vrf
  implements View.OnClickListener
{
  public vrf(GameRoomChatPie paramGameRoomChatPie) {}
  
  public void onClick(View paramView)
  {
    HashMap localHashMap1 = this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a().b();
    HashMap localHashMap2 = this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a().a();
    if (paramView == this.a.n) {
      if (this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() != 0)
      {
        if (localHashMap1 != null) {
          this.a.n.setImageDrawable((Drawable)localHashMap1.get("audioIcon"));
        }
        this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
        GameRoomChatPie.a(this.a).setVisibility(0);
        this.a.j.setVisibility(4);
        GameRoomChatPie.a(this.a).a(25);
        if ((this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel != null) && (localHashMap2 != null)) {
          this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.setBackgroundColor(((Integer)localHashMap2.get("quickWordBgColor")).intValue());
        }
      }
    }
    while (paramView != this.a.o)
    {
      return;
      if (localHashMap1 != null) {
        this.a.n.setImageDrawable((Drawable)localHashMap1.get("textIcon"));
      }
      this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(4);
      GameRoomChatPie.b(this.a).setVisibility(4);
      this.a.j.setVisibility(0);
      this.a.ay();
      return;
    }
    if (GameRoomChatPie.b(this.a).a() != 3)
    {
      this.a.a(Integer.valueOf(3));
      if (localHashMap1 != null) {
        this.a.n.setImageDrawable((Drawable)localHashMap1.get("audioIcon"));
      }
      this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
      GameRoomChatPie.c(this.a).setVisibility(0);
      this.a.j.setVisibility(4);
      return;
    }
    this.a.ay();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vrf
 * JD-Core Version:    0.7.0.1
 */