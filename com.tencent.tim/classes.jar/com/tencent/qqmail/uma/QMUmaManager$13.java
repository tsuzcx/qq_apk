package com.tencent.qqmail.uma;

import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.CloudProtocolResult.QueryConfigUpdateRspForOC;
import com.tencent.qqmail.protocol.CloudProtocolResult.QueryConfigUpdateRspForProtocol;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.protocol.UMA.AppMiscConfig;
import com.tencent.qqmail.protocol.UMA.AppNotNotify;
import com.tencent.qqmail.protocol.UMA.AppNotNotifyList;
import com.tencent.qqmail.protocol.UMA.AppNotToOpenFile;
import com.tencent.qqmail.protocol.UMA.AppNotToOpenFileList;
import com.tencent.qqmail.protocol.UMA.CmdLstADBWContactRsp;
import com.tencent.qqmail.protocol.UMA.CmdQueryConfigUpdateRsp;
import com.tencent.qqmail.protocol.UMA.CmdQueryConfigUpdateRsp_ResponseField;
import com.tencent.qqmail.protocol.UMA.DomainConfig;
import com.tencent.qqmail.protocol.UMA.DomainConfigCollection;
import com.tencent.qqmail.protocol.UMA.EmailAccountState;
import com.tencent.qqmail.protocol.UMA.EmailAccountStateCollection;
import com.tencent.qqmail.protocol.UMA.HolidayPicConfig;
import com.tencent.qqmail.protocol.UMA.HolidayPicConfigList;
import com.tencent.qqmail.protocol.UMA.PopularizeConfig;
import com.tencent.qqmail.protocol.UMA.PopularizeList;
import com.tencent.qqmail.protocol.UMA.PushConfig;
import com.tencent.qqmail.protocol.UMA.PushConfigList;
import com.tencent.qqmail.protocol.UMA.SpreadResult;
import com.tencent.qqmail.protocol.UMA.SpreadResultList;
import com.tencent.qqmail.protocol.UMA.UpdateInfo;
import com.tencent.qqmail.protocol.UMA.UserSetting;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.IOException;
import java.util.LinkedList;
import rx.functions.Action1;

