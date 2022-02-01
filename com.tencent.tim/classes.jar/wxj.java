import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.1;
import com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper.2;
import com.tencent.mobileqq.app.ThreadManager;

public class wxj
  implements wvs
{
  private BaseChatPie a;
  
  public wxj(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private void cdc()
  {
    if ((this.a != null) && (this.a.Pf()) && (this.a.getCurType() == 1)) {
      ThreadManager.post(new TroopNotificationAIOHelper.1(this), 8, null, true);
    }
  }
  
  private void cdd()
  {
    if ((this.a != null) && (this.a.getCurType() == 1)) {
      ThreadManager.post(new TroopNotificationAIOHelper.2(this), 8, null, true);
    }
  }
  
  public int[] C()
  {
    return new int[] { 5, 10 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 5: 
      cdc();
      return;
    }
    cdd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wxj
 * JD-Core Version:    0.7.0.1
 */