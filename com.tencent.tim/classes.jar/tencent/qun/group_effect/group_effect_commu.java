package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_effect_commu
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 74, 82, 90, 2402 }, new String[] { "u64_cmd", "u64_uin", "i32_implat", "str_version", "st_get_detail", "st_get_effect", "st_set_effect", "st_get_switch_others", "st_set_switch", "st_set_global_effect", "st_set_switch_others", "st_entry_notify" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", null, null, null, null, null, null, null, null }, ReqBody.class);
    public final PBInt32Field i32_implat = PBField.initInt32(0);
    public group_effect_commu.TEntryNotifyReq0x2000 st_entry_notify = new group_effect_commu.TEntryNotifyReq0x2000();
    public group_effect_commu.TGetEffectDetailReq0x1 st_get_detail = new group_effect_commu.TGetEffectDetailReq0x1();
    public group_effect_commu.TGetMyEffectReq0x2 st_get_effect = new group_effect_commu.TGetMyEffectReq0x2();
    public group_effect_commu.TGetSwitchOthersReq0x8 st_get_switch_others = new group_effect_commu.TGetSwitchOthersReq0x8();
    public group_effect_commu.TSetMyEffectReq0x4 st_set_effect = new group_effect_commu.TSetMyEffectReq0x4();
    public group_effect_commu.TSetGlobalEffectReq0x20 st_set_global_effect = new group_effect_commu.TSetGlobalEffectReq0x20();
    public group_effect_commu.TSetSwitchReq0x10 st_set_switch = new group_effect_commu.TSetSwitchReq0x10();
    public group_effect_commu.TSetSwitchOthersReq0x40 st_set_switch_others = new group_effect_commu.TSetSwitchOthersReq0x40();
    public final PBStringField str_version = PBField.initString("");
    public final PBUInt64Field u64_cmd = PBField.initUInt64(0L);
    public final PBUInt64Field u64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 2402 }, new String[] { "ret", "st_get_detail", "st_get_effect", "st_set_effect", "st_get_switch_others", "st_set_switch", "st_set_global_effect", "st_set_switch_others", "st_entry_notify" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, null, null }, RspBody.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public group_effect_commu.TEntryNotifyRsp0x2000 st_entry_notify = new group_effect_commu.TEntryNotifyRsp0x2000();
    public group_effect_commu.TGetEffectDetailRsp0x1 st_get_detail = new group_effect_commu.TGetEffectDetailRsp0x1();
    public group_effect_commu.TGetMyEffectRsp0x2 st_get_effect = new group_effect_commu.TGetMyEffectRsp0x2();
    public group_effect_commu.TGetSwitchOthersRsp0x8 st_get_switch_others = new group_effect_commu.TGetSwitchOthersRsp0x8();
    public group_effect_commu.TSetMyEffectRsp0x4 st_set_effect = new group_effect_commu.TSetMyEffectRsp0x4();
    public group_effect_commu.TSetGlobalEffectRsp0x20 st_set_global_effect = new group_effect_commu.TSetGlobalEffectRsp0x20();
    public group_effect_commu.TSetSwitchRsp0x10 st_set_switch = new group_effect_commu.TSetSwitchRsp0x10();
    public group_effect_commu.TSetSwitchOthersRsp0x40 st_set_switch_others = new group_effect_commu.TSetSwitchOthersRsp0x40();
  }
  
  public static final class TEffectDetail
    extends MessageMicro<TEffectDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "st_userconfig", "st_effectinfo" }, new Object[] { null, null }, TEffectDetail.class);
    public group_effect.EffectInfo st_effectinfo = new group_effect.EffectInfo();
    public group_effect.UserConfig st_userconfig = new group_effect.UserConfig();
  }
  
  public static final class TEntryNotifyReq0x2000
    extends MessageMicro<TEntryNotifyReq0x2000>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "group_id" }, new Object[] { Long.valueOf(0L) }, TEntryNotifyReq0x2000.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
  }
  
  public static final class TEntryNotifyRsp0x2000
    extends MessageMicro<TEntryNotifyRsp0x2000>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "ret", "st_userconfig", "notify_interval" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, TEntryNotifyRsp0x2000.class);
    public final PBUInt32Field notify_interval = PBField.initUInt32(0);
    public final PBInt32Field ret = PBField.initInt32(0);
    public group_effect_commu.TEffectDetail st_userconfig = new group_effect_commu.TEffectDetail();
  }
  
  public static final class TGetEffectDetailReq0x1
    extends MessageMicro<TGetEffectDetailReq0x1>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "effect_id" }, new Object[] { Long.valueOf(0L) }, TGetEffectDetailReq0x1.class);
    public final PBRepeatField<Long> effect_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class TGetEffectDetailRsp0x1
    extends MessageMicro<TGetEffectDetailRsp0x1>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret", "rpt_effectinfo" }, new Object[] { Integer.valueOf(0), null }, TGetEffectDetailRsp0x1.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBRepeatMessageField<group_effect.EffectInfo> rpt_effectinfo = PBField.initRepeatMessage(group_effect.EffectInfo.class);
  }
  
  public static final class TGetMyEffectReq0x2
    extends MessageMicro<TGetMyEffectReq0x2>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "group_id" }, new Object[] { Long.valueOf(0L) }, TGetMyEffectReq0x2.class);
    public final PBRepeatField<Long> group_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class TGetMyEffectRsp0x2
    extends MessageMicro<TGetMyEffectRsp0x2>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "ret", "global_effect_id", "st_global_effectinfo", "rpt_userconfig", "query_interval" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, Integer.valueOf(0) }, TGetMyEffectRsp0x2.class);
    public final PBUInt32Field global_effect_id = PBField.initUInt32(0);
    public final PBUInt32Field query_interval = PBField.initUInt32(0);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBRepeatMessageField<group_effect_commu.TEffectDetail> rpt_userconfig = PBField.initRepeatMessage(group_effect_commu.TEffectDetail.class);
    public group_effect.EffectInfo st_global_effectinfo = new group_effect.EffectInfo();
  }
  
  public static final class TGetSwitchOthersReq0x8
    extends MessageMicro<TGetSwitchOthersReq0x8>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "group_id" }, new Object[] { Long.valueOf(0L) }, TGetSwitchOthersReq0x8.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
  }
  
  public static final class TGetSwitchOthersRsp0x8
    extends MessageMicro<TGetSwitchOthersRsp0x8>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "ret", "forbid_others" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, TGetSwitchOthersRsp0x8.class);
    public final PBInt32Field forbid_others = PBField.initInt32(0);
    public final PBInt32Field ret = PBField.initInt32(0);
  }
  
  public static final class TSetGlobalEffectReq0x20
    extends MessageMicro<TSetGlobalEffectReq0x20>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "global_effect_id" }, new Object[] { Integer.valueOf(0) }, TSetGlobalEffectReq0x20.class);
    public final PBUInt32Field global_effect_id = PBField.initUInt32(0);
  }
  
  public static final class TSetGlobalEffectRsp0x20
    extends MessageMicro<TSetGlobalEffectRsp0x20>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ret" }, new Object[] { Integer.valueOf(0) }, TSetGlobalEffectRsp0x20.class);
    public final PBInt32Field ret = PBField.initInt32(0);
  }
  
  public static final class TSetMyEffectReq0x4
    extends MessageMicro<TSetMyEffectReq0x4>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "user_config" }, new Object[] { null }, TSetMyEffectReq0x4.class);
    public final PBRepeatMessageField<group_effect.UserConfig> user_config = PBField.initRepeatMessage(group_effect.UserConfig.class);
  }
  
  public static final class TSetMyEffectRsp0x4
    extends MessageMicro<TSetMyEffectRsp0x4>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ret" }, new Object[] { Integer.valueOf(0) }, TSetMyEffectRsp0x4.class);
    public final PBInt32Field ret = PBField.initInt32(0);
  }
  
  public static final class TSetSwitchOthersReq0x40
    extends MessageMicro<TSetSwitchOthersReq0x40>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_id", "forbid_others" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, TSetSwitchOthersReq0x40.class);
    public final PBInt32Field forbid_others = PBField.initInt32(0);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
  }
  
  public static final class TSetSwitchOthersRsp0x40
    extends MessageMicro<TSetSwitchOthersRsp0x40>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ret" }, new Object[] { Integer.valueOf(0) }, TSetSwitchOthersRsp0x40.class);
    public final PBInt32Field ret = PBField.initInt32(0);
  }
  
  public static final class TSetSwitchReq0x10
    extends MessageMicro<TSetSwitchReq0x10>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_id", "forbid_self" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, TSetSwitchReq0x10.class);
    public final PBUInt64Field forbid_self = PBField.initUInt64(0L);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
  }
  
  public static final class TSetSwitchRsp0x10
    extends MessageMicro<TSetSwitchRsp0x10>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ret" }, new Object[] { Integer.valueOf(0) }, TSetSwitchRsp0x10.class);
    public final PBInt32Field ret = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.qun.group_effect.group_effect_commu
 * JD-Core Version:    0.7.0.1
 */