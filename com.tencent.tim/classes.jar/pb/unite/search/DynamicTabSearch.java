package pb.unite.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicTabSearch
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public DynamicSearch.ExtensionRequestInfo extension_request_info = new DynamicSearch.ExtensionRequestInfo();
    public final PBUInt32Field from_sub_hot_word_id = PBField.initUInt32(0);
    public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public DynamicSearch.RootSearcherRequest search_request = new DynamicSearch.RootSearcherRequest();
    public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 802, 808 }, new String[] { "key_word", "version", "search_request", "extension_request_info", "from_sub_hot_word_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, null, Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field dont_need_merge = PBField.initUInt32(0);
    public final PBStringField error_msg = PBField.initString("");
    public final PBBytesField extension = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<DynamicTabSearch.SubHotWord> hot_words = PBField.initRepeatMessage(DynamicTabSearch.SubHotWord.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBRepeatMessageField<DynamicSearch.ResultItemGroup> item_groups = PBField.initRepeatMessage(DynamicSearch.ResultItemGroup.class);
    public final PBUInt32Field result_code = PBField.initUInt32(0);
    public final PBBytesField search_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField sub_hot_top_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66, 72, 810 }, new String[] { "result_code", "error_msg", "item_groups", "is_end", "cookie", "search_ver", "hot_words", "sub_hot_top_wording", "dont_need_merge", "extension" }, new Object[] { Integer.valueOf(0), "", null, Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, null, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4 }, RspBody.class);
    }
  }
  
  public static final class SubHotWord
    extends MessageMicro<SubHotWord>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField search_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField show_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field word_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "word_id", "show_word", "search_word" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, SubHotWord.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pb.unite.search.DynamicTabSearch
 * JD-Core Version:    0.7.0.1
 */