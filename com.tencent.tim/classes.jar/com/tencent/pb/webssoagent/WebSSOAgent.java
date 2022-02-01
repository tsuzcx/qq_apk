package com.tencent.pb.webssoagent;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WebSSOAgent
{
  public static final class UniSsoServerReq
    extends MessageMicro<UniSsoServerReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public WebSSOAgent.UniSsoServerReqComm comm = new WebSSOAgent.UniSsoServerReqComm();
    public final PBBytesField pbReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField reqdata = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "comm", "reqdata", "pbReqData" }, new Object[] { null, "", localByteStringMicro }, UniSsoServerReq.class);
    }
  }
  
  public static final class UniSsoServerReqComm
    extends MessageMicro<UniSsoServerReqComm>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "platform", "osver", "mqqver" }, new Object[] { Long.valueOf(0L), "", "" }, UniSsoServerReqComm.class);
    public final PBStringField mqqver = PBField.initString("");
    public final PBStringField osver = PBField.initString("");
    public final PBInt64Field platform = PBField.initInt64(0L);
  }
  
  public static final class UniSsoServerRsp
    extends MessageMicro<UniSsoServerRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public WebSSOAgent.UniSsoServerRspComm comm = new WebSSOAgent.UniSsoServerRspComm();
    public final PBStringField errmsg = PBField.initString("");
    public final PBBytesField pbRsqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field ret = PBField.initInt64(0L);
    public final PBStringField rspdata = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "ret", "errmsg", "comm", "rspdata", "pbRsqData" }, new Object[] { Long.valueOf(0L), "", null, "", localByteStringMicro }, UniSsoServerRsp.class);
    }
  }
  
  public static final class UniSsoServerRspComm
    extends MessageMicro<UniSsoServerRspComm>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "delayms", "packagesize", "proctime" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, UniSsoServerRspComm.class);
    public final PBUInt32Field delayms = PBField.initUInt32(0);
    public final PBUInt32Field packagesize = PBField.initUInt32(0);
    public final PBInt32Field proctime = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.webssoagent.WebSSOAgent
 * JD-Core Version:    0.7.0.1
 */