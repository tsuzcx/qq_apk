package tencent.im.oidb.cmd0x626;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x626
{
  public static final class OpenIDInfoRsp
    extends MessageMicro<OpenIDInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_openid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_acounttype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint32_appid", "uint64_tinyid", "bytes_openid", "uint32_acounttype" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, OpenIDInfoRsp.class);
    }
  }
  
  public static final class Tiny2Open_ReqBody
    extends MessageMicro<Tiny2Open_ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_tinyid_req_info" }, new Object[] { null }, Tiny2Open_ReqBody.class);
    public final PBRepeatMessageField<Oidb_0x626.TinyIDInfoReq> msg_tinyid_req_info = PBField.initRepeatMessage(Oidb_0x626.TinyIDInfoReq.class);
  }
  
  public static final class Tiny2Open_RspBody
    extends MessageMicro<Tiny2Open_RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_openid_rsp_info" }, new Object[] { null }, Tiny2Open_RspBody.class);
    public final PBRepeatMessageField<Oidb_0x626.OpenIDInfoRsp> msg_openid_rsp_info = PBField.initRepeatMessage(Oidb_0x626.OpenIDInfoRsp.class);
  }
  
  public static final class TinyIDInfoReq
    extends MessageMicro<TinyIDInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_tinyid" }, new Object[] { Long.valueOf(0L) }, TinyIDInfoReq.class);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x626.Oidb_0x626
 * JD-Core Version:    0.7.0.1
 */