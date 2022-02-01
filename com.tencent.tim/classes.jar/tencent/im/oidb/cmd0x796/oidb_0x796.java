package tencent.im.oidb.cmd0x796;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x796
{
  public static final class ItemInfo
    extends MessageMicro<ItemInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "uint64_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ItemInfo.class);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feedsid = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x796.ItemInfo stLastInfo = new oidb_0x796.ItemInfo();
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 48 }, new String[] { "feedsid", "uint64_time", "uint64_uin", "uint32_type", "stLastInfo", "uint32_seq" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField errMsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x796.ItemInfo> rpt_items = PBField.initRepeatMessage(oidb_0x796.ItemInfo.class);
    public oidb_0x796.ItemInfo stPagePointItem = new oidb_0x796.ItemInfo();
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_update = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rsp_seq = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56 }, new String[] { "uint32_result", "errMsg", "rpt_items", "stPagePointItem", "uint32_flag", "uint32_rsp_seq", "uint32_need_update" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x796.oidb_0x796
 * JD-Core Version:    0.7.0.1
 */