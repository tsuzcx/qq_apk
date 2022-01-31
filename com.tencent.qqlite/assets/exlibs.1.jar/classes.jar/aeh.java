import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;

public class aeh
  implements IIconListener
{
  public aeh(ChatSettingActivity paramChatSettingActivity) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((this.a.jdField_a_of_type_AndroidWidgetTextView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null) && (this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b == paramInt1) && (paramBitmap != null) && (paramInt2 == 200)) {
      ChatSettingActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.a.jdField_a_of_type_AndroidWidgetTextView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aeh
 * JD-Core Version:    0.7.0.1
 */