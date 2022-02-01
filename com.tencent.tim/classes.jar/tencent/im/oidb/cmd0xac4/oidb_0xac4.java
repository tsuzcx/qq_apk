package tencent.im.oidb.cmd0xac4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xac4
{
  public static final class MailInfo
    extends MessageMicro<MailInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_mail = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_type = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_mail", "uint64_type" }, new Object[] { localByteStringMicro, Long.valueOf(0L) }, MailInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_mail = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "bytes_mail" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_has_binding", "rpt_msg_mail_info", "rpt_msg_uin_info" }, new Object[] { Long.valueOf(0L), null, null }, RspBody.class);
    public final PBRepeatMessageField<oidb_0xac4.MailInfo> rpt_msg_mail_info = PBField.initRepeatMessage(oidb_0xac4.MailInfo.class);
    public final PBRepeatMessageField<oidb_0xac4.UinInfo> rpt_msg_uin_info = PBField.initRepeatMessage(oidb_0xac4.UinInfo.class);
    public final PBUInt64Field uint64_has_binding = PBField.initUInt64(0L);
  }
  
  public static final class UinInfo
    extends MessageMicro<UinInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_uin" }, new Object[] { Long.valueOf(0L) }, UinInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xac4.oidb_0xac4
 * JD-Core Version:    0.7.0.1
 */