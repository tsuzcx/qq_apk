import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.gdtad.views.video.GdtVideoData;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class yve
{
  private GdtAd jdField_a_of_type_ComTencentGdtadAditemGdtAd;
  private GdtMotiveVideoPageData jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData;
  private GdtVideoData jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData;
  private qq_ad_get.QQAdGetRsp.AdInfo jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
  
  public yve(GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    yxp.a("GdtMotiveVideoModel", "[GdtMotiveVideoModel]\n" + paramGdtMotiveVideoPageData.adsContent);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData = paramGdtMotiveVideoPageData;
    b(paramGdtMotiveVideoPageData);
    a(paramGdtMotiveVideoPageData);
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData = new GdtVideoData();
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.setAd(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.setPlayScene(11);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.setUrl(paramGdtMotiveVideoPageData.url);
  }
  
  private void b(GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    if (TextUtils.isEmpty(paramGdtMotiveVideoPageData.adsContent))
    {
      yxp.d("GdtMotiveVideoModel", "[adJson==null error]");
      return;
    }
    try
    {
      this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = ((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(yxo.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramGdtMotiveVideoPageData.adsContent))));
      return;
    }
    catch (Throwable paramGdtMotiveVideoPageData)
    {
      yxp.d("GdtMotiveVideoModel", "GdtMotiveVideoModel error]", paramGdtMotiveVideoPageData);
    }
  }
  
  public GdtAd a()
  {
    return this.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
  }
  
  public GdtMotiveVideoPageData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData;
  }
  
  public GdtVideoData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData;
  }
  
  public qq_ad_get.QQAdGetRsp.AdInfo a()
  {
    return this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yve
 * JD-Core Version:    0.7.0.1
 */