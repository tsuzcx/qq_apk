package tencent.im.mobileqq.configpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DomainIp
{
  public static final class NameReqBody
    extends MessageMicro<NameReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "SubCmd_name_Req" }, new Object[] { null }, NameReqBody.class);
    public DomainIp.SubCmd_name_Req SubCmd_name_Req = new DomainIp.SubCmd_name_Req();
  }
  
  public static final class NameRspBody
    extends MessageMicro<NameRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "SubCmd_name_Rsp" }, new Object[] { null }, NameRspBody.class);
    public DomainIp.SubCmd_name_Rsp SubCmd_name_Rsp = new DomainIp.SubCmd_name_Rsp();
  }
  
  public static final class ServerList
    extends MessageMicro<ServerList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "string_IP", "uint32_Port" }, new Object[] { "", Integer.valueOf(0) }, ServerList.class);
    public final PBStringField string_IP = PBField.initString("");
    public final PBUInt32Field uint32_Port = PBField.initUInt32(0);
  }
  
  public static final class SubCmd_name_Req
    extends MessageMicro<SubCmd_name_Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_uip", "uint32_qq", "dnameInfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, SubCmd_name_Req.class);
    public final PBRepeatMessageField<DomainIp.dnameInfo> dnameInfo = PBField.initRepeatMessage(DomainIp.dnameInfo.class);
    public final PBUInt32Field uint32_qq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_uip = PBField.initUInt32(0);
  }
  
  public static final class SubCmd_name_Rsp
    extends MessageMicro<SubCmd_name_Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_uip", "uint32_qq", "iplistInfo", "iplistInfoV6" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null }, SubCmd_name_Rsp.class);
    public final PBRepeatMessageField<DomainIp.iplistInfo> iplistInfo = PBField.initRepeatMessage(DomainIp.iplistInfo.class);
    public final PBRepeatMessageField<DomainIp.iplistInfo> iplistInfoV6 = PBField.initRepeatMessage(DomainIp.iplistInfo.class);
    public final PBUInt32Field uint32_qq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_uip = PBField.initUInt32(0);
  }
  
  public static final class dnameInfo
    extends MessageMicro<dnameInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 24 }, new String[] { "string_dname", "uint32_type" }, new Object[] { "", Integer.valueOf(0) }, dnameInfo.class);
    public final PBStringField string_dname = PBField.initString("");
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
  
  public static final class iplistInfo
    extends MessageMicro<iplistInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "int32_result", "string_dname", "uint32_type", "uint32_ttl", "ServerList_data" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), null }, iplistInfo.class);
    public final PBRepeatMessageField<DomainIp.ServerList> ServerList_data = PBField.initRepeatMessage(DomainIp.ServerList.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBStringField string_dname = PBField.initString("");
    public final PBUInt32Field uint32_ttl = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.mobileqq.configpush.DomainIp
 * JD-Core Version:    0.7.0.1
 */