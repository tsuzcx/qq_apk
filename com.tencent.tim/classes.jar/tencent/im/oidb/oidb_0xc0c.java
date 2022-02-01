package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xc0c
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0xc0c.VideoSrcType msg_video_from_type = new oidb_0xc0c.VideoSrcType();
    public final PBUInt32Field uint32_task_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "uint64_uin", "uint32_task_type", "bytes_rowkey", "uint64_feeds_id", "msg_video_from_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), null }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_guide_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_is_task_completed = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_exec_task = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_show_progress = PBField.initUInt32(0);
    public final PBUInt32Field uint32_now_progress = PBField.initUInt32(0);
    public final PBUInt32Field uint32_original_progress = PBField.initUInt32(0);
    public final PBUInt32Field uint32_task_point = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_progress = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 56, 64 }, new String[] { "uint32_is_task_completed", "uint32_task_point", "bytes_guide_wording", "uint32_need_show_progress", "uint32_original_progress", "uint32_now_progress", "uint32_total_progress", "uint32_need_exec_task" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    }
  }
  
  public static final class VideoSrcType
    extends MessageMicro<VideoSrcType>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_source_type", "video_from_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, VideoSrcType.class);
    public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
    public final PBInt32Field video_from_type = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc0c
 * JD-Core Version:    0.7.0.1
 */