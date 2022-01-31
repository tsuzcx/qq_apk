package cooperation.qzone;

import NS_MOBILE_OPERATION.LbsInfo;
import android.text.TextUtils;

public class LbsData
{
  public static int a;
  public static int b = 500;
  public static int c = 12103;
  
  static
  {
    jdField_a_of_type_Int = 900000000;
  }
  
  public static LbsInfo a(LbsData.QzonePoiInfo paramQzonePoiInfo)
  {
    if (paramQzonePoiInfo == null) {
      return null;
    }
    LbsInfo localLbsInfo = new LbsInfo();
    if (paramQzonePoiInfo.jdField_a_of_type_CooperationQzoneLbsData$QzoneGpsInfo != null)
    {
      localLbsInfo.lbs_x = String.valueOf(paramQzonePoiInfo.jdField_a_of_type_CooperationQzoneLbsData$QzoneGpsInfo.jdField_a_of_type_Int / 1000000.0D);
      localLbsInfo.lbs_y = String.valueOf(paramQzonePoiInfo.jdField_a_of_type_CooperationQzoneLbsData$QzoneGpsInfo.b / 1000000.0D);
    }
    localLbsInfo.lbs_idnm = paramQzonePoiInfo.c;
    if (TextUtils.isEmpty(localLbsInfo.lbs_idnm)) {
      localLbsInfo.lbs_idnm = paramQzonePoiInfo.b;
    }
    localLbsInfo.lbs_nm = paramQzonePoiInfo.jdField_e_of_type_JavaLangString;
    localLbsInfo.s_lbs_id = paramQzonePoiInfo.jdField_a_of_type_JavaLangString;
    localLbsInfo.i_poi_num = paramQzonePoiInfo.f;
    localLbsInfo.i_poi_order_type = paramQzonePoiInfo.jdField_e_of_type_Int;
    localLbsInfo.i_poi_type = paramQzonePoiInfo.jdField_a_of_type_Int;
    try
    {
      localLbsInfo.lbs_id = Integer.parseInt(paramQzonePoiInfo.jdField_a_of_type_JavaLangString);
      return localLbsInfo;
    }
    catch (Exception paramQzonePoiInfo)
    {
      paramQzonePoiInfo.printStackTrace();
    }
    return localLbsInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.LbsData
 * JD-Core Version:    0.7.0.1
 */