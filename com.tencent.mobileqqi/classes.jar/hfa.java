import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.AlbumImageProxy;
import com.tencent.mobileqq.widget.RotateBitmap;

public class hfa
  extends Handler
{
  public hfa(AlbumImageProxy paramAlbumImageProxy) {}
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (Bitmap)paramMessage.obj;
    this.a.setImageRotateBitmapResetBase(new RotateBitmap(paramMessage, 0), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hfa
 * JD-Core Version:    0.7.0.1
 */