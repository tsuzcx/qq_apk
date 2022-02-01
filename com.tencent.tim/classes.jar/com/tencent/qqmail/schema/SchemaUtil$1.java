package com.tencent.qqmail.schema;

import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.protocol.CloudProtocolInfo;
import com.tencent.qqmail.protocol.CloudProtocolService;
import com.tencent.qqmail.protocol.UMA.CheckUpgradeReq;

final class SchemaUtil$1
  implements Runnable
{
  public void run()
  {
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    CheckUpgradeReq localCheckUpgradeReq = new CheckUpgradeReq();
    localCheckUpgradeReq.version = new ByteString(AppConfig.getCodeVersion().getBytes());
    localCloudProtocolInfo.check_upgrade_req_ = localCheckUpgradeReq;
    CloudProtocolService.CheckUpgrade(localCloudProtocolInfo, new SchemaUtil.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaUtil.1
 * JD-Core Version:    0.7.0.1
 */