package tencent.im.oidb.cmd0xa75;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xa75
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_authkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_red_packet_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint32_action = PBField.initUInt64(0L);
    public final PBUInt32Field uint32_cur_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_red_packet_total = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56 }, new String[] { "uint32_action", "uint64_from_uin", "uint64_to_uin", "uint32_cur_score", "bytes_red_packet_id", "bytes_authkey", "uint32_red_packet_total" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_authkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Integer> rpt_uint32_emoji_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_cur_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_red_packet_percent = PBField.initUInt32(0);
    public final PBUInt32Field uint32_red_packet_win = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rest_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_score_max = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 48, 56, 64, 72, 82 }, new String[] { "rpt_uint32_emoji_id", "uint32_status", "uint32_start_time", "uint32_rest_time", "uint32_score_max", "uint32_cur_score", "uint32_red_packet_percent", "uint32_red_packet_win", "bytes_authkey" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa75.oidb_0xa75
 * JD-Core Version:    0.7.0.1
 */