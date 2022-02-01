package tencent.im.oidb.cmd0xdcc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xdcc
{
  public static final class EntryDelay
    extends MessageMicro<EntryDelay>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "em_entry", "uint32_delay" }, new Object[] { Integer.valueOf(11), Integer.valueOf(0) }, EntryDelay.class);
    public final PBEnumField em_entry = PBField.initEnum(11);
    public final PBUInt32Field uint32_delay = PBField.initUInt32(0);
  }
  
  public static final class RecommendCard
    extends MessageMicro<RecommendCard>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_main_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sub_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_card_id = PBField.initEnum(101);
    public final PBRepeatMessageField<oidb_cmd0xdcc.RecommendPerson> rpt_msg_person = PBField.initRepeatMessage(oidb_cmd0xdcc.RecommendPerson.class);
    public final PBUInt32Field uint32_show_max = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42 }, new String[] { "enum_card_id", "bytes_main_title", "bytes_sub_title", "uint32_show_max", "rpt_msg_person" }, new Object[] { Integer.valueOf(101), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), null }, RecommendCard.class);
    }
  }
  
  public static final class RecommendPerson
    extends MessageMicro<RecommendPerson>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_alghrithm = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_keyword = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_recall = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint64_uin", "bytes_reason", "bytes_keyword", "bytes_alghrithm", "bytes_recall" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, RecommendPerson.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_group_id", "em_entry", "rpt_uint64_filter_uin" }, new Object[] { Long.valueOf(0L), Integer.valueOf(11), Long.valueOf(0L) }, ReqBody.class);
    public final PBEnumField em_entry = PBField.initEnum(11);
    public final PBRepeatField<Long> rpt_uint64_filter_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "rpt_msg_recommend_card", "rpt_msg_entry_delay", "uint64_group_id", "uint32_timestamp" }, new Object[] { null, null, Long.valueOf(0L), Integer.valueOf(0) }, RspBody.class);
    public final PBRepeatMessageField<oidb_cmd0xdcc.EntryDelay> rpt_msg_entry_delay = PBField.initRepeatMessage(oidb_cmd0xdcc.EntryDelay.class);
    public final PBRepeatMessageField<oidb_cmd0xdcc.RecommendCard> rpt_msg_recommend_card = PBField.initRepeatMessage(oidb_cmd0xdcc.RecommendCard.class);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdcc.oidb_cmd0xdcc
 * JD-Core Version:    0.7.0.1
 */