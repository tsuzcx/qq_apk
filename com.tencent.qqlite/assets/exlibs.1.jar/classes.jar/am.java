import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;

public class am
  implements Runnable
{
  public am(LiteActivity paramLiteActivity, QQMessageFacade.Message paramMessage, Intent paramIntent) {}
  
  public void run()
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (((this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a()))) && (!this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_Boolean))
    {
      if (LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity) == null)
      {
        LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, new TextView(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity));
        LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).setId(2131296312);
        LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).setSingleLine();
        LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).setBackgroundDrawable(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130837715));
        LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).setGravity(17);
        LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).setTextSize(2, 14.0F);
        LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).setBackgroundResource(2130837715);
        LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).setTextColor(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getColorStateList(2131427495));
        LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).setPadding((int)(LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity) * 10.0F), LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).getPaddingTop(), (int)(LiteActivity.b(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity) * 10.0F), LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).getPaddingBottom());
        localObject = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDimension(2131492998));
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity), (ViewGroup.LayoutParams)localObject);
        LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity);
      }
      LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype != -2011) {
        break label501;
      }
      localObject = StructMsgFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgData);
      if (localObject == null) {
        break label490;
      }
      localObject = ((AbsStructMsg)localObject).mMsgBrief;
      localStringBuilder = new StringBuilder();
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.nickName == null) {
        break label512;
      }
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname"));
      localStringBuilder.append("-");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.nickName);
      label376:
      localStringBuilder.append(":");
      if (!(localObject instanceof QQText)) {
        break label591;
      }
    }
    for (;;)
    {
      try
      {
        LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).setText(((QQText)localObject).a(localStringBuilder.toString(), true, new int[] { 1, 16 }));
        LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).requestLayout();
        LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).setTag(this.jdField_a_of_type_AndroidContentIntent);
        localObject = LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).getHandler();
        if (localObject != null)
        {
          ((Handler)localObject).removeCallbacks(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_JavaLangRunnable);
          ((Handler)localObject).postDelayed(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_JavaLangRunnable, 10000L);
        }
        return;
        label490:
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msg;
        break;
        label501:
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.getMessageText();
        break;
        label512:
        String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname");
        if ((str == null) || (str.length() == 0))
        {
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin);
          break label376;
        }
        if (7000 == this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.istroop) {
          break label376;
        }
        localStringBuilder.append(str);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(LiteActivity.jdField_a_of_type_JavaLangString, 2, localException.toString());
        continue;
      }
      label591:
      localStringBuilder.append(localException);
      LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).setText(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     am
 * JD-Core Version:    0.7.0.1
 */