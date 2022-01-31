package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class C2CType0x211_SubC2CType0x8$RespAIOJudge
  extends MessageMicro
{
  public static final int BYTES_PEER_EXTRA_FIELD_NUMBER = 7;
  public static final int INT32_PEER_IP_FIELD_NUMBER = 5;
  public static final int INT32_PEER_PORT_FIELD_NUMBER = 6;
  public static final int MSG_HEAD_FIELD_NUMBER = 1;
  public static final int MSG_RESULT_FIELD_NUMBER = 2;
  public static final int UINT32_TIMEOUT_FIELD_NUMBER = 3;
  public static final int UINT64_TO_UIN_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_peer_extra = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_peer_ip = PBField.initInt32(0);
  public final PBInt32Field int32_peer_port = PBField.initInt32(0);
  public C2CType0x211_SubC2CType0x8.BusiRespHead msg_head = new C2CType0x211_SubC2CType0x8.BusiRespHead();
  public C2CType0x211_SubC2CType0x8.JudgeResult msg_result = new C2CType0x211_SubC2CType0x8.JudgeResult();
  public final PBUInt32Field uint32_timeout = PBField.initUInt32(0);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58 }, new String[] { "msg_head", "msg_result", "uint32_timeout", "uint64_to_uin", "int32_peer_ip", "int32_peer_port", "bytes_peer_extra" }, new Object[] { null, null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, RespAIOJudge.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8.RespAIOJudge
 * JD-Core Version:    0.7.0.1
 */