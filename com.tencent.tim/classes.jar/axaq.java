import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.GetWatermarkDictRequest;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.Map;

public class axaq
{
  private static final String TAG = axaq.class.getSimpleName();
  private static volatile axaq jdField_a_of_type_Axaq;
  private SosoInterface.SosoLocation jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation;
  private int eEs;
  private axbu f;
  
  public static axaq a()
  {
    if (jdField_a_of_type_Axaq == null) {}
    try
    {
      if (jdField_a_of_type_Axaq == null) {
        jdField_a_of_type_Axaq = new axaq();
      }
      return jdField_a_of_type_Axaq;
    }
    finally {}
  }
  
  private void av(Map<String, String> paramMap)
  {
    LogicDataManager.getInstance().addWatermarkDict(paramMap);
    String str = (String)paramMap.get("City");
    if (str != null)
    {
      axiy.i(TAG, "[prepareWMData]displayName : " + str);
      LogicDataManager.getInstance().setLocation(str);
    }
    str = (String)paramMap.get("Weather");
    if (str != null) {}
    try
    {
      i = Integer.parseInt(str);
      axiy.i(TAG, "[prepareWMData]weatherType : " + i);
      LogicDataManager.getInstance().setWeather(i);
      LogicDataManager.getInstance().setWeatherType(i);
      paramMap = (String)paramMap.get("TempCurr");
      if (paramMap != null)
      {
        axiy.i(TAG, "[prepareWMData]tempCurr : " + paramMap);
        LogicDataManager.getInstance().setTemperature(paramMap.replace(acfp.m(2131716900), ""));
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        LogUtils.e(localNumberFormatException);
        int i = 0;
      }
    }
  }
  
  private void e(double paramDouble1, double paramDouble2)
  {
    long l = cz.s();
    GetWatermarkDictRequest localGetWatermarkDictRequest = new GetWatermarkDictRequest(new COMM.StCommonExt(), paramDouble1, paramDouble2, String.valueOf(l));
    VSNetworkHelper.a().a(localGetWatermarkDictRequest, new axas(this));
  }
  
  public void XY(boolean paramBoolean)
  {
    spp.a().m("WM_LIST_CONFIG_CHANGED", Boolean.valueOf(paramBoolean));
  }
  
  public axbu a()
  {
    return this.f;
  }
  
  public SosoInterface.SosoLocation b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation;
  }
  
  public void eIt()
  {
    this.eEs = ((this.eEs + 1) % 50);
    if (this.eEs != 1) {
      return;
    }
    axiy.i(TAG, "updateWMProps start");
    aczc.a(new axar(this, "qq_story_water_mark", false));
  }
  
  public void releaseInstance()
  {
    try
    {
      jdField_a_of_type_Axaq = null;
      this.f = null;
      return;
    }
    finally {}
  }
  
  public void t(axbu paramaxbu)
  {
    this.f = paramaxbu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axaq
 * JD-Core Version:    0.7.0.1
 */