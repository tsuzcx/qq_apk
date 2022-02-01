package tencent.im.oidb.cmd0xd83;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xd83
{
  public static final class BlockedInfo
    extends MessageMicro<BlockedInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_source = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comm_frd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_has_read = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sex = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 56, 64 }, new String[] { "uint64_uin", "bytes_nick", "uint32_age", "uint32_sex", "bytes_source", "uint32_time", "uint32_has_read", "uint32_comm_frd" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, BlockedInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_uin", "uint32_req_num", "bytes_cookies" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_cmd0xd83.BlockedInfo> rpt_block_list = PBField.initRepeatMessage(oidb_cmd0xd83.BlockedInfo.class);
    public final PBUInt32Field uint32_entrance = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_entrance", "rpt_block_list", "bytes_cookies" }, new Object[] { Integer.valueOf(0), null, localByteStringMicro }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd83.oidb_cmd0xd83
 * JD-Core Version:    0.7.0.1
 */