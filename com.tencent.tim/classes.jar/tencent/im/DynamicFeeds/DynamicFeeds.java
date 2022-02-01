package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DynamicFeeds
{
  public static final class FeedsItem_History
    extends MessageMicro<FeedsItem_History>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "ulFeedID", "uiUpdateTimestamp", "bDislike" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Boolean.valueOf(false) }, FeedsItem_History.class);
    public final PBBoolField bDislike = PBField.initBool(false);
    public final PBUInt32Field uiUpdateTimestamp = PBField.initUInt32(0);
    public final PBUInt64Field ulFeedID = PBField.initUInt64(0L);
  }
  
  public static final class FeedsItem_Req
    extends MessageMicro<FeedsItem_Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uiResID", "uiOpenFlag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, FeedsItem_Req.class);
    public final PBUInt32Field uiOpenFlag = PBField.initUInt32(0);
    public final PBUInt32Field uiResID = PBField.initUInt32(0);
  }
  
  public static final class FeedsItem_Resp
    extends MessageMicro<FeedsItem_Resp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48 }, new String[] { "ulFeedID", "strTemplatData", "uiUpdateTime", "strFeedCookie", "uiResID", "exp_temlate_id" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, FeedsItem_Resp.class);
    public final PBUInt32Field exp_temlate_id = PBField.initUInt32(0);
    public final PBStringField strFeedCookie = PBField.initString("");
    public final PBStringField strTemplatData = PBField.initString("");
    public final PBUInt32Field uiResID = PBField.initUInt32(0);
    public final PBUInt32Field uiUpdateTime = PBField.initUInt32(0);
    public final PBUInt64Field ulFeedID = PBField.initUInt64(0L);
  }
  
  public static final class SubCmd_Feeds_ReqInfo
    extends MessageMicro<SubCmd_Feeds_ReqInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 50 }, new String[] { "uiReqEvent", "ReqResIDs", "uiLoadDayTimestamp", "HistoryFeedIDs", "ulFinishDayBitmap", "strReqCookie" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), null, Long.valueOf(0L), "" }, SubCmd_Feeds_ReqInfo.class);
    public final PBRepeatMessageField<DynamicFeeds.FeedsItem_History> HistoryFeedIDs = PBField.initRepeatMessage(DynamicFeeds.FeedsItem_History.class);
    public final PBRepeatMessageField<DynamicFeeds.FeedsItem_Req> ReqResIDs = PBField.initRepeatMessage(DynamicFeeds.FeedsItem_Req.class);
    public final PBStringField strReqCookie = PBField.initString("");
    public final PBUInt32Field uiLoadDayTimestamp = PBField.initUInt32(0);
    public final PBUInt32Field uiReqEvent = PBField.initUInt32(0);
    public final PBUInt64Field ulFinishDayBitmap = PBField.initUInt64(0L);
  }
  
  public static final class SubCmd_Feeds_RespInfo
    extends MessageMicro<SubCmd_Feeds_RespInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48, 58, 64 }, new String[] { "uiRetCode", "strError", "RespFeeds", "uiNextDayTimestamp", "strTodayTitle", "ulDelFeeds", "strReqCookie", "retFromRecsys" }, new Object[] { Integer.valueOf(0), "", null, Integer.valueOf(0), "", Long.valueOf(0L), "", Integer.valueOf(0) }, SubCmd_Feeds_RespInfo.class);
    public final PBRepeatMessageField<DynamicFeeds.FeedsItem_Resp> RespFeeds = PBField.initRepeatMessage(DynamicFeeds.FeedsItem_Resp.class);
    public final PBUInt32Field retFromRecsys = PBField.initUInt32(0);
    public final PBStringField strError = PBField.initString("");
    public final PBStringField strReqCookie = PBField.initString("");
    public final PBStringField strTodayTitle = PBField.initString("");
    public final PBUInt32Field uiNextDayTimestamp = PBField.initUInt32(0);
    public final PBUInt32Field uiRetCode = PBField.initUInt32(0);
    public final PBRepeatField<Long> ulDelFeeds = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.DynamicFeeds.DynamicFeeds
 * JD-Core Version:    0.7.0.1
 */