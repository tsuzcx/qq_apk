package msg.aio_doodle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DoodleMsgProto
{
  public static final class DoodleData
    extends MessageMicro<DoodleData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint_line_id", "uint32template_id", "uint32_rgba", "uint32_time", "rpt_line_Data" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, DoodleData.class);
    public final PBRepeatMessageField<DoodleMsgProto.LineData> rpt_line_Data = PBField.initRepeatMessage(DoodleMsgProto.LineData.class);
    public final PBUInt32Field uint32_rgba = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32template_id = PBField.initUInt32(0);
    public final PBUInt32Field uint_line_id = PBField.initUInt32(0);
  }
  
  public static final class DoodleHeader
    extends MessageMicro<DoodleHeader>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBFloatField float_comp_factor_max = PBField.initFloat(0.0F);
    public final PBFloatField float_comp_factor_min = PBField.initFloat(0.0F);
    public final PBFloatField float_draw_area_height = PBField.initFloat(0.0F);
    public final PBFloatField float_draw_area_width = PBField.initFloat(0.0F);
    public final PBFloatField float_line_width_max = PBField.initFloat(0.0F);
    public final PBFloatField float_line_width_min = PBField.initFloat(0.0F);
    public final PBBytesField tytes_doodle_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_Version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_line_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 45, 53, 61, 69, 77, 85 }, new String[] { "uint32_Version", "tytes_doodle_md5", "uint32_time", "uint32_line_count", "float_line_width_max", "float_line_width_min", "float_comp_factor_max", "float_comp_factor_min", "float_draw_area_width", "float_draw_area_height" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F) }, DoodleHeader.class);
    }
  }
  
  public static final class LineData
    extends MessageMicro<LineData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 24 }, new String[] { "float_X", "float_Y", "uint64_tickcount" }, new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Long.valueOf(0L) }, LineData.class);
    public final PBFloatField float_X = PBField.initFloat(0.0F);
    public final PBFloatField float_Y = PBField.initFloat(0.0F);
    public final PBUInt64Field uint64_tickcount = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msg.aio_doodle.DoodleMsgProto
 * JD-Core Version:    0.7.0.1
 */