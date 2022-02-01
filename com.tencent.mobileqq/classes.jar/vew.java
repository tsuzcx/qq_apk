import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCirclePrivateMsgShow.StChangePMSettingRsp;
import qqcircle.QQCirclePrivateMsgShow.StFuelCostRange;
import qqcircle.QQCirclePrivateMsgShow.StPMSettingData;

class vew
  implements Observer<vxq<QQCirclePrivateMsgShow.StChangePMSettingRsp>>
{
  vew(veu paramveu) {}
  
  public void a(@Nullable vxq<QQCirclePrivateMsgShow.StChangePMSettingRsp> paramvxq)
  {
    if ((paramvxq != null) && (paramvxq.a() == 3)) {
      QLog.e("QCirclePrivateMessageSettingContentPart", 1, "onChanged() return success！ retCode : " + ((QQCirclePrivateMsgShow.StChangePMSettingRsp)paramvxq.a()).errCode.get() + " , errMsg : " + ((QQCirclePrivateMsgShow.StChangePMSettingRsp)paramvxq.a()).errMsg.get());
    }
    while ((paramvxq == null) || (paramvxq.a() != 4)) {
      try
      {
        veu.a(this.a, (QQCirclePrivateMsgShow.StPMSettingData)new QQCirclePrivateMsgShow.StPMSettingData().mergeFrom(((QQCirclePrivateMsgShow.StPMSettingData)((QQCirclePrivateMsgShow.StChangePMSettingRsp)paramvxq.a()).setting.get()).toByteArray()));
        veu.a(this.a, (QQCirclePrivateMsgShow.StFuelCostRange)((QQCirclePrivateMsgShow.StChangePMSettingRsp)paramvxq.a()).fuelCostRange.get());
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
      }
    }
    veu.a(this.a, paramvxq.a(), paramvxq.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vew
 * JD-Core Version:    0.7.0.1
 */