import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.troop.data.TroopEntranceBar;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

public class vwp
  extends Handler
{
  public vwp(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 5: 
    case 8: 
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 6: 
    case 9: 
    case 7: 
      do
      {
        do
        {
          SharedPreferences localSharedPreferences;
          do
          {
            long l;
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                      } while (((this.a.ai) && ((!this.a.aj) || (((PublicAccountDataManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).c(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) == null))) || (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()));
                      try
                      {
                        this.a.bd();
                        return;
                      }
                      catch (Exception paramMessage)
                      {
                        paramMessage.printStackTrace();
                        return;
                      }
                      paramMessage = this.a.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a());
                      this.a.c(paramMessage);
                    } while ((paramMessage == null) || (paramMessage.isEmpty()));
                    this.a.o(true);
                    return;
                    this.a.bb();
                    this.a.ba();
                  } while (this.a.m == 1);
                  this.a.p = 5;
                  return;
                } while ((this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) || (this.a.d == null) || (!this.a.d.isShowing()));
                this.a.d.dismiss();
                QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131433424, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
                return;
              } while (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing());
              localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0);
              l = localSharedPreferences.getLong("switch_city" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0L);
              if (System.currentTimeMillis() - l >= 86400000L) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("Q.aio.BaseChatPie", 2, "switch_city no time =" + (System.currentTimeMillis() - l));
            return;
          } while (paramMessage.arg2 != 1);
          int i = paramMessage.arg1;
          PublicAccountChatPie.a(this.a, DialogUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 230, null, String.format("定位到你当前所在城市在%s，是否切换？", new Object[] { (String)paramMessage.obj }), "否", "是", new vwq(this, i), new vwr(this, localSharedPreferences)));
          PublicAccountChatPie.a(this.a).show();
          return;
          paramMessage = paramMessage.getData();
        } while (paramMessage == null);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a.put(paramMessage.getString("troopUin"), Integer.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessage.getString("troopUin"), 1)));
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.d();
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.e();
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.c();
        return;
      } while (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null);
      this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.springBackOverScrollHeaderView();
      this.a.W = false;
      return;
    }
    if (!(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity))
    {
      this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    paramMessage = new Intent(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class);
    paramMessage.putExtra("tab_index", MainFragment.a);
    paramMessage.putExtra("fragment_id", 1);
    paramMessage.setFlags(67108864);
    this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vwp
 * JD-Core Version:    0.7.0.1
 */