package tencent.im.oidb.cmd0x9fb;

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

public final class oidb_0x9fb
{
  public static final class Color
    extends MessageMicro<Color>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_r", "uint32_g", "uint32_b" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Color.class);
    public final PBUInt32Field uint32_b = PBField.initUInt32(0);
    public final PBUInt32Field uint32_g = PBField.initUInt32(0);
    public final PBUInt32Field uint32_r = PBField.initUInt32(0);
  }
  
  public static final class GroupLabel
    extends MessageMicro<GroupLabel>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "uin_info", "uint32_number_label", "uint32_label_style" }, new Object[] { null, Integer.valueOf(5), Integer.valueOf(0) }, GroupLabel.class);
    public oidb_0x9fb.UinInfo uin_info = new oidb_0x9fb.UinInfo();
    public final PBUInt32Field uint32_label_style = PBField.initUInt32(0);
    public final PBUInt32Field uint32_number_label = PBField.initUInt32(5);
  }
  
  public static final class Label
    extends MessageMicro<Label>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x9fb.Color edging_color = new oidb_0x9fb.Color();
    public final PBEnumField enum_type = PBField.initEnum(1);
    public oidb_0x9fb.Color text_color = new oidb_0x9fb.Color();
    public final PBUInt32Field uint32_label_attr = PBField.initUInt32(0);
    public final PBUInt32Field uint32_label_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48 }, new String[] { "bytes_name", "enum_type", "text_color", "edging_color", "uint32_label_attr", "uint32_label_type" }, new Object[] { localByteStringMicro, Integer.valueOf(1), null, null, Integer.valueOf(0), Integer.valueOf(0) }, Label.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "uint32_appid", "uint32_cmdid", "int32_channel", "uint64_last_group_code", "msg_group_label", "uint32_reason" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(0) }, ReqBody.class);
    public final PBInt32Field int32_channel = PBField.initInt32(0);
    public oidb_0x9fb.GroupLabel msg_group_label = new oidb_0x9fb.GroupLabel();
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cmdid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reason = PBField.initUInt32(0);
    public final PBUInt64Field uint64_last_group_code = PBField.initUInt64(0L);
  }
  
  public static final class RgroupInfo
    extends MessageMicro<RgroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_group_class_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_group_face_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_group_memo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x9fb.Label> rpt_group_label = PBField.initRepeatMessage(oidb_0x9fb.Label.class);
    public final PBUInt32Field uint32_group_bitmap = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_class = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_face = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_hot_degree = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_max_member_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 56, 66, 74, 82, 88, 96, 104, 112, 120, 130 }, new String[] { "uint64_group_code", "uint64_owner_uin", "bytes_group_name", "bytes_group_memo", "uint32_member_num", "uint32_group_face", "uint32_group_class", "bytes_group_face_url", "rpt_group_label", "bytes_group_class_text", "uint32_max_member_num", "uint32_group_level", "uint32_group_bitmap", "uint32_group_hot_degree", "uint32_group_flag", "bytes_recommend_reason" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, null, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5 }, RgroupInfo.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_errMsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0x9fb.RgroupInfo> msg_groups = PBField.initRepeatMessage(oidb_0x9fb.RgroupInfo.class);
    public final PBUInt32Field uint32_cmdid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uint32_cmdid", "uint32_result", "bytes_errMsg", "msg_groups", "is_end" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null, Integer.valueOf(0) }, RspBody.class);
    }
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
 * Qualified Name:     tencent.im.oidb.cmd0x9fb.oidb_0x9fb
 * JD-Core Version:    0.7.0.1
 */