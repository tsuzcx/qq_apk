package tencent.im.oidb.cmd0x5d6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5d6
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_seq", "rpt_msg_update_buffer", "uint32_domain" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, ReqBody.class);
    public final PBRepeatMessageField<oidb_0x5d6.SnsUpateBuffer> rpt_msg_update_buffer = PBField.initRepeatMessage(oidb_0x5d6.SnsUpateBuffer.class);
    public final PBUInt32Field uint32_domain = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_Seq", "str_wording", "rpt_msg_update_result" }, new Object[] { Integer.valueOf(0), "", null }, RspBody.class);
    public final PBRepeatMessageField<oidb_0x5d6.SnsUpateResult> rpt_msg_update_result = PBField.initRepeatMessage(oidb_0x5d6.SnsUpateResult.class);
    public final PBStringField str_wording = PBField.initString("");
    public final PBUInt32Field uint32_Seq = PBField.initUInt32(0);
  }
  
  public static final class SnsUpateBuffer
    extends MessageMicro<SnsUpateBuffer>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 3202, 3208 }, new String[] { "uint64_uin", "rpt_msg_sns_update_item", "rpt_uin32_idlist" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0) }, SnsUpateBuffer.class);
    public final PBRepeatMessageField<oidb_0x5d6.SnsUpdateItem> rpt_msg_sns_update_item = PBField.initRepeatMessage(oidb_0x5d6.SnsUpdateItem.class);
    public final PBRepeatField<Integer> rpt_uin32_idlist = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class SnsUpateResult
    extends MessageMicro<SnsUpateResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "uint32_result" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, SnsUpateResult.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class SnsUpdateItem
    extends MessageMicro<SnsUpdateItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_update_sns_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_value_offset = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_update_sns_type", "bytes_value", "uint32_value_offset" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, SnsUpdateItem.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5d6.oidb_0x5d6
 * JD-Core Version:    0.7.0.1
 */