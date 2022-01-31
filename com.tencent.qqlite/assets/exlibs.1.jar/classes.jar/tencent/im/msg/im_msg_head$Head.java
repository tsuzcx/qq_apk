package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_head$Head
  extends MessageMicro
{
  public static final int MSG_C2C_HEAD_FIELD_NUMBER = 8;
  public static final int MSG_CS_HEAD_FIELD_NUMBER = 2;
  public static final int MSG_DELTA_HEAD_FIELD_NUMBER = 7;
  public static final int MSG_HTTPCONN_HEAD_FIELD_NUMBER = 4;
  public static final int MSG_INST_CTRL_FIELD_NUMBER = 10;
  public static final int MSG_LOGIN_SIG_FIELD_NUMBER = 6;
  public static final int MSG_S2C_HEAD_FIELD_NUMBER = 3;
  public static final int MSG_SCONN_HEAD_FIELD_NUMBER = 9;
  public static final int UINT32_HEAD_TYPE_FIELD_NUMBER = 1;
  public static final int UINT32_PAINT_FLAG_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58, 66, 74, 82 }, new String[] { "uint32_head_type", "msg_cs_head", "msg_s2c_head", "msg_httpconn_head", "uint32_paint_flag", "msg_login_sig", "msg_delta_head", "msg_c2c_head", "msg_sconn_head", "msg_inst_ctrl" }, new Object[] { Integer.valueOf(0), null, null, null, Integer.valueOf(0), null, null, null, null, null }, Head.class);
  public im_msg_head.C2CHead msg_c2c_head = new im_msg_head.C2CHead();
  public im_msg_head.CSHead msg_cs_head = new im_msg_head.CSHead();
  public im_msg_head.DeltaHead msg_delta_head = new im_msg_head.DeltaHead();
  public im_msg_head.HttpConnHead msg_httpconn_head = new im_msg_head.HttpConnHead();
  public im_msg_head.InstCtrl msg_inst_ctrl = new im_msg_head.InstCtrl();
  public im_msg_head.LoginSig msg_login_sig = new im_msg_head.LoginSig();
  public im_msg_head.S2CHead msg_s2c_head = new im_msg_head.S2CHead();
  public im_msg_head.SConnHead msg_sconn_head = new im_msg_head.SConnHead();
  public final PBUInt32Field uint32_head_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_paint_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_head.Head
 * JD-Core Version:    0.7.0.1
 */