import BumpSvc.ReqConfirmContactFriend;
import NeighborComm.ReqHeader;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.AddFriendReq;
import friendlist.AddFriendResp;
import friendlist.CheckFriendReq;
import friendlist.DelFriendReq;
import friendlist.DelFriendResp;
import friendlist.GetAutoInfoReq;
import friendlist.GetAutoInfoResp;
import friendlist.GetFriendListReq;
import friendlist.GetFriendListResp;
import friendlist.GetFriendsVideoAbiResp;
import friendlist.GetLastLoginInfoReq;
import friendlist.GetLastLoginInfoResp;
import friendlist.GetOnlineInfoReq;
import friendlist.GetOnlineInfoResp;
import friendlist.GetSimpleOnlineFriendInfoReq;
import friendlist.GetSimpleOnlineFriendInfoResp;
import friendlist.GetUserAddFriendSettingReq;
import friendlist.GetUserAddFriendSettingResp;
import friendlist.LastLoginPageInfo;
import friendlist.MovGroupMem;
import friendlist.MovGroupMemReq;
import friendlist.MovGroupMemResp;
import friendlist.SetGroupResp;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50.ReqBody;
import tencent.im.oidb.cmd0xd6b.Oidb_0xd6b.ReqBody;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.DiscussInfo;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.FriendSysMsg;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.GroupInfo;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.GroupInfoExt;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.InviteInfo;

