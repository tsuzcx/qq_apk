import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.bmqq.protocol.Crm.CrmCCNotify;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.hummer.resv.notonlinefile.tencent_im_msg_hummer_resv_notonlinefile.ResvAttr;
import tencent.im.msg.im_msg_body.CrmElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.im_msg_body.RichText;

public class asih
{
  public static void a(anbm paramanbm, msg_comm.Msg paramMsg, MessageRecord paramMessageRecord)
  {
    if ((paramanbm != null) && (paramanbm.friendType == 1024) && (paramMsg.msg_body.rich_text.has()) && (paramMsg.msg_body.rich_text.elems.has()))
    {
      paramanbm = paramMsg.msg_body.rich_text.elems.get().iterator();
      while (paramanbm.hasNext())
      {
        paramMsg = (im_msg_body.Elem)paramanbm.next();
        if ((paramMsg.has()) && (paramMsg.crm_elem.has()) && (paramMsg.crm_elem.crm_buf.has()))
        {
          Crm.CrmCCNotify localCrmCCNotify = new Crm.CrmCCNotify();
          try
          {
            localCrmCCNotify.mergeFrom(paramMsg.crm_elem.crm_buf.get().toByteArray());
            if (localCrmCCNotify.str_ext_nick_name.has()) {
              paramMessageRecord.saveExtInfoToExtStr("qidian_ext_nick_name", localCrmCCNotify.str_ext_nick_name.get());
            }
          }
          catch (InvalidProtocolBufferMicroException paramMsg)
          {
            QLog.d("QidianUtils", 2, "qidian add ext name in master session " + paramMsg);
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    int i;
    if (!TextUtils.isEmpty(paramString4))
    {
      i = paramString4.indexOf(paramQQAppInterface.getApp().getString(2131700353));
      if (i != -1) {}
    }
    else
    {
      return;
    }
    paramString4 = new ahwa(paramString1, paramQQAppInterface.getCurrentAccountUin(), paramString4, paramInt, -5023, 1245186, anaz.gQ());
    paramString4.ciH = false;
    paramString4.time = paramLong;
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_action", 12);
    paramString4.addHightlightItem(i, i + 4, (Bundle)localObject);
    localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramString4);
    ((MessageForUniteGrayTip)localObject).masterUin = paramString2;
    ((MessageForUniteGrayTip)localObject).extUin = paramString1;
    ((MessageForUniteGrayTip)localObject).taskId = paramString3;
    ahwb.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Crm.CrmCCNotify paramCrmCCNotify, msg_comm.Msg paramMsg, anbm paramanbm)
  {
    long l = paramMsg.msg_head.from_uin.get();
    if (paramanbm == null) {}
    for (int i = 0;; i = paramanbm.friendType)
    {
      c(paramQQAppInterface, String.valueOf(l), i, -2005, paramMsg.msg_head.msg_time.get(), paramCrmCCNotify.str_check_id.get());
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    long l = anaz.gQ();
    paramString1 = new ahwa(paramString1, paramQQAppInterface.getCurrentAccountUin(), paramString2, paramInt, -5020, 1245187, l);
    paramString1.ciH = false;
    paramString1.time = l;
    paramString1.bLT = paramString3;
    paramString2 = new MessageForUniteGrayTip();
    paramString2.initGrayTipMsg(paramQQAppInterface, paramString1);
    ahwb.a(paramQQAppInterface, paramString2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList, msg_comm.Msg paramMsg, anbm paramanbm, Crm.CrmCCNotify paramCrmCCNotify)
  {
    int i = 0;
    if (paramList.isEmpty()) {}
    do
    {
      return;
      paramList = (MessageRecord)paramList.get(0);
    } while ((paramList == null) || (paramList.isSend()));
    long l = paramMsg.msg_head.from_uin.get();
    if (paramanbm == null) {}
    for (;;)
    {
      int j = paramMsg.msg_head.msg_time.get();
      paramMsg = paramCrmCCNotify.str_check_id.get();
      c(paramQQAppInterface, String.valueOf(l), i, paramList.msgtype, j, paramMsg);
      return;
      i = paramanbm.friendType;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList, im_msg_body.NotOnlineFile paramNotOnlineFile, msg_comm.Msg paramMsg, anbm paramanbm)
  {
    if ((paramNotOnlineFile == null) || (!paramNotOnlineFile.bytes_pb_reserve.has())) {
      return;
    }
    Object localObject = paramNotOnlineFile.bytes_pb_reserve.get().toByteArray();
    try
    {
      paramNotOnlineFile = new tencent_im_msg_hummer_resv_notonlinefile.ResvAttr();
      paramNotOnlineFile.mergeFrom((byte[])localObject);
      localObject = new Crm.CrmCCNotify();
      ((Crm.CrmCCNotify)localObject).mergeFrom(paramNotOnlineFile.bytes_crm_buf.get().toByteArray());
      if ((((Crm.CrmCCNotify)localObject).str_ext_nick_name.has()) && (!paramList.isEmpty())) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("qidian_ext_nick_name", ((Crm.CrmCCNotify)localObject).str_ext_nick_name.get());
      }
      a(paramQQAppInterface, (Crm.CrmCCNotify)localObject, paramMsg, paramanbm);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  /* Error */
  public static int aD(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: ldc_w 298
    //   6: invokevirtual 302	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   9: astore_0
    //   10: bipush 24
    //   12: istore_2
    //   13: iconst_0
    //   14: istore_1
    //   15: iload_1
    //   16: istore 4
    //   18: iload_3
    //   19: aload_0
    //   20: arraylength
    //   21: if_icmpge +46 -> 67
    //   24: iload_1
    //   25: i2l
    //   26: lstore 5
    //   28: aload_0
    //   29: iload_3
    //   30: aaload
    //   31: invokestatic 308	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   34: lstore 7
    //   36: lload 5
    //   38: lload 7
    //   40: iload_2
    //   41: lshl
    //   42: lor
    //   43: l2i
    //   44: istore_1
    //   45: iload_3
    //   46: iconst_1
    //   47: iadd
    //   48: istore_3
    //   49: iload_2
    //   50: bipush 8
    //   52: isub
    //   53: istore_2
    //   54: goto -39 -> 15
    //   57: astore_0
    //   58: iconst_0
    //   59: istore_1
    //   60: aload_0
    //   61: invokevirtual 294	java/lang/Exception:printStackTrace	()V
    //   64: iload_1
    //   65: istore 4
    //   67: iload 4
    //   69: ireturn
    //   70: astore_0
    //   71: goto -11 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	paramString	String
    //   14	51	1	i	int
    //   12	42	2	j	int
    //   1	48	3	k	int
    //   16	52	4	m	int
    //   26	11	5	l1	long
    //   34	5	7	l2	long
    // Exception table:
    //   from	to	target	type
    //   2	10	57	java/lang/Exception
    //   18	24	70	java/lang/Exception
    //   28	36	70	java/lang/Exception
  }
  
  public static String b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    String str2 = paramChatMessage.getExtInfoFromExtStr("qidian_ext_nick_name");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = asgx.H(paramQQAppInterface, paramChatMessage.senderuin);
    }
    if ((TextUtils.isEmpty(str1)) && (QLog.isColorLevel())) {
      QLog.d("QidianUtils", 2, "qidian ext nickname is null");
    }
    return str1;
  }
  
  private static void c(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.equals(paramQQAppInterface.getCurrentAccountUin())) || (TextUtils.isEmpty(paramString2))) {}
    label134:
    label177:
    for (;;)
    {
      return;
      String str1 = "0";
      String str2;
      if (paramInt2 == -1000)
      {
        str1 = "1";
        str2 = null;
        if (paramInt1 != 0) {
          break label134;
        }
        str2 = "0X800980B";
      }
      for (;;)
      {
        if (str2 == null) {
          break label177;
        }
        anot.a(paramQQAppInterface, "dc00899", "Qidian", paramString1, str2, "1", 1, 0, str1, "0", String.valueOf(paramInt3), paramString2);
        return;
        if (paramInt2 == -2000)
        {
          str1 = "2";
          break;
        }
        if (paramInt2 == -2005)
        {
          str1 = "3";
          break;
        }
        if (paramInt2 != -2011) {
          break;
        }
        str1 = "4";
        break;
        if (paramInt1 == 1024) {
          str2 = "0X8009810";
        } else if (paramInt1 == 1025) {
          str2 = "0X8009811";
        } else if (paramInt1 == 1000) {
          str2 = "0X800980E";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asih
 * JD-Core Version:    0.7.0.1
 */