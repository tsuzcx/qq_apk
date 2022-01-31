import com.tencent.image.VideoDrawable.OnAudioPlayOnceListener;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class vcx
  implements VideoDrawable.OnAudioPlayOnceListener
{
  public vcx(ShortVideoPTVItemBuilder paramShortVideoPTVItemBuilder) {}
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "VideoDrawable.OnAudioPlayOnceListener.onFinish");
    }
    if ((ShortVideoPTVItemBuilder.a() != null) && (ShortVideoPTVItemBuilder.a().get() != null))
    {
      ShortVideoPTVItemBuilder.a(ShortVideoPTVItemBuilder.a(this.a), (ChatMessage)ShortVideoPTVItemBuilder.a().get());
      ShortVideoPTVItemBuilder.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vcx
 * JD-Core Version:    0.7.0.1
 */