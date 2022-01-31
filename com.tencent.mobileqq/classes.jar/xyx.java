import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.activity.selectmember.TroopListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;

class xyx
  implements Runnable
{
  xyx(xyw paramxyw, QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, Bundle paramBundle, Handler paramHandler) {}
  
  public void run()
  {
    try
    {
      TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      Object localObject = new oidb_0x88d.RspBody();
      ((oidb_0x88d.RspBody)localObject).mergeFrom(this.jdField_a_of_type_ArrayOfByte);
      if (((oidb_0x88d.RspBody)localObject).stzrspgroupinfo.has())
      {
        localObject = ((oidb_0x88d.RspBody)localObject).stzrspgroupinfo.get();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          int i = 0;
          while (i < ((List)localObject).size())
          {
            oidb_0x88d.RspGroupInfo localRspGroupInfo = (oidb_0x88d.RspGroupInfo)((List)localObject).get(i);
            if (localRspGroupInfo.uint32_result.get() == 0)
            {
              TroopInfo localTroopInfo = localTroopManager.a(localRspGroupInfo.uint64_group_code.get() + "");
              localTroopInfo.troopPrivilegeFlag = ((oidb_0x88d.GroupInfo)localRspGroupInfo.stgroupinfo.get()).uint32_app_privilege_flag.get();
              localTroopManager.b(localTroopInfo);
            }
            i += 1;
          }
        }
      }
      ArrayList localArrayList;
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      localArrayList = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("TroopList");
      if (localArrayList != null)
      {
        TroopListAdapter.a((QQAppInterface)TroopListAdapter.a(this.jdField_a_of_type_Xyw.a).b.get(), TroopListAdapter.a(this.jdField_a_of_type_Xyw.a), localArrayList);
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new xyy(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xyx
 * JD-Core Version:    0.7.0.1
 */