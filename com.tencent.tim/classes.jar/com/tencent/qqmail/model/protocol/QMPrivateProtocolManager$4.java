package com.tencent.qqmail.model.protocol;

import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.CloudProtocolResult.QueryConfigUpdateRspForOC;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

class QMPrivateProtocolManager$4
  extends SimpleOnProtocolListener
{
  QMPrivateProtocolManager$4(QMPrivateProtocolManager paramQMPrivateProtocolManager) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMLog.log(4, "QMPrivateProtocolManager", "updateConfig error code: " + paramCloudProtocolResult.error_code_);
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      CloudProtocolResult.QueryConfigUpdateRspForOC[] arrayOfQueryConfigUpdateRspForOC = paramCloudProtocolResult.query_config_update_for_oc_list_;
      if ((arrayOfQueryConfigUpdateRspForOC != null) && (arrayOfQueryConfigUpdateRspForOC.length > 0))
      {
        paramCloudProtocolResult = new StringBuilder("updateConfig result");
        int j = arrayOfQueryConfigUpdateRspForOC.length;
        int i = 0;
        if (i < j)
        {
          CloudProtocolResult.QueryConfigUpdateRspForOC localQueryConfigUpdateRspForOC = arrayOfQueryConfigUpdateRspForOC[i];
          if (localQueryConfigUpdateRspForOC == null) {}
          for (;;)
          {
            i += 1;
            break;
            int k = localQueryConfigUpdateRspForOC.config_type_;
            String str = localQueryConfigUpdateRspForOC.new_config_version_;
            paramCloudProtocolResult.append(", [type:").append(k).append("/version:").append(str).append("/available:").append(localQueryConfigUpdateRspForOC.available_).append("]");
            if (localQueryConfigUpdateRspForOC.available_)
            {
              if (!StringExtention.isNullOrEmpty(str)) {
                SPManager.getEditor("user_info").putString("configtype_" + k, str).apply();
              }
              switch (k)
              {
              case 11: 
              case 14: 
              case 10: 
              case 12: 
              case 13: 
              case 15: 
              default: 
                break;
              case 1: 
                QMPrivateProtocolManager.access$300(this.this$0, localQueryConfigUpdateRspForOC);
                break;
              case 2: 
                QMPrivateProtocolManager.access$400(this.this$0, localQueryConfigUpdateRspForOC);
                break;
              case 3: 
                QMPrivateProtocolManager.access$500(this.this$0, localQueryConfigUpdateRspForOC);
                break;
              case 4: 
                QMPrivateProtocolManager.access$600(this.this$0, localQueryConfigUpdateRspForOC);
                break;
              case 6: 
                QMPrivateProtocolManager.access$700(this.this$0, localQueryConfigUpdateRspForOC);
                break;
              case 7: 
                QMPrivateProtocolManager.access$800(this.this$0, localQueryConfigUpdateRspForOC);
                break;
              case 8: 
                QMPrivateProtocolManager.access$900(this.this$0, localQueryConfigUpdateRspForOC);
                break;
              case 9: 
                QMPrivateProtocolManager.access$1000(this.this$0, localQueryConfigUpdateRspForOC);
                break;
              case 5: 
                QMPrivateProtocolManager.access$1100(this.this$0, localQueryConfigUpdateRspForOC);
                break;
              case 16: 
                QMPrivateProtocolManager.access$1200(this.this$0, localQueryConfigUpdateRspForOC);
                break;
              case 17: 
                QMPrivateProtocolManager.access$1300(this.this$0, localQueryConfigUpdateRspForOC);
              }
            }
          }
        }
        QMLog.log(4, "QMPrivateProtocolManager", paramCloudProtocolResult.toString());
        return;
      }
    }
    new QMUMAError(paramCloudProtocolResult.error_code_, "CloudProtocolService.QueryConfigUpdate");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.4
 * JD-Core Version:    0.7.0.1
 */