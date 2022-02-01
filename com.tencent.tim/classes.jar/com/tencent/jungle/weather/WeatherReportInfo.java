package com.tencent.jungle.weather;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeatherReportInfo
{
  public static final class GetWeatherMessageReq
    extends MessageMicro<GetWeatherMessageReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 64, 74, 82, 88 }, new String[] { "pbReqMsgHead", "uin", "lat", "lng", "ip", "area_id", "source", "fore_flag", "extra", "adcode", "adcode_from_mapsdk" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) }, GetWeatherMessageReq.class);
    public final PBStringField adcode = PBField.initString("");
    public final PBUInt32Field adcode_from_mapsdk = PBField.initUInt32(0);
    public final PBUInt32Field area_id = PBField.initUInt32(0);
    public final PBStringField extra = PBField.initString("");
    public final PBUInt32Field fore_flag = PBField.initUInt32(0);
    public final PBUInt32Field ip = PBField.initUInt32(0);
    public final PBUInt32Field lat = PBField.initUInt32(0);
    public final PBUInt32Field lng = PBField.initUInt32(0);
    public WeatherReportInfo.PbReqMsgHead pbReqMsgHead = new WeatherReportInfo.PbReqMsgHead();
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class GetWeatherMessageRsp
    extends MessageMicro<GetWeatherMessageRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "pbRspMsgHead", "cmd", "string_msg", "extra" }, new Object[] { null, Integer.valueOf(0), "", "" }, GetWeatherMessageRsp.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBStringField extra = PBField.initString("");
    public WeatherReportInfo.PbRspMsgHead pbRspMsgHead = new WeatherReportInfo.PbRspMsgHead();
    public final PBStringField string_msg = PBField.initString("");
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
 * Qualified Name:     com.tencent.jungle.weather.WeatherReportInfo
 * JD-Core Version:    0.7.0.1
 */