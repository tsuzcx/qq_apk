package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xc05
{
  public static final class GetAuthAppListReq
    extends MessageMicro<GetAuthAppListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "start", "limit" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetAuthAppListReq.class);
    public final PBUInt32Field limit = PBField.initUInt32(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
  }
  
  public static final class GetAuthAppListRsp
    extends MessageMicro<GetAuthAppListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "total_count", "appinfos", "cur_index" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, GetAuthAppListRsp.class);
    public final PBRepeatMessageField<qqconnect.Appinfo> appinfos = PBField.initRepeatMessage(qqconnect.Appinfo.class);
    public final PBUInt32Field cur_index = PBField.initUInt32(0);
    public final PBUInt32Field total_count = PBField.initUInt32(0);
  }
  
  public static final class GetCreateAppListReq
    extends MessageMicro<GetCreateAppListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "start", "limit" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetCreateAppListReq.class);
    public final PBUInt32Field limit = PBField.initUInt32(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
  }
  
  public static final class GetCreateAppListRsp
    extends MessageMicro<GetCreateAppListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "total_count", "appinfos" }, new Object[] { Integer.valueOf(0), null }, GetCreateAppListRsp.class);
    public final PBRepeatMessageField<qqconnect.Appinfo> appinfos = PBField.initRepeatMessage(qqconnect.Appinfo.class);
    public final PBUInt32Field total_count = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 90 }, new String[] { "get_create_app_list_req", "get_auth_app_list_req" }, new Object[] { null, null }, ReqBody.class);
    public oidb_0xc05.GetAuthAppListReq get_auth_app_list_req = new oidb_0xc05.GetAuthAppListReq();
    public oidb_0xc05.GetCreateAppListReq get_create_app_list_req = new oidb_0xc05.GetCreateAppListReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82, 90 }, new String[] { "wording", "get_create_app_list_rsp", "get_auth_app_list_rsp" }, new Object[] { "", null, null }, RspBody.class);
    public oidb_0xc05.GetAuthAppListRsp get_auth_app_list_rsp = new oidb_0xc05.GetAuthAppListRsp();
    public oidb_0xc05.GetCreateAppListRsp get_create_app_list_rsp = new oidb_0xc05.GetCreateAppListRsp();
    public final PBStringField wording = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc05
 * JD-Core Version:    0.7.0.1
 */