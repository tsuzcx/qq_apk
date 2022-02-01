package com.tencent.pb.vasreporter;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class VasReporter
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "cmd", "plat", "qqversion", "osversion", "statis_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", null }, ReqBody.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBStringField osversion = PBField.initString("");
    public final PBInt32Field plat = PBField.initInt32(0);
    public final PBStringField qqversion = PBField.initString("");
    public final PBRepeatMessageField<VasReporter.StatisInfo> statis_list = PBField.initRepeatMessage(VasReporter.StatisInfo.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ret" }, new Object[] { Integer.valueOf(0) }, RspBody.class);
    public final PBInt32Field ret = PBField.initInt32(0);
  }
  
  public static final class StatisInfo
    extends MessageMicro<StatisInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 29, 32, 42 }, new String[] { "appid", "key_list", "value_list", "ts", "msg" }, new Object[] { "", "", Float.valueOf(0.0F), Long.valueOf(0L), "" }, StatisInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBRepeatField<String> key_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField msg = PBField.initString("");
    public final PBInt64Field ts = PBField.initInt64(0L);
    public final PBRepeatField<Float> value_list = PBField.initRepeat(PBFloatField.__repeatHelper__);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.vasreporter.VasReporter
 * JD-Core Version:    0.7.0.1
 */