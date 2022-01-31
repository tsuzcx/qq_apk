import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.troop.widget.TroopAIORobotPanel.GetListDataCallback;

public class wbb
  implements TroopAIORobotPanel.GetListDataCallback
{
  public wbb(TroopChatPie paramTroopChatPie) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.f.equals(paramString)))
    {
      TroopChatPie.a(this.a, true);
      return;
    }
    TroopChatPie.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wbb
 * JD-Core Version:    0.7.0.1
 */