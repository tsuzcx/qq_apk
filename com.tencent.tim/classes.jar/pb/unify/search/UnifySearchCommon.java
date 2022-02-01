package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UnifySearchCommon
{
  public static final class ExtensionRequestInfo
    extends MessageMicro<ExtensionRequestInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField action = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field adcode = PBField.initUInt32(0);
    public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field key_word_src = PBField.initUInt32(0);
    public final PBFloatField latitude = PBField.initFloat(0.0F);
    public final PBFloatField longitude = PBField.initFloat(0.0F);
    public final PBInt32Field radius = PBField.initInt32(0);
    public final PBBytesField region = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Long> rpt_pubacc_local_result = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21, 29, 32, 42, 50, 56, 64, 72 }, new String[] { "action", "latitude", "longitude", "radius", "city", "region", "key_word_src", "rpt_pubacc_local_result", "adcode" }, new Object[] { localByteStringMicro1, Float.valueOf(0.0F), Float.valueOf(0.0F), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, ExtensionRequestInfo.class);
    }
  }
  
  public static final class Meaning
    extends MessageMicro<Meaning>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field eflag = PBField.initUInt32(0);
    public final PBBytesField words = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "words", "eflag" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, Meaning.class);
    }
  }
  
  public static final class ResultItem
    extends MessageMicro<ResultItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dbg_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField extension = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBFloatField final_score = PBField.initFloat(0.0F);
    public final PBUInt64Field group_mask = PBField.initUInt64(0L);
    public final PBUInt32Field is_bottom = PBField.initUInt32(0);
    public final PBUInt32Field is_multi_pic = PBField.initUInt32(0);
    public final PBUInt32Field is_top = PBField.initUInt32(0);
    public final PBBytesField jmp_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField layout_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field layout_id = PBField.initUInt32(0);
    public final PBBytesField ml_formula = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField report_ext_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField result_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field result_item_type = PBField.initUInt64(0L);
    public final PBRepeatMessageField<UnifySearchCommon.Meaning> rpt_meaning = PBField.initRepeatMessage(UnifySearchCommon.Meaning.class);
    public final PBUInt32Field seporator_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<UnifySearchCommon.SubItem> sub_item_list = PBField.initRepeatMessage(UnifySearchCommon.SubItem.class);
    public final PBRepeatMessageField<ResultItem> sub_result_items = PBField.initRepeatMessage(ResultItem.class);
    public final PBBytesField word = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 74, 80, 90, 96, 104, 114, 125, 130, 170, 176, 184, 194, 800 }, new String[] { "result_id", "name", "pic_url", "jmp_url", "word", "extension", "rpt_meaning", "group_mask", "sub_item_list", "layout_id", "layout_content", "is_top", "is_bottom", "dbg_msg", "final_score", "ml_formula", "sub_result_items", "result_item_type", "seporator_type", "report_ext_data", "is_multi_pic" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, null, Long.valueOf(0L), null, Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro8, Float.valueOf(0.0F), localByteStringMicro9, null, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro10, Integer.valueOf(0) }, ResultItem.class);
    }
  }
  
  public static final class ResultItemGroup
    extends MessageMicro<ResultItemGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field group_extra_flag = PBField.initUInt32(0);
    public final PBBytesField group_footer_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField group_footer_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field group_mask = PBField.initUInt64(0L);
    public final PBBytesField group_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field hide_title = PBField.initUInt32(0);
    public final PBUInt32Field hide_title_blank_view = PBField.initUInt32(0);
    public final PBUInt32Field highlight_title_keyword = PBField.initUInt32(0);
    public final PBUInt32Field is_big_pic = PBField.initUInt32(0);
    public final PBBytesField more_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField more_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<UnifySearchCommon.ResultItem> result_items = PBField.initRepeatMessage(UnifySearchCommon.ResultItem.class);
    public final PBRepeatField<ByteStringMicro> rpt_highlight_words = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt64Field total_result_count = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 56, 64, 72, 82, 90, 96, 8002, 8080 }, new String[] { "group_mask", "group_name", "result_items", "total_result_count", "more_url", "more_name", "hide_title", "highlight_title_keyword", "hide_title_blank_view", "group_footer_name", "group_footer_jump_url", "group_extra_flag", "rpt_highlight_words", "is_big_pic" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, null, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), localByteStringMicro6, Integer.valueOf(0) }, ResultItemGroup.class);
    }
  }
  
  public static final class RootSearcherRequest
    extends MessageMicro<RootSearcherRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field business = PBField.initUInt32(0);
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField json_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField ocean_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field page_size = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> query_cate = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field query_rewrite = PBField.initUInt32(0);
    public final PBRepeatField<Long> rpt_busi_mask = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field use_all_mask = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 32, 80, 90, 402, 408, 418, 424, 442 }, new String[] { "business", "page_size", "rpt_busi_mask", "cookie", "ocean_data", "use_all_mask", "query_cate", "query_rewrite", "json_data" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4 }, RootSearcherRequest.class);
    }
  }
  
  public static final class SubItem
    extends MessageMicro<SubItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField backgroud_color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field layout_id = PBField.initUInt32(0);
    public final PBRepeatMessageField<UnifySearchCommon.SubItemMedia> media_list = PBField.initRepeatMessage(UnifySearchCommon.SubItemMedia.class);
    public final PBUInt32Field media_total_count = PBField.initUInt32(0);
    public final PBUInt32Field show_arrow = PBField.initUInt32(0);
    public final PBRepeatMessageField<UnifySearchCommon.SubItemText> summary = PBField.initRepeatMessage(UnifySearchCommon.SubItemText.class);
    public final PBRepeatMessageField<UnifySearchCommon.SubItemText> title = PBField.initRepeatMessage(UnifySearchCommon.SubItemText.class);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 56, 66 }, new String[] { "layout_id", "title", "summary", "media_total_count", "media_list", "jump_url", "show_arrow", "backgroud_color" }, new Object[] { Integer.valueOf(0), null, null, Integer.valueOf(0), null, localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, SubItem.class);
    }
  }
  
  public static final class SubItemMedia
    extends MessageMicro<SubItemMedia>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField coverUrl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField description = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "type", "coverUrl", "description" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, SubItemMedia.class);
    }
  }
  
  public static final class SubItemText
    extends MessageMicro<SubItemText>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField text = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "text", "color" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, SubItemText.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pb.unify.search.UnifySearchCommon
 * JD-Core Version:    0.7.0.1
 */