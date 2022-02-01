import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat.Builder;
import com.tencent.biz.qqstory.notification.StoryPushMsg;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class xim
  implements URLDrawable.URLDrawableListener
{
  xim(xil paramxil, NotificationCompat.Builder paramBuilder, QQAppInterface paramQQAppInterface, StoryPushMsg paramStoryPushMsg, int paramInt) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadFialed, exception: " + QLog.getStackTraceString(paramThrowable));
    }
    this.jdField_a_of_type_Xil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryPushMsg, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder);
    xil.a(this.jdField_a_of_type_Xil).remove(paramURLDrawable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadSuccessed start, mURLDrawableList.size():" + xil.a(this.jdField_a_of_type_Xil).size());
    }
    Bitmap localBitmap1 = bhmq.a(paramURLDrawable.getCurrDrawable(), 200, 200);
    Bitmap localBitmap2 = nnw.b(localBitmap1, 1);
    if (QLog.isColorLevel()) {
      QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadSuccessed start, cutBitmap.size():" + localBitmap2.getHeight() + ", " + localBitmap2.getWidth());
    }
    this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.setLargeIcon(localBitmap2);
    this.jdField_a_of_type_Xil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryPushMsg, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder);
    localBitmap1.recycle();
    xil.a(this.jdField_a_of_type_Xil).remove(paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadSuccessed, mURLDrawableList.size():" + xil.a(this.jdField_a_of_type_Xil).size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xim
 * JD-Core Version:    0.7.0.1
 */