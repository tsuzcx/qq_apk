package com.tencent.mobileqq.emosm.favroaming;

import afhl;
import afhr;
import android.os.Bundle;
import eipc.EIPCResult;

public class EmoticonIPCModule$1
  implements Runnable
{
  public EmoticonIPCModule$1(afhr paramafhr, Bundle paramBundle, String paramString, afhl paramafhl, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.val$params.getString("pic_md5");
    if ("action_group_emo_big_pic_add_fav".equals(this.val$action)) {
      if (!this.b.lR((String)localObject))
      {
        localObject = EIPCResult.createResult(-102, null);
        this.this$0.callbackResult(this.val$callbackId, (EIPCResult)localObject);
      }
    }
    while (!"action_group_emo_big_pic_upload_wy".equals(this.val$action)) {
      return;
    }
    this.b.HU((String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonIPCModule.1
 * JD-Core Version:    0.7.0.1
 */