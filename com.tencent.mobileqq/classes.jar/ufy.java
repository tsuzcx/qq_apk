import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.NativeAd.report.ExposeMode;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.AppInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class ufy
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  Bundle jdField_a_of_type_AndroidOsBundle;
  ExposeMode jdField_a_of_type_ComTencentBizPubaccountNativeAdReportExposeMode = ExposeMode.STRICT;
  private JumpMode jdField_a_of_type_ComTencentBizPubaccountNativeAdReportJumpMode;
  private ActionEntity jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantActionEntity;
  private ReportAction jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportAction;
  VideoAdInfo jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
  AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  String jdField_a_of_type_JavaLangString;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  JSONObject jdField_b_of_type_OrgJsonJSONObject;
  private boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  JSONObject jdField_c_of_type_OrgJsonJSONObject;
  int jdField_d_of_type_Int;
  JSONObject jdField_d_of_type_OrgJsonJSONObject;
  JSONObject e;
  JSONObject f;
  
  public ufw a()
  {
    ufw localufw = new ufw(null);
    ufw.a(localufw, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    ufw.a(localufw, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    ufw.a(localufw, this.jdField_a_of_type_Long);
    ufw.a(localufw, this.jdField_c_of_type_Int);
    ufw.a(localufw, this.jdField_a_of_type_AndroidOsBundle);
    ufw.a(localufw, this.jdField_a_of_type_AndroidContentContext);
    ufw.a(localufw, this.jdField_b_of_type_OrgJsonJSONObject);
    ufw.a(localufw, this.jdField_a_of_type_JavaLangString);
    ufw.b(localufw, this.jdField_b_of_type_JavaLangString);
    ufw.b(localufw, this.jdField_b_of_type_Int);
    ufw.b(localufw, this.jdField_c_of_type_OrgJsonJSONObject);
    ufw.c(localufw, this.jdField_a_of_type_Int);
    ufw.c(localufw, this.jdField_d_of_type_OrgJsonJSONObject);
    ufw.a(localufw, this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    ufw.d(localufw, this.jdField_a_of_type_OrgJsonJSONObject);
    ufw.e(localufw, this.e);
    ufw.d(localufw, this.jdField_d_of_type_Int);
    ufw.f(localufw, this.f);
    localufw.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    ufw.a(localufw, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportExposeMode);
    ufw.a(localufw, this.jdField_b_of_type_Boolean);
    ufw.a(localufw, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantActionEntity);
    ufw.a(localufw, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportJumpMode);
    ufw.a(localufw, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportAction);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isMultiyVideo)) {
      try
      {
        if (ufw.a(localufw) == null) {
          ufw.f(localufw, new JSONObject());
        }
        if (ufw.a(localufw).has("statistics_data_report"))
        {
          localJSONObject = new JSONObject(ufw.a(localufw).getString("statistics_data_report"));
          localJSONObject.put("show_style", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRevisionVideoType);
          ufw.a(localufw).put("statistics_data_report", localJSONObject.toString());
          return localufw;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("show_style", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRevisionVideoType);
        ufw.a(localufw).put("statistics_data_report", localJSONObject.toString());
        return localufw;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return localufw;
  }
  
  public ufy a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public ufy a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public ufy a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    return this;
  }
  
  public ufy a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    return this;
  }
  
  public ufy a(ExposeMode paramExposeMode)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportExposeMode = paramExposeMode;
    return this;
  }
  
  public ufy a(JumpMode paramJumpMode)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportJumpMode = paramJumpMode;
    return this;
  }
  
  public ufy a(ActionEntity paramActionEntity)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantActionEntity = paramActionEntity;
    return this;
  }
  
  public ufy a(ReportAction paramReportAction)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportAction = paramReportAction;
    return this;
  }
  
  public ufy a(VideoAdInfo paramVideoAdInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = paramVideoAdInfo;
    return this;
  }
  
  public ufy a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    return this;
  }
  
  public ufy a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    return this;
  }
  
  public ufy a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ufy a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public ufy a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public ufy b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public ufy b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ufy b(JSONObject paramJSONObject)
  {
    this.jdField_b_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public ufy b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public ufy c(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
  
  public ufy c(JSONObject paramJSONObject)
  {
    this.jdField_c_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public ufy d(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public ufy d(JSONObject paramJSONObject)
  {
    this.e = paramJSONObject;
    return this;
  }
  
  public ufy e(JSONObject paramJSONObject)
  {
    this.f = paramJSONObject;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufy
 * JD-Core Version:    0.7.0.1
 */