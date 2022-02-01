package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.protocol.UMA.CmdQueryEmailTypeRsp.EmailTypeInfo;

class QMSpamTypeManager$2
  extends SimpleOnProtocolListener
{
  QMSpamTypeManager$2(QMSpamTypeManager paramQMSpamTypeManager, Runnable paramRunnable) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      if (paramCloudProtocolResult.email_type_info_list_ != null)
      {
        CmdQueryEmailTypeRsp.EmailTypeInfo[] arrayOfEmailTypeInfo = paramCloudProtocolResult.email_type_info_list_;
        int j = arrayOfEmailTypeInfo.length;
        int i = 0;
        while (i < j)
        {
          CmdQueryEmailTypeRsp.EmailTypeInfo localEmailTypeInfo = arrayOfEmailTypeInfo[i];
          if ((localEmailTypeInfo.rule_value != null) && (!localEmailTypeInfo.rule_value.equals(""))) {
            QMSpamTypeManager.access$200(this.this$0, localEmailTypeInfo.rule_value, localEmailTypeInfo.type, localEmailTypeInfo.rule_key, localEmailTypeInfo.rule_mode);
          }
          i += 1;
        }
      }
      if (this.val$callback != null) {
        this.val$callback.run();
      }
    }
    super.onCloudResult(paramCloudProtocolResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMSpamTypeManager.2
 * JD-Core Version:    0.7.0.1
 */