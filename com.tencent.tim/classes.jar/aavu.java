import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.selectable.ChatSelCurPageForLSSHelper.1;
import com.tencent.mobileqq.bubble.ChatXListView;

public class aavu
{
  private BaseChatPie a;
  private boolean bAy;
  private Runnable fl = new ChatSelCurPageForLSSHelper.1(this);
  
  public aavu(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public void czK()
  {
    this.bAy = true;
  }
  
  public void czL()
  {
    if (!this.bAy) {}
    do
    {
      return;
      this.bAy = false;
    } while ((this.a == null) || (this.a.b == null) || (this.a.a == null));
    this.a.b.removeCallbacks(this.fl);
    this.a.b.post(this.fl);
  }
  
  public void onDestroy()
  {
    if ((this.a != null) && (this.a.b != null)) {
      this.a.b.removeCallbacks(this.fl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aavu
 * JD-Core Version:    0.7.0.1
 */