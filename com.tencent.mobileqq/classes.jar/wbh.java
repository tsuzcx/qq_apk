import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.troop.logic.HomeworkTroopController;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.HWTroopUtils.OnHomeworkTroopIdentityCheckListener;

public class wbh
  implements HWTroopUtils.OnHomeworkTroopIdentityCheckListener
{
  public wbh(TroopChatPie paramTroopChatPie) {}
  
  public void a(int paramInt)
  {
    if (!HWTroopUtils.a(paramInt)) {
      this.a.bq();
    }
    if (this.a.a != null) {
      this.a.a.c(HWTroopUtils.b(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wbh
 * JD-Core Version:    0.7.0.1
 */