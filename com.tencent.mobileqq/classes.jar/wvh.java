import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.GetWatermarkDictRequest;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.Map;

public class wvh
{
  private static final String jdField_a_of_type_JavaLangString = wvh.class.getSimpleName();
  private static volatile wvh jdField_a_of_type_Wvh;
  private int jdField_a_of_type_Int;
  private bgya jdField_a_of_type_Bgya;
  private SosoInterface.SosoLocation jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation;
  
  public static wvh a()
  {
    if (jdField_a_of_type_Wvh == null) {}
    try
    {
      if (jdField_a_of_type_Wvh == null) {
        jdField_a_of_type_Wvh = new wvh();
      }
      return jdField_a_of_type_Wvh;
    }
    finally {}
  }
  
  private void a(double paramDouble1, double paramDouble2)
  {
    long l = dp.a();
    GetWatermarkDictRequest localGetWatermarkDictRequest = new GetWatermarkDictRequest(new COMM.StCommonExt(), paramDouble1, paramDouble2, String.valueOf(l));
    VSNetworkHelper.a().a(localGetWatermarkDictRequest, new wvj(this));
  }
  
  private void a(Map<String, String> paramMap)
  {
    LogicDataManager.getInstance().addWatermarkDict(paramMap);
    String str = (String)paramMap.get("City");
    if (str != null) {
      LogicDataManager.getInstance().setLocation(str);
    }
    str = (String)paramMap.get("Weather");
    if (str != null) {}
    try
    {
      i = Integer.parseInt(str);
      LogicDataManager.getInstance().setWeather(i);
      LogicDataManager.getInstance().setWeatherType(i);
      paramMap = (String)paramMap.get("TempCurr");
      if (paramMap != null) {
        LogicDataManager.getInstance().setTemperature(paramMap.replace(ajjy.a(2131651088), ""));
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
  
  public bgya a()
  {
    return this.jdField_a_of_type_Bgya;
  }
  
  public SosoInterface.SosoLocation a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = ((this.jdField_a_of_type_Int + 1) % 50);
    if (this.jdField_a_of_type_Int != 1) {
      return;
    }
    akfu.a(new wvi(this, "qq_story_water_mark", false));
  }
  
  public void a(bgya parambgya)
  {
    this.jdField_a_of_type_Bgya = parambgya;
  }
  
  public void a(boolean paramBoolean)
  {
    wwt.a().a("WM_LIST_CONFIG_CHANGED", Boolean.valueOf(paramBoolean));
  }
  
  public void b()
  {
    try
    {
      jdField_a_of_type_Wvh = null;
      this.jdField_a_of_type_Bgya = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wvh
 * JD-Core Version:    0.7.0.1
 */