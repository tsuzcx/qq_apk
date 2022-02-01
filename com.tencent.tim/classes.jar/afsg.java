import QC.ExtendFriend;
import QC.UniBusinessItem;
import QC.UniSetExtFriendReq;
import QC.UniSetExtFriendRsp;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageForLimitChatConfirm;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.GPS;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.LBSInfo;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.ReqBody;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.RspBody;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.StrangerInfo;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.labelInfo;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.schoolInfo;
import com.tencent.pb.extendfriend.GetExtendFriendInfo.ReqBody;
import com.tencent.pb.extendfriend.GetExtendFriendInfo.RspBody;
import com.tencent.pb.extendfriend.GetExtendFriendInfo.labelInfo;
import com.tencent.pb.extendfriend.GetExtendFriendInfo.schoolInfo;
import com.tencent.pb.personal.PersonalInfo.ReqBody;
import com.tencent.pb.profilecard.EditExtendFriendInfo.ReqBody;
import com.tencent.pb.profilecard.EditExtendFriendInfo.RspBody;
import com.tencent.pb.profilecard.EditExtendFriendInfo.SchoolInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import tencent.im.oidb.cmd0xcb5.cmd0xcb5.ReqBody;
import tencent.im.oidb.cmd0xcb5.cmd0xcb5.RspBody;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.GPS;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.LBSInfo;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.ReqBody;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.RspBody;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.GPS;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.LBSInfo;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.MatchInfo;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.MatchUinData;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.ProfileTagInfo;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.ReqBody;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.RspBody;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.TagInfo;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.schoolInfo;
import tencent.im.oidb.cmd0xe09.oidb_0xe09.OnlineInfo;
import tencent.im.oidb.cmd0xe09.oidb_0xe09.ReqBody;
import tencent.im.oidb.cmd0xe09.oidb_0xe09.RspBody;
import tencent.im.oidb.cmd0xe09.oidb_0xe09.reqItem;
import tencent.im.oidb.cmd0xe52.oidb_0xe52.RspBody;
import tencent.im.oidb.cmd0xe67.oidb_0xe67.GPS;
import tencent.im.oidb.cmd0xe67.oidb_0xe67.LBSInfo;
import tencent.im.oidb.cmd0xe67.oidb_0xe67.ReqBody;
import tencent.im.oidb.cmd0xe67.oidb_0xe67.RspBody;
import tencent.im.oidb.oidb_0xe51.ReqBody;
import tencent.im.oidb.oidb_0xe51.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x128.submsgtype0x128.MsgBody;

