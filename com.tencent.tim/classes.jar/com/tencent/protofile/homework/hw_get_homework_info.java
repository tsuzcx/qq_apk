package com.tencent.protofile.homework;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.protofile.group_homework.value.HomeworkInfo;

public final class hw_get_homework_info
{
  public static final class ErrorInfo
    extends MessageMicro<ErrorInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field error_code = PBField.initUInt32(0);
    public final PBBytesField error_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "error_code", "error_desc" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, ErrorInfo.class);
    }
  }
  
  public static final class ReqGetHomeworkInfo
    extends MessageMicro<ReqGetHomeworkInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "hw_id" }, new Object[] { Long.valueOf(0L) }, ReqGetHomeworkInfo.class);
    public final PBUInt64Field hw_id = PBField.initUInt64(0L);
  }
  
  public static final class RspGetHomeworkInfo
    extends MessageMicro<RspGetHomeworkInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "errinfo", "info" }, new Object[] { null, null }, RspGetHomeworkInfo.class);
    public hw_get_homework_info.ErrorInfo errinfo = new hw_get_homework_info.ErrorInfo();
    public value.HomeworkInfo info = new value.HomeworkInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.protofile.homework.hw_get_homework_info
 * JD-Core Version:    0.7.0.1
 */