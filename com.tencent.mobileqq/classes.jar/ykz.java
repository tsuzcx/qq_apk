import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.apollo.ApolloRender;

public final class ykz
  implements Runnable
{
  public ykz(ApolloRender paramApolloRender, View paramView, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.showAtLocation(this.jdField_a_of_type_AndroidViewView.getRootView(), 0, 0, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.update(0, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.getWidth(), this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ykz
 * JD-Core Version:    0.7.0.1
 */