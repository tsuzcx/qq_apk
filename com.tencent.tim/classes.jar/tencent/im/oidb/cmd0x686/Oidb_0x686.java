package tencent.im.oidb.cmd0x686;

import appoint.define.appoint_define.LBSInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x686
{
  public static final class CharmEvent
    extends MessageMicro<CharmEvent>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64 }, new String[] { "uint32_pop_flag", "uint32_old_charm", "uint32_old_charm_level", "uint32_new_charm", "uint32_new_charm_level", "uint32_next_level_threshold", "str_tips_content", "uint32_cur_level_threshold" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, CharmEvent.class);
    public final PBStringField str_tips_content = PBField.initString("");
    public final PBUInt32Field uint32_cur_level_threshold = PBField.initUInt32(0);
    public final PBUInt32Field uint32_new_charm = PBField.initUInt32(0);
    public final PBUInt32Field uint32_new_charm_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_level_threshold = PBField.initUInt32(0);
    public final PBUInt32Field uint32_old_charm = PBField.initUInt32(0);
    public final PBUInt32Field uint32_old_charm_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pop_flag = PBField.initUInt32(0);
  }
  
  public static final class NearbyCharmNotify
    extends MessageMicro<NearbyCharmNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 74, 80 }, new String[] { "uint32_pop_flag", "uint32_old_charm", "uint32_old_charm_level", "uint32_old_prof_percent", "uint32_new_charm", "uint32_new_charm_level", "uint32_new_prof_percent", "uint32_next_level_threshold", "str_tips_content", "uint32_cur_level_threshold" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, NearbyCharmNotify.class);
    public final PBStringField str_tips_content = PBField.initString("");
    public final PBUInt32Field uint32_cur_level_threshold = PBField.initUInt32(0);
    public final PBUInt32Field uint32_new_charm = PBField.initUInt32(0);
    public final PBUInt32Field uint32_new_charm_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_new_prof_percent = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_level_threshold = PBField.initUInt32(0);
    public final PBUInt32Field uint32_old_charm = PBField.initUInt32(0);
    public final PBUInt32Field uint32_old_charm_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_old_prof_percent = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pop_flag = PBField.initUInt32(0);
  }
  
  public static final class NearbyFeedConfig
    extends MessageMicro<NearbyFeedConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42 }, new String[] { "uint32_publish_feed_min_level", "str_publish_feed_tips", "str_unable_publish_feed_tips", "uint32_publish_comment_min_level", "str_unable_publish_comment_tips" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), "" }, NearbyFeedConfig.class);
    public final PBStringField str_publish_feed_tips = PBField.initString("");
    public final PBStringField str_unable_publish_comment_tips = PBField.initString("");
    public final PBStringField str_unable_publish_feed_tips = PBField.initString("");
    public final PBUInt32Field uint32_publish_comment_min_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_publish_feed_min_level = PBField.initUInt32(0);
  }
  
  public static final class NearbyRankConfig
    extends MessageMicro<NearbyRankConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_rank_sw", "rpt_msg_title_configs" }, new Object[] { Integer.valueOf(0), null }, NearbyRankConfig.class);
    public final PBRepeatMessageField<Oidb_0x686.RankTitleConfig> rpt_msg_title_configs = PBField.initRepeatMessage(Oidb_0x686.RankTitleConfig.class);
    public final PBUInt32Field uint32_rank_sw = PBField.initUInt32(0);
  }
  
  public static final class RankTitleConfig
    extends MessageMicro<RankTitleConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_listtype", "str_first_title", "str_second_title" }, new Object[] { Integer.valueOf(0), "", "" }, RankTitleConfig.class);
    public final PBStringField str_first_title = PBField.initString("");
    public final PBStringField str_second_title = PBField.initString("");
    public final PBUInt32Field uint32_listtype = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "msg_lbs_info", "uint32_last_config_seq", "uint32_last_config_time", "uint32_push_redpoint_id" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public appoint_define.LBSInfo msg_lbs_info = new appoint_define.LBSInfo();
    public final PBUInt32Field uint32_last_config_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_last_config_time = PBField.initUInt32(0);
    public final PBRepeatField<Integer> uint32_push_redpoint_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 50, 56 }, new String[] { "msg_notify_event", "msg_charm_event", "uint32_config_seq", "msg_rank_config", "uint32_gold_flag", "msg_feed_config", "uint32_config_time" }, new Object[] { null, null, Integer.valueOf(0), null, Integer.valueOf(0), null, Integer.valueOf(0) }, RspBody.class);
    public Oidb_0x686.CharmEvent msg_charm_event = new Oidb_0x686.CharmEvent();
    public Oidb_0x686.NearbyFeedConfig msg_feed_config = new Oidb_0x686.NearbyFeedConfig();
    public Oidb_0x686.NearbyCharmNotify msg_notify_event = new Oidb_0x686.NearbyCharmNotify();
    public Oidb_0x686.NearbyRankConfig msg_rank_config = new Oidb_0x686.NearbyRankConfig();
    public final PBUInt32Field uint32_config_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_config_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gold_flag = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x686.Oidb_0x686
 * JD-Core Version:    0.7.0.1
 */