import android.os.Handler;
import android.os.Message;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.qphone.base.util.QLog;

class dfc
  implements URLDrawable.URLDrawableListener
{
  dfc(dfb paramdfb) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d(FastImagePreviewLayout.jdField_a_of_type_JavaLangString, 2, "queryFastImage Load URLDrawable onLoadCanceled");
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d(FastImagePreviewLayout.jdField_a_of_type_JavaLangString, 2, "queryFastImage Load URLDrawable onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(FastImagePreviewLayout.jdField_a_of_type_JavaLangString, 2, "queryFastImage Load URLDrawable onLoadProgressed");
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d(FastImagePreviewLayout.jdField_a_of_type_JavaLangString, 2, "queryFastImage Load URLDrawable Successed, is to call showFastImage");
    }
    this.a.a.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.a.a.jdField_a_of_type_AndroidOsHandler, 31));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dfc
 * JD-Core Version:    0.7.0.1
 */