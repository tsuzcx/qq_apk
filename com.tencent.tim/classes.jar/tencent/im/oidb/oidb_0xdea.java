package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xdea
{
  public static final class AddBarrageReqBody
    extends MessageMicro<AddBarrageReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_group_code", "comment", "topic" }, new Object[] { Long.valueOf(0L), null, null }, AddBarrageReqBody.class);
    public oidb_0xdea.Comment comment = new oidb_0xdea.Comment();
    public oidb_0xdea.Topic topic = new oidb_0xdea.Topic();
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class AddBarrageRspBody
    extends MessageMicro<AddBarrageRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_ret_code", "str_err_msg", "str_wording" }, new Object[] { Integer.valueOf(0), "", "" }, AddBarrageRspBody.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_err_msg = PBField.initString("");
    public final PBStringField str_wording = PBField.initString("");
  }
  
  public static final class Comment
    extends MessageMicro<Comment>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_comment_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pass_through = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_comment_ctime = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt64Field uint64_comment_location = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_comment_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 24, 32, 42, 50, 56, 66, 72 }, new String[] { "uint64_comment_uin", "uint64_seq", "uint64_comment_location", "bytes_comment_msg", "bytes_pass_through", "uint32_comment_ctime", "bytes_nick", "uint32_source" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0) }, Comment.class);
    }
  }
  
  public static final class DeleteBarrageReqBody
    extends MessageMicro<DeleteBarrageReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_group_code", "uint32_group_seq", "uint64_delete_uin", "uint64_send_uin", "uint32_barrage_flag" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, DeleteBarrageReqBody.class);
    public final PBUInt32Field uint32_barrage_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint32_group_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_delete_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_send_uin = PBField.initUInt64(0L);
  }
  
  public static final class DeleteBarrageRspBody
    extends MessageMicro<DeleteBarrageRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_ret_code", "str_err_msg", "str_wording" }, new Object[] { Integer.valueOf(0), "", "" }, DeleteBarrageRspBody.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_err_msg = PBField.initString("");
    public final PBStringField str_wording = PBField.initString("");
  }
  
  public static final class GetBarrageListReqBody
    extends MessageMicro<GetBarrageListReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72 }, new String[] { "uint64_group_code", "uint64_barrage_seq", "uint32_last_update_time", "uint32_start_index", "uint32_barrage_count", "uint32_video_start_time", "uint32_video_end_time", "entrance", "terminal" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) }, GetBarrageListReqBody.class);
    public final PBEnumField entrance = PBField.initEnum(1);
    public final PBEnumField terminal = PBField.initEnum(0);
    public final PBUInt32Field uint32_barrage_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_last_update_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_end_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_start_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_barrage_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class GetBarrageListRspBody
    extends MessageMicro<GetBarrageListRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 56, 66, 72, 88, 96 }, new String[] { "int32_ret_code", "str_err_msg", "str_wording", "bool_is_end", "uint32_total_count", "uint32_next_start_index", "rpt_comment_list", "rpt_recall_del_seq_list", "uint32_last_update_time", "uint32_time_interval" }, new Object[] { Integer.valueOf(0), "", "", Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, GetBarrageListRspBody.class);
    public final PBBoolField bool_is_end = PBField.initBool(false);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBRepeatMessageField<oidb_0xdea.Comment> rpt_comment_list = PBField.initRepeatMessage(oidb_0xdea.Comment.class);
    public final PBRepeatField<Long> rpt_recall_del_seq_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBStringField str_err_msg = PBField.initString("");
    public final PBStringField str_wording = PBField.initString("");
    public final PBUInt32Field uint32_last_update_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_start_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time_interval = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
  }
  
  public static final class GetCommentReqBody
    extends MessageMicro<GetCommentReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GetCommentReqBody.class);
  }
  
  public static final class GetCommentRspBody
    extends MessageMicro<GetCommentRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GetCommentRspBody.class);
  }
  
  public static final class GetTopicReqBody
    extends MessageMicro<GetTopicReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GetTopicReqBody.class);
  }
  
  public static final class GetTopicRspBody
    extends MessageMicro<GetTopicRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GetTopicRspBody.class);
  }
  
  public static final class PassThrough
    extends MessageMicro<PassThrough>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "entrance", "uint32_client_type" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0) }, PassThrough.class);
    public final PBEnumField entrance = PBField.initEnum(1);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  }
  
  public static final class RecallBarrageReqBody
    extends MessageMicro<RecallBarrageReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_group_code", "uint32_group_seq", "uint64_recall_uin", "uint64_send_uin", "uint32_barrage_flag" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, RecallBarrageReqBody.class);
    public final PBUInt32Field uint32_barrage_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint32_group_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_recall_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_send_uin = PBField.initUInt64(0L);
  }
  
  public static final class RecallBarrageRspBody
    extends MessageMicro<RecallBarrageRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_ret_code", "str_err_msg", "str_wording" }, new Object[] { Integer.valueOf(0), "", "" }, RecallBarrageRspBody.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_err_msg = PBField.initString("");
    public final PBStringField str_wording = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "add_barrage_req", "get_barrage_list_req", "rpt_recall_barrage_req_list", "rpt_delete_barrage_req_list", "get_topic_req", "get_comment_req" }, new Object[] { null, null, null, null, null, null }, ReqBody.class);
    public oidb_0xdea.AddBarrageReqBody add_barrage_req = new oidb_0xdea.AddBarrageReqBody();
    public oidb_0xdea.GetBarrageListReqBody get_barrage_list_req = new oidb_0xdea.GetBarrageListReqBody();
    public oidb_0xdea.GetCommentReqBody get_comment_req = new oidb_0xdea.GetCommentReqBody();
    public oidb_0xdea.GetTopicReqBody get_topic_req = new oidb_0xdea.GetTopicReqBody();
    public final PBRepeatMessageField<oidb_0xdea.DeleteBarrageReqBody> rpt_delete_barrage_req_list = PBField.initRepeatMessage(oidb_0xdea.DeleteBarrageReqBody.class);
    public final PBRepeatMessageField<oidb_0xdea.RecallBarrageReqBody> rpt_recall_barrage_req_list = PBField.initRepeatMessage(oidb_0xdea.RecallBarrageReqBody.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "add_barrage_rsp", "get_barrage_list_rsp", "rpt_recall_barrage_rsp_list", "rpt_delete_barrage_rsp_list", "get_topic_rsp", "get_comment_rsp" }, new Object[] { null, null, null, null, null, null }, RspBody.class);
    public oidb_0xdea.AddBarrageRspBody add_barrage_rsp = new oidb_0xdea.AddBarrageRspBody();
    public oidb_0xdea.GetBarrageListRspBody get_barrage_list_rsp = new oidb_0xdea.GetBarrageListRspBody();
    public oidb_0xdea.GetCommentRspBody get_comment_rsp = new oidb_0xdea.GetCommentRspBody();
    public oidb_0xdea.GetTopicRspBody get_topic_rsp = new oidb_0xdea.GetTopicRspBody();
    public final PBRepeatMessageField<oidb_0xdea.DeleteBarrageRspBody> rpt_delete_barrage_rsp_list = PBField.initRepeatMessage(oidb_0xdea.DeleteBarrageRspBody.class);
    public final PBRepeatMessageField<oidb_0xdea.RecallBarrageRspBody> rpt_recall_barrage_rsp_list = PBField.initRepeatMessage(oidb_0xdea.RecallBarrageRspBody.class);
  }
  
  public static final class Topic
    extends MessageMicro<Topic>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_src_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField entrance = PBField.initEnum(1);
    public final PBUInt32Field uint32_send_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_send_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint64_send_uin", "uint64_seq", "uint32_send_time", "entrance", "bytes_src_msg" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(1), localByteStringMicro }, Topic.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xdea
 * JD-Core Version:    0.7.0.1
 */