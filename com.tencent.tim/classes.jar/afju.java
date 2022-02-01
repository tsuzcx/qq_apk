import android.os.Bundle;
import com.tencent.mobileqq.bubble.BubbleDiyEntity;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emosm.web.MessengerService.a;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class afju
  implements acci
{
  public afju(MessengerService.a parama, Bundle paramBundle1, MessengerService paramMessengerService, Bundle paramBundle2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null)) {}
    try
    {
      if ((paramObject instanceof List))
      {
        paramObject = (List)paramObject;
        if (!paramObject.isEmpty())
        {
          this.aG.putString("diyText", ((BubbleDiyEntity)paramObject.get(0)).diyText);
          this.aG.putString("isDiy", "1");
          this.aG.putString("tl", ((BubbleDiyEntity)paramObject.get(0)).topLeftId);
          this.aG.putString("tr", ((BubbleDiyEntity)paramObject.get(0)).topRightId);
          this.aG.putString("bl", ((BubbleDiyEntity)paramObject.get(0)).bottomLeftId);
          this.aG.putString("br", ((BubbleDiyEntity)paramObject.get(0)).bottomRightId);
        }
      }
      for (;;)
      {
        this.val$service.cp(this.val$reqbundle);
        return;
        this.aG.putString("diyText", "");
      }
      return;
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.emoji.web.MessengerService", 2, paramObject.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afju
 * JD-Core Version:    0.7.0.1
 */