public class anai
  extends swr
{
  private static final String[] ba = { "friendlist", "BumpSvc" };
  private andx a;
  private QQAppInterface app;
  
  public anai(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.a = new andx(paramQQAppInterface);
  }
  
  private Object A(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = (DelFriendResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "DFRESP", new DelFriendResp());
    paramToServiceMsg = paramFromServiceMsg;
    if (paramFromServiceMsg == null) {
      paramToServiceMsg = null;
    }
    return paramToServiceMsg;
  }
  
  private boolean A(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = u(paramToServiceMsg.getUin());
    if (l1 == 0L) {}
    long l2;
    do
    {
      return false;
      l2 = u(paramToServiceMsg.extraData.getString("uin"));
    } while (l2 == 0L);
    paramToServiceMsg = new CheckFriendReq();
    paramToServiceMsg.uin = l1;
    paramToServiceMsg.fuin = l2;
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("CheckFriendReq");
    paramUniPacket.put("CF", paramToServiceMsg);
    return true;
  }
  
  private Object B(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (AddFriendResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "AFRESP", new AddFriendResp());
  }
  
  private boolean B(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = u(paramToServiceMsg.getUin());
    if (l1 == 0L) {
      return false;
    }
    paramToServiceMsg = paramToServiceMsg.extraData;
    long l2 = u(paramToServiceMsg.getString("uin"));
    if (l2 == 0L) {
      return false;
    }
    if (l1 == l2) {
      return false;
    }
    byte b2 = paramToServiceMsg.getByte("del_type");
    byte b1;
    if (b2 == 1)
    {
      b1 = b2;
      if (b2 == 2) {}
    }
    else
    {
      b1 = 1;
    }
    paramToServiceMsg = new DelFriendReq();
    paramToServiceMsg.uin = l1;
    paramToServiceMsg.deluin = l2;
    paramToServiceMsg.delType = b1;
    paramToServiceMsg.version = 1;
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("DelFriendReq");
    paramUniPacket.put("DF", paramToServiceMsg);
    return true;
  }
  
  private Object C(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = (MovGroupMemResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "MovGroupMemResp", new MovGroupMemResp());
    paramToServiceMsg = paramFromServiceMsg;
    if (paramFromServiceMsg == null) {
      paramToServiceMsg = null;
    }
    return paramToServiceMsg;
  }
  
  private boolean C(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = u(paramToServiceMsg.getUin());
    if (l1 == 0L) {
      return false;
    }
    Bundle localBundle = paramToServiceMsg.extraData;
    paramToServiceMsg = localBundle.getString("uin");
    int i = localBundle.getInt("source_id", 3999);
    int j = localBundle.getInt("sub_source_id", 0);
    AddFriendReq localAddFriendReq = new AddFriendReq();
    localAddFriendReq.uin = l1;
    localAddFriendReq.sourceID = i;
    localAddFriendReq.sourceSubID = j;
    if ((i == 2007) || (i == 3007) || (i == 4007) || (i == 2017) || (i == 3017)) {
      this.app.a().e(Long.valueOf(paramToServiceMsg).longValue(), true, i);
    }
    Object localObject1;
    if ((i == 3016) || (i == 3090) || (i == 3024))
    {
      localObject1 = localBundle.getString("extra");
      if ((TextUtils.isEmpty(paramToServiceMsg)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
        return false;
      }
      localAddFriendReq.name = paramToServiceMsg.getBytes();
      localAddFriendReq.name1 = ((String)localObject1).getBytes();
    }
    for (;;)
    {
      label293:
      label312:
      boolean bool;
      Object localObject2;
      byte b1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder(300);
        ((StringBuilder)localObject1).append("handleAddFriend [uin: ").append(aqft.pl(paramToServiceMsg)).append(", source_id: ").append(i).append(", sub_source_id: ").append(j);
        if (i == 3004)
        {
          ((StringBuilder)localObject1).append(", group_uin: ").append(localBundle.getString("extra"));
          paramToServiceMsg = ((StringBuilder)localObject1).append(", friend_src_desc: ");
          if (localAddFriendReq.friend_src_desc != null) {
            break label1505;
          }
          i = 0;
          paramToServiceMsg.append(i);
          ((StringBuilder)localObject1).append("]");
          QLog.i("addFriendTag", 2, ((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        i = localBundle.getInt("friend_setting");
        byte b2 = localBundle.getByte("group_id");
        localObject1 = localBundle.getString("msg");
        bool = localBundle.getBoolean("auto_send");
        localObject2 = localBundle.getByteArray("sig");
        if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
          break label1516;
        }
        b1 = 0;
        label399:
        localAddFriendReq.adduinsetting = i;
        localAddFriendReq.myAllowFlag = 1;
        localAddFriendReq.msgLen = b1;
        if (localObject1 != null) {
          localAddFriendReq.msg = ((String)localObject1);
        }
        localAddFriendReq.myfriendgroupid = b2;
        localAddFriendReq.contact_bothway_friend = localBundle.getBoolean("contact_bothway", false);
        localAddFriendReq.showMyCard = localBundle.getByte("show_my_card");
        localObject1 = localBundle.getString("remark");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramToServiceMsg = null;
        }
      }
      try
      {
        localObject1 = ((String)localObject1).getBytes("utf-8");
        paramToServiceMsg = (ToServiceMsg)localObject1;
        localAddFriendReq.remark = paramToServiceMsg;
        if (bool)
        {
          i = 1;
          localAddFriendReq.autoSend = ((byte)i);
          if (localObject2 != null) {
            localAddFriendReq.sig = ((byte[])localObject2);
          }
          paramToServiceMsg = localBundle.getByteArray("flc_add_frd_token");
          if ((paramToServiceMsg != null) && (paramToServiceMsg.length > 0))
          {
            localAddFriendReq.token = paramToServiceMsg;
            if (QLog.isColorLevel()) {
              QLog.i("addFriendTag", 2, String.format("handleAddFriend token: %s", new Object[] { Integer.valueOf(paramToServiceMsg.length) }));
            }
          }
          paramToServiceMsg = localBundle.getString("security_ticket", "");
          if (TextUtils.isEmpty(paramToServiceMsg)) {}
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        try
        {
          for (;;)
          {
            localAddFriendReq.verify = paramToServiceMsg.getBytes("utf-8");
            if (QLog.isColorLevel()) {
              QLog.i("FriendListService", 2, String.format("handleAddFriend token: %s", new Object[] { Integer.valueOf(paramToServiceMsg.length()) }));
            }
            if (localAddFriendReq.friend_src_desc == null)
            {
              paramToServiceMsg = localBundle.getByteArray("friend_src_desc");
              if (paramToServiceMsg != null)
              {
                localAddFriendReq.friend_src_desc = paramToServiceMsg;
                if (QLog.isColorLevel()) {
                  QLog.i("FriendListService", 2, "handleAddFriend has friend_src_desc extra");
                }
              }
            }
            paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
            paramUniPacket.setFuncName("AddFriendReq");
            paramUniPacket.put("AF", localAddFriendReq);
            return true;
            if (azcl.oD(i))
            {
              if (!TextUtils.isEmpty(paramToServiceMsg))
              {
                localAddFriendReq.name = paramToServiceMsg.getBytes();
                break;
              }
              return false;
            }
            if (i == 3026)
            {
              if (j == 0)
              {
                if (!TextUtils.isEmpty(paramToServiceMsg))
                {
                  localAddFriendReq.name = paramToServiceMsg.getBytes();
                  break;
                }
                return false;
              }
              long l2 = u(paramToServiceMsg);
              if ((l2 == 0L) || (l1 == l2)) {
                return false;
              }
              localAddFriendReq.adduin = l2;
              break;
            }
            l1 = u(paramToServiceMsg);
            if (l1 == 0L) {
              return false;
            }
            localAddFriendReq.adduin = l1;
            if (i == 3004)
            {
              localObject1 = localBundle.getString("extra");
              if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
                break;
              }
              localObject2 = new FrdSysMsg.GroupInfo();
              ((FrdSysMsg.GroupInfo)localObject2).uint64_group_uin.set(u((String)localObject1));
              localAddFriendReq.friend_src_desc = ((FrdSysMsg.GroupInfo)localObject2).toByteArray();
              break;
            }
            if (i == 3005)
            {
              localObject1 = localBundle.getString("extra");
              localObject2 = new FrdSysMsg.DiscussInfo();
              ((FrdSysMsg.DiscussInfo)localObject2).uint64_discuss_uin.set(u((String)localObject1));
              localAddFriendReq.friend_src_desc = ((FrdSysMsg.DiscussInfo)localObject2).toByteArray();
              break;
            }
            if (i == 3037)
            {
              localObject1 = localBundle.getString("troop_uin");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break;
              }
              localObject2 = new FrdSysMsg.FriendSysMsg();
              localObject3 = new FrdSysMsg.GroupInfoExt();
              ((FrdSysMsg.GroupInfoExt)localObject3).uint64_group_code.set(u((String)localObject1));
              ((FrdSysMsg.FriendSysMsg)localObject2).msg_group_ext.set((MessageMicro)localObject3);
              localAddFriendReq.friend_src_desc = ((FrdSysMsg.FriendSysMsg)localObject2).toByteArray();
              break;
            }
            if (i == 3042)
            {
              localObject1 = localBundle.getString("troop_uin");
              int k = localBundle.getInt("flc_notify_type");
              localObject2 = localBundle.getString("flc_recommend_uin");
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
              {
                localObject3 = new FrdSysMsg.FriendSysMsg();
                FrdSysMsg.GroupInfoExt localGroupInfoExt = new FrdSysMsg.GroupInfoExt();
                localGroupInfoExt.uint64_group_code.set(u((String)localObject1));
                localGroupInfoExt.uint32_notify_type.set(k);
                localObject1 = new FrdSysMsg.InviteInfo();
                ((FrdSysMsg.InviteInfo)localObject1).uint64_recommend_uin.set(u((String)localObject2));
                ((FrdSysMsg.FriendSysMsg)localObject3).msg_group_ext.set(localGroupInfoExt);
                ((FrdSysMsg.FriendSysMsg)localObject3).msg_intite_info.set((MessageMicro)localObject1);
                localAddFriendReq.friend_src_desc = ((FrdSysMsg.FriendSysMsg)localObject3).toByteArray();
                break;
              }
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break;
              }
              localObject2 = new FrdSysMsg.FriendSysMsg();
              localObject3 = new FrdSysMsg.GroupInfoExt();
              ((FrdSysMsg.GroupInfoExt)localObject3).uint64_group_code.set(u((String)localObject1));
              ((FrdSysMsg.GroupInfoExt)localObject3).uint32_notify_type.set(k);
              ((FrdSysMsg.FriendSysMsg)localObject2).msg_group_ext.set((MessageMicro)localObject3);
              localAddFriendReq.friend_src_desc = ((FrdSysMsg.FriendSysMsg)localObject2).toByteArray();
              break;
            }
            if (i != 3022) {
              break;
            }
            localObject1 = localBundle.getString("flc_recommend_uin");
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            localObject2 = new FrdSysMsg.FriendSysMsg();
            Object localObject3 = new FrdSysMsg.InviteInfo();
            ((FrdSysMsg.InviteInfo)localObject3).uint64_recommend_uin.set(u((String)localObject1));
            ((FrdSysMsg.FriendSysMsg)localObject2).msg_intite_info.set((MessageMicro)localObject3);
            localAddFriendReq.friend_src_desc = ((FrdSysMsg.FriendSysMsg)localObject2).toByteArray();
            break;
            if (i == 3005)
            {
              ((StringBuilder)localObject1).append(", discuss_uin: ").append(localBundle.getString("extra"));
              break label293;
            }
            if (i == 3037)
            {
              ((StringBuilder)localObject1).append(", group_code: ").append(localBundle.getString("troop_uin"));
              break label293;
            }
            if (i == 3042)
            {
              ((StringBuilder)localObject1).append(", group_code: ").append(localBundle.getString("troop_uin"));
              ((StringBuilder)localObject1).append(", notify_type: ").append(localBundle.getInt("flc_notify_type"));
              ((StringBuilder)localObject1).append(", recommend_uin: ").append(localBundle.getString("flc_recommend_uin"));
              break label293;
            }
            if (i != 3022) {
              break label293;
            }
            ((StringBuilder)localObject1).append(", recommend_uin: ").append(localBundle.getString("flc_recommend_uin"));
            break label293;
            label1505:
            i = localAddFriendReq.friend_src_desc.length;
            break label312;
            label1516:
            paramToServiceMsg = (ToServiceMsg)localObject1;
            if (((String)localObject1).length() >= 127) {
              paramToServiceMsg = ((String)localObject1).substring(0, 126);
            }
            b1 = (byte)paramToServiceMsg.getBytes().length;
            localObject1 = paramToServiceMsg;
            break label399;
            localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
            localUnsupportedEncodingException1.printStackTrace();
          }
          i = 0;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          for (;;)
          {
            QLog.e("FriendListService", 1, "handleAddFriend, ", localUnsupportedEncodingException2);
          }
        }
      }
    }
  }
  
  private Object D(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetUserAddFriendSettingResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "FSRESP", new GetUserAddFriendSettingResp());
  }
  
  private boolean D(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Byte localByte = Byte.valueOf(paramToServiceMsg.extraData.getByte("move_fri_type"));
    if (localByte.byteValue() == 0) {
      return E(paramToServiceMsg, paramUniPacket);
    }
    if (localByte.byteValue() == 1) {
      return F(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  private Object E(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetFriendListResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "FLRESP", new GetFriendListResp());
  }
  
  private boolean E(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = u(paramToServiceMsg.getUin());
    if (l1 == 0L) {}
    long l2;
    byte b;
    do
    {
      do
      {
        return false;
        paramToServiceMsg = paramToServiceMsg.extraData;
        l2 = u(paramToServiceMsg.getString("uin"));
      } while (l2 == 0L);
      b = paramToServiceMsg.getByte("group_id");
    } while (b < 0);
    paramToServiceMsg = new MovGroupMem();
    paramToServiceMsg.Ver = 1;
    paramToServiceMsg.wReqLen = 5;
    paramToServiceMsg.dwUin = l2;
    paramToServiceMsg.cGroupid = b;
    paramToServiceMsg.wReserveLen = 0;
    MovGroupMemReq localMovGroupMemReq = new MovGroupMemReq();
    localMovGroupMemReq.uin = l1;
    localMovGroupMemReq.reqtype = 0;
    paramToServiceMsg = null;
    try
    {
      Object localObject = new ByteArrayOutputStream(10);
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeByte(1);
      localDataOutputStream.writeShort(5);
      localDataOutputStream.writeInt((int)l2);
      localDataOutputStream.writeByte(b);
      localDataOutputStream.writeShort(0);
      localDataOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      paramToServiceMsg = (ToServiceMsg)localObject;
    }
    catch (IOException localIOException)
    {
      label181:
      break label181;
    }
    localMovGroupMemReq.vecBody = paramToServiceMsg;
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("MovGroupMemReq");
    paramUniPacket.put("MovGroupMemReq", localMovGroupMemReq);
    return true;
  }
  
  private Object F(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetLastLoginInfoResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "GetLastLoginInfoResp", new GetLastLoginInfoResp());
  }
  
  private boolean F(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = u(paramToServiceMsg.getUin());
    if (l == 0L) {
      return false;
    }
    Object localObject = paramToServiceMsg.extraData;
    String[] arrayOfString = ((Bundle)localObject).getStringArray("uins");
    MovGroupMemReq localMovGroupMemReq = new MovGroupMemReq();
    localMovGroupMemReq.uin = l;
    localMovGroupMemReq.reqtype = 1;
    paramToServiceMsg = null;
    for (;;)
    {
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
        localDataOutputStream.writeByte(1);
        localDataOutputStream.writeShort(arrayOfString.length * 5);
        i = 0;
        if ((arrayOfString != null) && (i < arrayOfString.length))
        {
          l = u(arrayOfString[i]);
          if (l != 0L) {
            continue;
          }
        }
        localDataOutputStream.writeShort(0);
        localDataOutputStream.close();
        localObject = localByteArrayOutputStream.toByteArray();
        paramToServiceMsg = (ToServiceMsg)localObject;
      }
      catch (IOException localIOException)
      {
        DataOutputStream localDataOutputStream;
        int i;
        int j;
        continue;
      }
      localMovGroupMemReq.vecBody = paramToServiceMsg;
      paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
      paramUniPacket.setFuncName("MovGroupMemReq");
      paramUniPacket.put("MovGroupMemReq", localMovGroupMemReq);
      return true;
      j = ((Bundle)localObject).getByte("group_id");
      if (j >= 0)
      {
        localDataOutputStream.writeInt((int)l);
        localDataOutputStream.writeByte(j);
        i += 1;
      }
    }
  }
  
  private Object G(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SetGroupResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "SetGroupResp", new SetGroupResp());
  }
  
  private boolean G(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = u(paramToServiceMsg.getUin());
    if (l == 0L) {
      return false;
    }
    Object localObject = paramToServiceMsg.extraData;
    int i = ((Bundle)localObject).getInt("source_id");
    int j = ((Bundle)localObject).getInt("sub_source_id");
    paramToServiceMsg = ((Bundle)localObject).getString("uin");
    localObject = ((Bundle)localObject).getString("extra");
    GetUserAddFriendSettingReq localGetUserAddFriendSettingReq = new GetUserAddFriendSettingReq();
    localGetUserAddFriendSettingReq.version = 1L;
    localGetUserAddFriendSettingReq.uin = l;
    localGetUserAddFriendSettingReq.sourceID = i;
    if (azcl.oD(i)) {
      localGetUserAddFriendSettingReq.name = paramToServiceMsg.getBytes();
    }
    for (;;)
    {
      paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
      paramUniPacket.setFuncName("GetUserAddFriendSettingReq");
      paramUniPacket.put("FS", localGetUserAddFriendSettingReq);
      return true;
      if ((i == 3016) || (i == 3090) || (i == 3024))
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        localGetUserAddFriendSettingReq.name = paramToServiceMsg.getBytes();
        localGetUserAddFriendSettingReq.name1 = ((String)localObject).getBytes();
        localGetUserAddFriendSettingReq.sourceSubID = j;
        continue;
      }
      if (i == 3026)
      {
        localGetUserAddFriendSettingReq.sourceSubID = j;
        if (j == 0)
        {
          localGetUserAddFriendSettingReq.name = paramToServiceMsg.getBytes();
          continue;
        }
        l = u(paramToServiceMsg);
        if (l == 0L) {
          break;
        }
        localGetUserAddFriendSettingReq.queryuin = l;
        continue;
      }
      l = u(paramToServiceMsg);
      if (l == 0L) {
        break;
      }
      localGetUserAddFriendSettingReq.queryuin = l;
    }
  }
  
  private Object H(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetAutoInfoResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "GAIRESP", new GetAutoInfoResp());
  }
  
  private boolean H(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.extraData.getBoolean("getSingleFriend")) {
      return I(paramToServiceMsg, paramUniPacket);
    }
    return J(paramToServiceMsg, paramUniPacket);
  }
  
  private boolean I(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("targetUin");
    if (TextUtils.isEmpty(paramToServiceMsg)) {
      return false;
    }
    GetFriendListReq localGetFriendListReq = new GetFriendListReq();
    localGetFriendListReq.reqtype = 3;
    localGetFriendListReq.ifReflush = 1;
    localGetFriendListReq.ifShowTermType = 1;
    localGetFriendListReq.version = 30L;
    Object localObject = new Oidb_0xd50.ReqBody();
    ((Oidb_0xd50.ReqBody)localObject).appid.set(10002L);
    ((Oidb_0xd50.ReqBody)localObject).req_music_switch.set(1);
    ((Oidb_0xd50.ReqBody)localObject).req_ksing_switch.set(1);
    ((Oidb_0xd50.ReqBody)localObject).req_mutualmark_lbsshare.set(1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListService", 2, "handleGetSingleInfo: invoked. req lbs share profile. ");
    }
    ((Oidb_0xd50.ReqBody)localObject).req_mutualmark_alienation.set(1);
    localGetFriendListReq.vec0xd50Req = ((Oidb_0xd50.ReqBody)localObject).toByteArray();
    localGetFriendListReq.vec0xd6bReq = new Oidb_0xd6b.ReqBody().toByteArray();
    localObject = new ArrayList(1);
    try
    {
      localGetFriendListReq.uin = Long.parseLong(this.app.getCurrentAccountUin());
      ((ArrayList)localObject).add(Long.valueOf(Long.parseLong(paramToServiceMsg)));
      localGetFriendListReq.uinList = ((ArrayList)localObject);
      paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
      paramUniPacket.setFuncName("GetFriendListReq");
      paramUniPacket.put("FL", localGetFriendListReq);
      return true;
    }
    catch (NumberFormatException paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
    return false;
  }
  
  private boolean J(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    short s1 = paramToServiceMsg.extraData.getShort("friendStartIndex");
    short s2 = paramToServiceMsg.extraData.getShort("friendCount");
    byte b1 = paramToServiceMsg.extraData.getByte("groupStartIndex");
    byte b2 = paramToServiceMsg.extraData.getByte("groupCount");
    byte b3 = paramToServiceMsg.extraData.getByte("ifShowTermType");
    if (s1 > 0) {}
    for (int i = 0;; i = 1)
    {
      Oidb_0xd50.ReqBody localReqBody = new Oidb_0xd50.ReqBody();
      localReqBody.appid.set(10002L);
      localReqBody.req_music_switch.set(1);
      localReqBody.req_ksing_switch.set(1);
      localReqBody.req_mutualmark_lbsshare.set(1);
      if (QLog.isColorLevel()) {
        QLog.d("FriendListService", 2, new Object[] { "handleGetAllInfo: invoked. ", " req lbs share profile. " });
      }
      localReqBody.req_mutualmark_alienation.set(1);
      ArrayList localArrayList = new ArrayList(3);
      localArrayList.add(Long.valueOf(13580L));
      localArrayList.add(Long.valueOf(13581L));
      localArrayList.add(Long.valueOf(13582L));
      Oidb_0xd6b.ReqBody localReqBody1 = new Oidb_0xd6b.ReqBody();
      paramToServiceMsg = new GetFriendListReq(3, (byte)i, Long.valueOf(paramToServiceMsg.getUin()).longValue(), s1, s2, (byte)0, (byte)i, b1, b2, (byte)0, b3, 30L, null, 0, (byte)0, (byte)0, localReqBody.toByteArray(), localReqBody1.toByteArray(), localArrayList);
      paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
      paramUniPacket.setFuncName("GetFriendListReq");
      paramUniPacket.put("FL", paramToServiceMsg);
      return true;
    }
  }
  
  private boolean K(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("uin");
    long l2 = paramToServiceMsg.extraData.getLong("current_req_uin");
    long l3 = paramToServiceMsg.extraData.getLong("current_req_index");
    paramToServiceMsg = new GetLastLoginInfoReq(l1, new LastLoginPageInfo(paramToServiceMsg.extraData.getLong("total_req_times"), l3, l2));
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetLastLoginInfoReq");
    paramUniPacket.put("GetLastLoginInfoReq", paramToServiceMsg);
    return true;
  }
  
  private boolean L(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetAutoInfoReq localGetAutoInfoReq = new GetAutoInfoReq();
    localGetAutoInfoReq.uin = u(paramToServiceMsg.getUin());
    localGetAutoInfoReq.dwFriendUin = u(paramToServiceMsg.extraData.getString("uin"));
    localGetAutoInfoReq.cType = paramToServiceMsg.extraData.getByte("cType");
    localGetAutoInfoReq.sourceID = paramToServiceMsg.extraData.getInt("source_id", 3999);
    localGetAutoInfoReq.sourceSubID = paramToServiceMsg.extraData.getInt("sub_source_id", 0);
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetAutoInfoReq");
    paramUniPacket.put("GAIREQ", localGetAutoInfoReq);
    return true;
  }
  
  /* Error */
  private boolean M(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 85
    //   3: invokevirtual 91	com/qq/jce/wup/UniPacket:setServantName	(Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc_w 723
    //   10: invokevirtual 96	com/qq/jce/wup/UniPacket:setFuncName	(Ljava/lang/String;)V
    //   13: new 725	friendlist/SetGroupReq
    //   16: dup
    //   17: invokespecial 726	friendlist/SetGroupReq:<init>	()V
    //   20: astore 4
    //   22: aload 4
    //   24: aload_1
    //   25: invokevirtual 58	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   28: invokestatic 634	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   31: putfield 727	friendlist/SetGroupReq:uin	J
    //   34: aload 4
    //   36: aload_1
    //   37: getfield 66	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   40: ldc_w 729
    //   43: invokevirtual 249	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   46: putfield 730	friendlist/SetGroupReq:reqtype	I
    //   49: new 500	java/io/ByteArrayOutputStream
    //   52: dup
    //   53: bipush 10
    //   55: invokespecial 501	java/io/ByteArrayOutputStream:<init>	(I)V
    //   58: astore 5
    //   60: new 503	java/io/DataOutputStream
    //   63: dup
    //   64: aload 5
    //   66: invokespecial 506	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   69: astore 6
    //   71: aload 4
    //   73: getfield 730	friendlist/SetGroupReq:reqtype	I
    //   76: tableswitch	default:+369 -> 445, 0:+32->108, 1:+140->216, 2:+224->300, 3:+260->336
    //   109: iconst_m1
    //   110: <illegal opcode>
    //   111: dup
    //   112: invokespecial 733	friendlist/AddGroup:<init>	()V
    //   115: astore 7
    //   117: aload 7
    //   119: aload_1
    //   120: getfield 66	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   123: ldc_w 735
    //   126: invokevirtual 114	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   129: putfield 738	friendlist/AddGroup:cSortId	B
    //   132: aload 7
    //   134: aload_1
    //   135: getfield 66	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   138: ldc_w 740
    //   141: invokevirtual 74	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   144: putfield 743	friendlist/AddGroup:sGroupName	Ljava/lang/String;
    //   147: aload 7
    //   149: getfield 743	friendlist/AddGroup:sGroupName	Ljava/lang/String;
    //   152: invokevirtual 190	java/lang/String:getBytes	()[B
    //   155: astore_1
    //   156: aload 7
    //   158: aload_1
    //   159: arraylength
    //   160: i2b
    //   161: putfield 746	friendlist/AddGroup:cLen	B
    //   164: aload 6
    //   166: aload 7
    //   168: getfield 738	friendlist/AddGroup:cSortId	B
    //   171: invokevirtual 509	java/io/DataOutputStream:writeByte	(I)V
    //   174: aload 6
    //   176: aload 7
    //   178: getfield 746	friendlist/AddGroup:cLen	B
    //   181: invokevirtual 509	java/io/DataOutputStream:writeByte	(I)V
    //   184: aload 6
    //   186: aload_1
    //   187: invokevirtual 750	java/io/DataOutputStream:write	([B)V
    //   190: aload 6
    //   192: invokevirtual 518	java/io/DataOutputStream:close	()V
    //   195: aload 4
    //   197: aload 5
    //   199: invokevirtual 519	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   202: putfield 751	friendlist/SetGroupReq:vecBody	[B
    //   205: aload_2
    //   206: ldc_w 723
    //   209: aload 4
    //   211: invokevirtual 102	com/qq/jce/wup/UniPacket:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   214: iconst_1
    //   215: ireturn
    //   216: new 753	friendlist/RenameGroup
    //   219: dup
    //   220: invokespecial 754	friendlist/RenameGroup:<init>	()V
    //   223: astore 7
    //   225: aload 7
    //   227: aload_1
    //   228: getfield 66	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   231: ldc 251
    //   233: invokevirtual 114	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   236: putfield 757	friendlist/RenameGroup:cGroupId	B
    //   239: aload 7
    //   241: aload_1
    //   242: getfield 66	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   245: ldc_w 740
    //   248: invokevirtual 74	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   251: putfield 758	friendlist/RenameGroup:sGroupName	Ljava/lang/String;
    //   254: aload 7
    //   256: getfield 758	friendlist/RenameGroup:sGroupName	Ljava/lang/String;
    //   259: invokevirtual 190	java/lang/String:getBytes	()[B
    //   262: astore_1
    //   263: aload 7
    //   265: aload_1
    //   266: arraylength
    //   267: i2b
    //   268: putfield 759	friendlist/RenameGroup:cLen	B
    //   271: aload 6
    //   273: aload 7
    //   275: getfield 757	friendlist/RenameGroup:cGroupId	B
    //   278: invokevirtual 761	java/io/DataOutputStream:write	(I)V
    //   281: aload 6
    //   283: aload 7
    //   285: getfield 759	friendlist/RenameGroup:cLen	B
    //   288: invokevirtual 509	java/io/DataOutputStream:writeByte	(I)V
    //   291: aload 6
    //   293: aload_1
    //   294: invokevirtual 750	java/io/DataOutputStream:write	([B)V
    //   297: goto -107 -> 190
    //   300: new 763	friendlist/DelGroup
    //   303: dup
    //   304: invokespecial 764	friendlist/DelGroup:<init>	()V
    //   307: astore 7
    //   309: aload 7
    //   311: aload_1
    //   312: getfield 66	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   315: ldc 251
    //   317: invokevirtual 114	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   320: putfield 765	friendlist/DelGroup:cGroupId	B
    //   323: aload 6
    //   325: aload 7
    //   327: getfield 765	friendlist/DelGroup:cGroupId	B
    //   330: invokevirtual 509	java/io/DataOutputStream:writeByte	(I)V
    //   333: goto -143 -> 190
    //   336: new 767	friendlist/ReSortGroup
    //   339: dup
    //   340: invokespecial 768	friendlist/ReSortGroup:<init>	()V
    //   343: astore 7
    //   345: aload 7
    //   347: aload_1
    //   348: getfield 66	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   351: ldc_w 770
    //   354: invokevirtual 265	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   357: putfield 772	friendlist/ReSortGroup:cGroupId	[B
    //   360: aload 7
    //   362: aload_1
    //   363: getfield 66	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   366: ldc_w 774
    //   369: invokevirtual 265	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   372: putfield 776	friendlist/ReSortGroup:cSortId	[B
    //   375: aload 7
    //   377: aload 7
    //   379: getfield 772	friendlist/ReSortGroup:cGroupId	[B
    //   382: arraylength
    //   383: i2b
    //   384: putfield 779	friendlist/ReSortGroup:cNum	B
    //   387: aload 6
    //   389: aload 7
    //   391: getfield 779	friendlist/ReSortGroup:cNum	B
    //   394: invokevirtual 509	java/io/DataOutputStream:writeByte	(I)V
    //   397: aload 7
    //   399: getfield 772	friendlist/ReSortGroup:cGroupId	[B
    //   402: astore_1
    //   403: aload 7
    //   405: getfield 776	friendlist/ReSortGroup:cSortId	[B
    //   408: astore 7
    //   410: iconst_0
    //   411: istore_3
    //   412: iload_3
    //   413: aload_1
    //   414: arraylength
    //   415: if_icmpge -225 -> 190
    //   418: aload 6
    //   420: aload_1
    //   421: iload_3
    //   422: baload
    //   423: invokevirtual 509	java/io/DataOutputStream:writeByte	(I)V
    //   426: aload 6
    //   428: aload 7
    //   430: iload_3
    //   431: baload
    //   432: invokevirtual 509	java/io/DataOutputStream:writeByte	(I)V
    //   435: iload_3
    //   436: iconst_1
    //   437: iadd
    //   438: istore_3
    //   439: goto -27 -> 412
    //   442: astore_1
    //   443: iconst_0
    //   444: ireturn
    //   445: iconst_0
    //   446: ireturn
    //   447: astore_1
    //   448: iconst_0
    //   449: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	450	0	this	anai
    //   0	450	1	paramToServiceMsg	ToServiceMsg
    //   0	450	2	paramUniPacket	UniPacket
    //   411	28	3	i	int
    //   20	190	4	localSetGroupReq	friendlist.SetGroupReq
    //   58	140	5	localByteArrayOutputStream	ByteArrayOutputStream
    //   69	358	6	localDataOutputStream	DataOutputStream
    //   115	314	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   22	34	442	java/lang/NumberFormatException
    //   71	108	447	java/io/IOException
    //   108	190	447	java/io/IOException
    //   190	195	447	java/io/IOException
    //   216	297	447	java/io/IOException
    //   300	333	447	java/io/IOException
    //   336	410	447	java/io/IOException
    //   412	435	447	java/io/IOException
  }
  
  private long u(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    for (;;)
    {
      return 0L;
      try
      {
        long l = Long.parseLong(paramString);
        if (l >= 10000L) {
          return l;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return 0L;
  }
  
  private Object x(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return paramFromServiceMsg;
  }
  
  private boolean x(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = u(paramToServiceMsg.getUin());
    int i = paramToServiceMsg.extraData.getInt("bType");
    long l2 = paramToServiceMsg.extraData.getLong("lToMID");
    long l3 = paramToServiceMsg.extraData.getLong("lFromMobile");
    long l4 = paramToServiceMsg.extraData.getLong("lToMobile");
    Object localObject = paramToServiceMsg.extraData.getByteArray("vSig");
    byte b = paramToServiceMsg.extraData.getByte("bGroupId");
    String str = paramToServiceMsg.extraData.getString("strNickName");
    paramToServiceMsg = new ReqHeader();
    paramToServiceMsg.shVersion = 1;
    paramToServiceMsg.lMID = l1;
    paramToServiceMsg.iAppID = AppSetting.getAppId();
    paramToServiceMsg.eBusiType = 1;
    paramToServiceMsg.eMqqSysType = 2;
    localObject = new ReqConfirmContactFriend((byte)i, l2, l3, l4, (byte[])localObject, b, null, str);
    paramUniPacket.setServantName("BumpSvc");
    paramUniPacket.setFuncName("CMD_CONFIRM_CONTACT_FRIEND");
    paramUniPacket.put("ReqHeader", paramToServiceMsg);
    paramUniPacket.put("ReqConfirmContactFriend", localObject);
    return true;
  }
  
  private Object y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramFromServiceMsg.getWupBuffer();
    paramFromServiceMsg = new UniPacket(true);
    paramFromServiceMsg.setEncodeName("utf-8");
    paramFromServiceMsg.decode(paramToServiceMsg);
    if ("GetOnlineInfoReq".equals(paramFromServiceMsg.getFuncName()))
    {
      paramToServiceMsg = (GetOnlineInfoResp)decodePacket(paramToServiceMsg, "GetOnlineInfoResp", new GetOnlineInfoResp());
      if (paramToServiceMsg == null) {
        return null;
      }
      paramToServiceMsg.dwStatus = ((byte)(int)paramToServiceMsg.dwStatus);
      return paramToServiceMsg;
    }
    return null;
  }
  
  private boolean y(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = u(paramToServiceMsg.getUin());
    if (l == 0L) {
      return false;
    }
    paramToServiceMsg = new GetSimpleOnlineFriendInfoReq(l, (byte)0, (byte)0, null, paramToServiceMsg.extraData.getByte("ifShowTermType"), 30L, paramToServiceMsg.extraData.getByte("srcType"));
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetSimpleOnlineFriendInfoReq");
    paramUniPacket.put("FSOLREQ", paramToServiceMsg);
    return true;
  }
  
  private Object z(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramFromServiceMsg.getWupBuffer();
    paramFromServiceMsg = new UniPacket(true);
    paramFromServiceMsg.setEncodeName("utf-8");
    paramFromServiceMsg.decode(paramToServiceMsg);
    paramFromServiceMsg = paramFromServiceMsg.getFuncName();
    if ("GetSimpleOnlineFriendInfoReq".equals(paramFromServiceMsg))
    {
      paramFromServiceMsg = (GetSimpleOnlineFriendInfoResp)decodePacket(paramToServiceMsg, "FSOLRESP", new GetSimpleOnlineFriendInfoResp());
      if (paramFromServiceMsg == null) {
        paramToServiceMsg = null;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return paramToServiceMsg;
            paramToServiceMsg = paramFromServiceMsg;
          } while (paramFromServiceMsg == null);
          paramToServiceMsg = paramFromServiceMsg;
        } while (paramFromServiceMsg.result != 1);
        return null;
        if (!"GetFriendsVideoAbiResp".equals(paramFromServiceMsg)) {
          break;
        }
        paramFromServiceMsg = (GetFriendsVideoAbiResp)decodePacket(paramToServiceMsg, "VABRESP", new GetFriendsVideoAbiResp());
        paramToServiceMsg = paramFromServiceMsg;
      } while (paramFromServiceMsg == null);
      paramToServiceMsg = paramFromServiceMsg;
    } while (paramFromServiceMsg.result != 1);
    return null;
    return null;
  }
  
  private boolean z(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = paramToServiceMsg.extraData.getLong("dwReqType");
    if (l == 0L) {}
    for (paramToServiceMsg = new GetOnlineInfoReq(l, paramToServiceMsg.extraData.getLong("dwUin"), null, 30L, true);; paramToServiceMsg = new GetOnlineInfoReq(l, 0L, paramToServiceMsg.extraData.getString("strMobile"), 7L, false))
    {
      paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
      paramUniPacket.setFuncName("GetOnlineInfoReq");
      paramUniPacket.put("GetOnlineInfoReq", paramToServiceMsg);
      return true;
    }
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("friendlist.getFriendGroupList".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return E(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.GetLastLoginInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return F(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.MovGroupMemReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return C(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("BumpSvc.ReqComfirmContactFriend".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return x(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.addFriend".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return B(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.getUserAddFriendSetting".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return D(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.GetSimpleOnlineFriendInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return z(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.GetOnlineInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return y(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.delFriend".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return A(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.SetGroupReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return G(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.GetAutoInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return H(paramToServiceMsg, paramFromServiceMsg);
    }
    if (("friendlist.GetTroopListReqV2".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("friendlist.GetMultiTroopInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("friendlist.getTroopRemark".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("friendlist.getTroopMemberList".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("friendlist.ModifyGroupCardReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("friendlist.ModifyGroupInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("friendlist.GetTroopAppointRemarkReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
      return this.a.a(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.getFriendGroupList")) {
      return H(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetLastLoginInfoReq")) {
      return K(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.delFriend")) {
      return B(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.addFriend")) {
      return C(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.checkFriend")) {
      return A(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.getUserAddFriendSetting")) {
      return G(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetSimpleOnlineFriendInfoReq")) {
      return y(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetOnlineInfoReq")) {
      return z(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("BumpSvc.ReqComfirmContactFriend")) {
      return x(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.MovGroupMemReq")) {
      return D(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.SetGroupReq")) {
      return M(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetAutoInfoReq")) {
      return L(paramToServiceMsg, paramUniPacket);
    }
    if ((paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetTroopListReqV2")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.getTroopMemberList")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.getTroopRemark")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetMultiTroopInfoReq")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.ModifyGroupCardReq")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetTroopAppointRemarkReq")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.ModifyGroupInfoReq"))) {
      return this.a.a(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  public void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public String[] y()
  {
    return ba;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anai
 * JD-Core Version:    0.7.0.1
 */