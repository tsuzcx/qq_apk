import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.FriendShipFlagNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.HotFriendNotify;

public class ajom
{
  private static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, long paramLong1, String paramString2, long paramLong2, long paramLong3, int paramInt5) {}
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    int i;
    try
    {
      localObject2 = aqgv.D(paramQQAppInterface, paramString1);
      localObject1 = (acff)paramQQAppInterface.getManager(51);
      i = -5020;
      if (!QLog.isColorLevel()) {
        break label624;
      }
      QLog.d("FriendReactive", 2, "addLoveGrayTips type=" + paramInt1 + "subtype=" + paramInt2 + "LoverMainkeyText=" + paramString2 + "loveSubkeyText=" + paramString3);
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("FriendReactive", 2, "addLoveGrayTips exception" + paramQQAppInterface.toString());
      return;
    }
    Object localObject1 = paramString2;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject1 = paramString2;
      if (paramString2.contains("{friend_nick_name}")) {
        localObject1 = paramString2.replace("{friend_nick_name}", (CharSequence)localObject2);
      }
    }
    Object localObject2 = aejl.a().b("" + paramInt2);
    paramString2 = (String)localObject2;
    if (localObject2 == null) {
      paramString2 = new aejk().b("0");
    }
    localObject2 = paramString2.byb;
    switch (paramString2.cNt)
    {
    }
    for (;;)
    {
      localObject2 = new ahwa(paramString1, paramString1, (String)localObject1, 0, paramInt1, 655384, anaz.gQ());
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 1);
      localBundle.putString("key_action_DATA", paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("FriendReactive", 2, "addLoveGrayTips jumpurl=" + paramString2);
      }
      paramInt1 = ((String)localObject1).length() - paramString3.length();
      if (paramInt1 >= 0) {
        ((ahwa)localObject2).addHightlightItem(paramInt1, ((String)localObject1).length(), localBundle);
      }
      paramString2 = new MessageForUniteGrayTip();
      paramString2.hasRead = 0;
      paramString2.subType = 9;
      paramString2.initGrayTipMsg(paramQQAppInterface, (ahwa)localObject2);
      paramString2.saveExtInfoToExtStr("love_c2c_aio_businessSubtype", paramInt2 + "");
      paramString3 = new StringBuilder(21);
      paramString3.append(paramLong1).append("_").append(paramLong2);
      paramString2.tipParam.bLT = paramString3.toString();
      paramString1 = paramQQAppInterface.b().k(paramString1, 0);
      if ((paramString1 != null) && (!paramString1.isEmpty()))
      {
        paramString1 = (MessageRecord)paramString1.get(paramString1.size() - 1);
        if (((paramString1 instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)paramString1).tipParam != null) && (((MessageForUniteGrayTip)paramString1).subType == paramString2.subType) && (((MessageForUniteGrayTip)paramString1).tipParam.wording.equals(paramString2.tipParam.wording)) && (paramString2.tipParam.time - ((MessageForUniteGrayTip)paramString1).tipParam.time <= 1L))
        {
          if (!QLog.isColorLevel()) {
            break label629;
          }
          QLog.d("FriendReactive", 2, "addLoveGrayTips look! backend give repeat push!");
          return;
          paramString2 = paramString2 + paramString3;
          paramInt1 = -5023;
          break;
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        ahwb.a(paramQQAppInterface, paramString2);
        return;
        label624:
        if (paramInt2 >= 2) {}
      }
      else
      {
        label629:
        return;
      }
      switch (paramInt1)
      {
      }
      paramString2 = "";
      paramInt1 = i;
      break;
      paramString2 = "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1";
      continue;
      paramString2 = (String)localObject2;
      continue;
      paramString2 = (String)localObject2;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, submsgtype0xc7.HotFriendNotify paramHotFriendNotify, acrj paramacrj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_PushMessage", 2, "decodeC2CMsgPkgSubMsgType0xc7");
    }
    long l3 = paramacrj.msgSeq;
    long l4 = paramacrj.msgUid;
    acff localacff;
    long l2;
    Object localObject1;
    String str1;
    int i;
    Object localObject3;
    Object localObject4;
    Object localObject2;
    Bundle localBundle;
    String str2;
    int j;
    int m;
    if (paramHotFriendNotify != null)
    {
      localacff = (acff)paramQQAppInterface.getManager(51);
      l2 = paramHotFriendNotify.uint64_dst_uin.get();
      localObject1 = String.valueOf(l2);
      str1 = aqgv.D(paramQQAppInterface, (String)localObject1);
      i = 1;
      if (paramHotFriendNotify.bytes_wildcard_wording.has())
      {
        localObject3 = ajol.a(paramQQAppInterface, paramHotFriendNotify.bytes_wildcard_wording.get().toStringUtf8(), str1, localacff);
        localObject4 = ajol.a(paramQQAppInterface, (String)((List)localObject3).get(0), (String)localObject1);
        str1 = (String)((List)localObject4).get(0);
        ((List)localObject3).remove(0);
        ((List)localObject4).remove(0);
        localObject2 = new ahwa((String)localObject1, (String)localObject1, str1, 0, -5040, 2097153, anaz.gQ());
        if ((localObject4 != null) && (((List)localObject4).size() > 0))
        {
          i = 0;
          while (i < ((List)localObject4).size())
          {
            localBundle = new Bundle();
            str2 = (String)((List)localObject4).get(i);
            if (!TextUtils.isEmpty(str2))
            {
              localBundle.putString("image_resource", str2);
              j = str1.lastIndexOf(str2);
              if (j >= 0) {
                ((ahwa)localObject2).addHightlightItem(j, str2.length() + j, localBundle);
              }
              if (QLog.isColorLevel()) {
                QLog.d("reactive", 2, "addHotFriendAIOGrayTips grayStr=" + str1 + "iconPos=" + j + "icon=" + str2 + "grayStr=" + str1);
              }
            }
            i += 1;
          }
        }
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          Collections.sort((List)localObject3, new ajon());
          localObject4 = new ArrayList();
          j = 0;
          if (j < ((List)localObject3).size())
          {
            localBundle = new Bundle();
            str2 = (String)((List)localObject3).get(j);
            if (!TextUtils.isEmpty(str2))
            {
              localBundle.putInt("key_action", 11);
              localBundle.putString("key_action_DATA", str2);
              i = 0;
              m = str1.indexOf(str2, i);
              if (m >= 0) {
                break label476;
              }
            }
          }
        }
      }
    }
    label462:
    label2382:
    label2389:
    for (;;)
    {
      label476:
      int n;
      if (m < 0)
      {
        j += 1;
        break;
        n = str2.length();
        i = m + n;
        Iterator localIterator = ((ArrayList)localObject4).iterator();
        Pair localPair;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localPair = (Pair)localIterator.next();
        } while ((m < ((Integer)localPair.first).intValue()) || (m >= ((Integer)localPair.second).intValue()));
      }
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label2389;
        }
        ((ArrayList)localObject4).add(new Pair(Integer.valueOf(m), Integer.valueOf(m + n)));
        if (m >= 0)
        {
          ((ahwa)localObject2).addHightlightItem(m, i, localBundle);
          if (QLog.isColorLevel()) {
            QLog.d("Old0x210C7PushHelper", 2, "spanPos=" + m + " fromIndex=" + i);
          }
        }
        break label462;
        break;
        localObject3 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject3).hasRead = 0;
        ((MessageForUniteGrayTip)localObject3).initGrayTipMsg(paramQQAppInterface, (ahwa)localObject2);
        localObject2 = new StringBuilder(21);
        ((StringBuilder)localObject2).append(l3).append("_").append(l4);
        ((MessageForUniteGrayTip)localObject3).tipParam.bLT = ((StringBuilder)localObject2).toString();
        localObject1 = paramQQAppInterface.b().k((String)localObject1, 0);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          localObject1 = (MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1);
          if (((localObject1 instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localObject1).tipParam != null) && (((MessageForUniteGrayTip)localObject1).subType == ((MessageForUniteGrayTip)localObject3).subType) && (((MessageForUniteGrayTip)localObject1).tipParam.wording.equals(((MessageForUniteGrayTip)localObject3).tipParam.wording)) && (((MessageForUniteGrayTip)localObject3).tipParam.time - ((MessageForUniteGrayTip)localObject1).tipParam.time <= 1L))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendReactive", 2, "addHotFriendAIOGray look! backend give repeat push!");
            }
            return;
          }
        }
        if (!TextUtils.isEmpty(str1)) {
          ahwb.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject3);
        }
        i = 0;
        if (!paramHotFriendNotify.uint32_notify_type.has())
        {
          localObject2 = new ArrayList();
          paramacrj = localacff.a(String.valueOf(l2));
          if (paramacrj != null) {
            break label2382;
          }
          paramacrj = new ExtensionInfo();
          paramacrj.uin = String.valueOf(l2);
        }
        for (;;)
        {
          localObject3 = new StringBuilder(128);
          ((StringBuilder)localObject3).append(" === hotFriend uin: ").append(l2);
          ((StringBuilder)localObject3).append(" msgUid: ").append(l4).append(" msgSeq: ").append(l3);
          boolean bool1 = false;
          boolean bool2 = false;
          if (paramHotFriendNotify.uint64_notify_time.has())
          {
            l1 = paramHotFriendNotify.uint64_notify_time.get();
            long l5 = paramQQAppInterface.getPreferences().getLong("inccheckupdatetimeStamp9", 0L);
            bool1 = bool2;
            if (l1 < l5)
            {
              ((StringBuilder)localObject3).append(", notify_time is out of date notifyTime=" + l1 + "timeStamps=" + l5);
              if (QLog.isColorLevel()) {
                QLog.i("HotFriend_PushMessage", 2, ((StringBuilder)localObject3).toString());
              }
              bool1 = true;
            }
            ((StringBuilder)localObject3).append(", notify_time" + l1 + "timeStamps=" + l5);
          }
          long l1 = -1L;
          if (paramHotFriendNotify.uint64_notify_time.has()) {
            l1 = paramHotFriendNotify.uint64_notify_time.get();
          }
          j = i;
          if (paramacrj != null)
          {
            j = i;
            if (paramacrj.lastGrayPushTime == l1)
            {
              j = i;
              if (l1 != -1L)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendReactive", 2, "addHotFriendAIOGrayTips lastPushTime=" + l1 + "needAddGray isfalse");
                }
                j = 0;
              }
            }
            paramacrj.lastGrayPushTime = l1;
          }
          if (paramHotFriendNotify.uint32_praise_hot_level.has())
          {
            i = paramacrj.praiseHotLevel;
            k = paramHotFriendNotify.uint32_praise_hot_level.get();
            paramacrj.praiseHotLevel = k;
            ((StringBuilder)localObject3).append(", praiseHotLevel=").append(k);
            if (paramHotFriendNotify.uint32_praise_flag.has())
            {
              m = paramHotFriendNotify.uint32_praise_flag.get();
              if (j != 0) {
                a(paramQQAppInterface, 1, k, m, String.valueOf(l2), i, l1, null, l3, l4, paramHotFriendNotify.uint32_show_recheck_entry.get());
              }
            }
          }
          if (paramHotFriendNotify.uint32_praise_hot_days.has())
          {
            i = paramHotFriendNotify.uint32_praise_hot_days.get();
            paramacrj.praiseDays = i;
            ((StringBuilder)localObject3).append(", praiseDays=").append(i);
          }
          if (paramHotFriendNotify.uint32_chat_hot_level.has())
          {
            i = paramHotFriendNotify.uint32_chat_hot_level.get();
            k = paramacrj.chatHotLevel;
            paramacrj.chatHotLevel = i;
            ((StringBuilder)localObject3).append(", chatHotLevel=").append(i);
            if (paramHotFriendNotify.uint32_chat_flag.has())
            {
              m = paramHotFriendNotify.uint32_chat_flag.get();
              if (j != 0) {
                a(paramQQAppInterface, 2, i, m, String.valueOf(l2), k, l1, null, l3, l4, paramHotFriendNotify.uint32_show_recheck_entry.get());
              }
            }
          }
          str1 = null;
          if (paramHotFriendNotify.bytes_key_wording.has()) {
            str1 = paramHotFriendNotify.bytes_key_wording.get().toStringUtf8();
          }
          i = -1;
          k = paramacrj.loverChatLevel;
          if (paramHotFriendNotify.uint32_key_hot_level.has())
          {
            i = paramHotFriendNotify.uint32_key_hot_level.get();
            paramacrj.loverChatLevel = i;
            ((StringBuilder)localObject3).append(", loverChatLevel=").append(i);
          }
          if (paramHotFriendNotify.uint32_key_trans_flag.has())
          {
            if (paramHotFriendNotify.uint32_key_trans_flag.get() != 0)
            {
              bool2 = true;
              paramacrj.loverTransFlag = bool2;
              ((StringBuilder)localObject3).append(", loverTransFlag=").append(paramacrj.loverTransFlag);
            }
          }
          else
          {
            if (paramHotFriendNotify.uint32_key_flag.has())
            {
              m = paramHotFriendNotify.uint32_key_flag.get();
              paramacrj.loverFlag = m;
              ((StringBuilder)localObject3).append(", loverFlag=").append(m);
              if (j != 0) {
                a(paramQQAppInterface, 5, i, m, String.valueOf(l2), k, l1, str1, l3, l4, paramHotFriendNotify.uint32_show_recheck_entry.get());
              }
            }
            str1 = null;
            if (paramHotFriendNotify.loverKeyMainWording.has()) {
              str1 = paramHotFriendNotify.loverKeyMainWording.get().toStringUtf8();
            }
            localObject1 = null;
            if (paramHotFriendNotify.loverKeyLinkWording.has()) {
              localObject1 = paramHotFriendNotify.loverKeyLinkWording.get().toStringUtf8();
            }
            i = -1;
            if (paramHotFriendNotify.loverKeySubBusinessType.has()) {
              i = paramHotFriendNotify.loverKeySubBusinessType.get();
            }
            if (paramHotFriendNotify.loverKeyBusinessType.has())
            {
              k = paramHotFriendNotify.loverKeyBusinessType.get();
              if (j != 0) {
                a(paramQQAppInterface, k, i, String.valueOf(l2), str1, (String)localObject1, l3, l4);
              }
            }
            if (paramHotFriendNotify.uint32_key_hot_days.has())
            {
              i = paramHotFriendNotify.uint32_key_hot_days.get();
              paramacrj.loverChatDays = i;
              ((StringBuilder)localObject3).append(", loverChatDays=").append(i);
            }
            if (paramHotFriendNotify.uint32_chat_hot_days.has())
            {
              i = paramHotFriendNotify.uint32_chat_hot_days.get();
              paramacrj.chatDays = i;
              ((StringBuilder)localObject3).append(", chatDays=").append(i);
            }
            if (!ajol.arn()) {
              break label2229;
            }
            if (paramHotFriendNotify.uint32_boat_level.has())
            {
              i = paramacrj.newBestIntimacyType;
              k = paramHotFriendNotify.uint32_boat_level.get();
              paramacrj.newBestIntimacyType = k;
              ((StringBuilder)localObject3).append(", boatLevel=").append(k);
              if (paramHotFriendNotify.uint32_boat_flag.has())
              {
                m = paramHotFriendNotify.uint32_boat_flag.get();
                if (paramHotFriendNotify.bytes_boat_wording.has()) {
                  paramHotFriendNotify.bytes_boat_wording.get().toStringUtf8();
                }
                if (j != 0) {
                  a(paramQQAppInterface, 6, k, m, String.valueOf(l2), i, l1, null, l3, l4, paramHotFriendNotify.uint32_show_recheck_entry.get());
                }
              }
            }
          }
          for (;;)
          {
            if (paramHotFriendNotify.uint32_close_days.has())
            {
              i = paramHotFriendNotify.uint32_close_days.get();
              paramacrj.bestIntimacyDays = i;
              ((StringBuilder)localObject3).append(", closeDays=").append(i);
            }
            if (paramHotFriendNotify.uint64_last_praise_time.has())
            {
              l1 = paramHotFriendNotify.uint64_last_praise_time.get();
              paramacrj.lastpraiseTime = (86400L * l1 - 28800L);
              ((StringBuilder)localObject3).append(", lastpraiseTime=").append(l1);
            }
            if (paramHotFriendNotify.uint64_last_chat_time.has())
            {
              l1 = paramHotFriendNotify.uint64_last_chat_time.get();
              paramacrj.lastChatTime = (86400L * l1 - 28800L);
              ((StringBuilder)localObject3).append(", lastchatTime=").append(l1);
            }
            if (paramHotFriendNotify.uint64_last_key_time.has())
            {
              l1 = paramHotFriendNotify.uint64_last_key_time.get();
              paramacrj.loverLastChatTime = (86400L * l1 - 28800L);
              ((StringBuilder)localObject3).append(", lastLoverChatTime=").append(l1);
            }
            if (QLog.isColorLevel()) {
              QLog.i("HotFriend_PushMessage", 2, ((StringBuilder)localObject3).toString() + "isTimeOutOfDate=" + bool1);
            }
            if (bool1) {
              break;
            }
            localacff.a(paramacrj);
            ((ArrayList)localObject2).add(String.valueOf(l2));
            if (((ArrayList)localObject2).isEmpty()) {
              break;
            }
            paramQQAppInterface.getBusinessHandler(1).notifyUI(107, true, localObject2);
            return;
            bool2 = false;
            break label1554;
            if (paramHotFriendNotify.uint32_close_level.has())
            {
              i = paramacrj.bestIntimacyType;
              k = paramHotFriendNotify.uint32_close_level.get();
              paramacrj.bestIntimacyType = k;
              ((StringBuilder)localObject3).append(", closeLevel=").append(k);
              if (paramHotFriendNotify.uint32_close_flag.has())
              {
                m = paramHotFriendNotify.uint32_close_flag.get();
                if (j != 0) {
                  a(paramQQAppInterface, 3, k, m, String.valueOf(l2), i, l1, null, l3, l4, paramHotFriendNotify.uint32_show_recheck_entry.get());
                }
              }
            }
          }
          if ((paramHotFriendNotify.uint32_notify_type.get() != 1) || (!paramHotFriendNotify.msg_friendship_flag_notify.has())) {
            break;
          }
          ajol.a(paramQQAppInterface, paramacrj, (submsgtype0xc7.FriendShipFlagNotify)paramHotFriendNotify.msg_friendship_flag_notify.get());
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("HotFriend_PushMessage", 2, "decodeC2CMsgPkgSubMsgType0xc7 data is null");
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajom
 * JD-Core Version:    0.7.0.1
 */