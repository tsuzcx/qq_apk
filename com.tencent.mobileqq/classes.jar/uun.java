import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder.FlashPicAIOThumbView;
import com.tencent.qphone.base.util.QLog;

public class uun
  implements Runnable
{
  public uun(FlashPicItemBuilder.FlashPicAIOThumbView paramFlashPicAIOThumbView) {}
  
  public void run()
  {
    try
    {
      synchronized (BaseApplicationImpl.sImageCache) {}
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotchat", 2, "cache flashpic abumb exception:" + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uun
 * JD-Core Version:    0.7.0.1
 */