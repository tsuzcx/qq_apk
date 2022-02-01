import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCirclePrivateMsgShow.StChangePMSettingRsp;
import qqcircle.QQCirclePrivateMsgShow.StFuelCostRange;
import qqcircle.QQCirclePrivateMsgShow.StPMSettingData;

class vcs
  implements Observer<vup<QQCirclePrivateMsgShow.StChangePMSettingRsp>>
{
  vcs(vcq paramvcq) {}
  
  public void a(@Nullable vup<QQCirclePrivateMsgShow.StChangePMSettingRsp> paramvup)
  {
    if ((paramvup != null) && (paramvup.a() == 3)) {
      QLog.e("QCirclePrivateMessageSettingContentPart", 1, "onChanged() return success！ retCode : " + ((QQCirclePrivateMsgShow.StChangePMSettingRsp)paramvup.a()).errCode.get() + " , errMsg : " + ((QQCirclePrivateMsgShow.StChangePMSettingRsp)paramvup.a()).errMsg.get());
    }
    while ((paramvup == null) || (paramvup.a() != 4)) {
      try
      {
        vcq.a(this.a, (QQCirclePrivateMsgShow.StPMSettingData)new QQCirclePrivateMsgShow.StPMSettingData().mergeFrom(((QQCirclePrivateMsgShow.StPMSettingData)((QQCirclePrivateMsgShow.StChangePMSettingRsp)paramvup.a()).setting.get()).toByteArray()));
        vcq.a(this.a, (QQCirclePrivateMsgShow.StFuelCostRange)((QQCirclePrivateMsgShow.StChangePMSettingRsp)paramvup.a()).fuelCostRange.get());
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
    vcq.a(this.a, paramvup.a(), paramvup.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcs
 * JD-Core Version:    0.7.0.1
 */