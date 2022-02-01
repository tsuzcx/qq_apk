import com.tencent.image.VideoDrawable.OnAudioPlayOnceListener;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class xnd
  implements VideoDrawable.OnAudioPlayOnceListener
{
  public xnd(ShortVideoPTVItemBuilder paramShortVideoPTVItemBuilder) {}
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "VideoDrawable.OnAudioPlayOnceListener.onFinish");
    }
    if ((ShortVideoPTVItemBuilder.access$000() != null) && (ShortVideoPTVItemBuilder.access$000().get() != null))
    {
      ShortVideoPTVItemBuilder.a(ShortVideoPTVItemBuilder.a(this.a), (ChatMessage)ShortVideoPTVItemBuilder.access$000().get());
      ShortVideoPTVItemBuilder.access$002(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xnd
 * JD-Core Version:    0.7.0.1
 */