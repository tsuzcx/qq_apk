import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import java.util.List;

class wee
  implements wec
{
  wee(wed paramwed, List paramList, Bitmap[] paramArrayOfBitmap, Handler paramHandler) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramString);
    wdk.b(wed.a(this.jdField_a_of_type_Wed), "bitmap download success index=%d, url=%s", Integer.valueOf(i), paramString);
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i] = paramBitmap;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 0, this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap), 200L);
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramString);
    wdk.c(wed.a(this.jdField_a_of_type_Wed), "bitmap download failed index=%s, error=%s", Integer.valueOf(i), paramThrowable);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, paramThrowable), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wee
 * JD-Core Version:    0.7.0.1
 */