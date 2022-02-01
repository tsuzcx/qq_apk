package tencent.im.oidb.cmd0x83e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.feeds_info.BiuMultiLevel;
import tencent.im.oidb.articlesummary.feeds_info.BuluoInfo;
import tencent.im.oidb.articlesummary.feeds_info.LocationInfo;
import tencent.im.oidb.articlesummary.feeds_info.NowLiveInfo;
import tencent.im.oidb.articlesummary.feeds_info.PGCFeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.ShareWebPageInfo;
import tencent.im.oidb.articlesummary.feeds_info.SocializeFeedsExtInfo;
import tencent.im.oidb.articlesummary.feeds_info.SocializeFeedsInfoUser;
import tencent.im.oidb.articlesummary.feeds_info.TopicRecommendFeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCFeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.VerifyResult;
import tencent.im.oidb.articlesummary.feeds_info.VisibleInfo;

public final class oidb_cmd0x83e
{
  public static final class CommentExtInfo
    extends MessageMicro<CommentExtInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_comment_gif" }, new Object[] { null }, CommentExtInfo.class);
    public final PBRepeatMessageField<oidb_cmd0x83e.OneCommentGif> rpt_comment_gif = PBField.initRepeatMessage(oidb_cmd0x83e.OneCommentGif.class);
  }
  
  public static final class FeedsInfo
    extends MessageMicro<FeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_business_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_business_name_prefix = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_business_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_ugc_src = PBField.initEnum(0);
    public final PBEnumField feeds_type = PBField.initEnum(0);
    public oidb_cmd0x83e.SocializeFeedsInfo msg_social_feeds_info = new oidb_cmd0x83e.SocializeFeedsInfo();
    public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 90, 160 }, new String[] { "feeds_type", "uint32_business_id", "bytes_business_name", "bytes_business_url", "bytes_business_name_prefix", "msg_social_feeds_info", "enum_ugc_src" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, Integer.valueOf(0) }, FeedsInfo.class);
    }
  }
  
  public static final class OneCommentGif
    extends MessageMicro<OneCommentGif>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_gif_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_gif_url", "bytes_pic_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, OneCommentGif.class);
    }
  }
  
  public static final class PGCFuns
    extends MessageMicro<PGCFuns>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_fan_uin" }, new Object[] { Long.valueOf(0L) }, PGCFuns.class);
    public final PBUInt64Field uint64_fan_uin = PBField.initUInt64(0L);
  }
  
  public static final class PGCSubmitPara
    extends MessageMicro<PGCSubmitPara>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "uint64_puin", "rpt_pgc_fans_list" }, new Object[] { Long.valueOf(0L), null }, PGCSubmitPara.class);
    public final PBRepeatMessageField<oidb_cmd0x83e.PGCFuns> rpt_pgc_fans_list = PBField.initRepeatMessage(oidb_cmd0x83e.PGCFuns.class);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
  }
  
  public static final class PgcParam
    extends MessageMicro<PgcParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_puin", "uint64_insert_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, PgcParam.class);
    public final PBUInt64Field uint64_insert_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
  }
  
  public static final class QAReqParam
    extends MessageMicro<QAReqParam>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_question_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_refer = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_refer", "bytes_question_desc" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, QAReqParam.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_is_master = PBField.initBool(false);
    public final PBBytesField bytes_comment = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_comment_gif_thumbnail_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_comment_gif_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_comment_pic_type = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_extra_json_params = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_inner_uniq_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_parent_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_req_seq = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sub_comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_biu_src = PBField.initEnum(1);
    public final PBEnumField enum_ugc_src = PBField.initEnum(0);
    public oidb_cmd0x83e.FeedsInfo msg_feeds_info = new oidb_cmd0x83e.FeedsInfo();
    public oidb_cmd0x83e.PGCSubmitPara msg_pgc_submit_para = new oidb_cmd0x83e.PGCSubmitPara();
    public oidb_cmd0x83e.PgcParam pgc_param = new oidb_cmd0x83e.PgcParam();
    public oidb_cmd0x83e.QAReqParam qa_req_param = new oidb_cmd0x83e.QAReqParam();
    public final PBUInt32Field resend_times = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_comment_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatMessageField<oidb_cmd0x83e.SecondLevelComment> rpt_second_level_comment_list = PBField.initRepeatMessage(oidb_cmd0x83e.SecondLevelComment.class);
    public final PBUInt32Field uint32_comment_content_src = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comment_src = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_one_touch_biu = PBField.initUInt32(0);
    public final PBUInt32Field uint32_op_new_comment_system = PBField.initUInt32(0);
    public final PBUInt32Field uint32_operation = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_reply_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 58, 64, 72, 82, 88, 98, 106, 114, 128, 138, 146, 154, 162, 170, 240, 250, 258, 266, 272, 282, 328, 336 }, new String[] { "uint64_uin", "uint32_operation", "uint64_feeds_id", "bytes_comment", "bytes_parent_id", "uint64_reply_uin", "rpt_bytes_comment_id", "resend_times", "bool_is_master", "msg_feeds_info", "enum_biu_src", "bytes_inner_uniq_id", "msg_pgc_submit_para", "rpt_second_level_comment_list", "uint32_op_new_comment_system", "bytes_comment_gif_url", "bytes_comment_gif_thumbnail_url", "bytes_comment_pic_type", "bytes_comment_id", "bytes_sub_comment_id", "enum_ugc_src", "pgc_param", "bytes_extra_json_params", "qa_req_param", "uint32_is_one_touch_biu", "bytes_req_seq", "uint32_comment_content_src", "uint32_comment_src" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, Integer.valueOf(0), Boolean.valueOf(false), null, Integer.valueOf(1), localByteStringMicro4, null, null, Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, Integer.valueOf(0), null, localByteStringMicro10, null, Integer.valueOf(0), localByteStringMicro11, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_default_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_result_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sub_comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_is_like = PBField.initUInt32(0);
    public final PBUInt32Field uint32_operation = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ugc_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 58, 66, 72, 82 }, new String[] { "uint64_uin", "uint32_operation", "uint64_feeds_id", "bytes_comment_id", "bytes_rowkey", "uint32_ugc_status", "bytes_default_comments", "bytes_sub_comment_id", "uint32_is_like", "bytes_result_desc" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5 }, RspBody.class);
    }
  }
  
  public static final class SecondLevelComment
    extends MessageMicro<SecondLevelComment>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sub_comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_comment_id", "bytes_sub_comment_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, SecondLevelComment.class);
    }
  }
  
  public static final class SocializeFeedsInfo
    extends MessageMicro<SocializeFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public feeds_info.BuluoInfo buluo_info = new feeds_info.BuluoInfo();
    public final PBBytesField bytes_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public feeds_info.LocationInfo location_info = new feeds_info.LocationInfo();
    public feeds_info.BiuMultiLevel msg_biu_mutli_level = new feeds_info.BiuMultiLevel();
    public feeds_info.SocializeFeedsInfoUser msg_master_uin = new feeds_info.SocializeFeedsInfoUser();
    public feeds_info.PGCFeedsInfo msg_pgc_topic_feeds_info = new feeds_info.PGCFeedsInfo();
    public feeds_info.SocializeFeedsExtInfo msg_socialize_feeds_ext_info = new feeds_info.SocializeFeedsExtInfo();
    public feeds_info.TopicRecommendFeedsInfo msg_topic_recommend_feeds_info = new feeds_info.TopicRecommendFeedsInfo();
    public feeds_info.UGCFeedsInfo msg_ugc_topic_feeds_info = new feeds_info.UGCFeedsInfo();
    public feeds_info.VerifyResult msg_verify_result = new feeds_info.VerifyResult();
    public feeds_info.NowLiveInfo now_live_info = new feeds_info.NowLiveInfo();
    public final PBRepeatMessageField<feeds_info.SocializeFeedsInfoUser> rpt_recommend_list = PBField.initRepeatMessage(feeds_info.SocializeFeedsInfoUser.class);
    public feeds_info.ShareWebPageInfo share_web_page_info = new feeds_info.ShareWebPageInfo();
    public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comments_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_myself_biu_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_myself_like_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public feeds_info.VisibleInfo visible_info = new feeds_info.VisibleInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 98, 106, 114, 120, 128, 136, 146, 152, 160, 168, 178, 186, 194, 202, 210, 242, 274, 290, 298, 346 }, new String[] { "uint64_feeds_id", "uint64_article_id", "msg_master_uin", "rpt_recommend_list", "bytes_comments", "bytes_recommend_reason", "uint32_like_count", "uint32_myself_like_status", "uint32_comments_count", "msg_socialize_feeds_ext_info", "uint32_biu_time", "uint32_myself_biu_status", "uint32_biu_count", "msg_biu_mutli_level", "msg_ugc_topic_feeds_info", "msg_pgc_topic_feeds_info", "msg_verify_result", "msg_topic_recommend_feeds_info", "buluo_info", "now_live_info", "share_web_page_info", "location_info", "visible_info" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null, null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null }, SocializeFeedsInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x83e.oidb_cmd0x83e
 * JD-Core Version:    0.7.0.1
 */