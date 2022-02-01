package tencent.im.oidb.cmd0xcdd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class oidb_cmd0xcdd
{
  public static final class ConfirmQrReq
    extends MessageMicro<ConfirmQrReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField biz_type = PBField.initEnum(1);
    public final PBBytesField qr_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0xcdd.UserData user_data = new oidb_cmd0xcdd.UserData();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "qr_sig", "user_data", "biz_type" }, new Object[] { localByteStringMicro, null, Integer.valueOf(1) }, ConfirmQrReq.class);
    }
  }
  
  public static final class ConfirmQrRsp
    extends MessageMicro<ConfirmQrRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField biz_type = PBField.initEnum(1);
    public final PBBytesField encrypt_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField token = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0xcdd.UserData user_data = new oidb_cmd0xcdd.UserData();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "token", "encrypt_key", "user_data", "biz_type" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(1) }, ConfirmQrRsp.class);
    }
  }
  
  public static final class GetQrReq
    extends MessageMicro<GetQrReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "push", "user_data", "biz_type" }, new Object[] { Boolean.valueOf(false), null, Integer.valueOf(1) }, GetQrReq.class);
    public final PBEnumField biz_type = PBField.initEnum(1);
    public final PBBoolField push = PBField.initBool(false);
    public oidb_cmd0xcdd.UserData user_data = new oidb_cmd0xcdd.UserData();
  }
  
  public static final class GetQrRsp
    extends MessageMicro<GetQrRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField biz_type = PBField.initEnum(1);
    public final PBBytesField encrypt_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField qr_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField token = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0xcdd.UserData user_data = new oidb_cmd0xcdd.UserData();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "qr_sig", "token", "encrypt_key", "user_data", "biz_type" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, Integer.valueOf(1) }, GetQrRsp.class);
    }
  }
  
  public static final class QueryStateReq
    extends MessageMicro<QueryStateReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField qr_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "qr_sig" }, new Object[] { localByteStringMicro }, QueryStateReq.class);
    }
  }
  
  public static final class QueryStateRsp
    extends MessageMicro<QueryStateRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField biz_type = PBField.initEnum(1);
    public final PBBytesField encrypt_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField state = PBField.initEnum(1);
    public final PBBytesField token = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0xcdd.UserData user_data = new oidb_cmd0xcdd.UserData();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "state", "token", "encrypt_key", "user_data", "biz_type" }, new Object[] { Integer.valueOf(1), localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(1) }, QueryStateRsp.class);
    }
  }
  
  public static final class RejectQrReq
    extends MessageMicro<RejectQrReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField biz_type = PBField.initEnum(1);
    public final PBBytesField qr_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "qr_sig", "biz_type" }, new Object[] { localByteStringMicro, Integer.valueOf(1) }, RejectQrReq.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "get_qr_req", "confirm_qr_req", "verify_token_req", "reject_qr_req", "query_state_req" }, new Object[] { null, null, null, null, null }, ReqBody.class);
    public oidb_cmd0xcdd.ConfirmQrReq confirm_qr_req = new oidb_cmd0xcdd.ConfirmQrReq();
    public oidb_cmd0xcdd.GetQrReq get_qr_req = new oidb_cmd0xcdd.GetQrReq();
    public oidb_cmd0xcdd.QueryStateReq query_state_req = new oidb_cmd0xcdd.QueryStateReq();
    public oidb_cmd0xcdd.RejectQrReq reject_qr_req = new oidb_cmd0xcdd.RejectQrReq();
    public oidb_cmd0xcdd.VerifyTokenReq verify_token_req = new oidb_cmd0xcdd.VerifyTokenReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "get_qr_rsp", "confirm_qr_rsp", "query_state_rsp" }, new Object[] { null, null, null }, RspBody.class);
    public oidb_cmd0xcdd.ConfirmQrRsp confirm_qr_rsp = new oidb_cmd0xcdd.ConfirmQrRsp();
    public oidb_cmd0xcdd.GetQrRsp get_qr_rsp = new oidb_cmd0xcdd.GetQrRsp();
    public oidb_cmd0xcdd.QueryStateRsp query_state_rsp = new oidb_cmd0xcdd.QueryStateRsp();
  }
  
  public static final class UserData
    extends MessageMicro<UserData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bssid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField ip = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField platform = PBField.initEnum(1);
    public final PBRepeatField<Integer> port = PBField.initRepeat(PBFixed32Field.__repeatHelper__);
    public final PBBytesField ssid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21, 26, 34, 40 }, new String[] { "ip", "port", "ssid", "bssid", "platform" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(1) }, UserData.class);
    }
  }
  
  public static final class VerifyTokenReq
    extends MessageMicro<VerifyTokenReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField token = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "token" }, new Object[] { localByteStringMicro }, VerifyTokenReq.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd
 * JD-Core Version:    0.7.0.1
 */