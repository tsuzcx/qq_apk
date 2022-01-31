package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x383$ApplyFileSearchRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_key_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField item_list = PBField.initRepeatMessage(cmd0x383.ApplyFileSearchRspBody.Item.class);
  public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_match_count = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40 }, new String[] { "bytes_sync_cookie", "uint32_is_end", "bytes_key_word", "item_list", "uint32_total_match_count" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, null, Integer.valueOf(0) }, ApplyFileSearchRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyFileSearchRspBody
 * JD-Core Version:    0.7.0.1
 */