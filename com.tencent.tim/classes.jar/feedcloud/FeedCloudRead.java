package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedCloudRead
{
  public static final class StGetBusiInfoReq
    extends MessageMicro<StGetBusiInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "busiReqData" }, new Object[] { null, localByteStringMicro }, StGetBusiInfoReq.class);
    }
  }
  
  public static final class StGetBusiInfoRsp
    extends MessageMicro<StGetBusiInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "busiRspData" }, new Object[] { null, localByteStringMicro }, StGetBusiInfoRsp.class);
    }
  }
  
  public static final class StGetCommentListReq
    extends MessageMicro<StGetCommentListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField feedAttchInfo = PBField.initString("");
    public final PBStringField feedId = PBField.initString("");
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBStringField likeKey = PBField.initString("");
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public final PBStringField userId = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50, 58, 66 }, new String[] { "extInfo", "userId", "feedId", "listNum", "from", "feedAttchInfo", "busiReqData", "likeKey" }, new Object[] { null, "", "", Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro, "" }, StGetCommentListReq.class);
    }
  }
  
  public static final class StGetCommentListRsp
    extends MessageMicro<StGetCommentListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField feedAttchInfo = PBField.initString("");
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBUInt32Field totalNum = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta.StComment> vecComment = PBField.initRepeatMessage(FeedCloudMeta.StComment.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50 }, new String[] { "extInfo", "vecComment", "totalNum", "isFinish", "feedAttchInfo", "busiRspData" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro }, StGetCommentListRsp.class);
    }
  }
  
  public static final class StGetFansListReq
    extends MessageMicro<StGetFansListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField attachInfo = PBField.initString("");
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field count = PBField.initInt64(0L);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField userId = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "extInfo", "userId", "attachInfo", "count", "busiReqData" }, new Object[] { null, "", "", Long.valueOf(0L), localByteStringMicro }, StGetFansListReq.class);
    }
  }
  
  public static final class StGetFansListRsp
    extends MessageMicro<StGetFansListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField attachInfo = PBField.initString("");
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBUInt32Field hasNext = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta.StRelationInfo> relationInfo = PBField.initRepeatMessage(FeedCloudMeta.StRelationInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "extInfo", "attachInfo", "hasNext", "relationInfo", "busiRspData" }, new Object[] { null, "", Integer.valueOf(0), null, localByteStringMicro }, StGetFansListRsp.class);
    }
  }
  
  public static final class StGetFeedDetailReq
    extends MessageMicro<StGetFeedDetailReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField adAttchInfo = PBField.initString("");
    public final PBBytesField adres = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bizReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field createTime = PBField.initUInt64(0L);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField feedId = PBField.initString("");
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBBoolField useUGCStore = PBField.initBool(false);
    public final PBStringField userId = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 50, 58, 66, 72 }, new String[] { "extInfo", "from", "userId", "feedId", "createTime", "adres", "adAttchInfo", "bizReqData", "useUGCStore" }, new Object[] { null, Integer.valueOf(0), "", "", Long.valueOf(0L), localByteStringMicro1, "", localByteStringMicro2, Boolean.valueOf(false) }, StGetFeedDetailReq.class);
    }
  }
  
  public static final class StGetFeedDetailRsp
    extends MessageMicro<StGetFeedDetailRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField adAttchInfo = PBField.initString("");
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField detailUrl = PBField.initString("");
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public FeedCloudMeta.StShare share = new FeedCloudMeta.StShare();
    public final PBRepeatMessageField<FeedCloudMeta.StFeed> vecRcmdFeed = PBField.initRepeatMessage(FeedCloudMeta.StFeed.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58, 66 }, new String[] { "extInfo", "detailUrl", "feed", "vecRcmdFeed", "share", "isFinish", "adAttchInfo", "busiRspData" }, new Object[] { null, "", null, null, null, Integer.valueOf(0), "", localByteStringMicro }, StGetFeedDetailRsp.class);
    }
  }
  
  public static final class StGetFeedListReq
    extends MessageMicro<StGetFeedListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField adAttchInfo = PBField.initString("");
    public final PBBytesField adres = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
    public final PBStringField feedAttchInfo = PBField.initString("");
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public final PBInt32Field source = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 58, 80, 90 }, new String[] { "extInfo", "listNum", "from", "feed", "adres", "adAttchInfo", "feedAttchInfo", "source", "busiReqData" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro1, "", "", Integer.valueOf(0), localByteStringMicro2 }, StGetFeedListReq.class);
    }
  }
  
  public static final class StGetFeedListRsp
    extends MessageMicro<StGetFeedListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField adAttchInfo = PBField.initString("");
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField feedAttchInfo = PBField.initString("");
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public FeedCloudMeta.StUser user = new FeedCloudMeta.StUser();
    public final PBRepeatMessageField<FeedCloudMeta.StFeed> vecFeed = PBField.initRepeatMessage(FeedCloudMeta.StFeed.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 58 }, new String[] { "extInfo", "vecFeed", "isFinish", "user", "adAttchInfo", "feedAttchInfo", "busiRspData" }, new Object[] { null, null, Integer.valueOf(0), null, "", "", localByteStringMicro }, StGetFeedListRsp.class);
    }
  }
  
  public static final class StGetFollowListReq
    extends MessageMicro<StGetFollowListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField attachInfo = PBField.initString("");
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField userId = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "extInfo", "userId", "attachInfo", "count", "busiReqData" }, new Object[] { null, "", "", Integer.valueOf(0), localByteStringMicro }, StGetFollowListReq.class);
    }
  }
  
  public static final class StGetFollowListRsp
    extends MessageMicro<StGetFollowListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField attachInfo = PBField.initString("");
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBUInt32Field hasNext = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta.StRelationInfo> relationInfo = PBField.initRepeatMessage(FeedCloudMeta.StRelationInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "extInfo", "attachInfo", "hasNext", "relationInfo", "busiRspData" }, new Object[] { null, "", Integer.valueOf(0), null, localByteStringMicro }, StGetFollowListRsp.class);
    }
  }
  
  public static final class StGetFollowTagListReq
    extends MessageMicro<StGetFollowTagListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField attachInfo = PBField.initString("");
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField userId = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "extInfo", "userId", "attachInfo", "count", "busiReqData" }, new Object[] { null, "", "", Integer.valueOf(0), localByteStringMicro }, StGetFollowTagListReq.class);
    }
  }
  
  public static final class StGetFollowTagListRsp
    extends MessageMicro<StGetFollowTagListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField attachInfo = PBField.initString("");
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBUInt32Field hasNext = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta.StTagInfo> tagInfos = PBField.initRepeatMessage(FeedCloudMeta.StTagInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "extInfo", "attachInfo", "hasNext", "tagInfos", "busiRspData" }, new Object[] { null, "", Integer.valueOf(0), null, localByteStringMicro }, StGetFollowTagListRsp.class);
    }
  }
  
  public static final class StGetLightInteractListReq
    extends MessageMicro<StGetLightInteractListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50 }, new String[] { "extInfo", "type", "attachInfo", "id", "hostID", "feedID" }, new Object[] { null, Integer.valueOf(0), "", "", "", "" }, StGetLightInteractListReq.class);
    public final PBStringField attachInfo = PBField.initString("");
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField feedID = PBField.initString("");
    public final PBStringField hostID = PBField.initString("");
    public final PBStringField id = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class StGetLightInteractListRsp
    extends MessageMicro<StGetLightInteractListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "extInfo", "attachInfo", "listInfo", "isFinish", "totalCount" }, new Object[] { null, "", null, Integer.valueOf(0), Integer.valueOf(0) }, StGetLightInteractListRsp.class);
    public final PBStringField attachInfo = PBField.initString("");
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta.StLightInteractInfo> listInfo = PBField.initRepeatMessage(FeedCloudMeta.StLightInteractInfo.class);
    public final PBUInt32Field totalCount = PBField.initUInt32(0);
  }
  
  public static final class StGetMainPageReq
    extends MessageMicro<StGetMainPageReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField feedAttchInfo = PBField.initString("");
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBBoolField needFeed = PBField.initBool(false);
    public final PBStringField userId = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48 }, new String[] { "extInfo", "userId", "from", "feedAttchInfo", "busiReqData", "needFeed" }, new Object[] { null, "", Integer.valueOf(0), "", localByteStringMicro, Boolean.valueOf(false) }, StGetMainPageReq.class);
    }
  }
  
  public static final class StGetMainPageRsp
    extends MessageMicro<StGetMainPageRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBUInt32Field fansCount = PBField.initUInt32(0);
    public final PBStringField feedAttchInfo = PBField.initString("");
    public final PBUInt32Field feedCount = PBField.initUInt32(0);
    public final PBUInt32Field followCount = PBField.initUInt32(0);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public FeedCloudMeta.StShare share = new FeedCloudMeta.StShare();
    public FeedCloudMeta.StUser user = new FeedCloudMeta.StUser();
    public final PBRepeatMessageField<FeedCloudMeta.StFeed> vecFeed = PBField.initRepeatMessage(FeedCloudMeta.StFeed.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 56, 66, 74, 82 }, new String[] { "extInfo", "user", "feedCount", "fansCount", "followCount", "vecFeed", "isFinish", "share", "feedAttchInfo", "busiRspData" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), null, "", localByteStringMicro }, StGetMainPageRsp.class);
    }
  }
  
  public static final class StGetNoticeListReq
    extends MessageMicro<StGetNoticeListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField feedAttchInfo = PBField.initString("");
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public final PBUInt32Field pageType = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42 }, new String[] { "extInfo", "listNum", "feedAttchInfo", "pageType", "busiReqData" }, new Object[] { null, Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro }, StGetNoticeListReq.class);
    }
  }
  
  public static final class StGetNoticeListRsp
    extends MessageMicro<StGetNoticeListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField feedAttchInfo = PBField.initString("");
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBUInt32Field totalNum = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta.StNotice> vecNotice = PBField.initRepeatMessage(FeedCloudMeta.StNotice.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50 }, new String[] { "extInfo", "vecNotice", "totalNum", "isFinish", "feedAttchInfo", "busiRspData" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro }, StGetNoticeListRsp.class);
    }
  }
  
  public static final class StGetRecomTagListReq
    extends MessageMicro<StGetRecomTagListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StGPSV2 gpsInfo = new FeedCloudMeta.StGPSV2();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "gpsInfo", "busiReqData" }, new Object[] { null, null, localByteStringMicro }, StGetRecomTagListReq.class);
    }
  }
  
  public static final class StGetRecomTagListRsp
    extends MessageMicro<StGetRecomTagListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta.StTagInfo> tagList = PBField.initRepeatMessage(FeedCloudMeta.StTagInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "tagList", "busiRspData" }, new Object[] { null, null, localByteStringMicro }, StGetRecomTagListRsp.class);
    }
  }
  
  public static final class StGetRecomUserListReq
    extends MessageMicro<StGetRecomUserListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField attachInfo = PBField.initString("");
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBBoolField needFeeds = PBField.initBool(false);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "extInfo", "needFeeds", "attachInfo", "busiReqData" }, new Object[] { null, Boolean.valueOf(false), "", localByteStringMicro }, StGetRecomUserListReq.class);
    }
  }
  
  public static final class StGetRecomUserListRsp
    extends MessageMicro<StGetRecomUserListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField attachInfo = PBField.initString("");
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta.StUserRecomInfo> userRecoms = PBField.initRepeatMessage(FeedCloudMeta.StUserRecomInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "extInfo", "userRecoms", "attachInfo", "isFinish", "busiRspData" }, new Object[] { null, null, "", Integer.valueOf(0), localByteStringMicro }, StGetRecomUserListRsp.class);
    }
  }
  
  public static final class StGetSessionInfoReq
    extends MessageMicro<StGetSessionInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "scene" }, new Object[] { null, Integer.valueOf(0) }, StGetSessionInfoReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBUInt32Field scene = PBField.initUInt32(0);
  }
  
  public static final class StGetSessionInfoRsp
    extends MessageMicro<StGetSessionInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field expireTime = PBField.initUInt32(0);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBUInt32Field sessionType = PBField.initUInt32(0);
    public final PBBytesField sessonID = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField subSessonID = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField transInfo = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48 }, new String[] { "extInfo", "sessonID", "subSessonID", "transInfo", "expireTime", "sessionType" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0) }, StGetSessionInfoRsp.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     feedcloud.FeedCloudRead
 * JD-Core Version:    0.7.0.1
 */