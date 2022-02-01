package com.tencent.pb.websafe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WebSafe
{
  public static final class CheckURLReq
    extends MessageMicro<CheckURLReq>
  {
    public static final int GDT_DATA_FIELD_NUMBER = 2;
    public static final int URL_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "url", "gdt_data" }, new Object[] { "", "" }, CheckURLReq.class);
    public final PBStringField gdt_data = PBField.initString("");
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class CheckURLResp
    extends MessageMicro<CheckURLResp>
  {
    public static final int RESULT_FIELD_NUMBER = 2;
    public static final int RETCODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "retcode", "result" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, CheckURLResp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.websafe.WebSafe
 * JD-Core Version:    0.7.0.1
 */