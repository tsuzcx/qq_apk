package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StTagInfo;

public final class QQCircleFeedBase
{
  public static final class LightInteractionBusiData
    extends MessageMicro<LightInteractionBusiData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "polyInfo" }, new Object[] { null }, LightInteractionBusiData.class);
    public QQCircleFeedBase.StPolyLike polyInfo = new QQCircleFeedBase.StPolyLike();
  }
  
  public static final class StBusiInfoCommentListData
    extends MessageMicro<StBusiInfoCommentListData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "comment", "reply" }, new Object[] { null, null }, StBusiInfoCommentListData.class);
    public FeedCloudMeta.StComment comment = new FeedCloudMeta.StComment();
    public FeedCloudMeta.StReply reply = new FeedCloudMeta.StReply();
  }
  
  public static final class StBusiInfoData
    extends MessageMicro<StBusiInfoData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "tabInfos", "busiMap", "allPolyInfo", "schoolInfos", "companyInfos" }, new Object[] { null, null, null, null, null }, StBusiInfoData.class);
    public final PBRepeatMessageField<QQCircleFeedBase.StPolyLike> allPolyInfo = PBField.initRepeatMessage(QQCircleFeedBase.StPolyLike.class);
    public final PBRepeatMessageField<FeedCloudCommon.Entry> busiMap = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
    public final PBRepeatMessageField<QQCircleBase.UserCircleInfo> companyInfos = PBField.initRepeatMessage(QQCircleBase.UserCircleInfo.class);
    public final PBRepeatMessageField<QQCircleBase.UserCircleInfo> schoolInfos = PBField.initRepeatMessage(QQCircleBase.UserCircleInfo.class);
    public final PBRepeatMessageField<QQCircleFeedBase.StTabInfo> tabInfos = PBField.initRepeatMessage(QQCircleFeedBase.StTabInfo.class);
  }
  
  public static final class StBusiInfoReqData
    extends MessageMicro<StBusiInfoReqData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "gpsInfo", "busiMap" }, new Object[] { null, null }, StBusiInfoReqData.class);
    public final PBRepeatMessageField<FeedCloudCommon.Entry> busiMap = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
    public FeedCloudMeta.StGPSV2 gpsInfo = new FeedCloudMeta.StGPSV2();
  }
  
  public static final class StBusiReportInfo
    extends MessageMicro<StBusiReportInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public QQCircleFeedBase.StRecomReportInfo recom_report = new QQCircleFeedBase.StRecomReportInfo();
    public final PBBytesField tianji_report = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "tianji_report", "recom_report" }, new Object[] { localByteStringMicro, null }, StBusiReportInfo.class);
    }
  }
  
  public static final class StCampanyPageData
    extends MessageMicro<StCampanyPageData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "campanyName" }, new Object[] { "" }, StCampanyPageData.class);
    public final PBStringField campanyName = PBField.initString("");
  }
  
  public static final class StCityPageData
    extends MessageMicro<StCityPageData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "cityName" }, new Object[] { "" }, StCityPageData.class);
    public final PBStringField cityName = PBField.initString("");
  }
  
  public static final class StDoLikeReqDoPolyLikeBusiReqData
    extends MessageMicro<StDoLikeReqDoPolyLikeBusiReqData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "polyLikeInfo", "curPolyLikeInfo" }, new Object[] { null, null }, StDoLikeReqDoPolyLikeBusiReqData.class);
    public QQCircleFeedBase.StPolyLike curPolyLikeInfo = new QQCircleFeedBase.StPolyLike();
    public QQCircleFeedBase.StPolyLike polyLikeInfo = new QQCircleFeedBase.StPolyLike();
  }
  
  public static final class StExplorePageData
    extends MessageMicro<StExplorePageData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "recomTagList" }, new Object[] { null }, StExplorePageData.class);
    public final PBRepeatMessageField<FeedCloudMeta.StTagInfo> recomTagList = PBField.initRepeatMessage(FeedCloudMeta.StTagInfo.class);
  }
  
  public static final class StFeedBusiReqData
    extends MessageMicro<StFeedBusiReqData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "allPushList", "pushList" }, new Object[] { null, null }, StFeedBusiReqData.class);
    public FeedCloudMeta.StLike allPushList = new FeedCloudMeta.StLike();
    public FeedCloudMeta.StPushList pushList = new FeedCloudMeta.StPushList();
  }
  
  public static final class StFeedListBusiReqData
    extends MessageMicro<StFeedListBusiReqData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48 }, new String[] { "tabAttachInfo", "gpsInfo", "isReqLayer", "tagId", "tagName", "noRecom" }, new Object[] { "", null, Boolean.valueOf(false), "", "", Boolean.valueOf(false) }, StFeedListBusiReqData.class);
    public FeedCloudMeta.StGPSV2 gpsInfo = new FeedCloudMeta.StGPSV2();
    public final PBBoolField isReqLayer = PBField.initBool(false);
    public final PBBoolField noRecom = PBField.initBool(false);
    public final PBStringField tabAttachInfo = PBField.initString("");
    public final PBStringField tagId = PBField.initString("");
    public final PBStringField tagName = PBField.initString("");
  }
  
  public static final class StFeedListBusiRspData
    extends MessageMicro<StFeedListBusiRspData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 64 }, new String[] { "exploredPageData", "schoolPageData", "campanyPageData", "cityPageData", "tagPageData", "followPageData", "opMask" }, new Object[] { null, null, null, null, null, null, Integer.valueOf(0) }, StFeedListBusiRspData.class);
    public QQCircleFeedBase.StCampanyPageData campanyPageData = new QQCircleFeedBase.StCampanyPageData();
    public QQCircleFeedBase.StCityPageData cityPageData = new QQCircleFeedBase.StCityPageData();
    public QQCircleFeedBase.StExplorePageData exploredPageData = new QQCircleFeedBase.StExplorePageData();
    public QQCircleFeedBase.StFollowPageData followPageData = new QQCircleFeedBase.StFollowPageData();
    public final PBRepeatField<Integer> opMask = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public QQCircleFeedBase.StSchoolPageData schoolPageData = new QQCircleFeedBase.StSchoolPageData();
    public QQCircleFeedBase.StTagPageData tagPageData = new QQCircleFeedBase.StTagPageData();
  }
  
  public static final class StFollowPageData
    extends MessageMicro<StFollowPageData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "recomCircileCertification", "tipsTitle", "dittoFeed" }, new Object[] { null, "", null }, StFollowPageData.class);
    public FeedCloudMeta.StDittoFeed dittoFeed = new FeedCloudMeta.StDittoFeed();
    public QQCircleBase.UserCircleInfo recomCircileCertification = new QQCircleBase.UserCircleInfo();
    public final PBStringField tipsTitle = PBField.initString("");
  }
  
  public static final class StLikeBusiData
    extends MessageMicro<StLikeBusiData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "polyLikeInfo", "curPolyLikeInfo" }, new Object[] { null, null }, StLikeBusiData.class);
    public QQCircleFeedBase.StPolyLike curPolyLikeInfo = new QQCircleFeedBase.StPolyLike();
    public final PBRepeatMessageField<QQCircleFeedBase.StPolyLike> polyLikeInfo = PBField.initRepeatMessage(QQCircleFeedBase.StPolyLike.class);
  }
  
  public static final class StMainPageBusiRspData
    extends MessageMicro<StMainPageBusiRspData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "urlInfo", "opMask", "recomTagList" }, new Object[] { null, Integer.valueOf(0), null }, StMainPageBusiRspData.class);
    public final PBRepeatField<Integer> opMask = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatMessageField<FeedCloudMeta.StTagInfo> recomTagList = PBField.initRepeatMessage(FeedCloudMeta.StTagInfo.class);
    public final PBRepeatMessageField<FeedCloudCommon.Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
  }
  
  public static final class StNoticeBusiData
    extends MessageMicro<StNoticeBusiData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "urlInfo", "busiInfo" }, new Object[] { null, null }, StNoticeBusiData.class);
    public final PBRepeatMessageField<FeedCloudCommon.Entry> busiInfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
    public final PBRepeatMessageField<FeedCloudCommon.Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
  }
  
  public static final class StPolyLike
    extends MessageMicro<StPolyLike>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50 }, new String[] { "polyLikeID", "polyName", "polySource", "polyIconUrl", "count", "polyUnderPicUrl" }, new Object[] { "", "", "", "", Integer.valueOf(0), "" }, StPolyLike.class);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBStringField polyIconUrl = PBField.initString("");
    public final PBStringField polyLikeID = PBField.initString("");
    public final PBStringField polyName = PBField.initString("");
    public final PBStringField polySource = PBField.initString("");
    public final PBStringField polyUnderPicUrl = PBField.initString("");
  }
  
  public static final class StRecomReportInfo
    extends MessageMicro<StRecomReportInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "recomInfos" }, new Object[] { null }, StRecomReportInfo.class);
    public final PBRepeatMessageField<QQCircleFeedBase.StSingleRecomReportInfo> recomInfos = PBField.initRepeatMessage(QQCircleFeedBase.StSingleRecomReportInfo.class);
  }
  
  public static final class StReportInfoForClient
    extends MessageMicro<StReportInfoForClient>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "feedtype1", "feedtype2", "feedtype3" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StReportInfoForClient.class);
    public final PBUInt32Field feedtype1 = PBField.initUInt32(0);
    public final PBUInt32Field feedtype2 = PBField.initUInt32(0);
    public final PBUInt32Field feedtype3 = PBField.initUInt32(0);
  }
  
  public static final class StSchoolPageData
    extends MessageMicro<StSchoolPageData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "schoolName" }, new Object[] { "" }, StSchoolPageData.class);
    public final PBStringField schoolName = PBField.initString("");
  }
  
  public static final class StSessonID
    extends MessageMicro<StSessonID>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "sessonID" }, new Object[] { "" }, StSessonID.class);
    public final PBStringField sessonID = PBField.initString("");
  }
  
  public static final class StSingleRecomReportInfo
    extends MessageMicro<StSingleRecomReportInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField reportData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField reportID = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "reportID", "reportData" }, new Object[] { "", localByteStringMicro }, StSingleRecomReportInfo.class);
    }
  }
  
  public static final class StSubSessonID
    extends MessageMicro<StSubSessonID>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "subSessonID" }, new Object[] { "" }, StSubSessonID.class);
    public final PBStringField subSessonID = PBField.initString("");
  }
  
  public static final class StTabInfo
    extends MessageMicro<StTabInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 50 }, new String[] { "tabName", "tabType", "tagId", "status", "attachInfo", "urlInfo" }, new Object[] { "", Integer.valueOf(0), "", Integer.valueOf(0), "", null }, StTabInfo.class);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBStringField tabName = PBField.initString("");
    public final PBUInt32Field tabType = PBField.initUInt32(0);
    public final PBStringField tagId = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudCommon.Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
  }
  
  public static final class StTagPageData
    extends MessageMicro<StTagPageData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tagInfo" }, new Object[] { null }, StTagPageData.class);
    public FeedCloudMeta.StTagInfo tagInfo = new FeedCloudMeta.StTagInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase
 * JD-Core Version:    0.7.0.1
 */