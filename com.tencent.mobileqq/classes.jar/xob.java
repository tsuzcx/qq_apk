import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import mqq.os.MqqHandler;

public class xob
  implements PhoneContactManager.IPhoneContactListener
{
  public xob(BannerManager paramBannerManager) {}
  
  public void a(int paramInt)
  {
    BannerManager.a(this.a).removeMessages(11);
    BannerManager.a(this.a).sendEmptyMessageDelayed(11, 1000L);
  }
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void b(int paramInt) {}
  
  public void c(int paramInt)
  {
    if ((paramInt & 0x1) != 0)
    {
      BannerManager.a(this.a).removeMessages(11);
      BannerManager.a(this.a).sendEmptyMessageDelayed(11, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xob
 * JD-Core Version:    0.7.0.1
 */