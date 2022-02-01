import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.intervideo.singtogether.SingTogetherSession;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.aio.media.aio_media.ResultInfo;
import tencent.aio.media.aio_media.RspLatestPlayingState;
import tencent.aio.media.aio_media.TypeKSing;
import tencent.im.oidb.cmd0x857.TroopTips0x857.SingChangePushInfo;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50.KSingRelationInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x127.submsgtype0x127.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x129.submsgtype0x129.MsgBody;

public class aiha
  implements aoih
{
  private QQAppInterface mApp;
  
  public aiha(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public static boolean n(byte[] paramArrayOfByte)
  {
    Oidb_0xd50.KSingRelationInfo localKSingRelationInfo = new Oidb_0xd50.KSingRelationInfo();
    try
    {
      localKSingRelationInfo.mergeFrom(paramArrayOfByte);
      int i = localKSingRelationInfo.flag.get();
      return i == 1;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return false;
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, Object paramObject)
  {
    if (!(paramObject instanceof TroopTips0x857.SingChangePushInfo)) {
      if (QLog.isColorLevel()) {
        QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, params not right");
      }
    }
    label56:
    label77:
    label98:
    label119:
    label380:
    do
    {
      return;
      TroopTips0x857.SingChangePushInfo localSingChangePushInfo = (TroopTips0x857.SingChangePushInfo)paramObject;
      if (localSingChangePushInfo != null)
      {
        long l1;
        int i;
        long l2;
        long l3;
        int j;
        if (localSingChangePushInfo.uint64_seq.has())
        {
          l1 = localSingChangePushInfo.uint64_seq.get();
          if (!localSingChangePushInfo.uint32_action_type.has()) {
            break label346;
          }
          i = localSingChangePushInfo.uint32_action_type.get();
          if (!localSingChangePushInfo.uint64_group_id.has()) {
            break label352;
          }
          l2 = localSingChangePushInfo.uint64_group_id.get();
          if (!localSingChangePushInfo.uint64_oper_uin.has()) {
            break label360;
          }
          l3 = localSingChangePushInfo.uint64_oper_uin.get();
          if (!localSingChangePushInfo.uint32_join_nums.has()) {
            break label368;
          }
          j = localSingChangePushInfo.uint32_join_nums.get();
          if (!localSingChangePushInfo.bytes_gray_tips.has()) {
            break label374;
          }
        }
        for (paramObject = localSingChangePushInfo.bytes_gray_tips.get().toStringUtf8();; paramObject = null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, seq=" + l1 + ", actionType=" + i + ", groupid=" + l2 + ", uin=" + l3 + ", joinNum=" + j + ", tips=" + paramObject);
          }
          long l4 = ((aohy)paramQQAppInterface.getManager(339)).b(4, 1, l2);
          if (QLog.isColorLevel()) {
            QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, oldSeq=" + l4);
          }
          if (l1 >= l4) {
            break label380;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, skip pushinfo, old seq=" + l4);
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
        SingTogetherSession localSingTogetherSession = (SingTogetherSession)aoij.b(4, 1, String.valueOf(l2));
        if (i == 1) {
          if (l3 != -1L) {
            break label542;
          }
        }
        for (String str = "";; str = String.valueOf(l3))
        {
          localSingTogetherSession.ckN = str;
          if ((i == 1) || (i == 3) || (i == 4)) {
            localSingTogetherSession.dOD = j;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, session" + localSingTogetherSession);
          }
          a(paramQQAppInterface, localSingTogetherSession, i, l3, paramObject, l1, paramLong1, localSingChangePushInfo);
          if (((i != 5) && (i != 2)) || (TextUtils.isEmpty(paramObject)) || (l2 == -1L)) {
            break;
          }
          aiia.a(paramQQAppInterface, l2, 1, paramObject, i, paramLong1, paramLong2, 131087);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    label140:
    label346:
    label352:
    label360:
    label368:
    label374:
    QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, pushinfo is null.");
    label542:
  }
  
  public void a(QQAppInterface paramQQAppInterface, SingTogetherSession paramSingTogetherSession, int paramInt, long paramLong1, String paramString, long paramLong2, long paramLong3, TroopTips0x857.SingChangePushInfo paramSingChangePushInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherParser", 2, "handleSingTogetherPush");
    }
    aohy localaohy = (aohy)paramQQAppInterface.getManager(339);
    localaohy.a(4, paramSingTogetherSession.type, paramSingTogetherSession.uin, paramLong2);
    Object localObject = (SingTogetherSession)localaohy.a(paramSingTogetherSession.serviceType, paramSingTogetherSession.type, paramSingTogetherSession.uin);
    if (localObject != null)
    {
      if ((paramInt == 1) || (paramInt == 3) || (paramInt == 4)) {
        ((SingTogetherSession)localObject).dOD = paramSingTogetherSession.dOD;
      }
      if ((paramInt == 1) && (!TextUtils.isEmpty(paramSingTogetherSession.ckN))) {
        ((SingTogetherSession)localObject).ckN = paramSingTogetherSession.ckN;
      }
      if ((paramInt != 1) && (paramInt != 3) && (paramInt != 4)) {
        break label452;
      }
      ((SingTogetherSession)localObject).ddn = paramSingTogetherSession.ddn;
      paramSingTogetherSession = (SingTogetherSession)localObject;
    }
    for (;;)
    {
      if (paramInt == 1)
      {
        aoij.a(paramQQAppInterface, paramSingTogetherSession.uin, true, paramSingTogetherSession.type, 16777216);
        label164:
        if (paramSingTogetherSession.type != 2) {
          break label306;
        }
        localObject = ((acff)paramQQAppInterface.getManager(51)).b(paramSingTogetherSession.uin);
        if ((localObject != null) && (((Friends)localObject).isFriend())) {
          break label306;
        }
      }
      label306:
      while (TextUtils.isEmpty(paramSingTogetherSession.uin))
      {
        return;
        localaohy.a(paramSingTogetherSession.serviceType, paramSingTogetherSession.type, paramSingTogetherSession.uin, paramSingTogetherSession);
        break;
        if (paramInt == 2)
        {
          paramSingTogetherSession.status = 3;
          paramSingTogetherSession.deR = 3;
          aoij.a(paramQQAppInterface, paramSingTogetherSession.uin, false, paramSingTogetherSession.type, 16777216);
          break label164;
        }
        if ((!paramQQAppInterface.getCurrentAccountUin().equals(String.valueOf(paramLong1))) || ((paramInt != 3) && (paramInt != 4) && (paramInt != 5))) {
          break label164;
        }
        aoij.a(paramQQAppInterface, paramSingTogetherSession.uin, true, paramSingTogetherSession.type, 16777216);
        break label164;
      }
      localObject = localaohy.a(4, paramSingTogetherSession.type, paramSingTogetherSession.uin, 1003);
      ((aohy.a)localObject).data.putInt("action_type", paramInt);
      ((aohy.a)localObject).data.putString("tips", paramString);
      ((aohy.a)localObject).data.putLong("seq", paramLong2);
      ((aohy.a)localObject).data.putLong("msgSeq", paramLong3);
      ((aohy.a)localObject).ff = paramSingChangePushInfo;
      if ((!paramQQAppInterface.getCurrentAccountUin().equals(String.valueOf(paramLong1))) && ((paramInt == 2) || (paramInt == 4) || (paramInt == 3)))
      {
        a(true, paramSingTogetherSession, 1003, "");
        return;
      }
      localaohy.c(4, paramSingTogetherSession.type, paramSingTogetherSession.uin, 1003);
      return;
      label452:
      paramSingTogetherSession = (SingTogetherSession)localObject;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Object localObject;
    if (paramQQAppInterface != null)
    {
      localObject = paramQQAppInterface.getCurrentAccountUin();
      if (QLog.isColorLevel()) {
        QLog.d("SingTogetherParser", 2, "decodePush0x210_0x127, msgSeq = " + paramLong1 + " msgTime = " + paramLong2 + " selfUin:" + (String)localObject + " isOffline = " + paramBoolean);
      }
      if ((paramArrayOfByte == null) || (TextUtils.isEmpty((CharSequence)localObject))) {
        break label783;
      }
      if (paramBoolean) {
        break label372;
      }
    }
    int i;
    int j;
    long l1;
    long l2;
    long l3;
    label372:
    long l4;
    label429:
    label450:
    label471:
    label613:
    do
    {
      for (;;)
      {
        try
        {
          localObject = new submsgtype0x127.MsgBody();
          ((submsgtype0x127.MsgBody)localObject).mergeFrom(paramArrayOfByte);
          i = ((submsgtype0x127.MsgBody)localObject).join_state.get();
          j = ((submsgtype0x127.MsgBody)localObject).uint32_action_type.get();
          if (!((submsgtype0x127.MsgBody)localObject).uint64_oper_uin.has()) {
            continue;
          }
          l1 = ((submsgtype0x127.MsgBody)localObject).uint64_oper_uin.get();
          if (!((submsgtype0x127.MsgBody)localObject).uint64_friend_uin.has()) {
            continue;
          }
          l2 = ((submsgtype0x127.MsgBody)localObject).uint64_friend_uin.get();
          if (!((submsgtype0x127.MsgBody)localObject).uint64_seq.has()) {
            continue;
          }
          l3 = ((submsgtype0x127.MsgBody)localObject).uint64_seq.get();
          paramArrayOfByte = ((submsgtype0x127.MsgBody)localObject).bytes_gray_tips.get().toStringUtf8();
          if (QLog.isColorLevel()) {
            QLog.d("SingTogetherParser", 2, "decodePush0x210, actionType = " + j + " friend_uin = " + l2 + " oper_uin = " + l1 + " gray_tips = " + paramArrayOfByte + " timeStamp = " + l3 + " c2cJoinState" + i + " isOffLine=" + paramBoolean);
          }
          if (l2 != 0L) {
            continue;
          }
          QLog.d("SingTogetherParser", 1, "filter friendUin: " + l2 + ", operatorUin: " + l1);
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("SingTogetherParser", 2, "decodePush0x210_0x127f decode error, e=", paramQQAppInterface);
          return;
        }
        localObject = "";
        break;
        l1 = 0L;
        continue;
        l2 = 0L;
        continue;
        l3 = 0L;
        continue;
        localObject = new submsgtype0x129.MsgBody();
        ((submsgtype0x129.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        i = ((submsgtype0x129.MsgBody)localObject).join_state.get();
        j = ((submsgtype0x129.MsgBody)localObject).uint32_action_type.get();
        if (!((submsgtype0x129.MsgBody)localObject).uint64_oper_uin.has()) {
          break label799;
        }
        l1 = ((submsgtype0x129.MsgBody)localObject).uint64_oper_uin.get();
        if (!((submsgtype0x129.MsgBody)localObject).uint64_friend_uin.has()) {
          break label805;
        }
        l2 = ((submsgtype0x129.MsgBody)localObject).uint64_friend_uin.get();
        if (!((submsgtype0x129.MsgBody)localObject).uint64_seq.has()) {
          break label811;
        }
        l3 = ((submsgtype0x129.MsgBody)localObject).uint64_seq.get();
        paramArrayOfByte = ((submsgtype0x129.MsgBody)localObject).bytes_gray_tips.get().toStringUtf8();
        continue;
        if (!paramBoolean) {
          break label613;
        }
        if ((j != 1) && (j != 2))
        {
          QLog.d("SingTogetherParser", 1, "filter offline msg, msgType:" + j);
          return;
        }
      }
      l4 = paramQQAppInterface.getPreferences().getLong("inccheckupdatetimeStamp17", 0L);
      if (l3 / 1000L < l4)
      {
        QLog.d("SingTogetherParser", 1, String.format("filter offline msg, timestamp: %s < incUpdateTimeStamp: %s", new Object[] { Long.valueOf(l3 / 1000L), Long.valueOf(l4) }));
        return;
      }
      l4 = ((aohy)paramQQAppInterface.getManager(339)).b(4, 2, l2);
      if (l3 >= l4) {
        break label673;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SingTogetherParser", 2, "handleSingTogetherGroupPush, skip pushinfo, old seq=" + l4);
    return;
    label673:
    SingTogetherSession localSingTogetherSession = (SingTogetherSession)aoij.b(4, 2, String.valueOf(l2));
    if (j == 1) {
      if (l1 == 0L)
      {
        localObject = "";
        label705:
        localSingTogetherSession.ckN = ((String)localObject);
      }
    }
    for (;;)
    {
      label715:
      localSingTogetherSession.ddn = i;
      label783:
      label799:
      label805:
      label811:
      do
      {
        a(paramQQAppInterface, localSingTogetherSession, j, l1, paramArrayOfByte, l3, paramLong1, null);
        if (((j != 5) && (j != 2)) || (TextUtils.isEmpty(paramArrayOfByte))) {
          break;
        }
        aiia.a(paramQQAppInterface, l2, 0, paramArrayOfByte, j, paramLong1, paramLong2, 131087);
        return;
        localObject = String.valueOf(l1);
        break label705;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SingTogetherParser", 2, "decodePush0x210_0x127 pbData = null");
        return;
        l1 = 0L;
        break label429;
        l2 = 0L;
        break label450;
        l3 = 0L;
        break label471;
        if ((j == 1) || (j == 3)) {
          break label715;
        }
      } while (j != 4);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, aio_media.RspLatestPlayingState paramRspLatestPlayingState)
  {
    int j;
    Object localObject2;
    label32:
    int i;
    if (paramToServiceMsg != null)
    {
      j = paramToServiceMsg.extraData.getInt("KEY_SESSION_TYPE");
      if (paramToServiceMsg == null) {
        break label73;
      }
      localObject2 = paramToServiceMsg.extraData.getString("KEY_SESSION_UIN");
      if (paramToServiceMsg == null) {
        break label80;
      }
      i = paramToServiceMsg.extraData.getInt("KEY_REFRESH_SESSION_BY");
      label47:
      if (paramToServiceMsg != null) {
        break label85;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SingTogetherParser", 2, "handleGetSingPlayingState, req == null || resp == null || data == null");
      }
    }
    label73:
    label80:
    label85:
    do
    {
      return;
      j = -1;
      break;
      localObject2 = "";
      break label32;
      i = -1;
      break label47;
      if ((j == 2) || (j == 1)) {
        break label131;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SingTogetherParser", 2, "sessionType not right =" + j);
    return;
    label131:
    boolean bool2 = false;
    Object localObject3 = (aohy)this.mApp.getManager(339);
    paramToServiceMsg = (SingTogetherSession)((aohy)localObject3).a(4, j, (String)localObject2);
    Object localObject1 = paramToServiceMsg;
    if (paramToServiceMsg == null)
    {
      localObject1 = (SingTogetherSession)aoij.b(4, j, (String)localObject2);
      ((aohy)localObject3).a(4, j, (String)localObject2, (aoii)localObject1);
    }
    boolean bool1;
    if (((SingTogetherSession)localObject1).isValid()) {
      bool1 = bool2;
    }
    for (;;)
    {
      int k;
      try
      {
        localObject2 = (aio_media.ResultInfo)paramRspLatestPlayingState.msg_result.get();
        if (localObject2 != null)
        {
          bool1 = bool2;
          k = ((aio_media.ResultInfo)localObject2).uint32_result.get();
          if (k != 0) {
            break label985;
          }
          bool1 = bool2;
          localObject3 = new StringBuilder("handleGetPlayingState seesion=");
          bool2 = true;
          bool1 = bool2;
          ((SingTogetherSession)localObject1).status = paramRspLatestPlayingState.enum_aio_state.get();
          bool1 = bool2;
          ((SingTogetherSession)localObject1).deR = paramRspLatestPlayingState.enum_user_state.get();
          bool1 = bool2;
          if (!paramRspLatestPlayingState.uint64_create_uin.has()) {
            continue;
          }
          bool1 = bool2;
          paramToServiceMsg = Long.valueOf(paramRspLatestPlayingState.uint64_create_uin.get());
          bool1 = bool2;
          ((SingTogetherSession)localObject1).ckN = String.valueOf(paramToServiceMsg);
          bool1 = bool2;
          ((SingTogetherSession)localObject1).timeStamp = ((aio_media.ResultInfo)localObject2).uint64_svr_time.get();
          bool1 = bool2;
          ((SingTogetherSession)localObject1).apd = paramRspLatestPlayingState.uint64_aio_identification.get();
          bool1 = bool2;
          ((StringBuilder)localObject3).append(" status=").append(((SingTogetherSession)localObject1).status).append(" userState=").append(((SingTogetherSession)localObject1).deR).append(" creator=").append(((SingTogetherSession)localObject1).ckN).append(" timeStamp=").append(((SingTogetherSession)localObject1).timeStamp);
          bool1 = bool2;
          if (paramRspLatestPlayingState.msg_ksing_info.has())
          {
            bool1 = bool2;
            ((SingTogetherSession)localObject1).roomType = paramRspLatestPlayingState.msg_ksing_info.uint32_type.get();
            bool1 = bool2;
            ((SingTogetherSession)localObject1).roomId = paramRspLatestPlayingState.msg_ksing_info.uint64_id.get();
            bool1 = bool2;
            ((SingTogetherSession)localObject1).roomName = paramRspLatestPlayingState.msg_ksing_info.bytes_name.get().toStringUtf8();
            bool1 = bool2;
            ((SingTogetherSession)localObject1).jumpUrl = paramRspLatestPlayingState.msg_ksing_info.bytes_jump.get().toStringUtf8();
            bool1 = bool2;
            ((SingTogetherSession)localObject1).aif = paramRspLatestPlayingState.msg_ksing_info.bytes_cover.get().toStringUtf8();
            bool1 = bool2;
            ((SingTogetherSession)localObject1).songName = paramRspLatestPlayingState.msg_ksing_info.bytes_song.get().toStringUtf8();
            bool1 = bool2;
            ((SingTogetherSession)localObject1).aby = paramRspLatestPlayingState.msg_ksing_info.uint64_singer.get();
            bool1 = bool2;
            ((StringBuilder)localObject3).append(" roomType=").append(((SingTogetherSession)localObject1).roomType).append(" roomId=").append(((SingTogetherSession)localObject1).roomId).append(" roomName=").append(((SingTogetherSession)localObject1).roomName).append(" jumpUrl=").append(((SingTogetherSession)localObject1).jumpUrl).append(" roomCover=").append(((SingTogetherSession)localObject1).aif).append(" songName=").append(((SingTogetherSession)localObject1).songName).append(" singerUin=").append(((SingTogetherSession)localObject1).aby);
          }
          if (j != 1) {
            continue;
          }
          bool1 = bool2;
          ((SingTogetherSession)localObject1).dOD = paramRspLatestPlayingState.uint32_joined_num.get();
          bool1 = bool2;
          ((StringBuilder)localObject3).append(" joinNum=").append(((SingTogetherSession)localObject1).dOD);
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            bool1 = bool2;
            QLog.d("SingTogetherParser", 2, ((StringBuilder)localObject3).toString());
          }
          paramToServiceMsg = "";
          bool1 = true;
          paramRspLatestPlayingState = paramToServiceMsg;
          bool2 = bool1;
          if (!TextUtils.isEmpty(((SingTogetherSession)localObject1).ckN))
          {
            if (((SingTogetherSession)localObject1).type != 2) {
              break label1055;
            }
            aqgv.p(this.mApp, ((SingTogetherSession)localObject1).ckN);
            bool2 = bool1;
            paramRspLatestPlayingState = paramToServiceMsg;
          }
          label815:
          a(bool2, (SingTogetherSession)localObject1, i, paramRspLatestPlayingState);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SingTogetherParser", 2, "handleGetSingPlayingState, isSuccess=" + bool2 + ", session= " + localObject1 + ", by=" + i);
          return;
        }
        k = -1;
        continue;
        paramToServiceMsg = "";
        continue;
        bool1 = bool2;
        if (!paramRspLatestPlayingState.enum_c2c_join_state.has()) {
          break label971;
        }
        bool1 = bool2;
        j = paramRspLatestPlayingState.enum_c2c_join_state.get();
        bool1 = bool2;
        ((SingTogetherSession)localObject1).ddn = j;
        bool1 = bool2;
        ((StringBuilder)localObject3).append(" c2cStatus=").append(((SingTogetherSession)localObject1).ddn);
        continue;
        QLog.d("SingTogetherParser", 1, "handleGetSingPlayingState exception", paramRspLatestPlayingState);
      }
      catch (Exception paramRspLatestPlayingState)
      {
        paramToServiceMsg = "";
      }
      label958:
      continue;
      label971:
      bool1 = bool2;
      j = ((SingTogetherSession)localObject1).ddn;
      continue;
      label985:
      if (localObject2 != null)
      {
        bool1 = bool2;
        if (((aio_media.ResultInfo)localObject2).bytes_errmsg.get() != null) {
          bool1 = bool2;
        }
      }
      for (paramToServiceMsg = ((aio_media.ResultInfo)localObject2).bytes_errmsg.get().toStringUtf8();; paramToServiceMsg = "")
      {
        try
        {
          QLog.d("SingTogetherParser", 1, String.format("handleGetSingPlayingState, result = %s, errTips = %s", new Object[] { Integer.valueOf(k), paramToServiceMsg }));
          bool1 = false;
        }
        catch (Exception paramRspLatestPlayingState)
        {
          label1055:
          bool1 = false;
        }
        aqgv.h(this.mApp, ((SingTogetherSession)localObject1).uin, ((SingTogetherSession)localObject1).ckN);
        paramRspLatestPlayingState = paramToServiceMsg;
        bool2 = bool1;
        break label815;
        break label958;
      }
      paramRspLatestPlayingState = "";
      bool2 = false;
    }
  }
  
  public void a(boolean paramBoolean, SingTogetherSession paramSingTogetherSession, int paramInt, String paramString)
  {
    aohy localaohy = (aohy)this.mApp.getManager(339);
    aohy.a locala = localaohy.a(4, paramSingTogetherSession.type, paramSingTogetherSession.uin, paramInt);
    if ((paramBoolean) && (paramInt == 1003))
    {
      int i = locala.data.getInt("action_type");
      String str = locala.data.getString("tips");
      long l1 = locala.data.getLong("seq");
      long l2 = locala.data.getLong("msgSeq");
      localaohy.b(paramSingTogetherSession, i, str, l1, l2, locala.ff);
      localaohy.c(paramSingTogetherSession, i, str, l1, l2, locala.ff);
    }
    if (paramSingTogetherSession.status == 3) {
      aoij.a(this.mApp, paramSingTogetherSession.uin, false, paramSingTogetherSession.type, 16777216);
    }
    for (;;)
    {
      localaohy.b(paramBoolean, paramSingTogetherSession, paramInt, paramString);
      localaohy.d(4, paramSingTogetherSession.type, paramSingTogetherSession.uin, paramInt);
      return;
      aoij.a(this.mApp, paramSingTogetherSession.uin, true, paramSingTogetherSession.type, 16777216);
    }
  }
  
  public void bp(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      paramObject = ((aohy)this.mApp.getManager(339)).a(4, 2, String.valueOf(paramObject));
    } while (!(paramObject instanceof SingTogetherSession));
    paramObject.status = 3;
    paramObject.deR = 3;
    aoij.a(this.mApp, paramObject.uin, false, paramObject.type, 16777216);
    a(true, (SingTogetherSession)paramObject, 1007, "");
  }
  
  public void cG(String paramString, int paramInt)
  {
    paramString = ((aohy)this.mApp.getManager(339)).a(4, 1, paramString);
    if ((paramString instanceof SingTogetherSession))
    {
      paramString.status = 3;
      paramString.deR = 3;
      aoij.a(this.mApp, paramString.uin, false, paramString.type, 16777216);
      a(true, (SingTogetherSession)paramString, 1007, "");
    }
  }
  
  public void q(int paramInt1, int paramInt2, String paramString)
  {
    cG(paramString, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiha
 * JD-Core Version:    0.7.0.1
 */