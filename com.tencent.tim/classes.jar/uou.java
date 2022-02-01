import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.ChatHistoryViewBase.1;

public abstract class uou
{
  public ChatHistoryFileActivity a;
  public boolean aQ = true;
  
  public void At(int paramInt) {}
  
  protected boolean H()
  {
    return this.aQ;
  }
  
  public abstract View aI();
  
  protected void aM()
  {
    this.aQ = false;
    new Handler().postDelayed(new ChatHistoryViewBase.1(this), 1500L);
  }
  
  public abstract boolean bC();
  
  public void bJW() {}
  
  public void bJX() {}
  
  public abstract void bJY();
  
  public abstract void bJZ();
  
  public void cg() {}
  
  public void fG(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uou
 * JD-Core Version:    0.7.0.1
 */