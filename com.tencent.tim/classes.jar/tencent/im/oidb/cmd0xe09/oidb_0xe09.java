package tencent.im.oidb.cmd0xe09;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe09
{
  public static final class OnlineInfo
    extends MessageMicro<OnlineInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_friend_uin", "uint32_status", "uint32_ext_online_status", "uint64_act_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, OnlineInfo.class);
    public final PBUInt32Field uint32_ext_online_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_act_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_friend_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_item" }, new Object[] { null }, ReqBody.class);
    public final PBRepeatMessageField<oidb_0xe09.reqItem> rpt_item = PBField.initRepeatMessage(oidb_0xe09.reqItem.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18 }, new String[] { "rpt_online_info" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<oidb_0xe09.OnlineInfo> rpt_online_info = PBField.initRepeatMessage(oidb_0xe09.OnlineInfo.class);
  }
  
  public static final class reqItem
    extends MessageMicro<reqItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "bytes_sig" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, reqItem.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe09.oidb_0xe09
 * JD-Core Version:    0.7.0.1
 */