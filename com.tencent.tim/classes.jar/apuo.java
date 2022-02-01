import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.troop.utils.VideoAnimationUtils.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class apuo
{
  private static final String cou = acbn.SDCARD_PATH + ".troop/anim_video/";
  
  public static void a(aqva paramaqva, String paramString1, String paramString2, SpriteVideoView paramSpriteVideoView, anyo.a parama)
  {
    if (paramaqva == null) {}
    Object localObject;
    do
    {
      return;
      paramSpriteVideoView = new WeakReference(paramSpriteVideoView);
      paramString1 = new File(cou + paramString1);
      if (paramString1.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoAnimationUtils", 2, "res exists, return:" + paramString1.getAbsolutePath());
        }
        a(paramSpriteVideoView, paramString1.getAbsolutePath(), parama);
        return;
      }
      paramaqva = paramaqva.a(1);
      localObject = new File(cou);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramString2 = new aquz(paramString2, paramString1);
      paramString2.retryCount = 2;
      localObject = new Bundle();
    } while (paramaqva == null);
    paramaqva.a(paramString2, new apup(paramSpriteVideoView, paramString1, parama), (Bundle)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, SpriteVideoView paramSpriteVideoView, anyo.a parama)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    a((aqva)paramQQAppInterface.getManager(47), paramString1, paramString2, paramSpriteVideoView, parama);
  }
  
  private static void a(WeakReference<SpriteVideoView> paramWeakReference, String paramString, anyo.a parama)
  {
    if (paramWeakReference != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoAnimationUtils", 2, "playVideoAnim");
      }
      if ((SpriteVideoView)paramWeakReference.get() != null) {
        ThreadManager.getUIHandler().post(new VideoAnimationUtils.2(paramWeakReference, paramString, parama));
      }
    }
  }
  
  public static void u(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramString1, paramString2, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apuo
 * JD-Core Version:    0.7.0.1
 */