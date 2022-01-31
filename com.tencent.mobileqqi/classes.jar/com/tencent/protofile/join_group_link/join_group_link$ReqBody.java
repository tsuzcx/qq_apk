package com.tencent.protofile.join_group_link;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class join_group_link$ReqBody
  extends MessageMicro
{
  public static final int GROUP_CODE_FIELD_NUMBER = 2;
  public static final int TYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "type", "group_code" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L) }, ReqBody.class);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBEnumField type = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.protofile.join_group_link.join_group_link.ReqBody
 * JD-Core Version:    0.7.0.1
 */