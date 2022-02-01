import android.content.Intent;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.cmd0xe62.ReqBody;
import tencent.im.oidb.cmd0xe63.oidb_cmd0xe63.ReqBody;
import tencent.im.oidb.cmd0xe63.oidb_cmd0xe63.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class akty
  extends MSFServlet
{
  public static NewIntent a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), akty.class);
    localNewIntent.putExtra("param_online_status_request", 1);
    localNewIntent.putExtra("param_online_status_type", paramLong);
    paramQQAppInterface.startServlet(localNewIntent);
    return localNewIntent;
  }
  
  public static NewIntent a(QQAppInterface paramQQAppInterface, long paramLong, @NonNull OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), akty.class);
    localNewIntent.putExtra("param_online_status_request", 2);
    localNewIntent.putExtra("param_online_status_type", paramLong);
    localNewIntent.putExtra("online_status_permission_item", paramOnlineStatusPermissionItem);
    paramQQAppInterface.startServlet(localNewIntent);
    return localNewIntent;
  }
  
  private void m(Intent paramIntent, Packet paramPacket)
  {
    int i = 1;
    long l = paramIntent.getLongExtra("param_online_status_type", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "packModifyOnlineStatusPermission | onlineStatusType = ", Long.valueOf(l) });
    }
    Object localObject = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramIntent.getSerializableExtra("online_status_permission_item");
    paramIntent = new cmd0xe62.ReqBody();
    PBUInt32Field localPBUInt32Field = paramIntent.set_type;
    if (((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject).isAllHasPermission()) {}
    for (;;)
    {
      localPBUInt32Field.set(i);
      if (((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject).getPermissionUins() != null) {
        paramIntent.rpt_uint64_uin.set(((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject).getPermissionUins());
      }
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(3682);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(2);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
      paramIntent = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
      paramPacket.setSSOCommand("OidbSvc.0xe63_1");
      localObject = ByteBuffer.allocate(paramIntent.length + 4);
      ((ByteBuffer)localObject).putInt(paramIntent.length + 4);
      ((ByteBuffer)localObject).put(paramIntent);
      paramPacket.putSendData(((ByteBuffer)localObject).array());
      return;
      i = 2;
    }
  }
  
  private void n(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("param_online_status_type", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "packOnlineStatusPermission | onlineStatusType = ", Long.valueOf(l) });
    }
    paramIntent = new oidb_cmd0xe63.ReqBody();
    paramIntent.uint32_req_type.set(1);
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(3683);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
    paramIntent = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    paramPacket.setSSOCommand("OidbSvc.0xe63_1");
    localObject = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject).put(paramIntent);
    paramPacket.putSendData(((ByteBuffer)localObject).array());
  }
  
  private void w(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    long l = paramIntent.getLongExtra("param_online_status_type", 0L);
    OnlineStatusPermissionChecker.OnlineStatusPermissionItem localOnlineStatusPermissionItem = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramIntent.getSerializableExtra("online_status_permission_item");
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "handleModifyOnlineStatusPermission | onlineStatusType = ", Long.valueOf(l) });
    }
    if (paramFromServiceMsg.isSuccess()) {}
    for (;;)
    {
      try
      {
        localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg;
        int i;
        paramFromServiceMsg = null;
      }
      try
      {
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        localObject2 = new byte[paramFromServiceMsg.getInt() - 4];
        paramFromServiceMsg.get((byte[])localObject2);
        localOIDBSSOPkg.mergeFrom((byte[])localObject2);
        localObject2 = localOIDBSSOPkg;
        i = ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "handleModifyOnlineStatusPermission | result = ", Integer.valueOf(i) });
        }
        if (i != 0) {
          break;
        }
        paramFromServiceMsg = new OnlineStatusPermissionEntity();
        paramFromServiceMsg.onlineStateType = l;
        paramFromServiceMsg.allHasPermission = localOnlineStatusPermissionItem.isAllHasPermission();
        paramFromServiceMsg.hasPermissionList = localOnlineStatusPermissionItem.getPermissionUins();
        if ((getAppRuntime() instanceof QQAppInterface)) {
          ((aktw)((QQAppInterface)getAppRuntime()).getManager(370)).a(paramFromServiceMsg);
        }
        bool = true;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        for (;;)
        {
          paramFromServiceMsg = localInvalidProtocolBufferMicroException1;
          Object localObject1 = localInvalidProtocolBufferMicroException2;
        }
        bool = false;
        continue;
      }
      notifyObserver(paramIntent, 2, bool, null, aktx.class);
      return;
      Object localObject2 = paramFromServiceMsg;
      if (QLog.isColorLevel())
      {
        QLog.d("OnlineStatusPermissionServlet", 2, "handleModifyOnlineStatusPermission parseFrom byte", localInvalidProtocolBufferMicroException1);
        localObject2 = paramFromServiceMsg;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusPermissionServlet", 2, "handleOnlineStatusPermission | response.result = " + paramFromServiceMsg.getResultCode());
        }
        bool = false;
      }
    }
  }
  
  private void x(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    long l = paramIntent.getLongExtra("param_online_status_type", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "handleOnlineStatusPermission | onlineStatusType = ", Long.valueOf(l) });
    }
    if (paramFromServiceMsg.isSuccess()) {}
    for (;;)
    {
      try
      {
        Object localObject1 = new oidb_sso.OIDBSSOPkg();
        int i;
        localObject3 = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        for (;;)
        {
          try
          {
            paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
            localObject3 = new byte[paramFromServiceMsg.getInt() - 4];
            paramFromServiceMsg.get((byte[])localObject3);
            ((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom((byte[])localObject3);
            localObject3 = localObject1;
            i = ((oidb_sso.OIDBSSOPkg)localObject3).uint32_result.get();
            if (QLog.isColorLevel()) {
              QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "handleOnlineStatusPermission | result = ", Integer.valueOf(i) });
            }
            if ((i != 0) || (!((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.get() == null)) {
              continue;
            }
            localObject1 = ((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.get().toByteArray();
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
          {
            Object localObject3;
            boolean bool;
            paramFromServiceMsg = localInvalidProtocolBufferMicroException1;
            Object localObject2 = localInvalidProtocolBufferMicroException2;
            continue;
          }
          try
          {
            paramFromServiceMsg = new oidb_cmd0xe63.RspBody();
            paramFromServiceMsg.mergeFrom((byte[])localObject1);
            localObject1 = new OnlineStatusPermissionEntity();
            ((OnlineStatusPermissionEntity)localObject1).onlineStateType = l;
            if (paramFromServiceMsg.bool_online_status_visible_to_all_frd.has())
            {
              ((OnlineStatusPermissionEntity)localObject1).allHasPermission = paramFromServiceMsg.bool_online_status_visible_to_all_frd.get();
              if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "handleOnlineStatusPermission | entity.allHasPermission = ", Boolean.valueOf(((OnlineStatusPermissionEntity)localObject1).allHasPermission) });
              }
            }
            if (paramFromServiceMsg.rpt_uint64_uin_can_see_my_online_status.has())
            {
              if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusPermissionServlet", 2, "handleOnlineStatusPermission | entity.hasPermissionList.");
              }
              ((OnlineStatusPermissionEntity)localObject1).hasPermissionList = paramFromServiceMsg.rpt_uint64_uin_can_see_my_online_status.get();
            }
            if ((getAppRuntime() instanceof QQAppInterface)) {
              ((aktw)((QQAppInterface)getAppRuntime()).getManager(370)).a((OnlineStatusPermissionEntity)localObject1);
            }
            bool = true;
            notifyObserver(paramIntent, 1, bool, null, aktx.class);
            return;
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("OnlineStatusPermissionServlet", 2, "handleOnlineStatusPermission erro ", paramFromServiceMsg);
          }
        }
        localInvalidProtocolBufferMicroException1 = localInvalidProtocolBufferMicroException1;
        paramFromServiceMsg = null;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("OnlineStatusPermissionServlet", 2, "handleOnlineStatusPermission parseFrom byte", localInvalidProtocolBufferMicroException1);
        localObject3 = paramFromServiceMsg;
        continue;
        bool = false;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusPermissionServlet", 2, "handleOnlineStatusPermission | response.result = " + paramFromServiceMsg.getResultCode());
        }
        bool = false;
      }
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str2 = paramFromServiceMsg.getServiceCmd();
    String str1;
    if (QLog.isColorLevel())
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      StringBuilder localStringBuilder = new StringBuilder().append("OnlineStatusPermissionServlet onReceive:").append(str2).append(" is ");
      if (bool)
      {
        str1 = "";
        QLog.d("OnlineStatusPermissionServlet", 2, str1 + " success");
      }
    }
    else
    {
      if ((str2 != null) && (str2.equals("OidbSvc.0xe63_1"))) {
        break label100;
      }
    }
    label100:
    int i;
    do
    {
      return;
      str1 = "not";
      break;
      i = paramIntent.getIntExtra("param_online_status_request", 0);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "OnlineStatusPermissionServlet onReceive reqType", Integer.valueOf(i) });
      }
      if (i == 1)
      {
        x(paramIntent, paramFromServiceMsg);
        return;
      }
    } while (i != 2);
    w(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("param_online_status_request", 0);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusPermissionServlet", 2, new Object[] { "OnlineStatusPermissionServlet onSend reqType", Integer.valueOf(i) });
    }
    if (i == 1) {
      n(paramIntent, paramPacket);
    }
    while (i != 2) {
      return;
    }
    m(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akty
 * JD-Core Version:    0.7.0.1
 */