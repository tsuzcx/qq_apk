package tencent.im.s2c.msgtype0x211.submsgtype0x7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x7$MsgBody$MsgHeader
  extends MessageMicro
{
  public static final int UINT32_DST_APP_ID_FIELD_NUMBER = 3;
  public static final int UINT32_DST_INST_ID_FIELD_NUMBER = 4;
  public static final int UINT32_SRC_APP_ID_FIELD_NUMBER = 1;
  public static final int UINT32_SRC_INST_ID_FIELD_NUMBER = 2;
  public static final int UINT64_DST_UIN_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint32_src_app_id", "uint32_src_inst_id", "uint32_dst_app_id", "uint32_dst_inst_id", "uint64_dst_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, MsgHeader.class);
  public final PBUInt32Field uint32_dst_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_dst_inst_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_inst_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader
 * JD-Core Version:    0.7.0.1
 */