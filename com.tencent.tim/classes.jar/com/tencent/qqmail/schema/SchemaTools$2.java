package com.tencent.qqmail.schema;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;

class SchemaTools$2
  extends SimpleOnProtocolListener
{
  SchemaTools$2(SchemaTools paramSchemaTools) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    if ((paramCloudProtocolResult.error_code_ == 0) && (paramCloudProtocolResult.push_config_handle_resp_ != null)) {
      QMLog.log(4, "SchemaTools", "handle pushconfig check app install success.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaTools.2
 * JD-Core Version:    0.7.0.1
 */