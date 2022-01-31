package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;

public class ReqDpcInfoNewItem
  implements CheckUpdateItemInterface
{
  private static final String jdField_a_of_type_JavaLangString = "ReqDpcInfoNewItem";
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private boolean jdField_a_of_type_Boolean;
  
  public ReqDpcInfoNewItem(AppInterface paramAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReqDpcInfoNewItem", 2, "ReqDpcInfoNewItem getCheckUpdateItemData: isIncrementReq=" + this.jdField_a_of_type_Boolean);
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 117;
    localReqItem.cOperType = 1;
    byte[] arrayOfByte1 = DeviceProfileManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Boolean).toByteArray();
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 4];
    PkgTools.a(arrayOfByte2, 0, arrayOfByte1.length + 4);
    PkgTools.a(arrayOfByte2, 4, arrayOfByte1, arrayOfByte1.length);
    localReqItem.vecParam = arrayOfByte2;
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReqDpcInfoNewItem", 2, "ReqDpcInfoNewItem handleCheckUpdateItemData: item.eServiceID=" + paramRespItem.eServiceID + ", item.cResult=" + paramRespItem.cResult);
    }
    int j;
    byte[] arrayOfByte;
    int i;
    if (paramRespItem.eServiceID == 117)
    {
      j = 0;
      if (paramRespItem.cResult != 2) {
        break label225;
      }
      arrayOfByte = ProtoServlet.b(paramRespItem.vecUpdate);
      i = j;
      if (arrayOfByte != null) {
        paramRespItem = new ConfigurationService.RespGetConfig();
      }
    }
    for (;;)
    {
      try
      {
        paramRespItem.mergeFrom(arrayOfByte);
        i = j;
        if (paramRespItem != null)
        {
          i = j;
          if (paramRespItem.result.get() == 0)
          {
            if ((paramRespItem.config_list == null) || (paramRespItem.config_list.size() <= 0)) {
              continue;
            }
            DeviceProfileManager.a().a(paramRespItem, this.jdField_a_of_type_ComTencentCommonAppAppInterface.a());
            i = 1;
          }
        }
        if (i == 0) {
          DeviceProfileManager.a().a(4);
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramRespItem)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReqDpcInfoNewItem", 2, "error: " + paramRespItem.getMessage());
        }
        paramRespItem.printStackTrace();
        paramRespItem = null;
        continue;
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReqDpcInfoNewItem", 2, "respGetConfig has no contentlist");
        i = j;
        continue;
      }
      label225:
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("ReqDpcInfoNewItem", 2, "error happend item.cResult = " + paramRespItem.cResult);
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ReqDpcInfoNewItem
 * JD-Core Version:    0.7.0.1
 */