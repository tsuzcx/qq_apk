import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.ProfileCardBrowserActivity;
import com.tencent.mobileqq.profile.ProfileCardBrowserActivity.ImageGalleryAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class giq
  extends Handler
{
  public giq(ProfileCardBrowserActivity paramProfileCardBrowserActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    default: 
    case 1: 
    case 18: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      do
      {
        do
        {
          do
          {
            return;
            paramMessage = new LinearLayout.LayoutParams(this.a.jdField_a_of_type_JavaUtilList.size() * (this.a.A + this.a.D), this.a.B);
            this.a.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams(paramMessage);
            this.a.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.a.A);
            this.a.jdField_a_of_type_AndroidWidgetGridView.setStretchMode(0);
            this.a.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(this.a.jdField_a_of_type_JavaUtilList.size());
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity$ImageGalleryAdapter = new ProfileCardBrowserActivity.ImageGalleryAdapter(this.a, this.a.jdField_a_of_type_AndroidContentContext);
            this.a.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBrowserActivity$ImageGalleryAdapter);
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, "handleMessage mIsRedPoint : " + this.a.d + ", mLoaded : " + this.a.c);
            }
          } while ((!this.a.d) || (this.a.c));
          ThreadManager.a(ProfileCardBrowserActivity.a(this.a));
          return;
        } while (this.a.jdField_a_of_type_AndroidViewView == null);
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.a.jdField_a_of_type_AndroidViewView = null;
        return;
        this.a.b(paramMessage.arg1, 2);
        return;
        this.a.b(paramMessage.arg1, 3);
        return;
        this.a.b(paramMessage.arg1, 4);
        return;
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.a.b(paramMessage.arg1, 5);
      } while (this.a.y != 0);
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    case 6: 
      this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.a.b(paramMessage.arg1, 6);
      return;
    case 8: 
      this.a.a(paramMessage.arg1, paramMessage.arg2);
      return;
    case 7: 
      Toast.makeText(this.a.jdField_a_of_type_AndroidContentContext, 2131563268, 0).show();
      return;
    case 9: 
      this.a.f();
      return;
    case 16: 
      this.a.b(this.a.x, 16);
      return;
    }
    this.a.b(paramMessage.arg1, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     giq
 * JD-Core Version:    0.7.0.1
 */