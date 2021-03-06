package com.tencent.pb.personal;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class PersonalInfo
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "itemid", "fontid", "fonttype" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBInt32Field fontid = PBField.initInt32(0);
    public final PBInt32Field fonttype = PBField.initInt32(0);
    public final PBInt32Field itemid = PBField.initInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.personal.PersonalInfo
 * JD-Core Version:    0.7.0.1
 */