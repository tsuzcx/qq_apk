package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xb61
{
  public static final class GetAppinfoReq
    extends MessageMicro<GetAppinfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "appid", "app_type", "platform" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetAppinfoReq.class);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field platform = PBField.initUInt32(0);
  }
  
  public static final class GetAppinfoRsp
    extends MessageMicro<GetAppinfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "appinfo" }, new Object[] { null }, GetAppinfoRsp.class);
    public qqconnect.Appinfo appinfo = new qqconnect.Appinfo();
  }
  
  public static final class GetPkgUrlReq
    extends MessageMicro<GetPkgUrlReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50 }, new String[] { "appid", "app_type", "app_version", "platform", "sys_version", "qq_version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "" }, GetPkgUrlReq.class);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBUInt32Field app_version = PBField.initUInt32(0);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField qq_version = PBField.initString("");
    public final PBStringField sys_version = PBField.initString("");
  }
  
  public static final class GetPkgUrlRsp
    extends MessageMicro<GetPkgUrlRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "app_version", "pkg_url" }, new Object[] { Integer.valueOf(0), "" }, GetPkgUrlRsp.class);
    public final PBUInt32Field app_version = PBField.initUInt32(0);
    public final PBStringField pkg_url = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 90 }, new String[] { "get_appinfo_req", "get_mqqapp_url_req" }, new Object[] { null, null }, ReqBody.class);
    public oidb_0xb61.GetAppinfoReq get_appinfo_req = new oidb_0xb61.GetAppinfoReq();
    public oidb_0xb61.GetPkgUrlReq get_mqqapp_url_req = new oidb_0xb61.GetPkgUrlReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 82, 90 }, new String[] { "wording", "next_req_duration", "get_appinfo_rsp", "get_mqqapp_url_rsp" }, new Object[] { "", Integer.valueOf(0), null, null }, RspBody.class);
    public oidb_0xb61.GetAppinfoRsp get_appinfo_rsp = new oidb_0xb61.GetAppinfoRsp();
    public oidb_0xb61.GetPkgUrlRsp get_mqqapp_url_rsp = new oidb_0xb61.GetPkgUrlRsp();
    public final PBUInt32Field next_req_duration = PBField.initUInt32(0);
    public final PBStringField wording = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb61
 * JD-Core Version:    0.7.0.1
 */