package tencent.im.group.group_label;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GroupLabel
{
  public static final class Color
    extends MessageMicro<Color>
  {
    public static final int UINT32_B_FIELD_NUMBER = 3;
    public static final int UINT32_G_FIELD_NUMBER = 2;
    public static final int UINT32_R_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_r", "uint32_g", "uint32_b" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Color.class);
    public final PBUInt32Field uint32_b = PBField.initUInt32(0);
    public final PBUInt32Field uint32_g = PBField.initUInt32(0);
    public final PBUInt32Field uint32_r = PBField.initUInt32(0);
  }
  
  public static final class GroupInfo
    extends MessageMicro<GroupInfo>
  {
    public static final int INT32_RESULT_FIELD_NUMBER = 1;
    public static final int RPT_GROUP_LABEL_FIELD_NUMBER = 3;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "int32_result", "uint64_group_code", "rpt_group_label" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null }, GroupInfo.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBRepeatMessageField<GroupLabel.Label> rpt_group_label = PBField.initRepeatMessage(GroupLabel.Label.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class Label
    extends MessageMicro<Label>
  {
    public static final int BYTES_NAME_FIELD_NUMBER = 1;
    public static final int EDGING_COLOR_FIELD_NUMBER = 4;
    public static final int ENUM_TYPE_FIELD_NUMBER = 2;
    public static final int TEXT_COLOR_FIELD_NUMBER = 3;
    public static final int UINT32_LABEL_ATTR_FIELD_NUMBER = 5;
    public static final int UINT32_LABEL_TYPE_FIELD_NUMBER = 6;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public GroupLabel.Color edging_color = new GroupLabel.Color();
    public final PBEnumField enum_type = PBField.initEnum(1);
    public GroupLabel.Color text_color = new GroupLabel.Color();
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
    public static final int RPT_GROUP_CODE_FIELD_NUMBER = 4;
    public static final int SOURCE_ID_FIELD_NUMBER = 1;
    public static final int UINT32_LABEL_STYLE_FIELD_NUMBER = 5;
    public static final int UINT32_NUMBER_LABEL_FIELD_NUMBER = 3;
    public static final int UIN_INFO_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "source_id", "uin_info", "uint32_number_label", "rpt_group_code", "uint32_label_style" }, new Object[] { null, null, Integer.valueOf(5), Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
    public final PBRepeatField<Long> rpt_group_code = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public GroupLabel.SourceId source_id = new GroupLabel.SourceId();
    public GroupLabel.UinInfo uin_info = new GroupLabel.UinInfo();
    public final PBUInt32Field uint32_label_style = PBField.initUInt32(0);
    public final PBUInt32Field uint32_number_label = PBField.initUInt32(5);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int BYTES_ERROR_FIELD_NUMBER = 1;
    public static final int RPT_GROUP_INFO_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<GroupLabel.GroupInfo> rpt_group_info = PBField.initRepeatMessage(GroupLabel.GroupInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_error", "rpt_group_info" }, new Object[] { localByteStringMicro, null }, RspBody.class);
    }
  }
  
  public static final class SourceId
    extends MessageMicro<SourceId>
  {
    public static final int UINT32_SOURCE_ID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_source_id" }, new Object[] { Integer.valueOf(0) }, SourceId.class);
    public final PBUInt32Field uint32_source_id = PBField.initUInt32(0);
  }
  
  public static final class UinInfo
    extends MessageMicro<UinInfo>
  {
    public static final int INT64_LATITUDE_FIELD_NUMBER = 2;
    public static final int INT64_LONGITUDE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int64_longitude", "int64_latitude" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, UinInfo.class);
    public final PBInt64Field int64_latitude = PBField.initInt64(0L);
    public final PBInt64Field int64_longitude = PBField.initInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.group.group_label.GroupLabel
 * JD-Core Version:    0.7.0.1
 */