import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.app.MessageHandler.MsgSendCostParams;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class vsu
  extends MessageObserver
{
  public vsu(FriendChatPie paramFriendChatPie) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendChatPie", 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1, paramLong2);
      if ((paramString1 != null) && (paramString1.msgtype == -2058) && ((paramString1.extraflag == 32768) || (paramString1.sendFailCode == 41)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("FriendChatPie", 2, "onUpdateSendMsgError, sticker msg is failed!, now remove!");
        }
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, false);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendChatPie", 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    boolean bool;
    if (paramInt1 == 0)
    {
      paramSendMessageHandler = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1, paramLong2);
      if ((paramSendMessageHandler != null) && (paramSendMessageHandler.msgtype == -2058) && ((paramSendMessageHandler.extraflag == 32768) || (paramSendMessageHandler.sendFailCode == 41)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("FriendChatPie", 2, "onUpdateSendMsgError, sticker msg is failed!");
        }
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramSendMessageHandler, false);
        paramString1 = MsgProxyUtils.a(paramString1, paramInt1);
        if (!EmojiStickerManager.a().b.containsKey(paramString1)) {
          break label438;
        }
        paramLong1 = ((Long)EmojiStickerManager.a().b.get(paramString1)).longValue();
        if (System.currentTimeMillis() - paramLong1 <= 300000L) {
          break label444;
        }
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendChatPie", 2, "send sticker msg fail, is need send Toast " + bool);
      }
      if (bool)
      {
        EmojiStickerManager.a().b.put(paramString1, Long.valueOf(System.currentTimeMillis()));
        ThreadManager.getUIHandler().post(new vsv(this, paramSendMessageHandler));
      }
      this.a.b(196608);
      return;
      label438:
      bool = true;
      continue;
      label444:
      bool = false;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      ChatActivityUtils.b();
      if (paramBoolean) {
        this.a.k();
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    a(paramBoolean, paramString, paramLong, null);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong, MessageHandler.MsgSendCostParams paramMsgSendCostParams)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.a.q = true;
    this.a.a(262144, paramMsgSendCostParams, paramLong);
  }
  
  public void b(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgSend", 4, "delay 100ms, starting upadte ui");
    }
    this.a.b(131072);
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      ChatActivityUtils.b();
      if (paramBoolean) {
        this.a.k();
      }
    }
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    this.a.b(65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vsu
 * JD-Core Version:    0.7.0.1
 */