package pb.unite.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DynamicDiscovery
{
  public static final class GifInfoItem
    extends MessageMicro<GifInfoItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField gif_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField gif_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField gif_url_night = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "gif_url", "gif_url_night", "gif_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, GifInfoItem.class);
    }
  }
  
  public static final class HotSearchItem
    extends MessageMicro<HotSearchItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField detail_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField img_bg_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField img_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField mark_bg_color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField mark_text_color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField recall_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField right_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field show_type = PBField.initUInt32(0);
    public final PBBytesField text_color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field wz_ts = PBField.initUInt32(0);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 88, 98 }, new String[] { "show_type", "img_url", "title", "detail_text", "jump_url", "mark_text_color", "mark_bg_color", "img_bg_url", "text_color", "right_icon_url", "wz_ts", "recall_word" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, Integer.valueOf(0), localByteStringMicro10 }, HotSearchItem.class);
    }
  }
  
  public static final class OperationItem
    extends MessageMicro<OperationItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField detail_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField img_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField left_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField right_title = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "left_title", "right_title", "detail_text", "img_url", "jump_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, OperationItem.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field business = PBField.initUInt32(0);
    public final PBUInt32Field from_type = PBField.initUInt32(0);
    public final PBUInt32Field ignore_gender = PBField.initUInt32(0);
    public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "from_type", "version", "business", "ignore_gender" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class Result
    extends MessageMicro<Result>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 162, 170, 178, 184, 194, 202, 210 }, new String[] { "type", "has_header", "title_header", "hide_top_divider", "sub_business_items", "operation_items", "hot_search_items", "hotword_update_ts", "special_topic_item", "hot_wrod_gif_item", "hot_search_gif_item" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), null, null, null, Integer.valueOf(0), null, null, null }, Result.class);
    public final PBUInt32Field has_header = PBField.initUInt32(0);
    public final PBUInt32Field hide_top_divider = PBField.initUInt32(0);
    public DynamicDiscovery.GifInfoItem hot_search_gif_item = new DynamicDiscovery.GifInfoItem();
    public final PBRepeatMessageField<DynamicDiscovery.HotSearchItem> hot_search_items = PBField.initRepeatMessage(DynamicDiscovery.HotSearchItem.class);
    public DynamicDiscovery.GifInfoItem hot_wrod_gif_item = new DynamicDiscovery.GifInfoItem();
    public final PBUInt32Field hotword_update_ts = PBField.initUInt32(0);
    public final PBRepeatMessageField<DynamicDiscovery.OperationItem> operation_items = PBField.initRepeatMessage(DynamicDiscovery.OperationItem.class);
    public DynamicDiscovery.SpecialTopic special_topic_item = new DynamicDiscovery.SpecialTopic();
    public final PBRepeatMessageField<DynamicDiscovery.SubBusinessItem> sub_business_items = PBField.initRepeatMessage(DynamicDiscovery.SubBusinessItem.class);
    public DynamicDiscovery.TitleHeaderItem title_header = new DynamicDiscovery.TitleHeaderItem();
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bucket_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field expire_time = PBField.initUInt32(0);
    public final PBUInt32Field result_code = PBField.initUInt32(0);
    public final PBRepeatMessageField<DynamicDiscovery.Result> result_items = PBField.initRepeatMessage(DynamicDiscovery.Result.class);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42 }, new String[] { "result_items", "result_code", "error_msg", "expire_time", "bucket_id" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, RspBody.class);
    }
  }
  
  public static final class SpecialTopic
    extends MessageMicro<SpecialTopic>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_hotsearch = PBField.initUInt32(0);
    public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField left_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField more_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field show_type = PBField.initUInt32(0);
    public final PBBytesField title_color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<DynamicDiscovery.TopicImage> topic_images = PBField.initRepeatMessage(DynamicDiscovery.TopicImage.class);
    public final PBRepeatMessageField<DynamicDiscovery.TopicItem> topic_items = PBField.initRepeatMessage(DynamicDiscovery.TopicItem.class);
    public final PBBytesField topic_title = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58, 66, 74, 80 }, new String[] { "topic_title", "title_color", "icon_url", "topic_items", "jump_url", "show_type", "left_icon_url", "more_text", "topic_images", "is_hotsearch" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, null, Integer.valueOf(0) }, SpecialTopic.class);
    }
  }
  
  public static final class SubBusinessItem
    extends MessageMicro<SubBusinessItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field bzid = PBField.initUInt32(0);
    public final PBRepeatField<Long> group_masks = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field has_red_dot = PBField.initUInt32(0);
    public final PBBytesField icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_hot_words_list = PBField.initUInt32(0);
    public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field red_seq = PBField.initUInt32(0);
    public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 56, 64 }, new String[] { "title", "icon_url", "group_masks", "is_hot_words_list", "jump_url", "has_red_dot", "red_seq", "bzid" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SubBusinessItem.class);
    }
  }
  
  public static final class TitleHeaderItem
    extends MessageMicro<TitleHeaderItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field header_type = PBField.initUInt32(0);
    public final PBBytesField icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField morn_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField morn_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField qq_index_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50 }, new String[] { "title", "icon_url", "morn_text", "morn_url", "header_type", "qq_index_jump_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5 }, TitleHeaderItem.class);
    }
  }
  
  public static final class TopicImage
    extends MessageMicro<TopicImage>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField image_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField image_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_hotsearch = PBField.initUInt32(0);
    public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "image_url", "image_text", "jump_url", "is_hotsearch" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, TopicImage.class);
    }
  }
  
  public static final class TopicItem
    extends MessageMicro<TopicItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField config_color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField config_time = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_hotsearch = PBField.initUInt32(0);
    public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField title_color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField trait_title = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48 }, new String[] { "trait_title", "title_color", "config_time", "config_color", "jump_url", "is_hotsearch" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0) }, TopicItem.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pb.unite.search.DynamicDiscovery
 * JD-Core Version:    0.7.0.1
 */