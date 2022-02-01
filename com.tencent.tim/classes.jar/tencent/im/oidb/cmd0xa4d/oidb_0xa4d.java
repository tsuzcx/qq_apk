package tencent.im.oidb.cmd0xa4d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xa4d
{
  public static final class IMMRReq
    extends MessageMicro<IMMRReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_url" }, new Object[] { "" }, IMMRReq.class);
    public final PBStringField str_url = PBField.initString("");
  }
  
  public static final class IMMRRsp
    extends MessageMicro<IMMRRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rsp_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public final PBInt64Field int64_last_modified = PBField.initInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 810 }, new String[] { "int32_ret", "int64_last_modified", "bytes_rsp_data" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, IMMRRsp.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_immr_req" }, new Object[] { null }, ReqBody.class);
    public oidb_0xa4d.IMMRReq msg_immr_req = new oidb_0xa4d.IMMRReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_immr_rsp" }, new Object[] { null }, RspBody.class);
    public oidb_0xa4d.IMMRRsp msg_immr_rsp = new oidb_0xa4d.IMMRRsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa4d.oidb_0xa4d
 * JD-Core Version:    0.7.0.1
 */