import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public final class yla
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public yla(ApolloRender paramApolloRender, View paramView) {}
  
  public void onGlobalLayout()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow == null) || (!this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mShowEditWindow)) {
      QLog.e("rogersxiao", 2, "render.mEditWindow return");
    }
    do
    {
      return;
      localObject = new Rect();
      this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame((Rect)localObject);
      i = (int)DeviceInfoUtil.m();
      int j = ((Rect)localObject).bottom;
      int k = ((Rect)localObject).top;
      ImmersiveUtils.a(this.jdField_a_of_type_AndroidViewView.getContext());
      if (i - (j - k) >= 200) {
        break;
      }
    } while (!ApolloRender.sIsKeyBoardShow);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.dismiss();
    ApolloRender.sIsKeyBoardDissmiss = true;
    return;
    int i = ((Rect)localObject).bottom - this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.getHeight();
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0);
    if (((SharedPreferences)localObject).getInt("sp_key_apollo_keyboard_height", 0) != i)
    {
      ((SharedPreferences)localObject).edit().putInt("sp_key_apollo_keyboard_height", i).commit();
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.showAtLocation(this.jdField_a_of_type_AndroidViewView.getRootView(), 0, 0, i);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.update(0, i, this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.getWidth(), this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.getHeight());
      ApolloRender.sIsKeyBoardDissmiss = false;
    }
    if (ApolloRender.sIsKeyBoardDissmiss)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.showAtLocation(this.jdField_a_of_type_AndroidViewView.getRootView(), 0, 0, i);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.update(0, i, this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.getWidth(), this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.getHeight());
      ApolloRender.sIsKeyBoardDissmiss = false;
    }
    ApolloRender.sIsKeyBoardShow = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yla
 * JD-Core Version:    0.7.0.1
 */