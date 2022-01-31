import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.concurrent.atomic.AtomicBoolean;

public class wcf
  implements EncodeVideoTask.ResultListener
{
  public wcf(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void a(int paramInt)
  {
    this.a.runOnUiThread(new wcg(this));
    if (BlessSelectMemberActivity.a() != null) {
      BlessSelectMemberActivity.a().sendEmptyMessage(1);
    }
    synchronized (BlessSelectMemberActivity.a())
    {
      BlessSelectMemberActivity.a().set(true);
      BlessSelectMemberActivity.a().notifyAll();
      this.a.finish();
      return;
    }
  }
  
  public void a(String arg1, byte[] paramArrayOfByte1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    BlessSelectMemberActivity.a = ???;
    synchronized (BlessSelectMemberActivity.a())
    {
      BlessSelectMemberActivity.a().set(true);
      BlessSelectMemberActivity.a().notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wcf
 * JD-Core Version:    0.7.0.1
 */