import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager.MagicfaceSensorOperation;
import com.tencent.mobileqq.statistics.ReportController;

public class gak
  implements MagicfaceActionManager.MagicfaceSensorOperation
{
  public gak(MagicfaceActionManager paramMagicfaceActionManager) {}
  
  public void a()
  {
    if (this.a.c == 1)
    {
      ReportController.b(MagicfaceActionManager.a(this.a).b, "CliOper", "", "", "MbJieshou", "MbWanchengXiaochu", 0, 0, MagicfaceActionManager.a(this.a).epId, "", "", "");
      return;
    }
    MagicfaceActionManager.a(this.a, System.currentTimeMillis());
    ReportController.b(MagicfaceActionManager.a(this.a).b, "CliOper", "", "", "MbFasong", "MbZhudongChaozuo", 0, 0, MagicfaceActionManager.a(this.a).epId, "", "", "");
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gak
 * JD-Core Version:    0.7.0.1
 */