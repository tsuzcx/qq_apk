import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;

public class byy
  implements MessageQueue.IdleHandler
{
  public byy(AIOGalleryScene paramAIOGalleryScene) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     byy
 * JD-Core Version:    0.7.0.1
 */