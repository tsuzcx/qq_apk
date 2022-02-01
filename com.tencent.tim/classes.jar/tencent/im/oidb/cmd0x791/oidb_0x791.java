package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x791
{
  public static final class DTNearbyEntranceExtendConfig
    extends MessageMicro<DTNearbyEntranceExtendConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_has_hintWord = PBField.initBool(false);
    public final PBBoolField bool_has_waterMarkURLStr = PBField.initBool(false);
    public final PBBytesField str_hintWord = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_waterMarkURLStr = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "bool_has_waterMarkURLStr", "str_waterMarkURLStr", "bool_has_hintWord", "str_hintWord" }, new Object[] { Boolean.valueOf(false), localByteStringMicro1, Boolean.valueOf(false), localByteStringMicro2 }, DTNearbyEntranceExtendConfig.class);
    }
  }
  
  public static final class DTNearbyEntranceWordCornerRedDot
    extends MessageMicro<DTNearbyEntranceWordCornerRedDot>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_enable = PBField.initBool(false);
    public final PBBoolField bool_switch_to_word_corner = PBField.initBool(false);
    public final PBBytesField str_hintText = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "bool_enable", "bool_switch_to_word_corner", "str_hintText" }, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false), localByteStringMicro }, DTNearbyEntranceWordCornerRedDot.class);
    }
  }
  
  public static final class GetRedDotOpt
    extends MessageMicro<GetRedDotOpt>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "rpt_uint32_appid" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, GetRedDotOpt.class);
    public final PBRepeatField<Integer> rpt_uint32_appid = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetRedDotRes
    extends MessageMicro<GetRedDotRes>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_uin", "rpt_msg_reddot_info", "uint32_interval" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0) }, GetRedDotRes.class);
    public final PBRepeatMessageField<oidb_0x791.RedDotInfo> rpt_msg_reddot_info = PBField.initRepeatMessage(oidb_0x791.RedDotInfo.class);
    public final PBUInt32Field uint32_interval = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RedDotInfo
    extends MessageMicro<RedDotInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_display_reddot = PBField.initBool(false);
    public oidb_0x791.DTNearbyEntranceExtendConfig msg_nearby_entrance_extend_config = new oidb_0x791.DTNearbyEntranceExtendConfig();
    public oidb_0x791.DTNearbyEntranceWordCornerRedDot msg_word_corner_red_dot = new oidb_0x791.DTNearbyEntranceWordCornerRedDot();
    public final PBBytesField str_custom_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_face_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cmd_uin_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_last_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_number = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reason = PBField.initUInt32(0);
    public final PBUInt32Field uint32_report_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_cmd_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 66, 72, 80, 88, 98, 106 }, new String[] { "uint32_appid", "bool_display_reddot", "uint32_number", "uint32_reason", "uint32_last_time", "uint64_cmd_uin", "str_face_url", "str_custom_buffer", "uint32_expire_time", "uint32_cmd_uin_type", "uint32_report_type", "msg_word_corner_red_dot", "msg_nearby_entrance_extend_config" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null }, RedDotInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_set_reddot", "msg_get_reddot", "msg_set_reddot_appids" }, new Object[] { null, null, null }, ReqBody.class);
    public oidb_0x791.GetRedDotOpt msg_get_reddot = new oidb_0x791.GetRedDotOpt();
    public oidb_0x791.SetRedDotOpt msg_set_reddot = new oidb_0x791.SetRedDotOpt();
    public oidb_0x791.SetRedDotAppids msg_set_reddot_appids = new oidb_0x791.SetRedDotAppids();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_result", "msg_get_reddot_res", "msg_set_reddot_res", "msg_set_reddot_appids_res" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
    public oidb_0x791.GetRedDotRes msg_get_reddot_res = new oidb_0x791.GetRedDotRes();
    public oidb_0x791.SetRotDotAppidsRes msg_set_reddot_appids_res = new oidb_0x791.SetRotDotAppidsRes();
    public oidb_0x791.SetRedDotRes msg_set_reddot_res = new oidb_0x791.SetRedDotRes();
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  }
  
  public static final class SetAppidOpt
    extends MessageMicro<SetAppidOpt>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_appid", "set_reddot_opt" }, new Object[] { Integer.valueOf(0), null }, SetAppidOpt.class);
    public oidb_0x791.SetRedDotOpt set_reddot_opt = new oidb_0x791.SetRedDotOpt();
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  }
  
  public static final class SetRedDotAppids
    extends MessageMicro<SetRedDotAppids>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_cmd_uin", "uint64_to_uin", "rpt_appid_opt" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null }, SetRedDotAppids.class);
    public final PBRepeatMessageField<oidb_0x791.SetAppidOpt> rpt_appid_opt = PBField.initRepeatMessage(oidb_0x791.SetAppidOpt.class);
    public final PBUInt64Field uint64_cmd_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  }
  
  public static final class SetRedDotOpt
    extends MessageMicro<SetRedDotOpt>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_clear = PBField.initBool(false);
    public final PBBoolField bool_display_reddot = PBField.initBool(false);
    public final PBBoolField bool_keep_unchanged = PBField.initBool(false);
    public final PBBoolField bool_push_to_client = PBField.initBool(false);
    public final PBInt32Field int32_number = PBField.initInt32(0);
    public final PBRepeatField<Long> rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBBytesField str_custom_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_face_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_cmd_uin_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_last_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reason = PBField.initUInt32(0);
    public final PBUInt32Field uint32_report_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_number = PBField.initUInt32(0);
    public final PBUInt64Field uint64_cmd_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 74, 80, 88, 96, 104, 112, 120 }, new String[] { "uint64_cmd_uin", "rpt_uint64_uin", "bool_clear", "bool_display_reddot", "int32_number", "uint32_reason", "bool_push_to_client", "str_face_url", "str_custom_buffer", "uint32_expire_time", "uint32_last_time", "uint32_total_number", "uint32_cmd_uin_type", "uint32_report_type", "bool_keep_unchanged" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false) }, SetRedDotOpt.class);
    }
  }
  
  public static final class SetRedDotRes
    extends MessageMicro<SetRedDotRes>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint64_failed_uin" }, new Object[] { Long.valueOf(0L) }, SetRedDotRes.class);
    public final PBRepeatField<Long> rpt_uint64_failed_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class SetRotDotAppidsRes
    extends MessageMicro<SetRotDotAppidsRes>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint32_failed_appid" }, new Object[] { Integer.valueOf(0) }, SetRotDotAppidsRes.class);
    public final PBRepeatField<Integer> rpt_uint32_failed_appid = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x791.oidb_0x791
 * JD-Core Version:    0.7.0.1
 */