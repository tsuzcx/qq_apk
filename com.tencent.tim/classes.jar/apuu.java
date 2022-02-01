import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPager;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPager.RollViewPager;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter;

public class apuu
  extends Handler
{
  public apuu(AvatarWallViewPager paramAvatarWallViewPager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((AvatarWallViewPager.a(this.b)) || (!AvatarWallViewPager.b(this.b))) {}
    while (this.b.b.getCount() <= 1) {
      return;
    }
    paramMessage = this.b;
    paramMessage.baC += 1;
    this.b.baC %= this.b.b.getCount();
    this.b.a.setCurrentItem(this.b.baC, true);
    this.b.mHandler.sendMessageDelayed(this.b.mHandler.obtainMessage(), 4000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apuu
 * JD-Core Version:    0.7.0.1
 */