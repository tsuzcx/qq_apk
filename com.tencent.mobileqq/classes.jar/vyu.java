import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.nearby.gameroom.GameRoomAVController;
import com.tencent.mobileqq.werewolves.WerewolvesPluginInterface;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;

public class vyu
  implements View.OnTouchListener
{
  public vyu(GameRoomChatPie paramGameRoomChatPie) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    paramView = this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (i == 0) {
      if ((paramView != null) && (paramView.d()))
      {
        this.a.j.setText("正在发言");
        this.a.j.setPressed(true);
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.b();
        paramView.a(true);
      }
    }
    do
    {
      return true;
      this.a.o(false);
      return true;
      if ((i != 3) && (i != 1)) {
        break;
      }
      this.a.j.setText("按住发言");
      this.a.j.setPressed(false);
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.c();
    } while (paramView == null);
    paramView.a(false);
    return true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vyu
 * JD-Core Version:    0.7.0.1
 */