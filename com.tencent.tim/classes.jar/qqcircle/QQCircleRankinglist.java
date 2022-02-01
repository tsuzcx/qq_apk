package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StRelationInfo;
import feedcloud.FeedCloudMeta.StUser;

public final class QQCircleRankinglist
{
  public static final class ClassifyUserReq
    extends MessageMicro<ClassifyUserReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "listType", "opType", "uids" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "" }, ClassifyUserReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field listType = PBField.initInt32(0);
    public final PBInt32Field opType = PBField.initInt32(0);
    public final PBRepeatField<String> uids = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class ClassifyUserRsp
    extends MessageMicro<ClassifyUserRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, ClassifyUserRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class GetRankingListReq
    extends MessageMicro<GetRankingListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "extInfo", "listType", "count", "listTime", "listClass" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetRankingListReq.class);
    public final PBInt32Field count = PBField.initInt32(0);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field listClass = PBField.initInt32(0);
    public final PBUInt32Field listTime = PBField.initUInt32(0);
    public final PBInt32Field listType = PBField.initInt32(0);
  }
  
  public static final class GetRankingListRsp
    extends MessageMicro<GetRankingListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "items", "startTime", "endTime" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0) }, GetRankingListRsp.class);
    public final PBUInt32Field endTime = PBField.initUInt32(0);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatMessageField<QQCircleRankinglist.RankingItem> items = PBField.initRepeatMessage(QQCircleRankinglist.RankingItem.class);
    public final PBUInt32Field startTime = PBField.initUInt32(0);
  }
  
  public static final class NotifyReq
    extends MessageMicro<NotifyReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40 }, new String[] { "extInfo", "listType", "toUid", "feedid", "cost" }, new Object[] { null, Integer.valueOf(0), "", "", Integer.valueOf(0) }, NotifyReq.class);
    public final PBInt32Field cost = PBField.initInt32(0);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField feedid = PBField.initString("");
    public final PBInt32Field listType = PBField.initInt32(0);
    public final PBStringField toUid = PBField.initString("");
  }
  
  public static final class NotifyRsp
    extends MessageMicro<NotifyRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "score" }, new Object[] { null, Long.valueOf(0L) }, NotifyRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt64Field score = PBField.initInt64(0L);
  }
  
  public static final class RankingItem
    extends MessageMicro<RankingItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "user", "relation", "score" }, new Object[] { null, null, Long.valueOf(0L) }, RankingItem.class);
    public FeedCloudMeta.StRelationInfo relation = new FeedCloudMeta.StRelationInfo();
    public final PBInt64Field score = PBField.initInt64(0L);
    public FeedCloudMeta.StUser user = new FeedCloudMeta.StUser();
  }
  
  public static final class SetUserScoreReq
    extends MessageMicro<SetUserScoreReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40 }, new String[] { "extInfo", "listType", "listTime", "userScores", "listClass" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, SetUserScoreReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field listClass = PBField.initInt32(0);
    public final PBUInt32Field listTime = PBField.initUInt32(0);
    public final PBInt32Field listType = PBField.initInt32(0);
    public final PBRepeatMessageField<QQCircleRankinglist.UserScore> userScores = PBField.initRepeatMessage(QQCircleRankinglist.UserScore.class);
  }
  
  public static final class SetUserScoreRsp
    extends MessageMicro<SetUserScoreRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, SetUserScoreRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class UserScore
    extends MessageMicro<UserScore>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "uid", "score" }, new Object[] { "", Long.valueOf(0L) }, UserScore.class);
    public final PBInt64Field score = PBField.initInt64(0L);
    public final PBStringField uid = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqcircle.QQCircleRankinglist
 * JD-Core Version:    0.7.0.1
 */