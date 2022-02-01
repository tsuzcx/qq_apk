package tencent.im.cs.smart_device_proxy;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class smart_device_proxy
{
  public static final class CgiReq
    extends MessageMicro<CgiReq>
  {
    public static final int BYTES_COOKIE_FIELD_NUMBER = 3;
    public static final int BYTES_PARAM_FIELD_NUMBER = 2;
    public static final int STR_CGINAME_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_param = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_cgiName = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_cgiName", "bytes_param", "bytes_cookie" }, new Object[] { "", localByteStringMicro1, localByteStringMicro2 }, CgiReq.class);
    }
  }
  
  public static final class CgiRsp
    extends MessageMicro<CgiRsp>
  {
    public static final int BYTES_RSP_FIELD_NUMBER = 3;
    public static final int INT32_ERRORCODE_FIELD_NUMBER = 1;
    public static final int STR_ERRORMSG_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rsp = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_errorCode = PBField.initInt32(0);
    public final PBStringField str_errorMsg = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_errorCode", "str_errorMsg", "bytes_rsp" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro }, CgiRsp.class);
    }
  }
  
  public static final class CommonHead
    extends MessageMicro<CommonHead>
  {
    public static final int BYTES_SN_FIELD_NUMBER = 5;
    public static final int BYTES_TINYIDA2_FIELD_NUMBER = 7;
    public static final int BYTES_UINA2_FIELD_NUMBER = 6;
    public static final int STR_VERSION_FIELD_NUMBER = 8;
    public static final int UINT32_FLAG_FIELD_NUMBER = 10;
    public static final int UINT32_PID_FIELD_NUMBER = 4;
    public static final int UINT32_SEQ_FIELD_NUMBER = 9;
    public static final int UINT32_UIN_FIELD_NUMBER = 1;
    public static final int UINT64_DIN_FIELD_NUMBER = 2;
    public static final int UINT64_TINYID_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sn = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tinyidA2 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uinA2 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_version = PBField.initString("");
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt64Field uint32_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_din = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 72, 80 }, new String[] { "uint32_uin", "uint64_din", "uint64_tinyid", "uint32_pid", "bytes_sn", "bytes_uinA2", "bytes_tinyidA2", "str_version", "uint32_seq", "uint32_flag" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, "", Integer.valueOf(0), Integer.valueOf(0) }, CommonHead.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int BYTES_BODY_FIELD_NUMBER = 3;
    public static final int INT32_CMD_FIELD_NUMBER = 1;
    public static final int MSG_HEADER_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_body = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_cmd = PBField.initInt32(0);
    public smart_device_proxy.CommonHead msg_header = new smart_device_proxy.CommonHead();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_cmd", "msg_header", "bytes_body" }, new Object[] { Integer.valueOf(0), null, localByteStringMicro }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int BYTES_INFO_FIELD_NUMBER = 3;
    public static final int INT32_CMD_FIELD_NUMBER = 1;
    public static final int INT32_ERRORCODE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_cmd = PBField.initInt32(0);
    public final PBInt32Field int32_errorCode = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "int32_cmd", "int32_errorCode", "bytes_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.smart_device_proxy.smart_device_proxy
 * JD-Core Version:    0.7.0.1
 */