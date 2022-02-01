package com.tencent.mobileqq.bnr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BnrReport
{
  public static final class BNRConfigMsg
    extends MessageMicro<BNRConfigMsg>
  {
    public static final int CMD_FIELD_NUMBER = 2;
    public static final int EXT_INFO_FIELD_NUMBER = 4;
    public static final int MSG_REQ_BODY_FIELD_NUMBER = 10;
    public static final int MSG_RSP_BODY_FIELD_NUMBER = 11;
    public static final int SEQ_FIELD_NUMBER = 3;
    public static final int UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 82, 90 }, new String[] { "uin", "cmd", "seq", "ext_info", "msg_req_body", "msg_rsp_body" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, null, null }, BNRConfigMsg.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public BnrReport.ExtInfo ext_info = new BnrReport.ExtInfo();
    public BnrReport.BNReportConfigReq msg_req_body = new BnrReport.BNReportConfigReq();
    public BnrReport.BNReportConfigRsp msg_rsp_body = new BnrReport.BNReportConfigRsp();
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class BNReportConfig
    extends MessageMicro<BNReportConfig>
  {
    public static final int DICLIST_FIELD_NUMBER = 3;
    public static final int IDLIST_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int SEQNO_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "id", "seqno", "dicList", "idList" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, BNReportConfig.class);
    public final PBRepeatField<String> dicList = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBRepeatField<Integer> idList = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
  }
  
  public static final class BNReportConfigReq
    extends MessageMicro<BNReportConfigReq>
  {
    public static final int GROUP_INFO_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "group_info" }, new Object[] { null }, BNReportConfigReq.class);
    public final PBRepeatMessageField<BnrReport.BNReportGroupInfo> group_info = PBField.initRepeatMessage(BnrReport.BNReportGroupInfo.class);
  }
  
  public static final class BNReportConfigRsp
    extends MessageMicro<BNReportConfigRsp>
  {
    public static final int CFGLIST_FIELD_NUMBER = 2;
    public static final int RET_INFO_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ret_info", "cfglist" }, new Object[] { null, null }, BNReportConfigRsp.class);
    public final PBRepeatMessageField<BnrReport.BNReportConfig> cfglist = PBField.initRepeatMessage(BnrReport.BNReportConfig.class);
    public BnrReport.RetInfo ret_info = new BnrReport.RetInfo();
  }
  
  public static final class BNReportGroupInfo
    extends MessageMicro<BNReportGroupInfo>
  {
    public static final int ID_FIELD_NUMBER = 1;
    public static final int SEQNO_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "id", "seqno" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, BNReportGroupInfo.class);
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
  }
  
  public static final class ExtInfo
    extends MessageMicro<ExtInfo>
  {
    public static final int APP_VER_FIELD_NUMBER = 1;
    public static final int SYS_VER_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "app_ver", "sys_ver" }, new Object[] { "", "" }, ExtInfo.class);
    public final PBStringField app_ver = PBField.initString("");
    public final PBStringField sys_ver = PBField.initString("");
  }
  
  public static final class RetInfo
    extends MessageMicro<RetInfo>
  {
    public static final int ERR_INFO_FIELD_NUMBER = 2;
    public static final int RET_CODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "err_info" }, new Object[] { Long.valueOf(0L), "" }, RetInfo.class);
    public final PBStringField err_info = PBField.initString("");
    public final PBUInt64Field ret_code = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bnr.BnrReport
 * JD-Core Version:    0.7.0.1
 */