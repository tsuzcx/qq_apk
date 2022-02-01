import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity.11.1;
import java.util.concurrent.atomic.AtomicBoolean;

public class ylv
  implements aaza.c
{
  public ylv(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void a(String arg1, byte[] paramArrayOfByte1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    BlessSelectMemberActivity.aYT = ???;
    synchronized (BlessSelectMemberActivity.c())
    {
      BlessSelectMemberActivity.c().set(true);
      BlessSelectMemberActivity.c().notifyAll();
      return;
    }
  }
  
  public void onError(int paramInt)
  {
    this.this$0.runOnUiThread(new BlessSelectMemberActivity.11.1(this));
    if (BlessSelectMemberActivity.b() != null) {
      BlessSelectMemberActivity.b().sendEmptyMessage(1);
    }
    synchronized (BlessSelectMemberActivity.c())
    {
      BlessSelectMemberActivity.c().set(true);
      BlessSelectMemberActivity.c().notifyAll();
      this.this$0.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ylv
 * JD-Core Version:    0.7.0.1
 */