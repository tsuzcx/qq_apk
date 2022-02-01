package tencent.im.oidb.cmd0x5d0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x5d0
{
  public static final class ContentItem
    extends MessageMicro<ContentItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_field", "msg_general_buffer" }, new Object[] { Integer.valueOf(0), null }, ContentItem.class);
    public Oidb_0x5d0.GeneralBuffer msg_general_buffer = new Oidb_0x5d0.GeneralBuffer();
    public final PBUInt32Field uint32_field = PBField.initUInt32(0);
  }
  
  public static final class GeneralBuffer
    extends MessageMicro<GeneralBuffer>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_value" }, new Object[] { localByteStringMicro }, GeneralBuffer.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_start_time", "rpt_uint32_fieldlist", "rpt_uint64_uinlist", "uint64_bind_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
    public final PBRepeatField<Integer> rpt_uint32_fieldlist = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Long> rpt_uint64_uinlist = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_start_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_bind_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "rpt_msg_contentItem", "uint32_sys_time", "uint64_uin", "uint32_advise_gap" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, RspBody.class);
    public final PBRepeatMessageField<Oidb_0x5d0.ContentItem> rpt_msg_contentItem = PBField.initRepeatMessage(Oidb_0x5d0.ContentItem.class);
    public final PBUInt32Field uint32_advise_gap = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sys_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class SnsPbBuffer
    extends MessageMicro<SnsPbBuffer>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_sns_update_item" }, new Object[] { null }, SnsPbBuffer.class);
    public final PBRepeatMessageField<Oidb_0x5d0.SnsUpdateItem> rpt_msg_sns_update_item = PBField.initRepeatMessage(Oidb_0x5d0.SnsUpdateItem.class);
  }
  
  public static final class SnsUpateBuffer
    extends MessageMicro<SnsUpateBuffer>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 3202, 3208 }, new String[] { "uint64_uin", "rpt_msg_sns_update_item", "rpt_uin32_idlist" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0) }, SnsUpateBuffer.class);
    public final PBRepeatMessageField<Oidb_0x5d0.SnsUpdateItem> rpt_msg_sns_update_item = PBField.initRepeatMessage(Oidb_0x5d0.SnsUpdateItem.class);
    public final PBRepeatField<Integer> rpt_uin32_idlist = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class SnsUpdateItem
    extends MessageMicro<SnsUpdateItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_update_sns_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_update_sns_type", "bytes_value" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, SnsUpdateItem.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5d0.Oidb_0x5d0
 * JD-Core Version:    0.7.0.1
 */