import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.biz.qrcode.activity.QRCardActivity;

public class xym
  extends Handler
{
  public xym(QRCardActivity paramQRCardActivity) {}
  
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
      } while ((this.a.jdField_a_of_type_Boolean) || (!(paramMessage.obj instanceof Bitmap)));
      paramMessage = (Bitmap)paramMessage.obj;
    } while (paramMessage == null);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(0);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xym
 * JD-Core Version:    0.7.0.1
 */