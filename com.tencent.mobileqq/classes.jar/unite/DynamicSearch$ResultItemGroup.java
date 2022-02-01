package unite;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DynamicSearch$ResultItemGroup
  extends MessageMicro<ResultItemGroup>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField group_footer_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField group_footer_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field group_mask = PBField.initUInt64(0L);
  public final PBBytesField group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field hide_title = PBField.initUInt32(0);
  public final PBUInt32Field hide_title_blank_view = PBField.initUInt32(0);
  public final PBUInt32Field highlight_title_keyword = PBField.initUInt32(0);
  public final PBBytesField more_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField more_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<DynamicSearch.ResultItem> result_items = PBField.initRepeatMessage(DynamicSearch.ResultItem.class);
  public final PBRepeatField<ByteStringMicro> rpt_highlight_words = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt64Field total_result_count = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 56, 64, 72, 82, 90, 8002 }, new String[] { "group_mask", "group_name", "result_items", "total_result_count", "more_url", "more_name", "hide_title", "highlight_title_keyword", "hide_title_blank_view", "group_footer_name", "group_footer_jump_url", "rpt_highlight_words" }, new Object[] { localLong, localByteStringMicro1, null, localLong, localByteStringMicro2, localByteStringMicro3, localInteger, localInteger, localInteger, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6 }, ResultItemGroup.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     unite.DynamicSearch.ResultItemGroup
 * JD-Core Version:    0.7.0.1
 */