package tencent.im.cs.cmd0x6ff.cmd0x50b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class subcmd0x50b
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int MSG_SUBCMD_0X50C_REQ_BODY_FIELD_NUMBER = 1291;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10330 }, new String[] { "msg_subcmd_0x50c_req_body" }, new Object[] { null }, ReqBody.class);
    public subcmd0x50b.SubCmd0x50bReqBody msg_subcmd_0x50c_req_body = new subcmd0x50b.SubCmd0x50bReqBody();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspBody.class);
  }
  
  public static final class SubCmd0x50bReqBody
    extends MessageMicro<SubCmd0x50bReqBody>
  {
    public static final int BYTES_MSG_RESID_FIELD_NUMBER = 1;
    public static final int BYTES_MSG_UKEY_FIELD_NUMBER = 2;
    public static final int BYTES_OBJ_MSG_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_obj_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bytes_msg_resid", "bytes_msg_ukey", "bytes_obj_msg" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, SubCmd0x50bReqBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.cmd0x50b.subcmd0x50b
 * JD-Core Version:    0.7.0.1
 */