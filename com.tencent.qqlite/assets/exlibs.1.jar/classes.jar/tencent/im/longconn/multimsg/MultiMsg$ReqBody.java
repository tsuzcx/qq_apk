package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MultiMsg$ReqBody
  extends MessageMicro
{
  public static final int BYTES_BUILD_VER_FIELD_NUMBER = 5;
  public static final int RPT_MULTIMSG_APPLYDOWN_REQ_FIELD_NUMBER = 7;
  public static final int RPT_MULTIMSG_APPLYUP_REQ_FIELD_NUMBER = 6;
  public static final int UINT32_NET_TYPE_FIELD_NUMBER = 4;
  public static final int UINT32_PLATFORM_TYPE_FIELD_NUMBER = 3;
  public static final int UINT32_SUBCMD_FIELD_NUMBER = 1;
  public static final int UINT32_TERM_TYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_build_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField rpt_multimsg_applydown_req = PBField.initRepeatMessage(MultiMsg.MultiMsgApplyDownReq.class);
  public final PBRepeatMessageField rpt_multimsg_applyup_req = PBField.initRepeatMessage(MultiMsg.MultiMsgApplyUpReq.class);
  public final PBUInt32Field uint32_net_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_platform_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_term_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58 }, new String[] { "uint32_subcmd", "uint32_term_type", "uint32_platform_type", "uint32_net_type", "bytes_build_ver", "rpt_multimsg_applyup_req", "rpt_multimsg_applydown_req" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null, null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.longconn.multimsg.MultiMsg.ReqBody
 * JD-Core Version:    0.7.0.1
 */