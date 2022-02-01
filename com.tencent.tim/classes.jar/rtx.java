import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.biz.qrcode.activity.QRCardActivity;

public class rtx
  extends Handler
{
  public rtx(QRCardActivity paramQRCardActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while ((this.this$0.aJJ) || (!(paramMessage.obj instanceof Bitmap)));
      paramMessage = (Bitmap)paramMessage.obj;
    } while (paramMessage == null);
    this.this$0.nB.setBackgroundResource(0);
    this.this$0.nB.setImageBitmap(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rtx
 * JD-Core Version:    0.7.0.1
 */