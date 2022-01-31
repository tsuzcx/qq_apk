package com.tencent.pb.near_horn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class NearHornPb$HornRspHead
  extends MessageMicro
{
  public static final int CODE_FIELD_NUMBER = 1;
  public static final int MSG_FIELD_NUMBER = 3;
  public static final int MSG_TYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "code", "msg_type", "msg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, HornRspHead.class);
  public final PBInt32Field code = PBField.initInt32(0);
  public final PBStringField msg = PBField.initString("");
  public final PBInt32Field msg_type = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.near_horn.NearHornPb.HornRspHead
 * JD-Core Version:    0.7.0.1
 */