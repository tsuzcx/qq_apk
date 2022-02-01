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

public final class UnifyTabSearch
{
  public static final class ProcessData
    extends MessageMicro<ProcessData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field group_mask = PBField.initUInt32(0);
    public final PBBytesField key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField value = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "group_mask", "key", "value" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, ProcessData.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public UnifySearchCommon.ExtensionRequestInfo extension_request_info = new UnifySearchCommon.ExtensionRequestInfo();
    public final PBUInt32Field from_sub_hot_word_id = PBField.initUInt32(0);
    public final PBUInt32Field from_tabbar_index = PBField.initUInt32(0);
    public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public UnifySearchCommon.RootSearcherRequest search_request = new UnifySearchCommon.RootSearcherRequest();
    public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 802, 808, 816 }, new String[] { "key_word", "version", "search_request", "extension_request_info", "from_sub_hot_word_id", "from_tabbar_index" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, null, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
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
    public final PBRepeatMessageField<UnifyTabSearch.SubHotWord> hot_words = PBField.initRepeatMessage(UnifyTabSearch.SubHotWord.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBRepeatMessageField<UnifySearchCommon.ResultItemGroup> item_groups = PBField.initRepeatMessage(UnifySearchCommon.ResultItemGroup.class);
    public final PBUInt32Field key_word_prop = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> origin_rpt_highlight_words = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatMessageField<UnifyTabSearch.ProcessData> process_datas = PBField.initRepeatMessage(UnifyTabSearch.ProcessData.class);
    public final PBUInt32Field result_code = PBField.initUInt32(0);
    public final PBBytesField search_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField sub_hot_top_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66, 72, 810, 818, 1608, 8002 }, new String[] { "result_code", "error_msg", "item_groups", "is_end", "cookie", "search_ver", "hot_words", "sub_hot_top_wording", "dont_need_merge", "extension", "process_datas", "key_word_prop", "origin_rpt_highlight_words" }, new Object[] { Integer.valueOf(0), "", null, Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, null, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, null, Integer.valueOf(0), localByteStringMicro5 }, RspBody.class);
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
 * Qualified Name:     pb.unify.search.UnifyTabSearch
 * JD-Core Version:    0.7.0.1
 */