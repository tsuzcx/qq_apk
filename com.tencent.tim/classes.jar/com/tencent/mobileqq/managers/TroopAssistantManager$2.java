package com.tencent.mobileqq.managers;

import aizp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.List;
import jnm;
import jnm.d;
import tencent.im.oidb.cmd0x72d.cmd0x72d.ReqBody;

public class TroopAssistantManager$2
  implements Runnable
{
  public TroopAssistantManager$2(aizp paramaizp, QQAppInterface paramQQAppInterface, jnm.d paramd) {}
  
  public void run()
  {
    List localList = this.this$0.k(this.val$app);
    cmd0x72d.ReqBody localReqBody = new cmd0x72d.ReqBody();
    localReqBody.rpt_uint64_groupcode.set(localList);
    jnm.b(this.val$app, this.b, localReqBody.toByteArray(), "OidbSvc.0x72d_0", 1837, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TroopAssistantManager.2
 * JD-Core Version:    0.7.0.1
 */