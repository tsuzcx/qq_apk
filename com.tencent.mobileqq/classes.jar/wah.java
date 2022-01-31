import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.troop.widget.TroopAIORobotPanel.GetListDataCallback;

public class wah
  implements TroopAIORobotPanel.GetListDataCallback
{
  public wah(HotChatPie paramHotChatPie) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.f.equals(paramString)))
    {
      this.a.a.setChildVisible(27, 0);
      this.a.S = true;
      return;
    }
    this.a.a.setChildVisible(27, 8);
    this.a.S = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wah
 * JD-Core Version:    0.7.0.1
 */