package com.tencent.qqmail.model.protocol;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.protocol.GeneralResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;

class QMPrivateProtocolManager$29
  extends SimpleOnProtocolListener
{
  QMPrivateProtocolManager$29(QMPrivateProtocolManager paramQMPrivateProtocolManager) {}
  
  public void OnCloudProtocolLogin(GeneralResult paramGeneralResult)
  {
    if (paramGeneralResult.result_type_ == 3) {
      if (QMApplicationContext.sharedInstance().getVid() == paramGeneralResult.uma_id_) {
        this.this$0.triggerWipeAppWatcher(0);
      }
    }
    while ((paramGeneralResult.result_type_ == 1) || (paramGeneralResult.result_type_ == 2) || (paramGeneralResult.result_type_ != 4)) {
      return;
    }
    this.this$0.handleUploadDebugLog(paramGeneralResult.debug_log_setting_duration, paramGeneralResult.debug_log_setting_params);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.29
 * JD-Core Version:    0.7.0.1
 */