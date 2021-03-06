package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Proto
{
  public static final class EchoReq
    extends MessageMicro<EchoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg" }, new Object[] { "" }, EchoReq.class);
    public final PBStringField msg = PBField.initString("");
  }
  
  public static final class EchoRsp
    extends MessageMicro<EchoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg" }, new Object[] { "" }, EchoRsp.class);
    public final PBStringField msg = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.Proto
 * JD-Core Version:    0.7.0.1
 */