public class afsg
  extends accg
{
  public static AtomicInteger bm = new AtomicInteger(0);
  public final String bFc = "request_from_login";
  
  public afsg(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private Card a(String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("ExtendFriendHandler", 1, "saveExtendFriendInfo uin is null");
      return null;
    }
    acff localacff = (acff)this.app.getManager(51);
    Card localCard = localacff.c(paramString1);
    localCard.declaration = paramString2;
    localCard.voiceUrl = paramString3;
    if (paramInt1 != 0) {
      localCard.popularity = paramInt1;
    }
    localCard.updateTime = paramLong;
    localCard.extendFriendVoiceDuration = paramInt2;
    localacff.a(localCard);
    QLog.e("ExtendFriendHandler", 1, new Object[] { "saveExtendFriendInfo uin=%s declaration=%s voiceUrl=%s popularity=%d updateTime=%ld extendFriendVoiceDuration=%d", paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    return localCard;
  }
  
  private Card a(String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString4, String paramString5, long paramLong2, int paramInt6, int paramInt7)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("ExtendFriendHandler", 1, "saveExtendFriendInfo uin is null");
      return null;
    }
    acff localacff = (acff)this.app.getManager(51);
    Card localCard = localacff.c(paramString1);
    localCard.declaration = paramString2;
    localCard.voiceUrl = paramString3;
    localCard.fontId = paramInt3;
    localCard.fontType = paramInt4;
    localCard.clothesId = paramInt5;
    if (paramInt1 != 0) {
      localCard.popularity = paramInt1;
    }
    localCard.updateTime = paramLong1;
    localCard.extendFriendVoiceDuration = paramInt2;
    if ((TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString5)))
    {
      localCard.schoolName = "";
      localCard.schoolId = "";
      localCard.authState = -1L;
      localCard.idx = -1;
    }
    for (localCard.category = -1;; localCard.category = paramInt7)
    {
      localacff.a(localCard);
      QLog.e("ExtendFriendHandler", 1, new Object[] { "saveExtendFriendInfo uin=%s declaration=%s voiceUrl=%s popularity=%d updateTime=%ld extendFriendVoiceDuration=%d schoolId=%s schoolName=%s authState=%d idx=%d category=%d", paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), paramString4, paramString5, Long.valueOf(paramLong2), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7) });
      return localCard;
      localCard.schoolName = paramString5;
      localCard.schoolId = paramString4;
      localCard.authState = paramLong2;
      localCard.idx = paramInt6;
    }
  }
  
  private void a(List<Long> paramList1, int paramInt1, int paramInt2, List<Long> paramList2)
  {
    int i;
    if (paramList1 == null)
    {
      i = 0;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendHandler", 2, String.format("getExtendFriendOnlineState reqListSize=%s startIndex=%s count=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
    }
    for (;;)
    {
      anaz localanaz;
      Object localObject1;
      try
      {
        if (this.app == null) {
          break label380;
        }
        localanaz = this.app.a();
        localObject1 = this.app.getCurrentUin();
      }
      catch (Exception paramList1)
      {
        Iterator localIterator;
        Object localObject3;
        Object localObject2;
        QLog.e("ExtendFriendHandler", 1, "getExtendFriendOnlineState fail.", paramList1);
        return;
      }
      QLog.e("ExtendFriendHandler", 1, "getExtendFriendOnlineState invalid param.");
      return;
      i = paramList1.size();
      break;
      paramInt2 = Math.min(i - paramInt1, paramInt2);
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendHandler", 2, String.format("getExtendFriendOnlineState fixed count=%s", new Object[] { Integer.valueOf(paramInt2) }));
      }
      oidb_0xe09.ReqBody localReqBody = new oidb_0xe09.ReqBody();
      localIterator = paramList1.subList(paramInt1, paramInt1 + paramInt2).iterator();
      if (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        localObject3 = localanaz.e(String.valueOf(localLong), (String)localObject1);
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = localanaz.a(String.valueOf(localLong), (String)localObject1, false);
        }
        if (localObject2 != null)
        {
          localObject3 = new oidb_0xe09.reqItem();
          ((oidb_0xe09.reqItem)localObject3).uint64_uin.set(localLong.longValue());
          ((oidb_0xe09.reqItem)localObject3).bytes_sig.set(ByteStringMicro.copyFrom((byte[])localObject2));
          localReqBody.rpt_item.add((MessageMicro)localObject3);
        }
        else
        {
          QLog.w("ExtendFriendHandler", 1, String.format("getExtendFriendOnlineState get match chat sig fail. uin=%s", new Object[] { localLong }));
        }
      }
      else
      {
        localObject1 = makeOIDBPkg("OidbSvc.0xe09", 3593, 1, localReqBody.toByteArray());
        ((ToServiceMsg)localObject1).addAttribute("reqList", paramList1);
        ((ToServiceMsg)localObject1).addAttribute("startIndex", Integer.valueOf(paramInt1));
        ((ToServiceMsg)localObject1).addAttribute("count", Integer.valueOf(paramInt2));
        ((ToServiceMsg)localObject1).addAttribute("resultList", paramList2);
        sendPbReq((ToServiceMsg)localObject1);
        return;
        label380:
        localanaz = null;
        localObject1 = null;
        if ((i != 0) && (paramInt1 < i) && (paramInt2 > 0)) {
          if (localanaz != null) {}
        }
      }
    }
  }
  
  private void a(oidb_0xe03.MatchUinData paramMatchUinData, afsy paramafsy)
  {
    int j = -1;
    int k = 0;
    if ((paramMatchUinData == null) || (paramafsy == null))
    {
      QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "msg_match_uin_data || info is null. ");
      return;
    }
    label90:
    label118:
    int i;
    if (paramMatchUinData.uint32_age.has())
    {
      localObject1 = paramMatchUinData.uint32_age.get() + "";
      paramafsy.bFu = ((String)localObject1);
      if (!paramMatchUinData.bytes_constellation.has()) {
        break label516;
      }
      localObject1 = paramMatchUinData.bytes_constellation.get().toStringUtf8();
      paramafsy.constellation = ((String)localObject1);
      if (!paramMatchUinData.bytes_city.has()) {
        break label523;
      }
      localObject1 = paramMatchUinData.bytes_city.get().toStringUtf8();
      paramafsy.city = ((String)localObject1);
      if (!paramMatchUinData.bytes_school.has()) {
        break label530;
      }
      localObject1 = paramMatchUinData.bytes_school.get().toStringUtf8();
      label146:
      paramafsy.bFv = ((String)localObject1);
      if (!paramMatchUinData.bytes_company.has()) {
        break label537;
      }
      localObject1 = paramMatchUinData.bytes_company.get().toStringUtf8();
      label174:
      paramafsy.company = ((String)localObject1);
      if (!paramMatchUinData.bytes_declaration.has()) {
        break label544;
      }
      localObject1 = paramMatchUinData.bytes_declaration.get().toStringUtf8();
      label202:
      paramafsy.mDeclaration = ((String)localObject1);
      if (!paramMatchUinData.bytes_voice_url.has()) {
        break label551;
      }
      localObject1 = paramMatchUinData.bytes_voice_url.get().toStringUtf8();
      label230:
      paramafsy.mVoiceUrl = ((String)localObject1);
      if (!paramMatchUinData.uint32_voice_duration.has()) {
        break label558;
      }
      i = paramMatchUinData.uint32_voice_duration.get();
      label254:
      paramafsy.mVoiceDuration = i;
      if (!paramMatchUinData.bytes_long_nick.has()) {
        break label563;
      }
      localObject1 = paramMatchUinData.bytes_long_nick.get().toByteArray();
      label281:
      if (localObject1 != null) {
        paramafsy.bFw = RichStatus.parseStatus((byte[])localObject1).getPlainText();
      }
      if (!paramMatchUinData.uint32_sex.has()) {
        break label569;
      }
      paramafsy.mGender = paramMatchUinData.uint32_sex.get();
      label319:
      if (!paramMatchUinData.uint32_popularity.has()) {
        break label587;
      }
    }
    Object localObject2;
    label516:
    label523:
    label530:
    label537:
    label544:
    label551:
    label558:
    label563:
    label569:
    label587:
    for (long l = paramMatchUinData.uint32_popularity.get();; l = 0L)
    {
      paramafsy.XK = l;
      localObject1 = new ArrayList();
      if (!paramMatchUinData.rpt_school_info.has()) {
        break label593;
      }
      i = 0;
      while (i < paramMatchUinData.rpt_school_info.size())
      {
        if (((oidb_0xe03.schoolInfo)paramMatchUinData.rpt_school_info.get(i)).str_school_name.has())
        {
          localObject2 = new aftz(((oidb_0xe03.schoolInfo)paramMatchUinData.rpt_school_info.get(i)).str_school_id.get(), ((oidb_0xe03.schoolInfo)paramMatchUinData.rpt_school_info.get(i)).str_school_name.get(), ((oidb_0xe03.schoolInfo)paramMatchUinData.rpt_school_info.get(i)).uint64_state.get());
          ((ArrayList)localObject1).add(localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "schoolInfo. " + ((aftz)localObject2).toString());
          }
        }
        i += 1;
      }
      localObject1 = "";
      break;
      localObject1 = "";
      break label90;
      localObject1 = "";
      break label118;
      localObject1 = "";
      break label146;
      localObject1 = "";
      break label174;
      localObject1 = "";
      break label202;
      localObject1 = "";
      break label230;
      i = 0;
      break label254;
      localObject1 = null;
      break label281;
      paramafsy.mGender = 0;
      QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "mGender  is null. set 0  ");
      break label319;
    }
    label593:
    paramafsy.ws = ((ArrayList)localObject1);
    Object localObject1 = new ArrayList();
    if (paramMatchUinData.rpt_tag.has())
    {
      i = k;
      while (i < paramMatchUinData.rpt_tag.size())
      {
        if (((oidb_0xe03.ProfileTagInfo)paramMatchUinData.rpt_tag.get(i)).bytes_tag.has())
        {
          k = ((oidb_0xe03.ProfileTagInfo)paramMatchUinData.rpt_tag.get(i)).uint32_same_flag.get();
          localObject2 = ((oidb_0xe03.ProfileTagInfo)paramMatchUinData.rpt_tag.get(i)).bytes_tag.get().toStringUtf8();
          afty localafty = new afty();
          localafty.cUr = k;
          localafty.tagName = ((String)localObject2);
          ((ArrayList)localObject1).add(localafty);
        }
        i += 1;
      }
    }
    paramafsy.wr = ((ArrayList)localObject1);
    if (paramMatchUinData.uint32_distance.has())
    {
      i = paramMatchUinData.uint32_distance.get();
      label755:
      paramafsy.distance = i;
      i = j;
      if (paramMatchUinData.uint32_match_pool.has()) {
        i = paramMatchUinData.uint32_match_pool.get();
      }
      paramafsy.cUg = i;
      if (!paramMatchUinData.str_from_city_name.has()) {
        break label876;
      }
      localObject1 = paramMatchUinData.str_from_city_name.get();
      label805:
      paramafsy.bFx = ((String)localObject1);
      if (!paramMatchUinData.str_to_city_name.has()) {
        break label883;
      }
    }
    label876:
    label883:
    for (paramMatchUinData = paramMatchUinData.str_to_city_name.get();; paramMatchUinData = "")
    {
      paramafsy.bFy = paramMatchUinData;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "ChatFriendInfo. " + paramafsy.toString());
      return;
      i = -1;
      break label755;
      localObject1 = "";
      break label805;
    }
  }
  
  private long e(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "unknown";
    }
    try
    {
      long l = Long.parseLong(paramString1);
      return l;
    }
    catch (NumberFormatException paramString1)
    {
      QLog.e("ExtendFriendHandler", 2, str + " parse err " + paramString1.toString());
    }
    return 0L;
  }
  
  private int hs(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e("ExtendFriendHandler", 2, "un known op type" + paramInt);
    case 1: 
      return 11;
    case 2: 
      return 12;
    case 3: 
      return 13;
    case 4: 
      return 14;
    case 5: 
      return 15;
    case 6: 
      return 24;
    }
    return 25;
  }
  
  private void jo(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, new EditExtendFriendInfo.RspBody());
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, "handleUpdateExtendFriendCampusSchoolInfo,result = " + i);
    }
    if (i == 0)
    {
      paramFromServiceMsg = (afsi)this.mApp.getManager(264);
      if (paramFromServiceMsg != null)
      {
        i = paramToServiceMsg.extraData.getInt("idx", 0);
        paramObject = paramToServiceMsg.extraData.getString("school_name", "");
        String str = paramToServiceMsg.extraData.getString("school_id", "");
        int j = paramToServiceMsg.extraData.getInt("school_category", 0);
        paramFromServiceMsg.hS(paramToServiceMsg.extraData.getInt("school_certi_status", 0), 1);
        paramFromServiceMsg.h(i, paramObject, str, j);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      notifyUI(22, bool, null);
      return;
    }
  }
  
  private void jp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_0xe52.RspBody());
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, "handleCertificateConfirmSchool,result = " + i);
    }
    if (i == 0) {}
  }
  
  private void jq(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0xdb1.RspBody localRspBody = new oidb_0xdb1.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, new Object[] { "handleGetCampusCertificateStatusResponse. result = ", Integer.valueOf(i) });
    }
    if (i == 0)
    {
      paramObject = (afsi)this.mApp.getManager(264);
      if (paramObject != null) {
        paramObject.a(paramToServiceMsg, paramFromServiceMsg, localRspBody);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      notifyUI(20, bool, new Object[] { Integer.valueOf(1) });
      return;
    }
  }
  
  private void jt(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      Object localObject = new oidb_0xe09.RspBody();
      i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      if (i != 0) {
        break label266;
      }
      paramFromServiceMsg = new ArrayList();
      try
      {
        if (!((oidb_0xe09.RspBody)localObject).rpt_online_info.has()) {
          break label231;
        }
        paramObject = ((oidb_0xe09.RspBody)localObject).rpt_online_info.get().iterator();
        while (paramObject.hasNext())
        {
          localObject = (oidb_0xe09.OnlineInfo)paramObject.next();
          if (((oidb_0xe09.OnlineInfo)localObject).uint64_friend_uin.has()) {
            paramFromServiceMsg.add(Long.valueOf(((oidb_0xe09.OnlineInfo)localObject).uint64_friend_uin.get()));
          }
        }
        QLog.e("ExtendFriendHandler", 1, "handleGetExtendFriendOnlineState fail.", paramObject);
      }
      catch (Exception paramObject) {}
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        int i;
        label231:
        paramFromServiceMsg = null;
        label266:
        continue;
        label367:
        continue;
        label370:
        continue;
        label373:
        if (paramObject == null) {
          i = 0;
        }
      }
    }
    if (paramToServiceMsg != null) {}
    for (;;)
    {
      try
      {
        paramObject = (ArrayList)paramToServiceMsg.getAttribute("reqList");
        j = ((Integer)paramToServiceMsg.getAttribute("startIndex")).intValue();
        k = ((Integer)paramToServiceMsg.getAttribute("count")).intValue();
        paramToServiceMsg = (ArrayList)paramToServiceMsg.getAttribute("resultList");
        if (paramToServiceMsg != null) {
          break label367;
        }
        paramToServiceMsg = new ArrayList();
        if ((paramFromServiceMsg == null) || (paramFromServiceMsg.isEmpty())) {
          break label373;
        }
        paramToServiceMsg.addAll(paramFromServiceMsg);
      }
      catch (Exception paramToServiceMsg)
      {
        int j;
        int k;
        QLog.e("ExtendFriendHandler", 1, "handleGetExtendFriendOnlineState fail.", paramToServiceMsg);
        notifyUI(19, false, null);
        return;
      }
      if (j + k >= i) {
        continue;
      }
      a(paramObject, j + k, k, paramToServiceMsg);
      return;
      if (!QLog.isColorLevel()) {
        break label370;
      }
      QLog.d("ExtendFriendHandler", 2, String.format("handleGetExtendFriendOnlineState size=%s", new Object[] { Integer.valueOf(paramFromServiceMsg.size()) }));
      break;
      QLog.e("ExtendFriendHandler", 1, String.format("handleGetExtendFriendOnlineState result=%s", new Object[] { Integer.valueOf(i) }));
      paramFromServiceMsg = null;
      continue;
      i = paramObject.size();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, String.format("handleGetExtendFriendOnlineState request finished. resultList=%s", new Object[] { paramToServiceMsg }));
    }
    notifyUI(19, true, paramToServiceMsg);
  }
  
  private void ju(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      Object localObject = new oidb_0xe51.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("selfUin");
      paramObject = paramToServiceMsg.extraData.getString("friendUin");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("friendNick");
      if (i == 0)
      {
        localObject = ((oidb_0xe51.RspBody)localObject).bytes_sig.get().toByteArray();
        if ((this.app != null) && (this.app.a() != null))
        {
          this.app.a().a(paramObject, paramFromServiceMsg, (byte[])localObject, false);
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendHandler", 2, "handleGetSigByOxb4cCode() success -> addMatchChatSessionKey");
          }
          notifyUI(21, true, new Object[] { paramObject, paramToServiceMsg });
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendHandler", 2, "handleGetSigByOxb4cCode() fail result=" + i);
        }
        notifyUI(21, false, new Object[] { paramObject, Integer.valueOf(i) });
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("ExtendFriendHandler", 1, "handleGetSigByOxb4cCode() fail.", paramToServiceMsg);
    }
  }
  
  private void jv(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      try
      {
        oidb_0xe67.RspBody localRspBody = new oidb_0xe67.RspBody();
        int j = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
        int k = paramToServiceMsg.extraData.getInt("uint32_action", -1);
        if (localRspBody.uint32_flare_switch.has())
        {
          i = localRspBody.uint32_flare_switch.get();
          if ((k == 1) && (i == 1))
          {
            if (((afsi)this.app.getManager(264)).ajY())
            {
              paramToServiceMsg = "1";
              anot.a(null, "dc00898", "", "", "0X800AE9B", "0X800AE9B", 0, 0, "", paramToServiceMsg, "", "");
            }
          }
          else
          {
            QLog.i("ExtendFriendHandler", 2, "handleExtendFriendEnterAndQuit  result=" + j + "[0is exit] type:" + k + " signalSwitch:" + i);
            return;
          }
          paramToServiceMsg = "2";
          continue;
        }
        int i = -1;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("ExtendFriendHandler", 1, "handleExtendFriendEnterAndQuitReport() fail.", paramToServiceMsg);
        return;
      }
    }
  }
  
  public boolean B(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "setUnlimitMatchStatus. uin = " + paramString + " bopen: " + paramBoolean);
    }
    try
    {
      oidb_0xe03.ReqBody localReqBody = new oidb_0xe03.ReqBody();
      localReqBody.uint64_uin.set(e(paramString, "setUnlimitMatchStatus"));
      if (paramBoolean) {
        localReqBody.uint32_switch.set(1);
      }
      for (;;)
      {
        localReqBody.enum_matchopcode.set(4);
        paramString = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, localReqBody.toByteArray());
        paramString.extraData.putInt("match_op", 4);
        paramString.extraData.putBoolean("open", paramBoolean);
        sendPbReq(paramString);
        return true;
        localReqBody.uint32_switch.set(0);
      }
      return false;
    }
    catch (NumberFormatException paramString)
    {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "requestMatch. error = " + paramString);
    }
  }
  
  public void Ih(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, "reportUser, uin: " + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ExtendFriendHandler", 1, "reportUser, uin is empty!");
      return;
    }
    try
    {
      cmd0xcb5.ReqBody localReqBody = new cmd0xcb5.ReqBody();
      localReqBody.uint64_uin.set(Long.valueOf(paramString).longValue());
      localReqBody.uint32_report_type.set(0);
      localReqBody.str_report_conent.set("");
      localReqBody.uint64_report_time.set(NetConnInfoCenter.getServerTimeMillis());
      sendPbReq(makeOIDBPkg("OidbSvc.0xcb5", 3253, 0, localReqBody.toByteArray()));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.d("ExtendFriendHandler", 1, "reportUser exception:", paramString);
    }
  }
  
  public void Il(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "requestLimitChatSettingOnPlusPanel+voiceMatch");
    }
    try
    {
      ToServiceMsg localToServiceMsg = makeOIDBPkg("OidbSvc.0xdb1", 3505, 1, new oidb_0xdb1.ReqBody().toByteArray());
      localToServiceMsg.extraData.putBoolean("request_from_login", paramBoolean);
      sendPbReq(localToServiceMsg);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "requestLimitChatSettingOnPlusPanel. error = " + localNumberFormatException);
    }
  }
  
  public void a(EditExtendFriendInfo.SchoolInfo paramSchoolInfo)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, "updateExtendFriendCampusSchoolInfo ");
    }
    for (;;)
    {
      try
      {
        localObject = new EditExtendFriendInfo.ReqBody();
        ((EditExtendFriendInfo.ReqBody)localObject).msg_school_info.set(paramSchoolInfo);
        ToServiceMsg localToServiceMsg = makeOIDBPkg("OidbSvc.0xb4b_6", 2891, 6, ((EditExtendFriendInfo.ReqBody)localObject).toByteArray());
        if (paramSchoolInfo.uint32_idx.has())
        {
          i = paramSchoolInfo.uint32_idx.get();
          localToServiceMsg.extraData.putInt("idx", i);
          if (!paramSchoolInfo.str_school_name.has()) {
            break label305;
          }
          localObject = paramSchoolInfo.str_school_name.get();
          localToServiceMsg.extraData.putString("school_name", (String)localObject);
          String str;
          if (paramSchoolInfo.str_school_id.has())
          {
            str = paramSchoolInfo.str_school_id.get();
            localToServiceMsg.extraData.putString("school_id", str);
            if (paramSchoolInfo.uint32_category.has())
            {
              i = paramSchoolInfo.uint32_category.get();
              localToServiceMsg.extraData.putInt("school_category", i);
              i = j;
              if (paramSchoolInfo.uint32_verified.has()) {
                i = paramSchoolInfo.uint32_verified.get();
              }
              localToServiceMsg.extraData.putInt("school_certi_status", i);
              if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendHandler", 2, "updateExtendFriendCampusSchoolInfo ,schoolName = " + (String)localObject + ",verify status = " + i);
              }
              sendPbReq(localToServiceMsg);
            }
          }
          else
          {
            str = "";
            continue;
          }
          i = 0;
          continue;
        }
        int i = 0;
      }
      catch (NumberFormatException paramSchoolInfo)
      {
        QLog.d("ExtendFriendHandler", 1, "updateExtendFriendCampusSchoolInfo. error = " + paramSchoolInfo);
        return;
      }
      continue;
      label305:
      Object localObject = "";
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.i("ExtendFriendHandler", 1, String.format("editExtendFriendInfo uin=%s, declaration=%s, url=%s, duration=%d", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1) }));
    if (!NetworkState.isNetworkConnected(this.app.getApp()))
    {
      QQToast.a(this.app.getApp(), 1, 2131696270, 0).show();
      notifyUI(1, false, null);
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      paramInt4 = 0;
      paramInt2 = 0;
    }
    new aqve("QC.UniBusinessLogicServer.UniBusinessLogicObj", "QCUniBusinessLogic.UniSetExtFriend").a("UniSetExtFriend", new UniSetExtFriendReq(aqve.a(), new UniBusinessItem(304, paramInt4), new ExtendFriend(paramInt2)), new UniSetExtFriendRsp(), new afsh(this, paramString1, paramInt4, paramInt2), true);
    try
    {
      Object localObject = new EditExtendFriendInfo.ReqBody();
      ((EditExtendFriendInfo.ReqBody)localObject).uint64_uin.set(Long.parseLong(paramString1));
      ((EditExtendFriendInfo.ReqBody)localObject).bytes_declaration.set(ByteStringMicro.copyFromUtf8(paramString2));
      ((EditExtendFriendInfo.ReqBody)localObject).bytes_voice_url.set(ByteStringMicro.copyFromUtf8(paramString3));
      ((EditExtendFriendInfo.ReqBody)localObject).uint32_voice_duration.set(paramInt1);
      localObject = makeOIDBPkg("OidbSvc.0xb4b", 2891, 0, ((EditExtendFriendInfo.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString1);
      ((ToServiceMsg)localObject).extraData.putString("declaration", paramString2);
      ((ToServiceMsg)localObject).extraData.putString("url", paramString3);
      ((ToServiceMsg)localObject).extraData.putInt("duration", paramInt1);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("ExtendFriendHandler", 1, "editExtendFriendInfo exception:" + paramString1.getMessage());
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendHandler", 2, "getSigBy0xb4cCode() friendUin= " + paramString2 + " selfUin= " + paramString1 + " _0xb4cCode =" + paramArrayOfByte);
      }
      oidb_0xe51.ReqBody localReqBody = new oidb_0xe51.ReqBody();
      localReqBody.uint64_from_uin.set(Long.parseLong(paramString1));
      localReqBody.uint64_to_uin.set(Long.parseLong(paramString2));
      localReqBody.bytes_code.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      paramArrayOfByte = makeOIDBPkg("OidbSvc.0xe51", 3665, 1, localReqBody.toByteArray());
      paramArrayOfByte.extraData.putString("selfUin", paramString1);
      paramArrayOfByte.extraData.putString("friendUin", paramString2);
      paramArrayOfByte.extraData.putString("friendNick", paramString3);
      sendPbReq(paramArrayOfByte);
      return;
    }
    catch (Exception paramString1)
    {
      notifyUI(21, false, new Object[] { paramString2, Integer.valueOf(-1) });
      QLog.e("ExtendFriendHandler", 1, "getSigBy0xb4cCode() fail.", paramString1);
    }
  }
  
  public void a(String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, long paramLong, String paramString3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, String.format("getSquareStrangerList uin=%s reqCookies=%s reqCount=%s searchKey=%s ts=%d isConfigTag:%b", new Object[] { paramString1, paramArrayOfByte, Integer.valueOf(paramInt), paramString2, Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
    }
    for (;;)
    {
      try
      {
        localReqBody = new ExtendFriendSquareInfo.ReqBody();
        localReqBody.uint64_uin.set(Long.parseLong(paramString1));
        if (paramArrayOfByte == null) {
          break label421;
        }
        localReqBody.bytes_req_page_cookies.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      catch (Exception paramString1)
      {
        ExtendFriendSquareInfo.ReqBody localReqBody;
        SosoInterface.SosoLbsInfo localSosoLbsInfo;
        ExtendFriendSquareInfo.LBSInfo localLBSInfo;
        ExtendFriendSquareInfo.GPS localGPS;
        QLog.e("ExtendFriendHandler", 1, "getSquareStrangerList fail.", paramString1);
        return;
      }
      if ((!TextUtils.isEmpty(paramString1)) && (!paramString3.equals(paramString1))) {
        localReqBody.str_keyword.set(ByteStringMicro.copyFromUtf8(paramString1));
      }
      localReqBody.uint32_req_num.set(paramInt);
      localReqBody.bytes_req_buff.set(ByteStringMicro.copyFrom(awmc.a().aM()));
      paramArrayOfByte = makeOIDBPkg("OidbSvc.0xb4c", 2892, 0, localReqBody.toByteArray());
      paramArrayOfByte.setTimeout(10000L);
      paramArrayOfByte.extraData.putLong("reqTs", paramLong);
      if (!TextUtils.isEmpty(paramString2)) {
        paramArrayOfByte.extraData.putString("searchKey", paramString2);
      }
      localSosoLbsInfo = SosoInterface.a(3600000L, false, 0, true);
      if (localSosoLbsInfo != null)
      {
        localLBSInfo = new ExtendFriendSquareInfo.LBSInfo();
        localGPS = new ExtendFriendSquareInfo.GPS();
        if (localSosoLbsInfo.a != null)
        {
          localGPS.int32_lon.set((int)(localSosoLbsInfo.a.ce * 1000000.0D));
          localGPS.int32_lat.set((int)(localSosoLbsInfo.a.cd * 1000000.0D));
          localGPS.int32_type.set(1);
        }
        localLBSInfo.msg_gps.set(localGPS);
        localReqBody.msg_lbs_info.set(localLBSInfo);
      }
      sendPbReq(paramArrayOfByte);
      if ((!TextUtils.isEmpty(paramString3)) && (paramString3.equals(paramString1)))
      {
        paramInt = 1;
        if (paramInt != 0) {
          break;
        }
        paramString1 = this.app;
        if (paramBoolean)
        {
          paramInt = 1;
          anot.a(paramString1, "dc00898", "", "", "0X8009423", "0X8009423", paramInt, 0, "", "", paramString2, "");
          return;
          paramString1 = paramString2.trim();
        }
      }
      else
      {
        paramInt = 0;
        continue;
      }
      paramInt = 2;
      continue;
      label421:
      if (paramString2 == null) {
        paramString1 = null;
      }
    }
  }
  
  public void a(submsgtype0x128.MsgBody paramMsgBody, boolean paramBoolean)
  {
    if (paramMsgBody != null)
    {
      aftr localaftr = new aftr();
      localaftr.uin = this.app.getCurrentUin();
      localaftr.sig = paramMsgBody.bytes_sig.get().toByteArray();
      String str;
      label91:
      long l;
      label117:
      int i;
      if (paramMsgBody.uint64_match_uin.has())
      {
        str = String.valueOf(paramMsgBody.uint64_match_uin.get());
        localaftr.bFC = str;
        if (!paramMsgBody.bytes_tips_wording.has()) {
          break label472;
        }
        str = paramMsgBody.bytes_tips_wording.get().toStringUtf8();
        localaftr.tipsWording = str;
        if (!paramMsgBody.uint64_time_stamp.has()) {
          break label479;
        }
        l = paramMsgBody.uint64_time_stamp.get();
        localaftr.timeStamp = l;
        if (!paramMsgBody.uint32_match_expired_time.has()) {
          break label485;
        }
        i = paramMsgBody.uint32_match_expired_time.get();
        label142:
        localaftr.matchExpiredTime = i;
        if (!paramMsgBody.bytes_nick.has()) {
          break label490;
        }
        str = paramMsgBody.bytes_nick.get().toStringUtf8();
        label170:
        localaftr.nickName = str;
        if ((!paramMsgBody.msg_tag.has()) || (!paramMsgBody.msg_tag.uint32_tag_id.has())) {
          break label504;
        }
        localaftr.tagId = paramMsgBody.msg_tag.uint32_tag_id.get();
        if (!paramMsgBody.msg_tag.bytes_tag.has()) {
          break label497;
        }
        str = paramMsgBody.msg_tag.bytes_tag.get().toStringUtf8();
        label243:
        localaftr.tagName = str;
        label250:
        if (!paramMsgBody.msg_match_uin_data.has()) {
          break label540;
        }
        localaftr.a = new afsy();
        localaftr.a.friendUin = localaftr.bFC;
        a(paramMsgBody.msg_match_uin_data, localaftr.a);
      }
      for (;;)
      {
        str = "";
        if (paramMsgBody.string_report_id.has()) {
          str = paramMsgBody.string_report_id.get();
        }
        paramMsgBody = str;
        if (TextUtils.isEmpty(str))
        {
          paramMsgBody = "0";
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "string_report_id EMPTY bUnlimitMatchPush：" + paramBoolean);
        }
        localaftr.aeN = paramMsgBody;
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleGetUnlimitMatchOfflinePush push matchInfo = ", localaftr + "bUnlimitMatchPush：" + paramBoolean });
        }
        paramMsgBody = (afwh)this.app.getManager(292);
        if (paramMsgBody != null) {
          paramMsgBody.a();
        }
        if (!paramBoolean) {
          break label570;
        }
        notifyUI(16, true, new Object[] { localaftr });
        return;
        str = "0";
        break;
        label472:
        str = "";
        break label91;
        label479:
        l = 0L;
        break label117;
        label485:
        i = 0;
        break label142;
        label490:
        str = "";
        break label170;
        label497:
        str = "";
        break label243;
        label504:
        localaftr.tagId = 1;
        QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "msg_tag id empty in push bUnlimitMatchPush：" + paramBoolean);
        break label250;
        label540:
        QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "msg_match_uin_data in push bUnlimitMatchPush：" + paramBoolean);
      }
      label570:
      ((afsi)this.mApp.getManager(264)).a(localaftr);
      notifyUI(23, true, new Object[] { localaftr.bFC });
      return;
    }
    QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "handleGetUnlimitMatchOfflinePush failed bUnlimitMatchPush ：" + paramBoolean);
    if (paramBoolean)
    {
      notifyUI(16, false, null);
      return;
    }
    notifyUI(23, false, new Object[] { null });
  }
  
  public boolean a(int paramInt, aftc paramaftc)
  {
    aftc localaftc = paramaftc;
    if (paramaftc == null) {
      localaftc = ((afsi)this.mApp.getManager(264)).a();
    }
    QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "openSignalBomb  Match.   Type= " + paramInt);
    try
    {
      Object localObject = this.mApp.getCurrentAccountUin();
      paramaftc = new oidb_0xe03.ReqBody();
      paramaftc.uint64_uin.set(e((String)localObject, "openSignalBomb"));
      paramaftc.enum_matchopcode.set(6);
      paramaftc.uint32_tag_id.set(0);
      paramaftc.uint32_sex.set(paramInt);
      if (((afsi)this.mApp.getManager(264) != null) && (localaftc != null))
      {
        localObject = new oidb_0xe03.LBSInfo();
        oidb_0xe03.GPS localGPS = new oidb_0xe03.GPS();
        localGPS.int32_lon.set(localaftc.lon);
        localGPS.int32_lat.set(localaftc.lat);
        localGPS.int32_alt.set(localaftc.alt);
        localGPS.int32_type.set(localaftc.gpsType);
        ((oidb_0xe03.LBSInfo)localObject).msg_gps.set(localGPS);
        paramaftc.msg_lbs_info.set((MessageMicro)localObject);
        QLog.d("ExtendFriendHandler", 1, "openSignalBomb. with msg_lbs_info info ");
      }
      paramaftc = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, paramaftc.toByteArray());
      paramaftc.extraData.putInt("match_op", 6);
      sendPbReq(paramaftc);
      return true;
    }
    catch (NumberFormatException paramaftc)
    {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "openSignalBomb. error = " + paramaftc);
    }
    return false;
  }
  
  public boolean a(aftc paramaftc)
  {
    try
    {
      oidb_0xe67.ReqBody localReqBody = new oidb_0xe67.ReqBody();
      localReqBody.uint32_action.set(1);
      if (paramaftc != null)
      {
        oidb_0xe67.LBSInfo localLBSInfo = new oidb_0xe67.LBSInfo();
        oidb_0xe67.GPS localGPS = new oidb_0xe67.GPS();
        localGPS.int32_lon.set(paramaftc.lon);
        localGPS.int32_lat.set(paramaftc.lat);
        localGPS.int32_alt.set(paramaftc.alt);
        localGPS.int32_type.set(paramaftc.gpsType);
        localLBSInfo.msg_gps.set(localGPS);
        localReqBody.msg_lbs_info.set(localLBSInfo);
        QLog.i("ExtendFriendHandler", 1, "EnterExtendFriend. with msg_lbs_info info ");
      }
      paramaftc = makeOIDBPkg("OidbSvc.0xe67", 3687, 1, localReqBody.toByteArray());
      paramaftc.extraData.putInt("uint32_action", 1);
      sendPbReq(paramaftc);
      return true;
    }
    catch (NumberFormatException paramaftc)
    {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "EnterExtendFriend. error = " + paramaftc);
    }
    return false;
  }
  
  public boolean ajW()
  {
    QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "closeSignalBomb  Match.");
    try
    {
      Object localObject2 = this.mApp.getCurrentAccountUin();
      Object localObject1 = new oidb_0xe03.ReqBody();
      ((oidb_0xe03.ReqBody)localObject1).uint64_uin.set(e((String)localObject2, "closeSignalBomb"));
      ((oidb_0xe03.ReqBody)localObject1).enum_matchopcode.set(7);
      ((oidb_0xe03.ReqBody)localObject1).uint32_tag_id.set(0);
      localObject2 = (afsi)this.mApp.getManager(264);
      if (localObject2 != null)
      {
        localObject2 = ((afsi)localObject2).a();
        if (localObject2 != null)
        {
          oidb_0xe03.LBSInfo localLBSInfo = new oidb_0xe03.LBSInfo();
          oidb_0xe03.GPS localGPS = new oidb_0xe03.GPS();
          localGPS.int32_lon.set(((aftc)localObject2).lon);
          localGPS.int32_lat.set(((aftc)localObject2).lat);
          localGPS.int32_alt.set(((aftc)localObject2).alt);
          localGPS.int32_type.set(((aftc)localObject2).gpsType);
          localLBSInfo.msg_gps.set(localGPS);
          ((oidb_0xe03.ReqBody)localObject1).msg_lbs_info.set(localLBSInfo);
          QLog.d("ExtendFriendHandler", 1, "closeSignalBomb. with msg_lbs_info info ");
        }
      }
      localObject1 = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, ((oidb_0xe03.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putInt("match_op", 7);
      sendPbReq((ToServiceMsg)localObject1);
      return true;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "closeSignalBomb. error = " + localNumberFormatException);
    }
    return false;
  }
  
  public boolean ajX()
  {
    try
    {
      Object localObject1 = new oidb_0xe67.ReqBody();
      ((oidb_0xe67.ReqBody)localObject1).uint32_action.set(0);
      Object localObject2 = (afsi)this.mApp.getManager(264);
      if (localObject2 != null)
      {
        localObject2 = ((afsi)localObject2).a();
        if (localObject2 != null)
        {
          oidb_0xe67.LBSInfo localLBSInfo = new oidb_0xe67.LBSInfo();
          oidb_0xe67.GPS localGPS = new oidb_0xe67.GPS();
          localGPS.int32_lon.set(((aftc)localObject2).lon);
          localGPS.int32_lat.set(((aftc)localObject2).lat);
          localGPS.int32_alt.set(((aftc)localObject2).alt);
          localGPS.int32_type.set(((aftc)localObject2).gpsType);
          localLBSInfo.msg_gps.set(localGPS);
          ((oidb_0xe67.ReqBody)localObject1).msg_lbs_info.set(localLBSInfo);
          QLog.d("ExtendFriendHandler", 1, "QuitExtendFriend. with msg_lbs_info info ");
        }
      }
      localObject1 = makeOIDBPkg("OidbSvc.0xe67", 3687, 1, ((oidb_0xe67.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putInt("uint32_action", 0);
      sendPbReq((ToServiceMsg)localObject1);
      return true;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "QuitExtendFriend. error = " + localNumberFormatException);
    }
    return false;
  }
  
  public void al(MessageRecord paramMessageRecord)
  {
    Object localObject1;
    int i;
    int j;
    long l1;
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForLimitChatConfirm)))
    {
      paramMessageRecord = (MessageForLimitChatConfirm)paramMessageRecord;
      if (paramMessageRecord != null)
      {
        localObject1 = new afts();
        ((afts)localObject1).caL = paramMessageRecord.bEnterMsg;
        ((afts)localObject1).leaveChatType = paramMessageRecord.leaveChatType;
        ((afts)localObject1).timeStamp = paramMessageRecord.timeStamp;
        ((afts)localObject1).bFD = paramMessageRecord.frienduin;
        ((afts)localObject1).SenderNickName = paramMessageRecord.SenderNickName;
        ((afts)localObject1).c2cExpiredTime = paramMessageRecord.c2cExpiredTime;
        ((afts)localObject1).leftChatTime = paramMessageRecord.leftChatTime;
        ((afts)localObject1).tipsWording = paramMessageRecord.tipsWording;
        ((afts)localObject1).matchExpiredTime = paramMessageRecord.matchExpiredTime;
        ((afts)localObject1).readyTs = paramMessageRecord.readyTs;
        QLog.i("ExtendFriendHandlerExtendFriendLimitChat", 2, "HandleC2CConfirmOrCancelMsg  info：" + ((afts)localObject1).toString());
        i = 1;
        j = i;
        if (!aqiu.mt(paramMessageRecord.issend)) {
          l1 = paramMessageRecord.time;
        }
      }
    }
    label408:
    for (;;)
    {
      long l2;
      try
      {
        l2 = Long.valueOf(paramMessageRecord.frienduin).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.sendReadConfirm_PB", 2, String.format("HandleC2CConfirmMsg,uin: %s,  id: %d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) }));
        }
        if ((l1 == -1L) || (l1 == 0L)) {
          return;
        }
      }
      catch (NumberFormatException paramMessageRecord)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.msg.HandleC2CConfirmMsg sendReadConfirm_PB", 2, paramMessageRecord, new Object[0]);
        return;
      }
      paramMessageRecord = new msg_svc.PbMsgReadedReportReq();
      if (l2 != -1L)
      {
        Object localObject2 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject2).peer_uin.set(l2);
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject2).last_read_time.set((int)l1);
        localObject1 = new msg_svc.PbC2CReadedReportReq();
        ((msg_svc.PbC2CReadedReportReq)localObject1).pair_info.add((MessageMicro)localObject2);
        localObject2 = this.app.a().a().am();
        if (localObject2 != null) {
          ((msg_svc.PbC2CReadedReportReq)localObject1).sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject2));
        }
        paramMessageRecord.c2c_read_report.set((MessageMicro)localObject1);
        this.app.a().a("c2c_processor").a(paramMessageRecord);
        for (j = i;; j = 0)
        {
          if (j != 0) {
            break label408;
          }
          QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "HandleC2CConfirmMsg failed");
          return;
          i = 0;
          break;
        }
      }
    }
  }
  
  public void bU(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, "requestCampusCertificateStatus,getSearchKeywords = " + paramBoolean1 + ",getOnlineNumber = " + paramBoolean2);
    }
    try
    {
      Object localObject1 = new oidb_0xdb1.ReqBody();
      Object localObject2 = ((oidb_0xdb1.ReqBody)localObject1).uint32_get_search_keywords;
      if (paramBoolean1) {}
      for (int i = 1;; i = 0)
      {
        ((PBUInt32Field)localObject2).set(i);
        localObject2 = ((oidb_0xdb1.ReqBody)localObject1).uint32_get_online_num;
        i = j;
        if (paramBoolean2) {
          i = 1;
        }
        ((PBUInt32Field)localObject2).set(i);
        localObject2 = (afsi)this.mApp.getManager(264);
        if (localObject2 != null)
        {
          localObject2 = ((afsi)localObject2).a();
          if (localObject2 != null)
          {
            oidb_0xdb1.LBSInfo localLBSInfo = new oidb_0xdb1.LBSInfo();
            oidb_0xdb1.GPS localGPS = new oidb_0xdb1.GPS();
            localGPS.int32_lon.set(((aftc)localObject2).lon);
            localGPS.int32_lat.set(((aftc)localObject2).lat);
            localGPS.int32_alt.set(((aftc)localObject2).alt);
            localGPS.int32_type.set(((aftc)localObject2).gpsType);
            localLBSInfo.msg_gps.set(localGPS);
            ((oidb_0xdb1.ReqBody)localObject1).msg_lbs_info.set(localLBSInfo);
            QLog.d("ExtendFriendHandler", 1, "requestCampusCertificateStatus. with msg_lbs_info info ");
          }
        }
        localObject1 = makeOIDBPkg("OidbSvc.0xdb1_2", 3505, 2, ((oidb_0xdb1.ReqBody)localObject1).toByteArray());
        ((ToServiceMsg)localObject1).extraData.putBoolean("key_need_get_search_keywords", paramBoolean1);
        ((ToServiceMsg)localObject1).extraData.putBoolean("key_need_get_online_number", paramBoolean2);
        sendPbReq((ToServiceMsg)localObject1);
        return;
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e("ExtendFriendHandler", 1, "requestCampusCertificateStatus. error ", localNumberFormatException);
    }
  }
  
  public void bXV()
  {
    notifyUI(17, true, Integer.valueOf(aizy.Q(this.app)));
  }
  
  public void dbL()
  {
    if (!aizy.bb(this.app))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ExtendFriendHandler", 2, "calcMatchChatBoxUnreadCount isMatchChatRedPointSwitchOn false");
      }
      return;
    }
    bXV();
  }
  
  public boolean f(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "getUnlimitMatchUserInfo. uin = " + paramString1 + " matchUin:" + paramString2 + " uinType:" + paramInt);
    }
    try
    {
      oidb_0xe03.ReqBody localReqBody = new oidb_0xe03.ReqBody();
      localReqBody.uint64_uin.set(e(paramString1, "getUnlimitMatchUserInfo"));
      localReqBody.uint64_match_uin.set(e(paramString2, "getUnlimitMatchUserInfo"));
      localReqBody.enum_matchopcode.set(5);
      paramString1 = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, localReqBody.toByteArray());
      paramString1.extraData.putInt("match_op", 5);
      paramString1.extraData.putString("match_uin", paramString2);
      paramString1.extraData.putInt("uin_type", paramInt);
      sendPbReq(paramString1);
      return true;
    }
    catch (NumberFormatException paramString1)
    {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "requestMatch. error = " + paramString1);
    }
    return false;
  }
  
  public boolean g(String paramString, int paramInt1, int paramInt2)
  {
    QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "request Unlimit Match. uin = " + paramString + " Type= " + paramInt1 + " tag:" + paramInt2);
    try
    {
      oidb_0xe03.ReqBody localReqBody = new oidb_0xe03.ReqBody();
      localReqBody.uint64_uin.set(e(paramString, "requestUnlimitMatch"));
      localReqBody.enum_matchopcode.set(1);
      localReqBody.uint32_tag_id.set(paramInt2);
      localReqBody.uint32_sex.set(paramInt1);
      paramString = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, localReqBody.toByteArray());
      paramString.extraData.putInt("match_op", 1);
      sendPbReq(paramString);
      return true;
    }
    catch (NumberFormatException paramString)
    {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "requestMatch. error = " + paramString);
    }
    return false;
  }
  
  public void jk(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramFromServiceMsg = "success";
      paramObject = paramToServiceMsg.extraData.getString("uin");
      String str1 = paramToServiceMsg.extraData.getString("declaration");
      String str2 = paramToServiceMsg.extraData.getString("url");
      int i = paramToServiceMsg.extraData.getInt("duration");
      a(paramObject, str1, str2, 0, NetConnInfoCenter.getServerTimeMillis(), i);
      bool = true;
      paramToServiceMsg = paramFromServiceMsg;
    }
    for (;;)
    {
      QLog.i("ExtendFriendHandler", 1, String.format("handleEditExtendFriendInfo %s", new Object[] { paramToServiceMsg }));
      notifyUI(1, bool, null);
      return;
      paramToServiceMsg = paramFromServiceMsg.getStringForLog();
      bool = false;
    }
  }
  
  public void jl(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new ExtendFriendSquareInfo.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    long l = paramToServiceMsg.extraData.getLong("reqTs", 0L);
    paramObject = paramToServiceMsg.extraData.getString("searchKey", null);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, String.format("handleGetSquareStrangerList resultCode=%s searchKey=%s ts=%d", new Object[] { Integer.valueOf(i), paramObject, Long.valueOf(l) }));
    }
    boolean bool1;
    byte[] arrayOfByte;
    boolean bool2;
    label133:
    boolean bool3;
    label148:
    int m;
    ArrayList localArrayList;
    Object localObject2;
    boolean bool4;
    label288:
    label323:
    label1003:
    int n;
    label402:
    label553:
    label574:
    label1237:
    label1252:
    int j;
    if (i == 0)
    {
      for (;;)
      {
        afua localafua;
        try
        {
          if (((ExtendFriendSquareInfo.RspBody)localObject1).uint32_over.get() != 1) {
            break label1713;
          }
          bool1 = true;
          arrayOfByte = ((ExtendFriendSquareInfo.RspBody)localObject1).bytes_rsp_page_cookies.get().toByteArray();
          if (((ExtendFriendSquareInfo.RspBody)localObject1).uint32_is_profile_complete.get() != 1) {
            break label1719;
          }
          bool2 = true;
          if (((ExtendFriendSquareInfo.RspBody)localObject1).uint32_is_show_card.get() != 1) {
            break label1725;
          }
          bool3 = true;
          m = ((ExtendFriendSquareInfo.RspBody)localObject1).uint32_friend_max_votes.get();
          paramToServiceMsg = ((ExtendFriendSquareInfo.RspBody)localObject1).rpt_msg_stranger_info.get();
          localArrayList = new ArrayList();
          if ((paramToServiceMsg == null) || (paramToServiceMsg.size() <= 0)) {
            break;
          }
          localObject2 = paramToServiceMsg.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          ExtendFriendSquareInfo.StrangerInfo localStrangerInfo = (ExtendFriendSquareInfo.StrangerInfo)((Iterator)localObject2).next();
          localafua = new afua();
          localafua.mUin = String.valueOf(localStrangerInfo.uint64_uin.get());
          localafua.mNickName = localStrangerInfo.bytes_nick.get().toStringUtf8();
          localafua.mGender = localStrangerInfo.uint32_gender.get();
          if (localStrangerInfo.uint32_is_my_like.get() != 1) {
            break label1731;
          }
          bool4 = true;
          localafua.mLiked = bool4;
          localafua.mAvailLikeCount = localStrangerInfo.uint32_my_left_like_count.get();
          if (localStrangerInfo.uint32_addfri_status.get() != 1) {
            break label1737;
          }
          bool4 = true;
          localafua.mAddFriendVerified = bool4;
          localafua.mPopularity = localStrangerInfo.uint32_popularity.get();
          localafua.mDeclaration = localStrangerInfo.bytes_declaration.get().toStringUtf8();
          localafua.mVoiceUrl = localStrangerInfo.bytes_voice_url.get().toStringUtf8();
          localafua.mVoiceDuration = localStrangerInfo.uint32_voice_duration.get();
          if (localStrangerInfo.uint32_vote_switch.get() != 0) {
            break label1743;
          }
          bool4 = true;
          localafua.mbAllowStrangerVote = bool4;
          localafua.mStrRecomTrace = localStrangerInfo.str_recom_trace.get();
          localafua.voiceCode = localStrangerInfo.bytes_voice_code.get().toByteArray();
          paramToServiceMsg = new PersonalInfo.ReqBody();
          paramToServiceMsg.mergeFrom(localStrangerInfo.bytes_personalization.get().toByteArray());
          localafua.fontId = paramToServiceMsg.fontid.get();
          localafua.fontType = paramToServiceMsg.fonttype.get();
          localafua.clothesId = paramToServiceMsg.itemid.get();
          if (!TextUtils.isEmpty(localafua.mDeclaration))
          {
            localafua.mDeclaration = localafua.mDeclaration.replace('\n', ' ');
            localafua.mDeclaration = localafua.mDeclaration.trim();
          }
          if (localStrangerInfo.uint32_show_vip_info_flag.get() != 0) {
            break label1749;
          }
          bool4 = true;
          localafua.mVipHide = bool4;
          if (localStrangerInfo.uint32_bigvip_open.get() != 0) {
            break label1755;
          }
          bool4 = true;
          localafua.mBigVipHide = bool4;
          localafua.mBigVipLevel = localStrangerInfo.uint32_bigvip_level.get();
          localafua.mVipType = localStrangerInfo.uint32_vip_flag.get();
          localafua.mVipLevel = localStrangerInfo.uint32_svip_level.get();
          localafua.mTemplateId = localStrangerInfo.uint32_vipicon_id.get();
          if (!localStrangerInfo.bytes_ad_content.has()) {
            break label1761;
          }
          paramToServiceMsg = AlumBasicData.a(localStrangerInfo.bytes_ad_content.get().toByteArray());
          label659:
          localafua.mAlumbasicdata = paramToServiceMsg;
          localafua.mAge = localStrangerInfo.uint32_age.get();
          localafua.mLabelInfos = new ArrayList();
          Object localObject3;
          if (localStrangerInfo.rpt_label_info.has())
          {
            i = 0;
            if (i < localStrangerInfo.rpt_label_info.get().size())
            {
              localObject3 = new afua.a();
              ((afua.a)localObject3).XM = ((ExtendFriendSquareInfo.labelInfo)localStrangerInfo.rpt_label_info.get().get(i)).uint64_label_id.get();
              if (!((ExtendFriendSquareInfo.labelInfo)localStrangerInfo.rpt_label_info.get().get(i)).str_label_name.has()) {
                break label1766;
              }
              paramToServiceMsg = ((ExtendFriendSquareInfo.labelInfo)localStrangerInfo.rpt_label_info.get().get(i)).str_label_name.get();
              label812:
              ((afua.a)localObject3).labelName = paramToServiceMsg;
              localafua.mLabelInfos.add(localObject3);
              i += 1;
              continue;
            }
          }
          localafua.mSchoolInfos = new ArrayList();
          if (localStrangerInfo.rpt_school_info.has())
          {
            i = 0;
            if (i < localStrangerInfo.rpt_school_info.get().size())
            {
              localObject3 = new afua.b();
              ((afua.b)localObject3).schoolId = ((ExtendFriendSquareInfo.schoolInfo)localStrangerInfo.rpt_school_info.get().get(i)).str_school_id.get();
              ((afua.b)localObject3).authState = ((ExtendFriendSquareInfo.schoolInfo)localStrangerInfo.rpt_school_info.get().get(i)).uint64_state.get();
              if (!((ExtendFriendSquareInfo.schoolInfo)localStrangerInfo.rpt_school_info.get().get(i)).str_school_name.has()) {
                break label1771;
              }
              paramToServiceMsg = ((ExtendFriendSquareInfo.schoolInfo)localStrangerInfo.rpt_school_info.get().get(i)).str_school_name.get();
              ((afua.b)localObject3).schoolName = paramToServiceMsg;
              if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendHandler", 2, "handleGetSquareStrangerList: schoolId " + ((afua.b)localObject3).schoolId + " schoolName " + ((afua.b)localObject3).schoolName + " authState " + ((afua.b)localObject3).authState);
              }
              localafua.mSchoolInfos.add(localObject3);
              i += 1;
              continue;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendHandler", 2, "handleGetSquareStrangerList: " + localafua.mUin + " " + localStrangerInfo.uint32_vip_flag.get() + " " + localStrangerInfo.uint32_svip_level.get());
          }
          if ((TextUtils.isEmpty(localafua.mNickName)) && (localafua.mAlumbasicdata == null)) {
            break label1252;
          }
          localArrayList.add(localafua);
          continue;
          afxv.a().bk(paramFromServiceMsg.isSuccess(), paramFromServiceMsg.getResultCode());
        }
        catch (Exception paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ExtendFriendHandler", 2, paramToServiceMsg.getMessage(), paramToServiceMsg);
          }
          notifyUI(2, false, new Object[] { Long.valueOf(l), paramObject });
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.w("ExtendFriendHandler", 2, String.format("handleGetSquareStrangerList nick name is empty, uin=%s", new Object[] { localafua.mUin }));
        }
      }
      paramToServiceMsg = new aftq();
      paramToServiceMsg.cUo = ((ExtendFriendSquareInfo.RspBody)localObject1).uint32_match_count.get();
      paramToServiceMsg.cUp = ((ExtendFriendSquareInfo.RspBody)localObject1).uint32_match_time.get();
      paramToServiceMsg.cUq = ((ExtendFriendSquareInfo.RspBody)localObject1).uint32_online_num.get();
      localObject1 = new ArrayList();
      n = localArrayList.size();
      if (n <= 12)
      {
        ((List)localObject1).addAll(localArrayList);
        break label1776;
        label1367:
        while (i < ((List)localObject1).size())
        {
          paramToServiceMsg.list.add(((afua)((List)localObject1).get(i)).mUin);
          i += 1;
        }
      }
      localObject2 = new Random();
      j = 12;
      i = 0;
    }
    for (;;)
    {
      int k;
      if (i < n)
      {
        k = j;
        if (((Random)localObject2).nextInt(n - i) >= j) {
          break label1782;
        }
        ((List)localObject1).add(localArrayList.get(i));
        k = j - 1;
        break label1782;
        if (this.app != null) {
          ((afwh)this.app.getManager(292)).a(true, paramToServiceMsg);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, String.format("handleGetSquareStrangerList isOver=%s cookies=%s isProfileComplete=%s isShowCard=%s maxLikeCount=%s resultCount=%d matchCount=%d limitDuration=%d onlineNum=%d", new Object[] { Boolean.valueOf(bool1), arrayOfByte, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(m), Integer.valueOf(localArrayList.size()), Integer.valueOf(paramToServiceMsg.cUo), Integer.valueOf(paramToServiceMsg.cUp), Integer.valueOf(paramToServiceMsg.cUq) }));
        }
        notifyUI(2, true, new Object[] { Long.valueOf(l), paramObject, Boolean.valueOf(bool1), arrayOfByte, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(m), localArrayList, paramToServiceMsg });
        break label1237;
        notifyUI(2, false, new Object[] { Long.valueOf(l), paramObject });
        break label1237;
        label1713:
        bool1 = false;
        break;
        label1719:
        bool2 = false;
        break label133;
        label1725:
        bool3 = false;
        break label148;
        label1731:
        bool4 = false;
        break label288;
        label1737:
        bool4 = false;
        break label323;
        label1743:
        bool4 = false;
        break label402;
        label1749:
        bool4 = false;
        break label553;
        label1755:
        bool4 = false;
        break label574;
        label1761:
        paramToServiceMsg = null;
        break label659;
        label1766:
        paramToServiceMsg = null;
        break label812;
        label1771:
        paramToServiceMsg = null;
        break label1003;
      }
      label1776:
      i = 0;
      break label1367;
      label1782:
      i += 1;
      j = k;
    }
  }
  
  public void jm(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    QLog.i("ExtendFriendHandler", 1, String.format("handleGetExtendFriendInfo resultCode=%d", new Object[] { Integer.valueOf(i) }));
    boolean bool1 = false;
    if (i == 1000) {
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          break label1189;
        }
        bool1 = true;
        QLog.i("ExtendFriendHandler", 1, "handleGetExtendFriendInfo isSuccess=" + bool1);
        if ((!bool1) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null)) {
          break label1182;
        }
        GetExtendFriendInfo.RspBody localRspBody = new GetExtendFriendInfo.RspBody();
        localRspBody.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        String str = paramToServiceMsg.extraData.getString("uin");
        if ((!localRspBody.uint64_uin.has()) || (!String.valueOf(localRspBody.uint64_uin.get()).equals(str))) {
          break label1182;
        }
        if (!localRspBody.bytes_declaration.has()) {
          break label1195;
        }
        paramFromServiceMsg = localRspBody.bytes_declaration.get().toStringUtf8();
        if (!localRspBody.bytes_voice_url.has()) {
          break label1200;
        }
        localObject1 = localRspBody.bytes_voice_url.get().toStringUtf8();
        if (!localRspBody.uint32_popularity.has()) {
          break label1206;
        }
        i = localRspBody.uint32_popularity.get();
        if (!localRspBody.uint64_update_time.has()) {
          break label1212;
        }
        l1 = localRspBody.uint64_update_time.get();
        if (((localRspBody.uint32_is_show_card.has()) && (localRspBody.uint32_is_show_card.get() == 1)) && (!localRspBody.uint32_voice_duration.has())) {
          break label1218;
        }
        j = localRspBody.uint32_voice_duration.get();
        paramObject = new PersonalInfo.ReqBody();
        paramObject.mergeFrom(localRspBody.bytes_personalization.get().toByteArray());
        int i2 = paramObject.fontid.get();
        int i3 = paramObject.fonttype.get();
        int i4 = paramObject.itemid.get();
        paramObject = null;
        Card localCard = null;
        long l3 = -1L;
        int n = -1;
        int i1 = -1;
        Object localObject4 = paramObject;
        Object localObject3 = localCard;
        long l2 = l3;
        int m = n;
        int k = i1;
        if (localRspBody.rpt_school_info.has())
        {
          localObject4 = paramObject;
          localObject3 = localCard;
          l2 = l3;
          m = n;
          k = i1;
          if (((GetExtendFriendInfo.schoolInfo)localRspBody.rpt_school_info.get().get(0)).has())
          {
            paramObject = (GetExtendFriendInfo.schoolInfo)localRspBody.rpt_school_info.get().get(0);
            localObject4 = paramObject.str_school_id.get();
            localObject3 = paramObject.str_school_name.get();
            l2 = paramObject.uint64_state.get();
            m = paramObject.uint32_idx.get();
            k = paramObject.uint32_category.get();
          }
        }
        localCard = a(str, paramFromServiceMsg, (String)localObject1, i, l1, j, i2, i3, i4, (String)localObject4, (String)localObject3, l2, m, k);
        paramObject = new afua();
        paramObject.printStackTrace();
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        try
        {
          paramObject.mUin = str;
          paramObject.mDeclaration = paramFromServiceMsg;
          paramObject.mVoiceUrl = ((String)localObject1);
          paramObject.mPopularity = i;
          paramObject.mVoiceDuration = j;
          paramObject.mGender = localRspBody.uint32_gender.get();
          paramObject.mNickName = localRspBody.str_nick.get();
          if (localRspBody.uint32_show_vip_info_flag.get() != 0) {
            break label1224;
          }
          bool2 = true;
          paramObject.mVipHide = bool2;
          if (localRspBody.uint32_bigvip_open.get() != 0) {
            break label1230;
          }
          bool2 = true;
          paramObject.mBigVipHide = bool2;
          paramObject.mBigVipLevel = localRspBody.uint32_bigvip_level.get();
          paramObject.mVipType = localRspBody.uint32_vip_flag.get();
          paramObject.mVipLevel = localRspBody.uint32_svip_level.get();
          paramObject.mTemplateId = localRspBody.uint32_vipicon_id.get();
          if ((!TextUtils.isEmpty((CharSequence)localObject3)) || (!TextUtils.isEmpty((CharSequence)localObject4)))
          {
            paramObject.mSchoolInfos = new ArrayList();
            paramFromServiceMsg = new afua.b();
            paramFromServiceMsg.schoolName = ((String)localObject3);
            paramFromServiceMsg.schoolId = ((String)localObject4);
            paramFromServiceMsg.authState = l2;
          }
          paramObject.mLabelInfos = new ArrayList();
          if (localRspBody.rpt_label_info.has())
          {
            i = 0;
            if (i < localRspBody.rpt_label_info.get().size())
            {
              localObject1 = new afua.a();
              ((afua.a)localObject1).XM = ((GetExtendFriendInfo.labelInfo)localRspBody.rpt_label_info.get().get(i)).uint64_label_id.get();
              if (!((GetExtendFriendInfo.labelInfo)localRspBody.rpt_label_info.get().get(i)).str_label_name.has()) {
                break label1236;
              }
              paramFromServiceMsg = ((GetExtendFriendInfo.labelInfo)localRspBody.rpt_label_info.get().get(i)).str_label_name.get();
              ((afua.a)localObject1).labelName = paramFromServiceMsg;
              paramObject.mLabelInfos.add(localObject1);
              i += 1;
              continue;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendHandler", 2, "handleGetExtendFriendInfo: " + paramObject.mUin + " " + localRspBody.uint32_show_vip_info_flag.get() + " " + localRspBody.uint32_vip_flag.get() + " " + localRspBody.uint32_svip_level.get());
          }
          paramFromServiceMsg = paramObject;
          paramObject = localCard;
          bool2 = bool1;
          if (!paramToServiceMsg.extraData.getBoolean("onlyStrangerInfo", false))
          {
            bool2 = bool1;
            if (bool1)
            {
              bool2 = bool1;
              if (paramObject == null) {
                bool2 = false;
              }
            }
            notifyUI(3, bool2, paramObject);
          }
          notifyUI(9, bool2, new Object[] { paramFromServiceMsg, Integer.valueOf(paramToServiceMsg.extraData.getInt("getStrangerInfoSeq", 0)) });
          return;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            Object localObject1;
            paramFromServiceMsg = paramObject;
            paramObject = localInvalidProtocolBufferMicroException;
          }
        }
        paramObject = paramObject;
        paramFromServiceMsg = null;
      }
      bool1 = false;
      localObject1 = null;
      QLog.e("ExtendFriendHandler", 1, "handleGetExtendFriendInfo exception:" + paramObject.getMessage());
      paramObject = localObject1;
      continue;
      QLog.e("ExtendFriendHandler", 1, String.format("handleGetExtendFriendInfo errMsg=%s", new Object[] { paramFromServiceMsg.getStringForLog() }));
      paramObject = null;
      paramFromServiceMsg = null;
      continue;
      label1182:
      paramObject = null;
      paramFromServiceMsg = null;
      continue;
      label1189:
      bool1 = false;
      continue;
      label1195:
      paramFromServiceMsg = null;
      continue;
      label1200:
      Object localObject2 = null;
      continue;
      label1206:
      i = 0;
      continue;
      label1212:
      long l1 = 0L;
      continue;
      label1218:
      int j = 0;
      continue;
      label1224:
      boolean bool2 = false;
      continue;
      label1230:
      bool2 = false;
      continue;
      label1236:
      paramFromServiceMsg = null;
    }
  }
  
  public void jn(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null)) {
      QLog.d("ExtendFriendHandler", 1, "handleReportUserResponse error!");
    }
    int i;
    do
    {
      return;
      i = parseOIDBPkg(paramFromServiceMsg, paramObject, new cmd0xcb5.RspBody());
    } while (!QLog.isColorLevel());
    QLog.d("ExtendFriendHandler", 2, "handleReportUserResponse, result = " + i);
  }
  
  public void jr(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0xdb1.RspBody localRspBody = new oidb_0xdb1.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handlePlusSettingResponse. result = ", Integer.valueOf(i) });
    }
    if (paramToServiceMsg != null) {}
    for (boolean bool1 = paramToServiceMsg.extraData.getBoolean("request_from_login", false);; bool1 = false)
    {
      long l1;
      label112:
      long l2;
      label132:
      label153:
      int j;
      label174:
      boolean bool2;
      label184:
      label226:
      long l3;
      label247:
      boolean bool3;
      if (i == 0) {
        if (localRspBody.uint64_allow_kuolie.has())
        {
          l1 = localRspBody.uint64_allow_kuolie.get();
          if (!localRspBody.uint32_match_count.has()) {
            break label422;
          }
          i = localRspBody.uint32_match_count.get();
          if (!localRspBody.str_func_name.has()) {
            break label428;
          }
          paramToServiceMsg = localRspBody.str_func_name.get();
          if (!localRspBody.uint64_expire_time.has()) {
            break label434;
          }
          l2 = localRspBody.uint64_expire_time.get();
          if (!localRspBody.uint32_left_chat_time.has()) {
            break label442;
          }
          j = localRspBody.uint32_left_chat_time.get();
          if (l1 == 0L) {
            break label448;
          }
          bool2 = true;
          if (this.app != null)
          {
            if (!bool1) {
              break label454;
            }
            afwy.a(this.app, bool2, j, i, paramToServiceMsg, l2);
            if (bool2) {
              notifyUI(18, true, null);
            }
          }
          if (!localRspBody.uint64_voice_match_flag.has()) {
            break label467;
          }
          l3 = localRspBody.uint64_voice_match_flag.get();
          if (l3 != 1L) {
            break label475;
          }
          bool3 = true;
          label257:
          afwh.b(this.app, Boolean.valueOf(bool3));
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "handlePlusSettingResponse. lShow = " + l1 + " leftCount = " + i + " funcName = " + paramToServiceMsg + " expireTime=" + l2 + " chatTime:" + j + " voiceMatch: " + l3 + " FromLogginStep " + bool1);
          }
          notifyUI(10, true, new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), paramToServiceMsg, Long.valueOf(l2), Integer.valueOf(j) });
        }
      }
      label422:
      label428:
      label434:
      label442:
      label448:
      label454:
      label467:
      label475:
      do
      {
        return;
        l1 = 0L;
        break;
        i = -1;
        break label112;
        paramToServiceMsg = "";
        break label132;
        l2 = -1L;
        break label153;
        j = -1;
        break label174;
        bool2 = false;
        break label184;
        QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "handlePlusSettingResponse.  by voicematch not notify");
        break label226;
        l3 = -1L;
        break label247;
        bool3 = false;
        break label257;
        notifyUI(10, false, new Object[] { Boolean.valueOf(false), Integer.valueOf(-1), "", Integer.valueOf(-1), Integer.valueOf(-1) });
      } while (!QLog.isColorLevel());
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "handlePlusSettingResponse.  false result：" + i);
      return;
    }
  }
  
  public void js(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg == null)
    {
      QLog.e("ExtendFriendHandler", 2, " handleUnLimitResponse request null");
      return;
    }
    String str = paramToServiceMsg.getUin();
    Object localObject1 = getCurrentAccountUin();
    int i = paramToServiceMsg.extraData.getInt("match_op");
    int j = hs(i);
    if (!TextUtils.equals((CharSequence)localObject1, str))
    {
      QLog.e("ExtendFriendHandler", 2, " handleUnLimitResponse Wrong uin");
      return;
    }
    if (paramFromServiceMsg == null)
    {
      notifyUI(j, false, null);
      return;
    }
    localObject1 = new oidb_0xe03.RspBody();
    j = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "handleMatchResponse. uin = " + str + " match_op = " + i + " result = " + j);
    }
    int m;
    int n;
    label237:
    Object localObject2;
    label260:
    label344:
    label371:
    long l1;
    label396:
    int k;
    if (((oidb_0xe03.RspBody)localObject1).enum_matchopcode.has())
    {
      i = ((oidb_0xe03.RspBody)localObject1).enum_matchopcode.get();
      m = hs(i);
      if (j != 0) {
        break label1932;
      }
      if ((m != 11) && (m != 15)) {
        break label1018;
      }
      n = paramToServiceMsg.extraData.getInt("uin_type", 1044);
      if (!((oidb_0xe03.RspBody)localObject1).enum_matchopretcode.has()) {
        break label806;
      }
      j = ((oidb_0xe03.RspBody)localObject1).enum_matchopretcode.get();
      if (!((oidb_0xe03.RspBody)localObject1).bytes_match_fail_wording.has()) {
        break label812;
      }
      paramFromServiceMsg = ((oidb_0xe03.RspBody)localObject1).bytes_match_fail_wording.get().toStringUtf8();
      if (!((oidb_0xe03.RspBody)localObject1).msg_match_info.has()) {
        break label888;
      }
      paramObject = (oidb_0xe03.MatchInfo)((oidb_0xe03.RspBody)localObject1).msg_match_info.get();
      localObject2 = new aftr();
      ((aftr)localObject2).uin = String.valueOf(((oidb_0xe03.RspBody)localObject1).uint64_uin.get());
      ((aftr)localObject2).sig = paramObject.bytes_sig.get().toByteArray();
      if (!paramObject.uint64_match_uin.has()) {
        break label818;
      }
      paramToServiceMsg = String.valueOf(paramObject.uint64_match_uin.get());
      ((aftr)localObject2).bFC = paramToServiceMsg;
      if (!paramObject.bytes_tips_wording.has()) {
        break label825;
      }
      paramToServiceMsg = paramObject.bytes_tips_wording.get().toStringUtf8();
      ((aftr)localObject2).tipsWording = paramToServiceMsg;
      if (!paramObject.uint64_time_stamp.has()) {
        break label831;
      }
      l1 = paramObject.uint64_time_stamp.get();
      ((aftr)localObject2).timeStamp = l1;
      if (!paramObject.uint32_match_expired_time.has()) {
        break label839;
      }
      k = paramObject.uint32_match_expired_time.get();
      label422:
      ((aftr)localObject2).matchExpiredTime = k;
      if (!paramObject.bytes_nick.has()) {
        break label846;
      }
      paramToServiceMsg = paramObject.bytes_nick.get().toStringUtf8();
      label450:
      ((aftr)localObject2).nickName = paramToServiceMsg;
      if (!paramObject.string_report_id.has()) {
        break label1975;
      }
    }
    label553:
    label812:
    label818:
    label1975:
    for (paramToServiceMsg = paramObject.string_report_id.get();; paramToServiceMsg = "")
    {
      paramObject = paramToServiceMsg;
      if (TextUtils.isEmpty(paramToServiceMsg))
      {
        paramObject = "0";
        QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "string_report_id EMPTY");
      }
      ((aftr)localObject2).aeN = paramObject;
      if (((oidb_0xe03.RspBody)localObject1).msg_match_info.msg_tag.has()) {
        if (((oidb_0xe03.RspBody)localObject1).msg_match_info.msg_tag.uint32_tag_id.has())
        {
          ((aftr)localObject2).tagId = ((oidb_0xe03.RspBody)localObject1).msg_match_info.msg_tag.uint32_tag_id.get();
          if (((oidb_0xe03.RspBody)localObject1).msg_match_info.msg_tag.bytes_tag.has()) {
            ((aftr)localObject2).tagName = ((oidb_0xe03.RspBody)localObject1).msg_match_info.msg_tag.bytes_tag.get().toStringUtf8();
          }
          label592:
          if (!((oidb_0xe03.RspBody)localObject1).msg_match_info.msg_match_uin_data.has()) {
            break label876;
          }
          if (((aftr)localObject2).a == null)
          {
            ((aftr)localObject2).a = new afsy();
            ((aftr)localObject2).a.friendUin = ((aftr)localObject2).bFC;
          }
          a(((oidb_0xe03.RspBody)localObject1).msg_match_info.msg_match_uin_data, ((aftr)localObject2).a);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse type =" + m, " uin = ", str, ", match_op = ", Integer.valueOf(i), " retCode = ", Integer.valueOf(j), " matchInfo = ", ((aftr)localObject2).toString(), " errMsg = ", paramFromServiceMsg });
        }
        notifyUI(m, true, new Object[] { Integer.valueOf(j), localObject2, Integer.valueOf(n), paramFromServiceMsg });
        return;
        break;
        j = -1;
        break label237;
        paramFromServiceMsg = "";
        break label260;
        paramToServiceMsg = "0";
        break label344;
        label825:
        paramToServiceMsg = "";
        break label371;
        label831:
        l1 = -1L;
        break label396;
        label839:
        k = 30;
        break label422;
        label846:
        paramToServiceMsg = "";
        break label450;
        QLog.e("ExtendFriendHandler", 2, "msg_tag pi pei zhu ti  ID IS NULL");
        break label553;
        QLog.e("ExtendFriendHandler", 2, "msg_tag pi pei zhu ti   not has");
        break label592;
        label876:
        QLog.e("ExtendFriendHandler", 2, "msg_match_uin_data  not has");
      }
      label888:
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse type =" + m, " uin = ", str, ", match_op = ", Integer.valueOf(i), " retCode = ", Integer.valueOf(j), " errMsg = ", paramFromServiceMsg });
      }
      notifyUI(m, true, new Object[] { Integer.valueOf(j), null, Integer.valueOf(n), paramFromServiceMsg });
      return;
      label1018:
      boolean bool1;
      if (m == 12)
      {
        if (((oidb_0xe03.RspBody)localObject1).enum_matchopretcode.has())
        {
          j = ((oidb_0xe03.RspBody)localObject1).enum_matchopretcode.get();
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse TYPE_CANCLE_UNLIMIT_MATCH. uin = ", str, ", match_op = ", Integer.valueOf(i), " retCode = ", Integer.valueOf(j) });
          }
          if (j != 0) {
            break label1127;
          }
        }
        label1127:
        for (bool1 = true;; bool1 = false)
        {
          notifyUI(12, bool1, null);
          return;
          j = -1;
          break;
        }
      }
      if (m == 13)
      {
        if (((oidb_0xe03.RspBody)localObject1).uint32_switch.has())
        {
          j = ((oidb_0xe03.RspBody)localObject1).uint32_switch.get();
          paramFromServiceMsg = new ArrayList();
          if (!((oidb_0xe03.RspBody)localObject1).rpt_tag.has()) {
            break label1319;
          }
          k = 0;
          if (k >= ((oidb_0xe03.RspBody)localObject1).rpt_tag.size()) {
            break label1319;
          }
          paramObject = new afub();
          localObject2 = (oidb_0xe03.TagInfo)((oidb_0xe03.RspBody)localObject1).rpt_tag.get(k);
          paramObject.tagId = ((oidb_0xe03.TagInfo)localObject2).uint32_tag_id.get();
          if (!((oidb_0xe03.TagInfo)localObject2).bytes_tag.has()) {
            break label1307;
          }
          paramToServiceMsg = ((oidb_0xe03.TagInfo)localObject2).bytes_tag.get().toStringUtf8();
          label1254:
          paramObject.tagName = paramToServiceMsg;
          if (!((oidb_0xe03.TagInfo)localObject2).uint32_hot_flag.has()) {
            break label1313;
          }
        }
        for (m = ((oidb_0xe03.TagInfo)localObject2).uint32_hot_flag.get();; m = 0)
        {
          paramObject.cUs = m;
          paramFromServiceMsg.add(paramObject);
          k += 1;
          break label1183;
          j = 0;
          break;
          paramToServiceMsg = "";
          break label1254;
        }
        if (((oidb_0xe03.RspBody)localObject1).uint32_count.has()) {}
        for (k = ((oidb_0xe03.RspBody)localObject1).uint32_count.get();; k = 1212432)
        {
          paramToServiceMsg = new ArrayList();
          if (!((oidb_0xe03.RspBody)localObject1).uint64_uin_list.has()) {
            break;
          }
          m = 0;
          while (m < ((oidb_0xe03.RspBody)localObject1).uint64_uin_list.size())
          {
            paramToServiceMsg.add(((Long)((oidb_0xe03.RspBody)localObject1).uint64_uin_list.get(m)).toString());
            m += 1;
          }
        }
        long l2;
        label1464:
        boolean bool2;
        if (j != 0)
        {
          bool1 = true;
          if (!((oidb_0xe03.RspBody)localObject1).uint64_voice_match_flag.has()) {
            break label1677;
          }
          l1 = ((oidb_0xe03.RspBody)localObject1).uint64_voice_match_flag.get();
          if (!((oidb_0xe03.RspBody)localObject1).uint32_flare_switch.has()) {
            break label1685;
          }
          l2 = ((oidb_0xe03.RspBody)localObject1).uint32_flare_switch.get();
          if (l1 != 1L) {
            break label1693;
          }
          bool2 = true;
          label1474:
          if (l2 != 1L) {
            break label1699;
          }
        }
        for (boolean bool3 = true;; bool3 = false)
        {
          notifyUI(13, true, new Object[] { paramFromServiceMsg, Boolean.valueOf(bool1), Integer.valueOf(k), paramToServiceMsg, Boolean.valueOf(bool3) });
          afwh.a(this.app, Boolean.valueOf(bool1));
          afwh.b(this.app, Boolean.valueOf(bool2));
          afwh.g(this.app, paramFromServiceMsg);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. TYPE_GET_UNLIMIT_TAG uin = ", str, ", match_op = ", i + " tagList  :" + paramFromServiceMsg.toString() + " 勿扰 switch:" + bool1 + " voiceMatchF: " + l1 + " bSingalBombFlagOpen" + l2 + " uinList size" + paramToServiceMsg.size() });
          return;
          bool1 = false;
          break label1421;
          l1 = -1L;
          break label1442;
          l2 = -1L;
          break label1464;
          bool2 = false;
          break label1474;
        }
      }
      if (m == 14)
      {
        bool1 = paramToServiceMsg.extraData.getBoolean("open", false);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. TYPE_SET_UNLIMIT_SWITCH uin = ", str, ", open = ", Boolean.valueOf(bool1) });
        }
        afwh.a(this.app, Boolean.valueOf(bool1));
        notifyUI(14, true, null);
        return;
      }
      if (m == 15)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. TYPE_GET_UNLIMIT_FRIEND_INFO uin = ", str, ", match_op = ", Integer.valueOf(i) });
        return;
      }
      if (m == 24)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. TYPE_OPEN_SIGNAL_BOMB    match_op = ", Integer.valueOf(i) });
        return;
      }
      if (m != 25) {
        break;
      }
      ((afsi)this.mApp.getManager(264)).dbV();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. TYPE_CLOSE_SIGNAL_BOMB   match_op = ", Integer.valueOf(i) });
      return;
      notifyUI(m, false, null);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "handleMatchResponse. TYPE_UPDATE_MATCH_INFO false result：" + j);
      return;
    }
  }
  
  public int k(String paramString, boolean paramBoolean)
  {
    QLog.i("ExtendFriendHandler", 1, String.format("getExtendFriendInfo uin=%s", new Object[] { paramString }));
    int i = bm.incrementAndGet();
    try
    {
      Object localObject = new GetExtendFriendInfo.ReqBody();
      ((GetExtendFriendInfo.ReqBody)localObject).uint64_uin.set(Long.parseLong(paramString));
      localObject = makeOIDBPkg("OidbSvc.0xb51", 2897, 0, ((GetExtendFriendInfo.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString);
      ((ToServiceMsg)localObject).extraData.putBoolean("onlyStrangerInfo", paramBoolean);
      ((ToServiceMsg)localObject).extraData.putInt("getStrangerInfoSeq", i);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      sendPbReq((ToServiceMsg)localObject);
      return i;
    }
    catch (Exception paramString)
    {
      QLog.e("ExtendFriendHandler", 1, "getExtendFriendInfo exception:" + paramString.getMessage());
    }
    return i;
  }
  
  public void kz(List<Long> paramList)
  {
    if (paramList != null) {
      a(paramList, 0, 50, null);
    }
  }
  
  public boolean mc(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "cancleUnlimitMatch. uin = " + paramString);
    }
    try
    {
      oidb_0xe03.ReqBody localReqBody = new oidb_0xe03.ReqBody();
      localReqBody.uint64_uin.set(e(paramString, "cancleUnlimitMatch"));
      localReqBody.enum_matchopcode.set(2);
      paramString = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, localReqBody.toByteArray());
      paramString.extraData.putInt("match_op", 2);
      sendPbReq(paramString);
      return true;
    }
    catch (NumberFormatException paramString)
    {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "requestMatch. error = " + paramString);
    }
    return false;
  }
  
  public boolean md(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "getUnlimitMatchBaseInfo. uin = " + paramString);
    }
    try
    {
      oidb_0xe03.ReqBody localReqBody = new oidb_0xe03.ReqBody();
      localReqBody.uint64_uin.set(e(paramString, "getUnlimitMatchBaseInfo"));
      localReqBody.enum_matchopcode.set(3);
      localReqBody.uint64_client_version.set(833L);
      paramString = (afsi)this.mApp.getManager(264);
      if (paramString != null)
      {
        paramString = paramString.a();
        if (paramString != null)
        {
          oidb_0xe03.LBSInfo localLBSInfo = new oidb_0xe03.LBSInfo();
          oidb_0xe03.GPS localGPS = new oidb_0xe03.GPS();
          localGPS.int32_lon.set(paramString.lon);
          localGPS.int32_lat.set(paramString.lat);
          localGPS.int32_alt.set(paramString.alt);
          localGPS.int32_type.set(paramString.gpsType);
          localLBSInfo.msg_gps.set(localGPS);
          localReqBody.msg_lbs_info.set(localLBSInfo);
          QLog.d("ExtendFriendHandler", 1, "getUnlimitMatchBaseInfo. with msg_lbs_info info ");
        }
      }
      paramString = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, localReqBody.toByteArray());
      paramString.extraData.putInt("match_op", 3);
      sendPbReq(paramString);
      return true;
    }
    catch (NumberFormatException paramString)
    {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "requestMatch. error = " + paramString);
    }
    return false;
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xb4b");
      this.allowCmdSet.add("OidbSvc.0xb4b_6");
      this.allowCmdSet.add("OidbSvc.0xb4c");
      this.allowCmdSet.add("OidbSvc.0xb51");
      this.allowCmdSet.add("OidbSvc.0xcb5");
      this.allowCmdSet.add("OidbSvc.0xdb1");
      this.allowCmdSet.add("OidbSvc.0xdb1_2");
      this.allowCmdSet.add("OidbSvc.0xe52_3");
      this.allowCmdSet.add("OidbSvc.0xe03");
      this.allowCmdSet.add("OidbSvc.0xe09");
      this.allowCmdSet.add("OidbSvc.0xe51");
      this.allowCmdSet.add("OidbSvc.0xe67");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return afsr.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      return;
      if ("OidbSvc.0xb4b".equals(paramFromServiceMsg.getServiceCmd()))
      {
        jk(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xb4c".equals(paramFromServiceMsg.getServiceCmd()))
      {
        jl(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xb51".equals(paramFromServiceMsg.getServiceCmd()))
      {
        jm(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xcb5".equals(paramFromServiceMsg.getServiceCmd()))
      {
        jn(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xdb1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        jr(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xdb1_2".equals(paramFromServiceMsg.getServiceCmd()))
      {
        jq(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xe52_3".equals(paramFromServiceMsg.getServiceCmd()))
      {
        jp(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xb4b_6".equals(paramFromServiceMsg.getServiceCmd()))
      {
        jo(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xe03".equals(paramFromServiceMsg.getServiceCmd()))
      {
        js(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xe09".equals(paramFromServiceMsg.getServiceCmd()))
      {
        jt(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xe51".equals(paramFromServiceMsg.getServiceCmd()))
      {
        ju(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xe67".equals(paramFromServiceMsg.getServiceCmd()));
    jv(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afsg
 * JD-Core Version:    0.7.0.1
 */