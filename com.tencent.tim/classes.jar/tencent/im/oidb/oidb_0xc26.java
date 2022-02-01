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

public final class oidb_0xc26
{
  public static final class AddFriendSource
    extends MessageMicro<AddFriendSource>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_source", "uint32_sub_source" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, AddFriendSource.class);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_source = PBField.initUInt32(0);
  }
  
  public static final class Color
    extends MessageMicro<Color>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_r", "uint32_g", "uint32_b" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Color.class);
    public final PBUInt32Field uint32_b = PBField.initUInt32(0);
    public final PBUInt32Field uint32_g = PBField.initUInt32(0);
    public final PBUInt32Field uint32_r = PBField.initUInt32(0);
  }
  
  public static final class EntryDelay
    extends MessageMicro<EntryDelay>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "em_entry", "uint32_delay" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0) }, EntryDelay.class);
    public final PBEnumField em_entry = PBField.initEnum(1);
    public final PBUInt32Field uint32_delay = PBField.initUInt32(0);
  }
  
  public static final class Label
    extends MessageMicro<Label>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0xc26.Color edging_color = new oidb_0xc26.Color();
    public oidb_0xc26.Color text_color = new oidb_0xc26.Color();
    public final PBUInt32Field uint32_label_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "bytes_name", "text_color", "edging_color", "uint32_label_type" }, new Object[] { localByteStringMicro, null, null, Integer.valueOf(0) }, Label.class);
    }
  }
  
  public static final class MayKnowPerson
    extends MessageMicro<MayKnowPerson>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_additive = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_alghrithm = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_catelogue = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_country = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_mobile_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_province = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_richbuffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0xc26.AddFriendSource msg_android_source = new oidb_0xc26.AddFriendSource();
    public oidb_0xc26.AddFriendSource msg_ios_source = new oidb_0xc26.AddFriendSource();
    public final PBRepeatMessageField<oidb_0xc26.Label> rpt_msg_labels = PBField.initRepeatMessage(oidb_0xc26.Label.class);
    public final PBStringField str_token = PBField.initString("");
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_online_state = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qzone = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sourceid = PBField.initUInt32(0);
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 88, 98, 106, 114, 120, 128, 138, 146, 152, 162, 168 }, new String[] { "uint64_uin", "msg_ios_source", "msg_android_source", "bytes_reason", "bytes_additive", "bytes_nick", "bytes_remark", "bytes_country", "bytes_province", "bytes_city", "uint32_age", "bytes_catelogue", "bytes_alghrithm", "bytes_richbuffer", "uint32_qzone", "uint32_gender", "bytes_mobile_name", "str_token", "uint32_online_state", "rpt_msg_labels", "uint32_sourceid" }, new Object[] { Long.valueOf(0L), null, null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, Integer.valueOf(0), localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro11, "", Integer.valueOf(0), null, Integer.valueOf(0) }, MayKnowPerson.class);
    }
  }
  
  public static final class RecommendInfo
    extends MessageMicro<RecommendInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_woring = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0xc26.RgroupInfo> msg_groups = PBField.initRepeatMessage(oidb_0xc26.RgroupInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_woring", "msg_groups" }, new Object[] { localByteStringMicro, null }, RecommendInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField em_entry = PBField.initEnum(1);
    public final PBRepeatField<Long> rpt_expected_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<Long> rpt_filter_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_fetch_rgroup = PBField.initUInt32(0);
    public final PBUInt32Field uint32_phone_book = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_want = PBField.initUInt32(80);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66 }, new String[] { "rpt_filter_uins", "uint32_phone_book", "rpt_expected_uins", "em_entry", "uint32_fetch_rgroup", "uint32_tab_id", "uint32_want", "bytes_cookies" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(80), localByteStringMicro }, ReqBody.class);
    }
  }
  
  public static final class RgoupLabel
    extends MessageMicro<RgoupLabel>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0xc26.RgroupColor edging_color = new oidb_0xc26.RgroupColor();
    public final PBEnumField enum_type = PBField.initEnum(1);
    public oidb_0xc26.RgroupColor text_color = new oidb_0xc26.RgroupColor();
    public final PBUInt32Field uint32_label_attr = PBField.initUInt32(0);
    public final PBUInt32Field uint32_label_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48 }, new String[] { "bytes_name", "enum_type", "text_color", "edging_color", "uint32_label_attr", "uint32_label_type" }, new Object[] { localByteStringMicro, Integer.valueOf(1), null, null, Integer.valueOf(0), Integer.valueOf(0) }, RgoupLabel.class);
    }
  }
  
  public static final class RgroupColor
    extends MessageMicro<RgroupColor>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_r", "uint32_g", "uint32_b" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RgroupColor.class);
    public final PBUInt32Field uint32_b = PBField.initUInt32(0);
    public final PBUInt32Field uint32_g = PBField.initUInt32(0);
    public final PBUInt32Field uint32_r = PBField.initUInt32(0);
  }
  
  public static final class RgroupInfo
    extends MessageMicro<RgroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_algorithm = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_group_memo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_join_group_auth = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_uin_privilege = PBField.initInt32(0);
    public final PBRepeatMessageField<oidb_0xc26.RgoupLabel> rpt_group_label = PBField.initRepeatMessage(oidb_0xc26.RgoupLabel.class);
    public final PBEnumField source = PBField.initEnum(1);
    public oidb_0xc26.RgoupLabel tag_wording = new oidb_0xc26.RgoupLabel();
    public final PBUInt32Field uint32_activity = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_flag_ext = PBField.initUInt32(0);
    public final PBUInt32Field uint32_member_max_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 56, 64, 72, 82, 90, 98, 104, 112, 120 }, new String[] { "uint64_group_code", "uint64_owner_uin", "bytes_group_name", "bytes_group_memo", "uint32_member_num", "rpt_group_label", "uint32_group_flag_ext", "uint32_group_flag", "source", "tag_wording", "bytes_algorithm", "bytes_join_group_auth", "uint32_activity", "uint32_member_max_num", "int32_uin_privilege" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), null, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RgroupInfo.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_is_newuser = PBField.initBool(false);
    public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField em_rsp_data_type = PBField.initEnum(1);
    public final PBRepeatField<Integer> rpt_entry_close = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public final PBRepeatMessageField<oidb_0xc26.EntryDelay> rpt_entry_delays = PBField.initRepeatMessage(oidb_0xc26.EntryDelay.class);
    public final PBRepeatField<Integer> rpt_entry_inuse = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public final PBRepeatMessageField<oidb_0xc26.MayKnowPerson> rpt_msg_persons = PBField.initRepeatMessage(oidb_0xc26.MayKnowPerson.class);
    public final PBRepeatMessageField<oidb_0xc26.RecommendInfo> rpt_msg_rgroup_items = PBField.initRepeatMessage(oidb_0xc26.RecommendInfo.class);
    public final PBRepeatMessageField<oidb_0xc26.TabInfo> rpt_msg_tables = PBField.initRepeatMessage(oidb_0xc26.TabInfo.class);
    public final PBUInt32Field uint32_add_page_list_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_list_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_up = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_gap = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 58, 64, 72, 80, 90, 96, 106, 114 }, new String[] { "rpt_msg_persons", "rpt_entry_inuse", "rpt_entry_close", "uint32_next_gap", "uint32_timestamp", "uint32_msg_up", "rpt_entry_delays", "uint32_list_switch", "uint32_add_page_list_switch", "em_rsp_data_type", "rpt_msg_rgroup_items", "bool_is_newuser", "rpt_msg_tables", "bytes_cookies" }, new Object[] { null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), null, Boolean.valueOf(false), null, localByteStringMicro }, RspBody.class);
    }
  }
  
  public static final class TabInfo
    extends MessageMicro<TabInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public oidb_0xc26.Color background_color_select = new oidb_0xc26.Color();
    public oidb_0xc26.Color background_color_unselect = new oidb_0xc26.Color();
    public final PBBytesField bytes_icon_url_select = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_icon_url_unselect = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_table_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_recommend_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58 }, new String[] { "uint32_tab_id", "uint32_recommend_count", "bytes_table_name", "bytes_icon_url_select", "bytes_icon_url_unselect", "background_color_select", "background_color_unselect" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, null }, TabInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc26
 * JD-Core Version:    0.7.0.1
 */