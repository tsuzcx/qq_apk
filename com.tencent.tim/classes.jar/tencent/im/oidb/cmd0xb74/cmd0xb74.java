package tencent.im.oidb.cmd0xb74;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xb74
{
  public static final class FusionBiuInfo
    extends MessageMicro<FusionBiuInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "bool_is_gray", "uint32_biu_count", "bool_is_biu", "uint64_feeds_id" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false), Long.valueOf(0L) }, FusionBiuInfo.class);
    public final PBBoolField bool_is_biu = PBField.initBool(false);
    public final PBBoolField bool_is_gray = PBField.initBool(false);
    public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  }
  
  public static final class LikeInfo
    extends MessageMicro<LikeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public cmd0xb74.FusionBiuInfo msg_fusion_biu_info = new cmd0xb74.FusionBiuInfo();
    public final PBUInt32Field uint32_is_like = PBField.initUInt32(0);
    public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "bytes_rowkey", "uint32_like_count", "uint32_is_like", "msg_fusion_biu_info" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null }, LikeInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_rowkey = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field uint32_need_fusion_biu_info = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_like_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_like_status = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "rpt_bytes_rowkey", "uint32_need_like_count", "uint32_need_like_status", "uint32_need_fusion_biu_info" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_like_info" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<cmd0xb74.LikeInfo> rpt_like_info = PBField.initRepeatMessage(cmd0xb74.LikeInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb74.cmd0xb74
 * JD-Core Version:    0.7.0.1
 */