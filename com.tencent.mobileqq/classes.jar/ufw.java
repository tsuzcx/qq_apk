import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.NativeAd.report.ExposeMode;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.AppInterface;
import org.json.JSONObject;

public class ufw
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private ExposeMode jdField_a_of_type_ComTencentBizPubaccountNativeAdReportExposeMode = ExposeMode.STRICT;
  private JumpMode jdField_a_of_type_ComTencentBizPubaccountNativeAdReportJumpMode;
  private ActionEntity jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantActionEntity;
  private ReportAction jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportAction;
  private VideoAdInfo jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private JSONObject jdField_b_of_type_OrgJsonJSONObject;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private JSONObject jdField_c_of_type_OrgJsonJSONObject;
  private int jdField_d_of_type_Int;
  private JSONObject jdField_d_of_type_OrgJsonJSONObject;
  private JSONObject e;
  private JSONObject f;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public ExposeMode a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportExposeMode;
  }
  
  public JumpMode a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportJumpMode;
  }
  
  public ActionEntity a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantActionEntity;
  }
  
  public ReportAction a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportAction;
  }
  
  public VideoAdInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
  }
  
  public AdvertisementInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  }
  
  public AppInterface a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppAppInterface;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public JSONObject a()
  {
    return this.jdField_a_of_type_OrgJsonJSONObject;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public JSONObject b()
  {
    return this.jdField_b_of_type_OrgJsonJSONObject;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public JSONObject c()
  {
    return this.jdField_c_of_type_OrgJsonJSONObject;
  }
  
  public int d()
  {
    if ((this.jdField_c_of_type_Int <= 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.clickPos > 0)) {
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.clickPos;
    }
    return this.jdField_c_of_type_Int;
  }
  
  public JSONObject d()
  {
    return this.jdField_d_of_type_OrgJsonJSONObject;
  }
  
  public JSONObject e()
  {
    return this.f;
  }
  
  public JSONObject f()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufw
 * JD-Core Version:    0.7.0.1
 */