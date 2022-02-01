import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;

public class ebw
  implements MessageQueue.IdleHandler
{
  public ebw(AIOGalleryScene paramAIOGalleryScene) {}
  
  public boolean queueIdle()
  {
    Object localObject = this.a.a.a();
    if (localObject != null)
    {
      localObject = ((AIOImageInfo)localObject).a;
      if ((localObject != null) && (((AIOImageData)localObject).a(4)) && (((AIOImageData)localObject).a(4) == null)) {
        this.a.c(true);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ebw
 * JD-Core Version:    0.7.0.1
 */