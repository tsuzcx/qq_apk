import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;

public class zv
  implements Runnable
{
  public zv(BaseChatPie paramBaseChatPie, QQMessageFacade.Message paramMessage, Intent paramIntent) {}
  
  public void run()
  {
    Object localObject;
    label500:
    StringBuilder localStringBuilder;
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView == null)
      {
        BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, new View(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
        BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).setId(2131296313);
        BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131427451));
        localObject = new RelativeLayout.LayoutParams(-1, 1);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.addView(BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie), (ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setId(2131296312);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130837688));
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setGravity(17);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setBackgroundResource(2130837688);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColorStateList(2131427496));
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setPadding((int)(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Float * 10.0F), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.getPaddingTop(), (int)(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Float * 10.0F), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.getPaddingBottom());
        localObject = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131493003));
        ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131296313);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.addView(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      if ((!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
        break label665;
      }
      BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype != -2011) {
        break label691;
      }
      localObject = StructMsgFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgData);
      if (localObject == null) {
        break label680;
      }
      localObject = ((AbsStructMsg)localObject).mMsgBrief;
      localStringBuilder = new StringBuilder();
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.nickName == null) {
        break label702;
      }
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname"));
      localStringBuilder.append("-");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.nickName);
      label551:
      localStringBuilder.append(":");
      if (!(localObject instanceof QQText)) {
        break label781;
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setText(((QQText)localObject).a(localStringBuilder.toString(), true, new int[] { 1, 16 }));
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.requestLayout();
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_AndroidContentIntent);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.getHandler();
        if (localObject != null)
        {
          ((Handler)localObject).removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_JavaLangRunnable);
          ((Handler)localObject).postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_JavaLangRunnable, 10000L);
        }
        return;
        label665:
        BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).setVisibility(8);
        break;
        label680:
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msg;
        break label500;
        label691:
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.getMessageText();
        break label500;
        label702:
        String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname");
        if ((str == null) || (str.length() == 0))
        {
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin);
          break label551;
        }
        if (7000 == this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.istroop) {
          break label551;
        }
        localStringBuilder.append(str);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ChatActivity", 2, localException.toString());
        continue;
      }
      label781:
      localStringBuilder.append(localException);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_f_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     zv
 * JD-Core Version:    0.7.0.1
 */