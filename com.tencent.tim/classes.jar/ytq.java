import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ytq
  extends ytv
{
  public MessageForSystemMsg a;
  
  public ytq(MessageForSystemMsg paramMessageForSystemMsg)
  {
    this.a = paramMessageForSystemMsg;
    this.message = this.a.extStr;
    this.Kz = paramMessageForSystemMsg.time;
    this.boG = a(this.a.getSystemMsg());
  }
  
  public ytq(String paramString, long paramLong)
  {
    this.message = paramString;
    this.Kz = paramLong;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, structmsg.StructMsg paramStructMsg, boolean paramBoolean)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    boolean bool2;
    int i;
    label79:
    label93:
    boolean bool4;
    if ((paramStructMsg != null) && (paramStructMsg.msg.uint32_source_flag.has()) && (paramQQAppInterface != null))
    {
      paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
      if ((paramBoolean) && (paramQQAppInterface != null) && (paramQQAppInterface.isFriend(paramString)))
      {
        bool2 = true;
        i = paramStructMsg.msg.uint32_source_flag.get();
        if ((i & 0x10) != 0)
        {
          bool1 = true;
          if (!paramBoolean) {
            break label191;
          }
          if ((!bool1) || (bool2)) {
            break label185;
          }
          bool4 = bool1;
          bool1 = bool3;
          bool3 = bool4;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("isMsgFromWZRY", 2, "result=" + bool1 + ",isFromWzry=" + bool3 + ",sourceFlag=" + i + ",isFriend=" + bool2 + ",checkFriend=" + paramBoolean);
      }
      return bool1;
      bool1 = false;
      break label79;
      label185:
      bool3 = false;
      break label93;
      label191:
      bool3 = bool1;
      continue;
      bool2 = false;
      break;
      bool2 = false;
      i = 0;
      bool4 = false;
      bool3 = bool1;
      bool1 = bool4;
    }
  }
  
  public static boolean a(structmsg.StructMsg paramStructMsg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramStructMsg != null)
    {
      bool1 = bool2;
      if (paramStructMsg.msg != null)
      {
        bool1 = bool2;
        if (paramStructMsg.msg.uint32_doubt_flag.has())
        {
          bool1 = bool2;
          if (paramStructMsg.msg.uint32_doubt_flag.get() > 0) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String getNickName()
  {
    if (this.a.structMsg.msg.req_uin_nick.has()) {
      return this.a.structMsg.msg.req_uin_nick.get();
    }
    return null;
  }
  
  public String getUin()
  {
    return String.valueOf(this.a.structMsg.req_uin.get());
  }
  
  public boolean isReaded()
  {
    return this.a.isread;
  }
  
  public String o(QQAppInterface paramQQAppInterface)
  {
    if ((this.a != null) && (TextUtils.isEmpty(this.a.msg)))
    {
      this.a.parse();
      this.a.msg = MessageForSystemMsg.getSysMsgDesc(paramQQAppInterface.getApp().getResources(), this.a.structMsg);
      this.message = this.a.msg;
    }
    return this.message;
  }
  
  public String pR()
  {
    if (!TextUtils.isEmpty(this.a.structMsg.msg.msg_additional.get()))
    {
      if (!TextUtils.isEmpty(this.a.structMsg.msg.msg_qna.get())) {
        return this.a.structMsg.msg.msg_qna.get();
      }
      return this.a.structMsg.msg.msg_additional.get();
    }
    return this.a.structMsg.msg.msg_describe.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ytq
 * JD-Core Version:    0.7.0.1
 */