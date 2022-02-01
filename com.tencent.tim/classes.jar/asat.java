import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.oidb_0xc05.GetAuthAppListReq;
import tencent.im.oidb.oidb_0xc05.GetAuthAppListRsp;
import tencent.im.oidb.oidb_0xc05.ReqBody;
import tencent.im.oidb.oidb_0xc05.RspBody;
import tencent.im.oidb.oidb_0xccd.ReqBody;
import tencent.im.oidb.oidb_0xccd.Result;
import tencent.im.oidb.oidb_0xccd.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.oidb.qqconnect.Appinfo;

public final class asat
  extends accg
{
  private final List<qqconnect.Appinfo> JG = new ArrayList(10);
  private final List<AppInfo> JH = new ArrayList(10);
  
  public asat(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void kG(int paramInt1, int paramInt2)
  {
    Object localObject1 = new oidb_0xc05.ReqBody();
    Object localObject2 = new oidb_0xc05.GetAuthAppListReq();
    ((oidb_0xc05.GetAuthAppListReq)localObject2).start.set(paramInt1);
    ((oidb_0xc05.GetAuthAppListReq)localObject2).limit.set(paramInt2);
    ((oidb_0xc05.ReqBody)localObject1).get_auth_app_list_req.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(3077);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xc05.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0xc05");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putInt("req_index", paramInt1);
    ((ToServiceMsg)localObject1).extraData.putInt("req_page_size", paramInt2);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  private void lm(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = "";
    int i;
    if (paramFromServiceMsg.isSuccess())
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenAgentHandler", 2, "handleGetAuthorizeAppList");
      }
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = paramObject;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OpenAgentHandler", 2, "handleGetAuthorizeAppList, parsed pkg failed", paramObject);
          }
        }
      }
      i = -1;
      if (paramFromServiceMsg.uint32_result.has()) {
        i = paramFromServiceMsg.uint32_result.get();
      }
      if ((i == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
      {
        paramObject = new oidb_0xc05.RspBody();
        try
        {
          paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          i = 1;
        }
        catch (Exception paramFromServiceMsg)
        {
          for (;;)
          {
            int j;
            if (QLog.isColorLevel()) {
              QLog.d("OpenAgentHandler", 2, "handleGetAuthorizeAppList, parsed rsp failed", paramFromServiceMsg);
            }
            i = 0;
            continue;
            paramToServiceMsg = new ArrayList(this.JG.size());
            paramObject = this.JG.iterator();
            while (paramObject.hasNext()) {
              paramToServiceMsg.add(new AppInfo((qqconnect.Appinfo)paramObject.next()));
            }
            this.JG.clear();
            notifyUI(0, true, paramToServiceMsg);
            continue;
            paramToServiceMsg = paramFromServiceMsg;
            i = 0;
            continue;
            paramFromServiceMsg = "";
          }
        }
        if (i != 0) {
          if (paramObject.wording.has())
          {
            paramFromServiceMsg = paramObject.wording.get();
            if (paramObject.get_auth_app_list_rsp.has())
            {
              paramObject = paramObject.get_auth_app_list_rsp;
              localObject = paramObject.appinfos.get();
              if (localObject != null)
              {
                this.JG.addAll((Collection)localObject);
                i = paramToServiceMsg.extraData.getInt("req_index");
                j = paramToServiceMsg.extraData.getInt("req_page_size");
                if (i + j <= paramObject.total_count.get())
                {
                  kG(i + j, 10);
                  paramToServiceMsg = paramFromServiceMsg;
                  i = 1;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        this.JG.clear();
        notifyUI(0, false, paramToServiceMsg);
      }
      return;
      i = 0;
      paramToServiceMsg = (ToServiceMsg)localObject;
    }
  }
  
  private void ln(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if (paramFromServiceMsg.isSuccess())
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenAgentHandler", 2, "handleDelAppAuthrize");
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OpenAgentHandler", 2, "handleDelAppAuthrize, parsed pkg failed", paramFromServiceMsg);
          }
        }
      }
      i = -1;
      if (paramToServiceMsg.uint32_result.has()) {
        i = paramToServiceMsg.uint32_result.get();
      }
      if ((i == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
      {
        paramFromServiceMsg = new oidb_0xccd.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          i = 1;
        }
        catch (Exception paramToServiceMsg)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("OpenAgentHandler", 2, "handleGetAuthorizeAppList, parsed rsp failed", paramToServiceMsg);
            }
            i = 0;
          }
          notifyUI(1, true, paramToServiceMsg);
          this.JH.clear();
          i = 1;
        }
        if ((i != 0) && (paramFromServiceMsg.errcode.get() == 0))
        {
          paramToServiceMsg = new ArrayList(this.JH.size());
          paramFromServiceMsg = paramFromServiceMsg.Results.get();
          if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.isEmpty()))
          {
            paramFromServiceMsg = paramFromServiceMsg.iterator();
            while (paramFromServiceMsg.hasNext())
            {
              paramObject = (oidb_0xccd.Result)paramFromServiceMsg.next();
              if (paramObject.errcode.get() == 0)
              {
                i = paramObject.uint32_appid.get();
                paramObject = this.JH.iterator();
                while (paramObject.hasNext())
                {
                  AppInfo localAppInfo = (AppInfo)paramObject.next();
                  if (localAppInfo.getId() == i) {
                    paramToServiceMsg.add(localAppInfo);
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        this.JH.clear();
        notifyUI(1, false, "");
      }
      return;
      i = 0;
    }
  }
  
  public void emy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenAgentHandler", 2, "getAuthorizedAppList");
    }
    kG(0, 10);
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xc05");
      this.allowCmdSet.add("OidbSvc.0xccd");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  public void np(List<AppInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("deleteAppAuthorize, ");
      if (paramList == null) {
        break label131;
      }
    }
    label131:
    for (Object localObject1 = "size=" + paramList.size();; localObject1 = "apps=null")
    {
      QLog.d("OpenAgentHandler", 2, (String)localObject1);
      localObject1 = new ArrayList(paramList.size());
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AppInfo localAppInfo = (AppInfo)((Iterator)localObject2).next();
        if (localAppInfo.getId() > 0) {
          ((List)localObject1).add(Integer.valueOf(localAppInfo.getId()));
        }
      }
    }
    Object localObject2 = new oidb_0xccd.ReqBody();
    ((oidb_0xccd.ReqBody)localObject2).uint32_appids.set((List)localObject1);
    ((oidb_0xccd.ReqBody)localObject2).platform.set(1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(3277);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xccd.ReqBody)localObject2).toByteArray()));
    localObject2 = createToServiceMsg("OidbSvc.0xccd");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    this.JH.addAll(paramList);
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return asau.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      if (QLog.isColorLevel()) {
        QLog.d("OpenAgentHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
    }
    do
    {
      return;
      if ("OidbSvc.0xc05".equals(paramFromServiceMsg.getServiceCmd()))
      {
        lm(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xccd".equals(paramFromServiceMsg.getServiceCmd()));
    ln(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asat
 * JD-Core Version:    0.7.0.1
 */