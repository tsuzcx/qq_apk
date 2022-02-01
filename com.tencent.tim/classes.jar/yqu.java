import com.tencent.mobileqq.activity.contact.addfriendverifi.AddFriendBlockedInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xd7e.oidb_cmd0xd7e.ReqBody;
import tencent.im.oidb.cmd0xd82.oidb_cmd0xd82.ReqBody;
import tencent.im.oidb.cmd0xd82.oidb_cmd0xd82.RspBody;
import tencent.im.oidb.cmd0xd83.oidb_cmd0xd83.BlockedInfo;
import tencent.im.oidb.cmd0xd83.oidb_cmd0xd83.ReqBody;
import tencent.im.oidb.cmd0xd83.oidb_cmd0xd83.RspBody;
import tencent.im.oidb.cmd0xd86.oidb_cmd0xd86.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class yqu
  extends accg
{
  private yqv a;
  
  public yqu(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = ((yqv)paramQQAppInterface.getManager(332));
  }
  
  private void ba(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.handler", 1, "handleGetAddFriendBlockedRedPoint");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null)) {
      if (this.a != null) {
        this.a.AD(true);
      }
    }
    while (this.a == null) {
      return;
    }
    this.a.AD(paramFromServiceMsg.isSuccess());
  }
  
  private void bb(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.handler", 1, "handleGetAddFriendBlockedRedPoint");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null)) {
      if (this.a != null) {
        this.a.d(true, false, false, "");
      }
    }
    label45:
    while (!paramFromServiceMsg.isSuccess()) {
      return;
    }
    for (;;)
    {
      int j;
      long l;
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = new oidb_cmd0xd82.RspBody();
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        int i = paramFromServiceMsg.uint32_entrance.get();
        j = paramFromServiceMsg.uint32_redpoint.get();
        l = paramFromServiceMsg.uint64_blocked_uin.get();
        if (this.a == null) {
          break label45;
        }
        paramToServiceMsg = this.a;
        if (i != 1) {
          break label183;
        }
        bool1 = true;
      }
      catch (Exception paramToServiceMsg) {}
      paramToServiceMsg.d(true, bool1, bool2, String.valueOf(l));
      return;
      if (this.a == null) {
        break;
      }
      this.a.d(true, false, false, "");
      return;
      label183:
      boolean bool1 = false;
      while (j != 1)
      {
        bool2 = false;
        break;
      }
      boolean bool2 = true;
    }
  }
  
  private void bc(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.handler", 1, "handleGetAddFriendBlockedList");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null))
    {
      if (this.a != null)
      {
        this.a.g(false, false, "");
        this.a.a(false, null, "");
      }
      return;
    }
    Object localObject;
    for (;;)
    {
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          break;
        }
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = new oidb_cmd0xd83.RspBody();
        paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramObject = paramToServiceMsg.rpt_block_list.get();
        paramFromServiceMsg = new ArrayList();
        paramObject = paramObject.iterator();
        if (!paramObject.hasNext()) {
          break label369;
        }
        localObject = (oidb_cmd0xd83.BlockedInfo)paramObject.next();
        long l = ((oidb_cmd0xd83.BlockedInfo)localObject).uint64_uin.get();
        AddFriendBlockedInfo localAddFriendBlockedInfo = new AddFriendBlockedInfo();
        localAddFriendBlockedInfo.friendUin = String.valueOf(l);
        localAddFriendBlockedInfo.AI = ((oidb_cmd0xd83.BlockedInfo)localObject).bytes_nick.get().toStringUtf8();
        localAddFriendBlockedInfo.age = ((oidb_cmd0xd83.BlockedInfo)localObject).uint32_age.get();
        localAddFriendBlockedInfo.sex = ((oidb_cmd0xd83.BlockedInfo)localObject).uint32_sex.get();
        if (((oidb_cmd0xd83.BlockedInfo)localObject).uint32_has_read.get() != 1) {
          break label363;
        }
        bool = true;
        localAddFriendBlockedInfo.isRead = bool;
        localAddFriendBlockedInfo.aZx = ((oidb_cmd0xd83.BlockedInfo)localObject).bytes_source.get().toStringUtf8();
        localAddFriendBlockedInfo.Kx = ((oidb_cmd0xd83.BlockedInfo)localObject).uint32_time.get();
        localAddFriendBlockedInfo.caF = ((oidb_cmd0xd83.BlockedInfo)localObject).uint32_comm_frd.get();
        paramFromServiceMsg.add(localAddFriendBlockedInfo);
        if (!QLog.isDebugVersion()) {
          continue;
        }
        QLog.d("NewFriendVerification.handler", 2, " handleGetAddFriendBlockedList()--> blockedInfo =  " + localAddFriendBlockedInfo.toString());
        continue;
        if (this.a == null) {
          break;
        }
      }
      catch (Exception paramToServiceMsg) {}
      this.a.g(false, false, "");
      this.a.a(false, null, "");
      return;
      label363:
      bool = false;
    }
    label369:
    paramObject = paramToServiceMsg.bytes_cookies.get().toStringUtf8();
    int i = paramToServiceMsg.uint32_entrance.get();
    if (paramFromServiceMsg.size() > 0)
    {
      paramToServiceMsg = ((AddFriendBlockedInfo)paramFromServiceMsg.get(0)).friendUin;
      label412:
      if (this.a == null) {
        break label458;
      }
      localObject = this.a;
      if (i != 1) {
        break label460;
      }
    }
    label458:
    label460:
    for (boolean bool = true;; bool = false)
    {
      ((yqv)localObject).g(true, bool, paramToServiceMsg);
      this.a.a(true, paramFromServiceMsg, paramObject);
      return;
      paramToServiceMsg = "";
      break label412;
      break;
    }
  }
  
  private void bd(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.handler", 1, "handleReportAddFriendBlocked");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null)) {
      if (this.a != null) {
        this.a.AC(false);
      }
    }
    while (this.a == null) {
      return;
    }
    this.a.AC(paramFromServiceMsg.isSuccess());
  }
  
  protected void I(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      oidb_cmd0xd83.ReqBody localReqBody = new oidb_cmd0xd83.ReqBody();
      localReqBody.uint64_uin.set(Long.parseLong(paramString1));
      localReqBody.uint32_req_num.set(paramInt);
      localReqBody.bytes_cookies.set(ByteStringMicro.copyFromUtf8(paramString2));
      sendPbReq(makeOIDBPkg("OidbSvc.oidb_0xd83", 3459, 0, localReqBody.toByteArray()));
      return;
    }
    catch (NumberFormatException paramString1)
    {
      while (this.a == null) {}
      this.a.g(false, false, "");
      this.a.a(false, null, "");
    }
  }
  
  protected void c(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    try
    {
      oidb_cmd0xd86.ReqBody localReqBody = new oidb_cmd0xd86.ReqBody();
      localReqBody.uin.set(Long.parseLong(paramString1));
      localReqBody.blocked_uin.set(Long.parseLong(paramString2));
      localReqBody.source_id.set(paramInt1);
      localReqBody.sub_sourceid.set(paramInt2);
      localReqBody.group_uin.set(Long.parseLong(paramString3));
      sendPbReq(makeOIDBPkg("OidbSvc.oidb_0xd86", 3462, 0, localReqBody.toByteArray()));
      return;
    }
    catch (NumberFormatException paramString1)
    {
      while (this.a == null) {}
      this.a.AC(false);
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return yqy.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.oidb_0xd86".equals(paramFromServiceMsg.getServiceCmd())) {
      bd(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("OidbSvc.oidb_0xd83".equals(paramFromServiceMsg.getServiceCmd()))
      {
        bc(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.oidb_0xd82".equals(paramFromServiceMsg.getServiceCmd()))
      {
        bb(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.oidb_0xd7e".equals(paramFromServiceMsg.getServiceCmd()));
    ba(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  protected void zd(String paramString)
  {
    try
    {
      oidb_cmd0xd7e.ReqBody localReqBody = new oidb_cmd0xd7e.ReqBody();
      localReqBody.uin.set(Long.parseLong(paramString));
      sendPbReq(makeOIDBPkg("OidbSvc.oidb_0xd7e", 3454, 0, localReqBody.toByteArray()));
      return;
    }
    catch (NumberFormatException paramString)
    {
      while (this.a == null) {}
      this.a.AD(false);
    }
  }
  
  protected void ze(String paramString)
  {
    try
    {
      oidb_cmd0xd82.ReqBody localReqBody = new oidb_cmd0xd82.ReqBody();
      localReqBody.uin.set(Long.parseLong(paramString));
      sendPbReq(makeOIDBPkg("OidbSvc.oidb_0xd82", 3458, 0, localReqBody.toByteArray()));
      return;
    }
    catch (NumberFormatException paramString)
    {
      while (this.a == null) {}
      this.a.d(false, false, false, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yqu
 * JD-Core Version:    0.7.0.1
 */