package tencent.im.oidb.cmd0x625;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x625
{
  public static final class Open2Tiny_ReqBody
    extends MessageMicro<Open2Tiny_ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_openid_req_info" }, new Object[] { null }, Open2Tiny_ReqBody.class);
    public final PBRepeatMessageField<Oidb_0x625.OpenIDInfoReq> msg_openid_req_info = PBField.initRepeatMessage(Oidb_0x625.OpenIDInfoReq.class);
  }
  
  public static final class Open2Tiny_RspBody
    extends MessageMicro<Open2Tiny_RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_tinyid_rsp_info" }, new Object[] { null }, Open2Tiny_RspBody.class);
    public final PBRepeatMessageField<Oidb_0x625.TinyIDInfoRsp> msg_tinyid_rsp_info = PBField.initRepeatMessage(Oidb_0x625.TinyIDInfoRsp.class);
  }
  
  public static final class OpenIDInfoReq
    extends MessageMicro<OpenIDInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_openid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_acounttype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_appid", "bytes_openid", "uint32_acounttype" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, OpenIDInfoReq.class);
    }
  }
  
  public static final class TinyIDInfoRsp
    extends MessageMicro<TinyIDInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_openid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_acounttype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_appid", "bytes_openid", "uint64_tinyid", "uint32_acounttype" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0) }, TinyIDInfoRsp.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x625.Oidb_0x625
 * JD-Core Version:    0.7.0.1
 */