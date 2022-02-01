package pb.unite.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicAssociationWord
{
  public static final class AssociationItem
    extends MessageMicro<AssociationItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field group_mask = PBField.initUInt32(0);
    public final PBBytesField jmp_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField subWord = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBBytesField word = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48 }, new String[] { "word", "jmp_url", "pic_url", "subWord", "type", "group_mask" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0) }, AssociationItem.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field business = PBField.initUInt32(0);
    public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field key_word_src = PBField.initUInt32(0);
    public final PBUInt32Field need_flag = PBField.initUInt32(0);
    public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "key_word", "version", "business", "key_word_src", "need_flag" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "result_code", "error_msg", "association_items", "suggest_url_items", "completed_url_items" }, new Object[] { Integer.valueOf(0), "", null, null, null }, RspBody.class);
    public final PBRepeatMessageField<DynamicAssociationWord.AssociationItem> association_items = PBField.initRepeatMessage(DynamicAssociationWord.AssociationItem.class);
    public DynamicAssociationWord.SuggestUrlItem completed_url_items = new DynamicAssociationWord.SuggestUrlItem();
    public final PBStringField error_msg = PBField.initString("");
    public final PBUInt32Field result_code = PBField.initUInt32(0);
    public final PBRepeatMessageField<DynamicAssociationWord.SuggestUrlItem> suggest_url_items = PBField.initRepeatMessage(DynamicAssociationWord.SuggestUrlItem.class);
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
 * Qualified Name:     pb.unite.search.DynamicAssociationWord
 * JD-Core Version:    0.7.0.1
 */