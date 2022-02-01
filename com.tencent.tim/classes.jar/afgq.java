import android.os.Handler;
import android.os.Message;
import java.util.List;

class afgq
  extends aceg
{
  afgq(afgn paramafgn) {}
  
  public void EL(boolean paramBoolean)
  {
    afgn.a(this.this$0).clear();
  }
  
  protected void ag(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Integer)) && (afgn.a(this.this$0) != null)) {
      afgn.a(this.this$0).obtainMessage(208, paramObject).sendToTarget();
    }
    if ((this.this$0.b != null) && (paramBoolean)) {
      this.this$0.b.bYN();
    }
  }
  
  protected void x(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.this$0.b != null)) {
      this.this$0.b.bYN();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afgq
 * JD-Core Version:    0.7.0.1
 */