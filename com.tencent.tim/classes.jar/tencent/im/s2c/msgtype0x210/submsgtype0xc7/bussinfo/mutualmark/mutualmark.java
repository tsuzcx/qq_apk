package tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mutualmark
{
  public static final class MutualmarkInfo
    extends MessageMicro<MutualmarkInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_duplicate_removal_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_resource_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wildcard_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_close_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_continue_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt64Field uint64_icon_status = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_icon_status_end_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_action_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_change_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_notify_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64, 72, 82, 8002 }, new String[] { "uint64_last_action_time", "uint32_level", "uint64_last_change_time", "uint32_continue_days", "bytes_wildcard_wording", "uint64_notify_time", "uint64_icon_status", "uint64_icon_status_end_time", "uint32_close_flag", "bytes_resource_info", "bytes_duplicate_removal_key" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3 }, MutualmarkInfo.class);
    }
  }
  
  public static final class ResourceInfo_17
    extends MessageMicro<ResourceInfo_17>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cartoon_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cartoon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_dynamic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_static_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_play_cartoon = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50 }, new String[] { "bytes_dynamic_url", "bytes_static_url", "bytes_cartoon_url", "bytes_cartoon_md5", "uint32_play_cartoon", "bytes_word" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5 }, ResourceInfo_17.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark.mutualmark
 * JD-Core Version:    0.7.0.1
 */