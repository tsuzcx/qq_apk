package tencent.im.mobileqq.mobroute;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DomainIp
{
  public static final class MobRouteSSOList
    extends MessageMicro<MobRouteSSOList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_timeout", "vec_tcplist", "vec_httplist" }, new Object[] { Integer.valueOf(0), null, null }, MobRouteSSOList.class);
    public final PBUInt32Field uint32_timeout = PBField.initUInt32(0);
    public final PBRepeatMessageField<DomainIp.MobRouteSSOListInfo> vec_httplist = PBField.initRepeatMessage(DomainIp.MobRouteSSOListInfo.class);
    public final PBRepeatMessageField<DomainIp.MobRouteSSOListInfo> vec_tcplist = PBField.initRepeatMessage(DomainIp.MobRouteSSOListInfo.class);
  }
  
  public static final class MobRouteSSOListInfo
    extends MessageMicro<MobRouteSSOListInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "string_ip", "uint32_port" }, new Object[] { "", Integer.valueOf(0) }, MobRouteSSOListInfo.class);
    public final PBStringField string_ip = PBField.initString("");
    public final PBUInt32Field uint32_port = PBField.initUInt32(0);
  }
  
  public static final class MobRouteSSOListReq
    extends MessageMicro<MobRouteSSOListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50 }, new String[] { "uint32_uintype", "string_uin", "string_imsi", "uint32_nettype", "uint32_appid", "string_imei" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "" }, MobRouteSSOListReq.class);
    public final PBStringField string_imei = PBField.initString("");
    public final PBStringField string_imsi = PBField.initString("");
    public final PBStringField string_uin = PBField.initString("");
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_nettype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_uintype = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.mobileqq.mobroute.DomainIp
 * JD-Core Version:    0.7.0.1
 */