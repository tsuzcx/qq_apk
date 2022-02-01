import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.aio.media.aio_media.ResultInfo;
import tencent.aio.media.aio_media.RspLatestPlayingState;
import tencent.aio.media.aio_media.TypeVideo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.VideoChangePushInfo;

public class aiia
  implements aoih
{
  private QQAppInterface mApp;
  
  public aiia(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, String paramString, int paramInt2, long paramLong2, long paramLong3, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WatchTogetherParser", 2, "insertGrayTips begin uin:" + paramLong1 + " uinType:" + paramInt1 + " grayTips:" + paramString + " sub_type:" + paramInt2 + " msgSeq:" + paramLong2 + " msgTime:" + paramLong3 + " grayId=" + paramInt3);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramLong1 <= 0L)) {}
    Object localObject;
    boolean bool;
    do
    {
      return;
      int i = -5020;
      if ((paramInt2 == 2) || (paramInt2 == 5)) {
        i = -5040;
      }
      localObject = String.valueOf(paramLong1);
      paramString = new ahwa((String)localObject, (String)localObject, paramString, paramInt1, i, paramInt3, anaz.gQ());
      localObject = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject).hasRead = 0;
      ((MessageForUniteGrayTip)localObject).subType = paramInt2;
      ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramString);
      ((MessageForUniteGrayTip)localObject).tipParam.bLT = (paramLong1 + "_" + paramInt1 + "_watch_together_" + paramLong2 + "_" + paramLong3);
      bool = ahwb.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("WatchTogetherParser", 2, "insertGrayTips end  res:" + bool + " grayTipKey:" + ((MessageForUniteGrayTip)localObject).tipParam.bLT);
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, Object paramObject)
  {
    if (!(paramObject instanceof TroopTips0x857.VideoChangePushInfo)) {
      if (QLog.isColorLevel()) {
        QLog.d("WatchTogetherParser", 2, "handleBusinessTogetherGroupPush, object is error");
      }
    }
    label56:
    label77:
    label98:
    label119:
    label505:
    do
    {
      int i;
      long l2;
      long l3;
      String str;
      do
      {
        return;
        TroopTips0x857.VideoChangePushInfo localVideoChangePushInfo = (TroopTips0x857.VideoChangePushInfo)paramObject;
        if (localVideoChangePushInfo == null) {
          break label505;
        }
        long l1;
        if (localVideoChangePushInfo.uint64_seq.has())
        {
          l1 = localVideoChangePushInfo.uint64_seq.get();
          if (!localVideoChangePushInfo.uint32_action_type.has()) {
            break label314;
          }
          i = localVideoChangePushInfo.uint32_action_type.get();
          if (!localVideoChangePushInfo.uint64_group_id.has()) {
            break label320;
          }
          l2 = localVideoChangePushInfo.uint64_group_id.get();
          if (!localVideoChangePushInfo.uint64_oper_uin.has()) {
            break label328;
          }
          l3 = localVideoChangePushInfo.uint64_oper_uin.get();
          if (!localVideoChangePushInfo.uint32_join_nums.has()) {
            break label336;
          }
          j = localVideoChangePushInfo.uint32_join_nums.get();
          if (!localVideoChangePushInfo.bytes_gray_tips.has()) {
            break label342;
          }
        }
        for (paramObject = localVideoChangePushInfo.bytes_gray_tips.get().toStringUtf8();; paramObject = null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("WatchTogetherParser", 2, "handleWatchTogetherGroupPush, seq=" + l1 + ", actionType=" + i + ", groupid=" + l2 + ", uin=" + l3 + ", joinNum=" + j + ", tips=" + paramObject);
          }
          long l4 = ((aohy)paramQQAppInterface.getManager(339)).b(2, 1, l2);
          if (l1 >= l4) {
            break label348;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("WatchTogetherParser", 2, "handleWatchTogetherGroupPush, skip pushinfo, old seq=" + l4);
          return;
          l1 = -1L;
          break label56;
          i = -1;
          break label77;
          l2 = -1L;
          break label98;
          l3 = -1L;
          break label119;
          j = -1;
          break label140;
        }
        WatchTogetherSession localWatchTogetherSession = (WatchTogetherSession)aoij.b(2, 1, String.valueOf(l2));
        if (i == 1)
        {
          if (l3 != -1L) {
            break;
          }
          str = "";
          localWatchTogetherSession.ckN = str;
        }
        if ((i == 1) || (i == 3) || (i == 4)) {
          localWatchTogetherSession.dOD = j;
        }
        a(paramQQAppInterface, localWatchTogetherSession, i, l3, paramObject, l1, paramLong1, localVideoChangePushInfo);
      } while (((i != 5) && (i != 2)) || (TextUtils.isEmpty(paramObject)) || (l2 == -1L));
      if (i == 5) {}
      for (int j = 131085;; j = 131084)
      {
        a(paramQQAppInterface, l2, 1, paramObject, i, paramLong1, paramLong2, j);
        return;
        str = String.valueOf(l3);
        break;
      }
    } while (!QLog.isColorLevel());
    label140:
    label314:
    label320:
    label328:
    label336:
    label342:
    label348:
    QLog.d("WatchTogetherParser", 2, "handleWatchTogetherGroupPush, pushinfo is null.");
  }
  
  public void a(QQAppInterface paramQQAppInterface, WatchTogetherSession paramWatchTogetherSession, int paramInt, long paramLong1, String paramString, long paramLong2, long paramLong3, TroopTips0x857.VideoChangePushInfo paramVideoChangePushInfo)
  {
    aohy localaohy = (aohy)paramQQAppInterface.getManager(339);
    localaohy.a(2, 1, paramWatchTogetherSession.uin, paramLong2);
    WatchTogetherSession localWatchTogetherSession2 = (WatchTogetherSession)localaohy.a(paramWatchTogetherSession.serviceType, paramWatchTogetherSession.type, paramWatchTogetherSession.uin);
    WatchTogetherSession localWatchTogetherSession1;
    if (localWatchTogetherSession2 != null)
    {
      if ((paramInt == 1) || (paramInt == 3) || (paramInt == 4)) {
        localWatchTogetherSession2.dOD = paramWatchTogetherSession.dOD;
      }
      localWatchTogetherSession1 = localWatchTogetherSession2;
      if (paramInt == 1)
      {
        localWatchTogetherSession1 = localWatchTogetherSession2;
        if (!TextUtils.isEmpty(paramWatchTogetherSession.ckN))
        {
          localWatchTogetherSession2.ckN = paramWatchTogetherSession.ckN;
          localWatchTogetherSession1 = localWatchTogetherSession2;
        }
      }
      if (paramQQAppInterface.getCurrentAccountUin().equals(String.valueOf(paramLong1)))
      {
        if ((paramInt != 3) && (paramInt != 1) && (paramInt != 4) && (paramInt != 5)) {
          break label277;
        }
        aoij.p(paramQQAppInterface, localWatchTogetherSession1.uin, true);
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localWatchTogetherSession1.uin))
      {
        paramQQAppInterface = localaohy.a(2, 1, localWatchTogetherSession1.uin, 1003);
        paramQQAppInterface.data.putInt("action_type", paramInt);
        paramQQAppInterface.data.putString("tips", paramString);
        paramQQAppInterface.data.putLong("seq", paramLong2);
        paramQQAppInterface.data.putLong("msgSeq", paramLong3);
        paramQQAppInterface.ff = paramVideoChangePushInfo;
        localaohy.c(2, 1, localWatchTogetherSession1.uin, 1003);
      }
      return;
      localaohy.a(paramWatchTogetherSession.serviceType, paramWatchTogetherSession.type, paramWatchTogetherSession.uin, paramWatchTogetherSession);
      localWatchTogetherSession1 = paramWatchTogetherSession;
      break;
      label277:
      if (paramInt == 2) {
        aoij.p(paramQQAppInterface, localWatchTogetherSession1.uin, false);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public void a(ToServiceMsg paramToServiceMsg, aio_media.RspLatestPlayingState paramRspLatestPlayingState)
  {
    int k = -1;
    int j;
    String str;
    label35:
    int i;
    if (paramToServiceMsg != null)
    {
      j = paramToServiceMsg.extraData.getInt("KEY_SESSION_TYPE");
      if (paramToServiceMsg == null) {
        break label76;
      }
      str = paramToServiceMsg.extraData.getString("KEY_SESSION_UIN");
      if (paramToServiceMsg == null) {
        break label83;
      }
      i = paramToServiceMsg.extraData.getInt("KEY_REFRESH_SESSION_BY");
      label50:
      if (paramToServiceMsg != null) {
        break label88;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WatchTogetherParser", 2, "handleGetWatchPlayingState, req == null || resp == null || data == null");
      }
    }
    label76:
    label83:
    label88:
    while (j == 2)
    {
      return;
      j = -1;
      break;
      str = "";
      break label35;
      i = -1;
      break label50;
    }
    aohy localaohy = (aohy)this.mApp.getManager(339);
    paramToServiceMsg = (WatchTogetherSession)localaohy.a(2, 1, str);
    Object localObject = paramToServiceMsg;
    if (paramToServiceMsg == null)
    {
      localObject = (WatchTogetherSession)aoij.b(2, 1, str);
      localaohy.a(2, 1, str, (aoii)localObject);
    }
    boolean bool1;
    label470:
    boolean bool2;
    if (((WatchTogetherSession)localObject).isValid())
    {
      try
      {
        paramToServiceMsg = (aio_media.ResultInfo)paramRspLatestPlayingState.msg_result.get();
        j = k;
        if (paramToServiceMsg != null) {
          j = paramToServiceMsg.uint32_result.get();
        }
        if (j != 0) {}
      }
      catch (Exception paramRspLatestPlayingState)
      {
        for (;;)
        {
          try
          {
            QLog.d("WatchTogetherParser", 1, String.format("handleGetWatchPlayingState, result = %s, errTips = %s", new Object[] { Integer.valueOf(j), paramToServiceMsg }));
            bool1 = false;
          }
          catch (Exception paramRspLatestPlayingState)
          {
            bool1 = false;
            continue;
          }
          paramRspLatestPlayingState = paramRspLatestPlayingState;
          paramToServiceMsg = "";
          bool1 = false;
          QLog.d("WatchTogetherParser", 1, "handleGetWatchPlayingState exception", paramRspLatestPlayingState);
        }
      }
      try
      {
        ((WatchTogetherSession)localObject).status = paramRspLatestPlayingState.enum_aio_state.get();
        ((WatchTogetherSession)localObject).deR = paramRspLatestPlayingState.enum_user_state.get();
        ((WatchTogetherSession)localObject).ckN = String.valueOf(paramRspLatestPlayingState.uint64_create_uin.get());
        ((WatchTogetherSession)localObject).dOD = paramRspLatestPlayingState.uint32_joined_num.get();
        ((WatchTogetherSession)localObject).timeStamp = paramToServiceMsg.uint64_svr_time.get();
        ((WatchTogetherSession)localObject).ape = ((WatchTogetherSession)localObject).apd;
        ((WatchTogetherSession)localObject).apd = paramRspLatestPlayingState.uint64_aio_identification.get();
        if (((WatchTogetherSession)localObject).apd != ((WatchTogetherSession)localObject).ape) {
          ((WatchTogetherSession)localObject).dOF = 0;
        }
        if ((((WatchTogetherSession)localObject).deR == 2) && (((WatchTogetherSession)localObject).status == 1)) {
          ((WatchTogetherSession)localObject).dOF = 1;
        }
        if (!paramRspLatestPlayingState.msg_room_info.has()) {
          break label678;
        }
        ((WatchTogetherSession)localObject).roomType = paramRspLatestPlayingState.msg_room_info.uint32_type.get();
        ((WatchTogetherSession)localObject).roomId = paramRspLatestPlayingState.msg_room_info.uint64_id.get();
        ((WatchTogetherSession)localObject).roomName = paramRspLatestPlayingState.msg_room_info.bytes_name.get().toStringUtf8();
        ((WatchTogetherSession)localObject).jumpurl = paramRspLatestPlayingState.msg_room_info.bytes_jump.get().toStringUtf8();
        ((WatchTogetherSession)localObject).aif = paramRspLatestPlayingState.msg_room_info.bytes_cover.get().toStringUtf8();
        ((WatchTogetherSession)localObject).videoType = paramRspLatestPlayingState.msg_room_info.enum_video_type.get();
        ((WatchTogetherSession)localObject).dOE = paramRspLatestPlayingState.msg_room_info.enum_video_jump_type.get();
        ((WatchTogetherSession)localObject).ckO = paramRspLatestPlayingState.msg_room_info.bytes_video_jump_value.get().toStringUtf8();
        paramToServiceMsg = "";
        bool1 = true;
      }
      catch (Exception paramRspLatestPlayingState)
      {
        paramToServiceMsg = "";
        bool1 = true;
        break label642;
        paramToServiceMsg = "";
        break label601;
        paramToServiceMsg = "";
        bool1 = true;
        break label470;
      }
      paramRspLatestPlayingState = paramToServiceMsg;
      bool2 = bool1;
      if (!TextUtils.isEmpty(((WatchTogetherSession)localObject).ckN))
      {
        aqgv.h(this.mApp, ((WatchTogetherSession)localObject).uin, ((WatchTogetherSession)localObject).ckN);
        bool2 = bool1;
        paramRspLatestPlayingState = paramToServiceMsg;
      }
    }
    for (;;)
    {
      a(bool2, (WatchTogetherSession)localObject, i, paramRspLatestPlayingState);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("WatchTogetherParser", 2, "handleGetWatchPlayingState, isSuccess=" + bool2 + ", session= " + localObject + ", by=" + i);
      return;
      if ((paramToServiceMsg != null) && (paramToServiceMsg.bytes_errmsg.get() != null)) {
        paramToServiceMsg = paramToServiceMsg.bytes_errmsg.get().toStringUtf8();
      }
      label601:
      paramRspLatestPlayingState = "";
      label642:
      label678:
      bool2 = false;
    }
  }
  
  public void a(boolean paramBoolean, WatchTogetherSession paramWatchTogetherSession, int paramInt, String paramString)
  {
    aohy localaohy = (aohy)this.mApp.getManager(339);
    Object localObject = localaohy.a(2, 1, paramWatchTogetherSession.uin, paramInt);
    if ((paramBoolean) && (paramInt == 1003) && ((((aohy.a)localObject).ff instanceof TroopTips0x857.VideoChangePushInfo)))
    {
      int i = ((aohy.a)localObject).data.getInt("action_type");
      String str = ((aohy.a)localObject).data.getString("tips");
      long l1 = ((aohy.a)localObject).data.getLong("seq");
      long l2 = ((aohy.a)localObject).data.getLong("msgSeq");
      localaohy.b(paramWatchTogetherSession, i, str, l1, l2, (TroopTips0x857.VideoChangePushInfo)((aohy.a)localObject).ff);
      localaohy.c(paramWatchTogetherSession, i, str, l1, l2, (TroopTips0x857.VideoChangePushInfo)((aohy.a)localObject).ff);
    }
    boolean bool1;
    label201:
    boolean bool2;
    if (paramWatchTogetherSession.status == 3)
    {
      aoij.p(this.mApp, paramWatchTogetherSession.uin, false);
      if ((paramWatchTogetherSession.status == 1) && (paramWatchTogetherSession.deR == 2))
      {
        if ((paramWatchTogetherSession.roomType == 1) || (paramWatchTogetherSession.roomType == 0)) {
          break label540;
        }
        bool1 = true;
        if ((TextUtils.isEmpty(paramWatchTogetherSession.jumpurl)) || (TextUtils.isEmpty(paramWatchTogetherSession.ckO))) {
          break label546;
        }
        bool2 = true;
        label224:
        if ((!bool1) || (!bool2) || (!aihl.g(paramWatchTogetherSession.serviceType, paramWatchTogetherSession.uin, paramWatchTogetherSession.type))) {
          break label561;
        }
        if (QLog.isColorLevel()) {
          QLog.d("WatchTogetherParser", 1, "isSameFloatingInfo");
        }
        localObject = new WatchTogetherFloatingData();
        ((WatchTogetherFloatingData)localObject).setCurUin(paramWatchTogetherSession.uin);
        ((WatchTogetherFloatingData)localObject).setCurType(paramWatchTogetherSession.type);
        ((WatchTogetherFloatingData)localObject).setSmallUrl(paramWatchTogetherSession.jumpurl);
        ((WatchTogetherFloatingData)localObject).setBigUrl(paramWatchTogetherSession.ckO);
        if ((!((TroopManager)this.mApp.getManager(52)).c(paramWatchTogetherSession.uin).isAdmin()) && (!paramWatchTogetherSession.ckN.equals(this.mApp.getCurrentUin()))) {
          break label552;
        }
        ((WatchTogetherFloatingData)localObject).setIsAdm(true);
        label360:
        aihl.a(BaseApplicationImpl.context, (WatchTogetherFloatingData)localObject);
      }
    }
    for (;;)
    {
      if ((paramWatchTogetherSession.status == 3) || (paramWatchTogetherSession.deR == 1) || (paramWatchTogetherSession.deR == 3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WatchTogetherParser", 1, "session.state=" + paramWatchTogetherSession.status + " session.userState=" + paramWatchTogetherSession.deR + " uin=" + paramWatchTogetherSession.uin + " type=" + paramWatchTogetherSession.type);
        }
        localObject = new WatchTogetherFloatingData();
        ((WatchTogetherFloatingData)localObject).setCurUin(paramWatchTogetherSession.uin);
        ((WatchTogetherFloatingData)localObject).setCurType(paramWatchTogetherSession.type);
        aihl.a(BaseApplicationImpl.context, (WatchTogetherFloatingData)localObject);
      }
      localaohy.b(paramBoolean, paramWatchTogetherSession, paramInt, paramString);
      localaohy.d(2, 1, paramWatchTogetherSession.uin, paramInt);
      return;
      aoij.p(this.mApp, paramWatchTogetherSession.uin, true);
      break;
      label540:
      bool1 = false;
      break label201;
      label546:
      bool2 = false;
      break label224;
      label552:
      ((WatchTogetherFloatingData)localObject).setIsAdm(false);
      break label360;
      label561:
      if (aihl.g(paramWatchTogetherSession.serviceType, paramWatchTogetherSession.uin, paramWatchTogetherSession.type))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WatchTogetherParser", 1, "isSameFloatingInfo but param error isSupportRoomType=" + bool1 + " isUrlValid=" + bool2);
        }
        aihl.a(false, paramWatchTogetherSession.uin, paramWatchTogetherSession.type, false);
      }
    }
  }
  
  public void bp(Object paramObject) {}
  
  public void cG(String paramString, int paramInt)
  {
    aoii localaoii = ((aohy)this.mApp.getManager(339)).a(2, 1, paramString);
    if ((localaoii instanceof WatchTogetherSession))
    {
      localaoii.status = 3;
      localaoii.deR = 3;
      aoij.p(this.mApp, paramString, false);
      a(true, (WatchTogetherSession)localaoii, 1007, "");
    }
  }
  
  public void q(int paramInt1, int paramInt2, String paramString)
  {
    aoii localaoii = ((aohy)this.mApp.getManager(339)).a(2, 1, paramString);
    if ((localaoii instanceof WatchTogetherSession))
    {
      localaoii.status = 3;
      localaoii.deR = 3;
      aoij.p(this.mApp, paramString, false);
      a(true, (WatchTogetherSession)localaoii, 1007, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiia
 * JD-Core Version:    0.7.0.1
 */