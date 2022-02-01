import android.content.Context;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class afpy
  implements ajdq<EmoticonPackage>
{
  afpy(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, afke paramafke, SessionInfo paramSessionInfo, EmojiStickerManager.StickerInfo paramStickerInfo) {}
  
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
    do
    {
      return;
      bool = false;
      break;
      if (!this.jdField_a_of_type_Afke.ajt()) {
        break label483;
      }
      if (this.jdField_a_of_type_Afke.a(this.d.epId, Boolean.valueOf(false))) {
        break label170;
      }
      ChatActivityUtils.h(this.val$context, 2131690208, 0);
      paramEmoticonPackage = this.val$app.getHandler(ChatActivity.class);
    } while (paramEmoticonPackage == null);
    paramEmoticonPackage.obtainMessage(10).sendToTarget();
    paramEmoticonPackage.obtainMessage(21).sendToTarget();
    return;
    label170:
    Object localObject = aiyh.a(this.d, 0);
    if ((localObject != null) && (((aixt)localObject).cmB))
    {
      if (aiyr.apU())
      {
        ((FragmentActivity)this.val$context).getChatFragment().a().a(this.d, 0, null, false);
        ((FragmentActivity)this.val$context).getChatFragment().a().a().d(this.d);
        return;
      }
      this.d.magicValue = "value=1";
    }
    do
    {
      afpu.e(this.val$app, this.val$context, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.d, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo);
      return;
      int j = aixo.il(aiyh.a(this.d, 0));
      int i = 0;
      if (paramEmoticonPackage != null) {
        i = paramEmoticonPackage.rscType;
      }
      paramEmoticonPackage = "rscType?" + i + ";value=" + j;
      this.d.magicValue = paramEmoticonPackage;
      if (QLog.isColorLevel()) {
        QLog.d("PicEmoticonInfo", 2, "before play,magicvalue:" + this.d.magicValue);
      }
      if ((localObject != null) && (!((aixt)localObject).isAutoPlay))
      {
        ujt.a(this.val$app, this.val$context, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.d);
        anot.a(this.val$app, "CliOper", "", "", "ep_mall", "0X800579D", 0, 0, this.d.epId, "", "", "");
        return;
      }
      localObject = ((FragmentActivity)this.val$context).getChatFragment();
    } while (localObject == null);
    ((ChatFragment)localObject).a().a().a(this.d, new afpz(this, paramEmoticonPackage));
    return;
    label483:
    ChatActivityUtils.Z(this.val$context, 2131690227);
    anot.a(this.val$app, "CliOper", "", "", "ep_mall", "0X8005C16", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afpy
 * JD-Core Version:    0.7.0.1
 */