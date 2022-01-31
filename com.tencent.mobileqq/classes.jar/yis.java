import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public final class yis
  implements Runnable
{
  public yis(ApolloRender paramApolloRender, RelativeLayout paramRelativeLayout) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender == null) {
      return;
    }
    int i = (int)(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredWidth() - 80.0F * DeviceInfoUtil.a);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditorPop.setWidth(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yis
 * JD-Core Version:    0.7.0.1
 */