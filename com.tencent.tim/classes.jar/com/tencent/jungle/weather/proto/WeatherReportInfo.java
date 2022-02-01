package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeatherReportInfo
{
  public static final class Area
    extends MessageMicro<Area>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "area_id", "area_name", "en_name", "city", "province", "country" }, new Object[] { Integer.valueOf(0), "", "", "", "", "" }, Area.class);
    public final PBUInt32Field area_id = PBField.initUInt32(0);
    public final PBStringField area_name = PBField.initString("");
    public final PBStringField city = PBField.initString("");
    public final PBStringField country = PBField.initString("");
    public final PBStringField en_name = PBField.initString("");
    public final PBStringField province = PBField.initString("");
  }
  
  public static final class GetWeatherByLbsReq
    extends MessageMicro<GetWeatherByLbsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "pbReqMsgHead", "uin", "lat", "lng", "adcode_from_mapsdk" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetWeatherByLbsReq.class);
    public final PBUInt32Field adcode_from_mapsdk = PBField.initUInt32(0);
    public final PBUInt32Field lat = PBField.initUInt32(0);
    public final PBUInt32Field lng = PBField.initUInt32(0);
    public WeatherReportInfo.PbReqMsgHead pbReqMsgHead = new WeatherReportInfo.PbReqMsgHead();
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class GetWeatherByLbsRsp
    extends MessageMicro<GetWeatherByLbsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56 }, new String[] { "pbRspMsgHead", "area", "o_wea_code", "t_wea_code", "wea_desc", "temper", "show_flag" }, new Object[] { null, null, "", "", "", "", Integer.valueOf(0) }, GetWeatherByLbsRsp.class);
    public WeatherReportInfo.Area area = new WeatherReportInfo.Area();
    public final PBStringField o_wea_code = PBField.initString("");
    public WeatherReportInfo.PbRspMsgHead pbRspMsgHead = new WeatherReportInfo.PbRspMsgHead();
    public final PBUInt32Field show_flag = PBField.initUInt32(0);
    public final PBStringField t_wea_code = PBField.initString("");
    public final PBStringField temper = PBField.initString("");
    public final PBStringField wea_desc = PBField.initString("");
  }
  
  public static final class PbReqMsgHead
    extends MessageMicro<PbReqMsgHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_platform_type", "uint32_version", "uint32_ext_mask" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PbReqMsgHead.class);
    public final PBUInt32Field uint32_ext_mask = PBField.initUInt32(0);
    public final PBUInt32Field uint32_platform_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
  }
  
  public static final class PbRspMsgHead
    extends MessageMicro<PbRspMsgHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "string_err_msg" }, new Object[] { Integer.valueOf(0), "" }, PbRspMsgHead.class);
    public final PBStringField string_err_msg = PBField.initString("");
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.jungle.weather.proto.WeatherReportInfo
 * JD-Core Version:    0.7.0.1
 */