package com.tencent.mobileqq.activity.selectmember;

import aayq;
import aayr;
import android.os.Bundle;
import android.os.Handler;
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
import jnm.d;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;

public class TroopListAdapter$1$1
  implements Runnable
{
  public TroopListAdapter$1$1(aayr paramaayr, QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, Bundle paramBundle, Handler paramHandler) {}
  
  public void run()
  {
    try
    {
      TroopManager localTroopManager = (TroopManager)this.val$app.getManager(52);
      Object localObject = new oidb_0x88d.RspBody();
      ((oidb_0x88d.RspBody)localObject).mergeFrom(this.cF);
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
              TroopInfo localTroopInfo = localTroopManager.b(localRspGroupInfo.uint64_group_code.get() + "");
              localTroopInfo.troopPrivilegeFlag = ((oidb_0x88d.GroupInfo)localRspGroupInfo.stgroupinfo.get()).uint32_app_privilege_flag.get();
              localTroopManager.i(localTroopInfo);
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
      localArrayList = this.aq.getStringArrayList("TroopList");
      if (localArrayList != null)
      {
        aayq.a((QQAppInterface)aayq.a(this.a.a).n.get(), aayq.a(this.a.a), localArrayList);
        return;
      }
      this.val$handler.post(new TroopListAdapter.1.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */