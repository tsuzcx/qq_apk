package tencent.im.oidb.oidb_0xde8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xde8
{
  public static final class CommentItem
    extends MessageMicro<CommentItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48 }, new String[] { "uint64_comment_id", "str_comment", "uint64_target_comment_id", "uint64_target_uin", "uint64_comment_uin", "uint64_time" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, CommentItem.class);
    public final PBStringField str_comment = PBField.initString("");
    public final PBUInt64Field uint64_comment_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_comment_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_target_comment_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_target_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  }
  
  public static final class NickInfo
    extends MessageMicro<NickInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feedid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0xde8.lightCommentInfo msg_light_comment = new oidb_0xde8.lightCommentInfo();
    public final PBRepeatMessageField<oidb_0xde8.CommentItem> rpt_item = PBField.initRepeatMessage(oidb_0xde8.CommentItem.class);
    public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_del_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mod_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58, 66 }, new String[] { "bytes_feedid", "bytes_nick", "uint32_type", "uint32_create_time", "uint32_mod_time", "uint32_del_time", "rpt_item", "msg_light_comment" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null }, NickInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 32, 40, 48, 56, 64, 80 }, new String[] { "uint64_to_uin", "uint32_check_fri_type", "uint32_start_time", "uint32_end_time", "uint32_type", "uint32_start", "uint32_num", "uint32_comment_size" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field uint32_check_fri_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comment_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_info", "uint32_is_over" }, new Object[] { null, Integer.valueOf(0) }, RspBody.class);
    public final PBRepeatMessageField<oidb_0xde8.NickInfo> rpt_info = PBField.initRepeatMessage(oidb_0xde8.NickInfo.class);
    public final PBUInt32Field uint32_is_over = PBField.initUInt32(0);
  }
  
  public static final class lightCommentInfo
    extends MessageMicro<lightCommentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_total_num", "rpt_items" }, new Object[] { Long.valueOf(0L), null }, lightCommentInfo.class);
    public final PBRepeatMessageField<oidb_0xde8.lightCommentItem> rpt_items = PBField.initRepeatMessage(oidb_0xde8.lightCommentItem.class);
    public final PBUInt64Field uint64_total_num = PBField.initUInt64(0L);
  }
  
  public static final class lightCommentItem
    extends MessageMicro<lightCommentItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "uint64_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, lightCommentItem.class);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xde8.oidb_0xde8
 * JD-Core Version:    0.7.0.1
 */