import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.ListView;

public class wtb
  implements wvs
{
  private wtc a;
  private boolean bfS;
  private BaseChatPie f;
  
  public wtb(BaseChatPie paramBaseChatPie)
  {
    this.f = paramBaseChatPie;
  }
  
  private ListView b()
  {
    if ((this.f instanceof ybl)) {
      return ((ybl)this.f).b();
    }
    return this.f.b;
  }
  
  public int[] C()
  {
    return new int[] { 3, 7, 13, 19 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 3: 
    case 7: 
    case 19: 
      do
      {
        return;
        this.a = new wtc();
        return;
        this.bfS = true;
        this.a.a(this.f.app, b());
        return;
      } while (!this.bfS);
      this.a.b(this.f.app, b());
      return;
    }
    this.bfS = false;
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wtb
 * JD-Core Version:    0.7.0.1
 */