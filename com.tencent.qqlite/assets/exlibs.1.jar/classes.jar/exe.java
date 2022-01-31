import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.AlbumImageProxy;
import com.tencent.qphone.base.util.QLog;

public class exe
  extends Thread
{
  public exe(AlbumImageProxy paramAlbumImageProxy, String paramString, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AlbumImageProxy", 2, "AlbumImageProxy, decode Thread: filekey :" + this.jdField_a_of_type_JavaLangString);
    }
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqWidgetAlbumImageProxy.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    Message localMessage = new Message();
    localMessage.what = 0;
    localMessage.obj = localBitmap;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAlbumImageProxy.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     exe
 * JD-Core Version:    0.7.0.1
 */