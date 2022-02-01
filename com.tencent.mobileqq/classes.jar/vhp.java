import com.tencent.biz.qcircleshadow.remoteCheck.QCircleGetRainBowRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData;
import qqcircle.QQCircleConfig.GetRainbowTableConfigRsp;

class vhp
  implements VSDispatchObserver.onVSRspCallBack<QQCircleConfig.GetRainbowTableConfigRsp>
{
  vhp(vho paramvho, QCircleGetRainBowRequest paramQCircleGetRainBowRequest) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleConfig.GetRainbowTableConfigRsp paramGetRainbowTableConfigRsp)
  {
    QLog.i("QCirclePluginManager", 1, "traceId:" + this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCircleGetRainBowRequest.getTraceId() + " retcode:" + paramLong);
    if (paramBoolean)
    {
      vho.a(this.jdField_a_of_type_Vho, paramGetRainbowTableConfigRsp);
      return;
    }
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_cmd_rsp").setRetCode(paramLong));
    QLog.e("QCirclePluginManager", 1, " retcode= " + paramLong + " errMsg=" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhp
 * JD-Core Version:    0.7.0.1
 */