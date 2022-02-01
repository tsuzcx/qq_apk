import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87.CloneInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87.MsgNotify;

@TargetApi(11)
public class yrv
{
  public static final HashSet<String> aH = new HashSet();
  public static boolean bou;
  public static final HashMap<String, Long> he = new HashMap();
  
  private static void A(QQAppInterface paramQQAppInterface, String paramString)
  {
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, new ahwa(paramString, paramString, acfp.m(2131703964), 0, -5020, 2686977, anaz.gQ()));
    ahwb.a(paramQQAppInterface, localMessageForUniteGrayTip);
  }
  
  private static boolean F(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloneFriendPushHelper", 2, "initSet, uin=" + paramQQAppInterface.getCurrentUin() + ", hasInit=" + bou);
    }
    synchronized (aH)
    {
      if (bou) {
        return false;
      }
      aH.clear();
      paramQQAppInterface = paramQQAppInterface.getPreferences().getStringSet("cloneFriendPush_" + paramQQAppInterface.getCurrentUin(), null);
      if (paramQQAppInterface != null) {
        aH.addAll(paramQQAppInterface);
      }
      bou = true;
      return true;
    }
  }
  
  static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    b(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramInt);
    b(paramQQAppInterface, paramString2, paramString3, paramString4);
    A(paramQQAppInterface, paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SubMsgType0x87.MsgBody paramMsgBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloneFriendPushHelper", 2, "onLinePush onReceivePush, app=" + paramQQAppInterface + ", msgBody=" + paramMsgBody);
    }
    paramMsgBody = paramMsgBody.rpt_msg_msg_notify.get();
    int i;
    Object localObject1;
    Object localObject2;
    String str1;
    boolean bool;
    label172:
    String str2;
    String str3;
    int j;
    if ((paramMsgBody != null) && (paramMsgBody.size() > 0))
    {
      i = 0;
      if (i < paramMsgBody.size())
      {
        localObject1 = (SubMsgType0x87.MsgNotify)paramMsgBody.get(i);
        if ((localObject1 != null) && (((SubMsgType0x87.MsgNotify)localObject1).uint32_reqsubtype.get() == 2) && (((SubMsgType0x87.MsgNotify)localObject1).msg_clone_info.has()))
        {
          localObject2 = (SubMsgType0x87.CloneInfo)((SubMsgType0x87.MsgNotify)localObject1).msg_clone_info.get();
          if (localObject2 != null)
          {
            localObject1 = String.valueOf(((SubMsgType0x87.CloneInfo)localObject2).uint64_uin.get());
            str1 = ((SubMsgType0x87.CloneInfo)localObject2).bytes_remark.get().toStringUtf8();
            if (((SubMsgType0x87.CloneInfo)localObject2).uint32_show_in_aio.get() != 1) {
              break label300;
            }
            bool = true;
            str2 = String.valueOf(((SubMsgType0x87.CloneInfo)localObject2).uint64_to_uin.get());
            str3 = ((SubMsgType0x87.CloneInfo)localObject2).bytes_to_nick.get().toStringUtf8();
            j = ((SubMsgType0x87.CloneInfo)localObject2).uint32_src_gender.get();
            if (QLog.isColorLevel()) {
              QLog.d("CloneFriendPushHelper", 2, "cloneInfo, uinC=" + (String)localObject1 + ", nickC=" + str1 + ", showInAio=" + bool + ", uinB=" + str2 + ", nickB=" + str3 + ", gender=" + j);
            }
            if (bool) {
              break label306;
            }
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      label300:
      bool = false;
      break label172;
      label306:
      localObject2 = str2 + (String)localObject1 + paramQQAppInterface.getCurrentUin();
      if (he.get(localObject2) == null) {}
      for (long l1 = 0L;; l1 = ((Long)he.get(localObject2)).longValue())
      {
        long l2 = System.currentTimeMillis();
        he.put(localObject2, Long.valueOf(l2));
        if (Math.abs(l2 - l1) >= 60000L) {
          break;
        }
        QLog.d("CloneFriendPushHelper", 1, "onReceivePush, gap < 60s");
        return;
      }
      a(paramQQAppInterface, (String)localObject1, str1, str2, str3, j);
      paramQQAppInterface.reportClickEvent("CliOper", "", "", "0X8008071", "0X8008071", 0, 0, "", "", "", "");
      y(paramQQAppInterface, str2);
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    MessageForText localMessageForText = new MessageForText();
    localMessageForText.istroop = 0;
    localMessageForText.frienduin = paramString2;
    localMessageForText.senderuin = paramString2;
    localMessageForText.isread = true;
    localMessageForText.msg = String.format(acfp.m(2131703967), new Object[] { paramString1, paramString3, paramString2 });
    localMessageForText.time = anaz.gQ();
    paramQQAppInterface.b().b(localMessageForText, paramQQAppInterface.getCurrentUin());
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    Object localObject1 = acfp.m(2131703970);
    String str1 = String.format("%s(%s)", new Object[] { paramString2, paramString1 });
    Object localObject2 = acfp.m(2131703968);
    if (paramInt == 1) {}
    for (paramString2 = acfp.m(2131703962);; paramString2 = acfp.m(2131703965))
    {
      String str2 = String.format((String)localObject2, new Object[] { paramString2 });
      String str3 = String.format("%s(%s)", new Object[] { paramString4, paramString3 });
      paramString2 = acfp.m(2131703966);
      paramString4 = acfp.m(2131703963);
      localObject2 = new ahwa(paramString3, paramString3, (String)localObject1 + str1 + str2 + str3 + "的好友列表中。\n不想和他们是好友关系，可选择" + paramString2 + "。\n不想再被其他好友克隆，可选择" + paramString4 + "。", 0, -5040, 2686977, anaz.gQ());
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 44);
      localBundle.putString("key_action_DATA", paramString1);
      paramInt = ((String)localObject1).length();
      ((ahwa)localObject2).addHightlightItem(paramInt, str1.length() + paramInt, localBundle);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_action", 44);
      ((Bundle)localObject1).putString("key_action_DATA", paramString3);
      int i = str1.length();
      paramInt = str2.length() + (paramInt + i);
      ((ahwa)localObject2).addHightlightItem(paramInt, str3.length() + paramInt, (Bundle)localObject1);
      paramString3 = new Bundle();
      paramString3.putInt("key_action", 45);
      paramString3.putString("key_action_DATA", paramString1);
      paramString3.putString("key_a_action_DATA", String.format(acfp.m(2131703969), new Object[] { str1, str3 }));
      paramInt = paramInt + str3.length() + "的好友列表中。\n不想和他们是好友关系，可选择".length();
      ((ahwa)localObject2).addHightlightItem(paramInt, paramString2.length() + paramInt, paramString3);
      paramString1 = new Bundle();
      paramString1.putInt("key_action", 1);
      paramString1.putString("key_action_DATA", "https://ti.qq.com/friendship_auth/index.html?_wv=3#clone_setting");
      paramInt = paramInt + paramString2.length() + "。\n不想再被其他好友克隆，可选择".length();
      ((ahwa)localObject2).addHightlightItem(paramInt, paramString4.length() + paramInt, paramString1);
      localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, (ahwa)localObject2);
      ahwb.a(paramQQAppInterface, localMessageForUniteGrayTip);
      return;
    }
  }
  
  public static void release()
  {
    synchronized (aH)
    {
      bou = false;
      aH.clear();
      return;
    }
  }
  
  public static boolean t(QQAppInterface paramQQAppInterface, String paramString)
  {
    synchronized (aH)
    {
      if (!bou) {
        F(paramQQAppInterface);
      }
      boolean bool = aH.contains(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("CloneFriendPushHelper", 2, "hasUin, uin=" + paramString + ", has=" + bool);
      }
      return bool;
    }
  }
  
  private static void y(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloneFriendPushHelper", 2, "addUin, uin=" + paramString);
    }
    synchronized (aH)
    {
      if (!bou) {
        F(paramQQAppInterface);
      }
      if (!aH.contains(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CloneFriendPushHelper", 2, "addUin, not contains, need add");
        }
        aH.add(paramString);
        paramQQAppInterface.getPreferences().edit().putStringSet("cloneFriendPush_" + paramQQAppInterface.getCurrentUin(), aH).commit();
      }
      return;
    }
  }
  
  public static void z(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloneFriendPushHelper", 2, "removeUin, uin=" + paramString);
    }
    synchronized (aH)
    {
      if (!bou) {
        F(paramQQAppInterface);
      }
      if (aH.contains(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CloneFriendPushHelper", 2, "addUin, contains, need remove");
        }
        aH.remove(paramString);
        paramQQAppInterface.getPreferences().edit().putStringSet("cloneFriendPush_" + paramQQAppInterface.getCurrentUin(), aH).commit();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yrv
 * JD-Core Version:    0.7.0.1
 */