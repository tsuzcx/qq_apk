import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShieldOperationItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShieldListInfo;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.MobileQQ;
import org.apache.http.util.ByteArrayBuffer;
import tencent.im.s2c.msgtype0x210.submsgtype0x30.SubMsgType0x30.BlockListNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x30.SubMsgType0x30.BlockUinInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x30.SubMsgType0x30.MsgBody;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.BlockUinInfo;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.ReqBody;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.ReqBodyAddBlockList;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.ReqBodyDelBlockList;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.ReqBodyGetBlockList;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.RspBody;
import tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.RspBodyGetBlockList;
import tencent.im.sso2sns.sso2sns_comm_info.Sso2SnsCommInfo;

public class aclo
  extends accg
{
  private volatile boolean bJp;
  private String bpi;
  private String bpj;
  private String bpk;
  private String bpl;
  private String bpm;
  private String bpn;
  private String bpo;
  private String bpp;
  private String bpq;
  private volatile int cyb = -1;
  private ConcurrentHashMap<String, ShieldListInfo> ei = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ShieldListInfo> ej = new ConcurrentHashMap();
  private ConcurrentLinkedQueue<ShieldOperationItem> y = new ConcurrentLinkedQueue();
  
  public aclo(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.bpi = paramQQAppInterface.getApplication().getString(2131720216);
    this.bpj = paramQQAppInterface.getApplication().getString(2131720217);
    this.bpk = paramQQAppInterface.getApplication().getString(2131720214);
    this.bpl = paramQQAppInterface.getApplication().getString(2131720218);
    this.bpn = paramQQAppInterface.getApplication().getString(2131720212);
    this.bpo = paramQQAppInterface.getApplication().getString(2131720210);
    this.bpp = paramQQAppInterface.getApplication().getString(2131720213);
    this.bpm = paramQQAppInterface.getApplication().getString(2131720215);
    this.bpq = paramQQAppInterface.getApplication().getString(2131720211);
  }
  
  private int AY()
  {
    if (this.cyb == -1) {
      this.cyb = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getInt("lastGetShieldListTime", 0);
    }
    return this.cyb;
  }
  
  private void JV(int paramInt)
  {
    this.cyb = paramInt;
    if (this.app.getCurrentAccountUin() != null)
    {
      SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).edit();
      localEditor.putInt("lastGetShieldListTime", paramInt);
      localEditor.commit();
      if (QLog.isColorLevel()) {
        QLog.d("ShieldListHandler", 2, "setLastGetShieldListTime lastTime = " + paramInt);
      }
    }
  }
  
  private void a(ShieldOperationItem paramShieldOperationItem)
  {
    synchronized (this.y)
    {
      this.y.add(paramShieldOperationItem);
      cMs();
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, sso2sns_0x3_blocklist.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_add><R><---handleAddShieldListResp.");
    }
    paramFromServiceMsg = new ArrayList();
    paramRspBody = paramToServiceMsg.extraData.getLongArray("uinList");
    int j = paramToServiceMsg.extraData.getInt("source_id");
    int k = paramToServiceMsg.extraData.getInt("source_sub_id");
    int m = paramToServiceMsg.extraData.getInt("fromType");
    int n = paramRspBody.length;
    int i = 0;
    while (i < n)
    {
      long l = paramRspBody[i];
      paramToServiceMsg = new ShieldListInfo();
      paramToServiceMsg.uin = String.valueOf(Long.valueOf(l));
      paramToServiceMsg.source_id = j;
      paramToServiceMsg.source_sub_id = k;
      paramToServiceMsg.flags = 1;
      paramFromServiceMsg.add(paramToServiceMsg);
      i += 1;
    }
    ((aizg)this.app.getManager(16)).aq(paramFromServiceMsg);
    a(true, j, paramRspBody);
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_add><R> : " + Arrays.toString(paramRspBody));
    }
    notifyUI(2, true, new Object[] { paramRspBody, Integer.valueOf(m) });
  }
  
  private void a(boolean paramBoolean, int paramInt, long[] paramArrayOfLong)
  {
    String str = this.app.getCurrentAccountUin();
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfLong.length;
    int i = 0;
    long l1;
    Object localObject3;
    Object localObject2;
    Object localObject1;
    asgx localasgx;
    if (i < k)
    {
      l1 = paramArrayOfLong[i];
      long l2 = anaz.gQ();
      j = ShieldListInfo.SOURCE_ID_2_AIO_TYPE(paramInt);
      localObject3 = String.valueOf(l1);
      if (j != 1006) {
        if (paramBoolean)
        {
          localObject2 = this.bpi;
          if (ChatActivityUtils.C.contains(l1 + ""))
          {
            localObject2 = this.bpj;
            ChatActivityUtils.C.remove(l1 + "");
          }
          localObject1 = localObject2;
          if (j == 1024)
          {
            localasgx = (asgx)this.app.getManager(165);
            if (localasgx != null)
            {
              localObject1 = localObject2;
              if (!localasgx.sH((String)localObject3))
              {
                localObject1 = localObject2;
                if (localasgx.sM((String)localObject3)) {}
              }
            }
            else
            {
              localObject1 = this.bpl;
            }
          }
          if ((j != 1037) && (j != 1044))
          {
            localObject2 = localObject3;
            if (j != 1045) {}
          }
          else
          {
            localObject1 = this.bpm;
            localObject2 = localObject3;
          }
          label246:
          localObject3 = anbi.d(-2012);
          ((MessageRecord)localObject3).init(str, (String)localObject2, str, (String)localObject1, l2, 0, j, 0L);
          ((MessageRecord)localObject3).msgtype = -2012;
          ((MessageRecord)localObject3).isread = true;
          localObject1 = this.app.b().k((String)localObject2, j);
          if ((localObject1 == null) || (((List)localObject1).size() <= 0) || (!top.a((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1), (MessageRecord)localObject3, false))) {
            break label610;
          }
          if (QLog.isColorLevel()) {
            QLog.w("ShieldListHandler", 2, "insertShieldMsgIntoMsgPool filtered!");
          }
        }
      }
    }
    label610:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        localArrayList.add(localObject3);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShieldListHandler", 2, "<---insertShieldMsgIntoMsgPool : insert:" + ((MessageRecord)localObject3).toString());
      }
      do
      {
        i += 1;
        break;
        localObject2 = this.bpn;
        localObject1 = localObject2;
        if (j == 1024)
        {
          localasgx = (asgx)this.app.getManager(165);
          if (localasgx != null)
          {
            localObject1 = localObject2;
            if (!localasgx.sH((String)localObject3))
            {
              localObject1 = localObject2;
              if (localasgx.sM((String)localObject3)) {}
            }
          }
          else
          {
            localObject1 = this.bpp;
          }
        }
        if ((j != 1037) && (j != 1044))
        {
          localObject2 = localObject3;
          if (j != 1045) {
            break label246;
          }
        }
        localObject1 = this.bpq;
        localObject2 = localObject3;
        break label246;
        if (QLog.isColorLevel()) {
          QLog.d("ShieldListHandler", 2, "<---insertShieldMsgIntoMsgPool : isContactMsgType!");
        }
        localObject2 = aqgv.y(this.app, String.valueOf(l1));
      } while (localObject2 == null);
      if (paramBoolean)
      {
        localObject1 = this.bpk;
        break label246;
      }
      localObject1 = this.bpo;
      break label246;
      this.app.b().c(localArrayList, String.valueOf(str), false);
      return;
    }
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    byte[] arrayOfByte1 = (byte[])paramObject;
    String str = paramFromServiceMsg.getServiceCmd();
    paramObject = new sso2sns_comm_info.Sso2SnsCommInfo();
    sso2sns_0x3_blocklist.RspBody localRspBody = new sso2sns_0x3_blocklist.RspBody();
    if (arrayOfByte1.length < 8)
    {
      n(paramToServiceMsg, paramFromServiceMsg);
      return false;
    }
    long l1 = aqoj.getLongData(arrayOfByte1, 0);
    long l2 = aqoj.getLongData(arrayOfByte1, 4);
    byte[] arrayOfByte3 = new byte[(int)l1];
    byte[] arrayOfByte2 = new byte[(int)l2];
    System.arraycopy(arrayOfByte1, 8, arrayOfByte3, 0, (int)l1);
    try
    {
      paramObject = (sso2sns_comm_info.Sso2SnsCommInfo)paramObject.mergeFrom(arrayOfByte3);
      if (paramObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShieldListHandler", 2, "<---decodeSso2SnsCommInfo: error: commInfo is null.");
        }
        n(paramToServiceMsg, paramFromServiceMsg);
        return false;
      }
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShieldListHandler", 2, "<---decodeSso2SnsCommInfo: exception : parse Sso2SnsCommInfo failed.", paramObject);
        }
        paramObject = null;
      }
      if ((!paramObject.uint32_result.has()) || (paramObject.uint32_result.get() != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShieldListHandler", 2, "<---decodeSso2SnsCommInfo: error resultCode :" + paramObject.uint32_result.get());
        }
        n(paramToServiceMsg, paramFromServiceMsg);
        return false;
      }
      System.arraycopy(arrayOfByte1, (int)(l1 + 8L), arrayOfByte2, 0, (int)l2);
      try
      {
        paramObject = (sso2sns_0x3_blocklist.RspBody)localRspBody.mergeFrom(arrayOfByte2);
        if ("SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList".equalsIgnoreCase(str)) {
          return a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
      }
      catch (Exception paramObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShieldListHandler", 2, "<---decodeSso2SnsCommInfo: exception : parse RspBody failed.", paramObject);
        }
        n(paramToServiceMsg, paramFromServiceMsg);
        return false;
      }
      if ("SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList".equalsIgnoreCase(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return false;
      }
      if ("SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList".equalsIgnoreCase(str)) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
    return false;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, sso2sns_0x3_blocklist.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_get><R><---handleGetShieldListResp.");
    }
    if ((paramRspBody == null) || (!paramRspBody.msg_body_get_blocklist.has())) {
      return false;
    }
    paramToServiceMsg = (sso2sns_0x3_blocklist.RspBodyGetBlockList)paramRspBody.msg_body_get_blocklist.get();
    int j = paramToServiceMsg.fixed32_get_time.get();
    int k = paramToServiceMsg.uint32_completed.get();
    int m = paramToServiceMsg.uint32_now_pos.get();
    int n = paramToServiceMsg.uint32_get_type.get();
    paramRspBody = paramToServiceMsg.rpt_msg_block_uin_info.get();
    paramToServiceMsg = (aizg)this.app.getManager(16);
    int i = 0;
    if (paramRspBody != null) {
      i = paramRspBody.size();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<---handleGetShieldListResp : lastGetTime:" + j + ",isComplete:" + k + ",nowPos:" + m + ",getType:" + n + ",respSize:" + i);
    }
    Object localObject;
    boolean bool;
    if (n == 2)
    {
      if ((paramRspBody != null) && (paramRspBody.size() > 0))
      {
        paramFromServiceMsg = paramRspBody.iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramRspBody = (sso2sns_0x3_blocklist.BlockUinInfo)paramFromServiceMsg.next();
          localObject = new ShieldListInfo();
          ((ShieldListInfo)localObject).uin = String.valueOf(paramRspBody.uint64_block_uin.get());
          ((ShieldListInfo)localObject).flags = 1;
          ((ShieldListInfo)localObject).source_id = paramRspBody.uint32_source_id.get();
          ((ShieldListInfo)localObject).source_sub_id = paramRspBody.uint32_source_sub_id.get();
          if (QLog.isColorLevel()) {
            QLog.d("ShieldListHandler", 2, "<---handleGetShieldListResp : total data : shieldUin:" + ((ShieldListInfo)localObject).uin + ",source_id:" + ((ShieldListInfo)localObject).source_id + ",sub_ource_id:" + ((ShieldListInfo)localObject).source_sub_id);
          }
          this.ej.put(((ShieldListInfo)localObject).uin, localObject);
        }
      }
      if (k != 1) {
        break label596;
      }
      bool = paramToServiceMsg.a(this.ej);
      this.ej.clear();
    }
    for (;;)
    {
      if (k == 0)
      {
        ha(n, m);
        return true;
        if (n == 1)
        {
          paramFromServiceMsg = new ArrayList();
          if ((paramRspBody != null) && (paramRspBody.size() > 0))
          {
            paramRspBody = paramRspBody.iterator();
            while (paramRspBody.hasNext())
            {
              localObject = (sso2sns_0x3_blocklist.BlockUinInfo)paramRspBody.next();
              ShieldListInfo localShieldListInfo = new ShieldListInfo();
              localShieldListInfo.uin = String.valueOf(((sso2sns_0x3_blocklist.BlockUinInfo)localObject).uint64_block_uin.get());
              localShieldListInfo.flags = 1;
              localShieldListInfo.source_id = ((sso2sns_0x3_blocklist.BlockUinInfo)localObject).uint32_source_id.get();
              localShieldListInfo.source_sub_id = ((sso2sns_0x3_blocklist.BlockUinInfo)localObject).uint32_source_sub_id.get();
              if (QLog.isColorLevel()) {
                QLog.d("ShieldListHandler", 2, "<---handleGetShieldListResp : add data :" + localShieldListInfo.toString());
              }
              paramFromServiceMsg.add(localShieldListInfo);
            }
          }
          bool = paramToServiceMsg.aq(paramFromServiceMsg);
        }
      }
      else
      {
        if ((k == 1) && (bool)) {
          JV(j);
        }
        return false;
      }
      label596:
      bool = false;
    }
  }
  
  private byte[] a(sso2sns_comm_info.Sso2SnsCommInfo paramSso2SnsCommInfo, sso2sns_0x3_blocklist.ReqBody paramReqBody)
  {
    byte[] arrayOfByte1 = new byte[4];
    byte[] arrayOfByte2 = new byte[4];
    paramSso2SnsCommInfo = paramSso2SnsCommInfo.toByteArray();
    paramReqBody = paramReqBody.toByteArray();
    long l1 = paramSso2SnsCommInfo.length;
    long l2 = paramReqBody.length;
    aqoj.DWord2Byte(arrayOfByte1, 0, l1);
    aqoj.DWord2Byte(arrayOfByte2, 0, l2);
    ByteArrayBuffer localByteArrayBuffer = new ByteArrayBuffer((int)(8L + l1 + l2));
    localByteArrayBuffer.append(arrayOfByte1, 0, 4);
    localByteArrayBuffer.append(arrayOfByte2, 0, 4);
    localByteArrayBuffer.append(paramSso2SnsCommInfo, 0, (int)l1);
    localByteArrayBuffer.append(paramReqBody, 0, (int)l2);
    return localByteArrayBuffer.toByteArray();
  }
  
  private void av(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield><TO><---handleOperatingShieldList time out.");
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if ((str == null) || (str.length() == 0)) {}
    do
    {
      return;
      if ("SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList".equalsIgnoreCase(str))
      {
        aw(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList".equalsIgnoreCase(str))
      {
        ax(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    } while (!"SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList".equalsIgnoreCase(str));
    ay(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void aw(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_get><E><---handleGetShieldListError.");
    }
    notifyUI(1, false, null);
  }
  
  private void ax(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = paramToServiceMsg.extraData.getLongArray("uinList");
    int i = paramToServiceMsg.extraData.getInt("fromType");
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_add><E> : handleAddShieldListError :" + Arrays.toString(paramFromServiceMsg));
    }
    notifyUI(2, false, new Object[] { paramFromServiceMsg, Integer.valueOf(i) });
  }
  
  private void ay(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = paramToServiceMsg.extraData.getLongArray("uinList");
    int i = paramToServiceMsg.extraData.getInt("fromType");
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_del><E> : handleDeleteShieldListError : " + Arrays.toString(paramFromServiceMsg));
    }
    notifyUI(3, false, new Object[] { paramFromServiceMsg, Integer.valueOf(i) });
  }
  
  private void b(ShieldOperationItem paramShieldOperationItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_add><S> : sendGetShieldListReqInternal : queue size:" + this.y.size());
    }
    long l = Long.valueOf(this.app.getCurrentAccountUin()).longValue();
    ToServiceMsg localToServiceMsg = createToServiceMsg("SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList");
    Object localObject1 = new sso2sns_comm_info.Sso2SnsCommInfo();
    ((sso2sns_comm_info.Sso2SnsCommInfo)localObject1).uint32_seq.set(1234);
    sso2sns_0x3_blocklist.ReqBodyAddBlockList localReqBodyAddBlockList = new sso2sns_0x3_blocklist.ReqBodyAddBlockList();
    localReqBodyAddBlockList.uint64_uin.set(l);
    Object localObject2 = paramShieldOperationItem.f;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      l = localObject2[i];
      sso2sns_0x3_blocklist.BlockUinInfo localBlockUinInfo = new sso2sns_0x3_blocklist.BlockUinInfo();
      localBlockUinInfo.uint64_block_uin.set(Long.valueOf(l).longValue());
      localBlockUinInfo.uint32_source_id.set(paramShieldOperationItem.source_id);
      localBlockUinInfo.uint32_source_sub_id.set(0);
      localReqBodyAddBlockList.rpt_msg_block_uin_info.add(localBlockUinInfo);
      i += 1;
    }
    localObject2 = new sso2sns_0x3_blocklist.ReqBody();
    ((sso2sns_0x3_blocklist.ReqBody)localObject2).msg_body_add_blocklist.set(localReqBodyAddBlockList);
    localObject1 = a((sso2sns_comm_info.Sso2SnsCommInfo)localObject1, (sso2sns_0x3_blocklist.ReqBody)localObject2);
    localToServiceMsg.setTimeout(60000L);
    localToServiceMsg.extraData.putInt("opType", paramShieldOperationItem.opType);
    localToServiceMsg.extraData.putInt("source_id", paramShieldOperationItem.source_id);
    localToServiceMsg.extraData.putInt("source_sub_id", paramShieldOperationItem.source_sub_id);
    localToServiceMsg.extraData.putLongArray("uinList", paramShieldOperationItem.f);
    localToServiceMsg.extraData.putInt("fromType", paramShieldOperationItem.fromType);
    localToServiceMsg.putWupBuffer((byte[])localObject1);
    sendPbReq(localToServiceMsg);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, sso2sns_0x3_blocklist.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_del><R><---handleDeleteShieldListResp.");
    }
    paramFromServiceMsg = new ArrayList();
    paramRspBody = paramToServiceMsg.extraData.getLongArray("uinList");
    int j = paramToServiceMsg.extraData.getInt("source_id");
    int k = paramToServiceMsg.extraData.getInt("source_sub_id");
    int m = paramToServiceMsg.extraData.getInt("fromType");
    int n = paramRspBody.length;
    int i = 0;
    while (i < n)
    {
      long l = paramRspBody[i];
      paramToServiceMsg = new ShieldListInfo();
      paramToServiceMsg.uin = String.valueOf(Long.valueOf(l));
      paramToServiceMsg.source_id = j;
      paramToServiceMsg.source_sub_id = k;
      paramToServiceMsg.flags = 0;
      paramFromServiceMsg.add(paramToServiceMsg);
      i += 1;
    }
    ((aizg)this.app.getManager(16)).aq(paramFromServiceMsg);
    a(false, j, paramRspBody);
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_del><R> : " + Arrays.toString(paramRspBody));
    }
    notifyUI(3, true, new Object[] { paramRspBody, Integer.valueOf(m) });
  }
  
  private void c(ShieldOperationItem paramShieldOperationItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_del><S> : sendDeleteShieldListReqInternal : queue size:" + this.y.size());
    }
    long l = Long.valueOf(this.app.getCurrentAccountUin()).longValue();
    ToServiceMsg localToServiceMsg = createToServiceMsg("SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList");
    Object localObject1 = new sso2sns_comm_info.Sso2SnsCommInfo();
    ((sso2sns_comm_info.Sso2SnsCommInfo)localObject1).uint32_seq.set(1234);
    sso2sns_0x3_blocklist.ReqBodyDelBlockList localReqBodyDelBlockList = new sso2sns_0x3_blocklist.ReqBodyDelBlockList();
    localReqBodyDelBlockList.uint64_uin.set(l);
    Object localObject2 = paramShieldOperationItem.f;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      l = localObject2[i];
      localReqBodyDelBlockList.rpt_uint64_del_uin.add(Long.valueOf(l));
      i += 1;
    }
    localObject2 = new sso2sns_0x3_blocklist.ReqBody();
    ((sso2sns_0x3_blocklist.ReqBody)localObject2).msg_body_del_blocklist.set(localReqBodyDelBlockList);
    localObject1 = a((sso2sns_comm_info.Sso2SnsCommInfo)localObject1, (sso2sns_0x3_blocklist.ReqBody)localObject2);
    localToServiceMsg.extraData.putInt("opType", paramShieldOperationItem.opType);
    localToServiceMsg.extraData.putInt("source_id", paramShieldOperationItem.source_id);
    localToServiceMsg.extraData.putInt("source_sub_id", paramShieldOperationItem.source_sub_id);
    localToServiceMsg.extraData.putLongArray("uinList", paramShieldOperationItem.f);
    localToServiceMsg.extraData.putInt("fromType", paramShieldOperationItem.fromType);
    localToServiceMsg.setTimeout(60000L);
    localToServiceMsg.putWupBuffer((byte[])localObject1);
    sendPbReq(localToServiceMsg);
  }
  
  private void cMs()
  {
    synchronized (this.y)
    {
      boolean bool = this.y.isEmpty();
      if (QLog.isColorLevel()) {
        QLog.d("ShieldListHandler", 2, "--->execNextShieldOperation : isShieldOperating:" + this.bJp + ",isEmpty:" + bool);
      }
      if ((this.bJp) || (bool)) {
        return;
      }
      ShieldOperationItem localShieldOperationItem1 = (ShieldOperationItem)this.y.poll();
      if (localShieldOperationItem1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShieldListHandler", 2, "--->execNextShieldOperation : queque is empty.");
        }
        return;
      }
    }
    int i = localShieldOperationItem2.opType;
    this.bJp = true;
    switch (i)
    {
    }
    for (;;)
    {
      return;
      ha(0, 0);
      continue;
      b(localShieldOperationItem2);
      continue;
      c(localShieldOperationItem2);
    }
  }
  
  private void cMt()
  {
    this.bJp = false;
    cMu();
    cMs();
  }
  
  private void cMu()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "flushPushCacheIntoDB : pushCache size" + this.ei.size());
    }
    if (this.ei.isEmpty()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.ei.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add((ShieldListInfo)this.ei.get(str));
    }
    ((aizg)this.app.getManager(16)).aq(localArrayList);
    this.ei.clear();
    notifyUI(4, true, null);
  }
  
  private void ha(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_get><S> : sendGetShieldListReqInternal : queue size:" + this.y.size());
    }
    Object localObject2 = Long.valueOf(this.app.getCurrentAccountUin());
    int i = AY();
    ToServiceMsg localToServiceMsg = createToServiceMsg("SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList");
    Object localObject1 = new sso2sns_comm_info.Sso2SnsCommInfo();
    ((sso2sns_comm_info.Sso2SnsCommInfo)localObject1).uint32_seq.set(1234);
    sso2sns_0x3_blocklist.ReqBodyGetBlockList localReqBodyGetBlockList = new sso2sns_0x3_blocklist.ReqBodyGetBlockList();
    localReqBodyGetBlockList.uint64_uin.set(((Long)localObject2).longValue());
    localReqBodyGetBlockList.uint32_get_type.set(paramInt1);
    localReqBodyGetBlockList.uint32_start_pos.set(paramInt2);
    localReqBodyGetBlockList.uint32_want_num.set(1000);
    localReqBodyGetBlockList.fixed32_last_get_time.set(i);
    localObject2 = new sso2sns_0x3_blocklist.ReqBody();
    ((sso2sns_0x3_blocklist.ReqBody)localObject2).msg_body_get_blocklist.set(localReqBodyGetBlockList);
    localObject1 = a((sso2sns_comm_info.Sso2SnsCommInfo)localObject1, (sso2sns_0x3_blocklist.ReqBody)localObject2);
    localToServiceMsg.setTimeout(60000L);
    localToServiceMsg.putWupBuffer((byte[])localObject1);
    sendPbReq(localToServiceMsg);
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ((str == null) || (str.length() == 0)) {}
    do
    {
      return;
      if ("SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList".equalsIgnoreCase(str))
      {
        aw(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList".equalsIgnoreCase(str))
      {
        ax(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    } while (!"SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList".equalsIgnoreCase(str));
    ay(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(int paramInt1, long[] paramArrayOfLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_add><S> : msgType " + paramInt1 + ",uinList:" + Arrays.toString(paramArrayOfLong));
    }
    int i = paramArrayOfLong.length;
    if ((paramArrayOfLong == null) || (i <= 0)) {}
    ShieldOperationItem localShieldOperationItem;
    do
    {
      return;
      localShieldOperationItem = new ShieldOperationItem();
      localShieldOperationItem.opType = 2;
      localShieldOperationItem.source_id = ShieldListInfo.AIO_TYPE_2_SOURCE_ID(paramInt1);
      localShieldOperationItem.f = paramArrayOfLong;
      localShieldOperationItem.fromType = paramInt2;
    } while (localShieldOperationItem.source_id == -1);
    a(localShieldOperationItem);
  }
  
  public void aN(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_push><R><---handleShieldListOnlinePush.");
    }
    Object localObject1 = new SubMsgType0x30.MsgBody();
    try
    {
      paramArrayOfByte = (SubMsgType0x30.MsgBody)((SubMsgType0x30.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
      if ((paramArrayOfByte == null) || (!paramArrayOfByte.uint32_sub_cmd.has()) || (paramArrayOfByte.uint32_sub_cmd.get() != 1)) {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder().append("<---handleShieldListOnlinePush : msgBody is null or NotSupportSubCMd :");
          if (paramArrayOfByte == null)
          {
            paramArrayOfByte = "null";
            QLog.e("ShieldListHandler", 2, paramArrayOfByte);
          }
        }
        else
        {
          return;
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ShieldListHandler", 2, "<---handleShieldListOnlinePush : fail to parse SubMsgType0x30.");
          }
          paramArrayOfByte = null;
          continue;
          paramArrayOfByte = Integer.valueOf(paramArrayOfByte.uint32_sub_cmd.get());
        }
        if (paramArrayOfByte.msg_s2c_blocklist_notify.has())
        {
          paramArrayOfByte = (SubMsgType0x30.BlockListNotify)paramArrayOfByte.msg_s2c_blocklist_notify.get();
          localObject1 = paramArrayOfByte.rpt_msg_block_uin_info.get();
          paramArrayOfByte = paramArrayOfByte.rpt_uint64_del_uin.get();
          Object localObject2;
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (SubMsgType0x30.BlockUinInfo)((Iterator)localObject1).next();
              ShieldListInfo localShieldListInfo = new ShieldListInfo();
              localShieldListInfo.uin = String.valueOf(((SubMsgType0x30.BlockUinInfo)localObject2).uint64_block_uin.get());
              localShieldListInfo.source_id = ((SubMsgType0x30.BlockUinInfo)localObject2).uint32_source_id.get();
              localShieldListInfo.source_sub_id = ((SubMsgType0x30.BlockUinInfo)localObject2).uint32_source_sub_id.get();
              localShieldListInfo.flags = 1;
              if (QLog.isColorLevel()) {
                QLog.d("ShieldListHandler", 2, "<---handleShieldListOnlinePush : add: uin:" + localShieldListInfo.uin + ",source_id:" + localShieldListInfo.source_id);
              }
              this.ei.put(localShieldListInfo.uin, localShieldListInfo);
            }
          }
          if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
          {
            localObject1 = paramArrayOfByte.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              long l = ((Long)((Iterator)localObject1).next()).longValue();
              localObject2 = new ShieldListInfo();
              ((ShieldListInfo)localObject2).uin = String.valueOf(l);
              ((ShieldListInfo)localObject2).flags = 0;
              if (QLog.isColorLevel()) {
                QLog.d("ShieldListHandler", 2, "<---handleShieldListOnlinePush : del: uin:" + ((ShieldListInfo)localObject2).uin + ",source_id:" + ((ShieldListInfo)localObject2).source_id);
              }
              this.ei.put(((ShieldListInfo)localObject2).uin, localObject2);
            }
          }
          localObject1 = this.app.a();
          if (localObject1 != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ShieldListHandler", 2, "handleShieldListOnlinePush, removeFriendFromBlackList");
            }
            ((MessageHandler)localObject1).iX(paramArrayOfByte);
          }
        }
        if (!this.bJp)
        {
          cMu();
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ShieldListHandler", 2, "<---handleShieldListOnlinePush : is shield operating, put into cache.");
    }
  }
  
  public void b(int paramInt1, long[] paramArrayOfLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_del><S> : msgType:" + paramInt1 + ",uinList:" + Arrays.toString(paramArrayOfLong));
    }
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length <= 0)) {}
    ShieldOperationItem localShieldOperationItem;
    do
    {
      return;
      localShieldOperationItem = new ShieldOperationItem();
      localShieldOperationItem.opType = 3;
      localShieldOperationItem.source_id = ShieldListInfo.AIO_TYPE_2_SOURCE_ID(paramInt1);
      localShieldOperationItem.f = paramArrayOfLong;
      localShieldOperationItem.fromType = paramInt2;
    } while (localShieldOperationItem.source_id == -1);
    a(localShieldOperationItem);
  }
  
  public void cMr()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldListHandler", 2, "<shield_get><S> : sendGetShieldListReq");
    }
    ShieldOperationItem localShieldOperationItem = new ShieldOperationItem();
    localShieldOperationItem.opType = 1;
    localShieldOperationItem.f = null;
    a(localShieldOperationItem);
  }
  
  public void dI(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    long l = -1L;
    long[] arrayOfLong = new long[1];
    boolean bool;
    if (paramInt == 1006)
    {
      paramString = aqgv.x(this.app, paramString);
      if ((paramString == null) || (paramString.length() <= 0)) {
        bool = false;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShieldListHandler", 2, "<---handleSendMsgErrorWhileShield : msgType:" + paramInt + Arrays.toString(arrayOfLong) + ",hasUin:" + bool);
      }
      if (bool)
      {
        arrayOfLong[0] = l;
        paramString = new ShieldListInfo();
        paramString.uin = String.valueOf(l);
        paramString.source_id = ShieldListInfo.AIO_TYPE_2_SOURCE_ID(paramInt);
        paramString.source_sub_id = 0;
        paramString.flags = 1;
        localArrayList.add(paramString);
        ((aizg)this.app.getManager(16)).aq(localArrayList);
        a(true, paramString.source_id, arrayOfLong);
      }
      return;
      l = Long.valueOf(paramString).longValue();
      bool = true;
      continue;
      l = Long.valueOf(paramString).longValue();
      bool = true;
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return aclp.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ((str == null) || (str.length() == 0)) {}
    while ((!"SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList".equalsIgnoreCase(str)) && (!"SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList".equalsIgnoreCase(str)) && (!"SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList".equalsIgnoreCase(str))) {
      return;
    }
    boolean bool2 = false;
    if (paramFromServiceMsg.getResultCode() == 1000) {}
    for (;;)
    {
      boolean bool1;
      try
      {
        bool1 = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        if (bool1) {
          break;
        }
        cMt();
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ShieldListHandler", 2, "<---decodeSso2SnsCommInfo: exception.", paramToServiceMsg);
        bool1 = bool2;
        continue;
      }
      if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
      {
        av(paramToServiceMsg, paramFromServiceMsg);
        bool1 = bool2;
      }
      else
      {
        n(paramToServiceMsg, paramFromServiceMsg);
        bool1 = bool2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aclo
 * JD-Core Version:    0.7.0.1
 */