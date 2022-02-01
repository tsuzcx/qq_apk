package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xc0b
{
  public static final class KanDianCMSActivityInfo
    extends MessageMicro<KanDianCMSActivityInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_picture_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_activity_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_activity_id", "bytes_wording", "bytes_picture_url" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, KanDianCMSActivityInfo.class);
    }
  }
  
  public static final class KanDianCoinRemind
    extends MessageMicro<KanDianCoinRemind>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_wording" }, new Object[] { localByteStringMicro }, KanDianCoinRemind.class);
    }
  }
  
  public static final class KanDianTaskRemind
    extends MessageMicro<KanDianTaskRemind>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_task_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "bytes_wording", "bytes_jump_url", "uint32_task_type" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, KanDianTaskRemind.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_uin" }, new Object[] { Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_coin_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0xc0b.KanDianCoinRemind msg_kandian_coin_remind = new oidb_0xc0b.KanDianCoinRemind();
    public oidb_0xc0b.KanDianTaskRemind msg_kandian_task_remind = new oidb_0xc0b.KanDianTaskRemind();
    public final PBRepeatMessageField<oidb_0xc0b.KanDianCMSActivityInfo> rpt_cms_wording = PBField.initRepeatMessage(oidb_0xc0b.KanDianCMSActivityInfo.class);
    public final PBUInt32Field uint32_can_get_coin_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_open_coin_entry = PBField.initUInt32(0);
    public final PBUInt64Field uint64_last_cms_activity_stamp = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_completed_task_stamp = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 40, 50, 56, 66, 74 }, new String[] { "uint32_is_open_coin_entry", "uint32_can_get_coin_count", "bytes_coin_icon_url", "uint64_last_completed_task_stamp", "rpt_cms_wording", "uint64_last_cms_activity_stamp", "msg_kandian_coin_remind", "msg_kandian_task_remind" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), null, Long.valueOf(0L), null, null }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc0b
 * JD-Core Version:    0.7.0.1
 */