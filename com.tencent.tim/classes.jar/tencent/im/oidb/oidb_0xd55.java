package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xd55
{
  public static final class CheckAppSignReq
    extends MessageMicro<CheckAppSignReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "client_info" }, new Object[] { null }, CheckAppSignReq.class);
    public qqconnect.ConnectClientInfo client_info = new qqconnect.ConnectClientInfo();
  }
  
  public static final class CheckAppSignRsp
    extends MessageMicro<CheckAppSignRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 88 }, new String[] { "ios_app_token", "ios_universal_link", "optimize_switch" }, new Object[] { "", "", Integer.valueOf(0) }, CheckAppSignRsp.class);
    public final PBStringField ios_app_token = PBField.initString("");
    public final PBStringField ios_universal_link = PBField.initString("");
    public final PBUInt32Field optimize_switch = PBField.initUInt32(0);
  }
  
  public static final class CheckMiniAppReq
    extends MessageMicro<CheckMiniAppReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "mini_app_appid", "need_check_bind" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, CheckMiniAppReq.class);
    public final PBUInt64Field mini_app_appid = PBField.initUInt64(0L);
    public final PBUInt32Field need_check_bind = PBField.initUInt32(0);
  }
  
  public static final class CheckMiniAppRsp
    extends MessageMicro<CheckMiniAppRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], CheckMiniAppRsp.class);
  }
  
  public static final class CheckUserReq
    extends MessageMicro<CheckUserReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "openid", "need_check_same_user" }, new Object[] { "", Integer.valueOf(0) }, CheckUserReq.class);
    public final PBUInt32Field need_check_same_user = PBField.initUInt32(0);
    public final PBStringField openid = PBField.initString("");
  }
  
  public static final class CheckUserRsp
    extends MessageMicro<CheckUserRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "openid_uin" }, new Object[] { Long.valueOf(0L) }, CheckUserRsp.class);
    public final PBUInt64Field openid_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 90, 98, 106 }, new String[] { "appid", "app_type", "src_id", "raw_url", "is_need_appinfo", "check_app_sign_req", "check_user_req", "check_mini_app_req" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), null, null, null }, ReqBody.class);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBUInt64Field appid = PBField.initUInt64(0L);
    public oidb_0xd55.CheckAppSignReq check_app_sign_req = new oidb_0xd55.CheckAppSignReq();
    public oidb_0xd55.CheckMiniAppReq check_mini_app_req = new oidb_0xd55.CheckMiniAppReq();
    public oidb_0xd55.CheckUserReq check_user_req = new oidb_0xd55.CheckUserReq();
    public final PBUInt32Field is_need_appinfo = PBField.initUInt32(0);
    public final PBStringField raw_url = PBField.initString("");
    public final PBUInt32Field src_id = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 90, 98, 106 }, new String[] { "wording", "appinfo", "check_app_sign_rsp", "check_user_rsp", "check_mini_app_rsp" }, new Object[] { "", null, null, null, null }, RspBody.class);
    public qqconnect.Appinfo appinfo = new qqconnect.Appinfo();
    public oidb_0xd55.CheckAppSignRsp check_app_sign_rsp = new oidb_0xd55.CheckAppSignRsp();
    public oidb_0xd55.CheckMiniAppRsp check_mini_app_rsp = new oidb_0xd55.CheckMiniAppRsp();
    public oidb_0xd55.CheckUserRsp check_user_rsp = new oidb_0xd55.CheckUserRsp();
    public final PBStringField wording = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd55
 * JD-Core Version:    0.7.0.1
 */