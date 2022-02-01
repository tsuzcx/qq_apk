package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import apbr;
import apca;
import apcc;
import apcd;
import apsv;
import aqha;
import aqju;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;

public class TroopFileItemOperation$10$1
  implements Runnable
{
  public TroopFileItemOperation$10$1(apcc paramapcc) {}
  
  public void run()
  {
    Object localObject = this.a.f.a(this.a.c.Id);
    if ((localObject != null) && (((TroopFileTransferManager.Item)localObject).ErrorCode == -136))
    {
      this.a.this$0.a(this.a.c, this.a.this$0.mActivity.getString(2131699983), this.a.this$0.mActivity.getString(2131699984));
      return;
    }
    int i = apca.a(this.a.this$0, false);
    apcd localapcd = new apcd(this);
    if (i == 1) {}
    for (localObject = apca.d(2131699610, new Object[] { apsv.oR(this.a.c.str_file_name), this.a.c.AV() });; localObject = apca.d(2131699916, new Object[] { apsv.oR(this.a.c.str_file_name) }))
    {
      aqha.a(this.a.this$0.mActivity, 230, apca.fK(2131699918), (String)localObject, 2131721058, 2131699917, localapcd, localapcd).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.10.1
 * JD-Core Version:    0.7.0.1
 */