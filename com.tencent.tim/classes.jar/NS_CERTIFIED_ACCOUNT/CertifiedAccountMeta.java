package NS_CERTIFIED_ACCOUNT;

import NS_COMM.COMM.Entry;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CertifiedAccountMeta
{
  public static final class FollowBody
    extends MessageMicro<FollowBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "relation" }, new Object[] { null }, FollowBody.class);
    public CertifiedAccountMeta.Relation relation = new CertifiedAccountMeta.Relation();
  }
  
  public static final class Relation
    extends MessageMicro<Relation>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "puin", "uin", "opTime", "op" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, Relation.class);
    public final PBInt32Field op = PBField.initInt32(0);
    public final PBUInt32Field opTime = PBField.initUInt32(0);
    public final PBUInt64Field puin = PBField.initUInt64(0L);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class StAioMsg
    extends MessageMicro<StAioMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "id", "sendUser", "createTime", "msgContent" }, new Object[] { "", null, Long.valueOf(0L), "" }, StAioMsg.class);
    public final PBUInt64Field createTime = PBField.initUInt64(0L);
    public final PBStringField id = PBField.initString("");
    public final PBStringField msgContent = PBField.initString("");
    public CertifiedAccountMeta.StUser sendUser = new CertifiedAccountMeta.StUser();
  }
  
  public static final class StAutoAioReply
    extends MessageMicro<StAutoAioReply>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "autoState", "replyType", "replyText", "replyImage" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", null }, StAutoAioReply.class);
    public final PBUInt32Field autoState = PBField.initUInt32(0);
    public CertifiedAccountMeta.StImage replyImage = new CertifiedAccountMeta.StImage();
    public final PBStringField replyText = PBField.initString("");
    public final PBUInt32Field replyType = PBField.initUInt32(0);
  }
  
  public static final class StComment
    extends MessageMicro<StComment>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 58 }, new String[] { "id", "postUser", "createTime", "content", "vecAtUin", "replyCount", "vecReply" }, new Object[] { "", null, Long.valueOf(0L), "", Long.valueOf(0L), Integer.valueOf(0), null }, StComment.class);
    public final PBStringField content = PBField.initString("");
    public final PBUInt64Field createTime = PBField.initUInt64(0L);
    public final PBStringField id = PBField.initString("");
    public CertifiedAccountMeta.StUser postUser = new CertifiedAccountMeta.StUser();
    public final PBUInt32Field replyCount = PBField.initUInt32(0);
    public final PBRepeatField<Long> vecAtUin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatMessageField<CertifiedAccountMeta.StReply> vecReply = PBField.initRepeatMessage(CertifiedAccountMeta.StReply.class);
  }
  
  public static final class StEntry
    extends MessageMicro<StEntry>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "cover", "title", "updateCount", "type" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0) }, StEntry.class);
    public CertifiedAccountMeta.StImage cover = new CertifiedAccountMeta.StImage();
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field updateCount = PBField.initUInt32(0);
  }
  
  public static final class StFeed
    extends MessageMicro<StFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField adBuffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field commentCount = PBField.initUInt32(0);
    public final PBStringField content = PBField.initString("");
    public CertifiedAccountMeta.StImage cover = new CertifiedAccountMeta.StImage();
    public final PBUInt64Field createTime = PBField.initUInt64(0L);
    public final PBStringField ext = PBField.initString("");
    public final PBUInt64Field feedAttr = PBField.initUInt64(0L);
    public final PBUInt32Field feedLevel = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta.StYouZanGood> goods = PBField.initRepeatMessage(CertifiedAccountMeta.StYouZanGood.class);
    public final PBStringField id = PBField.initString("");
    public final PBRepeatMessageField<CertifiedAccountMeta.StImage> images = PBField.initRepeatMessage(CertifiedAccountMeta.StImage.class);
    public CertifiedAccountMeta.StLike likeInfo = new CertifiedAccountMeta.StLike();
    public CertifiedAccountMeta.StPoiInfoV2 poiInfo = new CertifiedAccountMeta.StPoiInfoV2();
    public CertifiedAccountMeta.StUser poster = new CertifiedAccountMeta.StUser();
    public final PBUInt32Field pushStatus = PBField.initUInt32(0);
    public CertifiedAccountMeta.StShare share = new CertifiedAccountMeta.StShare();
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBStringField subtitle = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta.StComment> vecComment = PBField.initRepeatMessage(CertifiedAccountMeta.StComment.class);
    public CertifiedAccountMeta.StVideo video = new CertifiedAccountMeta.StVideo();
    public CertifiedAccountMeta.StVisitor visitorInfo = new CertifiedAccountMeta.StVisitor();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 72, 82, 88, 98, 106, 114, 122, 128, 136, 146, 152, 162, 170, 176, 186 }, new String[] { "id", "title", "subtitle", "poster", "cover", "video", "content", "type", "createTime", "likeInfo", "commentCount", "vecComment", "share", "visitorInfo", "images", "status", "pushStatus", "poiInfo", "feedLevel", "adBuffer", "goods", "feedAttr", "ext" }, new Object[] { "", "", "", null, null, null, "", Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro, null, Long.valueOf(0L), "" }, StFeed.class);
    }
  }
  
  public static final class StFollowRcmd
    extends MessageMicro<StFollowRcmd>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "user", "feedList", "reason", "fansCount" }, new Object[] { null, null, "", Integer.valueOf(0) }, StFollowRcmd.class);
    public final PBUInt32Field fansCount = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta.StFeed> feedList = PBField.initRepeatMessage(CertifiedAccountMeta.StFeed.class);
    public final PBStringField reason = PBField.initString("");
    public CertifiedAccountMeta.StUser user = new CertifiedAccountMeta.StUser();
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
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42 }, new String[] { "url", "width", "height", "vecImageUrl", "fileId" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), null, "" }, StImage.class);
    public final PBStringField fileId = PBField.initString("");
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBRepeatMessageField<CertifiedAccountMeta.StImageUrl> vecImageUrl = PBField.initRepeatMessage(CertifiedAccountMeta.StImageUrl.class);
    public final PBUInt32Field width = PBField.initUInt32(0);
  }
  
  public static final class StImageUrl
    extends MessageMicro<StImageUrl>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "levelType", "url", "width", "height" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, StImageUrl.class);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBUInt32Field levelType = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field width = PBField.initUInt32(0);
  }
  
  public static final class StLike
    extends MessageMicro<StLike>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "id", "count", "status", "vecUser" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), null }, StLike.class);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBStringField id = PBField.initString("");
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta.StUser> vecUser = PBField.initRepeatMessage(CertifiedAccountMeta.StUser.class);
  }
  
  public static final class StMessageStatus
    extends MessageMicro<StMessageStatus>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "readStatus", "jumpURL", "noticeCount" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, StMessageStatus.class);
    public final PBStringField jumpURL = PBField.initString("");
    public final PBUInt32Field noticeCount = PBField.initUInt32(0);
    public final PBUInt32Field readStatus = PBField.initUInt32(0);
  }
  
  public static final class StNotice
    extends MessageMicro<StNotice>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42 }, new String[] { "feedId", "noticeType", "createTime", "operation", "feed" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L), null, null }, StNotice.class);
    public final PBUInt64Field createTime = PBField.initUInt64(0L);
    public CertifiedAccountMeta.StFeed feed = new CertifiedAccountMeta.StFeed();
    public final PBStringField feedId = PBField.initString("");
    public final PBUInt32Field noticeType = PBField.initUInt32(0);
    public CertifiedAccountMeta.StOperation operation = new CertifiedAccountMeta.StOperation();
  }
  
  public static final class StOperation
    extends MessageMicro<StOperation>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "opType", "opUser", "opTime", "comment" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L), null }, StOperation.class);
    public CertifiedAccountMeta.StComment comment = new CertifiedAccountMeta.StComment();
    public final PBUInt64Field opTime = PBField.initUInt64(0L);
    public final PBUInt32Field opType = PBField.initUInt32(0);
    public CertifiedAccountMeta.StUser opUser = new CertifiedAccountMeta.StUser();
  }
  
  public static final class StPersonInfo
    extends MessageMicro<StPersonInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "sex", "birthday", "constellation", "school", "location" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "", "", "" }, StPersonInfo.class);
    public final PBUInt64Field birthday = PBField.initUInt64(0L);
    public final PBStringField constellation = PBField.initString("");
    public final PBStringField location = PBField.initString("");
    public final PBStringField school = PBField.initString("");
    public final PBUInt32Field sex = PBField.initUInt32(0);
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
    public CertifiedAccountMeta.StGPSV2 gps = new CertifiedAccountMeta.StGPSV2();
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
  
  public static final class StPushFeed
    extends MessageMicro<StPushFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48 }, new String[] { "feedId", "cover", "userId", "title", "type", "feedCreateTime" }, new Object[] { "", null, "", "", Integer.valueOf(0), Integer.valueOf(0) }, StPushFeed.class);
    public CertifiedAccountMeta.StImage cover = new CertifiedAccountMeta.StImage();
    public final PBUInt32Field feedCreateTime = PBField.initUInt32(0);
    public final PBStringField feedId = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField userId = PBField.initString("");
  }
  
  public static final class StPushSet
    extends MessageMicro<StPushSet>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "createTime", "sendTime", "pFeeds", "pushSetID" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, "" }, StPushSet.class);
    public final PBUInt32Field createTime = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta.StPushFeed> pFeeds = PBField.initRepeatMessage(CertifiedAccountMeta.StPushFeed.class);
    public final PBStringField pushSetID = PBField.initString("");
    public final PBUInt32Field sendTime = PBField.initUInt32(0);
  }
  
  public static final class StQQGroup
    extends MessageMicro<StQQGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 66, 72, 80, 90, 96 }, new String[] { "id", "owner", "createTime", "memberMaxNum", "memberNum", "icon", "name", "desc", "joinState", "joinTime", "auth", "safeState" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, StQQGroup.class);
    public final PBStringField auth = PBField.initString("");
    public final PBUInt32Field createTime = PBField.initUInt32(0);
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field icon = PBField.initUInt32(0);
    public final PBUInt64Field id = PBField.initUInt64(0L);
    public final PBUInt32Field joinState = PBField.initUInt32(0);
    public final PBUInt32Field joinTime = PBField.initUInt32(0);
    public final PBUInt32Field memberMaxNum = PBField.initUInt32(0);
    public final PBUInt32Field memberNum = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBUInt64Field owner = PBField.initUInt64(0L);
    public final PBUInt32Field safeState = PBField.initUInt32(0);
  }
  
  public static final class StReply
    extends MessageMicro<StReply>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48 }, new String[] { "id", "postUser", "createTime", "content", "targetUser", "vecAtUin" }, new Object[] { "", null, Long.valueOf(0L), "", null, Long.valueOf(0L) }, StReply.class);
    public final PBStringField content = PBField.initString("");
    public final PBUInt64Field createTime = PBField.initUInt64(0L);
    public final PBStringField id = PBField.initString("");
    public CertifiedAccountMeta.StUser postUser = new CertifiedAccountMeta.StUser();
    public CertifiedAccountMeta.StUser targetUser = new CertifiedAccountMeta.StUser();
    public final PBRepeatField<Long> vecAtUin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class StShare
    extends MessageMicro<StShare>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 58, 66, 74, 82, 90 }, new String[] { "title", "desc", "type", "url", "author", "poster", "cover", "video", "shorturl", "shareCardInfo", "shareQzoneInfo" }, new Object[] { "", "", Integer.valueOf(0), "", null, null, null, null, "", "", null }, StShare.class);
    public CertifiedAccountMeta.StUser author = new CertifiedAccountMeta.StUser();
    public CertifiedAccountMeta.StImage cover = new CertifiedAccountMeta.StImage();
    public final PBStringField desc = PBField.initString("");
    public CertifiedAccountMeta.StUser poster = new CertifiedAccountMeta.StUser();
    public final PBStringField shareCardInfo = PBField.initString("");
    public CertifiedAccountMeta.StShareQzoneInfo shareQzoneInfo = new CertifiedAccountMeta.StShareQzoneInfo();
    public final PBStringField shorturl = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public CertifiedAccountMeta.StVideo video = new CertifiedAccountMeta.StVideo();
  }
  
  public static final class StShareQzoneInfo
    extends MessageMicro<StShareQzoneInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "entrys" }, new Object[] { null }, StShareQzoneInfo.class);
    public final PBRepeatMessageField<COMM.Entry> entrys = PBField.initRepeatMessage(COMM.Entry.class);
  }
  
  public static final class StUser
    extends MessageMicro<StUser>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 58, 66, 72, 82, 90, 98, 106, 114 }, new String[] { "id", "nick", "icon", "desc", "followState", "type", "email", "telNum", "attr", "youZhan", "yzOrderPage", "registerCertifiedAccountUrl", "personInfo", "iconInfo" }, new Object[] { "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", "", Long.valueOf(0L), null, "", "", null, null }, StUser.class);
    public final PBUInt64Field attr = PBField.initUInt64(0L);
    public final PBStringField desc = PBField.initString("");
    public final PBStringField email = PBField.initString("");
    public final PBUInt32Field followState = PBField.initUInt32(0);
    public final PBStringField icon = PBField.initString("");
    public CertifiedAccountMeta.StIconInfo iconInfo = new CertifiedAccountMeta.StIconInfo();
    public final PBStringField id = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public CertifiedAccountMeta.StPersonInfo personInfo = new CertifiedAccountMeta.StPersonInfo();
    public final PBStringField registerCertifiedAccountUrl = PBField.initString("");
    public final PBStringField telNum = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta.StYouZanShop> youZhan = PBField.initRepeatMessage(CertifiedAccountMeta.StYouZanShop.class);
    public final PBStringField yzOrderPage = PBField.initString("");
  }
  
  public static final class StVideo
    extends MessageMicro<StVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 56, 64, 72, 82 }, new String[] { "fileId", "fileSize", "duration", "width", "height", "playUrl", "transStatus", "videoPrior", "videoRate", "vecVideoUrl" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, StVideo.class);
    public final PBUInt32Field duration = PBField.initUInt32(0);
    public final PBStringField fileId = PBField.initString("");
    public final PBUInt32Field fileSize = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBStringField playUrl = PBField.initString("");
    public final PBUInt32Field transStatus = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta.StVideoUrl> vecVideoUrl = PBField.initRepeatMessage(CertifiedAccountMeta.StVideoUrl.class);
    public final PBUInt32Field videoPrior = PBField.initUInt32(0);
    public final PBUInt32Field videoRate = PBField.initUInt32(0);
    public final PBUInt32Field width = PBField.initUInt32(0);
  }
  
  public static final class StVideoUrl
    extends MessageMicro<StVideoUrl>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "levelType", "playUrl", "videoPrior", "videoRate", "transStatus" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StVideoUrl.class);
    public final PBUInt32Field levelType = PBField.initUInt32(0);
    public final PBStringField playUrl = PBField.initString("");
    public final PBUInt32Field transStatus = PBField.initUInt32(0);
    public final PBUInt32Field videoPrior = PBField.initUInt32(0);
    public final PBUInt32Field videoRate = PBField.initUInt32(0);
  }
  
  public static final class StVisitor
    extends MessageMicro<StVisitor>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "view_count" }, new Object[] { Integer.valueOf(0) }, StVisitor.class);
    public final PBUInt32Field view_count = PBField.initUInt32(0);
  }
  
  public static final class StYouZanGood
    extends MessageMicro<StYouZanGood>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 50 }, new String[] { "title", "img", "price", "url", "itemID", "alias" }, new Object[] { "", "", Long.valueOf(0L), "", Long.valueOf(0L), "" }, StYouZanGood.class);
    public final PBStringField alias = PBField.initString("");
    public final PBStringField img = PBField.initString("");
    public final PBInt64Field itemID = PBField.initInt64(0L);
    public final PBUInt64Field price = PBField.initUInt64(0L);
    public final PBStringField title = PBField.initString("");
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class StYouZanShop
    extends MessageMicro<StYouZanShop>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50 }, new String[] { "type", "id", "name", "schema", "goodNum", "goods" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), null }, StYouZanShop.class);
    public final PBUInt32Field goodNum = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta.StYouZanGood> goods = PBField.initRepeatMessage(CertifiedAccountMeta.StYouZanGood.class);
    public final PBStringField id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField schema = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta
 * JD-Core Version:    0.7.0.1
 */