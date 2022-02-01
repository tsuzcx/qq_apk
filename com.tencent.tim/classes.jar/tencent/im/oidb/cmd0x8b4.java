package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group.group_label.GroupLabel.Label;

public final class cmd0x8b4
{
  public static final class GroupInfo
    extends MessageMicro<GroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rich_intro = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_text_intro = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<GroupLabel.Label> rpt_group_label = PBField.initRepeatMessage(GroupLabel.Label.class);
    public final PBStringField str_face_url = PBField.initString("");
    public final PBStringField str_group_name = PBField.initString("");
    public final PBUInt32Field uint32_set_display_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_gc = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58 }, new String[] { "uint64_gc", "str_group_name", "str_face_url", "uint32_set_display_time", "rpt_group_label", "bytes_text_intro", "bytes_rich_intro" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), null, localByteStringMicro1, localByteStringMicro2 }, GroupInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_tag = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_cnt = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_gc = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_guin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 168, 176, 184, 194 }, new String[] { "uint64_gc", "uint64_guin", "uint32_flag", "uint64_dst_uin", "uint32_start", "uint32_cnt", "bytes_tag" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_tag = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> bytes_text_label = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatMessageField<cmd0x8b4.GroupInfo> rpt_group_info = PBField.initRepeatMessage(cmd0x8b4.GroupInfo.class);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 170, 178, 186 }, new String[] { "uint32_result", "uint32_flag", "bytes_tag", "rpt_group_info", "bytes_text_label" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, null, localByteStringMicro2 }, RspBody.class);
    }
  }
  
  public static final class TagInfo
    extends MessageMicro<TagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_dst_uin", "uint32_start", "uint32_cnt", "uint32_timestamp", "uint32_0x7dd_seq" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, TagInfo.class);
    public final PBUInt32Field uint32_0x7dd_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cnt = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8b4
 * JD-Core Version:    0.7.0.1
 */