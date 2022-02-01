package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_effect
{
  public static final class Banner
    extends MessageMicro<Banner>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 810 }, new String[] { "effect_id", "bottom_url", "top_url", "goto_url", "time_begin", "time_end", "effect_info" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), null }, Banner.class);
    public final PBStringField bottom_url = PBField.initString("");
    public final PBUInt32Field effect_id = PBField.initUInt32(0);
    public group_effect.EffectInfo effect_info = new group_effect.EffectInfo();
    public final PBStringField goto_url = PBField.initString("");
    public final PBUInt32Field time_begin = PBField.initUInt32(0);
    public final PBUInt32Field time_end = PBField.initUInt32(0);
    public final PBStringField top_url = PBField.initString("");
  }
  
  public static final class Category
    extends MessageMicro<Category>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 810 }, new String[] { "name", "wording", "rpt_effect_id", "rpt_effect_info" }, new Object[] { "", "", Integer.valueOf(0), null }, Category.class);
    public final PBStringField name = PBField.initString("");
    public final PBRepeatField<Integer> rpt_effect_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatMessageField<group_effect.EffectInfo> rpt_effect_info = PBField.initRepeatMessage(group_effect.EffectInfo.class);
    public final PBStringField wording = PBField.initString("");
  }
  
  public static final class EffectConfig
    extends MessageMicro<EffectConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_banner", "rpt_category" }, new Object[] { null, null }, EffectConfig.class);
    public final PBRepeatMessageField<group_effect.Banner> rpt_banner = PBField.initRepeatMessage(group_effect.Banner.class);
    public final PBRepeatMessageField<group_effect.Category> rpt_category = PBField.initRepeatMessage(group_effect.Category.class);
  }
  
  public static final class EffectIndex
    extends MessageMicro<EffectIndex>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_effect_id" }, new Object[] { Integer.valueOf(0) }, EffectIndex.class);
    public final PBRepeatField<Integer> rpt_effect_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class EffectInfo
    extends MessageMicro<EffectInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 66, 74, 82, 88, 96, 104, 114, 122, 130, 138, 146, 808, 816 }, new String[] { "effect_id", "name", "wording", "get_mode", "svip_level", "group_level", "price", "gif_url", "pic_url", "mp4_url", "duration", "status", "sort_num", "attr_id", "small_pic_url", "bg_pic_url", "spirit_url", "spirit_config", "ttl", "user_config_status" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), Boolean.valueOf(false) }, EffectInfo.class);
    public final PBStringField attr_id = PBField.initString("");
    public final PBStringField bg_pic_url = PBField.initString("");
    public final PBUInt32Field duration = PBField.initUInt32(0);
    public final PBUInt32Field effect_id = PBField.initUInt32(0);
    public final PBUInt32Field get_mode = PBField.initUInt32(0);
    public final PBStringField gif_url = PBField.initString("");
    public final PBUInt32Field group_level = PBField.initUInt32(0);
    public final PBStringField mp4_url = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField pic_url = PBField.initString("");
    public final PBUInt32Field price = PBField.initUInt32(0);
    public final PBStringField small_pic_url = PBField.initString("");
    public final PBUInt32Field sort_num = PBField.initUInt32(0);
    public final PBStringField spirit_config = PBField.initString("");
    public final PBStringField spirit_url = PBField.initString("");
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBUInt32Field svip_level = PBField.initUInt32(0);
    public final PBInt32Field ttl = PBField.initInt32(0);
    public final PBBoolField user_config_status = PBField.initBool(false);
    public final PBStringField wording = PBField.initString("");
  }
  
  public static final class UserConfig
    extends MessageMicro<UserConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "group_code", "effect_id", "status", "set_mode" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, UserConfig.class);
    public final PBUInt32Field effect_id = PBField.initUInt32(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBUInt64Field set_mode = PBField.initUInt64(0L);
    public final PBUInt64Field status = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.qun.group_effect.group_effect
 * JD-Core Version:    0.7.0.1
 */