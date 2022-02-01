package tencent.im.oidb.cmd0xb31;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xb31
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_to", "uint64_from" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt64Field uint64_from = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 792, 800 }, new String[] { "items", "fromuin", "touin" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L) }, RspBody.class);
    public final PBUInt64Field fromuin = PBField.initUInt64(0L);
    public final PBRepeatMessageField<oidb_0xb31.SimilarItem> items = PBField.initRepeatMessage(oidb_0xb31.SimilarItem.class);
    public final PBUInt64Field touin = PBField.initUInt64(0L);
  }
  
  public static final class SimilarItem
    extends MessageMicro<SimilarItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 64 }, new String[] { "type", "title", "name", "url", "jump_url", "sub_title", "icon_url", "show_both_head" }, new Object[] { Integer.valueOf(1), "", "", "", "", "", "", Integer.valueOf(0) }, SimilarItem.class);
    public final PBStringField icon_url = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field show_both_head = PBField.initUInt32(0);
    public final PBStringField sub_title = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(1);
    public final PBStringField url = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb31.oidb_0xb31
 * JD-Core Version:    0.7.0.1
 */