package tencent.im.oidb.cmd0xe2a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe2a
{
  public static final class AddVideoReq
    extends MessageMicro<AddVideoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_video_list" }, new Object[] { null }, AddVideoReq.class);
    public final PBRepeatMessageField<oidb_0xe2a.UgcVideoInfo> rpt_video_list = PBField.initRepeatMessage(oidb_0xe2a.UgcVideoInfo.class);
  }
  
  public static final class AddVideoRsp
    extends MessageMicro<AddVideoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> rpt_rowkey_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_rowkey_list" }, new Object[] { localByteStringMicro }, AddVideoRsp.class);
    }
  }
  
  public static final class MoveVideoReq
    extends MessageMicro<MoveVideoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> rpt_rowkey_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field uint32_column_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_oper_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "rpt_rowkey_list", "uint32_column_id", "uint32_oper_type" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, MoveVideoReq.class);
    }
  }
  
  public static final class MoveVideoRsp
    extends MessageMicro<MoveVideoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], MoveVideoRsp.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_add_video_req", "msg_move_video_req" }, new Object[] { null, null }, ReqBody.class);
    public oidb_0xe2a.AddVideoReq msg_add_video_req = new oidb_0xe2a.AddVideoReq();
    public oidb_0xe2a.MoveVideoReq msg_move_video_req = new oidb_0xe2a.MoveVideoReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_add_video_rsp", "msg_move_video_rsp" }, new Object[] { null, null }, RspBody.class);
    public oidb_0xe2a.AddVideoRsp msg_add_video_rsp = new oidb_0xe2a.AddVideoRsp();
    public oidb_0xe2a.MoveVideoRsp msg_move_video_rsp = new oidb_0xe2a.MoveVideoRsp();
  }
  
  public static final class UgcVideoInfo
    extends MessageMicro<UgcVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_brief = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_cover_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cover_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
    public final PBUInt32Field uint32_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_remind_friends = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reprint_disable = PBField.initUInt32(0);
    public final PBUInt32Field uint32_width = PBField.initUInt32(0);
    public final PBUInt64Field uint64_column_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 64, 72, 80, 90, 98, 104, 112 }, new String[] { "bytes_title", "bytes_url", "bytes_cover_url", "uint32_cover_width", "uint32_cover_height", "uint64_column_id", "uint32_duration", "uint32_width", "uint32_height", "uint64_file_size", "bytes_file_md5", "bytes_brief", "uint32_reprint_disable", "uint32_remind_friends" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0) }, UgcVideoInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe2a.oidb_0xe2a
 * JD-Core Version:    0.7.0.1
 */