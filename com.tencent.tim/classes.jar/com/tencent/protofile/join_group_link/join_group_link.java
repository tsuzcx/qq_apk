package com.tencent.protofile.join_group_link;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class join_group_link
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "type", "group_code" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBEnumField type = PBField.initEnum(1);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "error_code", "group_code", "url" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "" }, RspBody.class);
    public final PBUInt32Field error_code = PBField.initUInt32(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBStringField url = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.protofile.join_group_link.join_group_link
 * JD-Core Version:    0.7.0.1
 */