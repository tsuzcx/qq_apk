import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.AppInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class tlx
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
  JSONObject e;
  JSONObject f;
  
  public tlv a()
  {
    tlv localtlv = new tlv(null);
    tlv.a(localtlv, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    tlv.a(localtlv, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    tlv.a(localtlv, this.jdField_a_of_type_Long);
    tlv.a(localtlv, this.jdField_c_of_type_Int);
    tlv.a(localtlv, this.jdField_a_of_type_AndroidOsBundle);
    tlv.a(localtlv, this.jdField_a_of_type_AndroidContentContext);
    tlv.a(localtlv, this.jdField_b_of_type_OrgJsonJSONObject);
    tlv.a(localtlv, this.jdField_a_of_type_JavaLangString);
    tlv.b(localtlv, this.jdField_b_of_type_Int);
    tlv.b(localtlv, this.jdField_c_of_type_OrgJsonJSONObject);
    tlv.c(localtlv, this.jdField_a_of_type_Int);
    tlv.c(localtlv, this.jdField_d_of_type_OrgJsonJSONObject);
    tlv.a(localtlv, this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    tlv.d(localtlv, this.jdField_a_of_type_OrgJsonJSONObject);
    tlv.e(localtlv, this.e);
    tlv.d(localtlv, this.jdField_d_of_type_Int);
    tlv.f(localtlv, this.f);
    localtlv.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isMultiyVideo)) {
      try
      {
        if (tlv.a(localtlv) == null) {
          tlv.f(localtlv, new JSONObject());
        }
        if (tlv.a(localtlv).has("statistics_data_report"))
        {
          localJSONObject = new JSONObject(tlv.a(localtlv).getString("statistics_data_report"));
          localJSONObject.put("show_style", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRevisionVideoType);
          tlv.a(localtlv).put("statistics_data_report", localJSONObject.toString());
          return localtlv;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("show_style", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRevisionVideoType);
        tlv.a(localtlv).put("statistics_data_report", localJSONObject.toString());
        return localtlv;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return localtlv;
  }
  
  public tlx a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public tlx a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public tlx a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    return this;
  }
  
  public tlx a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    return this;
  }
  
  public tlx a(VideoAdInfo paramVideoAdInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = paramVideoAdInfo;
    return this;
  }
  
  public tlx a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    return this;
  }
  
  public tlx a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    return this;
  }
  
  public tlx a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public tlx a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public tlx a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public tlx b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public tlx b(JSONObject paramJSONObject)
  {
    this.jdField_b_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public tlx c(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
  
  public tlx c(JSONObject paramJSONObject)
  {
    this.jdField_c_of_type_OrgJsonJSONObject = paramJSONObject;
    return this;
  }
  
  public tlx d(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public tlx d(JSONObject paramJSONObject)
  {
    this.e = paramJSONObject;
    return this;
  }
  
  public tlx e(JSONObject paramJSONObject)
  {
    this.f = paramJSONObject;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tlx
 * JD-Core Version:    0.7.0.1
 */