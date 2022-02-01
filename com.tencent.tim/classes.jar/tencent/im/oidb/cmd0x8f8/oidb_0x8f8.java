package tencent.im.oidb.cmd0x8f8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.trunk.feeds_inner_define.feeds_inner_define.FaceRecordSet;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage.VoteRecord;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage.VoteStatistic;

public final class oidb_0x8f8
{
  public static final class LiteMailIndexInfo
    extends MessageMicro<LiteMailIndexInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x8f8.SourceID msg_source_id = new oidb_0x8f8.SourceID();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_feeds_id", "msg_source_id" }, new Object[] { localByteStringMicro, null }, LiteMailIndexInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106 }, new String[] { "msg_source_id", "msg_add_feeds", "msg_add_cmmnt", "msg_add_face", "msg_del_feeds", "msg_del_cmmnt", "msg_set_feeds_flag", "msg_add_visit", "msg_attend_vote", "msg_del_apic", "msg_set_theme", "msg_set_async_state", "msg_del_litemail_index" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null }, ReqBody.class);
    public oidb_0x8f8.SubCmd02AddCmmntReq msg_add_cmmnt = new oidb_0x8f8.SubCmd02AddCmmntReq();
    public oidb_0x8f8.SubCmd04AddFaceReq msg_add_face = new oidb_0x8f8.SubCmd04AddFaceReq();
    public oidb_0x8f8.SubCmd01AddFeedsReq msg_add_feeds = new oidb_0x8f8.SubCmd01AddFeedsReq();
    public oidb_0x8f8.SubCmd09AddVisitReq msg_add_visit = new oidb_0x8f8.SubCmd09AddVisitReq();
    public oidb_0x8f8.SubCmd16AttendVoteReq msg_attend_vote = new oidb_0x8f8.SubCmd16AttendVoteReq();
    public oidb_0x8f8.SubCmd17DelAPicUrlReq msg_del_apic = new oidb_0x8f8.SubCmd17DelAPicUrlReq();
    public oidb_0x8f8.SubCmd06DelCmmntReq msg_del_cmmnt = new oidb_0x8f8.SubCmd06DelCmmntReq();
    public oidb_0x8f8.SubCmd05DelFeedsReq msg_del_feeds = new oidb_0x8f8.SubCmd05DelFeedsReq();
    public oidb_0x8f8.SubCmd20DelLiteMailIndexReq msg_del_litemail_index = new oidb_0x8f8.SubCmd20DelLiteMailIndexReq();
    public oidb_0x8f8.SubCmd19SetAsyncMsgStateReq msg_set_async_state = new oidb_0x8f8.SubCmd19SetAsyncMsgStateReq();
    public oidb_0x8f8.SubCmd07SetFeedsFlagReq msg_set_feeds_flag = new oidb_0x8f8.SubCmd07SetFeedsFlagReq();
    public oidb_0x8f8.SubCmd18SetThemeStateReq msg_set_theme = new oidb_0x8f8.SubCmd18SetThemeStateReq();
    public oidb_0x8f8.SourceID msg_source_id = new oidb_0x8f8.SourceID();
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
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114 }, new String[] { "msg_source_id", "msg_result", "msg_add_feeds_rsp", "msg_add_cmmnt_rsp", "msg_add_face_rsp", "msg_del_feeds_rsp", "msg_del_cmmnt_rsp", "msg_set_feeds_flag_rsp", "msg_add_visit_rsp", "msg_attend_vote_rsp", "msg_del_apic_rsp", "msg_set_theme_rsp", "msg_set_asyncmsg_state_rsp", "msg_del_litemail_index_rsp" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null }, RspBody.class);
    public oidb_0x8f8.SubCmd02AddCmmntRsp msg_add_cmmnt_rsp = new oidb_0x8f8.SubCmd02AddCmmntRsp();
    public oidb_0x8f8.SubCmd04AddFaceRsp msg_add_face_rsp = new oidb_0x8f8.SubCmd04AddFaceRsp();
    public oidb_0x8f8.SubCmd01AddFeedsRsp msg_add_feeds_rsp = new oidb_0x8f8.SubCmd01AddFeedsRsp();
    public oidb_0x8f8.SubCmd09AddVisitRsp msg_add_visit_rsp = new oidb_0x8f8.SubCmd09AddVisitRsp();
    public oidb_0x8f8.SubCmd16AttendVoteRsp msg_attend_vote_rsp = new oidb_0x8f8.SubCmd16AttendVoteRsp();
    public oidb_0x8f8.SubCmd17DelAPicUrlRsp msg_del_apic_rsp = new oidb_0x8f8.SubCmd17DelAPicUrlRsp();
    public oidb_0x8f8.SubCmd06DelCmmntRsp msg_del_cmmnt_rsp = new oidb_0x8f8.SubCmd06DelCmmntRsp();
    public oidb_0x8f8.SubCmd05DelFeedsRsp msg_del_feeds_rsp = new oidb_0x8f8.SubCmd05DelFeedsRsp();
    public oidb_0x8f8.SubCmd20DelLiteMailIndexRsp msg_del_litemail_index_rsp = new oidb_0x8f8.SubCmd20DelLiteMailIndexRsp();
    public oidb_0x8f8.ResultMsg msg_result = new oidb_0x8f8.ResultMsg();
    public oidb_0x8f8.SubCmd19SetAsyncMsgStateRsp msg_set_asyncmsg_state_rsp = new oidb_0x8f8.SubCmd19SetAsyncMsgStateRsp();
    public oidb_0x8f8.SubCmd07SetFeedsFlagRsp msg_set_feeds_flag_rsp = new oidb_0x8f8.SubCmd07SetFeedsFlagRsp();
    public oidb_0x8f8.SubCmd18SetThemeStateRsp msg_set_theme_rsp = new oidb_0x8f8.SubCmd18SetThemeStateRsp();
    public oidb_0x8f8.SourceID msg_source_id = new oidb_0x8f8.SourceID();
  }
  
  public static final class SourceID
    extends MessageMicro<SourceID>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_source_type", "uint64_source_code" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, SourceID.class);
    public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_source_code = PBField.initUInt64(0L);
  }
  
  public static final class SubCmd01AddFeedsReq
    extends MessageMicro<SubCmd01AddFeedsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_feeds_type", "msg_feeds", "uint32_auto_pull_flag", "uint32_msg_type" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, SubCmd01AddFeedsReq.class);
    public group_feeds.GroupFeedsMessage msg_feeds = new group_feeds.GroupFeedsMessage();
    public final PBUInt32Field uint32_auto_pull_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  }
  
  public static final class SubCmd01AddFeedsRsp
    extends MessageMicro<SubCmd01AddFeedsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_feeds_id" }, new Object[] { localByteStringMicro }, SubCmd01AddFeedsRsp.class);
    }
  }
  
  public static final class SubCmd02AddCmmntReq
    extends MessageMicro<SubCmd02AddCmmntReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public group_feeds.GroupFeedsMessage msg_comment = new group_feeds.GroupFeedsMessage();
    public final PBRepeatField<Long> rpt_concern_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_cmmnt_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "bytes_feeds_id", "msg_comment", "uint32_cmmnt_id", "rpt_concern_uin" }, new Object[] { localByteStringMicro, null, Integer.valueOf(0), Long.valueOf(0L) }, SubCmd02AddCmmntReq.class);
    }
  }
  
  public static final class SubCmd02AddCmmntRsp
    extends MessageMicro<SubCmd02AddCmmntRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_cmmnt_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cmmnt_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_feeds_id", "uint32_cmmnt_id", "uint32_cmmnt_count" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, SubCmd02AddCmmntRsp.class);
    }
  }
  
  public static final class SubCmd04AddFaceReq
    extends MessageMicro<SubCmd04AddFaceReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_face_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_feeds_id", "uint32_face_type" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, SubCmd04AddFaceReq.class);
    }
  }
  
  public static final class SubCmd04AddFaceRsp
    extends MessageMicro<SubCmd04AddFaceRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public feeds_inner_define.FaceRecordSet msg_face_set = new feeds_inner_define.FaceRecordSet();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_feeds_id", "msg_face_set" }, new Object[] { localByteStringMicro, null }, SubCmd04AddFaceRsp.class);
    }
  }
  
  public static final class SubCmd05DelFeedsReq
    extends MessageMicro<SubCmd05DelFeedsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_del_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_edu_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_feeds_id", "uint32_del_type", "uint32_edu_id" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, SubCmd05DelFeedsReq.class);
    }
  }
  
  public static final class SubCmd05DelFeedsRsp
    extends MessageMicro<SubCmd05DelFeedsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_feeds_id" }, new Object[] { localByteStringMicro }, SubCmd05DelFeedsRsp.class);
    }
  }
  
  public static final class SubCmd06DelCmmntReq
    extends MessageMicro<SubCmd06DelCmmntReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_cmmnt_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_feeds_id", "uint32_cmmnt_id" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, SubCmd06DelCmmntReq.class);
    }
  }
  
  public static final class SubCmd06DelCmmntRsp
    extends MessageMicro<SubCmd06DelCmmntRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_cmmnt_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_feeds_id", "uint32_cmmnt_id" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, SubCmd06DelCmmntRsp.class);
    }
  }
  
  public static final class SubCmd07SetFeedsFlagReq
    extends MessageMicro<SubCmd07SetFeedsFlagReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_theme_state = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_feeds_id", "uint32_flag", "uint32_theme_state" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, SubCmd07SetFeedsFlagReq.class);
    }
  }
  
  public static final class SubCmd07SetFeedsFlagRsp
    extends MessageMicro<SubCmd07SetFeedsFlagRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_theme_state = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_feeds_id", "uint32_flag", "uint32_theme_state" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, SubCmd07SetFeedsFlagRsp.class);
    }
  }
  
  public static final class SubCmd09AddVisitReq
    extends MessageMicro<SubCmd09AddVisitReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_feeds_id" }, new Object[] { localByteStringMicro }, SubCmd09AddVisitReq.class);
    }
  }
  
  public static final class SubCmd09AddVisitRsp
    extends MessageMicro<SubCmd09AddVisitRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_visit_num = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_feeds_id", "uint32_visit_num" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, SubCmd09AddVisitRsp.class);
    }
  }
  
  public static final class SubCmd16AttendVoteReq
    extends MessageMicro<SubCmd16AttendVoteReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Integer> rpt_uint32_voteids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_feeds_id", "rpt_uint32_voteids" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, SubCmd16AttendVoteReq.class);
    }
  }
  
  public static final class SubCmd16AttendVoteRsp
    extends MessageMicro<SubCmd16AttendVoteRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Integer> rpt_uint32_voteids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatMessageField<group_feeds.GroupFeedsMessage.VoteRecord> rpt_vote_record = PBField.initRepeatMessage(group_feeds.GroupFeedsMessage.VoteRecord.class);
    public final PBRepeatMessageField<group_feeds.GroupFeedsMessage.VoteStatistic> rpt_vote_statistic = PBField.initRepeatMessage(group_feeds.GroupFeedsMessage.VoteStatistic.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 114, 122 }, new String[] { "bytes_feeds_id", "rpt_uint32_voteids", "rpt_vote_statistic", "rpt_vote_record" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null, null }, SubCmd16AttendVoteRsp.class);
    }
  }
  
  public static final class SubCmd17DelAPicUrlReq
    extends MessageMicro<SubCmd17DelAPicUrlReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_feeds_id", "bytes_pic_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, SubCmd17DelAPicUrlReq.class);
    }
  }
  
  public static final class SubCmd17DelAPicUrlRsp
    extends MessageMicro<SubCmd17DelAPicUrlRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_feeds_id", "bytes_pic_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, SubCmd17DelAPicUrlRsp.class);
    }
  }
  
  public static final class SubCmd18SetThemeStateReq
    extends MessageMicro<SubCmd18SetThemeStateReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_theme_state = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_feeds_id", "uint32_theme_state" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, SubCmd18SetThemeStateReq.class);
    }
  }
  
  public static final class SubCmd18SetThemeStateRsp
    extends MessageMicro<SubCmd18SetThemeStateRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_theme_state = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_feeds_id", "uint32_theme_state" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, SubCmd18SetThemeStateRsp.class);
    }
  }
  
  public static final class SubCmd19SetAsyncMsgStateReq
    extends MessageMicro<SubCmd19SetAsyncMsgStateReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_feeds_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field uint32_set_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_bytes_feeds_id", "uint32_set_type" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, SubCmd19SetAsyncMsgStateReq.class);
    }
  }
  
  public static final class SubCmd19SetAsyncMsgStateRsp
    extends MessageMicro<SubCmd19SetAsyncMsgStateRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_fail_feeds_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_success_feeds_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_bytes_success_feeds_id", "rpt_bytes_fail_feeds_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, SubCmd19SetAsyncMsgStateRsp.class);
    }
  }
  
  public static final class SubCmd20DelLiteMailIndexReq
    extends MessageMicro<SubCmd20DelLiteMailIndexReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_lite_mail_index" }, new Object[] { null }, SubCmd20DelLiteMailIndexReq.class);
    public final PBRepeatMessageField<oidb_0x8f8.LiteMailIndexInfo> rpt_msg_lite_mail_index = PBField.initRepeatMessage(oidb_0x8f8.LiteMailIndexInfo.class);
  }
  
  public static final class SubCmd20DelLiteMailIndexRsp
    extends MessageMicro<SubCmd20DelLiteMailIndexRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_msg_succ_lite_mail_index", "rpt_msg_fail_lite_mail_index" }, new Object[] { null, null }, SubCmd20DelLiteMailIndexRsp.class);
    public final PBRepeatMessageField<oidb_0x8f8.LiteMailIndexInfo> rpt_msg_fail_lite_mail_index = PBField.initRepeatMessage(oidb_0x8f8.LiteMailIndexInfo.class);
    public final PBRepeatMessageField<oidb_0x8f8.LiteMailIndexInfo> rpt_msg_succ_lite_mail_index = PBField.initRepeatMessage(oidb_0x8f8.LiteMailIndexInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f8.oidb_0x8f8
 * JD-Core Version:    0.7.0.1
 */