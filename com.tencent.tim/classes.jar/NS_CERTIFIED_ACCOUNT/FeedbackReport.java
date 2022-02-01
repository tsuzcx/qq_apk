package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedbackReport
{
  public static final class BidInfo
    extends MessageMicro<BidInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bid", "bsign" }, new Object[] { "", "" }, BidInfo.class);
    public final PBStringField bid = PBField.initString("");
    public final PBStringField bsign = PBField.initString("");
  }
  
  public static final class ContentFeedbackItem
    extends MessageMicro<ContentFeedbackItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 56, 64, 72, 82 }, new String[] { "cmsid", "content_type", "feedback_type", "reasonid", "agent_tip_words", "details", "feedback_time", "is_aggregated", "times_aggregated", "vid" }, new Object[] { "", Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, ContentFeedbackItem.class);
    public final PBStringField agent_tip_words = PBField.initString("");
    public final PBStringField cmsid = PBField.initString("");
    public final PBEnumField content_type = PBField.initEnum(1);
    public final PBStringField details = PBField.initString("");
    public final PBInt32Field feedback_time = PBField.initInt32(0);
    public final PBEnumField feedback_type = PBField.initEnum(1);
    public final PBInt32Field is_aggregated = PBField.initInt32(0);
    public final PBEnumField reasonid = PBField.initEnum(1);
    public final PBInt32Field times_aggregated = PBField.initInt32(0);
    public final PBStringField vid = PBField.initString("");
  }
  
  public static final class FeedbackRequest
    extends MessageMicro<FeedbackRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bid_info", "user_info", "content_items" }, new Object[] { null, null, null }, FeedbackRequest.class);
    public FeedbackReport.BidInfo bid_info = new FeedbackReport.BidInfo();
    public final PBRepeatMessageField<FeedbackReport.ContentFeedbackItem> content_items = PBField.initRepeatMessage(FeedbackReport.ContentFeedbackItem.class);
    public FeedbackReport.UserInfo user_info = new FeedbackReport.UserInfo();
  }
  
  public static final class FeedbackResponse
    extends MessageMicro<FeedbackResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "code", "msg" }, new Object[] { Integer.valueOf(0), "" }, FeedbackResponse.class);
    public final PBInt32Field code = PBField.initInt32(0);
    public final PBStringField msg = PBField.initString("");
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "uid", "qq", "openid", "imei", "idfa", "idfv" }, new Object[] { "", "", "", "", "", "" }, UserInfo.class);
    public final PBStringField idfa = PBField.initString("");
    public final PBStringField idfv = PBField.initString("");
    public final PBStringField imei = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField qq = PBField.initString("");
    public final PBStringField uid = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.FeedbackReport
 * JD-Core Version:    0.7.0.1
 */