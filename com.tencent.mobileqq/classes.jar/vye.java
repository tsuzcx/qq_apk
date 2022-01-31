import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.aio.tips.GatherContactsTips;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class vye
  extends FriendListObserver
{
  public vye(FriendChatPie paramFriendChatPie) {}
  
  protected void onSetAsNormalContacts(boolean paramBoolean, List paramList)
  {
    if ((paramBoolean) && (FriendChatPie.a(this.a) != null))
    {
      if ((FriendChatPie.a(this.a).a()) && (!FriendChatPie.a(this.a).b()))
      {
        FriendChatPie.a(this.a).b(1);
        FriendChatPie.a(this.a).a(2);
      }
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131437782), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  protected void onSetAsUncommonlyUsedContacts(boolean paramBoolean, List paramList)
  {
    if ((paramBoolean) && (FriendChatPie.a(this.a) != null)) {
      FriendChatPie.a(this.a).b(2);
    }
  }
  
  protected void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList paramArrayList)
  {
    super.onUpdateHotFriendLevel(paramBoolean, paramArrayList);
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.contains(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendChatPie", 2, "onUpdateHotFriendLevel");
      }
      this.a.y();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vye
 * JD-Core Version:    0.7.0.1
 */