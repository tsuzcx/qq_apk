package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UnifySearchAssociationWord
{
  public static final class AssociationItem
    extends MessageMicro<AssociationItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field gbar_id = PBField.initUInt32(0);
    public final PBUInt32Field group_mask = PBField.initUInt32(0);
    public final PBBytesField jmp_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField sub_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBBytesField word = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56 }, new String[] { "word", "jmp_url", "pic_url", "sub_word", "type", "group_mask", "gbar_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, AssociationItem.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field business = PBField.initUInt32(0);
    public final PBUInt32Field from_tabbar_index = PBField.initUInt32(0);
    public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field key_word_src = PBField.initUInt32(0);
    public final PBUInt32Field need_flag = PBField.initUInt32(0);
    public final PBUInt32Field req_src = PBField.initUInt32(0);
    public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 56, 64 }, new String[] { "key_word", "version", "business", "key_word_src", "need_flag", "from_tabbar_index", "req_src" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "result_code", "error_msg", "association_items", "suggest_url_items", "completed_url_item" }, new Object[] { Integer.valueOf(0), "", null, null, null }, RspBody.class);
    public final PBRepeatMessageField<UnifySearchAssociationWord.AssociationItem> association_items = PBField.initRepeatMessage(UnifySearchAssociationWord.AssociationItem.class);
    public UnifySearchAssociationWord.SuggestUrlItem completed_url_item = new UnifySearchAssociationWord.SuggestUrlItem();
    public final PBStringField error_msg = PBField.initString("");
    public final PBUInt32Field result_code = PBField.initUInt32(0);
    public final PBRepeatMessageField<UnifySearchAssociationWord.SuggestUrlItem> suggest_url_items = PBField.initRepeatMessage(UnifySearchAssociationWord.SuggestUrlItem.class);
  }
  
  public static final class SuggestUrlItem
    extends MessageMicro<SuggestUrlItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "url", "title" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, SuggestUrlItem.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pb.unify.search.UnifySearchAssociationWord
 * JD-Core Version:    0.7.0.1
 */