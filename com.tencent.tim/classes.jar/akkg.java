import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter;
import com.tencent.mobileqq.nearby.widget.AvatarWallViewPager;
import com.tencent.mobileqq.nearby.widget.AvatarWallViewPager.RollViewPager;

public class akkg
  extends Handler
{
  public akkg(AvatarWallViewPager paramAvatarWallViewPager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.c.b.GS() > 1)
    {
      paramMessage = this.c;
      paramMessage.baC += 1;
      this.c.baC %= this.c.b.GS();
      this.c.a.setCurrentItem(this.c.baC, true);
      this.c.mHandler.sendMessageDelayed(this.c.mHandler.obtainMessage(), this.c.dnn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akkg
 * JD-Core Version:    0.7.0.1
 */