import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.qphone.base.util.QLog;

public class wee
  implements View.OnClickListener
{
  public wee(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "mQidianClickListener ... mQidianKefu = " + this.a.ak);
    }
    this.a.v(2131430031);
    this.a.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.j, this.a.k, this.a.l, new wef(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wee
 * JD-Core Version:    0.7.0.1
 */