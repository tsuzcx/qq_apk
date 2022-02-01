package com.tencent.mobileqq.dynamic_search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_dynamic_search
{
  public static final class ExtensionRequestInfo
    extends MessageMicro<ExtensionRequestInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField action = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBFloatField latitude = PBField.initFloat(0.0F);
    public final PBFloatField longitude = PBField.initFloat(0.0F);
    public final PBInt32Field radius = PBField.initInt32(0);
    public final PBBytesField region = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21, 29, 32, 42, 50 }, new String[] { "action", "latitude", "longitude", "radius", "city", "region" }, new Object[] { localByteStringMicro1, Float.valueOf(0.0F), Float.valueOf(0.0F), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3 }, ExtensionRequestInfo.class);
    }
  }
  
  public static final class JumpInfo
    extends MessageMicro<JumpInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field flag = PBField.initInt32(0);
    public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "url", "title", "flag" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, JumpInfo.class);
    }
  }
  
  public static final class MoreWordInfo
    extends MessageMicro<MoreWordInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField jmp_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField show_words = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "show_words", "jmp_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, MoreWordInfo.class);
    }
  }
  
  public static final class PluginState
    extends MessageMicro<PluginState>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "plugin_id", "plugin_switch" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, PluginState.class);
    public final PBInt32Field plugin_id = PBField.initInt32(0);
    public final PBInt32Field plugin_switch = PBField.initInt32(0);
  }
  
  public static final class RequestBody
    extends MessageMicro<RequestBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public mobileqq_dynamic_search.ExtensionRequestInfo extension_request_info = new mobileqq_dynamic_search.ExtensionRequestInfo();
    public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField result_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public mobileqq_dynamic_search.RootSearcherRequest search_request = new mobileqq_dynamic_search.RootSearcherRequest();
    public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58 }, new String[] { "cmd", "key_word", "search_request", "extension_request_info", "result_id", "version", "bytes_cookie" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, null, null, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, RequestBody.class);
    }
  }
  
  public static final class ResponseBody
    extends MessageMicro<ResponseBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt32Field hotwords_cache_timeout = PBField.initUInt32(0);
    public final PBRepeatMessageField<mobileqq_dynamic_search.ResultItemGroup> item_groups = PBField.initRepeatMessage(mobileqq_dynamic_search.ResultItemGroup.class);
    public mobileqq_dynamic_search.JumpInfo jump_info = new mobileqq_dynamic_search.JumpInfo();
    public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public mobileqq_dynamic_search.MoreWordInfo more_word_info = new mobileqq_dynamic_search.MoreWordInfo();
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBUInt64Field search_id = PBField.initUInt64(0L);
    public final PBBytesField search_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<mobileqq_dynamic_search.TabItemGroup> tab_groups = PBField.initRepeatMessage(mobileqq_dynamic_search.TabItemGroup.class);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 58, 66, 74, 82, 802 }, new String[] { "cmd", "retcode", "key_word", "item_groups", "search_id", "hotwords_cache_timeout", "more_word_info", "tab_groups", "jump_info", "bytes_cookie", "search_ver" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, null, Long.valueOf(0L), Integer.valueOf(0), null, null, null, localByteStringMicro2, localByteStringMicro3 }, ResponseBody.class);
    }
  }
  
  public static final class ResultItem
    extends MessageMicro<ResultItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField extension = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField jmp_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField result_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField word = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "result_id", "name", "pic_url", "jmp_url", "word", "extension" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6 }, ResultItem.class);
    }
  }
  
  public static final class ResultItemGroup
    extends MessageMicro<ResultItemGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field group_id = PBField.initUInt32(0);
    public final PBUInt32Field group_mask = PBField.initUInt32(0);
    public final PBBytesField group_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField more_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField more_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<mobileqq_dynamic_search.ResultItem> result_items = PBField.initRepeatMessage(mobileqq_dynamic_search.ResultItem.class);
    public final PBUInt64Field total_result_count = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 56 }, new String[] { "group_mask", "group_name", "result_items", "total_result_count", "more_url", "more_name", "group_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, null, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, ResultItemGroup.class);
    }
  }
  
  public static final class RootSearcherRequest
    extends MessageMicro<RootSearcherRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58 }, new String[] { "ver", "business", "start_index", "page_size", "busi_mask", "req_ctrl_type", "plugin_state" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), Long.valueOf(-1L), Integer.valueOf(0), null }, RootSearcherRequest.class);
    public final PBInt64Field busi_mask = PBField.initInt64(-1L);
    public final PBEnumField business = PBField.initEnum(0);
    public final PBInt32Field page_size = PBField.initInt32(3);
    public final PBRepeatMessageField<mobileqq_dynamic_search.PluginState> plugin_state = PBField.initRepeatMessage(mobileqq_dynamic_search.PluginState.class);
    public final PBEnumField req_ctrl_type = PBField.initEnum(0);
    public final PBInt32Field start_index = PBField.initInt32(0);
    public final PBUInt32Field ver = PBField.initUInt32(0);
  }
  
  public static final class TabItemGroup
    extends MessageMicro<TabItemGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field group_mask = PBField.initUInt32(0);
    public final PBBytesField tab_name = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "group_mask", "tab_name" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, TabItemGroup.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search
 * JD-Core Version:    0.7.0.1
 */