import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment;

public class zyp
  extends aoop.a
{
  public zyp(RedPacketEmojiFragment paramRedPacketEmojiFragment) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    this.a.csz();
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    super.onLoadSuccessed(paramURLDrawable);
    this.a.cancelLoading();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zyp
 * JD-Core Version:    0.7.0.1
 */