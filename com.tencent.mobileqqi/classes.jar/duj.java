import android.os.Handler;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.managers.TroopAssistantManager;

public class duj
  extends TroopObserver
{
  public duj(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    if (paramInt == 6) {
      if (paramByte == 0) {
        this.a.a.sendEmptyMessage(1);
      }
    }
    while ((paramInt != 2) || (paramByte != 0)) {
      return;
    }
    TroopAssistantManager.a().b(paramString, this.a.b);
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     duj
 * JD-Core Version:    0.7.0.1
 */