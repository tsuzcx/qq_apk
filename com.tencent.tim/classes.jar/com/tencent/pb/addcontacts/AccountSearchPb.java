package com.tencent.pb.addcontacts;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;

public final class AccountSearchPb
{
  public static final class Color
    extends MessageMicro<Color>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_r", "uint32_g", "uint32_b" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Color.class);
    public final PBUInt32Field uint32_b = PBField.initUInt32(0);
    public final PBUInt32Field uint32_g = PBField.initUInt32(0);
    public final PBUInt32Field uint32_r = PBField.initUInt32(0);
  }
  
  public static final class Label
    extends MessageMicro<Label>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public AccountSearchPb.Color edging_color = new AccountSearchPb.Color();
    public AccountSearchPb.Color text_color = new AccountSearchPb.Color();
    public final PBUInt32Field uint32_label_attr = PBField.initUInt32(0);
    public final PBUInt32Field uint32_label_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 26, 34, 40, 48 }, new String[] { "bytes_name", "text_color", "edging_color", "uint32_label_attr", "uint32_label_type" }, new Object[] { localByteStringMicro, null, null, Integer.valueOf(0), Integer.valueOf(0) }, Label.class);
    }
  }
  
  public static final class Location
    extends MessageMicro<Location>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 9, 17 }, new String[] { "double_latitude", "double_longitude" }, new Object[] { Double.valueOf(0.0D), Double.valueOf(0.0D) }, Location.class);
    public final PBDoubleField double_latitude = PBField.initDouble(0.0D);
    public final PBDoubleField double_longitude = PBField.initDouble(0.0D);
  }
  
  public static final class ResultItem
    extends MessageMicro<ResultItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField feed_type = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field ftime = PBField.initUInt32(0);
    public final PBBytesField has_video = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField jmp_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField phtot_update = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> pic_url_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField result_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field total_pic_num = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    
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
      ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 72, 82, 88, 98, 106, 112 }, new String[] { "feed_id", "name", "pic_url", "jmp_url", "feed_type", "summary", "has_video", "phtot_update", "uin", "result_id", "ftime", "nick_name", "pic_url_list", "total_pic_num" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, Long.valueOf(0L), localByteStringMicro9, Integer.valueOf(0), localByteStringMicro10, localByteStringMicro11, Integer.valueOf(0) }, ResultItem.class);
    }
  }
  
  public static final class hotwordrecord
    extends MessageMicro<hotwordrecord>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "hotword", "hotword_type", "hotword_cover_url", "hotword_title", "hotword_description" }, new Object[] { "", Integer.valueOf(0), "", "", "" }, hotwordrecord.class);
    public final PBStringField hotword = PBField.initString("");
    public final PBStringField hotword_cover_url = PBField.initString("");
    public final PBStringField hotword_description = PBField.initString("");
    public final PBStringField hotword_title = PBField.initString("");
    public final PBUInt32Field hotword_type = PBField.initUInt32(0);
  }
  
  public static final class record
    extends MessageMicro<record>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field account_flag = PBField.initUInt32(0);
    public final PBUInt64Field account_id = PBField.initUInt64(0L);
    public final PBStringField accout = PBField.initString("");
    public final PBUInt32Field age = PBField.initUInt32(0);
    public final PBStringField article_author = PBField.initString("");
    public final PBStringField article_create_time = PBField.initString("");
    public final PBStringField article_short_url = PBField.initString("");
    public final PBStringField brief = PBField.initString("");
    public final PBBytesField bytes_join_group_auth = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_token = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field city = PBField.initUInt32(0);
    public final PBStringField city_name = PBField.initString("");
    public final PBUInt32Field class_index = PBField.initUInt32(0);
    public final PBStringField class_name = PBField.initString("");
    public final PBUInt64Field code = PBField.initUInt64(0L);
    public final PBUInt32Field country = PBField.initUInt32(0);
    public final PBStringField country_name = PBField.initString("");
    public final PBUInt64Field flag = PBField.initUInt64(0L);
    public final PBStringField mobile = PBField.initString("");
    public final PBRepeatMessageField<AccountSearchPb.Label> msg_group_labels = PBField.initRepeatMessage(AccountSearchPb.Label.class);
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field number = PBField.initUInt32(0);
    public final PBUInt32Field province = PBField.initUInt32(0);
    public final PBStringField province_name = PBField.initString("");
    public final PBUInt64Field relation = PBField.initUInt64(0L);
    public RichStatus richStatus;
    public final PBUInt32Field sex = PBField.initUInt32(0);
    public final PBBytesField sign = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField source = PBField.initEnum(1);
    public final PBStringField title_image = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBInt32Field uin_privilege = PBField.initInt32(0);
    public final PBUInt32Field video_account = PBField.initUInt32(0);
    public final PBUInt32Field video_article = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58, 66, 72, 80, 88, 98, 106, 112, 120, 128, 136, 146, 154, 162, 170, 176, 186, 194, 202, 210, 216, 242, 248, 256, 264, 274, 4002 }, new String[] { "uin", "code", "source", "name", "sex", "age", "accout", "brief", "number", "flag", "relation", "mobile", "sign", "country", "province", "city", "class_index", "class_name", "country_name", "province_name", "city_name", "account_flag", "title_image", "article_short_url", "article_create_time", "article_author", "account_id", "msg_group_labels", "video_account", "video_article", "uin_privilege", "bytes_join_group_auth", "bytes_token" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), "", "", "", "", Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3 }, record.class);
    }
  }
  
  public static final class search
    extends MessageMicro<search>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 82, 88, 96, 106, 114, 122, 130, 136, 144 }, new String[] { "start", "count", "end", "keyword", "list", "highlight", "msg_user_location", "bool_location_group", "filtertype", "recommend_list", "hotword_record", "article_more_url", "result_items", "bool_keyword_suicide", "bool_exact_search" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", null, "", null, Boolean.valueOf(false), Integer.valueOf(0), null, null, "", null, Boolean.valueOf(false), Boolean.valueOf(false) }, search.class);
    public final PBStringField article_more_url = PBField.initString("");
    public final PBBoolField bool_exact_search = PBField.initBool(false);
    public final PBBoolField bool_keyword_suicide = PBField.initBool(false);
    public final PBBoolField bool_location_group = PBField.initBool(false);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field end = PBField.initUInt32(0);
    public final PBInt32Field filtertype = PBField.initInt32(0);
    public final PBRepeatField<String> highlight = PBField.initRepeat(PBStringField.__repeatHelper__);
    public AccountSearchPb.hotwordrecord hotword_record = new AccountSearchPb.hotwordrecord();
    public final PBStringField keyword = PBField.initString("");
    public final PBRepeatMessageField<AccountSearchPb.record> list = PBField.initRepeatMessage(AccountSearchPb.record.class);
    public AccountSearchPb.Location msg_user_location = new AccountSearchPb.Location();
    public final PBRepeatMessageField<AccountSearchPb.record> recommend_list = PBField.initRepeatMessage(AccountSearchPb.record.class);
    public final PBRepeatMessageField<AccountSearchPb.ResultItem> result_items = PBField.initRepeatMessage(AccountSearchPb.ResultItem.class);
    public final PBInt32Field start = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.addcontacts.AccountSearchPb
 * JD-Core Version:    0.7.0.1
 */