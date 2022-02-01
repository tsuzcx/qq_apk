package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedCloudMeta
{
  public static final class StComment
    extends MessageMicro<StComment>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField content = PBField.initString("");
    public final PBUInt64Field createTime = PBField.initUInt64(0L);
    public final PBStringField id = PBField.initString("");
    public FeedCloudMeta.StLike likeInfo = new FeedCloudMeta.StLike();
    public FeedCloudMeta.StUser postUser = new FeedCloudMeta.StUser();
    public final PBUInt32Field replyCount = PBField.initUInt32(0);
    public final PBUInt32Field typeFlag = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta.StReply> vecReply = PBField.initRepeatMessage(FeedCloudMeta.StReply.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 50, 58, 66, 72 }, new String[] { "id", "postUser", "createTime", "content", "replyCount", "vecReply", "busiData", "likeInfo", "typeFlag" }, new Object[] { "", null, Long.valueOf(0L), "", Integer.valueOf(0), null, localByteStringMicro, null, Integer.valueOf(0) }, StComment.class);
    }
  }
  
  public static final class StDittoFeed
    extends MessageMicro<StDittoFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dittoData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField dittoDataNew = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field dittoId = PBField.initUInt32(0);
    public final PBUInt32Field dittoPatternId = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "dittoId", "dittoPatternId", "dittoData", "dittoDataNew" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, StDittoFeed.class);
    }
  }
  
  public static final class StFeed
    extends MessageMicro<StFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField adBuffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField busiReport = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<FeedCloudCommon.BytesEntry> busiTranparent = PBField.initRepeatMessage(FeedCloudCommon.BytesEntry.class);
    public final PBUInt32Field commentCount = PBField.initUInt32(0);
    public final PBStringField content = PBField.initString("");
    public FeedCloudMeta.StImage cover = new FeedCloudMeta.StImage();
    public final PBUInt64Field createTime = PBField.initUInt64(0L);
    public FeedCloudMeta.StDittoFeed dittoFeed = new FeedCloudMeta.StDittoFeed();
    public final PBUInt32Field feedType = PBField.initUInt32(0);
    public final PBStringField id = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta.StImage> images = PBField.initRepeatMessage(FeedCloudMeta.StImage.class);
    public final PBBoolField isRecomFd = PBField.initBool(false);
    public FeedCloudMeta.StLike likeInfo = new FeedCloudMeta.StLike();
    public final PBRepeatField<Integer> opMask = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> opMask2 = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBBoolField orgFeedDeleted = PBField.initBool(false);
    public FeedCloudMeta.StPoiInfoV2 poiInfo = new FeedCloudMeta.StPoiInfoV2();
    public FeedCloudMeta.StUser poster = new FeedCloudMeta.StUser();
    public FeedCloudMeta.StRecomForward recomForward = new FeedCloudMeta.StRecomForward();
    public FeedCloudMeta.StRecomInfo recomInfo = new FeedCloudMeta.StRecomInfo();
    public final PBBytesField reportInfoForClient = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudMeta.StShare share = new FeedCloudMeta.StShare();
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBStringField subtitle = PBField.initString("");
    public final PBUInt32Field syncStatus = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta.StTagInfo> tagInfos = PBField.initRepeatMessage(FeedCloudMeta.StTagInfo.class);
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta.StComment> vecComment = PBField.initRepeatMessage(FeedCloudMeta.StComment.class);
    public FeedCloudMeta.StVideo video = new FeedCloudMeta.StVideo();
    public FeedCloudMeta.StVisitor visitorInfo = new FeedCloudMeta.StVisitor();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 72, 82, 88, 98, 106, 114, 122, 128, 138, 146, 154, 160, 170, 178, 184, 194, 202, 208, 218, 224, 234, 240, 250, 256 }, new String[] { "id", "title", "subtitle", "poster", "cover", "video", "content", "type", "createTime", "likeInfo", "commentCount", "vecComment", "share", "visitorInfo", "images", "status", "poiInfo", "adBuffer", "busiData", "isRecomFd", "recomForward", "tagInfos", "syncStatus", "busiReport", "dittoFeed", "feedType", "busiTranparent", "orgFeedDeleted", "recomInfo", "opMask", "reportInfoForClient", "opMask2" }, new Object[] { "", "", "", null, null, null, "", Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), null, localByteStringMicro1, localByteStringMicro2, Boolean.valueOf(false), null, null, Integer.valueOf(0), localByteStringMicro3, null, Integer.valueOf(0), null, Boolean.valueOf(false), null, Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0) }, StFeed.class);
    }
  }
  
  public static final class StFeedAbstract
    extends MessageMicro<StFeedAbstract>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 58 }, new String[] { "id", "title", "poster", "pic", "type", "createTime", "video" }, new Object[] { "", "", null, null, Integer.valueOf(0), Long.valueOf(0L), null }, StFeedAbstract.class);
    public final PBUInt64Field createTime = PBField.initUInt64(0L);
    public final PBStringField id = PBField.initString("");
    public FeedCloudMeta.StImage pic = new FeedCloudMeta.StImage();
    public FeedCloudMeta.StUser poster = new FeedCloudMeta.StUser();
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public FeedCloudMeta.StVideo video = new FeedCloudMeta.StVideo();
  }
  
  public static final class StGPSV2
    extends MessageMicro<StGPSV2>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "lat", "lon", "eType", "alt" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, StGPSV2.class);
    public final PBInt64Field alt = PBField.initInt64(0L);
    public final PBInt64Field eType = PBField.initInt64(0L);
    public final PBInt64Field lat = PBField.initInt64(0L);
    public final PBInt64Field lon = PBField.initInt64(0L);
  }
  
  public static final class StIconInfo
    extends MessageMicro<StIconInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "iconUrl40", "iconUrl100", "iconUrl140", "iconUrl640", "iconUrl" }, new Object[] { "", "", "", "", "" }, StIconInfo.class);
    public final PBStringField iconUrl = PBField.initString("");
    public final PBStringField iconUrl100 = PBField.initString("");
    public final PBStringField iconUrl140 = PBField.initString("");
    public final PBStringField iconUrl40 = PBField.initString("");
    public final PBStringField iconUrl640 = PBField.initString("");
  }
  
  public static final class StImage
    extends MessageMicro<StImage>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBStringField picId = PBField.initString("");
    public final PBStringField picUrl = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta.StImageUrl> vecImageUrl = PBField.initRepeatMessage(FeedCloudMeta.StImageUrl.class);
    public final PBUInt32Field width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50 }, new String[] { "width", "height", "picUrl", "vecImageUrl", "picId", "busiData" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", null, "", localByteStringMicro }, StImage.class);
    }
  }
  
  public static final class StImageUrl
    extends MessageMicro<StImageUrl>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBUInt32Field levelType = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "levelType", "url", "width", "height", "busiData" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, StImageUrl.class);
    }
  }
  
  public static final class StLightInteractInfo
    extends MessageMicro<StLightInteractInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public FeedCloudMeta.StRelationInfo relation = new FeedCloudMeta.StRelationInfo();
    public FeedCloudMeta.StUser user = new FeedCloudMeta.StUser();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "user", "relation", "count", "busiData" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro }, StLightInteractInfo.class);
    }
  }
  
  public static final class StLike
    extends MessageMicro<StLike>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field hasLikedCount = PBField.initUInt32(0);
    public final PBStringField id = PBField.initString("");
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBUInt32Field ownerStatus = PBField.initUInt32(0);
    public FeedCloudMeta.StUser postUser = new FeedCloudMeta.StUser();
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta.StUser> vecUser = PBField.initRepeatMessage(FeedCloudMeta.StUser.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 56, 64, 74 }, new String[] { "id", "count", "status", "vecUser", "busiData", "postUser", "hasLikedCount", "ownerStatus", "jumpUrl" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0), "" }, StLike.class);
    }
  }
  
  public static final class StNotice
    extends MessageMicro<StNotice>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field createTime = PBField.initUInt64(0L);
    public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
    public final PBStringField feedId = PBField.initString("");
    public final PBStringField message = PBField.initString("");
    public final PBUInt32Field noticeType = PBField.initUInt32(0);
    public FeedCloudMeta.StOperation operation = new FeedCloudMeta.StOperation();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 58 }, new String[] { "feedId", "noticeType", "createTime", "operation", "feed", "busiData", "message" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L), null, null, localByteStringMicro, "" }, StNotice.class);
    }
  }
  
  public static final class StOperation
    extends MessageMicro<StOperation>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudMeta.StComment comment = new FeedCloudMeta.StComment();
    public FeedCloudMeta.StLike like = new FeedCloudMeta.StLike();
    public final PBUInt64Field opTime = PBField.initUInt64(0L);
    public final PBUInt32Field opType = PBField.initUInt32(0);
    public FeedCloudMeta.StUser opUser = new FeedCloudMeta.StUser();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50 }, new String[] { "opType", "opUser", "opTime", "comment", "like", "busiData" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L), null, null, localByteStringMicro }, StOperation.class);
    }
  }
  
  public static final class StPoiInfoV2
    extends MessageMicro<StPoiInfoV2>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48, 58, 64, 72, 82, 90, 98, 106, 112, 120, 130, 138, 146 }, new String[] { "poiId", "name", "poiType", "typeName", "address", "districtCode", "gps", "distance", "hotValue", "phone", "country", "province", "city", "poiNum", "poiOrderType", "defaultName", "district", "dianPingId" }, new Object[] { "", "", Integer.valueOf(0), "", "", Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", "", "" }, StPoiInfoV2.class);
    public final PBStringField address = PBField.initString("");
    public final PBStringField city = PBField.initString("");
    public final PBStringField country = PBField.initString("");
    public final PBStringField defaultName = PBField.initString("");
    public final PBStringField dianPingId = PBField.initString("");
    public final PBInt32Field distance = PBField.initInt32(0);
    public final PBStringField district = PBField.initString("");
    public final PBInt32Field districtCode = PBField.initInt32(0);
    public FeedCloudMeta.StGPSV2 gps = new FeedCloudMeta.StGPSV2();
    public final PBInt32Field hotValue = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField phone = PBField.initString("");
    public final PBStringField poiId = PBField.initString("");
    public final PBInt32Field poiNum = PBField.initInt32(0);
    public final PBInt32Field poiOrderType = PBField.initInt32(0);
    public final PBInt32Field poiType = PBField.initInt32(0);
    public final PBStringField province = PBField.initString("");
    public final PBStringField typeName = PBField.initString("");
  }
  
  public static final class StPushList
    extends MessageMicro<StPushList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field hasClickCount = PBField.initUInt32(0);
    public final PBStringField id = PBField.initString("");
    public final PBStringField jumpUrl = PBField.initString("");
    public FeedCloudMeta.StUser postUser = new FeedCloudMeta.StUser();
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBUInt32Field totalClickCount = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta.StUser> vecUser = PBField.initRepeatMessage(FeedCloudMeta.StUser.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 56, 64, 74 }, new String[] { "id", "count", "status", "vecUser", "busiData", "postUser", "hasClickCount", "totalClickCount", "jumpUrl" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0), "" }, StPushList.class);
    }
  }
  
  public static final class StRecomForward
    extends MessageMicro<StRecomForward>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field createTime = PBField.initUInt64(0L);
    public final PBStringField id = PBField.initString("");
    public FeedCloudMeta.StUser poster = new FeedCloudMeta.StUser();
    public final PBStringField subtitle = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 58 }, new String[] { "id", "title", "subtitle", "poster", "createTime", "type", "busiData" }, new Object[] { "", "", "", null, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, StRecomForward.class);
    }
  }
  
  public static final class StRecomInfo
    extends MessageMicro<StRecomInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "recomReason" }, new Object[] { "" }, StRecomInfo.class);
    public final PBStringField recomReason = PBField.initString("");
  }
  
  public static final class StRelationInfo
    extends MessageMicro<StRelationInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField id = PBField.initString("");
    public final PBUInt32Field relation = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "id", "relation", "busiData" }, new Object[] { "", Integer.valueOf(0), localByteStringMicro }, StRelationInfo.class);
    }
  }
  
  public static final class StReply
    extends MessageMicro<StReply>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField content = PBField.initString("");
    public final PBUInt64Field createTime = PBField.initUInt64(0L);
    public final PBStringField id = PBField.initString("");
    public FeedCloudMeta.StLike likeInfo = new FeedCloudMeta.StLike();
    public FeedCloudMeta.StUser postUser = new FeedCloudMeta.StUser();
    public FeedCloudMeta.StUser targetUser = new FeedCloudMeta.StUser();
    public final PBUInt32Field typeFlag = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 58, 64 }, new String[] { "id", "postUser", "createTime", "content", "targetUser", "busiData", "likeInfo", "typeFlag" }, new Object[] { "", null, Long.valueOf(0L), "", null, localByteStringMicro, null, Integer.valueOf(0) }, StReply.class);
    }
  }
  
  public static final class StReportInfo
    extends MessageMicro<StReportInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiReport = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField id = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "id", "busiReport" }, new Object[] { "", localByteStringMicro }, StReportInfo.class);
    }
  }
  
  public static final class StShare
    extends MessageMicro<StShare>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public FeedCloudMeta.StUser author = new FeedCloudMeta.StUser();
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudMeta.StImage cover = new FeedCloudMeta.StImage();
    public final PBStringField desc = PBField.initString("");
    public FeedCloudMeta.StUser poster = new FeedCloudMeta.StUser();
    public final PBStringField shareCardInfo = PBField.initString("");
    public FeedCloudMeta.StShareQzoneInfo shareQzoneInfo = new FeedCloudMeta.StShareQzoneInfo();
    public final PBStringField shorturl = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public FeedCloudMeta.StVideo video = new FeedCloudMeta.StVideo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 58, 66, 74, 82, 90, 98 }, new String[] { "title", "desc", "type", "url", "author", "poster", "cover", "video", "shorturl", "shareCardInfo", "shareQzoneInfo", "busiData" }, new Object[] { "", "", Integer.valueOf(0), "", null, null, null, null, "", "", null, localByteStringMicro }, StShare.class);
    }
  }
  
  public static final class StShareQzoneInfo
    extends MessageMicro<StShareQzoneInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "entrys" }, new Object[] { null }, StShareQzoneInfo.class);
    public final PBRepeatMessageField<FeedCloudCommon.Entry> entrys = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
  }
  
  public static final class StTagInfo
    extends MessageMicro<StTagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 66, 72, 80, 90, 96, 794 }, new String[] { "tagId", "tagName", "tagDec", "userList", "feedList", "tagTotalUser", "tagTotalFeed", "tagWording", "tagType", "followState", "shareInfo", "isTop", "tagReport" }, new Object[] { "", "", "", null, null, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), "" }, StTagInfo.class);
    public final PBRepeatMessageField<FeedCloudMeta.StFeedAbstract> feedList = PBField.initRepeatMessage(FeedCloudMeta.StFeedAbstract.class);
    public final PBUInt32Field followState = PBField.initUInt32(0);
    public final PBUInt32Field isTop = PBField.initUInt32(0);
    public FeedCloudMeta.StShare shareInfo = new FeedCloudMeta.StShare();
    public final PBStringField tagDec = PBField.initString("");
    public final PBStringField tagId = PBField.initString("");
    public final PBStringField tagName = PBField.initString("");
    public final PBStringField tagReport = PBField.initString("");
    public final PBUInt32Field tagTotalFeed = PBField.initUInt32(0);
    public final PBUInt32Field tagTotalUser = PBField.initUInt32(0);
    public final PBUInt32Field tagType = PBField.initUInt32(0);
    public final PBStringField tagWording = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta.StUser> userList = PBField.initRepeatMessage(FeedCloudMeta.StUser.class);
  }
  
  public static final class StUser
    extends MessageMicro<StUser>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field birthday = PBField.initUInt64(0L);
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field followState = PBField.initUInt32(0);
    public final PBUInt32Field frdState = PBField.initUInt32(0);
    public FeedCloudMeta.StIconInfo icon = new FeedCloudMeta.StIconInfo();
    public final PBStringField id = PBField.initString("");
    public final PBStringField location = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBStringField school = PBField.initString("");
    public final PBUInt32Field sex = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 64, 74, 90, 98, 104 }, new String[] { "id", "nick", "icon", "desc", "followState", "type", "sex", "birthday", "school", "location", "busiData", "frdState" }, new Object[] { "", "", null, "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", "", localByteStringMicro, Integer.valueOf(0) }, StUser.class);
    }
  }
  
  public static final class StUserRecomInfo
    extends MessageMicro<StUserRecomInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "user", "feedList" }, new Object[] { null, null }, StUserRecomInfo.class);
    public final PBRepeatMessageField<FeedCloudMeta.StFeedAbstract> feedList = PBField.initRepeatMessage(FeedCloudMeta.StFeedAbstract.class);
    public FeedCloudMeta.StUser user = new FeedCloudMeta.StUser();
  }
  
  public static final class StVideo
    extends MessageMicro<StVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field approvalStatus = PBField.initUInt32(0);
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field duration = PBField.initUInt32(0);
    public final PBStringField fileId = PBField.initString("");
    public final PBUInt32Field fileSize = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBStringField playUrl = PBField.initString("");
    public final PBUInt32Field transStatus = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta.StVideoUrl> vecVideoUrl = PBField.initRepeatMessage(FeedCloudMeta.StVideoUrl.class);
    public final PBUInt32Field videoPrior = PBField.initUInt32(0);
    public final PBUInt32Field videoRate = PBField.initUInt32(0);
    public final PBUInt32Field videoSource = PBField.initUInt32(0);
    public final PBUInt32Field width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 56, 64, 72, 82, 90, 96, 104 }, new String[] { "fileId", "fileSize", "duration", "width", "height", "playUrl", "transStatus", "videoPrior", "videoRate", "vecVideoUrl", "busiData", "approvalStatus", "videoSource" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, StVideo.class);
    }
  }
  
  public static final class StVideoUrl
    extends MessageMicro<StVideoUrl>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field levelType = PBField.initUInt32(0);
    public final PBStringField playUrl = PBField.initString("");
    public final PBUInt32Field transStatus = PBField.initUInt32(0);
    public final PBUInt32Field videoPrior = PBField.initUInt32(0);
    public final PBUInt32Field videoRate = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50 }, new String[] { "levelType", "playUrl", "videoPrior", "videoRate", "transStatus", "busiData" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, StVideoUrl.class);
    }
  }
  
  public static final class StVisitor
    extends MessageMicro<StVisitor>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field recomCount = PBField.initUInt32(0);
    public final PBUInt32Field viewCount = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "viewCount", "busiData", "recomCount" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, StVisitor.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     feedcloud.FeedCloudMeta
 * JD-Core Version:    0.7.0.1
 */