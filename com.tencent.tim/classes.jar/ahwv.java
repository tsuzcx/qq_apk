import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XEditTextEx.f;

public class ahwv
  implements wvs
{
  private XEditTextEx.f b = new ahww(this);
  public boolean ciK;
  private final BaseChatPie f;
  
  public ahwv(BaseChatPie paramBaseChatPie)
  {
    this.f = paramBaseChatPie;
  }
  
  public static ahwv a(BaseChatPie paramBaseChatPie)
  {
    return (ahwv)paramBaseChatPie.a(6);
  }
  
  private void c(XEditTextEx paramXEditTextEx)
  {
    try
    {
      paramXEditTextEx.b(this.b);
      return;
    }
    catch (Throwable paramXEditTextEx) {}
  }
  
  public int[] C()
  {
    return new int[] { 3, 13, 5 };
  }
  
  public void Ck(int paramInt)
  {
    if (paramInt == 3) {
      b(this.f.a);
    }
    do
    {
      return;
      if (paramInt == 13)
      {
        c(this.f.a);
        return;
      }
    } while (paramInt != 5);
    ausb.a(this.f.app).f(this.f.sessionInfo);
  }
  
  public void Pu(int paramInt)
  {
    if (paramInt >= 30) {
      this.ciK = true;
    }
  }
  
  public void b(XEditTextEx paramXEditTextEx)
  {
    try
    {
      paramXEditTextEx.a(this.b);
      return;
    }
    catch (Throwable paramXEditTextEx)
    {
      paramXEditTextEx.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahwv
 * JD-Core Version:    0.7.0.1
 */