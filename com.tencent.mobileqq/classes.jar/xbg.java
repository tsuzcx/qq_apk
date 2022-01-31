import Wallet.GroupGoldMsgGrabReq;
import android.os.Build;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.TenCookie;
import mqq.manager.TicketManager;

public class xbg
  implements Runnable
{
  public xbg(GoldMsgChatHelper paramGoldMsgChatHelper, MessageRecord paramMessageRecord, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject = QWalletTools.a();
    if (localObject == null) {
      return;
    }
    String str3 = ((QQAppInterface)localObject).getCurrentNickname();
    String str4 = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
    String str5 = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
    String str2 = "";
    String str1 = "";
    localObject = (TicketManager)((QQAppInterface)localObject).getManager(2);
    if (localObject != null)
    {
      str2 = ((TicketManager)localObject).getSkey(this.jdField_a_of_type_JavaLangString);
      str1 = ((TicketManager)localObject).getPskey(this.jdField_a_of_type_JavaLangString, "tenpay.com");
    }
    localObject = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 1) {
      localObject = "1";
    }
    for (;;)
    {
      String str6 = QWalletTools.a(NetConnInfoCenter.GUID);
      String str7 = TenCookie.getInstance().readTagCookie(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_JavaLangString, "mqq.tenpay.com");
      String str8 = TenCookie.getInstance().getMsgNo(this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("GoldMsgChatHelper", 2, String.format("real grap uin = %s, listid = %s, name = %s, authkey = %s, channel = %s, groupuin = %s, grouptype = %s, groupcode = %s,  cookies = %s,  msgNo = %s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b, str3, this.c, "8192", str4, localObject, str5, str7, str8 }));
      }
      QWalletCommonServlet.a(new GroupGoldMsgGrabReq(this.jdField_a_of_type_JavaLangString, this.b, str3, this.c, "8192", str4, str5, (String)localObject, str1, str2, "2", Build.MODEL, String.valueOf(42), str6, str7, str8), this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper.a);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 3000) {
        localObject = "2";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xbg
 * JD-Core Version:    0.7.0.1
 */