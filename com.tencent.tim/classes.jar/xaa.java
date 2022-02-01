import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatManager.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xaa
  implements View.OnClickListener
{
  xaa(wzx paramwzx) {}
  
  public void onClick(View paramView)
  {
    MessageForArkFlashChat localMessageForArkFlashChat = (MessageForArkFlashChat)paramView.getTag();
    FlashChatManager.b localb;
    String str1;
    if (localMessageForArkFlashChat != null)
    {
      localb = ((FlashChatManager)this.a.app.getManager(217)).a;
      str1 = localb.url;
      String str2 = localb.bKd;
      String str3 = localb.bKe;
      if (QLog.isColorLevel()) {
        QLog.d("FlashChat", 2, "mSourceOnClickListener clickAppMsg url = " + str1 + ", actionData = " + str2 + ", actionDataA = " + str3);
      }
      if (!this.a.j(str1, str2, str3)) {
        break label126;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label126:
      if (!this.a.a(str1, localb.name, localMessageForArkFlashChat)) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xaa
 * JD-Core Version:    0.7.0.1
 */