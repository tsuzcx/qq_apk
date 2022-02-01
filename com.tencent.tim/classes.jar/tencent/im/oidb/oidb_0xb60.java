package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xb60
{
  public static final class CheckUrlReq
    extends MessageMicro<CheckUrlReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "appid", "app_type", "url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, CheckUrlReq.class);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class CheckUrlRsp
    extends MessageMicro<CheckUrlRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "is_authed", "next_req_duration" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0) }, CheckUrlRsp.class);
    public final PBBoolField is_authed = PBField.initBool(false);
    public final PBUInt32Field next_req_duration = PBField.initUInt32(0);
  }
  
  public static final class ClientInfo
    extends MessageMicro<ClientInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "platform", "sdk_version", "android_package_name", "android_signature", "ios_bundle_id", "pc_sign" }, new Object[] { Integer.valueOf(0), "", "", "", "", "" }, ClientInfo.class);
    public final PBStringField android_package_name = PBField.initString("");
    public final PBStringField android_signature = PBField.initString("");
    public final PBStringField ios_bundle_id = PBField.initString("");
    public final PBStringField pc_sign = PBField.initString("");
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField sdk_version = PBField.initString("");
  }
  
  public static final class GetPrivilegeReq
    extends MessageMicro<GetPrivilegeReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "appid", "app_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(3) }, GetPrivilegeReq.class);
    public final PBUInt32Field app_type = PBField.initUInt32(3);
    public final PBUInt32Field appid = PBField.initUInt32(0);
  }
  
  public static final class GetPrivilegeRsp
    extends MessageMicro<GetPrivilegeRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "api_groups", "next_req_duration", "api_names" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, GetPrivilegeRsp.class);
    public final PBRepeatField<Integer> api_groups = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<String> api_names = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field next_req_duration = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82, 90 }, new String[] { "client_info", "get_privilege_req", "check_url_req" }, new Object[] { null, null, null }, ReqBody.class);
    public oidb_0xb60.CheckUrlReq check_url_req = new oidb_0xb60.CheckUrlReq();
    public oidb_0xb60.ClientInfo client_info = new oidb_0xb60.ClientInfo();
    public oidb_0xb60.GetPrivilegeReq get_privilege_req = new oidb_0xb60.GetPrivilegeReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82, 90 }, new String[] { "wording", "get_privilege_rsp", "check_url_rsp" }, new Object[] { "", null, null }, RspBody.class);
    public oidb_0xb60.CheckUrlRsp check_url_rsp = new oidb_0xb60.CheckUrlRsp();
    public oidb_0xb60.GetPrivilegeRsp get_privilege_rsp = new oidb_0xb60.GetPrivilegeRsp();
    public final PBStringField wording = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb60
 * JD-Core Version:    0.7.0.1
 */