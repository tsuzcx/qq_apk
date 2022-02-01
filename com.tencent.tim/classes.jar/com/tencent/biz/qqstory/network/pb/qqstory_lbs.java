package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_lbs
{
  public static final class LbsData
    extends MessageMicro<LbsData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 9, 17, 25, 37, 42, 48, 56, 66, 74, 82, 90 }, new String[] { "lat", "lng", "alt", "accuracy", "bussinessTag", "plat_type", "oper_time", "nation", "province", "city", "district" }, new Object[] { Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.0D), Float.valueOf(0.0F), "", Integer.valueOf(0), Integer.valueOf(0), "", "", "", "" }, LbsData.class);
    public final PBFloatField accuracy = PBField.initFloat(0.0F);
    public final PBDoubleField alt = PBField.initDouble(0.0D);
    public final PBStringField bussinessTag = PBField.initString("");
    public final PBStringField city = PBField.initString("");
    public final PBStringField district = PBField.initString("");
    public final PBDoubleField lat = PBField.initDouble(0.0D);
    public final PBDoubleField lng = PBField.initDouble(0.0D);
    public final PBStringField nation = PBField.initString("");
    public final PBUInt32Field oper_time = PBField.initUInt32(0);
    public final PBUInt32Field plat_type = PBField.initUInt32(0);
    public final PBStringField province = PBField.initString("");
  }
  
  public static final class ReqLbsReport
    extends MessageMicro<ReqLbsReport>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "list_data" }, new Object[] { null }, ReqLbsReport.class);
    public final PBRepeatMessageField<qqstory_lbs.LbsData> list_data = PBField.initRepeatMessage(qqstory_lbs.LbsData.class);
  }
  
  public static final class RspLbsReport
    extends MessageMicro<RspLbsReport>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspLbsReport.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_lbs
 * JD-Core Version:    0.7.0.1
 */