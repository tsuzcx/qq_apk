import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import mqq.os.MqqHandler;

public class ttc
  extends TroopObserver
{
  public ttc(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6) {
      if (paramInt2 == 0) {
        this.a.a.sendEmptyMessage(1);
      }
    }
    while ((paramInt1 != 2) || (paramInt2 != 0)) {
      return;
    }
    TroopAssistantManager.a().b(paramString, this.a.app);
    this.a.c();
  }
  
  protected void b(String paramString)
  {
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ttc
 * JD-Core Version:    0.7.0.1
 */