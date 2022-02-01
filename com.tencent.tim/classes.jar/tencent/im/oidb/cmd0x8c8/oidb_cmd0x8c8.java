package tencent.im.oidb.cmd0x8c8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x8c8
{
  public static final class AccountInfo
    extends MessageMicro<AccountInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_account_id", "uint32_is_account_approved", "uint32_is_account_derelict" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, AccountInfo.class);
    public final PBUInt32Field uint32_is_account_approved = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_account_derelict = PBField.initUInt32(0);
    public final PBUInt64Field uint64_account_id = PBField.initUInt64(0L);
  }
  
  public static final class BiuMultiLevel
    extends MessageMicro<BiuMultiLevel>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "rpt_biu_mutli_level", "uint64_origin_feeds_id", "uint64_origin_feeds_type", "enum_origin_verify_status" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(2) }, BiuMultiLevel.class);
    public final PBEnumField enum_origin_verify_status = PBField.initEnum(2);
    public final PBRepeatMessageField<oidb_cmd0x8c8.BiuOneLevelItem> rpt_biu_mutli_level = PBField.initRepeatMessage(oidb_cmd0x8c8.BiuOneLevelItem.class);
    public final PBUInt64Field uint64_origin_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_origin_feeds_type = PBField.initUInt64(0L);
  }
  
  public static final class BiuOneLevelItem
    extends MessageMicro<BiuOneLevelItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_biu_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField feeds_type = PBField.initEnum(0);
    public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uint64_feeds_id", "uint64_uin", "uint32_biu_time", "bytes_biu_comments", "feeds_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, BiuOneLevelItem.class);
    }
  }
  
  public static final class ControlParam
    extends MessageMicro<ControlParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80 }, new String[] { "uint32_need_basic_info", "uint32_need_like_count", "uint32_need_biu_count", "uint32_need_comment_count", "uint32_need_origin_feed_info", "uint32_need_follow_status", "uint32_need_topic_info", "uint32_need_article_info", "uint32_need_userinfo", "uint32_need_account_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ControlParam.class);
    public final PBUInt32Field uint32_need_account_info = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_article_info = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_basic_info = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_biu_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_comment_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_follow_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_like_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_origin_feed_info = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_topic_info = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_userinfo = PBField.initUInt32(0);
  }
  
  public static final class FeedsInfo
    extends MessageMicro<FeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public oidb_cmd0x8c8.AccountInfo account_info = new oidb_cmd0x8c8.AccountInfo();
    public final PBBytesField bytes_article_summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_business_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_business_name_prefix = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_business_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_number_of_participants = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subscribe_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subscribe_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField feeds_type = PBField.initEnum(0);
    public final PBBytesField json_video_list = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0x8c8.SocializeFeedsInfo msg_social_fees_info = new oidb_cmd0x8c8.SocializeFeedsInfo();
    public final PBUInt32Field uint32_article_is_video = PBField.initUInt32(0);
    public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 64, 74, 82, 90, 98, 106, 114, 4002 }, new String[] { "feeds_type", "uint64_article_id", "uint32_article_is_video", "bytes_subscribe_name", "json_video_list", "bytes_subscribe_id", "bytes_article_summary", "uint32_business_id", "bytes_business_name", "bytes_business_url", "msg_social_fees_info", "bytes_business_name_prefix", "account_info", "bytes_rowkey", "bytes_number_of_participants" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, null, localByteStringMicro7, null, localByteStringMicro8, localByteStringMicro9 }, FeedsInfo.class);
    }
  }
  
  public static final class FollowRecommendFeedsInfo
    extends MessageMicro<FollowRecommendFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 88, 96, 104, 112, 120, 128 }, new String[] { "uint64_feeds_id", "uint32_feeds_style", "uint64_article_id", "uint32_like_count", "uint32_myself_like_status", "uint32_comments_count", "uint32_biu_count", "uint32_myself_follow_status", "uint32_follow_counts" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FollowRecommendFeedsInfo.class);
    public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comments_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_feeds_style = PBField.initUInt32(0);
    public final PBUInt32Field uint32_follow_counts = PBField.initUInt32(0);
    public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_myself_follow_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_myself_like_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  }
  
  public static final class PGCFeedsInfo
    extends MessageMicro<PGCFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pgc_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_pgc_feeds_card_type = PBField.initEnum(0);
    public final PBRepeatMessageField<oidb_cmd0x8c8.PGCPicInfo> msg_pgc_pic_info_list = PBField.initRepeatMessage(oidb_cmd0x8c8.PGCPicInfo.class);
    public final PBRepeatMessageField<oidb_cmd0x8c8.PGCVideoInfo> msg_pgc_video_info_list = PBField.initRepeatMessage(oidb_cmd0x8c8.PGCVideoInfo.class);
    public final PBUInt32Field uint32_follow_counts = PBField.initUInt32(0);
    public final PBUInt32Field uint32_myself_follow_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 98, 106, 112, 120 }, new String[] { "enum_pgc_feeds_card_type", "uint64_puin", "msg_pgc_pic_info_list", "msg_pgc_video_info_list", "bytes_pgc_comments", "uint32_myself_follow_status", "uint32_follow_counts" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, PGCFeedsInfo.class);
    }
  }
  
  public static final class PGCPicInfo
    extends MessageMicro<PGCPicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumbnail_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_animation = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48 }, new String[] { "uint32_pic_width", "uint32_pic_height", "bytes_pic_md5", "bytes_pic_url", "bytes_thumbnail_url", "is_animation" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, PGCPicInfo.class);
    }
  }
  
  public static final class PGCVideoInfo
    extends MessageMicro<PGCVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "bytes_video_md5", "bytes_video_url", "bytes_pic_md5", "bytes_pic_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, PGCVideoInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public oidb_cmd0x8c8.ControlParam control_req_param = new oidb_cmd0x8c8.ControlParam();
    public final PBRepeatField<ByteStringMicro> rpt_bytes_rowkey = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatMessageField<oidb_cmd0x8c8.ReqMsgInfo> rpt_msg_info_list = PBField.initRepeatMessage(oidb_cmd0x8c8.ReqMsgInfo.class);
    public final PBUInt32Field uint32_need_account_info = PBField.initUInt32(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
    public final PBUInt64Field uint64_client_switch = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 74, 82 }, new String[] { "uint64_uin", "rpt_msg_info_list", "uint32_version", "uint64_client_switch", "uint32_need_account_info", "control_req_param", "rpt_bytes_rowkey" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, localByteStringMicro }, ReqBody.class);
    }
  }
  
  public static final class ReqMsgInfo
    extends MessageMicro<ReqMsgInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField feeds_type = PBField.initEnum(0);
    public final PBRepeatField<Integer> rpt_topic_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_feeds_style = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 56 }, new String[] { "uint64_feeds_id", "uint32_feeds_style", "bytes_recommend_reason", "uint32_biu_time", "feeds_type", "uint32_business_id", "rpt_topic_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqMsgInfo.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint64_uin", "rpt_social_feeds_info", "rpt_del_feeds_id_list", "rpt_del_feeds_info_list" }, new Object[] { Long.valueOf(0L), null, Long.valueOf(0L), null }, RspBody.class);
    public final PBRepeatField<Long> rpt_del_feeds_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatMessageField<oidb_cmd0x8c8.FeedsInfo> rpt_del_feeds_info_list = PBField.initRepeatMessage(oidb_cmd0x8c8.FeedsInfo.class);
    public final PBRepeatMessageField<oidb_cmd0x8c8.FeedsInfo> rpt_social_feeds_info = PBField.initRepeatMessage(oidb_cmd0x8c8.FeedsInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class SocializeFeedsExtInfo
    extends MessageMicro<SocializeFeedsExtInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_article_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_site_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subject = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sum_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_publish_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50 }, new String[] { "uint32_publish_time", "uint32_source", "bytes_article_url", "bytes_subject", "bytes_sum_pic_url", "bytes_site_name" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, SocializeFeedsExtInfo.class);
    }
  }
  
  public static final class SocializeFeedsInfo
    extends MessageMicro<SocializeFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0x8c8.BiuMultiLevel msg_biu_mutli_level = new oidb_cmd0x8c8.BiuMultiLevel();
    public oidb_cmd0x8c8.SocializeFeedsInfoUser msg_master_uin = new oidb_cmd0x8c8.SocializeFeedsInfoUser();
    public oidb_cmd0x8c8.PGCFeedsInfo msg_pgc_topic_feeds_info = new oidb_cmd0x8c8.PGCFeedsInfo();
    public oidb_cmd0x8c8.SocializeFeedsExtInfo msg_socialize_feeds_ext_info = new oidb_cmd0x8c8.SocializeFeedsExtInfo();
    public oidb_cmd0x8c8.TopicRecommendFeedsInfo msg_topic_recommend_feeds_info = new oidb_cmd0x8c8.TopicRecommendFeedsInfo();
    public oidb_cmd0x8c8.UGCFeedsInfo msg_ugc_topic_feeds_info = new oidb_cmd0x8c8.UGCFeedsInfo();
    public oidb_cmd0x8c8.VerifyResult msg_verify_result = new oidb_cmd0x8c8.VerifyResult();
    public final PBRepeatMessageField<oidb_cmd0x8c8.SocializeFeedsInfoUser> rpt_recommend_list = PBField.initRepeatMessage(oidb_cmd0x8c8.SocializeFeedsInfoUser.class);
    public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comments_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_feeds_style = PBField.initUInt32(0);
    public final PBUInt32Field uint32_follow_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_follow_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_myself_biu_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_myself_like_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90, 98, 106, 114, 120, 128, 136, 146, 152, 160, 168, 178, 186, 194, 202, 210, 216, 224 }, new String[] { "uint64_feeds_id", "uint32_feeds_style", "uint64_article_id", "msg_master_uin", "rpt_recommend_list", "bytes_comments", "bytes_recommend_reason", "uint32_like_count", "uint32_myself_like_status", "uint32_comments_count", "msg_socialize_feeds_ext_info", "uint32_biu_time", "uint32_myself_biu_status", "uint32_biu_count", "msg_biu_mutli_level", "msg_ugc_topic_feeds_info", "msg_pgc_topic_feeds_info", "msg_verify_result", "msg_topic_recommend_feeds_info", "uint32_follow_status", "uint32_follow_count" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), null, null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, Integer.valueOf(0), Integer.valueOf(0) }, SocializeFeedsInfo.class);
    }
  }
  
  public static final class SocializeFeedsInfoUser
    extends MessageMicro<SocializeFeedsInfoUser>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "enum_uin_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, SocializeFeedsInfoUser.class);
    public final PBEnumField enum_uin_type = PBField.initEnum(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class TopicRecommendFeedsInfo
    extends MessageMicro<TopicRecommendFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subscribe_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0x8c8.TopicRecommendFeedsTitle msg_left_title = new oidb_cmd0x8c8.TopicRecommendFeedsTitle();
    public oidb_cmd0x8c8.TopicRecommendFeedsTitle msg_right_title = new oidb_cmd0x8c8.TopicRecommendFeedsTitle();
    public final PBRepeatMessageField<oidb_cmd0x8c8.TopicRecommendInfo> msg_topic_recommend_info = PBField.initRepeatMessage(oidb_cmd0x8c8.TopicRecommendInfo.class);
    public final PBUInt32Field uint32_feeds_style = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 90, 98, 106, 114 }, new String[] { "uint64_feeds_id", "uint32_feeds_style", "uint64_uin", "bytes_subscribe_id", "msg_topic_recommend_info", "msg_left_title", "msg_right_title", "bytes_comments" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, null, null, null, localByteStringMicro2 }, TopicRecommendFeedsInfo.class);
    }
  }
  
  public static final class TopicRecommendFeedsTitle
    extends MessageMicro<TopicRecommendFeedsTitle>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_title_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_title_content", "bytes_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, TopicRecommendFeedsTitle.class);
    }
  }
  
  public static final class TopicRecommendInfo
    extends MessageMicro<TopicRecommendInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_business_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_business_name_prefix = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_business_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_number_of_participants = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50 }, new String[] { "uint32_business_id", "bytes_business_name", "bytes_business_url", "bytes_business_name_prefix", "uint32_number_of_participants", "bytes_pic_url" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4 }, TopicRecommendInfo.class);
    }
  }
  
  public static final class UGCFeedsInfo
    extends MessageMicro<UGCFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_json_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_json_pic_list = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_json_video_list = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ugc_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_ugc_feeds_card_type = PBField.initEnum(0);
    public final PBRepeatMessageField<oidb_cmd0x8c8.UGCPicInfo> msg_ugc_pic_info_list = PBField.initRepeatMessage(oidb_cmd0x8c8.UGCPicInfo.class);
    public final PBRepeatMessageField<oidb_cmd0x8c8.UGCVideoInfo> msg_ugc_video_info_list = PBField.initRepeatMessage(oidb_cmd0x8c8.UGCVideoInfo.class);
    public final PBUInt64Field uint64_cuin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 98, 106, 114, 122, 130 }, new String[] { "enum_ugc_feeds_card_type", "uint64_cuin", "msg_ugc_pic_info_list", "msg_ugc_video_info_list", "bytes_ugc_comments", "bytes_json_pic_list", "bytes_json_video_list", "bytes_json_content" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, UGCFeedsInfo.class);
    }
  }
  
  public static final class UGCPicInfo
    extends MessageMicro<UGCPicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumbnail_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_animation = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56 }, new String[] { "uint32_pic_width", "uint32_pic_height", "bytes_pic_md5", "bytes_pic_url", "bytes_thumbnail_url", "is_animation", "uint32_pic_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0) }, UGCPicInfo.class);
    }
  }
  
  public static final class UGCVideoInfo
    extends MessageMicro<UGCVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uniq_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_busi_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_width = PBField.initUInt32(0);
    public final PBUInt64Field uint64_duration = PBField.initUInt64(0L);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 64, 72, 80, 88, 98, 104, 114, 120, 130 }, new String[] { "bytes_video_md5", "bytes_video_url", "bytes_pic_md5", "bytes_pic_url", "bytes_title", "bytes_uuid", "uint64_duration", "uint32_video_width", "uint32_video_height", "uint32_pic_width", "uint32_pic_height", "bytes_uniq_id", "uint32_create_time", "bytes_share_url", "uint32_busi_type", "bytes_vid" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), localByteStringMicro8, Integer.valueOf(0), localByteStringMicro9 }, UGCVideoInfo.class);
    }
  }
  
  public static final class VerifyResult
    extends MessageMicro<VerifyResult>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_verify_status = PBField.initEnum(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "enum_verify_status", "bytes_reason" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, VerifyResult.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8
 * JD-Core Version:    0.7.0.1
 */