import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.troop.utils.RollangleImageView;
import com.tencent.mobileqq.troop.utils.RollangleImageView.a;

public class aprh
  extends Handler
{
  public aprh(RollangleImageView.a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (this.this$0.cSd) {}
    Object localObject;
    String str;
    do
    {
      return;
      localObject = (Object[])paramMessage.obj;
      paramMessage = (RollangleImageView)localObject[0];
      str = (String)localObject[1];
      localObject = (Bitmap)localObject[2];
    } while ((paramMessage == null) || (str == null) || (localObject == null) || (!str.equals(paramMessage.cqH)));
    paramMessage.setImageBitmap((Bitmap)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aprh
 * JD-Core Version:    0.7.0.1
 */