import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QAVHrMeeting.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

public class aqjl
{
  static void C(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject1 = (acdu)paramQQAppInterface.getManager(53);
    Object localObject2 = (acdt)paramQQAppInterface.getBusinessHandler(6);
    QLog.d("QAVHrMeeting", 1, "HR_meeting Finish quit DiscussionId[" + paramLong + "]");
    ((acdt)localObject2).hm(paramLong);
    ((acdu)localObject1).jV(String.valueOf(paramLong));
    localObject1 = paramQQAppInterface.a().a();
    localObject2 = ((acxw)localObject1).b(String.valueOf(paramLong), 3000);
    if (localObject2 != null) {
      ((acxw)localObject1).f((RecentUser)localObject2);
    }
    ((acdt)paramQQAppInterface.getBusinessHandler(6)).cIk();
  }
  
  public static String Ce()
  {
    return BaseApplicationImpl.getApplication().getResources().getString(2131694710);
  }
  
  public static Bundle a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    long l1 = 0L;
    paramBundle = paramBundle.getString("uin");
    paramQQAppInterface = ((acdu)paramQQAppInterface.getManager(53)).a(paramBundle);
    int i = -1;
    long l2;
    if (paramQQAppInterface != null)
    {
      l2 = paramQQAppInterface.mOrigin;
      l1 = paramQQAppInterface.mOriginExtra;
      if (cW(l2)) {
        i = paramQQAppInterface.mSelfRight;
      }
    }
    for (;;)
    {
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putLong("Origin", l2);
      paramQQAppInterface.putLong("OriginExtra", l1);
      paramQQAppInterface.putInt("SelfRight", i);
      if (AudioHelper.aCz()) {
        QLog.w("QAVHrMeeting", 1, "GetDiscussOrigin, uin[" + paramBundle + "], Origin[" + l2 + "], OriginExtra[" + l1 + "], mSelfRight[" + i + "]");
      }
      return paramQQAppInterface;
      i = 0;
      continue;
      l2 = 0L;
    }
  }
  
  public static String a(acdu paramacdu, String paramString1, String paramString2)
  {
    paramacdu = paramacdu.n(paramString1);
    if (paramacdu != null)
    {
      paramacdu = (DiscussionMemberInfo)paramacdu.get(paramString2);
      if (paramacdu != null) {
        if (!TextUtils.isEmpty(paramacdu.inteRemark)) {
          paramacdu = paramacdu.inteRemark;
        }
      }
    }
    for (;;)
    {
      paramString1 = paramacdu;
      if (TextUtils.isEmpty(paramacdu)) {
        paramString1 = Ce();
      }
      return paramString1;
      if (!TextUtils.isEmpty(paramacdu.memberName)) {
        paramacdu = paramacdu.memberName;
      } else {
        paramacdu = "";
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, DiscussionInfo paramDiscussionInfo)
  {
    DiscussionInfo localDiscussionInfo = paramDiscussionInfo;
    if (paramDiscussionInfo == null) {
      localDiscussionInfo = ((acdu)paramQQAppInterface.getManager(53)).a(String.valueOf(paramLong));
    }
    if (localDiscussionInfo == null) {}
    while (((localDiscussionInfo.mOrigin & 0x2) == 2L) || ((localDiscussionInfo.mOrigin & 0x4) != 4L)) {
      return;
    }
    C(paramQQAppInterface, paramLong);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, int paramInt, long paramLong)
  {
    if (paramInt != 2) {}
    DiscussionInfo localDiscussionInfo;
    do
    {
      return;
      localDiscussionInfo = ((acdu)paramQQAppInterface.getManager(53)).a(String.valueOf(paramLong));
    } while ((localDiscussionInfo == null) || (!localDiscussionInfo.isDiscussHrMeeting()));
    paramInt = paramIntent.getIntExtra("quitReson", -1);
    if ((paramInt != 20) && (paramInt != 7)) {
      a(paramQQAppInterface, paramLong, localDiscussionInfo);
    }
    if (mv(localDiscussionInfo.mSelfRight)) {
      ((acdt)paramQQAppInterface.getBusinessHandler(6)).hk(paramLong);
    }
    QLog.e("QAVHrMeeting", 1, "do Report, lFlag=" + localDiscussionInfo.mOrigin);
    paramLong = paramQQAppInterface.a().bF();
    long l = System.currentTimeMillis();
    adaa.a(paramQQAppInterface).ag(paramLong, l);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo, DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    if (!paramDiscussionInfo.isDiscussHrMeeting()) {
      return;
    }
    paramDiscussionMemberInfo.memberName = Ce();
    paramDiscussionMemberInfo.inteRemark = paramDiscussionMemberInfo.memberName;
    a(paramQQAppInterface, paramDiscussionInfo.uin, paramDiscussionMemberInfo.memberUin, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, aqjl.a parama)
  {
    AudioHelper.rw("获取hr信息_delay_" + paramString2);
    String str = "https://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/get_nickname_video_meeting_for_hr?uin=" + paramString2 + "&discid=" + paramString1;
    ThreadManager.post(new QAVHrMeeting.1("QAVHrMeeting_" + AudioHelper.hG(), str, paramString2, paramQQAppInterface, paramString1, parama), 5, null, false);
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo)
  {
    if ((paramDiscussionInfo.mOrigin & 0x2) != 2L) {
      return;
    }
    boolean bool = mv(paramDiscussionInfo.mSelfRight);
    long l = paramDiscussionInfo.uiControlFlag;
    acdu localacdu;
    if (bool)
    {
      localacdu = (acdu)paramQQAppInterface.getManager(53);
      paramQQAppInterface = (acdt)paramQQAppInterface.getBusinessHandler(6);
      if (paramDiscussionInfo.getHrExtra() != 1) {
        break label176;
      }
      localacdu.jT(paramDiscussionInfo.uin);
      paramQQAppInterface.notifyUI(1004, true, paramDiscussionInfo.uin);
    }
    for (;;)
    {
      QLog.w("QAVHrMeeting", 1, "checkHrConfHidden[" + paramString + "], mSelfRight[" + paramDiscussionInfo.mSelfRight + "][" + bool + "], uiControlFlag[" + l + "->" + paramDiscussionInfo.uiControlFlag + "], getHrExtra[" + paramDiscussionInfo.getHrExtra() + "]");
      return;
      label176:
      localacdu.jU(paramDiscussionInfo.uin);
      Long.parseLong(paramDiscussionInfo.uin);
      paramQQAppInterface = paramDiscussionInfo.discussionName;
    }
  }
  
  public static int ah(long paramLong)
  {
    return (int)(0x3 & paramLong);
  }
  
  public static int ai(long paramLong)
  {
    long l2 = 0L;
    boolean bool = false;
    Object localObject1 = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("uin", String.valueOf(paramLong));
    localObject1 = ((VideoAppInterface)localObject1).a(5, 0, 0, (Bundle)localObject2, null);
    int i = -1;
    long l1;
    if (localObject1 != null)
    {
      l2 = ((Bundle)localObject1).getLong("Origin", 0L);
      l1 = ((Bundle)localObject1).getLong("OriginExtra", 0L);
      i = ((Bundle)localObject1).getInt("SelfRight", 0);
    }
    for (;;)
    {
      localObject2 = new StringBuilder().append("getStasks, relationId[").append(paramLong).append("], mOrigin[").append(l2).append("], mOriginExtra[").append(l1).append("], mSelfRight[").append(i).append("], rsp[");
      if (localObject1 != null) {
        bool = true;
      }
      QLog.w("QAVHrMeeting", 1, bool + "]");
      return i;
      l1 = 0L;
    }
  }
  
  public static void bh(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (acdt)paramQQAppInterface.getBusinessHandler(6);
    paramQQAppInterface.notifyUI(1000, true, null);
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(paramString);
    localArrayList.add(1, Boolean.valueOf(true));
    paramQQAppInterface.notifyUI(1001, true, localArrayList);
  }
  
  public static boolean cV(long paramLong)
  {
    return (paramLong & 1L) == 1L;
  }
  
  public static boolean cW(long paramLong)
  {
    return (0x6 & paramLong) != 0L;
  }
  
  public static void f(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("uin");
    ((acdt)paramQQAppInterface.getBusinessHandler(6)).aw(Long.valueOf(paramBundle).longValue(), 1);
  }
  
  public static boolean mv(int paramInt)
  {
    return (paramInt == -1) || ((paramInt & 0x8) == 8);
  }
  
  public static void n(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.msgtype == -2016) || (paramMessageRecord.msgtype == -4008) || (paramMessageRecord.istroop != 3000)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.w("QAVHrMeeting", 1, "onMsgUpdae, curFriendUin[" + paramMessageRecord.frienduin + "], senderuin[" + paramMessageRecord.senderuin + "], isSendFromLocal[" + paramMessageRecord.isSendFromLocal() + "], isSend[" + paramMessageRecord.isSend() + "], msgtype[" + paramMessageRecord.msgtype + "], isread[" + paramMessageRecord.isread + "], msgseq[" + paramMessageRecord.msgseq + "], uniseq[" + paramMessageRecord.uniseq + "], msg[" + AudioHelper.s(paramMessageRecord.msg) + "]");
            }
            if (!paramMessageRecord.isSend()) {
              break;
            }
          } while (!paramMessageRecord.isSendFromLocal());
          localObject = ((acdu)paramQQAppInterface.getManager(53)).a(paramMessageRecord.frienduin);
        } while ((localObject == null) || (!((DiscussionInfo)localObject).isDiscussHrMeeting()) || (mv(((DiscussionInfo)localObject).mSelfRight)) || (((DiscussionInfo)localObject).getHrExtra() != 1));
        ((acdt)paramQQAppInterface.getBusinessHandler(6)).aw(Long.valueOf(paramMessageRecord.frienduin).longValue(), 2);
        return;
      } while (paramMessageRecord.msgtype != -1000);
      localObject = (acdu)paramQQAppInterface.getManager(53);
      paramMessageRecord = ((acdu)localObject).a(paramMessageRecord.frienduin);
    } while ((paramMessageRecord == null) || (!paramMessageRecord.isHidden()) || (paramMessageRecord.getHrExtra() != 1));
    paramMessageRecord.mOriginExtra = 2L;
    ((acdu)localObject).d(paramMessageRecord);
    a("onMsgUpdae", paramQQAppInterface, paramMessageRecord);
    bh(paramQQAppInterface, paramMessageRecord.uin);
  }
  
  public static abstract interface a
  {
    public abstract void onComplete(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqjl
 * JD-Core Version:    0.7.0.1
 */