package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import lcc;
import lhm;
import ljc;
import ljc.a;
import ljc.b;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.RspFollowOperationResult;

public class UserOperationModule$1
  implements Runnable
{
  public UserOperationModule$1(ljc paramljc, ArrayList paramArrayList, oidb_cmd0x978.RspFollowOperationResult paramRspFollowOperationResult, ljc.a parama) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.kK.size())
    {
      lcc.a().W(((lhm)this.kK.get(i)).ur, ((lhm)this.kK.get(i)).isFollowed);
      i += 1;
    }
    ThreadManager.post(new UserOperationModule.1.1(this), 5, null, true);
    ((ljc.b)this.jdField_a_of_type_Ljc$a).a(true, this.kK, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.1
 * JD-Core Version:    0.7.0.1
 */