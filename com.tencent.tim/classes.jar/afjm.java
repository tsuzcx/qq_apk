import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.emosm.web.MessengerService.a;
import com.tencent.qphone.base.util.QLog;

public class afjm
  implements URLDrawable.URLDrawableListener
{
  public afjm(MessengerService.a parama, String paramString) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IPC_CMD_PRELOAD_IMAGE", 2, "handle url onLoadCanceled:" + this.val$url);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IPC_CMD_PRELOAD_IMAGE", 2, "handle url failed:" + this.val$url);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IPC_CMD_PRELOAD_IMAGE", 2, "handle url down:" + this.val$url);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afjm
 * JD-Core Version:    0.7.0.1
 */