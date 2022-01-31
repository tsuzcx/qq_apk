package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x7ca$RspBody
  extends MessageMicro
{
  public static final int BYTES_SIGC2C_FIELD_NUMBER = 1;
  public static final int STR_ERROR_WORDING_FIELD_NUMBER = 3;
  public static final int UINT32_OP_TYPE_FIELD_NUMBER = 4;
  public static final int UINT64_PEER_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_SigC2C = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_error_wording = PBField.initString("");
  public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_peer_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "bytes_SigC2C", "uint64_peer_uin", "str_error_wording", "uint32_op_type" }, new Object[] { localByteStringMicro, Long.valueOf(0L), "", Integer.valueOf(0) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7ca.RspBody
 * JD-Core Version:    0.7.0.1
 */