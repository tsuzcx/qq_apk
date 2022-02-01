import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.gdtad.views.video.GdtVideoData;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class tir
{
  private GdtMotiveVideoPageData jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData;
  private GdtVideoData jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData;
  private qq_ad_get.QQAdGetRsp.AdInfo jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
  private GdtAd c;
  
  public tir(GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    tkw.d("GdtMotiveVideoModel", "[GdtMotiveVideoModel]\n" + paramGdtMotiveVideoPageData.adsContent);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData = paramGdtMotiveVideoPageData;
    b(paramGdtMotiveVideoPageData);
    a(paramGdtMotiveVideoPageData);
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    this.c = new GdtAd(this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData = new GdtVideoData();
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.setAd(this.c);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.setPlayScene(11);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData.setUrl(paramGdtMotiveVideoPageData.url);
  }
  
  private void b(GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    if (TextUtils.isEmpty(paramGdtMotiveVideoPageData.adsContent))
    {
      tkw.e("GdtMotiveVideoModel", "[adJson==null error]");
      return;
    }
    try
    {
      this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = ((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramGdtMotiveVideoPageData.adsContent))));
      return;
    }
    catch (Throwable paramGdtMotiveVideoPageData)
    {
      tkw.e("GdtMotiveVideoModel", "GdtMotiveVideoModel error]", paramGdtMotiveVideoPageData);
    }
  }
  
  public GdtAd a()
  {
    return this.c;
  }
  
  public GdtMotiveVideoPageData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData;
  }
  
  public GdtVideoData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoData;
  }
  
  public qq_ad_get.QQAdGetRsp.AdInfo b()
  {
    return this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tir
 * JD-Core Version:    0.7.0.1
 */