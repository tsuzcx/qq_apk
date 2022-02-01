package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AVFunDrawing
{
  public static final class DrawingInfo
    extends MessageMicro<DrawingInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 58 }, new String[] { "uint32_pen_type", "str_pen_name", "str_pen_color", "uint32_pen_width", "uint32_screen_width", "uint32_screen_height", "msg_point_info" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, DrawingInfo.class);
    public final PBRepeatMessageField<AVFunDrawing.PointInfo> msg_point_info = PBField.initRepeatMessage(AVFunDrawing.PointInfo.class);
    public final PBStringField str_pen_color = PBField.initString("");
    public final PBStringField str_pen_name = PBField.initString("");
    public final PBUInt32Field uint32_pen_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pen_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_screen_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_screen_width = PBField.initUInt32(0);
  }
  
  public static final class MessageBody
    extends MessageMicro<MessageBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "uint32_msg_type", "versionInfo", "drawingInfo", "uint32_seq", "uint64_time" }, new Object[] { Integer.valueOf(0), null, null, Integer.valueOf(0), Long.valueOf(0L) }, MessageBody.class);
    public AVFunDrawing.DrawingInfo drawingInfo = new AVFunDrawing.DrawingInfo();
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
    public AVFunDrawing.VersionInfo versionInfo = new AVFunDrawing.VersionInfo();
  }
  
  public static final class PointInfo
    extends MessageMicro<PointInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 24 }, new String[] { "float_x", "float_y", "uint32_type" }, new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Integer.valueOf(0) }, PointInfo.class);
    public final PBFloatField float_x = PBField.initFloat(0.0F);
    public final PBFloatField float_y = PBField.initFloat(0.0F);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
  
  public static final class VersionInfo
    extends MessageMicro<VersionInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_version", "uint32_support_drawing" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, VersionInfo.class);
    public final PBUInt32Field uint32_support_drawing = PBField.initUInt32(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.AVFunDrawing
 * JD-Core Version:    0.7.0.1
 */