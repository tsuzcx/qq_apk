package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedCloudWrite
{
  public static final class StDelFeedReq
    extends MessageMicro<StDelFeedReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "feed", "from" }, new Object[] { null, null, Integer.valueOf(0) }, StDelFeedReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
    public final PBInt32Field from = PBField.initInt32(0);
  }
  
  public static final class StDelFeedRsp
    extends MessageMicro<StDelFeedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StDelFeedRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class StDoBatchFollowReq
    extends MessageMicro<StDoBatchFollowReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "extInfo", "followType", "userList", "from" }, new Object[] { null, Integer.valueOf(0), null, Integer.valueOf(0) }, StDoBatchFollowReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBUInt32Field followType = PBField.initUInt32(0);
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta.StUser> userList = PBField.initRepeatMessage(FeedCloudMeta.StUser.class);
  }
  
  public static final class StDoBatchFollowRsp
    extends MessageMicro<StDoBatchFollowRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StDoBatchFollowRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class StDoCommentReq
    extends MessageMicro<StDoCommentReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudMeta.StComment comment = new FeedCloudMeta.StComment();
    public final PBUInt32Field commentType = PBField.initUInt32(0);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
    public final PBInt32Field from = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 50 }, new String[] { "extInfo", "commentType", "comment", "feed", "from", "busiReqData" }, new Object[] { null, Integer.valueOf(0), null, null, Integer.valueOf(0), localByteStringMicro }, StDoCommentReq.class);
    }
  }
  
  public static final class StDoCommentRsp
    extends MessageMicro<StDoCommentRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudMeta.StComment comment = new FeedCloudMeta.StComment();
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "comment", "busiRspData" }, new Object[] { null, null, localByteStringMicro }, StDoCommentRsp.class);
    }
  }
  
  public static final class StDoFollowReq
    extends MessageMicro<StDoFollowReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "extInfo", "followType", "user", "from" }, new Object[] { null, Integer.valueOf(0), null, Integer.valueOf(0) }, StDoFollowReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBUInt32Field followType = PBField.initUInt32(0);
    public final PBInt32Field from = PBField.initInt32(0);
    public FeedCloudMeta.StUser user = new FeedCloudMeta.StUser();
  }
  
  public static final class StDoFollowRsp
    extends MessageMicro<StDoFollowRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StDoFollowRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class StDoLikeReq
    extends MessageMicro<StDoLikeReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudMeta.StComment comment = new FeedCloudMeta.StComment();
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
    public FeedCloudMeta.StLike like = new FeedCloudMeta.StLike();
    public final PBUInt32Field likeType = PBField.initUInt32(0);
    public FeedCloudMeta.StReply reply = new FeedCloudMeta.StReply();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 58 }, new String[] { "extInfo", "likeType", "like", "feed", "busiReqData", "comment", "reply" }, new Object[] { null, Integer.valueOf(0), null, null, localByteStringMicro, null, null }, StDoLikeReq.class);
    }
  }
  
  public static final class StDoLikeRsp
    extends MessageMicro<StDoLikeRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StLike like = new FeedCloudMeta.StLike();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "like", "busiRspData" }, new Object[] { null, null, localByteStringMicro }, StDoLikeRsp.class);
    }
  }
  
  public static final class StDoPushReq
    extends MessageMicro<StDoPushReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field comboCount = PBField.initInt32(0);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
    public final PBInt32Field from = PBField.initInt32(0);
    public FeedCloudMeta.StPushList push = new FeedCloudMeta.StPushList();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 50 }, new String[] { "extInfo", "feed", "comboCount", "push", "from", "busiReqData" }, new Object[] { null, null, Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro }, StDoPushReq.class);
    }
  }
  
  public static final class StDoPushRsp
    extends MessageMicro<StDoPushRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field consumeFuel = PBField.initUInt32(0);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBUInt32Field myFuel = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "consumeFuel", "myFuel", "busiRspData" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, StDoPushRsp.class);
    }
  }
  
  public static final class StDoReplyReq
    extends MessageMicro<StDoReplyReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudMeta.StComment comment = new FeedCloudMeta.StComment();
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
    public final PBInt32Field from = PBField.initInt32(0);
    public FeedCloudMeta.StReply reply = new FeedCloudMeta.StReply();
    public final PBUInt32Field replyType = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 48, 58 }, new String[] { "extInfo", "replyType", "reply", "comment", "feed", "from", "busiReqData" }, new Object[] { null, Integer.valueOf(0), null, null, null, Integer.valueOf(0), localByteStringMicro }, StDoReplyReq.class);
    }
  }
  
  public static final class StDoReplyRsp
    extends MessageMicro<StDoReplyRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StReply reply = new FeedCloudMeta.StReply();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "reply", "busiRspData" }, new Object[] { null, null, localByteStringMicro }, StDoReplyRsp.class);
    }
  }
  
  public static final class StDoSecurityReq
    extends MessageMicro<StDoSecurityReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50 }, new String[] { "extInfo", "feed", "comment", "reply", "from", "poster" }, new Object[] { null, null, null, null, Integer.valueOf(0), null }, StDoSecurityReq.class);
    public FeedCloudMeta.StComment comment = new FeedCloudMeta.StComment();
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
    public final PBInt32Field from = PBField.initInt32(0);
    public FeedCloudMeta.StUser poster = new FeedCloudMeta.StUser();
    public FeedCloudMeta.StReply reply = new FeedCloudMeta.StReply();
  }
  
  public static final class StDoSecurityRsp
    extends MessageMicro<StDoSecurityRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StDoSecurityRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class StDoTopReq
    extends MessageMicro<StDoTopReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudMeta.StComment comment = new FeedCloudMeta.StComment();
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBUInt32Field topType = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 50 }, new String[] { "extInfo", "topType", "feed", "comment", "from", "busiReqData" }, new Object[] { null, Integer.valueOf(0), null, null, Integer.valueOf(0), localByteStringMicro }, StDoTopReq.class);
    }
  }
  
  public static final class StDoTopRsp
    extends MessageMicro<StDoTopRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StDoTopRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class StModifyFeedReq
    extends MessageMicro<StModifyFeedReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "feed", "mBitmap", "from" }, new Object[] { null, null, Long.valueOf(0L), Integer.valueOf(0) }, StModifyFeedReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBUInt64Field mBitmap = PBField.initUInt64(0L);
  }
  
  public static final class StModifyFeedRsp
    extends MessageMicro<StModifyFeedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "feed", "busiRspData" }, new Object[] { null, null, localByteStringMicro }, StModifyFeedRsp.class);
    }
  }
  
  public static final class StPublishFeedReq
    extends MessageMicro<StPublishFeedReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
    public final PBInt32Field from = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "extInfo", "feed", "busiReqData", "from" }, new Object[] { null, null, localByteStringMicro, Integer.valueOf(0) }, StPublishFeedReq.class);
    }
  }
  
  public static final class StPublishFeedRsp
    extends MessageMicro<StPublishFeedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "feed", "busiRspData" }, new Object[] { null, null, localByteStringMicro }, StPublishFeedRsp.class);
    }
  }
  
  public static final class StRecomForwardFeedReq
    extends MessageMicro<StRecomForwardFeedReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudMeta.StComment comment = new FeedCloudMeta.StComment();
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
    public final PBInt32Field from = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "extInfo", "feed", "busiReqData", "from", "comment" }, new Object[] { null, null, localByteStringMicro, Integer.valueOf(0), null }, StRecomForwardFeedReq.class);
    }
  }
  
  public static final class StRecomForwardFeedRsp
    extends MessageMicro<StRecomForwardFeedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudMeta.StComment comment = new FeedCloudMeta.StComment();
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "extInfo", "feed", "busiRspData", "comment" }, new Object[] { null, null, localByteStringMicro, null }, StRecomForwardFeedRsp.class);
    }
  }
  
  public static final class StReportReq
    extends MessageMicro<StReportReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "reportType", "from", "reportInfo" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), null }, StReportReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta.StReportInfo> reportInfo = PBField.initRepeatMessage(FeedCloudMeta.StReportInfo.class);
    public final PBUInt32Field reportType = PBField.initUInt32(0);
  }
  
  public static final class StReportRsp
    extends MessageMicro<StReportRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StReportRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     feedcloud.FeedCloudWrite
 * JD-Core Version:    0.7.0.1
 */