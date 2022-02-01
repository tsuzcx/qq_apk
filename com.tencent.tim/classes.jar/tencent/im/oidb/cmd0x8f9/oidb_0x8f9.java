package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.trunk.feeds_inner_define.feeds_inner_define.FaceRecordSet;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage;

public final class oidb_0x8f9
{
  public static final class ConcernUinInfo
    extends MessageMicro<ConcernUinInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_concern_uin", "uint32_confirm_time", "uint32_read_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ConcernUinInfo.class);
    public final PBUInt32Field uint32_confirm_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_read_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_concern_uin = PBField.initUInt64(0L);
  }
  
  public static final class FeedsState
    extends MessageMicro<FeedsState>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_concern_flag", "uint32_readed_flag", "uint32_ignored_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FeedsState.class);
    public final PBUInt32Field uint32_concern_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ignored_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_readed_flag = PBField.initUInt32(0);
  }
  
  public static final class GetAsyncMsgFeedsReq
    extends MessageMicro<GetAsyncMsgFeedsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_req_start", "uint32_req_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetAsyncMsgFeedsReq.class);
    public final PBInt32Field int32_req_start = PBField.initInt32(0);
    public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
  }
  
  public static final class GetCommentsByTopReq
    extends MessageMicro<GetCommentsByTopReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_req_start = PBField.initInt32(0);
    public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_feeds_id", "int32_req_start", "uint32_req_num" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, GetCommentsByTopReq.class);
    }
  }
  
  public static final class GetFeedsByIDReq
    extends MessageMicro<GetFeedsByIDReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_feeds_id" }, new Object[] { localByteStringMicro }, GetFeedsByIDReq.class);
    }
  }
  
  public static final class GetFeedsByTimeReq
    extends MessageMicro<GetFeedsByTimeReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_begin_time", "uint32_end_time", "uint32_req_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetFeedsByTimeReq.class);
    public final PBUInt32Field uint32_begin_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
  }
  
  public static final class GetFeedsByTopReq
    extends MessageMicro<GetFeedsByTopReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_req_start", "uint32_req_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetFeedsByTopReq.class);
    public final PBInt32Field int32_req_start = PBField.initInt32(0);
    public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
  }
  
  public static final class GetFeedsByTypeReq
    extends MessageMicro<GetFeedsByTypeReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_feeds_type", "int32_req_start", "uint32_req_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetFeedsByTypeReq.class);
    public final PBInt32Field int32_req_start = PBField.initInt32(0);
    public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
  }
  
  public static final class GetLatestNodeInfoReq
    extends MessageMicro<GetLatestNodeInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_node_type", "uint32_unread_count_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetLatestNodeInfoReq.class);
    public final PBUInt32Field uint32_node_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unread_count_flag = PBField.initUInt32(0);
  }
  
  public static final class GetLatestNodeInfoRsp
    extends MessageMicro<GetLatestNodeInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x8f9.LiteMailBrief msg_litemail_brief = new oidb_0x8f9.LiteMailBrief();
    public oidb_0x8f9.UnreadMailCountInfo msg_unread_cnt_info = new oidb_0x8f9.UnreadMailCountInfo();
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_result", "bytes_err_msg", "msg_litemail_brief", "msg_unread_cnt_info" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null }, GetLatestNodeInfoRsp.class);
    }
  }
  
  public static final class GetLiteMailListByUinReq
    extends MessageMicro<GetLiteMailListByUinReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint32_end_time", "rpt_msg_litemail_list", "uint32_amount", "msg_filter" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), null }, GetLiteMailListByUinReq.class);
    public oidb_0x8f9.LiteMailFilter msg_filter = new oidb_0x8f9.LiteMailFilter();
    public final PBRepeatMessageField<oidb_0x8f9.LiteMailBrief> rpt_msg_litemail_list = PBField.initRepeatMessage(oidb_0x8f9.LiteMailBrief.class);
    public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
    public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
  }
  
  public static final class GetLiteMailListByUinRsp
    extends MessageMicro<GetLiteMailListByUinRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x8f9.LiteMail> rpt_msg_litemail_list = PBField.initRepeatMessage(oidb_0x8f9.LiteMail.class);
    public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "uint32_start_time", "uint32_end_time", "rpt_msg_litemail_list", "uint32_result", "bytes_err_msg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro }, GetLiteMailListByUinRsp.class);
    }
  }
  
  public static final class GroupFeedsCommentRecord
    extends MessageMicro<GroupFeedsCommentRecord>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public group_feeds.GroupFeedsMessage msg_comment_content = new group_feeds.GroupFeedsMessage();
    public oidb_0x8f9.SourceID msg_source_id = new oidb_0x8f9.SourceID();
    public final PBUInt32Field uint32_comment_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comment_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_modify_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 66, 74 }, new String[] { "bytes_feeds_id", "msg_source_id", "uint64_from_uin", "uint32_comment_id", "uint32_comment_flag", "uint32_create_time", "uint32_modify_time", "bytes_reserve", "msg_comment_content" }, new Object[] { localByteStringMicro1, null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, null }, GroupFeedsCommentRecord.class);
    }
  }
  
  public static final class GroupFeedsRecord
    extends MessageMicro<GroupFeedsRecord>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public feeds_inner_define.FaceRecordSet msg_face_record = new feeds_inner_define.FaceRecordSet();
    public group_feeds.GroupFeedsMessage msg_feeds_content = new group_feeds.GroupFeedsMessage();
    public oidb_0x8f9.FeedsState msg_feeds_state = new oidb_0x8f9.FeedsState();
    public oidb_0x8f9.SourceID msg_source_id = new oidb_0x8f9.SourceID();
    public final PBRepeatMessageField<oidb_0x8f9.ConcernUinInfo> rpt_concern_uin_info = PBField.initRepeatMessage(oidb_0x8f9.ConcernUinInfo.class);
    public final PBRepeatMessageField<oidb_0x8f9.GroupFeedsCommentRecord> rpt_msg_comments = PBField.initRepeatMessage(oidb_0x8f9.GroupFeedsCommentRecord.class);
    public final PBUInt32Field uint32_comment_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_feeds_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_modify_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_visit_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 56, 64, 72, 82, 90, 98, 106, 114, 122 }, new String[] { "msg_source_id", "uint64_from_uin", "uint32_feeds_type", "bytes_feeds_id", "uint32_feeds_flag", "uint32_create_time", "uint32_modify_time", "uint32_visit_count", "uint32_comment_num", "bytes_reserve", "msg_face_record", "msg_feeds_content", "rpt_msg_comments", "rpt_concern_uin_info", "msg_feeds_state" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, null, null, null, null, null }, GroupFeedsRecord.class);
    }
  }
  
  public static final class LiteMail
    extends MessageMicro<LiteMail>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_mail", "uint32_result" }, new Object[] { null, Integer.valueOf(0) }, LiteMail.class);
    public oidb_0x8f9.GroupFeedsRecord msg_mail = new oidb_0x8f9.GroupFeedsRecord();
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  }
  
  public static final class LiteMailBrief
    extends MessageMicro<LiteMailBrief>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_feeds_summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x8f9.SourceID msg_source_id = new oidb_0x8f9.SourceID();
    public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_last_modify_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_my_read_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_summary_truncate_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58, 64 }, new String[] { "bytes_feeds_id", "msg_source_id", "uint32_last_modify_time", "uint32_create_time", "uint32_my_read_status", "uint64_author_uin", "bytes_feeds_summary", "uint32_summary_truncate_flag" }, new Object[] { localByteStringMicro1, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0) }, LiteMailBrief.class);
    }
  }
  
  public static final class LiteMailFilter
    extends MessageMicro<LiteMailFilter>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_filter_type" }, new Object[] { Integer.valueOf(0) }, LiteMailFilter.class);
    public final PBUInt32Field uint32_filter_type = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98 }, new String[] { "msg_source_id", "msg_req_by_top", "msg_req_by_time", "msg_req_by_id", "msg_req_comment_by_top", "msg_req_by_type", "msg_req_get_theme_list", "msg_req_themecont_by_top", "msg_req_async_feeds", "msg_req_get_litemail_list_by_uin", "msg_set_all_litemail_readed_by_endtime", "msg_req_get_latest_node_info" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null }, ReqBody.class);
    public oidb_0x8f9.GetAsyncMsgFeedsReq msg_req_async_feeds = new oidb_0x8f9.GetAsyncMsgFeedsReq();
    public oidb_0x8f9.GetFeedsByIDReq msg_req_by_id = new oidb_0x8f9.GetFeedsByIDReq();
    public oidb_0x8f9.GetFeedsByTimeReq msg_req_by_time = new oidb_0x8f9.GetFeedsByTimeReq();
    public oidb_0x8f9.GetFeedsByTopReq msg_req_by_top = new oidb_0x8f9.GetFeedsByTopReq();
    public oidb_0x8f9.GetFeedsByTypeReq msg_req_by_type = new oidb_0x8f9.GetFeedsByTypeReq();
    public oidb_0x8f9.GetCommentsByTopReq msg_req_comment_by_top = new oidb_0x8f9.GetCommentsByTopReq();
    public oidb_0x8f9.GetLatestNodeInfoReq msg_req_get_latest_node_info = new oidb_0x8f9.GetLatestNodeInfoReq();
    public oidb_0x8f9.GetLiteMailListByUinReq msg_req_get_litemail_list_by_uin = new oidb_0x8f9.GetLiteMailListByUinReq();
    public oidb_0x8f9.GetFeedsByTopReq msg_req_get_theme_list = new oidb_0x8f9.GetFeedsByTopReq();
    public oidb_0x8f9.GetCommentsByTopReq msg_req_themecont_by_top = new oidb_0x8f9.GetCommentsByTopReq();
    public oidb_0x8f9.SetAllLiteMailReadedByEndTimeReq msg_set_all_litemail_readed_by_endtime = new oidb_0x8f9.SetAllLiteMailReadedByEndTimeReq();
    public oidb_0x8f9.SourceID msg_source_id = new oidb_0x8f9.SourceID();
  }
  
  public static final class ResultMsg
    extends MessageMicro<ResultMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "bytes_err_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, ResultMsg.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 66, 74, 82 }, new String[] { "msg_source_id", "msg_result_msg", "rpt_feeds_recored", "rpt_feeds_comments", "uint32_last_modify_time", "uint32_feeds_rsp_flag", "uint32_unread_num", "msg_litemail_list", "msg_set_all_litemail_readed_by_endtime", "msg_rsp_get_latest_node_info" }, new Object[] { null, null, null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null }, RspBody.class);
    public oidb_0x8f9.GetLiteMailListByUinRsp msg_litemail_list = new oidb_0x8f9.GetLiteMailListByUinRsp();
    public oidb_0x8f9.ResultMsg msg_result_msg = new oidb_0x8f9.ResultMsg();
    public oidb_0x8f9.GetLatestNodeInfoRsp msg_rsp_get_latest_node_info = new oidb_0x8f9.GetLatestNodeInfoRsp();
    public oidb_0x8f9.SetAllLiteMailReadedByEndTimeRsp msg_set_all_litemail_readed_by_endtime = new oidb_0x8f9.SetAllLiteMailReadedByEndTimeRsp();
    public oidb_0x8f9.SourceID msg_source_id = new oidb_0x8f9.SourceID();
    public final PBRepeatMessageField<oidb_0x8f9.GroupFeedsCommentRecord> rpt_feeds_comments = PBField.initRepeatMessage(oidb_0x8f9.GroupFeedsCommentRecord.class);
    public final PBRepeatMessageField<oidb_0x8f9.GroupFeedsRecord> rpt_feeds_recored = PBField.initRepeatMessage(oidb_0x8f9.GroupFeedsRecord.class);
    public final PBUInt32Field uint32_feeds_rsp_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_last_modify_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unread_num = PBField.initUInt32(0);
  }
  
  public static final class SetAllLiteMailReadedByEndTimeReq
    extends MessageMicro<SetAllLiteMailReadedByEndTimeReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_end_time" }, new Object[] { Integer.valueOf(0) }, SetAllLiteMailReadedByEndTimeReq.class);
    public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
  }
  
  public static final class SetAllLiteMailReadedByEndTimeRsp
    extends MessageMicro<SetAllLiteMailReadedByEndTimeRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "bytes_err_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, SetAllLiteMailReadedByEndTimeRsp.class);
    }
  }
  
  public static final class SourceID
    extends MessageMicro<SourceID>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_source_type", "uint64_source_code" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, SourceID.class);
    public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_source_code = PBField.initUInt64(0L);
  }
  
  public static final class UnreadMailCountInfo
    extends MessageMicro<UnreadMailCountInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_uin", "uint32_unread_count", "uint32_data_version" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, UnreadMailCountInfo.class);
    public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unread_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f9.oidb_0x8f9
 * JD-Core Version:    0.7.0.1
 */