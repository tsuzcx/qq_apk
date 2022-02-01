package tencent.hiboom.hiboomauth;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.msg.im_imagent.ImAgentHead;
import tencent.im.msg.im_msg_body.CommonElem;

public final class hiboom_auth
{
  public static final class AuthReqBody
    extends MessageMicro<AuthReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field i32_implat = PBField.initInt32(0);
    public im_msg_body.CommonElem req_elem = new im_msg_body.CommonElem();
    public final PBBytesField str_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field u32_product_id = PBField.initUInt32(0);
    public final PBUInt64Field u64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "u64_uin", "i32_implat", "str_version", "req_elem", "u32_product_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, null, Integer.valueOf(0) }, AuthReqBody.class);
    }
  }
  
  public static final class AuthRspBody
    extends MessageMicro<AuthRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_trans_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field i32_result = PBField.initInt32(0);
    public final PBUInt32Field u32_business_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "i32_result", "bytes_err_msg", "bytes_trans_info", "u32_business_type" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, AuthRspBody.class);
    }
  }
  
  public static final class ImAgentSendNextPack
    extends MessageMicro<ImAgentSendNextPack>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 106, 114 }, new String[] { "head", "reqBody", "rspBody" }, new Object[] { null, null, null }, ImAgentSendNextPack.class);
    public im_imagent.ImAgentHead head = new im_imagent.ImAgentHead();
    public hiboom_auth.AuthReqBody reqBody = new hiboom_auth.AuthReqBody();
    public hiboom_auth.AuthRspBody rspBody = new hiboom_auth.AuthRspBody();
  }
  
  public static final class TTipsInfo
    extends MessageMicro<TTipsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "i32_type", "str_msg", "str_title", "str_button", "str_url", "str_vip_type", "str_month", "str_aid" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", "", "" }, TTipsInfo.class);
    public final PBInt32Field i32_type = PBField.initInt32(0);
    public final PBStringField str_aid = PBField.initString("");
    public final PBStringField str_button = PBField.initString("");
    public final PBStringField str_month = PBField.initString("");
    public final PBStringField str_msg = PBField.initString("");
    public final PBStringField str_title = PBField.initString("");
    public final PBStringField str_url = PBField.initString("");
    public final PBStringField str_vip_type = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.hiboom.hiboomauth.hiboom_auth
 * JD-Core Version:    0.7.0.1
 */