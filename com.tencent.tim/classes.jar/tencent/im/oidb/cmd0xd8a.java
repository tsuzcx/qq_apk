package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xd8a
{
  public static final class ClientInfo
    extends MessageMicro<ClientInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_implat", "string_clientver" }, new Object[] { Integer.valueOf(0), "" }, ClientInfo.class);
    public final PBStringField string_clientver = PBField.initString("");
    public final PBUInt32Field uint32_implat = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint64_uin", "uint32_cmd", "str_body", "client_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", null }, ReqBody.class);
    public cmd0xd8a.ClientInfo client_info = new cmd0xd8a.ClientInfo();
    public final PBStringField str_body = PBField.initString("");
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_retcode", "str_res" }, new Object[] { Integer.valueOf(0), "" }, RspBody.class);
    public final PBStringField str_res = PBField.initString("");
    public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd8a
 * JD-Core Version:    0.7.0.1
 */