import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.a;

public class yfb
  implements RobotPanelLayoutBase.a
{
  public yfb(TroopChatPie paramTroopChatPie) {}
  
  public void af(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.this$0.aWO.equals(paramString)))
    {
      TroopChatPie.b(this.this$0, true);
      paramString = (wxk)this.this$0.a(23);
      if (paramString != null) {
        paramString.l(true);
      }
    }
    do
    {
      return;
      TroopChatPie.b(this.this$0, false);
      paramString = (wxk)this.this$0.a(23);
    } while (paramString == null);
    paramString.l(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yfb
 * JD-Core Version:    0.7.0.1
 */