package tencent.im.oidb.cmd0xda2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class content_vidurl_svr
{
  public static final class GetVid2UrlsReq
    extends MessageMicro<GetVid2UrlsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 58, 66, 72, 82, 90, 98 }, new String[] { "uid", "appid", "client_ip", "net_type", "app_name", "app_version", "imei", "idfa", "system", "vids", "timestamp", "sign" }, new Object[] { "", "", "", Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), "", "", "" }, GetVid2UrlsReq.class);
    public final PBStringField app_name = PBField.initString("");
    public final PBStringField app_version = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField client_ip = PBField.initString("");
    public final PBStringField idfa = PBField.initString("");
    public final PBStringField imei = PBField.initString("");
    public final PBUInt32Field net_type = PBField.initUInt32(0);
    public final PBStringField sign = PBField.initString("");
    public final PBUInt32Field system = PBField.initUInt32(0);
    public final PBStringField timestamp = PBField.initString("");
    public final PBStringField uid = PBField.initString("");
    public final PBRepeatField<String> vids = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class GetVid2UrlsRsp
    extends MessageMicro<GetVid2UrlsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ret_code", "ret_msg", "urls" }, new Object[] { Integer.valueOf(0), "", null }, GetVid2UrlsRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBRepeatMessageField<content_vidurl_svr.UrlInfo> urls = PBField.initRepeatMessage(content_vidurl_svr.UrlInfo.class);
  }
  
  public static final class UrlInfo
    extends MessageMicro<UrlInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "vid", "status", "url" }, new Object[] { "", Integer.valueOf(0), "" }, UrlInfo.class);
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBStringField vid = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xda2.content_vidurl_svr
 * JD-Core Version:    0.7.0.1
 */