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
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRelation
{
  public static final class BatchVerifyRelationReq
    extends MessageMicro<BatchVerifyRelationReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uins" }, new Object[] { Long.valueOf(0L) }, BatchVerifyRelationReq.class);
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class BatchVerifyRelationRsp
    extends MessageMicro<BatchVerifyRelationRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "infos" }, new Object[] { null }, BatchVerifyRelationRsp.class);
    public final PBRepeatMessageField<QQCircleRelation.RelationInfo> infos = PBField.initRepeatMessage(QQCircleRelation.RelationInfo.class);
  }
  
  public static final class GetFansFollowNumReq
    extends MessageMicro<GetFansFollowNumReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uin" }, new Object[] { Long.valueOf(0L) }, GetFansFollowNumReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class GetFansFollowNumRsp
    extends MessageMicro<GetFansFollowNumRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "fansNum", "followNum" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, GetFansFollowNumRsp.class);
    public final PBInt64Field fansNum = PBField.initInt64(0L);
    public final PBInt64Field followNum = PBField.initInt64(0L);
  }
  
  public static final class NotifyFreshUserReq
    extends MessageMicro<NotifyFreshUserReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, NotifyFreshUserReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class NotifyFreshUserRsp
    extends MessageMicro<NotifyFreshUserRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, NotifyFreshUserRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  }
  
  public static final class RelationBiz
    extends MessageMicro<RelationBiz>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "timestamp", "nick", "sign", "qqRelation" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0) }, RelationBiz.class);
    public final PBStringField nick = PBField.initString("");
    public final PBInt32Field qqRelation = PBField.initInt32(0);
    public final PBStringField sign = PBField.initString("");
    public final PBUInt64Field timestamp = PBField.initUInt64(0L);
  }
  
  public static final class RelationInfo
    extends MessageMicro<RelationInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "relation" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, RelationInfo.class);
    public final PBUInt32Field relation = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqcircle.QQCircleRelation
 * JD-Core Version:    0.7.0.1
 */