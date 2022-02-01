package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import com.tencent.qqmini.sdk.widget.MiniToast;

class ShareManager$1$1
  implements Runnable
{
  ShareManager$1$1(ShareManager.1 param1, long paramLong, String paramString) {}
  
  public void run()
  {
    if ((this.val$finalErrCode == -100070004L) || (this.val$finalErrCode == -1000710003L))
    {
      DialogUtil.createCustomDialog(this.this$1.val$shareData.fromActivity, 230, "分享失败", this.val$finalErrMsg, new ShareManager.1.1.1(this), null).show();
      return;
    }
    MiniToast.makeText(this.this$1.val$shareData.fromActivity, 1, "小程序分享失败，参数错误", 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.ShareManager.1.1
 * JD-Core Version:    0.7.0.1
 */