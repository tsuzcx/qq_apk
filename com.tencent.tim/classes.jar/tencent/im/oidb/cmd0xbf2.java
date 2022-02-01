package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xbf2
{
  public static final class PhoneAddrBook
    extends MessageMicro<PhoneAddrBook>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "str_phone", "str_nick", "str_head_url", "str_long_nick" }, new Object[] { "", "", "", "" }, PhoneAddrBook.class);
    public final PBStringField str_head_url = PBField.initString("");
    public final PBStringField str_long_nick = PBField.initString("");
    public final PBStringField str_nick = PBField.initString("");
    public final PBStringField str_phone = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_uin", "uint64_start_index", "uint64_num" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt64Field uint64_num = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_start_index = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "phoneAddrBook", "uint32_end", "uint32_next_index" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L) }, RspBody.class);
    public final PBRepeatMessageField<cmd0xbf2.PhoneAddrBook> phoneAddrBook = PBField.initRepeatMessage(cmd0xbf2.PhoneAddrBook.class);
    public final PBUInt32Field uint32_end = PBField.initUInt32(0);
    public final PBUInt64Field uint32_next_index = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbf2
 * JD-Core Version:    0.7.0.1
 */