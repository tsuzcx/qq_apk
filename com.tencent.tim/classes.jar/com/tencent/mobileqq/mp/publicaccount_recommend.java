package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class publicaccount_recommend
{
  public static final class BusinessRecommend
    extends MessageMicro<BusinessRecommend>
  {
    public static final int ACCOUNT_FIELD_NUMBER = 5;
    public static final int ACCOUNT_FLAG_FIELD_NUMBER = 15;
    public static final int CATEGORY_FIELD_NUMBER = 11;
    public static final int CS_FIELD_NUMBER = 10;
    public static final int DESC_FIELD_NUMBER = 6;
    public static final int FILTER_FIELD_NUMBER = 14;
    public static final int IC_FIELD_NUMBER = 12;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int ISVERIFIED_FIELD_NUMBER = 13;
    public static final int KFUIN_FIELD_NUMBER = 8;
    public static final int NAMEACCOUNT_FIELD_NUMBER = 7;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int SI_FIELD_NUMBER = 9;
    public static final int SOURCE_FIELD_NUMBER = 2;
    public static final int UIN_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 64, 74, 82, 90, 98, 106, 112, 120 }, new String[] { "id", "source", "uin", "name", "account", "desc", "nameAccount", "kfuin", "si", "cs", "category", "ic", "isverified", "filter", "account_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", "", "", "", Long.valueOf(0L), "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, BusinessRecommend.class);
    public final PBStringField account = PBField.initString("");
    public final PBUInt32Field account_flag = PBField.initUInt32(0);
    public final PBStringField category = PBField.initString("");
    public final PBStringField cs = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field filter = PBField.initUInt32(0);
    public final PBStringField ic = PBField.initString("");
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBStringField isverified = PBField.initString("");
    public final PBUInt64Field kfuin = PBField.initUInt64(0L);
    public final PBStringField name = PBField.initString("");
    public final PBStringField nameAccount = PBField.initString("");
    public final PBStringField si = PBField.initString("");
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class BusinessRecommendRequest
    extends MessageMicro<BusinessRecommendRequest>
  {
    public static final int BASE_STATION_FIELD_NUMBER = 5;
    public static final int CATEGORYN_FIELD_NUMBER = 1;
    public static final int CITY_INFO_FIELD_NUMBER = 6;
    public static final int CITY_LOCATION_FIELD_NUMBER = 9;
    public static final int ICON_TYPE_FIELD_NUMBER = 10;
    public static final int LATITUDE_FIELD_NUMBER = 3;
    public static final int LONGITUDE_FIELD_NUMBER = 4;
    public static final int MOBILE_VERSION_FIELD_NUMBER = 8;
    public static final int PLATFORM_FIELD_NUMBER = 7;
    public static final int RECOMEND_COUNT_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 56, 64, 74, 80 }, new String[] { "categoryn", "recomend_count", "latitude", "longitude", "base_station", "city_info", "platform", "mobile_version", "city_location", "icon_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, BusinessRecommendRequest.class);
    public final PBStringField base_station = PBField.initString("");
    public final PBUInt32Field categoryn = PBField.initUInt32(0);
    public final PBStringField city_info = PBField.initString("");
    public final PBStringField city_location = PBField.initString("");
    public final PBUInt32Field icon_type = PBField.initUInt32(0);
    public final PBStringField latitude = PBField.initString("");
    public final PBStringField longitude = PBField.initString("");
    public final PBUInt32Field mobile_version = PBField.initUInt32(0);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBUInt32Field recomend_count = PBField.initUInt32(0);
  }
  
  public static final class BusinessRecommendResponse
    extends MessageMicro<BusinessRecommendResponse>
  {
    public static final int BUSINESS_FIELD_NUMBER = 4;
    public static final int CURRENT_BUSINESS_COUNT_FIELD_NUMBER = 3;
    public static final int RET_INFO_FIELD_NUMBER = 1;
    public static final int TOTLE_BUSINESS_COUNT_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "ret_info", "totle_business_count", "current_business_count", "business" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), null }, BusinessRecommendResponse.class);
    public final PBRepeatMessageField<publicaccount_recommend.BusinessRecommend> business = PBField.initRepeatMessage(publicaccount_recommend.BusinessRecommend.class);
    public final PBUInt32Field current_business_count = PBField.initUInt32(0);
    public publicaccount_recommend.RetInfo ret_info = new publicaccount_recommend.RetInfo();
    public final PBUInt32Field totle_business_count = PBField.initUInt32(0);
  }
  
  public static final class RetInfo
    extends MessageMicro<RetInfo>
  {
    public static final int ERR_INFO_FIELD_NUMBER = 2;
    public static final int RET_CODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "err_info" }, new Object[] { Integer.valueOf(0), "" }, RetInfo.class);
    public final PBStringField err_info = PBField.initString("");
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mp.publicaccount_recommend
 * JD-Core Version:    0.7.0.1
 */