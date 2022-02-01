import KQQ.ReqItem;
import KQQ.RespItem;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;

public class ackz
  implements andh
{
  private AppInterface app;
  
  public ackz(AppInterface paramAppInterface)
  {
    this.app = paramAppInterface;
  }
  
  public ReqItem a(int paramInt)
  {
    QLog.i("ReqDpcInfoNewItem", 1, "getCheckUpdateItemData");
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 117;
    localReqItem.cOperType = 1;
    byte[] arrayOfByte1 = DeviceProfileManager.a(this.app).toByteArray();
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 4];
    aqoj.DWord2Byte(arrayOfByte2, 0, arrayOfByte1.length + 4);
    aqoj.b(arrayOfByte2, 4, arrayOfByte1, arrayOfByte1.length);
    localReqItem.vecParam = arrayOfByte2;
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    QLog.i("ReqDpcInfoNewItem", 1, "handleCheckUpdateItemData" + paramRespItem.cResult);
    byte[] arrayOfByte;
    int i;
    if (paramRespItem.eServiceID == 117)
    {
      if (paramRespItem.cResult != 2) {
        break label224;
      }
      arrayOfByte = aqnv.J(paramRespItem.vecUpdate);
      if (arrayOfByte != null) {
        paramRespItem = new ConfigurationService.RespGetConfig();
      }
    }
    else
    {
      try
      {
        paramRespItem.mergeFrom(arrayOfByte);
        if ((paramRespItem != null) && (paramRespItem.result.get() == 0)) {
          if ((paramRespItem.config_list != null) && (paramRespItem.config_list.size() > 0))
          {
            DeviceProfileManager.a().a(paramRespItem, this.app.getCurrentAccountUin());
            i = 1;
            if (i == 0) {
              DeviceProfileManager.a().IQ(4);
            }
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramRespItem)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ReqDpcInfoNewItem", 2, "error: " + paramRespItem.getMessage());
          }
          paramRespItem.printStackTrace();
          paramRespItem = null;
        }
        QLog.i("ReqDpcInfoNewItem", 1, "respGetConfig has no contentlist");
        if ((this.app instanceof QQAppInterface)) {
          ((pma)((QQAppInterface)this.app).getBusinessHandler(98)).notifyUI(1023, true, Boolean.valueOf(false));
        }
      }
    }
    for (;;)
    {
      i = 0;
      break;
      label224:
      QLog.i("ReqDpcInfoNewItem", 1, "error happend item.cResult = " + paramRespItem.cResult);
    }
  }
  
  public int mT()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ackz
 * JD-Core Version:    0.7.0.1
 */