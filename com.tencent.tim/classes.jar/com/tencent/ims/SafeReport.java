package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SafeReport
{
  public static final class LogItem
    extends MessageMicro<LogItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rpt_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_rpt_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_rpt_id", "bytes_rpt_data" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, LogItem.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "LogItem_reportdata" }, new Object[] { null }, ReqBody.class);
    public final PBRepeatMessageField<SafeReport.LogItem> LogItem_reportdata = PBField.initRepeatMessage(SafeReport.LogItem.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "string_errmsg" }, new Object[] { Integer.valueOf(0), "" }, RspBody.class);
    public final PBStringField string_errmsg = PBField.initString("");
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ims.SafeReport
 * JD-Core Version:    0.7.0.1
 */