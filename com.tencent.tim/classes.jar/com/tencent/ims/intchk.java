package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class intchk
{
  public static final class AppInfo
    extends MessageMicro<AppInfo>
  {
    public static final int BYTES_APP_VERSION_FIELD_NUMBER = 3;
    public static final int BYTES_PACKAGE_NAME_FIELD_NUMBER = 2;
    public static final int UINT32_INTCHK_MODULE_VERSION_FIELD_NUMBER = 4;
    public static final int UINT32_NET_TYPE_FIELD_NUMBER = 5;
    public static final int UINT32_PLATFORM_TYPE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_app_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_package_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_intchk_module_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_net_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_platform_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "uint32_platform_type", "bytes_package_name", "bytes_app_version", "uint32_intchk_module_version", "uint32_net_type" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, AppInfo.class);
    }
  }
  
  public static final class CheckItem
    extends MessageMicro<CheckItem>
  {
    public static final int BYTES_MATCH_PATTERN_FIELD_NUMBER = 6;
    public static final int BYTES_MODULE_NAME_FIELD_NUMBER = 3;
    public static final int UINT32_CHECK_ITEM_ID_FIELD_NUMBER = 1;
    public static final int UINT32_CHECK_TYPE_FIELD_NUMBER = 2;
    public static final int UINT32_END_OFFSET_FIELD_NUMBER = 5;
    public static final int UINT32_START_OFFSET_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_match_pattern = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_module_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_check_item_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_check_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_end_offset = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start_offset = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50 }, new String[] { "uint32_check_item_id", "uint32_check_type", "bytes_module_name", "uint32_start_offset", "uint32_end_offset", "bytes_match_pattern" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, CheckItem.class);
    }
  }
  
  public static final class CheckResult
    extends MessageMicro<CheckResult>
  {
    public static final int BYTES_MEMREPORT_RESULT_FIELD_NUMBER = 4;
    public static final int UINT32_CHECK_ITEM_ID_FIELD_NUMBER = 1;
    public static final int UINT32_CHECK_TYPE_FIELD_NUMBER = 2;
    public static final int UINT32_MEMCHK_RESULT_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_memreport_result = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_check_item_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_check_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_memchk_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_check_item_id", "uint32_check_type", "uint32_memchk_result", "bytes_memreport_result" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, CheckResult.class);
    }
  }
  
  public static final class FetchCheckConfigReq
    extends MessageMicro<FetchCheckConfigReq>
  {
    public static final int UINT32_RESERVED_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_reserved" }, new Object[] { Integer.valueOf(0) }, FetchCheckConfigReq.class);
    public final PBUInt32Field uint32_reserved = PBField.initUInt32(0);
  }
  
  public static final class FetchCheckConfigRsp
    extends MessageMicro<FetchCheckConfigRsp>
  {
    public static final int RPT_MSG_CHECK_ITEM_FIELD_NUMBER = 3;
    public static final int UINT32_INTCHK_ID_FIELD_NUMBER = 2;
    public static final int UINT32_NEED_INTCHK_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_need_intchk", "uint32_intchk_id", "rpt_msg_check_item" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, FetchCheckConfigRsp.class);
    public final PBRepeatMessageField<intchk.CheckItem> rpt_msg_check_item = PBField.initRepeatMessage(intchk.CheckItem.class);
    public final PBUInt32Field uint32_intchk_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_intchk = PBField.initUInt32(0);
  }
  
  public static final class ReportCheckResultReq
    extends MessageMicro<ReportCheckResultReq>
  {
    public static final int RPT_MSG_CHECK_RESULT_FIELD_NUMBER = 2;
    public static final int UINT32_INTCHK_ID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_intchk_id", "rpt_msg_check_result" }, new Object[] { Integer.valueOf(0), null }, ReportCheckResultReq.class);
    public final PBRepeatMessageField<intchk.CheckResult> rpt_msg_check_result = PBField.initRepeatMessage(intchk.CheckResult.class);
    public final PBUInt32Field uint32_intchk_id = PBField.initUInt32(0);
  }
  
  public static final class ReportCheckResultRsp
    extends MessageMicro<ReportCheckResultRsp>
  {
    public static final int BYTES_STRIKE_CONFIG_FIELD_NUMBER = 3;
    public static final int UINT32_INTCHK_ID_FIELD_NUMBER = 2;
    public static final int UINT32_NEED_STRIKE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_strike_config = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_intchk_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_strike = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_need_strike", "uint32_intchk_id", "bytes_strike_config" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, ReportCheckResultRsp.class);
    }
  }
  
  public static final class ReportStrikeResultReq
    extends MessageMicro<ReportStrikeResultReq>
  {
    public static final int UINT32_INTCHK_ID_FIELD_NUMBER = 1;
    public static final int UINT32_STRIKE_RESULT_FIELD_NUMBER = 3;
    public static final int UINT32_STRIKE_TYPE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_intchk_id", "uint32_strike_type", "uint32_strike_result" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReportStrikeResultReq.class);
    public final PBUInt32Field uint32_intchk_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_strike_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_strike_type = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int MSG_APP_INFO_FIELD_NUMBER = 2;
    public static final int MSG_CHECK_CONFIG_REQ_FIELD_NUMBER = 3;
    public static final int MSG_REPORT_CHECK_RESULT_REQ_FIELD_NUMBER = 4;
    public static final int MSG_REPORT_STRIKE_RESULT_REQ_FIELD_NUMBER = 5;
    public static final int UINT32_SUBCMD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint32_subcmd", "msg_app_info", "msg_check_config_req", "msg_report_check_result_req", "msg_report_strike_result_req" }, new Object[] { Integer.valueOf(0), null, null, null, null }, ReqBody.class);
    public intchk.AppInfo msg_app_info = new intchk.AppInfo();
    public intchk.FetchCheckConfigReq msg_check_config_req = new intchk.FetchCheckConfigReq();
    public intchk.ReportCheckResultReq msg_report_check_result_req = new intchk.ReportCheckResultReq();
    public intchk.ReportStrikeResultReq msg_report_strike_result_req = new intchk.ReportStrikeResultReq();
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int MSG_CHECK_CONFIG_RSP_FIELD_NUMBER = 3;
    public static final int MSG_REPORT_CHECK_RESULT_RSP_FIELD_NUMBER = 4;
    public static final int UINT32_RESULT_FIELD_NUMBER = 2;
    public static final int UINT32_SUBCMD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_subcmd", "uint32_result", "msg_check_config_rsp", "msg_report_check_result_rsp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null }, RspBody.class);
    public intchk.FetchCheckConfigRsp msg_check_config_rsp = new intchk.FetchCheckConfigRsp();
    public intchk.ReportCheckResultRsp msg_report_check_result_rsp = new intchk.ReportCheckResultRsp();
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ims.intchk
 * JD-Core Version:    0.7.0.1
 */