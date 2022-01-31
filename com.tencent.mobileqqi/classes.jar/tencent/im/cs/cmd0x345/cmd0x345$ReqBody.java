package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x345$ReqBody
  extends MessageMicro
{
  public static final int MSG_SUBCMD_0X1_REQ_BODY_FIELD_NUMBER = 2;
  public static final int MSG_SUBCMD_0X2_REQ_BODY_FIELD_NUMBER = 3;
  public static final int MSG_SUBCMD_0X3_REQ_BODY_FIELD_NUMBER = 4;
  public static final int MSG_SUBCMD_0X4_REQ_BODY_FIELD_NUMBER = 5;
  public static final int MSG_SUBCMD_0X5_REQ_BODY_FIELD_NUMBER = 6;
  public static final int MSG_SUBCMD_0X6_REQ_BODY_FIELD_NUMBER = 7;
  public static final int MSG_SUBCMD_0X7_REQ_BODY_FIELD_NUMBER = 8;
  public static final int UINT32_SUB_CMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "uint32_sub_cmd", "msg_subcmd_0x1_req_body", "msg_subcmd_0x2_req_body", "msg_subcmd_0x3_req_body", "msg_subcmd_0x4_req_body", "msg_subcmd_0x5_req_body", "msg_subcmd_0x6_req_body", "msg_subcmd_0x7_req_body" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, null }, ReqBody.class);
  public cmd0x345.ReqBody.SubCmd0x1ReqBody msg_subcmd_0x1_req_body = new cmd0x345.ReqBody.SubCmd0x1ReqBody();
  public cmd0x345.ReqBody.SubCmd0x2ReqBody msg_subcmd_0x2_req_body = new cmd0x345.ReqBody.SubCmd0x2ReqBody();
  public cmd0x345.ReqBody.SubCmd0x3ReqBody msg_subcmd_0x3_req_body = new cmd0x345.ReqBody.SubCmd0x3ReqBody();
  public cmd0x345.ReqBody.SubCmd0x4ReqBody msg_subcmd_0x4_req_body = new cmd0x345.ReqBody.SubCmd0x4ReqBody();
  public cmd0x345.ReqBody.SubCmd0x5ReqBody msg_subcmd_0x5_req_body = new cmd0x345.ReqBody.SubCmd0x5ReqBody();
  public cmd0x345.ReqBody.SubCmd0x6ReqBody msg_subcmd_0x6_req_body = new cmd0x345.ReqBody.SubCmd0x6ReqBody();
  public cmd0x345.ReqBody.SubCmd0x7ReqBody msg_subcmd_0x7_req_body = new cmd0x345.ReqBody.SubCmd0x7ReqBody();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x345.cmd0x345.ReqBody
 * JD-Core Version:    0.7.0.1
 */