import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils.TroopPrivilegeCallback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public final class uhu
  extends ProtoUtils.TroopProtocolObserver
{
  public uhu(String paramString, Context paramContext, TroopNotificationUtils.TroopPrivilegeCallback paramTroopPrivilegeCallback, structmsg.StructMsg paramStructMsg) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    int j;
    int i;
    if (paramInt == 0)
    {
      for (paramBundle = new oidb_sso.OIDBSSOPkg();; paramBundle = (oidb_0x88d.GroupInfo)localRspGroupInfo.stgroupinfo.get())
      {
        try
        {
          paramArrayOfByte = (oidb_sso.OIDBSSOPkg)paramBundle.mergeFrom((byte[])paramArrayOfByte);
          if (paramArrayOfByte == null) {
            break label613;
          }
          j = paramArrayOfByte.uint32_result.get();
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.systemmsg.TroopRequestActivity", 2, "handle_oidb_0x88d_0|oidb_sso.OIDBSSOPkg.result " + j);
            i = j;
          }
          if ((i != 0) || (paramArrayOfByte == null) || (!paramArrayOfByte.bytes_bodybuffer.has()) || (paramArrayOfByte.bytes_bodybuffer.get() == null)) {
            break label608;
          }
          paramArrayOfByte = paramArrayOfByte.bytes_bodybuffer.get().toByteArray();
          for (;;)
          {
            try
            {
              paramBundle = new oidb_0x88d.RspBody();
              paramBundle.mergeFrom(paramArrayOfByte);
              if ((i == 0) || (!paramBundle.str_errorinfo.has())) {
                continue;
              }
              paramArrayOfByte = String.valueOf(paramBundle.str_errorinfo.get().toByteArray());
            }
            catch (Exception localException1)
            {
              List localList;
              int m;
              int n;
              oidb_0x88d.RspGroupInfo localRspGroupInfo;
              int k;
              boolean bool;
              paramArrayOfByte = null;
              j = i;
              paramBundle = paramArrayOfByte;
              i = j;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("Q.troopdisband.", 2, localException1.toString());
              paramBundle = paramArrayOfByte;
              i = j;
              continue;
              paramArrayOfByte = null;
              continue;
            }
            try
            {
              localList = paramBundle.stzrspgroupinfo.get();
              if (localList == null)
              {
                m = 0;
                paramBundle = null;
                n = 0;
                if ((paramBundle != null) || (n >= m)) {
                  continue;
                }
                j = i;
              }
            }
            catch (Exception localException2)
            {
              j = i;
              continue;
            }
            try
            {
              localRspGroupInfo = (oidb_0x88d.RspGroupInfo)localList.get(n);
              k = i;
              if (localRspGroupInfo == null) {
                continue;
              }
              j = i;
              bool = this.jdField_a_of_type_JavaLangString.equals(String.valueOf(localRspGroupInfo.uint64_group_code.get()));
              if (bool) {
                continue;
              }
            }
            catch (Exception localException3)
            {
              continue;
              i = k;
              continue;
            }
            n += 1;
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.systemmsg.TroopRequestActivity", 2, "handle_oidb_0x88d_0|oidb_sso parseFrom byte " + paramArrayOfByte.toString());
            }
            paramArrayOfByte = paramBundle;
            continue;
            m = localList.size();
          }
          j = i;
          i = localRspGroupInfo.uint32_result.get();
          k = i;
          if (i != 0) {
            break label596;
          }
        }
        j = i;
        k = i;
        if (!localRspGroupInfo.stgroupinfo.has()) {
          break label596;
        }
        j = i;
      }
      if (paramBundle != null)
      {
        j = i;
        if (paramBundle.uint32_app_privilege_flag.has())
        {
          j = i;
          k = paramBundle.uint32_app_privilege_flag.get();
          j = i;
          new Handler(this.jdField_a_of_type_AndroidContentContext.getMainLooper()).post(new uhv(this, k));
          label434:
          return;
        }
      }
      paramBundle = paramArrayOfByte;
    }
    for (;;)
    {
      new Handler(this.jdField_a_of_type_AndroidContentContext.getMainLooper()).post(new uhw(this, i, paramInt, paramBundle));
      if (!QLog.isColorLevel()) {
        break label434;
      }
      paramArrayOfByte = new StringBuilder(150);
      paramArrayOfByte.append("handle_oidb_0x88d_0").append("|result = ").append(i).append("|errorCode = ").append(paramInt).append("|troopuin = ").append(this.jdField_a_of_type_JavaLangString).append("|strErrorMsg = ").append(paramBundle);
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, paramArrayOfByte.toString());
      return;
      label596:
      label608:
      paramBundle = null;
      continue;
      label613:
      i = -1;
      break;
      paramBundle = null;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uhu
 * JD-Core Version:    0.7.0.1
 */