package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM.StCommonExt;
import NS_QQ_STORY_META.META.StComment;
import NS_QQ_STORY_META.META.StMusic;
import NS_QQ_STORY_META.META.StReply;
import NS_QQ_STORY_META.META.StStoryFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
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

public final class CLIENT
{
  public static final class StAddInteractEmojiReq
    extends MessageMicro<StAddInteractEmojiReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "extInfo", "feedID", "feedPosterUin", "emojiId", "emojiAddCount" }, new Object[] { null, "", "", Integer.valueOf(1), Integer.valueOf(0) }, StAddInteractEmojiReq.class);
    public final PBInt32Field emojiAddCount = PBField.initInt32(0);
    public final PBEnumField emojiId = PBField.initEnum(1);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField feedID = PBField.initString("");
    public final PBStringField feedPosterUin = PBField.initString("");
  }
  
  public static final class StAddInteractEmojiRsp
    extends MessageMicro<StAddInteractEmojiRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "emojiTotalCount" }, new Object[] { null, Long.valueOf(0L) }, StAddInteractEmojiRsp.class);
    public final PBUInt64Field emojiTotalCount = PBField.initUInt64(0L);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StBannerFriendsUnreadByUser
    extends MessageMicro<StBannerFriendsUnreadByUser>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "userStoryList", "total", "isFinish", "attachInfo" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "" }, StBannerFriendsUnreadByUser.class);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBRepeatMessageField<CLIENT.StStoryBanner> userStoryList = PBField.initRepeatMessage(CLIENT.StStoryBanner.class);
  }
  
  public static final class StBatchGetMusicInfoReq
    extends MessageMicro<StBatchGetMusicInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "vecSongMid", "needLyric" }, new Object[] { null, "", Integer.valueOf(0) }, StBatchGetMusicInfoReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field needLyric = PBField.initUInt32(0);
    public final PBRepeatField<String> vecSongMid = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StBatchGetMusicInfoRsp
    extends MessageMicro<StBatchGetMusicInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "vecMusic" }, new Object[] { null, null }, StBatchGetMusicInfoRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<META.StMusic> vecMusic = PBField.initRepeatMessage(META.StMusic.class);
  }
  
  public static final class StExposeStoryReq
    extends MessageMicro<StExposeStoryReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "feedPosterUin", "feedId" }, new Object[] { null, "", "" }, StExposeStoryReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField feedId = PBField.initString("");
    public final PBStringField feedPosterUin = PBField.initString("");
  }
  
  public static final class StExposeStoryRsp
    extends MessageMicro<StExposeStoryRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StExposeStoryRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetStoryCommentListReq
    extends MessageMicro<StGetStoryCommentListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "storyFeed", "listNum" }, new Object[] { null, null, Integer.valueOf(0) }, StGetStoryCommentListReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public META.StStoryFeed storyFeed = new META.StStoryFeed();
  }
  
  public static final class StGetStoryCommentListRsp
    extends MessageMicro<StGetStoryCommentListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "extInfo", "vecComment", "totalNum", "isFinish", "storyFeed" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), null }, StGetStoryCommentListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public META.StStoryFeed storyFeed = new META.StStoryFeed();
    public final PBUInt32Field totalNum = PBField.initUInt32(0);
    public final PBRepeatMessageField<META.StComment> vecComment = PBField.initRepeatMessage(META.StComment.class);
  }
  
  public static final class StGetStoryFeedListReq
    extends MessageMicro<StGetStoryFeedListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "listType", "listNum", "uinTime" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), null }, StGetStoryFeedListReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public final PBEnumField listType = PBField.initEnum(0);
    public CLIENT.StUinTime uinTime = new CLIENT.StUinTime();
  }
  
  public static final class StGetStoryFeedListRsp
    extends MessageMicro<StGetStoryFeedListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field hasNewStory = PBField.initUInt32(0);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBUInt32Field isShowCamera = PBField.initUInt32(0);
    public final PBBytesField storyBannerBuff = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field totalNum = PBField.initUInt32(0);
    public final PBRepeatMessageField<META.StStoryFeed> vecStoryFeed = PBField.initRepeatMessage(META.StStoryFeed.class);
    public final PBRepeatMessageField<CLIENT.StUinStory> vecUinStory = PBField.initRepeatMessage(CLIENT.StUinStory.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 56, 66 }, new String[] { "extInfo", "vecStoryFeed", "totalNum", "isFinish", "isShowCamera", "vecUinStory", "hasNewStory", "storyBannerBuff" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro }, StGetStoryFeedListRsp.class);
    }
  }
  
  public static final class StGetStoryReplyListReq
    extends MessageMicro<StGetStoryReplyListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "extInfo", "storyFeed", "comment", "listNum" }, new Object[] { null, null, null, Integer.valueOf(0) }, StGetStoryReplyListReq.class);
    public META.StComment comment = new META.StComment();
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public META.StStoryFeed storyFeed = new META.StStoryFeed();
  }
  
  public static final class StGetStoryReplyListRsp
    extends MessageMicro<StGetStoryReplyListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "vecReply", "totalNum", "isFinish" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0) }, StGetStoryReplyListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBUInt32Field totalNum = PBField.initUInt32(0);
    public final PBRepeatMessageField<META.StReply> vecReply = PBField.initRepeatMessage(META.StReply.class);
  }
  
  public static final class StGetUserNewestStoryReq
    extends MessageMicro<StGetUserNewestStoryReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "vecUinTime", "fromScene" }, new Object[] { null, null, Integer.valueOf(0) }, StGetUserNewestStoryReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field fromScene = PBField.initUInt32(0);
    public final PBRepeatMessageField<CLIENT.StUinTime> vecUinTime = PBField.initRepeatMessage(CLIENT.StUinTime.class);
  }
  
  public static final class StGetUserNewestStoryRsp
    extends MessageMicro<StGetUserNewestStoryRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "extInfo", "vecStoryFeed", "vecUinStory", "hasNewStory" }, new Object[] { null, null, null, Integer.valueOf(0) }, StGetUserNewestStoryRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field hasNewStory = PBField.initUInt32(0);
    public final PBRepeatMessageField<META.StStoryFeed> vecStoryFeed = PBField.initRepeatMessage(META.StStoryFeed.class);
    public final PBRepeatMessageField<CLIENT.StUinStory> vecUinStory = PBField.initRepeatMessage(CLIENT.StUinStory.class);
  }
  
  public static final class StGetWatermarkDictReq
    extends MessageMicro<StGetWatermarkDictReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 17, 25, 34 }, new String[] { "extInfo", "fLat", "fLon", "clientIP" }, new Object[] { null, Double.valueOf(0.0D), Double.valueOf(0.0D), "" }, StGetWatermarkDictReq.class);
    public final PBStringField clientIP = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBDoubleField fLat = PBField.initDouble(0.0D);
    public final PBDoubleField fLon = PBField.initDouble(0.0D);
  }
  
  public static final class StGetWatermarkDictRsp
    extends MessageMicro<StGetWatermarkDictRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "vecWatermarkDict" }, new Object[] { null, null }, StGetWatermarkDictRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<CLIENT.StWatermarkDict> vecWatermarkDict = PBField.initRepeatMessage(CLIENT.StWatermarkDict.class);
  }
  
  public static final class StPublishStoryFeedReq
    extends MessageMicro<StPublishStoryFeedReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "storyFeed" }, new Object[] { null, null }, StPublishStoryFeedReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public META.StStoryFeed storyFeed = new META.StStoryFeed();
  }
  
  public static final class StPublishStoryFeedRsp
    extends MessageMicro<StPublishStoryFeedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "storyFeed" }, new Object[] { null, null }, StPublishStoryFeedRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public META.StStoryFeed storyFeed = new META.StStoryFeed();
  }
  
  public static final class StSmartMatchMusicReq
    extends MessageMicro<StSmartMatchMusicReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field cameraType = PBField.initUInt32(0);
    public final PBUInt32Field dataType = PBField.initUInt32(0);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBDoubleField fLat = PBField.initDouble(0.0D);
    public final PBDoubleField fLon = PBField.initDouble(0.0D);
    public final PBRepeatField<ByteStringMicro> vecPicBuff = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField videoBuff = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field videoDuration = PBField.initUInt32(0);
    public final PBDoubleField videoLat = PBField.initDouble(0.0D);
    public final PBDoubleField videoLon = PBField.initDouble(0.0D);
    public final PBUInt64Field videoTime = PBField.initUInt64(0L);
    public final PBUInt32Field videoType = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 49, 57, 64, 72, 81, 89, 96 }, new String[] { "extInfo", "videoBuff", "videoDuration", "dataType", "vecPicBuff", "fLat", "fLon", "videoType", "cameraType", "videoLat", "videoLon", "videoTime" }, new Object[] { null, localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Double.valueOf(0.0D), Double.valueOf(0.0D), Integer.valueOf(0), Integer.valueOf(0), Double.valueOf(0.0D), Double.valueOf(0.0D), Long.valueOf(0L) }, StSmartMatchMusicReq.class);
    }
  }
  
  public static final class StSmartMatchMusicRsp
    extends MessageMicro<StSmartMatchMusicRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "vecMusic" }, new Object[] { null, null }, StSmartMatchMusicRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<META.StMusic> vecMusic = PBField.initRepeatMessage(META.StMusic.class);
  }
  
  public static final class StStoryBanner
    extends MessageMicro<StStoryBanner>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "vecStoryFeed", "unreadCount" }, new Object[] { null, Integer.valueOf(0) }, StStoryBanner.class);
    public final PBUInt32Field unreadCount = PBField.initUInt32(0);
    public final PBRepeatMessageField<META.StStoryFeed> vecStoryFeed = PBField.initRepeatMessage(META.StStoryFeed.class);
  }
  
  public static final class StUinStory
    extends MessageMicro<StUinStory>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField storyBuff = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uin", "storyBuff" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, StUinStory.class);
    }
  }
  
  public static final class StUinTime
    extends MessageMicro<StUinTime>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "newestTime" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, StUinTime.class);
    public final PBUInt64Field newestTime = PBField.initUInt64(0L);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class StWatermarkDict
    extends MessageMicro<StWatermarkDict>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "key", "value" }, new Object[] { "", "" }, StWatermarkDict.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QQ_STORY_CLIENT.CLIENT
 * JD-Core Version:    0.7.0.1
 */