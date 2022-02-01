package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ClubContentUpdateInfoPb
{
  public static final class ReqAppInfo
    extends MessageMicro<ReqAppInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint_appid", "rpt_msg_reqiteminfo" }, new Object[] { Integer.valueOf(0), null }, ReqAppInfo.class);
    public final PBRepeatMessageField<ClubContentUpdateInfoPb.ReqItemInfo> rpt_msg_reqiteminfo = PBField.initRepeatMessage(ClubContentUpdateInfoPb.ReqItemInfo.class);
    public final PBUInt32Field uint_appid = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "int_protocolver", "uint_clientplatid", "str_clientver", "uint_uin", "rpt_msg_reqappinfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), null }, ReqBody.class);
    public final PBInt32Field int_protocolver = PBField.initInt32(0);
    public final PBRepeatMessageField<ClubContentUpdateInfoPb.ReqAppInfo> rpt_msg_reqappinfo = PBField.initRepeatMessage(ClubContentUpdateInfoPb.ReqAppInfo.class);
    public final PBStringField str_clientver = PBField.initString("");
    public final PBUInt32Field uint_clientplatid = PBField.initUInt32(0);
    public final PBUInt64Field uint_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqItemInfo
    extends MessageMicro<ReqItemInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_name", "uint_version" }, new Object[] { "", Integer.valueOf(0) }, ReqItemInfo.class);
    public final PBStringField str_name = PBField.initString("");
    public final PBUInt32Field uint_version = PBField.initUInt32(0);
  }
  
  public static final class RspAppInfo
    extends MessageMicro<RspAppInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint_appid", "rpt_msg_rspiteminfo" }, new Object[] { Integer.valueOf(0), null }, RspAppInfo.class);
    public final PBRepeatMessageField<ClubContentUpdateInfoPb.RspItemInfo> rpt_msg_rspiteminfo = PBField.initRepeatMessage(ClubContentUpdateInfoPb.RspItemInfo.class);
    public final PBUInt32Field uint_appid = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int_result", "rpt_msg_rspappinfo" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
    public final PBInt32Field int_result = PBField.initInt32(0);
    public final PBRepeatMessageField<ClubContentUpdateInfoPb.RspAppInfo> rpt_msg_rspappinfo = PBField.initRepeatMessage(ClubContentUpdateInfoPb.RspAppInfo.class);
  }
  
  public static final class RspItemInfo
    extends MessageMicro<RspItemInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "str_name", "uint_version", "uint_update_flag", "str_extend" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "" }, RspItemInfo.class);
    public final PBStringField str_extend = PBField.initString("");
    public final PBStringField str_name = PBField.initString("");
    public final PBUInt32Field uint_update_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint_version = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.clubcontent.ClubContentUpdateInfoPb
 * JD-Core Version:    0.7.0.1
 */