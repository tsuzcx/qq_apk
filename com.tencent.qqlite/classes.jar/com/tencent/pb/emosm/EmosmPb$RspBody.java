package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class EmosmPb$RspBody
  extends MessageMicro
{
  public static final int INT32_RESULT_FIELD_NUMBER = 2;
  public static final int MSG_SUBCMD0X1_RSP_DELTAB_FIELD_NUMBER = 3;
  public static final int MSG_SUBCMD0X2_RSP_FETCHTAB_FIELD_NUMBER = 4;
  public static final int MSG_SUBCMD0X3_RSP_FETCHBQ_FIELD_NUMBER = 5;
  public static final int MSG_SUBCMD0X5_RECOMMEND_FIELD_NUMBER = 6;
  public static final int MSG_SUBCMD0X6_COLLECT_AUTH_FIELD_NUMBER = 7;
  public static final int MSG_SUBCMD0X7_RSP_FIELD_NUMBER = 8;
  public static final int MSG_SUBCMD0X8_RSP_ADDTAB_FIELD_NUMBER = 9;
  public static final int MSG_SUBCMD0X9_RSP_FIELD_NUMBER = 10;
  public static final int UINT32_SUB_CMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "uint32_sub_cmd", "int32_result", "msg_subcmd0x1_rsp_deltab", "msg_subcmd0x2_rsp_fetchtab", "msg_subcmd0x3_rsp_fetchbq", "msg_subcmd0x5_recommend", "msg_subcmd0x6_collect_auth", "msg_subcmd0x7_rsp", "msg_subcmd0x8_rsp_addtab", "msg_subcmd0x9_rsp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, null, null }, RspBody.class);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public EmosmPb.SubCmd0x1RspDelTab msg_subcmd0x1_rsp_deltab = new EmosmPb.SubCmd0x1RspDelTab();
  public EmosmPb.SubCmd0x2RspFetchTab msg_subcmd0x2_rsp_fetchtab = new EmosmPb.SubCmd0x2RspFetchTab();
  public EmosmPb.SubCmd0x3RspFetchBq msg_subcmd0x3_rsp_fetchbq = new EmosmPb.SubCmd0x3RspFetchBq();
  public EmosmPb.SubCmd0x5RspBQRecommend msg_subcmd0x5_recommend = new EmosmPb.SubCmd0x5RspBQRecommend();
  public EmosmPb.SubCmd0x6Rsp msg_subcmd0x6_collect_auth = new EmosmPb.SubCmd0x6Rsp();
  public EmosmPb.SubCmd0x7Rsp msg_subcmd0x7_rsp = new EmosmPb.SubCmd0x7Rsp();
  public EmosmPb.SubCmd0x8RspAddTab msg_subcmd0x8_rsp_addtab = new EmosmPb.SubCmd0x8RspAddTab();
  public EmosmPb.SubCmd0x9BqAssocRsp msg_subcmd0x9_rsp = new EmosmPb.SubCmd0x9BqAssocRsp();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.RspBody
 * JD-Core Version:    0.7.0.1
 */