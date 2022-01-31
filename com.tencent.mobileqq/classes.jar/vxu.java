import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.BaseTroopChatPie.BaseTroopMsgObserver;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class vxu
  extends BaseTroopChatPie.BaseTroopMsgObserver
{
  public vxu(TroopChatPie paramTroopChatPie)
  {
    super(paramTroopChatPie);
  }
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {}
    while (paramInt1 != 1) {
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 1: 
    case 2: 
      paramString = this.a.b.obtainMessage(5, 1, 0, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131433043));
      this.a.b.sendMessage(paramString);
    }
    for (;;)
    {
      this.a.A();
      return;
      paramString = this.a.b.obtainMessage(5, 1, 0, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131433042));
      this.a.b.sendMessage(paramString);
    }
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.TroopChatPie", 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1, paramLong2);
      if ((paramString1 != null) && (paramString1.msgtype == -2058) && ((paramString1.extraflag == 32768) || (paramString1.sendFailCode == 41)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.aio.TroopChatPie", 2, "onUpdateSendMsgError, sticker msg is failed!, now remove!");
        }
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, false);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.TroopChatPie", 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    if ((paramInt1 == 1) || (paramInt1 == 3000) || (paramInt1 == 0))
    {
      paramSendMessageHandler = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1, paramLong2);
      if ((paramSendMessageHandler == null) || (!(paramSendMessageHandler instanceof MessageForStructing))) {
        break label382;
      }
      if ("viewMultiMsg".equals(((MessageForStructing)paramSendMessageHandler).structingMsg.mMsgAction)) {
        MultiMsgManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramInt1, paramLong2, false);
      }
    }
    label372:
    label382:
    while ((paramSendMessageHandler == null) || (paramSendMessageHandler.msgtype != -2058) || ((paramSendMessageHandler.extraflag != 32768) && (paramSendMessageHandler.sendFailCode != 41)))
    {
      if (paramInt1 == 1) {}
      switch (paramInt2)
      {
      default: 
        this.a.b(196608);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.TroopChatPie", 2, "onUpdateSendMsgError, sticker msg is failed!");
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramSendMessageHandler, false);
    paramString1 = MsgProxyUtils.a(paramString1, paramInt1);
    boolean bool;
    if (EmojiStickerManager.a().b.containsKey(paramString1))
    {
      paramLong1 = ((Long)EmojiStickerManager.a().b.get(paramString1)).longValue();
      if (System.currentTimeMillis() - paramLong1 <= 300000L) {
        break label816;
      }
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.TroopChatPie", 2, "send sticker msg fail, is need send Toast " + bool);
      }
      if (!bool) {
        break;
      }
      EmojiStickerManager.a().b.put(paramString1, Long.valueOf(System.currentTimeMillis()));
      ThreadManager.getUIHandler().post(new vxv(this, paramSendMessageHandler));
      break;
      bool = true;
      continue;
      paramString1 = this.a.b.obtainMessage(5, 1, 0, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131433043));
      this.a.b.sendMessage(paramString1);
      break label372;
      paramString1 = this.a.b.obtainMessage(5, 1, 0, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131433042));
      this.a.b.sendMessage(paramString1);
      break label372;
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131430447);
      }
      paramString1 = this.a.b.obtainMessage(5, 1, 0, paramString1);
      this.a.b.sendMessage(paramString1);
      break label372;
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131430448);
      }
      paramString1 = this.a.b.obtainMessage(5, 1, 0, paramString1);
      this.a.b.sendMessage(paramString1);
      break label372;
      if (TextUtils.isEmpty(paramString2)) {
        break label372;
      }
      paramString1 = this.a.b.obtainMessage(5, 1, 0, paramString2);
      this.a.b.sendMessage(paramString1);
      break label372;
      label816:
      bool = false;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1;
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.TroopChatPie", 2, "onGetSystemMsgFin.success");
      }
      List localList = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.L, 0);
      Object localObject2 = null;
      localObject1 = localObject2;
      if (localList != null)
      {
        localObject1 = localObject2;
        if (localList.size() - 1 >= 0) {
          localObject1 = (MessageRecord)localList.get(localList.size() - 1);
        }
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForSystemMsg))) {
        break label100;
      }
    }
    label100:
    long l;
    do
    {
      int i;
      do
      {
        do
        {
          return;
          localObject1 = ((MessageForSystemMsg)localObject1).getSystemMsg();
        } while ((((structmsg.StructMsg)localObject1).msg_type.get() != 2) || (((structmsg.StructMsg)localObject1).msg.get() == null));
        i = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
      } while ((i != 3) && (i != 15));
      l = ((structmsg.StructMsg)localObject1).msg.group_code.get();
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase("" + l)));
    this.a.bh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vxu
 * JD-Core Version:    0.7.0.1
 */