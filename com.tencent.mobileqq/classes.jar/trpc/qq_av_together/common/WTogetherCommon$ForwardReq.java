package trpc.qq_av_together.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WTogetherCommon$ForwardReq
  extends MessageMicro<ForwardReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field client_type = PBField.initUInt32(0);
  public final PBUInt64Field dst_uin = PBField.initUInt64(0L);
  public final PBBytesField file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField file_name = PBField.initString("");
  public final PBUInt64Field file_size = PBField.initUInt64(0L);
  public final PBUInt64Field src_group = PBField.initUInt64(0L);
  public final PBBytesField src_parentfolder = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field src_svcid = PBField.initUInt32(0);
  public final PBUInt64Field src_uin = PBField.initUInt64(0L);
  public final PBBytesField src_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 56, 64, 74, 80 }, new String[] { "src_uin", "src_group", "src_svcid", "src_parentfolder", "src_uuid", "file_md5", "dst_uin", "file_size", "file_name", "client_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0) }, ForwardReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_av_together.common.WTogetherCommon.ForwardReq
 * JD-Core Version:    0.7.0.1
 */