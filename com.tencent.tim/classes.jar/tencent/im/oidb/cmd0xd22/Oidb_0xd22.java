package tencent.im.oidb.cmd0xd22;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0xd22
{
  public static final class AppInfo
    extends MessageMicro<AppInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "appid", "organization_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, AppInfo.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field organization_id = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "app_info" }, new Object[] { null }, ReqBody.class);
    public Oidb_0xd22.AppInfo app_info = new Oidb_0xd22.AppInfo();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField create_group_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBInt32Field int32_uin_privilege = PBField.initInt32(0);
    public final PBBytesField join_group_token = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "create_group_url", "join_group_token", "group_code", "int32_uin_privilege" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0) }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd22.Oidb_0xd22
 * JD-Core Version:    0.7.0.1
 */