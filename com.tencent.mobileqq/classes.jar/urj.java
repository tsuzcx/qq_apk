import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout;
import com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper;
import com.tencent.qphone.base.util.QLog;

public class urj
  implements Runnable
{
  public urj(DoodleMsgLayout paramDoodleMsgLayout, int paramInt) {}
  
  public void run()
  {
    QLog.d("DoodleMsgLayout", 2, "setDoodleContent start create drawable:" + this.jdField_a_of_type_Int);
    if (!DoodleResHelper.a().b(1, this.jdField_a_of_type_Int)) {
      DoodleResHelper.a().b(1, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
    }
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = DoodleResHelper.a().a(2, this.jdField_a_of_type_Int, true);
      if (localDrawable != null) {
        ((URLDrawable)localDrawable).startDownload();
      }
    } while (this.jdField_a_of_type_Int != DoodleMsgLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout));
    new Handler(Looper.getMainLooper()).post(new urk(this, localDrawable));
    QLog.d("DoodleMsgLayout", 2, "setDoodleContent finish create drawable:" + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     urj
 * JD-Core Version:    0.7.0.1
 */