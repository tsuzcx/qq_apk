package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_feeds_write
{
  public static final class AddFeedReq
    extends MessageMicro<AddFeedReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50, 58, 64, 72, 82 }, new String[] { "feed_type", "feed_source", "feed_video", "feed_upload_status", "pic_info", "live_info", "chang_info", "nowid", "local_video_flag", "lbs_info" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), null, Integer.valueOf(1), null, null, null, Long.valueOf(0L), Integer.valueOf(0), null }, AddFeedReq.class);
    public ilive_feeds_tmem.ChangFeed chang_info = new ilive_feeds_tmem.ChangFeed();
    public final PBEnumField feed_source = PBField.initEnum(0);
    public final PBEnumField feed_type = PBField.initEnum(1);
    public final PBEnumField feed_upload_status = PBField.initEnum(1);
    public ilive_feeds_tmem.VideoFeed feed_video = new ilive_feeds_tmem.VideoFeed();
    public ilive_feeds_write.LbsInfo lbs_info = new ilive_feeds_write.LbsInfo();
    public ilive_feeds_tmem.LiveFeed live_info = new ilive_feeds_tmem.LiveFeed();
    public final PBUInt32Field local_video_flag = PBField.initUInt32(0);
    public final PBUInt64Field nowid = PBField.initUInt64(0L);
    public ilive_feeds_tmem.PicFeed pic_info = new ilive_feeds_tmem.PicFeed();
  }
  
  public static final class AddFeedRsp
    extends MessageMicro<AddFeedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field ret = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "feed_id", "ret", "err_msg" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, AddFeedRsp.class);
    }
  }
  
  public static final class DelFeedReq
    extends MessageMicro<DelFeedReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field anchor_del_user = PBField.initUInt32(0);
    public final PBEnumField del_source = PBField.initEnum(1);
    public final PBRepeatMessageField<ilive_feeds_write.DelFeedStuct> del_st = PBField.initRepeatMessage(ilive_feeds_write.DelFeedStuct.class);
    public final PBEnumField del_type = PBField.initEnum(1);
    public final PBUInt32Field select_all = PBField.initUInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50, 56 }, new String[] { "del_type", "uid", "del_st", "select_all", "del_source", "vid", "anchor_del_user" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(1), localByteStringMicro, Integer.valueOf(0) }, DelFeedReq.class);
    }
  }
  
  public static final class DelFeedRsp
    extends MessageMicro<DelFeedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field ret = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret", "err_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, DelFeedRsp.class);
    }
  }
  
  public static final class DelFeedStuct
    extends MessageMicro<DelFeedStuct>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField feed_type = PBField.initEnum(1);
    public final PBBytesField file_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field timestamp = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "file_id", "feed_id", "feed_type", "timestamp" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(1), Long.valueOf(0L) }, DelFeedStuct.class);
    }
  }
  
  public static final class FeedNoInterestReq
    extends MessageMicro<FeedNoInterestReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "feedid", "is_nointerest", "type" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, FeedNoInterestReq.class);
    public final PBStringField feedid = PBField.initString("");
    public final PBInt32Field is_nointerest = PBField.initInt32(0);
    public final PBInt32Field type = PBField.initInt32(0);
  }
  
  public static final class FeedNoInterestRsp
    extends MessageMicro<FeedNoInterestRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field ret = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret", "errmsg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, FeedNoInterestRsp.class);
    }
  }
  
  public static final class GetChangVideoAndResetReq
    extends MessageMicro<GetChangVideoAndResetReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField chang_feedsid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "chang_feedsid" }, new Object[] { localByteStringMicro }, GetChangVideoAndResetReq.class);
    }
  }
  
  public static final class GetChangVideoAndResetRsp
    extends MessageMicro<GetChangVideoAndResetRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<ilive_feeds_tmem.Chang> chang = PBField.initRepeatMessage(ilive_feeds_tmem.Chang.class);
    public final PBBytesField errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field ret = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ret", "errmsg", "chang" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, GetChangVideoAndResetRsp.class);
    }
  }
  
  public static final class LbsInfo
    extends MessageMicro<LbsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField lat = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField lng = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "lng", "lat", "city", "name" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, LbsInfo.class);
    }
  }
  
  public static final class ModFeedReq
    extends MessageMicro<ModFeedReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50 }, new String[] { "feed_type", "feed_source", "feed_video", "pic_info", "live_info", "chang_info" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), null, null, null, null }, ModFeedReq.class);
    public ilive_feeds_tmem.ChangFeed chang_info = new ilive_feeds_tmem.ChangFeed();
    public final PBEnumField feed_source = PBField.initEnum(0);
    public final PBEnumField feed_type = PBField.initEnum(1);
    public ilive_feeds_tmem.VideoFeed feed_video = new ilive_feeds_tmem.VideoFeed();
    public ilive_feeds_tmem.LiveFeed live_info = new ilive_feeds_tmem.LiveFeed();
    public ilive_feeds_tmem.PicFeed pic_info = new ilive_feeds_tmem.PicFeed();
  }
  
  public static final class ModFeedRsp
    extends MessageMicro<ModFeedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field ret = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "feed_id", "ret", "err_msg" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, ModFeedRsp.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_write
 * JD-Core Version:    0.7.0.1
 */