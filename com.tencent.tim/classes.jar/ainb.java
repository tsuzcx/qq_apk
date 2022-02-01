import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

public class ainb
{
  private static ainb jdField_a_of_type_Ainb;
  public static boolean ckG = true;
  private ainb.a jdField_a_of_type_Ainb$a;
  
  public static ainb a()
  {
    if (jdField_a_of_type_Ainb == null) {
      jdField_a_of_type_Ainb = new ainb();
    }
    return jdField_a_of_type_Ainb;
  }
  
  public static URLDrawable a(String paramString, int paramInt1, int paramInt2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = new afei(-10065297, 100, 100);
    localURLDrawableOptions.mFailedDrawable = new afei(-10065297, 100, 100);
    localURLDrawableOptions.mRequestHeight = paramInt2;
    localURLDrawableOptions.mRequestWidth = paramInt1;
    return URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions);
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = MediaPlayerManager.a(paramQQAppInterface).a();
    if (((localChatMessage == paramChatMessage) || (((localChatMessage instanceof MessageForLightVideo)) && (localChatMessage.uniseq == paramChatMessage.uniseq))) && (((MessageForLightVideo)paramChatMessage).videoStatus == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        MediaPlayerManager.a(paramQQAppInterface).stop(true);
      }
      return bool;
    }
  }
  
  public void Lg(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoPlayMgr", 2, "switchEarOrLoudspeaker:" + paramBoolean);
    }
    ckG = paramBoolean;
    if (this.jdField_a_of_type_Ainb$a != null) {
      this.jdField_a_of_type_Ainb$a.zr(paramBoolean);
    }
  }
  
  public boolean Rw()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return MediaPlayerManager.a((QQAppInterface)localAppRuntime).Rw();
    }
    return false;
  }
  
  public void a(ainb.a parama)
  {
    this.jdField_a_of_type_Ainb$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void zr(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ainb
 * JD-Core Version:    0.7.0.1
 */