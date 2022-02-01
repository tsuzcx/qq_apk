package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudCity
{
  public static final class GeoInfo
    extends MessageMicro<GeoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 104 }, new String[] { "districtCode", "range", "country", "province", "city", "district", "town", "village", "road", "defaultName", "cityCode", "nationalCode", "isForeign" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", "", "", "", "", "", Boolean.valueOf(false) }, GeoInfo.class);
    public final PBStringField city = PBField.initString("");
    public final PBStringField cityCode = PBField.initString("");
    public final PBStringField country = PBField.initString("");
    public final PBStringField defaultName = PBField.initString("");
    public final PBStringField district = PBField.initString("");
    public final PBInt32Field districtCode = PBField.initInt32(0);
    public final PBBoolField isForeign = PBField.initBool(false);
    public final PBStringField nationalCode = PBField.initString("");
    public final PBStringField province = PBField.initString("");
    public final PBInt32Field range = PBField.initInt32(0);
    public final PBStringField road = PBField.initString("");
    public final PBStringField town = PBField.initString("");
    public final PBStringField village = PBField.initString("");
  }
  
  public static final class GetFeedsKeysForGPSReq
    extends MessageMicro<GetFeedsKeysForGPSReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "extInfo", "gpsInfo", "attach", "num" }, new Object[] { null, null, "", Long.valueOf(0L) }, GetFeedsKeysForGPSReq.class);
    public final PBStringField attach = PBField.initString("");
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StGPSV2 gpsInfo = new FeedCloudMeta.StGPSV2();
    public final PBInt64Field num = PBField.initInt64(0L);
  }
  
  public static final class GetFeedsKeysForGPSRsp
    extends MessageMicro<GetFeedsKeysForGPSRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "extInfo", "hasMore", "attach", "feedsKeyList", "geo" }, new Object[] { null, Integer.valueOf(0), "", "", null }, GetFeedsKeysForGPSRsp.class);
    public final PBStringField attach = PBField.initString("");
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatField<String> feedsKeyList = PBField.initRepeat(PBStringField.__repeatHelper__);
    public FeedCloudCity.GeoInfo geo = new FeedCloudCity.GeoInfo();
    public final PBInt32Field hasMore = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     feedcloud.FeedCloudCity
 * JD-Core Version:    0.7.0.1
 */