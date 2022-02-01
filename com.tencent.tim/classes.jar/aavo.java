import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;

public class aavo
  extends aavv
{
  protected final BaseChatPie f;
  
  public aavo(BaseChatPie paramBaseChatPie)
  {
    this.f = paramBaseChatPie;
  }
  
  void a(aqoa paramaqoa, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramaqoa != null) && (paramaqoa.size() > 0))
    {
      if (this.f == null) {
        break label43;
      }
      if (this.f.vn() < 8) {
        a(paramView, paramInt1, paramInt2, paramaqoa, paramInt3, false);
      }
    }
    return;
    label43:
    a(paramView, paramInt1, paramInt2, paramaqoa, paramInt3, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aavo
 * JD-Core Version:    0.7.0.1
 */