import android.os.Message;
import com.tencent.mobileqq.profile.like.PraiseManager.a;
import mqq.os.MqqHandler;

class afcz
  implements PraiseManager.a
{
  afcz(afcy paramafcy, int paramInt) {}
  
  public void a(int paramInt1, alen paramalen, int paramInt2, String paramString)
  {
    if (this.a.b.hasMessages(0))
    {
      this.a.b.removeMessages(0);
      this.a.b.obtainMessage(0, this.cQs, 0).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afcz
 * JD-Core Version:    0.7.0.1
 */