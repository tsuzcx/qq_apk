import QQService.AddDiscussMemberInfo;
import QQService.DiscussInfo;
import QQService.DiscussRespHeader;
import QQService.InteRemarkInfo;
import QQService.RespAddDiscussMember;
import QQService.RespChangeDiscussName;
import QQService.RespCreateDiscuss;
import QQService.RespGetDiscussInfo;
import QQService.RespGetDiscussInteRemark;
import QQService.RespJoinDiscuss;
import QQService.RespQuitDiscuss;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.DiscussionHandler.1;
import com.tencent.mobileqq.app.DiscussionHandler.2;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.protofile.discuss.FlyTicket.DiscussGetUrlRequest;
import com.tencent.protofile.discuss.FlyTicket.DiscussGetUrlResponse;
import com.tencent.protofile.discuss.FlyTicket.DiscussSigDecodeRequest;
import com.tencent.protofile.discuss.FlyTicket.DiscussSigDecodeResponse;
import com.tencent.protofile.discuss.FlyTicket.RetInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x44c.cmd0x44c.ModifyConfInfoReq;
import tencent.im.oidb.cmd0x44c.cmd0x44c.ReqBody;
import tencent.im.oidb.cmd0x44c.cmd0x44c.RspBody;
import tencent.im.oidb.cmd0x58a.cmd0x58a.ConfBaseInfo;
import tencent.im.oidb.cmd0x58a.cmd0x58a.GetConfListRsp;
import tencent.im.oidb.cmd0x58a.cmd0x58a.ReqBody;
import tencent.im.oidb.cmd0x58a.cmd0x58a.RspBody;
import tencent.im.oidb.cmd0x58b.cmd0x58b.CmdErrorCode;
import tencent.im.oidb.cmd0x58b.cmd0x58b.ConfBaseInfo;
import tencent.im.oidb.cmd0x58b.cmd0x58b.ConfMemberInfo;
import tencent.im.oidb.cmd0x58b.cmd0x58b.GetConfInfoRsp;
import tencent.im.oidb.cmd0x58b.cmd0x58b.GetMultiConfInfoReq;
import tencent.im.oidb.cmd0x58b.cmd0x58b.GetMultiConfInfoRsp;
import tencent.im.oidb.cmd0x58b.cmd0x58b.ReqBody;
import tencent.im.oidb.cmd0x58b.cmd0x58b.RspBody;
import tencent.im.oidb.cmd0x751.oidb_0x751.CheckIsConfMemberResult;
import tencent.im.oidb.cmd0x751.oidb_0x751.RspBody;
import tencent.im.oidb.cmd0x751.oidb_0x751.RspCheckIsConfMember;
import tencent.im.oidb.cmd0x921.cmd0x921.GetAtAllRemain;
import tencent.im.oidb.cmd0x921.cmd0x921.GetAtAllRemainRsp;
import tencent.im.oidb.cmd0x921.cmd0x921.ReqBody;
import tencent.im.oidb.cmd0x921.cmd0x921.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class acdt
  extends accg
{
  private LinkedHashMap<String, acdt.c> K = new LinkedHashMap(100);
  private LinkedHashMap<String, acdt.c> L = new LinkedHashMap();
  private long Pq;
  private long Pr;
  private GroupIconHelper a;
  private FriendListHandler d;
  private ArrayList<Pair<Boolean, String>> sW;
  
  public acdt(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.d = ((FriendListHandler)paramQQAppInterface.getBusinessHandler(1));
    this.a = new GroupIconHelper(paramQQAppInterface.getCurrentAccountUin(), this);
  }
  
  private void A(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      send(paramToServiceMsg);
      return;
    }
    x(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void B(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      send(paramToServiceMsg);
      return;
    }
    y(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void C(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  private void D(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  private void E(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      send(paramToServiceMsg);
      return;
    }
    q(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void F(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      send(paramToServiceMsg);
    }
  }
  
  private void G(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      send(paramToServiceMsg);
      return;
    }
    r(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void H(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      send(paramToServiceMsg);
      return;
    }
    s(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void I(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      send(paramToServiceMsg);
      return;
    }
    t(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void IR(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    case 106: 
    case 107: 
    case 108: 
    case 109: 
    default: 
      str = BaseApplicationImpl.getApplication().getResources().getString(2131692862);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new DiscussionHandler.1(this, str));
      return;
      str = BaseApplicationImpl.getApplication().getResources().getString(2131692865);
      continue;
      str = BaseApplicationImpl.getApplication().getResources().getString(2131692869);
      continue;
      str = BaseApplicationImpl.getApplication().getResources().getString(2131692863);
      continue;
      str = BaseApplicationImpl.getApplication().getResources().getString(2131692864);
    }
  }
  
  private void J(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      send(paramToServiceMsg);
      return;
    }
    u(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void K(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.extraData.getString("signature") != null) {}
    label145:
    label162:
    do
    {
      return;
      paramFromServiceMsg = (ArrayList)paramToServiceMsg.extraData.getSerializable("discussUin");
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("handleGetDiscussInfoErrorV2 disUin: ");
        if (paramFromServiceMsg != null) {
          break label145;
        }
      }
      for (paramToServiceMsg = "null";; paramToServiceMsg = paramFromServiceMsg.toString())
      {
        QLog.d("Q.contacttab.dscs", 2, paramToServiceMsg);
        if ((paramFromServiceMsg == null) || (paramFromServiceMsg.size() <= 0)) {
          break label162;
        }
        paramToServiceMsg = new ArrayList(paramFromServiceMsg.size() * 2);
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        while (paramFromServiceMsg.hasNext())
        {
          localObject = (Long)paramFromServiceMsg.next();
          this.K.remove(String.valueOf(localObject));
          paramToServiceMsg.add(localObject);
          paramToServiceMsg.add(Boolean.valueOf(false));
        }
      }
      notifyUI(1001, false, paramToServiceMsg);
    } while (!ZR());
    cIm();
  }
  
  private void L(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      sendPbReq(paramToServiceMsg);
      return;
    }
    K(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private boolean ZR()
  {
    return this.L.size() > 0;
  }
  
  private void a(String paramString, DiscussionInfo paramDiscussionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussInfoRespV2, new info, disUin[" + paramString + "], DiscussionFlag[" + paramDiscussionInfo.DiscussionFlag + "]");
    }
  }
  
  private void a(String paramString, cmd0x58b.ConfBaseInfo paramConfBaseInfo, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(512);
      localStringBuilder.append("handleGetDiscussInfoRespV2, server data:");
      localStringBuilder.append(" disUin[").append(paramString);
      localStringBuilder.append("], owner[").append(paramConfBaseInfo.uint64_owner_uin.get());
      localStringBuilder.append("], errCode[").append(paramInt2);
      localStringBuilder.append("], flag[").append(paramConfBaseInfo.uint32_flag.get());
      localStringBuilder.append("], createTime[").append(paramConfBaseInfo.uint32_create_time.get());
      localStringBuilder.append("], disName[").append(aqft.pk(paramConfBaseInfo.bytes_conf_name.get().toStringUtf8()));
      localStringBuilder.append("], infoseq[").append(paramInt3);
      localStringBuilder.append("], timesec[").append(paramInt1);
      localStringBuilder.append("], discOrigin[").append(paramLong1);
      localStringBuilder.append("], discOriginExtra[").append(paramLong2);
      localStringBuilder.append("]");
      QLog.d("Q.contacttab.dscs", 2, new Object[] { localStringBuilder });
    }
  }
  
  private void a(String paramString1, cmd0x58b.ConfBaseInfo paramConfBaseInfo, int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString2, acdu paramacdu, DiscussionInfo paramDiscussionInfo)
  {
    paramDiscussionInfo.createTime = paramConfBaseInfo.uint32_create_time.get();
    paramDiscussionInfo.ownerUin = String.valueOf(paramConfBaseInfo.uint64_owner_uin.get());
    paramDiscussionInfo.inheritOwnerUin = String.valueOf(paramConfBaseInfo.uint64_inherit_owner_uin.get());
    paramDiscussionInfo.timeSec = paramInt1;
    paramDiscussionInfo.groupUin = paramConfBaseInfo.uint64_group_uin.get();
    paramDiscussionInfo.groupCode = paramConfBaseInfo.uint64_group_code.get();
    paramDiscussionInfo.mOrigin = paramLong1;
    paramDiscussionInfo.mOriginExtra = paramLong2;
    if ((paramInt2 & 0x40) == 0L)
    {
      paramDiscussionInfo.discussionName = paramString2;
      paramDiscussionInfo.DiscussionFlag = (paramInt2 | 0x20000000);
    }
    for (;;)
    {
      paramacdu.d(paramDiscussionInfo);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "handleGetDiscussInfoRespV2 disUin=" + paramString1 + " old flag=" + paramDiscussionInfo.DiscussionFlag);
      }
      paramDiscussionInfo.DiscussionFlag = paramInt2;
      paramDiscussionInfo.DiscussionFlag |= 0x20000000;
      paramDiscussionInfo.discussionName = paramString2;
    }
  }
  
  private void a(String paramString, cmd0x58b.ConfBaseInfo paramConfBaseInfo, List<cmd0x58b.ConfMemberInfo> paramList, acff paramacff, acdu paramacdu, DiscussionInfo paramDiscussionInfo)
  {
    HashMap localHashMap = new HashMap();
    long l = System.currentTimeMillis();
    Map localMap = paramacdu.n(paramString);
    aqjl.a("handleGetDiscussInfoRespV2", this.app, paramDiscussionInfo);
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      cmd0x58b.ConfMemberInfo localConfMemberInfo = (cmd0x58b.ConfMemberInfo)localIterator.next();
      String str = String.valueOf(localConfMemberInfo.uint64_uin.get());
      if (QLog.isColorLevel())
      {
        localStringBuffer.append("handleGetDiscussInfoRespV2, memberUin=");
        localStringBuffer.append(str.toString());
        localStringBuffer.append("flag=");
        localStringBuffer.append(localConfMemberInfo.uint32_flag.get());
        localStringBuffer.append("inteRemark=");
        localStringBuffer.append(aqft.pk(localConfMemberInfo.bytes_member_interemark.get().toStringUtf8()));
        localStringBuffer.append("Source=");
        localStringBuffer.append(localConfMemberInfo.uint32_interemark_source.get());
        localStringBuffer.append("\r\n");
      }
      paramList = null;
      if (localMap != null) {
        paramList = (DiscussionMemberInfo)localMap.get(str);
      }
      Object localObject = paramList;
      if (paramList == null)
      {
        localObject = new DiscussionMemberInfo();
        ((DiscussionMemberInfo)localObject).discussionUin = paramString;
        ((DiscussionMemberInfo)localObject).memberUin = str;
      }
      ((DiscussionMemberInfo)localObject).flag = ((byte)localConfMemberInfo.uint32_flag.get());
      ((DiscussionMemberInfo)localObject).dataTime = l;
      if ((localConfMemberInfo.bytes_member_interemark.has()) && (!TextUtils.isEmpty(localConfMemberInfo.bytes_member_interemark.get().toStringUtf8()))) {
        ((DiscussionMemberInfo)localObject).inteRemark = localConfMemberInfo.bytes_member_interemark.get().toStringUtf8();
      }
      for (;;)
      {
        aqjl.a(this.app, paramDiscussionInfo, (DiscussionMemberInfo)localObject);
        localHashMap.put(((DiscussionMemberInfo)localObject).memberUin, localObject);
        break;
        if (TextUtils.isEmpty(((DiscussionMemberInfo)localObject).inteRemark))
        {
          paramList = paramacff.b(((DiscussionMemberInfo)localObject).memberUin);
          if ((paramList != null) && (paramList.isFriend()))
          {
            ((DiscussionMemberInfo)localObject).memberName = paramList.name;
            if (TextUtils.isEmpty(paramList.remark)) {}
            for (paramList = paramList.name;; paramList = paramList.remark)
            {
              ((DiscussionMemberInfo)localObject).inteRemark = paramList;
              ((DiscussionMemberInfo)localObject).inteRemarkSource = 129L;
              break;
            }
          }
          ((DiscussionMemberInfo)localObject).inteRemarkSource = 0L;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, localStringBuffer.toString());
    }
    paramacdu.a(paramString, paramDiscussionInfo, paramConfBaseInfo.uint32_info_seq.get(), localHashMap, l);
    this.a.FR(paramDiscussionInfo.uin);
  }
  
  private void a(ArrayList<Object> paramArrayList, int paramInt1, String paramString1, List<cmd0x58b.ConfMemberInfo> paramList, long paramLong1, long paramLong2, int paramInt2, String paramString2, acdu paramacdu, DiscussionInfo paramDiscussionInfo)
  {
    Map localMap = paramacdu.n(paramString1);
    paramArrayList.set(paramInt1 * 2 + 1, Boolean.valueOf(a(paramDiscussionInfo, paramList, localMap)));
    paramInt1 = 0;
    if ((paramInt2 & 0x40) == 0L) {
      if (!paramDiscussionInfo.discussionName.equals(paramString2))
      {
        paramDiscussionInfo.DiscussionFlag = (paramInt2 | 0x20000000);
        paramDiscussionInfo.discussionName = paramString2;
        paramInt2 = 1;
        paramInt1 = paramInt2;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussInfoRespV2 disUin=" + paramString1 + " name need server name| local name=" + aqft.pk(paramDiscussionInfo.discussionName));
        }
      }
    }
    for (paramInt1 = paramInt2;; paramInt1 = 1)
    {
      if ((paramLong1 != paramDiscussionInfo.mOrigin) || (paramLong2 != paramDiscussionInfo.mOriginExtra))
      {
        if (AudioHelper.aCz()) {
          QLog.w("DiscussionHandler", 1, "handleGetDiscussInfoRespV2, update mOrigin[" + paramDiscussionInfo.mOrigin + "->" + paramLong1 + "], mOriginExtra[" + paramDiscussionInfo.mOriginExtra + "->" + paramLong2 + "]");
        }
        paramDiscussionInfo.mOrigin = paramLong1;
        paramDiscussionInfo.mOriginExtra = paramLong2;
        paramInt1 = 1;
      }
      if (paramInt1 != 0) {
        paramacdu.d(paramDiscussionInfo);
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussInfoRespV2 disUin=" + paramString1 + " old flag=" + paramDiscussionInfo.DiscussionFlag);
      }
      paramDiscussionInfo.DiscussionFlag = paramInt2;
      paramDiscussionInfo.DiscussionFlag |= 0x20000000;
      aqgv.a(this.app, paramString1, paramDiscussionInfo, localMap, false);
    }
  }
  
  private void a(ArrayList<Long> paramArrayList, ArrayList<Object> paramArrayList1, HashMap<String, acdt.c> paramHashMap)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Long localLong = (Long)paramArrayList.next();
        acdt.c localc = (acdt.c)this.K.remove(String.valueOf(localLong));
        if (localc != null)
        {
          localc.retryCount += 1;
          paramHashMap.put(String.valueOf(localLong), localc);
          paramArrayList1.add(String.valueOf(localLong));
          paramArrayList1.add(Boolean.valueOf(false));
        }
      }
    }
  }
  
  private boolean a(DiscussionInfo paramDiscussionInfo, List<cmd0x58b.ConfMemberInfo> paramList, Map<String, DiscussionMemberInfo> paramMap)
  {
    boolean bool2 = false;
    acdu localacdu = (acdu)this.app.getManager(53);
    ArrayList localArrayList = new ArrayList();
    long l;
    Object localObject1;
    Object localObject2;
    boolean bool1;
    if ((paramList != null) && (paramMap != null))
    {
      l = System.currentTimeMillis();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (cmd0x58b.ConfMemberInfo)paramList.next();
        if ((((cmd0x58b.ConfMemberInfo)localObject1).bytes_member_interemark.has()) && (!TextUtils.isEmpty(((cmd0x58b.ConfMemberInfo)localObject1).bytes_member_interemark.get().toStringUtf8())))
        {
          localObject2 = String.valueOf(((cmd0x58b.ConfMemberInfo)localObject1).uint64_uin.get());
          DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)paramMap.get(localObject2);
          if (localDiscussionMemberInfo == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("DiscussionHandler", 2, "warning dbMemberInfo is null uin=" + (String)localObject2);
            }
          }
          else if ((!paramDiscussionInfo.isDiscussHrMeeting()) && (!TextUtils.isEmpty(localDiscussionMemberInfo.memberUin)) && (localDiscussionMemberInfo.memberUin.equals(localObject2)) && (!TextUtils.isEmpty(localDiscussionMemberInfo.inteRemark)) && (!localDiscussionMemberInfo.inteRemark.equals(((cmd0x58b.ConfMemberInfo)localObject1).bytes_member_interemark.get().toStringUtf8())))
          {
            localDiscussionMemberInfo.dataTime = l;
            localDiscussionMemberInfo.inteRemark = ((cmd0x58b.ConfMemberInfo)localObject1).bytes_member_interemark.get().toStringUtf8();
            localDiscussionMemberInfo.inteRemarkSource = ((cmd0x58b.ConfMemberInfo)localObject1).uint32_interemark_source.get();
            localArrayList.add(localDiscussionMemberInfo);
            bool1 = true;
          }
        }
      }
    }
    for (;;)
    {
      if (localArrayList.size() > 0) {
        localacdu.iH(localArrayList);
      }
      return bool1;
      bool1 = bool2;
      if (paramList != null)
      {
        bool1 = bool2;
        if (paramMap == null)
        {
          l = System.currentTimeMillis();
          paramMap = (acff)this.app.getManager(51);
          localObject1 = paramList.iterator();
          do
          {
            bool1 = bool2;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            paramList = (cmd0x58b.ConfMemberInfo)((Iterator)localObject1).next();
            localObject2 = new DiscussionMemberInfo();
            ((DiscussionMemberInfo)localObject2).discussionUin = paramDiscussionInfo.uin;
            ((DiscussionMemberInfo)localObject2).memberUin = String.valueOf(paramList.uint64_uin.get());
            ((DiscussionMemberInfo)localObject2).flag = ((byte)paramList.uint32_flag.get());
            ((DiscussionMemberInfo)localObject2).dataTime = l;
          } while (paramDiscussionInfo.isDiscussHrMeeting());
          if ((paramList.bytes_member_interemark.has()) && (!TextUtils.isEmpty(paramList.bytes_member_interemark.get().toStringUtf8())))
          {
            ((DiscussionMemberInfo)localObject2).inteRemark = paramList.bytes_member_interemark.get().toStringUtf8();
            ((DiscussionMemberInfo)localObject2).inteRemarkSource = paramList.uint32_interemark_source.get();
          }
          for (;;)
          {
            localArrayList.add(localObject2);
            break;
            paramList = paramMap.b(((DiscussionMemberInfo)localObject2).memberUin);
            if ((paramList != null) && (paramList.isFriend()))
            {
              ((DiscussionMemberInfo)localObject2).memberName = paramList.name;
              if (TextUtils.isEmpty(paramList.remark)) {}
              for (paramList = paramList.name;; paramList = paramList.remark)
              {
                ((DiscussionMemberInfo)localObject2).inteRemark = paramList;
                ((DiscussionMemberInfo)localObject2).inteRemarkSource = 129L;
                break;
              }
            }
            ((DiscussionMemberInfo)localObject2).inteRemarkSource = 0L;
          }
          bool1 = false;
        }
      }
    }
  }
  
  private boolean a(boolean paramBoolean, List<cmd0x58a.ConfBaseInfo> paramList, List<Long> paramList1)
  {
    Object localObject2 = ((acdu)this.app.getManager(53)).getDiscussList();
    Object localObject1 = new HashMap(((ArrayList)localObject2).size());
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (DiscussionInfo)((Iterator)localObject2).next();
      ((HashMap)localObject1).put(((DiscussionInfo)localObject3).uin, localObject3);
    }
    localObject2 = new ArrayList(paramList.size());
    Object localObject3 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject4;
    while (paramList.hasNext())
    {
      localObject4 = (cmd0x58a.ConfBaseInfo)paramList.next();
      DiscussionInfo localDiscussionInfo = new DiscussionInfo();
      localDiscussionInfo.uin = String.valueOf(((cmd0x58a.ConfBaseInfo)localObject4).uint64_conf_uin.get());
      localDiscussionInfo.infoSeq = ((cmd0x58a.ConfBaseInfo)localObject4).uint32_info_seq.get();
      localDiscussionInfo.mUnreliableMemberCount = ((cmd0x58a.ConfBaseInfo)localObject4).uint32_member_num.get();
      ((ArrayList)localObject2).add(localDiscussionInfo);
      if (((cmd0x58a.ConfBaseInfo)localObject4).uint32_is_favorite.get() == 1) {
        ((ArrayList)localObject3).add(localDiscussionInfo.uin);
      }
      if (((HashMap)localObject1).containsKey(localDiscussionInfo.uin)) {
        ((HashMap)localObject1).remove(localDiscussionInfo.uin);
      }
    }
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "handleGetDiscussResp bakUinList size = " + paramList1.size());
      }
      paramList = paramList1.iterator();
      while (paramList.hasNext())
      {
        paramList1 = String.valueOf((Long)paramList.next());
        if (((HashMap)localObject1).containsKey(paramList1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "handleGetDiscussResp uin: " + paramList1 + " is in bakUinList,can not delete");
          }
          ((HashMap)localObject1).remove(paramList1);
        }
      }
    }
    paramList = this.app.a();
    paramList1 = new StringBuilder(100);
    paramList1.append("need delete dis ");
    localObject1 = ((HashMap)localObject1).keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (String)((Iterator)localObject1).next();
      paramList1.append((String)localObject4).append(";");
      Dz((String)localObject4);
      if (paramList.V((String)localObject4) != null) {
        paramList.Qi((String)localObject4);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, paramList1.toString());
    }
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionVerify", 2, "GetDiscussList dis_cnt=" + ((ArrayList)localObject2).size() + " fav_cnt=" + ((ArrayList)localObject3).size());
    }
    return e((ArrayList)localObject2, (ArrayList)localObject3);
  }
  
  private void c(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    MessageRecord localMessageRecord = anbi.d(-1004);
    localMessageRecord.init(paramLong1, paramLong2, paramLong2, paramString, NetConnInfoCenter.getServerTime(), -1004, 3000, NetConnInfoCenter.getServerTime());
    localMessageRecord.isread = true;
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "----------addMsgToDB after analysis friendUin: " + paramLong2 + " msgType: " + -1004 + " friendType: " + 3000 + " msgContent: " + aqft.pk(paramString));
    }
    paramString = (MessageHandler)this.app.getBusinessHandler(0);
    if (!achp.a(this.app, localMessageRecord, false)) {
      this.app.b().b(localMessageRecord, String.valueOf(paramLong1));
    }
  }
  
  private void da(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("discUid");
    paramToServiceMsg = new Object[4];
    paramToServiceMsg[0] = paramFromServiceMsg;
    paramToServiceMsg[1] = Boolean.valueOf(false);
    paramToServiceMsg[2] = Integer.valueOf(0);
    paramToServiceMsg[3] = Integer.valueOf(0);
    Object localObject = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
      if ((paramObject == null) || (!paramObject.uint32_result.has()) || (paramObject.uint32_result.get() != 0) || (!paramObject.bytes_bodybuffer.has()) || (paramObject.bytes_bodybuffer.get() == null))
      {
        notifyUI(1018, false, paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      notifyUI(1018, false, paramToServiceMsg);
      return;
    }
    localObject = new cmd0x921.RspBody();
    for (;;)
    {
      try
      {
        ((cmd0x921.RspBody)localObject).mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        boolean bool = ((cmd0x921.RspBody)localObject).msg_get_at_all_remain.bool_priviledge.get();
        if (!((cmd0x921.RspBody)localObject).msg_get_at_all_remain.uint32_uin_remain.has()) {
          break label290;
        }
        i = ((cmd0x921.RspBody)localObject).msg_get_at_all_remain.uint32_uin_remain.get();
        if (((cmd0x921.RspBody)localObject).msg_get_at_all_remain.uint32_discuss_uin_remain.has())
        {
          j = ((cmd0x921.RspBody)localObject).msg_get_at_all_remain.uint32_discuss_uin_remain.get();
          notifyUI(1018, true, new Object[] { paramFromServiceMsg, Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        notifyUI(1018, false, paramToServiceMsg);
        return;
      }
      int j = 0;
      continue;
      label290:
      int i = 0;
    }
  }
  
  private void dp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = (anaf.a)paramObject;
    paramObject = (RespGetDiscussInteRemark)paramToServiceMsg.eG;
    long l = paramObject.DiscussUin;
    Object localObject1 = (DiscussRespHeader)paramToServiceMsg.eF;
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleGetDiscussInteRemarkResp header.Result" + ((DiscussRespHeader)localObject1).Result);
    }
    if (((DiscussRespHeader)localObject1).Result != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("DiscussionHandler", 2, "header failed code: " + ((DiscussRespHeader)localObject1).Result);
      }
      notifyUI(1010, false, Long.valueOf(l));
    }
    do
    {
      return;
      if ((!paramFromServiceMsg.isSuccess()) || (!paramToServiceMsg.cew))
      {
        notifyUI(1010, false, Long.valueOf(l));
        return;
      }
      paramToServiceMsg = paramObject.InteRemarks;
      paramFromServiceMsg = (acdu)this.app.getManager(53);
      paramObject = paramFromServiceMsg.n(String.valueOf(l));
    } while ((paramToServiceMsg == null) || (paramObject == null));
    paramToServiceMsg.keySet();
    localObject1 = paramToServiceMsg.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Long)((Iterator)localObject1).next();
      DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)paramObject.get(String.valueOf(localObject2));
      if (localDiscussionMemberInfo != null)
      {
        localObject2 = (InteRemarkInfo)paramToServiceMsg.get(localObject2);
        localDiscussionMemberInfo.inteRemark = ((InteRemarkInfo)localObject2).StrValue;
        localDiscussionMemberInfo.inteRemarkSource = ((InteRemarkInfo)localObject2).Source;
        paramFromServiceMsg.a(localDiscussionMemberInfo);
      }
    }
    notifyUI(1010, true, Long.valueOf(l));
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleError serviceCmd:" + str);
    }
    if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(str)) {
      u(paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      do
      {
        return;
        if ("QQServiceDiscussSvc.ReqChangeDiscussName".equalsIgnoreCase(str))
        {
          t(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("QQServiceDiscussSvc.ReqCreateDiscuss".equalsIgnoreCase(str))
        {
          s(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("OidbSvc.0x58a".equalsIgnoreCase(str))
        {
          r(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
      } while ("QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(str));
      if ("QQServiceDiscussSvc.ReqQuitDiscuss".equalsIgnoreCase(str))
      {
        q(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussAttr".equalsIgnoreCase(str))
      {
        p(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussFlag".equalsIgnoreCase(str))
      {
        o(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QRCodeSvc.discuss_geturl".equals(str))
      {
        de(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("QRCodeSvc.discuss_decode".equals(str))
      {
        df(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("QQServiceDiscussSvc.ReqJoinDiscuss".equals(str))
      {
        dh(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("OidbSvc.0x921_0".equals(str))
      {
        notifyUI(1018, false, new Object[] { paramToServiceMsg.extraData.getString("discUid"), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) });
        return;
      }
      if ("OidbSvc.0x58b_0".equals(str))
      {
        K(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x751".equalsIgnoreCase(str))
      {
        ds(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
    } while (!"OidbSvc.0x44c".equals(str));
    dq(paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    notifyUI(1004, false, String.valueOf(paramToServiceMsg.extraData.getLong("discussUin")));
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    notifyUI(1000, false, null);
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = new Object[3];
    paramToServiceMsg[2] = Integer.valueOf(-1);
    notifyUI(1002, false, paramToServiceMsg);
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    notifyUI(1005, false, String.valueOf(paramToServiceMsg.extraData.getLong("discussUin")));
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    notifyUI(1003, false, new Object[] { String.valueOf(paramToServiceMsg.extraData.getLong("discussUin")), Integer.valueOf(-1), null });
  }
  
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleTimeOut serviceCmd:" + str);
    }
    if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(str)) {
      J(paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      return;
      if ("QQServiceDiscussSvc.ReqChangeDiscussName".equalsIgnoreCase(str))
      {
        I(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqCreateDiscuss".equalsIgnoreCase(str))
      {
        H(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x58a".equalsIgnoreCase(str))
      {
        G(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(str))
      {
        F(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqQuitDiscuss".equalsIgnoreCase(str))
      {
        E(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussAttr".equalsIgnoreCase(str))
      {
        D(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussFlag".equalsIgnoreCase(str))
      {
        C(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("QRCodeSvc.discuss_geturl".equals(str))
      {
        de(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("QRCodeSvc.discuss_decode".equals(str))
      {
        df(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("QQServiceDiscussSvc.ReqJoinDiscuss".equals(str))
      {
        dh(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("OidbSvc.0x865_3".equals(str))
      {
        z(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x870_4".equals(str))
      {
        B(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x870_5".equals(str))
      {
        A(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x921_0".equals(str))
      {
        notifyUI(1018, false, new Object[] { paramToServiceMsg.extraData.getString("discUid"), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) });
        return;
      }
      if ("OidbSvc.0x58b_0".equalsIgnoreCase(str))
      {
        L(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x751".equalsIgnoreCase(str))
      {
        ds(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
    } while (!"OidbSvc.0x44c".equals(str));
    dq(paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  private void w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l = paramToServiceMsg.extraData.getLong("dwDelMemberUin");
    notifyUI(1015, false, new long[] { Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin")).longValue(), Long.valueOf(l).longValue() });
  }
  
  private void x(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    notifyUI(1017, false, Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin")));
  }
  
  private void y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    notifyUI(1016, false, Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin")));
  }
  
  private void z(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      send(paramToServiceMsg);
      return;
    }
    w(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean D(ArrayList<DiscussInfo> paramArrayList)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("addOrUpdateDiscussion ");
      if (paramArrayList == null) {
        break label56;
      }
    }
    long l;
    label56:
    for (int i = paramArrayList.size();; i = -1)
    {
      QLog.d("Q.contacttab.dscs", 2, i);
      l = System.currentTimeMillis();
      if (paramArrayList != null) {
        break;
      }
      return true;
    }
    Object localObject2;
    acdu localacdu;
    DiscussionInfo localDiscussionInfo;
    try
    {
      localObject2 = this.app.getPreferences();
      localObject1 = "DiscusstionIconVersion" + this.app.getCurrentAccountUin();
      i = ((SharedPreferences)localObject2).getInt((String)localObject1, -1);
      DiscussInfo localDiscussInfo;
      if (i != 1)
      {
        localObject2 = ((SharedPreferences)localObject2).edit();
        ((SharedPreferences.Editor)localObject2).putInt((String)localObject1, 1);
        ((SharedPreferences.Editor)localObject2).commit();
        if (i != -1) {
          try
          {
            localObject1 = new String[2];
            localObject1[0] = acbn.bmD;
            localObject1[1] = "/data/data/com.tencent.tim/files/head/_hd/";
            int k = localObject1.length;
            i = 0;
            while (i < k)
            {
              localObject2 = new File(localObject1[i]);
              if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
              {
                localObject2 = ((File)localObject2).listFiles();
                int m = localObject2.length;
                int j = 0;
                while (j < m)
                {
                  localDiscussInfo = localObject2[j];
                  if (localDiscussInfo.getName().startsWith("discussion_"))
                  {
                    localDiscussInfo.delete();
                    if (QLog.isColorLevel()) {
                      QLog.d("DiscussionHandler", 2, "del discussion icon. name=" + localDiscussInfo.getName() + "," + localDiscussInfo.lastModified());
                    }
                  }
                  j += 1;
                }
              }
              i += 1;
            }
            localacdu = (acdu)this.app.getManager(53);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
      localObject2 = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      for (;;)
      {
        if (!paramArrayList.hasNext()) {
          break label509;
        }
        localDiscussInfo = (DiscussInfo)paramArrayList.next();
        localDiscussionInfo = localacdu.a(String.valueOf(localDiscussInfo.DiscussUin));
        if (localDiscussionInfo != null) {
          break;
        }
        localDiscussionInfo = new DiscussionInfo();
        localDiscussionInfo.uin = String.valueOf(localDiscussInfo.DiscussUin);
        localDiscussionInfo.infoSeq = -1L;
        localDiscussionInfo.timeSec = l;
        hk(Long.parseLong(localDiscussionInfo.uin));
        ((ArrayList)localObject2).add(localDiscussionInfo);
      }
      if (localDiscussionInfo.infoSeq == localDiscussInfo.InfoSeq) {
        break label498;
      }
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
      return false;
    }
    hk(Long.parseLong(localDiscussionInfo.uin));
    for (;;)
    {
      localDiscussionInfo.timeSec = l;
      break;
      label498:
      ((ArrayList)localObject2).add(localDiscussionInfo);
    }
    label509:
    boolean bool = localacdu.a((ArrayList)localObject2, l, true);
    return bool;
  }
  
  public void DA(String paramString)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("QRCodeSvc.discuss_decode");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    localToServiceMsg.extraData.putString("signature", paramString);
    FlyTicket.DiscussSigDecodeRequest localDiscussSigDecodeRequest = new FlyTicket.DiscussSigDecodeRequest();
    localDiscussSigDecodeRequest.sig.set(paramString);
    localToServiceMsg.putWupBuffer(localDiscussSigDecodeRequest.toByteArray());
    send(localToServiceMsg);
  }
  
  public void DB(String paramString)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqGetDiscussInfo");
    localToServiceMsg.extraData.putString("signature", paramString);
    send(localToServiceMsg);
  }
  
  public void Dz(String paramString)
  {
    this.a.FS(paramString);
    ((acdu)this.app.getManager(53)).jV(paramString);
    this.app.b().N(paramString, 3000);
    notifyUI(1004, true, paramString);
  }
  
  public void Y(long paramLong1, long paramLong2)
  {
    acdu localacdu = (acdu)this.app.getManager(53);
    if (localacdu.a(paramLong1 + "") == null) {
      hk(paramLong1);
    }
    while (localacdu.a(String.valueOf(paramLong1), String.valueOf(paramLong2)) != null) {
      return;
    }
    hk(paramLong1);
  }
  
  public void Z(long paramLong1, long paramLong2)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2149);
    localOIDBSSOPkg.uint32_service_type.set(3);
    Object localObject = ByteBuffer.allocate(20);
    ((ByteBuffer)localObject).putInt(aqft.ag(paramLong1)).putShort((short)1).putInt(aqft.ag(paramLong2));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x865_3");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("dwConfUin", paramLong1);
    ((ToServiceMsg)localObject).extraData.putShort("wUinNum", (short)1);
    ((ToServiceMsg)localObject).extraData.putLong("dwDelMemberUin", paramLong2);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public Drawable a(String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    Bitmap localBitmap = f(paramString, paramBoolean);
    paramString = localObject;
    if (localBitmap != null) {
      paramString = new BitmapDrawable(localBitmap);
    }
    return paramString;
  }
  
  public GroupIconHelper a()
  {
    return this.a;
  }
  
  public void a(long paramLong, byte paramByte1, byte paramByte2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqSetDiscussFlag");
    localToServiceMsg.extraData.putLong("discussUin", paramLong);
    localToServiceMsg.extraData.putByte("flag", paramByte1);
    localToServiceMsg.extraData.putByte("infoflag", paramByte2);
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "--->>set discuss flag uin: " + paramLong + " req: " + localToServiceMsg);
    }
    send(localToServiceMsg);
  }
  
  public void a(long paramLong, String paramString, List<String> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "notifyMemberChange disUin=" + paramLong + " cmdUin=" + paramString + " opType=" + paramInt + " uinsize=" + paramList.size());
    }
    MqqHandler localMqqHandler = this.app.getHandler(AVNotifyCenter.class);
    if (localMqqHandler != null)
    {
      Message localMessage = localMqqHandler.obtainMessage(paramInt);
      localMessage.obj = new Object[] { Long.valueOf(paramLong), paramString, (String[])paramList.toArray(new String[paramList.size()]) };
      localMqqHandler.sendMessage(localMessage);
    }
  }
  
  public void a(@NonNull acdt.c paramc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "getDiscussInfo2 " + paramc.uin);
    }
    synchronized (this.L)
    {
      if ((!this.L.containsKey(paramc.uin)) && (!this.K.containsKey(paramc.uin))) {
        this.L.put(paramc.uin, paramc);
      }
      while (!QLog.isColorLevel())
      {
        cIm();
        return;
      }
      QLog.d("Q.contacttab.dscs", 2, "getDiscussionInfo filtered " + paramc.uin);
    }
  }
  
  public void a(DiscussionInfo paramDiscussionInfo, boolean paramBoolean)
  {
    acxw localacxw = this.app.a().a();
    paramDiscussionInfo = localacxw.a(paramDiscussionInfo.uin, 3000);
    if (paramDiscussionInfo != null) {
      if (!paramBoolean) {
        break label75;
      }
    }
    label75:
    for (paramDiscussionInfo.showUpTime = (System.currentTimeMillis() / 1000L);; paramDiscussionInfo.showUpTime = 0L)
    {
      localacxw.e(paramDiscussionInfo);
      paramDiscussionInfo = this.app.getHandler(Conversation.class);
      if (paramDiscussionInfo != null) {
        paramDiscussionInfo.sendMessage(paramDiscussionInfo.obtainMessage(1009));
      }
      return;
    }
  }
  
  public void a(String paramString, ArrayList<AddDiscussMemberInfo> paramArrayList, int paramInt, long paramLong)
  {
    if ((paramString != null) && (paramArrayList != null))
    {
      localObject2 = (acdu)this.app.getManager(53);
      localObject1 = ((acdu)localObject2).a(paramArrayList);
      if (localObject1 != null)
      {
        notifyUI(1002, true, new Object[] { Long.valueOf(Long.parseLong(((DiscussionInfo)localObject1).uin)), ((DiscussionInfo)localObject1).discussionName, Integer.valueOf(0) });
        localObject3 = ((acdu)localObject2).z(((DiscussionInfo)localObject1).uin);
        localObject2 = new ArrayList();
        paramString = null;
        i = 0;
        if (i < ((ArrayList)localObject3).size())
        {
          localObject4 = (DiscussionMemberInfo)((ArrayList)localObject3).get(i);
          if (localObject4 != null) {
            if (((DiscussionMemberInfo)localObject4).memberUin != null)
            {
              paramInt = 0;
              if (((DiscussionMemberInfo)localObject4).memberUin.equals(((DiscussionInfo)localObject1).inheritOwnerUin))
              {
                paramInt = 1;
                label157:
                if (paramInt == 0) {
                  break label221;
                }
                paramString = new DiscussionMemberInfo();
                paramString.memberUin = ((DiscussionMemberInfo)localObject4).memberUin;
                paramString.memberName = aqgv.a((DiscussionMemberInfo)localObject4, this.app);
              }
            }
          }
          for (;;)
          {
            i += 1;
            break;
            if (!((DiscussionMemberInfo)localObject4).memberUin.equals(((DiscussionInfo)localObject1).ownerUin)) {
              break label157;
            }
            paramInt = 1;
            break label157;
            label221:
            if (!((DiscussionMemberInfo)localObject4).memberUin.equalsIgnoreCase(this.app.getCurrentAccountUin()))
            {
              localObject5 = new DiscussionMemberInfo();
              ((DiscussionMemberInfo)localObject5).memberUin = ((DiscussionMemberInfo)localObject4).memberUin;
              ((DiscussionMemberInfo)localObject5).memberName = aqgv.a((DiscussionMemberInfo)localObject4, this.app);
              ((DiscussionMemberInfo)localObject5).discussionUin = ChnToSpell.aJ(((DiscussionMemberInfo)localObject5).memberName, 1);
              ((List)localObject2).add(localObject5);
            }
          }
        }
        Collections.sort((List)localObject2, new acdb.a());
        if (paramString != null) {
          ((List)localObject2).add(0, paramString);
        }
        paramString = new StringBuffer();
        paramString.append("你与");
        paramInt = 0;
        while ((paramInt < ((List)localObject2).size()) && (paramInt < 3))
        {
          localObject3 = (DiscussionMemberInfo)((List)localObject2).get(paramInt);
          if (!((DiscussionMemberInfo)localObject3).memberUin.equalsIgnoreCase(this.app.getCurrentAccountUin()))
          {
            paramString.append(((DiscussionMemberInfo)localObject3).memberName);
            paramString.append("、");
          }
          paramInt += 1;
        }
        paramString.deleteCharAt(paramString.length() - 1);
        if (((List)localObject2).size() > 3) {
          paramString.append("等");
        }
        paramString.append(paramArrayList.size());
        paramString.append("个成员已有该多人聊天。");
        paramArrayList = this.app.getCurrentAccountUin();
        paramString = new ahwa(((DiscussionInfo)localObject1).uin, paramArrayList, paramString.toString(), 3000, -5040, 65560, anaz.gQ());
        paramArrayList = new MessageForUniteGrayTip();
        paramArrayList.initGrayTipMsg(this.app, paramString);
        ahwb.a(this.app, paramArrayList);
      }
    }
    else
    {
      return;
    }
    Object localObject1 = createToServiceMsg("QQServiceDiscussSvc.ReqCreateDiscuss");
    int j = paramArrayList.size();
    Object localObject2 = new long[j];
    Object localObject3 = new int[j];
    Object localObject4 = new long[j];
    Object localObject5 = new String[j];
    int i = 0;
    while (i < j)
    {
      localObject2[i] = ((AddDiscussMemberInfo)paramArrayList.get(i)).Uin;
      localObject3[i] = ((AddDiscussMemberInfo)paramArrayList.get(i)).Type;
      localObject4[i] = ((AddDiscussMemberInfo)paramArrayList.get(i)).RefUin;
      localObject5[i] = ((AddDiscussMemberInfo)paramArrayList.get(i)).RefStr;
      i += 1;
    }
    ((ToServiceMsg)localObject1).extraData.putLongArray("uin", (long[])localObject2);
    ((ToServiceMsg)localObject1).extraData.putIntArray("type", (int[])localObject3);
    ((ToServiceMsg)localObject1).extraData.putLongArray("refUin", (long[])localObject4);
    ((ToServiceMsg)localObject1).extraData.putStringArray("refStr", (String[])localObject5);
    ((ToServiceMsg)localObject1).extraData.putString("name", paramString);
    ((ToServiceMsg)localObject1).extraData.putInt("from", paramInt);
    ((ToServiceMsg)localObject1).extraData.putLong("uiControlFlag", paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "--->>create discuss name: " + paramString + " req: " + localObject1);
    }
    send((ToServiceMsg)localObject1);
  }
  
  public void a(String paramString, HashSet<String> paramHashSet)
  {
    if ((paramString == null) || (paramHashSet == null) || (paramHashSet.size() == 0)) {
      return;
    }
    acdu localacdu = (acdu)this.app.getManager(53);
    DiscussionInfo localDiscussionInfo = localacdu.a(paramString);
    if (localDiscussionInfo != null) {
      localDiscussionInfo.DiscussionFlag |= 0x20000000;
    }
    localacdu.a(paramString, paramHashSet);
  }
  
  public boolean a(DiscussionInfo paramDiscussionInfo)
  {
    paramDiscussionInfo = this.app.a().a().a(paramDiscussionInfo.uin, 3000);
    if (paramDiscussionInfo == null) {}
    while (paramDiscussionInfo.showUpTime == 0L) {
      return false;
    }
    return true;
  }
  
  public void ad(long paramLong, String paramString)
  {
    if (paramString != null)
    {
      ToServiceMsg localToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqChangeDiscussName");
      localToServiceMsg.extraData.putLong("discussUin", paramLong);
      localToServiceMsg.extraData.putString("newName", paramString);
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "--->>change discuss name uin: " + paramLong + " req: " + localToServiceMsg);
      }
      send(localToServiceMsg);
    }
  }
  
  public void ah(long paramLong, boolean paramBoolean)
  {
    if ((this.Pq > 0L) && (System.currentTimeMillis() - this.Pq < 120000L)) {
      return;
    }
    this.Pq = System.currentTimeMillis();
    ToServiceMsg localToServiceMsg = createToServiceMsg("QRCodeSvc.discuss_geturl");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    localToServiceMsg.extraData.putLong("discussUin", paramLong);
    FlyTicket.DiscussGetUrlRequest localDiscussGetUrlRequest = new FlyTicket.DiscussGetUrlRequest();
    localDiscussGetUrlRequest.conf_uin.set((int)paramLong);
    localDiscussGetUrlRequest.is_need_long_link.set(paramBoolean);
    localToServiceMsg.putWupBuffer(localDiscussGetUrlRequest.toByteArray());
    send(localToServiceMsg);
  }
  
  public void aw(long paramLong, int paramInt)
  {
    long l1 = AudioHelper.hG();
    String str = String.valueOf(paramLong);
    Object localObject = ((acdu)this.app.getManager(53)).a(str);
    if (localObject == null) {
      str = "" + "[DiscussionInfo为空], ";
    }
    for (;;)
    {
      QLog.w("DiscussionHandler", 1, "setHrConfExtraInfo, discUin[" + paramLong + "], discHrExtraValue[" + paramInt + "], debugSeq[" + l1 + "], " + str);
      return;
      if ((((DiscussionInfo)localObject).mOrigin & 0x2) != 2L)
      {
        str = "" + "mOrigin[" + ((DiscussionInfo)localObject).mOrigin + "], ";
      }
      else
      {
        int i = ((DiscussionInfo)localObject).getHrExtra();
        if ((paramInt == 1) && (i != 0))
        {
          str = "" + "hrExtra[" + i + "], ";
        }
        else
        {
          cmd0x44c.ReqBody localReqBody = new cmd0x44c.ReqBody();
          localReqBody.uint32_subcmd.set(1);
          cmd0x44c.ModifyConfInfoReq localModifyConfInfoReq = new cmd0x44c.ModifyConfInfoReq();
          localModifyConfInfoReq.uint64_conf_uin.set(paramLong);
          long l2 = ((DiscussionInfo)localObject).mOriginExtra;
          long l3 = paramInt & 0x3;
          localModifyConfInfoReq.uint32_conf_meeting_option.set((int)(l2 & 0xFFFFFFFC | l3));
          localReqBody.msg_modify_conf_info_req.set(localModifyConfInfoReq);
          localObject = makeOIDBPkg("OidbSvc.0x44c", 1100, 2, localReqBody.toByteArray());
          ((ToServiceMsg)localObject).extraData.putLong("debugSeq", l1);
          ((ToServiceMsg)localObject).extraData.putString("uin", str);
          ((ToServiceMsg)localObject).extraData.putInt("value", paramInt);
          sendPbReq((ToServiceMsg)localObject);
          str = "" + "reqAppSeq[" + ((ToServiceMsg)localObject).getAppSeq() + "], reqSsoSeq[" + ((ToServiceMsg)localObject).getRequestSsoSeq() + "], ";
        }
      }
    }
  }
  
  public void b(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApp(), acdw.class);
    localNewIntent.putExtra("key_cmd", 0);
    localNewIntent.putExtra("field_id", paramArrayOfString1);
    localNewIntent.putExtra("uin_list", paramArrayOfString2);
    this.app.startServlet(localNewIntent);
  }
  
  public void bA(String paramString, boolean paramBoolean)
  {
    if (this.app.a.abT())
    {
      if (paramBoolean)
      {
        this.a.FP(paramString);
        return;
      }
      this.a.FQ(paramString);
      return;
    }
    if (this.sW == null) {
      this.sW = new ArrayList();
    }
    paramString = new Pair(Boolean.valueOf(paramBoolean), paramString);
    this.sW.add(paramString);
  }
  
  public boolean bE(long paramLong)
  {
    return paramLong > 1000000L;
  }
  
  public void c(String paramString, ArrayList<AddDiscussMemberInfo> paramArrayList, int paramInt)
  {
    a(paramString, paramArrayList, paramInt, 0L);
  }
  
  public void cIk()
  {
    notifyUI(1008, true, null);
  }
  
  public void cIl()
  {
    if ((this.app.a.abT()) && (this.sW != null) && (!this.sW.isEmpty()))
    {
      int i = 0;
      if (i < this.sW.size())
      {
        Pair localPair = (Pair)this.sW.get(i);
        if ((localPair == null) || (localPair.first == null) || (localPair.second == null)) {}
        for (;;)
        {
          i += 1;
          break;
          if (((Boolean)localPair.first).booleanValue()) {
            a((String)localPair.second, false);
          } else {
            this.a.FQ((String)localPair.second);
          }
        }
      }
      this.sW = null;
    }
  }
  
  public void cIm()
  {
    ArrayList localArrayList = new ArrayList(50);
    synchronized (this.L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "startGetDiscussionInfoWorkV2, discussionUinListofGetinfo[" + this.L.size() + "], mGettingDiscussUins[" + this.K.size() + "]");
      }
      if (this.L.size() == 0) {
        return;
      }
      if (this.K.size() >= 100) {
        return;
      }
    }
    Object localObject2 = (acdu)this.app.getManager(53);
    Object localObject3 = this.L.entrySet().iterator();
    int i = 0;
    int j = 0;
    int m;
    for (int k = 0; ((Iterator)localObject3).hasNext(); k = m)
    {
      acdt.c localc = (acdt.c)((Map.Entry)((Iterator)localObject3).next()).getValue();
      if ((localc.memberCount + j > 500) || (i >= 50)) {
        break;
      }
      ((Iterator)localObject3).remove();
      DiscussionInfo localDiscussionInfo = ((acdu)localObject2).a(localc.uin);
      m = k;
      if (localDiscussionInfo != null)
      {
        m = k;
        if (k > (int)localDiscussionInfo.timeSec) {
          m = (int)localDiscussionInfo.timeSec;
        }
      }
      this.K.put(localc.uin, localc);
      localList.add(Long.valueOf(Long.parseLong(localc.uin)));
      j += localc.memberCount;
      i += 1;
    }
    QLog.d("DiscussionVerify", 2, "updateBatchDiscussInfo dis_cnt=%tu mem_cnt=%tu" + i + " mem_cnt=" + j);
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "startGetDiscussionInfoWorkV2, disUin[" + localList.toString() + "]");
    }
    ??? = new cmd0x58b.ReqBody();
    ((cmd0x58b.ReqBody)???).uint32_subcmd.set(3);
    try
    {
      localObject2 = new cmd0x58b.GetMultiConfInfoReq();
      ((cmd0x58b.GetMultiConfInfoReq)localObject2).uint64_conf_uin.set(localList);
      localObject3 = (acdu)this.app.getManager(53);
      ((cmd0x58b.GetMultiConfInfoReq)localObject2).uint32_interemark_timestamp.set(k);
      localObject3 = new cmd0x58b.ConfBaseInfo();
      ((cmd0x58b.ConfBaseInfo)localObject3).bytes_conf_name.set(ByteStringMicro.copyFromUtf8(""));
      ((cmd0x58b.ConfBaseInfo)localObject3).uint32_create_time.set(0);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint64_owner_uin.set(0L);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint32_info_seq.set(0);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint32_last_info_time.set(0);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint32_msg_seq.set(0);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint32_last_msg_time.set(0);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint32_member_num.set(0);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint32_flag.set(0);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint64_inherit_owner_uin.set(0L);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint64_group_code.set(0L);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint64_group_uin.set(0L);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint32_conf_meeting_origin.set(0);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint32_conf_meeting_option.set(0);
      ((cmd0x58b.GetMultiConfInfoReq)localObject2).msg_conf_base_info.set((MessageMicro)localObject3);
      localObject3 = new cmd0x58b.ConfMemberInfo();
      ((cmd0x58b.ConfMemberInfo)localObject3).uint32_join_time.set(0);
      ((cmd0x58b.ConfMemberInfo)localObject3).uint32_flag.set(0);
      ((cmd0x58b.ConfMemberInfo)localObject3).uint32_read_msg_seq.set(0);
      ((cmd0x58b.ConfMemberInfo)localObject3).bytes_member_interemark.set(ByteStringMicro.copyFromUtf8(""));
      ((cmd0x58b.ConfMemberInfo)localObject3).uint32_interemark_source.set(0);
      ((cmd0x58b.GetMultiConfInfoReq)localObject2).msg_conf_mem_info.set((MessageMicro)localObject3);
      ((cmd0x58b.ReqBody)???).msg_get_multi_conf_info.set((MessageMicro)localObject2);
      ??? = makeOIDBPkg("OidbSvc.0x58b_0", 1419, 0, ((cmd0x58b.ReqBody)???).toByteArray());
      ((ToServiceMsg)???).extraData.putSerializable("discussUin", localList);
      sendPbReq((ToServiceMsg)???);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DiscussionHandler", 2, "startGetDiscussionInfoWorkV2 disUin:" + localList.toString() + " error:" + localException.toString());
        }
      }
    }
  }
  
  /* Error */
  protected void db(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 391
    //   9: iconst_2
    //   10: ldc_w 1581
    //   13: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_2
    //   17: invokevirtual 791	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   20: ifeq +429 -> 449
    //   23: aload_3
    //   24: ifnull +425 -> 449
    //   27: iconst_1
    //   28: istore 9
    //   30: aload_1
    //   31: getfield 72	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   34: ldc_w 910
    //   37: invokevirtual 874	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   40: invokestatic 786	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   43: astore_2
    //   44: aload_1
    //   45: getfield 72	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   48: ldc_w 912
    //   51: invokevirtual 874	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   54: invokestatic 786	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   57: astore_1
    //   58: iload 9
    //   60: istore 8
    //   62: iload 9
    //   64: ifeq +426 -> 490
    //   67: new 717	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   70: dup
    //   71: invokespecial 718	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   74: astore 14
    //   76: aload 14
    //   78: aload_3
    //   79: checkcast 720	[B
    //   82: checkcast 720	[B
    //   85: invokevirtual 724	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   88: pop
    //   89: aload 14
    //   91: getfield 727	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   94: invokevirtual 300	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   97: istore 4
    //   99: iload 4
    //   101: ifne +354 -> 455
    //   104: iconst_1
    //   105: istore 8
    //   107: aload_1
    //   108: invokevirtual 915	java/lang/Long:longValue	()J
    //   111: lstore 10
    //   113: aload_2
    //   114: invokevirtual 915	java/lang/Long:longValue	()J
    //   117: lstore 12
    //   119: aload_0
    //   120: getfield 414	acdt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   123: aload_1
    //   124: invokestatic 220	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   127: aload_2
    //   128: invokestatic 220	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   131: invokestatic 1585	aqgv:m	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   134: astore_3
    //   135: new 177	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 1586
    //   145: invokestatic 1590	acfp:m	(I)Ljava/lang/String;
    //   148: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_0
    //   152: getfield 414	acdt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   155: invokevirtual 1416	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   158: ldc_w 1591
    //   161: iconst_1
    //   162: anewarray 336	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: aload_3
    //   168: aastore
    //   169: invokevirtual 1596	com/tencent/qphone/base/util/BaseApplication:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   172: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: astore_3
    //   179: aload_0
    //   180: aload_0
    //   181: getfield 414	acdt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   184: invokevirtual 58	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   187: invokestatic 996	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   190: aload_1
    //   191: invokevirtual 915	java/lang/Long:longValue	()J
    //   194: aload_1
    //   195: invokevirtual 915	java/lang/Long:longValue	()J
    //   198: aload_3
    //   199: invokespecial 1598	acdt:c	(JJJLjava/lang/String;)V
    //   202: aload_0
    //   203: getfield 414	acdt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   206: bipush 53
    //   208: invokevirtual 575	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   211: checkcast 386	acdu
    //   214: aload_1
    //   215: invokestatic 220	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   218: invokevirtual 991	acdu:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   221: astore_3
    //   222: iconst_0
    //   223: istore 6
    //   225: iload 6
    //   227: istore 5
    //   229: aload_3
    //   230: ifnull +92 -> 322
    //   233: aload_3
    //   234: getfield 1601	com/tencent/mobileqq/data/DiscussionInfo:faceUinSet	Ljava/lang/String;
    //   237: astore 14
    //   239: iload 6
    //   241: istore 5
    //   243: aload 14
    //   245: ifnull +77 -> 322
    //   248: iload 6
    //   250: istore 5
    //   252: aload 14
    //   254: invokevirtual 1604	java/lang/String:trim	()Ljava/lang/String;
    //   257: ldc_w 1052
    //   260: invokevirtual 543	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   263: ifne +59 -> 322
    //   266: aload 14
    //   268: ldc_w 637
    //   271: invokevirtual 1608	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   274: astore 14
    //   276: iload 6
    //   278: istore 5
    //   280: aload 14
    //   282: ifnull +40 -> 322
    //   285: aload 14
    //   287: arraylength
    //   288: istore 7
    //   290: iconst_0
    //   291: istore 4
    //   293: iload 6
    //   295: istore 5
    //   297: iload 4
    //   299: iload 7
    //   301: if_icmpge +21 -> 322
    //   304: aload 14
    //   306: iload 4
    //   308: aaload
    //   309: aload_2
    //   310: invokestatic 220	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   313: invokevirtual 543	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   316: ifeq +198 -> 514
    //   319: iconst_1
    //   320: istore 5
    //   322: aload_1
    //   323: invokestatic 220	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   326: astore 14
    //   328: new 1311	java/util/HashSet
    //   331: dup
    //   332: invokespecial 1609	java/util/HashSet:<init>	()V
    //   335: astore 15
    //   337: aload 15
    //   339: new 177	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   346: aload_2
    //   347: invokevirtual 1130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   350: ldc_w 1052
    //   353: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokevirtual 1610	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   362: pop
    //   363: aload_0
    //   364: aload 14
    //   366: aload 15
    //   368: invokevirtual 1612	acdt:a	(Ljava/lang/String;Ljava/util/HashSet;)V
    //   371: new 169	java/util/ArrayList
    //   374: dup
    //   375: invokespecial 576	java/util/ArrayList:<init>	()V
    //   378: astore 14
    //   380: aload 14
    //   382: aload_2
    //   383: invokestatic 220	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   386: invokeinterface 582 2 0
    //   391: pop
    //   392: aload_0
    //   393: aload_1
    //   394: invokevirtual 915	java/lang/Long:longValue	()J
    //   397: aload_0
    //   398: getfield 414	acdt:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   401: invokevirtual 58	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   404: aload 14
    //   406: iconst_2
    //   407: invokevirtual 1614	acdt:a	(JLjava/lang/String;Ljava/util/List;I)V
    //   410: iload 5
    //   412: ifeq +14 -> 426
    //   415: aload_0
    //   416: getfield 63	acdt:a	Lcom/tencent/mobileqq/app/face/GroupIconHelper;
    //   419: aload_3
    //   420: getfield 526	com/tencent/mobileqq/data/DiscussionInfo:uin	Ljava/lang/String;
    //   423: invokevirtual 530	com/tencent/mobileqq/app/face/GroupIconHelper:FR	(Ljava/lang/String;)V
    //   426: aload_0
    //   427: sipush 1015
    //   430: iload 8
    //   432: iconst_2
    //   433: newarray long
    //   435: dup
    //   436: iconst_0
    //   437: lload 10
    //   439: lastore
    //   440: dup
    //   441: iconst_1
    //   442: lload 12
    //   444: lastore
    //   445: invokevirtual 238	acdt:notifyUI	(IZLjava/lang/Object;)V
    //   448: return
    //   449: iconst_0
    //   450: istore 9
    //   452: goto -422 -> 30
    //   455: iconst_0
    //   456: istore 8
    //   458: goto -351 -> 107
    //   461: astore_3
    //   462: iconst_0
    //   463: istore 9
    //   465: iload 9
    //   467: istore 8
    //   469: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   472: ifeq +18 -> 490
    //   475: ldc_w 1616
    //   478: iconst_2
    //   479: aload_3
    //   480: invokevirtual 1619	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   483: invokestatic 559	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   486: iload 9
    //   488: istore 8
    //   490: goto -383 -> 107
    //   493: astore_3
    //   494: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   497: ifeq -295 -> 202
    //   500: ldc_w 391
    //   503: iconst_2
    //   504: ldc_w 1621
    //   507: aload_3
    //   508: invokestatic 1624	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   511: goto -309 -> 202
    //   514: iload 4
    //   516: iconst_1
    //   517: iadd
    //   518: istore 4
    //   520: goto -227 -> 293
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	this	acdt
    //   0	523	1	paramToServiceMsg	ToServiceMsg
    //   0	523	2	paramFromServiceMsg	FromServiceMsg
    //   0	523	3	paramObject	Object
    //   97	422	4	i	int
    //   227	184	5	j	int
    //   223	71	6	k	int
    //   288	14	7	m	int
    //   60	429	8	bool1	boolean
    //   28	459	9	bool2	boolean
    //   111	327	10	l1	long
    //   117	326	12	l2	long
    //   74	331	14	localObject	Object
    //   335	32	15	localHashSet	HashSet
    // Exception table:
    //   from	to	target	type
    //   67	99	461	java/lang/Exception
    //   179	202	493	java/lang/NumberFormatException
  }
  
  protected void dc(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleCollectDisucssionResp");
    }
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      paramToServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin"));
      if (!bool1) {
        break label199;
      }
    }
    label199:
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = bool3;
        if (bool1)
        {
          paramFromServiceMsg = (acdu)this.app.getManager(53);
          paramObject = paramFromServiceMsg.a(String.valueOf(paramToServiceMsg));
          if (paramObject != null)
          {
            long l = System.currentTimeMillis();
            paramObject.hasCollect = true;
            paramObject.timeSec = l;
            paramFromServiceMsg.a(paramObject);
            paramFromServiceMsg.e(paramObject);
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("handleCollectDisucssionResp", 2, paramFromServiceMsg.getMessage());
        bool1 = bool2;
        continue;
      }
      notifyUI(1016, bool1, paramToServiceMsg);
      return;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  protected void dd(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleUncollectDisucssionResp");
    }
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      paramToServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin"));
      if (!bool1) {
        break label199;
      }
    }
    label199:
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = bool3;
        if (bool1)
        {
          paramFromServiceMsg = (acdu)this.app.getManager(53);
          paramObject = paramFromServiceMsg.a(String.valueOf(paramToServiceMsg));
          if (paramObject != null)
          {
            long l = System.currentTimeMillis();
            paramObject.hasCollect = false;
            paramObject.timeSec = l;
            paramFromServiceMsg.a(paramObject);
            paramFromServiceMsg.e(paramObject);
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("handleUncollectDisucssionResp", 2, paramFromServiceMsg.getMessage());
        bool1 = bool2;
        continue;
      }
      notifyUI(1017, bool1, paramToServiceMsg);
      return;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  protected void de(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleGetFlyTicket");
    }
    this.Pq = 0L;
    long l2 = -1L;
    FlyTicket.DiscussGetUrlResponse localDiscussGetUrlResponse = new FlyTicket.DiscussGetUrlResponse();
    paramObject = localDiscussGetUrlResponse;
    long l1 = l2;
    if (paramFromServiceMsg != null)
    {
      paramObject = localDiscussGetUrlResponse;
      l1 = l2;
      if (!paramFromServiceMsg.isSuccess()) {}
    }
    try
    {
      paramFromServiceMsg = (FlyTicket.DiscussGetUrlResponse)localDiscussGetUrlResponse.mergeFrom(paramFromServiceMsg.getWupBuffer());
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.ret_info.get() != null))
      {
        l1 = ((FlyTicket.RetInfo)paramFromServiceMsg.ret_info.get()).ret_code.get();
        paramObject = paramFromServiceMsg;
        l2 = paramToServiceMsg.extraData.getLong("discussUin");
        if (l1 == 0L)
        {
          bool = true;
          notifyUI(1011, bool, new Object[] { String.valueOf(l1), paramObject, Long.valueOf(l2) });
          return;
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = null;
        continue;
        boolean bool = false;
        continue;
        paramObject = paramFromServiceMsg;
        l1 = l2;
      }
    }
  }
  
  protected void df(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = null;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleDecodeFlyTicket");
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramObject = new FlyTicket.DiscussSigDecodeResponse();
      try
      {
        paramFromServiceMsg = (FlyTicket.DiscussSigDecodeResponse)paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
          continue;
          boolean bool1 = false;
        }
      }
      bool1 = bool2;
      if (paramToServiceMsg != null)
      {
        bool1 = bool2;
        if (paramToServiceMsg.ret_info.get() != null)
        {
          if (((FlyTicket.RetInfo)paramToServiceMsg.ret_info.get()).ret_code.get() != 0) {
            break label117;
          }
          bool1 = true;
        }
      }
      notifyUI(1012, bool1, paramToServiceMsg);
      return;
    }
    label117:
    notifyUI(1012, false, null);
  }
  
  protected void dg(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l2 = -1L;
    DiscussRespHeader localDiscussRespHeader = null;
    paramToServiceMsg = localDiscussRespHeader;
    long l1 = l2;
    if (paramFromServiceMsg != null)
    {
      paramToServiceMsg = localDiscussRespHeader;
      l1 = l2;
      if (paramFromServiceMsg.isSuccess())
      {
        paramToServiceMsg = localDiscussRespHeader;
        l1 = l2;
        if (paramObject != null)
        {
          paramToServiceMsg = (anaf.a)paramObject;
          localDiscussRespHeader = (DiscussRespHeader)paramToServiceMsg.eF;
          paramObject = (RespGetDiscussInfo)paramToServiceMsg.eG;
          paramToServiceMsg = paramObject;
          l1 = l2;
          if (localDiscussRespHeader != null)
          {
            l1 = localDiscussRespHeader.Result;
            paramToServiceMsg = paramObject;
          }
        }
      }
    }
    paramObject = new Object[2];
    paramObject[0] = String.valueOf(l1);
    paramObject[1] = paramToServiceMsg;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (l1 == 0L))
    {
      notifyUI(1013, true, paramObject);
      return;
    }
    notifyUI(1013, false, paramObject);
  }
  
  protected void dh(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l2 = -1L;
    this.Pr = 0L;
    long l1;
    long l3;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramObject = (anaf.a)paramObject;
      paramToServiceMsg = (DiscussRespHeader)paramObject.eF;
      paramObject = (RespJoinDiscuss)paramObject.eG;
      if (paramToServiceMsg != null)
      {
        l1 = paramToServiceMsg.Result;
        if (paramObject != null)
        {
          l3 = paramObject.DiscussUin;
          l2 = l1;
          l1 = l3;
        }
      }
    }
    for (;;)
    {
      paramToServiceMsg = new Long[2];
      paramToServiceMsg[0] = Long.valueOf(l2);
      paramToServiceMsg[1] = Long.valueOf(l1);
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (l2 == 0L) && (l1 > 0L))
      {
        notifyUI(1014, true, paramToServiceMsg);
        return;
      }
      notifyUI(1014, false, paramToServiceMsg);
      return;
      l3 = -1L;
      l2 = l1;
      l1 = l3;
      continue;
      l1 = -1L;
      break;
      l1 = -1L;
    }
  }
  
  protected void di(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("discussUin"));
    paramToServiceMsg = Byte.valueOf(paramToServiceMsg.extraData.getByte("infoflag"));
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "handleSetDiscussFlagResp dis=" + paramFromServiceMsg + " flag=" + paramToServiceMsg);
    }
    paramObject = (acdu)this.app.getManager(53);
    paramFromServiceMsg = paramObject.a(String.valueOf(paramFromServiceMsg), this.app.getCurrentAccountUin());
    if (paramFromServiceMsg != null)
    {
      paramFromServiceMsg.flag = paramToServiceMsg.byteValue();
      paramObject.a(paramFromServiceMsg);
    }
  }
  
  protected void dj(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handle set discuss attr req: " + paramToServiceMsg + " ~~resp: " + paramFromServiceMsg + " ~~ data: " + paramObject);
    }
  }
  
  protected void dk(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleQuitDiscussResp");
    }
    paramObject = (anaf.a)paramObject;
    Object localObject = (RespQuitDiscuss)paramObject.eG;
    localObject = (DiscussRespHeader)paramObject.eF;
    String str1 = String.valueOf(paramToServiceMsg.extraData.getLong("discussUin"));
    int i = ((DiscussRespHeader)localObject).Result;
    String str2 = ((DiscussRespHeader)localObject).ResultDesc;
    if (((DiscussRespHeader)localObject).Result != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("DiscussionHandler", 2, "header failed! failed code: " + ((DiscussRespHeader)localObject).Result);
      }
      notifyUI(2000, true, new Object[] { str1, Integer.valueOf(i), str2 });
      notifyUI(1004, false, str1);
      return;
    }
    if ((!paramFromServiceMsg.isSuccess()) || (!paramObject.cew))
    {
      notifyUI(1004, false, str1);
      return;
    }
    Dz(str1);
    paramFromServiceMsg = new ArrayList();
    paramFromServiceMsg.add(this.app.getCurrentAccountUin());
    a(paramToServiceMsg.extraData.getLong("discussUin"), this.app.getCurrentAccountUin(), paramFromServiceMsg, 10009);
  }
  
  protected void dl(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = new acdt.b(paramToServiceMsg).a();
        if (!paramToServiceMsg.WE()) {
          break label121;
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.contacttab.dscs", 2, "merge fail " + paramToServiceMsg.toString());
        }
        notifyUI(1000, false, null);
        return;
      }
      notifyUI(1000, bool, null);
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussRespV2 excep", paramToServiceMsg);
      }
      bool = false;
    }
    for (;;)
    {
      return;
      label121:
      bool = a(false, paramToServiceMsg.dR(), paramToServiceMsg.dS());
    }
  }
  
  protected void dm(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleChangeDiscussNameResp");
    }
    paramObject = (anaf.a)paramObject;
    paramFromServiceMsg = (RespChangeDiscussName)paramObject.eG;
    Object localObject = (DiscussRespHeader)paramObject.eF;
    paramFromServiceMsg = String.valueOf(paramToServiceMsg.extraData.getLong("discussUin"));
    int i = ((DiscussRespHeader)localObject).Result;
    String str = ((DiscussRespHeader)localObject).ResultDesc;
    if (((DiscussRespHeader)localObject).Result != 0)
    {
      notifyUI(2000, true, new Object[] { paramFromServiceMsg, Integer.valueOf(i), str });
      notifyUI(1005, false, paramFromServiceMsg);
      return;
    }
    if (paramObject.cew)
    {
      paramObject = (acdu)this.app.getManager(53);
      localObject = paramObject.a(paramFromServiceMsg);
      if (localObject != null)
      {
        ((DiscussionInfo)localObject).discussionName = paramToServiceMsg.extraData.getString("newName");
        ((DiscussionInfo)localObject).DiscussionFlag &= 0xFFFFFFBF;
        paramObject.d((DiscussionInfo)localObject);
      }
      notifyUI(1005, true, paramFromServiceMsg);
      return;
    }
    notifyUI(1005, false, paramFromServiceMsg);
  }
  
  protected void dn(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleCreateDiscussResp ");
    }
    Object[] arrayOfObject = new Object[3];
    paramObject = (anaf.a)paramObject;
    arrayOfObject[2] = Integer.valueOf(((DiscussRespHeader)paramObject.eF).Result);
    if ((!paramFromServiceMsg.isSuccess()) || (!paramObject.cew))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "create discussion fail, result code: " + paramFromServiceMsg.getResultCode() + " errMsg: " + paramFromServiceMsg.getBusinessFailMsg() + " respPackage.bSuccess: " + paramObject.cew);
      }
      notifyUI(1002, false, arrayOfObject);
      return;
    }
    paramFromServiceMsg = (RespCreateDiscuss)paramObject.eG;
    if (!bE(paramFromServiceMsg.DiscussUin))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "create discussion fail: invalid discussion uin");
      }
      notifyUI(1002, false, arrayOfObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "create discussion succeeded " + paramFromServiceMsg.DiscussUin);
    }
    paramObject = (acff)this.app.getManager(51);
    acdu localacdu = (acdu)this.app.getManager(53);
    Object localObject2 = new DiscussionInfo();
    ((DiscussionInfo)localObject2).uin = String.valueOf(paramFromServiceMsg.DiscussUin);
    ((DiscussionInfo)localObject2).discussionName = paramToServiceMsg.extraData.getString("name");
    ((DiscussionInfo)localObject2).infoSeq = -1L;
    ((DiscussionInfo)localObject2).createFrom = paramToServiceMsg.extraData.getInt("from", 0);
    ((DiscussionInfo)localObject2).uiControlFlag = paramToServiceMsg.extraData.getLong("uiControlFlag", 0L);
    if (((DiscussionInfo)localObject2).isUIControlFlag_Hidden_RecentUser())
    {
      localObject1 = localacdu.z(((DiscussionInfo)localObject2).uin);
      if (localObject1 != null)
      {
        int j = ((ArrayList)localObject1).size();
        i = 0;
        if (i < j)
        {
          localObject3 = (DiscussionMemberInfo)((ArrayList)localObject1).get(i);
          if (localObject3 == null) {
            break label638;
          }
          localObject3 = ((DiscussionMemberInfo)localObject3).memberUin;
          if ((TextUtils.isEmpty((CharSequence)localObject3)) || (((String)localObject3).equals(this.app.getCurrentAccountUin()))) {
            break label638;
          }
          ((DiscussionInfo)localObject2).removeUIControlFlag_Hidden_RecentUser();
          if (QLog.isDevelopLevel()) {
            QLog.d("DiscussionHandler", 4, "不是单人多人聊天");
          }
        }
      }
    }
    Object localObject1 = paramFromServiceMsg.AddResult;
    Object localObject3 = new acdt.c();
    ((acdt.c)localObject3).uin = String.valueOf(paramFromServiceMsg.DiscussUin);
    ((acdt.c)localObject3).memberCount = ((Map)localObject1).size();
    localacdu.d((DiscussionInfo)localObject2);
    a((acdt.c)localObject3);
    localObject3 = ((Map)localObject1).keySet();
    localObject2 = new ArrayList();
    localObject3 = ((Set)localObject3).iterator();
    int i = 0;
    label508:
    DiscussionMemberInfo localDiscussionMemberInfo;
    if (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = (Long)((Iterator)localObject3).next();
      if (((Integer)((Map)localObject1).get(localObject4)).intValue() != 0) {
        break label713;
      }
      localDiscussionMemberInfo = new DiscussionMemberInfo();
      localDiscussionMemberInfo.discussionUin = String.valueOf(paramFromServiceMsg.DiscussUin);
      localDiscussionMemberInfo.memberUin = String.valueOf(localObject4);
      localDiscussionMemberInfo.flag = 0;
      localObject4 = paramObject.b(localDiscussionMemberInfo.memberUin);
      if ((localObject4 != null) && (((Friends)localObject4).isFriend()))
      {
        localDiscussionMemberInfo.memberName = ((Friends)localObject4).name;
        label619:
        ((List)localObject2).add(localDiscussionMemberInfo);
        i += 1;
      }
    }
    label713:
    for (;;)
    {
      break label508;
      label638:
      i += 1;
      break;
      this.d.DG(localDiscussionMemberInfo.memberUin);
      break label619;
      localacdu.iH((List)localObject2);
      arrayOfObject[0] = Long.valueOf(paramFromServiceMsg.DiscussUin);
      arrayOfObject[1] = paramToServiceMsg.extraData.getString("name");
      arrayOfObject[2] = Integer.valueOf(0);
      notifyUI(1002, true, arrayOfObject);
      return;
    }
  }
  
  protected void jdMethod_do(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleAddDiscussMemberResp");
    }
    paramObject = (anaf.a)paramObject;
    RespAddDiscussMember localRespAddDiscussMember = (RespAddDiscussMember)paramObject.eG;
    Object localObject1 = (DiscussRespHeader)paramObject.eF;
    Object localObject2 = String.valueOf(Long.valueOf(paramToServiceMsg.extraData.getLong("discussUin")));
    int i = ((DiscussRespHeader)localObject1).Result;
    paramToServiceMsg = ((DiscussRespHeader)localObject1).ResultDesc;
    if (((DiscussRespHeader)localObject1).Result != 0)
    {
      notifyUI(2000, true, new Object[] { localObject2, Integer.valueOf(i), paramToServiceMsg });
      return;
    }
    paramToServiceMsg = new Object[3];
    paramToServiceMsg[0] = localObject2;
    paramToServiceMsg[1] = Integer.valueOf(((DiscussRespHeader)localObject1).Result);
    if ((!paramFromServiceMsg.isSuccess()) || (!paramObject.cew))
    {
      paramToServiceMsg[2] = null;
      notifyUI(1003, false, paramToServiceMsg);
      return;
    }
    paramFromServiceMsg = (acff)this.app.getManager(51);
    localObject1 = (acdu)this.app.getManager(53);
    localObject2 = ((acdu)localObject1).a((String)localObject2);
    if (localObject2 == null)
    {
      paramToServiceMsg[0] = String.valueOf(localRespAddDiscussMember.DiscussUin);
      notifyUI(1003, false, paramToServiceMsg);
      return;
    }
    Object localObject3 = ((DiscussionInfo)localObject2).faceUinSet;
    int j = 0;
    i = j;
    if (localObject3 != null)
    {
      i = j;
      if (!((String)localObject3).trim().equals("")) {
        i = ((String)localObject3).split(";").length;
      }
    }
    Set localSet;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    StringBuffer localStringBuffer;
    Iterator localIterator;
    if (4 - i > 0)
    {
      i = 1;
      localObject3 = localRespAddDiscussMember.AddResult;
      localSet = ((Map)localObject3).keySet();
      localArrayList1 = new ArrayList(localSet.size());
      localArrayList2 = new ArrayList();
      localStringBuffer = new StringBuffer();
      localIterator = localSet.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label589;
      }
      Long localLong = (Long)localIterator.next();
      j = ((Integer)((Map)localObject3).get(localLong)).intValue();
      if (QLog.isColorLevel())
      {
        localStringBuffer.append("discussUin: " + localRespAddDiscussMember.DiscussUin + " memberUin: " + localLong.longValue() + " value: " + j);
        localStringBuffer.append("\n");
      }
      if (j != 0)
      {
        if (localSet.size() != 1) {
          continue;
        }
        IR(j);
        continue;
        i = 0;
        break;
      }
      DiscussionMemberInfo localDiscussionMemberInfo = new DiscussionMemberInfo();
      localDiscussionMemberInfo.discussionUin = String.valueOf(localRespAddDiscussMember.DiscussUin);
      localDiscussionMemberInfo.memberUin = String.valueOf(localLong);
      localDiscussionMemberInfo.flag = 0;
      Friends localFriends = paramFromServiceMsg.e(localLong + "");
      if ((localFriends != null) && (localFriends.name != null)) {
        localDiscussionMemberInfo.memberName = localFriends.name;
      }
      localArrayList1.add(String.valueOf(localLong));
      localArrayList2.add(localDiscussionMemberInfo);
    }
    label589:
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, localStringBuffer.toString());
    }
    a(localRespAddDiscussMember.DiscussUin, this.app.getCurrentAccountUin(), localArrayList1, 1);
    ((DiscussionInfo)localObject2).DiscussionFlag |= 0x20000000;
    ((acdu)localObject1).iH(localArrayList2);
    if (i != 0) {
      this.a.FR(((DiscussionInfo)localObject2).uin);
    }
    paramToServiceMsg[2] = paramObject.eG;
    notifyUI(1003, true, paramToServiceMsg);
  }
  
  void dq(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = 0L;
    Object localObject = null;
    int j = 0;
    if (paramToServiceMsg == null)
    {
      paramToServiceMsg = "" + "req为空, ";
      i = -1;
      paramFromServiceMsg = (FromServiceMsg)localObject;
    }
    for (;;)
    {
      if ((i == 0) && (!TextUtils.isEmpty(paramFromServiceMsg)))
      {
        paramObject = (acdu)this.app.getManager(53);
        localObject = paramObject.a(paramFromServiceMsg);
        if ((localObject != null) && (((DiscussionInfo)localObject).getHrExtra() != j))
        {
          ((DiscussionInfo)localObject).mOriginExtra &= 0xFFFFFFFC;
          ((DiscussionInfo)localObject).mOriginExtra |= j & 0x3;
          paramObject.d((DiscussionInfo)localObject);
          aqjl.a("handle_0x44c_rsp", this.app, (DiscussionInfo)localObject);
          aqjl.bh(this.app, paramFromServiceMsg);
        }
      }
      QLog.w("DiscussionHandler", 1, "handle_0x44c_rsp, debugSeq[" + l + "], strDiscUin[" + paramFromServiceMsg + "], discHrExtraValue[" + j + "], " + paramToServiceMsg);
      return;
      l = paramToServiceMsg.extraData.getLong("debugSeq");
      localObject = paramToServiceMsg.extraData.getString("uin");
      j = paramToServiceMsg.extraData.getInt("value");
      if (paramFromServiceMsg == null)
      {
        paramToServiceMsg = "" + "res为空, ";
        i = -1;
        paramFromServiceMsg = (FromServiceMsg)localObject;
      }
      else
      {
        paramToServiceMsg = "" + "isSuccess[" + paramFromServiceMsg.isSuccess() + "], reqAppSeq[" + paramToServiceMsg.getAppSeq() + "], reqSsoSeq[" + paramToServiceMsg.getRequestSsoSeq() + "], resAppSeq[" + paramFromServiceMsg.getAppSeq() + "], resSsoSeq[" + paramFromServiceMsg.getRequestSsoSeq() + "], ";
        if (paramObject == null)
        {
          paramToServiceMsg = paramToServiceMsg + "data为空, ";
          i = -1;
          paramFromServiceMsg = (FromServiceMsg)localObject;
        }
        else
        {
          paramObject = (cmd0x44c.RspBody)decodeOidb("DiscussionHandler", (byte[])paramObject, cmd0x44c.RspBody.class);
          if (paramObject != null) {
            break;
          }
          paramToServiceMsg = paramToServiceMsg + "rspBody为空, ";
          i = -1;
          paramFromServiceMsg = (FromServiceMsg)localObject;
        }
      }
    }
    int i = paramObject.uint32_code.get();
    paramFromServiceMsg = new StringBuilder().append(paramToServiceMsg).append("uint32_code[").append(i).append("], bytes_err_msg[");
    if (paramObject.bytes_err_msg.get() != null) {}
    for (paramToServiceMsg = paramObject.bytes_err_msg.get().toStringUtf8();; paramToServiceMsg = "null")
    {
      paramToServiceMsg = paramToServiceMsg + "]";
      paramFromServiceMsg = (FromServiceMsg)localObject;
      break;
    }
  }
  
  protected void dr(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = (ArrayList)paramToServiceMsg.extraData.getSerializable("discussUin");
    if (paramToServiceMsg != null)
    {
      i = paramToServiceMsg.size() * 2;
      paramFromServiceMsg = new ArrayList(i);
      if (paramToServiceMsg != null) {
        break label112;
      }
    }
    HashMap localHashMap;
    label112:
    for (int i = 0;; i = paramToServiceMsg.size())
    {
      localHashMap = new HashMap(i);
      a(paramToServiceMsg, paramFromServiceMsg, localHashMap);
      try
      {
        paramToServiceMsg = new acdt.a((byte[])paramObject, paramFromServiceMsg, localHashMap).a();
        boolean bool = paramToServiceMsg.ZS();
        if (!bool) {
          break label121;
        }
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        List localList;
        int k;
        acff localacff;
        if (!QLog.isColorLevel()) {
          break label546;
        }
        QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussInfoRespV2 excep", paramToServiceMsg);
        notifyUI(1001, false, paramFromServiceMsg);
        return;
        if (paramToServiceMsg.infoSeq != k) {
          break label610;
        }
        a(paramFromServiceMsg, i, str1, localList, l1, l2, m, str2, localacdu, paramToServiceMsg);
        if (!paramToServiceMsg.isDiscussHrMeeting()) {
          break label686;
        }
      }
      finally
      {
        String str1;
        cmd0x58b.ConfBaseInfo localConfBaseInfo;
        int j;
        int m;
        long l1;
        long l2;
        String str2;
        acdu localacdu;
        if (!ZR()) {
          break label646;
        }
        cIm();
      }
      i = 0;
      break;
    }
    label121:
    paramObject = paramToServiceMsg.dQ();
    i = 0;
    label129:
    if (i < paramObject.size())
    {
      paramToServiceMsg = (cmd0x58b.GetConfInfoRsp)paramObject.get(i);
      str1 = String.valueOf(paramToServiceMsg.uint64_conf_uin.get());
      localConfBaseInfo = (cmd0x58b.ConfBaseInfo)paramToServiceMsg.msg_conf_base_info.get();
      localList = paramToServiceMsg.rpt_msg_member_info.get();
      j = paramToServiceMsg.uint32_server_remark_timestamp.get();
      m = localConfBaseInfo.uint32_err_code.get();
      k = localConfBaseInfo.uint32_info_seq.get();
      l1 = localConfBaseInfo.uint32_conf_meeting_origin.get() & 0xFF;
      l2 = localConfBaseInfo.uint32_conf_meeting_option.get() & 0xFFFF;
      a(str1, localConfBaseInfo, j, m, k, l1, l2);
      if (m != 0)
      {
        if (m != 1) {
          break label686;
        }
        localHashMap.remove(str1);
        break label686;
      }
      localHashMap.remove(str1);
      m = localConfBaseInfo.uint32_flag.get();
      str2 = localConfBaseInfo.bytes_conf_name.get().toStringUtf8();
      localacff = (acff)this.app.getManager(51);
      localacdu = (acdu)this.app.getManager(53);
      paramToServiceMsg = localacdu.a(str1);
      if (paramToServiceMsg == null)
      {
        paramToServiceMsg = new DiscussionInfo();
        paramToServiceMsg.uin = str1;
        paramToServiceMsg.createTime = localConfBaseInfo.uint32_create_time.get();
        paramToServiceMsg.discussionName = str2;
        paramToServiceMsg.ownerUin = String.valueOf(localConfBaseInfo.uint64_owner_uin.get());
        paramToServiceMsg.inheritOwnerUin = String.valueOf(localConfBaseInfo.uint64_inherit_owner_uin.get());
        paramToServiceMsg.timeSec = j;
        paramToServiceMsg.groupCode = localConfBaseInfo.uint64_group_code.get();
        paramToServiceMsg.groupUin = localConfBaseInfo.uint64_group_uin.get();
        paramToServiceMsg.mOrigin = l1;
        paramToServiceMsg.mOriginExtra = l2;
        l1 = paramToServiceMsg.DiscussionFlag;
        paramToServiceMsg.DiscussionFlag = m;
        paramToServiceMsg.DiscussionFlag = (l1 & 0x20000000 | paramToServiceMsg.DiscussionFlag);
        a(str1, paramToServiceMsg);
      }
    }
    for (;;)
    {
      a(str1, localConfBaseInfo, localList, localacff, localacdu, paramToServiceMsg);
      paramFromServiceMsg.set(i * 2 + 1, Boolean.valueOf(true));
      break label686;
      label546:
      label610:
      notifyUI(1001, true, paramFromServiceMsg);
      label646:
      if (!ZR()) {
        break;
      }
      cIm();
      return;
      label686:
      i += 1;
      break label129;
    }
  }
  
  public void ds(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = System.currentTimeMillis();
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember req or res is null!");
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (paramFromServiceMsg.getResultCode() == 1002)
        {
          i = paramToServiceMsg.extraData.getInt("retryTime", 0);
          if (i < 1)
          {
            paramToServiceMsg.extraData.putInt("retryTime", i + 1);
            send(paramToServiceMsg);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember retry timeout!");
          }
        }
        else if (paramFromServiceMsg.getResultCode() != 1000)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember failCode:" + paramFromServiceMsg.getResultCode());
          }
        }
        else
        {
          paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
          try
          {
            paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
            if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null)) {
              break label243;
            }
            if (QLog.isColorLevel())
            {
              QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember ssoPkg invalid!");
              return;
            }
          }
          catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember merge ssopkg exception!");
    return;
    label243:
    k = 0;
    int i5 = 0;
    int i6 = 0;
    i = 0;
    int j = 0;
    int i7 = 0;
    int i4 = 0;
    paramObject = new oidb_0x751.RspBody();
    int m = i7;
    i1 = i6;
    int i3 = k;
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        m = i7;
        i1 = i6;
        i3 = k;
        k = paramObject.uint32_err_code.get();
        if (k != 0)
        {
          n = i4;
          i2 = i;
          m = i7;
          i1 = i6;
          i3 = k;
          if (QLog.isColorLevel())
          {
            m = i7;
            i1 = i6;
            i3 = k;
            QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember handle rspBody error! resultCode:" + k + " ,errMsg:" + paramObject.bytes_err_msg.get().toString());
            i2 = i;
            n = i4;
          }
          j = 0;
          i = k;
          i1 = i2;
          m = n;
          l = System.currentTimeMillis() - l;
          k = paramToServiceMsg.extraData.getInt("checkDiscCount");
          if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember end! resultCode:" + i + " ,totalCount:" + k + " ,validCount:" + i1 + " ,invalidCount:" + m + " ,cost:" + l);
          }
          paramToServiceMsg = new HashMap();
          paramToServiceMsg.put("pm_totalCount", String.valueOf(k));
          paramToServiceMsg.put("pm_validCount", String.valueOf(i1));
          paramToServiceMsg.put("pm_inValidCount", String.valueOf(m));
          paramToServiceMsg.put("pm_resultCode", String.valueOf(i));
          if (j != 0) {
            paramToServiceMsg.put("pm_exceptionHappen", "true");
          }
          anpc.a(BaseApplication.getContext()).collectPerformance(null, "checkIsDiscussionMember", true, l, 0L, paramToServiceMsg, null);
          return;
        }
        int n = i4;
        int i2 = i;
        m = i7;
        i1 = i6;
        i3 = k;
        if (!paramObject.msg_rsp_check_is_conf_member.has()) {
          continue;
        }
        m = i7;
        i1 = i6;
        i3 = k;
        paramFromServiceMsg = (oidb_0x751.RspCheckIsConfMember)paramObject.msg_rsp_check_is_conf_member.get();
        n = i4;
        i2 = i;
        m = i7;
        i1 = i6;
        i3 = k;
        if (!paramFromServiceMsg.msg_check_is_conf_member_result.has()) {
          continue;
        }
        m = i7;
        i1 = i6;
        i3 = k;
        paramFromServiceMsg = paramFromServiceMsg.msg_check_is_conf_member_result.get().iterator();
        i = i5;
        n = j;
        i2 = i;
        m = j;
        i1 = i;
        i3 = k;
        if (!paramFromServiceMsg.hasNext()) {
          continue;
        }
        m = j;
        i1 = i;
        i3 = k;
        paramObject = (oidb_0x751.CheckIsConfMemberResult)paramFromServiceMsg.next();
        m = j;
        i1 = i;
        i3 = k;
        str = String.valueOf(paramObject.uint64_conf_uin.get());
        m = j;
        i1 = i;
        i3 = k;
        n = paramObject.uint32_is_conf_member.get();
        if (n == 0) {
          m = j + 1;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        String str;
        i = i3;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember. Need to deleteDiscuss:" + str);
        }
        Dz(str);
        j = i;
        i = m;
        m = j;
        j = i;
        i = m;
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          i1 = i;
          i = k;
        }
      }
      m = i + 1;
      i = j;
      j = m;
      continue;
      QLog.i("DiscussionHandler", 1, "handleCheckIsDiscussionMember handle rspBody exception!", paramFromServiceMsg);
      j = 1;
    }
  }
  
  public void ds(String paramString, int paramInt)
  {
    if ((this.Pr > 0L) && (System.currentTimeMillis() - this.Pr < 120000L)) {
      return;
    }
    this.Pr = System.currentTimeMillis();
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqJoinDiscuss");
    localToServiceMsg.extraData.putString("signature", paramString);
    localToServiceMsg.extraData.putInt("addDisSource", paramInt);
    send(localToServiceMsg);
  }
  
  public boolean e(@NonNull ArrayList<DiscussionInfo> paramArrayList, @NonNull ArrayList<String> paramArrayList1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "addOrUpdateDiscussionWithCollectData" + paramArrayList.size() + ", " + paramArrayList1.size());
    }
    long l = System.currentTimeMillis();
    Object localObject2;
    Object localObject3;
    acdu localacdu;
    DiscussionInfo localDiscussionInfo;
    for (;;)
    {
      try
      {
        localObject2 = this.app.getPreferences();
        Object localObject1 = "DiscusstionIconVersion" + this.app.getCurrentAccountUin();
        int i = ((SharedPreferences)localObject2).getInt((String)localObject1, -1);
        if (i != 1)
        {
          localObject2 = ((SharedPreferences)localObject2).edit();
          ((SharedPreferences.Editor)localObject2).putInt((String)localObject1, 1);
          ((SharedPreferences.Editor)localObject2).commit();
          if (i != -1) {
            try
            {
              localObject1 = new String[2];
              localObject1[0] = acbn.bmD;
              localObject1[1] = "/data/data/com.tencent.tim/files/head/_hd/";
              int k = localObject1.length;
              i = 0;
              if (i < k)
              {
                localObject2 = new File(localObject1[i]);
                if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
                {
                  localObject2 = ((File)localObject2).listFiles();
                  int m = localObject2.length;
                  int j = 0;
                  if (j < m)
                  {
                    localObject3 = localObject2[j];
                    if (((File)localObject3).getName().startsWith("discussion_"))
                    {
                      ((File)localObject3).delete();
                      if (QLog.isColorLevel()) {
                        QLog.d("DiscussionHandler", 2, "del discussion icon. name=" + ((File)localObject3).getName() + "," + ((File)localObject3).lastModified());
                      }
                    }
                    j += 1;
                    continue;
                  }
                }
                i += 1;
                continue;
              }
              localacdu = (acdu)this.app.getManager(53);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
        localObject2 = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        if (!paramArrayList.hasNext()) {
          break label592;
        }
        localObject3 = (DiscussionInfo)paramArrayList.next();
        localDiscussionInfo = localacdu.a(((DiscussionInfo)localObject3).uin);
        if (localDiscussionInfo != null) {
          break;
        }
        localDiscussionInfo = new DiscussionInfo();
        localDiscussionInfo.uin = ((DiscussionInfo)localObject3).uin;
        localDiscussionInfo.infoSeq = -1L;
        localDiscussionInfo.timeSec = l;
        if (paramArrayList1.contains(((DiscussionInfo)localObject3).uin))
        {
          localDiscussionInfo.hasCollect = true;
          localObject3 = new acdt.c();
          ((acdt.c)localObject3).uin = localDiscussionInfo.uin;
          ((acdt.c)localObject3).memberCount = localDiscussionInfo.mUnreliableMemberCount;
          a((acdt.c)localObject3);
        }
        else
        {
          localDiscussionInfo.hasCollect = false;
        }
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
        return false;
      }
    }
    if (paramArrayList1.contains(((DiscussionInfo)localObject3).uin))
    {
      localDiscussionInfo.hasCollect = true;
      label513:
      if (localDiscussionInfo.infoSeq == ((DiscussionInfo)localObject3).infoSeq) {
        break label581;
      }
      localObject3 = new acdt.c();
      ((acdt.c)localObject3).uin = localDiscussionInfo.uin;
      ((acdt.c)localObject3).memberCount = localDiscussionInfo.mUnreliableMemberCount;
      a((acdt.c)localObject3);
    }
    for (;;)
    {
      localDiscussionInfo.timeSec = l;
      break;
      localDiscussionInfo.hasCollect = false;
      break label513;
      label581:
      ((ArrayList)localObject2).add(localDiscussionInfo);
    }
    label592:
    boolean bool = localacdu.a((ArrayList)localObject2, l, false);
    return bool;
  }
  
  public void eE(String paramString1, String paramString2)
  {
    acdu localacdu = (acdu)this.app.getManager(53);
    DiscussionInfo localDiscussionInfo = localacdu.a(paramString1);
    if (localDiscussionInfo != null)
    {
      localDiscussionInfo.discussionName = paramString2;
      localDiscussionInfo.DiscussionFlag &= 0xFFFFFFBF;
      localacdu.d(localDiscussionInfo);
      notifyUI(1005, true, paramString1);
    }
  }
  
  public void eF(String paramString1, String paramString2)
  {
    cmd0x921.ReqBody localReqBody = new cmd0x921.ReqBody();
    localReqBody.uint32_subcmd.set(1);
    try
    {
      cmd0x921.GetAtAllRemain localGetAtAllRemain = new cmd0x921.GetAtAllRemain();
      localGetAtAllRemain.uint64_uin.set(Long.parseLong(paramString1));
      localGetAtAllRemain.uint64_discuss_uin.set(Long.parseLong(paramString2));
      localReqBody.msg_get_at_all_remain.set(localGetAtAllRemain);
      paramString1 = makeOIDBPkg("OidbSvc.0x921_0", 2337, 0, localReqBody.toByteArray());
      paramString1.extraData.putString("discUid", paramString2);
      sendPbReq(paramString1);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("DiscussionHandler", 2, "getAnonymousChatNick error, NumberFormatException, uin : " + paramString1 + ", discUin : " + paramString2);
    }
  }
  
  public Bitmap f(String paramString, boolean paramBoolean)
  {
    Bitmap localBitmap;
    if ((paramString != null) || (paramBoolean))
    {
      try
      {
        return aqhu.aN();
      }
      catch (Throwable paramString)
      {
        if (!QLog.isColorLevel()) {
          break label108;
        }
        QLog.e("DiscussionHandler", 2, "getDiscussionFaceIcon error", paramString);
        return null;
        label103:
        localBitmap = null;
      }
      if (GroupIconHelper.kH(paramString)) {}
      for (localBitmap = this.app.getFaceBitmap(1001, paramString, (byte)1, false, (byte)1, 0); localBitmap == null; localBitmap = this.app.getFaceBitmap(101, paramString, (byte)1, false, (byte)1, 0))
      {
        bA(paramString, true);
        if (!paramBoolean) {
          break label103;
        }
        return aqhu.aN();
      }
      bA(paramString, false);
    }
    else
    {
      label108:
      return null;
    }
    return localBitmap;
  }
  
  public void g(@NonNull Collection<acdt.c> paramCollection)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "getDiscussInfo" + paramCollection.size());
    }
    for (;;)
    {
      acdt.c localc;
      synchronized (this.L)
      {
        paramCollection = paramCollection.iterator();
        if (!paramCollection.hasNext()) {
          break;
        }
        localc = (acdt.c)paramCollection.next();
        if ((!this.L.containsKey(localc.uin)) && (!this.K.containsKey(localc.uin)) && (localc.retryCount <= 1)) {
          this.L.put(localc.uin, localc);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "getDiscussionInfo2 filtered " + localc.uin);
      }
    }
    cIm();
  }
  
  public void hk(long paramLong)
  {
    if (!bE(paramLong))
    {
      localObject = new ArrayList(2);
      ((ArrayList)localObject).add(Long.valueOf(paramLong));
      ((ArrayList)localObject).add(Boolean.valueOf(false));
      notifyUI(1001, false, localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "getDiscussInfo " + paramLong);
    }
    Object localObject = (acdu)this.app.getManager(53);
    acdt.c localc = new acdt.c();
    localc.uin = String.valueOf(paramLong);
    localc.memberCount = ((acdu)localObject).cn(localc.uin);
    a(localc);
  }
  
  public void hl(long paramLong)
  {
    if (((acdu)this.app.getManager(53)).a(paramLong + "") == null) {
      hk(paramLong);
    }
  }
  
  public void hm(long paramLong)
  {
    if (bE(paramLong))
    {
      ToServiceMsg localToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqQuitDiscuss");
      localToServiceMsg.extraData.putLong("discussUin", paramLong);
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "--->>quit discuss uin: " + paramLong);
      }
      send(localToServiceMsg);
      return;
    }
    notifyUI(1004, false, String.valueOf(paramLong));
  }
  
  public void hn(long paramLong)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2160);
    localOIDBSSOPkg.uint32_service_type.set(4);
    Object localObject = ByteBuffer.allocate(20);
    ((ByteBuffer)localObject).putInt(aqft.ag(paramLong)).putInt(0).putShort((short)4).putInt(aqft.ag(paramLong));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x870_4");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("dwConfUin", paramLong);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void ho(long paramLong)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2160);
    localOIDBSSOPkg.uint32_service_type.set(5);
    Object localObject = ByteBuffer.allocate(20);
    ((ByteBuffer)localObject).putInt(aqft.ag(paramLong)).putInt(0).putShort((short)4).putInt(aqft.ag(paramLong));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x870_5");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("dwConfUin", paramLong);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void hp(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "getDiscuss" + paramLong);
    }
    cmd0x58a.ReqBody localReqBody = new cmd0x58a.ReqBody();
    localReqBody.uint32_subcmd.set(1);
    sendPbReq(makeOIDBPkg("OidbSvc.0x58a", 1418, 0, localReqBody.toByteArray()));
  }
  
  public void i(long paramLong, ArrayList<AddDiscussMemberInfo> paramArrayList)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqAddDiscussMember");
    localToServiceMsg.extraData.putLong("discussUin", paramLong);
    int j = paramArrayList.size();
    long[] arrayOfLong1 = new long[j];
    int[] arrayOfInt = new int[j];
    long[] arrayOfLong2 = new long[j];
    String[] arrayOfString = new String[j];
    int i = 0;
    while (i < j)
    {
      arrayOfLong1[i] = ((AddDiscussMemberInfo)paramArrayList.get(i)).Uin;
      arrayOfInt[i] = ((AddDiscussMemberInfo)paramArrayList.get(i)).Type;
      arrayOfLong2[i] = ((AddDiscussMemberInfo)paramArrayList.get(i)).RefUin;
      arrayOfString[i] = ((AddDiscussMemberInfo)paramArrayList.get(i)).RefStr;
      i += 1;
    }
    localToServiceMsg.extraData.putLongArray("uin", arrayOfLong1);
    localToServiceMsg.extraData.putIntArray("type", arrayOfInt);
    localToServiceMsg.extraData.putLongArray("refUin", arrayOfLong2);
    localToServiceMsg.extraData.putStringArray("refStr", arrayOfString);
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "--->>add discuss member uin: " + paramLong + " req: " + localToServiceMsg);
    }
    send(localToServiceMsg);
  }
  
  public void j(long paramLong, ArrayList<AddDiscussMemberInfo> paramArrayList)
  {
    if (bE(paramLong))
    {
      DiscussionInfo localDiscussionInfo = ((acdu)this.app.getManager(53)).a(String.valueOf(paramLong));
      if ((localDiscussionInfo != null) && (localDiscussionInfo.isDiscussHrMeeting()))
      {
        k(paramLong, paramArrayList);
        return;
      }
      i(paramLong, paramArrayList);
      return;
    }
    notifyUI(1003, false, new Object[] { String.valueOf(paramLong), Integer.valueOf(-1) });
  }
  
  void k(long paramLong, ArrayList<AddDiscussMemberInfo> paramArrayList)
  {
    ThreadManager.post(new DiscussionHandler.2(this, paramLong, paramArrayList), 5, null, false);
  }
  
  public void k(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    notifyUI(1007, paramBoolean1, Pair.create(Boolean.valueOf(paramBoolean2), paramString));
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("QQServiceDiscussSvc.ReqAddDiscussMember");
      this.allowCmdSet.add("QQServiceDiscussSvc.ReqChangeDiscussName");
      this.allowCmdSet.add("QQServiceDiscussSvc.ReqCreateDiscuss");
      this.allowCmdSet.add("OidbSvc.0x58a");
      this.allowCmdSet.add("QQServiceDiscussSvc.ReqGetDiscussInfo");
      this.allowCmdSet.add("QQServiceDiscussSvc.ReqQuitDiscuss");
      this.allowCmdSet.add("QQServiceDiscussSvc.ReqSetDiscussAttr");
      this.allowCmdSet.add("QQServiceDiscussSvc.ReqSetDiscussFlag");
      this.allowCmdSet.add("QQServiceDiscussSvc.ReqGetDiscussInteRemark");
      this.allowCmdSet.add("QRCodeSvc.discuss_geturl");
      this.allowCmdSet.add("QRCodeSvc.discuss_decode");
      this.allowCmdSet.add("QQServiceDiscussSvc.ReqJoinDiscuss");
      this.allowCmdSet.add("OidbSvc.0x865_3");
      this.allowCmdSet.add("OidbSvc.0x870_4");
      this.allowCmdSet.add("OidbSvc.0x870_5");
      this.allowCmdSet.add("OidbSvc.0x921_0");
      this.allowCmdSet.add("OidbSvc.0x58b_0");
      this.allowCmdSet.add("OidbSvc.0x751");
      this.allowCmdSet.add("OidbSvc.0x44c");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return acdv.class;
  }
  
  public void onDestroy()
  {
    if (this.a != null) {
      this.a.release();
    }
    super.onDestroy();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "cmdfilter error=" + str);
      }
    }
    do
    {
      do
      {
        return;
        if (paramFromServiceMsg.getResultCode() == 1002)
        {
          v(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (paramFromServiceMsg.getResultCode() != 1000)
        {
          n(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(str))
        {
          jdMethod_do(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("QQServiceDiscussSvc.ReqChangeDiscussName".equalsIgnoreCase(str))
        {
          dm(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("QQServiceDiscussSvc.ReqCreateDiscuss".equalsIgnoreCase(str))
        {
          dn(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x58a".equalsIgnoreCase(str))
        {
          dl(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (!"QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(str)) {
          break;
        }
      } while (paramToServiceMsg.extraData.getString("signature") == null);
      dg(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
      if ("QQServiceDiscussSvc.ReqQuitDiscuss".equalsIgnoreCase(str))
      {
        dk(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussAttr".equalsIgnoreCase(str))
      {
        dj(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussFlag".equalsIgnoreCase(str))
      {
        di(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqGetDiscussInteRemark".equalsIgnoreCase(str))
      {
        dp(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QRCodeSvc.discuss_geturl".equalsIgnoreCase(str))
      {
        de(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QRCodeSvc.discuss_decode".equalsIgnoreCase(str))
      {
        df(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqJoinDiscuss".equalsIgnoreCase(str))
      {
        dh(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x865_3".equalsIgnoreCase(str))
      {
        db(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x870_4".equalsIgnoreCase(str))
      {
        dc(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x870_5".equalsIgnoreCase(str))
      {
        dd(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x921_0".equalsIgnoreCase(str))
      {
        da(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x58b_0".equalsIgnoreCase(str))
      {
        dr(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x751".equalsIgnoreCase(str))
      {
        ds(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x44c".equalsIgnoreCase(str));
    dq(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public Bitmap w(String paramString)
  {
    int j = 4;
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    float f = this.app.getApp().getResources().getDisplayMetrics().density;
    int m = (int)(50.0F * f + 0.5D);
    paramString = paramString.split(";");
    int i;
    if (paramString.length <= 1)
    {
      i = (int)(f * 117.0F);
      if (paramString.length <= 4) {
        break label150;
      }
    }
    Bitmap[] arrayOfBitmap;
    for (;;)
    {
      arrayOfBitmap = new Bitmap[j];
      int k = 0;
      while (k < j)
      {
        arrayOfBitmap[k] = ((Bitmap)this.app.a(paramString[k], 1, i, i).second);
        k += 1;
      }
      if (paramString.length <= 4)
      {
        i = (int)(f * 53.0F);
        break;
      }
      i = (int)(f * 34.0F);
      break;
      label150:
      j = paramString.length;
    }
    try
    {
      paramString = this.a.a(m, arrayOfBitmap);
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  class a
  {
    private byte[] data;
    private boolean failed;
    private HashMap<String, acdt.c> iL;
    private ArrayList<Object> sY;
    private List<cmd0x58b.GetConfInfoRsp> xq;
    
    public a(ArrayList<Object> paramArrayList, HashMap<String, acdt.c> paramHashMap)
    {
      this.data = paramArrayList;
      this.sY = paramHashMap;
      Object localObject;
      this.iL = localObject;
    }
    
    boolean ZS()
    {
      return this.failed;
    }
    
    public a a()
    {
      List localList = null;
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      try
      {
        localOIDBSSOPkg = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom(this.data);
        if ((!localOIDBSSOPkg.uint32_result.has()) || (localOIDBSSOPkg.uint32_result.get() != 0) || (!localOIDBSSOPkg.bytes_bodybuffer.has()) || (localOIDBSSOPkg.bytes_bodybuffer.get() == null))
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.contacttab.dscs", 2, "sso check fail " + localOIDBSSOPkg.uint32_result.get());
          }
          acdt.this.notifyUI(1001, false, this.sY);
          this.failed = true;
          return this;
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.contacttab.dscs", 2, "merge fail " + localInvalidProtocolBufferMicroException1.toString());
        }
        acdt.this.notifyUI(1001, false, this.sY);
        this.failed = true;
        return this;
      }
      cmd0x58b.RspBody localRspBody = new cmd0x58b.RspBody();
      try
      {
        localRspBody.mergeFrom(localInvalidProtocolBufferMicroException1.bytes_bodybuffer.get().toByteArray());
        if (localRspBody.msg_cmd_error_code.uint32_code.get() != 0)
        {
          acdt.this.g(this.iL.values());
          acdt.this.notifyUI(1001, false, this.sY);
          this.failed = true;
          return this;
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.contacttab.dscs", 2, "rspBody merge fail " + localInvalidProtocolBufferMicroException2.toString());
        }
        acdt.this.notifyUI(1001, false, this.sY);
        this.failed = true;
        return this;
      }
      if (localRspBody.msg_get_multi_conf_info.has()) {}
      for (cmd0x58b.GetMultiConfInfoRsp localGetMultiConfInfoRsp = (cmd0x58b.GetMultiConfInfoRsp)localRspBody.msg_get_multi_conf_info.get();; localGetMultiConfInfoRsp = null)
      {
        if (localGetMultiConfInfoRsp.msg_get_conf_info.has()) {
          localList = localGetMultiConfInfoRsp.msg_get_conf_info.get();
        }
        this.xq = localList;
        this.failed = false;
        return this;
      }
    }
    
    public List<cmd0x58b.GetConfInfoRsp> dQ()
    {
      return this.xq;
    }
  }
  
  class b
  {
    private oidb_sso.OIDBSSOPkg a;
    private boolean bwj;
    private List<cmd0x58a.ConfBaseInfo> xr;
    private List<Long> xs;
    
    public b(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
    {
      this.a = paramOIDBSSOPkg;
    }
    
    boolean WE()
    {
      return this.bwj;
    }
    
    public b a()
    {
      if ((this.a == null) || (!this.a.uint32_result.has()) || (this.a.uint32_result.get() != 0) || (!this.a.bytes_bodybuffer.has()) || (this.a.bytes_bodybuffer.get() == null))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.contacttab.dscs", 2, "sso check fail " + this.a.uint32_result.get());
        }
        acdt.this.notifyUI(1000, false, null);
        this.bwj = true;
        return this;
      }
      for (Object localObject = new cmd0x58a.RspBody();; localList1 = null) {
        try
        {
          ((cmd0x58a.RspBody)localObject).mergeFrom(this.a.bytes_bodybuffer.get().toByteArray());
          if (((cmd0x58a.RspBody)localObject).msg_get_conf_list.has())
          {
            localObject = (cmd0x58a.GetConfListRsp)((cmd0x58a.RspBody)localObject).msg_get_conf_list.get();
            if (localObject != null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.e("Q.contacttab.dscs", 2, "getConfInfoRsp is null");
            }
            acdt.this.notifyUI(1000, true, null);
            this.bwj = true;
            return this;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.contacttab.dscs", 2, "rspBody merge fail " + localInvalidProtocolBufferMicroException.toString());
          }
          acdt.this.notifyUI(1000, false, null);
          this.bwj = true;
          return this;
        }
      }
      List localList2;
      if (localList1.rpt_msg_conf_base_info.has())
      {
        localList2 = localList1.rpt_msg_conf_base_info.get();
        this.xr = localList2;
        if (!localList1.rpt_uint64_other_conf_list.has()) {
          break label352;
        }
      }
      label352:
      for (List localList1 = localList1.rpt_uint64_other_conf_list.get();; localList1 = null)
      {
        this.xs = localList1;
        if (this.xr != null) {
          break label357;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.contacttab.dscs", 2, "baseInfo is null");
        }
        acdt.this.notifyUI(1000, false, null);
        this.bwj = true;
        return this;
        localList2 = null;
        break;
      }
      label357:
      this.bwj = false;
      return this;
    }
    
    public List<cmd0x58a.ConfBaseInfo> dR()
    {
      return this.xr;
    }
    
    public List<Long> dS()
    {
      return this.xs;
    }
  }
  
  public static class c
  {
    public int memberCount = 100;
    public int retryCount;
    public String uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acdt
 * JD-Core Version:    0.7.0.1
 */