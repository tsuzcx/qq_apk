package com.tencent.pb.unifiedebug;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class RemoteDebugReportMsg
{
  public static final class RemoteLogReq
    extends MessageMicro<RemoteLogReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_seq", "str_data" }, new Object[] { "", "" }, RemoteLogReq.class);
    public final PBStringField str_data = PBField.initString("");
    public final PBStringField str_seq = PBField.initString("");
  }
  
  public static final class RemoteLogRsp
    extends MessageMicro<RemoteLogRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "i32_ret" }, new Object[] { Integer.valueOf(0) }, RemoteLogRsp.class);
    public final PBInt32Field i32_ret = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.unifiedebug.RemoteDebugReportMsg
 * JD-Core Version:    0.7.0.1
 */