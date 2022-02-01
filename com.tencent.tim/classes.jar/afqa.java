import android.content.Context;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class afqa
  implements ajdq<EmoticonPackage>
{
  afqa(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, afke paramafke, SessionInfo paramSessionInfo) {}
  
  public void c(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool;
    if ((paramEmoticonPackage != null) && ((2 != paramEmoticonPackage.status) || (!paramEmoticonPackage.valid))) {
      if (paramEmoticonPackage.jobType == 4)
      {
        bool = true;
        EmojiHomeUiPlugin.openEmojiDetailPage(((BaseActivity)this.val$context).getActivity(), this.val$app.getAccount(), 8, this.d.epId, false, bool);
        anot.a(this.val$app, "CliOper", "", "", "ep_mall", "0X8005C13", 0, 0, "", "", "", "");
      }
    }
    label194:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        if (!this.jdField_a_of_type_Afke.ajt()) {
          break label237;
        }
        if (!this.jdField_a_of_type_Afke.d(this.d.epId, true, true)) {
          break label194;
        }
        if (this.jdField_a_of_type_Afke.ajs())
        {
          afpu.b(this.val$context, this.val$app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.d);
          anot.a(this.val$app, "CliOper", "", "", "MbFasong", "MbZidongBofang", 0, 0, "", "", "", "");
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PicEmoticonInfo", 2, "not support h5magic ");
      return;
      ChatActivityUtils.h(this.val$context, 2131690208, 0);
      paramEmoticonPackage = this.val$app.getHandler(ChatActivity.class);
    } while (paramEmoticonPackage == null);
    paramEmoticonPackage.obtainMessage(10).sendToTarget();
    paramEmoticonPackage.obtainMessage(21).sendToTarget();
    return;
    label237:
    ChatActivityUtils.Z(this.val$context, 2131690227);
    anot.a(this.val$app, "CliOper", "", "", "ep_mall", "0X8005C16", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afqa
 * JD-Core Version:    0.7.0.1
 */