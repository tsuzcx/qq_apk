import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.applets.data.AppletItem.a;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xc76.oidb_cmd0xc76.Item;
import tencent.im.oidb.cmd0xc76.oidb_cmd0xc76.ReqBody;
import tencent.im.oidb.cmd0xc76.oidb_cmd0xc76.RspBody;
import tencent.im.oidb.cmd0xc76.oidb_cmd0xc76.Setting;
import tencent.im.oidb.cmd0xc7a.oidb_cmd0xc7a.GetUinInfoReq;
import tencent.im.oidb.cmd0xc7a.oidb_cmd0xc7a.ReqBody;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.FollowExt;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.FollowReq;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.ReqBody;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.UnFollowExt;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.UnfollowReq;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class adag
  extends accg
{
  private final Object cL = new Object();
  private final Set<Long> ca = new HashSet();
  private final Map<String, Integer> jB = new ConcurrentHashMap();
  
  public adag(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private oidb_sso.OIDBSSOPkg a(ArrayList<AppletItem> paramArrayList, boolean paramBoolean)
  {
    oidb_cmd0xc76.ReqBody localReqBody = new oidb_cmd0xc76.ReqBody();
    localReqBody.cmd.set(2);
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      AppletItem localAppletItem = (AppletItem)paramArrayList.next();
      oidb_cmd0xc76.Item localItem = new oidb_cmd0xc76.Item();
      if (paramBoolean)
      {
        localItem.puin.set(Long.parseLong(localAppletItem.sb()));
        localItem.name.set(localAppletItem.getName());
        localItem.value.set(localAppletItem.getValue());
      }
      for (;;)
      {
        localArrayList.add(localItem);
        break;
        localItem.id.set(localAppletItem.getId());
        localItem.type.set(localAppletItem.getType());
        localItem.value.set(localAppletItem.getValue());
      }
    }
    localReqBody.apps.set(localArrayList);
    paramArrayList = new oidb_sso.OIDBSSOPkg();
    paramArrayList.uint32_command.set(3190);
    paramArrayList.uint32_result.set(0);
    paramArrayList.uint32_service_type.set(0);
    paramArrayList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    return paramArrayList;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_cmd0xc76.RspBody paramRspBody)
  {
    paramToServiceMsg = new ArrayList();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (paramRspBody.main.has())
    {
      paramFromServiceMsg = (oidb_cmd0xc76.Setting)paramRspBody.main.get();
      localObject1 = new ArrayList();
      localObject2 = new adao();
      if (paramFromServiceMsg.item.has())
      {
        localObject3 = paramFromServiceMsg.item.get().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (oidb_cmd0xc76.Item)((Iterator)localObject3).next();
          AppletItem.a locala = new AppletItem.a();
          if (((oidb_cmd0xc76.Item)localObject4).id.has()) {
            locala.a(((oidb_cmd0xc76.Item)localObject4).id.get());
          }
          if (((oidb_cmd0xc76.Item)localObject4).icon.has()) {
            locala.b(((oidb_cmd0xc76.Item)localObject4).icon.get());
          }
          if (((oidb_cmd0xc76.Item)localObject4).type.has()) {
            locala.a(((oidb_cmd0xc76.Item)localObject4).type.get());
          }
          if (((oidb_cmd0xc76.Item)localObject4).name.has()) {
            locala.a(((oidb_cmd0xc76.Item)localObject4).name.get());
          }
          if (((oidb_cmd0xc76.Item)localObject4).value.has()) {
            locala.b(((oidb_cmd0xc76.Item)localObject4).value.get());
          }
          ((List)localObject1).add(locala.a());
        }
      }
      ((adao)localObject2).items = ((List)localObject1);
      if (paramFromServiceMsg.desc.has()) {
        ((adao)localObject2).des = paramFromServiceMsg.desc.get();
      }
      paramToServiceMsg.add(localObject2);
    }
    if (paramRspBody.apps.has())
    {
      paramFromServiceMsg = new ArrayList();
      localObject1 = new adao();
      paramRspBody = (oidb_cmd0xc76.Setting)paramRspBody.apps.get();
      if (paramRspBody.item.has())
      {
        localObject2 = paramRspBody.item.get().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (oidb_cmd0xc76.Item)((Iterator)localObject2).next();
          localObject4 = new AppletItem.a();
          if (((oidb_cmd0xc76.Item)localObject3).id.has()) {
            ((AppletItem.a)localObject4).a(((oidb_cmd0xc76.Item)localObject3).id.get());
          }
          if (((oidb_cmd0xc76.Item)localObject3).icon.has()) {
            ((AppletItem.a)localObject4).b(((oidb_cmd0xc76.Item)localObject3).icon.get());
          }
          if (((oidb_cmd0xc76.Item)localObject3).type.has()) {
            ((AppletItem.a)localObject4).a(((oidb_cmd0xc76.Item)localObject3).type.get());
          }
          if (((oidb_cmd0xc76.Item)localObject3).name.has()) {
            ((AppletItem.a)localObject4).a(((oidb_cmd0xc76.Item)localObject3).name.get());
          }
          if (((oidb_cmd0xc76.Item)localObject3).value.has()) {
            ((AppletItem.a)localObject4).b(((oidb_cmd0xc76.Item)localObject3).value.get());
          }
          paramFromServiceMsg.add(((AppletItem.a)localObject4).a());
        }
      }
      ((adao)localObject1).items = paramFromServiceMsg;
      if (paramRspBody.desc.has()) {
        ((adao)localObject1).des = paramRspBody.desc.get();
      }
      paramToServiceMsg.add(localObject1);
    }
    if (paramToServiceMsg.size() > 0)
    {
      notifyUI(2, true, paramToServiceMsg);
      return;
    }
    notifyUI(2, false, null);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_cmd0xc76.RspBody paramRspBody)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("unreceived_uin_list");
    if (paramFromServiceMsg.isSuccess())
    {
      notifyUI(3, true, paramToServiceMsg);
      return;
    }
    notifyUI(3, false, paramToServiceMsg);
  }
  
  private <T extends MessageRecord> Map<String, Integer> e(List<T> paramList)
  {
    Iterator localIterator = null;
    Object localObject = localIterator;
    if (paramList != null)
    {
      localObject = localIterator;
      if (paramList.size() > 0)
      {
        localObject = new HashMap();
        localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          String str = p((MessageRecord)localIterator.next());
          if (!TextUtils.isEmpty(str))
          {
            paramList = (Integer)((Map)localObject).get(str);
            if (paramList != null) {}
            for (paramList = Integer.valueOf(paramList.intValue() + 1);; paramList = Integer.valueOf(1))
            {
              ((Map)localObject).put(str, paramList);
              break;
            }
          }
        }
      }
    }
    return localObject;
  }
  
  private List<MessageRecord> em()
  {
    Object localObject1 = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappNotificationUin", "1038354735");
    long l2 = this.app.a().e((String)localObject1, 1038);
    long l1 = l2;
    if (l2 > System.currentTimeMillis()) {
      l1 = -1L;
    }
    Object localObject2 = this.app.b().a(1038).a((String)localObject1, 1038, l1);
    if (localObject2 != null)
    {
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject2).next();
        if (!localChatMessage.isread) {
          ((List)localObject1).add(localChatMessage);
        }
      }
      return localObject1;
    }
    return null;
  }
  
  private void iD(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      Object localObject = new oidb_sso.OIDBSSOPkg();
      for (;;)
      {
        int i;
        try
        {
          paramObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
          int j = -1;
          i = j;
          if (paramObject != null)
          {
            i = j;
            if (paramObject.uint32_result.has())
            {
              j = paramObject.uint32_result.get();
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.i("AppletsHandler", 2, "handle OidbSvc.0xc76|OIDBSSOPke.result=" + j);
                i = j;
              }
            }
          }
          if (paramToServiceMsg.extraData.getBoolean("public_account_state_changed_flag", false)) {
            if (i == 0)
            {
              if (QLog.isColorLevel()) {
                QLog.i("AppletsHandler", 2, "handle OidbSvc.0xc76|OIDBSSOPke  pubacc report successfully!");
              }
              paramObject = paramObject.bytes_bodybuffer.get().toByteArray();
              localObject = new oidb_cmd0xc76.RspBody();
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          try
          {
            ((oidb_cmd0xc76.RspBody)localObject).mergeFrom(paramObject);
            if (!((oidb_cmd0xc76.RspBody)localObject).cmd.has()) {
              break label267;
            }
            if (((oidb_cmd0xc76.RspBody)localObject).cmd.get() == 2)
            {
              paramObject = paramToServiceMsg.extraData.getParcelableArrayList("unreceived_uin_list");
              notifyUI(7, paramFromServiceMsg.isSuccess(), paramObject);
            }
            return;
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            QLog.w("AppletsHandler", 4, paramFromServiceMsg.getMessage(), paramFromServiceMsg);
            notifyUI(7, false, paramToServiceMsg.extraData.getParcelableArrayList("unreceived_uin_list"));
            return;
          }
          catch (Exception paramFromServiceMsg)
          {
            for (;;)
            {
              QLog.w("AppletsHandler", 4, paramFromServiceMsg.getMessage(), paramFromServiceMsg);
            }
          }
          paramObject = paramObject;
          QLog.w("AppletsHandler", 4, paramObject.getMessage(), paramObject);
          paramObject = localObject;
          continue;
        }
        catch (Exception paramObject)
        {
          QLog.w("AppletsHandler", 4, paramObject.getMessage(), paramObject);
          paramObject = localObject;
          continue;
        }
        label267:
        if ((i == 0) && (paramObject.bytes_bodybuffer.has()) && (paramObject.bytes_bodybuffer.get() != null))
        {
          paramObject = paramObject.bytes_bodybuffer.get().toByteArray();
          localObject = new oidb_cmd0xc76.RspBody();
          try
          {
            ((oidb_cmd0xc76.RspBody)localObject).mergeFrom(paramObject);
            if (((oidb_cmd0xc76.RspBody)localObject).cmd.has())
            {
              i = ((oidb_cmd0xc76.RspBody)localObject).cmd.get();
              if (i == 1)
              {
                a(paramToServiceMsg, paramFromServiceMsg, (oidb_cmd0xc76.RspBody)localObject);
                return;
              }
            }
          }
          catch (InvalidProtocolBufferMicroException paramToServiceMsg)
          {
            QLog.w("AppletsHandler", 4, paramToServiceMsg.getMessage(), paramToServiceMsg);
            return;
            if (i == 2)
            {
              b(paramToServiceMsg, paramFromServiceMsg, (oidb_cmd0xc76.RspBody)localObject);
              return;
            }
          }
          catch (Exception paramToServiceMsg)
          {
            QLog.w("AppletsHandler", 4, paramToServiceMsg.getMessage(), paramToServiceMsg);
            return;
          }
        }
      }
      paramToServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("unreceived_uin_list");
      if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
      {
        notifyUI(3, false, paramToServiceMsg);
        return;
      }
      notifyUI(2, false, null);
      return;
    }
    paramToServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("unreceived_uin_list");
    if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
    {
      notifyUI(3, false, paramToServiceMsg);
      return;
    }
    notifyUI(2, false, null);
  }
  
  /* Error */
  private void iE(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 268	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +504 -> 508
    //   7: new 139	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   10: dup
    //   11: invokespecial 140	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   14: astore_1
    //   15: aload_1
    //   16: aload_3
    //   17: checkcast 370	[B
    //   20: checkcast 370	[B
    //   23: invokevirtual 374	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   26: checkcast 139	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   29: astore_2
    //   30: aload_2
    //   31: astore_1
    //   32: iconst_m1
    //   33: istore 5
    //   35: iload 5
    //   37: istore 4
    //   39: aload_1
    //   40: ifnull +68 -> 108
    //   43: iload 5
    //   45: istore 4
    //   47: aload_1
    //   48: getfield 146	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   51: invokevirtual 217	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   54: ifeq +54 -> 108
    //   57: aload_1
    //   58: getfield 146	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   61: invokevirtual 219	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   64: istore 5
    //   66: iload 5
    //   68: istore 4
    //   70: invokestatic 379	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +35 -> 108
    //   76: ldc_w 381
    //   79: iconst_2
    //   80: new 383	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 432
    //   90: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: iload 5
    //   95: invokevirtual 393	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 400	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: iload 5
    //   106: istore 4
    //   108: iload 4
    //   110: ifne +390 -> 500
    //   113: aload_1
    //   114: getfield 153	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   117: invokevirtual 424	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   120: ifeq +380 -> 500
    //   123: aload_1
    //   124: getfield 153	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   127: invokevirtual 411	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   130: ifnull +370 -> 500
    //   133: new 434	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$RspBody
    //   136: dup
    //   137: invokespecial 435	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$RspBody:<init>	()V
    //   140: astore_2
    //   141: aload_1
    //   142: getfield 153	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   145: invokevirtual 411	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   148: invokevirtual 412	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   151: astore_1
    //   152: aload_2
    //   153: aload_1
    //   154: invokevirtual 436	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   157: pop
    //   158: aload_2
    //   159: getfield 439	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$RspBody:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   162: invokevirtual 210	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   165: ifeq +367 -> 532
    //   168: aload_2
    //   169: getfield 439	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$RspBody:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   172: invokevirtual 212	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   175: astore_1
    //   176: aload_2
    //   177: getfield 442	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$RspBody:next_req_duration	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   180: invokevirtual 217	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   183: ifeq +343 -> 526
    //   186: aload_2
    //   187: getfield 442	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$RspBody:next_req_duration	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   190: invokevirtual 219	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   193: istore 4
    //   195: aload_0
    //   196: getfield 446	adag:mApp	Lcom/tencent/common/app/AppInterface;
    //   199: sipush 315
    //   202: invokevirtual 452	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   205: checkcast 454	aagv
    //   208: aload_1
    //   209: iload 4
    //   211: invokevirtual 458	aagv:cV	(Ljava/lang/String;I)V
    //   214: aload_2
    //   215: getfield 462	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$RspBody:get_uin_info_rsp	Ltencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$GetUinInfoRsp;
    //   218: invokevirtual 465	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$GetUinInfoRsp:has	()Z
    //   221: ifeq +300 -> 521
    //   224: aload_2
    //   225: getfield 462	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$RspBody:get_uin_info_rsp	Ltencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$GetUinInfoRsp;
    //   228: invokevirtual 466	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$GetUinInfoRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   231: checkcast 464	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$GetUinInfoRsp
    //   234: astore_1
    //   235: aload_1
    //   236: ifnull +280 -> 516
    //   239: aload_1
    //   240: getfield 469	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$GetUinInfoRsp:uin_infos	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   243: invokevirtual 193	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   246: ifeq +270 -> 516
    //   249: aload_1
    //   250: getfield 469	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$GetUinInfoRsp:uin_infos	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   253: invokevirtual 196	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   256: astore_1
    //   257: new 51	java/util/ArrayList
    //   260: dup
    //   261: invokespecial 52	java/util/ArrayList:<init>	()V
    //   264: astore_2
    //   265: aload_1
    //   266: ifnull +227 -> 493
    //   269: aload_1
    //   270: invokeinterface 197 1 0
    //   275: astore_1
    //   276: aload_1
    //   277: invokeinterface 62 1 0
    //   282: ifeq +211 -> 493
    //   285: aload_1
    //   286: invokeinterface 66 1 0
    //   291: checkcast 471	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$UinInfo
    //   294: astore_3
    //   295: new 473	com/tencent/mobileqq/applets/data/AppletsAccountInfo
    //   298: dup
    //   299: invokespecial 474	com/tencent/mobileqq/applets/data/AppletsAccountInfo:<init>	()V
    //   302: astore 6
    //   304: aload_3
    //   305: getfield 477	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$UinInfo:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   308: invokevirtual 201	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   311: ifeq +18 -> 329
    //   314: aload 6
    //   316: aload_3
    //   317: getfield 477	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$UinInfo:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   320: invokevirtual 203	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   323: invokestatic 482	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   326: putfield 484	com/tencent/mobileqq/applets/data/AppletsAccountInfo:uin	Ljava/lang/String;
    //   329: aload_3
    //   330: getfield 487	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$UinInfo:face_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   333: invokevirtual 210	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   336: ifeq +15 -> 351
    //   339: aload 6
    //   341: aload_3
    //   342: getfield 487	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$UinInfo:face_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   345: invokevirtual 212	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   348: putfield 490	com/tencent/mobileqq/applets/data/AppletsAccountInfo:faceUrl	Ljava/lang/String;
    //   351: aload_3
    //   352: getfield 493	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$UinInfo:face_url_simple	Lcom/tencent/mobileqq/pb/PBStringField;
    //   355: invokevirtual 210	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   358: ifeq +15 -> 373
    //   361: aload 6
    //   363: aload_3
    //   364: getfield 493	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$UinInfo:face_url_simple	Lcom/tencent/mobileqq/pb/PBStringField;
    //   367: invokevirtual 212	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   370: putfield 496	com/tencent/mobileqq/applets/data/AppletsAccountInfo:faceUrlSimple	Ljava/lang/String;
    //   373: aload_3
    //   374: getfield 499	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$UinInfo:nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   377: invokevirtual 210	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   380: ifeq +15 -> 395
    //   383: aload 6
    //   385: aload_3
    //   386: getfield 499	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$UinInfo:nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   389: invokevirtual 212	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   392: putfield 501	com/tencent/mobileqq/applets/data/AppletsAccountInfo:nick	Ljava/lang/String;
    //   395: aload_3
    //   396: getfield 505	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$UinInfo:appinfo	Ltencent/im/oidb/qqconnect$Appinfo;
    //   399: invokevirtual 508	tencent/im/oidb/qqconnect$Appinfo:has	()Z
    //   402: ifeq +23 -> 425
    //   405: aload 6
    //   407: aload 6
    //   409: aload_3
    //   410: getfield 505	tencent/im/oidb/cmd0xc7a/oidb_cmd0xc7a$UinInfo:appinfo	Ltencent/im/oidb/qqconnect$Appinfo;
    //   413: invokevirtual 509	tencent/im/oidb/qqconnect$Appinfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   416: checkcast 507	tencent/im/oidb/qqconnect$Appinfo
    //   419: invokevirtual 513	com/tencent/mobileqq/applets/data/AppletsAccountInfo:convertToAppletInfo	(Ltencent/im/oidb/qqconnect$Appinfo;)Lcom/tencent/mobileqq/applets/data/AppletInfo;
    //   422: putfield 517	com/tencent/mobileqq/applets/data/AppletsAccountInfo:appInfo	Lcom/tencent/mobileqq/applets/data/AppletInfo;
    //   425: aload_2
    //   426: aload 6
    //   428: invokeinterface 115 2 0
    //   433: pop
    //   434: goto -158 -> 276
    //   437: astore_2
    //   438: ldc_w 381
    //   441: iconst_4
    //   442: aload_2
    //   443: invokevirtual 418	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   446: aload_2
    //   447: invokestatic 422	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   450: goto -418 -> 32
    //   453: astore_2
    //   454: ldc_w 381
    //   457: iconst_4
    //   458: aload_2
    //   459: invokevirtual 423	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   462: aload_2
    //   463: invokestatic 422	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   466: goto -434 -> 32
    //   469: astore_1
    //   470: invokestatic 379	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   473: ifeq +13 -> 486
    //   476: ldc_w 381
    //   479: iconst_2
    //   480: ldc_w 519
    //   483: invokestatic 522	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   486: aload_1
    //   487: invokevirtual 525	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   490: goto -332 -> 158
    //   493: aload_0
    //   494: iconst_1
    //   495: iconst_1
    //   496: aload_2
    //   497: invokevirtual 249	adag:notifyUI	(IZLjava/lang/Object;)V
    //   500: aload_0
    //   501: iconst_1
    //   502: iconst_0
    //   503: aconst_null
    //   504: invokevirtual 249	adag:notifyUI	(IZLjava/lang/Object;)V
    //   507: return
    //   508: aload_0
    //   509: iconst_1
    //   510: iconst_0
    //   511: aconst_null
    //   512: invokevirtual 249	adag:notifyUI	(IZLjava/lang/Object;)V
    //   515: return
    //   516: aconst_null
    //   517: astore_1
    //   518: goto -261 -> 257
    //   521: aconst_null
    //   522: astore_1
    //   523: goto -288 -> 235
    //   526: iconst_0
    //   527: istore 4
    //   529: goto -334 -> 195
    //   532: ldc_w 527
    //   535: astore_1
    //   536: goto -360 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	539	0	this	adag
    //   0	539	1	paramToServiceMsg	ToServiceMsg
    //   0	539	2	paramFromServiceMsg	FromServiceMsg
    //   0	539	3	paramObject	Object
    //   37	491	4	i	int
    //   33	72	5	j	int
    //   302	125	6	localAppletsAccountInfo	com.tencent.mobileqq.applets.data.AppletsAccountInfo
    // Exception table:
    //   from	to	target	type
    //   15	30	437	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   15	30	453	java/lang/Exception
    //   152	158	469	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void iF(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int k = -1;
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    oidb_cmd0xc96.ReqBody localReqBody = new oidb_cmd0xc96.ReqBody();
    int i;
    try
    {
      localOIDBSSOPkg.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
      localReqBody.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      i = localReqBody.cmd_type.get();
      if (!paramFromServiceMsg.isSuccess()) {
        break label319;
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          int j;
          QLog.w("AppletsHandler", 4, paramFromServiceMsg.getMessage(), paramFromServiceMsg);
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          QLog.w("AppletsHandler", 4, paramFromServiceMsg.getMessage(), paramFromServiceMsg);
        }
        notifyUI(4, true, paramToServiceMsg);
        return;
      }
      j = k;
      if (paramToServiceMsg != null)
      {
        j = k;
        if (paramToServiceMsg.uint32_result.has())
        {
          k = paramToServiceMsg.uint32_result.get();
          j = k;
          if (QLog.isColorLevel())
          {
            QLog.i("AppletsHandler", 2, "handle OidbSvc.0xc96|OIDBSSOPke.result=" + k);
            j = k;
          }
        }
      }
      if ((j != 0) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null)) {
        break label292;
      }
      paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      switch (i)
      {
      default: 
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        paramToServiceMsg.printStackTrace();
        i = -1;
      }
    }
    notifyUI(5, true, paramToServiceMsg);
    return;
    label292:
    if (QLog.isColorLevel()) {
      QLog.d("AppletsHandler", 2, "0xc96 fail");
    }
    notifyUI(i + 3, false, null);
    return;
    label319:
    if (QLog.isColorLevel()) {
      QLog.d("AppletsHandler", 2, "handleGetAppletPublicAccount res.isSuccess=false");
    }
    notifyUI(i, false, null);
  }
  
  private String p(MessageRecord paramMessageRecord)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessageRecord != null)
    {
      localObject1 = localObject2;
      if (paramMessageRecord.mExJsonObject != null) {
        localObject1 = paramMessageRecord.mExJsonObject.optString("appid");
      }
    }
    return localObject1;
  }
  
  public void D(ArrayList<AppletItem> paramArrayList, boolean paramBoolean)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = a(paramArrayList, paramBoolean);
    ToServiceMsg localToServiceMsg = createToServiceMsg("OidbSvc.0xc76");
    localToServiceMsg.putWupBuffer(localOIDBSSOPkg.toByteArray());
    if (paramBoolean)
    {
      localToServiceMsg.extraData.putBoolean("public_account_state_changed_flag", true);
      localToServiceMsg.extraData.putParcelableArrayList("unreceived_uin_list", paramArrayList);
    }
    for (;;)
    {
      sendPbReq(localToServiceMsg);
      return;
      localToServiceMsg.extraData.putParcelableArrayList("unreceived_uin_list", paramArrayList);
    }
  }
  
  public void Gl(String paramString)
  {
    List localList;
    if (!TextUtils.isEmpty(paramString)) {
      localList = em();
    }
    label303:
    for (;;)
    {
      int i;
      synchronized (this.cL)
      {
        this.jB.remove(paramString);
        if (localList == null) {
          break label220;
        }
        ??? = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappNotificationUin", "1038354735");
        Iterator localIterator = localList.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if (!paramString.equals(p(localMessageRecord))) {
            break label303;
          }
          this.app.b().a((String)???, 1038, localMessageRecord.uniseq, "isread", Boolean.valueOf(true));
          i -= 1;
        }
      }
      if (i != 0) {
        this.app.a().G((String)???, 1038, i);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AppletsHandler", 2, "setAppletsMsgReadedByAppid: " + paramString + "  increaseCount: " + i + "  unreadMsgList size:" + localList.size());
      }
      label220:
      do
      {
        do
        {
          return;
        } while (!QLog.isColorLevel());
        QLog.d("AppletsHandler", 2, "setAppletsMsgReadedByAppid: " + paramString + "  unreadMsgList size:" + localList.size());
        return;
      } while (!QLog.isColorLevel());
      QLog.d("AppletsHandler", 2, "setAppletsMsgReadedByAppid: " + paramString);
      return;
    }
  }
  
  public void K(String paramString1, String paramString2, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    AppletItem.a locala = new AppletItem.a();
    locala.a(paramString2);
    locala.Gm(paramString1);
    locala.b(paramInt);
    localArrayList.add(locala.a());
    D(localArrayList, true);
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    Object localObject1 = new oidb_cmd0xc96.ReqBody();
    Object localObject2;
    Object localObject3;
    if ((paramInt1 != -1) && (paramLong1 != -1L))
    {
      ((oidb_cmd0xc96.ReqBody)localObject1).app_type.set(paramInt1);
      ((oidb_cmd0xc96.ReqBody)localObject1).appid.set(paramLong1);
      if (!paramBoolean) {
        break label220;
      }
      localObject2 = new oidb_cmd0xc96.FollowExt();
      ((oidb_cmd0xc96.FollowExt)localObject2).source_from.set(paramInt2);
      localObject3 = new oidb_cmd0xc96.FollowReq();
      ((oidb_cmd0xc96.FollowReq)localObject3).ext.set((MessageMicro)localObject2);
      ((oidb_cmd0xc96.ReqBody)localObject1).follow_req.set((MessageMicro)localObject3);
      ((oidb_cmd0xc96.ReqBody)localObject1).cmd_type.set(1);
    }
    for (;;)
    {
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(3222);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xc96.ReqBody)localObject1).toByteArray()));
      localObject1 = createToServiceMsg("OidbSvc.0xc96");
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      sendPbReq((ToServiceMsg)localObject1);
      do
      {
        return;
        if (paramLong2 != -1L)
        {
          ((oidb_cmd0xc96.ReqBody)localObject1).puin.set(paramLong2);
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AppletsHandler", 2, "report info error, all is none!");
      return;
      label220:
      localObject2 = new oidb_cmd0xc96.UnFollowExt();
      ((oidb_cmd0xc96.UnFollowExt)localObject2).source_from.set(paramInt2);
      localObject3 = new oidb_cmd0xc96.UnfollowReq();
      ((oidb_cmd0xc96.UnfollowReq)localObject3).ext.set((MessageMicro)localObject2);
      ((oidb_cmd0xc96.ReqBody)localObject1).unfollow_req.set((MessageMicro)localObject3);
      ((oidb_cmd0xc96.ReqBody)localObject1).cmd_type.set(2);
    }
  }
  
  public void cPu()
  {
    Object localObject = new oidb_cmd0xc76.ReqBody();
    ((oidb_cmd0xc76.ReqBody)localObject).cmd.set(1);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(3190);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(0);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xc76.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0xc76");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void cPv()
  {
    synchronized (this.cL)
    {
      this.jB.clear();
      this.ca.clear();
      notifyUI(8, true, null);
      return;
    }
  }
  
  public void cPw()
  {
    QLog.d("AppletsHandler", 1, "requestGetAppletsMsgUnreadInfo");
    ??? = em();
    if ((??? != null) && (((List)???).size() > 0))
    {
      Map localMap = e((List)???);
      if ((localMap != null) && (localMap.size() > 0)) {}
      synchronized (this.cL)
      {
        this.jB.clear();
        this.jB.putAll(localMap);
        notifyUI(8, true, this.jB);
        return;
      }
    }
    synchronized (this.cL)
    {
      this.jB.clear();
      notifyUI(8, true, null);
      return;
    }
  }
  
  public void dS(ArrayList<AppletItem> paramArrayList)
  {
    D(paramArrayList, false);
  }
  
  public void jv(List<Long> paramList)
  {
    Object localObject = new oidb_cmd0xc7a.ReqBody();
    ((oidb_cmd0xc7a.ReqBody)localObject).cmd.set(1);
    oidb_cmd0xc7a.GetUinInfoReq localGetUinInfoReq = new oidb_cmd0xc7a.GetUinInfoReq();
    localGetUinInfoReq.uins.set(paramList);
    ((oidb_cmd0xc7a.ReqBody)localObject).get_uin_info_req.set(localGetUinInfoReq);
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(3194);
    paramList.uint32_result.set(0);
    paramList.uint32_service_type.set(0);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xc7a.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0xc7a");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void jw(List<MessageRecord> paramList)
  {
    if (paramList == null) {}
    Object localObject2;
    Object localObject3;
    do
    {
      do
      {
        return;
        localObject2 = new LinkedList();
        synchronized (this.cL)
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localObject3 = (MessageRecord)paramList.next();
            if (!this.ca.contains(Long.valueOf(((MessageRecord)localObject3).msgUid)))
            {
              ((List)localObject2).add(localObject3);
              this.ca.add(Long.valueOf(((MessageRecord)localObject3).msgUid));
            }
          }
        }
      } while (((List)localObject2).size() < 1);
      paramList = e((List)localObject2);
    } while ((paramList == null) || (paramList.size() <= 0));
    for (;;)
    {
      synchronized (this.cL)
      {
        localObject2 = paramList.entrySet().iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        paramList = (Map.Entry)((Iterator)localObject2).next();
        localObject3 = (String)paramList.getKey();
        Integer localInteger = (Integer)this.jB.get(localObject3);
        if (localInteger != null)
        {
          int i = localInteger.intValue();
          paramList = Integer.valueOf(((Integer)paramList.getValue()).intValue() + i);
          this.jB.put(localObject3, paramList);
        }
      }
      paramList = (Integer)paramList.getValue();
    }
    notifyUI(8, true, this.jB);
  }
  
  public boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xc76");
      this.allowCmdSet.add("OidbSvc.0xc7a");
      this.allowCmdSet.add("OidbSvc.0xc96");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return adah.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      if (QLog.isColorLevel()) {
        QLog.d("AppletsHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
    }
    do
    {
      return;
      if ("OidbSvc.0xc7a".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        iE(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xc76".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        iD(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xc96".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()));
    iF(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adag
 * JD-Core Version:    0.7.0.1
 */