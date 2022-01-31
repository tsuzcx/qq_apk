import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;

public class cdl
  implements Runnable
{
  public cdl(ChatActivity paramChatActivity, QQMessageFacade.Message paramMessage, Intent paramIntent) {}
  
  public void run()
  {
    Object localObject;
    label524:
    StringBuilder localStringBuilder;
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d))
    {
      if (ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity) == null)
      {
        ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, new View(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity));
        ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).setId(2131230786);
        ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).setBackgroundColor(-3486515);
        localObject = new RelativeLayout.LayoutParams(-1, 1);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity), (ViewGroup.LayoutParams)localObject);
        ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity));
        ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).setId(2131230785);
        ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).setSingleLine();
        ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getResources().getDrawable(2130837767));
        ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).setGravity(17);
        ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).setTextSize(2, 14.0F);
        ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).setBackgroundResource(2130837767);
        ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getResources().getColorStateList(2131362095));
        ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).setPadding((int)(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.jdField_a_of_type_Float * 10.0F), ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).getPaddingTop(), (int)(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.jdField_a_of_type_Float * 10.0F), ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).getPaddingBottom());
        localObject = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getResources().getDimension(2131427498));
        ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131230786);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity), (ViewGroup.LayoutParams)localObject);
        ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity);
      }
      localObject = (RelativeLayout.LayoutParams)ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).getLayoutParams();
      if ((!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
        break label695;
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getResources().getDimension(2131427498));
      ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).setVisibility(0);
      ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).setLayoutParams((ViewGroup.LayoutParams)localObject);
      ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype != -2016) {
        break label722;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msg.split("\\|");
      if ((localObject == null) || (localObject.length <= 0)) {
        break label715;
      }
      localObject = localObject[0].trim();
      localStringBuilder = new StringBuilder();
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.nickName == null) {
        break label780;
      }
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname"));
      localStringBuilder.append("-");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.nickName);
      localStringBuilder.append(":");
      label587:
      if (!(localObject instanceof QQText)) {
        break label926;
      }
      ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).setText(((QQText)localObject).a(localStringBuilder.toString(), true, new int[] { 1, 16 }));
    }
    for (;;)
    {
      ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).requestLayout();
      ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).setTag(this.jdField_a_of_type_AndroidContentIntent);
      localObject = ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).getHandler();
      if (localObject != null)
      {
        ((Handler)localObject).removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.jdField_a_of_type_JavaLangRunnable);
        ((Handler)localObject).postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.jdField_a_of_type_JavaLangRunnable, 10000L);
      }
      return;
      label695:
      ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
      ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).setVisibility(8);
      break;
      label715:
      localObject = "";
      break label524;
      label722:
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype == -2011)
      {
        localObject = StructMsgFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgData);
        if (localObject != null)
        {
          localObject = ((AbsStructMsg)localObject).mMsgBrief;
          break label524;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msg;
        break label524;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.getMessageText();
      break label524;
      label780:
      String str3 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname");
      if ((str3 == null) || (str3.length() == 0))
      {
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin);
        localStringBuilder.append(":");
        break label587;
      }
      if (7000 == this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.istroop)
      {
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("subAccountLatestNick");
        String str1;
        if (str2 != null)
        {
          str1 = str2;
          if (str2.length() != 0) {}
        }
        else
        {
          str1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin;
        }
        localStringBuilder.append(str3);
        localStringBuilder.append("-");
        localStringBuilder.append(str1);
        localStringBuilder.append(":");
        break label587;
      }
      localStringBuilder.append(str3);
      localStringBuilder.append(":");
      break label587;
      label926:
      localStringBuilder.append((CharSequence)localObject);
      ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).setText(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cdl
 * JD-Core Version:    0.7.0.1
 */