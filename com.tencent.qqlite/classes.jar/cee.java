import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class cee
  extends MessageObserver
{
  public cee(SystemMsgListView paramSystemMsgListView) {}
  
  protected void a(String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      paramString = SystemMsgListView.a(this.a).getResources().getString(2131362903);
      QQToast.a(SystemMsgListView.a(this.a), 1, paramString, 0).b(this.a.a());
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    long l1 = FriendSystemMsgController.a().b();
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      try
      {
        l2 = Long.parseLong(paramString1);
        l1 = l2;
        if (paramBoolean) {
          break label169;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        paramString1 = SystemMsgListView.a(this.a).getResources().getString(2131363399);
        if (TextUtils.isEmpty(paramString3)) {
          break label365;
        }
        QQToast.a(SystemMsgListView.a(this.a), 1, paramString3, 0).b(this.a.a());
        SystemMsgUtils.a(FriendSystemMsgController.a().a(Long.valueOf(l1)), paramInt3, paramString2, paramString4);
        paramString1 = FriendSystemMsgController.a().a(Long.valueOf(l1));
        if ((paramString1 != null) && (paramString1.msg_type.get() == 2)) {
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1012);
        }
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      continue;
      label169:
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      paramString1 = SystemMsgListView.a(this.a).getResources().getString(2131362833);
      if (paramInt1 == 0) {
        paramString1 = SystemMsgListView.a(this.a).getResources().getString(2131362832);
      }
      QQToast.a(SystemMsgListView.a(this.a), 2, paramString1, 0).b(this.a.a());
      long l2 = FriendSystemMsgController.a().a();
      SystemMsgUtils.a(FriendSystemMsgController.a().a(Long.valueOf(l1)), paramInt1, paramString2, paramInt2);
      paramString1 = FriendSystemMsgController.a().a(Long.valueOf(l1));
      if (l2 != 0L) {}
      try
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ad, 0, l2, paramString1.toByteArray());
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1012);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i("Q.newfriendSystemMsgListView", 2, "onSendSystemMsgActionFin Exception!");
          }
        }
      }
      label365:
      paramString3 = paramString1;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onGetSystemMsgFin.bengin");
    }
    if (((Activity)SystemMsgListView.a(this.a)).isFinishing()) {
      return;
    }
    if (paramBoolean1) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "onGetSystemMsgFin.success");
      }
    }
    for (;;)
    {
      try
      {
        SystemMsgListView.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ad, 0));
        if (SystemMsgListView.a(this.a) == null) {
          break;
        }
        SystemMsgListView.a(this.a).a(SystemMsgListView.a(this.a));
        SystemMsgListView.a(this.a).notifyDataSetChanged();
        if (SystemMsgListView.a(this.a))
        {
          ((NewFriendManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31)).a(new NewFriendMessage(1, 0, false));
          FriendSystemMsgController.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b();
          SystemMsgListView.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        this.a.j();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      SystemMsgListView.a(this.a);
      return;
      if ((paramBoolean2) && (SystemMsgListView.b(this.a)))
      {
        String str = SystemMsgListView.a(this.a).getResources().getString(2131362904);
        QQToast.a(SystemMsgListView.a(this.a), 1, str, 0).b(this.a.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cee
 * JD-Core Version:    0.7.0.1
 */