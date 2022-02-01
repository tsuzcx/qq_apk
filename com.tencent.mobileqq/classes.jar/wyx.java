import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat.Builder;
import com.tencent.biz.qqstory.notification.StoryPushMsg;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class wyx
  implements URLDrawable.URLDrawableListener
{
  wyx(wyw paramwyw, NotificationCompat.Builder paramBuilder, QQAppInterface paramQQAppInterface, StoryPushMsg paramStoryPushMsg, int paramInt) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadFialed, exception: " + QLog.getStackTraceString(paramThrowable));
    }
    this.jdField_a_of_type_Wyw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryPushMsg, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder);
    wyw.a(this.jdField_a_of_type_Wyw).remove(paramURLDrawable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadSuccessed start, mURLDrawableList.size():" + wyw.a(this.jdField_a_of_type_Wyw).size());
    }
    Bitmap localBitmap1 = bheg.a(paramURLDrawable.getCurrDrawable(), 200, 200);
    if (localBitmap1 == null) {}
    do
    {
      return;
      Bitmap localBitmap2 = nwh.b(localBitmap1, 1);
      if ((QLog.isColorLevel()) && (localBitmap2 != null)) {
        QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadSuccessed start, cutBitmap.size():" + localBitmap2.getHeight() + ", " + localBitmap2.getWidth());
      }
      this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.setLargeIcon(localBitmap2);
      this.jdField_a_of_type_Wyw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryPushMsg, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder);
      localBitmap1.recycle();
      wyw.a(this.jdField_a_of_type_Wyw).remove(paramURLDrawable);
    } while (!QLog.isColorLevel());
    QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadSuccessed, mURLDrawableList.size():" + wyw.a(this.jdField_a_of_type_Wyw).size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyx
 * JD-Core Version:    0.7.0.1
 */