class QMUmaManager$13
  implements Action1<QMUmaManager.QMUmaResult>
{
  QMUmaManager$13(QMUmaManager paramQMUmaManager) {}
  
  public void call(QMUmaManager.QMUmaResult paramQMUmaResult)
  {
    int i = 0;
    CloudProtocolResult localCloudProtocolResult = new CloudProtocolResult();
    for (;;)
    {
      int j;
      try
      {
        localCloudProtocolResult.error_code_ = 0;
        Object localObject1 = new CmdQueryConfigUpdateRsp().parseFrom(paramQMUmaResult.decryptedPkg);
        localCloudProtocolResult.query_config_update_rsp_ = new CloudProtocolResult.QueryConfigUpdateRspForProtocol();
        localCloudProtocolResult.query_config_update_rsp_.response_list_ = ((CmdQueryConfigUpdateRsp_ResponseField[])((CmdQueryConfigUpdateRsp)localObject1).response.toArray(new CmdQueryConfigUpdateRsp_ResponseField[((CmdQueryConfigUpdateRsp)localObject1).response.size()]));
        localCloudProtocolResult.query_config_update_for_oc_list_ = new CloudProtocolResult.QueryConfigUpdateRspForOC[localCloudProtocolResult.query_config_update_rsp_.response_list_.length];
        if (i < localCloudProtocolResult.query_config_update_rsp_.response_list_.length)
        {
          Object localObject2 = localCloudProtocolResult.query_config_update_rsp_.response_list_[i];
          localObject1 = new CloudProtocolResult.QueryConfigUpdateRspForOC();
          ((CloudProtocolResult.QueryConfigUpdateRspForOC)localObject1).config_type_ = ((CmdQueryConfigUpdateRsp_ResponseField)localObject2).config_type;
          ((CloudProtocolResult.QueryConfigUpdateRspForOC)localObject1).available_ = ((CmdQueryConfigUpdateRsp_ResponseField)localObject2).available;
          ((CloudProtocolResult.QueryConfigUpdateRspForOC)localObject1).new_config_digest_ = ((CmdQueryConfigUpdateRsp_ResponseField)localObject2).new_config_digest;
          ((CloudProtocolResult.QueryConfigUpdateRspForOC)localObject1).new_config_part_pos_ = ((CmdQueryConfigUpdateRsp_ResponseField)localObject2).new_config_part_pos;
          ((CloudProtocolResult.QueryConfigUpdateRspForOC)localObject1).new_config_size_ = ((CmdQueryConfigUpdateRsp_ResponseField)localObject2).new_config_size;
          ((CloudProtocolResult.QueryConfigUpdateRspForOC)localObject1).new_config_version_ = ((CmdQueryConfigUpdateRsp_ResponseField)localObject2).new_config_version;
          if (((CmdQueryConfigUpdateRsp_ResponseField)localObject2).new_config_part != null)
          {
            j = ((CmdQueryConfigUpdateRsp_ResponseField)localObject2).config_type;
            if (j != 1) {
              break label334;
            }
          }
          try
          {
            localObject2 = new DomainConfigCollection().parseFrom(((CmdQueryConfigUpdateRsp_ResponseField)localObject2).new_config_part.getBytes());
            ((CloudProtocolResult.QueryConfigUpdateRspForOC)localObject1).domain_config_list_ = ((DomainConfig[])((DomainConfigCollection)localObject2).config.toArray(new DomainConfig[((DomainConfigCollection)localObject2).config.size()]));
            localCloudProtocolResult.query_config_update_for_oc_list_[i] = localObject1;
            i += 1;
          }
          catch (IOException localIOException2)
          {
            QMLog.log(6, "uma", "uma update domain config error");
            continue;
          }
        }
        j = localIOException2.config_type;
      }
      catch (IOException localIOException1)
      {
        localCloudProtocolResult.error_code_ = -1;
        QMLog.log(5, "QMUmaManager", "general result.query_config_update_for_oc_list_ error: " + localIOException1.getMessage());
        paramQMUmaResult.session.callback.onCloudResult(localCloudProtocolResult);
        return;
      }
      label334:
      if (j == 2)
      {
        try
        {
          EmailAccountStateCollection localEmailAccountStateCollection = new EmailAccountStateCollection().parseFrom(localIOException2.new_config_part.getBytes());
          localIOException1.email_account_state_list_ = ((EmailAccountState[])localEmailAccountStateCollection.state.toArray(new EmailAccountState[localEmailAccountStateCollection.state.size()]));
        }
        catch (IOException localIOException3)
        {
          QMLog.log(6, "uma", "uma update email account state error");
        }
      }
      else
      {
        j = localIOException3.config_type;
        if (j == 3)
        {
          try
          {
            UserSetting localUserSetting = new UserSetting().parseFrom(localIOException3.new_config_part.getBytes());
            localIOException1.user_setting_list_ = new UserSetting[1];
            localIOException1.user_setting_list_[0] = localUserSetting;
          }
          catch (IOException localIOException4)
          {
            QMLog.log(6, "uma", "uma update UserSetting error");
          }
        }
        else
        {
          j = localIOException4.config_type;
          if (j == 4)
          {
            try
            {
              UpdateInfo localUpdateInfo = new UpdateInfo().parseFrom(localIOException4.new_config_part.getBytes());
              localIOException1.updateinfo_list_ = new UpdateInfo[1];
              localIOException1.updateinfo_list_[0] = localUpdateInfo;
            }
            catch (IOException localIOException5)
            {
              QMLog.log(6, "uma", "uma update VARCFG_APP_UPDATE error");
            }
          }
          else
          {
            j = localIOException5.config_type;
            if (j == 6)
            {
              try
              {
                localIOException1.app_misc_config_ = new AppMiscConfig().parseFrom(localIOException5.new_config_part.getBytes());
              }
              catch (IOException localIOException6)
              {
                QMLog.log(6, "uma", "uma update VARCFG_MISC_CONFIG error");
              }
            }
            else if (localIOException6.config_type == 5)
            {
              localIOException1.email_type_rule_ = localIOException6.new_config_part.toString();
            }
            else
            {
              j = localIOException6.config_type;
              if (j == 8)
              {
                try
                {
                  SpreadResultList localSpreadResultList = new SpreadResultList().parseFrom(localIOException6.new_config_part.getBytes());
                  localIOException1.spreadresult_list_ = ((SpreadResult[])localSpreadResultList.spread_result.toArray(new SpreadResult[localSpreadResultList.spread_result.size()]));
                }
                catch (IOException localIOException7)
                {
                  QMLog.log(6, "uma", "uma update VARCFG_SPREAD_LIST error");
                }
              }
              else
              {
                j = localIOException7.config_type;
                if (j == 9)
                {
                  try
                  {
                    HolidayPicConfigList localHolidayPicConfigList = new HolidayPicConfigList().parseFrom(localIOException7.new_config_part.getBytes());
                    localIOException1.holidaypic_list_ = ((HolidayPicConfig[])localHolidayPicConfigList.holiday_pic_config.toArray(new HolidayPicConfig[localHolidayPicConfigList.holiday_pic_config.size()]));
                  }
                  catch (IOException localIOException8)
                  {
                    QMLog.log(6, "uma", "uma update VARCFG_HOLIDAY_PIC error");
                  }
                }
                else
                {
                  j = localIOException8.config_type;
                  if (j == 11)
                  {
                    try
                    {
                      PopularizeList localPopularizeList = new PopularizeList().parseFrom(localIOException8.new_config_part.getBytes());
                      localIOException1.popularize_list_ = ((PopularizeConfig[])localPopularizeList.config.toArray(new PopularizeConfig[localPopularizeList.config.size()]));
                    }
                    catch (IOException localIOException9)
                    {
                      QMLog.log(6, "uma", "uma update VARCFG_POPULARIZE_CONFIG error");
                    }
                  }
                  else
                  {
                    j = localIOException9.config_type;
                    if (j == 14)
                    {
                      try
                      {
                        PushConfigList localPushConfigList = new PushConfigList().parseFrom(localIOException9.new_config_part.getBytes());
                        localIOException1.push_config_list_ = ((PushConfig[])localPushConfigList.config.toArray(new PushConfig[localPushConfigList.config.size()]));
                      }
                      catch (IOException localIOException10)
                      {
                        QMLog.log(6, "uma", "uma update VARCFG_PUSH_CONFIG error");
                      }
                    }
                    else if ((localIOException10.config_type != 12) && (localIOException10.config_type != 13) && (localIOException10.config_type != 15))
                    {
                      j = localIOException10.config_type;
                      if (j == 7)
                      {
                        try
                        {
                          localIOException1.adbw_contact_resp_ = new CmdLstADBWContactRsp().parseFrom(localIOException10.new_config_part.getBytes());
                        }
                        catch (IOException localIOException11)
                        {
                          QMLog.log(6, "uma", "uma update VARCFG_ADBW_LIST error");
                        }
                      }
                      else
                      {
                        j = localIOException11.config_type;
                        if (j == 17)
                        {
                          try
                          {
                            AppNotToOpenFileList localAppNotToOpenFileList = new AppNotToOpenFileList().parseFrom(localIOException11.new_config_part.getBytes());
                            localIOException1.app_not_to_open_file_list_ = ((AppNotToOpenFile[])localAppNotToOpenFileList.list.toArray(new AppNotToOpenFile[localAppNotToOpenFileList.list.size()]));
                          }
                          catch (IOException localIOException12)
                          {
                            QMLog.log(6, "uma", "uma update VARCFG_APP_NOT_TO_NOTIFY error");
                          }
                        }
                        else if (localIOException12.config_type != 10)
                        {
                          j = localIOException12.config_type;
                          if (j == 16) {
                            try
                            {
                              AppNotNotifyList localAppNotNotifyList = new AppNotNotifyList().parseFrom(localIOException12.new_config_part.getBytes());
                              localIOException1.app_not_notify_list_ = ((AppNotNotify[])localAppNotNotifyList.list.toArray(new AppNotNotify[localAppNotNotifyList.list.size()]));
                            }
                            catch (IOException localIOException13)
                            {
                              QMLog.log(6, "uma", "uma update VARCFG_APP_NOT_TO_NOTIFY error");
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.13
 * JD-Core Version:    0.7.0.1
 */