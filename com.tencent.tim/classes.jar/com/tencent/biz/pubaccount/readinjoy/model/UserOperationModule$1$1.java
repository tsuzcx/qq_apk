package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Iterator;
import java.util.List;
import lbz;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.OneFollowOperationResult;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.RspFollowOperationResult;

class UserOperationModule$1$1
  implements Runnable
{
  UserOperationModule$1$1(UserOperationModule.1 param1) {}
  
  public void run()
  {
    Iterator localIterator = this.a.a.rpt_follow_operation_result.get().iterator();
    while (localIterator.hasNext())
    {
      oidb_cmd0x978.OneFollowOperationResult localOneFollowOperationResult = (oidb_cmd0x978.OneFollowOperationResult)localIterator.next();
      lbz.a().ab(localOneFollowOperationResult.uint64_dst_uin.get(), localOneFollowOperationResult.enum_follow_status.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.1.1
 * JD-Core Version:    0.7.0.1
 */