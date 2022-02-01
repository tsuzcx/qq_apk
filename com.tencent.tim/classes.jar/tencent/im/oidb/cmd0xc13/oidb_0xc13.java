package tencent.im.oidb.cmd0xc13;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xc13
{
  public static final class EncryptUinReqBody
    extends MessageMicro<EncryptUinReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint64_uin" }, new Object[] { Long.valueOf(0L) }, EncryptUinReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class EncryptUinResult
    extends MessageMicro<EncryptUinResult>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_encrypt_uin = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBUInt64Field uint64_original_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_original_uin", "int32_result", "bytes_encrypt_uin" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, EncryptUinResult.class);
    }
  }
  
  public static final class EncryptUinRspBody
    extends MessageMicro<EncryptUinRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_encrypt_result" }, new Object[] { null }, EncryptUinRspBody.class);
    public final PBRepeatMessageField<oidb_0xc13.EncryptUinResult> rpt_msg_encrypt_result = PBField.initRepeatMessage(oidb_0xc13.EncryptUinResult.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_encrypt_uin_req_body" }, new Object[] { null }, ReqBody.class);
    public oidb_0xc13.EncryptUinReqBody msg_encrypt_uin_req_body = new oidb_0xc13.EncryptUinReqBody();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_encrypt_uin_rsp_body" }, new Object[] { null }, RspBody.class);
    public oidb_0xc13.EncryptUinRspBody msg_encrypt_uin_rsp_body = new oidb_0xc13.EncryptUinRspBody();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc13.oidb_0xc13
 * JD-Core Version:    0.7.0.1
 */