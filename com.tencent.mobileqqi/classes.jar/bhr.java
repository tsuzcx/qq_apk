import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.GaInviteActivity;
import com.tencent.qphone.base.util.QLog;

public class bhr
  implements Runnable
{
  public bhr(GaInviteActivity paramGaInviteActivity) {}
  
  public void run()
  {
    long l = this.a.b;
    String str1 = Long.toString(this.a.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.e(GaInviteActivity.jdField_a_of_type_JavaLangString, 2, "GetDiscussFaceRunnable");
    }
    Bitmap localBitmap = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, String.valueOf(l), null, true, false);
    String str2 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1004, str1, String.valueOf(this.a.b));
    if ((localBitmap != null) && (!str2.equals(str1)))
    {
      if (QLog.isColorLevel()) {
        QLog.e(GaInviteActivity.jdField_a_of_type_JavaLangString, 2, "GetDiscussFaceRunnable bitmap OK");
      }
      if (this.a.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
      }
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhr
 * JD-Core Version:    0.7.0.1
 */