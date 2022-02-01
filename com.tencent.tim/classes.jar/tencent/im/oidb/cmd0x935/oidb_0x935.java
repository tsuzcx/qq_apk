package tencent.im.oidb.cmd0x935;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x935
{
  public static final class Color
    extends MessageMicro<Color>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_r", "uint32_g", "uint32_b" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Color.class);
    public final PBUInt32Field uint32_b = PBField.initUInt32(0);
    public final PBUInt32Field uint32_g = PBField.initUInt32(0);
    public final PBUInt32Field uint32_r = PBField.initUInt32(0);
  }
  
  public static final class GPS
    extends MessageMicro<GPS>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_client_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_accuracy = PBField.initUInt32(0);
    public final PBUInt32Field uint32_altitude = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cityid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_latitude = PBField.initUInt32(0);
    public final PBUInt32Field uint32_longitude = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 72 }, new String[] { "uint32_latitude", "uint32_longitude", "uint32_altitude", "uint32_accuracy", "uint32_time", "uint32_flag", "uint32_cityid", "bytes_client_version", "uint32_client" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, GPS.class);
    }
  }
  
  public static final class GroupLabel
    extends MessageMicro<GroupLabel>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "uin_info", "uint32_number_label", "uint32_label_style" }, new Object[] { null, Integer.valueOf(5), Integer.valueOf(0) }, GroupLabel.class);
    public oidb_0x935.UinInfo uin_info = new oidb_0x935.UinInfo();
    public final PBUInt32Field uint32_label_style = PBField.initUInt32(0);
    public final PBUInt32Field uint32_number_label = PBField.initUInt32(5);
  }
  
  public static final class Label
    extends MessageMicro<Label>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x935.Color edging_color = new oidb_0x935.Color();
    public final PBEnumField enum_type = PBField.initEnum(1);
    public oidb_0x935.Color text_color = new oidb_0x935.Color();
    public final PBUInt32Field uint32_label_attr = PBField.initUInt32(0);
    public final PBUInt32Field uint32_label_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48 }, new String[] { "bytes_name", "enum_type", "text_color", "edging_color", "uint32_label_attr", "uint32_label_type" }, new Object[] { localByteStringMicro, Integer.valueOf(1), null, null, Integer.valueOf(0), Integer.valueOf(0) }, Label.class);
    }
  }
  
  public static final class NotifyInfo
    extends MessageMicro<NotifyInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_notify_gc", "uint32_notify_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, NotifyInfo.class);
    public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_notify_gc = PBField.initUInt64(0L);
  }
  
  public static final class RecommendInfo
    extends MessageMicro<RecommendInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_woring = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x935.RgroupInfo> msg_groups = PBField.initRepeatMessage(oidb_0x935.RgroupInfo.class);
    
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
    public final PBBytesField bytes_class_param = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x935.GPS msg_gps = new oidb_0x935.GPS();
    public final PBRepeatMessageField<oidb_0x935.NotifyInfo> msg_notify_info = PBField.initRepeatMessage(oidb_0x935.NotifyInfo.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_memo_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_new = PBField.initUInt32(0);
    public final PBUInt32Field uint32_max_pos_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pos = PBField.initUInt32(0);
    public final PBUInt64Field uint64_black_gc = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_join_gc = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50, 56, 64, 74, 80 }, new String[] { "uint32_appid", "uint32_pos", "msg_gps", "uint64_join_gc", "uint32_max_pos_count", "bytes_class_param", "uint64_black_gc", "uint32_is_new", "msg_notify_info", "uint32_group_memo_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0) }, ReqBody.class);
    }
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
    public final PBRepeatMessageField<oidb_0x935.Label> rpt_group_label = PBField.initRepeatMessage(oidb_0x935.Label.class);
    public final PBEnumField source = PBField.initEnum(1);
    public oidb_0x935.Label tag_wording = new oidb_0x935.Label();
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
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "recommend_info", "is_end", "cur_pos" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    public final PBUInt32Field cur_pos = PBField.initUInt32(0);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0x935.RecommendInfo> recommend_info = PBField.initRepeatMessage(oidb_0x935.RecommendInfo.class);
  }
  
  public static final class UinInfo
    extends MessageMicro<UinInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int64_longitude", "int64_latitude" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, UinInfo.class);
    public final PBInt64Field int64_latitude = PBField.initInt64(0L);
    public final PBInt64Field int64_longitude = PBField.initInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x935.oidb_0x935
 * JD-Core Version:    0.7.0.1
 */