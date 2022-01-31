package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class EmosmPb$ReqBody
  extends MessageMicro
{
  public static final int INT32_PLAT_ID_FIELD_NUMBER = 6;
  public static final int MSG_SUBCMD0X1_REQ_DELTAB_FIELD_NUMBER = 3;
  public static final int MSG_SUBCMD0X2_REQ_FETCHTAB_FIELD_NUMBER = 4;
  public static final int MSG_SUBCMD0X3_REQ_FETCHBQ_FIELD_NUMBER = 5;
  public static final int MSG_SUBCMD0X6_REQ_FIELD_NUMBER = 8;
  public static final int MSG_SUBCMD0X7_REQ_FIELD_NUMBER = 9;
  public static final int MSG_SUBCMD0X8_REQ_ADDTAB_FIELD_NUMBER = 10;
  public static final int STR_APP_VERSION_FIELD_NUMBER = 7;
  public static final int UINT32_SUB_CMD_FIELD_NUMBER = 1;
  public static final int UINT64_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 58, 66, 74, 82 }, new String[] { "uint32_sub_cmd", "uint64_uin", "msg_subcmd0x1_req_deltab", "msg_subcmd0x2_req_fetchtab", "msg_subcmd0x3_req_fetchbq", "int32_plat_id", "str_app_version", "msg_subcmd0x6_req", "msg_subcmd0x7_req", "msg_subcmd0x8_req_addtab" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null, null, Integer.valueOf(0), "", null, null, null }, ReqBody.class);
  public final PBInt32Field int32_plat_id = PBField.initInt32(0);
  public EmosmPb.SubCmd0x1ReqDelTab msg_subcmd0x1_req_deltab = new EmosmPb.SubCmd0x1ReqDelTab();
  public EmosmPb.SubCmd0x2ReqFetchTab msg_subcmd0x2_req_fetchtab = new EmosmPb.SubCmd0x2ReqFetchTab();
  public EmosmPb.SubCmd0x3ReqFetchBq msg_subcmd0x3_req_fetchbq = new EmosmPb.SubCmd0x3ReqFetchBq();
  public EmosmPb.SubCmd0x6Req msg_subcmd0x6_req = new EmosmPb.SubCmd0x6Req();
  public EmosmPb.SubCmd0x7Req msg_subcmd0x7_req = new EmosmPb.SubCmd0x7Req();
  public EmosmPb.SubCmd0x8ReqAddTab msg_subcmd0x8_req_addtab = new EmosmPb.SubCmd0x8ReqAddTab();
  public final PBStringField str_app_version = PBField.initString("");
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.ReqBody
 * JD-Core Version:    0.7.0.1
 */