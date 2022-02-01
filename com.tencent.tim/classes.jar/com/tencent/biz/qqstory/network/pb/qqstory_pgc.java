package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_pgc
{
  public static final class ErrorInfo
    extends MessageMicro<ErrorInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field error_code = PBField.initUInt32(0);
    public final PBBytesField error_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "error_code", "error_desc" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, ErrorInfo.class);
    }
  }
  
  public static final class ReqGetInfoCard
    extends MessageMicro<ReqGetInfoCard>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uid", "type", "union_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, ReqGetInfoCard.class);
    }
  }
  
  public static final class ReqGetSearchFeedList
    extends MessageMicro<ReqGetSearchFeedList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField ignore_keyword = PBField.initBool(false);
    public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_pgc.SearchType> type_list = PBField.initRepeatMessage(qqstory_pgc.SearchType.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "key_word", "type_list", "ignore_keyword" }, new Object[] { localByteStringMicro, null, Boolean.valueOf(false) }, ReqGetSearchFeedList.class);
    }
  }
  
  public static final class ReqGetStoryList
    extends MessageMicro<ReqGetStoryList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "uid", "type", "count", "start_cookie", "union_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, ReqGetStoryList.class);
    }
  }
  
  public static final class ReqReport
    extends MessageMicro<ReqReport>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field operation = PBField.initUInt32(0);
    public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "story_id", "type", "uid", "operation", "union_id" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro2 }, ReqReport.class);
    }
  }
  
  public static final class ReqSubscription
    extends MessageMicro<ReqSubscription>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field from = PBField.initUInt32(0);
    public final PBUInt32Field operation = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uin", "type", "operation", "union_id", "from" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, ReqSubscription.class);
    }
  }
  
  public static final class RspGetInfoCard
    extends MessageMicro<RspGetInfoCard>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "user" }, new Object[] { null, null }, RspGetInfoCard.class);
    public qqstory_pgc.ErrorInfo result = new qqstory_pgc.ErrorInfo();
    public qqstory_pgc.UserInfo user = new qqstory_pgc.UserInfo();
  }
  
  public static final class RspGetSearchFeedList
    extends MessageMicro<RspGetSearchFeedList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<qqstory_pgc.UserInfo> feed_list = PBField.initRepeatMessage(qqstory_pgc.UserInfo.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> key_word_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_pgc.ErrorInfo result = new qqstory_pgc.ErrorInfo();
    public final PBUInt32Field result_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 50 }, new String[] { "result", "result_type", "feed_list", "is_end", "next_cookie", "key_word_list" }, new Object[] { null, Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, RspGetSearchFeedList.class);
    }
  }
  
  public static final class RspReport
    extends MessageMicro<RspReport>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspReport.class);
    public qqstory_pgc.ErrorInfo result = new qqstory_pgc.ErrorInfo();
  }
  
  public static final class RspSubscription
    extends MessageMicro<RspSubscription>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "result", "is_subscribe" }, new Object[] { null, Integer.valueOf(0) }, RspSubscription.class);
    public final PBUInt32Field is_subscribe = PBField.initUInt32(0);
    public qqstory_pgc.ErrorInfo result = new qqstory_pgc.ErrorInfo();
  }
  
  public static final class SearchType
    extends MessageMicro<SearchType>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field search_count = PBField.initUInt32(0);
    public final PBUInt32Field search_type = PBField.initUInt32(0);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "search_type", "start_cookie", "search_count" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, SearchType.class);
    }
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField auth_type_icon = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField auth_type_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field fans_group_uin = PBField.initUInt64(0L);
    public final PBBytesField head_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField is_subscribe = PBField.initBool(false);
    public final PBBytesField logo_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field subscribe_count = PBField.initUInt64(0L);
    public final PBUInt32Field theme_color = PBField.initUInt32(0);
    public final PBUInt64Field tribe_id = PBField.initUInt64(0L);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field view_count = PBField.initUInt64(0L);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 58, 66, 72, 80, 88, 96, 104, 114, 122, 130 }, new String[] { "type", "uid", "nick", "head_url", "remark", "is_subscribe", "desc", "logo_url", "view_count", "fans_group_uin", "tribe_id", "theme_color", "subscribe_count", "union_id", "auth_type_name", "auth_type_icon" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Boolean.valueOf(false), localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro6, localByteStringMicro7, localByteStringMicro8 }, UserInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_pgc
 * JD-Core Version:    0.7.0.1
 */