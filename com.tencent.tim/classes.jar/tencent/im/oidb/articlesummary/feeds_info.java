package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.MedalInfo;
import tencent.im.oidb.nowlive.nowlive.MixInfo;
import tencent.kandian.community.pk_post.oidb_pk_post.PkPostAttribute;

public final class feeds_info
{
  public static final class AccountLevelInfo
    extends MessageMicro<AccountLevelInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 40, 50, 58 }, new String[] { "uint32_account_cc_level", "account_cc_level_icon_s", "account_cc_level_icon_l" }, new Object[] { Integer.valueOf(0), "", "" }, AccountLevelInfo.class);
    public final PBStringField account_cc_level_icon_l = PBField.initString("");
    public final PBStringField account_cc_level_icon_s = PBField.initString("");
    public final PBUInt32Field uint32_account_cc_level = PBField.initUInt32(0);
  }
  
  public static final class AccountProfile
    extends MessageMicro<AccountProfile>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_home_page_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_profile_photo_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50 }, new String[] { "uint64_uin", "uint32_account_type", "bytes_nick", "bytes_profile_photo_url", "bytes_desc", "bytes_home_page_url" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, AccountProfile.class);
    }
  }
  
  public static final class ArticleBasicInfo
    extends MessageMicro<ArticleBasicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "rowkey", "title", "msg_pgc_pic_info_list", "jump_url" }, new Object[] { "", "", null, "" }, ArticleBasicInfo.class);
    public final PBStringField jump_url = PBField.initString("");
    public final PBRepeatMessageField<feeds_info.PGCPicInfo> msg_pgc_pic_info_list = PBField.initRepeatMessage(feeds_info.PGCPicInfo.class);
    public final PBStringField rowkey = PBField.initString("");
    public final PBStringField title = PBField.initString("");
  }
  
  public static final class BiuMultiLevel
    extends MessageMicro<BiuMultiLevel>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "rpt_biu_mutli_level", "uint64_origin_feeds_id", "uint64_origin_feeds_type", "enum_origin_verify_status" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(2) }, BiuMultiLevel.class);
    public final PBEnumField enum_origin_verify_status = PBField.initEnum(2);
    public final PBRepeatMessageField<feeds_info.BiuOneLevelItem> rpt_biu_mutli_level = PBField.initRepeatMessage(feeds_info.BiuOneLevelItem.class);
    public final PBUInt64Field uint64_origin_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_origin_feeds_type = PBField.initUInt64(0L);
  }
  
  public static final class BiuOneLevelItem
    extends MessageMicro<BiuOneLevelItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_biu_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field feeds_type = PBField.initUInt32(0);
    public feeds_info.JumpInfo msg_jump_info = new feeds_info.JumpInfo();
    public feeds_info.UGCVoiceInfo msg_voice_info = new feeds_info.UGCVoiceInfo();
    public final PBEnumField op_type = PBField.initEnum(0);
    public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58, 66 }, new String[] { "uint64_feeds_id", "uint64_uin", "uint32_biu_time", "bytes_biu_comments", "feeds_type", "op_type", "msg_jump_info", "msg_voice_info" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null, null }, BiuOneLevelItem.class);
    }
  }
  
  public static final class BuluoInfo
    extends MessageMicro<BuluoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_head_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_buluo_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "bytes_wording", "bytes_jump_url", "uint64_buluo_id", "bytes_name", "bytes_head_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, localByteStringMicro4 }, BuluoInfo.class);
    }
  }
  
  public static final class CardConfigInfo
    extends MessageMicro<CardConfigInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_pic_auto_play_type", "uint32_pic_show_type", "uint32_limit_word_lines", "uint32_show_next_button" }, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) }, CardConfigInfo.class);
    public final PBUInt32Field uint32_limit_word_lines = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_auto_play_type = PBField.initUInt32(1);
    public final PBUInt32Field uint32_pic_show_type = PBField.initUInt32(1);
    public final PBUInt32Field uint32_show_next_button = PBField.initUInt32(0);
  }
  
  public static final class CardJumpInfo
    extends MessageMicro<CardJumpInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_card_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_comment_btn_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_available = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_available", "bytes_card_jump_url", "bytes_comment_btn_url" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, CardJumpInfo.class);
    }
  }
  
  public static final class ColumnTopicInfo
    extends MessageMicro<ColumnTopicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_id", "str_title" }, new Object[] { Integer.valueOf(0), "" }, ColumnTopicInfo.class);
    public final PBStringField str_title = PBField.initString("");
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
  }
  
  public static final class FeedsInfo
    extends MessageMicro<FeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_business_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_business_name_prefix = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_business_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_ugc_src = PBField.initEnum(0);
    public final PBUInt32Field feeds_type = PBField.initUInt32(0);
    public feeds_info.FollowRecommendFeedsInfo msg_follow_recommend_feeds_info = new feeds_info.FollowRecommendFeedsInfo();
    public feeds_info.SocializeFeedsInfo msg_social_feeds_info = new feeds_info.SocializeFeedsInfo();
    public feeds_info.TopicRecommendFeedsInfo msg_topic_recommend_feeds_info = new feeds_info.TopicRecommendFeedsInfo();
    public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_index = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 90, 106, 114, 160, 1600, 1608 }, new String[] { "feeds_type", "uint32_business_id", "bytes_business_name", "bytes_business_url", "bytes_business_name_prefix", "msg_social_feeds_info", "msg_follow_recommend_feeds_info", "msg_topic_recommend_feeds_info", "enum_ugc_src", "uint64_feeds_index", "uint64_feeds_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, null, null, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, FeedsInfo.class);
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
  
  public static final class GalleryPGCFeedsInfo
    extends MessageMicro<GalleryPGCFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_gallery_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_report_exdata = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_pic_count = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_source = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sub_source = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 24, 32, 42, 402 }, new String[] { "uint64_pic_count", "uint64_source", "uint64_sub_source", "bytes_report_exdata", "bytes_gallery_url" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, GalleryPGCFeedsInfo.class);
    }
  }
  
  public static final class GameLiveInfo
    extends MessageMicro<GameLiveInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_game_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_play_bill_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_play_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_status = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_status_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tips_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_audience_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 58, 66 }, new String[] { "bytes_play_bill_id", "uint32_status", "uint32_audience_count", "bytes_play_url", "bytes_game_name", "bytes_tips_wording", "bytes_status", "bytes_status_icon_url" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6 }, GameLiveInfo.class);
    }
  }
  
  public static final class IconWordingInfo
    extends MessageMicro<IconWordingInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_status = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_status_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_icon_show_mode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 56 }, new String[] { "uint32_type", "bytes_icon_url", "bytes_wording", "bytes_status_icon_url", "uint32_status", "bytes_status", "uint32_icon_show_mode" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0) }, IconWordingInfo.class);
    }
  }
  
  public static final class JumpInfo
    extends MessageMicro<JumpInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_id", "bytes_wording", "bytes_jump_url" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, JumpInfo.class);
    }
  }
  
  public static final class LocationInfo
    extends MessageMicro<LocationInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_latitude = PBField.initUInt32(0);
    public final PBUInt32Field uint32_longitude = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "bytes_name", "uint32_longitude", "uint32_latitude", "bytes_icon_url" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, LocationInfo.class);
    }
  }
  
  public static final class LongContentInfo
    extends MessageMicro<LongContentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "enum_long_content_card_type", "msg_article_basic_info", "msg_pgc_video_info", "msg_outside_link_info" }, new Object[] { Integer.valueOf(1), null, null, null }, LongContentInfo.class);
    public final PBEnumField enum_long_content_card_type = PBField.initEnum(1);
    public feeds_info.ArticleBasicInfo msg_article_basic_info = new feeds_info.ArticleBasicInfo();
    public feeds_info.OutsideLinkInfo msg_outside_link_info = new feeds_info.OutsideLinkInfo();
    public feeds_info.PGCVideoInfo msg_pgc_video_info = new feeds_info.PGCVideoInfo();
  }
  
  public static final class MediaData
    extends MessageMicro<MediaData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "str_text", "str_pic_url", "uint32_pic_width", "uint32_pci_height" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0) }, MediaData.class);
    public final PBStringField str_pic_url = PBField.initString("");
    public final PBStringField str_text = PBField.initString("");
    public final PBUInt32Field uint32_pci_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
  }
  
  public static final class NowLiveInfo
    extends MessageMicro<NowLiveInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "msg_type", "mix_info", "uint32_timestamp" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, NowLiveInfo.class);
    public nowlive.MixInfo mix_info = new nowlive.MixInfo();
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  }
  
  public static final class OutsideLinkInfo
    extends MessageMicro<OutsideLinkInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "title", "bring_goods_url", "icon_url" }, new Object[] { "", "", "" }, OutsideLinkInfo.class);
    public final PBStringField bring_goods_url = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
    public final PBStringField title = PBField.initString("");
  }
  
  public static final class PGCFeedsInfo
    extends MessageMicro<PGCFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pgc_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_pgc_feeds_card_type = PBField.initEnum(0);
    public final PBEnumField enum_pgc_feeds_type = PBField.initEnum(0);
    public feeds_info.GalleryPGCFeedsInfo msg_gallery_feeds_info = new feeds_info.GalleryPGCFeedsInfo();
    public final PBRepeatMessageField<feeds_info.PGCPicInfo> msg_pgc_pic_info_list = PBField.initRepeatMessage(feeds_info.PGCPicInfo.class);
    public final PBRepeatMessageField<feeds_info.PGCVideoInfo> msg_pgc_video_info_list = PBField.initRepeatMessage(feeds_info.PGCVideoInfo.class);
    public final PBUInt32Field uint32_article_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_follow_counts = PBField.initUInt32(0);
    public final PBUInt32Field uint32_myself_follow_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90, 98, 106, 112, 120, 160, 170 }, new String[] { "enum_pgc_feeds_card_type", "uint64_puin", "uint32_article_type", "msg_pgc_pic_info_list", "msg_pgc_video_info_list", "bytes_pgc_comments", "uint32_myself_follow_status", "uint32_follow_counts", "enum_pgc_feeds_type", "msg_gallery_feeds_info" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, PGCFeedsInfo.class);
    }
  }
  
  public static final class PGCPicInfo
    extends MessageMicro<PGCPicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumbnail_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_animation = PBField.initUInt32(0);
    public feeds_info.PGCVideoInfo msg_video_info = new feeds_info.PGCVideoInfo();
    public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
    public final PBUInt64Field uint64_gallery_index = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 58, 82, 88 }, new String[] { "uint32_pic_width", "uint32_pic_height", "bytes_pic_md5", "bytes_pic_url", "bytes_thumbnail_url", "is_animation", "msg_video_info", "bytes_pic_desc", "uint64_gallery_index" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), null, localByteStringMicro4, Long.valueOf(0L) }, PGCPicInfo.class);
    }
  }
  
  public static final class PGCVideoInfo
    extends MessageMicro<PGCVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField rowkey = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field uint32_busi_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
    public final PBUInt64Field uint64_play_num = PBField.initUInt64(0L);
    public final PBBoolField video_auto_play = PBField.initBool(false);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 64, 72, 82, 90, 98 }, new String[] { "bytes_video_md5", "bytes_video_url", "bytes_pic_md5", "bytes_pic_url", "bytes_vid", "uint32_duration", "uint32_busi_type", "uint64_play_num", "video_auto_play", "rowkey", "title", "jump_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Boolean.valueOf(false), "", "", "" }, PGCVideoInfo.class);
    }
  }
  
  public static final class ShareWebPageInfo
    extends MessageMicro<ShareWebPageInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_source = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_web_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "bytes_web_url", "bytes_title", "bytes_source", "bytes_desc", "bytes_pic_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, ShareWebPageInfo.class);
    }
  }
  
  public static final class SocializeFeedsExtInfo
    extends MessageMicro<SocializeFeedsExtInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_article_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_site_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subject = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sum_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_article_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_in_use = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_video_ad = PBField.initUInt32(0);
    public final PBUInt32Field uint32_private_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_publish_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_in_use = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 56, 64, 72, 80, 88 }, new String[] { "uint32_publish_time", "uint32_source", "bytes_article_url", "bytes_subject", "bytes_sum_pic_url", "bytes_site_name", "uint32_in_use", "uint32_src_in_use", "uint32_private_status", "uint32_article_status", "uint32_is_video_ad" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SocializeFeedsExtInfo.class);
    }
  }
  
  public static final class SocializeFeedsInfo
    extends MessageMicro<SocializeFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public feeds_info.BuluoInfo buluo_info = new feeds_info.BuluoInfo();
    public final PBBytesField bytes_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_extra_json_params = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_recommend_prompt = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_recommend_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_private_status_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_recommend_account_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public feeds_info.GameLiveInfo game_live_info = new feeds_info.GameLiveInfo();
    public feeds_info.IconWordingInfo icon_wording_info = new feeds_info.IconWordingInfo();
    public feeds_info.LocationInfo location_info = new feeds_info.LocationInfo();
    public feeds_info.LongContentInfo long_content_info = new feeds_info.LongContentInfo();
    public feeds_info.BiuMultiLevel msg_biu_mutli_level = new feeds_info.BiuMultiLevel();
    public feeds_info.CardConfigInfo msg_card_config_info = new feeds_info.CardConfigInfo();
    public feeds_info.CardJumpInfo msg_card_jump_info = new feeds_info.CardJumpInfo();
    public feeds_info.ColumnTopicInfo msg_column_topic_info = new feeds_info.ColumnTopicInfo();
    public feeds_info.SocializeFeedsInfoUser msg_master_uin = new feeds_info.SocializeFeedsInfoUser();
    public feeds_info.PGCFeedsInfo msg_pgc_topic_feeds_info = new feeds_info.PGCFeedsInfo();
    public feeds_info.SocializeFeedsExtInfo msg_socialize_feeds_ext_info = new feeds_info.SocializeFeedsExtInfo();
    public feeds_info.TopicRecommendFeedsInfo msg_topic_recommend_feeds_info = new feeds_info.TopicRecommendFeedsInfo();
    public feeds_info.UGCFeedsInfo msg_ugc_topic_feeds_info = new feeds_info.UGCFeedsInfo();
    public feeds_info.VerifyResult msg_verify_result = new feeds_info.VerifyResult();
    public feeds_info.NowLiveInfo now_live_info = new feeds_info.NowLiveInfo();
    public final PBRepeatMessageField<feeds_info.MediaData> rpt_media_data_list = PBField.initRepeatMessage(feeds_info.MediaData.class);
    public final PBRepeatMessageField<feeds_info.SocializeFeedsInfoUser> rpt_recommend_list = PBField.initRepeatMessage(feeds_info.SocializeFeedsInfoUser.class);
    public feeds_info.ShareWebPageInfo share_web_page_info = new feeds_info.ShareWebPageInfo();
    public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comments_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_feed_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_feeds_style = PBField.initUInt32(0);
    public final PBUInt32Field uint32_follow_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_follow_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_biu_comment = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_jump_recommend_page = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_origin_feeds_deleted = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_short_video = PBField.initUInt32(0);
    public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_myself_biu_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_myself_like_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_real_verify_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public feeds_info.VisibleInfo visible_info = new feeds_info.VisibleInfo();
    public feeds_info.WendaInfo wenda_info = new feeds_info.WendaInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90, 98, 106, 114, 120, 128, 136, 146, 152, 160, 168, 178, 186, 194, 202, 210, 216, 224, 234, 242, 250, 256, 266, 274, 280, 290, 298, 304, 314, 320, 330, 338, 346, 352, 362, 368, 378, 386, 394, 402, 410, 418 }, new String[] { "uint64_feeds_id", "uint32_feeds_style", "uint64_article_id", "msg_master_uin", "rpt_recommend_list", "bytes_comments", "bytes_recommend_reason", "uint32_like_count", "uint32_myself_like_status", "uint32_comments_count", "msg_socialize_feeds_ext_info", "uint32_biu_time", "uint32_myself_biu_status", "uint32_biu_count", "msg_biu_mutli_level", "msg_ugc_topic_feeds_info", "msg_pgc_topic_feeds_info", "msg_verify_result", "msg_topic_recommend_feeds_info", "uint32_follow_status", "uint32_follow_count", "bytes_recommend_account_reason", "buluo_info", "wenda_info", "uint32_is_origin_feeds_deleted", "icon_wording_info", "now_live_info", "uint32_is_short_video", "share_web_page_info", "location_info", "uint32_feed_status", "bytes_private_status_title", "uint32_is_jump_recommend_page", "bytes_jump_recommend_url", "bytes_jump_recommend_prompt", "visible_info", "uint32_real_verify_status", "bytes_extra_json_params", "uint32_is_biu_comment", "msg_card_jump_info", "msg_card_config_info", "game_live_info", "long_content_info", "rpt_media_data_list", "msg_column_topic_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), null, null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, null, Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), null, null, null, null, null, null }, SocializeFeedsInfo.class);
    }
  }
  
  public static final class SocializeFeedsInfoUser
    extends MessageMicro<SocializeFeedsInfoUser>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_person_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_uin_type = PBField.initEnum(0);
    public feeds_info.AccountLevelInfo msg_account_level_info = new feeds_info.AccountLevelInfo();
    public final PBRepeatMessageField<oidb_cmd0xb57.MedalInfo> rpt_msg_medal_info = PBField.initRepeatMessage(oidb_cmd0xb57.MedalInfo.class);
    public final PBUInt32Field uint32_star_style = PBField.initUInt32(0);
    public final PBUInt64Field uint64_real_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 58 }, new String[] { "uint64_uin", "enum_uin_type", "uint32_star_style", "bytes_person_desc", "rpt_msg_medal_info", "uint64_real_uin", "msg_account_level_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null, Long.valueOf(0L), null }, SocializeFeedsInfoUser.class);
    }
  }
  
  public static final class TagInfo
    extends MessageMicro<TagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_tag_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBDoubleField double_tag_score = PBField.initDouble(0.0D);
    public final PBUInt64Field uint64_channel = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_tag_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 25, 32 }, new String[] { "uint64_tag_id", "bytes_tag_name", "double_tag_score", "uint64_channel" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Double.valueOf(0.0D), Long.valueOf(0L) }, TagInfo.class);
    }
  }
  
  public static final class TopicRecommendFeedsInfo
    extends MessageMicro<TopicRecommendFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subscribe_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subscribe_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public feeds_info.TopicRecommendFeedsTitle msg_left_title = new feeds_info.TopicRecommendFeedsTitle();
    public feeds_info.TopicRecommendFeedsTitle msg_right_title = new feeds_info.TopicRecommendFeedsTitle();
    public final PBRepeatMessageField<feeds_info.TopicRecommendInfo> msg_topic_recommend_info = PBField.initRepeatMessage(feeds_info.TopicRecommendInfo.class);
    public final PBUInt32Field uint32_feeds_style = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 90, 98, 106, 114 }, new String[] { "uint64_feeds_id", "uint32_feeds_style", "uint64_uin", "bytes_subscribe_id", "bytes_subscribe_name", "msg_topic_recommend_info", "msg_left_title", "msg_right_title", "bytes_comments" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, null, null, null, localByteStringMicro3 }, TopicRecommendFeedsInfo.class);
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
    public final PBUInt32Field uint32_is_follow = PBField.initUInt32(0);
    public final PBUInt32Field uint32_number_of_participants = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 56 }, new String[] { "uint32_business_id", "bytes_business_name", "bytes_business_url", "bytes_business_name_prefix", "uint32_number_of_participants", "bytes_pic_url", "uint32_is_follow" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0) }, TopicRecommendInfo.class);
    }
  }
  
  public static final class UGCFeedsInfo
    extends MessageMicro<UGCFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public feeds_info.AccountProfile account_profile = new feeds_info.AccountProfile();
    public final PBBytesField bytes_json_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_json_pic_list = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_json_video_list = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rich_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ugc_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field enum_ugc_feeds_card_type = PBField.initUInt32(0);
    public final PBUInt32Field enum_ugc_feeds_src = PBField.initUInt32(0);
    public feeds_info.BiuMultiLevel msg_at_multi_level = new feeds_info.BiuMultiLevel();
    public oidb_pk_post.PkPostAttribute msg_pk_post_info = new oidb_pk_post.PkPostAttribute();
    public final PBRepeatMessageField<feeds_info.UGCPicInfo> msg_ugc_pic_info_list = PBField.initRepeatMessage(feeds_info.UGCPicInfo.class);
    public final PBRepeatMessageField<feeds_info.UGCVideoInfo> msg_ugc_video_info_list = PBField.initRepeatMessage(feeds_info.UGCVideoInfo.class);
    public final PBRepeatMessageField<feeds_info.UGCVoiceInfo> msg_ugc_voice_info_list = PBField.initRepeatMessage(feeds_info.UGCVoiceInfo.class);
    public final PBRepeatMessageField<feeds_info.TagInfo> rpt_msg_tag_info_list = PBField.initRepeatMessage(feeds_info.TagInfo.class);
    public final PBUInt32Field uint32_ugc_feeds_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_cuin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 90, 98, 106, 114, 122, 130, 138, 170, 178, 186, 194, 202, 210 }, new String[] { "enum_ugc_feeds_card_type", "uint64_cuin", "enum_ugc_feeds_src", "uint32_ugc_feeds_type", "msg_ugc_pic_info_list", "msg_ugc_video_info_list", "bytes_ugc_comments", "bytes_json_pic_list", "bytes_json_video_list", "bytes_json_content", "msg_at_multi_level", "rpt_msg_tag_info_list", "bytes_jump_url", "account_profile", "bytes_rich_text", "msg_pk_post_info", "msg_ugc_voice_info_list" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, null, null, localByteStringMicro5, null, localByteStringMicro6, null, null }, UGCFeedsInfo.class);
    }
  }
  
  public static final class UGCPicInfo
    extends MessageMicro<UGCPicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_desc = PBField.initBytes(ByteStringMicro.EMPTY);
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
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 82 }, new String[] { "uint32_pic_width", "uint32_pic_height", "bytes_pic_md5", "bytes_pic_url", "bytes_thumbnail_url", "is_animation", "uint32_pic_type", "bytes_pic_desc" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4 }, UGCPicInfo.class);
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
    public final PBBytesField bytes_video_format = PBField.initBytes(ByteStringMicro.EMPTY);
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
      ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 64, 72, 80, 88, 98, 104, 114, 120, 130, 146 }, new String[] { "bytes_video_md5", "bytes_video_url", "bytes_pic_md5", "bytes_pic_url", "bytes_title", "bytes_uuid", "uint64_duration", "uint32_video_width", "uint32_video_height", "uint32_pic_width", "uint32_pic_height", "bytes_uniq_id", "uint32_create_time", "bytes_share_url", "uint32_busi_type", "bytes_vid", "bytes_video_format" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), localByteStringMicro8, Integer.valueOf(0), localByteStringMicro9, localByteStringMicro10 }, UGCVideoInfo.class);
    }
  }
  
  public static final class UGCVoiceInfo
    extends MessageMicro<UGCVoiceInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_voice_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_size = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_voice_url", "uint32_duration", "uint32_file_size" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, UGCVoiceInfo.class);
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
  
  public static final class VisibleInfo
    extends MessageMicro<VisibleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "visible_param", "visible_show_info" }, new Object[] { null, null }, VisibleInfo.class);
    public feeds_info.VisibleSetParam visible_param = new feeds_info.VisibleSetParam();
    public feeds_info.VisibleShowInfo visible_show_info = new feeds_info.VisibleShowInfo();
  }
  
  public static final class VisibleSetParam
    extends MessageMicro<VisibleSetParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_visible_type", "rpt_uint64_uin" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, VisibleSetParam.class);
    public final PBRepeatField<Long> rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_visible_type = PBField.initUInt32(0);
  }
  
  public static final class VisibleShowInfo
    extends MessageMicro<VisibleShowInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_visible_type", "uint64_who", "uint64_feed_id", "uint32_is_visible" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, VisibleShowInfo.class);
    public final PBUInt32Field uint32_is_visible = PBField.initUInt32(0);
    public final PBUInt32Field uint32_visible_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feed_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_who = PBField.initUInt64(0L);
  }
  
  public static final class WendaInfo
    extends MessageMicro<WendaInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_answer_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_question_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_question_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_question_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wenda_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField super_wenda_button_title = PBField.initString("");
    public final PBUInt32Field uint32_answer_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_follow_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_super_wenda = PBField.initUInt32(0);
    public final PBUInt32Field uint32_question_status = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 56, 66, 72, 82, 186 }, new String[] { "uint32_is_super_wenda", "bytes_question_rowkey", "bytes_question_desc", "bytes_question_pic_url", "bytes_wenda_url", "uint32_follow_count", "uint32_answer_count", "bytes_icon_url", "uint32_question_status", "bytes_answer_url", "super_wenda_button_title" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, Integer.valueOf(0), localByteStringMicro6, "" }, WendaInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.feeds_info
 * JD-Core Version:    0.7.0.1
 */