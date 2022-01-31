import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.DrawerCoverUtil;

public class zkl
  implements Runnable
{
  public zkl(FrameHelperActivity paramFrameHelperActivity, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidViewViewGroup == null) {
      return;
    }
    RandomCoverView localRandomCoverView = (RandomCoverView)this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371360);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localObject = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject);
    String str = (String)localObject.getCoverData(0)[0];
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "[getCoverData] getCovertUrl from cache,url:" + str);
    }
    if ((!TextUtils.isEmpty(str)) && (!DrawerCoverUtil.b()))
    {
      DrawerCoverUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Card)localObject, localRandomCoverView, str, FrameHelperActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity), this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.a());
      return;
    }
    if (DrawerCoverUtil.b()) {}
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(new zkm(this, (Card)localObject), 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zkl
 * JD-Core Version:    0.7.0.1
 */