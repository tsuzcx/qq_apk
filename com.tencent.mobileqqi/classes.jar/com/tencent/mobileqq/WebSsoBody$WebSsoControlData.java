package com.tencent.mobileqq;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WebSsoBody$WebSsoControlData
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "frequency", "packageSize" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, WebSsoControlData.class);
  public final PBUInt32Field frequency = PBField.initUInt32(0);
  public final PBUInt32Field packageSize = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.WebSsoBody.WebSsoControlData
 * JD-Core Version:    0.7.0.1
 */