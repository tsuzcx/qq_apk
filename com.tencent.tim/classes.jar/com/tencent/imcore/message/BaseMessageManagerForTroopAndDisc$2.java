package com.tencent.imcore.message;

import acms;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import java.util.ArrayList;
import tnu;

public class BaseMessageManagerForTroopAndDisc$2
  implements Runnable
{
  public BaseMessageManagerForTroopAndDisc$2(tnu paramtnu, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject = (acms)this.this$0.app.getBusinessHandler(20);
    if (localObject != null)
    {
      localObject = ((acms)localObject).a();
      if (localObject != null) {
        ((TroopBatchAddFriendMgr)localObject).fe(this.oF);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.2
 * JD-Core Version:    0.7.0.1
 */