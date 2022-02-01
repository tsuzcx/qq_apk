package com.tencent.qqmail.attachment.activity;

import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;

class AttachSaveToWeiYunActivity$11
  implements Runnable
{
  AttachSaveToWeiYunActivity$11(AttachSaveToWeiYunActivity paramAttachSaveToWeiYunActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    AttachSaveToWeiYunActivity.access$1500(this.this$0).getViewTreeObserver().addOnGlobalLayoutListener(new AttachSaveToWeiYunActivity.11.1(this));
    QMLog.log(4, "AttachSaveToWeiYunActivity", "mail is BigAttach:" + AttachSaveToWeiYunActivity.access$200(this.this$0).isBigAttach() + ",errCode:" + this.val$errCode);
    if (AttachSaveToWeiYunActivity.access$200(this.this$0).isBigAttach())
    {
      if (this.val$errCode == AttachSaveToWeiYunActivity.ERR_SAVE_TO_WEIYUN_SUCCESS)
      {
        AttachSaveToWeiYunActivity.access$1600(this.this$0).setVisibility(0);
        AttachSaveToWeiYunActivity.access$1700(this.this$0).setVisibility(8);
        AttachSaveToWeiYunActivity.access$1800(this.this$0).setVisibility(8);
        AttachSaveToWeiYunActivity.access$1900(this.this$0).setText(this.val$showTips);
        AttachSaveToWeiYunActivity.access$2000(this.this$0).setVisibility(0);
        AttachSaveToWeiYunActivity.access$2100(this.this$0).setText(String.format(this.this$0.getString(2131690573), new Object[] { AttachSaveToWeiYunActivity.access$300(this.this$0) }));
        DataCollector.logEvent("Event_Weiyun_Success");
        return;
      }
      AttachSaveToWeiYunActivity.access$1700(this.this$0).setVisibility(0);
      AttachSaveToWeiYunActivity.access$1800(this.this$0).setVisibility(8);
      AttachSaveToWeiYunActivity.access$1600(this.this$0).setVisibility(8);
      AttachSaveToWeiYunActivity.access$2100(this.this$0).setVisibility(8);
      AttachSaveToWeiYunActivity.access$1300(this.this$0).setTag(this.val$showTips);
      AttachSaveToWeiYunActivity.access$2000(this.this$0).setVisibility(8);
      String str = AttachSaveToWeiYunActivity.access$1400(this.this$0, this.val$showTips);
      if (this.val$errCode == AttachSaveToWeiYunActivity.ERR_SAVE_TO_WEIYUN_FILE_IS_EXIST)
      {
        AttachSaveToWeiYunActivity.access$1700(this.this$0).setVisibility(8);
        AttachSaveToWeiYunActivity.access$1600(this.this$0).setVisibility(0);
        AttachSaveToWeiYunActivity.access$1900(this.this$0).setText(str);
        AttachSaveToWeiYunActivity.access$2100(this.this$0).setVisibility(0);
        AttachSaveToWeiYunActivity.access$2000(this.this$0).setVisibility(0);
        AttachSaveToWeiYunActivity.access$2100(this.this$0).setText(String.format(this.this$0.getString(2131690573), new Object[] { AttachSaveToWeiYunActivity.access$300(this.this$0) }));
        DataCollector.logEvent("Event_Weiyun_Success_File_Exist");
        return;
      }
      if (this.val$errCode == AttachSaveToWeiYunActivity.ERR_SAVE_TO_WEIYUN_ROOM_LIMIT)
      {
        AttachSaveToWeiYunActivity.access$1300(this.this$0).setText(str);
        DataCollector.logEvent("Event_Weiyun_Failed_Space_Not_Enough");
        return;
      }
      if (this.val$errCode == AttachSaveToWeiYunActivity.ERR_SAVE_TO_WEIYUN_STORAGE_LIMIT)
      {
        AttachSaveToWeiYunActivity.access$1300(this.this$0).setText(str);
        DataCollector.logEvent("Event_Weiyun_Failed_Directory_Full");
        return;
      }
      if (this.val$errCode == AttachSaveToWeiYunActivity.ERR_SAVE_TO_WEIYUN_TODAY_LIMIT)
      {
        AttachSaveToWeiYunActivity.access$2200(this.this$0).setVisibility(8);
        AttachSaveToWeiYunActivity.access$1300(this.this$0).setText(str);
        DataCollector.logEvent("Event_Weiyun_Failed_Size_Limit");
        return;
      }
      if (this.val$errCode == AttachSaveToWeiYunActivity.ERR_SAVE_TO_WEIYUN_FTN_FAIL)
      {
        QMAttachManager.sharedInstance().updateBigAttachExpire(AttachSaveToWeiYunActivity.access$200(this.this$0).getHashId(), -2L);
        QMNotification.postNotification("ftnfailexpired", QMNotification.createNotification(new Object[] { "ftnfailexpired", Long.valueOf(AttachSaveToWeiYunActivity.access$200(this.this$0).getHashId()) }));
        AttachSaveToWeiYunActivity.access$2200(this.this$0).setVisibility(8);
        AttachSaveToWeiYunActivity.access$1300(this.this$0).setText(str);
        DataCollector.logEvent("Event_Weiyun_Failed");
        return;
      }
      AttachSaveToWeiYunActivity.access$1300(this.this$0).setText(str);
      AttachSaveToWeiYunActivity.access$2200(this.this$0).setVisibility(0);
      DataCollector.logEvent("Event_Weiyun_Failed");
      return;
    }
    if (this.val$errCode == 0)
    {
      AttachSaveToWeiYunActivity.access$1600(this.this$0).setVisibility(0);
      AttachSaveToWeiYunActivity.access$1700(this.this$0).setVisibility(8);
      AttachSaveToWeiYunActivity.access$1800(this.this$0).setVisibility(8);
      AttachSaveToWeiYunActivity.access$2000(this.this$0).setVisibility(0);
      AttachSaveToWeiYunActivity.access$2100(this.this$0).setText(String.format(this.this$0.getString(2131690573), new Object[] { AttachSaveToWeiYunActivity.access$300(this.this$0) }));
      DataCollector.logEvent("Event_Weiyun_Success");
      return;
    }
    AttachSaveToWeiYunActivity.access$1700(this.this$0).setVisibility(0);
    AttachSaveToWeiYunActivity.access$1600(this.this$0).setVisibility(8);
    AttachSaveToWeiYunActivity.access$1800(this.this$0).setVisibility(8);
    AttachSaveToWeiYunActivity.access$2100(this.this$0).setVisibility(8);
    AttachSaveToWeiYunActivity.access$2200(this.this$0).setVisibility(0);
    DataCollector.logEvent("Event_Weiyun_Failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachSaveToWeiYunActivity.11
 * JD-Core Version:    0.7.0.1
 */