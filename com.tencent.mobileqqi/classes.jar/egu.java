import com.tencent.mobileqq.activity.contact.troop.TroopView;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.ArrayList;

public class egu
  extends TroopObserver
{
  private egu(TroopView paramTroopView) {}
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    if (paramInt == 6) {
      if (paramByte == 0) {
        this.a.a();
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt != 2) {
          break;
        }
      } while (paramByte != 0);
      this.a.a();
      return;
    } while ((paramInt != 9) || (paramByte != 0));
    this.a.a();
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      TroopView.a(this.a);
    }
    if (this.a.c)
    {
      this.a.c = false;
      if (!paramBoolean) {
        break label79;
      }
      TroopView.a(this.a).a(0);
      this.a.a(101, 800L);
    }
    for (;;)
    {
      this.a.a.postDelayed(new egv(this), 1200L);
      return;
      label79:
      this.a.a.B();
      this.a.b(2131562097);
    }
  }
  
  protected void b(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
  
  protected void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     egu
 * JD-Core Version:    0.7.0.1
 */