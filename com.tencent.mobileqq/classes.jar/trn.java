import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.AppInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class trn
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  Bundle jdField_a_of_type_AndroidOsBundle;
  VideoAdInfo jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
  AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  String jdField_a_of_type_JavaLangString;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  JSONObject jdField_b_of_type_OrgJsonJSONObject;
  int jdField_c_of_type_Int;
  JSONObject jdField_c_of_type_OrgJsonJSONObject;
  int jdField_d_of_type_Int;
  JSONObject jdField_d_of_type_OrgJsonJSONObject;
  int jdField_e_of_type_Int;
  JSONObject jdField_e_of_type_OrgJsonJSONObject;
  JSONObject f;
  
  public trl a()
  {
    trl localtrl = new trl(null);
    trl.a(localtrl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    trl.a(localtrl, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    trl.a(localtrl, this.jdField_a_of_type_Long);
    trl.a(localtrl, this.jdField_c_of_type_Int);
    trl.a(localtrl, this.jdField_a_of_type_AndroidOsBundle);
    trl.a(localtrl, this.jdField_a_of_type_AndroidContentContext);
    trl.a(localtrl, this.jdField_b_of_type_OrgJsonJSONObject);
    trl.a(localtrl, this.jdField_a_of_type_JavaLangString);
    trl.b(localtrl, this.jdField_b_of_type_Int);
    trl.b(localtrl, this.jdField_c_of_type_OrgJsonJSONObject);
    trl.c(localtrl, this.jdField_a_of_type_Int);
    trl.c(localtrl, this.jdField_d_of_type_OrgJsonJSONObject);
    trl.a(localtrl, this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    trl.d(localtrl, this.jdField_a_of_type_OrgJsonJSONObject);
    trl.e(localtrl, this.jdField_e_of_type_OrgJsonJSONObject);
    trl.d(localtrl, this.jdField_d_of_type_Int);
    trl.f(localtrl, this.f);
    localtrl.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    trl.e(localtrl, this.jdField_e_of_type_Int);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isMultiyVideo)) {
      try
      {
        if (trl.a(localtrl) == null) {
          trl.f(localtrl, new JSONObject());
        }
        if (trl.a(localtrl).has("statistics_data_report"))
        {
          localJSONObject = new JSONObject(trl.a(localtrl).getString("statistics_data_report"));
          localJSONObject.put("show_style", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRevisionVideoType);
          trl.a(localtrl).put("statistics_data_report", localJSONObject.toString());
          return localtrl;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("show_style", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRevisionVideoType);
        trl.a(localtrl).put("statistics_data_report", localJSONObject.toString());
        return localtrl;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return localtrl;
  }
  
  public trn a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public trn a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public trn a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    return this;
  }
  
  public trn a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    return this;
  }
  
  public trn a(VideoAdInfo paramVideoAdInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = paramVideoAdInfo;
    return this;
  }
  
  public trn a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    return this;
  }
  
  public trn a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    return this;
  }
  
  public trn a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public trn a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public trn a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public trn b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public trn b(JSONObject paramJSONObject)
  {
    this.jdField_b_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public trn c(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
  
  public trn c(JSONObject paramJSONObject)
  {
    this.jdField_c_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public trn d(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public trn d(JSONObject paramJSONObject)
  {
    this.jdField_e_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public trn e(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    return this;
  }
  
  public trn e(JSONObject paramJSONObject)
  {
    this.f = paramJSONObject;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trn
 * JD-Core Version:    0.7.0.1
 */