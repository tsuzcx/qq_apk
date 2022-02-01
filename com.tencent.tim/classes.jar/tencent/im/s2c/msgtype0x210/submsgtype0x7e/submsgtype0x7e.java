package tencent.im.s2c.msgtype0x210.submsgtype0x7e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0x7e
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_notice", "msg_online_push" }, new Object[] { "", null }, MsgBody.class);
    public submsgtype0x7e.WalletMsgPush msg_online_push = new submsgtype0x7e.WalletMsgPush();
    public final PBStringField str_notice = PBField.initString("");
  }
  
  public static final class WalletMsgPush
    extends MessageMicro<WalletMsgPush>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_extend = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_appinfo = PBField.initString("");
    public final PBStringField str_billno = PBField.initString("");
    public final PBStringField str_jumpurl = PBField.initString("");
    public final PBStringField str_serialno = PBField.initString("");
    public final PBUInt32Field uint32_action = PBField.initUInt32(0);
    public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 56, 66 }, new String[] { "uint32_action", "uint32_timestamp", "bytes_extend", "str_serialno", "str_billno", "str_appinfo", "uint32_amount", "str_jumpurl" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, "", "", "", Integer.valueOf(0), "" }, WalletMsgPush.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x7e.submsgtype0x7e
 * JD-Core Version:    0.7.0.1
 */