import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat.Builder;
import com.tencent.biz.qqstory.notification.StoryPushMsg;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class qeb
  implements URLDrawable.URLDrawableListener
{
  qeb(qea paramqea, NotificationCompat.Builder paramBuilder, QQAppInterface paramQQAppInterface, StoryPushMsg paramStoryPushMsg, int paramInt) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadFialed, exception: " + QLog.getStackTraceString(paramThrowable));
    }
    this.this$0.a(this.val$app, this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryPushMsg, this.blN, this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder);
    qea.a(this.this$0).remove(paramURLDrawable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadSuccessed start, mURLDrawableList.size():" + qea.a(this.this$0).size());
    }
    Bitmap localBitmap1 = aqhu.f(paramURLDrawable.getCurrDrawable(), 200, 200);
    Bitmap localBitmap2 = jqg.b(localBitmap1, 1);
    if (QLog.isColorLevel()) {
      QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadSuccessed start, cutBitmap.size():" + localBitmap2.getHeight() + ", " + localBitmap2.getWidth());
    }
    this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.setLargeIcon(localBitmap2);
    this.this$0.a(this.val$app, this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryPushMsg, this.blN, this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder);
    localBitmap1.recycle();
    qea.a(this.this$0).remove(paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadSuccessed, mURLDrawableList.size():" + qea.a(this.this$0).size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qeb
 * JD-Core Version:    0.7.0.1
 */