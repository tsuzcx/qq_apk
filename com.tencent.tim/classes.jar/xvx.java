import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class xvx
  implements View.OnClickListener
{
  xvx(xvw paramxvw) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    this.a.jdField_a_of_type_Xvt.hW.setVisibility(8);
    if (this.a.jdField_a_of_type_Xvt.hW.getChildCount() > 0) {
      this.a.jdField_a_of_type_Xvt.hW.removeAllViews();
    }
    if ((this.a.mBaseChatPie == null) || (this.a.mBaseChatPie.sessionInfo == null) || (TextUtils.isEmpty(this.a.mBaseChatPie.sessionInfo.aTl))) {}
    while (!(paramView.getTag() instanceof Integer))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    aafi.c(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg, this.a.app);
    int i = ((Integer)paramView.getTag()).intValue();
    Object localObject = aado.a().cU(i);
    localObject = "，" + (String)localObject;
    this.a.mBaseChatPie.a.setText((CharSequence)localObject);
    localObject = aqgv.a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin);
    QQAppInterface localQQAppInterface = this.a.app;
    Context localContext = this.a.context;
    String str1 = this.a.mBaseChatPie.sessionInfo.aTl;
    String str2 = this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin;
    XEditTextEx localXEditTextEx = this.a.mBaseChatPie.a;
    if (this.a.mBaseChatPie.sessionInfo.cZ == 1) {}
    for (;;)
    {
      localObject = appb.a(localQQAppInterface, localContext, str1, str2, (String)localObject, false, localXEditTextEx, bool);
      if ((localObject != null) && (((SpannableString)localObject).length() != 0)) {
        this.a.mBaseChatPie.a.getEditableText().insert(0, (CharSequence)localObject);
      }
      this.a.mBaseChatPie.a.setSelection(this.a.mBaseChatPie.a.length());
      break;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xvx
 * JD-Core Version:    0.7.0.1
 */