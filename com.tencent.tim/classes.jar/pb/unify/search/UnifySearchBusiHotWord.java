package pb.unify.search;

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

public final class UnifySearchBusiHotWord
{
  public static final class ClueWordItem
    extends MessageMicro<ClueWordItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField word_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "word_id", "word" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, ClueWordItem.class);
    }
  }
  
  public static final class GroupID
    extends MessageMicro<GroupID>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_group_mask" }, new Object[] { Long.valueOf(0L) }, GroupID.class);
    public final PBRepeatField<Long> rpt_group_mask = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class GroupWord
    extends MessageMicro<GroupWord>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "group_id", "rpt_hot_word_items", "clue_word_item" }, new Object[] { null, null, null }, GroupWord.class);
    public UnifySearchBusiHotWord.ClueWordItem clue_word_item = new UnifySearchBusiHotWord.ClueWordItem();
    public UnifySearchBusiHotWord.GroupID group_id = new UnifySearchBusiHotWord.GroupID();
    public final PBRepeatMessageField<UnifySearchBusiHotWord.HotWordItem> rpt_hot_word_items = PBField.initRepeatMessage(UnifySearchBusiHotWord.HotWordItem.class);
  }
  
  public static final class HotWordItem
    extends MessageMicro<HotWordItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField word_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "word_id", "word" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, HotWordItem.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field business = PBField.initUInt32(0);
    public final PBRepeatMessageField<UnifySearchBusiHotWord.GroupID> rpt_group_id = PBField.initRepeatMessage(UnifySearchBusiHotWord.GroupID.class);
    public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "version", "business", "rpt_group_id" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "result_code", "error_msg", "rpt_item_groups", "expire_time" }, new Object[] { Integer.valueOf(0), "", null, Integer.valueOf(0) }, RspBody.class);
    public final PBStringField error_msg = PBField.initString("");
    public final PBUInt32Field expire_time = PBField.initUInt32(0);
    public final PBUInt32Field result_code = PBField.initUInt32(0);
    public final PBRepeatMessageField<UnifySearchBusiHotWord.GroupWord> rpt_item_groups = PBField.initRepeatMessage(UnifySearchBusiHotWord.GroupWord.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pb.unify.search.UnifySearchBusiHotWord
 * JD-Core Version:    0.7.0.1
 */