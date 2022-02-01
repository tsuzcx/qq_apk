package tencent.im.oidb.cmd0xd50;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0xd50
{
  public static final class ExtSnsFrdData
    extends MessageMicro<ExtSnsFrdData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ksing_switch = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_lbs_share = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_music_switch = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_mutualmark_alienation = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_mutualmark_score = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field frd_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 728010, 808010, 1128010, 1208010, 1448010 }, new String[] { "frd_uin", "bytes_music_switch", "bytes_mutualmark_alienation", "bytes_mutualmark_score", "bytes_ksing_switch", "bytes_lbs_share" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, ExtSnsFrdData.class);
    }
  }
  
  public static final class KSingRelationInfo
    extends MessageMicro<KSingRelationInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "flag" }, new Object[] { Integer.valueOf(0) }, KSingRelationInfo.class);
    public final PBUInt32Field flag = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 728008, 808008, 1128008, 1208008, 1448008 }, new String[] { "appid", "max_pkg_size", "start_time", "start_index", "req_num", "rpt_uin_list", "req_music_switch", "req_mutualmark_alienation", "req_mutualmark_score", "req_ksing_switch", "req_mutualmark_lbsshare" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt64Field appid = PBField.initUInt64(0L);
    public final PBUInt32Field max_pkg_size = PBField.initUInt32(0);
    public final PBUInt32Field req_ksing_switch = PBField.initUInt32(0);
    public final PBUInt32Field req_music_switch = PBField.initUInt32(0);
    public final PBUInt32Field req_mutualmark_alienation = PBField.initUInt32(0);
    public final PBUInt32Field req_mutualmark_lbsshare = PBField.initUInt32(0);
    public final PBUInt32Field req_mutualmark_score = PBField.initUInt32(0);
    public final PBUInt32Field req_num = PBField.initUInt32(0);
    public final PBRepeatField<Long> rpt_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field start_index = PBField.initUInt32(0);
    public final PBUInt32Field start_time = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 88, 96, 104 }, new String[] { "rpt_msg_update_data", "uint32_over", "uint32_next_start", "rpt_uint64_unfinished_uins" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, RspBody.class);
    public final PBRepeatMessageField<Oidb_0xd50.ExtSnsFrdData> rpt_msg_update_data = PBField.initRepeatMessage(Oidb_0xd50.ExtSnsFrdData.class);
    public final PBRepeatField<Long> rpt_uint64_unfinished_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_next_start = PBField.initUInt32(0);
    public final PBUInt32Field uint32_over = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd50.Oidb_0xd50
 * JD-Core Version:    0.7.0.1
 */