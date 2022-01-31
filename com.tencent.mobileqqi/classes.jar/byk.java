import PushNotifyPack.C2CMsgReadedNotify;
import PushNotifyPack.DisMsgReadedNotify;
import PushNotifyPack.GroupMsgReadedNotify;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class byk
  extends MessageObserver
{
  private cyp jdField_a_of_type_Cyp = null;
  
  public byk(ChatActivity paramChatActivity) {}
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.jdField_a_of_type_Int)) {}
    while (paramInt1 != 1) {
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 1: 
    case 2: 
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, 2131561471, 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.finish();
      return;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, 2131563241, 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d());
    }
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    if (paramInt1 == 1) {
      if (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b.getManager(8)).f(paramString1)) {
        if (paramInt2 == 108)
        {
          if (this.jdField_a_of_type_Cyp == null) {
            this.jdField_a_of_type_Cyp = new cyp(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity);
          }
          paramString1 = (ChatMessage)ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).getItem(ChatActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).getCount() - 1);
          this.jdField_a_of_type_Cyp.a(paramString1);
          if (this.jdField_a_of_type_Cyp.a()) {
            this.jdField_a_of_type_Cyp.a();
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a(196608);
      return;
      if (paramInt2 == 102)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.finish();
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getApplicationContext(), 2131562089, 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d());
      }
      else if (paramString2.length() > 0)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, paramString2, 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d());
        continue;
        switch (paramInt2)
        {
        default: 
          break;
        case 1: 
        case 2: 
        case 101: 
        case 102: 
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, 2131561471, 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d());
          break;
        case 3: 
        case 103: 
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, 2131563241, 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d());
          continue;
          if (paramInt1 == 3000) {
            switch (paramInt2)
            {
            default: 
              break;
            case 101: 
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, 2131561434, 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d());
              break;
            case 102: 
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, 2131561449, 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d());
              break;
            case 103: 
              DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, 230, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getString(2131559040), this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getString(2131561440), new byl(this, paramString1), null).show();
              break;
            case 104: 
              DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, 230, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getString(2131559040), this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getString(2131562512), new bym(this, paramString1), null).show();
              break;
            }
          } else if (paramInt1 == 1005) {
            switch (paramInt2)
            {
            case 55: 
            default: 
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getString(2131562088), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d());
              break;
            case 1603: 
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getString(2131563046), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d());
              break;
            }
          } else if (paramInt1 == 1004) {
            switch (paramInt2)
            {
            default: 
              break;
            case 102: 
            case 103: 
            case 104: 
              paramString1 = String.format(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getString(2131561433), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.d });
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, paramString1, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d());
              break;
            }
          } else if (paramInt1 == 1000) {
            switch (paramInt2)
            {
            default: 
              break;
            case 102: 
            case 103: 
            case 104: 
              paramString1 = String.format(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getString(2131563240), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.d });
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, paramString1, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d());
              break;
            }
          } else if (paramInt1 == 1020) {
            switch (paramInt2)
            {
            default: 
              break;
            case 40: 
            case 102: 
            case 103: 
            case 104: 
              paramString1 = String.format(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getString(2131560289), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.d });
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, paramString1, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d());
              break;
            }
          } else if (paramInt1 == 1009) {
            switch (paramInt2)
            {
            default: 
              break;
            case 3: 
            case 21: 
            case 22: 
            case 23: 
            case 28: 
            case 48: 
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getString(2131563280), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d());
              break;
            }
          } else if (paramInt1 == 1006) {
            switch (paramInt2)
            {
            default: 
              break;
            case 1600: 
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getString(2131561466), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d());
              break;
            case 1601: 
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getString(2131561466), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d());
              break;
            case 1602: 
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getString(2131561465), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d());
              break;
            }
          } else if (paramInt1 == 1022) {
            switch (paramInt2)
            {
            default: 
              break;
            case 16: 
              ChatActivityFacade.c(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a);
              break;
            }
          } else if (paramInt1 == 1023) {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, "errorCode" + paramInt2, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d());
          } else if (paramInt1 == 1024) {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, "errorCode" + paramInt2, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.d());
          }
          break;
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int j = paramObject.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramObject[i];
      if ((localObject instanceof C2CMsgReadedNotify))
      {
        localObject = (C2CMsgReadedNotify)localObject;
        if (QLog.isColorLevel()) {
          QLog.i("onPushReadedNotify", 2, ((C2CMsgReadedNotify)localObject).lPeerUin + "---c2c---" + ((C2CMsgReadedNotify)localObject).lLastReadTime);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof GroupMsgReadedNotify))
        {
          localObject = (GroupMsgReadedNotify)localObject;
          if (QLog.isColorLevel()) {
            QLog.i("onPushReadedNotify", 2, ((GroupMsgReadedNotify)localObject).lGroupCode + "---group---" + ((GroupMsgReadedNotify)localObject).lGroupMsgSeq + "------" + ((GroupMsgReadedNotify)localObject).lMemberSeq);
          }
        }
        else if ((localObject instanceof DisMsgReadedNotify))
        {
          localObject = (DisMsgReadedNotify)localObject;
          if (QLog.isColorLevel()) {
            QLog.i("onPushReadedNotify", 2, ((DisMsgReadedNotify)localObject).lDisUin + "---dis---" + ((DisMsgReadedNotify)localObject).lMemberSeq);
          }
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.f = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a(131072);
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a(131072);
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      ChatActivityUtils.a();
      if (paramBoolean) {
        ChatActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity);
      }
    }
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      ChatActivityUtils.a();
      if (paramBoolean) {
        ChatActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity);
      }
    }
  }
  
  protected void d(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a(65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     byk
 * JD-Core Version:    0.7.0.1
 */