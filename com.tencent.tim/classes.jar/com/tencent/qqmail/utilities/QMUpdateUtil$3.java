package com.tencent.qqmail.utilities;

import android.content.Context;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.marcos.ChannelDefine;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.ui.QMUIHelper;

class QMUpdateUtil$3
  implements QMUIDialogAction.ActionListener
{
  QMUpdateUtil$3(QMUpdateUtil paramQMUpdateUtil, Context paramContext, String paramString) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    if (ChannelDefine.isGooglePlay())
    {
      IntentUtil.intentToMarketFromOutsideActivity(QMApplicationContext.sharedInstance(), QMApplicationContext.sharedInstance().getPackageName());
      if (QMUpdateUtil.access$300(this.this$0, QMUpdateUtil.access$400(this.this$0)))
      {
        QMUpdateUtil.access$200(this.this$0, QMUpdateUtil.access$100(this.this$0), false);
        return;
      }
      QMUpdateUtil.isTipsShowing = false;
      paramQMUIDialog.dismiss();
      return;
    }
    QMAttachUtils.goToDownload(this.val$context, this.val$updateUrl, 1, "", null);
    if (QMUpdateUtil.access$300(this.this$0, QMUpdateUtil.access$400(this.this$0)))
    {
      QMUpdateUtil.isTipsShowing = true;
      QMUpdateUtil.access$200(this.this$0, QMUpdateUtil.access$100(this.this$0), false);
      QMUIHelper.showToast(this.val$context, 2131696497, this.val$context.getString(2131690404));
      return;
    }
    QMUpdateUtil.isTipsShowing = false;
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.QMUpdateUtil.3
 * JD-Core Version:    0.7.0.1
 */